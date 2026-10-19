//! usbfs transport for the ADB/Fastboot layer.
//!
//! Android hands us an open file descriptor instead of a USB handle, so everything goes through
//! `USBDEVFS_*` ioctls: control transfers to read the device/config descriptors, a single claimed
//! interface, and bulk transfers for the fastboot conversation.

use std::ffi::c_void;
use std::io;
use std::os::fd::RawFd;

pub mod ioc {
    pub const CONTROL: u64 = 0xc018_5500; // _IOWR('U', 0, struct usbdevfs_ctrltransfer)
    pub const BULK: u64 = 0xc018_5502; // _IOWR('U', 2, struct usbdevfs_bulktransfer)
    pub const CLAIMINTERFACE: u64 = 0x8004_550f; // _IOR('U', 15, unsigned int)
    pub const RELEASEINTERFACE: u64 = 0x8004_5510; // _IOR('U', 16, unsigned int)
}

const GET_DESCRIPTOR: u8 = 6;
const DESCRIPTOR_DEVICE: u16 = 1;
const DESCRIPTOR_CONFIG: u16 = 2;
const TYPE_INTERFACE: u8 = 4;
const TYPE_ENDPOINT: u8 = 5;
const ENDPOINT_BULK: u8 = 2;
const ENDPOINT_IN: u8 = 0x80;
/// Fastboot advertises vendor-specific class/subclass/protocol.
const FASTBOOT_CLASS: u8 = 0xff;
const FASTBOOT_SUBCLASS: u8 = 0x42;
const FASTBOOT_PROTOCOL: u8 = 0x03;

#[repr(C)]
struct BulkTransfer {
    ep: u32,
    len: u32,
    timeout: u32,
    data: *mut c_void,
}

#[repr(C)]
struct CtrlTransfer {
    request_type: u8,
    request: u8,
    value: u16,
    index: u16,
    length: u16,
    timeout: u32,
    data: *mut c_void,
}

fn ioctl_ptr(fd: RawFd, request: u64, arg: *mut c_void) -> i32 {
    unsafe { libc::ioctl(fd, request as _, arg) }
}

fn ioctl_interface(fd: RawFd, request: u64, interface: i32) -> i32 {
    ioctl_ptr(fd, request, interface as usize as *mut c_void)
}

/// Control transfer; returns the number of bytes transferred or a negative errno.
pub fn control(
    fd: RawFd,
    request_type: u8,
    request: u8,
    value: u16,
    index: u16,
    buffer: &mut [u8],
    timeout_ms: u32,
) -> i32 {
    let mut transfer = CtrlTransfer {
        request_type,
        request,
        value,
        index,
        length: buffer.len() as u16,
        timeout: timeout_ms,
        data: buffer.as_mut_ptr() as *mut c_void,
    };
    ioctl_ptr(fd, ioc::CONTROL, &mut transfer as *mut _ as *mut c_void)
}

/// Bulk transfer; returns the byte count or -1.
pub fn bulk(fd: RawFd, endpoint: u8, data: *mut c_void, len: u32, timeout_ms: u32) -> i32 {
    let mut transfer = BulkTransfer {
        ep: endpoint as u32,
        len,
        timeout: timeout_ms.max(1),
        data,
    };
    let ret = ioctl_ptr(fd, ioc::BULK, &mut transfer as *mut _ as *mut c_void);
    if ret < 0 { -1 } else { ret }
}

pub fn claim_interface(fd: RawFd, interface: i32) -> bool {
    ioctl_interface(fd, ioc::CLAIMINTERFACE, interface) >= 0
}

pub fn release_interface(fd: RawFd, interface: i32) {
    let _ = ioctl_interface(fd, ioc::RELEASEINTERFACE, interface);
}

#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub struct Endpoints {
    pub interface: u8,
    pub ep_in: u8,
    pub ep_out: u8,
}

/// Walk the active config descriptor for the fastboot interface.
///
/// Preference order: vendor class 0xff/0x42/0x03 with both bulk directions, then any interface
/// that has both bulk directions. `None` means the descriptor did not describe a usable pair.
pub fn discover(fd: RawFd) -> Option<Endpoints> {
    let mut device = [0u8; 18];
    let ret = control(
        fd,
        0x80,
        GET_DESCRIPTOR,
        DESCRIPTOR_DEVICE << 8,
        0,
        &mut device,
        1000,
    );
    if ret < 8 {
        return None;
    }
    let mut header = [0u8; 9];
    let ret = control(fd, 0x80, GET_DESCRIPTOR, DESCRIPTOR_CONFIG << 8, 0, &mut header, 1000);
    if ret < 9 {
        return None;
    }
    let total = u16::from_le_bytes([header[2], header[3]]) as usize;
    if !(9..=4096).contains(&total) {
        return None;
    }
    let mut config = vec![0u8; total];
    let ret = control(fd, 0x80, GET_DESCRIPTOR, DESCRIPTOR_CONFIG << 8, 0, &mut config, 1000);
    if ret < 9 {
        return None;
    }
    parse_config(&config[..(ret as usize).min(total)])
}

/// Pick the endpoint pair out of one config descriptor blob.
pub fn parse_config(config: &[u8]) -> Option<Endpoints> {
    let mut preferred: Option<Endpoints> = None;
    let mut fallback: Option<Endpoints> = None;
    let mut index = 0usize;
    let mut current: Option<(u8, u8, u8, u8)> = None; // interface, class, subclass, proto
    let mut ep_in: Option<u8> = None;
    let mut ep_out: Option<u8> = None;
    while index + 2 <= config.len() {
        let length = config[index] as usize;
        let kind = config[index + 1];
        if length == 0 || index + length > config.len() {
            break;
        }
        match kind {
            TYPE_INTERFACE if length >= 9 => {
                if let Some((number, class, subclass, proto)) = current.take() {
                    record(&mut preferred, &mut fallback, number, class, subclass, proto, ep_in, ep_out);
                }
                current = Some((config[index + 2], config[index + 5], config[index + 6], config[index + 7]));
                ep_in = None;
                ep_out = None;
            }
            TYPE_ENDPOINT if length >= 7 => {
                let address = config[index + 2];
                let attributes = config[index + 3] & 0x03;
                if attributes == ENDPOINT_BULK {
                    if address & ENDPOINT_IN != 0 {
                        ep_in.get_or_insert(address);
                    } else {
                        ep_out.get_or_insert(address);
                    }
                }
            }
            _ => {}
        }
        index += length;
    }
    if let Some((number, class, subclass, proto)) = current.take() {
        record(&mut preferred, &mut fallback, number, class, subclass, proto, ep_in, ep_out);
    }
    preferred.or(fallback)
}

#[allow(clippy::too_many_arguments)]
fn record(
    preferred: &mut Option<Endpoints>,
    fallback: &mut Option<Endpoints>,
    interface: u8,
    class: u8,
    subclass: u8,
    protocol: u8,
    ep_in: Option<u8>,
    ep_out: Option<u8>,
) {
    let (Some(ep_in), Some(ep_out)) = (ep_in, ep_out) else {
        return;
    };
    let endpoints = Endpoints { interface, ep_in, ep_out };
    if class == FASTBOOT_CLASS && subclass == FASTBOOT_SUBCLASS && protocol == FASTBOOT_PROTOCOL {
        preferred.get_or_insert(endpoints);
    } else {
        fallback.get_or_insert(endpoints);
    }
}

/// What the fastboot protocol layer needs from a transport. Split out so the framing can be
/// tested without a device.
pub trait Wire {
    fn write_all(&mut self, data: &[u8]) -> io::Result<()>;
    fn read(&mut self, buffer: &mut [u8], timeout_ms: u32) -> io::Result<usize>;
}

pub struct UsbfsWire {
    fd: RawFd,
    ep_in: u8,
    ep_out: u8,
    timeout_ms: u32,
}

impl UsbfsWire {
    pub const fn new(fd: RawFd, endpoints: Endpoints, timeout_ms: u32) -> Self {
        Self {
            fd,
            ep_in: endpoints.ep_in,
            ep_out: endpoints.ep_out,
            timeout_ms,
        }
    }
}

impl Wire for UsbfsWire {
    fn write_all(&mut self, data: &[u8]) -> io::Result<()> {
        let mut written = 0usize;
        while written < data.len() {
            let chunk = &data[written..];
            let transferred = bulk(
                self.fd,
                self.ep_out,
                chunk.as_ptr() as *mut c_void,
                chunk.len() as u32,
                self.timeout_ms,
            );
            if transferred <= 0 {
                return Err(io::Error::other(format!("USB bulk write failed at {written}/{}", data.len())));
            }
            written += transferred as usize;
        }
        Ok(())
    }

    fn read(&mut self, buffer: &mut [u8], timeout_ms: u32) -> io::Result<usize> {
        let transferred = bulk(
            self.fd,
            self.ep_in,
            buffer.as_mut_ptr() as *mut c_void,
            buffer.len() as u32,
            timeout_ms.max(1),
        );
        if transferred < 0 {
            return Err(io::Error::other("USB bulk read failed"));
        }
        Ok(transferred as usize)
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    fn config_with(interfaces: &[(u8, u8, u8, u8, &[(u8, u8)])]) -> Vec<u8> {
        let mut bytes = vec![9u8, 2, 0, 0, 1, 1, 0, 0x80, 0x32];
        for (number, class, subclass, protocol, endpoints) in interfaces {
            bytes.extend_from_slice(&[9, TYPE_INTERFACE, *number, 0, endpoints.len() as u8, *class, *subclass, *protocol, 0]);
            for (address, attributes) in *endpoints {
                bytes.extend_from_slice(&[7, TYPE_ENDPOINT, *address, *attributes, 0, 0, 0]);
            }
        }
        let total = bytes.len() as u16;
        bytes[2..4].copy_from_slice(&total.to_le_bytes());
        bytes
    }

    #[test]
    fn interface_walk_prefers_the_vendor_fastboot_interface() {
        // A generic interface on 0 and the fastboot one on 1: the vendored pair wins.
        let config = config_with(&[
            (0, 0x08, 0x06, 0x50, &[(0x81, 0x02), (0x01, 0x02)]),
            (1, 0xff, 0x42, 0x03, &[(0x83, 0x02), (0x02, 0x02)]),
        ]);
        assert_eq!(
            parse_config(&config),
            Some(Endpoints { interface: 1, ep_in: 0x83, ep_out: 0x02 })
        );
    }

    #[test]
    fn interface_walk_falls_back_to_any_bulk_pair() {
        let config = config_with(&[(0, 0x08, 0x06, 0x50, &[(0x81, 0x02), (0x01, 0x02)])]);
        assert_eq!(
            parse_config(&config),
            Some(Endpoints { interface: 0, ep_in: 0x81, ep_out: 0x01 })
        );
    }

    #[test]
    fn interface_walk_ignores_interrupt_endpoints() {
        let config = config_with(&[(0, 0xff, 0x42, 0x03, &[(0x81, 0x03), (0x02, 0x02)])]);
        assert_eq!(parse_config(&config), None);
    }
}
