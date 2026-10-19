//! Transport for the native core: raw USB through the Linux `usbfs` interface.
//!
//! Android hands us a file descriptor for the USB device instead of a libusb handle, so
//! the engine's `MtkPort` trait is implemented directly on top of `USBDEVFS_*` ioctls.

use std::ffi::c_void;
use std::io;
use std::os::fd::RawFd;
use std::time::Duration;

use penumbra_mtk::error::{ConnectionError, Error, Result};
use penumbra_mtk::port::{ConnectionType, MtkPort};

/// Bulk endpoints MediaTek BROM/DA ports expose at the default interface layout.
pub const EP_IN_DEFAULT: u8 = 0x81;
pub const EP_OUT_DEFAULT: u8 = 0x01;

/// ioctl numbers from `linux/usbdevice_fs.h` (`_IOC` encoding, direction|size|type|nr).
mod ioc {
    pub const CONTROL: u64 = 0xc018_5500; // _IOWR('U', 0, struct usbdevfs_ctrltransfer)
    pub const BULK: u64 = 0xc018_5502; // _IOWR('U', 2, struct usbdevfs_bulktransfer)
#[allow(dead_code)]
    pub const SETINTERFACE: u64 = 0x8008_5504; // _IOR('U', 4, struct usbdevfs_setinterface)
    pub const CLAIMINTERFACE: u64 = 0x8004_550f; // _IOR('U', 15, unsigned int)
    pub const RELEASEINTERFACE: u64 = 0x8004_5510; // _IOR('U', 16, unsigned int)
    pub const CLEAR_HALT: u64 = 0x8004_5515; // _IOR('U', 21, unsigned int)
#[allow(dead_code)]
    pub const DISCONNECT: u64 = 0x0000_5516; // _IO('U', 22)
#[allow(dead_code)]
    pub const CONNECT: u64 = 0x0000_5517; // _IO('U', 23)
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

#[repr(C)]
struct BulkTransfer {
    ep: u32,
    len: u32,
    timeout: u32,
    data: *mut c_void,
}

fn ioctl_ptr(fd: RawFd, request: u64, arg: *mut c_void) -> io::Result<i32> {
    let ret = unsafe { libc::ioctl(fd, request as _, arg) };
    if ret < 0 {
        Err(io::Error::last_os_error())
    } else {
        Ok(ret)
    }
}

fn timeout_ms(timeout: Duration) -> u32 {
    // A zero timeout means "wait forever" in usbfs and cannot be cancelled, so clamp.
    timeout.as_millis().clamp(1, u32::MAX as u128) as u32
}

/// Bulk endpoints and the interface that owns them.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub struct Endpoints {
    pub interface: u32,
    pub ep_in: u8,
    pub ep_out: u8,
}

/// A USB device reached through a raw `usbfs` file descriptor owned by the app.
#[derive(Debug)]
pub struct UsbfsPort {
    fd: RawFd,
    interface: u32,
    ep_in: u8,
    ep_out: u8,
    timeout: Duration,
    connection_type: ConnectionType,
    name: String,
    claimed: bool,
}

impl UsbfsPort {
    pub fn new(fd: RawFd, connection_type: ConnectionType) -> Self {
        Self::with_endpoints(
            fd,
            connection_type,
            Endpoints {
                interface: 0,
                ep_in: EP_IN_DEFAULT,
                ep_out: EP_OUT_DEFAULT,
            },
        )
    }

    pub fn with_endpoints(fd: RawFd, connection_type: ConnectionType, eps: Endpoints) -> Self {
        Self {
            fd,
            interface: eps.interface,
            ep_in: eps.ep_in,
            ep_out: eps.ep_out,
            timeout: penumbra_mtk::port::MIN_TIMEOUT,
            connection_type,
            name: format!("usbfs:{}", eps.interface),
            claimed: false,
        }
    }

    pub fn fd(&self) -> RawFd {
        self.fd
    }

    /// Read the configuration descriptor and pick the interface carrying a bulk pair.
    ///
    /// MediaTek ports are usually interface 0 with 0x81/0x01, but preloader CDC layouts move
    /// the bulk pair onto another interface, so the descriptor decides.
    pub fn discover(fd: RawFd) -> Option<Endpoints> {
        let mut head = [0u8; 9];
        let desc = read_descriptor(fd, &mut head, 8)?;
        if desc.len() < 9 {
            return None;
        }
        let total = u16::from_le_bytes([desc[2], desc[3]]) as usize;
        let mut buf = vec![0u8; total.clamp(9, 4096)];
        let desc = read_descriptor(fd, &mut buf, 2)?;

        let mut interface = 0u32;
        let mut ep_in = None;
        let mut ep_out = None;
        let mut i = 0usize;
        while i + 2 <= desc.len() {
            let len = desc[i] as usize;
            let kind = desc[i + 1];
            if len == 0 || i + len > desc.len() {
                break;
            }
            match kind {
                0x04 if len >= 9 => {
                    // A new interface: keep the last complete pair only if the next one is empty.
                    if ep_in.is_some() && ep_out.is_some() {
                        break;
                    }
                    interface = desc[i + 2] as u32;
                }
                0x05 if len >= 7 && desc[i + 3] & 0x03 == 0x02 => {
                    let addr = desc[i + 2];
                    if addr & 0x80 != 0 {
                        ep_in.get_or_insert(addr);
                    } else {
                        ep_out.get_or_insert(addr);
                    }
                }
                _ => {}
            }
            i += len;
        }

        Some(Endpoints {
            interface,
            ep_in: ep_in.unwrap_or(EP_IN_DEFAULT),
            ep_out: ep_out.unwrap_or(EP_OUT_DEFAULT),
        })
    }

    fn ctrl(
        &self,
        request_type: u8,
        request: u8,
        value: u16,
        index: u16,
        data: *mut c_void,
        length: u16,
    ) -> Result<i32> {
        let mut transfer = CtrlTransfer {
            request_type,
            request,
            value,
            index,
            length,
            timeout: timeout_ms(self.timeout),
            data,
        };
        ioctl_ptr(self.fd, ioc::CONTROL, &mut transfer as *mut _ as *mut c_void)
            .map_err(|_| Error::Connection(ConnectionError::CtrlTransferInFailed))
    }

    fn bulk(&self, ep: u8, data: *mut c_void, len: u32) -> Result<i32> {
        let mut transfer = BulkTransfer {
            ep: ep as u32,
            len,
            timeout: timeout_ms(self.timeout),
            data,
        };
        match ioctl_ptr(self.fd, ioc::BULK, &mut transfer as *mut _ as *mut c_void) {
            Ok(n) => Ok(n),
            Err(e) if matches!(e.kind(), io::ErrorKind::TimedOut | io::ErrorKind::WouldBlock) => {
                Err(Error::Timeout)
            }
            Err(_) => Err(Error::Connection(ConnectionError::OpenFailed(
                "usbfs bulk transfer failed".into(),
            ))),
        }
    }
}

fn read_descriptor(fd: RawFd, buf: &mut [u8], kind: u8) -> Option<Vec<u8>> {
    let transfer = CtrlTransfer {
        request_type: 0x80,
        request: 0x06, // GET_DESCRIPTOR
        value: (kind as u16) << 8,
        index: 0,
        length: buf.len() as u16,
        timeout: 1000,
        data: buf.as_mut_ptr() as *mut c_void,
    };
    let mut transfer = transfer;
    let n = ioctl_ptr(fd, ioc::CONTROL, &mut transfer as *mut _ as *mut c_void).ok()?;
    if n <= 0 {
        return None;
    }
    Some(buf[..n as usize].to_vec())
}

impl MtkPort for UsbfsPort {
    fn open(&mut self) -> Result<()> {
        let mut interface = self.interface;
        ioctl_ptr(
            self.fd,
            ioc::CLAIMINTERFACE,
            &mut interface as *mut u32 as *mut c_void,
        )
        .map_err(|_| Error::Connection(ConnectionError::InterfaceNotFound))?;
        self.claimed = true;
        Ok(())
    }

    fn close(&mut self) -> Result<()> {
        if self.claimed {
            let mut interface = self.interface;
            let _ = ioctl_ptr(
                self.fd,
                ioc::RELEASEINTERFACE,
                &mut interface as *mut u32 as *mut c_void,
            );
            self.claimed = false;
        }
        Ok(())
    }

    /// Nothing to do: the app owns the descriptor and reopens it after a re-enumeration.
    fn reenumerate(&mut self, _vid: u16, _pid: u16) -> Result<()> {
        Ok(())
    }

    fn read_exact(&mut self, buf: &mut [u8]) -> Result<usize> {
        let mut done = 0usize;
        while done < buf.len() {
            let ptr = unsafe { buf.as_mut_ptr().add(done) } as *mut c_void;
            let n = self.bulk(self.ep_in, ptr, (buf.len() - done) as u32)?;
            if n <= 0 {
                return Err(Error::Timeout);
            }
            done += n as usize;
        }
        Ok(done)
    }

    fn write_all(&mut self, buf: &[u8]) -> Result<()> {
        let mut done = 0usize;
        while done < buf.len() {
            let ptr = unsafe { buf.as_ptr().add(done) } as *mut c_void;
            let n = self.bulk(self.ep_out, ptr, (buf.len() - done) as u32)?;
            if n <= 0 {
                return Err(Error::Timeout);
            }
            done += n as usize;
        }
        Ok(())
    }

    fn flush(&mut self) -> Result<()> {
        let mut ep = self.ep_out as u32;
        let _ = ioctl_ptr(self.fd, ioc::CLEAR_HALT, &mut ep as *mut u32 as *mut c_void);
        Ok(())
    }

    fn get_baudrate(&self) -> u32 {
        0
    }

    fn get_port_name(&self) -> String {
        self.name.clone()
    }

    fn set_timeout(&mut self, timeout: Duration) -> Result<()> {
        self.timeout = timeout;
        Ok(())
    }

    fn get_timeout(&self) -> Duration {
        self.timeout
    }

    fn connection_type(&self) -> ConnectionType {
        self.connection_type
    }

    fn set_connection_type(&mut self, connection_type: ConnectionType) -> Result<()> {
        self.connection_type = connection_type;
        Ok(())
    }

    fn ctrl_out(
        &mut self,
        request_type: u8,
        request: u8,
        value: u16,
        index: u16,
        data: &[u8],
    ) -> Result<()> {
        self.ctrl(
            request_type,
            request,
            value,
            index,
            data.as_ptr() as *mut c_void,
            data.len() as u16,
        )
        .map_err(|_| Error::Connection(ConnectionError::CtrlTransferOutFailed))?;
        Ok(())
    }

    fn ctrl_in(
        &mut self,
        request_type: u8,
        request: u8,
        value: u16,
        index: u16,
        len: usize,
    ) -> Result<Vec<u8>> {
        let mut buf = vec![0u8; len];
        let n = self
            .ctrl(
                request_type,
                request,
                value,
                index,
                buf.as_mut_ptr() as *mut c_void,
                len as u16,
            )
            .map_err(|_| Error::Connection(ConnectionError::CtrlTransferInFailed))?;
        buf.truncate(n.max(0) as usize);
        Ok(buf)
    }
}
