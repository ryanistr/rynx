# Rynx

Rynx is a free and open-source **Android MediaTek service flash tool**: partition reads, backups and
flashes, scatter firmware, BootROM/DA service flows, plus ADB and Fastboot helpers, in a plain
text-first interface.

Licensed under the Apache License 2.0 - see [LICENSE](LICENSE).

## Status

Early scaffold. This first commit is the plain starting point: the UI is text plus generic
vector icons, and the native USB / ADB / Fastboot core is not part of the repository yet, so the
core-loading screen reports that a component could not be loaded and the device flows are inert.

## Layout

    app/src/main/AndroidManifest.xml
    app/src/main/java/com/rynx/app/       entry point, UI, USB + flashing logic
    app/src/main/res/                     strings (en, in), colours, styles, vector icons

## Requirements

* JDK 17 or newer
* Android SDK platform 35 and build-tools 35
* Gradle 8.13 (see `gradle/wrapper/gradle-wrapper.properties`)

## Build

    echo "sdk.dir=$ANDROID_HOME" > local.properties
    gradle wrapper --gradle-version 8.13     # once, to add the wrapper scripts
    ./gradlew :app:assembleDebug

## Roadmap

* implement the native USB / ADB / Fastboot core
* replace the placeholder UI with a designed one
* fill in the project links - the update feed and the community/donate links are placeholders
  (`res/values/strings.xml`, `res/values-in/strings.xml`, `x/iivesaq.java`)

## License

Copyright 2026 Rynx contributors. Licensed under the Apache License, Version 2.0.
