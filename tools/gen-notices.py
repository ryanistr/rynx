#!/usr/bin/env python3
"""Regenerate THIRD-PARTY-NOTICES.md from the crates the APK's libraries actually compile.

The inventory comes from `cargo tree` for the two shipped cdylibs on the Android target, so only
crates that really end up inside librynx_core.so / librynx_adbfastboot.so are listed — the lock
file also pins desktop-only backends (nusb, rusb) that cannot build for Android and are linked
into nothing here.

Every licence text the crates ship is reproduced verbatim: MIT/BSD/ISC require the copyright notice
and permission text to travel with the binary, and Apache-2.0 requires the licence text and any
NOTICE file. Copies that differ by more than whitespace or copyright lines — a few crates ship a
mislabelled Apache text — stay separate entries instead of being folded into one, so what each
crate actually ships is what appears here. When a crate ships only a pointer notice (serialport's
MPL file) the canonical text comes from `tools/licenses/<SPDX>.txt`, committed beside this script.

Usage:  tools/gen-notices.py [--check]
        --check  exit non-zero if THIRD-PARTY-NOTICES.md is out of date (for CI)
"""

from __future__ import annotations

import argparse
import glob
import hashlib
import os
import re
import subprocess
import sys

REPO = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
NATIVE = os.path.join(REPO, "native")
SUPPLIED = os.path.join(REPO, "tools", "licenses")
OUT = os.path.join(REPO, "THIRD-PARTY-NOTICES.md")
TARGET = "aarch64-linux-android"
CRATES = ("rynx-core", "rynx-adbfastboot")
OWN = {"rynx-core", "rynx-adbfastboot", "usbfs"}  # this repository's own crates
LICENSE_FILE = re.compile(r"^(LICEN[CS]E|COPYING|NOTICE)", re.I)
COPYRIGHT = re.compile(r"^\s*(copyright|\(c\)|©).*$", re.I | re.M)
SHORT_NOTICE = 600  # bytes under which a "licence file" is really a pointer to one

# Order matters: the first marker that hits decides the family.
KINDS = (
    ("GNU AFFERO GENERAL PUBLIC LICENSE", "AGPL-3.0"),
    ("GNU LESSER GENERAL PUBLIC LICENSE", "LGPL-3.0"),
    ("GNU GENERAL PUBLIC LICENSE", "GPL-3.0"),
    ("Mozilla Public License", "MPL-2.0"),
    ("Apache License", "Apache-2.0"),
    ("Permission is hereby granted, free of charge", "MIT"),
    ("Permission to use, copy, modify, and distribute this software", "ISC"),
    ("free and unencumbered software released into the public domain", "Unlicense"),
    ("CC0 1.0 Universal", "CC0-1.0"),
    ("Unicode, Inc.", "Unicode-3.0"),
    ("altered source versions must be plainly marked", "Zlib"),
    ("Redistribution and use in source and binary forms", "BSD"),
)
KNOWN_SPDX = ("MIT", "Apache-2.0", "BSD-2-Clause", "BSD-3-Clause", "ISC", "Unlicense",
              "Unicode-3.0", "MPL-2.0", "Zlib", "CC0-1.0", "AGPL-3.0", "GPL-3.0", "LGPL-3.0")


def cargo_tree() -> list[tuple[str, str]]:
    seen: dict[tuple[str, str], None] = {}
    for crate in CRATES:
        out = subprocess.run(
            ["cargo", "+nightly", "tree", "--offline", "--target", TARGET, "-p", crate,
             "-e", "normal", "--prefix", "none"],
            cwd=NATIVE, capture_output=True, text=True, check=True,
        ).stdout
        for line in out.splitlines():
            parts = line.split()
            if len(parts) >= 2:
                seen[(parts[0], parts[1].lstrip("v"))] = None
    return sorted(seen)


def crate_dir(name: str, version: str) -> str | None:
    for root in glob.glob(os.path.expanduser("~/.cargo/registry/src/*")):
        cand = os.path.join(root, f"{name}-{version}")
        if os.path.isdir(cand):
            return cand
    for root in glob.glob(os.path.expanduser("~/.cargo/git/checkouts/*/*")):
        for dirpath, dirnames, filenames in os.walk(root):
            dirnames[:] = [d for d in dirnames if d not in ("target", ".git")]
            if "Cargo.toml" in filenames:
                with open(os.path.join(dirpath, "Cargo.toml"), encoding="utf-8",
                          errors="replace") as fh:
                    text = fh.read()
                if re.search(r'^\s*name\s*=\s*"%s"\s*$' % re.escape(name), text, re.M):
                    return dirpath
    return None


def manifest_license(path: str) -> str | None:
    with open(os.path.join(path, "Cargo.toml"), encoding="utf-8", errors="replace") as fh:
        text = fh.read()
    m = re.search(r'^\s*license\s*=\s*"([^"]+)"', text, re.M)
    if m:
        return m.group(1)
    if re.search(r"license\.workspace\s*=\s*true", text):
        d = path
        for _ in range(8):  # inherit from the workspace manifest that declares it
            d = os.path.dirname(d)
            cand = os.path.join(d, "Cargo.toml")
            if os.path.isfile(cand):
                with open(cand, encoding="utf-8", errors="replace") as fh:
                    wt = fh.read()
                if "[workspace.package]" in wt:
                    m2 = re.search(r'^\s*license\s*=\s*"([^"]+)"',
                                   wt.split("[workspace.package]")[1], re.M)
                    if m2:
                        return m2.group(1)
    return None


def license_files(path: str) -> list[tuple[str, str]]:
    """Licence files in the crate dir, or in the nearest ancestor that has one (git workspaces)."""
    seen: set[str] = set()
    found: list[tuple[str, str]] = []
    d = path
    for _ in range(6):
        for entry in sorted(os.listdir(d)):
            f = os.path.join(d, entry)
            if entry in seen or not os.path.isfile(f) or not LICENSE_FILE.match(entry):
                continue
            with open(f, encoding="utf-8", errors="replace") as fh:
                found.append((os.path.relpath(f, path), fh.read().strip()))
            seen.add(entry)
        if found:
            break
        parent = os.path.dirname(d)
        if parent == d or ".cargo" not in d:
            break  # only climb inside a cargo checkout, never into the filesystem at large
        d = parent
    return found


def normalize(text: str) -> str:
    """Same licence, different wrapping: line endings, trailing spaces, tabs, blank-line runs."""
    text = text.replace("\r\n", "\n").replace("\r", "\n").replace("\t", "    ")
    text = "\n".join(line.rstrip() for line in text.split("\n"))
    text = re.sub(r"\n{3,}", "\n\n", text)
    return text.strip()


def fingerprint(text: str) -> str:
    """Licence text without its copyright lines — MIT texts differ only there."""
    return hashlib.sha1(COPYRIGHT.sub("", normalize(text)).encode()).hexdigest()[:12]


def kind_of(text: str) -> str | None:
    for marker, kind in KINDS:
        if marker in text:
            if kind == "BSD":
                return "BSD-3-Clause" if "endorse or promote" in text else "BSD-2-Clause"
            return kind
    return None


def declared_kinds(spdx: str | None) -> list[str]:
    if not spdx:
        return []
    tokens = re.split(r"\s+(?:OR|AND)\s+|/", spdx)
    return [t.strip() for t in tokens if t.strip() in KNOWN_SPDX]


def source_of(name: str, version: str, path: str) -> str:
    if "registry/src" in path:
        return f"crates.io/{name}/{version}"
    for root in glob.glob(os.path.expanduser("~/.cargo/git/checkouts/*/*")):
        if path.startswith(root):
            return f"git:{os.path.basename(os.path.dirname(root))}@{os.path.basename(root)[:12]}"
    return "local"


def build() -> str:
    crates = cargo_tree()
    rows, texts, missing = [], {}, []
    for name, version in crates:
        if name in OWN:
            continue
        path = crate_dir(name, version)
        if path is None:
            missing.append(f"{name} {version}")
            continue
        spdx = manifest_license(path)
        files = [(fname, normalize(text)) for fname, text in license_files(path)]
        ids = []
        for fname, text in files:
            fp = fingerprint(text)
            entry = texts.setdefault(fp, {"file": fname, "text": text, "crates": [],
                                          "kind": kind_of(text)})
            entry["crates"].append(f"{name} {version}")
            ids.append(fp)
        detected = [texts[i]["kind"] for i in ids if texts[i]["kind"]]
        kinds = list(dict.fromkeys(detected + declared_kinds(spdx)))
        holders = sorted({m.group(0).strip() for _, t in files for m in COPYRIGHT.finditer(t)})
        short = [f for f in files if len(f[1]) < SHORT_NOTICE]
        rows.append({"name": name, "version": version,
                     "license": spdx or (kinds[0] if kinds else "UNKNOWN"),
                     "source": source_of(name, version, path), "ids": ids, "kinds": kinds,
                     "holders": holders or ["(no copyright line in the licence file)"],
                     "short": short})

    # The fullest text each licence family has among the crates; a family whose crates only ship a
    # pointer notice (serialport's MPL file) takes its text from tools/licenses/<SPDX>.txt instead.
    full_text: dict[str, str] = {}
    for fp, entry in texts.items():
        if entry["kind"] and len(entry["text"]) >= SHORT_NOTICE:
            if entry["kind"] not in full_text or len(entry["text"]) > len(texts[full_text[entry["kind"]]]["text"]):
                full_text[entry["kind"]] = fp
    supplied: dict[str, str] = {}
    for kind in sorted({k for r in rows for k in r["kinds"]} - set(full_text)):
        for cand in (f"{kind}.txt", f"{kind}.md"):
            p = os.path.join(SUPPLIED, cand)
            if os.path.isfile(p):
                with open(p, encoding="utf-8", errors="replace") as fh:
                    supplied[kind] = normalize(fh.read())
                break

    lines = [
        "# Third-party notices",
        "",
        "Rynx ships as the APK that `tools/build-apk.sh` produces; its two libraries are built from",
        f"the {len(rows)} crates listed below. The inventory is generated from `cargo tree` for those",
        "two libraries on `aarch64-linux-android`, so it names exactly the crates inside the shipped",
        "binaries — the lock file also pins desktop-only backends (nusb, rusb) that cannot build for",
        "Android and are linked into nothing here.",
        "",
        "Licence texts are reproduced verbatim, one entry per distinct text. Copies that differ by",
        "more than whitespace or copyright lines are kept apart rather than folded together, so what",
        "each crate actually ships is what appears here; each heading says how many crates ship it.",
        "",
        "Regenerate with `tools/gen-notices.py`; CI can run `tools/gen-notices.py --check`.",
        "",
        "## Inventory",
        "",
        "| Crate | Version | Licence | Source | Licence text |",
        "| --- | --- | --- | --- | --- |",
    ]
    for r in sorted(rows, key=lambda r: r["name"].lower()):
        refs = list(dict.fromkeys(f"[`{i}`](#licence-{i})" for i in r["ids"]))
        # a crate that ships only a pointer notice still links to the text of the licence it names
        for k in r["kinds"]:
            if any(texts[i]["kind"] == k and len(texts[i]["text"]) >= SHORT_NOTICE for i in r["ids"]):
                continue
            target = full_text.get(k) or k
            ref = f"[`{target}`](#licence-{target})"
            if ref not in refs:
                refs.append(ref)
        lines.append(f"| {r['name']} | {r['version']} | {r['license']} | `{r['source']}` | "
                     f"{', '.join(refs) if refs else '—'} |")

    lines += ["", "## Copyright notices", "",
              "The copyright lines each licence file carries, gathered here so a reader does not",
              "have to scan every text below.", ""]
    for r in sorted(rows, key=lambda r: r["name"].lower()):
        lines.append(f"* `{r['name']} {r['version']}` — {r['license']}")
        for h in r["holders"]:
            lines.append(f"  * {h}")

    if any(r["short"] for r in rows):
        lines += ["", "## Notices that point elsewhere", "",
                  "These crates ship a short notice instead of the text of the licence they name;",
                  "that text is reproduced under *Licence texts* below.", ""]
        for r in sorted(rows, key=lambda r: r["name"].lower()):
            for fname, text in r["short"]:
                lines += [f"* `{r['name']} {r['version']}` (`{fname}`) — {r['license']}",
                          "", "  ```", *[f"  {l}" for l in text.split("\n")], "  ```", ""]

    lines += ["", "## Licence texts", ""]
    for fp, entry in sorted(texts.items(), key=lambda kv: (kv[1]["kind"] or "zz", kv[0])):
        if entry["kind"]:
            kind = entry["kind"]
        elif len(entry["text"]) < SHORT_NOTICE:
            kind = "pointer notice"
        else:
            kind = "unrecognised licence text"
        here = sorted(entry["crates"])
        lines += [f'<a id="licence-{fp}"></a>', "",
                  f"### `{kind}` — `{fp}` ({len(here)} crate(s), as shipped in `{entry['file']}`)",
                  "",
                  ", ".join(f"`{c}`" for c in here), "",
                  "```", entry["text"], "```", ""]
    for kind, text in sorted(supplied.items()):
        lines += [f'<a id="licence-{kind}"></a>', "",
                  f"### `{kind}` — supplied text (no crate in this build ships the full text)", "",
                  f"Taken from `tools/licenses/{kind}.txt`.", "",
                  "```", text, "```", ""]

    if missing:
        lines += ["## Not resolved", "",
                  "Not found in the local cargo cache, so no licence text could be copied — resolve",
                  "them before distributing a binary:", ""]
        lines += [f"* {m}" for m in missing] + [""]
    return "\n".join(lines).rstrip() + "\n"


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--check", action="store_true")
    args = ap.parse_args()
    body = build()
    current = open(OUT, encoding="utf-8").read() if os.path.isfile(OUT) else None
    if args.check:
        if current != body:
            print("THIRD-PARTY-NOTICES.md is out of date; run tools/gen-notices.py", file=sys.stderr)
            return 1
        print("THIRD-PARTY-NOTICES.md is current")
        return 0
    with open(OUT, "w", encoding="utf-8") as fh:
        fh.write(body)
    print(f"wrote {OUT} ({len(body)} bytes)")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
