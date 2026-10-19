//! The fastboot conversation: command framing, one-shot transfers, flash with sparse parts.
//!
//! The target answers every command with a status frame — `OKAY`, `FAIL`, `INFO` or `DATA` — and a
//! download is `DATA<size>` followed by the payload bytes and a final `OKAY`. A sparse image larger
//! than the download limit is one `flash:` followed by as many `download:` continuations as the
//! image needs; that sequence is the reason `flash:` is sent before the first byte rather than after
//! the last.

use std::fs::File;
use std::io::{Read, Seek, SeekFrom, Write};
use std::path::Path;
use std::sync::atomic::{AtomicBool, Ordering};

use crate::sparse::{self, Part};
use crate::wire::Wire;

const RESPONSE_PACKET: usize = 64;
const TRANSFER_CHUNK: usize = 1024 * 1024;
const DOWNLOAD_TIMEOUT_MS: u32 = 120_000;

#[derive(Debug, Clone, PartialEq, Eq)]
pub enum Reply {
    Okay(String),
    Fail(String),
    Data(u64),
}

pub struct Channel<W: Wire> {
    wire: W,
    timeout_ms: u32,
    info: Vec<String>,
}

impl<W: Wire> Channel<W> {
    pub const fn new(wire: W, timeout_ms: u32) -> Self {
        Self { wire, timeout_ms, info: Vec::new() }
    }

    pub fn info_lines(&self) -> &[String] {
        &self.info
    }

    fn read_reply(&mut self) -> Result<Reply, String> {
        loop {
            let mut buffer = [0u8; RESPONSE_PACKET];
            let read = self
                .wire
                .read(&mut buffer, self.timeout_ms)
                .map_err(|e| format!("Fastboot USBFS read failed before final status: {e}"))?;
            if read < 4 {
                return Err(format!("Invalid Fastboot response length: {read}"));
            }
            let text = String::from_utf8_lossy(&buffer[4..read])
                .trim_end_matches('\0')
                .to_string();
            match &buffer[..4] {
                b"INFO" => self.info.push(text),
                b"OKAY" => return Ok(Reply::Okay(text)),
                b"FAIL" => return Ok(Reply::Fail(text)),
                b"DATA" => {
                    let digits = text.trim();
                    if digits.len() != 8 {
                        return Err(format!(
                            "Fastboot DATA must contain exactly eight hexadecimal digits: '{digits}'"
                        ));
                    }
                    let size = u64::from_str_radix(digits, 16)
                        .map_err(|e| format!("Invalid Fastboot DATA size '{digits}': {e}"))?;
                    return Ok(Reply::Data(size));
                }
                other => {
                    return Err(format!(
                        "Unknown Fastboot response status: '{}'",
                        String::from_utf8_lossy(other)
                    ));
                }
            }
        }
    }

    /// Send one command and read its status frame.
    pub fn request(&mut self, command: &str) -> Result<Reply, String> {
        if command.is_empty() || command.len() > 256 {
            return Err(format!("Fastboot command must contain 1..=256 bytes, got {}", command.len()));
        }
        self.wire
            .write_all(command.as_bytes())
            .map_err(|e| format!("Fastboot command USBFS write failed ({command}): {e}"))?;
        let reply = self.read_reply()?;
        if let Reply::Fail(message) = &reply {
            return Err(format!("Fastboot target returned FAIL: {message}"));
        }
        Ok(reply)
    }

    /// `request` that insists on a `DATA<size>` stage and reports the size.
    fn request_data_stage(&mut self, command: &str) -> Result<u64, String> {
        match self.request(command)? {
            Reply::Data(size) => Ok(size),
            Reply::Okay(_) => Err(format!("Fastboot target returned OKAY without DATA stage: {command}")),
            Reply::Fail(message) => Err(format!("Fastboot target returned FAIL: {message}")),
        }
    }

    /// One `download:` part: announce, then stream the header and its segments, then wait for OKAY.
    fn send_part(
        &mut self,
        part: &Part,
        file: &mut File,
        cancel: &AtomicBool,
        progress: &mut dyn FnMut(u64, u64),
    ) -> Result<(), String> {
        let announced = self.request_data_stage(&format!("download:{:08x}", part.len))?;
        if announced != part.len {
            return Err(format!(
                "Fastboot target accepted {announced} bytes but sparse part is {}",
                part.len
            ));
        }
        let mut sent = 0u64;
        if !part.header.is_empty() {
            self.wire.write_all(&part.header).map_err(|e| format!("Fastboot USBFS write failed at {sent}/{}: {e}", part.len))?;
            sent += part.header.len() as u64;
            progress(sent, part.len);
        }
        for (offset, len) in &part.segments {
            file.seek(SeekFrom::Start(*offset))
                .map_err(|e| format!("Unable to seek sparse source: {e}"))?;
            let mut remaining = *len;
            let mut buffer = vec![0u8; TRANSFER_CHUNK.min(*len as usize).max(1)];
            while remaining > 0 {
                if cancel.load(Ordering::SeqCst) {
                    return Err("Fastboot operation cancelled; no further commands will be sent".into());
                }
                let want = remaining.min(buffer.len() as u64) as usize;
                file.read_exact(&mut buffer[..want])
                    .map_err(|e| format!("Unable to read sparse chunk: {e}"))?;
                self.wire
                    .write_all(&buffer[..want])
                    .map_err(|e| format!("Fastboot USBFS write failed at {sent}/{}: {e}", part.len))?;
                sent += want as u64;
                remaining -= want as u64;
                progress(sent, part.len);
            }
        }
        match self.read_reply()? {
            Reply::Okay(_) => Ok(()),
            Reply::Fail(message) => Err(format!("Fastboot target returned FAIL: {message}")),
            Reply::Data(size) => Err(format!("Unexpected second Fastboot DATA response: {size}")),
        }
    }

    /// Read a `DATA` payload into `file`.
    fn receive_payload(
        &mut self,
        file: &mut File,
        size: u64,
        cancel: &AtomicBool,
        progress: &mut dyn FnMut(u64, u64),
    ) -> Result<u64, String> {
        let mut received = 0u64;
        let mut buffer = vec![0u8; TRANSFER_CHUNK];
        while received < size {
            if cancel.load(Ordering::SeqCst) {
                return Err("Fastboot operation cancelled; no further commands will be sent".into());
            }
            let want = (size - received).min(buffer.len() as u64) as usize;
            let read = self
                .wire
                .read(&mut buffer[..want], DOWNLOAD_TIMEOUT_MS)
                .map_err(|e| format!("Fastboot DATA USBFS receive failed: {e}"))?;
            if read == 0 {
                return Err("Fastboot DATA receive returned 0 bytes".into());
            }
            file.write_all(&buffer[..read])
                .map_err(|e| format!("Unable to write Fastboot output: {e}"))?;
            received += read as u64;
            progress(received, size);
        }
        match self.read_reply()? {
            Reply::Okay(_) => Ok(received),
            Reply::Fail(message) => Err(format!("Fastboot target returned FAIL: {message}")),
            Reply::Data(size) => Err(format!("Unexpected second Fastboot DATA response while receiving: {size}")),
        }
    }
}

/// Everything the verbs need from a channel, so the file-level verbs can be tested with a fake.
pub trait WireOps {
    fn request(&mut self, command: &str) -> Result<Reply, String>;
    fn getvar(&mut self, name: &str) -> Result<String, String> {
        match self.request(&format!("getvar:{name}"))? {
            Reply::Okay(text) => Ok(text),
            Reply::Fail(message) => Err(format!("Fastboot target returned FAIL: {message}")),
            Reply::Data(size) => Err(format!("Invalid getvar:{name} DATA stage: {size}")),
        }
    }
}

impl<W: Wire> WireOps for Channel<W> {
    fn request(&mut self, command: &str) -> Result<Reply, String> {
        Channel::request(self, command)
    }
}

/// Slot-aware partition name: the app sends the base name, the device decides the suffix.
fn resolve_partition(channel: &mut impl WireOps, partition: &str) -> String {
    if partition.ends_with("_a") || partition.ends_with("_b") || partition.ends_with("-a") || partition.ends_with("-b") {
        return partition.to_string();
    }
    let has_slot = channel
        .getvar(&format!("has-slot:{partition}"))
        .map(|value| value.trim().eq_ignore_ascii_case("yes"))
        .unwrap_or(false);
    if !has_slot {
        return partition.to_string();
    }
    match channel.getvar("current-slot") {
        Ok(slot) if !slot.trim().is_empty() => format!("{partition}_{}", slot.trim()),
        _ => partition.to_string(),
    }
}

fn max_download(channel: &mut impl WireOps) -> Result<u64, String> {
    let value = channel.getvar("max-download-size")?;
    let text = value.trim().trim_start_matches("0x");
    u64::from_str_radix(text, 16).or_else(|_| text.parse::<u64>()).map_err(|e| format!("Invalid getvar:max-download-size value: '{text}' ({e})"))
}

fn max_fetch(channel: &mut impl WireOps) -> Result<u64, String> {
    let value = channel
        .getvar("max-fetch-size")
        .map_err(|_| "Device does not report max-fetch-size; Fastboot fetch is not supported".to_string())?;
    let text = value.trim().trim_start_matches("0x");
    u64::from_str_radix(text, 16)
        .or_else(|_| text.parse::<u64>())
        .map_err(|e| format!("Invalid getvar:max-fetch-size value: '{text}' ({e})"))
}

fn userspace_flag(value: &str) -> bool {
    value.trim().eq_ignore_ascii_case("yes")
}

/// True when the target is `fastbootd` rather than the bootloader.
fn is_userspace(channel: &mut impl WireOps) -> bool {
    channel.getvar("is-userspace").map(|value| userspace_flag(&value)).unwrap_or(false)
}

/// `nativeFastbootSnapshot`: the device block the tools screen reads back by label.
pub fn snapshot(channel: &mut impl WireOps) -> Result<String, String> {
    let bootloader = channel.getvar("version-bootloader").unwrap_or_default();
    let product = channel.getvar("product").unwrap_or_default();
    let serial = channel.getvar("serialno").unwrap_or_default();
    let slot = channel.getvar("current-slot").unwrap_or_default();
    let unlocked = channel.getvar("unlocked").unwrap_or_default();
    let userspace = channel.getvar("is-userspace").unwrap_or_default();
    let mode = if userspace_flag(&userspace) { "FASTBOOTD" } else { "FASTBOOT" };
    Ok(format!(
        "MODE: {mode}\n\
         PRODUCT: {product}\n\
         SERIAL: {serial}\n\
         CURRENT SLOT: {slot}\n\
         UNLOCKED: {unlocked}\n\
         BOOTLOADER: {bootloader}\n\
         IS USERSPACE: {userspace}"
    ))
}

/// `nativeFastbootCommand`: command-door verbs. `getvar:` reports the value, everything else reports
/// the command that was accepted.
pub fn command(channel: &mut impl WireOps, command: &str) -> Result<String, String> {
    let trimmed = command.trim();
    let (verb, rest) = match trimmed.split_once(':') {
        Some((verb, rest)) => (verb, Some(rest)),
        None => (trimmed, None),
    };
    let accepted = match verb {
        "getvar" => {
            let Some(name) = rest else {
                return Err("Invalid getvar: missing variable name".into());
            };
            let value = channel.getvar(name)?;
            return Ok(format!("RESPONSE: {value}\nSTATUS: OKAY"));
        }
        "reboot" | "reboot-bootloader" | "reboot-fastboot" | "reboot-recovery" | "continue" | "oem"
        | "flashing" | "set_active" | "shutdown" | "poweroff" => trimmed.to_string(),
        other => {
            return Err(format!("Invalid getvar:{other} value: unsupported Fastboot command '{trimmed}'"));
        }
    };
    match channel.request(&accepted)? {
        Reply::Okay(_) => Ok(format!("COMMAND: {accepted}\nSTATUS: OKAY")),
        Reply::Fail(message) => Err(format!("Fastboot target returned FAIL: {message}")),
        Reply::Data(size) => Err(format!("{accepted}: unexpected DATA stage ({size} bytes)")),
    }
}

/// `nativeFastbootFileCommand`: flash / boot / stage / erase / logical partitions.
pub fn file_command<W: Wire>(
    channel: &mut Channel<W>,
    action: &str,
    partition: &str,
    path: &Path,
    cancel: &AtomicBool,
    progress: &mut dyn FnMut(u64, u64),
) -> Result<String, String> {
    let action = action.trim();
    match action {
        "flash" => flash(channel, partition, path, cancel, progress),
        "boot" | "stage" => one_shot(channel, action, path, cancel, progress),
        "erase" => {
            if partition.is_empty() {
                return Err("Invalid Fastboot partition name".into());
            }
            let command = format!("erase:{}", resolve_partition(channel, partition));
            match channel.request(&command)? {
                Reply::Okay(_) => Ok(format!("COMMAND: {command}\nSTATUS: OKAY")),
                Reply::Fail(message) => Err(format!("Fastboot target returned FAIL: {message}")),
                Reply::Data(size) => Err(format!("{command}: unexpected DATA stage ({size} bytes)")),
            }
        }
        "create-logical-partition" | "delete-logical-partition" | "resize-logical-partition" => {
            if !is_userspace(channel) {
                return Err(format!(
                    "{action} requires userspace Fastboot, or its physical capacity could not be \
                     verified. Run 'fastboot reboot fastboot', wait for FASTBOOTD, then retry this flash"
                ));
            }
            let (name, size) = match partition.split_once(':') {
                Some((name, size)) => (name.trim(), Some(size.trim())),
                None => (partition.trim(), None),
            };
            if name.is_empty() {
                return Err("Invalid Fastboot partition name".into());
            }
            let command = match (action, size) {
                ("delete-logical-partition", _) => format!("{action}:{name}"),
                (_, Some(size)) => {
                    let bytes: u64 = size
                        .parse()
                        .map_err(|_| format!("Invalid logical partition size (must fit unsigned 64-bit bytes): '{size}'"))?;
                    format!("{action}:{name}:{bytes}")
                }
                (_, None) => return Err(format!("{action} requires a size operand")),
            };
            match channel.request(&command)? {
                Reply::Okay(_) => Ok(format!("COMMAND: {command}\nSTATUS: OKAY")),
                Reply::Fail(message) => Err(format!("Fastboot target returned FAIL: {message}")),
                Reply::Data(size) => Err(format!("{command}: unexpected DATA stage ({size} bytes)")),
            }
        }
        "gsi" => {
            let command = format!("gsi:{partition}");
            match channel.request(&command)? {
                Reply::Okay(_) => Ok(format!("COMMAND: {command}\nSTATUS: OKAY")),
                Reply::Fail(message) => Err(format!("Fastboot target returned FAIL: {message}")),
                Reply::Data(size) => Err(format!("{command}: unexpected DATA stage ({size} bytes)")),
            }
        }
        "wipe-super" => Err("wipe-super requires liblp".into()),
        "format" => Err("PREFLIGHT: Unsupported Fastboot file action: format".into()),
        other => Err(format!("PREFLIGHT: Unsupported Fastboot file action: {other}")),
    }
}

fn flash<W: Wire>(
    channel: &mut Channel<W>,
    partition: &str,
    path: &Path,
    cancel: &AtomicBool,
    progress: &mut dyn FnMut(u64, u64),
) -> Result<String, String> {
    if partition.is_empty() {
        return Err("Invalid Fastboot partition name".into());
    }
    let target = resolve_partition(channel, partition);
    let limit = max_download(channel)?;
    let mut file = File::open(path).map_err(|e| format!("Unable to open sparse image {path:?}: {e}"))?;

    let parts = match sparse::read(path).map_err(|e| format!("Unable to read sparse header: {e}"))? {
        Some(image) => {
            let parts = image.plan(limit)?;
            // A sparse image can expand past the partition even when every part fits.
            if let Ok(declared) = channel.getvar(&format!("partition-size:{target}"))
                && let Ok(size) = u64::from_str_radix(declared.trim().trim_start_matches("0x"), 16)
                && image.expanded_bytes() > size
            {
                return Err(format!(
                    "Sparse image expands to {} bytes, larger than partition '{target}' ({size} bytes)",
                    image.expanded_bytes()
                ));
            }
            let described: u64 = parts.iter().map(|part| part.blocks).sum();
            if described != image.total_blks as u64 {
                return Err(format!(
                    "Sparse chunks exceed total block count: chunks describe {described} blocks, \
                     header says {}",
                    image.total_blks
                ));
            }
            parts
        }
        None => vec![sparse::raw_part(path, limit).map_err(|e| e.to_string())?],
    };

    let part_count = parts.len();
    let mut transferred = 0u64;
    let mut completed = 0usize;

    for (index, part) in parts.iter().enumerate() {
        if cancel.load(Ordering::SeqCst) {
            return Err("Fastboot operation cancelled; no further commands will be sent".into());
        }
        if index == 0 {
            let announced = match channel.request(&format!("flash:{target}"))? {
                Reply::Data(size) => size,
                Reply::Okay(_) => {
                    return Err(format!("Fastboot target returned OKAY without DATA stage: flash:{target}"));
                }
                Reply::Fail(message) => return Err(format!("Fastboot target returned FAIL: {message}")),
            };
            if announced != part.len {
                return Err(format!(
                    "Fastboot target accepted {announced} bytes but sparse part is {}",
                    part.len
                ));
            }
            transfer_announced(channel, part, &mut file, cancel, progress)?;
        } else {
            channel.send_part(part, &mut file, cancel, progress)?;
        }
        transferred += part.len;
        completed += 1;
    }

    if part_count == 1 {
        return Ok(format!(
            "FILE: {}\nPARTITION: {target}\nBYTES: {transferred}\nSTATUS: OKAY",
            path.display()
        ));
    }
    Ok(format!(
        "PARTITION: {target}\n\
         FILE: {}\n\
         DOWNLOAD LIMIT: target={limit}; safe-fastbootd={limit}; PARTS: {part_count}\n\
         TRANSFERRED BYTES: {transferred}\n\
         PARTS COMPLETED: {completed}/{part_count}\n\
         STATUS: OKAY",
        path.display()
    ))
}

/// First `flash:` transfer: the target already announced the DATA stage, so stream without a
/// second `download:` command.
fn transfer_announced<W: Wire>(
    channel: &mut Channel<W>,
    part: &Part,
    file: &mut File,
    cancel: &AtomicBool,
    progress: &mut dyn FnMut(u64, u64),
) -> Result<(), String> {
    let mut sent = 0u64;
    if !part.header.is_empty() {
        channel
            .wire
            .write_all(&part.header)
            .map_err(|e| format!("Fastboot USBFS write failed at 0/{}: {e}", part.len))?;
        sent += part.header.len() as u64;
        progress(sent, part.len);
    }
    for (offset, len) in &part.segments {
        file.seek(SeekFrom::Start(*offset))
            .map_err(|e| format!("Unable to seek sparse source: {e}"))?;
        let mut remaining = *len;
        let mut buffer = vec![0u8; TRANSFER_CHUNK.min(*len as usize).max(1)];
        while remaining > 0 {
            if cancel.load(Ordering::SeqCst) {
                return Err("Fastboot operation cancelled; no further commands will be sent".into());
            }
            let want = remaining.min(buffer.len() as u64) as usize;
            file.read_exact(&mut buffer[..want])
                .map_err(|e| format!("Unable to read sparse chunk: {e}"))?;
            channel
                .wire
                .write_all(&buffer[..want])
                .map_err(|e| format!("Fastboot USBFS write failed at {sent}/{}: {e}", part.len))?;
            sent += want as u64;
            remaining -= want as u64;
            progress(sent, part.len);
        }
    }
    match channel.read_reply()? {
        Reply::Okay(_) => Ok(()),
        Reply::Fail(message) => Err(format!("Fastboot target returned FAIL: {message}")),
        Reply::Data(size) => Err(format!("Unexpected second Fastboot DATA response: {size}")),
    }
}

fn one_shot<W: Wire>(
    channel: &mut Channel<W>,
    action: &str,
    path: &Path,
    cancel: &AtomicBool,
    progress: &mut dyn FnMut(u64, u64),
) -> Result<String, String> {
    let limit = max_download(channel)?;
    let part = sparse::raw_part(path, limit).map_err(|e| e.to_string())?;
    if part.len == 0 {
        return Err("Raw Fastboot image is empty".into());
    }
    let announced = match channel.request(action)? {
        Reply::Data(size) => size,
        Reply::Okay(_) => return Err(format!("Fastboot target returned OKAY without DATA stage: {action}")),
        Reply::Fail(message) => return Err(format!("Fastboot target returned FAIL: {message}")),
    };
    if announced != part.len {
        return Err(format!(
            "Fastboot target accepted {announced} bytes but sparse part is {}",
            part.len
        ));
    }
    let mut file = File::open(path).map_err(|e| format!("Unable to open sparse image {path:?}: {e}"))?;
    transfer_announced(channel, &part, &mut file, cancel, progress)?;
    Ok(format!(
        "FILE: {}\nBYTES: {}\nCOMMAND: {action}\nSTATUS: OKAY",
        path.display(),
        part.len
    ))
}

/// `nativeFastbootFetch`: pull a partition out through the DATA stage.
pub fn fetch<W: Wire>(
    channel: &mut Channel<W>,
    partition: &str,
    path: &Path,
    cancel: &AtomicBool,
    progress: &mut dyn FnMut(u64, u64),
) -> Result<String, String> {
    if partition.trim().is_empty() {
        return Err("Fastboot fetch partition is invalid".into());
    }
    if path.as_os_str().is_empty() {
        return Err("INFO: Fastboot fetch output path is empty".into());
    }
    let limit = max_fetch(channel)?;
    let command = format!("fetch:{}", resolve_partition(channel, partition));
    let size = match channel.request(&command)? {
        Reply::Data(size) => size,
        Reply::Okay(_) => return Err(format!("Fastboot target returned OKAY without DATA stage: {command}")),
        Reply::Fail(message) => return Err(format!("Fastboot target returned FAIL: {message}")),
    };
    if size > limit {
        return Err(format!("Fastboot fetch returned {size} bytes, above max-fetch-size {limit}"));
    }
    let mut file = File::create(path).map_err(|e| format!("Unable to create Fastboot output {path:?}: {e}"))?;
    let received = channel.receive_payload(&mut file, size, cancel, progress)?;
    file.flush().map_err(|e| format!("Unable to sync Fastboot output: {e}"))?;
    Ok(format!(
        "FILE: {}\nBYTES: {received}\nCOMMAND: {command}\nSTATUS: OKAY",
        path.display()
    ))
}

/// `nativeFastbootReceiveCommand`: `upload` / `fetch:` with a caller-chosen output file.
pub fn receive_command<W: Wire>(
    channel: &mut Channel<W>,
    command: &str,
    path: &Path,
    cancel: &AtomicBool,
    progress: &mut dyn FnMut(u64, u64),
) -> Result<String, String> {
    if path.as_os_str().is_empty() {
        return Err("Fastboot output path is empty".into());
    }
    let trimmed = command.trim();
    if trimmed.is_empty() {
        return Err("Fastboot receive command is not enabled: empty command".into());
    }
    let command = match trimmed.split_once(':') {
        Some(("fetch", partition)) => format!("fetch:{}", resolve_partition(channel, partition)),
        _ => trimmed.to_string(),
    };
    let size = match channel.request(&command)? {
        Reply::Data(size) => size,
        Reply::Okay(_) => return Err(format!("Fastboot target returned OKAY without DATA stage: {command}")),
        Reply::Fail(message) => return Err(format!("Fastboot target returned FAIL: {message}")),
    };
    let mut file = File::create(path).map_err(|e| format!("Unable to create Fastboot output {path:?}: {e}"))?;
    let received = channel.receive_payload(&mut file, size, cancel, progress)?;
    file.flush().map_err(|e| format!("Unable to sync Fastboot output: {e}"))?;
    Ok(format!(
        "FILE: {}\nBYTES: {received}\nCOMMAND: {command}\nSTATUS: OKAY",
        path.display()
    ))
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::collections::VecDeque;
    use std::io;

    /// A wire that answers from a canned script and records what the host sent.
    struct MockWire {
        incoming: VecDeque<Vec<u8>>,
        #[allow(dead_code)]
        sent: Vec<u8>,
    }

    impl MockWire {
        fn new(frames: &[&[u8]]) -> Self {
            Self {
                incoming: frames.iter().map(|frame| frame.to_vec()).collect(),
                sent: Vec::new(),
            }
        }
    }

    impl Wire for MockWire {
        fn write_all(&mut self, data: &[u8]) -> io::Result<()> {
            self.sent.extend_from_slice(data);
            Ok(())
        }

        fn read(&mut self, buffer: &mut [u8], _timeout_ms: u32) -> io::Result<usize> {
            let Some(frame) = self.incoming.pop_front() else {
                return Ok(0);
            };
            let len = frame.len().min(buffer.len());
            buffer[..len].copy_from_slice(&frame[..len]);
            Ok(len)
        }
    }

    fn okay(text: &str) -> Vec<u8> {
        format!("OKAY{text}").into_bytes()
    }

    fn data(size: usize) -> Vec<u8> {
        format!("DATA{size:08x}").into_bytes()
    }

    #[test]
    fn info_frames_are_skipped_before_the_status() {
        let frames: Vec<Vec<u8>> = vec![b"INFOwaiting for device".to_vec(), okay("")];
        let refs: Vec<&[u8]> = frames.iter().map(|f| f.as_slice()).collect();
        let mut channel = Channel::new(MockWire::new(&refs), 1000);
        assert_eq!(channel.request("reboot").unwrap(), Reply::Okay(String::new()));
        assert_eq!(channel.info_lines(), ["waiting for device"]);
    }

    #[test]
    fn fail_frames_become_errors() {
        let frames: Vec<Vec<u8>> = vec![b"FAILpartition not found".to_vec()];
        let refs: Vec<&[u8]> = frames.iter().map(|f| f.as_slice()).collect();
        let mut channel = Channel::new(MockWire::new(&refs), 1000);
        let error = channel.request("flash:boot_a").unwrap_err();
        assert_eq!(error, "Fastboot target returned FAIL: partition not found");
    }

    #[test]
    fn getvar_reports_the_response_line() {
        let frames: Vec<Vec<u8>> = vec![okay("android")];
        let refs: Vec<&[u8]> = frames.iter().map(|f| f.as_slice()).collect();
        let mut channel = Channel::new(MockWire::new(&refs), 1000);
        let payload = command(&mut channel, "getvar:product").unwrap();
        assert_eq!(payload, "RESPONSE: android\nSTATUS: OKAY");
    }

    #[test]
    fn reboot_reports_the_accepted_command() {
        let frames: Vec<Vec<u8>> = vec![okay("")];
        let refs: Vec<&[u8]> = frames.iter().map(|f| f.as_slice()).collect();
        let mut channel = Channel::new(MockWire::new(&refs), 1000);
        let payload = command(&mut channel, "reboot-fastboot").unwrap();
        assert_eq!(payload, "COMMAND: reboot-fastboot\nSTATUS: OKAY");
    }

    #[test]
    fn unknown_commands_are_refused_before_any_transfer() {
        let mut channel = Channel::new(MockWire::new(&[]), 1000);
        let error = command(&mut channel, "frobnicate").unwrap_err();
        assert!(error.contains("unsupported Fastboot command"), "{error}");
    }

    #[test]
    fn snapshot_carries_every_label_the_screen_reads() {
        let frames: Vec<Vec<u8>> = vec![
            okay("android-14"),
            okay("GT10"),
            okay("ABC123"),
            okay("b"),
            okay("yes"),
            okay("no"),
        ];
        let refs: Vec<&[u8]> = frames.iter().map(|f| f.as_slice()).collect();
        let mut channel = Channel::new(MockWire::new(&refs), 1000);
        let payload = snapshot(&mut channel).unwrap();
        assert_eq!(
            payload,
            "MODE: FASTBOOT\nPRODUCT: GT10\nSERIAL: ABC123\nCURRENT SLOT: b\nUNLOCKED: yes\nBOOTLOADER: android-14\nIS USERSPACE: no"
        );
    }

    #[test]
    fn data_stage_size_must_match_the_part() {
        // flash:boot_a announces 16 bytes but the image is 4.
        let dir = std::env::temp_dir().join("rynx-proto-flash");
        std::fs::create_dir_all(&dir).unwrap();
        let path = dir.join("boot.img");
        std::fs::write(&path, vec![0u8; 4]).unwrap();
        let frames: Vec<Vec<u8>> = vec![okay("4096"), data(16)];
        let refs: Vec<&[u8]> = frames.iter().map(|f| f.as_slice()).collect();
        let mut channel = Channel::new(MockWire::new(&refs), 1000);
        let cancel = AtomicBool::new(false);
        let error = file_command(&mut channel, "flash", "boot_a", &path, &cancel, &mut |_, _| {}).unwrap_err();
        assert!(error.contains("bytes but sparse part is"), "{error}");
        std::fs::remove_file(&path).ok();
    }

    #[test]
    fn flash_streams_the_payload_and_reports_bytes() {
        let dir = std::env::temp_dir().join("rynx-proto-flash-ok");
        std::fs::create_dir_all(&dir).unwrap();
        let path = dir.join("boot.img");
        std::fs::write(&path, vec![0xaa; 4]).unwrap();
        // max-download-size, then flash: → DATA 4, then final OKAY.
        let frames: Vec<Vec<u8>> = vec![okay("00100000"), data(4), okay("")];
        let refs: Vec<&[u8]> = frames.iter().map(|f| f.as_slice()).collect();
        let mut channel = Channel::new(MockWire::new(&refs), 1000);
        let cancel = AtomicBool::new(false);
        let payload = file_command(&mut channel, "flash", "boot_a", &path, &cancel, &mut |_, _| {}).unwrap();
        assert_eq!(
            payload,
            format!("FILE: {}\nPARTITION: boot_a\nBYTES: 4\nSTATUS: OKAY", path.display())
        );
        std::fs::remove_file(&path).ok();
    }

    #[test]
    fn wipe_super_and_format_are_refused() {
        let mut channel = Channel::new(MockWire::new(&[]), 1000);
        let cancel = AtomicBool::new(false);
        let path = Path::new("/nonexistent");
        assert_eq!(
            file_command(&mut channel, "wipe-super", "super", path, &cancel, &mut |_, _| {}).unwrap_err(),
            "wipe-super requires liblp"
        );
        assert!(file_command(&mut channel, "format", "data", path, &cancel, &mut |_, _| {})
            .unwrap_err()
            .contains("Unsupported Fastboot file action"));
    }
}
