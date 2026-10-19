//! ADB/Fastboot layer: usbfs transport, the fastboot conversation and the JNI door.
//!
//! The app opens the USB device itself and hands over the descriptor, so everything here runs on a
//! caller-supplied fd: descriptor discovery, one claimed interface, bulk transfers, and the fastboot
//! status/`DATA` framing on top. Results are `OK\n<payload>` or `ERROR\n<message>` — the screens test
//! `startsWith("OK\n")` and strip a leading `ERROR\n`.

use std::ffi::c_void;
use std::os::fd::RawFd;
use std::path::PathBuf;
use std::sync::atomic::{AtomicBool, AtomicPtr, Ordering};
use std::sync::Mutex;

use jni::JNIEnv;
use jni::objects::{JByteArray, JClass, JString, JValue};
use jni::sys::{JNI_VERSION_1_6, JavaVM, jboolean, jint, jsize, jstring};

mod proto;
mod sparse;
mod wire;

use proto::Channel;
use wire::{Endpoints, UsbfsWire};

const FASTBOOT_TIMEOUT_MS: u32 = 30_000;

/// The app's `teupdsw()` gate: one fastboot worker at a time, `false` while one is still running.
static BUSY: AtomicBool = AtomicBool::new(false);
/// Set by `nativeFastbootCancel`, observed between transfers.
static CANCEL: AtomicBool = AtomicBool::new(false);
static IN_FLIGHT: AtomicBool = AtomicBool::new(false);
static JVM: AtomicPtr<JavaVM> = AtomicPtr::new(std::ptr::null_mut());

struct Transport {
    fd: RawFd,
    endpoints: Endpoints,
}

static TRANSPORT: Mutex<Option<Transport>> = Mutex::new(None);

struct Operation;

impl Operation {
    fn begin() -> Self {
        IN_FLIGHT.store(true, Ordering::SeqCst);
        Self
    }
}

impl Drop for Operation {
    fn drop(&mut self) {
        IN_FLIGHT.store(false, Ordering::SeqCst);
        BUSY.store(false, Ordering::SeqCst);
    }
}

fn reply(env: &mut JNIEnv, text: &str) -> jstring {
    match env.new_string(text) {
        Ok(value) => value.into_raw(),
        Err(_) => std::ptr::null_mut(),
    }
}

fn ok(payload: &str) -> String {
    format!("OK\n{payload}")
}

fn error(message: &str) -> String {
    format!("ERROR\n{message}")
}

fn argument(env: &mut JNIEnv, value: &JString) -> String {
    env.get_string(value)
        .map(|text| text.to_string_lossy().into_owned())
        .unwrap_or_default()
}

fn path_of(env: &mut JNIEnv, value: &JString) -> PathBuf {
    PathBuf::from(argument(env, value))
}

/// Post one progress line to `AdbFastbootNative.onNativeFastbootEvent`.
fn emit(text: &str) {
    let pointer = JVM.load(Ordering::SeqCst);
    if pointer.is_null() {
        return;
    }
    // SAFETY: the pointer is the JavaVM handed to JNI_OnLoad and lives as long as the process.
    let Ok(vm) = (unsafe { jni::JavaVM::from_raw(pointer) }) else {
        return;
    };
    let Ok(mut env) = vm.attach_current_thread() else {
        return;
    };
    let Ok(message) = env.new_string(text) else {
        return;
    };
    let _ = env.call_static_method(
        "com/rynx/app/adbfastboot/AdbFastbootNative",
        "onNativeFastbootEvent",
        "(Ljava/lang/String;)V",
        &[JValue::Object(&message)],
    );
}

/// Claim the interface once per descriptor and remember the endpoint pair.
fn prepare_transport(fd: RawFd) -> Result<Endpoints, String> {
    if fd < 0 {
        return Err("Fastboot USB FD unavailable".into());
    }
    {
        let guard = TRANSPORT.lock().map_err(|_| "Recovering poisoned Fastboot operation mutex".to_string())?;
        if let Some(existing) = guard.as_ref()
            && existing.fd == fd
        {
            return Ok(existing.endpoints);
        }
    }
    let endpoints = wire::discover(fd).unwrap_or(Endpoints {
        interface: 0,
        ep_in: 0x81,
        ep_out: 0x01,
    });
    if !wire::claim_interface(fd, endpoints.interface as i32) {
        return Err(format!("Unable to claim Fastboot usbfs interface: {}", endpoints.interface));
    }
    let mut guard = TRANSPORT.lock().map_err(|_| "Recovering poisoned Fastboot operation mutex".to_string())?;
    *guard = Some(Transport { fd, endpoints });
    Ok(endpoints)
}

fn with_channel<T>(fd: RawFd, body: impl FnOnce(&mut Channel<UsbfsWire>) -> Result<T, String>) -> Result<T, String> {
    let endpoints = prepare_transport(fd)?;
    let mut channel = Channel::new(UsbfsWire::new(fd, endpoints, FASTBOOT_TIMEOUT_MS), FASTBOOT_TIMEOUT_MS);
    let result = body(&mut channel);
    // `INFO` frames are the target's own progress messages; pass them to the screen as events.
    for line in channel.info_lines() {
        emit(&format!("[fastboot] {line}"));
    }
    result
}

/// Run one operation with the transport guard, the cancel flag and the OK/ERROR envelope.
fn run(body: impl FnOnce() -> Result<String, String>) -> String {
    let _operation = Operation::begin();
    CANCEL.store(false, Ordering::SeqCst);
    let result = body();
    CANCEL.store(false, Ordering::SeqCst);
    match result {
        Ok(payload) => ok(&payload),
        Err(message) => error(&message),
    }
}

// ---------------------------------------------------------------------------------------------
// fastboot verbs
// ---------------------------------------------------------------------------------------------

extern "system" fn fastboot_prepare(_env: JNIEnv, _class: JClass) -> jboolean {
    // The app calls this before every worker: `false` means a previous one is still running.
    BUSY.compare_exchange(false, true, Ordering::SeqCst, Ordering::SeqCst).is_ok() as jboolean
}

extern "system" fn fastboot_cancel(_env: JNIEnv, _class: JClass) {
    CANCEL.store(true, Ordering::SeqCst);
    if !IN_FLIGHT.load(Ordering::SeqCst) {
        BUSY.store(false, Ordering::SeqCst);
        CANCEL.store(false, Ordering::SeqCst);
    }
}

extern "system" fn fastboot_snapshot(mut env: JNIEnv, _class: JClass, fd: jint) -> jstring {
    let text = run(|| with_channel(fd as RawFd, |channel| proto::snapshot(channel)));
    reply(&mut env, &text)
}

extern "system" fn fastboot_command(mut env: JNIEnv, _class: JClass, fd: jint, command: JString) -> jstring {
    let command = argument(&mut env, &command);
    emit(&format!("[fastboot] {command}"));
    let text = run(|| with_channel(fd as RawFd, |channel| proto::command(channel, &command)));
    reply(&mut env, &text)
}

#[allow(clippy::too_many_arguments)]
extern "system" fn fastboot_file_command(
    mut env: JNIEnv,
    _class: JClass,
    fd: jint,
    action: JString,
    partition: JString,
    path: JString,
) -> jstring {
    let action = argument(&mut env, &action);
    let partition = argument(&mut env, &partition);
    let path = path_of(&mut env, &path);
    emit(&format!("[fastboot] {action} {partition} {}", path.display()));
    let text = run(|| {
        with_channel(fd as RawFd, |channel| {
            let mut progressed = 0u64;
            let mut progress = |sent: u64, total: u64| {
                // One event per 5% keeps the UI informed without flooding the binder.
                let step = (total / 20).max(1);
                if sent >= progressed + step || sent == total {
                    progressed = sent;
                    emit(&format!("[fastboot] {} {partition} {sent}/{total}", action));
                }
            };
            proto::file_command(channel, &action, &partition, &path, &CANCEL, &mut progress)
        })
    });
    reply(&mut env, &text)
}

extern "system" fn fastboot_fetch(mut env: JNIEnv, _class: JClass, fd: jint, partition: JString, path: JString) -> jstring {
    let partition = argument(&mut env, &partition);
    let path = path_of(&mut env, &path);
    emit(&format!("[fastboot] fetch {partition} -> {}", path.display()));
    let text = run(|| {
        with_channel(fd as RawFd, |channel| {
            proto::fetch(channel, &partition, &path, &CANCEL, &mut |_, _| {})
        })
    });
    reply(&mut env, &text)
}

extern "system" fn fastboot_receive(mut env: JNIEnv, _class: JClass, fd: jint, command: JString, path: JString) -> jstring {
    let command = argument(&mut env, &command);
    let path = path_of(&mut env, &path);
    emit(&format!("[fastboot] {command} -> {}", path.display()));
    let text = run(|| {
        with_channel(fd as RawFd, |channel| {
            proto::receive_command(channel, &command, &path, &CANCEL, &mut |_, _| {})
        })
    });
    reply(&mut env, &text)
}

// ---------------------------------------------------------------------------------------------
// raw usbfs primitives, used directly by the ADB layer
// ---------------------------------------------------------------------------------------------

extern "system" fn usbfs_claim(_env: JNIEnv, _class: JClass, fd: jint, interface: jint, _timeout_ms: jint) -> jint {
    if fd < 0 {
        return -1;
    }
    if wire::claim_interface(fd as RawFd, interface) { 0 } else { -1 }
}

extern "system" fn usbfs_release(_env: JNIEnv, _class: JClass, fd: jint, interface: jint) {
    if fd >= 0 {
        wire::release_interface(fd as RawFd, interface);
        if let Ok(mut guard) = TRANSPORT.lock() {
            *guard = None;
        }
    }
}

extern "system" fn usbfs_read(
    env: JNIEnv,
    _class: JClass,
    fd: jint,
    endpoint: jint,
    buffer: JByteArray,
    offset: jint,
    length: jint,
    timeout_ms: jint,
) -> jint {
    if fd < 0 || length <= 0 {
        return 0;
    }
    let len = length as usize;
    let mut raw = vec![0u8; len];
    let transferred = wire::bulk(
        fd as RawFd,
        endpoint as u8,
        raw.as_mut_ptr() as *mut c_void,
        len as u32,
        timeout_ms.max(0) as u32,
    );
    if transferred <= 0 {
        return 0;
    }
    let read = transferred as usize;
    let signed: Vec<i8> = raw[..read].iter().map(|byte| *byte as i8).collect();
    if env.set_byte_array_region(&buffer, offset as jsize, &signed).is_err() {
        return 0;
    }
    transferred
}

extern "system" fn usbfs_write(
    env: JNIEnv,
    _class: JClass,
    fd: jint,
    endpoint: jint,
    buffer: JByteArray,
    offset: jint,
    length: jint,
    timeout_ms: jint,
) -> jint {
    if fd < 0 || length <= 0 {
        return 0;
    }
    let len = length as usize;
    let mut raw = vec![0i8; len];
    if env.get_byte_array_region(&buffer, offset as jsize, &mut raw).is_err() {
        return 0;
    }
    let bytes: Vec<u8> = raw.iter().map(|byte| *byte as u8).collect();
    let transferred = wire::bulk(
        fd as RawFd,
        endpoint as u8,
        bytes.as_ptr() as *mut c_void,
        len as u32,
        timeout_ms.max(0) as u32,
    );
    if transferred < 0 { 0 } else { transferred }
}

#[unsafe(no_mangle)]
pub unsafe extern "system" fn JNI_OnLoad(vm: *mut JavaVM, _reserved: *mut c_void) -> jint {
    // JNI_OnLoad receives the JavaVM, not a JNIEnv: the environment has to be fetched from it.
    let jvm = match unsafe { jni::JavaVM::from_raw(vm) } {
        Ok(jvm) => jvm,
        Err(_) => return JNI_VERSION_1_6,
    };
    let mut env = match jvm.get_env() {
        Ok(env) => env,
        Err(_) => return JNI_VERSION_1_6,
    };
    let class: JClass = match env.find_class("com/rynx/app/adbfastboot/AdbFastbootNative") {
        Ok(class) => class,
        Err(_) => return JNI_VERSION_1_6,
    };
    JVM.store(vm, Ordering::SeqCst);
    let methods = [
        ("nativeFastbootCancel", "()V", fastboot_cancel as *mut c_void),
        (
            "nativeFastbootCommand",
            "(ILjava/lang/String;)Ljava/lang/String;",
            fastboot_command as *mut c_void,
        ),
        (
            "nativeFastbootFetch",
            "(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            fastboot_fetch as *mut c_void,
        ),
        (
            "nativeFastbootFileCommand",
            "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            fastboot_file_command as *mut c_void,
        ),
        (
            "nativeFastbootPrepare",
            "()Z",
            fastboot_prepare as *mut c_void,
        ),
        (
            "nativeFastbootReceiveCommand",
            "(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            fastboot_receive as *mut c_void,
        ),
        (
            "nativeFastbootSnapshot",
            "(I)Ljava/lang/String;",
            fastboot_snapshot as *mut c_void,
        ),
        ("nativeUsbfsClaim", "(III)I", usbfs_claim as *mut c_void),
        ("nativeUsbfsRead", "(II[BIII)I", usbfs_read as *mut c_void),
        ("nativeUsbfsRelease", "(II)V", usbfs_release as *mut c_void),
        ("nativeUsbfsWrite", "(II[BIII)I", usbfs_write as *mut c_void),
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
    JNI_VERSION_1_6
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn payload_envelope_matches_the_screen_check() {
        assert_eq!(ok("STATUS: OKAY"), "OK\nSTATUS: OKAY");
        assert_eq!(error("boom"), "ERROR\nboom");
        assert!(ok("x").starts_with("OK\n"));
        assert!(!error("x").starts_with("OK\n"));
    }

    #[test]
    fn prepare_is_a_single_worker_lease() {
        BUSY.store(false, Ordering::SeqCst);
        IN_FLIGHT.store(false, Ordering::SeqCst);
        assert!(BUSY.compare_exchange(false, true, Ordering::SeqCst, Ordering::SeqCst).is_ok());
        assert!(BUSY.compare_exchange(false, true, Ordering::SeqCst, Ordering::SeqCst).is_err());
        let operation = Operation::begin();
        drop(operation);
        assert!(!BUSY.load(Ordering::SeqCst));
    }
}
