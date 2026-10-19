//! Session lifecycle, command dispatch and USB transport for the flash tool.
//!
//! Two constraints shape this file:
//!
//! * The engine's device object is not `Send` (it keeps an `Rc` device-info cell), but a JNI
//!   entry point can be called from any thread. All session state therefore lives behind one
//!   mutex and is only ever touched by one thread at a time; `SendSession` asserts that.
//! * The engine borrows the DA/preloader/auth payloads for the session's lifetime, which the
//!   Java side supplies as file paths. Those payloads are leaked on purpose: a session holds at
//!   most a few megabytes, and a fresh connect replaces the whole object.
//!
//! Command results are strings: `OK\n<payload>` on success, an error message otherwise.

use std::fmt::Display;
use std::fs;
use std::os::fd::RawFd;
use std::path::Path;
use std::sync::atomic::{AtomicBool, AtomicI32, Ordering};
use std::sync::Mutex;
use std::time::Duration;

use jni::JNIEnv;
use jni::objects::{JClass, JObject, JString};
use jni::sys::{JNIEnv as RawJniEnv, JNI_VERSION_1_6, JavaVM, jboolean, jint, jlong, jstring};

use penumbra_mtk::device::{Device, DeviceBuilder};
use penumbra_mtk::hacc::{BootControl, BootPartition, LockState, OFFSET_SLOT_SUFFIX, TryRead, TryWrite};
use penumbra_mtk::port::ConnectionType;
use penumbra_mtk::{BootMode, Error, MtkPort, Partition};
use usbfs::{EP_IN_DEFAULT, EP_OUT_DEFAULT, Endpoints, UsbfsPort};

const SESSION_TIMEOUT: Duration = Duration::from_millis(5000);

struct Session {
    dev: Device<'static, UsbfsPort>,
    /// Descriptor and payload paths this session was built from. Each command carries its own copy,
    /// so a mismatch means the app switched device or DA and the old session must be dropped.
    key: (RawFd, String, String, String),
}

/// SAFETY: the only reachable path to a session is [`SESSION`], and every entry point holding
/// it does so under that mutex, so no two threads ever touch the same non-atomic internals.
struct SendSession(Session);
unsafe impl Send for SendSession {}

static SESSION: Mutex<Option<SendSession>> = Mutex::new(None);
static USB_FD: AtomicI32 = AtomicI32::new(-1);
static CANCEL: AtomicBool = AtomicBool::new(false);
static XIAOMI_GENERATION: AtomicI32 = AtomicI32::new(0);

fn describe<E: Display>(err: E) -> String {
    format!("ERR:{err}")
}

fn load_payload(path: &str) -> Result<Option<&'static [u8]>, String> {
    if path.trim().is_empty() {
        return Ok(None);
    }
    let bytes = fs::read(path).map_err(|e| format!("cannot read {path}: {e}"))?;
    Ok(Some(Box::leak(bytes.into_boxed_slice())))
}

fn hex_bytes(bytes: &[u8]) -> String {
    let mut out = String::with_capacity(bytes.len() * 2);
    for byte in bytes {
        out.push_str(&format!("{byte:02x}"));
    }
    out
}

fn yes_no(value: bool) -> &'static str {
    if value { "yes" } else { "no" }
}

/// Device info block. The app reads these lines with `key(payload, "CHIP:")`, which matches a
/// line prefix and returns the remainder, so the labels here are part of the ABI.
fn device_info_payload(dev: &mut Device<'static, UsbfsPort>) -> String {
    let sbc = dev.devinfo().sbc_enabled();
    let sla = dev.devinfo().sla_enabled();
    let daa = dev.devinfo().daa_enabled();
    let data = dev.devinfo().data();
    let storage = match dev.get_storage() {
        Some(penumbra_mtk::StorageKind::Emmc(_)) => "eMMC",
        Some(penumbra_mtk::StorageKind::Ufs(_)) => "UFS",
        None => "",
    };
    let mode = format!("{:?}", dev.get_connection_type());
    let protocol = match dev.get_protocol() {
        Some(penumbra_mtk::da::DaProtocol::V5(_)) => "XFlash",
        Some(penumbra_mtk::da::DaProtocol::V6(_)) => "XML",
        None => "",
    };

    let mut out = String::new();
    out.push_str(&format!(
        "CHIP: {}\n",
        data.chip.map(|soc| format!("{soc:?}")).unwrap_or_default()
    ));
    out.push_str(&format!("STORAGE: {storage}\n"));
    out.push_str(&format!("BOOT MODE: {mode}\n"));
    out.push_str(&format!("DA PROTOCOL: {protocol}\n"));
    out.push_str(&format!("HW CODE: 0x{:04x}\n", data.hw_code));
    out.push_str(&format!("HW SUBCODE: 0x{:04x}\n", data.hw_subcode));
    out.push_str(&format!("TARGET CONFIG: 0x{:08x}\n", data.target_config));
    out.push_str(&format!("MEID: {}\n", hex_bytes(&data.meid)));
    out.push_str(&format!("SOC ID: {}\n", hex_bytes(&data.soc_id)));
    out.push_str(&format!("SBC: {}\n", yes_no(sbc)));
    out.push_str(&format!("SLA: {}\n", yes_no(sla)));
    out.push_str(&format!("DAA: {}\n", yes_no(daa)));
    out
}

/// Boot control block, keyed the way the app's boot slot screen reads it.
fn bootctrl_payload(control: &penumbra_mtk::hacc::BootControl) -> String {
    let active = match control.get_active_slot() {
        penumbra_mtk::hacc::BootPartition::A => "a",
        penumbra_mtk::hacc::BootPartition::B => "b",
    };
    let mut out = format!(
        "ACTIVE_SLOT: {active}\nSUFFIX: {}\n",
        control.get_current_suffix().unwrap_or_default()
    );
    for (name, slot) in [
        ("A", penumbra_mtk::hacc::BootPartition::A),
        ("B", penumbra_mtk::hacc::BootPartition::B),
    ] {
        let bits = control.get_slot(slot);
        let priority = bits.priority().value();
        out.push_str(&format!("SLOT_{name}_PRIORITY: {priority}\n"));
        out.push_str(&format!(
            "SLOT_{name}_TRIES: {}\n",
            bits.tries_remaining().value()
        ));
        out.push_str(&format!(
            "SLOT_{name}_SUCCESSFUL: {}\n",
            bits.successful_boot().value()
        ));
        out.push_str(&format!(
            "SLOT_{name}_BOOTABLE: {}\n",
            yes_no(priority > 0)
        ));
        out.push_str(&format!(
            "SLOT_{name}_VERITY: {}\n",
            bits.verity_corrupted().value()
        ));
    }
    out
}

/// Readable partition table. The app-side format for this verb is not established yet, so
/// nothing here claims a keyed contract (see ../docs/PARITY.md).
fn partitions_payload(partitions: &[Partition]) -> String {
    let mut out = String::new();
    for partition in partitions {
        out.push_str(&format!(
            "{}: {} bytes at 0x{:x} ({:?})\n",
            partition.name, partition.size, partition.address, partition.kind
        ));
    }
    out.push_str(&format!("total: {} partitions", partitions.len()));
    out
}

fn boot_mode(name: &str) -> Result<BootMode, String> {
    match name.trim().to_ascii_lowercase().as_str() {
        "normal" => Ok(BootMode::Normal),
        "home" | "homescreen" => Ok(BootMode::HomeScreen),
        "fastboot" => Ok(BootMode::Fastboot),
        "test" => Ok(BootMode::Test),
        "meta" => Ok(BootMode::Meta),
        other => Err(format!("unknown boot mode '{other}'")),
    }
}

/// Build a device session from an already-open USB descriptor.
fn build_session(
    fd: RawFd,
    connection: ConnectionType,
    da_path: &str,
    auth_path: &str,
    preloader_path: &str,
    want_da: bool,
) -> Result<Session, String> {
    if fd < 0 {
        return Err("no USB descriptor: call nativeSetUsbFd first".into());
    }
    let endpoints = UsbfsPort::discover(fd).unwrap_or(Endpoints {
        interface: 0,
        ep_in: EP_IN_DEFAULT,
        ep_out: EP_OUT_DEFAULT,
    });
    let mut port = UsbfsPort::with_endpoints(fd, connection, endpoints);
    port.set_timeout(SESSION_TIMEOUT).map_err(describe)?;

    let da = load_payload(da_path)?;
    let auth = load_payload(auth_path)?;
    let preloader = load_payload(preloader_path)?;

    let mut builder = DeviceBuilder::new(port);
    if let Some(data) = da {
        builder = builder.with_da_data(data);
    }
    if let Some(data) = preloader {
        builder = builder.with_preloader(data);
    }
    if let Some(data) = auth {
        builder = builder.with_auth(data);
    }

    let mut dev = builder.build().map_err(describe)?;
    dev.init().map_err(describe)?;
    if want_da && da.is_some() {
        dev.ensure_da_mode().map_err(describe)?;
    }
    Ok(Session {
        dev,
        key: (
            fd,
            da_path.to_string(),
            auth_path.to_string(),
            preloader_path.to_string(),
        ),
    })
}

/// Get the session for this descriptor + payload set, building it when the app moved on.
fn ensure_session(
    fd: RawFd,
    connection: ConnectionType,
    da_path: &str,
    auth_path: &str,
    preloader_path: &str,
    want_da: bool,
) -> Result<(), String> {
    let mut guard = SESSION
        .lock()
        .map_err(|_| "session lock poisoned".to_string())?;
    let key = (
        fd,
        da_path.to_string(),
        auth_path.to_string(),
        preloader_path.to_string(),
    );
    if let Some(existing) = guard.as_ref()
        && existing.0.key == key
    {
        return Ok(());
    }
    if let Some(mut stale) = guard.take() {
        let _ = stale.0.dev.port_mut().close();
    }
    let session = build_session(
        fd,
        connection,
        da_path,
        auth_path,
        preloader_path,
        want_da,
    )?;
    *guard = Some(SendSession(session));
    Ok(())
}

fn dispatch(session: &mut Session, verb: &str, operands: &[String]) -> Result<String, String> {
    let operand = |index: usize| -> String {
        operands
            .get(index)
            .map(|value| value.trim().to_string())
            .unwrap_or_default()
    };
    let required = |index: usize, what: &str| -> Result<String, String> {
        let value = operand(index);
        if value.is_empty() {
            Err(format!("{verb}: missing {what}"))
        } else {
            Ok(value)
        }
    };

    match verb {
        "probe" | "devinfo" | "device-info" => Ok(device_info_payload(&mut session.dev)),
        "pgpt" | "partitions" | "list-partitions" => {
            let partitions = session.dev.partitions();
            Ok(partitions_payload(&partitions))
        }
        "bootctrl-info" => {
            let control = session.dev.get_bootctrl().map_err(describe)?;
            Ok(bootctrl_payload(&control))
        }
        "bootctrl-set" => bootctrl_set(session, &required(0, "slot (A or B)")?),
        "upload" => {
            let name = required(0, "partition name")?;
            let path = required(1, "output path")?;
            let file = fs::File::create(&path).map_err(|e| format!("cannot create {path}: {e}"))?;
            session
                .dev
                .read_partition(&name, file, |_, _| {})
                .map_err(describe)?;
            Ok(format!("read {name} -> {path}"))
        }
        "download" | "scatter-download" => {
            let name = required(0, "partition name")?;
            let path = required(1, "input path")?;
            let (name, offset) = split_offset(&name);
            let file = fs::File::open(&path).map_err(|e| format!("cannot open {path}: {e}"))?;
            let size = file
                .metadata()
                .map_err(|e| format!("cannot stat {path}: {e}"))?
                .len();
            match offset {
                Some(address) => {
                    let kind = session
                        .dev
                        .get_partition(&name)
                        .map(|partition| partition.kind.clone())
                        .ok_or_else(|| format!("no partition named '{name}'"))?;
                    session
                        .dev
                        .write_offset(address, size, kind, file, |_, _| {})
                        .map_err(describe)?;
                    Ok(format!("wrote {path} -> {name} at 0x{address:x}"))
                }
                None => {
                    session
                        .dev
                        .write_partition(&name, size, file, |_, _| {})
                        .map_err(describe)?;
                    Ok(format!("wrote {path} -> {name}"))
                }
            }
        }
        "erase-partition" => {
            let name = required(0, "partition name")?;
            session
                .dev
                .erase_partition(&name, |_, _| {})
                .map_err(describe)?;
            Ok(format!("erased {name}"))
        }
        "read-flash" => {
            let name = required(0, "partition name")?;
            let path = required(1, "output path")?;
            let file = fs::File::create(&path).map_err(|e| format!("cannot create {path}: {e}"))?;
            session
                .dev
                .read_flash(&name, file, |_, _| {})
                .map_err(describe)?;
            Ok(format!("read {name} -> {path}"))
        }
        "write-flash" => {
            let name = required(0, "partition name")?;
            let path = required(1, "input path")?;
            let file = fs::File::open(&path).map_err(|e| format!("cannot open {path}: {e}"))?;
            session
                .dev
                .write_flash(&name, file, |_, _| {})
                .map_err(describe)?;
            Ok(format!("wrote {path} -> {name}"))
        }
        "seccfg" => {
            let state = operand(0).to_ascii_lowercase();
            match state.as_str() {
                "unlock" => {
                    session
                        .dev
                        .set_seccfg_lock_state(LockState::Unlock)
                        .map_err(describe)?;
                    Ok("seccfg: unlock state applied".into())
                }
                "lock" => {
                    session
                        .dev
                        .set_seccfg_lock_state(LockState::Lock)
                        .map_err(describe)?;
                    Ok("seccfg: lock state applied".into())
                }
                other => Err(format!(
                    "seccfg: '{}' is not implemented in this build",
                    if other.is_empty() { "read" } else { other }
                )),
            }
        }
        "scatter-download-v6" => {
            let path = required(0, "scatter path")?;
            let content = fs::read_to_string(&path).map_err(|e| format!("cannot read {path}: {e}"))?;
            let base = Path::new(&path)
                .parent()
                .map(Path::to_path_buf)
                .unwrap_or_default();
            let source = |image: &str| -> Result<(fs::File, u64), Error> {
                // Scatter entries name their images relative to the scatter file.
                let file = if base.as_os_str().is_empty() || Path::new(image).is_absolute() {
                    fs::File::open(image)?
                } else {
                    fs::File::open(base.join(image))?
                };
                let size = file.metadata()?.len();
                Ok((file, size))
            };
            let sink = |name: &str| -> Result<fs::File, Error> {
                let target = base.join(name);
                if let Some(dir) = target.parent() {
                    fs::create_dir_all(dir)?;
                }
                Ok(fs::File::create(target)?)
            };
            session
                .dev
                .flash_scatter(&content, source, sink, |_, _| {})
                .map_err(describe)?;
            Ok(format!("scatter {path} flashed"))
        }
        "reboot" => {
            // A bare `reboot` means the normal boot mode.
            let mode = match operand(0).as_str() {
                "" => BootMode::Normal,
                other => boot_mode(other)?,
            };
            session.dev.reboot(mode).map_err(describe)?;
            Ok(format!("rebooting into {mode:?}"))
        }
        "scatter-firmware-upgrade" => Err(
            "scatter-firmware-upgrade: not implemented in this build; the firmware-upgrade \
             packaging pipeline is not part of the flash core yet"
                .into(),
        ),
        "shutdown" => {
            session.dev.shutdown().map_err(describe)?;
            Ok("shutdown requested".into())
        }
        other => Err(format!("unsupported command '{other}'")),
    }
}

/// `scatter-download` hands the partition over as `name\t<hex offset>`.
fn split_offset(partition: &str) -> (String, Option<u64>) {
    match partition.split_once('\t') {
        Some((name, offset)) => (
            name.trim().to_string(),
            u64::from_str_radix(offset.trim().trim_start_matches("0x"), 16).ok(),
        ),
        None => (partition.trim().to_string(), None),
    }
}

/// Point the boot control block at another slot. The block lives inside a small partition
/// (`misc`/`para`), so it is read whole, patched and written back — nothing else persists it.
fn bootctrl_set(session: &mut Session, slot: &str) -> Result<String, String> {
    let slot = match slot.to_ascii_uppercase().as_str() {
        "A" => BootPartition::A,
        "B" => BootPartition::B,
        other => return Err(format!("bootctrl-set: slot must be A or B, got '{other}'")),
    };
    let partition = session
        .dev
        .partitions()
        .iter()
        .find(|partition| partition.name == "misc" || partition.name == "para")
        .map(|partition| partition.name.clone())
        .ok_or("bootctrl-set: neither misc nor para is present")?;
    let mut buffer = Vec::new();
    session
        .dev
        .read_partition(&partition, &mut buffer, |_, _| {})
        .map_err(describe)?;
    if buffer.len() < OFFSET_SLOT_SUFFIX + std::mem::size_of::<BootControl>() {
        return Err(format!(
            "bootctrl-set: {partition} holds only {} bytes",
            buffer.len()
        ));
    }
    let mut control = BootControl::try_read(&buffer[OFFSET_SLOT_SUFFIX..]).map_err(describe)?;
    control.set_active_slot(slot);
    control
        .try_write(&mut buffer[OFFSET_SLOT_SUFFIX..])
        .map_err(describe)?;
    let size = buffer.len() as u64;
    session
        .dev
        .write_partition(&partition, size, std::io::Cursor::new(buffer), |_, _| {})
        .map_err(describe)?;
    Ok(format!("bootctrl-set: active slot is {slot:?} in {partition}"))
}

fn with_session<T>(f: impl FnOnce(&mut Session) -> T) -> Result<T, String> {
    let mut guard = SESSION.lock().map_err(|_| "session lock poisoned".to_string())?;
    match guard.as_mut() {
        Some(session) => Ok(f(&mut session.0)),
        None => Err("no active session".into()),
    }
}

fn reply(env: &mut JNIEnv, text: &str) -> jstring {
    match env.new_string(text) {
        Ok(value) => value.into_raw(),
        Err(_) => std::ptr::null_mut(),
    }
}

fn argument(env: &mut JNIEnv, value: &JString) -> String {
    env.get_string(value)
        .map(|text| text.to_string_lossy().into_owned())
        .unwrap_or_default()
}

/// Run one command. Every call carries its own descriptor and payload paths, so a call whose
/// payloads differ from the cached session rebuilds it; `crash` tears the session down.
fn run(verb: &str, operands: &[String], fd: RawFd, da: &str, auth: &str, preloader: &str) -> String {
    if CANCEL.swap(false, Ordering::SeqCst) {
        return describe("cancelled");
    }
    if verb == "crash" || verb == "disconnect" {
        return match SESSION.lock() {
            Ok(mut guard) => {
                if let Some(mut session) = guard.take() {
                    let _ = session.0.dev.port_mut().close();
                }
                "OK\nsession closed".to_string()
            }
            Err(_) => describe("session lock poisoned"),
        };
    }
    let connection = if verb == "probe" && da.is_empty() {
        ConnectionType::Preloader
    } else {
        ConnectionType::Da
    };
    // `probe` is the handshake-only door: it is exempt from the app's DA requirement.
    let want_da = !da.is_empty() && verb != "probe";
    if let Err(message) = ensure_session(fd, connection, da, auth, preloader, want_da) {
        return describe(message);
    }
    let result =
        with_session(|session| dispatch(session, verb, operands)).and_then(|payload| payload);
    match result {
        Ok(payload) => format!("OK\n{payload}"),
        Err(message) => describe(message),
    }
}

// ---------------------------------------------------------------------------------------------
// JNI entry points, registered against com.rynx.app.MainActivity
// ---------------------------------------------------------------------------------------------

extern "system" fn native_set_usb_fd(_env: JNIEnv, _this: JObject, fd: jint) -> jlong {
    if fd < 0 {
        return 0;
    }
    USB_FD.store(fd, Ordering::SeqCst);
    fd as jlong
}

extern "system" fn native_set_xiaomi_auth_generation(
    _env: JNIEnv,
    _this: JObject,
    generation: jint,
) {
    XIAOMI_GENERATION.store(generation, Ordering::SeqCst);
}

extern "system" fn native_has_session(_env: JNIEnv, _this: JObject) -> jboolean {
    match SESSION.lock() {
        Ok(guard) => guard.is_some() as jboolean,
        Err(_) => 0,
    }
}

extern "system" fn native_cancel_io(_env: JNIEnv, _this: JObject) {
    CANCEL.store(true, Ordering::SeqCst);
}

extern "system" fn native_disconnect_session(_env: JNIEnv, _this: JObject) {
    if let Ok(mut guard) = SESSION.lock()
        && let Some(mut session) = guard.take()
    {
        let _ = session.0.dev.port_mut().close();
    }
}

extern "system" fn native_connect_session(
    mut env: JNIEnv,
    _this: JObject,
    mode: jint,
    _timeout: jlong,
    first: JString,
    second: JString,
    third: JString,
) -> jstring {
    // NativeConnectSession's strings are the DA, auth and preloader paths, not a verb.
    let da = argument(&mut env, &first);
    let auth = argument(&mut env, &second);
    let preloader = argument(&mut env, &third);
    let fd = USB_FD.load(Ordering::SeqCst) as RawFd;
    let connection = match mode {
        0 => ConnectionType::Brom,
        1 => ConnectionType::Preloader,
        _ => ConnectionType::Da,
    };
    let text = match ensure_session(fd, connection, &da, &auth, &preloader, true) {
        Ok(()) => "OK\nsession established".to_string(),
        Err(message) => describe(message),
    };
    reply(&mut env, &text)
}

#[allow(clippy::too_many_arguments)]
extern "system" fn native_run_command(
    mut env: JNIEnv,
    _this: JObject,
    fd: jint,
    _timeout: jlong,
    first: JString,
    second: JString,
    third: JString,
    fourth: JString,
    fifth: JString,
    sixth: JString,
) -> jstring {
    let verb = argument(&mut env, &first);
    let operands = [argument(&mut env, &second), argument(&mut env, &third)];
    let text = dispatch_native(&mut env, fd, &verb, &operands, &fourth, &fifth, &sixth);
    reply(&mut env, &text)
}

/// Command arguments end with the session's payload paths:
/// `(fd, timeout, verb, operand, operand, da, auth, preloader)`.
fn dispatch_native(
    env: &mut JNIEnv,
    fd: jint,
    verb: &str,
    operands: &[String],
    da: &JString,
    auth: &JString,
    preloader: &JString,
) -> String {
    let da = argument(env, da);
    let auth = argument(env, auth);
    let preloader = argument(env, preloader);
    let descriptor = if fd < 0 {
        USB_FD.load(Ordering::SeqCst)
    } else {
        fd
    };
    run(verb, operands, descriptor as RawFd, &da, &auth, &preloader)
}

#[allow(clippy::too_many_arguments)]
extern "system" fn native_run_gui_action(
    mut env: JNIEnv,
    _this: JObject,
    fd: jint,
    _timeout: jlong,
    first: JString,
    second: JString,
    third: JString,
    fourth: JString,
    fifth: JString,
    sixth: JString,
) -> jstring {
    let verb = argument(&mut env, &first);
    let operands = [argument(&mut env, &second), argument(&mut env, &third)];
    let text = dispatch_native(&mut env, fd, &verb, &operands, &fourth, &fifth, &sixth);
    reply(&mut env, &text)
}

#[unsafe(no_mangle)]
pub unsafe extern "system" fn JNI_OnLoad(vm: *mut JavaVM, _reserved: *mut std::ffi::c_void) -> jint {
    let mut env = match unsafe { JNIEnv::from_raw(vm.cast::<RawJniEnv>()) } {
        Ok(env) => env,
        Err(_) => return JNI_VERSION_1_6,
    };
    let class: JClass = match env.find_class("com/rynx/app/MainActivity") {
        Ok(class) => class,
        Err(_) => return JNI_VERSION_1_6,
    };
    let methods = [
        (
            "nativeCancelIo",
            "()V",
            native_cancel_io as *mut std::ffi::c_void,
        ),
        (
            "nativeConnectSession",
            "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            native_connect_session as *mut std::ffi::c_void,
        ),
        (
            "nativeDisconnectSession",
            "()V",
            native_disconnect_session as *mut std::ffi::c_void,
        ),
        (
            "nativeHasSession",
            "()Z",
            native_has_session as *mut std::ffi::c_void,
        ),
        (
            "nativeRunCommand",
            "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            native_run_command as *mut std::ffi::c_void,
        ),
        (
            "nativeRunGuiAction",
            "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            native_run_gui_action as *mut std::ffi::c_void,
        ),
        (
            "nativeSetUsbFd",
            "(I)J",
            native_set_usb_fd as *mut std::ffi::c_void,
        ),
        (
            "nativeSetXiaomiAuthGeneration",
            "(I)V",
            native_set_xiaomi_auth_generation as *mut std::ffi::c_void,
        ),
    ];
    let native_methods: Vec<jni::NativeMethod> = methods
        .iter()
        .map(|(name, signature, pointer)| jni::NativeMethod {
            name: jni::strings::JNIString::from(*name),
            sig: jni::strings::JNIString::from(*signature),
            fn_ptr: *pointer,
        })
        .collect();
    let _ = env.register_native_methods(class, &native_methods);
    let _ = XIAOMI_GENERATION.load(Ordering::Relaxed);
    JNI_VERSION_1_6
}
