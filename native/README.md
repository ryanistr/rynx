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
command verb against the live session and answer `OK\n<payload>` or `ERR:<message>`.

The payload blocks are a contract with the app's screens, which read them back by label
(`CHIP:`, `SLOT_COUNT:`, `addr=0x`…), so their text and line order are pinned to the reference
engine's own templates — see `../docs/NATIVE-ENGINE-RE.md`.

Implemented verbs — exactly the reference engine's namespace, no aliases of our own:

| Verb | Operands | Action |
| --- | --- | --- |
| `probe` | — | device block |
| `pgpt` | — | partition table |
| `bootctrl-info` | — | boot-control state |
| `bootctrl-set` | slot (`a`/`b`) | patch the active slot, then verify the write back |
| `upload` | partition, path | read a partition out to a file |
| `read-flash` | partition, path | raw flash read to a file |
| `download` | partition[`\t`offset], path | write an image into a partition |
| `scatter-download` | partition[`\t`offset], path | as `download` |
| `write-flash` | partition, path | write an image through the flash path |
| `erase-partition` | partition | erase one partition |
| `erase` | partition | erase through the flash path |
| `seccfg` | `unlock` / `lock` | bootloader lock state |
| `reboot` | `normal`, `home-screen`, `fastboot`, `meta`, `test` | reboot; empty means `normal` |
| `shutdown` | — | power off |
| `crash` | — | drop the session (refused while a DA is live) |
| `scatter-download-v6` | scatter path | flash one XML/V6 package |
| `scatter-firmware-upgrade` | scatter path | protocol gate + flash + layout report |

Every other verb answers `ERR:unsupported command '<verb>'`, so a gap in coverage is
visible in the UI instead of silently doing nothing. The payload text of each verb, and the
evidence it was read from, is in `../docs/NATIVE-ENGINE-RE.md`.

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
- **`crash` has no SoC primitive.** The linked engine exposes no crash command, so the verb
  drops the transport instead of faulting the SoC; it keeps the reference engine's payload and
  its DA-mode refusal. Rationale and the rest of the gap list: `../docs/NATIVE-ENGINE-RE.md`.

## Requirements

- Rust toolchain with the `aarch64-linux-android` target.
- Android NDK (default `/opt/android-sdk/ndk/27.3.13750724`, matching `ndkVersion` in
  `app/build.gradle.kts`).

## Licensing

The engine crates this core links against are AGPL-3.0-or-later; a binary built this way
is a combined work under those terms. See `../CREDITS.md` and `../README.md`.
