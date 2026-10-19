//! Raw usbfs transfers for the app's ADB/Fastboot layer.
//!
//! The Java side opens the USB device and hands over the descriptor, so the usbfs entry points
//! only perform a single transfer on a caller-supplied endpoint. The bulk fastboot verbs are
//! not implemented yet: each one answers with an explicit error instead of pretending.

use std::ffi::c_void;
use std::os::fd::RawFd;

use jni::JNIEnv;
use jni::objects::{JByteArray, JClass, JString};
use jni::sys::{JNIEnv as RawJniEnv, JNI_VERSION_1_6, JavaVM, jboolean, jint, jsize, jstring};

mod ioc {
    pub const BULK: u64 = 0xc018_5502; // _IOWR('U', 2, struct usbdevfs_bulktransfer)
    pub const CLAIMINTERFACE: u64 = 0x8004_550f; // _IOR('U', 15, unsigned int)
    pub const RELEASEINTERFACE: u64 = 0x8004_5510; // _IOR('U', 16, unsigned int)
}

#[repr(C)]
struct BulkTransfer {
    ep: u32,
    len: u32,
    timeout: u32,
    data: *mut c_void,
}

const NOT_IMPLEMENTED: &str = "ERR:fastboot transport is not implemented in this build";

fn ioctl_ptr(fd: RawFd, request: u64, arg: *mut c_void) -> i32 {
    unsafe { libc::ioctl(fd, request as _, arg) }
}

fn ioctl_interface(fd: RawFd, request: u64, interface: i32) -> i32 {
    ioctl_ptr(fd, request, interface as usize as *mut c_void)
}

/// Bulk transfer; returns the byte count or -1.
fn bulk(fd: RawFd, endpoint: u8, data: *mut c_void, len: u32, timeout_ms: u32) -> i32 {
    let mut transfer = BulkTransfer {
        ep: endpoint as u32,
        len,
        timeout: timeout_ms.max(1),
        data,
    };
    let ret = ioctl_ptr(fd, ioc::BULK, &mut transfer as *mut _ as *mut c_void);
    if ret < 0 { -1 } else { ret }
}

fn reply(env: &mut JNIEnv, text: &str) -> jstring {
    match env.new_string(text) {
        Ok(value) => value.into_raw(),
        Err(_) => std::ptr::null_mut(),
    }
}

// ---------------------------------------------------------------------------------------------
// usbfs primitives (implemented)
// ---------------------------------------------------------------------------------------------

/// `nativeUsbfsClaim(fd, interface, timeoutMs) -> 0 on success, -1 on failure`
extern "system" fn usbfs_claim(
    _env: JNIEnv,
    _class: JClass,
    fd: jint,
    interface: jint,
    _timeout_ms: jint,
) -> jint {
    if fd < 0 {
        return -1;
    }
    let ret = ioctl_interface(fd as RawFd, ioc::CLAIMINTERFACE, interface);
    if ret < 0 { -1 } else { 0 }
}

/// `nativeUsbfsRelease(fd, interface)`
extern "system" fn usbfs_release(_env: JNIEnv, _class: JClass, fd: jint, interface: jint) {
    if fd >= 0 {
        let _ = ioctl_interface(fd as RawFd, ioc::RELEASEINTERFACE, interface);
    }
}

/// `nativeUsbfsRead(fd, endpoint, buffer, offset, length, timeoutMs) -> bytesRead`
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
    let mut buf = vec![0u8; len];
    let transferred = bulk(
        fd as RawFd,
        endpoint as u8,
        buf.as_mut_ptr() as *mut c_void,
        len as u32,
        timeout_ms.max(0) as u32,
    );
    if transferred <= 0 {
        return 0;
    }
    let read = transferred as usize;
    let signed: Vec<i8> = buf[..read].iter().map(|byte| *byte as i8).collect();
    if env
        .set_byte_array_region(&buffer, offset as jsize, &signed)
        .is_err()
    {
        return 0;
    }
    transferred
}

/// `nativeUsbfsWrite(fd, endpoint, buffer, offset, length, timeoutMs) -> bytesWritten`
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
    if env
        .get_byte_array_region(&buffer, offset as jsize, &mut raw)
        .is_err()
    {
        return 0;
    }
    let bytes: Vec<u8> = raw.iter().map(|byte| *byte as u8).collect();
    let transferred = bulk(
        fd as RawFd,
        endpoint as u8,
        bytes.as_ptr() as *mut c_void,
        len as u32,
        timeout_ms.max(0) as u32,
    );
    if transferred < 0 { 0 } else { transferred }
}

// ---------------------------------------------------------------------------------------------
// fastboot verbs (not implemented in this build)
// ---------------------------------------------------------------------------------------------

extern "system" fn fastboot_cancel(_env: JNIEnv, _class: JClass) {}

extern "system" fn fastboot_prepare(_env: JNIEnv, _class: JClass) -> jboolean {
    0
}

extern "system" fn fastboot_snapshot(mut env: JNIEnv, _class: JClass, _id: jint) -> jstring {
    reply(&mut env, NOT_IMPLEMENTED)
}

extern "system" fn fastboot_command(
    mut env: JNIEnv,
    _class: JClass,
    _id: jint,
    _first: JString,
) -> jstring {
    reply(&mut env, NOT_IMPLEMENTED)
}

extern "system" fn fastboot_pair(
    mut env: JNIEnv,
    _class: JClass,
    _id: jint,
    _first: JString,
    _second: JString,
) -> jstring {
    reply(&mut env, NOT_IMPLEMENTED)
}

extern "system" fn fastboot_triple(
    mut env: JNIEnv,
    _class: JClass,
    _id: jint,
    _first: JString,
    _second: JString,
    _third: JString,
) -> jstring {
    reply(&mut env, NOT_IMPLEMENTED)
}

#[unsafe(no_mangle)]
pub unsafe extern "system" fn JNI_OnLoad(vm: *mut JavaVM, _reserved: *mut c_void) -> jint {
    let mut env = match unsafe { JNIEnv::from_raw(vm.cast::<RawJniEnv>()) } {
        Ok(env) => env,
        Err(_) => return JNI_VERSION_1_6,
    };
    let class: JClass = match env.find_class("com/rynx/app/adbfastboot/AdbFastbootNative") {
        Ok(class) => class,
        Err(_) => return JNI_VERSION_1_6,
    };
    let methods = [
        (
            "nativeFastbootCancel",
            "()V",
            fastboot_cancel as *mut c_void,
        ),
        (
            "nativeFastbootCommand",
            "(ILjava/lang/String;)Ljava/lang/String;",
            fastboot_command as *mut c_void,
        ),
        (
            "nativeFastbootFetch",
            "(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            fastboot_pair as *mut c_void,
        ),
        (
            "nativeFastbootFileCommand",
            "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            fastboot_triple as *mut c_void,
        ),
        (
            "nativeFastbootPrepare",
            "()Z",
            fastboot_prepare as *mut c_void,
        ),
        (
            "nativeFastbootReceiveCommand",
            "(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            fastboot_pair as *mut c_void,
        ),
        (
            "nativeFastbootSnapshot",
            "(I)Ljava/lang/String;",
            fastboot_snapshot as *mut c_void,
        ),
        ("nativeUsbfsClaim", "(III)I", usbfs_claim as *mut c_void),
        ("nativeUsbfsRead", "(II[BII)I", usbfs_read as *mut c_void),
        (
            "nativeUsbfsRelease",
            "(II)V",
            usbfs_release as *mut c_void,
        ),
        ("nativeUsbfsWrite", "(II[BII)I", usbfs_write as *mut c_void),
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
