# Credits

Rynx is a frontend for MediaTek service work. The protocols it depends on were
documented and implemented by other open-source projects long before this one, and
the native core builds on them rather than reinventing them.

| Project | Author | Licence | Used for |
| --- | --- | --- | --- |
| [Penumbra](https://github.com/shomykohai/penumbra) | Shomy | AGPL-3.0-or-later | BROM/Preloader protocol, DA/XML-DA/XFlash DA protocols, DA SLA, scatter and partition handling, storage backends, patching utilities |
| [mtk-payloads](https://github.com/shomykohai/mtk-payloads) | Shomy | AGPL-3.0 | Download Agent payloads used for DA upload |
| [mtkclient](https://github.com/bkerler/mtkclient) | Bjoern Kerler | GPL-3.0 | Protocol documentation and reference behaviour |
| [hacc](https://github.com/shomykohai/hacc) | Shomy | MIT | MediaTek data structures parser used by the core |

## Licensing consequence

The engine crates are AGPL-3.0-or-later, and a binary that links them is a combined work that must be
conveyed under AGPL-3.0-or-later as a whole. This repository is therefore AGPL-3.0-or-later
throughout — `LICENSE`, and `license = "AGPL-3.0-or-later"` in `native/Cargo.toml` — instead of
permissive. Every third-party copyright notice and licence text that has to travel with the shipped
binaries is reproduced in [THIRD-PARTY-NOTICES.md](THIRD-PARTY-NOTICES.md), which
`tools/gen-notices.py` generates from the crates the two libraries actually link (`--check` for CI).

What each dependency asks of a redistribution:

| Component | Terms that matter |
| --- | --- |
| Engine crates (AGPL-3.0-or-later) | Strong copyleft: the corresponding source ships with the binary. The pinned revisions are public, and nothing here patches them. |
| `hacc` (MIT), the MIT/Apache-2.0 crates | Attribution: copyright notice and licence text in `THIRD-PARTY-NOTICES.md`. |
| `serialport` (MPL-2.0) | File-level copyleft — changes to its files would stay MPL-2.0. It ships only a pointer notice, so the full text is committed at `tools/licenses/MPL-2.0.txt`. |
| Download Agent payloads | Supplied by the engine crates; they are not vendored here, so the APK carries no payload blob of its own. |
| mtkclient (GPL-3.0) | Credited for protocol documentation and reference behaviour; no source from it is vendored, and AGPL-3.0-or-later is compatible with GPL-3.0 either way. |
