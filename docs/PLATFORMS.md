# Platform support

The goal is one tool on three targets: **Android** (the only one shipped today), **Linux** and
**Windows** (planned). Almost all of the code is platform-independent already, because the split
between the transport and everything above it is explicit.

| Layer | Where | Platform-specific? |
| --- | --- | --- |
| Transport | `native/usbfs`, `native/adbfastboot/src/wire.rs` | **yes** — the only layer that has to change |
| Session, command dispatch, payload text | `native/core/src/lib.rs` (`run`, `dispatch`, `build_session`, `ensure_session`) | no — takes an `fd` and `&str`/`&[String]`, returns `String` |
| JNI door | `JNI_OnLoad` + `RegisterNatives` in both crates | Android only — a desktop build has its own entry point |

`native/core/src/lib.rs` names the swap point:

    pub type Port = UsbfsPort;

The session and every command are written against that alias. Retargeting a build means pointing the
alias at another transport; the command namespace and the payload labels stay identical, so the
same payload text is parsed the same way on every platform.

## Android (shipped)

* The app opens the device through the platform USB API and hands the open file descriptor to the
  core (`nativeSetUsbFd`). Everything after that is `USBDEVFS_CONTROL` / `USBDEVFS_BULK` /
  `USBDEVFS_CLAIMINTERFACE` ioctls on that descriptor — no USB permission, enumeration or
  descriptor parsing is done natively.
* Built for `aarch64-linux-android` with the NDK (`native/build.sh`, API 26 by default) into
  `app/src/main/jniLibs/arm64-v8a/librynx_core.so` and `librynx_adbfastboot.so`.
* The engine crate requires exactly one of its `nusb` / `libusb` / `serial` port backends — its own
  `compile_error!` otherwise — and `nusb`'s `list_devices()` is gated to
  `linux | macos | windows | wasm32`, so it cannot build for Android. The workspace therefore
  selects `serial` (the one backend that stays compilable for this target) and drives the
  descriptor through its own transport instead of using a backend of the engine's.
* Verified: both libraries are mapped into a running app process
  (`/proc/<pid>/maps` → `/data/app/…/lib/arm64/librynx_core.so`, `…librynx_adbfastboot.so`); the
  workspace cross-compiles with no warnings; the payload and protocol layers pass `cargo test`.
* Not verified: no USB session has been opened against a MediaTek target — this machine has no such
  device on USB.

## Linux

* What is already true: the ioctl set the transport uses is the Linux kernel's own usbfs ABI. The
  constants in `native/usbfs/src/lib.rs` and `adbfastboot/src/wire.rs` were cross-checked against
  `/usr/include/linux/usbdevice_fs.h`, so the same transport code runs on a desktop Linux where the
  descriptor comes from opening `/dev/bus/usb/<bus>/<device>` instead of from the app.
* What a Linux build needs: a host entry point (CLI or desktop UI) in place of the JNI door, and a
  `build.sh` target for the host triple. The engine's own `nusb` and `libusb` backends are also
  available on this platform as an alternative transport, and either can be dropped in behind the
  `Port` alias.
* Not started. The ioctl path itself is exercised only by the unit tests that run without hardware.

## Windows

* No file descriptor and no `USBDEVFS`: the transport has to own a device handle rather than read
  a caller-supplied one, so this is a new backend behind the `Port` alias, not a variation of the
  current one. The two candidate routes are the engine's `nusb` backend (its Windows backend) or
  `libusb`; JNI is not involved either way.
* Not started.

## Scope today

Android is the only shipped target, and the tool is built and validated as an Android app. Linux
and Windows are recorded here so the boundary stays honest: the layers above the transport are
already platform-neutral, and the transport is the work.
