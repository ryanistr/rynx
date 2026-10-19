# Feature parity ledger

What a complete MediaTek service flash tool has to do, and where each piece lives in
this repository. Two layers are tracked separately, because they are delivered by
different build systems and have different completion states.

| Layer | What it covers | State |
| --- | --- | --- |
| App layer (Java) | UI, screen flows, USB permission handling, ADB/Fastboot orchestration, update feed | present |
| Native core (`arm64-v8a` `.so`) | BROM/Preloader handshake, DA upload and DA protocols, storage and partition operations, SLA signing, ADB/Fastboot protocol | **not in this repository yet** |

The app layer and the native core talk over a fixed JNI contract; that contract is
recorded in section 2 and is the checklist for the core.

## 1. App layer

`app/src/main/java` holds the full application source: the five tool screens plus the
navigation shell, the ADB/Fastboot screen, the security/loader classes and the
obfuscated support package `x`. The screen set observed on a running build is
FLASH TOOL, XIAOMI AUTHORIZATION, PARTITION MANAGER, BOOTLOADER, ADB & FASTBOOT,
POWER, plus the bottom navigation bar.

## 2. Native ABI contract

Three libraries make up the core. Every Java-visible entry point is registered from
`JNI_OnLoad` with `RegisterNatives`, so the exported symbol table of each library
contains only `JNI_OnLoad`; the names below are the registration strings.

### 2.1 `librynx_core.so` — registered against `com.rynx.app.MainActivity`

| Method | JNI signature | Arguments |
| --- | --- | --- |
| `nativeCancelIo` | `()V` | cancel the in-flight operation |
| `nativeConnectSession` | `(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;` | mode, timeout, three request strings |
| `nativeDisconnectSession` | `()V` | tear down the DA session |
| `nativeHasSession` | `()Z` | session-present probe |
| `nativeRunCommand` | `(IJLjava/lang/String;×5)Ljava/lang/String;` | command id, timeout, five argument strings |
| `nativeRunGuiAction` | `(IJLjava/lang/String;×5)Ljava/lang/String;` | UI action id, timeout, five argument strings |
| `nativeSetUsbFd` | `(I)J` | hand the open USB file descriptor to the core |
| `nativeSetXiaomiAuthGeneration` | `(I)V` | select the BROM SLA key generation |

`nativeRunCommand` and `nativeRunGuiAction` take the same shape: an integer
dispatch id, a `long` timeout, then five `String` operands. The dispatch ids are the
core's command/action namespace, so the core decides which ids exist.

### 2.2 `librynx_adbfastboot.so` — registered against `com.rynx.app.adbfastboot.AdbFastbootNative`

Static natives:

| Method | JNI signature |
| --- | --- |
| `nativeFastbootPrepare` | `()Z` |
| `nativeFastbootCommand` | `(ILjava/lang/String;)Ljava/lang/String;` |
| `nativeFastbootFetch` | `(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;` |
| `nativeFastbootReceiveCommand` | `(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;` |
| `nativeFastbootFileCommand` | `(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;` |
| `nativeFastbootSnapshot` | `(I)Ljava/lang/String;` |
| `nativeFastbootCancel` | `()V` |

The same library also exposes the raw transport used by every other flow:

| Method | JNI signature | Argument shape (observed at the call sites) |
| --- | --- | --- |
| `nativeUsbfsClaim` | `(III)I` | fd, interface number, interface alternate setting |
| `nativeUsbfsRelease` | `(II)V` | fd, interface number |
| `nativeUsbfsRead` | `(II[BIII)I` | fd, interface, buffer, buffer offset, length, timeout |
| `nativeUsbfsWrite` | `(II[BIII)I` | fd, interface, buffer, buffer offset, length, timeout |

### 2.3 `librynx_guard.so` — registered against `com.rynx.app.security.NativeAssetGate`

| Method | JNI signature | Purpose |
| --- | --- | --- |
| `nativeOpen` | `([BI[B)[B` | open and authenticate one protected component (key bytes, component id, container blob) |
| `nativeSignerAccepted` | `([B)Z` | validate the running signer certificate digest |

Evidence for the contract: the three engine artifacts carry the JNI entry-name
strings for exactly these methods and register them from `JNI_OnLoad` via
`RegisterNatives` — `librynx_core.so` digest `ef8068b7…`, `librynx_adbfastboot.so`
digest `9ef98467…`, `librynx_guard.so` digest `5effccf4…`. Method descriptors above
were read from the declaring Java classes in `app/src/main/java`. A core built for
this app must register the `com.rynx.app.*` paths; the paths baked into those
artifacts predate this project's package name and are replaced at build time.

## 3. Native core — capability checklist

Everything below is required by the ABI in section 2 and by the app's screen flows,
and none of it is in this repository yet.

- **Preloader / BROM**: preloader protocol, handshake, `MTK_BLOADER_INFO` read,
  preloader backup/restore, EMI settings, BROM security handshake and exploit paths
  (linecode-style partition-table tamper, heap-bait style DA patching).
- **Download Agent**: DA1/DA2 upload, XML DA protocol, XFlash DA protocol, DA
  extensions, DA patch/sign paths, DA readback.
- **SLA**: DA SLA, Xiaomi BROM SLA (requires the 32-byte SoC ID), Transsion DA SLA
  (XML challenge/response), local keyring for stored credentials.
- **Storage**: eMMC and UFS, GPT and PMT partition tables (primary/backup, vendor LBA
  metadata, entry validation), RPMB read, user area sizing.
- **Scatter**: scatter file parsing (v6 fields), storage section types, partition
  layout validation, image/partition size checks.
- **Flash operations**: partition write/read/erase/format, `WRITE-PARTITIONS`,
  resumable transfer, input-larger-than-partition rejection.
- **Security config**: `secfg` policy update and recovery, boot-control partition
  parse and slot switch.
- **Transport**: Android `usbfs` layer — control and bulk IN/OUT on a Java-supplied
  file descriptor, with cancellation and timeout accounting.
- **SoC coverage**: the SoC table the app presents must cover at least the families
  the core is built for (MT6xxx Dimensity and Helio ranges).

## 4. Plan

The core is a Rust workspace library plus a thin JNI bridge:

1. Depend on the MTK engine crate family (credited in `CREDITS.md`) rather than
   reimplementing the protocols.
2. Implement the `usbfs` transport backend against the fd supplied by
   `nativeSetUsbFd`.
3. Write the JNI bridge registering the 19 methods of section 2 under the
   `com.rynx.app.*` paths.
4. Cross-compile for `aarch64-linux-android` with the NDK and ship as
   `jniLibs/arm64-v8a/` (plain libraries) — the protected-container path
   (`EncryptedNativeLoader` + `NativeAssetGate`) is optional and only exists to keep
   an engine out of plain sight; a core built from source does not need it.

Licensing note: the engine crates are AGPL-3.0-or-later. Linking them makes the
combined work AGPL-3.0-or-later; the repository licence has to be settled before the
core is added. See `README.md` → Licensing.

## 5. Not verified

- No USB/DA/Flash flow has been exercised end to end in this project — there is no
  target device on USB here, and without a native core there is nothing to call.
- The dispatch-id namespace of `nativeRunCommand` / `nativeRunGuiAction` is not
  enumerated: the ids are owned by the core, and the Java call sites only pass them.
- `nativeSetUsbFd`'s `long` return and `nativeSetXiaomiAuthGeneration`'s effect are
  typed from the Java declarations only.
