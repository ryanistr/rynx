# Feature parity ledger

What a complete MediaTek service flash tool has to do, and where each piece lives in
this repository. Two layers are tracked separately, because they are delivered by
different build systems and have different completion states.

| Layer | What it covers | State |
| --- | --- | --- |
| App layer (Java) | UI, screen flows, USB permission handling, ADB/Fastboot orchestration, update feed | present |
| Native core (`arm64-v8a` `.so`) | BROM/Preloader handshake, DA upload and DA protocols, storage and partition operations, SLA signing, ADB/Fastboot protocol | `native/` (transport, session, dispatch, fastboot conversation) |

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

This repository builds two of them (`librynx_core.so`, `librynx_adbfastboot.so`). The third is the
protected-container gate; the app was switched to loading plain libraries with
`System.loadLibrary` instead, so that gate is not built here and the class that declares it is
never reached.

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

The registration tables were then checked against the classes they target: `javap -s -p`
over the compiled `MainActivity` and `AdbFastbootNative` yields 19 native methods, and all
19 (name, descriptor) pairs appear in `native/core/src/lib.rs` (8) and
`native/adbfastboot/src/lib.rs` (11) — no name on either side is unmatched and no descriptor
differs from the compiled one. The reference split is the same shape: 8 names against
`…MainActivity`, 11 against `…adbfastboot/AdbFastbootNative`, 2 against
`…security/NativeAssetGate`, plus the `(Ljava/lang/String;)V` callback
`onNativeFastbootEvent` on the last of those classes, which this repository also calls.
`NativeAssetGate`'s two are the only methods in the app that no built library registers, and
nothing invokes its entry point, so no call can reach it.

## 3. Native core — capability checklist

Everything below is required by the ABI in section 2 and by the app's screen flows. The
engine-side half (protocols, storage, SLA, patching) is supplied by the crates listed in
`CREDITS.md`; this repository supplies the transport, the session and the command layer.

The command layer is aligned with the reference engine's own vocabulary and payload text — see
`docs/NATIVE-ENGINE-RE.md` for the artifact evidence behind every label and message.

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

Steps 1–4 are done and committed; `native/README.md` describes the resulting layout. The APK itself
is produced by `tools/build-apk.sh`, which needs only the SDK tools — see the Build section of
`README.md`. For the desktop targets, see `docs/PLATFORMS.md`.

Licensing note: the engine crates are AGPL-3.0-or-later. Linking them makes the
combined work AGPL-3.0-or-later; the repository licence has to be settled before the
core is added. See `README.md` → Licensing.

## 5. Not verified

- No USB/DA/Flash flow has been exercised end to end — there is no MTK target on USB on this
  machine. The core builds and links for `aarch64-linux-android`, and its payload layer is
  unit-tested, but no session has ever been opened against a device. The same applies to the
  fastboot conversation in `librynx_adbfastboot.so`: its framing, sparse splitting and interface
  walk are unit-tested against the wire format, and no target has ever answered it.
- What *is* verified on hardware: the app installs, launches and keeps running with both libraries
  mapped into its address space, and the screens that read the payload labels render. The last
  build checked this way was `tools/build-apk.sh`'s output, APK
  `md5 4bc9f9803f330a30cf312228dd3823c7`: `adb install -r -d` reported success, `am start -W`
  reported `TotalTime: 3713`, `pidof` gave a live process, a root read of `/proc/<pid>/maps` showed
  both `lib/arm64/librynx_core.so` and `lib/arm64/librynx_adbfastboot.so` from that APK, the crash
  buffer held nothing from the app, and `aapt2 dump badging` reports `versionCode='1'
  versionName='0.1.0'`. One build earlier (`md5 331febdca0714f99b2979461c34f1854`, `TotalTime: 3108`)
  is the run whose About screen the uiautomator dump read as `License: AGPL-3.0-or-later` together
  with the AGPL notice and its gnu.org link; the licence resources are byte-identical in both
  builds — `res/raw/agpl_3_0.txt`, 34 523 bytes — and neither APK carries an Apache licence string.
  Nothing in either run called a native method — the terminal screen is the app's own non-root
  legacy console, and every entry point needs an open USB descriptor — so registration is proven
  statically (section 2), not by a call.
- Linux and Windows are not built at all — see `docs/PLATFORMS.md` for what each target needs and
  which layers are already platform-independent.
- The dispatch-id namespace of `nativeRunCommand` / `nativeRunGuiAction` is not enumerated: the
  ids are owned by the core, and the Java call sites only pass them. The reference engine ignores
  them too, so this core does the same.
- `nativeSetUsbFd`'s `long` return and `nativeSetXiaomiAuthGeneration`'s effect are
  typed from the Java declarations only.
- `crash` reaches the same place as the reference engine (a BROM assertion through the preloader
  protocol) but does not re-enumerate and re-handshake the crashed device afterwards: on Android the
  descriptor is the app's, so the app re-attaches and hands over a fresh one. See
  `docs/NATIVE-ENGINE-RE.md`, "What this core does not reproduce".

## 6. Result payload contract (established)

Every native entry point answers with a string. Success is a payload starting with `OK\n` —
the call sites test `startsWith("OK\n")` and show the rest to the user; anything else is
presented as an error. The payload is a line-oriented block, **not JSON**: `x/zamkzqg.oohojlj
(payload, label)` splits on `\r?\n` and returns the remainder of the first line whose text
starts with the label, colon included.

Labels the app reads from a device-info payload (all from one call site in `MainActivity`):

| Label | Meaning |
| --- | --- |
| `CHIP:` | SoC |
| `STORAGE:` | storage kind (eMMC/UFS) |
| `BOOT MODE:` | connection / boot mode |
| `DA PROTOCOL:` | XML or XFlash |
| `HW CODE:`, `HW SUBCODE:` | hardware code and subcode |
| `HW VERSION:`, `SW VERSION:` | versions, read off the preloader reply by the transport wrapper (`native/core/src/port_recorder.rs`) |
| `TARGET CONFIG:` | target config word |
| `MEID:` | MEID |
| `SOC ID:` | SoC ID |
| `SBC:`, `SLA:`, `DAA:` | security features enabled |

Labels the app reads from a boot-control payload: `SLOT_COUNT:`, `ACTIVE_SLOT:`, `SUFFIX:`,
`CRC:`, `OFFSET:`, and per slot `SLOT_A_PRIORITY:`, `SLOT_A_TRIES:`, `SLOT_A_SUCCESSFUL:`,
`SLOT_A_BOOTABLE:`, `SLOT_A_VERITY:` plus the `SLOT_B_*` set.

`bootctrl-set` receives operands shaped like `set_active:<slot>` (`format:` and `raw:`
operands appear on the same path). Call sites pass two leading empty operands before the
meaningful ones — `nativeRunGuiAction(i, j, "pgpt", "", "", a, b, c)` — so a core must not
assume operand 0 is the primary argument.

The `pgpt` and per-verb label sets are now established from the reference engine's `.rodata`:
`pgpt` emits `PARTITION TABLE` followed by `{name} addr=0x{addr:x} size=0x{size:x}
section={section}` lines, and `upload`/`read-flash`, `download`/`write-flash`/`scatter-download`,
`erase*`, `seccfg`, `bootctrl-set`, `reboot`, `shutdown`, `crash`, `scatter-download-v6` and
`scatter-firmware-upgrade` each carry a fixed block — all recorded in `docs/NATIVE-ENGINE-RE.md`.
Error messages are `ERR:<text>`; the ones the reference engine pins verbatim are listed there too.

## 7. Command surface the core implements

The operand layout is established: `nativeRunCommand(fd, timeout, verb, op0, op1, da, auth,
preloader)`. `MainActivity.java:406-442` passes the two parsed operands as `str9`/`str10` and then
`str2`/`str3`/`str4` — the `--da`, `--auth` and `--pl` paths — and `MainActivity.java:5364` hands
all six to JNI in that order; the GUI call sites (`x/vntpaom.java:94,226`, `x/hhqpjvl.java:59,158`,
`x/silhone.java:123`, `x/lpkdqgx.java:122`) use the same tail. `nativeConnectSession(mode, timeout,
da, auth, preloader)` is the same shape without the verb and operands.

| verb | core behaviour | payload |
| --- | --- | --- |
| `probe` | build session, handshake, return the device block | `SESSION READY` … `PARTITIONS:` |
| `pgpt` | partition table | `PARTITION TABLE` + `addr=/size=/section=` lines |
| `bootctrl-info` | boot-control block from `misc`/`para` | `BOOTCTRL` … `SLOT_B_VERITY:` |
| `bootctrl-set` | read the block, patch the active slot, write it back, re-read to prove it | `BOOTCTRL UPDATED` |
| `upload` | read partition → file | `READ COMPLETE` + `PARTITION/BYTES/FILE` |
| `read-flash` | raw flash read → file | as `upload` |
| `download` | write image into a partition; a `name\t<hex offset>` operand takes the raw-offset path | `WRITE COMPLETE` + `PARTITION/BYTES` |
| `scatter-download` | as `download` (offset form) | as `download` |
| `write-flash` | write image to a partition through the flash path | as `download` |
| `erase-partition` | erase one partition | `ERASE COMPLETE` + `PARTITION/BYTES` |
| `erase` | erase through the flash path | as `erase-partition` |
| `seccfg` | `unlock` / `lock` only; any other action is refused verbatim | `SECCFG UPDATED` + `STATE` |
| `reboot` | `normal`, `home-screen`, `fastboot`, `meta`, `test`; an empty operand means normal | `REBOOT COMPLETE` + `MODE` |
| `shutdown` | power off | `SHUTDOWN COMPLETE` |
| `crash` | assert the bootrom with a garbage DA image, dropping the SoC to BROM; refused while a DA is live | `CRASH TRIGGERED` + `TARGET` |
| `scatter-download-v6` | parse the plan, pin the scatter, flash only the named payloads | `DOWNLOAD ONLY COMPLETE` + `ENGINE/PARTITIONS` |
| `scatter-firmware-upgrade` | pin the plan's scatter and images, flash the named payloads with the engine's own pre-flash backups, settle the seccfg policy, report the layout facts it measured | `FIRMWARE UPGRADE COMPLETE` … |

Nothing above is verified against hardware: this machine has no MTK target on USB, so every
USB/DA path is compile-, API- and unit-verified only (`cargo +nightly test -p rynx-core`,
twenty-eight tests, three of them driving the engine's own `PlProtocol::get_hw_sw_ver` through the
port wrapper). `HW VERSION`/`SW VERSION` are no longer a gap: the wrapper watches the version reply
as it passes (`native/core/src/port_recorder.rs`) instead of waiting for an engine change, and the
transactional firmware upgrade is no longer reduced to a bare scatter flash: the plan codec
(`native/core/src/plan.rs`) authorizes the transaction and the remaining differences — protected-data
record files, postflight re-audit, layout-migration handling — are listed with their reason in
`docs/NATIVE-ENGINE-RE.md`.

## 8. Structural audit against the reference build

Run 2026-10-19 on the shipped bytes of both APKs: `apkanalyzer manifest print` and
`aapt2 dump badging` for declarations, REA `decode_android_resources` (`include_strings: true`,
locales `default` and `in`) for the string tables, `baksmali list classes|methods|fields` for the
code. Reference artifact: the released arm64-v8a build (release, R8-minified). Rynx side:
`build-apk/rynx-debug.apk`, md5 `72aecef2a7b04019cf814b8ec7998f1b`; `librynx_core.so` md5
`4f4761f337e966b37f62b361fd330e57` (device copy identical).

| surface | reference | rynx | result |
| --- | --- | --- | --- |
| string keys | 1092 en / 1092 in | 1092 / 1092 | identical key sets, both locales |
| string values | — | — | 114 differ: product names, the `/sdcard/rynx` backup path, credit lines, and `&`-escaping artifacts. No functional text differs |
| manifest | `INTERNET`, `MANAGE_EXTERNAL_STORAGE`, `READ_EXTERNAL_STORAGE`, `WRITE_EXTERNAL_STORAGE`; `android.hardware.usb.host` required; one launcher activity; no service, receiver or provider | same | identical, except that `icon`/`roundIcon` are absent by design — no image assets ship yet, and the APK installs and launches with the platform default (cold start `TotalTime: 3713`, §5) |
| resources (by name) | 1343 | 1340 | same type counts on both sides — see the table breakdown below; only brand renames and three removed image assets differ |
| defined classes | 229 | 503 | 156 identical names, 69 renamed with an identical `(name, argc, return)` method profile, 4 method-less classes present by name; **0 missing** |
| defined methods | 1105 | 1813 | superset |
| defined fields | 1142 | 3700 | superset |

The 343 rynx-only class names are all nested (`$…`), `R`/`R$` or `BuildConfig` entries; the audit
found no unexplained top-level class. The 69 ref-only names each have a class in rynx carrying the
same method multisets, which is expected after the R8 → decompile → javac round trip reshapes
anonymous classes.

Package inventory: outside `res/` both APKs ship `AndroidManifest.xml`, `classes.dex` and
`resources.arsc`; the reference additionally carries a guard library plus two encrypted native
payloads under `assets/`, the container rynx deliberately does not reproduce — it ships the two
plain `librynx_*.so` instead. Neither APK carries a Download Agent, scatter file or certificate, so
no runtime payload is missing.

Resource table, compared by name through `aapt2 dump resources` (R8 shuffles `res/` file paths, so
paths are not comparable): 1343 entries in the reference against 1340 in rynx, with 1092 strings,
146 dimens, 49 colours, 12 integers, 2 styles, 1 xml and 1 raw on both sides. Every name difference
is either a brand rename (colours and the theme prefix now carry the rynx name) or one of the three
deliberately removed image assets (one upstream creator animation and the two launcher mipmaps). The
single `raw` entry is the GNU AGPL v3 text on both sides: the reference asset, rynx's
`res/raw/agpl_3_0.txt` and the repository `LICENSE` are byte-identical, md5
`4ae09d45eac4aa08d013b5f2e01c67f6`.

Two defects the audit caught, both fixed in the same commit:

* `x/iivesaq.java` fetched `https://api.github.com/repos/OWNER/rynx/releases/latest` — a
  placeholder owner, so "Check for updates" could only ever fail. It now reads
  `repos/ryanistr/rynx/releases/latest`. That path answers 200 for the repository and 404 for
  `releases/latest` while no release exists — the branch that shows `R.string.update_check_failed`
  (`x/eigllth.java:101`) rather than crashing.
* The About screen's two link rows pointed at `example.com` stubs. They now point at the project
  (`https://github.com/ryanistr/rynx`) and its releases page, and the row labels read PROJECT and
  RELEASES instead of TELEGRAM and DONATE.

The update checker fixes the release convention for this repository: a published release's notes
must carry `RYNX_VERSION_CODE = <n>` and `RYNX_VERSION_NAME = <x.y.z>`, or the checker reports
"could not check for updates" by design.

Not verified in this pass: the About screen was not walked on-device. The device was released by
another session at 23:48 WIB and an attestation pass was using its screen. The change is
resource-verified — `resources.arsc` carries both new URLs and `classes.dex` carries the new API
URL — and the endpoint behaviour was checked against GitHub directly.

The §5 native gap stands: this audit covers the app half only. `HW VERSION`/`SW VERSION` were
closed in the core afterwards (`native/core/src/port_recorder.rs`), leaving the reduced
firmware-upgrade transaction. The core's verb literals could not
be re-confirmed by a Ghidra defined-string search for `bootctrl-set`, `read-flash` or `nativeRun`
(all empty), because Rust packs them into one `&str` table; those empty results are bounded by the
string inventory, not evidence of absence — §7 and `docs/NATIVE-ENGINE-RE.md` hold the disassembly
evidence that established the pool.
