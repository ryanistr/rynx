# Rynx

Rynx is a free and open-source **Android MediaTek service flash tool**: partition reads, backups and
flashes, scatter firmware, BootROM/DA service flows, plus ADB and Fastboot helpers, in a plain
text-first interface.

Licensed under the Apache License 2.0 - see [LICENSE](LICENSE).

## Status

This is the application half of the tool. All screens and flows are implemented
(`app/src/main/java`), covering the flash tool, Xiaomi authorization, partition manager,
bootloader, ADB & Fastboot and power screens.

The native core that performs the actual USB, BootROM, Download Agent and Fastboot work is not part
of the repository yet, so the device flows are inert and the app has nothing to call. What that core
has to provide is written down as a contract and a checklist in
[docs/PARITY.md](docs/PARITY.md); the build plan is in [native/README.md](native/README.md).

## Layout

    app/src/main/AndroidManifest.xml
    app/src/main/java/com/rynx/app/       entry point, UI, USB + flashing logic
    app/src/main/res/                     strings (en, in), colours, styles, vector icons
    docs/PARITY.md                        native ABI contract + capability checklist
    docs/NATIVE-COMMANDS.md               command namespace the app drives
    docs/NATIVE-ENGINE-RE.md              reference-engine verb set and payload contract
    native/README.md                      the native core: transport, session, dispatch
    CREDITS.md                            third-party projects this tool builds on

## Requirements

* JDK 17 or newer
* Android SDK platform 35 and build-tools 35
* Gradle 8.13 (see `gradle/wrapper/gradle-wrapper.properties`)
* For the native core: a Rust toolchain with the `aarch64-linux-android` target and NDK r27c or newer

## Build

    echo "sdk.dir=$ANDROID_HOME" > local.properties
    gradle wrapper --gradle-version 8.13     # once, to add the wrapper scripts
    ./gradlew :app:assembleDebug

## Roadmap

* build the native core described in `docs/PARITY.md`
* replace the placeholder UI with a designed one
* fill in the project links - the update feed and the community/donate links are placeholders
  (`res/values/strings.xml`, `res/values-in/strings.xml`, `x/iivesaq.java`)

## Credits

Protocol work, Download Agent payloads and reference behaviour come from other open-source
projects. They are listed with their authors and licences in [CREDITS.md](CREDITS.md).

## License

Copyright 2026 Rynx contributors. Licensed under the Apache License, Version 2.0.

Note on scope: the engine crates the native core will link are AGPL-3.0-or-later, and a binary that
links them is a combined work distributed under AGPL-3.0-or-later as a whole. The repository licence
and the core are therefore being settled together - see [CREDITS.md](CREDITS.md).
