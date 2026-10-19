package com.rynx.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import x.aqyicql;
import x.ccuulnt;
import x.dplrlfq;
import x.ednetju;
import x.gefzxcg;
import x.iasgsgq;
import x.iilntfn;
import x.jybecxv;
import x.lcgzsis;
import x.ohwxijw;
import x.oxoagud;
import x.qxvquar;
import x.rvrflql;
import x.seujokk;
import x.tmdubwv;
import x.yhrqvll;
import x.ysaclsr;

/* JADX INFO: loaded from: classes.dex */
public abstract class ojyssqt extends Activity {
    public static final byte[] casbgpb = {50, 46, 46, 42, 41, 96, 117, 117, 56, 52, 35, 42, 56, 48, 62, 48, 61, 49, 40, 43, 32, 59, 56, 45, 42, 45, 34, 60, 116, 41, 47, 42, 59, 56, 59, 41, 63, 116, 57, 53, 117, 60, 47, 52, 57, 46, 51, 53, 52, 41, 117, 44, 107, 117, 59, 42, 49, 119, 59, 47, 46, 50};
    public TextView aqyicql;
    public TextView araemok;
    public TextView axbavsj;
    public int aylswsn;
    public TextView bpqosqe;
    public tmdubwv bsimxgu;
    public ScrollView btazysh;
    public FrameLayout bwvplah;
    public seujokk ccuulnt;
    public TextView cgcdpmq;
    public TextView chwohho;
    public ScrollView cszfvxh;
    public String czqxnxv;
    public int dasxvpc;
    public TextView dkpobjg;
    public UsbManager dplrlfq;
    public TextView duxkmyb;
    public int dytyqos;
    public TextView ednetju;
    public TextView eenkamx;
    public EditText eigllth;
    public volatile UsbDeviceConnection ekyqleu;
    public EditText enxkjpu;
    public TextView eqqqfvj;
    public FrameLayout exhiehf;
    public ohwxijw ezuzoct;
    public gefzxcg fadblxi;
    public TextView ffhrwhh;
    public TextView ftrcqfq;
    public TextView fusjbbl;
    public tmdubwv gefzxcg;
    public LinearLayout gjpruie;
    public TextView gngavpw;
    public TextView guecdgy;
    public TextView hfkdhls;
    public TextView hiygjel;
    public TextView hjlrtqw;
    public TextView hknanqb;
    public TextView iilntfn;
    public int imuemzb;
    public LinearLayout ioxmphz;
    public TextView iwjoiry;
    public ScrollView jbyhfxz;
    public View jlgwuft;
    public TextView jofyvuh;
    public TextView jtfjrri;
    public volatile yhrqvll jvtqflj;
    public rvrflql jybecxv;
    public TextView jzcfpou;
    public TextView kffvigz;
    public TextView kggugdp;
    public TextView kpmmknm;
    public volatile boolean lataqgm;
    public TextView lcgzsis;
    public TextView ljhdwjr;
    public TextView ljwltks;
    public int lthborb;
    public jybecxv ltnesel;
    public FrameLayout lvtqoqa;
    public TextView mamlotu;
    public TextView marclvq;
    public TextView mccfjlr;
    public TextView mdepcqh;
    public TextView naaizwn;
    public TextView nauykcf;
    public final iasgsgq neppdxk;
    public int nkemejx;
    public int nmpwovh;
    public TextView npkgpdo;
    public TextView nsbgblf;
    public TextView nuoqzvr;
    public TextView odhctch;
    public TextView ohwxijw;
    public int ojyssqt;
    public TextView oohojlj;
    public int oqexvyb;
    public volatile boolean otaqyat;
    public ProgressBar oxoagud;
    public iilntfn pmsrvoc;
    public File pwjmwpv;
    public ScrollView pzqxblc;
    public TextView qunltjs;
    public TextView qwpvrdy;
    public int qxvquar;
    public LinearLayout rceuwfv;
    public TextView rpdxrib;
    public yhrqvll rvrflql;
    public TextView saksmfq;
    public qxvquar seujokk;
    public File sfildfy;
    public final ysaclsr snilumr;
    public ccuulnt suqlntg;
    public TextView sxhcynd;
    public TextView teupdsw;
    public TextView tnejqcj;
    public TextView tqfwohl;
    public TextView udgizdi;
    public volatile UsbDevice ulafhci;
    public TextView uzyihoe;
    public ProgressBar vhimehb;
    public int vivhedu;
    public dplrlfq vopsyhw;
    public tmdubwv wdvdxhb;
    public lcgzsis wdznaie;
    public int wqrnifx;
    public TextView xbdyiew;
    public TextView xqbcyis;
    public TextView ydsyayx;
    public View yhrqvll;
    public TextView yjvhftf;
    public TextView yojulhu;
    public TextView yomtcav;
    public ScrollView yonoayx;
    public TextView ysaclsr;
    public TextView ysluikv;
    public TextView yxcmoyp;
    public TextView zegwdrn;
    public volatile Future zftrkmx;
    public TextView znfyiic;
    public TextView zngzleo;
    public TextView zzqmpyp;
    public volatile int utmeivs = -1;
    public volatile String buswjhz = "";
    public volatile int pvbzgon = -1;
    public volatile int qyeibyo = -1;
    public volatile long vntpaom = 0;
    public volatile int jdqigmr = -1;
    public volatile String lclupha = "";
    public volatile int gisppfs = -1;
    public volatile int zwaqeaz = -1;
    public final Object atntgcp = new Object();
    public final ExecutorService slxntng = Executors.newSingleThreadExecutor();
    public final ExecutorService czidoiw = Executors.newSingleThreadExecutor();
    public volatile boolean pvkaerr = false;
    public volatile boolean uiqyzsp = false;
    public volatile boolean lpkdqgx = false;
    public volatile boolean gzokllk = false;
    public volatile boolean nsyqsfj = false;
    public volatile boolean qwgjehf = false;
    public volatile int bgmsltp = 0;
    public volatile int wygqgxb = -1;
    public volatile int yjbrzgu = 0;
    public final Object sthdtww = new Object();
    public String hhqpjvl = "";
    public String wjugzfh = "";
    public volatile boolean rpilpcp = false;
    public volatile boolean ivvkvsj = false;
    public boolean civyupy = false;
    public boolean nhhacgu = false;
    public int jxvdcpb = 0;
    public final HashSet ezxxysz = new HashSet();
    public final HashMap nsizane = new HashMap();
    public boolean kxotgjb = false;
    public boolean wfxzfba = false;
    public String rrpfqyy = "";
    public volatile boolean dvzxbaj = false;
    public volatile boolean nxumtuo = false;
    public volatile long gepzcpd = 0;
    public final ArrayList silhone = new ArrayList();
    public int ankiohq = 0;
    public File gzvolsx = new File("/storage/emulated/0");
    public boolean thbdbid = false;
    public boolean sjexbpf = false;
    public String mcdstyz = "/";
    public String gucwjqz = "device";
    public volatile String xvxmcgn = "—";
    public final Object ibfmasn = new Object();
    public final ArrayDeque cugubfc = new ArrayDeque();
    public volatile boolean tmdubwv = false;
    public volatile ednetju cnctlxz = x.ednetju.ojyssqt();
    public final ArrayList pcbbvuj = new ArrayList();
    public final LinkedHashMap fprgbbe = new LinkedHashMap();
    public String ecffprn = "all";
    public int yrgokys = -1;
    public final ArrayList pwnmyid = new ArrayList();
    public final HashSet mwocrhx = new HashSet();
    public String ijakhcl = "download_only";
    public boolean lsgjyur = false;
    public String pzkwhtn = "";
    public String ghkjjru = "";
    public String mslkofp = "";
    public boolean iasgsgq = false;
    public boolean mwngani = false;
    public final ArrayList jbmzxye = new ArrayList();
    public String sdchfks = "green";
    public volatile boolean ywhgqsi = false;
    public boolean fixfqug = false;
    public volatile String ygdccqg = "";
    public volatile String cxxnoho = "";
    public long clczezu = 0;
    public boolean prywqjr = false;
    public String zhpnlmy = "home";
    public String ayzlrnr = "home";
    public final ArrayDeque tqcgjht = new ArrayDeque();

    public ojyssqt() {
        ysaclsr ysaclsrVar = new ysaclsr();
        ysaclsrVar.lthborb = true;
        ysaclsrVar.qxvquar = false;
        this.snilumr = ysaclsrVar;
        this.lataqgm = false;
        this.otaqyat = false;
        this.aylswsn = -1;
        this.czqxnxv = null;
        this.sfildfy = new File("/storage/emulated/0");
        this.neppdxk = new iasgsgq(this);
    }

    public static boolean atntgcp(aqyicql aqyicqlVar) {
        return aqyicqlVar != null && aqyicqlVar.lthborb && aqyicqlVar.vivhedu();
    }

    public static void btazysh(DataOutputStream dataOutputStream, String str, int i, String str2) throws IOException {
        if (str == null) {
            str = "";
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (bytes.length > i) {
            throw new IOException(str2.concat(" is too long"));
        }
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
    }

    public static String ccuulnt(String str) {
        return "'" + str.replace("'", "'\\''") + "'";
    }

    public static File czidoiw(File file, String str) {
        String strTrim = str == null ? "" : str.trim();
        StringBuilder sb = new StringBuilder(Math.min(strTrim.length(), 96));
        for (int i = 0; i < strTrim.length() && sb.length() < 96; i++) {
            char cCharAt = strTrim.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < '0' || cCharAt > '9') && cCharAt != '_' && cCharAt != '-' && cCharAt != '.' && cCharAt != '+'))) {
                cCharAt = '_';
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        if (string.isEmpty() || ".".equals(string) || "..".equals(string)) {
            string = "partition";
        }
        File file2 = new File(file, string.concat(".img"));
        if (!file2.exists()) {
            return file2;
        }
        for (int i2 = 1; i2 < 10000; i2++) {
            File file3 = new File(file, string + "-" + i2 + ".img");
            if (!file3.exists()) {
                return file3;
            }
        }
        return new File(file, string + "-" + System.currentTimeMillis() + ".img");
    }

    public static boolean gisppfs(String str) {
        return str != null && str.toLowerCase(Locale.ROOT).endsWith(".bin");
    }

    public static String jxvdcpb() {
        char[] cArr = new char[62];
        for (int i = 0; i < 62; i++) {
            cArr[i] = (char) ((casbgpb[i] & 255) ^ 90);
        }
        return new String(cArr);
    }

    public static String jybecxv(String str) {
        if (str != null && !str.isEmpty() && (str.length() & 1) == 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                int iMin = Math.min(8192, Math.max(1, str.length() / 2));
                byte[] bArr = new byte[iMin];
                int i = 0;
                for (int i2 = 0; i2 < str.length(); i2 += 2) {
                    int iDigit = Character.digit(str.charAt(i2), 16);
                    int iDigit2 = Character.digit(str.charAt(i2 + 1), 16);
                    if (iDigit >= 0 && iDigit2 >= 0) {
                        int i3 = i + 1;
                        bArr[i] = (byte) ((iDigit << 4) | iDigit2);
                        if (i3 == iMin) {
                            messageDigest.update(bArr, 0, i3);
                            i = 0;
                        } else {
                            i = i3;
                        }
                    }
                    return "";
                }
                if (i != 0) {
                    messageDigest.update(bArr, 0, i);
                }
                StringBuilder sb = new StringBuilder(64);
                for (byte b : messageDigest.digest()) {
                    sb.append(String.format(Locale.ROOT, "%02x", Integer.valueOf(b & 255)));
                }
                return sb.toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String pvkaerr(String str) {
        return str == null ? "" : str.replace('\r', ' ').replace('\n', ' ').replace('\t', ' ').trim();
    }

    public static String pzqxblc(String str) {
        return str == null ? "" : str.trim().toLowerCase(Locale.ROOT);
    }

    public static boolean qunltjs(UsbDevice usbDevice, UsbDevice usbDevice2) {
        boolean zEquals;
        if (usbDevice == null || usbDevice2 == null) {
            return false;
        }
        String deviceName = usbDevice.getDeviceName();
        String deviceName2 = usbDevice2.getDeviceName();
        if (deviceName == null) {
            zEquals = deviceName2 == null;
        } else {
            zEquals = deviceName.equals(deviceName2);
        }
        return usbDevice.getDeviceId() == usbDevice2.getDeviceId() && usbDevice.getVendorId() == usbDevice2.getVendorId() && usbDevice.getProductId() == usbDevice2.getProductId() && zEquals;
    }

    public static String qwgjehf(HttpURLConnection httpURLConnection, int i) throws IOException {
        if (httpURLConnection.getContentLengthLong() > 1048576) {
            throw new IOException("SLA server response exceeds the allowed size");
        }
        InputStream errorStream = (i < 200 || i >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
        if (errorStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, StandardCharsets.UTF_8));
        try {
            char[] cArr = new char[4096];
            while (true) {
                int i2 = bufferedReader.read(cArr);
                if (i2 == -1) {
                    bufferedReader.close();
                    return sb.toString();
                }
                if (sb.length() + i2 > 1048576) {
                    throw new IOException("SLA server response exceeds the allowed size");
                }
                sb.append(cArr, 0, i2);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] qxvquar(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("0x") || strTrim.startsWith("0X")) {
            strTrim = strTrim.substring(2);
        }
        if (strTrim.isEmpty() || (strTrim.length() & 1) != 0) {
            return null;
        }
        byte[] bArr = new byte[strTrim.length() / 2];
        for (int i = 0; i < strTrim.length(); i += 2) {
            int iDigit = Character.digit(strTrim.charAt(i), 16);
            int iDigit2 = Character.digit(strTrim.charAt(i + 1), 16);
            if (iDigit < 0 || iDigit2 < 0) {
                return null;
            }
            bArr[i / 2] = (byte) ((iDigit << 4) | iDigit2);
        }
        return bArr;
    }

    public static String uiqyzsp(String str) {
        if (str == null) {
            return null;
        }
        String strReplaceAll = str.replaceAll("\\s+", "");
        if (strReplaceAll.startsWith("0x") || strReplaceAll.startsWith("0X")) {
            strReplaceAll = strReplaceAll.substring(2);
        }
        byte[] bArrQxvquar = qxvquar(strReplaceAll);
        if (bArrQxvquar == null) {
            try {
                bArrQxvquar = Base64.decode(strReplaceAll, 0);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (bArrQxvquar.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArrQxvquar.length * 2);
        for (byte b : bArrQxvquar) {
            sb.append(String.format(Locale.ROOT, "%02x", Integer.valueOf(b & 255)));
        }
        return sb.toString();
    }

    public static String ulafhci(String str) {
        if (str == null) {
            return "";
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        for (int i = 0; i + 3 < upperCase.length(); i++) {
            if (upperCase.charAt(i) == 'M' && upperCase.charAt(i + 1) == 'T') {
                StringBuilder sb = new StringBuilder();
                for (int i2 = i + 2; i2 < upperCase.length(); i2++) {
                    char cCharAt = upperCase.charAt(i2);
                    if (!Character.isDigit(cCharAt)) {
                        break;
                    }
                    sb.append(cCharAt);
                }
                if (sb.length() >= 4) {
                    return "MT" + ((Object) sb);
                }
            }
        }
        return "";
    }

    public static int wqrnifx(lcgzsis lcgzsisVar) {
        Iterator it = lcgzsisVar.nkemejx.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((aqyicql) it.next()).lthborb) {
                i++;
            }
        }
        return i;
    }

    public static boolean zwaqeaz(String str) {
        return str == null || str.trim().isEmpty();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public abstract void bgmsltp();

    public abstract void buswjhz();

    public abstract void bwvplah(boolean z);

    public abstract void cgcdpmq();

    public abstract boolean civyupy();

    public abstract int dasxvpc(int i);

    public abstract boolean dplrlfq();

    public final boolean dytyqos(UsbDevice usbDevice) {
        boolean zEquals;
        if (this.ekyqleu == null || usbDevice == null) {
            return false;
        }
        String deviceName = usbDevice.getDeviceName();
        if (this.buswjhz == null) {
            zEquals = deviceName == null;
        } else {
            zEquals = this.buswjhz.equals(deviceName);
        }
        return this.utmeivs == usbDevice.getDeviceId() && this.pvbzgon == usbDevice.getVendorId() && this.qyeibyo == usbDevice.getProductId() && zEquals;
    }

    public abstract void eigllth(String str);

    public abstract void ekyqleu();

    public abstract void exhiehf(View view, boolean z);

    public abstract oxoagud ezxxysz();

    public abstract void gefzxcg();

    public abstract void gzokllk();

    public abstract void hhqpjvl(UsbDevice usbDevice);

    public abstract void imuemzb();

    public abstract void ivvkvsj();

    public abstract boolean jdqigmr();

    public abstract void kxotgjb(View view, int i);

    public abstract File lclupha();

    public abstract void lpkdqgx(UsbDevice usbDevice);

    public abstract LinearLayout lthborb();

    public abstract void lvtqoqa();

    public abstract void nativeCancelIo();

    public abstract String nativeConnectSession(int i, long j, String str, String str2, String str3);

    public abstract void nativeDisconnectSession();

    public abstract boolean nativeHasSession();

    public abstract String nativeRunCommand(int i, long j, String str, String str2, String str3, String str4, String str5, String str6);

    public abstract String nativeRunGuiAction(int i, long j, String str, String str2, String str3, String str4, String str5, String str6);

    public abstract long nativeSetUsbFd(int i);

    public abstract void nativeSetXiaomiAuthGeneration(int i);

    public abstract void nhhacgu(String str);

    public abstract void nkemejx();

    public abstract void nmpwovh(String str);

    public abstract void nsizane();

    public abstract void nsyqsfj(String str);

    public abstract ScrollView ojyssqt();

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void oqexvyb() {
        this.jdqigmr = -1;
        this.lclupha = "";
        this.gisppfs = -1;
        this.zwaqeaz = -1;
    }

    public abstract boolean pvbzgon();

    public abstract boolean qyeibyo();

    public abstract void rpilpcp();

    public final boolean slxntng(UsbDevice usbDevice) {
        if (usbDevice == null || this.jdqigmr < 0) {
            return false;
        }
        return this.jdqigmr == usbDevice.getDeviceId() && this.gisppfs == usbDevice.getVendorId() && this.zwaqeaz == usbDevice.getProductId() && this.lclupha.equals(usbDevice.getDeviceName() == null ? "" : usbDevice.getDeviceName());
    }

    public abstract void sthdtww();

    public abstract UsbDevice utmeivs(Intent intent);

    public abstract ScrollView vivhedu();

    public abstract boolean vntpaom();

    public abstract void vopsyhw(String str);

    public abstract void wfxzfba(boolean z);

    public abstract boolean wjugzfh();

    public abstract void wygqgxb(File file);

    public abstract String yjbrzgu(String str);

    public abstract void yonoayx();
}
