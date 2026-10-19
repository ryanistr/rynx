//! Android sparse images: what a flash payload is, and how it splits across `download:` parts.

use std::fs::File;
use std::io::{self, Read, Seek, SeekFrom};
use std::path::Path;

pub const MAGIC: u32 = 0xed26_ff3a;
const FILE_HEADER_SIZE: usize = 28;
const CHUNK_HEADER_SIZE: usize = 12;
const CHUNK_RAW: u16 = 0xcac1;
const CHUNK_FILL: u16 = 0xcac2;
const CHUNK_DONT_CARE: u16 = 0xcac3;
const CHUNK_CRC32: u16 = 0xcac4;

#[derive(Debug, Clone, Copy)]
pub struct Chunk {
    pub kind: u16,
    pub blocks: u32,
    /// Absolute offset of the chunk header in the source file.
    pub offset: u64,
    /// Header plus payload, i.e. the chunk's `total_sz`.
    pub len: u64,
}

#[derive(Debug, Clone)]
pub struct SparseImage {
    pub blk_sz: u32,
    pub total_blks: u32,
    pub header: Vec<u8>,
    pub chunks: Vec<Chunk>,
}

/// One `download:` transfer: a file header, then chunk bytes copied straight from the source.
#[derive(Debug, Clone)]
pub struct Part {
    pub header: Vec<u8>,
    pub segments: Vec<(u64, u64)>,
    pub len: u64,
    pub blocks: u64,
}

fn le16(bytes: &[u8], at: usize) -> u16 {
    u16::from_le_bytes([bytes[at], bytes[at + 1]])
}

fn le32(bytes: &[u8], at: usize) -> u32 {
    u32::from_le_bytes([bytes[at], bytes[at + 1], bytes[at + 2], bytes[at + 3]])
}

/// Read the sparse header and chunk table; `Ok(None)` means "not a sparse image".
pub fn read(path: &Path) -> io::Result<Option<SparseImage>> {
    let mut file = File::open(path)?;
    let mut header = vec![0u8; FILE_HEADER_SIZE];
    if file.read(&mut header)? < 4 {
        return Ok(None);
    }
    if le32(&header, 0) != MAGIC {
        return Ok(None);
    }
    if header.len() < FILE_HEADER_SIZE {
        header.resize(FILE_HEADER_SIZE, 0);
        file.seek(SeekFrom::Start(0))?;
        file.read_exact(&mut header)?;
    }
    let major = le16(&header, 4);
    if major != 1 {
        return Ok(None);
    }
    let file_hdr_sz = le16(&header, 8);
    let chunk_hdr_sz = le16(&header, 10);
    let blk_sz = le32(&header, 12);
    let total_blks = le32(&header, 16);
    let total_chunks = le32(&header, 20);
    if (file_hdr_sz as usize) < FILE_HEADER_SIZE || (chunk_hdr_sz as usize) < CHUNK_HEADER_SIZE || blk_sz == 0 {
        return Ok(None);
    }
    let file_len = file.metadata()?.len();

    let mut chunks = Vec::with_capacity(total_chunks as usize);
    let mut cursor = file_hdr_sz as u64;
    file.seek(SeekFrom::Start(cursor))?;
    let mut raw = vec![0u8; chunk_hdr_sz as usize];
    for _ in 0..total_chunks {
        if cursor + chunk_hdr_sz as u64 > file_len {
            return Ok(None);
        }
        file.read_exact(&mut raw)?;
        let kind = le16(&raw, 0);
        let blocks = le32(&raw, 4);
        let total_sz = le32(&raw, 8) as u64;
        if total_sz < chunk_hdr_sz as u64 || cursor + total_sz > file_len {
            return Ok(None);
        }
        chunks.push(Chunk { kind, blocks, offset: cursor, len: total_sz });
        cursor += total_sz;
        file.seek(SeekFrom::Start(cursor))?;
    }

    Ok(Some(SparseImage { blk_sz, total_blks, header, chunks }))
}

impl SparseImage {
    /// Split into `download:` parts no larger than `limit` wire bytes.
    ///
    /// Parts break on chunk boundaries only: a chunk is never split, and a single chunk that cannot
    /// fit is an error rather than a corrupt transfer.
    pub fn plan(&self, limit: u64) -> Result<Vec<Part>, String> {
        let header_len = self.header.len() as u64;
        let mut parts: Vec<Part> = Vec::new();
        let mut segments: Vec<(u64, u64)> = Vec::new();
        let mut blocks = 0u64;
        let mut len = header_len;

        for chunk in &self.chunks {
            if header_len + chunk.len > limit {
                return Err(format!(
                    "Sparse {} chunk at 0x{:x} is {} bytes and exceeds the Fastboot limit {limit}",
                    kind_name(chunk.kind),
                    chunk.offset,
                    chunk.len
                ));
            }
            if len + chunk.len > limit && !segments.is_empty() {
                parts.push(self.part(std::mem::take(&mut segments), blocks, len));
                blocks = 0;
                len = header_len;
            }
            segments.push((chunk.offset, chunk.len));
            blocks += chunk.blocks as u64;
            len += chunk.len;
        }
        if !segments.is_empty() {
            parts.push(self.part(segments, blocks, len));
        }
        if parts.is_empty() {
            return Err("Sparse resparse produced no output parts".into());
        }
        Ok(parts)
    }

    fn part(&self, segments: Vec<(u64, u64)>, blocks: u64, len: u64) -> Part {
        let mut header = self.header.clone();
        header[16..20].copy_from_slice(&(blocks as u32).to_le_bytes());
        header[20..24].copy_from_slice(&(segments.len() as u32).to_le_bytes());
        header[24..28].copy_from_slice(&0u32.to_le_bytes());
        Part { header, segments, len, blocks }
    }

    /// Expanded size in bytes, i.e. what the image becomes on the device.
    pub fn expanded_bytes(&self) -> u64 {
        self.total_blks as u64 * self.blk_sz as u64
    }
}

fn kind_name(kind: u16) -> &'static str {
    match kind {
        CHUNK_RAW => "RAW",
        CHUNK_FILL => "FILL",
        CHUNK_DONT_CARE => "DONT-CARE",
        CHUNK_CRC32 => "CRC",
        _ => "unknown",
    }
}

/// Raw (non-sparse) images are one `download:` part straight from the file.
pub fn raw_part(path: &Path, limit: u64) -> io::Result<Part> {
    let len = File::open(path)?.metadata()?.len();
    if len > limit {
        return Err(io::Error::other(format!(
            "image is {len} bytes and exceeds the Fastboot limit {limit}"
        )));
    }
    Ok(Part { header: Vec::new(), segments: vec![(0, len)], len, blocks: 0 })
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::io::Write;

    fn chunk(kind: u16, blocks: u32, payload: &[u8]) -> Vec<u8> {
        let mut out = Vec::new();
        out.extend_from_slice(&kind.to_le_bytes());
        out.extend_from_slice(&0u16.to_le_bytes());
        out.extend_from_slice(&blocks.to_le_bytes());
        out.extend_from_slice(&((CHUNK_HEADER_SIZE + payload.len()) as u32).to_le_bytes());
        out.extend_from_slice(payload);
        out
    }

    fn write_image(path: &Path, blk_sz: u32, chunks: &[Vec<u8>], total_blks: u32) {
        let mut file = File::create(path).unwrap();
        let mut header = Vec::new();
        header.extend_from_slice(&MAGIC.to_le_bytes());
        header.extend_from_slice(&1u16.to_le_bytes());
        header.extend_from_slice(&0u16.to_le_bytes());
        header.extend_from_slice(&(FILE_HEADER_SIZE as u16).to_le_bytes());
        header.extend_from_slice(&(CHUNK_HEADER_SIZE as u16).to_le_bytes());
        header.extend_from_slice(&blk_sz.to_le_bytes());
        header.extend_from_slice(&total_blks.to_le_bytes());
        header.extend_from_slice(&(chunks.len() as u32).to_le_bytes());
        header.extend_from_slice(&0u32.to_le_bytes());
        file.write_all(&header).unwrap();
        for chunk in chunks {
            file.write_all(chunk).unwrap();
        }
    }

    #[test]
    fn reads_the_chunk_table() {
        let dir = std::env::temp_dir().join("rynx-sparse-read");
        std::fs::create_dir_all(&dir).unwrap();
        let path = dir.join("image.bin");
        write_image(
            &path,
            4096,
            &[chunk(CHUNK_RAW, 2, &[0xab; 8192]), chunk(CHUNK_DONT_CARE, 1, &[])],
            3,
        );
        let image = read(&path).unwrap().expect("sparse image");
        assert_eq!(image.blk_sz, 4096);
        assert_eq!(image.chunks.len(), 2);
        assert_eq!(image.expanded_bytes(), 3 * 4096);
        assert!(image.plan(1 << 20).unwrap().len() == 1);
        std::fs::remove_file(&path).ok();
    }

    #[test]
    fn splits_on_chunk_boundaries_and_rewrites_headers() {
        let dir = std::env::temp_dir().join("rynx-sparse-split");
        std::fs::create_dir_all(&dir).unwrap();
        let path = dir.join("image.bin");
        // Three raw chunks of 4096 bytes each; the file header is 28 bytes.
        write_image(&path, 4096, &[chunk(CHUNK_RAW, 1, &[1; 4096]), chunk(CHUNK_RAW, 1, &[2; 4096]), chunk(CHUNK_RAW, 1, &[3; 4096])], 3);
        let image = read(&path).unwrap().expect("sparse image");
        let parts = image.plan(28 + 2 * (12 + 4096)).unwrap();
        assert_eq!(parts.len(), 2);
        assert_eq!(parts[0].segments.len(), 2);
        assert_eq!(parts[0].blocks, 2);
        assert_eq!(parts[0].len, 28 + 2 * (12 + 4096));
        assert_eq!(parts[1].segments.len(), 1);
        assert_eq!(parts[1].blocks, 1);
        // Each part carries its own chunk count and zeroed checksum.
        assert_eq!(u32::from_le_bytes(parts[0].header[20..24].try_into().unwrap()), 2);
        assert_eq!(u32::from_le_bytes(parts[1].header[16..20].try_into().unwrap()), 1);
        assert_eq!(u32::from_le_bytes(parts[1].header[24..28].try_into().unwrap()), 0);
        std::fs::remove_file(&path).ok();
    }

    #[test]
    fn refuses_a_chunk_larger_than_the_limit() {
        let dir = std::env::temp_dir().join("rynx-sparse-big");
        std::fs::create_dir_all(&dir).unwrap();
        let path = dir.join("image.bin");
        write_image(&path, 4096, &[chunk(CHUNK_RAW, 4, &[7; 16384])], 4);
        let image = read(&path).unwrap().expect("sparse image");
        let error = image.plan(1024).unwrap_err();
        assert!(error.contains("exceeds the Fastboot limit"), "{error}");
        std::fs::remove_file(&path).ok();
    }

    #[test]
    fn a_raw_file_is_one_part() {
        let dir = std::env::temp_dir().join("rynx-sparse-raw");
        std::fs::create_dir_all(&dir).unwrap();
        let path = dir.join("boot.img");
        std::fs::write(&path, vec![0u8; 64]).unwrap();
        let part = raw_part(&path, 1 << 20).unwrap();
        assert_eq!(part.len, 64);
        assert!(raw_part(&path, 16).is_err());
        std::fs::remove_file(&path).ok();
    }
}
