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

The engine crates are AGPL-3.0-or-later. A binary that links them is a combined work
and must be distributed under AGPL-3.0-or-later as a whole, with the corresponding
source available. Keeping this repository Apache-2.0-only is possible only while it
contains no engine code — i.e. while the native core is absent. See `README.md`.
