# Native command / verb namespace (`rynx` native dispatch layer)

Scope: the command-string entry points of the app's native core, resolved from the
decompiled Java under `app/src/main/java` (package `com.rynx.app` and the obfuscated
support package `x`). Read-only analysis; no source file was modified.

## Dispatch convention

The app binds to its native core through 19 JNI methods. Three of them accept a
command/verb as their first `String` argument:

| JNI method | signature |
| --- | --- |
| `nativeRunCommand` | `String nativeRunCommand(int commandId, long timeout, String a, String b, String c, String d, String e, String f)` |
| `nativeRunGuiAction` | `String nativeRunGuiAction(int actionId, long timeout, String a, String b, String c, String d, String e, String f)` |
| `nativeConnectSession` | `String nativeConnectSession(int mode, long timeout, String a, String b, String c)` |

Convention: argument `a` is the verb (kebab-case, lower-case; e.g. `bootctrl-set`,
`pgpt`, `erase-partition`), followed by up to five operand strings (`b`..`f`), which
are the partition name, file path, slot suffix, etc. depending on the verb. The
integer `commandId`/`actionId` is the USB-session handle, `timeout` is a
millisecond deadline. The 6-argument call sites pass `""` for absent operands rather
than `null`. The native return value is a result string whose first line is the
success marker: callers test `result.startsWith("OK\n")` and treat anything else
(notably an `ERROR\n` prefix) as failure — see `x/kggugdp.java:8632`,
`x/hhqpjvl.java:159`, `x/lpkdqgx.java:74`, `x/vntpaom.java:227`,
`x/silhone.java:124`, `com/rynx/app/MainActivity.java:5364`. `nativeConnectSession`
follows the same `OK\n` result convention but its first three strings are the DA,
auth and preloader file paths, not a verb.

There are two doors into `nativeRunCommand`/`nativeRunGuiAction`:

* **CLI / console door** — `MainActivity.neppdxk` tokenises the typed line with
  `MainActivity.iqvvlnh` (`MainActivity.java:1787`), finds the verb token, then
  `x/kggugdp.java:2808-2864` normalises it (`x/cugubfc.nmpwovh`), rejects verbs not in
  the implemented set (`x/cugubfc.ojyssqt`) and calls `MainActivity.snbdnwo` →
  `MainActivity.axbavsj` → `MainActivity.zamkzqg` → `nativeRunCommand`.
* **GUI action door** — a screen builds a command line and hands it to
  `MainActivity.casbgpb` or to the confirm-dialog `x/qyeibyo`, which normalise the
  first token and run it through `x/lpkdqgx` (case 0) or `x/hhqpjvl` (case 0) →
  `nativeRunGuiAction`. Most fixed GUI verbs are hard-coded literals in the worker
  classes; the rest arrive from the same CLI token set.

The verb grammar itself is a literal allowlist in `x/cugubfc.java:10-13`, plus an
alias-collapsing normaliser at `x/cugubfc.java:68-86`.

The engine's own view of this namespace — which verbs it actually compares, and the payload
each one answers with — is read out of its `.rodata` in `docs/NATIVE-ENGINE-RE.md`. Where the two
records disagree, that one wins: it is the artifact, not a reading of the callers.

## Canonical grammar (verb allowlist)

`x/cugubfc.java` holds the authoritative vocabulary as three literal sets.

Recognised verbs (`cugubfc.nmpwovh`, `cugubfc.java:10`) plus the aliases that
`cugubfc.nmpwovh(String)` rewrites to them (`cugubfc.java:68-86`):

| canonical verb | accepted aliases | role |
| --- | --- | --- |
| `probe` | — | handshake / probe device |
| `upload` | `up`, `read`, `r` | read a partition out to a host file |
| `read-flash` | `rf` | raw flash read |
| `write-flash` | `wf` | raw flash write (advanced/raw mode) |
| `download` | `dl`, `write`, `w` | download a host image into a partition |
| `pgpt` | `gpt` | read/print the partition table (GPT/PGPT) |
| `reboot` | — | reboot device |
| `shutdown` | — | power off |
| `seccfg` | — | read/change seccfg (lock/unlock) |
| `crash` | — | crash the DA / close session |
| `format` | — | recognised, not backend-implemented |
| `erase` | — | recognised, not backend-implemented |
| `write-offset` | — | recognised, not backend-implemented |
| `read-offset` | — | recognised, not backend-implemented |
| `write-all` | — | recognised, not backend-implemented |
| `read-all` | — | recognised, not backend-implemented |
| `peek` | — | recognised, not backend-implemented |
| `poke` | — | recognised, not backend-implemented |
| `rpmb` | — | recognised, not backend-implemented |
| `x-flash` | `xflash` | recognised, not backend-implemented |
| `set-active-slot` | — | recognised, not backend-implemented |

Implemented backend set (`cugubfc.ojyssqt`, `cugubfc.java:11`) — a CLI line whose
normalised verb is not in this set is rejected with "unsupported"/"backend
unimplemented" and never reaches the native core:

`probe`, `upload`, `read-flash`, `write-flash`, `download`, `pgpt`, `reboot`,
`shutdown`, `seccfg`, `crash`

Two further sets classify verbs for argument validation: read-type verbs require an
output path and write-type verbs require an input file
(`cugubfc.vivhedu` = `upload`,`up`,`read`,`r`,`read-flash`,`rf`;
`cugubfc.lthborb` = `write-flash`,`wf`,`download`,`dl`,`write`,`w`).

Confidence split used throughout: the **11 verbs that exist only in the recognised
allowlist** and have no call-site evidence (`format`, `erase`, `write-offset`,
`read-offset`, `write-all`, `read-all`, `peek`, `poke`, `rpmb`, `x-flash`,
`set-active-slot`) are the **inferred** set — their spelling comes from a literal, but
this build gates them off before any native call. Every other verb in the table below
is an **established** verb, pinned either by a literal at a call site or by a
two-arm ternary over literals. Aliases (`up`, `r`, `rf`, `wf`, `dl`, `w`, `gpt`,
`xflash`) are normalised away by `cugubfc.nmpwovh` before reaching the native core and
are therefore not commands of the native layer.

Not commands: the kebab/named literals `selected-auth`, `selected-da`,
`selected-preloader` (`MainActivity.java:947,2765,2785,2802,2808`) are
file-picker/SharedPreferences keys; `rynx-native-disconnect`
(`MainActivity.java:2999`) and `rynx-update-check` (`com/rynx/app/nmpwovh.java:955`)
are `Thread` names. The literals in `x/ohwxijw.java:40-115` (`flashinfo`, `md_sec`,
`blackbox`, `nvdata`, `protect1/2`, `seccfg`, `persist`, `proinfo`, `dram_para`,
`vb`, `mem`, `otp`, `oops`, `para`, `pgpt`, `sec1`, `sgpt`, `efuse`, `gsort`,
`nvcfg`, `nvram`, `charger`) classify *partition names* by risk (red/yellow/green),
not verbs.

## Command table

Confidence column: **established** = the argument is a string literal (or a ternary /
switch arm over literals) at or directly feeding the call site; **inferred** = the
argument is a variable whose domain is established elsewhere but not at this site.

### Verbs reaching `nativeRunCommand` (CLI/console path)

| command | call sites (file:line) | operands observed | what it does (UI flow) | confidence |
| --- | --- | --- | --- | --- |
| `probe` | `com/rynx/app/MainActivity.java:5363` (via `MainActivity.java:448`; verb picked at `x/kggugdp.java:2832`) | `a`=`probe`; no file operands required (`MainActivity.java:4193,4203`) | console: connect/probe the device without reading a DA (`snbdnwo`), terminal "probe" | established |
| `crash` | `com/rynx/app/MainActivity.java:5363` | `a`=`crash` | console: crash/close the DA session; same path exempted from the DA-required check (`MainActivity.java:4193`), confirmed as executed verb in `x/ekyqleu.java:474` | established |
| `upload` | `com/rynx/app/MainActivity.java:5363` | `a`=`upload`, `b`=partition, `c`=output path | console: read partition to host file (`MainActivity.java:4238` requires a writable output dir) | established |
| `read-flash` | `com/rynx/app/MainActivity.java:5363` | `a`=`read-flash`, `b`=partition, `c`=output path | console: raw flash read | established |
| `write-flash` | `com/rynx/app/MainActivity.java:5363` | `a`=`write-flash`, `b`=partition, `c`=input image | console: raw flash write (`MainActivity.java:4227` requires the input file) | established |
| `download` | `com/rynx/app/MainActivity.java:5363` | `a`=`download`, `b`=partition, `c`=input image | console: flash a host image into a partition | established |
| `pgpt` | `com/rynx/app/MainActivity.java:5363` | `a`=`pgpt` | console: print/read the partition table | established |
| `reboot` | `com/rynx/app/MainActivity.java:5363` | `a`=`reboot` | console/power menu: reboot device | established |
| `shutdown` | `com/rynx/app/MainActivity.java:5363` (verb captured at `MainActivity.java:2097`) | `a`=`shutdown` | power menu → confirm dialog (`x/nsyqsfj.java:28` builds `"shutdown"`) → `x/qyeibyo` case 0 → `casbgpb` mixed path | established |
| `seccfg` | `com/rynx/app/MainActivity.java:5363` | `a`=`seccfg`, `b`/`c` as built by the console line | console: bootloader lock state (`x/tqfwohl.java:10`, `x/ezuzoct.java:55` treat `seccfg` specially) | established |

### Verbs reaching `nativeRunGuiAction` (GUI-action path)

Direct call sites of `nativeRunGuiAction` are the 8 listed below; four further verbs
arrive through the shared wrapper `x/kggugdp.yhrqvll(...)`
(`x/kggugdp.java:8623`, calling `nativeRunGuiAction` at
`x/kggugdp.java:8631`). Each wrapper call site is listed against its verb.

| command | call sites (file:line) | operands observed | what it does (UI flow) | confidence |
| --- | --- | --- | --- | --- |
| `bootctrl-info` | `x/vntpaom.java:94` | `a`=`bootctrl-info`, `b`=`""`, `c`=`""`, `d`=da_path, `e`=auth_path, `f`=preloader_path | Bootloader screen: read the boot-control (active-slot / slot metadata) block. Launched from `MainActivity.java:2673` (`new vntpaom(..., 2)`). Result parsed by `MainActivity.clczezu` in `x/utmeivs.java:10` | established |
| `bootctrl-set` | `x/hhqpjvl.java:59` | `a`=`bootctrl-set`, `b`=slot letter (`A`/`B`, lower-cased), `c`=`""`, `d`=da_path, `e`=auth_path, `f`=preloader_path | Bootloader screen: set the active boot slot. Confirmation built in `x/pzqxblc.java:140` → `x/qyeibyo` case 1 → `new hhqpjvl(..., 0)` (`x/qyeibyo.java:63`); slot must be `A`/`B` and differ from the current slot | established |
| `pgpt` | `x/vntpaom.java:226` | `a`=`pgpt`, `b`=`""`, `c`=`""`, `d`=da_path, `e`=auth_path, `f`=preloader_path | Partition screen: read/refresh the partition table ("parts reading"). Launched from `x/kggugdp.java:4718` (`new vntpaom(..., 7)`), log string `log_parts_reading` | established |
| `erase-partition` | `x/hhqpjvl.java:158` | `a`=`erase-partition`, `b`=partition name, `c`=`""`, `d`=da_path, `e`=auth_path, `f`=preloader_path | Partition screen: erase one partition (`ygdccqg = "ERASE"`, progress "partition_erase_progress"). Launched from `x/dkpobjg.java:158` (`new hhqpjvl(..., 4)`), log `log_parts_erase_start` | established |
| `upload` | `x/silhone.java:123`, `x/silhone.java:58` (wrapper) | `a`=`upload`, `b`=partition name, `c`=destination file path, `d`=da_path, `e`=auth_path, `f`=preloader_path | Partition screen: back up (read out) a partition to a file (`ygdccqg = "READ"`, "partition_backup_progress"). Launched from `x/kggugdp.java:545` (`new silhone(..., 2)`) and `x/pmsrvoc.java:57` (batch backup) | established |
| `download` | `x/hhqpjvl.java:91` (wrapper call at `x/hhqpjvl.java:94`) | `a`=`download`, `b`=partition name (or `partition\t<hex offset>`), `c`=source image path, `d`=da_path, `e`=auth_path, `f`=preloader_path | Scatter/partition multi-write: flash each selected payload one partition at a time. Verb chosen by ternary `z ? "scatter-download" : "download"` on the payload's sparse flag. Launched from `x/kggugdp.java:4729` (`tmdubwv(ArrayList)`) | established |
| `scatter-download` | `x/hhqpjvl.java:91` (wrapper at `x/hhqpjvl.java:94`) | `a`=`scatter-download`, `b`=`partition\t<emmc offset in hex>`, `c`=source image path, `d`–`f` = da/auth/preloader paths | Same loop as `download`, used when the scatter entry carries an explicit offset (`x/hhqpjvl.java:92` appends `"\t" + Long.toUnsignedString(offset, 16)`) | established |
| `scatter-download-v6` | `x/silhone.java:86` (wrapper; class `x/silhone.java:76-109`) | `a`=`scatter-download-v6`, `b`=generated XML/scatter path, `c`=`""`, `d`=da_path, `e`=auth_path, `f`=preloader_path | "XML/V6 Download Only": build one scatter package and flash it in a single native call. Launched from `x/kggugdp.java:8810` (`[SCATTER] XML/V6 Download Only -> CMD:WRITE-PARTITIONS v1.0`) | established |
| `scatter-firmware-upgrade` | `x/lpkdqgx.java:185` (wrapper; class `x/lpkdqgx.java:172-208`) | `a`=`scatter-firmware-upgrade`, `b`=built scatter package, `c`=output package path, `d`=da_path, `e`=auth_path, `f`=preloader_path | "FWUP" firmware-upgrade flow: full firmware upgrade with slot handling. Launched from `x/kggugdp.java:8839` (`[FWUP] Worker queued`) | established |
| `write-flash` | `x/lpkdqgx.java:122` | `a`=`write-flash`, `b`=partition name, `c`=image path, `d`=da_path, `e`=auth_path, `f`=preloader_path | Flash screen ("raw/advanced" method): write an image to one partition. Verb from ternary `mainActivity2.prywqjr ? "write-flash" : "download"` at `x/hknanqb.java:51`, passed via `new lpkdqgx(..., str3, ...)` at `x/hknanqb.java:166` (`lpkdqgx` case 1) | established |
| `download` | `x/lpkdqgx.java:122` | `a`=`download`, `b`=partition, `c`=image path, `d`–`f` = da/auth/preloader paths | Same Flash screen, non-raw method (same ternary as above) | established |
| `seccfg`, `bootctrl-set`, `reboot`, `shutdown`, or any normalised CLI verb | `x/lpkdqgx.java:73` (class `x/lpkdqgx.java:45-103`) | `a`=<verb>, `b`/`c` = first/second operand of the command line | GUI-action confirmations (`MainActivity.casbgpb`, `MainActivity.java:600-633`): `seccfg` + `unlock`/`lock` from the bootloader menu (`MainActivity.java:1615`), `bootctrl-set`/`reboot`/`shutdown` command lines from `x/qyeibyo` case 0 (`x/qyeibyo.java:33-35`, `MainActivity.java:2097`) | inferred |

### `nativeConnectSession` (session door)

Single call site. The three strings are **not** a verb and operands — they are the
session's DA, auth and preloader file paths.

| command | call sites (file:line) | operands observed | what it does (UI flow) | confidence |
| --- | --- | --- | --- | --- |
| *(none — no verb slot)* | `com/rynx/app/MainActivity.java:4760` | `a`=da_path, `b`=auth_path, `c`=preloader_path | `MainActivity.ygdccqg()`: open the GUI session against the selected DA; result parsed by `x.zamkzqg.xvxmcgn` / `x.zamkzqg.rpdxrib`; failure disconnects any previous session | established (the literals/keys `da_path`,`auth_path`,`preloader_path` are set by `MainActivity.mccfjlr`, `MainActivity.java:2081-2089`) |

## Adjacent but separate: the direct-USB Fastboot transport

A second native library (`com/rynx/app/adbfastboot/AdbFastbootNative`, 11 JNI methods
`nativeFastboot*` / `nativeUsbfs*`) also takes a command string. These verbs are
**not** part of the `nativeRunCommand`/`nativeRunGuiAction` namespace and go to a
different native entry point, so they are recorded separately. Source of the verbs is
the `fastboot` console implemented in `MainActivity.neppdxk`
(`MainActivity.java:2230-2494`), dispatched via `Snbdnwo`-independent helpers:
`bsimxgu` → `aylswsn` → `AdbFastbootNative.ojyssqt(fd, verb)` =
`nativeFastbootCommand` (`x/vopsyhw.java:68`), and `czqxnxv` →
`AdbFastbootNative.lthborb(fd, verb, arg, path)` = `nativeFastbootFileCommand`
(`MainActivity.java:860`).

| verb | site | notes |
| --- | --- | --- |
| `reboot` | `MainActivity.java:2267` | `fastboot reboot` |
| `reboot-bootloader` | `MainActivity.java:2271, 2286` | also from `fastboot reboot bootloader` |
| `reboot-fastboot` | `MainActivity.java:2275, 2290` | also `fastbootd` |
| `reboot-recovery` | `MainActivity.java:2278` | |
| `continue` | `MainActivity.java:2294` | |
| `shutdown` | `MainActivity.java:2298` | also `poweroff` |
| `getvar:<name>` | `MainActivity.java:2258` | |
| `set_active:<slot>` | `MainActivity.java:2359` | also `set-active` |
| `flashing <action>` | `MainActivity.java:2374` | `lock`/`unlock`/`lock_critical`/`unlock_critical`/`get_unlock_ability` |
| `oem <args...>` | `MainActivity.java:2386-2397` | free-form vendor command |
| `flash` | `MainActivity.java:2312` (`x/gisppfs.java:90`) | `nativeFastbootFileCommand` |
| `boot` | `MainActivity.java:2321` (`x/utmeivs.java:27`) | |
| `stage` | `MainActivity.java:2329` | |
| `fetch` / `upload` | `MainActivity.java:2471, 2483` → `MainActivity.sfildfy` (`MainActivity.java:4158`) | `nativeFastbootFetch` / `nativeFastbootReceiveCommand` |
| `erase:<part>` | `x/utmeivs.java:31` | |
| `create-logical-partition:<name>:<size>` | `MainActivity.java:2409` | |
| `delete-logical-partition:<name>` | `MainActivity.java:2422` | |
| `resize-logical-partition:<name>:<size>` | `MainActivity.java:2434` | |
| `snapshot-update[:cancel\|merge]` | `MainActivity.java:2452` | |
| `gsi:<wipe\|disable>` | `MainActivity.java:2443` | |
| `wipe-super` | `MainActivity.java:2456` | explicitly refused, no native call |
| `format` / `format:<fs>` | `MainActivity.java:2460` | explicitly refused, no native call |

## Call-site inventory

Ten textual call sites of the three in-scope JNI methods were found (52 matches
overall in the tree, of which 6 are declarations — 3 `native` in
`MainActivity.java:2210-2222` and 3 `abstract` in `com/rynx/app/ojyssqt.java:569-577`):

| # | call site | method | verb resolved |
| --- | --- | --- | --- |
| 1 | `com/rynx/app/MainActivity.java:4760` | `nativeConnectSession` | n/a — paths, no verb |
| 2 | `com/rynx/app/MainActivity.java:5363` | `nativeRunCommand` | established (CLI implemented set) |
| 3 | `x/kggugdp.java:8631` | `nativeRunGuiAction` | wrapper (`yhrqvll`), verb = 1st arg |
| 4 | `x/vntpaom.java:94` | `nativeRunGuiAction` | established — `bootctrl-info` |
| 5 | `x/vntpaom.java:226` | `nativeRunGuiAction` | established — `pgpt` |
| 6 | `x/hhqpjvl.java:59` | `nativeRunGuiAction` | established — `bootctrl-set` |
| 7 | `x/hhqpjvl.java:158` | `nativeRunGuiAction` | established — `erase-partition` |
| 8 | `x/lpkdqgx.java:73` | `nativeRunGuiAction` | **unresolved** — verb is dynamic |
| 9 | `x/lpkdqgx.java:122` | `nativeRunGuiAction` | established — ternary `write-flash`/`download` |
| 10 | `x/silhone.java:123` | `nativeRunGuiAction` | established — `upload` |

Four call sites of the shared wrapper `x/kggugdp.yhrqvll` also reach
`nativeRunGuiAction` (`x/kggugdp.java:8631`): `x/silhone.java:58` (`upload`),
`x/silhone.java:86` (`scatter-download-v6`), `x/hhqpjvl.java:94`
(`scatter-download`/`download`), `x/lpkdqgx.java:185`
(`scatter-firmware-upgrade`).

## Unresolved

* `x/lpkdqgx.java:73` (`lpkdqgx` case 0) — the command is `str5` = `this.ojyssqt`, the
  first `String` of `lpkdqgx(MainActivity, String, String, String, String, String,
  String)`. Its only feeder is `MainActivity.casbgpb(String, String, String)`
  (`MainActivity.java:600`), whose callers are:
  * `com/rynx/app/MainActivity.java:1615` — literal `"seccfg"` (operand
    `unlock`/`lock`, bootloader lock/unlock menu, `MainActivity.ghkjjru`);
  * `x/qyeibyo.java:35` — `x.cugubfc.nmpwovh(cliTokens.get(0))`, i.e. any CLI verb
    that already passed the `cugubfc.ojyssqt` implemented-set gate (observed command
    lines include `"bootctrl-set <slot>"`, `"reboot normal"`, `"shutdown"` from
    `x/nsyqsfj.java:26-28` and `MainActivity.java:2097`).
  The verb therefore cannot be pinned to a literal at the call site; its domain is
  bounded by `x/cugubfc.ojyssqt` plus the extra GUI-only verb `bootctrl-set`.

No other call site failed to resolve: every other verb is either a literal at the
call site or a two-arm ternary over literals. Terms that do **not** occur anywhere in
this tree as verbs (checked): `sgpt`, `efuse`, `efuse-read`, `seccfg-set`,
`read-partition`, `write-partition`, `readback`. `sgpt`/`efuse` appear only as
partition *names* in the risk classifier (`x/ohwxijw.java:95,98`) and the scatter
status logic (`x/kggugdp.java:2255`).

## Terminal gate vs engine dispatch

The app's terminal gate is wider than the engine. `x/cugubfc.nmpwovh` lists 31 names
(`x/cugubfc.java:10`), and `x/cugubfc.nmpwovh(String)` (`x/cugubfc.java:68`) collapses only
the eight aliases — `up`/`read`/`r` → `upload`, `rf` → `read-flash`, `wf` → `write-flash`,
`dl`/`write`/`w` → `download`, `gpt` → `pgpt`, `xflash` → `x-flash`. Everything else passes
through with its spelling intact.

The engine can execute far fewer of them. A byte-level scan of the reference core (1 448 696
bytes, arm64) finds its dispatch literals in one pool at file offset `0x2302d`–`0x230ab`:

```
probe  reboot  bootctrl-info  bootctrl-set  upload  read-flash  erase-partition  erase
scatter-firmware-upgrade  scatter-download-v6  scatter-download  write-flash
```

with `seccfg`, `crash` and `shutdown` compared from their own literals (`0x2311b`, `0x23186`,
`0x19300`) and `download` as the 8-byte prefix of `scatter-download` (`0x23095`, inside the
`scatter-download-v6` literal at `0x2308d`). The remaining
gate names are **absent from the whole binary**: `rpmb`, `format`, `peek`, `poke`, `read-all`,
`write-all`, `read-offset`, `write-offset`, `set-active-slot` and `x-flash` occur nowhere as
standalone bytes (`rpmb`/`format` only inside longer words such as `Invalid RPMB key format`
and `format-on-upgrade`; `xflash` only as the DA module path `…da::xflash::patch`), and no
inline 4-byte compare for `pgpt`/`sgpt` exists either — `pgpt` appears once, as data at
`0x22e94`, with `sgpt` beside it at `0x22e98`.

So a terminal line naming one of those is rejected by the engine as an unsupported command,
not silently handled. The core here matches the engine's executable set exactly and adds only
`partitions`/`list-partitions`, which the app never sends.

