# Rynx

Rynx is a free and open-source **Android MediaTek service flash tool**: partition reads, backups and
flashes, scatter firmware, BootROM/DA service flows, plus ADB and Fastboot helpers, in a plain
text-first interface.

Licensed under the Apache License 2.0 - see [LICENSE](LICENSE).

## Status

Both halves are in the repository.

* **App layer** — `app/src/main/java`: all screens and flows (flash tool, Xiaomi authorization,
  partition manager, bootloader, ADB & Fastboot, power), the USB permission handling and the
  ADB/Fastboot orchestration.
* **Native core** — `native/`: a Rust workspace that builds two `arm64-v8a` libraries,
  `librynx_core.so` (BootROM/Preloader handshake, Download Agent upload, storage and partition
  operations, scatter flashing, boot-control, security config) and `librynx_adbfastboot.so`
  (fastboot conversation and the raw `usbfs` transport). The app loads them with
  `System.loadLibrary` and both are mapped into the running process.

The engine protocols are not reimplemented here; the core links an open-source MediaTek engine
family and supplies the transport, the session and the command layer around it — see
[CREDITS.md](CREDITS.md). The ABI contract between the two halves is in
[docs/PARITY.md](docs/PARITY.md), the command namespace in
[docs/NATIVE-COMMANDS.md](docs/NATIVE-COMMANDS.md), and the build plan in
[native/README.md](native/README.md).

### Verified

* The app builds, installs, launches and stays up, with `librynx_core.so` and
  `librynx_adbfastboot.so` mapped from `/data/app/.../lib/arm64/` (`/proc/<pid>/maps`).
* The native core and the fastboot layer compile warning-free for `aarch64-linux-android`, and
  their payload layers pass `cargo test`.

### Not verified

* No USB/Download-Agent flow has been exercised against a device: there is no MediaTek target in
  BootROM or preloader mode on this machine's USB. Every USB path is compile-, API- and
  unit-verified only.

## Layout

    app/src/main/AndroidManifest.xml
    app/src/main/java/com/rynx/app/       entry point, UI, USB + flashing logic
    app/src/main/res/                     strings (en, in), colours, styles, vector icons
    docs/PARITY.md                        native ABI contract + capability checklist
    docs/NATIVE-COMMANDS.md               command namespace the app drives
    docs/NATIVE-ENGINE-RE.md              reference-engine verb set and payload contract
    docs/PLATFORMS.md                     what each target platform needs from the core
    native/README.md                      the native core: transport, session, dispatch
    CREDITS.md                            third-party projects this tool builds on

## Requirements

* JDK 17 or newer
* Android SDK platform 35 and build-tools 35
* Gradle 8.13 (see `gradle/wrapper/gradle-wrapper.properties`)
* For the native core: a Rust toolchain with the `aarch64-linux-android` target and NDK r27c or newer

## Build

With Gradle:

    echo "sdk.dir=$ANDROID_HOME" > local.properties
    gradle wrapper --gradle-version 8.13     # once, to add the wrapper scripts
    ./gradlew :app:assembleDebug

Without Gradle — the path the verified builds in [docs/PARITY.md](docs/PARITY.md) used — the SDK
tools are enough:

    native/build.sh        # cross-compile librynx_core.so and librynx_adbfastboot.so
    tools/build-apk.sh     # -> build-apk/rynx-debug.apk, signed with the debug keystore

`tools/build-apk.sh` drives aapt2, javac, d8, zipalign and apksigner itself and takes an output
directory as its first argument. It reads `ANDROID_HOME` (falling back to `~/Android/Sdk`) and signs
with `RYNX_KEYSTORE` if set, otherwise `~/.android/debug.keystore`.

## Roadmap

* **Platforms.** Android is the only shipped target today: the core builds for `arm64-v8a` and
  talks to devices through the app's own USB file descriptor. Linux and Windows are goals for the
  desktop half of the tool — the transport is the only layer that has to change, and the engine,
  session and command layers are already transport-agnostic. [docs/PLATFORMS.md](docs/PLATFORMS.md)
  records what each target needs and which parts are already platform-independent.
* Replace the placeholder UI with a designed one.
* Fill in the project links — the update feed and the community/donate links are placeholders
  (`res/values/strings.xml`, `res/values-in/strings.xml`, `x/iivesaq.java`).

## Credits

Protocol work, Download Agent payloads and reference behaviour come from other open-source
projects. They are listed with their authors and licences in [CREDITS.md](CREDITS.md).

## License

Copyright 2026 Rynx contributors. Licensed under the Apache License, Version 2.0.

Note on scope: the engine crates the native core will link are AGPL-3.0-or-later, and a binary that
links them is a combined work distributed under AGPL-3.0-or-later as a whole. The repository licence
and the core are therefore being settled together - see [CREDITS.md](CREDITS.md).
