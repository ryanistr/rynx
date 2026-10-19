# Native core

The app is the front half of a MediaTek service tool: it drives the USB device, owns
the screens and the flows, and calls into a native core that speaks the actual
protocols. That core is not in this repository yet — see `../docs/PARITY.md` for the
JNI contract it has to satisfy and the capability checklist.

## Shape of the core

Three `arm64-v8a` libraries:

| Library | Registers natives on | Methods |
| --- | --- | --- |
| `librynx_core.so` | `com.rynx.app.MainActivity` | 8 (session, command dispatch, USB fd, Xiaomi SLA generation) |
| `librynx_adbfastboot.so` | `com.rynx.app.adbfastboot.AdbFastbootNative` | 11 (fastboot verbs + raw usbfs claim/read/write/release) |
| `librynx_guard.so` | `com.rynx.app.security.NativeAssetGate` | 2 (protected-container open, signer check) |

The third is optional: it exists to keep a prebuilt engine inside an encrypted
container in `assets/`. A core built from source is shipped as an ordinary
`jniLibs/arm64-v8a/` library and needs no container.

## Build plan

1. Add the engine crate (credited in `../CREDITS.md`) as a dependency of a new
   workspace member, e.g. `native/core/`.
2. Implement the `usbfs` transport backend over the fd handed in by
   `nativeSetUsbFd` — control and bulk transfers with timeout and cancellation.
3. Write the JNI bridge: `JNI_OnLoad` + `RegisterNatives` for the 19 methods of
   `../docs/PARITY.md` §2, under the `com.rynx.app.*` class paths.
4. Cross-compile for `aarch64-linux-android` (NDK r27c or newer) and place the
   `.so` files under `app/src/main/jniLibs/arm64-v8a/`.

## Requirements

- Rust toolchain with the `aarch64-linux-android` target.
- Android NDK r27c or newer (matching `ndkVersion` in `app/build.gradle.kts`).
- `cargo-ndk` or an equivalent `CC_aarch64_linux_android` / linker setup.

## Licensing

The engine crates are AGPL-3.0-or-later; linking them makes the whole distributed
binary AGPL-3.0-or-later. Settle the repository licence before adding core code —
see `../README.md`.
