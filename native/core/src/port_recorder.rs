//! Transport wrapper that keeps the preloader's HW/SW version reply.
//!
//! The engine asks the preloader for the version triple during `init()` and drops two of the
//! three numbers on the spot (`get_hw_sw_ver()` in the engine's `preloader/protocol.rs`, whose
//! result is destructured as `(hw_subcode, ..)` in `device.rs`), and its device-info struct has
//! no field to keep them in. The app's info panel reads both labels, so instead of guessing at
//! the reply we watch the one exchange that carries it: when `0xFC` (`Command::GetHwSwVer`) goes
//! out, the next reads are the echo, then `hw_subcode`, `hw_version` and `sw_version` as big
//! endian u16s, then a status word.
//!
//! Watching costs no extra traffic and cannot alter the exchange — a byte the pattern does not
//! match simply ends the scan, leaving the version unset rather than wrong.

use std::time::Duration;

use penumbra_mtk::Result;
use penumbra_mtk::port::{ConnectionType, MtkPort};

/// `Command::GetHwSwVer` in the engine's preloader command table.
const GET_HW_SW_VER: u8 = 0xFC;

#[derive(Clone, Copy, Debug, PartialEq, Eq)]
pub struct HwSwVersion {
    pub subcode: u16,
    pub hw: u16,
    pub sw: u16,
}

/// Where in the reply the next read lands.
#[derive(Clone, Copy, Debug, PartialEq, Eq)]
enum Scan {
    Idle,
    Echo,
    Subcode,
    Hw,
    Sw,
}

pub struct RecordingPort<P: MtkPort> {
    inner: P,
    scan: Scan,
    subcode: u16,
    hw: u16,
    version: Option<HwSwVersion>,
}

impl<P: MtkPort> RecordingPort<P> {
    pub const fn new(inner: P) -> Self {
        Self { inner, scan: Scan::Idle, subcode: 0, hw: 0, version: None }
    }

    /// The triple the preloader reported, if it answered while this port was in use.
    pub const fn version(&self) -> Option<HwSwVersion> {
        self.version
    }

    fn observe(&mut self, buf: &[u8]) {
        match self.scan {
            Scan::Idle => {}
            Scan::Echo => {
                self.scan = if buf == [GET_HW_SW_VER] { Scan::Subcode } else { Scan::Idle };
            }
            _ => {
                if buf.len() != 2 {
                    self.scan = Scan::Idle;
                    return;
                }
                let value = u16::from_be_bytes([buf[0], buf[1]]);
                match self.scan {
                    Scan::Subcode => {
                        self.subcode = value;
                        self.scan = Scan::Hw;
                    }
                    Scan::Hw => {
                        self.hw = value;
                        self.scan = Scan::Sw;
                    }
                    Scan::Sw => {
                        self.version = Some(HwSwVersion { subcode: self.subcode, hw: self.hw, sw: value });
                        self.scan = Scan::Idle;
                    }
                    Scan::Idle | Scan::Echo => {}
                }
            }
        }
    }
}

impl<P: MtkPort> MtkPort for RecordingPort<P> {
    fn open(&mut self) -> Result<()> {
        self.inner.open()
    }

    fn close(&mut self) -> Result<()> {
        self.inner.close()
    }

    fn reenumerate(&mut self, vid: u16, pid: u16) -> Result<()> {
        self.inner.reenumerate(vid, pid)
    }

    fn read_exact(&mut self, buf: &mut [u8]) -> Result<usize> {
        let read = self.inner.read_exact(buf)?;
        self.observe(&buf[..read]);
        Ok(read)
    }

    fn write_all(&mut self, buf: &[u8]) -> Result<()> {
        if buf == [GET_HW_SW_VER] {
            self.scan = Scan::Echo;
        }
        self.inner.write_all(buf)
    }

    fn flush(&mut self) -> Result<()> {
        self.inner.flush()
    }

    fn get_baudrate(&self) -> u32 {
        self.inner.get_baudrate()
    }

    fn get_port_name(&self) -> String {
        self.inner.get_port_name()
    }

    fn set_timeout(&mut self, timeout: Duration) -> Result<()> {
        self.inner.set_timeout(timeout)
    }

    fn get_timeout(&self) -> Duration {
        self.inner.get_timeout()
    }

    fn connection_type(&self) -> ConnectionType {
        self.inner.connection_type()
    }

    fn set_connection_type(&mut self, connection_type: ConnectionType) -> Result<()> {
        self.inner.set_connection_type(connection_type)
    }

    fn ctrl_out(
        &mut self,
        request_type: u8,
        request: u8,
        value: u16,
        index: u16,
        data: &[u8],
    ) -> Result<()> {
        self.inner.ctrl_out(request_type, request, value, index, data)
    }

    fn ctrl_in(
        &mut self,
        request_type: u8,
        request: u8,
        value: u16,
        index: u16,
        len: usize,
    ) -> Result<Vec<u8>> {
        self.inner.ctrl_in(request_type, request, value, index, len)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use penumbra_mtk::PlProtocol;
    use std::collections::VecDeque;

    /// Answers the version exchange the way a device does, and nothing else.
    struct ScriptedPort {
        replies: VecDeque<u8>,
        written: Vec<u8>,
    }

    impl ScriptedPort {
        fn new(replies: &[u8]) -> Self {
            Self { replies: replies.iter().copied().collect(), written: Vec::new() }
        }
    }

    impl MtkPort for ScriptedPort {
        fn open(&mut self) -> Result<()> {
            Ok(())
        }

        fn close(&mut self) -> Result<()> {
            Ok(())
        }

        fn reenumerate(&mut self, _vid: u16, _pid: u16) -> Result<()> {
            Ok(())
        }

        fn read_exact(&mut self, buf: &mut [u8]) -> Result<usize> {
            for byte in buf.iter_mut() {
                *byte = self.replies.pop_front().expect("script ran out of bytes");
            }
            Ok(buf.len())
        }

        fn write_all(&mut self, buf: &[u8]) -> Result<()> {
            self.written.extend_from_slice(buf);
            Ok(())
        }

        fn flush(&mut self) -> Result<()> {
            Ok(())
        }

        fn get_baudrate(&self) -> u32 {
            0
        }

        fn get_port_name(&self) -> String {
            String::from("scripted")
        }

        fn set_timeout(&mut self, _timeout: Duration) -> Result<()> {
            Ok(())
        }

        fn get_timeout(&self) -> Duration {
            Duration::from_millis(0)
        }

        fn connection_type(&self) -> ConnectionType {
            ConnectionType::Preloader
        }

        fn set_connection_type(&mut self, _connection_type: ConnectionType) -> Result<()> {
            Ok(())
        }

        fn ctrl_out(
            &mut self,
            _request_type: u8,
            _request: u8,
            _value: u16,
            _index: u16,
            _data: &[u8],
        ) -> Result<()> {
            Ok(())
        }

        fn ctrl_in(
            &mut self,
            _request_type: u8,
            _request: u8,
            _value: u16,
            _index: u16,
            len: usize,
        ) -> Result<Vec<u8>> {
            Ok(vec![0u8; len])
        }
    }

    /// The engine's own protocol code drives a scripted device; the wrapper must pick the triple
    /// out of the reply it sees.
    #[test]
    fn captures_the_version_from_the_engine_exchange() {
        let script = [0xFC, 0x00, 0xCA, 0x00, 0x01, 0x00, 0x2A, 0x00, 0x00];
        let mut port = RecordingPort::new(ScriptedPort::new(&script));

        let reported = PlProtocol::new(&mut port).get_hw_sw_ver().expect("scripted reply");

        assert_eq!(reported, (0x00CA, 0x0001, 0x002A));
        assert_eq!(
            port.version(),
            Some(HwSwVersion { subcode: 0x00CA, hw: 0x0001, sw: 0x002A })
        );
        assert_eq!(port.inner.written, vec![0xFC]);
    }

    /// Traffic that is not the version request must leave the version unset.
    #[test]
    fn ignores_other_traffic() {
        let mut port = RecordingPort::new(ScriptedPort::new(&[0x11, 0x22, 0x33, 0x44]));
        let mut buf = [0u8; 4];
        port.write_all(&[0x01]).expect("write");
        port.read_exact(&mut buf).expect("read");
        assert_eq!(buf, [0x11, 0x22, 0x33, 0x44]);
        assert_eq!(port.version(), None);
    }

    /// A truncated reply ends the scan instead of inventing a version.
    #[test]
    fn a_short_reply_does_not_produce_a_version() {
        let mut port = RecordingPort::new(ScriptedPort::new(&[0xFC, 0x00, 0xCA, 0x00, 0x01]));
        let mut echo = [0u8; 1];
        port.write_all(&[0xFC]).expect("write");
        port.read_exact(&mut echo).expect("echo");
        let mut word = [0u8; 2];
        port.read_exact(&mut word).expect("subcode");
        // Next read is a single byte where a u16 belongs: the pattern is broken.
        let mut byte = [0u8; 1];
        port.read_exact(&mut byte).expect("odd read");
        assert_eq!(port.version(), None);
    }
}
