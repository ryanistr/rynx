/*! Immutable transaction plans the app writes before it hands a firmware package to the engine.

The app does not pass a scatter path for a firmware upgrade any more: it reviews the scatter,
freezes the selection into a temporary `.plan` file and passes *that* as the first operand. The
plan is the authorization list — the engine may only open images named in it, and the scatter it
reads must still be the exact file (size and timestamp) the user reviewed.

Layout, all integers big-endian, strings as `u32` length + UTF-8 bytes:

FWUP (`RYNXFWU2!`, v2)
    magic[9] version:u32 scatter:str platform:str storage:str
    scatter_block_size:u64 scatter_size:u64 scatter_timestamp:u64 count:u32
    count × (name:str image:str operation:str region:str storage:str
             address:u64 size:u64 image_size:u64 image_timestamp:u64 flags:u8)

DLV6 (`RYNXDLV61`, v1)
    magic[9] version:u32 scatter:str platform:str storage:str count:u32
    count × (name:str image:str size:u64)

Strings carry per-field length limits that the writer enforces; a plan that breaks them could not
have come from the app, so the parser refuses it the same way it refuses a bad magic.
*/

use std::collections::BTreeSet;
use std::fmt::Write as _;
use std::path::{Path, PathBuf};

/// Magic the app writes for a firmware-upgrade plan. Nine bytes, not eight.
pub const FWUP_MAGIC: &[u8] = b"RYNXFWU2!";
/// Magic the app writes for a download-only plan.
pub const DLV6_MAGIC: &[u8] = b"RYNXDLV61";
pub const FWUP_VERSION: u32 = 2;
pub const DLV6_VERSION: u32 = 1;

/// Flag bit set when the user ticked the partition in the review sheet.
pub const FLAG_SELECTED: u8 = 0x01;
/// Scatter entry's `is_reserved` attribute, carried but not acted on.
#[allow(dead_code)]
pub const FLAG_RESERVED: u8 = 0x02;
/// Scatter entry's `boundary_check` attribute, carried but not acted on.
#[allow(dead_code)]
pub const FLAG_BOUNDARY_CHECK: u8 = 0x04;
/// Flag bits the writer can produce; anything else did not come from the app.
pub const FLAG_MASK: u8 = 0x0F;

/// Flag bit the review sheet sets on the seccfg entry when Auto Relock was ticked.
pub const FLAG_RELOCK: u8 = 0x08;

const LIMIT_SCATTER: usize = 4096;
const LIMIT_PLATFORM: usize = 256;
const LIMIT_STORAGE: usize = 64;
const LIMIT_NAME: usize = 128;
const LIMIT_IMAGE: usize = 4096;
const LIMIT_OPERATION: usize = 64;
const LIMIT_REGION: usize = 64;

#[derive(Debug, Clone, PartialEq, Eq)]
pub struct FwupEntry {
    pub name: String,
    pub image: String,
    pub operation: String,
    pub region: String,
    pub storage: String,
    pub address: u64,
    pub size: u64,
    pub image_size: u64,
    pub image_timestamp: u64,
    pub flags: u8,
}

impl FwupEntry {
    pub fn selected(&self) -> bool {
        self.flags & FLAG_SELECTED != 0
    }
}

#[derive(Debug, Clone, PartialEq, Eq)]
pub struct FwupPlan {
    pub scatter_path: String,
    pub platform: String,
    pub storage: String,
    pub scatter_block_size: u64,
    pub scatter_size: u64,
    pub scatter_timestamp: u64,
    pub entries: Vec<FwupEntry>,
}

impl FwupPlan {
    /// Names the user froze into the plan, i.e. everything the engine is allowed to write.
    pub fn selected_names(&self) -> BTreeSet<String> {
        self.entries
            .iter()
            .filter(|entry| entry.selected())
            .map(|entry| entry.name.to_ascii_lowercase())
            .collect()
    }

    pub fn selected(&self) -> impl Iterator<Item = &FwupEntry> {
        self.entries.iter().filter(|entry| entry.selected())
    }
}

#[derive(Debug, Clone, PartialEq, Eq)]
pub struct Dlv6Entry {
    pub name: String,
    pub image: String,
    pub size: u64,
}

#[derive(Debug, Clone, PartialEq, Eq)]
pub struct Dlv6Plan {
    pub scatter_path: String,
    pub platform: String,
    pub storage: String,
    pub entries: Vec<Dlv6Entry>,
}

#[derive(Debug, Clone, PartialEq, Eq)]
pub enum Format {
    Xml,
    Yaml,
}

impl Format {
    pub fn of(scatter: &str) -> Format {
        if scatter.trim_start().starts_with('<') {
            Format::Xml
        } else {
            Format::Yaml
        }
    }
}

struct Cursor<'a> {
    bytes: &'a [u8],
    offset: usize,
    truncation: &'static str,
}

impl<'a> Cursor<'a> {
    fn new(bytes: &'a [u8], truncation: &'static str) -> Self {
        Self { bytes, offset: 0, truncation }
    }

    fn take(&mut self, count: usize) -> Result<&'a [u8], String> {
        let end = self
            .offset
            .checked_add(count)
            .filter(|end| *end <= self.bytes.len())
            // The plan ends where the bytes run out, not where the missing field began.
            .ok_or_else(|| format!("{} {}", self.truncation, self.bytes.len()))?;
        let slice = &self.bytes[self.offset..end];
        self.offset = end;
        Ok(slice)
    }

    fn u8(&mut self) -> Result<u8, String> {
        Ok(self.take(1)?[0])
    }

    fn u32(&mut self) -> Result<u32, String> {
        let raw = self.take(4)?;
        Ok(u32::from_be_bytes([raw[0], raw[1], raw[2], raw[3]]))
    }

    fn u64(&mut self) -> Result<u64, String> {
        let raw = self.take(8)?;
        let mut word = [0u8; 8];
        word.copy_from_slice(raw);
        Ok(u64::from_be_bytes(word))
    }

    fn str(&mut self, limit: usize, field: &str, invalid: &str) -> Result<String, String> {
        let len = self.u32()? as usize;
        if len > limit {
            return Err(format!("{invalid} {field}"));
        }
        let raw = self.take(len)?;
        String::from_utf8(raw.to_vec()).map_err(|_| format!("{invalid} {field}"))
    }

    fn done(&self) -> bool {
        self.offset == self.bytes.len()
    }
}

/// Parse a firmware-upgrade plan. Every failure names the field, because the app surfaces the
/// string verbatim in the log pane.
pub fn parse_fwup(bytes: &[u8]) -> Result<FwupPlan, String> {
    const TRUNC: &str = "Firmware Upgrade plan is truncated at";
    const INVALID: &str = "Firmware Upgrade plan has invalid";
    const HEADER: usize = FWUP_MAGIC.len() + 4;
    if bytes.len() < HEADER {
        return Err(format!("Firmware Upgrade plan size is invalid: {}", bytes.len()));
    }
    if &bytes[..FWUP_MAGIC.len()] != FWUP_MAGIC {
        return Err("Firmware Upgrade plan magic is invalid".into());
    }
    let mut cursor = Cursor::new(bytes, TRUNC);
    cursor.take(FWUP_MAGIC.len())?;
    let version = cursor.u32()?;
    if version != FWUP_VERSION {
        return Err(format!("Unsupported Firmware Upgrade plan version: {version}"));
    }
    let scatter_path = cursor.str(LIMIT_SCATTER, "scatter path", INVALID)?;
    let platform = cursor.str(LIMIT_PLATFORM, "platform", INVALID)?;
    let storage = cursor.str(LIMIT_STORAGE, "storage", INVALID)?;
    let scatter_block_size = cursor.u64()?;
    let scatter_size = cursor.u64()?;
    let scatter_timestamp = cursor.u64()?;
    let count = cursor.u32()? as usize;
    if count > bytes.len() {
        return Err(format!("{INVALID} partition count"));
    }
    let mut entries = Vec::with_capacity(count);
    for _ in 0..count {
        let name = cursor.str(LIMIT_NAME, "partition name", INVALID)?;
        let image = cursor.str(LIMIT_IMAGE, "image path", INVALID)?;
        let operation = cursor.str(LIMIT_OPERATION, "operation type", INVALID)?;
        let region = cursor.str(LIMIT_REGION, "region", INVALID)?;
        let storage = cursor.str(LIMIT_STORAGE, "entry storage", INVALID)?;
        let address = cursor.u64()?;
        let size = cursor.u64()?;
        let image_size = cursor.u64()?;
        let image_timestamp = cursor.u64()?;
        let flags = cursor.u8()?;
        entries.push(FwupEntry {
            name,
            image,
            operation,
            region,
            storage,
            address,
            size,
            image_size,
            image_timestamp,
            flags,
        });
    }
    if !cursor.done() {
        return Err("Firmware Upgrade plan has trailing data".into());
    }
    if scatter_path.is_empty() || platform.is_empty() || storage.is_empty() || entries.is_empty() {
        return Err("Firmware Upgrade plan identity is incomplete".into());
    }
    if let Some(entry) = entries.iter().find(|entry| entry.flags & !FLAG_MASK != 0) {
        return Err(format!("Unknown Firmware Upgrade flags for '{}'", entry.name));
    }
    if let Some(entry) = entries.iter().find(|entry| entry.selected() && entry.image.is_empty()) {
        return Err(format!("Firmware Upgrade plan has no image for '{}'", entry.name));
    }
    let mut seen = BTreeSet::new();
    for entry in &entries {
        if !seen.insert(entry.name.to_ascii_lowercase()) {
            return Err(format!(
                "Duplicate Firmware Upgrade partition: '{}'",
                entry.name
            ));
        }
    }
    if let Some(entry) = entries
        .iter()
        .find(|entry| entry.selected() && !inside_scatter(&scatter_path, &entry.image))
    {
        return Err(format!(
            "Authorized image escaped the scatter folder: '{}'",
            entry.name
        ));
    }
    Ok(FwupPlan {
        scatter_path,
        platform,
        storage,
        scatter_block_size,
        scatter_size,
        scatter_timestamp,
        entries,
    })
}

pub fn parse_dlv6(bytes: &[u8]) -> Result<Dlv6Plan, String> {
    const TRUNC: &str = "V6 Download Only plan is truncated at";
    const INVALID: &str = "V6 Download Only plan has invalid";
    const HEADER: usize = DLV6_MAGIC.len() + 4;
    if bytes.len() < HEADER {
        return Err(format!("V6 Download Only plan size is invalid: {}", bytes.len()));
    }
    if &bytes[..DLV6_MAGIC.len()] != DLV6_MAGIC {
        return Err("V6 Download Only plan magic is invalid".into());
    }
    let mut cursor = Cursor::new(bytes, TRUNC);
    cursor.take(DLV6_MAGIC.len())?;
    let version = cursor.u32()?;
    if version != DLV6_VERSION {
        return Err(format!("Unsupported V6 Download Only plan version: {version}"));
    }
    let scatter_path = cursor.str(LIMIT_SCATTER, "scatter path", INVALID)?;
    let platform = cursor.str(LIMIT_PLATFORM, "platform", INVALID)?;
    let storage = cursor.str(LIMIT_STORAGE, "storage", INVALID)?;
    let count = cursor.u32()? as usize;
    if count > bytes.len() {
        return Err(format!("{INVALID} partition count"));
    }
    let mut entries = Vec::with_capacity(count);
    for _ in 0..count {
        let name = cursor.str(LIMIT_NAME, "partition name", INVALID)?;
        let image = cursor.str(LIMIT_IMAGE, "image path", INVALID)?;
        let size = cursor.u64()?;
        entries.push(Dlv6Entry { name, image, size });
    }
    if !cursor.done() {
        return Err("V6 Download Only plan has trailing data".into());
    }
    if scatter_path.is_empty() || platform.is_empty() || storage.is_empty() {
        return Err("V6 Download Only scatter identity is incomplete".into());
    }
    if entries.is_empty() {
        return Err("No V6 Download Only payloads are selected".into());
    }
    if let Some(entry) = entries.iter().find(|entry| entry.image.is_empty()) {
        return Err(format!("V6 Download Only image path is empty for {}", entry.name));
    }
    Ok(Dlv6Plan {
        scatter_path,
        platform,
        storage,
        entries,
    })
}

/// Drop every partition the user did not freeze into the plan, keeping the file's own syntax so
/// the engine's scatter parser sees a package identical to the reviewed one minus the exclusions.
pub fn filter_scatter(content: &str, selected: &BTreeSet<String>) -> String {
    match Format::of(content) {
        Format::Xml => filter_xml(content, selected),
        Format::Yaml => filter_yaml(content, selected),
    }
}

fn filter_xml(content: &str, selected: &BTreeSet<String>) -> String {
    let mut out = String::with_capacity(content.len());
    let mut rest = content;
    let mut kept = 0usize;
    while let Some(open) = rest.find("<partition") {
        out.push_str(&rest[..open]);
        rest = &rest[open..];
        let Some(close) = rest.find("</partition>") else {
            out.push_str(rest);
            return out;
        };
        let block = &rest[..close + "</partition>".len()];
        rest = &rest[close + "</partition>".len()..];
        match xml_name(block) {
            Some(name) if selected.contains(&name.to_ascii_lowercase()) => {
                out.push_str(block);
                kept += 1;
            }
            Some(_) => {}
            None => out.push_str(block),
        }
    }
    out.push_str(rest);
    if kept == 0 { content.to_string() } else { out }
}

fn xml_name(block: &str) -> Option<String> {
    let open = block.find("<partition_name>")? + "<partition_name>".len();
    let close = block[open..].find("</partition_name>")? + open;
    Some(block[open..close].trim().to_string())
}

fn filter_yaml(content: &str, selected: &BTreeSet<String>) -> String {
    let mut out = String::with_capacity(content.len());
    let mut kept = 0usize;
    let mut dropping = false;
    for line in content.split_inclusive('\n') {
        if line.trim_start().starts_with("- partition_name:") {
            let name = line
                .split_once("- partition_name:")
                .map(|(_, rest)| rest.trim().trim_matches('"').trim_matches('\'').to_string())
                .unwrap_or_default();
            dropping = !selected.contains(&name.to_ascii_lowercase());
            if !dropping {
                kept += 1;
            }
        }
        if !dropping {
            out.push_str(line);
        }
    }
    if kept == 0 { content.to_string() } else { out }
}

/// `name → canonical image path` for every selected entry, so the engine can only open files the
/// plan authorized even when the scatter spells them differently.
pub fn authorized_images<'a>(
    entries: impl Iterator<Item = (&'a str, &'a str)>,
) -> Vec<(String, String)> {
    entries
        .map(|(name, image)| (name.to_ascii_lowercase(), image.to_string()))
        .collect()
}

/// Whether a plan path stays inside the folder that holds the scatter.
///
/// The reference derives every plan path relative to the scatter's own folder and refuses one that
/// escapes it, so a plan cannot reach a file the user never picked.
pub fn inside_scatter(scatter_path: &str, image: &str) -> bool {
    let folder = Path::new(scatter_path)
        .parent()
        .unwrap_or_else(|| Path::new("/"));
    Path::new(image).starts_with(folder)
}

/// Resolve a scatter-relative image path against the plan's authorization list.
pub fn authorize(request: &str, scatter_dir: &Path, allowed: &[(String, String)]) -> Option<PathBuf> {
    let base = Path::new(request)
        .file_name()
        .map(|name| name.to_string_lossy().to_ascii_lowercase())?;
    let candidate = if Path::new(request).is_absolute() {
        PathBuf::from(request)
    } else {
        scatter_dir.join(request)
    };
    let key = candidate
        .file_name()
        .map(|name| name.to_string_lossy().to_ascii_lowercase())
        .unwrap_or_else(|| base.clone());
    let entry = allowed.iter().find(|(_, image)| {
        let allowed_name = Path::new(image)
            .file_name()
            .map(|name| name.to_string_lossy().to_ascii_lowercase());
        allowed_name.as_deref() == Some(key.as_str())
    })?;
    Some(PathBuf::from(&entry.1))
}

/// Human-readable dump the app puts in the log pane before the transaction starts.
pub fn describe_fwup(plan: &FwupPlan, format: Format) -> String {
    let mut text = String::new();
    let _ = write!(
        text,
        "[FWUP] Preflight: parsing immutable Firmware Upgrade plan v2\n\
         [FWUP] Scatter: {} ({}, {} bytes)\n\
         [FWUP] Review: {} partition(s), {} selected",
        plan.scatter_path,
        match format {
            Format::Xml => "XML/V6",
            Format::Yaml => "XFlash/V5",
        },
        plan.scatter_size,
        plan.entries.len(),
        plan.selected().count()
    );
    text
}

#[cfg(test)]
mod tests {
    use super::*;

    fn put_str(out: &mut Vec<u8>, value: &str) {
        out.extend_from_slice(&(value.len() as u32).to_be_bytes());
        out.extend_from_slice(value.as_bytes());
    }

    fn fwup(entries: &[(&str, &str, u64, u64, u8)], scatter: &str) -> Vec<u8> {
        let mut out = Vec::new();
        out.extend_from_slice(FWUP_MAGIC);
        out.extend_from_slice(&FWUP_VERSION.to_be_bytes());
        put_str(&mut out, scatter);
        put_str(&mut out, "MT6893");
        put_str(&mut out, "UFS");
        out.extend_from_slice(&4096u64.to_be_bytes());
        out.extend_from_slice(&1234u64.to_be_bytes());
        out.extend_from_slice(&1_700_000_000u64.to_be_bytes());
        out.extend_from_slice(&(entries.len() as u32).to_be_bytes());
        for (name, image, size, image_size, flags) in entries {
            put_str(&mut out, name);
            put_str(&mut out, image);
            put_str(&mut out, "UPDATE");
            put_str(&mut out, "EMMC_USER");
            put_str(&mut out, "UFS");
            out.extend_from_slice(&0u64.to_be_bytes());
            out.extend_from_slice(&size.to_be_bytes());
            out.extend_from_slice(&image_size.to_be_bytes());
            out.extend_from_slice(&1_700_000_001u64.to_be_bytes());
            out.push(*flags);
        }
        out
    }

    fn dlv6(entries: &[(&str, &str, u64)]) -> Vec<u8> {
        let mut out = Vec::new();
        out.extend_from_slice(DLV6_MAGIC);
        out.extend_from_slice(&DLV6_VERSION.to_be_bytes());
        put_str(&mut out, "/sdcard/scatter.xml");
        put_str(&mut out, "MT6893");
        put_str(&mut out, "UFS");
        out.extend_from_slice(&(entries.len() as u32).to_be_bytes());
        for (name, image, size) in entries {
            put_str(&mut out, name);
            put_str(&mut out, image);
            out.extend_from_slice(&size.to_be_bytes());
        }
        out
    }

    #[test]
    fn fwup_round_trips_the_writer_layout() {
        let bytes = fwup(
            &[
                ("boot", "/sdcard/images/boot.img", 1 << 20, 900_000, FLAG_SELECTED),
                ("userdata", "", 1 << 30, 0, 0),
            ],
            "/sdcard/scatter.xml",
        );
        let plan = parse_fwup(&bytes).expect("plan parses");
        assert_eq!(plan.scatter_path, "/sdcard/scatter.xml");
        assert_eq!(plan.platform, "MT6893");
        assert_eq!(plan.scatter_block_size, 4096);
        assert_eq!(plan.entries.len(), 2);
        assert_eq!(plan.entries[0].address, 0);
        assert_eq!(plan.entries[0].image_size, 900_000);
        assert_eq!(plan.entries[0].image_timestamp, 1_700_000_001);
        assert!(plan.entries[0].selected());
        assert!(!plan.entries[1].selected());
        assert_eq!(plan.selected().count(), 1);
    }

    #[test]
    fn fwup_refuses_a_foreign_magic_before_reading_anything_else() {
        let mut bytes = fwup(&[("boot", "/a", 1, 1, 1)], "/s");
        bytes[0] = b'X';
        assert_eq!(parse_fwup(&bytes).unwrap_err(), "Firmware Upgrade plan magic is invalid");
    }

    #[test]
    fn fwup_names_the_version_it_refuses() {
        let mut bytes = fwup(&[("boot", "/a", 1, 1, 1)], "/s");
        bytes[FWUP_MAGIC.len() + 3] = 3;
        assert_eq!(
            parse_fwup(&bytes).unwrap_err(),
            "Unsupported Firmware Upgrade plan version: 3"
        );
    }

    #[test]
    fn fwup_reports_the_offset_where_it_ran_out() {
        let bytes = fwup(&[("boot", "/a", 1, 1, 1)], "/s");
        let cut = bytes.len() - 3;
        let message = parse_fwup(&bytes[..cut]).unwrap_err();
        assert!(message.starts_with("Firmware Upgrade plan is truncated at "), "{message}");
        assert!(message.ends_with(&cut.to_string()), "{message}");
    }

    #[test]
    fn fwup_refuses_trailing_data() {
        let mut bytes = fwup(&[("boot", "/a", 1, 1, 1)], "/s");
        bytes.push(0);
        assert_eq!(parse_fwup(&bytes).unwrap_err(), "Firmware Upgrade plan has trailing data");
    }

    #[test]
    fn fwup_refuses_an_empty_identity_or_selection() {
        let empty_scatter = fwup(&[("boot", "/a", 1, 1, 1)], "");
        assert_eq!(
            parse_fwup(&empty_scatter).unwrap_err(),
            "Firmware Upgrade plan identity is incomplete"
        );
        let no_entries = fwup(&[], "/s");
        assert_eq!(
            parse_fwup(&no_entries).unwrap_err(),
            "Firmware Upgrade plan identity is incomplete"
        );
    }

    #[test]
    fn fwup_refuses_flag_bits_the_app_cannot_write() {
        let bytes = fwup(&[("boot", "/a", 1, 1, 0x81)], "/s");
        assert_eq!(
            parse_fwup(&bytes).unwrap_err(),
            "Unknown Firmware Upgrade flags for 'boot'"
        );
    }

    #[test]
    fn fwup_refuses_a_selected_entry_without_an_image() {
        let bytes = fwup(&[("boot", "", 1, 0, FLAG_SELECTED)], "/s");
        assert_eq!(
            parse_fwup(&bytes).unwrap_err(),
            "Firmware Upgrade plan has no image for 'boot'"
        );
    }

    #[test]
    fn fwup_size_error_wins_over_the_magic_check() {
        assert_eq!(
            parse_fwup(b"RYNX").unwrap_err(),
            "Firmware Upgrade plan size is invalid: 4"
        );
    }

    #[test]
    fn dlv6_round_trips_and_keeps_selection_order() {
        let plan = parse_dlv6(&dlv6(&[
            ("boot", "/sdcard/boot.img", 1 << 20),
            ("vendor", "/sdcard/vendor.img", 1 << 22),
        ]))
        .expect("plan parses");
        assert_eq!(plan.scatter_path, "/sdcard/scatter.xml");
        assert_eq!(plan.entries.len(), 2);
        assert_eq!(plan.entries[1].size, 1 << 22);
    }

    #[test]
    fn dlv6_refuses_an_empty_selection_and_an_empty_image_path() {
        assert_eq!(
            parse_dlv6(&dlv6(&[])).unwrap_err(),
            "No V6 Download Only payloads are selected"
        );
        assert_eq!(
            parse_dlv6(&dlv6(&[("boot", "", 1)])).unwrap_err(),
            "V6 Download Only image path is empty for boot"
        );
    }

    #[test]
    fn filtering_keeps_only_the_reviewed_partitions() {
        let xml = "<scatter>\n<partition>\n<partition_name>boot</partition_name>\n<file_name>boot.img</file_name>\n</partition>\n<partition>\n<partition_name>vendor</partition_name>\n<file_name>vendor.img</file_name>\n</partition>\n</scatter>\n";
        let selected = BTreeSet::from(["boot".to_string()]);
        let filtered = filter_scatter(xml, &selected);
        assert!(filtered.contains("boot"), "{filtered}");
        assert!(!filtered.contains("vendor"), "{filtered}");
        assert!(filtered.trim_end().ends_with("</scatter>"), "{filtered}");
    }

    #[test]
    fn filtering_yaml_drops_partition_blocks() {
        let yaml = "general: MTK_PLATFORM_CFG\nstorage: UFS\n- partition_name: boot\n  file_name: boot.img\n  is_download: true\n- partition_name: userdata\n  file_name: userdata.img\n  is_download: true\n";
        let selected = BTreeSet::from(["boot".to_string()]);
        let filtered = filter_scatter(yaml, &selected);
        assert!(filtered.contains("boot.img"), "{filtered}");
        assert!(!filtered.contains("userdata"), "{filtered}");
        assert!(filtered.contains("general: MTK_PLATFORM_CFG"), "{filtered}");
    }

    #[test]
    fn authorization_resolves_a_relative_scatter_path_to_the_plan_image() {
        let allowed = authorized_images([("boot", "/sdcard/images/boot.img")].into_iter());
        let resolved = authorize("images/boot.img", Path::new("/sdcard"), &allowed)
            .expect("authorized");
        assert_eq!(resolved, PathBuf::from("/sdcard/images/boot.img"));
        assert!(authorize("images/vendor.img", Path::new("/sdcard"), &allowed).is_none());
    }

    #[test]
    fn fwup_refuses_a_path_that_leaves_the_scatter_folder() {
        let bytes = fwup(
            &[("boot", "/elsewhere/boot.img", 1 << 20, 900_000, FLAG_SELECTED)],
            "/sdcard/scatter.xml",
        );
        assert_eq!(
            parse_fwup(&bytes).unwrap_err(),
            "Authorized image escaped the scatter folder: 'boot'"
        );
        let inside = fwup(
            &[("boot", "/sdcard/boot.img", 1 << 20, 900_000, FLAG_SELECTED)],
            "/sdcard/scatter.xml",
        );
        assert!(parse_fwup(&inside).is_ok());
    }

    #[test]
    fn fwup_refuses_a_partition_named_twice() {
        let bytes = fwup(
            &[
                ("boot", "/sdcard/boot.img", 1 << 20, 900_000, FLAG_SELECTED),
                ("Boot", "/sdcard/boot2.img", 1 << 20, 900_000, 0),
            ],
            "/sdcard/scatter.xml",
        );
        assert_eq!(
            parse_fwup(&bytes).unwrap_err(),
            "Duplicate Firmware Upgrade partition: 'Boot'"
        );
    }

    #[test]
    fn the_scatter_attributes_ride_in_the_plan_flags() {
        let bytes = fwup(
            &[(
                "boot",
                "/sdcard/boot.img",
                1 << 20,
                900_000,
                FLAG_SELECTED | FLAG_RESERVED,
            )],
            "/sdcard/scatter.xml",
        );
        let plan = parse_fwup(&bytes).expect("plan parses");
        assert_eq!(plan.entries[0].flags, FLAG_SELECTED | FLAG_RESERVED);

        let bytes = fwup(
            &[(
                "boot",
                "/sdcard/boot.img",
                1 << 20,
                900_000,
                FLAG_SELECTED | FLAG_BOUNDARY_CHECK,
            )],
            "/sdcard/scatter.xml",
        );
        let plan = parse_fwup(&bytes).expect("plan parses");
        assert_eq!(plan.entries[0].flags, FLAG_SELECTED | FLAG_BOUNDARY_CHECK);
    }
}
