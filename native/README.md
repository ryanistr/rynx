# Native core

The app is the front half of a MediaTek service tool: it drives the USB device, owns
the screens and the flows, and calls into a native core that speaks the actual
protocols. This directory holds that core as a Cargo workspace, plus the transport it
needs because Android hands out a raw file descriptor instead of a USB handle.

```
native/
  usbfs/        transport: USBDEVFS_* transfers, implements the engine's MtkPort trait
  core/         session, command dispatch, JNI_OnLoad for com.rynx.app.MainActivity
  adbfastboot/  raw usbfs transfers + fastboot verbs for AdbFastbootNative
  build.sh      cross-compile for arm64-v8a and install into app/src/main/jniLibs/
```

`librynx_guard.so` (see `../docs/PARITY.md` §2) is not part of this workspace: it only
exists to keep a prebuilt engine inside an encrypted container. A core built from
source ships as an ordinary `jniLibs/arm64-v8a/` library and needs no container.

## Build

```
native/build.sh            # release build, installs the .so files into the app module
native/build.sh check      # compile-check only
```

The script sets `CARGO_TARGET_AARCH64_LINUX_ANDROID_LINKER` and the `CC_`/`AR_`/`CFLAGS_`
variables from the NDK and builds for `aarch64-linux-android` with `API_LEVEL` (default
26). Override the toolchain location with `ANDROID_NDK_HOME`. Built libraries and
`native/target/` are not committed.

## What the core does

`nativeSetUsbFd` stores the descriptor the app opened. `nativeConnectSession` then builds
a device session on it — endpoint pair discovered from the configuration descriptor, DA /
preloader / SLA payloads read from the operand paths, BROM/preloader handshake, and DA mode
when a DA payload was supplied. `nativeRunCommand` and `nativeRunGuiAction` dispatch a
command verb against the live session and answer `OK\n<payload>` or an error string.

Implemented verbs:

| Verb | Operands | Action |
| --- | --- | --- |
| `device-info` | — | device info dump |
| `partitions`, `pgpt`, `list-partitions` | — | partition table as JSON (`name`, `size`, `address`, `kind`) |
| `bootctrl-info` | — | boot control state |
| `read-partition` | name, path | read a partition to a file |
| `write-partition` | name, path | write a file into a partition |
| `erase-partition` | name | erase a partition |
| `read-flash`, `write-flash`, `erase-flash` | name[, path] | same, through the flash path |
| `read-efuses` | path | efuse dump to a file |
| `read-register`, `write-register` | address[, value] | register access (hex operands) |
| `reboot` | mode | `normal`, `home`, `fastboot`, `test`, `meta` |
| `shutdown` | — | shut the device down |

Every other verb answers `ERR:unsupported command '<verb>'`, so a gap in coverage is
visible in the UI instead of silently doing nothing.

## Constraints worth knowing

- **One session at a time, one thread at a time.** The engine's device object keeps an
  `Rc` device-info cell and is not `Send`; the session lives behind a single mutex and
  `SendSession` asserts that only one thread reaches it.
- **Payloads are leaked per connect.** The engine borrows the DA/preloader/SLA buffers for
  the session's lifetime and the Java side supplies paths, so each connect leaks those
  buffers (a few megabytes at most) until the process exits.
- **Cancellation is not mid-transfer.** `nativeCancelIo` sets a flag that stops the next
  command; the engine's progress callback cannot abort an in-flight transfer.
- **The fastboot verbs are not implemented.** `nativeUsbfsClaim/Read/Write/Release` are
  real; the seven `nativeFastboot*` entries answer
  `ERR:fastboot transport is not implemented in this build`.

## Requirements

- Rust toolchain with the `aarch64-linux-android` target.
- Android NDK (default `/opt/android-sdk/ndk/27.3.13750724`, matching `ndkVersion` in
  `app/build.gradle.kts`).

## Licensing

The engine crates this core links against are AGPL-3.0-or-later; a binary built this way
is a combined work under those terms. See `../CREDITS.md` and `../README.md`.
