# Reference engine: command surface and payload contract

This is the evidence record behind `native/core/src/lib.rs`. It documents what the reference
engine — the AArch64 library a shipping MediaTek service tool loads — exposes to its Java front
end, so that this core can be compared against it feature by feature instead of by guesswork.

Everything below is read out of the artifact itself: no source was available, no device was on
USB, and nothing here was learned by running the engine.

## Subject

| item | value |
| --- | --- |
| file | engine library recovered from the app's protected asset container |
| format | ELF64 little-endian AArch64, shared object, stripped |
| size | 1 448 696 bytes |
| SHA-256 | `ef8068b71a22f343c11fef6dfa74ae269170a5f6e7eadbc8435daf92f72d6f3f` |
| Ghidra image base | `0x100000` (addresses below are Ghidra addresses; file offset = address − `0x100000` in `.text`/`.rodata`) |
| exported symbols | `JNI_OnLoad` only; every Java-visible entry is registered through `RegisterNatives` |
| procedures / strings seen by Ghidra | 5 753 / 1 346 (`binary_overview`) |

Analysis was done with REA (`open_binary` → `binary_overview`, `search_bytes`, `xrefs`,
`read_bytes`, `procedure_pseudo_code`) plus `llvm-objdump` over the same bytes for immediate
resolution. Evidence IDs from that session are quoted where a claim rests on one.

## How the text is stored

The verb names and payload templates live in `.rodata` as Rust literal pools with **no NUL
terminators**, so a string tool merges them into one long run. They also are not plain literals:
each template is a length-prefixed concatenation list, `0xc0` marks an argument slot, and the
byte after the marker is the length of the literal chunk that follows it. Decoding that byte as
"next chunk length" is self-checking — every one of the ~40 payload lines below validates, e.g.

```
"PARTITIONS: " <c0> <0d> "\nDAA: "     13 = len("\nDAA: ")
"SBC: "        <c0> <06> "\nSLA: "      6 = len("\nSLA: ")
```

`0xc3` marks a width-formatted slot (hex, width in the following byte): `HW CODE: 0x` is followed
by `<c3> … <04>` and `TARGET CONFIG: 0x` by `<c3> … <08>`, i.e. `{:04x}` and `{:08x}`.

## Verb namespace

One contiguous pool at `0x122ff2` holds the dispatch vocabulary as compared by the engine
(`adr` references at `0x1934a0`, `0x194348`, `0x1944a0`, `0x1945e4`, `0x194a7c`, `0x19504c`,
`0x195060`, `0x19527c`, `0x195318`, `0x195448` and the mirror set at `0x19d5a0`…`0x19e8e0`):

| address | literal | length |
| --- | --- | --- |
| `0x122ff4` | `BootControl slot must be 'a' or 'b'` | 36 |
| `0x12302d` | `probe` | 5 |
| `0x123032` | `reboot` | 6 |
| `0x123038` | `bootctrl-info` | 13 |
| `0x123045` | `bootctrl-set` | 10 |
| `0x123050` | `upload` | 6 |
| `0x123057` | `read-flash` | 10 |
| `0x123061` | `erase-partition` | 15 |
| `0x123070` | `erase` | 5 |
| `0x123075` | `scatter-firmware-upgrade` | 23 |
| `0x12308d` | `scatter-download-v6` | 19 |
| `0x1230a0` | `write-flash` | 11 |

Prefix sharing covers the rest, which is why they have no separate literal of their own:
`download` is the 8-byte prefix of `scatter-download-v6` at `0x123095`; `seccfg` is the prefix of
`seccfg action must be 'unlock' or 'lock'` at `0x12311b`. `pgpt` and `sgpt` sit in the pool at
`0x122e94`/`0x122e98`, `crash` at `0x123186`, `shutdown` at `0x119301`.

Settled verb set (`native/core` implements exactly this, nothing else):

```
probe  pgpt  bootctrl-info  bootctrl-set  upload  read-flash
download  scatter-download  scatter-download-v6  write-flash  erase  erase-partition
seccfg  reboot  shutdown  crash  scatter-firmware-upgrade
```

Alias collapsing (`up`, `r`, `rf`, `wf`, `dl`, `w`, `gpt`, `xflash`) happens in the app's own
command gate, not in the engine, so the engine never sees them.

## Result convention

Success payloads are `OK\n<block>`; the app tests `startsWith("OK\n")`. `ERR:` is the engine's own
error prefix (literal at `0x122e90`). Blocks are line-oriented `LABEL: value` text, never JSON.

## Payload templates

Decoded from `.rodata`. `{}` is a slot; everything else is literal, including the line order.

### `probe` — device block (`0x12480d`)

```
SESSION READY
CHIP: {}
STORAGE: {}
BOOT MODE: {}
DA PROTOCOL: {}
HW CODE: 0x{:04x}
HW SUBCODE: {}
HW VERSION: {}
SW VERSION: {}
TARGET CONFIG: 0x{:08x}
MEID: {}
SOC ID: {}
SBC: {}
SLA: {}
DAA: {}
PARTITIONS: {}
```

Slot values, from adjacent pools: `STORAGE` is `EMMC`/`UFS`; `BOOT MODE` is the `Brom`,
`Preloader`, `Da` set (pool `0x130093`); `DA PROTOCOL` is `XFlash (V5)` (`0x1247d1`) or
`XML (V6)` (`0x119480`); `HW SUBCODE` is **not** hex-prefixed, unlike `HW CODE`. The block ends at
`PARTITIONS` — its slot carries `<c0> <00>`, which in this encoding means "no further chunk".

### `pgpt` — partition table (`0x1248e4`, line template `0x1230e0`)

```
PARTITION TABLE
{name} addr=0x{addr:x} size=0x{size:x} section={section}
```

`section` is the storage section of the partition (`EMMC-BOOT1`, `EMMC-BOOT2`, … / `LU0`, `LU1`, …
from the engine's partition-kind table). The app parses a line by `indexOf("addr=0x")`,
`indexOf("size=0x")`, `indexOf("section=")` (`x/zamkzqg.java:1489-1520` of the decompiled front
end), and shows `UNKNOWN` when the section is empty.

### `bootctrl-info` (`0x11a24d`)

```
BOOTCTRL
PARTITION: {}
OFFSET: 0x{:x}
SLOT_COUNT: {}
ACTIVE_SLOT: {}
SUFFIX: {}
CRC: OK
SLOT_A_PRIORITY: {}   SLOT_A_TRIES: {}   SLOT_A_SUCCESSFUL: {}
SLOT_A_BOOTABLE: {}   SLOT_A_VERITY: {}
SLOT_B_PRIORITY: {}   SLOT_B_TRIES: {}   SLOT_B_SUCCESSFUL: {}
SLOT_B_BOOTABLE: {}   SLOT_B_VERITY: {}
```

`CRC: OK` is a literal — the block is only printed after its CRC validated, so there is no
"bad CRC" rendering. `OFFSET` is `0x800` (`hacc::OFFSET_SLOT_SUFFIX`), the boot-control block's
offset inside `misc`/`para`.

### Per-verb results

| verb | payload |
| --- | --- |
| `upload`, `read-flash` | `READ COMPLETE\nPARTITION: {}\nBYTES: {}\nFILE: {}` (`0x12167d`) |
| `download`, `scatter-download`, `write-flash` | `WRITE COMPLETE\nPARTITION: {}\nBYTES: {}` (`0x11b4a0`) |
| `erase`, `erase-partition` | `ERASE COMPLETE\nPARTITION: {}\nBYTES: {}` (`0x11a621`) |
| `seccfg` | `SECCFG UPDATED\nSTATE: {}` (`0x119e77`), state `LOCKED`/`UNLOCKED` |
| `bootctrl-set` | `BOOTCTRL UPDATED\n` (`0x11c530`) |
| `reboot` | `REBOOT COMPLETE\nMODE: {}` (`0x11e64c`) |
| `shutdown` | `SHUTDOWN COMPLETE` (`0x123149`) |
| `crash` | `CRASH TRIGGERED\nTARGET: BROM` (`0x122f63`) |
| `scatter-download-v6` | `DOWNLOAD ONLY COMPLETE\nENGINE: XML/V6 WRITE-PARTITIONS\nPARTITIONS: {}` (`0x11bcce`) |
| `scatter-firmware-upgrade` | see below (`0x11cead`) |

### `scatter-firmware-upgrade` (`0x11cead`, continues past `0x11cf30`)

```
FIRMWARE UPGRADE COMPLETE
ENGINE: {}
FLASH_UPDATE_VERSION: {}

SCATTER: {}
CHECKSUM_LEVEL: NONE
HOST_CALLBACK_CONTRACT: {}
HOST_FILESYSTEM_OPS: {}
LAYOUT_CHANGED: {}
POSTFLIGHT_PARTITIONS: {}
AUTO_RELOCK: {}
SECCFG_POLICY: {}
AUTHORIZED_IMAGES: {}
NATIVE_BACKUP_BYTES: {}
NATIVE_BACKUP_RETAINED_BYTES: {}
BOOT_SLOT_POLICY: UNCHANGED
```

Note the blank line after `FLASH_UPDATE_VERSION` — it is a literal in the template, not a typo
here. The engine's own vocabulary for the same transaction, from the FWUP log literals next to
the template (`0x12318b`…`0x1232ee`): `SPFT-V5-TRANSACTION-4`, `SPFT-V6-TRANSACTION-6`,
`XML/V6 FLASH-UPDATE 2.0`, and the two protocol refusals quoted below.

## Refusals and validation messages (verbatim)

| site | message |
| --- | --- |
| `0x122ff4` | `BootControl slot must be 'a' or 'b'` |
| `0x12311b` | `seccfg action must be 'unlock' or 'lock'` |
| `0x11b985` | `Unsupported reboot mode '{}'. Use: normal | home-screen | fastboot | meta | test` |
| `0x124636` / `0x12fb23` | `Neither 'misc' nor 'para' partition found.` / `BootControl read-back mismatch after slot switch` |
| `0x122f7f` | `Penumbra crash is unavailable while the device is already in DA mode. Reboot to Preloader and try again.` |
| `0x12320d` | `XFlash/V5 DA cannot run an XML/V6 Firmware Upgrade` |
| `0x12323f` | `XML/V6 DA requires an XML scatter for Firmware Upgrade` |
| `0x123959` | `Firmware Upgrade plan contains no selected payloads` |

`BootControl slot must be 'a' or 'b'` fixes the operand case: the engine compares lowercase
`a`/`b`, which matches the app lower-casing the slot letter before the call.

One message is deliberately **not** reproduced verbatim: the DA-mode crash refusal above. Its
operative sentence is kept — reboot to Preloader and try again — but the product name it opens with
belongs to the engine and is not carried into a runtime string here. The payload text around it is
unchanged.

## Recovered plan format

The two scatter verbs receive their selection as a plan file, not as a scatter path — the app
freezes its review into a temp file and hands that over as operand 0. Recovered from the writers in
the app half and reproduced in `native/core/src/plan.rs`:

| Plan | Magic | Header | Entry |
|---|---|---|---|
| Firmware Upgrade v2 | `RYNXFWU2!` | `version:u32`, `scatter:str`, `platform:str`, `storage:str`, `scatter_block_size:u64`, `scatter_size:u64`, `scatter_timestamp:u64`, `count:u32` | `name`, `image`, `operation`, `region`, `storage` (str), `address`, `size`, `image_size`, `image_timestamp` (u64), `flags:u8` |
| Download Only v6 | `RYNXDLV61` | `version:u32`, `scatter:str`, `platform:str`, `storage:str`, `count:u32` | `name`, `image` (str), `size:u64` |

Every integer is big-endian, and a string is a `u32` length followed by that many UTF-8 bytes,
refused when the length exceeds the field's limit. The operand's kind is decided by the magic, so a
console invocation that passes a plain scatter still works.

`flags` carries four bits, all of them written by the review sheet in `x/kggugdp.java:4804`:

| Bit | Meaning | Source in the app |
|---|---|---|
| `0x01` | the partition was ticked | `atntgcp(entry)` |
| `0x02` | the scatter entry says `is_reserved` | `pvbzgon && buswjhz` (`x/ezuzoct.java:60`) |
| `0x04` | the scatter entry says `boundary_check` | `utmeivs && ekyqleu` (`x/ezuzoct.java:60`) |
| `0x08` | Auto Relock on the seccfg row | `lsgjyur && name == "seccfg"` |

A plan is refused before any device work when it names a partition twice, when a selected entry has
no image or an empty one, when its flags carry a bit the writer cannot produce, or when a selected
image resolves outside the scatter's own folder — the reference derives every plan path relative to
the scatter and refuses one that escapes it, so a plan cannot reach a file the user never picked.

## What this core does not reproduce

Honest gaps, not oversights:

* **`crash` asserts the bootrom rather than re-handshaking it.** The verb pushes a garbage DA image
  through the preloader protocol (`PlProtocol::send_da` with a 0x100-byte dummy) — the mechanism the
  reference engine's own crash path uses — so the SoC falls back into BROM and the payload is
  `CRASH TRIGGERED` + `TARGET: BROM`/`PRELOADER`, with the DA-mode refusal kept. What it does *not*
  do is the reference's follow-up: re-enumerate and re-handshake the newly-crashed device. On
  Android the descriptor belongs to the app, the assertion destroys it, and `UsbfsPort::reenumerate`
  is a no-op by design (`native/usbfs/src/lib.rs:254`); the app re-attaches the device and hands over
  a fresh descriptor, which is the same end state by a different route.
* **`HW VERSION` / `SW VERSION` come off the wire, not from the engine.** The linked engine reads
  the pair and throws it away: `penumbra-mtk` `core/src/device.rs:228` runs
  `let (hw_subcode, ..) = pl.get_hw_sw_ver()?;` and `core/src/devinfo.rs:20-29` has no field to keep
  the numbers in, so nothing downstream can ask for them. Rather than patch the crate, the transport
  is wrapped: `native/core/src/port_recorder.rs` is an `MtkPort` decorator that forwards every call
  unchanged and only *watches* the one exchange that carries the answer — after `0xFC`
  (`Command::GetHwSwVer`, `core/src/preloader/cmd.rs:61`) goes out, the reply is the echo, then
  `hw_subcode`, `hw_version`, `sw_version` as big-endian u16s, then the status word. Watching adds no
  traffic and cannot change the exchange; any byte that breaks the pattern ends the scan, so an
  unanswered request leaves the labels empty instead of wrong. `Port` is
  `RecordingPort<UsbfsPort>`, and `build_session` snapshots the triple after `dev.init()`. Tests drive
  the engine's real `PlProtocol::get_hw_sw_ver` against a scripted device, plus the short-reply and
  unrelated-traffic cases (`native/core/src/port_recorder.rs`, tests).
* **Firmware-upgrade internals are reproduced from the plan, with the differences named at the end.**
  reference engine runs a full transactional FWUP: immutable plan v2, seccfg preservation and
  recovery, auto-relock policy, native backup bookkeeping, layout-migration detection. This core
  parses the same plan (`native/core/src/plan.rs`: `RYNXFWU2!` v2 and `RYNXDLV61` v1, big-endian,
  u32-length strings) and enforces it as an authorization list — the scatter must still match the
  reviewed size and epoch-millisecond timestamp, every selected image must still match its recorded
  size and timestamp, and the flash may only open payloads the plan names. The second operand, the
  backup directory the app creates (`/sdcard/rynx/Backup/FirmwareUpgrade-<device>-<ms>`), is handed
  to the engine's sink, so the protected-partition copies land there and are read back through the
  same source when a partition has to be restored; `NATIVE_BACKUP_BYTES` and
  `NATIVE_BACKUP_RETAINED_BYTES` are measured from that tree, not copied. seccfg is preserved by
  reading the block before the flash and writing it back afterwards unless Auto Relock is set, in
  which case it is reformatted.

  The reference's protected-data *record* machinery is reproduced as far as its strings allow:
  a `NATIVE-ENGINE-BACKUP` folder is created inside the backup directory and the transaction journal
  files (`PREFLIGHT.txt`, `MUTATION_STARTED.txt`, `SUCCESS.txt`, `SECCFG-PRESERVE.bin`) are written
  best-effort; `record-file.txt` and `record-file.bin` are named as placeholders because their
  content formats are not recoverable from the shipped binary. The payload reports
  `RECORD_FILE_STATUS` / `RECORD_FILE_RAW` / `RECORD_FILE_SUMMARY` lines. `RECORD_FILE_STATUS` is
  `N/A (XFLASH/V5)` when the engine is V5 (`NOT_RECEIVED` otherwise — no other engine's record-file
  reporting was observed); `RECORD_FILE_RAW` and `RECORD_FILE_SUMMARY` are empty. Exact journal
  file contents and the record-file wire format are gaps: they were not recoverable from static
  analysis of the reference `.so` and have not been exercised against silicon.

  Its postflight partition re-audit beyond the count and signature this core can measure, and its own
  layout-migration handling — here `LAYOUT_CHANGED` is a comparison of the partition signature before
  and after — are likewise out of scope. Fields for machinery that does not exist are emitted at their
  true values (`NONE`, `0`, `NO`), never copied from the reference.
* **Dispatch ids, none of this.** `nativeRunCommand`/`nativeRunGuiAction` take an integer
  `commandId` that the app passes through untouched; the engine ignores it, as this core does.

## Bounded negative results

* `search_strings("scatter-download-v6")` returns nothing: the pool is undefined data for Ghidra,
  not a defined string. Presence was established with `search_bytes` over `.rodata`
  (`ev_ba3cf805881eabea865f6b003243e2258ffba453b18f053c74190a137aecff31`).
* No `sgpt`, `efuse-read`, `readback`, `seccfg-set`, `read-partition` or `write-partition` verb
  exists in the pool, the pools adjacent to it, or the app's command gate.
* The engine's `DaProtocol` has no crash entry (42 trait methods, none of them a crash/abort), which
  is why `crash` goes through the preloader protocol instead — the route the reference engine's own
  crash path takes.
