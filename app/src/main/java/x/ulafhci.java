package x;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.util.Base64;
import com.rynx.app.adbfastboot.AdbFastbootNative;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes.dex */
public final class ulafhci implements AutoCloseable {
    public static final byte[] vntpaom = {48, 33, 48, 9, 6, 5, 43, 14, 3, 2, 26, 5, 0, 4, 20};
    public boolean dytyqos;
    public boolean ekyqleu;
    public final KeyPair imuemzb;
    public final int lthborb;
    public final int nkemejx;
    public final Context nmpwovh;
    public final UsbDeviceConnection ojyssqt;
    public final int oqexvyb;
    public int pvbzgon;
    public final int qxvquar;
    public boolean utmeivs;
    public final int vivhedu;
    public String wqrnifx = "";
    public int dasxvpc = 1;
    public int dplrlfq = 1048576;
    public int ulafhci = 16777216;
    public byte[] buswjhz = new byte[0];
    public final byte[] qyeibyo = new byte[16384];

    public ulafhci(Context context, UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) throws NoSuchAlgorithmException, IOException {
        UsbInterface usbInterface;
        UsbEndpoint usbEndpoint;
        UsbEndpoint usbEndpoint2;
        KeyPair keyPairGenerateKeyPair;
        if (context == null || usbDevice == null || usbDeviceConnection == null) {
            throw new IllegalArgumentException("ADB USB device/connection is not available");
        }
        this.nmpwovh = context.getApplicationContext();
        this.ojyssqt = usbDeviceConnection;
        int i = 0;
        while (true) {
            usbInterface = null;
            UsbEndpoint usbEndpoint3 = null;
            if (i >= usbDevice.getInterfaceCount()) {
                usbEndpoint = null;
                usbEndpoint2 = null;
                break;
            }
            UsbInterface usbInterface2 = usbDevice.getInterface(i);
            if (usbInterface2.getInterfaceClass() == 255 && usbInterface2.getInterfaceSubclass() == 66 && usbInterface2.getInterfaceProtocol() == 1) {
                usbEndpoint2 = null;
                for (int i2 = 0; i2 < usbInterface2.getEndpointCount(); i2++) {
                    UsbEndpoint endpoint = usbInterface2.getEndpoint(i2);
                    if (endpoint.getType() == 2) {
                        usbEndpoint3 = endpoint.getDirection() == 128 ? endpoint : usbEndpoint3;
                        if (endpoint.getDirection() == 0) {
                            usbEndpoint2 = endpoint;
                        }
                    }
                }
                if (usbEndpoint3 != null && usbEndpoint2 != null) {
                    usbEndpoint = usbEndpoint3;
                    usbInterface = usbInterface2;
                    break;
                }
            }
            i++;
        }
        if (usbInterface == null || usbEndpoint == null || usbEndpoint2 == null) {
            throw new IllegalStateException("USB device does not expose an ADB interface (FF/42/01) with bulk endpoints");
        }
        this.nkemejx = usbInterface.getId();
        this.vivhedu = usbEndpoint.getAddress();
        this.lthborb = usbEndpoint2.getAddress();
        this.qxvquar = Math.max(1, usbEndpoint.getMaxPacketSize());
        this.oqexvyb = Math.max(1, usbEndpoint2.getMaxPacketSize());
        File file = new File(this.nmpwovh.getFilesDir(), "adb");
        if (!file.exists() && !file.mkdirs() && !file.isDirectory()) {
            throw new IllegalStateException("Unable to create private ADB key directory");
        }
        File file2 = new File(file, "adbkey.pk8");
        File file3 = new File(file, "adbkey.x509");
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        if (file2.isFile() && file3.isFile()) {
            try {
                keyPairGenerateKeyPair = new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(wqrnifx(file3))), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(wqrnifx(file2))));
            } catch (Exception unused) {
                file2.delete();
                file3.delete();
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
                keyPairGenerator.initialize(2048);
                keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
                pvkaerr(file2, keyPairGenerateKeyPair.getPrivate().getEncoded());
                pvkaerr(file3, keyPairGenerateKeyPair.getPublic().getEncoded());
            }
        } else {
            KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator2.initialize(2048);
            keyPairGenerateKeyPair = keyPairGenerator2.generateKeyPair();
            pvkaerr(file2, keyPairGenerateKeyPair.getPrivate().getEncoded());
            pvkaerr(file3, keyPairGenerateKeyPair.getPublic().getEncoded());
        }
        this.imuemzb = keyPairGenerateKeyPair;
        int iImuemzb = AdbFastbootNative.imuemzb(usbDeviceConnection.getFileDescriptor(), this.nkemejx, usbInterface.getAlternateSetting());
        if (iImuemzb >= 0) {
            this.dytyqos = true;
            return;
        }
        throw new IllegalStateException("Unable to claim ADB USBFS interface (errno " + (-iImuemzb) + ")");
    }

    public static void dytyqos(ByteBuffer byteBuffer, BigInteger bigInteger) {
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigInteger2.shiftLeft(32).subtract(bigInteger2);
        for (int i = 0; i < 64; i++) {
            byteBuffer.putInt(bigInteger.shiftRight(i * 32).and(bigIntegerSubtract).intValue());
        }
    }

    public static String ekyqleu(Context context, UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("ADB shell command is empty");
        }
        ulafhci ulafhciVar = new ulafhci(context, usbDevice, usbDeviceConnection);
        try {
            ulafhciVar.lthborb();
            String strPvbzgon = ulafhciVar.pvbzgon(str.trim());
            ulafhciVar.close();
            return strPvbzgon;
        } catch (Throwable th) {
            try {
                ulafhciVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] gisppfs(int i, String str) {
        if (str.length() != 4) {
            throw new IllegalArgumentException("Invalid ADB sync id");
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(str.getBytes(StandardCharsets.US_ASCII), 0, 4);
        byteBufferOrder.putInt(i);
        return byteBufferOrder.array();
    }

    public static wqrnifx jdqigmr(Context context, UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        int iIndexOf;
        String strTrim = "device";
        ulafhci ulafhciVar = new ulafhci(context, usbDevice, usbDeviceConnection);
        try {
            ulafhciVar.lthborb();
            String[] strArrSplit = ulafhciVar.pvbzgon("getprop ro.product.model; getprop ro.product.name; getprop ro.build.version.release; getprop ro.build.version.sdk; getprop ro.serialno").replace("\r", "").split("\n", -1);
            wqrnifx wqrnifxVar = new wqrnifx();
            wqrnifxVar.nmpwovh = "device";
            wqrnifxVar.ojyssqt = "";
            wqrnifxVar.vivhedu = "";
            wqrnifxVar.lthborb = "";
            wqrnifxVar.qxvquar = "";
            wqrnifxVar.oqexvyb = "";
            String str = ulafhciVar.wqrnifx;
            if (str != null && !str.isEmpty() && (iIndexOf = str.indexOf(58)) > 0) {
                strTrim = str.substring(0, iIndexOf).trim();
            }
            wqrnifxVar.nmpwovh = strTrim;
            if (strArrSplit.length > 0) {
                wqrnifxVar.ojyssqt = strArrSplit[0].trim();
            }
            if (strArrSplit.length > 1) {
                wqrnifxVar.vivhedu = strArrSplit[1].trim();
            }
            if (strArrSplit.length > 2) {
                wqrnifxVar.lthborb = strArrSplit[2].trim();
            }
            if (strArrSplit.length > 3) {
                wqrnifxVar.qxvquar = strArrSplit[3].trim();
            }
            if (strArrSplit.length > 4) {
                wqrnifxVar.oqexvyb = strArrSplit[4].trim();
            }
            ulafhciVar.close();
            return wqrnifxVar;
        } catch (Throwable th) {
            try {
                ulafhciVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] lclupha(String str, byte[] bArr) throws IOException {
        if (bArr.length > 1048568) {
            throw new IllegalArgumentException("ADB sync payload exceeds the protocol limit");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 8);
        byteArrayOutputStream.write(gisppfs(bArr.length, str));
        byteArrayOutputStream.write(bArr);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] nmpwovh(PublicKey publicKey) {
        if (!(publicKey instanceof RSAPublicKey)) {
            throw new IllegalStateException("ADB key is not RSA");
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKey;
        BigInteger modulus = rSAPublicKey.getModulus();
        BigInteger publicExponent = rSAPublicKey.getPublicExponent();
        if (modulus.bitLength() > 2048) {
            throw new IllegalStateException("ADB RSA modulus is larger than 2048 bits");
        }
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(32);
        BigInteger bigIntegerAnd = bigIntegerShiftLeft.subtract(modulus.and(bigIntegerShiftLeft.subtract(bigInteger)).modInverse(bigIntegerShiftLeft)).and(bigIntegerShiftLeft.subtract(bigInteger));
        BigInteger bigIntegerMod = bigInteger.shiftLeft(4096).mod(modulus);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(524).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(64);
        byteBufferOrder.putInt(bigIntegerAnd.intValue());
        dytyqos(byteBufferOrder, modulus);
        dytyqos(byteBufferOrder, bigIntegerMod);
        byteBufferOrder.putInt(publicExponent.intValue());
        return (Base64.encodeToString(byteBufferOrder.array(), 2) + " android@host\u0000").getBytes(StandardCharsets.US_ASCII);
    }

    public static byte[] ojyssqt(String str) {
        byte[] bArrSlxntng = slxntng(1048575, str, "ADB service string");
        return Arrays.copyOf(bArrSlxntng, bArrSlxntng.length + 1);
    }

    public static void pvkaerr(File file, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static File qxvquar(File file) throws IOException {
        File absoluteFile = file.getAbsoluteFile();
        File parentFile = absoluteFile.getParentFile();
        if (parentFile == null) {
            throw new IOException("Output path has no parent directory: " + file);
        }
        if (!parentFile.exists() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Unable to create local directory: " + parentFile);
        }
        String str = "." + absoluteFile.getName() + ".";
        if (str.length() < 3) {
            str = ".adb.";
        }
        return File.createTempFile(str, ".partial", parentFile);
    }

    public static String qyeibyo(String str) {
        return "'" + str.replace("'", "'\\''") + "'";
    }

    public static byte[] slxntng(int i, String str, String str2) {
        if (str == null || i < 0 || str.length() > i) {
            throw new IllegalArgumentException(str2 + " exceeds " + i + " bytes");
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (bytes.length <= i) {
            return bytes;
        }
        throw new IllegalArgumentException(str2 + " exceeds " + i + " UTF-8 bytes");
    }

    public static void ulafhci(Context context, UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, String str) {
        String lowerCase = str == null ? "" : str.trim().toLowerCase(Locale.ROOT);
        if (!lowerCase.isEmpty() && !"system".equals(lowerCase) && !"recovery".equals(lowerCase) && !"bootloader".equals(lowerCase) && !"fastboot".equals(lowerCase) && !"sideload".equals(lowerCase) && !"sideload-auto-reboot".equals(lowerCase)) {
            throw new IllegalArgumentException("Unsupported ADB reboot target: " + str);
        }
        String str2 = "system".equals(lowerCase) ? "" : lowerCase;
        ulafhci ulafhciVar = new ulafhci(context, usbDevice, usbDeviceConnection);
        try {
            ulafhciVar.lthborb();
            ulafhciVar.oqexvyb("reboot:".concat(str2));
            ulafhciVar.close();
        } catch (Throwable th) {
            try {
                ulafhciVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void utmeivs(Context context, UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, String str, pvkaerr pvkaerrVar) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("ADB shell command is empty");
        }
        ulafhci ulafhciVar = new ulafhci(context, usbDevice, usbDeviceConnection);
        try {
            ulafhciVar.lthborb();
            oqexvyb oqexvybVarImuemzb = ulafhciVar.imuemzb("shell:" + str.trim());
            try {
                dplrlfq dplrlfqVar = new dplrlfq();
                while (!Thread.currentThread().isInterrupted()) {
                    byte[] bArrNmpwovh = oqexvybVarImuemzb.nmpwovh();
                    if (bArrNmpwovh == null) {
                        String strVivhedu = dplrlfqVar.vivhedu(new byte[0], true);
                        if (!strVivhedu.isEmpty()) {
                            pvkaerrVar.nmpwovh(strVivhedu);
                        }
                        oqexvybVarImuemzb.close();
                        ulafhciVar.close();
                        return;
                    }
                    if (bArrNmpwovh.length > 0) {
                        String strVivhedu2 = dplrlfqVar.vivhedu(bArrNmpwovh, false);
                        if (!strVivhedu2.isEmpty()) {
                            pvkaerrVar.nmpwovh(strVivhedu2);
                        }
                    }
                }
                throw new InterruptedException("ADB shell command cancelled");
            } catch (Throwable th) {
                try {
                    oqexvybVarImuemzb.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                ulafhciVar.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static void vivhedu(File file, File file2) throws IOException {
        try {
            Files.move(file.toPath(), file2.getAbsoluteFile().toPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (AtomicMoveNotSupportedException unused) {
            Files.move(file.toPath(), file2.getAbsoluteFile().toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static byte[] wqrnifx(File file) throws IOException {
        long length = file.length();
        if (length <= 0 || length > 65536) {
            throw new IOException("Invalid ADB key file length: " + length);
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) length);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i < 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        fileInputStream.close();
                        return byteArray;
                    }
                    if (i > 0) {
                        if (((long) byteArrayOutputStream.size()) + ((long) i) > 65536) {
                            throw new IOException("ADB key file grew beyond the size limit");
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                fileInputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public final void atntgcp(File file, String str) {
        oqexvyb oqexvybVarImuemzb = imuemzb("sync:");
        try {
            dasxvpc dasxvpcVar = new dasxvpc(oqexvybVarImuemzb);
            if (str.length() > 1048560) {
                throw new IllegalArgumentException("ADB remote path is too long");
            }
            oqexvybVarImuemzb.ojyssqt(lclupha("SEND", slxntng(1048568, str.concat(",33188"), "ADB sync SEND path")));
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[65536];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i < 0) {
                        break;
                    }
                    if (i != 0) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i + 8);
                        byteArrayOutputStream.write(gisppfs(i, "DATA"));
                        byteArrayOutputStream.write(bArr, 0, i);
                        oqexvybVarImuemzb.ojyssqt(byteArrayOutputStream.toByteArray());
                    }
                }
                fileInputStream.close();
                oqexvybVarImuemzb.ojyssqt(gisppfs((int) Math.min(2147483647L, Math.max(0L, file.lastModified() / 1000)), "DONE"));
                byte[] bArrNmpwovh = dasxvpcVar.nmpwovh(8);
                String str2 = new String(bArrNmpwovh, 0, 4, StandardCharsets.US_ASCII);
                int i2 = ByteBuffer.wrap(bArrNmpwovh, 4, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
                if ("OKAY".equals(str2)) {
                    oqexvybVarImuemzb.close();
                    return;
                }
                if (!"FAIL".equals(str2)) {
                    throw new IllegalStateException("Unexpected ADB sync response: " + str2);
                }
                if (i2 < 0 || i2 > 65536) {
                    throw new IllegalStateException("Invalid ADB sync FAIL length: " + i2);
                }
                throw new IllegalStateException("ADB push failed: " + (i2 > 0 ? new String(dasxvpcVar.nmpwovh(i2), StandardCharsets.UTF_8) : "unknown error"));
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            try {
                oqexvybVarImuemzb.close();
            } catch (Throwable th5) {
                th4.addSuppressed(th5);
            }
            throw th4;
        }
    }

    public final void buswjhz(int i, int i2, int i3, byte[] bArr) {
        int i4;
        int i5;
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException("ADB operation cancelled");
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr.length > (this.utmeivs ? this.dplrlfq : 4096)) {
            throw new IllegalStateException("ADB payload exceeds negotiated maxdata");
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(24).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(i);
        byteBufferOrder.putInt(i2);
        byteBufferOrder.putInt(i3);
        byteBufferOrder.putInt(bArr.length);
        if (!this.utmeivs ? this.ekyqleu : this.ulafhci >= 16777217) {
            i4 = 0;
        } else {
            i4 = 0;
            for (byte b : bArr) {
                i4 += b & 255;
            }
        }
        byteBufferOrder.putInt(i4);
        byteBufferOrder.putInt(~i);
        czidoiw(byteBufferOrder.array());
        if (bArr.length > 0) {
            czidoiw(bArr);
            int length = bArr.length;
            if (length <= 0 || (i5 = this.oqexvyb) <= 0 || length % i5 != 0) {
                return;
            }
            int iDasxvpc = AdbFastbootNative.dasxvpc(this.ojyssqt.getFileDescriptor(), this.lthborb, new byte[0], 0, 0);
            if (iDasxvpc < 0) {
                throw new IllegalStateException("ADB USBFS zero-length packet failed (errno " + (-iDasxvpc) + ")");
            }
            if (iDasxvpc == 0) {
                return;
            }
            throw new IllegalStateException("ADB USBFS zero-length packet returned " + iDasxvpc + " bytes");
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.dytyqos) {
            try {
                AdbFastbootNative.wqrnifx(this.ojyssqt.getFileDescriptor(), this.nkemejx);
            } catch (Throwable unused) {
            }
            this.dytyqos = false;
        }
    }

    public final void czidoiw(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            if (Thread.currentThread().isInterrupted()) {
                throw new IllegalStateException("ADB operation cancelled");
            }
            int iDasxvpc = AdbFastbootNative.dasxvpc(this.ojyssqt.getFileDescriptor(), this.lthborb, bArr, i, bArr.length - i);
            if (iDasxvpc < 0) {
                throw new IllegalStateException("ADB USBFS write failed (errno " + (-iDasxvpc) + ") at " + i + "/" + bArr.length);
            }
            if (iDasxvpc == 0) {
                throw new IllegalStateException("ADB USBFS write returned 0 bytes");
            }
            i += iDasxvpc;
        }
    }

    public final void dasxvpc(byte[] bArr, boolean z) {
        int iMin;
        int iMax;
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException("ADB operation cancelled");
            }
            int i3 = this.pvbzgon;
            byte[] bArr2 = this.buswjhz;
            if (i3 < bArr2.length) {
                int iMin2 = Math.min(bArr2.length - i3, bArr.length - i);
                System.arraycopy(this.buswjhz, this.pvbzgon, bArr, i, iMin2);
                int i4 = this.pvbzgon + iMin2;
                this.pvbzgon = i4;
                i += iMin2;
                if (i4 == this.buswjhz.length) {
                    this.buswjhz = new byte[0];
                    this.pvbzgon = 0;
                }
            } else {
                int length = bArr.length - i;
                byte[] bArr3 = this.qyeibyo;
                int length2 = bArr3.length;
                if (length <= 0 || length2 <= 0 || length2 < (iMax = Math.max(1, this.qxvquar))) {
                    iMin = 0;
                } else {
                    long j = iMax;
                    iMin = (int) Math.min(length2, Math.max(j, (((((long) Math.min(length, length2)) + j) - 1) / j) * j));
                }
                if (iMin <= 0) {
                    throw new IllegalStateException("Invalid ADB USBFS read buffer geometry");
                }
                int iDytyqos = AdbFastbootNative.dytyqos(this.ojyssqt.getFileDescriptor(), this.vivhedu, iMin, bArr3);
                if (iDytyqos <= 0) {
                    if (iDytyqos < 0 && iDytyqos != -110) {
                        throw new IllegalStateException("ADB USBFS read failed (errno " + (-iDytyqos) + ") at " + i + "/" + bArr.length);
                    }
                    if (i == 0 && z) {
                        throw new dytyqos();
                    }
                    i2++;
                    if (i2 >= 60) {
                        throw new IllegalStateException("ADB packet truncated at " + i + "/" + bArr.length);
                    }
                } else {
                    if (iDytyqos > iMin) {
                        throw new IllegalStateException("ADB USBFS read exceeded submitted buffer: " + iDytyqos + "/" + iMin);
                    }
                    int iMin3 = Math.min(iDytyqos, bArr.length - i);
                    System.arraycopy(bArr3, 0, bArr, i, iMin3);
                    i += iMin3;
                    if (iMin3 < iDytyqos) {
                        this.buswjhz = Arrays.copyOfRange(bArr3, iMin3, iDytyqos);
                        this.pvbzgon = 0;
                    }
                    i2 = 0;
                }
            }
        }
    }

    public final imuemzb dplrlfq() {
        byte[] bArr = new byte[24];
        dasxvpc(bArr, true);
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        int i = byteBufferOrder.getInt();
        int i2 = byteBufferOrder.getInt();
        int i3 = byteBufferOrder.getInt();
        int i4 = byteBufferOrder.getInt();
        int i5 = byteBufferOrder.getInt();
        if (byteBufferOrder.getInt() != (~i)) {
            throw new IllegalStateException("Invalid ADB packet magic");
        }
        int iMin = this.utmeivs ? Math.min(1048576, this.dplrlfq) : 4096;
        if (i4 < 0 || i4 > iMin) {
            throw new IllegalStateException("Invalid ADB payload length: " + i4);
        }
        byte[] bArr2 = new byte[i4];
        if (i4 > 0) {
            dasxvpc(bArr2, false);
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            i6 += bArr2[i7] & 255;
        }
        if (this.utmeivs) {
            if (this.ulafhci < 16777217 && i5 != i6) {
                throw new IllegalStateException("ADB packet checksum mismatch");
            }
        } else if (i5 == 0) {
            this.ekyqleu = true;
        } else if (i5 != i6) {
            throw new IllegalStateException("ADB handshake packet checksum mismatch");
        }
        return new imuemzb(i, i2, i3, bArr2);
    }

    public final oqexvyb imuemzb(String str) {
        imuemzb imuemzbVarDplrlfq;
        int i;
        int i2 = this.dasxvpc;
        this.dasxvpc = i2 + 1;
        buswjhz(1313165391, i2, 0, ojyssqt(str));
        while (true) {
            int i3 = 0;
            while (true) {
                if (i3 >= 60) {
                    throw new IllegalStateException("Timed out opening ADB service: " + str);
                }
                try {
                    imuemzbVarDplrlfq = dplrlfq();
                } catch (dytyqos unused) {
                    i3++;
                }
            }
            int i4 = imuemzbVarDplrlfq.vivhedu;
            int i5 = imuemzbVarDplrlfq.nmpwovh;
            if (i5 == 1497451343 && i4 == i2 && (i = imuemzbVarDplrlfq.ojyssqt) != 0) {
                return new oqexvyb(this, i2, i);
            }
            if (i5 == 1163086915 && i4 == i2) {
                throw new IllegalStateException("ADB service refused: " + str);
            }
        }
    }

    public final void lthborb() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, nkemejx, InvalidKeyException {
        int i;
        byte[] bArrDoFinal;
        buswjhz(1314410051, 16777217, 1048576, ojyssqt("host::"));
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        for (int i3 = 0; i3 < 24; i3++) {
            try {
                imuemzb imuemzbVarDplrlfq = dplrlfq();
                byte[] bArr = imuemzbVarDplrlfq.lthborb;
                int i4 = imuemzbVarDplrlfq.ojyssqt;
                int i5 = imuemzbVarDplrlfq.nmpwovh;
                if (i5 == 1314410051) {
                    if (i4 < 16777216 || (i = imuemzbVarDplrlfq.vivhedu) <= 0) {
                        throw new IllegalStateException("Invalid ADB version/maxdata in CNXN");
                    }
                    this.ulafhci = Math.min(16777217, i4);
                    this.dplrlfq = Math.min(1048576, i);
                    int i6 = 0;
                    while (i6 < bArr.length && bArr[i6] != 0) {
                        i6++;
                    }
                    this.wqrnifx = new String(bArr, 0, i6, StandardCharsets.UTF_8).trim();
                    this.utmeivs = true;
                    return;
                }
                if (i5 == 1397511251) {
                    throw new IllegalStateException("ADB target requested STLS/TLS, which is not supported by this direct USB transport");
                }
                if (i5 == 1213486401 && i4 == 1) {
                    if (bArr.length != 20) {
                        throw new IllegalStateException("Unexpected ADB AUTH token length: " + bArr.length);
                    }
                    KeyPair keyPair = this.imuemzb;
                    if (!z2) {
                        PrivateKey privateKey = keyPair.getPrivate();
                        byte[] bArr2 = new byte[bArr.length + 15];
                        System.arraycopy(vntpaom, 0, bArr2, 0, 15);
                        System.arraycopy(bArr, 0, bArr2, 15, bArr.length);
                        try {
                            Signature signature = Signature.getInstance("NONEwithRSA");
                            signature.initSign(privateKey);
                            signature.update(bArr2);
                            bArrDoFinal = signature.sign();
                        } catch (Exception unused) {
                            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                            cipher.init(1, privateKey);
                            bArrDoFinal = cipher.doFinal(bArr2);
                        }
                        buswjhz(1213486401, 2, 0, bArrDoFinal);
                        z2 = true;
                    } else if (z) {
                        buswjhz(1213486401, 3, 0, nmpwovh(keyPair.getPublic()));
                    } else {
                        buswjhz(1213486401, 3, 0, nmpwovh(keyPair.getPublic()));
                        z = true;
                    }
                }
            } catch (dytyqos unused2) {
                if (!z) {
                    throw new IllegalStateException("Timed out waiting for ADB handshake");
                }
                i2++;
                if (i2 >= 5) {
                    throw new nkemejx("ADB authorization pending. Tap Allow USB debugging on the target, then refresh.");
                }
            }
        }
        if (!z) {
            throw new IllegalStateException("ADB handshake did not complete");
        }
        throw new nkemejx("ADB authorization pending. Tap Allow USB debugging on the target, then refresh.");
    }

    public final String nkemejx(int i, String str, boolean z) throws InterruptedException, IOException {
        int i2 = this.dasxvpc;
        this.dasxvpc = i2 + 1;
        buswjhz(1313165391, i2, 0, ojyssqt(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException("ADB service cancelled");
            }
            try {
                imuemzb imuemzbVarDplrlfq = dplrlfq();
                int i5 = imuemzbVarDplrlfq.ojyssqt;
                int i6 = imuemzbVarDplrlfq.vivhedu;
                int i7 = imuemzbVarDplrlfq.nmpwovh;
                if (i7 != 1497451343 || i6 != i2 || i5 == 0) {
                    byte[] bArr = imuemzbVarDplrlfq.lthborb;
                    if (i7 == 1163154007 && i6 == i2 && i4 != 0 && i5 == i4) {
                        if (((long) byteArrayOutputStream.size()) + ((long) bArr.length) > 16777216) {
                            buswjhz(1497451343, i2, i4, new byte[0]);
                            buswjhz(1163086915, i2, i4, new byte[0]);
                            throw new IllegalStateException("ADB text output exceeded 16777216 bytes; redirect large/binary output to a file instead");
                        }
                        byteArrayOutputStream.write(bArr);
                        buswjhz(1497451343, i2, i4, new byte[0]);
                    } else {
                        if (i7 == 1163086915 && i6 == i2) {
                            if (i4 != 0) {
                                if (i5 == i4) {
                                    return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                                }
                                throw new IllegalStateException("ADB CLOSE stream id mismatch");
                            }
                            throw new IllegalStateException("ADB service refused: " + str);
                        }
                        if (i7 == 1314410051) {
                            int i8 = 0;
                            while (i8 < bArr.length && bArr[i8] != 0) {
                                i8++;
                            }
                            this.wqrnifx = new String(bArr, 0, i8, StandardCharsets.UTF_8).trim();
                        }
                    }
                    i3 = 0;
                } else if (i4 == 0) {
                    i3 = 0;
                    i4 = i5;
                } else {
                    i3 = 0;
                }
            } catch (dytyqos unused) {
                i3++;
                if (!z || i4 == 0 || byteArrayOutputStream.size() <= 0) {
                    continue;
                } else if (i3 >= 3) {
                    return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                }
            }
        }
        if (i4 == 0) {
            throw new IllegalStateException("ADB service refused or timed out: " + str);
        }
        buswjhz(1163086915, i2, i4, new byte[0]);
        throw new IllegalStateException("ADB service timed out: " + str);
    }

    public final void oqexvyb(String str) {
        int i = this.dasxvpc;
        this.dasxvpc = i + 1;
        buswjhz(1313165391, i, 0, ojyssqt(str));
        while (true) {
            int i2 = 0;
            while (i2 < 3) {
                try {
                    imuemzb imuemzbVarDplrlfq = dplrlfq();
                    try {
                        int i3 = imuemzbVarDplrlfq.nmpwovh;
                        int i4 = imuemzbVarDplrlfq.vivhedu;
                        if (i3 != 1497451343 && i4 == i && imuemzbVarDplrlfq.ojyssqt != 0) {
                            return;
                        }
                        if (i3 != 1163086915 && i4 == i) {
                            throw new IllegalStateException("ADB service refused before OPEN acknowledgement: " + str);
                        }
                        while (true) {
                            imuemzb imuemzbVarDplrlfq2 = dplrlfq();
                            int i5 = imuemzbVarDplrlfq2.nmpwovh;
                            int i6 = imuemzbVarDplrlfq2.vivhedu;
                            if (i5 != 1497451343) {
                            }
                            if (i5 != 1163086915) {
                                break;
                            }
                            throw new IllegalStateException("ADB service refused before OPEN acknowledgement: " + str);
                            i2++;
                        }
                    } catch (dytyqos unused) {
                        i2 = 0;
                        i2++;
                    }
                } catch (dytyqos unused2) {
                }
                int i7 = 0;
            }
            throw new IllegalStateException("ADB service was not acknowledged before transport timeout: " + str);
        }
    }

    public final String pvbzgon(String str) {
        return nkemejx(120, "shell:" + str, false);
    }

    public final long vntpaom(File file) {
        long length = file.length();
        long j = 0;
        if (length <= 0) {
            throw new IllegalArgumentException("OTA package is empty");
        }
        oqexvyb oqexvybVarImuemzb = imuemzb("sideload-host:" + length + ":65536");
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] bArrNmpwovh = new byte[0];
                int i = 0;
                while (true) {
                    byte[] bArr = new byte[8];
                    int i2 = 0;
                    while (i2 < 8) {
                        if (i >= bArrNmpwovh.length) {
                            bArrNmpwovh = oqexvybVarImuemzb.nmpwovh();
                            if (bArrNmpwovh == null) {
                                throw new IllegalStateException("ADB stream closed unexpectedly");
                            }
                            i = 0;
                        }
                        int iMin = Math.min(8 - i2, bArrNmpwovh.length - i);
                        System.arraycopy(bArrNmpwovh, i, bArr, i2, iMin);
                        i += iMin;
                        i2 += iMin;
                    }
                    String str = new String(bArr, StandardCharsets.US_ASCII);
                    if ("DONEDONE".equals(str)) {
                        randomAccessFile.close();
                        oqexvybVarImuemzb.close();
                        return length;
                    }
                    if ("FAILFAIL".equals(str)) {
                        throw new IllegalStateException("ADB sideload target reported failure");
                    }
                    try {
                        int i3 = Integer.parseInt(str);
                        long j2 = ((long) i3) * 65536;
                        if (j2 < j || j2 >= length) {
                            throw new IllegalStateException("ADB sideload requested invalid block " + i3);
                        }
                        byte[] bArr2 = new byte[(int) Math.min(65536L, length - j2)];
                        randomAccessFile.seek(j2);
                        randomAccessFile.readFully(bArr2);
                        oqexvybVarImuemzb.ojyssqt(bArr2);
                        j = 0;
                    } catch (NumberFormatException unused) {
                        throw new IllegalStateException("Invalid ADB sideload block request: " + str);
                    }
                }
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                    throw th2;
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                oqexvybVarImuemzb.close();
            } catch (Throwable th5) {
                th4.addSuppressed(th5);
            }
            throw th4;
        }
    }

    public final long zwaqeaz(File file, String str) throws IOException {
        File fileQxvquar = qxvquar(file);
        try {
            oqexvyb oqexvybVarImuemzb = imuemzb("sync:");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileQxvquar, false);
                try {
                    dasxvpc dasxvpcVar = new dasxvpc(oqexvybVarImuemzb);
                    oqexvybVarImuemzb.ojyssqt(lclupha("RECV", slxntng(1048568, str, "ADB sync RECV path")));
                    long length = 0;
                    while (true) {
                        byte[] bArrNmpwovh = dasxvpcVar.nmpwovh(8);
                        String str2 = new String(bArrNmpwovh, 0, 4, StandardCharsets.US_ASCII);
                        int i = ByteBuffer.wrap(bArrNmpwovh, 4, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
                        if (!"DATA".equals(str2)) {
                            if ("DONE".equals(str2)) {
                                fileOutputStream.flush();
                                fileOutputStream.getFD().sync();
                                fileOutputStream.close();
                                oqexvybVarImuemzb.close();
                                vivhedu(fileQxvquar, file);
                                return length;
                            }
                            if (!"FAIL".equals(str2)) {
                                throw new IllegalStateException("Unexpected ADB sync response: " + str2);
                            }
                            if (i < 0 || i > 65536) {
                                throw new IllegalStateException("Invalid ADB sync FAIL length: " + i);
                            }
                            throw new IllegalStateException("ADB pull failed: " + (i > 0 ? new String(dasxvpcVar.nmpwovh(i), StandardCharsets.UTF_8) : "unknown error"));
                        }
                        if (i < 0 || i > 65536) {
                            throw new IllegalStateException("Invalid ADB sync DATA length: " + i);
                        }
                        byte[] bArrNmpwovh2 = dasxvpcVar.nmpwovh(i);
                        fileOutputStream.write(bArrNmpwovh2);
                        length += (long) bArrNmpwovh2.length;
                    }
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    oqexvybVarImuemzb.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Throwable th5) {
            if (fileQxvquar != null && fileQxvquar.exists() && !fileQxvquar.delete()) {
                fileQxvquar.deleteOnExit();
            }
            throw th5;
        }
    }
}
