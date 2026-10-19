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
//! Command results are strings: `OK\n<payload>` on success, `ERR:<message>` otherwise. The
//! payload text is a contract with the app — the screen code reads it back by label — so the
//! label set and line order here are fixed, not cosmetic. See `../../docs/PARITY.md` §6 and
//! `../../docs/NATIVE-ENGINE-RE.md`.

use std::fmt::Display;
use std::fs::{self, File};
use std::io::{Cursor, Write};
use std::os::fd::RawFd;
use std::path::Path;
use std::sync::atomic::{AtomicBool, AtomicI32, Ordering};
use std::sync::Mutex;
use std::time::Duration;

use jni::JNIEnv;
use jni::objects::{JClass, JObject, JString};
use jni::sys::{JNI_VERSION_1_6, JavaVM, jboolean, jint, jlong, jstring};

use penumbra_mtk::da::{DaProtocol, ScatterFile};
use penumbra_mtk::device::{Device, DeviceBuilder};
use penumbra_mtk::hacc::{
    BootControl,
    BootPartition,
    LockState,
    OFFSET_SLOT_SUFFIX,
    TryRead,
    TryWrite,
};
use penumbra_mtk::port::ConnectionType;
use penumbra_mtk::{BootMode, Error, MtkPort, Partition};
use usbfs::{EP_IN_DEFAULT, EP_OUT_DEFAULT, Endpoints, UsbfsPort};

const SESSION_TIMEOUT: Duration = Duration::from_millis(5000);

/// Size of the boot-control block as it sits on the wire, from `hacc::BootControl`.
const BOOTCONTROL_SIZE: usize = 32;
/// `BootControlInfo` sits 9 bytes into the block (suffix[4], magic u32, version u8).
const BOOTCONTROL_INFO_OFFSET: usize = OFFSET_SLOT_SUFFIX + 9;
/// Low three bits of `BootControlInfo` are the slot count.
const BOOTCONTROL_SLOT_COUNT_MASK: u16 = 0x7;

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
    if value { "true" } else { "false" }
}

/// Connection type as the app's `BOOT MODE:` line spells it.
fn boot_mode_label(connection: ConnectionType) -> &'static str {
    match connection {
        ConnectionType::Brom => "Brom",
        ConnectionType::Preloader => "Preloader",
        ConnectionType::Da => "Da",
    }
}

/// DA protocol as the app's `DA PROTOCOL:` line spells it.
fn protocol_label(dev: &mut Device<'static, UsbfsPort>) -> &'static str {
    match dev.get_protocol() {
        Some(DaProtocol::V5(_)) => "XFlash (V5)",
        Some(DaProtocol::V6(_)) => "XML (V6)",
        None => "",
    }
}

/// Storage kind as the partition table's `section=` and the `STORAGE:` line spell it.
fn storage_label(dev: &mut Device<'static, UsbfsPort>) -> &'static str {
    match dev.get_storage() {
        Some(penumbra_mtk::StorageKind::Emmc(_)) => "EMMC",
        Some(penumbra_mtk::StorageKind::Ufs(_)) => "UFS",
        None => "",
    }
}

fn chip_label(dev: &mut Device<'static, UsbfsPort>) -> String {
    match dev.devinfo().chip() {
        Some(soc) => match soc.marketing_name() {
            Some(marketing) => format!("{soc:?}/{marketing}"),
            None => format!("{soc:?}"),
        },
        None => String::new(),
    }
}

/// Partition line the app parses with `indexOf("addr=0x") / "size=0x" / "section="`.
fn partition_line(partition: &Partition, storage: &'static str) -> String {
    let section: &'static str = partition.kind.into();
    let section = if section.is_empty() { storage } else { section };
    format!(
        "{} addr=0x{:x} size=0x{:x} section={section}\n",
        partition.name, partition.address, partition.size
    )
}

/// `probe` payload: the device block the app's info panel reads label by label.
fn device_info_payload(dev: &mut Device<'static, UsbfsPort>) -> Result<String, String> {
    let sbc = dev.devinfo().sbc_enabled();
    let sla = dev.devinfo().sla_enabled();
    let daa = dev.devinfo().daa_enabled();
    let data = dev.devinfo().data();
    let connection = dev.get_connection_type();
    let chip = chip_label(dev);
    let storage = storage_label(dev);
    let protocol = protocol_label(dev);
    let partitions = dev.partitions().len();

    let mut out = String::new();
    out.push_str("SESSION READY\n");
    out.push_str(&format!("CHIP: {chip}\n"));
    out.push_str(&format!("STORAGE: {storage}\n"));
    out.push_str(&format!("BOOT MODE: {}\n", boot_mode_label(connection)));
    out.push_str(&format!("DA PROTOCOL: {protocol}\n"));
    out.push_str(&format!("HW CODE: 0x{:04x}\n", data.hw_code));
    out.push_str(&format!("HW SUBCODE: {}\n", data.hw_subcode));
    // The engine carries neither field, so both labels are present with an empty value.
    out.push_str("HW VERSION: \n");
    out.push_str("SW VERSION: \n");
    out.push_str(&format!("TARGET CONFIG: 0x{:08x}\n", data.target_config));
    out.push_str(&format!("MEID: {}\n", hex_bytes(&data.meid)));
    out.push_str(&format!("SOC ID: {}\n", hex_bytes(&data.soc_id)));
    out.push_str(&format!("SBC: {}\n", yes_no(sbc)));
    out.push_str(&format!("SLA: {}\n", yes_no(sla)));
    out.push_str(&format!("DAA: {}\n", yes_no(daa)));
    out.push_str(&format!("PARTITIONS: {partitions}\n"));
    Ok(out)
}

/// `pgpt` payload: a header line then one parsable line per partition.
fn partition_table_payload(dev: &mut Device<'static, UsbfsPort>) -> String {
    let storage = storage_label(dev);
    let partitions = dev.partitions();
    let mut out = String::from("PARTITION TABLE\n");
    for partition in &partitions {
        out.push_str(&partition_line(partition, storage));
    }
    out
}

/// Read the boot-control block whole. `misc` wins over `para`; the block sits at
/// `OFFSET_SLOT_SUFFIX` inside it.
fn read_bootctrl(
    session: &mut Session,
) -> Result<(String, Vec<u8>, BootControl), String> {
    let name = session
        .dev
        .partitions()
        .iter()
        .find(|partition| partition.name == "misc" || partition.name == "para")
        .map(|partition| partition.name.clone())
        .ok_or("Neither 'misc' nor 'para' partition found.")?;
    let mut buffer = Vec::new();
    session
        .dev
        .read_partition(&name, &mut buffer, |_, _| {})
        .map_err(describe)?;
    if buffer.len() < OFFSET_SLOT_SUFFIX + BOOTCONTROL_SIZE {
        return Err(format!(
            "'{name}' holds {} bytes, too short for a boot-control block",
            buffer.len()
        ));
    }
    let control = BootControl::try_read(&buffer[OFFSET_SLOT_SUFFIX..]).map_err(describe)?;
    Ok((name, buffer, control))
}

/// `bootctrl-info` payload.
fn bootctrl_info_payload(
    partition: &str,
    buffer: &[u8],
    control: &BootControl,
) -> String {
    let slot = match control.get_active_slot() {
        BootPartition::A => "a",
        BootPartition::B => "b",
    };
    let slot_count = u16::from_le_bytes([
        buffer[BOOTCONTROL_INFO_OFFSET],
        buffer[BOOTCONTROL_INFO_OFFSET + 1],
    ]) & BOOTCONTROL_SLOT_COUNT_MASK;

    let mut out = String::new();
    out.push_str("BOOTCTRL\n");
    out.push_str(&format!("PARTITION: {partition}\n"));
    out.push_str(&format!("OFFSET: 0x{OFFSET_SLOT_SUFFIX:x}\n"));
    out.push_str(&format!("SLOT_COUNT: {slot_count}\n"));
    out.push_str(&format!("ACTIVE_SLOT: {slot}\n"));
    out.push_str(&format!(
        "SUFFIX: {}\n",
        control.get_current_suffix().unwrap_or_default()
    ));
    out.push_str("CRC: OK\n");
    for (name, slot) in [("A", BootPartition::A), ("B", BootPartition::B)] {
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

fn parse_scatter(content: &str) -> Result<ScatterFile, String> {
    if content.trim_start().starts_with('<') {
        ScatterFile::from_xml(content).map_err(describe)
    } else {
        ScatterFile::from_yaml(content).map_err(describe)
    }
}

fn scatter_is_xml(content: &str) -> bool {
    content.trim_start().starts_with('<')
}

/// Images a scatter actually supplies (entries flagged for download that carry a file).
fn scatter_image_count(scatter: &ScatterFile) -> usize {
    scatter
        .parts
        .iter()
        .filter(|part| part.download && part.path.is_some())
        .count()
}

fn partition_signature(dev: &mut Device<'static, UsbfsPort>) -> Vec<(String, u64, u64)> {
    dev.partitions()
        .into_iter()
        .map(|partition| (partition.name, partition.address, partition.size))
        .collect()
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

fn boot_mode(name: &str) -> Result<(BootMode, &'static str), String> {
    match name.trim().to_ascii_lowercase().as_str() {
        "" | "normal" => Ok((BootMode::Normal, "normal")),
        "home-screen" | "homescreen" => Ok((BootMode::HomeScreen, "home-screen")),
        "fastboot" => Ok((BootMode::Fastboot, "fastboot")),
        "meta" => Ok((BootMode::Meta, "meta")),
        "test" => Ok((BootMode::Test, "test")),
        _ => Err(format!(
            "Unsupported reboot mode '{name}'. Use: normal | home-screen | fastboot | meta | test"
        )),
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
        .map_err(|_| "Android persistent session mutex is poisoned".to_string())?;
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
        "probe" => device_info_payload(&mut session.dev),
        "pgpt" => Ok(partition_table_payload(&mut session.dev)),
        "bootctrl-info" => {
            let (partition, buffer, control) = read_bootctrl(session)?;
            Ok(bootctrl_info_payload(&partition, &buffer, &control))
        }
        "bootctrl-set" => bootctrl_set(session, &operand(0)),
        "upload" | "read-flash" => {
            let name = required(0, "partition name")?;
            let path = required(1, "output file path")?;
            read_out(session, verb, &name, &path)
        }
        "download" | "scatter-download" | "write-flash" => {
            let name = required(0, "partition name")?;
            let path = required(1, "input file path")?;
            write_in(session, &name, &path)
        }
        "erase-partition" | "erase" => {
            let name = required(0, "partition name")?;
            erase(session, verb, &name)
        }
        "seccfg" => seccfg(session, &operand(0)),
        "reboot" => {
            let (mode, label) = boot_mode(&operand(0))?;
            session.dev.reboot(mode).map_err(describe)?;
            Ok(format!("REBOOT COMPLETE\nMODE: {label}"))
        }
        "shutdown" => {
            session.dev.shutdown().map_err(describe)?;
            Ok("SHUTDOWN COMPLETE".into())
        }
        "scatter-download-v6" => download_only(session, &required(0, "scatter path")?),
        "scatter-firmware-upgrade" => {
            firmware_upgrade(session, &required(0, "scatter path")?)
        }
        other => Err(format!("unsupported command '{other}'")),
    }
}

/// `upload` / `read-flash`: partition (or raw flash) out to a host file.
fn read_out(
    session: &mut Session,
    verb: &str,
    name: &str,
    path: &str,
) -> Result<String, String> {
    let mut file = File::create(path).map_err(|e| format!("cannot create {path}: {e}"))?;
    let result = if verb == "read-flash" {
        session.dev.read_flash(name, &mut file, |_, _| {})
    } else {
        session.dev.read_partition(name, &mut file, |_, _| {})
    };
    result.map_err(describe)?;
    file.flush().map_err(describe)?;
    drop(file);
    let bytes = fs::metadata(path)
        .map_err(|e| format!("cannot stat {path}: {e}"))?
        .len();
    Ok(format!(
        "READ COMPLETE\nPARTITION: {name}\nBYTES: {bytes}\nFILE: {path}"
    ))
}

/// `download` / `scatter-download` / `write-flash`: host image into a partition. A
/// `name\t<hex offset>` operand takes the raw-offset path.
fn write_in(session: &mut Session, partition: &str, path: &str) -> Result<String, String> {
    let (name, offset) = split_offset(partition);
    let file = File::open(path).map_err(|e| format!("cannot open {path}: {e}"))?;
    let size = file
        .metadata()
        .map_err(|e| format!("cannot stat {path}: {e}"))?
        .len();
    match offset {
        Some(address) => {
            let kind = session
                .dev
                .get_partition(&name)
                .map(|partition| partition.kind)
                .ok_or_else(|| format!("no partition named '{name}'"))?;
            session
                .dev
                .write_offset(address, size, kind, file, |_, _| {})
                .map_err(describe)?;
        }
        None => {
            session
                .dev
                .write_partition(&name, size, file, |_, _| {})
                .map_err(describe)?;
        }
    }
    Ok(format!("WRITE COMPLETE\nPARTITION: {name}\nBYTES: {size}"))
}

fn erase(session: &mut Session, verb: &str, name: &str) -> Result<String, String> {
    let bytes = session
        .dev
        .get_partition(name)
        .map(|partition| partition.size)
        .unwrap_or(0);
    if verb == "erase" {
        session.dev.erase_flash(name, |_, _| {}).map_err(describe)?;
    } else {
        session
            .dev
            .erase_partition(name, |_, _| {})
            .map_err(describe)?;
    }
    Ok(format!("ERASE COMPLETE\nPARTITION: {name}\nBYTES: {bytes}"))
}

/// `seccfg`: the only sampled verbs are `unlock` and `lock`; reading the state back is not
/// a supported action.
fn seccfg(session: &mut Session, action: &str) -> Result<String, String> {
    let (state, label) = match action.to_ascii_lowercase().as_str() {
        "unlock" => (LockState::Unlock, "UNLOCKED"),
        "lock" => (LockState::Lock, "LOCKED"),
        _ => return Err("seccfg action must be 'unlock' or 'lock'".into()),
    };
    session
        .dev
        .set_seccfg_lock_state(state)
        .map_err(describe)?;
    Ok(format!("SECCFG UPDATED\nSTATE: {label}"))
}

/// Point the boot control block at another slot and prove the write landed.
fn bootctrl_set(session: &mut Session, slot: &str) -> Result<String, String> {
    let slot = match slot.to_ascii_lowercase().as_str() {
        "a" => BootPartition::A,
        "b" => BootPartition::B,
        _ => return Err("BootControl slot must be 'a' or 'b'".into()),
    };
    let (name, mut buffer, mut control) = read_bootctrl(session)?;
    control.set_active_slot(slot);
    control
        .try_write(&mut buffer[OFFSET_SLOT_SUFFIX..])
        .map_err(describe)?;
    let size = buffer.len() as u64;
    session
        .dev
        .write_partition(&name, size, Cursor::new(buffer.clone()), |_, _| {})
        .map_err(describe)?;

    let mut check = Vec::new();
    session
        .dev
        .read_partition(&name, &mut check, |_, _| {})
        .map_err(describe)?;
    let expected = &buffer[OFFSET_SLOT_SUFFIX..OFFSET_SLOT_SUFFIX + BOOTCONTROL_SIZE];
    if check.len() < OFFSET_SLOT_SUFFIX + BOOTCONTROL_SIZE
        || &check[OFFSET_SLOT_SUFFIX..OFFSET_SLOT_SUFFIX + BOOTCONTROL_SIZE] != expected
    {
        return Err("BootControl read-back mismatch after slot switch".into());
    }
    Ok("BOOTCTRL UPDATED\n".into())
}

/// Source/sink closures for scatter flashing: images resolve beside the scatter file, backups are
/// written beside it too.
fn scatter_io(
    base: &Path,
) -> (
    impl FnMut(&str) -> Result<(File, u64), Error> + Send + use<>,
    impl FnMut(&str) -> Result<File, Error> + Send + use<>,
) {
    let source_base = base.to_path_buf();
    let sink_base = base.to_path_buf();
    let source = move |image: &str| -> Result<(File, u64), Error> {
        let file = if source_base.as_os_str().is_empty() || Path::new(image).is_absolute() {
            File::open(image)?
        } else {
            File::open(source_base.join(image))?
        };
        let size = file.metadata()?.len();
        Ok((file, size))
    };
    let sink = move |name: &str| -> Result<File, Error> {
        let target = sink_base.join(name);
        if let Some(dir) = target.parent() {
            fs::create_dir_all(dir)?;
        }
        Ok(File::create(target)?)
    };
    (source, sink)
}

fn scatter_base(path: &str) -> std::path::PathBuf {
    Path::new(path)
        .parent()
        .map(Path::to_path_buf)
        .unwrap_or_default()
}

/// `scatter-download-v6`: one scatter package flashed in a single call.
fn download_only(session: &mut Session, path: &str) -> Result<String, String> {
    let content = fs::read_to_string(path).map_err(|e| format!("cannot read {path}: {e}"))?;
    let scatter = parse_scatter(&content)?;
    let images = scatter_image_count(&scatter);
    let engine = protocol_label(&mut session.dev);
    let base = scatter_base(path);
    let (source, sink) = scatter_io(&base);
    session
        .dev
        .flash_scatter(&content, source, sink, |_, _| {})
        .map_err(describe)?;
    Ok(format!(
        "DOWNLOAD ONLY COMPLETE\nENGINE: {engine} WRITE-PARTITIONS\nPARTITIONS: {images}"
    ))
}

/// `scatter-firmware-upgrade`: a whole firmware package written as one transaction, then
/// reported with the layout facts the app shows.
fn firmware_upgrade(session: &mut Session, path: &str) -> Result<String, String> {
    let content = fs::read_to_string(path).map_err(|e| format!("cannot read {path}: {e}"))?;
    let xml = scatter_is_xml(&content);
    let engine = protocol_label(&mut session.dev);
    match (engine, xml) {
        ("XFlash/V5", true) => {
            return Err("XFlash/V5 DA cannot run an XML/V6 Firmware Upgrade".into());
        }
        ("XML/V6", false) => {
            return Err("XML/V6 DA requires an XML scatter for Firmware Upgrade".into());
        }
        _ => {}
    }
    let scatter = parse_scatter(&content)?;
    let images = scatter_image_count(&scatter);
    if images == 0 {
        return Err("Firmware Upgrade plan contains no selected payloads".into());
    }
    let version = if xml { "2.0" } else { "n/a" };

    let before = partition_signature(&mut session.dev);
    let base = scatter_base(path);
    let (source, sink) = scatter_io(&base);
    session
        .dev
        .flash_scatter(&content, source, sink, |_, _| {})
        .map_err(describe)?;
    let after = partition_signature(&mut session.dev);
    let layout_changed = if before == after { "NO" } else { "YES" };

    Ok(format!(
        "FIRMWARE UPGRADE COMPLETE\n\
         ENGINE: {engine}\n\
         FLASH_UPDATE_VERSION: {version}\n\
         \n\
         SCATTER: {path}\n\
         CHECKSUM_LEVEL: NONE\n\
         HOST_CALLBACK_CONTRACT: NONE\n\
         HOST_FILESYSTEM_OPS: NATIVE\n\
         LAYOUT_CHANGED: {layout_changed}\n\
         POSTFLIGHT_PARTITIONS: {}\n\
         AUTO_RELOCK: OFF\n\
         SECCFG_POLICY: PRESERVE\n\
         AUTHORIZED_IMAGES: {images}\n\
         NATIVE_BACKUP_BYTES: 0\n\
         NATIVE_BACKUP_RETAINED_BYTES: 0\n\
         BOOT_SLOT_POLICY: UNCHANGED",
        after.len()
    ))
}

/// `crash`: the engine has no SoC crash primitive, so the verb drops the transport instead —
/// which is what the app uses it for (a DA session it wants abandoned). It is refused while the
/// device is already running a DA.
fn crash() -> Result<String, String> {
    let mut guard = SESSION
        .lock()
        .map_err(|_| "Android persistent session mutex is poisoned".to_string())?;
    let Some(session) = guard.as_ref() else {
        return Err("no active session".into());
    };
    let connection = session.0.dev.get_connection_type();
    if connection == ConnectionType::Da {
        return Err(
            "Penumbra crash is unavailable while the device is already in DA mode. Reboot to \
             Preloader and try again."
                .into(),
        );
    }
    if let Some(mut session) = guard.take() {
        let _ = session.0.dev.port_mut().close();
    }
    let target = match connection {
        ConnectionType::Brom => "BROM",
        _ => "PRELOADER",
    };
    Ok(format!("CRASH TRIGGERED\nTARGET: {target}"))
}

fn with_session<T>(f: impl FnOnce(&mut Session) -> T) -> Result<T, String> {
    let mut guard = SESSION
        .lock()
        .map_err(|_| "Android persistent session mutex is poisoned".to_string())?;
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
/// payloads differ from the cached session rebuilds it.
fn run(verb: &str, operands: &[String], fd: RawFd, da: &str, auth: &str, preloader: &str) -> String {
    if CANCEL.swap(false, Ordering::SeqCst) {
        return describe("cancelled");
    }
    let result = if verb == "crash" {
        crash()
    } else {
        let connection = if verb == "probe" && da.is_empty() {
            ConnectionType::Preloader
        } else {
            ConnectionType::Da
        };
        // `probe` is the handshake-only door: it is exempt from the app's DA requirement.
        let want_da = !da.is_empty() && verb != "probe";
        ensure_session(fd, connection, da, auth, preloader, want_da)
            .and_then(|()| with_session(|session| dispatch(session, verb, operands)))
            .and_then(|payload| payload)
    };
    match result {
        Ok(payload) => format!("OK\n{payload}"),
        Err(message) => {
            if message.starts_with("ERR:") {
                message
            } else {
                describe(message)
            }
        }
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
    // nativeConnectSession's strings are the DA, auth and preloader paths, not a verb.
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
        Err(message) => {
            if message.starts_with("ERR:") {
                message
            } else {
                describe(message)
            }
        }
    };
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
    // JNI_OnLoad receives the JavaVM, not a JNIEnv: the environment has to be fetched from it.
    let jvm = match unsafe { jni::JavaVM::from_raw(vm) } {
        Ok(jvm) => jvm,
        Err(_) => return JNI_VERSION_1_6,
    };
    let mut env = match jvm.get_env() {
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

#[cfg(test)]
mod tests {
    use super::*;

    fn bootctrl_buffer() -> Vec<u8> {
        let mut control = BootControl::default();
        control.set_active_slot(BootPartition::B);
        let mut buffer = vec![0u8; OFFSET_SLOT_SUFFIX + BOOTCONTROL_SIZE];
        control
            .try_write(&mut buffer[OFFSET_SLOT_SUFFIX..])
            .expect("boot-control block encodes");
        buffer
    }

    #[test]
    fn partition_line_matches_the_app_parser() {
        let partition = Partition {
            name: "boot_a".into(),
            size: 0x2000_0000,
            address: 0x8000,
            kind: penumbra_mtk::PartitionKind::Emmc(penumbra_mtk::storage::EmmcPartition::Boot1),
        };
        assert_eq!(
            partition_line(&partition, "EMMC"),
            "boot_a addr=0x8000 size=0x20000000 section=EMMC-BOOT1\n"
        );
    }

    #[test]
    fn bootctrl_block_is_label_for_label() {
        let buffer = bootctrl_buffer();
        let control = BootControl::try_read(&buffer[OFFSET_SLOT_SUFFIX..]).unwrap();
        let text = bootctrl_info_payload("misc", &buffer, &control);
        assert_eq!(
            text,
            "BOOTCTRL\n\
             PARTITION: misc\n\
             OFFSET: 0x800\n\
             SLOT_COUNT: 2\n\
             ACTIVE_SLOT: b\n\
             SUFFIX: _b\n\
             CRC: OK\n\
             SLOT_A_PRIORITY: 14\n\
             SLOT_A_TRIES: 7\n\
             SLOT_A_SUCCESSFUL: 0\n\
             SLOT_A_BOOTABLE: true\n\
             SLOT_A_VERITY: 0\n\
             SLOT_B_PRIORITY: 15\n\
             SLOT_B_TRIES: 7\n\
             SLOT_B_SUCCESSFUL: 0\n\
             SLOT_B_BOOTABLE: true\n\
             SLOT_B_VERITY: 0\n"
        );
    }

    #[test]
    fn reboot_modes_match_the_engine_vocabulary() {
        assert_eq!(boot_mode("").unwrap().1, "normal");
        assert_eq!(boot_mode("normal").unwrap().1, "normal");
        assert_eq!(boot_mode("home-screen").unwrap().1, "home-screen");
        assert_eq!(boot_mode("homescreen").unwrap().1, "home-screen");
        assert_eq!(boot_mode("fastboot").unwrap().1, "fastboot");
        assert_eq!(boot_mode("meta").unwrap().1, "meta");
        assert_eq!(boot_mode("test").unwrap().1, "test");
        assert_eq!(
            boot_mode("recovery").unwrap_err(),
            "Unsupported reboot mode 'recovery'. Use: normal | home-screen | fastboot | meta | test"
        );
    }

    #[test]
    fn scatter_offset_operand_splits_on_tab() {
        assert_eq!(split_offset("boot"), ("boot".to_string(), None));
        assert_eq!(
            split_offset("boot\t1f000"),
            ("boot".to_string(), Some(0x1f000))
        );
    }

    #[test]
    fn scatter_format_is_read_from_the_content() {
        assert!(scatter_is_xml("  \n<partition>"));
        assert!(!scatter_is_xml("- partition_index: SYS0"));
    }

    #[test]
    fn scatter_images_are_counted_only_when_a_file_is_present() {
        let part = |name: &str, size: u64| Partition {
            name: name.into(),
            size,
            address: 0,
            kind: penumbra_mtk::PartitionKind::Unknown,
        };
        let mut scatter = ScatterFile::new();
        scatter.parts.push(penumbra_mtk::da::ScatterPartition::new(
            part("boot_a", 0x2000),
            Some(std::path::PathBuf::from("boot.img")),
            penumbra_mtk::da::ScatterOp::Update,
            true,
            penumbra_mtk::StorageType::Emmc,
            None,
        ));
        // Selected but with no image: nothing to write.
        scatter.parts.push(penumbra_mtk::da::ScatterPartition::new(
            part("userdata", 0x1000),
            None,
            penumbra_mtk::da::ScatterOp::Update,
            true,
            penumbra_mtk::StorageType::Emmc,
            None,
        ));
        // Image present but not selected for download.
        scatter.parts.push(penumbra_mtk::da::ScatterPartition::new(
            part("preloader", 0x4000),
            Some(std::path::PathBuf::from("preloader.bin")),
            penumbra_mtk::da::ScatterOp::Invisible,
            false,
            penumbra_mtk::StorageType::Emmc,
            None,
        ));
        assert_eq!(scatter_image_count(&scatter), 1);
    }
}

