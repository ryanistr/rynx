package com.rynx.app;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.database.Cursor;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.provider.DocumentsContract;
import android.util.Base64;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import com.rynx.app.adbfastboot.AdbFastbootNative;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x.ccuulnt;
import x.chwohho;
import x.cugubfc;
import x.czgynww;
import x.czidoiw;
import x.dasxvpc;
import x.dplrlfq;
import x.ecffprn;
import x.ednetju;
import x.eigllth;
import x.ekyqleu;
import x.enxkjpu;
import x.gisppfs;
import x.hhqpjvl;
import x.hiofinr;
import x.hknanqb;
import x.iilntfn;
import x.jybecxv;
import x.kggugdp;
import x.lclupha;
import x.ljhdwjr;
import x.lpkdqgx;
import x.mslkofp;
import x.mwngani;
import x.mwocrhx;
import x.nnkxxji;
import x.nsyqsfj;
import x.ohwxijw;
import x.oxoagud;
import x.pvbzgon;
import x.pwnmyid;
import x.pzkwhtn;
import x.qxvquar;
import x.qyeibyo;
import x.rrpfqyy;
import x.rvrflql;
import x.suqlntg;
import x.tmdubwv;
import x.utmeivs;
import x.vntpaom;
import x.vopsyhw;
import x.wdznaie;
import x.xhyvkax;
import x.yhrqvll;
import x.yrgokys;
import x.ysaclsr;
import x.zamkzqg;
import x.zfmpmio;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends kggugdp {
    public static final int[] rzsxsyc = {0, 100};
    public String eldycgp;
    public final Object haevqmd;
    public final HashSet icjnmlh;
    public final Object lbyddwl;
    public volatile boolean qppdydr;
    public boolean sxcwslq;

    public MainActivity() {
        this.osgyung = 0;
        this.haevqmd = new Object();
        this.lbyddwl = new Object();
        this.icjnmlh = new HashSet();
        this.eldycgp = "";
    }

    public static chwohho clczezu(String str) {
        chwohho chwohhoVar = new chwohho();
        chwohhoVar.nmpwovh = x.zamkzqg.oohojlj(str, "OFFSET:");
        chwohhoVar.ojyssqt = x.zamkzqg.oohojlj(str, "SLOT_COUNT:");
        chwohhoVar.vivhedu = x.zamkzqg.oohojlj(str, "ACTIVE_SLOT:");
        chwohhoVar.lthborb = x.zamkzqg.oohojlj(str, "SUFFIX:");
        chwohhoVar.qxvquar = x.zamkzqg.oohojlj(str, "CRC:");
        chwohhoVar.oqexvyb = x.zamkzqg.oohojlj(str, "SLOT_A_PRIORITY:");
        chwohhoVar.nkemejx = x.zamkzqg.oohojlj(str, "SLOT_A_TRIES:");
        chwohhoVar.imuemzb = x.zamkzqg.oohojlj(str, "SLOT_A_SUCCESSFUL:");
        chwohhoVar.dytyqos = x.zamkzqg.oohojlj(str, "SLOT_A_BOOTABLE:");
        chwohhoVar.wqrnifx = x.zamkzqg.oohojlj(str, "SLOT_A_VERITY:");
        chwohhoVar.dasxvpc = x.zamkzqg.oohojlj(str, "SLOT_B_PRIORITY:");
        chwohhoVar.dplrlfq = x.zamkzqg.oohojlj(str, "SLOT_B_TRIES:");
        chwohhoVar.ulafhci = x.zamkzqg.oohojlj(str, "SLOT_B_SUCCESSFUL:");
        chwohhoVar.ekyqleu = x.zamkzqg.oohojlj(str, "SLOT_B_BOOTABLE:");
        chwohhoVar.utmeivs = x.zamkzqg.oohojlj(str, "SLOT_B_VERITY:");
        return chwohhoVar;
    }

    public static HttpURLConnection cxxnoho(JSONObject jSONObject) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(com.rynx.app.ojyssqt.jxvdcpb()).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(180000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
        httpURLConnection.setFixedLengthStreamingMode(bytes.length);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
            return httpURLConnection;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static UsbDevice hiofinr(UsbDevice usbDevice, UsbDevice usbDevice2) {
        if (usbDevice == null) {
            return usbDevice2;
        }
        if (usbDevice2 == null) {
            return usbDevice;
        }
        int iCompareTo = (usbDevice.getDeviceName() == null ? "" : usbDevice.getDeviceName()).compareTo(usbDevice2.getDeviceName() != null ? usbDevice2.getDeviceName() : "");
        if (iCompareTo < 0) {
            return usbDevice;
        }
        return (iCompareTo <= 0 && usbDevice.getDeviceId() <= usbDevice2.getDeviceId()) ? usbDevice : usbDevice2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    public static String qdiugcp(String str) {
        byte b;
        switch (str) {
            case "1.0":
                b = 0;
                break;
            case "2.0":
                b = 4;
                break;
            case "3.0":
                b = 1;
                break;
            case "4.0":
                b = 5;
                break;
            case "5.0":
                b = 2;
                break;
            case "6.0":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return "rnd16";
        }
        if (b == 1) {
            return "nonce8 || lowerhex(sha256(nonce8 || rnd16))";
        }
        if (b != 2) {
            return b != 3 ? "server_resolved_exact_profile" : "nonce8 || lowerhex(sha256(nonce8 || le32hex(rnd16[0:8]) || lowerhex(sha256(hrid16)[0:8])))";
        }
        return "nonce8 || lowerhex(sha256(nonce8 || lowerhex(sha256(hrid16)[0:16])))";
    }

    public static boolean sdchfks(int i, String str) {
        byte[] bArrQxvquar = com.rynx.app.ojyssqt.qxvquar(str);
        return bArrQxvquar != null && bArrQxvquar.length == i;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0063 A[EDGE_INSN: B:43:0x0063->B:32:0x0063 BREAK  A[LOOP:0: B:3:0x0009->B:31:0x0060], SYNTHETIC] */
    public static dplrlfq tqcgjht(String str, xhyvkax xhyvkaxVar) throws InterruptedException, czgynww, IOException {
        int[] iArrYomtcav;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        IOException iOException = null;
        czgynww czgynwwVar = null;
        for (int i = 0; i < 2; i++) {
            int i2 = rzsxsyc[i];
            long jElapsedRealtime2 = 4000 - (SystemClock.elapsedRealtime() - jElapsedRealtime);
            if (i2 <= 0) {
                iArrYomtcav = yomtcav(4000, jElapsedRealtime2);
                if (iArrYomtcav != null) {
                    return x.zamkzqg.rvrflql(com.rynx.app.ojyssqt.jxvdcpb(), xhyvkaxVar, str, iArrYomtcav[0], iArrYomtcav[1]);
                }
                break;
            }
            long j = i2;
            if (jElapsedRealtime2 <= 1500 + j) {
                break;
            }
            Thread.sleep(j);
            jElapsedRealtime2 = 4000 - (SystemClock.elapsedRealtime() - jElapsedRealtime);
            iArrYomtcav = yomtcav(4000, jElapsedRealtime2);
            if (iArrYomtcav != null) {
                break;
            }
            try {
                try {
                    return x.zamkzqg.rvrflql(com.rynx.app.ojyssqt.jxvdcpb(), xhyvkaxVar, str, iArrYomtcav[0], iArrYomtcav[1]);
                } catch (IOException e) {
                    iOException = e;
                } catch (czgynww e2) {
                    if (!xbdyiew(e2)) {
                        throw e2;
                    }
                    czgynwwVar = e2;
                }
            } catch (czgynww e4) {
                czgynwwVar = e4;
            }
        }
        if (czgynwwVar != null) {
            throw czgynwwVar;
        }
        if (iOException == null) {
            throw new IOException("job result unavailable within live deadline");
        }
        throw iOException;
    }

    public static int tqfwohl(String str) {
        if (str == null) {
            return 0;
        }
        String strTrim = str.trim();
        try {
            if (!strTrim.startsWith("0x") && !strTrim.startsWith("0X")) {
                return Integer.parseInt(strTrim);
            }
            return Integer.parseInt(strTrim.substring(2), 16);
        } catch (RuntimeException unused) {
            return 0;
        }
    }

    public static boolean xbdyiew(czgynww czgynwwVar) {
        int i = czgynwwVar.ojyssqt;
        return i == 408 || i == 425 || i == 429 || i >= 500;
    }

    public static int[] yomtcav(int i, long j) {
        if (j < 1500) {
            return null;
        }
        int iMin = (int) Math.min(2000, Math.max(500L, j / 3));
        long j2 = j - ((long) iMin);
        if (j2 < 1000) {
            return null;
        }
        return new int[]{iMin, (int) Math.min(i, j2)};
    }

    public static String ywhgqsi(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(String.format(Locale.ROOT, "%02x", Integer.valueOf(b & 255)));
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0063 A[EDGE_INSN: B:43:0x0063->B:32:0x0063 BREAK  A[LOOP:0: B:3:0x0009->B:31:0x0060], SYNTHETIC] */
    public static nnkxxji yztlqms(String str, xhyvkax xhyvkaxVar) throws InterruptedException, czgynww, IOException {
        int[] iArrYomtcav;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        IOException iOException = null;
        czgynww czgynwwVar = null;
        for (int i = 0; i < 2; i++) {
            int i2 = rzsxsyc[i];
            long jElapsedRealtime2 = 4000 - (SystemClock.elapsedRealtime() - jElapsedRealtime);
            if (i2 <= 0) {
                iArrYomtcav = yomtcav(4000, jElapsedRealtime2);
                if (iArrYomtcav != null) {
                    return x.zamkzqg.guecdgy(com.rynx.app.ojyssqt.jxvdcpb(), xhyvkaxVar, str, iArrYomtcav[0], iArrYomtcav[1]);
                }
                break;
            }
            long j = i2;
            if (jElapsedRealtime2 <= 1500 + j) {
                break;
            }
            Thread.sleep(j);
            jElapsedRealtime2 = 4000 - (SystemClock.elapsedRealtime() - jElapsedRealtime);
            iArrYomtcav = yomtcav(4000, jElapsedRealtime2);
            if (iArrYomtcav != null) {
                break;
            }
            try {
                try {
                    return x.zamkzqg.guecdgy(com.rynx.app.ojyssqt.jxvdcpb(), xhyvkaxVar, str, iArrYomtcav[0], iArrYomtcav[1]);
                } catch (IOException e) {
                    iOException = e;
                } catch (czgynww e2) {
                    if (!xbdyiew(e2)) {
                        throw e2;
                    }
                    czgynwwVar = e2;
                }
            } catch (czgynww e4) {
                czgynwwVar = e4;
            }
        }
        if (czgynwwVar != null) {
            throw czgynwwVar;
        }
        if (iOException == null) {
            throw new IOException("job status unavailable within live deadline");
        }
        throw iOException;
    }

    public static void ziuhthw(TextView textView, boolean z) {
        if (textView == null) {
            return;
        }
        textView.animate().cancel();
        textView.setScaleX(1.0f);
        textView.setScaleY(1.0f);
        textView.setTranslationX(0.0f);
        textView.setTranslationY(0.0f);
        textView.setEnabled(z);
        textView.setAlpha(z ? 1.0f : 0.42f);
    }

    public static String zngzleo(UsbDevice usbDevice) {
        try {
            String serialNumber = usbDevice.getSerialNumber();
            return (serialNumber == null || serialNumber.trim().isEmpty()) ? "unknown" : serialNumber.trim().replace('\n', '_');
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public final String aqyicql(String str) {
        return (str == null || str.isEmpty()) ? str : pwjmwpv(str).getAbsolutePath();
    }

    public final void axbavsj(final tmdubwv tmdubwvVar, final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str7 = "";
        sb.append(str5 == null ? "" : " ".concat(str5));
        if (str6 != null) {
            str7 = " " + oxoagud(str6);
        }
        sb.append(str7);
        nmpwovh(getString(R.string.terminal_run, sb.toString()));
        this.lpkdqgx = true;
        gefzxcg();
        this.slxntng.execute(new Runnable() { // from class: x.zhpnlmy
            public final /* synthetic */ MainActivity nmpwovh = MainActivity.this;
            @Override // java.lang.Runnable
            public final void run() {
                suqlntg suqlntgVarZamkzqg;
                MainActivity mainActivity = this.nmpwovh;
                tmdubwv tmdubwvVar2 = tmdubwvVar;
                String str8 = str;
                String str9 = str5;
                String str10 = str6;
                String str11 = str2;
                String str12 = str3;
                String str13 = str4;
                mainActivity.getClass();
                try {
                    ArrayList arrayList = (ArrayList) tmdubwvVar2.nmpwovh;
                    HashSet hashSet = x.cugubfc.nmpwovh;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((String) it.next()).equalsIgnoreCase("--usb-log")) {
                            mainActivity.runOnUiThread(new yrgokys(mainActivity, 13));
                            break;
                        }
                    }
                    suqlntgVarZamkzqg = mainActivity.zamkzqg(str8, str9, str10, str11, str12, str13);
                    mainActivity.lpkdqgx = false;
                } catch (Throwable th) {
                    try {
                        suqlntg suqlntgVar = new suqlntg(1, mainActivity.getString(R.string.error_executor, String.valueOf(th)));
                        mainActivity.lpkdqgx = false;
                        suqlntgVarZamkzqg = suqlntgVar;
                    } catch (Throwable th2) {
                        mainActivity.lpkdqgx = false;
                        throw th2;
                    }
                }
                mainActivity.runOnUiThread(new ekyqleu(mainActivity, suqlntgVarZamkzqg, str8, 7));
            }
        });
    }

    public final void aylswsn(String str) {
        ParcelFileDescriptor parcelFileDescriptorOhwxijw;
        UsbDevice usbDevice = this.ulafhci;
        if (x.zamkzqg.nsyqsfj(usbDevice) != 3) {
            Toast.makeText(this, R.string.android_tools_fastboot_only, 0).show();
            fusjbbl("ERROR: no device in Fastboot mode");
            return;
        }
        if (this.nxumtuo || this.dvzxbaj || this.lpkdqgx || this.gzokllk || this.nsyqsfj) {
            Toast.makeText(this, R.string.android_tools_busy, 0).show();
            fusjbbl("ERROR: USB transport is busy");
            return;
        }
        if (!this.dplrlfq.hasPermission(usbDevice) || !qyeibyo()) {
            hhqpjvl(usbDevice);
            Toast.makeText(this, R.string.android_tools_permission, 0).show();
            fusjbbl("USB permission/open required. Approve the Android USB prompt and retry.");
            return;
        }
        int iNnkxxji = nnkxxji();
        if (iNnkxxji < 0) {
            wfxzfba(false);
            return;
        }
        if (teupdsw() && (parcelFileDescriptorOhwxijw = ohwxijw(iNnkxxji)) != null) {
            this.dvzxbaj = true;
            long j = this.gepzcpd + 1;
            this.gepzcpd = j;
            gdkopre();
            jybecxv jybecxvVar = this.ltnesel;
            if (jybecxvVar != null) {
                jybecxvVar.vivhedu.setText(R.string.android_tools_fastboot_action_started);
                this.ltnesel.vivhedu.setTextColor(this.oqexvyb);
            }
            nmpwovh("[FASTBOOT] " + str);
            this.zftrkmx = this.slxntng.submit(new vopsyhw(this, parcelFileDescriptorOhwxijw, str, j, 2));
        }
    }

    public final String ayzlrnr(String str) {
        return (str == null || str.isEmpty()) ? str : zhpnlmy(str).getAbsolutePath();
    }

    @Override // com.rynx.app.ojyssqt
    public final void bgmsltp() {
        ScrollView scrollView;
        if (this.exhiehf == null) {
            return;
        }
        boolean zPvbzgon = pvbzgon();
        vntpaom();
        nlcdwap(zPvbzgon);
        if (!zPvbzgon) {
            this.kxotgjb = true;
            this.tqcgjht.clear();
            eigllth("setup");
            this.zhpnlmy = "setup";
            jtfjrri(true);
            if (this.exhiehf == null || (scrollView = this.yonoayx) == null) {
                return;
            }
            if (scrollView.getParent() != null) {
                ((ViewGroup) scrollView.getParent()).removeView(scrollView);
            }
            this.exhiehf.removeAllViews();
            this.exhiehf.addView(this.yonoayx, new FrameLayout.LayoutParams(-1, -1));
            return;
        }
        if (this.kxotgjb) {
            this.kxotgjb = false;
            this.tqcgjht.clear();
            eigllth("home");
            jtfjrri(true);
            this.zhpnlmy = "home";
            FrameLayout frameLayout = this.lvtqoqa;
            if (frameLayout != null && frameLayout.getParent() != null) {
                ((ViewGroup) frameLayout.getParent()).removeView(frameLayout);
            }
            this.exhiehf.removeAllViews();
            this.exhiehf.addView(this.lvtqoqa, new FrameLayout.LayoutParams(-1, -1));
            tmdubwv tmdubwvVar = this.gefzxcg;
            if (tmdubwvVar != null) {
                ((ljhdwjr) tmdubwvVar.nmpwovh).ojyssqt(false);
            }
            rvrflql rvrflqlVar = this.jybecxv;
            if (rvrflqlVar != null) {
                rvrflqlVar.vivhedu(this.zhpnlmy);
            }
        }
        if (!this.wfxzfba) {
            this.wfxzfba = true;
            dkpobjg();
        } else if (civyupy()) {
            UsbDevice usbDevice = this.ulafhci;
            if (qyeibyo() && iivesaq()) {
                ygdccqg();
            } else if (usbDevice != null && !qyeibyo()) {
                hhqpjvl(usbDevice);
            } else if (usbDevice == null) {
                cgcdpmq();
            }
        }
        gefzxcg();
    }

    public final void bsimxgu(String str) {
        if ("reboot".equals(str) || "continue".equals(str) || str.startsWith("set_active:") || "flashing lock".equals(str)) {
            tmdubwv tmdubwvVarUzyihoe = uzyihoe();
            String strZngzleo = zngzleo(this.ulafhci);
            StringBuilder sb = new StringBuilder();
            for (String str2 : (HashSet<String>) tmdubwvVarUzyihoe.nmpwovh) {
                int iIndexOf = str2.indexOf(10);
                if (iIndexOf >= 0) {
                    String strSubstring = str2.substring(0, iIndexOf);
                    if (strSubstring.equals(strZngzleo) || strSubstring.equals("unknown")) {
                        String strSubstring2 = str2.substring(iIndexOf + 1);
                        if (strSubstring2.startsWith("?")) {
                            strSubstring2 = "unconfirmed flash: " + strSubstring2.substring(strSubstring2.indexOf(58) + 1).trim();
                        }
                        if (sb.length() > 0) {
                            sb.append(", ");
                        }
                        sb.append(strSubstring2);
                    }
                }
            }
            String string = sb.toString();
            if (!string.isEmpty()) {
                pzkwhtn("Incomplete Fastboot flash", "These partitions have an incomplete or unconfirmed flash: " + string + "\n\nBooting or changing the active slot can fail until the intended images are fully flashed. Run '" + str + "' anyway?", new utmeivs(this, str, 9));
                return;
            }
        }
        aylswsn(str);
    }

    public final void casbgpb(String str, String str2, String str3) {
        String str4;
        if (wjugzfh()) {
            if (this.lpkdqgx || this.gzokllk) {
                Toast.makeText(this, R.string.error_busy, 0).show();
                return;
            }
            if (!qyeibyo()) {
                Toast.makeText(this, R.string.error_usb_unavailable, 0).show();
                return;
            }
            String strYjbrzgu = yjbrzgu("da_path");
            String strYjbrzgu2 = yjbrzgu("auth_path");
            String strYjbrzgu3 = yjbrzgu("preloader_path");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str5 = "";
            if (com.rynx.app.ojyssqt.zwaqeaz(str2)) {
                str4 = "";
            } else {
                str4 = " " + str2;
            }
            sb.append(str4);
            if (!com.rynx.app.ojyssqt.zwaqeaz(str3)) {
                str5 = " " + oxoagud(str3);
            }
            sb.append(str5);
            nmpwovh(getString(R.string.log_gui_run, sb.toString()));
            this.lpkdqgx = true;
            gefzxcg();
            nhhacgu("menu");
            this.slxntng.execute(new lpkdqgx(this, str, str2, str3, strYjbrzgu, strYjbrzgu2, strYjbrzgu3));
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:87:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ec  */
    @Override // com.rynx.app.ojyssqt
    public final void cgcdpmq() {
        HashMap<String, UsbDevice> deviceList = this.dplrlfq.getDeviceList();
        UsbDevice usbDevice = this.ulafhci;
        Iterator<Map.Entry<String, UsbDevice>> it = deviceList.entrySet().iterator();
        UsbDevice usbDeviceHiofinr = null;
        UsbDevice usbDevice2 = null;
        UsbDevice usbDevice3 = null;
        UsbDevice usbDeviceHiofinr2 = null;
        int i = 0;
        while (it.hasNext()) {
            UsbDevice value = it.next().getValue();
            int iNsyqsfj = x.zamkzqg.nsyqsfj(value);
            if (iNsyqsfj == 1) {
                i++;
                usbDeviceHiofinr = hiofinr(usbDeviceHiofinr, value);
            } else if (iNsyqsfj == 2 || iNsyqsfj == 3) {
                usbDeviceHiofinr2 = hiofinr(usbDeviceHiofinr2, value);
            }
            if (com.rynx.app.ojyssqt.qunltjs(usbDevice, value)) {
                usbDevice3 = value;
            }
            synchronized (this.atntgcp) {
                if (dytyqos(value)) {
                    usbDevice2 = value;
                }
            }
        }
        boolean zEquals = "android_tools".equals(this.ayzlrnr);
        if (!this.nsyqsfj && !this.gzokllk && !this.lpkdqgx) {
            if (usbDevice3 == null) {
                if (!zEquals && this.qwgjehf && i > 1) {
                    nmpwovh("[USB] Multiple MTK devices detected; keeping the GUI session disarmed until only one target is available.");
                    gefzxcg();
                    return;
                } else if ((zEquals && usbDeviceHiofinr2 != null) || usbDeviceHiofinr == null) {
                    usbDeviceHiofinr = usbDeviceHiofinr2;
                }
            }
            if (usbDevice3 == null) {
                this.ulafhci = usbDevice3;
                gefzxcg();
                if (civyupy()) {
                    hhqpjvl(usbDevice3);
                }
                if (zEquals) {
                    wfxzfba(false);
                }
            }
            nkemejx();
            this.ulafhci = null;
            if (!this.lpkdqgx && !this.gzokllk && this.nsyqsfj) {
                nativeDisconnectSession();
                this.nsyqsfj = false;
            }
            gefzxcg();
            return;
        }
        if (usbDevice2 != null && x.zamkzqg.pmsrvoc(usbDevice2)) {
            usbDeviceHiofinr = usbDevice2;
        } else if (usbDevice3 != null && x.zamkzqg.pmsrvoc(usbDevice3)) {
            usbDeviceHiofinr = usbDevice3;
        } else if (i != 1) {
            if (i > 1) {
                nmpwovh("[USB] Multiple MTK devices are present during DA ownership; automatic rebind is disabled to avoid selecting the wrong target.");
                gefzxcg();
                if (zEquals) {
                    wfxzfba(false);
                    return;
                }
                return;
            }
            usbDeviceHiofinr = null;
        }
        if (usbDeviceHiofinr == null) {
            synchronized (this.atntgcp) {
                try {
                    if (this.ekyqleu != null && this.vntpaom != 0) {
                        gefzxcg();
                        if (zEquals) {
                            wfxzfba(false);
                        }
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        usbDevice3 = usbDeviceHiofinr;
        if (usbDevice3 == null) {
            nkemejx();
            this.ulafhci = null;
            if (!this.lpkdqgx) {
                nativeDisconnectSession();
                this.nsyqsfj = false;
            }
            gefzxcg();
            return;
        }
        this.ulafhci = usbDevice3;
        gefzxcg();
        if (civyupy()) {
            hhqpjvl(usbDevice3);
        }
        if (zEquals) {
            wfxzfba(false);
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final boolean civyupy() {
        if ((this.ulafhci != null && !x.zamkzqg.pmsrvoc(this.ulafhci)) || this.ivvkvsj) {
            return false;
        }
        if (this.lataqgm) {
            return this.bsimxgu != null || this.lpkdqgx;
        }
        return this.bsimxgu != null || this.lpkdqgx || (this.gzokllk && this.qwgjehf) || this.nsyqsfj || this.qwgjehf;
    }

    public final UsbDeviceConnection czgynww(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return null;
        }
        synchronized (this.atntgcp) {
            try {
                if (this.ekyqleu != null && this.ulafhci != null && this.utmeivs == usbDevice.getDeviceId() && this.ulafhci.getDeviceId() == usbDevice.getDeviceId()) {
                    return this.ekyqleu;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void czqxnxv(final String str, final String str2, String str3) {
        final ParcelFileDescriptor parcelFileDescriptorOhwxijw;
        String str4;
        UsbDevice usbDevice = this.ulafhci;
        if (x.zamkzqg.nsyqsfj(usbDevice) != 3) {
            fusjbbl("ERROR: no device in Fastboot mode");
            return;
        }
        if (this.nxumtuo || this.dvzxbaj || this.lpkdqgx || this.gzokllk || this.nsyqsfj) {
            fusjbbl("ERROR: USB transport is busy");
            return;
        }
        if (str3 == null) {
            str3 = "";
        }
        final File file = new File(str3);
        if (!file.isFile()) {
            fusjbbl("ERROR: image file not found: " + file.getAbsolutePath());
            if (pvbzgon()) {
                return;
            }
            fusjbbl(getString(R.string.storage_grant_hint));
            return;
        }
        if (!this.dplrlfq.hasPermission(usbDevice) || !qyeibyo()) {
            hhqpjvl(usbDevice);
            fusjbbl("USB permission/open required. Approve the Android USB prompt and retry.");
            return;
        }
        int iNnkxxji = nnkxxji();
        if (iNnkxxji < 0) {
            fusjbbl("ERROR: Fastboot USB FD unavailable");
            return;
        }
        if (teupdsw() && (parcelFileDescriptorOhwxijw = ohwxijw(iNnkxxji)) != null) {
            tmdubwv tmdubwvVarUzyihoe = uzyihoe();
            if ("flash".equals(str)) {
                str4 = zngzleo(usbDevice) + "\n?" + UUID.randomUUID() + ": " + str2;
                ((HashSet) tmdubwvVarUzyihoe.nmpwovh).add(str4);
            } else {
                str4 = null;
            }
            final String str5 = str4;
            if (str5 != null && !getSharedPreferences("fastboot_flash_journal", 0).edit().putStringSet("incomplete", new HashSet((HashSet) tmdubwvVarUzyihoe.nmpwovh)).commit()) {
                try {
                    parcelFileDescriptorOhwxijw.close();
                } catch (IOException unused) {
                }
                fusjbbl("ERROR: could not record flash recovery state; flash was not started");
                return;
            }
            this.dvzxbaj = true;
            final long j = this.gepzcpd + 1;
            this.gepzcpd = j;
            gdkopre();
            Locale locale = Locale.US;
            String str6 = com.rynx.app.ojyssqt.zwaqeaz(str2) ? "" : str2;
            fusjbbl("[fastboot] " + str + " " + str6 + " <- " + file.getAbsolutePath() + " (" + x.zamkzqg.jybecxv(file.length()) + ")");
            StringBuilder sb = new StringBuilder("[FASTBOOT] ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            sb.append(" ");
            sb.append(file.getAbsolutePath());
            nmpwovh(sb.toString());
            this.zftrkmx = this.slxntng.submit(new Runnable() { // from class: x.bgmsltp
                public final /* synthetic */ MainActivity nmpwovh = MainActivity.this;
                @Override // java.lang.Runnable
                public final void run() {
                    String strLthborb;
                    ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorOhwxijw;
                    String str7 = str;
                    File file2 = file;
                    long j2 = j;
                    MainActivity mainActivity = this.nmpwovh;
                    mainActivity.getClass();
                    try {
                        try {
                            int fd = parcelFileDescriptor.getFd();
                            String str8 = str2;
                            if (str8 == null) {
                                str8 = "";
                            }
                            strLthborb = AdbFastbootNative.lthborb(fd, str7, str8, file2.getAbsolutePath(), new x.pvkaerr(mainActivity, j2, 1));
                            parcelFileDescriptor.close();
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        strLthborb = "ERROR\n" + th3;
                    }
                    mainActivity.runOnUiThread(new x.yjbrzgu(mainActivity, str5, strLthborb == null ? "ERROR\nNative Fastboot file command returned null" : strLthborb, j2));
                }
            });
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final int dasxvpc(int i) {
        return Math.round(i * getResources().getDisplayMetrics().density);
    }

    public final void dkpobjg() {
        UsbDevice usbDeviceUtmeivs = utmeivs(getIntent());
        if (usbDeviceUtmeivs == null || x.zamkzqg.nsyqsfj(usbDeviceUtmeivs) == 4) {
            cgcdpmq();
            return;
        }
        this.ulafhci = usbDeviceUtmeivs;
        gefzxcg();
        if (civyupy()) {
            hhqpjvl(usbDeviceUtmeivs);
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final boolean dplrlfq() {
        if (pvbzgon()) {
            return true;
        }
        Toast.makeText(this, R.string.error_grant_storage_first, 0).show();
        sthdtww();
        return false;
    }

    public final String dreanqi() {
        xhyvkax xhyvkaxVar = this.iqvvlnh;
        if (!rrpfqyy() || xhyvkaxVar == null || xhyvkaxVar.nmpwovh.isEmpty()) {
            return null;
        }
        return "broker\nsession";
    }

    public final String duxkmyb(Uri uri) {
        int columnIndex;
        Cursor cursorQuery = null;
        try {
            cursorQuery = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_display_name")) < 0) {
                if (cursorQuery != null) {
                }
                return uri.getLastPathSegment();
            }
            String string = cursorQuery.getString(columnIndex);
            cursorQuery.close();
            return string;
        } catch (Throwable unused) {
            if (cursorQuery != null) {
            }
        }
        cursorQuery.close();
        return uri.getLastPathSegment();
    }

    public final void ecffprn(File file, String str) throws IOException {
        if (file == null || !file.isFile() || !file.canRead() || file.length() <= 0) {
            throw new IOException(getString(R.string.error_read_selected_auth));
        }
        rpilpcp();
        String absolutePath = file.getAbsolutePath();
        SharedPreferences.Editor editorEdit = getSharedPreferences("rynx_persistent_session", 0).edit();
        if (absolutePath == null) {
            absolutePath = "";
        }
        editorEdit.putString("auth_path", absolutePath).apply();
        iasgsgq(file, "selected-auth");
        nmpwovh(getString(R.string.gui_auth_selected, file.getAbsolutePath()));
        Toast.makeText(this, getString(R.string.gui_auth_selected_toast, com.rynx.app.ojyssqt.pvkaerr(str)), 0).show();
        gefzxcg();
    }

    @Override // com.rynx.app.ojyssqt
    public final void ekyqleu() {
        EditText editText = this.eigllth;
        if (editText == null) {
            return;
        }
        editText.setEnabled(true);
        this.eigllth.setFocusableInTouchMode(true);
        this.eigllth.requestFocus();
        EditText editText2 = this.eigllth;
        editText2.setSelection(editText2.getText().length());
    }

    @Override // com.rynx.app.ojyssqt
    public final void exhiehf(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.animate().cancel();
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setEnabled(z);
        view.setAlpha(z ? 1.0f : 0.42f);
    }

    public final String ezuzoct(String str) {
        String strPvkaerr = com.rynx.app.ojyssqt.pvkaerr(yjbrzgu("da_display_name"));
        if (com.rynx.app.ojyssqt.zwaqeaz(strPvkaerr)) {
            return com.rynx.app.ojyssqt.zwaqeaz(str) ? "" : new File(str).getName();
        }
        return strPvkaerr;
    }

    @Override // com.rynx.app.ojyssqt
    public final oxoagud ezxxysz() {
        synchronized (this.atntgcp) {
            try {
                if (this.ekyqleu == null || this.vntpaom == 0) {
                    return new oxoagud(-1, 0L);
                }
                try {
                    return new oxoagud(this.ekyqleu.getFileDescriptor(), this.vntpaom);
                } catch (Throwable unused) {
                    return new oxoagud(-1, 0L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void fadblxi() {
        xhyvkax xhyvkaxVar = this.iqvvlnh;
        if (xhyvkaxVar == null || !xhyvkaxVar.vivhedu() || xhyvkaxVar.nmpwovh.isEmpty()) {
            return;
        }
        String str = xhyvkaxVar.nmpwovh;
        mslkofp mslkofpVar = null;
        if (str != null && !str.isEmpty()) {
            synchronized (this.lbyddwl) {
                try {
                    JSONArray jSONArrayQwpvrdy = qwpvrdy();
                    int i = 0;
                    while (true) {
                        if (i >= jSONArrayQwpvrdy.length()) {
                            break;
                        }
                        JSONObject jSONObjectOptJSONObject = jSONArrayQwpvrdy.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("owner_user_id", ""))) {
                            String strOptString = jSONObjectOptJSONObject.optString("job_id", "");
                            String strOptString2 = jSONObjectOptJSONObject.optString("response_sha256", "");
                            if (!strOptString.isEmpty() && !strOptString2.isEmpty()) {
                                mslkofpVar = new mslkofp(str, strOptString, strOptString2, jSONObjectOptJSONObject.optBoolean("accepted", false), jSONObjectOptJSONObject.optInt("status_code", 0));
                                break;
                            }
                        }
                        i++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (mslkofpVar == null || !xhyvkaxVar.nmpwovh.equals(mslkofpVar.nmpwovh)) {
            return;
        }
        synchronized (this.lbyddwl) {
            try {
                if (this.sxcwslq) {
                    return;
                }
                this.sxcwslq = true;
                this.ziuhthw.submit(new ekyqleu(this, xhyvkaxVar, mslkofpVar, 3));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void ffhrwhh(int i, boolean z) {
        xhyvkax xhyvkaxVar = this.iqvvlnh;
        String str = this.dreanqi;
        String str2 = this.ebrwptg;
        if (xhyvkaxVar == null || xhyvkaxVar.nmpwovh.isEmpty() || str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return;
        }
        String str3 = xhyvkaxVar.nmpwovh;
        synchronized (this.lbyddwl) {
            try {
                JSONArray jSONArrayQwpvrdy = qwpvrdy();
                JSONArray jSONArray = new JSONArray();
                for (int iMax = Math.max(0, jSONArrayQwpvrdy.length() - 31); iMax < jSONArrayQwpvrdy.length(); iMax++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayQwpvrdy.optJSONObject(iMax);
                    if (jSONObjectOptJSONObject != null && (!str3.equals(jSONObjectOptJSONObject.optString("owner_user_id", "")) || !str.equals(jSONObjectOptJSONObject.optString("job_id", "")) || !str2.equalsIgnoreCase(jSONObjectOptJSONObject.optString("response_sha256", "")))) {
                        jSONArray.put(jSONObjectOptJSONObject);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("owner_user_id", str3);
                    jSONObject.put("job_id", str);
                    jSONObject.put("response_sha256", str2);
                    jSONObject.put("accepted", z);
                    jSONObject.put("status_code", i);
                } catch (Throwable unused) {
                }
                jSONArray.put(jSONObject);
                getSharedPreferences("xiaomi_auth_pending_ack", 0).edit().putString("queue_json", jSONArray.toString()).commit();
            } catch (Throwable th) {
                throw th;
            }
        }
        fadblxi();
    }

    public final void fixfqug(String str) {
        synchronized (this.haevqmd) {
            try {
                if (str.equals(this.eldycgp)) {
                    this.eldycgp = "";
                }
                if (this.icjnmlh.size() >= 32) {
                    this.icjnmlh.clear();
                }
                this.icjnmlh.add(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void fprgbbe(File file) {
        try {
            File fileGisppfs = x.zamkzqg.gisppfs(file);
            if (!fileGisppfs.isFile() || !fileGisppfs.canRead() || fileGisppfs.length() <= 0) {
                throw new IllegalStateException(getString(R.string.error_selected_image_realpath));
            }
            this.pwjmwpv = fileGisppfs;
            nmpwovh(getString(R.string.log_flash_image_selected, fileGisppfs.getAbsolutePath()));
            lvtqoqa();
        } catch (Throwable th) {
            nmpwovh(getString(R.string.log_flash_image_realpath_error, th.getMessage()));
            Toast.makeText(this, R.string.error_use_selected_image, 1).show();
        }
    }

    public final void fusjbbl(String str) {
        ccuulnt ccuulntVar = this.suqlntg;
        ccuulntVar.getClass();
        if (str == null || str.isEmpty()) {
            return;
        }
        synchronized (ccuulntVar) {
            try {
                if (ccuulntVar.nmpwovh.length() > 0) {
                    StringBuilder sb = ccuulntVar.nmpwovh;
                    if (sb.charAt(sb.length() - 1) != '\n') {
                        ccuulntVar.nmpwovh.append('\n');
                    }
                }
                ccuulntVar.nmpwovh.append(str.replace("\r\n", "\n").replace('\r', '\n'));
                ccuulntVar.ojyssqt();
            } catch (Throwable th) {
                throw th;
            }
        }
        ccuulntVar.nmpwovh(true);
    }

    public final void gdkopre() {
        if (this.ltnesel != null) {
            boolean z = this.nxumtuo || this.dvzxbaj;
            this.ltnesel.nkemejx.setEnabled(z);
            this.ltnesel.nkemejx.setAlpha(z ? 1.0f : 0.35f);
        }
        nysvajy();
    }

    /* JADX WARN: Code duplicated, block: B:114:0x0200  */
    @Override // com.rynx.app.ojyssqt
    public final void gefzxcg() {
        String string;
        int iNmpwovh;
        String string2;
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        String str2;
        String str3;
        String str4;
        int i5;
        int i6;
        String string3;
        int i7;
        int i8;
        boolean z = false;
        String string4 = getString(R.string.mode_non_root);
        if (this.nsyqsfj) {
            string = getString(R.string.session_da_ready_upper);
            iNmpwovh = this.qxvquar;
        } else if (this.gzokllk) {
            string = this.qwgjehf ? getString(R.string.session_connecting_upper) : getString(R.string.session_stopping_upper);
            iNmpwovh = this.oqexvyb;
        } else if (this.qwgjehf && this.ulafhci != null && x.zamkzqg.pmsrvoc(this.ulafhci)) {
            string = getString(R.string.session_started_usb_detected);
            iNmpwovh = this.oqexvyb;
        } else if (this.qwgjehf) {
            string = getString(R.string.session_started_waiting_usb);
            iNmpwovh = this.oqexvyb;
        } else if (this.ulafhci != null) {
            string = getString(R.string.session_stopped_usb_detected);
            iNmpwovh = this.dytyqos;
        } else {
            string = getString(R.string.session_stopped_upper);
            iNmpwovh = this.dytyqos;
        }
        String str5 = "";
        if (this.qunltjs != null) {
            if (this.lataqgm) {
                this.qunltjs.setText(getString(R.string.terminal_status_format, string4, this.ulafhci == null ? getString(R.string.status_waiting_usb) : getString(R.string.terminal_usb_detected), this.nsyqsfj ? getString(R.string.terminal_gui_active_suffix) : ""));
                this.qunltjs.setTextColor(this.nsyqsfj ? this.oqexvyb : this.dytyqos);
            } else {
                this.qunltjs.setText(getString(R.string.gui_status_format, string4, string));
                TextView textView = this.qunltjs;
                if (this.nsyqsfj) {
                    i8 = this.qxvquar;
                } else {
                    i8 = this.gzokllk ? this.oqexvyb : this.dytyqos;
                }
                textView.setTextColor(i8);
            }
        }
        if (this.kggugdp == null) {
            str5 = "";
        } else {
            if (this.nsyqsfj) {
                i7 = R.string.home_connected;
            } else if (this.gzokllk) {
                i7 = this.qwgjehf ? R.string.home_connecting_to_da : R.string.home_stopping_session;
            } else if (this.qwgjehf) {
                i7 = (this.ulafhci == null || !x.zamkzqg.pmsrvoc(this.ulafhci)) ? R.string.home_waiting_device : R.string.home_mediatek_detected;
            } else {
                i7 = this.ulafhci != null ? R.string.home_device_detected_start : R.string.home_gui_stopped;
            }
            this.kggugdp.setText(i7);
            this.kggugdp.setTextColor(iNmpwovh);
            if (this.ulafhci == null && !this.gzokllk && !this.nsyqsfj) {
                iNmpwovh = x.zamkzqg.nmpwovh(this);
            }
            TextView textView2 = this.kggugdp;
            boolean z2 = this.gzokllk || (this.qwgjehf && !this.nsyqsfj);
            if (textView2 == null) {
                str5 = "";
            } else {
                Object tag = textView2.getTag();
                if (tag instanceof ImageView) {
                    ImageView imageView = (ImageView) tag;
                    imageView.setImageTintList(ColorStateList.valueOf(iNmpwovh));
                    imageView.setBackground(x.zamkzqg.jtfjrri(this, x.zamkzqg.atntgcp(this), iNmpwovh, getResources().getDimensionPixelSize(R.dimen.home_usb_orb_ring_width)));
                    Object tag2 = imageView.getTag();
                    if (((tag2 instanceof Boolean) && ((Boolean) tag2).booleanValue()) != z2) {
                        imageView.setTag(Boolean.valueOf(z2));
                        WeakHashMap weakHashMap = x.zfmpmio.nmpwovh;
                        Animator animator = (Animator) weakHashMap.remove(imageView);
                        if (animator != null) {
                            animator.cancel();
                        }
                        imageView.animate().cancel();
                        if (z2 && ValueAnimator.areAnimatorsEnabled()) {
                            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, View.SCALE_X, 1.0f, 1.055f, 1.0f);
                            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView, View.SCALE_Y, 1.0f, 1.055f, 1.0f);
                            objectAnimatorOfFloat.setDuration(1050L);
                            objectAnimatorOfFloat2.setDuration(1050L);
                            objectAnimatorOfFloat.setRepeatCount(-1);
                            objectAnimatorOfFloat2.setRepeatCount(-1);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
                            weakHashMap.put(imageView, animatorSet);
                            animatorSet.start();
                        } else {
                            imageView.setScaleX(1.0f);
                            imageView.setScaleY(1.0f);
                        }
                        if (!z2) {
                            x.zfmpmio.ojyssqt(imageView);
                        }
                    } else {
                        str5 = "";
                    }
                } else {
                    str5 = "";
                }
            }
        }
        TextView textView3 = this.mamlotu;
        if (textView3 != null) {
            UsbDevice usbDevice = this.ulafhci;
            if (usbDevice != null) {
                int iNsyqsfj = x.zamkzqg.nsyqsfj(usbDevice);
                if (iNsyqsfj == 2) {
                    string3 = getString(R.string.usb_mode_adb);
                } else if (iNsyqsfj == 3) {
                    string3 = getString(R.string.usb_mode_fastboot);
                } else {
                    int productId = usbDevice.getProductId() & 65535;
                    if (productId == 8192) {
                        string3 = getString(R.string.usb_mode_preloader);
                    } else {
                        string3 = productId == 3 ? getString(R.string.usb_mode_brom) : getString(R.string.usb_mode_unknown, Integer.valueOf(productId));
                    }
                }
            } else if (this.nsyqsfj) {
                string3 = getString(R.string.usb_mode_da);
            } else {
                string3 = this.qwgjehf ? getString(R.string.status_waiting_usb) : getString(R.string.usb_mode_no_device);
            }
            textView3.setText(string3);
            this.mamlotu.setTextColor((this.ulafhci != null || this.nsyqsfj) ? this.imuemzb : this.nkemejx);
        }
        TextView textView4 = this.yojulhu;
        if (textView4 != null) {
            textView4.setText(string);
            TextView textView5 = this.yojulhu;
            if (this.nsyqsfj) {
                i6 = this.qxvquar;
            } else {
                i6 = (this.gzokllk || this.qwgjehf) ? this.oqexvyb : this.nkemejx;
            }
            textView5.setTextColor(i6);
        }
        TextView textView6 = this.jtfjrri;
        if (textView6 != null) {
            textView6.setText(this.nsyqsfj ? this.xvxmcgn : getString(R.string.value_not_available));
        }
        TextView textView7 = this.ljhdwjr;
        if (textView7 != null) {
            textView7.setText((!this.nsyqsfj || com.rynx.app.ojyssqt.zwaqeaz(this.cnctlxz.ojyssqt)) ? getString(R.string.value_not_available) : this.cnctlxz.ojyssqt);
        }
        TextView textView8 = this.ednetju;
        if (textView8 != null) {
            textView8.setText((!this.nsyqsfj || com.rynx.app.ojyssqt.zwaqeaz(this.cnctlxz.lthborb)) ? getString(R.string.value_not_available) : this.cnctlxz.lthborb);
        }
        TextView textView9 = this.ydsyayx;
        if (textView9 != null) {
            textView9.setText((!this.nsyqsfj || com.rynx.app.ojyssqt.zwaqeaz(this.cnctlxz.wqrnifx)) ? getString(R.string.value_not_available) : this.cnctlxz.wqrnifx);
        }
        TextView textView10 = this.ysaclsr;
        if (textView10 != null) {
            textView10.setText((!this.nsyqsfj || com.rynx.app.ojyssqt.zwaqeaz(this.cnctlxz.dasxvpc)) ? getString(R.string.value_not_available) : this.cnctlxz.dasxvpc);
        }
        vlyywxv(this.hknanqb, this.nsyqsfj ? this.cnctlxz.dplrlfq : null);
        vlyywxv(this.kpmmknm, this.nsyqsfj ? this.cnctlxz.ulafhci : null);
        vlyywxv(this.kffvigz, this.nsyqsfj ? this.cnctlxz.ekyqleu : null);
        TextView textView11 = this.iwjoiry;
        if (textView11 != null) {
            textView11.setText(this.ulafhci == null ? getString(R.string.value_not_available) : String.format(Locale.US, "%04X:%04X", Integer.valueOf(this.ulafhci.getVendorId()), Integer.valueOf(this.ulafhci.getProductId())));
        }
        String strYjbrzgu = yjbrzgu("da_path");
        String string5 = com.rynx.app.ojyssqt.zwaqeaz(strYjbrzgu) ? getString(R.string.status_not_configured) : ezuzoct(strYjbrzgu);
        TextView textView12 = this.marclvq;
        if (textView12 != null) {
            textView12.setText(string5);
        }
        TextView textView13 = this.yxcmoyp;
        if (textView13 != null) {
            textView13.setText(string5);
        }
        TextView textView14 = this.yjvhftf;
        if (textView14 != null) {
            textView14.setText(com.rynx.app.ojyssqt.zwaqeaz(strYjbrzgu) ? R.string.home_select_da : R.string.home_change_da);
        }
        String strYjbrzgu2 = yjbrzgu("auth_path");
        boolean zZwaqeaz = com.rynx.app.ojyssqt.zwaqeaz(strYjbrzgu2);
        boolean z3 = !zZwaqeaz;
        String name = !zZwaqeaz ? new File(strYjbrzgu2).getName() : getString(R.string.home_auth_not_selected);
        TextView textView15 = this.xqbcyis;
        if (textView15 != null) {
            textView15.setText(name);
            this.xqbcyis.setTextColor(!zZwaqeaz ? this.imuemzb : this.dytyqos);
        }
        TextView textView16 = this.tnejqcj;
        if (textView16 != null) {
            textView16.setText(!zZwaqeaz ? R.string.home_change_auth : R.string.home_select_auth);
        }
        exhiehf(this.mdepcqh, z3);
        String strYjbrzgu3 = yjbrzgu("preloader_path");
        boolean zZwaqeaz2 = com.rynx.app.ojyssqt.zwaqeaz(strYjbrzgu3);
        boolean z4 = !zZwaqeaz2;
        boolean zJdqigmr = jdqigmr();
        if (zZwaqeaz2) {
            string2 = getString(R.string.home_preloader_not_selected);
        } else {
            string2 = com.rynx.app.ojyssqt.pvkaerr(yjbrzgu("preloader_display_name"));
            if (com.rynx.app.ojyssqt.zwaqeaz(string2)) {
                string2 = com.rynx.app.ojyssqt.zwaqeaz(strYjbrzgu3) ? str5 : new File(strYjbrzgu3).getName();
            }
        }
        TextView textView17 = this.eqqqfvj;
        if (textView17 != null) {
            textView17.setText(string2);
            TextView textView18 = this.eqqqfvj;
            if (zZwaqeaz2) {
                i5 = this.dytyqos;
            } else {
                i5 = zJdqigmr ? this.imuemzb : this.nkemejx;
            }
            textView18.setTextColor(i5);
        }
        TextView textView19 = this.zzqmpyp;
        if (textView19 != null) {
            textView19.setText(!zZwaqeaz2 ? R.string.home_change_preloader : R.string.home_select_preloader);
        }
        exhiehf(this.nuoqzvr, z4);
        boolean zVntpaom = vntpaom();
        ziuhthw(this.ftrcqfq, (!zVntpaom || !zJdqigmr || this.nsyqsfj || this.gzokllk || this.qwgjehf) ? false : true);
        ziuhthw(this.udgizdi, this.qwgjehf || this.gzokllk || this.nsyqsfj || qyeibyo());
        TextView textView20 = this.saksmfq;
        if (textView20 != null) {
            if (!zVntpaom) {
                textView20.setText(R.string.home_da_first_terminal_note);
                this.saksmfq.setTextColor(this.oqexvyb);
            } else if (!zJdqigmr) {
                textView20.setText(R.string.home_preloader_unreadable_hint);
                this.saksmfq.setTextColor(this.nkemejx);
            } else if (this.nsyqsfj) {
                this.saksmfq.setText(R.string.home_da_ready_hint);
                this.saksmfq.setTextColor(this.qxvquar);
            } else if (this.gzokllk && !this.qwgjehf) {
                this.saksmfq.setText(R.string.home_stopping_transport);
                this.saksmfq.setTextColor(this.oqexvyb);
            } else if (this.gzokllk) {
                this.saksmfq.setText(R.string.home_handshake_progress);
                this.saksmfq.setTextColor(this.oqexvyb);
            } else if (this.qwgjehf) {
                this.saksmfq.setText(this.ulafhci == null ? R.string.home_started_waiting_usb : R.string.home_started_preparing);
                this.saksmfq.setTextColor(this.oqexvyb);
            } else {
                this.saksmfq.setText(R.string.home_press_start_hint);
                this.saksmfq.setTextColor(this.dytyqos);
            }
        }
        TextView textView21 = this.mccfjlr;
        if (textView21 != null) {
            if (com.rynx.app.ojyssqt.zwaqeaz(strYjbrzgu)) {
                strYjbrzgu = getString(R.string.status_not_configured);
            }
            textView21.setText(strYjbrzgu);
        }
        lvtqoqa();
        if (this.aqyicql != null) {
            if (this.nsyqsfj) {
                this.aqyicql.setText(R.string.parts_status_ready);
            } else if (this.gzokllk) {
                this.aqyicql.setText(R.string.parts_status_connecting);
            } else {
                this.aqyicql.setText(string);
            }
            this.aqyicql.setTextColor(this.nsyqsfj ? this.qxvquar : this.oqexvyb);
        }
        if (this.zegwdrn != null) {
            yhrqvll yhrqvllVar = this.jvtqflj;
            if (yhrqvllVar == null || this.nsyqsfj || this.gzokllk) {
                View view = this.yhrqvll;
                if (view == null) {
                    view = this.zegwdrn;
                }
                view.setVisibility(8);
            } else {
                if (yhrqvllVar.qxvquar.length() <= 1200) {
                    str = yhrqvllVar.qxvquar;
                } else {
                    str = yhrqvllVar.qxvquar.substring(0, 1200) + "\n… " + getString(R.string.home_error_full_details_hint);
                }
                TextView textView22 = this.zegwdrn;
                StringBuilder sb = new StringBuilder("✕  ");
                sb.append(yhrqvllVar.nmpwovh);
                sb.append("\n");
                int i9 = yhrqvllVar.vivhedu;
                if (i9 == 1) {
                    str2 = "USB";
                } else if (i9 == 2) {
                    str2 = "BROM";
                } else if (i9 == 3) {
                    str2 = "DA";
                } else {
                    if (i9 != 4) {
                        throw null;
                    }
                    str2 = "READY";
                }
                sb.append(getString(R.string.home_error_stage, str2));
                if (yhrqvllVar.oqexvyb.isEmpty()) {
                    str3 = str5;
                } else {
                    str3 = "\n" + getString(R.string.home_error_code, yhrqvllVar.oqexvyb);
                }
                sb.append(str3);
                sb.append("\n\n");
                sb.append(getString(R.string.home_error_native));
                sb.append("\n");
                sb.append(str);
                if (yhrqvllVar.nkemejx.isEmpty() || yhrqvllVar.qxvquar.contains(yhrqvllVar.nkemejx)) {
                    str4 = str5;
                } else {
                    str4 = "\n\n" + getString(R.string.home_error_native_context) + "\n" + yhrqvllVar.nkemejx;
                }
                sb.append(str4);
                sb.append("\n\n");
                sb.append(getString(R.string.home_error_suggestion));
                sb.append("\n");
                sb.append(yhrqvllVar.ojyssqt);
                textView22.setText(sb.toString());
                if (this.rvrflql != yhrqvllVar) {
                    this.rvrflql = yhrqvllVar;
                    TextView textView23 = this.chwohho;
                    if (textView23 != null) {
                        textView23.setText(yhrqvllVar.imuemzb);
                        this.chwohho.setVisibility(8);
                    }
                    TextView textView24 = this.ljwltks;
                    if (textView24 != null) {
                        textView24.setText(R.string.home_error_show_details);
                    }
                }
                this.zegwdrn.setTextColor(this.nkemejx);
                TextView textView25 = this.iilntfn;
                if (textView25 != null) {
                    textView25.setVisibility(yhrqvllVar.lthborb ? 0 : 8);
                }
                View view2 = this.yhrqvll;
                if (view2 == null) {
                    view2 = this.zegwdrn;
                }
                if (view2.getVisibility() != 0) {
                    view2.setVisibility(0);
                    x.zfmpmio.ojyssqt(view2);
                }
            }
        }
        yhrqvll yhrqvllVar2 = this.jvtqflj;
        boolean z5 = (yhrqvllVar2 == null || this.nsyqsfj || this.gzokllk) ? false : true;
        TextView textView26 = this.eenkamx;
        boolean z6 = this.ulafhci != null || this.gzokllk || this.nsyqsfj;
        if (z5 && yhrqvllVar2.vivhedu == 1) {
            i = this.nkemejx;
        } else {
            i = (this.ulafhci != null || this.gzokllk || this.nsyqsfj) ? this.qxvquar : this.dytyqos;
        }
        wrbqriz(textView26, z6, i);
        TextView textView27 = this.rpdxrib;
        boolean z7 = (this.gzokllk && this.qwgjehf) || this.nsyqsfj;
        if (z5 && yhrqvllVar2.vivhedu == 2) {
            i2 = this.nkemejx;
        } else if (this.nsyqsfj) {
            i2 = this.qxvquar;
        } else {
            i2 = (this.gzokllk && this.qwgjehf) ? this.oqexvyb : this.dytyqos;
        }
        wrbqriz(textView27, z7, i2);
        TextView textView28 = this.hiygjel;
        boolean z8 = (this.gzokllk && this.qwgjehf) || this.nsyqsfj;
        if (z5 && yhrqvllVar2.vivhedu == 3) {
            i3 = this.nkemejx;
        } else if (this.nsyqsfj) {
            i3 = this.qxvquar;
        } else {
            i3 = (this.gzokllk && this.qwgjehf) ? this.oqexvyb : this.dytyqos;
        }
        wrbqriz(textView28, z8, i3);
        TextView textView29 = this.oohojlj;
        boolean z9 = this.nsyqsfj;
        if (z5 && yhrqvllVar2.vivhedu == 4) {
            i4 = this.nkemejx;
        } else {
            i4 = this.nsyqsfj ? this.qxvquar : this.dytyqos;
        }
        wrbqriz(textView29, z9, i4);
        exhiehf(this.rceuwfv, (!this.nsyqsfj || this.lpkdqgx || this.gzokllk) ? false : true);
        exhiehf(this.fusjbbl, (!this.nsyqsfj || this.ywhgqsi || this.lpkdqgx || this.jbmzxye.isEmpty()) ? false : true);
        TextView textView30 = this.npkgpdo;
        if (this.nsyqsfj && !this.ywhgqsi && !this.lpkdqgx) {
            z = true;
        }
        exhiehf(textView30, z);
        TextView textView31 = this.ysluikv;
        if (textView31 != null) {
            textView31.setAlpha(1.0f);
        }
        if (this.nsbgblf != null && this.jbmzxye.isEmpty() && !this.ywhgqsi && !this.nsyqsfj) {
            this.nsbgblf.setText(R.string.parts_offline_summary);
            this.nsbgblf.setTextColor(this.dytyqos);
        }
        if (this.kxotgjb) {
            boolean zPvbzgon = pvbzgon();
            vntpaom();
            nlcdwap(zPvbzgon);
        }
        nysvajy();
        iwjoiry();
    }

    public String getPreparedSlaCredentials(String str) {
        if ("BROM_NEW_SECURITY".equalsIgnoreCase(str) || ("BROM".equalsIgnoreCase(str) && rrpfqyy() && kggugdp())) {
            if (rrpfqyy() && kggugdp()) {
                return dreanqi();
            }
            return null;
        }
        if ("BROM".equalsIgnoreCase(str) && this.laodqsm != null && !kggugdp()) {
            return dreanqi();
        }
        synchronized (this.sthdtww) {
            try {
                if (this.hhqpjvl.isEmpty() || this.wjugzfh.isEmpty()) {
                    return null;
                }
                return this.hhqpjvl + "\n" + this.wjugzfh;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void ghkjjru(final boolean z) {
        if (wjugzfh()) {
            if (this.lpkdqgx || this.gzokllk) {
                Toast.makeText(this, R.string.error_busy, 0).show();
                return;
            }
            x.zamkzqg.bgmsltp(this, z ? R.string.bootloader_unlock_title : R.string.bootloader_lock_title, getString(z ? R.string.bootloader_unlock_message : R.string.bootloader_lock_message), z ? R.string.bootloader_unlock : R.string.bootloader_lock, true, new DialogInterface.OnClickListener() { // from class: x.slxntng
                public final /* synthetic */ MainActivity nmpwovh = MainActivity.this;
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity mainActivity = this.nmpwovh;
                    mainActivity.getClass();
                    String str = z ? "unlock" : "lock";
                    if (mainActivity.wjugzfh()) {
                        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
                        if ("unlock".equals(lowerCase) || "lock".equals(lowerCase)) {
                            Toast.makeText(mainActivity, "unlock".equals(lowerCase) ? R.string.bootloader_unlock_started : R.string.bootloader_lock_started, 0).show();
                            mainActivity.casbgpb("seccfg", lowerCase, "");
                        }
                    }
                }
            });
        }
    }

    public final String gngavpw(int i) {
        jybecxv jybecxvVar = this.ltnesel;
        if (jybecxvVar != null) {
            TextView textView = i == 2 ? jybecxvVar.ekyqleu : jybecxvVar.buswjhz;
            String strTrim = textView.getText() == null ? "" : textView.getText().toString().trim();
            if (!strTrim.isEmpty() && !"—".equals(strTrim) && !getString(R.string.value_not_available).equals(strTrim)) {
                return strTrim;
            }
        }
        UsbDevice usbDevice = this.ulafhci;
        return usbDevice == null ? "unknown" : String.format(Locale.US, "%04X:%04X", Integer.valueOf(usbDevice.getVendorId()), Integer.valueOf(usbDevice.getProductId()));
    }

    public final String guecdgy() {
        if (this.thbdbid) {
            String str = com.rynx.app.ojyssqt.zwaqeaz(this.gucwjqz) ? "device" : this.gucwjqz;
            String str2 = com.rynx.app.ojyssqt.zwaqeaz(this.mcdstyz) ? "/" : this.mcdstyz;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            sb.append(this.sjexbpf ? " # " : " $ ");
            return sb.toString();
        }
        File file = this.gzvolsx;
        String absolutePath = file == null ? "/storage/emulated/0" : file.getAbsolutePath();
        if (absolutePath.startsWith("/storage/emulated/0")) {
            absolutePath = "/sdcard" + absolutePath.substring(19);
        }
        return absolutePath + " $ ";
    }

    public final void hfkdhls(String str) {
        synchronized (this.haevqmd) {
            try {
                if (str.equals(this.eldycgp)) {
                    this.eldycgp = "";
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void hhqpjvl(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return;
        }
        if (x.zamkzqg.rrpfqyy(usbDevice) && (this.nsyqsfj || this.gzokllk || this.lpkdqgx)) {
            nmpwovh("[USB] DA owns the USB transport; stop/disconnect the DA session before opening ADB/Fastboot.");
            return;
        }
        if (this.dplrlfq.hasPermission(usbDevice)) {
            oqexvyb();
            lpkdqgx(usbDevice);
            return;
        }
        this.jdqigmr = usbDevice.getDeviceId();
        this.lclupha = usbDevice.getDeviceName() == null ? "" : usbDevice.getDeviceName();
        this.gisppfs = usbDevice.getVendorId();
        this.zwaqeaz = usbDevice.getProductId();
        this.dplrlfq.requestPermission(usbDevice, PendingIntent.getBroadcast(this, 0, new Intent("com.rynx.app.USB_PERMISSION").setPackage(getPackageName()), Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728));
    }

    public final File hjlrtqw(InputStream inputStream, String str, String str2, String str3) throws Throwable {
        File file = new File(getNoBackupFilesDir(), str);
        if ((!file.isDirectory() && !file.mkdirs()) || !file.isDirectory()) {
            throw new IOException("Unable to create private " + str3 + " directory");
        }
        File fileCreateTempFile = File.createTempFile(".pending-".concat(str2), ".tmp", file);
        boolean z = false;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile, false);
            try {
                byte[] bArr = new byte[65536];
                long j = 0;
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                        if (j <= 0) {
                            throw new IOException("Selected " + str3 + " is empty");
                        }
                        File file2 = new File(file, str2 + Long.toHexString(System.currentTimeMillis()) + "-" + Long.toHexString(System.nanoTime()) + ".bin");
                        if (!fileCreateTempFile.renameTo(file2)) {
                            throw new IOException("Unable to commit private " + str3 + " copy");
                        }
                        try {
                            return x.zamkzqg.gisppfs(file2);
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            if (!z) {
                                fileCreateTempFile.delete();
                            }
                            throw th;
                        }
                    }
                    if (i != 0) {
                        j += (long) i;
                        if (j > 134217728) {
                            throw new IOException("Selected " + str3 + " exceeds the configured import limit");
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                }
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                    throw th2;
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            if (!z && fileCreateTempFile.exists()) {
                fileCreateTempFile.delete();
            }
            throw th4;
        }
    }

    public final void iasgsgq(File file, String str) {
        try {
            File fileGisppfs = x.zamkzqg.gisppfs(new File(getNoBackupFilesDir(), str));
            File fileGisppfs2 = file == null ? null : x.zamkzqg.gisppfs(file);
            File[] fileArrListFiles = fileGisppfs.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                File fileGisppfs3 = x.zamkzqg.gisppfs(file2);
                if (fileGisppfs2 == null || !fileGisppfs3.equals(fileGisppfs2)) {
                    fileGisppfs3.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean iivesaq() {
        return (this.ulafhci == null || !x.zamkzqg.pmsrvoc(this.ulafhci) || this.ivvkvsj || this.lataqgm || this.nsyqsfj || this.gzokllk || this.lpkdqgx || this.bsimxgu != null || !this.qwgjehf || !vntpaom()) ? false : true;
    }

    public final void ijakhcl() {
        synchronized (this.sthdtww) {
            this.hhqpjvl = "";
            this.wjugzfh = "";
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void imuemzb() {
        if (this.lpkdqgx && "WRITE".equals(this.ygdccqg)) {
            new AlertDialog.Builder(this).setTitle(R.string.flash_stop_title).setMessage(R.string.flash_stop_message).setNegativeButton(R.string.action_keep_flashing, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.action_stop_anyway, new hknanqb(this, 0)).show();
        } else {
            yonoayx();
        }
    }

    public final ArrayList iqvvlnh(String str) {
        String string = getString(R.string.error_unclosed_quote);
        HashSet hashSet = x.cugubfc.nmpwovh;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (z) {
                sb.append(cCharAt);
                z = false;
            } else if (cCharAt == '\\' && !z2) {
                z = true;
            } else if (cCharAt == '\'' && !z3) {
                z2 = !z2;
            } else if (cCharAt == '\"' && !z2) {
                z3 = !z3;
            } else if (!Character.isWhitespace(cCharAt) || z2 || z3) {
                sb.append(cCharAt);
            } else if (sb.length() > 0) {
                arrayList.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (z || z2 || z3) {
            throw new IllegalArgumentException(string);
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    public final void jbmzxye() {
        this.dvzxbaj = false;
        if (this.qppdydr) {
            this.qppdydr = false;
            nkemejx();
            fusjbbl("[cancelled] Fastboot worker stopped. Reconnect the target before retrying.");
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final boolean jdqigmr() {
        String strYjbrzgu = yjbrzgu("preloader_path");
        if (com.rynx.app.ojyssqt.zwaqeaz(strYjbrzgu)) {
            return true;
        }
        File file = new File(strYjbrzgu);
        return file.isFile() && file.canRead() && file.length() > 0 && com.rynx.app.ojyssqt.gisppfs(file.getName());
    }

    public final void jzcfpou() {
        if (this.nsyqsfj || this.gzokllk || this.lpkdqgx) {
            Toast.makeText(this, R.string.android_tools_busy, 0).show();
            wfxzfba(false);
            return;
        }
        cgcdpmq();
        wfxzfba(true);
        UsbDevice usbDevice = this.ulafhci;
        int iNsyqsfj = x.zamkzqg.nsyqsfj(usbDevice);
        if ((iNsyqsfj == 2 || iNsyqsfj == 3) && this.dplrlfq.hasPermission(usbDevice) && qyeibyo()) {
            if (iNsyqsfj == 2) {
                znfyiic();
            } else {
                sxhcynd();
            }
        }
    }

    public final void lataqgm(String str, String str2) {
        snilumr(str2, new lclupha(this, str, 1));
    }

    public final void lcgzsis(String str, String str2) {
        SharedPreferences.Editor editorEdit = getSharedPreferences("rynx_persistent_session", 0).edit();
        if (str == null) {
            str = "";
        }
        editorEdit.putString("preloader_path", str).putString("preloader_display_name", com.rynx.app.ojyssqt.pvkaerr(str2)).apply();
    }

    @Override // com.rynx.app.ojyssqt
    public final File lclupha() {
        String string = getSharedPreferences("rynx_persistent_session", 0).getString("internal_picker_dir", "");
        if (!com.rynx.app.ojyssqt.zwaqeaz(string)) {
            try {
                File fileGisppfs = x.zamkzqg.gisppfs(new File(string));
                if (fileGisppfs.isDirectory() && fileGisppfs.canRead()) {
                    return fileGisppfs;
                }
            } catch (Throwable unused) {
            }
        }
        File file = new File(Environment.getExternalStorageDirectory(), "Download");
        return (file.isDirectory() && file.canRead()) ? x.zamkzqg.gisppfs(file) : x.zamkzqg.gisppfs(Environment.getExternalStorageDirectory());
    }

    @Override // com.rynx.app.ojyssqt
    public final void lpkdqgx(UsbDevice usbDevice) {
        boolean z;
        if (usbDevice == null) {
            return;
        }
        if (x.zamkzqg.rrpfqyy(usbDevice) && (this.nsyqsfj || this.gzokllk || this.lpkdqgx)) {
            nmpwovh("[USB] Ignoring ADB/Fastboot open while DA owns the USB transport.");
            return;
        }
        synchronized (this.atntgcp) {
            try {
                z = true;
                if (dytyqos(usbDevice)) {
                    this.ulafhci = usbDevice;
                } else {
                    UsbDeviceConnection usbDeviceConnectionOpenDevice = this.dplrlfq.openDevice(usbDevice);
                    if (usbDeviceConnectionOpenDevice != null) {
                        UsbDeviceConnection usbDeviceConnection = this.ekyqleu;
                        boolean zPmsrvoc = x.zamkzqg.pmsrvoc(usbDevice);
                        long jNativeSetUsbFd = nativeSetUsbFd(zPmsrvoc ? usbDeviceConnectionOpenDevice.getFileDescriptor() : -1);
                        this.ekyqleu = usbDeviceConnectionOpenDevice;
                        this.utmeivs = usbDevice.getDeviceId();
                        this.buswjhz = usbDevice.getDeviceName() == null ? "" : usbDevice.getDeviceName();
                        this.pvbzgon = usbDevice.getVendorId();
                        this.qyeibyo = usbDevice.getProductId();
                        if (!zPmsrvoc) {
                            jNativeSetUsbFd = 0;
                        }
                        this.vntpaom = jNativeSetUsbFd;
                        this.ulafhci = usbDevice;
                        oqexvyb();
                        if (usbDeviceConnection != null) {
                            try {
                                usbDeviceConnection.close();
                            } catch (Throwable unused) {
                            }
                        }
                    } else {
                        z = false;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z) {
            nmpwovh(getString(R.string.log_usb_open_null));
            gefzxcg();
            return;
        }
        gefzxcg();
        int iNsyqsfj = x.zamkzqg.nsyqsfj(usbDevice);
        if (iNsyqsfj != 2 && iNsyqsfj != 3) {
            if (this.gzokllk) {
                return;
            }
            if (iivesaq()) {
                ygdccqg();
                return;
            } else {
                wdvdxhb();
                return;
            }
        }
        if ("android_tools".equals(this.ayzlrnr)) {
            wfxzfba(false);
            if (iNsyqsfj == 2) {
                znfyiic();
            } else {
                sxhcynd();
            }
        }
    }

    public final void lsgjyur() {
        oqexvyb();
        if (this.ekyqleu == null) {
            this.utmeivs = -1;
            this.buswjhz = "";
            this.pvbzgon = -1;
            this.qyeibyo = -1;
            this.vntpaom = 0L;
            return;
        }
        nativeSetUsbFd(-1);
        UsbDeviceConnection usbDeviceConnection = this.ekyqleu;
        this.ekyqleu = null;
        this.utmeivs = -1;
        this.buswjhz = "";
        this.pvbzgon = -1;
        this.qyeibyo = -1;
        this.vntpaom = 0L;
        try {
            usbDeviceConnection.close();
        } catch (Throwable unused) {
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void lvtqoqa() {
        File file;
        TextView textView = this.gngavpw;
        if (textView != null) {
            ohwxijw ohwxijwVar = this.ezuzoct;
            textView.setText(ohwxijwVar == null ? getString(R.string.flash_select_partition) : ohwxijwVar.nmpwovh);
        }
        TextView textView2 = this.teupdsw;
        if (textView2 != null) {
            ohwxijw ohwxijwVar2 = this.ezuzoct;
            if (ohwxijwVar2 == null) {
                textView2.setText(R.string.flash_load_parts_hint);
            } else if (!ohwxijwVar2.nkemejx || "—".equals(ohwxijwVar2.qxvquar)) {
                ohwxijw ohwxijwVar3 = this.ezuzoct;
                if (ohwxijwVar3.nkemejx) {
                    this.teupdsw.setText(getString(R.string.flash_meta_critical, ohwxijwVar3.lthborb));
                } else if ("—".equals(ohwxijwVar3.qxvquar)) {
                    this.teupdsw.setText(this.ezuzoct.lthborb);
                } else {
                    TextView textView3 = this.teupdsw;
                    ohwxijw ohwxijwVar4 = this.ezuzoct;
                    textView3.setText(getString(R.string.parts_meta_slot, ohwxijwVar4.lthborb, ohwxijwVar4.qxvquar));
                }
            } else {
                TextView textView4 = this.teupdsw;
                ohwxijw ohwxijwVar5 = this.ezuzoct;
                textView4.setText(getString(R.string.flash_meta_slot_critical, ohwxijwVar5.lthborb, ohwxijwVar5.qxvquar));
            }
            TextView textView5 = this.teupdsw;
            ohwxijw ohwxijwVar6 = this.ezuzoct;
            textView5.setTextColor((ohwxijwVar6 == null || !ohwxijwVar6.nkemejx) ? this.dytyqos : this.oqexvyb);
        }
        TextView textView6 = this.duxkmyb;
        if (textView6 != null) {
            File file2 = this.pwjmwpv;
            textView6.setText(file2 == null ? getString(R.string.flash_choose_image) : file2.getName());
        }
        TextView textView7 = this.znfyiic;
        if (textView7 != null) {
            File file3 = this.pwjmwpv;
            textView7.setText(file3 == null ? getString(R.string.flash_real_path_hint) : file3.getAbsolutePath());
        }
        File file4 = this.pwjmwpv;
        long length = (file4 == null || !file4.isFile()) ? -1L : this.pwjmwpv.length();
        ohwxijw ohwxijwVar7 = this.ezuzoct;
        long j = ohwxijwVar7 != null ? ohwxijwVar7.vivhedu : -1L;
        TextView textView8 = this.sxhcynd;
        if (textView8 != null) {
            textView8.setText(length >= 0 ? x.zamkzqg.jybecxv(length) : getString(R.string.value_not_available));
        }
        TextView textView9 = this.hfkdhls;
        if (textView9 != null) {
            textView9.setText(j >= 0 ? x.zamkzqg.jybecxv(j) : getString(R.string.value_not_available));
        }
        boolean z = false;
        boolean z2 = this.nsyqsfj && this.ezuzoct != null && (file = this.pwjmwpv) != null && file.isFile() && this.pwjmwpv.canRead() && length > 0 && length <= j;
        TextView textView10 = this.lcgzsis;
        if (textView10 != null) {
            if (this.ezuzoct == null || this.pwjmwpv == null) {
                textView10.setText(R.string.flash_select_validation);
                this.lcgzsis.setTextColor(this.dytyqos);
            } else if (length <= 0) {
                textView10.setText(R.string.flash_image_empty);
                this.lcgzsis.setTextColor(this.nkemejx);
            } else if (length > j) {
                textView10.setText(R.string.flash_image_too_large);
                this.lcgzsis.setTextColor(this.nkemejx);
            } else if (this.prywqjr && length < j) {
                textView10.setText(getString(R.string.flash_raw_padding_warning, x.zamkzqg.jybecxv(j - length)));
                this.lcgzsis.setTextColor(this.oqexvyb);
            } else if (length == j) {
                textView10.setText(R.string.flash_exact_size);
                this.lcgzsis.setTextColor(this.qxvquar);
            } else {
                textView10.setText(getString(R.string.flash_fits, x.zamkzqg.jybecxv(j), x.zamkzqg.jybecxv(length)));
                this.lcgzsis.setTextColor(this.qxvquar);
            }
        }
        TextView textView11 = this.tqfwohl;
        if (z2 && !this.lpkdqgx && !this.gzokllk) {
            z = true;
        }
        exhiehf(textView11, z);
    }

    public final void mccfjlr(String str, String str2, String str3, String str4) {
        if (com.rynx.app.ojyssqt.zwaqeaz(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = getSharedPreferences("rynx_persistent_session", 0).edit();
        if (str == null) {
            str = "";
        }
        SharedPreferences.Editor editorPutString = editorEdit.putString("da_path", str).putString("da_display_name", com.rynx.app.ojyssqt.pvkaerr(str2));
        if (str3 == null) {
            str3 = "";
        }
        SharedPreferences.Editor editorPutString2 = editorPutString.putString("auth_path", str3);
        if (str4 == null) {
            str4 = "";
        }
        editorPutString2.putString("preloader_path", str4).apply();
    }

    public final void mslkofp(int i, int i2, int i3, String str) {
        if (wjugzfh()) {
            if (this.lpkdqgx || this.gzokllk) {
                Toast.makeText(this, R.string.error_busy, 0).show();
            } else {
                x.zamkzqg.bgmsltp(this, i, getString(i2), i3, "shutdown".equals(str), new qyeibyo(this, str, 0));
            }
        }
    }

    public final String mwngani() {
        int i;
        String strYjbrzgu = yjbrzgu("da_path");
        if (com.rynx.app.ojyssqt.zwaqeaz(strYjbrzgu)) {
            return "UNKNOWN";
        }
        File file = new File(strYjbrzgu);
        if (file.isFile() && file.canRead()) {
            byte[] bArr = {120, 105, 97, 111, 109, 105};
            byte[] bArr2 = {116, 114, 97, 110, 115, 115, 105, 111, 110};
            byte[] bArr3 = new byte[65536];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                boolean z = false;
                boolean z2 = false;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    try {
                        int i4 = fileInputStream.read(bArr3);
                        if (i4 < 0) {
                            fileInputStream.close();
                            if (z) {
                                return "XIAOMI";
                            }
                            return z2 ? "TRANSSION" : "UNKNOWN";
                        }
                        if (i4 != 0) {
                            for (int i5 = 0; i5 < i4; i5++) {
                                int i6 = bArr3[i5] & 255;
                                if (i6 >= 65 && i6 <= 90) {
                                    i6 += 32;
                                }
                                if (!z) {
                                    i2 = (i2 >= 6 || i6 != (bArr[i2] & 255)) ? i6 == (bArr[0] & 255) ? 1 : 0 : i2 + 1;
                                    if (i2 == 6) {
                                        z = true;
                                    }
                                }
                                if (!z2) {
                                    if (i3 >= 9 || i6 != (bArr2[i3] & 255)) {
                                        i3 = i6 == (bArr2[0] & 255) ? 1 : 0;
                                        i = 9;
                                    } else {
                                        i3++;
                                        i = 9;
                                    }
                                    if (i3 == i) {
                                        z2 = true;
                                    }
                                }
                                if (z && z2) {
                                    fileInputStream.close();
                                    return "UNKNOWN";
                                }
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                }
            } catch (IOException unused) {
            }
        }
        return "UNKNOWN";
    }

    public final void mwocrhx() {
        if (this.ltnesel == null) {
            return;
        }
        String string = getString(R.string.value_not_available);
        this.ltnesel.utmeivs.setText(string);
        this.ltnesel.buswjhz.setText(string);
        this.ltnesel.pvbzgon.setText(string);
        this.ltnesel.qyeibyo.setText(string);
        this.ltnesel.vntpaom.setText(string);
    }

    public final File naaizwn(File file, String str, String str2, String str3) throws IOException {
        if (file == null || !file.isFile() || !file.canRead()) {
            throw new IOException("Selected " + str3 + " cannot be opened");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            File fileHjlrtqw = hjlrtqw(fileInputStream, str, str2, str3);
            fileInputStream.close();
            return fileHjlrtqw;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.rynx.app.ojyssqt
    public native void nativeCancelIo();

    @Override // com.rynx.app.ojyssqt
    public native String nativeConnectSession(int i, long j, String str, String str2, String str3);

    @Override // com.rynx.app.ojyssqt
    public native void nativeDisconnectSession();

    @Override // com.rynx.app.ojyssqt
    public native boolean nativeHasSession();

    @Override // com.rynx.app.ojyssqt
    public native String nativeRunCommand(int i, long j, String str, String str2, String str3, String str4, String str5, String str6);

    @Override // com.rynx.app.ojyssqt
    public native String nativeRunGuiAction(int i, long j, String str, String str2, String str3, String str4, String str5, String str6);

    @Override // com.rynx.app.ojyssqt
    public native long nativeSetUsbFd(int i);

    @Override // com.rynx.app.ojyssqt
    public native void nativeSetXiaomiAuthGeneration(int i);

    public final void neppdxk(String str) {
        try {
            ArrayList arrayListIqvvlnh = iqvvlnh(str);
            if (arrayListIqvvlnh.isEmpty()) {
                fusjbbl(getString(R.string.android_tools_terminal_fastboot_help));
                return;
            }
            String str2 = (String) arrayListIqvvlnh.get(0);
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            if ("devices".equals(lowerCase)) {
                if (x.zamkzqg.nsyqsfj(this.ulafhci) != 3) {
                    fusjbbl("(no Fastboot device detected)");
                    return;
                } else {
                    fusjbbl(gngavpw(3).concat("\tfastboot"));
                    return;
                }
            }
            if ("version".equals(lowerCase) || "--version".equals(lowerCase)) {
                fusjbbl("rynx direct Fastboot host (USB transport)");
                return;
            }
            if ("getvar".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 2) {
                    fusjbbl("Usage: fastboot getvar <name>");
                    return;
                }
                bsimxgu("getvar:" + ((String) arrayListIqvvlnh.get(1)));
                return;
            }
            if ("reboot".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() > 2) {
                    fusjbbl("Usage: fastboot reboot [bootloader|fastboot|recovery]");
                    return;
                }
                if (arrayListIqvvlnh.size() == 1) {
                    bsimxgu("reboot");
                    return;
                }
                if ("bootloader".equalsIgnoreCase((String) arrayListIqvvlnh.get(1))) {
                    bsimxgu("reboot-bootloader");
                    return;
                }
                if ("fastboot".equalsIgnoreCase((String) arrayListIqvvlnh.get(1)) || "fastbootd".equalsIgnoreCase((String) arrayListIqvvlnh.get(1))) {
                    bsimxgu("reboot-fastboot");
                    return;
                } else if ("recovery".equalsIgnoreCase((String) arrayListIqvvlnh.get(1))) {
                    bsimxgu("reboot-recovery");
                    return;
                } else {
                    fusjbbl("Usage: fastboot reboot [bootloader|fastboot|recovery]");
                    return;
                }
            }
            if ("reboot-bootloader".equals(lowerCase) && arrayListIqvvlnh.size() == 1) {
                bsimxgu("reboot-bootloader");
                return;
            }
            if ("reboot-fastboot".equals(lowerCase) && arrayListIqvvlnh.size() == 1) {
                bsimxgu("reboot-fastboot");
                return;
            }
            if ("continue".equals(lowerCase) && arrayListIqvvlnh.size() == 1) {
                bsimxgu("continue");
                return;
            }
            if (("shutdown".equals(lowerCase) || "poweroff".equals(lowerCase)) && arrayListIqvvlnh.size() == 1) {
                bsimxgu("shutdown");
                return;
            }
            if ("flash".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 3) {
                    fusjbbl("Usage: fastboot flash <partition> <image>");
                    return;
                }
                String str3 = (String) arrayListIqvvlnh.get(1);
                if (!x.zamkzqg.dvzxbaj(str3)) {
                    fusjbbl("ERROR: invalid Fastboot partition name");
                    return;
                }
                String strAqyicql = aqyicql((String) arrayListIqvvlnh.get(2));
                pzkwhtn("Fastboot flash", "Flash " + str3 + " with:\n" + strAqyicql + "\n\nWrong images can make the device unbootable.", new gisppfs(this, str3, strAqyicql, 1));
                return;
            }
            if ("boot".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 2) {
                    fusjbbl("Usage: fastboot boot <boot.img>");
                    return;
                }
                String strAqyicql2 = aqyicql((String) arrayListIqvvlnh.get(1));
                pzkwhtn("Fastboot boot", "Temporarily boot image:\n" + strAqyicql2, new utmeivs(this, strAqyicql2, 0));
                return;
            }
            if ("stage".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 2) {
                    fusjbbl("Usage: fastboot stage <in_file>");
                    return;
                } else {
                    czqxnxv("stage", "", aqyicql((String) arrayListIqvvlnh.get(1)));
                    return;
                }
            }
            if ("erase".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 2) {
                    fusjbbl("Usage: fastboot erase <partition>");
                    return;
                }
                String str4 = (String) arrayListIqvvlnh.get(1);
                if (!x.zamkzqg.dvzxbaj(str4)) {
                    fusjbbl("ERROR: invalid Fastboot partition name");
                    return;
                }
                pzkwhtn("Fastboot erase", "Erase partition '" + str4 + "'? This destroys its contents.", new utmeivs(this, str4, 1));
                return;
            }
            if ("set_active".equals(lowerCase) || "set-active".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 2) {
                    fusjbbl("Usage: fastboot set_active <slot>");
                    return;
                }
                String lowerCase2 = ((String) arrayListIqvvlnh.get(1)).trim().toLowerCase(locale);
                if (lowerCase2.startsWith("_")) {
                    lowerCase2 = lowerCase2.substring(1);
                }
                if (lowerCase2.length() != 1 || lowerCase2.charAt(0) < 'a' || lowerCase2.charAt(0) > 'z') {
                    fusjbbl("ERROR: slot must be a single suffix letter (for example a or b)");
                    return;
                } else {
                    bsimxgu("set_active:".concat(lowerCase2));
                    return;
                }
            }
            if ("flashing".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 2) {
                    fusjbbl("Usage: fastboot flashing <lock|unlock|lock_critical|unlock_critical|get_unlock_ability>");
                    return;
                }
                String lowerCase3 = ((String) arrayListIqvvlnh.get(1)).toLowerCase(locale);
                if (!"lock".equals(lowerCase3) && !"unlock".equals(lowerCase3) && !"lock_critical".equals(lowerCase3) && !"unlock_critical".equals(lowerCase3) && !"get_unlock_ability".equals(lowerCase3)) {
                    fusjbbl("Unsupported flashing action");
                    return;
                }
                if ("get_unlock_ability".equals(lowerCase3)) {
                    bsimxgu("flashing " + lowerCase3);
                    return;
                } else {
                    pzkwhtn("Fastboot flashing " + lowerCase3, "Bootloader lock state changes can wipe data or make an incompatible device unbootable.", new utmeivs(this, lowerCase3, 2));
                    return;
                }
            }
            if ("oem".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() < 2) {
                    fusjbbl("Usage: fastboot oem <command>");
                    return;
                }
                StringBuilder sb = new StringBuilder("oem ");
                int size = arrayListIqvvlnh.size();
                StringBuilder sb2 = new StringBuilder();
                for (int i = 1; i < size; i++) {
                    if (sb2.length() > 0) {
                        sb2.append(" ");
                    }
                    sb2.append((String) arrayListIqvvlnh.get(i));
                }
                sb.append(sb2.toString());
                String string = sb.toString();
                pzkwhtn("Fastboot OEM command", "Run vendor-specific command?\n\n" + string, new utmeivs(this, string, 3));
                return;
            }
            if ("create-logical-partition".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 3) {
                    fusjbbl("Usage: fastboot create-logical-partition <name> <size>");
                    return;
                }
                if (!x.zamkzqg.dvzxbaj((String) arrayListIqvvlnh.get(1)) || !x.zamkzqg.ltnesel((String) arrayListIqvvlnh.get(2))) {
                    fusjbbl("ERROR: invalid logical partition name or size");
                    return;
                }
                String str5 = "create-logical-partition:" + ((String) arrayListIqvvlnh.get(1)) + ":" + ((String) arrayListIqvvlnh.get(2));
                pzkwhtn("Create logical partition", str5, new utmeivs(this, str5, 4));
                return;
            }
            if ("delete-logical-partition".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 2) {
                    fusjbbl("Usage: fastboot delete-logical-partition <name>");
                    return;
                }
                if (!x.zamkzqg.dvzxbaj((String) arrayListIqvvlnh.get(1))) {
                    fusjbbl("ERROR: invalid logical partition name");
                    return;
                }
                pzkwhtn("Delete logical partition", "Delete " + ((String) arrayListIqvvlnh.get(1)) + "?", new utmeivs(this, "delete-logical-partition:" + ((String) arrayListIqvvlnh.get(1)), 5));
                return;
            }
            if ("resize-logical-partition".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 3) {
                    fusjbbl("Usage: fastboot resize-logical-partition <name> <size>");
                    return;
                }
                if (!x.zamkzqg.dvzxbaj((String) arrayListIqvvlnh.get(1)) || !x.zamkzqg.ltnesel((String) arrayListIqvvlnh.get(2))) {
                    fusjbbl("ERROR: invalid logical partition name or size");
                    return;
                }
                String str6 = "resize-logical-partition:" + ((String) arrayListIqvvlnh.get(1)) + ":" + ((String) arrayListIqvvlnh.get(2));
                pzkwhtn("Resize logical partition", str6, new utmeivs(this, str6, 6));
                return;
            }
            if ("gsi".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 2 || (!"wipe".equals(arrayListIqvvlnh.get(1)) && !"disable".equals(arrayListIqvvlnh.get(1)))) {
                    fusjbbl("Usage: fastboot gsi <wipe|disable>");
                    return;
                }
                String str7 = "gsi:" + ((String) arrayListIqvvlnh.get(1));
                pzkwhtn("Fastboot GSI", str7, new utmeivs(this, str7, 7));
                return;
            }
            if ("snapshot-update".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() > 2 || !(arrayListIqvvlnh.size() != 2 || "cancel".equals(arrayListIqvvlnh.get(1)) || "merge".equals(arrayListIqvvlnh.get(1)))) {
                    fusjbbl("Usage: fastboot snapshot-update [cancel|merge]");
                    return;
                }
                String str8 = "snapshot-update:" + (arrayListIqvvlnh.size() == 2 ? (String) arrayListIqvvlnh.get(1) : "");
                pzkwhtn("Snapshot update", str8, new utmeivs(this, str8, 8));
                return;
            }
            if ("wipe-super".equals(lowerCase)) {
                fusjbbl("fastboot wipe-super is intentionally disabled in direct-USB mode. AOSP parses super_empty metadata and generates slot-aware super images; sending super_empty.img directly to update-super is not equivalent and can be unsafe.");
                return;
            }
            if ("format".equals(lowerCase) || lowerCase.startsWith("format:")) {
                fusjbbl("fastboot format requires host filesystem image builders (mke2fs/mkfs.f2fs), which are not bundled in this APK. Use erase or flash a prepared filesystem image.");
                return;
            }
            if ("fetch".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 3) {
                    fusjbbl("Usage: fastboot fetch <partition> <out_file>");
                    return;
                }
                String str9 = (String) arrayListIqvvlnh.get(1);
                if (x.zamkzqg.dvzxbaj(str9)) {
                    sfildfy(true, str9, aqyicql((String) arrayListIqvvlnh.get(2)));
                    return;
                } else {
                    fusjbbl("ERROR: invalid Fastboot partition name");
                    return;
                }
            }
            if ("upload".equals(lowerCase) || "get_staged".equals(lowerCase) || "get-staged".equals(lowerCase)) {
                if (arrayListIqvvlnh.size() != 2) {
                    fusjbbl("Usage: fastboot upload <out_file>");
                    return;
                } else {
                    sfildfy(false, "upload", aqyicql((String) arrayListIqvvlnh.get(1)));
                    return;
                }
            }
            if ("update".equals(lowerCase) || "flashall".equals(lowerCase) || "-w".equals(lowerCase)) {
                fusjbbl("Product-package orchestration is not a single Fastboot protocol command. Flash partitions explicitly in this terminal.");
            } else {
                fusjbbl("Unsupported Fastboot command in the direct USB backend.\nUse 'fastboot help' for supported commands.");
            }
        } catch (IllegalArgumentException e) {
            fusjbbl("ERROR: " + e.getMessage());
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void nkemejx() {
        synchronized (this.atntgcp) {
            lsgjyur();
        }
        gefzxcg();
    }

    public final void nlcdwap(boolean z) {
        TextView textView = this.bpqosqe;
        int i = R.string.setup_storage_granted;
        if (textView != null) {
            textView.setText(z ? R.string.setup_storage_granted : R.string.setup_storage_required);
            this.bpqosqe.setTextColor(z ? this.qxvquar : this.oqexvyb);
            this.bpqosqe.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.ic_status_done : R.drawable.ic_warning, 0, 0, 0);
            this.bpqosqe.setCompoundDrawableTintList(ColorStateList.valueOf(z ? this.qxvquar : this.oqexvyb));
            this.bpqosqe.setCompoundDrawablePadding(dasxvpc(7));
        }
        TextView textView2 = this.araemok;
        if (textView2 != null) {
            if (!z) {
                i = R.string.setup_grant_storage;
            }
            textView2.setText(i);
            exhiehf(this.araemok, !z);
        }
        TextView textView3 = this.jofyvuh;
        if (textView3 != null) {
            textView3.setText(!z ? R.string.error_grant_storage_first : R.string.setup_storage_ready_hint);
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void nmpwovh(String str) {
        ysaclsr ysaclsrVar;
        TextView textView;
        if (str == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            runOnUiThread(new utmeivs(this, str, 12));
            return;
        }
        if (isFinishing() || isDestroyed() || (textView = (ysaclsrVar = this.snilumr).nmpwovh) == null) {
            return;
        }
        boolean z = ysaclsrVar.lthborb;
        textView.append(str);
        ysaclsrVar.nmpwovh.append("\n");
        ysaclsrVar.qxvquar = false;
        ysaclsrVar.nmpwovh();
        if (z) {
            ysaclsrVar.lthborb = true;
            ScrollView scrollView = ysaclsrVar.ojyssqt;
            if (scrollView == null) {
                return;
            }
            scrollView.post(new eigllth(ysaclsrVar, 3));
        }
    }

    public final int nnkxxji() {
        synchronized (this.atntgcp) {
            if (this.ekyqleu == null) {
                return -1;
            }
            try {
                return this.ekyqleu.getFileDescriptor();
            } catch (Throwable unused) {
                return -1;
            }
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void nsizane() {
        this.ivvkvsj = false;
        if (!pvbzgon()) {
            Toast.makeText(this, R.string.error_grant_storage_first, 0).show();
            sthdtww();
            return;
        }
        if (!vntpaom()) {
            Toast.makeText(this, R.string.error_da_required, 0).show();
            if (dplrlfq()) {
                x.ecffprn.imuemzb(this, getString(R.string.home_da_file), lclupha(), new String[]{".bin"}, new pvbzgon(this, 3));
                return;
            }
            return;
        }
        if (!jdqigmr()) {
            Toast.makeText(this, R.string.error_remembered_preloader_unreadable, 1).show();
            return;
        }
        if (this.nsyqsfj) {
            Toast.makeText(this, R.string.error_gui_ready, 0).show();
            return;
        }
        if (this.gzokllk) {
            Toast.makeText(this, R.string.error_gui_connecting, 0).show();
            return;
        }
        if (this.lataqgm) {
            Toast.makeText(this, R.string.error_return_home, 0).show();
            return;
        }
        this.jvtqflj = null;
        this.qwgjehf = true;
        this.bgmsltp++;
        this.wygqgxb = this.bgmsltp;
        this.yjbrzgu = 0;
        nmpwovh(getString(R.string.gui_start_requested));
        gefzxcg();
        if (!this.wfxzfba) {
            this.wfxzfba = true;
            dkpobjg();
            return;
        }
        UsbDevice usbDevice = this.ulafhci;
        if (qyeibyo()) {
            ygdccqg();
        } else if (usbDevice != null) {
            hhqpjvl(usbDevice);
        } else {
            cgcdpmq();
        }
    }

    public final void nysvajy() {
        qxvquar qxvquarVar = this.seujokk;
        if (qxvquarVar == null) {
            return;
        }
        boolean z = this.nsyqsfj;
        boolean z2 = this.gzokllk;
        boolean z3 = this.lpkdqgx;
        boolean z4 = this.ywhgqsi;
        boolean z5 = true;
        boolean z6 = this.nxumtuo || this.dvzxbaj;
        if (!z && !z2 && !z3 && !z4 && !z6) {
            z5 = false;
        }
        qxvquarVar.nmpwovh(z5);
    }

    public final void odhctch() {
        if (!this.nsyqsfj) {
            this.rrpfqyy = "";
            iilntfn iilntfnVar = this.pmsrvoc;
            if (iilntfnVar != null) {
                iilntfnVar.lthborb(getString(this.gzokllk ? R.string.error_da_connecting : R.string.error_wait_da_ready));
                return;
            }
            return;
        }
        if (this.lpkdqgx || this.gzokllk) {
            Toast.makeText(this, R.string.error_busy, 0).show();
            return;
        }
        if (!qyeibyo()) {
            iilntfn iilntfnVar2 = this.pmsrvoc;
            if (iilntfnVar2 != null) {
                iilntfnVar2.lthborb(getString(R.string.error_usb_unavailable));
                return;
            }
            return;
        }
        iilntfn iilntfnVar3 = this.pmsrvoc;
        if (iilntfnVar3 != null) {
            iilntfnVar3.vivhedu();
        }
        String strYjbrzgu = yjbrzgu("da_path");
        String strYjbrzgu2 = yjbrzgu("auth_path");
        String strYjbrzgu3 = yjbrzgu("preloader_path");
        this.lpkdqgx = true;
        gefzxcg();
        this.slxntng.execute(new vntpaom((kggugdp) this, strYjbrzgu, strYjbrzgu2, strYjbrzgu3, 2));
    }

    public final ParcelFileDescriptor ohwxijw(int i) {
        try {
            return ParcelFileDescriptor.fromFd(i);
        } catch (IOException e) {
            fusjbbl("ERROR: unable to retain Fastboot USB connection: " + e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009a A[Catch: all -> 0x013d, TryCatch #2 {all -> 0x013d, blocks: (B:31:0x0073, B:33:0x007f, B:35:0x008e, B:37:0x0094, B:38:0x009a, B:40:0x00a6, B:42:0x00ac, B:45:0x00b8, B:48:0x00c4, B:50:0x00c8, B:52:0x00cb, B:54:0x00d0, B:56:0x00d6, B:58:0x00ed, B:60:0x00f8, B:62:0x00fe, B:57:0x00db, B:63:0x0103, B:65:0x0109, B:67:0x0111, B:68:0x0117, B:70:0x011f, B:71:0x0124, B:73:0x0133, B:75:0x0139), top: B:141:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a6 A[Catch: all -> 0x013d, TryCatch #2 {all -> 0x013d, blocks: (B:31:0x0073, B:33:0x007f, B:35:0x008e, B:37:0x0094, B:38:0x009a, B:40:0x00a6, B:42:0x00ac, B:45:0x00b8, B:48:0x00c4, B:50:0x00c8, B:52:0x00cb, B:54:0x00d0, B:56:0x00d6, B:58:0x00ed, B:60:0x00f8, B:62:0x00fe, B:57:0x00db, B:63:0x0103, B:65:0x0109, B:67:0x0111, B:68:0x0117, B:70:0x011f, B:71:0x0124, B:73:0x0133, B:75:0x0139), top: B:141:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00c4 A[Catch: all -> 0x013d, TRY_ENTER, TryCatch #2 {all -> 0x013d, blocks: (B:31:0x0073, B:33:0x007f, B:35:0x008e, B:37:0x0094, B:38:0x009a, B:40:0x00a6, B:42:0x00ac, B:45:0x00b8, B:48:0x00c4, B:50:0x00c8, B:52:0x00cb, B:54:0x00d0, B:56:0x00d6, B:58:0x00ed, B:60:0x00f8, B:62:0x00fe, B:57:0x00db, B:63:0x0103, B:65:0x0109, B:67:0x0111, B:68:0x0117, B:70:0x011f, B:71:0x0124, B:73:0x0133, B:75:0x0139), top: B:141:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00cb A[Catch: all -> 0x013d, TryCatch #2 {all -> 0x013d, blocks: (B:31:0x0073, B:33:0x007f, B:35:0x008e, B:37:0x0094, B:38:0x009a, B:40:0x00a6, B:42:0x00ac, B:45:0x00b8, B:48:0x00c4, B:50:0x00c8, B:52:0x00cb, B:54:0x00d0, B:56:0x00d6, B:58:0x00ed, B:60:0x00f8, B:62:0x00fe, B:57:0x00db, B:63:0x0103, B:65:0x0109, B:67:0x0111, B:68:0x0117, B:70:0x011f, B:71:0x0124, B:73:0x0133, B:75:0x0139), top: B:141:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d6 A[Catch: all -> 0x013d, TryCatch #2 {all -> 0x013d, blocks: (B:31:0x0073, B:33:0x007f, B:35:0x008e, B:37:0x0094, B:38:0x009a, B:40:0x00a6, B:42:0x00ac, B:45:0x00b8, B:48:0x00c4, B:50:0x00c8, B:52:0x00cb, B:54:0x00d0, B:56:0x00d6, B:58:0x00ed, B:60:0x00f8, B:62:0x00fe, B:57:0x00db, B:63:0x0103, B:65:0x0109, B:67:0x0111, B:68:0x0117, B:70:0x011f, B:71:0x0124, B:73:0x0133, B:75:0x0139), top: B:141:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00db A[Catch: all -> 0x013d, TryCatch #2 {all -> 0x013d, blocks: (B:31:0x0073, B:33:0x007f, B:35:0x008e, B:37:0x0094, B:38:0x009a, B:40:0x00a6, B:42:0x00ac, B:45:0x00b8, B:48:0x00c4, B:50:0x00c8, B:52:0x00cb, B:54:0x00d0, B:56:0x00d6, B:58:0x00ed, B:60:0x00f8, B:62:0x00fe, B:57:0x00db, B:63:0x0103, B:65:0x0109, B:67:0x0111, B:68:0x0117, B:70:0x011f, B:71:0x0124, B:73:0x0133, B:75:0x0139), top: B:141:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0103 A[Catch: all -> 0x013d, TryCatch #2 {all -> 0x013d, blocks: (B:31:0x0073, B:33:0x007f, B:35:0x008e, B:37:0x0094, B:38:0x009a, B:40:0x00a6, B:42:0x00ac, B:45:0x00b8, B:48:0x00c4, B:50:0x00c8, B:52:0x00cb, B:54:0x00d0, B:56:0x00d6, B:58:0x00ed, B:60:0x00f8, B:62:0x00fe, B:57:0x00db, B:63:0x0103, B:65:0x0109, B:67:0x0111, B:68:0x0117, B:70:0x011f, B:71:0x0124, B:73:0x0133, B:75:0x0139), top: B:141:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0109 A[Catch: all -> 0x013d, TryCatch #2 {all -> 0x013d, blocks: (B:31:0x0073, B:33:0x007f, B:35:0x008e, B:37:0x0094, B:38:0x009a, B:40:0x00a6, B:42:0x00ac, B:45:0x00b8, B:48:0x00c4, B:50:0x00c8, B:52:0x00cb, B:54:0x00d0, B:56:0x00d6, B:58:0x00ed, B:60:0x00f8, B:62:0x00fe, B:57:0x00db, B:63:0x0103, B:65:0x0109, B:67:0x0111, B:68:0x0117, B:70:0x011f, B:71:0x0124, B:73:0x0133, B:75:0x0139), top: B:141:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x011f A[Catch: all -> 0x013d, LOOP:0: B:68:0x0117->B:70:0x011f, LOOP_END, TryCatch #2 {all -> 0x013d, blocks: (B:31:0x0073, B:33:0x007f, B:35:0x008e, B:37:0x0094, B:38:0x009a, B:40:0x00a6, B:42:0x00ac, B:45:0x00b8, B:48:0x00c4, B:50:0x00c8, B:52:0x00cb, B:54:0x00d0, B:56:0x00d6, B:58:0x00ed, B:60:0x00f8, B:62:0x00fe, B:57:0x00db, B:63:0x0103, B:65:0x0109, B:67:0x0111, B:68:0x0117, B:70:0x011f, B:71:0x0124, B:73:0x0133, B:75:0x0139), top: B:141:0x0073 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0133 A[Catch: all -> 0x013d, TryCatch #2 {all -> 0x013d, blocks: (B:31:0x0073, B:33:0x007f, B:35:0x008e, B:37:0x0094, B:38:0x009a, B:40:0x00a6, B:42:0x00ac, B:45:0x00b8, B:48:0x00c4, B:50:0x00c8, B:52:0x00cb, B:54:0x00d0, B:56:0x00d6, B:58:0x00ed, B:60:0x00f8, B:62:0x00fe, B:57:0x00db, B:63:0x0103, B:65:0x0109, B:67:0x0111, B:68:0x0117, B:70:0x011f, B:71:0x0124, B:73:0x0133, B:75:0x0139), top: B:141:0x0073 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:57:0x00db, please report this as an issue */
    @Override // com.rynx.app.ojyssqt, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        String path;
        int iIndexOf = -1;
        String strSubstring;
        File file;
        String treeDocumentId;
        String[] strArrSplit;
        String str;
        String str2;
        File file2;
        File file3;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || intent == null) {
            return;
        }
        if (i == 4107) {
            if (intent.getData() != null) {
                File filePrywqjr = prywqjr(intent.getData());
                if (filePrywqjr != null) {
                    ftrcqfq(filePrywqjr);
                    return;
                } else {
                    Toast.makeText(this, R.string.scatter_file_not_real, 1).show();
                    gzokllk();
                    return;
                }
            }
            return;
        }
        if (i == 4105) {
            if (intent.getData() != null) {
                File filePrywqjr2 = prywqjr(intent.getData());
                if (filePrywqjr2 != null) {
                    eqqqfvj(filePrywqjr2);
                    return;
                }
                this.yrgokys = -1;
                Toast.makeText(this, R.string.error_use_selected_image, 1).show();
                hknanqb();
                return;
            }
            return;
        }
        if (i != 4106) {
            if (intent.getData() == null) {
                return;
            }
            Uri data = intent.getData();
            if (i == 4103) {
                File filePrywqjr3 = prywqjr(data);
                if (filePrywqjr3 != null) {
                    fprgbbe(filePrywqjr3);
                    return;
                } else {
                    Toast.makeText(this, R.string.error_use_selected_image, 1).show();
                    return;
                }
            }
            if (i == 4108) {
                try {
                    String strPvkaerr = com.rynx.app.ojyssqt.pvkaerr(duxkmyb(data));
                    if (!com.rynx.app.ojyssqt.gisppfs(strPvkaerr)) {
                        nmpwovh(getString(R.string.log_preloader_extension_rejected, strPvkaerr));
                        Toast.makeText(this, R.string.error_preloader_must_be_bin, 1).show();
                        return;
                    }
                    File fileVhimehb = vhimehb(data, "selected-preloader", "preloader-", "preloader");
                    if (!fileVhimehb.isFile() || !fileVhimehb.canRead() || fileVhimehb.length() <= 0) {
                        throw new IOException(getString(R.string.error_read_selected_preloader));
                    }
                    rpilpcp();
                    lcgzsis(fileVhimehb.getAbsolutePath(), strPvkaerr);
                    iasgsgq(fileVhimehb, "selected-preloader");
                    nmpwovh(getString(R.string.gui_preloader_selected, strPvkaerr));
                    Toast.makeText(this, getString(R.string.gui_preloader_selected_toast, strPvkaerr), 0).show();
                    gefzxcg();
                    return;
                } catch (Throwable th) {
                    nmpwovh(getString(R.string.log_preloader_import_error, String.valueOf(th.getMessage())));
                    Toast.makeText(this, R.string.error_read_selected_preloader, 1).show();
                    return;
                }
            }
            if (i == 4104) {
                try {
                    ecffprn(vhimehb(data, "selected-auth", "auth-", "AUTH"), duxkmyb(data));
                    return;
                } catch (Throwable th2) {
                    nmpwovh(getString(R.string.log_auth_realpath_error, th2.getMessage()));
                    Toast.makeText(this, R.string.error_read_selected_auth, 1).show();
                    return;
                }
            }
            if (i != 4101) {
                return;
            }
            try {
                String strPvkaerr2 = com.rynx.app.ojyssqt.pvkaerr(duxkmyb(data));
                if (!com.rynx.app.ojyssqt.gisppfs(strPvkaerr2)) {
                    nmpwovh(getString(R.string.log_da_extension_rejected, strPvkaerr2));
                    Toast.makeText(this, R.string.error_da_must_be_bin, 1).show();
                    return;
                }
                File fileVhimehb2 = vhimehb(data, "selected-da", "da-", "DA");
                if (!fileVhimehb2.isFile() || !fileVhimehb2.canRead() || fileVhimehb2.length() <= 0) {
                    throw new IOException(getString(R.string.error_read_selected_da));
                }
                rpilpcp();
                mccfjlr(fileVhimehb2.getAbsolutePath(), strPvkaerr2, yjbrzgu("auth_path"), yjbrzgu("preloader_path"));
                iasgsgq(fileVhimehb2, "selected-da");
                nmpwovh(getString(R.string.gui_da_selected, strPvkaerr2));
                Toast.makeText(this, getString(R.string.gui_da_selected_toast, strPvkaerr2), 0).show();
                bgmsltp();
                ivvkvsj();
                return;
            } catch (Throwable th3) {
                nmpwovh(getString(R.string.log_da_import_error, String.valueOf(th3.getMessage())));
                Toast.makeText(this, R.string.error_read_selected_da, 1).show();
                return;
            }
        }
        if (intent.getData() != null) {
            Uri data2 = intent.getData();
            File fileGisppfs = null;
            if (data2 != null) {
                try {
                    if ("file".equalsIgnoreCase(data2.getScheme())) {
                        File file4 = new File(data2.getPath());
                        if (file4.isDirectory() && file4.canRead()) {
                            fileGisppfs = x.zamkzqg.gisppfs(file4);
                        } else if ("com.android.externalstorage.documents".equals(data2.getAuthority())) {
                            treeDocumentId = DocumentsContract.getTreeDocumentId(data2);
                            if (treeDocumentId != null && !treeDocumentId.trim().isEmpty()) {
                                strArrSplit = treeDocumentId.split(":", 2);
                                if (strArrSplit.length > 0) {
                                    str = strArrSplit[0];
                                } else {
                                    str = "primary";
                                }
                                if (strArrSplit.length > 1) {
                                    str2 = strArrSplit[1];
                                } else {
                                    str2 = "";
                                }
                                if ("primary".equalsIgnoreCase(str)) {
                                    file2 = Environment.getExternalStorageDirectory();
                                } else {
                                    file2 = new File("/storage/" + str);
                                }
                                file3 = new File(file2, str2);
                                if (file3.isDirectory() || !file3.canRead()) {
                                    path = data2.getPath();
                                    if (path != null) {
                                        strSubstring = path.substring(iIndexOf + 8);
                                        while (strSubstring.startsWith("/")) {
                                            strSubstring = strSubstring.substring(1);
                                        }
                                        file = new File(Environment.getExternalStorageDirectory(), strSubstring);
                                        if (file.isDirectory()) {
                                            fileGisppfs = x.zamkzqg.gisppfs(file);
                                        }
                                    }
                                } else {
                                    fileGisppfs = x.zamkzqg.gisppfs(file3);
                                }
                            }
                        } else {
                            path = data2.getPath();
                            if (path != null && (iIndexOf = path.indexOf("primary:")) >= 0) {
                                strSubstring = path.substring(iIndexOf + 8);
                                while (strSubstring.startsWith("/")) {
                                    strSubstring = strSubstring.substring(1);
                                }
                                file = new File(Environment.getExternalStorageDirectory(), strSubstring);
                                if (file.isDirectory() && file.canRead()) {
                                    fileGisppfs = x.zamkzqg.gisppfs(file);
                                }
                            }
                        }
                    } else if ("com.android.externalstorage.documents".equals(data2.getAuthority())) {
                        path = data2.getPath();
                        if (path != null) {
                            strSubstring = path.substring(iIndexOf + 8);
                            while (strSubstring.startsWith("/")) {
                                strSubstring = strSubstring.substring(1);
                            }
                            file = new File(Environment.getExternalStorageDirectory(), strSubstring);
                            if (file.isDirectory()) {
                                fileGisppfs = x.zamkzqg.gisppfs(file);
                            }
                        }
                    } else {
                        treeDocumentId = DocumentsContract.getTreeDocumentId(data2);
                        if (treeDocumentId != null) {
                            strArrSplit = treeDocumentId.split(":", 2);
                            if (strArrSplit.length > 0) {
                                str = strArrSplit[0];
                            } else {
                                str = "primary";
                            }
                            if (strArrSplit.length > 1) {
                                str2 = strArrSplit[1];
                            } else {
                                str2 = "";
                            }
                            if ("primary".equalsIgnoreCase(str)) {
                                file2 = Environment.getExternalStorageDirectory();
                            } else {
                                file2 = new File("/storage/" + str);
                            }
                            file3 = new File(file2, str2);
                            if (file3.isDirectory()) {
                                path = data2.getPath();
                                if (path != null) {
                                    strSubstring = path.substring(iIndexOf + 8);
                                    while (strSubstring.startsWith("/")) {
                                        strSubstring = strSubstring.substring(1);
                                    }
                                    file = new File(Environment.getExternalStorageDirectory(), strSubstring);
                                    if (file.isDirectory()) {
                                        fileGisppfs = x.zamkzqg.gisppfs(file);
                                    }
                                }
                            } else {
                                path = data2.getPath();
                                if (path != null) {
                                    strSubstring = path.substring(iIndexOf + 8);
                                    while (strSubstring.startsWith("/")) {
                                        strSubstring = strSubstring.substring(1);
                                    }
                                    file = new File(Environment.getExternalStorageDirectory(), strSubstring);
                                    if (file.isDirectory()) {
                                        fileGisppfs = x.zamkzqg.gisppfs(file);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            if (fileGisppfs != null) {
                nuoqzvr(fileGisppfs);
            } else {
                Toast.makeText(this, R.string.batch_flash_folder_not_real, 1).show();
                hknanqb();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        cszfvxh();
        jtfjrri(false);
        ccuulnt ccuulntVar = this.suqlntg;
        if (ccuulntVar != null) {
            boolean zEquals = "android_tools".equals(this.ayzlrnr);
            ccuulntVar.qxvquar = zEquals;
            if (zEquals) {
                ccuulntVar.nmpwovh(true);
            }
            if ("android_tools".equals(this.ayzlrnr)) {
                this.suqlntg.nmpwovh(true);
            }
        }
    }

    @Override // com.rynx.app.ojyssqt, android.app.Activity
    public final void onDestroy() {
        qxvquar qxvquarVar = this.seujokk;
        if (qxvquarVar != null) {
            qxvquarVar.nmpwovh(false);
        }
        if (Build.VERSION.SDK_INT >= 33 && this.fadblxi != null) {
            try {
                getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.fadblxi);
            } catch (Throwable unused) {
            }
            this.fadblxi = null;
        }
        this.gepzcpd++;
        this.qppdydr = true;
        try {
            AdbFastbootNative.nmpwovh();
        } catch (Throwable unused2) {
        }
        Future future = this.zftrkmx;
        this.zftrkmx = null;
        if (future != null) {
            future.cancel(true);
        }
        this.nxumtuo = false;
        this.dvzxbaj = false;
        if (this.pvkaerr) {
            try {
                nativeCancelIo();
            } catch (Throwable unused3) {
            }
            if (this.lpkdqgx || this.gzokllk) {
                Thread thread = new Thread(new yrgokys(this, 12), "rynx-native-disconnect");
                thread.setDaemon(true);
                thread.start();
            } else {
                try {
                    nativeDisconnectSession();
                } catch (Throwable unused4) {
                }
            }
            this.nsyqsfj = false;
        }
        nkemejx();
        this.nnkxxji++;
        Future future2 = this.iivesaq;
        this.iivesaq = null;
        if (future2 != null) {
            future2.cancel(true);
        }
        this.yztlqms = false;
        this.iqvvlnh = null;
        this.nysvajy = null;
        this.hiofinr++;
        Future future3 = this.czgynww;
        this.czgynww = null;
        if (future3 != null) {
            future3.cancel(true);
        }
        this.xhyvkax = false;
        this.jcyrpko = Collections.emptyList();
        this.laodqsm = null;
        this.zfmpmio.shutdownNow();
        this.ziuhthw.shutdownNow();
        this.slxntng.shutdownNow();
        this.czidoiw.shutdownNow();
        ijakhcl();
        try {
            unregisterReceiver(this.neppdxk);
        } catch (Exception unused5) {
        }
        super.onDestroy();
    }

    public void onNativeLog(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (this.tmdubwv) {
            synchronized (this.ibfmasn) {
                try {
                    if (this.tmdubwv) {
                        for (String str2 : str.replace("\r", "").split("\n")) {
                            if (!str2.isEmpty()) {
                                ArrayDeque arrayDeque = this.cugubfc;
                                if (str2.length() > 600) {
                                    str2 = str2.substring(0, 600) + " [line truncated]";
                                }
                                arrayDeque.addLast(str2);
                                while (this.cugubfc.size() > 48) {
                                    this.cugubfc.removeFirst();
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        runOnUiThread(new pzkwhtn(this, str, this.otaqyat, 0));
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 4102) {
            bgmsltp();
        }
    }

    @Override // com.rynx.app.nmpwovh, com.rynx.app.ojyssqt, android.app.Activity
    public final void onResume() {
        super.onResume();
        fadblxi();
    }

    public final void otaqyat(String str) {
        UsbDevice usbDevice = this.ulafhci;
        if (x.zamkzqg.nsyqsfj(usbDevice) != 2) {
            Toast.makeText(this, R.string.android_tools_adb_only, 0).show();
            fusjbbl("ERROR: no device in ADB mode");
            return;
        }
        String strTrim = str == null ? "" : str.trim();
        if (strTrim.isEmpty()) {
            Toast.makeText(this, R.string.android_tools_adb_shell_empty, 0).show();
            fusjbbl("Usage: adb shell <command>");
            return;
        }
        if (this.nxumtuo || this.dvzxbaj || this.lpkdqgx || this.gzokllk || this.nsyqsfj) {
            Toast.makeText(this, R.string.android_tools_busy, 0).show();
            fusjbbl("ERROR: USB transport is busy");
            return;
        }
        if (!this.dplrlfq.hasPermission(usbDevice) || !qyeibyo()) {
            hhqpjvl(usbDevice);
            Toast.makeText(this, R.string.android_tools_permission, 0).show();
            fusjbbl("USB permission/open required. Approve the Android USB prompt and retry.");
            return;
        }
        UsbDeviceConnection usbDeviceConnectionCzgynww = czgynww(usbDevice);
        if (usbDeviceConnectionCzgynww == null) {
            wfxzfba(false);
            return;
        }
        this.nxumtuo = true;
        long j = 1 + this.gepzcpd;
        this.gepzcpd = j;
        gdkopre();
        jybecxv jybecxvVar = this.ltnesel;
        if (jybecxvVar != null) {
            jybecxvVar.vivhedu.setText(R.string.android_tools_adb_shell_running);
            this.ltnesel.vivhedu.setTextColor(this.oqexvyb);
        }
        nmpwovh("[ADB] $ ".concat(strTrim));
        pcbbvuj("\n");
        this.zftrkmx = this.slxntng.submit(new czidoiw(this, usbDevice, usbDeviceConnectionCzgynww, strTrim, j, 1));
    }

    public final String oxoagud(String str) {
        if (str == null) {
            return "";
        }
        File file = new File(str);
        return (file.getParentFile() == null || !file.getParentFile().equals(getCacheDir())) ? str : file.getName();
    }

    public final void pcbbvuj(String str) {
        ccuulnt ccuulntVar = this.suqlntg;
        ccuulntVar.getClass();
        if (str.isEmpty()) {
            return;
        }
        synchronized (ccuulntVar) {
            ccuulntVar.nmpwovh.append(str.replace("\r\n", "\n").replace('\r', '\n'));
            ccuulntVar.ojyssqt();
        }
        ccuulntVar.nmpwovh(false);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00ae A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:5:0x0007, B:7:0x0013, B:10:0x0020, B:12:0x0027, B:14:0x0037, B:18:0x0044, B:20:0x0048, B:22:0x004b, B:24:0x0050, B:26:0x0056, B:28:0x006d, B:30:0x0078, B:32:0x007e, B:27:0x005b, B:33:0x0084, B:36:0x008e, B:38:0x0096, B:39:0x00a1, B:42:0x00ae, B:44:0x00b6, B:47:0x00c1, B:50:0x00cc, B:52:0x00d2, B:54:0x00da, B:55:0x00e0, B:57:0x00e8, B:58:0x00ed, B:60:0x00fc, B:62:0x0102), top: B:66:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c1 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:5:0x0007, B:7:0x0013, B:10:0x0020, B:12:0x0027, B:14:0x0037, B:18:0x0044, B:20:0x0048, B:22:0x004b, B:24:0x0050, B:26:0x0056, B:28:0x006d, B:30:0x0078, B:32:0x007e, B:27:0x005b, B:33:0x0084, B:36:0x008e, B:38:0x0096, B:39:0x00a1, B:42:0x00ae, B:44:0x00b6, B:47:0x00c1, B:50:0x00cc, B:52:0x00d2, B:54:0x00da, B:55:0x00e0, B:57:0x00e8, B:58:0x00ed, B:60:0x00fc, B:62:0x0102), top: B:66:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cc A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:5:0x0007, B:7:0x0013, B:10:0x0020, B:12:0x0027, B:14:0x0037, B:18:0x0044, B:20:0x0048, B:22:0x004b, B:24:0x0050, B:26:0x0056, B:28:0x006d, B:30:0x0078, B:32:0x007e, B:27:0x005b, B:33:0x0084, B:36:0x008e, B:38:0x0096, B:39:0x00a1, B:42:0x00ae, B:44:0x00b6, B:47:0x00c1, B:50:0x00cc, B:52:0x00d2, B:54:0x00da, B:55:0x00e0, B:57:0x00e8, B:58:0x00ed, B:60:0x00fc, B:62:0x0102), top: B:66:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00d2 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:5:0x0007, B:7:0x0013, B:10:0x0020, B:12:0x0027, B:14:0x0037, B:18:0x0044, B:20:0x0048, B:22:0x004b, B:24:0x0050, B:26:0x0056, B:28:0x006d, B:30:0x0078, B:32:0x007e, B:27:0x005b, B:33:0x0084, B:36:0x008e, B:38:0x0096, B:39:0x00a1, B:42:0x00ae, B:44:0x00b6, B:47:0x00c1, B:50:0x00cc, B:52:0x00d2, B:54:0x00da, B:55:0x00e0, B:57:0x00e8, B:58:0x00ed, B:60:0x00fc, B:62:0x0102), top: B:66:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:72:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public final File prywqjr(Uri uri) {
        File fileUdgizdi;
        String path;
        int iIndexOf;
        File file;
        if (uri == null) {
            return null;
        }
        try {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return x.zamkzqg.udgizdi(uri.getPath());
            }
            if (DocumentsContract.isDocumentUri(this, uri)) {
                String authority = uri.getAuthority();
                String documentId = DocumentsContract.getDocumentId(uri);
                if ("com.android.externalstorage.documents".equals(authority)) {
                    String[] strArrSplit = documentId.split(":", 2);
                    String str = strArrSplit.length > 0 ? strArrSplit[0] : "primary";
                    String str2 = strArrSplit.length > 1 ? strArrSplit[1] : "";
                    if ("primary".equalsIgnoreCase(str)) {
                        file = Environment.getExternalStorageDirectory();
                    } else {
                        file = new File("/storage/" + str);
                    }
                    File file2 = new File(file, str2);
                    if (file2.isFile() && file2.canRead()) {
                        return x.zamkzqg.gisppfs(file2);
                    }
                }
                if ("com.android.providers.downloads.documents".equals(authority)) {
                    if (documentId != null && documentId.startsWith("raw:")) {
                        return x.zamkzqg.udgizdi(documentId.substring(4));
                    }
                    fileUdgizdi = x.zamkzqg.udgizdi(x.zamkzqg.nuoqzvr(this, uri));
                    if (fileUdgizdi == null) {
                        if ("com.android.providers.media.documents".equals(authority)) {
                            fileUdgizdi = x.zamkzqg.udgizdi(x.zamkzqg.nuoqzvr(this, uri));
                            if (fileUdgizdi != null) {
                                path = uri.getPath();
                                if (path != null) {
                                    return null;
                                }
                                return null;
                            }
                        } else {
                            fileUdgizdi = x.zamkzqg.udgizdi(x.zamkzqg.nuoqzvr(this, uri));
                            if (fileUdgizdi != null) {
                                path = uri.getPath();
                                if (path != null) {
                                    return null;
                                }
                                return null;
                            }
                        }
                    }
                } else if ("com.android.providers.media.documents".equals(authority) || (fileUdgizdi = x.zamkzqg.udgizdi(x.zamkzqg.nuoqzvr(this, uri))) == null) {
                    fileUdgizdi = x.zamkzqg.udgizdi(x.zamkzqg.nuoqzvr(this, uri));
                    if (fileUdgizdi != null) {
                        path = uri.getPath();
                        if (path != null || (iIndexOf = path.indexOf("primary:")) < 0) {
                            return null;
                        }
                        String strSubstring = path.substring(iIndexOf + 8);
                        while (strSubstring.startsWith("/")) {
                            strSubstring = strSubstring.substring(1);
                        }
                        File file3 = new File(Environment.getExternalStorageDirectory(), strSubstring);
                        if (file3.isFile() && file3.canRead()) {
                            return x.zamkzqg.gisppfs(file3);
                        }
                        return null;
                    }
                }
            } else {
                fileUdgizdi = x.zamkzqg.udgizdi(x.zamkzqg.nuoqzvr(this, uri));
                if (fileUdgizdi != null) {
                    path = uri.getPath();
                    if (path != null) {
                        return null;
                    }
                    return null;
                }
            }
            return fileUdgizdi;
        } catch (Throwable th) {
            nmpwovh(getString(R.string.terminal_parse_error, getString(R.string.terminal_realpath_error, th.getMessage())));
            return null;
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final boolean pvbzgon() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public final File pwjmwpv(String str) {
        if (this.gzvolsx == null) {
            this.gzvolsx = new File("/storage/emulated/0");
        }
        if (str == null || str.isEmpty() || ".".equals(str)) {
            return x.zamkzqg.gisppfs(this.gzvolsx);
        }
        if ("~".equals(str) || "/sdcard".equals(str)) {
            return new File("/storage/emulated/0");
        }
        if (str.startsWith("~/")) {
            str = "/storage/emulated/0/" + str.substring(2);
        }
        if (str.startsWith("/sdcard/")) {
            str = "/storage/emulated/0/" + str.substring(8);
        }
        File file = new File(str);
        if (!file.isAbsolute()) {
            file = new File(this.gzvolsx, str);
        }
        return x.zamkzqg.gisppfs(file);
    }

    public final void pwnmyid() {
        if (this.ltnesel == null) {
            return;
        }
        String string = getString(R.string.value_not_available);
        this.ltnesel.dytyqos.setText(string);
        this.ltnesel.wqrnifx.setText(string);
        this.ltnesel.dasxvpc.setText(string);
        this.ltnesel.dplrlfq.setText(string);
        this.ltnesel.ulafhci.setText(string);
        this.ltnesel.ekyqleu.setText(string);
    }

    public final void pzkwhtn(String str, String str2, Runnable runnable) {
        new AlertDialog.Builder(this).setTitle(str).setMessage(str2).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton("Run", new nsyqsfj(runnable, 0)).show();
    }

    public final JSONArray qwpvrdy() {
        String str = "[]";
        String string = getSharedPreferences("xiaomi_auth_pending_ack", 0).getString("queue_json", "[]");
        try {
            if (string != null) {
                str = string;
            }
            return new JSONArray(str);
        } catch (Throwable unused) {
            return new JSONArray();
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final boolean qyeibyo() {
        boolean z;
        synchronized (this.atntgcp) {
            try {
                z = (this.ekyqleu == null || this.ulafhci == null || !dytyqos(this.ulafhci)) ? false : true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00db  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:64:0x0102 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x0104  */
    /* JADX WARN: Code duplicated, block: B:66:0x0108  */
    /* JADX WARN: Code duplicated, block: B:72:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String requestManualBromSlaResponse(String str) {
        long j = 0L;
        boolean z;
        boolean z2 = false;
        boolean z3;
        int i;
        if (!useManualBromSlaForSelectedDa()) {
            return null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            nmpwovh("[SLA] ERROR: Manual BROM SLA cannot block the Android UI thread.");
            return null;
        }
        String strReplaceAll = str == null ? "" : str.replaceAll("\\s+", "");
        if (strReplaceAll.startsWith("0x") || strReplaceAll.startsWith("0X")) {
            strReplaceAll = strReplaceAll.substring(2);
        }
        if (com.rynx.app.ojyssqt.qxvquar(strReplaceAll) == null) {
            runOnUiThread(new yrgokys(this, 2));
            return null;
        }
        String upperCase = strReplaceAll.toUpperCase(Locale.ROOT);
        int i2 = this.bgmsltp;
        UsbDevice usbDevice = this.ulafhci;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Object obj = new Object();
        boolean[] zArr = {true};
        String[] strArr = {null};
        Dialog[] dialogArr = {null};
        runOnUiThread(new lpkdqgx(this, obj, zArr, dialogArr, upperCase, strArr, countDownLatch));
        while (true) {
            long j2 = j - 1;
            if (j > 0) {
                try {
                    if (!countDownLatch.await(1L, TimeUnit.SECONDS)) {
                        j = (i2 == this.bgmsltp && this.qwgjehf && this.ulafhci == usbDevice) ? j2 : 900L;
                        z2 = true;
                    }
                    if (!z2 || countDownLatch.getCount() == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    z = false;
                    z2 = true;
                }
                if (!z2 || (i2 == this.bgmsltp && this.qwgjehf && this.ulafhci == usbDevice)) {
                    z3 = z2;
                } else {
                    z3 = true;
                }
                if (z3 || z) {
                    synchronized (obj) {
                        zArr[0] = false;
                        strArr[0] = null;
                    }
                    runOnUiThread(new eigllth(dialogArr, 4));
                }
                if (strArr[0] != null) {
                    runOnUiThread(new yrgokys(this, 3));
                    return strArr[0];
                }
                if (z) {
                    i = R.string.sla_brom_manual_timeout;
                } else if (z3) {
                    i = R.string.sla_brom_manual_stopped;
                } else {
                    i = R.string.sla_brom_manual_cancelled;
                }
                runOnUiThread(new wdznaie(this, i, 0));
                return null;
            }
            z2 = false;
            if (z2) {
                z = false;
            } else {
                z = false;
            }
            if (z2) {
                z3 = z2;
            } else {
                z3 = z2;
            }
            if (z3) {
                synchronized (obj) {
                    zArr[0] = false;
                    strArr[0] = null;
                    runOnUiThread(new eigllth(dialogArr, 4));
                }
            } else {
                synchronized (obj) {
                    zArr[0] = false;
                    strArr[0] = null;
                    runOnUiThread(new eigllth(dialogArr, 4));
                }
            }
            if (strArr[0] != null) {
                runOnUiThread(new yrgokys(this, 3));
                return strArr[0];
            }
            if (z) {
                i = R.string.sla_brom_manual_timeout;
            } else if (z3) {
                i = R.string.sla_brom_manual_stopped;
            } else {
                i = R.string.sla_brom_manual_cancelled;
            }
            runOnUiThread(new wdznaie(this, i, 0));
            return null;
        }
    }

    public String requestSlaCredentials(String str) {
        String str2;
        boolean z = "BROM_NEW_SECURITY".equalsIgnoreCase(str) || ("BROM".equalsIgnoreCase(str) && rrpfqyy() && kggugdp());
        String str3 = "DA".equalsIgnoreCase(str) ? "DA" : "BROM";
        boolean z2 = (!"BROM".equals(str3) || this.laodqsm == null || kggugdp()) ? false : true;
        if (z) {
            String strDreanqi = (rrpfqyy() && kggugdp()) ? dreanqi() : null;
            if (strDreanqi != null) {
                runOnUiThread(new yrgokys(this, 6));
                return strDreanqi;
            }
            runOnUiThread(new yrgokys(this, 7));
            return null;
        }
        if (z2) {
            String strDreanqi2 = dreanqi();
            if (strDreanqi2 != null) {
                runOnUiThread(new yrgokys(this, 8));
                return strDreanqi2;
            }
            runOnUiThread(new yrgokys(this, 9));
            return null;
        }
        synchronized (this.sthdtww) {
            try {
                if (!this.hhqpjvl.isEmpty() && !this.wjugzfh.isEmpty()) {
                    nmpwovh("[SLA] Using credentials already prepared in RAM.");
                    return this.hhqpjvl + "\n" + this.wjugzfh;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                String[] strArr = new String[2];
                runOnUiThread(new hhqpjvl(this, str3, yrgokys(str3), strArr, countDownLatch, 3));
                try {
                    if (!countDownLatch.await(180L, TimeUnit.SECONDS)) {
                        runOnUiThread(new yrgokys(this, 1));
                        return null;
                    }
                    String str4 = strArr[0];
                    if (str4 == null || str4.isEmpty() || (str2 = strArr[1]) == null || str2.isEmpty()) {
                        return null;
                    }
                    return strArr[0] + "\n" + strArr[1];
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void rpilpcp() {
        this.ivvkvsj = false;
        this.qwgjehf = false;
        this.bgmsltp++;
        if (this.wdznaie != null) {
            this.iasgsgq = true;
        }
        if (this.nsyqsfj || this.gzokllk || qyeibyo()) {
            try {
                nativeDisconnectSession();
            } catch (Throwable unused) {
            }
            this.nsyqsfj = false;
            this.gzokllk = false;
            this.cnctlxz = x.ednetju.ojyssqt();
            this.xvxmcgn = "—";
            this.jbmzxye.clear();
            this.ezuzoct = null;
            nkemejx();
        }
    }

    public int selectedXiaomiBromSecurityMode() {
        if (this.laodqsm == null) {
            return 0;
        }
        return kggugdp() ? 2 : 1;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:101:0x01da  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:105:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:108:0x01f6 A[Catch: all -> 0x019c, TryCatch #3 {all -> 0x019c, blocks: (B:78:0x016e, B:82:0x0190, B:90:0x01a8, B:94:0x01c9, B:98:0x01d2, B:102:0x01db, B:106:0x01e9, B:108:0x01f6, B:112:0x0219, B:114:0x0260, B:116:0x0270, B:118:0x0276, B:122:0x0288, B:121:0x0281, B:123:0x028e, B:126:0x0297, B:129:0x02a0, B:133:0x02ae, B:137:0x02ba, B:141:0x02c8), top: B:207:0x016e }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0214  */
    /* JADX WARN: Code duplicated, block: B:111:0x0217  */
    /* JADX WARN: Code duplicated, block: B:114:0x0260 A[Catch: all -> 0x019c, TryCatch #3 {all -> 0x019c, blocks: (B:78:0x016e, B:82:0x0190, B:90:0x01a8, B:94:0x01c9, B:98:0x01d2, B:102:0x01db, B:106:0x01e9, B:108:0x01f6, B:112:0x0219, B:114:0x0260, B:116:0x0270, B:118:0x0276, B:122:0x0288, B:121:0x0281, B:123:0x028e, B:126:0x0297, B:129:0x02a0, B:133:0x02ae, B:137:0x02ba, B:141:0x02c8), top: B:207:0x016e }] */
    /* JADX WARN: Code duplicated, block: B:115:0x026a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0276 A[Catch: all -> 0x019c, TryCatch #3 {all -> 0x019c, blocks: (B:78:0x016e, B:82:0x0190, B:90:0x01a8, B:94:0x01c9, B:98:0x01d2, B:102:0x01db, B:106:0x01e9, B:108:0x01f6, B:112:0x0219, B:114:0x0260, B:116:0x0270, B:118:0x0276, B:122:0x0288, B:121:0x0281, B:123:0x028e, B:126:0x0297, B:129:0x02a0, B:133:0x02ae, B:137:0x02ba, B:141:0x02c8), top: B:207:0x016e }] */
    /* JADX WARN: Code duplicated, block: B:120:0x027c  */
    /* JADX WARN: Code duplicated, block: B:121:0x0281 A[Catch: all -> 0x019c, TryCatch #3 {all -> 0x019c, blocks: (B:78:0x016e, B:82:0x0190, B:90:0x01a8, B:94:0x01c9, B:98:0x01d2, B:102:0x01db, B:106:0x01e9, B:108:0x01f6, B:112:0x0219, B:114:0x0260, B:116:0x0270, B:118:0x0276, B:122:0x0288, B:121:0x0281, B:123:0x028e, B:126:0x0297, B:129:0x02a0, B:133:0x02ae, B:137:0x02ba, B:141:0x02c8), top: B:207:0x016e }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0295  */
    /* JADX WARN: Code duplicated, block: B:128:0x029e  */
    /* JADX WARN: Code duplicated, block: B:131:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:132:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:135:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:136:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:139:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:140:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:149:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:155:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:182:0x037a  */
    /* JADX WARN: Code duplicated, block: B:183:0x037c A[Catch: all -> 0x02eb, TryCatch #1 {all -> 0x02eb, blocks: (B:142:0x02cf, B:147:0x02dd, B:160:0x02fd, B:162:0x030b, B:165:0x032e, B:172:0x0346, B:177:0x0352, B:180:0x0367, B:184:0x038d, B:183:0x037c, B:187:0x0398), top: B:204:0x02cf }] */
    /* JADX WARN: Code duplicated, block: B:202:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:55:0x010e  */
    /* JADX WARN: Code duplicated, block: B:60:0x012b  */
    /* JADX WARN: Code duplicated, block: B:61:0x012d A[Catch: all -> 0x0163, TRY_ENTER, TryCatch #0 {all -> 0x0163, blocks: (B:57:0x011a, B:62:0x0131, B:66:0x013c, B:69:0x0147, B:74:0x015f, B:72:0x0157, B:77:0x0167, B:61:0x012d), top: B:202:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0138  */
    /* JADX WARN: Code duplicated, block: B:65:0x013a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0147 A[Catch: all -> 0x0163, TRY_ENTER, TryCatch #0 {all -> 0x0163, blocks: (B:57:0x011a, B:62:0x0131, B:66:0x013c, B:69:0x0147, B:74:0x015f, B:72:0x0157, B:77:0x0167, B:61:0x012d), top: B:202:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0154  */
    /* JADX WARN: Code duplicated, block: B:72:0x0157 A[Catch: all -> 0x0163, TryCatch #0 {all -> 0x0163, blocks: (B:57:0x011a, B:62:0x0131, B:66:0x013c, B:69:0x0147, B:74:0x015f, B:72:0x0157, B:77:0x0167, B:61:0x012d), top: B:202:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:74:0x015f A[Catch: all -> 0x0163, TryCatch #0 {all -> 0x0163, blocks: (B:57:0x011a, B:62:0x0131, B:66:0x013c, B:69:0x0147, B:74:0x015f, B:72:0x0157, B:77:0x0167, B:61:0x012d), top: B:202:0x011a }] */
    /* JADX WARN: Code duplicated, block: B:80:0x018c  */
    /* JADX WARN: Code duplicated, block: B:81:0x018f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0199  */
    /* JADX WARN: Code duplicated, block: B:87:0x01a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:89:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:93:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:97:0x01d1  */
    /* JADX WARN: Instruction removed from duplicated block: B:108:0x01f6, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:183:0x037c, please report this as an issue */
    public String sendSlaAuthorizationRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9;
        String str10;
        String str11;
        String strConcat;
        JSONObject jSONObjectWdznaie;
        String strTrim;
        String str12;
        JSONObject jSONObject;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        HttpURLConnection httpURLConnectionCxxnoho;
        int responseCode;
        String strQwgjehf;
        String str25;
        byte[] bArrQxvquar;
        String strEncodeToString;
        String str26;
        String str27;
        String str28;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        byte[] bArrQxvquar2;
        String str29 = str4;
        String str30 = str5;
        String str31 = "raw";
        String str32 = "DA".equalsIgnoreCase(str) ? "DA" : "BROM";
        if ("BROM".equals(str32) && this.laodqsm != null) {
            boolean zKggugdp = kggugdp();
            return (!zKggugdp || com.rynx.app.ojyssqt.zwaqeaz(str4)) ? zfmpmio(zKggugdp, str7, str8) : "ERR:SLA mode mismatch: selected model requires SLA_NEW";
        }
        String strMwngani = mwngani();
        HttpURLConnection httpURLConnection = null;
        if ("DA".equals(str32) && "TRANSSION".equalsIgnoreCase(strMwngani) && (bArrQxvquar2 = com.rynx.app.ojyssqt.qxvquar(str8)) != null) {
            String str33 = new String(bArrQxvquar2, StandardCharsets.UTF_8);
            str10 = "sla_profile";
            str11 = null;
            int i = 1;
            while (true) {
                if (i > 6) {
                    str9 = str31;
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                str9 = str31;
                sb.append(".0");
                String string = sb.toString();
                if (str33.contains("<sla version=\"" + string + "\">")) {
                    if (str11 == null) {
                        str11 = string;
                    }
                }
                i++;
                str31 = str9;
            }
            if (str11 == null && (!sdchfks(256, str29) || !sdchfks(16, str30) || !sdchfks(16, str6) || !sdchfks(32, str7))) {
                runOnUiThread(new yrgokys(this, 0));
                return "ERR:Malformed Transsion DA SLA challenge";
            }
            if (str11 == null) {
                strConcat = str32;
            } else {
                strConcat = "Transsion XML SLA v".concat(str11);
            }
            runOnUiThread(new utmeivs(this, strConcat, 11));
            if (com.rynx.app.ojyssqt.jxvdcpb().trim().isEmpty()) {
                runOnUiThread(new yrgokys(this, 4));
                return "ERR:SLA server is not configured";
            }
            try {
                jSONObjectWdznaie = wdznaie(str32);
                jSONObjectWdznaie.put("action", "sign");
                if (str2 == null) {
                    strTrim = "";
                } else {
                    strTrim = str2.trim();
                }
                jSONObjectWdznaie.put("email", strTrim);
                if (str3 == null) {
                    str12 = "";
                } else {
                    str12 = str3;
                }
                jSONObjectWdznaie.put("password", str12);
                if (!com.rynx.app.ojyssqt.zwaqeaz(str7)) {
                    jSONObjectWdznaie.put("device_id", str7);
                    jSONObjectOptJSONObject2 = jSONObjectWdznaie.optJSONObject("device_info");
                    if (jSONObjectOptJSONObject2 == null) {
                        jSONObjectOptJSONObject3 = null;
                    } else {
                        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("target");
                    }
                    if (jSONObjectOptJSONObject3 != null) {
                        jSONObjectOptJSONObject3.put("soc_id", str7);
                    }
                }
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", str32.toLowerCase(Locale.ROOT) + "_sla");
                    if (str29 == null) {
                        str13 = "";
                    } else {
                        str13 = str29;
                    }
                    jSONObject.put("pubkey_mod", str13);
                    if ("BROM".equals(str32)) {
                        str14 = "tool_auth_rsa_modulus";
                    } else if (str11 != null) {
                        str14 = "rsa2048_modulus_be";
                    } else {
                        str14 = "da2_search_blob";
                    }
                    jSONObject.put("pubkey_mod_kind", str14);
                    jSONObject.put("pubkey_mod_bytes", str13.length() / 2);
                    jSONObject.put("pubkey_mod_sha256", com.rynx.app.ojyssqt.jybecxv(str13));
                    if (str30 == null) {
                        str15 = "";
                    } else {
                        str15 = str30;
                    }
                    jSONObject.put("rnd", str15);
                    if (str6 == null) {
                        str16 = "";
                    } else {
                        str16 = str6;
                    }
                    jSONObject.put("hrid", str16);
                    if (str7 == null) {
                        str17 = "";
                    } else {
                        str17 = str7;
                    }
                    jSONObject.put("soc_id", str17);
                    if (str8 == null) {
                        str18 = "";
                    } else {
                        str18 = str8;
                    }
                    jSONObject.put(str9, str18);
                    jSONObject.put("raw_encoding", "hex");
                    if (str11 != null) {
                        str26 = "transsion_xml_v" + str11.substring(0, 1);
                        if ("6.0".equals(str11)) {
                            str27 = "transsion_xml_v6";
                        } else {
                            str27 = "transsion_xml_v1_v5";
                        }
                        String strQdiugcp = qdiugcp(str11);
                        str19 = str9;
                        str28 = str10;
                        jSONObject.put(str28, str26);
                        str21 = "soc_id";
                        jSONObject.put("sla_family", str27);
                        jSONObject.put("sla_version", str11);
                        str20 = "hrid";
                        jSONObject.put("rsa_operation", "private_encrypt");
                        jSONObject.put("rsa_padding", "oaep_sha256");
                        jSONObject.put("response_bytes", 256);
                        jSONObject.put("payload_format", strQdiugcp);
                        jSONObjectWdznaie.put(str28, str26);
                        jSONObjectWdznaie.put("sla_family", str27);
                        jSONObjectWdznaie.put("sla_version", str11);
                        jSONObjectWdznaie.put("payload_format", strQdiugcp);
                        jSONObjectOptJSONObject = jSONObjectWdznaie.optJSONObject("session_info");
                        if (jSONObjectOptJSONObject != null) {
                            jSONObjectOptJSONObject.put(str28, str26);
                            jSONObjectOptJSONObject.put("sla_family", str27);
                            jSONObjectOptJSONObject.put("sla_version", str11);
                        }
                    } else {
                        str19 = str9;
                        str20 = "hrid";
                        str21 = "soc_id";
                    }
                    if ("BROM".equals(str32)) {
                        bArrQxvquar = com.rynx.app.ojyssqt.qxvquar(str8);
                        if (bArrQxvquar == null) {
                            strEncodeToString = "";
                        } else {
                            strEncodeToString = Base64.encodeToString(bArrQxvquar, 2);
                        }
                        jSONObject.put("flashToken", strEncodeToString);
                        jSONObjectWdznaie.put("flashToken", strEncodeToString);
                    }
                    jSONObjectWdznaie.put("device_auth", jSONObject);
                    if (str29 == null) {
                        str29 = "";
                    }
                    jSONObjectWdznaie.put("pubkey_mod", str29);
                    if (str30 == null) {
                        str30 = "";
                    }
                    jSONObjectWdznaie.put("rnd", str30);
                    if (str6 == null) {
                        str22 = "";
                    } else {
                        str22 = str6;
                    }
                    jSONObjectWdznaie.put(str20, str22);
                    String str34 = str21;
                    if (str7 == null) {
                        str23 = "";
                    } else {
                        str23 = str7;
                    }
                    jSONObjectWdznaie.put(str34, str23);
                    if (str8 == null) {
                        str24 = "";
                    } else {
                        str24 = str8;
                    }
                    jSONObjectWdznaie.put(str19, str24);
                    httpURLConnectionCxxnoho = cxxnoho(jSONObjectWdznaie);
                    try {
                        responseCode = httpURLConnectionCxxnoho.getResponseCode();
                        if (responseCode != 401 && responseCode != 403) {
                            strQwgjehf = com.rynx.app.ojyssqt.qwgjehf(httpURLConnectionCxxnoho, responseCode);
                            if (responseCode == 204) {
                                httpURLConnectionCxxnoho.disconnect();
                                return "ERR:SLA credential accepted, but server signing is not configured";
                            }
                            if (responseCode >= 200 || responseCode >= 300) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("ERR:SLA server HTTP ");
                                sb2.append(responseCode);
                                if (strQwgjehf.isEmpty()) {
                                    str25 = "";
                                } else {
                                    str25 = ": " + strQwgjehf;
                                }
                                sb2.append(str25);
                                String string2 = sb2.toString();
                                httpURLConnectionCxxnoho.disconnect();
                                return string2;
                            }
                            JSONObject jSONObject2 = new JSONObject(strQwgjehf);
                            if (!jSONObject2.optBoolean("ok", false)) {
                                String str35 = "ERR:" + jSONObject2.optString("message", jSONObject2.optString("error", "SLA authorization rejected"));
                                httpURLConnectionCxxnoho.disconnect();
                                return str35;
                            }
                            String strUiqyzsp = com.rynx.app.ojyssqt.uiqyzsp(jSONObject2.optString("signature", ""));
                            if (strUiqyzsp == null) {
                                httpURLConnectionCxxnoho.disconnect();
                                return "ERR:SLA server returned an invalid signature";
                            }
                            if (str11 != null && !sdchfks(256, strUiqyzsp)) {
                                httpURLConnectionCxxnoho.disconnect();
                                return "ERR:Transsion DA SLA response must be exactly 256 bytes";
                            }
                            String str36 = "OK:" + strUiqyzsp;
                            httpURLConnectionCxxnoho.disconnect();
                            return str36;
                        }
                        ijakhcl();
                        try {
                            runOnUiThread(new yrgokys(this, 5));
                            httpURLConnectionCxxnoho.disconnect();
                            return "ERR:Username / password Wrong";
                        } catch (Throwable th) {
                            httpURLConnection = httpURLConnectionCxxnoho;
                            try {
                                return "ERR:SLA server connection failed: " + th.getClass().getSimpleName();
                            } finally {
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        httpURLConnection = httpURLConnectionCxxnoho;
                        try {
                            return "ERR:SLA server connection failed: " + th2.getClass().getSimpleName();
                        } finally {
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        return "ERR:SLA server connection failed: " + th3.getClass().getSimpleName();
                    } finally {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
            } catch (Throwable th4) {
                try {
                    return "ERR:SLA server connection failed: " + th4.getClass().getSimpleName();
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } else {
            str9 = "raw";
            str10 = "sla_profile";
        }
        str11 = null;
        if (str11 == null) {
        }
        if (str11 == null) {
            strConcat = str32;
        } else {
            strConcat = "Transsion XML SLA v".concat(str11);
        }
        runOnUiThread(new utmeivs(this, strConcat, 11));
        if (com.rynx.app.ojyssqt.jxvdcpb().trim().isEmpty()) {
            runOnUiThread(new yrgokys(this, 4));
            return "ERR:SLA server is not configured";
        }
        try {
        jSONObjectWdznaie = wdznaie(str32);
        jSONObjectWdznaie.put("action", "sign");
        if (str2 == null) {
            strTrim = "";
        } else {
            strTrim = str2.trim();
        }
        jSONObjectWdznaie.put("email", strTrim);
        if (str3 == null) {
            str12 = "";
        } else {
            str12 = str3;
        }
        jSONObjectWdznaie.put("password", str12);
        if (!com.rynx.app.ojyssqt.zwaqeaz(str7)) {
            jSONObjectWdznaie.put("device_id", str7);
            jSONObjectOptJSONObject2 = jSONObjectWdznaie.optJSONObject("device_info");
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject3 = null;
            } else {
                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("target");
            }
            if (jSONObjectOptJSONObject3 != null) {
                jSONObjectOptJSONObject3.put("soc_id", str7);
            }
        }
        jSONObject = new JSONObject();
        jSONObject.put("type", str32.toLowerCase(Locale.ROOT) + "_sla");
        if (str29 == null) {
            str13 = "";
        } else {
            str13 = str29;
        }
        jSONObject.put("pubkey_mod", str13);
        if ("BROM".equals(str32)) {
            str14 = "tool_auth_rsa_modulus";
        } else if (str11 != null) {
            str14 = "rsa2048_modulus_be";
        } else {
            str14 = "da2_search_blob";
        }
        jSONObject.put("pubkey_mod_kind", str14);
        jSONObject.put("pubkey_mod_bytes", str13.length() / 2);
        jSONObject.put("pubkey_mod_sha256", com.rynx.app.ojyssqt.jybecxv(str13));
        if (str30 == null) {
            str15 = "";
        } else {
            str15 = str30;
        }
        jSONObject.put("rnd", str15);
        if (str6 == null) {
            str16 = "";
        } else {
            str16 = str6;
        }
        jSONObject.put("hrid", str16);
        if (str7 == null) {
            str17 = "";
        } else {
            str17 = str7;
        }
        jSONObject.put("soc_id", str17);
        if (str8 == null) {
            str18 = "";
        } else {
            str18 = str8;
        }
        jSONObject.put(str9, str18);
        jSONObject.put("raw_encoding", "hex");
        if (str11 != null) {
            str26 = "transsion_xml_v" + str11.substring(0, 1);
            if ("6.0".equals(str11)) {
                str27 = "transsion_xml_v6";
            } else {
                str27 = "transsion_xml_v1_v5";
            }
            String strQdiugcp2 = qdiugcp(str11);
            str19 = str9;
            str28 = str10;
            jSONObject.put(str28, str26);
            str21 = "soc_id";
            jSONObject.put("sla_family", str27);
            jSONObject.put("sla_version", str11);
            str20 = "hrid";
            jSONObject.put("rsa_operation", "private_encrypt");
            jSONObject.put("rsa_padding", "oaep_sha256");
            jSONObject.put("response_bytes", 256);
            jSONObject.put("payload_format", strQdiugcp2);
            jSONObjectWdznaie.put(str28, str26);
            jSONObjectWdznaie.put("sla_family", str27);
            jSONObjectWdznaie.put("sla_version", str11);
            jSONObjectWdznaie.put("payload_format", strQdiugcp2);
            jSONObjectOptJSONObject = jSONObjectWdznaie.optJSONObject("session_info");
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.put(str28, str26);
                jSONObjectOptJSONObject.put("sla_family", str27);
                jSONObjectOptJSONObject.put("sla_version", str11);
            }
        } else {
            str19 = str9;
            str20 = "hrid";
            str21 = "soc_id";
        }
        if ("BROM".equals(str32)) {
            bArrQxvquar = com.rynx.app.ojyssqt.qxvquar(str8);
            if (bArrQxvquar == null) {
                strEncodeToString = "";
            } else {
                strEncodeToString = Base64.encodeToString(bArrQxvquar, 2);
            }
            jSONObject.put("flashToken", strEncodeToString);
            jSONObjectWdznaie.put("flashToken", strEncodeToString);
        }
        jSONObjectWdznaie.put("device_auth", jSONObject);
        if (str29 == null) {
            str29 = "";
        }
        jSONObjectWdznaie.put("pubkey_mod", str29);
        if (str30 == null) {
            str30 = "";
        }
        jSONObjectWdznaie.put("rnd", str30);
        if (str6 == null) {
            str22 = "";
        } else {
            str22 = str6;
        }
        jSONObjectWdznaie.put(str20, str22);
        String str37 = str21;
        if (str7 == null) {
            str23 = "";
        } else {
            str23 = str7;
        }
        jSONObjectWdznaie.put(str37, str23);
        if (str8 == null) {
            str24 = "";
        } else {
            str24 = str8;
        }
        jSONObjectWdznaie.put(str19, str24);
        httpURLConnectionCxxnoho = cxxnoho(jSONObjectWdznaie);
        responseCode = httpURLConnectionCxxnoho.getResponseCode();
        if (responseCode != 401) {
            strQwgjehf = com.rynx.app.ojyssqt.qwgjehf(httpURLConnectionCxxnoho, responseCode);
            if (responseCode == 204) {
                httpURLConnectionCxxnoho.disconnect();
                return "ERR:SLA credential accepted, but server signing is not configured";
            }
            if (responseCode >= 200) {
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ERR:SLA server HTTP ");
            sb3.append(responseCode);
            if (strQwgjehf.isEmpty()) {
                str25 = "";
            } else {
                str25 = ": " + strQwgjehf;
            }
            sb3.append(str25);
            String string3 = sb3.toString();
            httpURLConnectionCxxnoho.disconnect();
            return string3;
        }
        ijakhcl();
        runOnUiThread(new yrgokys(this, 5));
        httpURLConnectionCxxnoho.disconnect();
        return "ERR:Username / password Wrong";
        } catch (JSONException jsonException) {
            return "ERR:SLA request encoding failed: " + jsonException.getClass().getSimpleName();
        } catch (IOException ioException) {
            return "ERR:SLA server connection failed: " + ioException.getClass().getSimpleName();
        }
    }

    public final void seujokk(String str) {
        UsbDevice usbDevice = this.ulafhci;
        if (x.zamkzqg.nsyqsfj(usbDevice) != 2) {
            Toast.makeText(this, R.string.android_tools_adb_only, 0).show();
            fusjbbl("ERROR: no device in ADB mode");
            return;
        }
        if (this.nxumtuo || this.dvzxbaj || this.lpkdqgx || this.gzokllk || this.nsyqsfj) {
            Toast.makeText(this, R.string.android_tools_busy, 0).show();
            fusjbbl("ERROR: USB transport is busy");
            return;
        }
        if (!this.dplrlfq.hasPermission(usbDevice) || !qyeibyo()) {
            hhqpjvl(usbDevice);
            Toast.makeText(this, R.string.android_tools_permission, 0).show();
            fusjbbl("USB permission/open required. Approve the Android USB prompt and retry.");
            return;
        }
        UsbDeviceConnection usbDeviceConnectionCzgynww = czgynww(usbDevice);
        if (usbDeviceConnectionCzgynww == null) {
            return;
        }
        this.nxumtuo = true;
        jybecxv jybecxvVar = this.ltnesel;
        if (jybecxvVar != null) {
            jybecxvVar.vivhedu.setText(R.string.android_tools_adb_reboot_sending);
            this.ltnesel.vivhedu.setTextColor(this.oqexvyb);
        }
        nmpwovh("[ADB] reboot " + str);
        this.slxntng.execute(new vntpaom(this, usbDevice, usbDeviceConnectionCzgynww, str, 0));
    }

    public final void sfildfy(final boolean z, final String str, String str2) {
        final ParcelFileDescriptor parcelFileDescriptorOhwxijw;
        UsbDevice usbDevice = this.ulafhci;
        if (x.zamkzqg.nsyqsfj(usbDevice) != 3) {
            fusjbbl("ERROR: no device in Fastboot mode");
            return;
        }
        if (this.nxumtuo || this.dvzxbaj || this.lpkdqgx || this.gzokllk || this.nsyqsfj) {
            fusjbbl("ERROR: USB transport is busy");
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        final File file = new File(str2);
        if (file.exists()) {
            fusjbbl("ERROR: refusing to overwrite existing file: " + file.getAbsolutePath());
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            fusjbbl("ERROR: unable to create output directory: " + parentFile.getAbsolutePath());
            return;
        }
        if (!this.dplrlfq.hasPermission(usbDevice) || !qyeibyo()) {
            hhqpjvl(usbDevice);
            fusjbbl("USB permission/open required. Approve the Android USB prompt and retry.");
            return;
        }
        int iNnkxxji = nnkxxji();
        if (iNnkxxji < 0) {
            fusjbbl("ERROR: Fastboot USB FD unavailable");
            return;
        }
        if (teupdsw() && (parcelFileDescriptorOhwxijw = ohwxijw(iNnkxxji)) != null) {
            this.dvzxbaj = true;
            final long j = this.gepzcpd + 1;
            this.gepzcpd = j;
            gdkopre();
            StringBuilder sb = new StringBuilder("[FASTBOOT] ");
            sb.append(z ? "fetch " : "upload ");
            sb.append(str);
            sb.append(" -> ");
            sb.append(file.getAbsolutePath());
            nmpwovh(sb.toString());
            this.zftrkmx = this.slxntng.submit(new Runnable() { // from class: x.gzokllk
                public final /* synthetic */ MainActivity nmpwovh = MainActivity.this;
                @Override // java.lang.Runnable
                public final void run() {
                    String strVivhedu;
                    MainActivity mainActivity = this.nmpwovh;
                    mainActivity.getClass();
                    ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorOhwxijw;
                    File file2 = file;
                    boolean z2 = z;
                    String str3 = str;
                    try {
                        try {
                            strVivhedu = z2 ? AdbFastbootNative.vivhedu(parcelFileDescriptor.getFd(), str3, file2.getAbsolutePath()) : AdbFastbootNative.oqexvyb(parcelFileDescriptor.getFd(), str3, file2.getAbsolutePath());
                            parcelFileDescriptor.close();
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        strVivhedu = "ERROR\n" + th3;
                    }
                    mainActivity.runOnUiThread(new x.uiqyzsp(mainActivity, j, strVivhedu == null ? "ERROR\nNative Fastboot receive command returned null" : strVivhedu, 3));
                }
            });
        }
    }

    public final void snbdnwo(int i, String str) {
        File parentFile;
        tmdubwv tmdubwvVar = this.wdvdxhb;
        if (tmdubwvVar == null) {
            return;
        }
        this.wdvdxhb = null;
        String strAyzlrnr = ayzlrnr(x.cugubfc.imuemzb("--da", "-d", (ArrayList) tmdubwvVar.nmpwovh));
        String strAyzlrnr2 = ayzlrnr(x.cugubfc.imuemzb("--auth", "-a", (ArrayList) tmdubwvVar.nmpwovh));
        String strAyzlrnr3 = ayzlrnr(x.cugubfc.imuemzb("--pl", "-p", (ArrayList) tmdubwvVar.nmpwovh));
        String strDytyqos = x.cugubfc.dytyqos((ArrayList) tmdubwvVar.nmpwovh, i, 0);
        String strDytyqos2 = x.cugubfc.dytyqos((ArrayList) tmdubwvVar.nmpwovh, i, 1);
        if (strDytyqos2 != null && !strDytyqos2.startsWith("/data/user/")) {
            strDytyqos2 = ayzlrnr(strDytyqos2);
        }
        String str2 = strDytyqos2;
        if (!str.equals("probe") && !str.equals("crash") && com.rynx.app.ojyssqt.zwaqeaz(strAyzlrnr)) {
            nmpwovh(getString(R.string.terminal_legacy_da_required));
            nmpwovh(getString(R.string.terminal_legacy_da_example, str));
            return;
        }
        if (this.qwgjehf || this.gzokllk || this.nsyqsfj) {
            nmpwovh(getString(R.string.terminal_gui_session_conflict));
            nmpwovh(getString(R.string.terminal_gui_session_stop_first));
            return;
        }
        if (!str.equals("probe")) {
            File file = new File(strAyzlrnr);
            if (!file.isFile() || !file.canRead()) {
                nmpwovh(getString(R.string.terminal_da_not_readable, strAyzlrnr));
                if (pvbzgon() || !strAyzlrnr.startsWith("/storage/emulated/0")) {
                    return;
                }
                nmpwovh(getString(R.string.storage_grant_hint));
                return;
            }
            if (!com.rynx.app.ojyssqt.zwaqeaz(strAyzlrnr2)) {
                File file2 = new File(strAyzlrnr2);
                if (!file2.isFile() || !file2.canRead()) {
                    nmpwovh(getString(R.string.terminal_auth_not_readable, strAyzlrnr2));
                    return;
                }
            }
            if (!com.rynx.app.ojyssqt.zwaqeaz(strAyzlrnr3)) {
                File file3 = new File(strAyzlrnr3);
                if (!file3.isFile() || !file3.canRead()) {
                    nmpwovh(getString(R.string.terminal_pl_not_readable, strAyzlrnr3));
                    return;
                }
            }
            if (x.cugubfc.lthborb.contains(str) && str2 != null) {
                File file4 = new File(str2);
                if (!file4.isFile() || !file4.canRead()) {
                    nmpwovh(getString(R.string.terminal_input_not_readable, str2));
                    if (pvbzgon() || !str2.startsWith("/storage/emulated/0")) {
                        return;
                    }
                    nmpwovh(getString(R.string.storage_grant_hint));
                    return;
                }
            }
            if (x.cugubfc.vivhedu.contains(str) && str2 != null && !str2.startsWith(getCacheDir().getAbsolutePath()) && ((parentFile = new File(str2).getParentFile()) == null || !parentFile.exists() || !parentFile.canWrite())) {
                nmpwovh(getString(R.string.terminal_output_not_writable, parentFile == null ? str2 : parentFile.getAbsolutePath()));
                if (pvbzgon() || !str2.startsWith("/storage/emulated/0")) {
                    return;
                }
                nmpwovh(getString(R.string.storage_grant_hint));
                return;
            }
        }
        if (qyeibyo()) {
            axbavsj(tmdubwvVar, str, strAyzlrnr, strAyzlrnr2, strAyzlrnr3, strDytyqos, str2);
            return;
        }
        this.bsimxgu = tmdubwvVar;
        this.aylswsn = i;
        this.czqxnxv = str;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str3 = "";
        sb.append(strDytyqos == null ? "" : " ".concat(strDytyqos));
        if (str2 != null) {
            str3 = " " + oxoagud(str2);
        }
        sb.append(str3);
        nmpwovh(getString(R.string.terminal_armed, sb.toString()));
        if (this.ulafhci != null) {
            hhqpjvl(this.ulafhci);
        } else {
            cgcdpmq();
        }
    }

    public final void snilumr(String str, mwngani mwnganiVar) {
        UsbDevice usbDevice = this.ulafhci;
        if (x.zamkzqg.nsyqsfj(usbDevice) != 2) {
            fusjbbl("ERROR: no device in ADB mode");
            return;
        }
        if (this.nxumtuo || this.dvzxbaj || this.lpkdqgx || this.gzokllk || this.nsyqsfj) {
            fusjbbl("ERROR: USB transport is busy");
            return;
        }
        if (!this.dplrlfq.hasPermission(usbDevice) || !qyeibyo()) {
            hhqpjvl(usbDevice);
            fusjbbl("USB permission/open required. Approve the Android USB prompt and retry.");
            return;
        }
        UsbDeviceConnection usbDeviceConnectionCzgynww = czgynww(usbDevice);
        if (usbDeviceConnectionCzgynww == null) {
            fusjbbl("ERROR: USB connection unavailable");
            return;
        }
        this.nxumtuo = true;
        long j = 1 + this.gepzcpd;
        this.gepzcpd = j;
        gdkopre();
        nmpwovh("[ADB] " + str);
        this.zftrkmx = this.slxntng.submit(new czidoiw(this, mwnganiVar, usbDevice, usbDeviceConnectionCzgynww, j));
    }

    @Override // com.rynx.app.ojyssqt
    public final void sthdtww() {
        if (pvbzgon()) {
            bgmsltp();
            return;
        }
        if (Build.VERSION.SDK_INT < 30) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 4102);
            return;
        }
        try {
            Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
            nmpwovh(getString(R.string.storage_settings_opened_app));
        } catch (Throwable unused) {
            startActivity(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
            nmpwovh(getString(R.string.storage_settings_opened));
        }
    }

    public final void sxhcynd() {
        ParcelFileDescriptor parcelFileDescriptorOhwxijw;
        if (this.nxumtuo || this.dvzxbaj || this.lpkdqgx || this.gzokllk || this.nsyqsfj || this.ltnesel == null) {
            return;
        }
        UsbDevice usbDevice = this.ulafhci;
        if (x.zamkzqg.nsyqsfj(usbDevice) != 3 || !qyeibyo()) {
            wfxzfba(false);
            return;
        }
        int iNnkxxji = nnkxxji();
        if (iNnkxxji < 0) {
            wfxzfba(false);
        } else if (teupdsw() && (parcelFileDescriptorOhwxijw = ohwxijw(iNnkxxji)) != null) {
            this.dvzxbaj = true;
            wfxzfba(false);
            this.zftrkmx = this.slxntng.submit(new ekyqleu(this, parcelFileDescriptorOhwxijw, usbDevice));
        }
    }

    public final boolean teupdsw() {
        if (AdbFastbootNative.qxvquar()) {
            this.qppdydr = false;
            return true;
        }
        fusjbbl("ERROR: previous Fastboot worker is still stopping");
        return false;
    }

    public boolean useManualBromSlaForSelectedDa() {
        return false;
    }

    public final tmdubwv uzyihoe() {
        return new tmdubwv(getSharedPreferences("fastboot_flash_journal", 0).getStringSet("incomplete", Collections.emptySet()));
    }

    public final File vhimehb(Uri uri, String str, String str2, String str3) throws IOException {
        InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
        try {
            if (inputStreamOpenInputStream != null) {
                File fileHjlrtqw = hjlrtqw(inputStreamOpenInputStream, str, str2, str3);
                inputStreamOpenInputStream.close();
                return fileHjlrtqw;
            }
            throw new IOException("Selected " + str3 + " cannot be opened");
        } catch (Throwable th) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw new RuntimeException(th);
        }
    }

    public final void vlyywxv(TextView textView, Boolean bool) {
        if (textView == null) {
            return;
        }
        if (bool == null) {
            textView.setText(R.string.value_not_available);
            textView.setTextColor(this.dytyqos);
        } else {
            textView.setText(bool.booleanValue() ? R.string.security_enabled : R.string.security_disabled);
            textView.setTextColor(bool.booleanValue() ? this.qxvquar : this.dytyqos);
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final boolean vntpaom() {
        String strYjbrzgu = yjbrzgu("da_path");
        if (com.rynx.app.ojyssqt.zwaqeaz(strYjbrzgu)) {
            return false;
        }
        File file = new File(strYjbrzgu);
        return file.isFile() && file.canRead() && com.rynx.app.ojyssqt.gisppfs(file.getName());
    }

    public final void wdvdxhb() {
        tmdubwv tmdubwvVar;
        if (!qyeibyo() || (tmdubwvVar = this.bsimxgu) == null) {
            return;
        }
        int i = this.aylswsn;
        String str = this.czqxnxv;
        this.bsimxgu = null;
        this.aylswsn = -1;
        this.czqxnxv = null;
        ArrayList arrayList = (ArrayList) tmdubwvVar.nmpwovh;
        String strAyzlrnr = ayzlrnr(x.cugubfc.imuemzb("--da", "-d", arrayList));
        String strAyzlrnr2 = ayzlrnr(x.cugubfc.imuemzb("--auth", "-a", arrayList));
        String strAyzlrnr3 = ayzlrnr(x.cugubfc.imuemzb("--pl", "-p", arrayList));
        String strDytyqos = x.cugubfc.dytyqos(arrayList, i, 0);
        String strDytyqos2 = x.cugubfc.dytyqos(arrayList, i, 1);
        if (strDytyqos2 != null && !strDytyqos2.startsWith("/data/user/")) {
            strDytyqos2 = ayzlrnr(strDytyqos2);
        }
        axbavsj(tmdubwvVar, str, strAyzlrnr, strAyzlrnr2, strAyzlrnr3, strDytyqos, strDytyqos2);
    }

    public final JSONObject wdznaie(String str) throws JSONException {
        String str2 = "DA".equalsIgnoreCase(str) ? "DA" : "BROM";
        ednetju ednetjuVarYrgokys = yrgokys(str2);
        UsbDevice usbDevice = this.ulafhci;
        String strMwngani = mwngani();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("manufacturer", Build.MANUFACTURER);
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("device", Build.DEVICE);
        jSONObject.put("android", Build.VERSION.RELEASE);
        jSONObject.put("sdk", Build.VERSION.SDK_INT);
        String[] strArr = Build.SUPPORTED_ABIS;
        jSONObject.put("abi", (strArr == null || strArr.length <= 0) ? "" : strArr[0]);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("chip", ednetjuVarYrgokys.nmpwovh);
        jSONObject2.put("storage", ednetjuVarYrgokys.ojyssqt);
        jSONObject2.put("boot_mode", ednetjuVarYrgokys.vivhedu);
        jSONObject2.put("da_protocol", ednetjuVarYrgokys.lthborb);
        jSONObject2.put("hw_code", ednetjuVarYrgokys.qxvquar);
        jSONObject2.put("hw_sub_code", ednetjuVarYrgokys.oqexvyb);
        jSONObject2.put("hw_version", ednetjuVarYrgokys.nkemejx);
        jSONObject2.put("sw_version", ednetjuVarYrgokys.imuemzb);
        jSONObject2.put("target_config", ednetjuVarYrgokys.dytyqos);
        jSONObject2.put("meid", ednetjuVarYrgokys.wqrnifx);
        jSONObject2.put("soc_id", ednetjuVarYrgokys.dasxvpc);
        Object obj = ednetjuVarYrgokys.dplrlfq;
        if (obj == null) {
            obj = JSONObject.NULL;
        }
        jSONObject2.put("sbc", obj);
        Object obj2 = ednetjuVarYrgokys.ulafhci;
        if (obj2 == null) {
            obj2 = JSONObject.NULL;
        }
        jSONObject2.put("sla", obj2);
        Object obj3 = ednetjuVarYrgokys.ekyqleu;
        if (obj3 == null) {
            obj3 = JSONObject.NULL;
        }
        jSONObject2.put("daa", obj3);
        jSONObject2.put("partition_count", ednetjuVarYrgokys.utmeivs);
        jSONObject2.put("usb_vid", usbDevice == null ? JSONObject.NULL : String.format(Locale.US, "0x%04X", Integer.valueOf(usbDevice.getVendorId())));
        jSONObject2.put("usb_pid", usbDevice == null ? JSONObject.NULL : String.format(Locale.US, "0x%04X", Integer.valueOf(usbDevice.getProductId())));
        jSONObject2.put("da_vendor", strMwngani);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("host", jSONObject);
        jSONObject3.put("target", jSONObject2);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("purpose", str2.concat("_SLA"));
        jSONObject4.put("boot_mode", ednetjuVarYrgokys.vivhedu);
        jSONObject4.put("da_protocol", ednetjuVarYrgokys.lthborb);
        jSONObject4.put("storage", ednetjuVarYrgokys.ojyssqt);
        jSONObject4.put("da_vendor", strMwngani);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("purpose", str2.toLowerCase(Locale.ROOT) + "_sla");
        jSONObject5.put("package_name", getPackageName());
        jSONObject5.put("app_version", com.rynx.app.BuildConfig.VERSION_NAME);
        jSONObject5.put("app_build", String.valueOf(301));
        jSONObject5.put("device_id", !com.rynx.app.ojyssqt.zwaqeaz(ednetjuVarYrgokys.dasxvpc) ? ednetjuVarYrgokys.dasxvpc : ednetjuVarYrgokys.wqrnifx);
        jSONObject5.put("device_info", jSONObject3);
        jSONObject5.put("session_info", jSONObject4);
        return jSONObject5;
    }

    @Override // com.rynx.app.ojyssqt
    public final void wfxzfba(boolean z) {
        if (this.ltnesel == null) {
            return;
        }
        gdkopre();
        UsbDevice usbDevice = this.ulafhci;
        int iNsyqsfj = x.zamkzqg.nsyqsfj(usbDevice);
        if (this.thbdbid && iNsyqsfj != 2) {
            this.thbdbid = false;
            this.sjexbpf = false;
            this.mcdstyz = "/";
            this.gucwjqz = "device";
        }
        this.ltnesel.imuemzb.setVisibility(iNsyqsfj == 2 ? 0 : 8);
        this.ltnesel.jdqigmr.setVisibility(iNsyqsfj == 3 ? 0 : 8);
        this.ltnesel.lclupha.setVisibility(iNsyqsfj != 3 ? 8 : 0);
        if (usbDevice == null || iNsyqsfj == 4 || iNsyqsfj == 1) {
            this.ltnesel.nmpwovh.setText(iNsyqsfj == 1 ? R.string.android_tools_transport_mtk : R.string.android_tools_transport_none);
            this.ltnesel.ojyssqt.setText(R.string.value_not_available);
            this.ltnesel.vivhedu.setText(R.string.android_tools_no_device);
            this.ltnesel.vivhedu.setTextColor(this.dytyqos);
            x.zamkzqg.enxkjpu(this, this.ltnesel.vivhedu, R.drawable.ic_usb, this.dytyqos);
            pwnmyid();
            mwocrhx();
            return;
        }
        this.ltnesel.ojyssqt.setText(String.format(Locale.US, "%04X:%04X", Integer.valueOf(usbDevice.getVendorId()), Integer.valueOf(usbDevice.getProductId())));
        if (iNsyqsfj == 2) {
            this.ltnesel.nmpwovh.setText(R.string.android_tools_transport_adb);
            mwocrhx();
            if (!this.dplrlfq.hasPermission(usbDevice)) {
                this.ltnesel.vivhedu.setText(R.string.android_tools_permission);
                this.ltnesel.vivhedu.setTextColor(this.oqexvyb);
                x.zamkzqg.enxkjpu(this, this.ltnesel.vivhedu, R.drawable.ic_warning, this.oqexvyb);
                if (z) {
                    hhqpjvl(usbDevice);
                    return;
                }
                return;
            }
            if (qyeibyo()) {
                this.ltnesel.vivhedu.setText(this.nxumtuo ? R.string.android_tools_adb_communicating : R.string.android_tools_adb_ready);
                this.ltnesel.vivhedu.setTextColor(this.nxumtuo ? this.oqexvyb : this.lthborb);
                x.zamkzqg.enxkjpu(this, this.ltnesel.vivhedu, R.drawable.ic_terminal, this.nxumtuo ? this.oqexvyb : this.lthborb);
                return;
            } else {
                this.ltnesel.vivhedu.setText(R.string.android_tools_adb_connecting);
                this.ltnesel.vivhedu.setTextColor(this.oqexvyb);
                x.zamkzqg.enxkjpu(this, this.ltnesel.vivhedu, R.drawable.ic_usb, this.oqexvyb);
                if (z) {
                    hhqpjvl(usbDevice);
                    return;
                }
                return;
            }
        }
        pwnmyid();
        this.ltnesel.nmpwovh.setText(R.string.android_tools_transport_fastboot);
        if (!this.dplrlfq.hasPermission(usbDevice)) {
            this.ltnesel.vivhedu.setText(R.string.android_tools_permission);
            this.ltnesel.vivhedu.setTextColor(this.oqexvyb);
            x.zamkzqg.enxkjpu(this, this.ltnesel.vivhedu, R.drawable.ic_warning, this.oqexvyb);
            if (z) {
                hhqpjvl(usbDevice);
                return;
            }
            return;
        }
        boolean zQyeibyo = qyeibyo();
        int i = R.string.android_tools_fastboot_loading;
        if (zQyeibyo) {
            TextView textView = this.ltnesel.vivhedu;
            if (!this.dvzxbaj) {
                i = R.string.android_tools_fastboot_ready;
            }
            textView.setText(i);
            this.ltnesel.vivhedu.setTextColor(this.dvzxbaj ? this.oqexvyb : this.qxvquar);
            x.zamkzqg.enxkjpu(this, this.ltnesel.vivhedu, R.drawable.ic_usb, this.dvzxbaj ? this.oqexvyb : this.qxvquar);
            return;
        }
        this.ltnesel.vivhedu.setText(R.string.android_tools_fastboot_loading);
        this.ltnesel.vivhedu.setTextColor(this.oqexvyb);
        x.zamkzqg.enxkjpu(this, this.ltnesel.vivhedu, R.drawable.ic_usb, this.oqexvyb);
        if (z) {
            hhqpjvl(usbDevice);
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final boolean wjugzfh() {
        if (this.nsyqsfj) {
            return true;
        }
        Toast.makeText(this, this.gzokllk ? R.string.error_da_connecting : R.string.error_wait_da_ready, 0).show();
        return false;
    }

    public final void wrbqriz(TextView textView, boolean z, int i) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(i);
        Object tag = textView.getTag();
        if (tag instanceof enxkjpu) {
            enxkjpu enxkjpuVar = (enxkjpu) tag;
            boolean z2 = (enxkjpuVar.lthborb && enxkjpuVar.qxvquar == z && enxkjpuVar.oqexvyb == i) ? false : true;
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
            ImageView imageView = enxkjpuVar.nmpwovh;
            imageView.setImageTintList(colorStateListValueOf);
            imageView.setBackground(x.zamkzqg.jtfjrri(this, z ? x.zamkzqg.atntgcp(this) : getColor(R.color.rynx_transparent), i, getResources().getDimensionPixelSize(R.dimen.home_step_ring_width)));
            TextView textView2 = enxkjpuVar.ojyssqt;
            textView2.setTextColor(i);
            textView2.setBackground(x.zamkzqg.jtfjrri(this, z ? x.zamkzqg.atntgcp(this) : x.zamkzqg.czidoiw(this), i, getResources().getDimensionPixelSize(R.dimen.ui_stroke_width)));
            View view = enxkjpuVar.vivhedu;
            if (view != null) {
                view.setBackgroundColor(z ? i : x.zamkzqg.qyeibyo(this));
            }
            if (z2 && z) {
                x.zfmpmio.ojyssqt(imageView);
            }
            enxkjpuVar.lthborb = true;
            enxkjpuVar.qxvquar = z;
            enxkjpuVar.oqexvyb = i;
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void wygqgxb(File file) {
        if (file == null) {
            return;
        }
        try {
            File fileGisppfs = x.zamkzqg.gisppfs(file);
            if (fileGisppfs.isDirectory() && fileGisppfs.canRead()) {
                getSharedPreferences("rynx_persistent_session", 0).edit().putString("internal_picker_dir", fileGisppfs.getAbsolutePath()).apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0041 A[EDGE_INSN: B:31:0x0041->B:11:0x0041 BREAK  A[LOOP:0: B:3:0x000b->B:27:0x007c], SYNTHETIC] */
    public final dasxvpc xhyvkax(xhyvkax xhyvkaxVar, hiofinr hiofinrVar, String str, String str2, String str3, String str4, String str5, String str6, int i) throws InterruptedException, czgynww, IOException {
        int[] iArrYomtcav;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        czgynww e = null;
        IOException iOException = null;
        int i2 = 0;
        while (true) {
            long jElapsedRealtime2 = 10000 - (SystemClock.elapsedRealtime() - jElapsedRealtime);
            if (i2 <= 0) {
                iArrYomtcav = yomtcav(5000, jElapsedRealtime2);
                if (iArrYomtcav != null) {
                    return x.zamkzqg.lsgjyur(com.rynx.app.ojyssqt.jxvdcpb(), xhyvkaxVar, hiofinrVar, str, str2, str3, str4, str5, str6, iArrYomtcav[0], iArrYomtcav[1]);
                }
                break;
            }
            long jMin = Math.min(1000L, 100 << Math.min(i2 - 1, 3));
            if (jElapsedRealtime2 <= 1500 + jMin) {
                break;
            }
            Thread.sleep(jMin);
            jElapsedRealtime2 = 10000 - (SystemClock.elapsedRealtime() - jElapsedRealtime);
            iArrYomtcav = yomtcav(5000, jElapsedRealtime2);
            if (iArrYomtcav != null) {
                break;
            }
            try {
                return x.zamkzqg.lsgjyur(com.rynx.app.ojyssqt.jxvdcpb(), xhyvkaxVar, hiofinrVar, str, str2, str3, str4, str5, str6, iArrYomtcav[0], iArrYomtcav[1]);
            } catch (IOException e2) {
                iOException = e2;
                e = null;
            } catch (czgynww e3) {
                e = e3;
                if (!xbdyiew(e)) {
                    throw e;
                }
                iOException = null;
            }
            i2++;
            runOnUiThread(new mwocrhx(this, i, i2, 3));
        }
        if (e != null) {
            throw e;
        }
        if (iOException == null) {
            throw new IOException("broker submit recovery deadline expired");
        }
        throw iOException;
    }

    public final void ygdccqg() {
        if (!iivesaq()) {
            wdvdxhb();
            return;
        }
        if (qyeibyo()) {
            final String strYjbrzgu = yjbrzgu("da_path");
            final String strYjbrzgu2 = yjbrzgu("auth_path");
            final String strYjbrzgu3 = yjbrzgu("preloader_path");
            synchronized (this.ibfmasn) {
                this.cugubfc.clear();
                this.tmdubwv = true;
            }
            this.gzokllk = true;
            final int i = this.bgmsltp;
            final int i2 = this.zyxfuka;
            nmpwovh(getString(R.string.log_session_start));
            gefzxcg();
            this.slxntng.execute(new Runnable() { // from class: x.prywqjr
                public final /* synthetic */ MainActivity nmpwovh = MainActivity.this;
                /* JADX WARN: Code duplicated, block: B:120:0x01d3  */
                /* JADX WARN: Code duplicated, block: B:180:0x02d7  */
                /* JADX WARN: Code duplicated, block: B:181:0x02dc  */
                /* JADX WARN: Code duplicated, block: B:184:0x02e4  */
                /* JADX WARN: Code duplicated, block: B:186:0x02ee  */
                /* JADX WARN: Code duplicated, block: B:187:0x02f3  */
                /* JADX WARN: Code duplicated, block: B:189:0x02f8  */
                /* JADX WARN: Code duplicated, block: B:193:0x030f  */
                /* JADX WARN: Code duplicated, block: B:328:0x0547  */
                /* JADX WARN: Instruction removed from duplicated block: B:193:0x030f, please report this as an issue */
                @Override // java.lang.Runnable
                public final void run() {
                    final suqlntg suqlntgVar;
                    String string;
                    int iIndexOf;
                    final String str;
                    final boolean z;
                    boolean z2;
                    String strNmpwovh;
                    Pattern pattern;
                    Matcher matcher;
                    String strGroup;
                    String str2;
                    String lowerCase;
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    String str6 = null;
                    int i3 = 0;
                    boolean z3;
                    String str7 = null;
                    String str8 = null;
                    String str9 = null;
                    String str10 = null;
                    String str11 = null;
                    String str12 = null;
                    Matcher matcher2;
                    String strGroup2;
                    String str13;
                    final MainActivity mainActivity = this.nmpwovh;
                    String str14 = strYjbrzgu;
                    String str15 = strYjbrzgu2;
                    String str16 = strYjbrzgu3;
                    final int i4 = i;
                    final int i5 = i2;
                    oxoagud oxoagudVarEzxxysz = mainActivity.ezxxysz();
                    int i6 = oxoagudVarEzxxysz.nmpwovh;
                    yhrqvll yhrqvllVar = null;
                    boolean z4 = false;
                    if (i6 < 0) {
                        suqlntgVar = new suqlntg(2, mainActivity.getString(R.string.error_usb_lost_session));
                    } else {
                        suqlntg suqlntgVarLocal;
                        try {
                            long j = oxoagudVarEzxxysz.ojyssqt;
                            if (str14 == null) {
                                str14 = "";
                            }
                            if (str15 == null) {
                                str15 = "";
                            }
                            String strNativeConnectSession = mainActivity.nativeConnectSession(i6, j, str14, str15, str16 == null ? "" : str16);
                            int i7 = (strNativeConnectSession == null || !strNativeConnectSession.startsWith("OK\n")) ? 0 : 1;
                            boolean z5 = mainActivity.qwgjehf && i4 == mainActivity.bgmsltp;
                            if (i7 != 0 && mainActivity.nativeHasSession() && !z5) {
                                mainActivity.nativeDisconnectSession();
                            }
                            mainActivity.nsyqsfj = i7 != 0 && z5 && mainActivity.nativeHasSession();
                            if (mainActivity.nsyqsfj) {
                                mainActivity.cnctlxz = x.zamkzqg.xvxmcgn(strNativeConnectSession);
                                mainActivity.xvxmcgn = com.rynx.app.ojyssqt.zwaqeaz(mainActivity.cnctlxz.nmpwovh) ? mainActivity.getString(R.string.cpu_unknown) : mainActivity.cnctlxz.nmpwovh;
                                ArrayList arrayListRpdxrib = x.zamkzqg.rpdxrib(strNativeConnectSession);
                                mainActivity.jbmzxye.clear();
                                mainActivity.jbmzxye.addAll(arrayListRpdxrib);
                                mainActivity.ezuzoct = null;
                            } else {
                                mainActivity.cnctlxz = x.ednetju.ojyssqt();
                                mainActivity.xvxmcgn = "—";
                            }
                            int i8 = i7 ^ 1;
                            if (strNativeConnectSession == null) {
                                strNativeConnectSession = mainActivity.getString(R.string.error_jni_null);
                            }
                            suqlntgVarLocal = new suqlntg(i8, strNativeConnectSession);
                        } catch (Throwable th) {
                            mainActivity.nsyqsfj = false;
                            mainActivity.cnctlxz = x.ednetju.ojyssqt();
                            mainActivity.xvxmcgn = "—";
                            suqlntgVarLocal = new suqlntg(1, mainActivity.getString(R.string.error_session_jni, String.valueOf(th)));
                        }
                        suqlntgVar = suqlntgVarLocal;
                    }
                    synchronized (mainActivity.ibfmasn) {
                        try {
                            mainActivity.tmdubwv = false;
                            StringBuilder sb = new StringBuilder();
                            for (String str17 : (ArrayDeque<String>) mainActivity.cugubfc) {
                                if (sb.length() != 0) {
                                    sb.append('\n');
                                }
                                sb.append(str17);
                            }
                            string = sb.toString();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    mainActivity.gzokllk = false;
                    String str18 = (String) suqlntgVar.ojyssqt;
                    if (str18 != null && (iIndexOf = str18.indexOf("SLA_LOGIN_REQUIRED:")) >= 0) {
                        int i9 = iIndexOf + 19;
                        int i10 = i9;
                        while (i10 < str18.length()) {
                            char cCharAt = str18.charAt(i10);
                            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_' && cCharAt != '-') {
                                break;
                            } else {
                                i10++;
                            }
                        }
                        String strTrim = str18.substring(i9, i10).trim();
                        if (strTrim.isEmpty()) {
                            strTrim = "DA";
                        }
                        str = strTrim;
                    } else {
                        str = null;
                    }
                    if (str == null && !mainActivity.nsyqsfj && mainActivity.qwgjehf && i4 == mainActivity.bgmsltp && (str13 = (String) suqlntgVar.ojyssqt) != null) {
                        String lowerCase2 = str13.toLowerCase(Locale.ROOT);
                        if (lowerCase2.contains("operation was cancelled") || lowerCase2.contains("discarded") || lowerCase2.contains("sla_login_required:") || !(lowerCase2.contains("input/output error") || lowerCase2.contains("i/o error") || lowerCase2.contains("handshake bulk read failed") || lowerCase2.contains("overflow") || lowerCase2.contains("timeout") || lowerCase2.contains("no device") || lowerCase2.contains("nodevice"))) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (mainActivity.nsyqsfj || !mainActivity.qwgjehf || i4 != mainActivity.bgmsltp) {
                        mainActivity.jvtqflj = null;
                    } else if (!z || mainActivity.yjbrzgu >= 1) {
                        String str19 = (String) suqlntgVar.ojyssqt;
                        Pattern pattern2 = x.jvtqflj.nmpwovh;
                        if (str19 != null && !str19.trim().isEmpty()) {
                            String strTrim2 = str19.replace("\r", "").trim();
                            if (!strTrim2.startsWith("OK\n")) {
                                String strTrim3 = strTrim2.equals("ERROR") ? "" : strTrim2.startsWith("ERROR\n") ? strTrim2.substring(6).trim() : strTrim2;
                                if (strTrim3.isEmpty()) {
                                    strTrim3 = "Native returned an error without a description.";
                                }
                                String strTrim4 = string == null ? "" : string.replace("\r", "").trim();
                                String strNmpwovh2 = x.jvtqflj.nmpwovh(strTrim3);
                                if (strTrim4.isEmpty()) {
                                    strNmpwovh = "";
                                } else {
                                    String[] strArrSplit = strTrim4.split("\n");
                                    int length = strArrSplit.length - 1;
                                    while (true) {
                                        if (length < 0) {
                                            z2 = false;
                                            strNmpwovh = "";
                                            break;
                                        }
                                        String strTrim5 = strArrSplit[length].trim();
                                        String lowerCase3 = strTrim5.toLowerCase(Locale.ROOT);
                                        String[] strArr = strArrSplit;
                                        if (strTrim5.startsWith("@PLOG") || strTrim5.startsWith("@PLOG\t") || !(lowerCase3.contains("error") || lowerCase3.contains("failed") || lowerCase3.contains("rejected") || lowerCase3.contains("transport lost"))) {
                                            length--;
                                            strArrSplit = strArr;
                                        } else {
                                            if (strTrim5.length() > 350) {
                                                StringBuilder sb2 = new StringBuilder();
                                                z4 = false;
                                                sb2.append(strTrim5.substring(0, 350));
                                                sb2.append("…");
                                                strTrim5 = sb2.toString();
                                            } else {
                                                z4 = false;
                                            }
                                            strNmpwovh = x.jvtqflj.nmpwovh(strTrim5);
                                        }
                                    }
                                    pattern = x.jvtqflj.nmpwovh;
                                    matcher = pattern.matcher(strTrim3);
                                    if (matcher.find()) {
                                        strGroup = matcher.group();
                                    } else {
                                        strGroup = "";
                                    }
                                    if (strGroup.isEmpty()) {
                                        matcher2 = pattern.matcher(strNmpwovh);
                                        if (matcher2.find()) {
                                            strGroup2 = matcher2.group();
                                        } else {
                                            strGroup2 = "";
                                        }
                                        str2 = strGroup2;
                                    } else {
                                        str2 = strGroup;
                                    }
                                    StringBuilder sb3 = new StringBuilder("NATIVE RESULT:\n");
                                    sb3.append(x.jvtqflj.nmpwovh(strTrim2));
                                    sb3.append(strTrim4.isEmpty() ? "" : "\n\nRECENT NATIVE EVENTS (THIS ATTEMPT):\n" + x.jvtqflj.nmpwovh(strTrim4));
                                    String string2 = sb3.toString();
                                    lowerCase = strTrim3.toLowerCase(Locale.ROOT);
                                    if (!lowerCase.contains("0x1d0d") || lowerCase.contains("sla challenge not completed")) {
                                        str3 = "SLA challenge incomplete";
                                        str4 = "Check the authorization flow and device security mode; the SLA challenge did not complete.";
                                    } else {
                                        if (lowerCase.contains("0x7020") || lowerCase.contains("sla verification failed")) {
                                            str7 = "SLA verification rejected";
                                            str8 = "The device rejected the SLA verification. Inspect the signer response and matching device profile; reconnecting alone will not fix an invalid response.";
                                        } else {
                                            if (lowerCase.contains("invalid signature length") || lowerCase.contains("signature length")) {
                                                str9 = "Invalid signature length";
                                                str10 = "Inspect the authorization server response format and expected signature length; do not retry the same payload blindly.";
                                            } else if (lowerCase.contains("china device, not support") || lowerCase.contains("china device, not supported")) {
                                                str9 = "Authorization service rejected device";
                                                str10 = "The remote signer reported that this device is unsupported. This is not evidence of a USB cable problem.";
                                            } else if ((lowerCase.contains("sec da") && lowerCase.contains("signature")) || lowerCase.contains("da signature") || lowerCase.contains("signature verification failed")) {
                                                str9 = "DA signature verification failed";
                                                str10 = "Check whether the selected DA and authorization data match this device and firmware.";
                                            } else if (lowerCase.contains("sla_login_required:") || lowerCase.contains("authorization required")) {
                                                str7 = "Authorization required";
                                                str8 = "Complete the requested authorization and resume the same connection flow.";
                                            } else if ((lowerCase.contains("auth") && (lowerCase.contains("fail") || lowerCase.contains("rejected"))) || (lowerCase.contains("authorization") && lowerCase.contains("error"))) {
                                                str7 = "Authorization failed";
                                                str8 = "Read the reported server/BROM rejection above and check the authorization flow or credentials.";
                                            } else if (lowerCase.contains("0x7016")) {
                                                str7 = "DA reported status 0x7016";
                                                str8 = "The precise meaning of this status is not verified for this DA. Use the native details instead of assuming an authorization or cable failure.";
                                            } else if (lowerCase.contains("preloader") && (lowerCase.contains("handshake") || lowerCase.contains("fail"))) {
                                                str3 = "Preloader handshake failed";
                                                str4 = "Check the connection mode and the detailed handshake error above.";
                                            } else {
                                                if ((lowerCase.contains("brom") && (lowerCase.contains("handshake") || lowerCase.contains("fail"))) || (lowerCase.contains("bootrom") && lowerCase.contains("handshake"))) {
                                                    str3 = "BROM handshake failed";
                                                    str4 = "Inspect the handshake rejection before reconnecting in BROM mode.";
                                                } else if (lowerCase.contains("da") && (lowerCase.contains("upload") || lowerCase.contains("send da") || lowerCase.contains("enter da mode") || lowerCase.contains("da init"))) {
                                                    str7 = "DA bootstrap failed";
                                                    str8 = "Check the reported protocol/status and DA compatibility. A failed DA upload does not necessarily mean the USB cable is faulty.";
                                                } else {
                                                    if (lowerCase.contains("permission denied") || lowerCase.contains("usb permission")) {
                                                        str11 = "USB permission denied";
                                                        str12 = "Grant this app USB access to the selected device and reconnect it.";
                                                    } else if (lowerCase.contains("errno 19") || lowerCase.contains("errno: 19") || lowerCase.contains("no such device") || lowerCase.contains("device disconnected") || lowerCase.contains("usb lost") || lowerCase.contains("transport endpoint shutdown") || lowerCase.contains("errno 108")) {
                                                        str11 = "USB transport disconnected";
                                                        str12 = "The Android USB endpoint is no longer available. Inspect device re-enumeration and USB permission before retrying.";
                                                    } else if (lowerCase.contains("overflow") || lowerCase.contains("bulk read failed") || lowerCase.contains("input/output error") || lowerCase.contains("i/o error")) {
                                                        str11 = "USB transfer failed";
                                                        str12 = "Check the transfer context and endpoint shown in native details. A transport failure alone does not establish its root cause.";
                                                    } else if (lowerCase.contains("timeout") || lowerCase.contains("timed out")) {
                                                        str11 = "Connection timed out";
                                                        str12 = "Check the last completed connection stage and whether the phone re-enumerated before retrying.";
                                                    } else if (lowerCase.contains("da file") || lowerCase.contains("da path") || lowerCase.contains("unable to read da")) {
                                                        str9 = "DA file unavailable";
                                                        str10 = "Check the selected DA path and Android storage permission.";
                                                    } else {
                                                        str5 = "Connection failed";
                                                        str6 = "Read the native error above. Retry only after identifying its cause.";
                                                        i3 = 4;
                                                    }
                                                    str5 = str11;
                                                    str6 = str12;
                                                    i3 = 1;
                                                }
                                                z3 = true;
                                                yhrqvllVar = new yhrqvll(str5, str6, i3, z3, strNmpwovh2, str2, strNmpwovh, string2);
                                            }
                                            str5 = str9;
                                            z3 = z2;
                                            str6 = str10;
                                            i3 = 3;
                                            yhrqvllVar = new yhrqvll(str5, str6, i3, z3, strNmpwovh2, str2, strNmpwovh, string2);
                                        }
                                        str5 = str7;
                                        str6 = str8;
                                        i3 = 3;
                                        z3 = true;
                                        yhrqvllVar = new yhrqvll(str5, str6, i3, z3, strNmpwovh2, str2, strNmpwovh, string2);
                                    }
                                    str5 = str3;
                                    str6 = str4;
                                    i3 = 2;
                                    z3 = true;
                                    yhrqvllVar = new yhrqvll(str5, str6, i3, z3, strNmpwovh2, str2, strNmpwovh, string2);
                                }
                                z2 = z4;
                                pattern = x.jvtqflj.nmpwovh;
                                matcher = pattern.matcher(strTrim3);
                                if (matcher.find()) {
                                    strGroup = matcher.group();
                                } else {
                                    strGroup = "";
                                }
                                if (strGroup.isEmpty()) {
                                    matcher2 = pattern.matcher(strNmpwovh);
                                    if (matcher2.find()) {
                                        strGroup2 = matcher2.group();
                                    } else {
                                        strGroup2 = "";
                                    }
                                    str2 = strGroup2;
                                } else {
                                    str2 = strGroup;
                                }
                                StringBuilder sb4 = new StringBuilder("NATIVE RESULT:\n");
                                sb4.append(x.jvtqflj.nmpwovh(strTrim2));
                                if (strTrim4.isEmpty()) {
                                }
                                sb4.append(strTrim4.isEmpty() ? "" : "\n\nRECENT NATIVE EVENTS (THIS ATTEMPT):\n" + x.jvtqflj.nmpwovh(strTrim4));
                                String string3 = sb4.toString();
                                lowerCase = strTrim3.toLowerCase(Locale.ROOT);
                                if (lowerCase.contains("0x1d0d")) {
                                    str3 = "SLA challenge incomplete";
                                    str4 = "Check the authorization flow and device security mode; the SLA challenge did not complete.";
                                    str5 = str3;
                                    str6 = str4;
                                    i3 = 2;
                                    z3 = true;
                                } else {
                                    str3 = "SLA challenge incomplete";
                                    str4 = "Check the authorization flow and device security mode; the SLA challenge did not complete.";
                                    str5 = str3;
                                    str6 = str4;
                                    i3 = 2;
                                    z3 = true;
                                }
                                yhrqvllVar = new yhrqvll(str5, str6, i3, z3, strNmpwovh2, str2, strNmpwovh, string3);
                            }
                        }
                        mainActivity.jvtqflj = yhrqvllVar;
                    }
                    mainActivity.runOnUiThread(new Runnable() { // from class: x.ayzlrnr
                        /* JADX WARN: Code duplicated, block: B:8:0x0029 A[PHI: r9
                          0x0029: PHI (r9v14 java.lang.String) = (r9v4 java.lang.String), (r9v5 java.lang.String) binds: [B:7:0x0027, B:10:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
                        @Override // java.lang.Runnable
                        public final void run() {
                            MainActivity mainActivity2;
                            int i11;
                            int i12;
                            x.vlyywxv vlyywxvVar;
                            char c;
                            MainActivity mainActivity3 = mainActivity;
                            suqlntg suqlntgVar2 = suqlntgVar;
                            int i13 = i4;
                            String str20 = str;
                            boolean z6 = z;
                            int i14 = i5;
                            mainActivity3.getClass();
                            String str21 = (String) suqlntgVar2.ojyssqt;
                            if (str21 == null || str21.trim().isEmpty()) {
                                mainActivity2 = mainActivity3;
                                suqlntgVar2 = suqlntgVar2;
                                i13 = i13;
                                str20 = str20;
                                z6 = z6;
                                i14 = i14;
                            } else {
                                String str22 = (String) suqlntgVar2.ojyssqt;
                                String strTrim6 = "";
                                if (str22 == null) {
                                    mainActivity2 = mainActivity3;
                                } else {
                                    strTrim6 = str22.replace("\r", "").trim();
                                    if (strTrim6.startsWith("OK\n")) {
                                        String strOohojlj = x.zamkzqg.oohojlj(strTrim6, "CHIP:");
                                        String strOohojlj2 = x.zamkzqg.oohojlj(strTrim6, "STORAGE:");
                                        String strOohojlj3 = x.zamkzqg.oohojlj(strTrim6, "BOOT MODE:");
                                        String strOohojlj4 = x.zamkzqg.oohojlj(strTrim6, "DA PROTOCOL:");
                                        String strOohojlj5 = x.zamkzqg.oohojlj(strTrim6, "HW CODE:");
                                        String strOohojlj6 = x.zamkzqg.oohojlj(strTrim6, "HW SUBCODE:");
                                        String strOohojlj7 = x.zamkzqg.oohojlj(strTrim6, "HW VERSION:");
                                        String strOohojlj8 = x.zamkzqg.oohojlj(strTrim6, "SW VERSION:");
                                        String strOohojlj9 = x.zamkzqg.oohojlj(strTrim6, "TARGET CONFIG:");
                                        String strOohojlj10 = x.zamkzqg.oohojlj(strTrim6, "MEID:");
                                        String strOohojlj11 = x.zamkzqg.oohojlj(strTrim6, "SOC ID:");
                                        String strOohojlj12 = x.zamkzqg.oohojlj(strTrim6, "SBC:");
                                        String strOohojlj13 = x.zamkzqg.oohojlj(strTrim6, "SLA:");
                                        String strOohojlj14 = x.zamkzqg.oohojlj(strTrim6, "DAA:");
                                        StringBuilder sb5 = new StringBuilder();
                                        if (!strOohojlj.isEmpty()) {
                                            sb5.append("Rynx ✦  CPU : ");
                                            sb5.append(strOohojlj);
                                            sb5.append('\n');
                                        }
                                        sb5.append("Rynx ✦  =====================================\n");
                                        if (strOohojlj12.isEmpty()) {
                                            c = '\n';
                                        } else {
                                            sb5.append("Rynx ✦  SBC: ");
                                            sb5.append("ENABLED".equalsIgnoreCase(strOohojlj12));
                                            c = '\n';
                                            sb5.append('\n');
                                        }
                                        if (!strOohojlj13.isEmpty()) {
                                            sb5.append("Rynx ✦  SLA: ");
                                            sb5.append("ENABLED".equalsIgnoreCase(strOohojlj13));
                                            sb5.append(c);
                                        }
                                        if (!strOohojlj14.isEmpty()) {
                                            sb5.append("Rynx ✦  DAA: ");
                                            sb5.append("ENABLED".equalsIgnoreCase(strOohojlj14));
                                            sb5.append(c);
                                        }
                                        sb5.append("Rynx ✦  =====================================\n");
                                        if (!strOohojlj2.isEmpty()) {
                                            sb5.append("Rynx ✦  Storage: ");
                                            sb5.append(strOohojlj2);
                                            sb5.append(c);
                                        }
                                        if (!strOohojlj3.isEmpty()) {
                                            sb5.append("Rynx ✦  Boot mode: ");
                                            sb5.append(strOohojlj3);
                                            sb5.append(c);
                                        }
                                        if (!strOohojlj4.isEmpty()) {
                                            sb5.append("Rynx ✦  DA protocol: ");
                                            sb5.append(strOohojlj4);
                                            sb5.append(c);
                                        }
                                        if (!strOohojlj5.isEmpty()) {
                                            sb5.append("Rynx ✦  HW code: ");
                                            sb5.append(strOohojlj5);
                                            sb5.append(c);
                                        }
                                        if (!strOohojlj6.isEmpty()) {
                                            sb5.append("Rynx ✦  HW subcode: ");
                                            sb5.append(strOohojlj6);
                                            sb5.append(c);
                                        }
                                        if (!strOohojlj7.isEmpty()) {
                                            sb5.append("Rynx ✦  HW version: ");
                                            sb5.append(strOohojlj7);
                                            sb5.append(c);
                                        }
                                        if (!strOohojlj8.isEmpty()) {
                                            sb5.append("Rynx ✦  SW version: ");
                                            sb5.append(strOohojlj8);
                                            sb5.append(c);
                                        }
                                        if (!strOohojlj9.isEmpty()) {
                                            sb5.append("Rynx ✦  Target config: ");
                                            sb5.append(strOohojlj9);
                                            sb5.append(c);
                                        }
                                        if (!strOohojlj10.isEmpty()) {
                                            sb5.append("Rynx ✦  MEID: ");
                                            sb5.append(strOohojlj10);
                                            sb5.append(c);
                                        }
                                        if (!strOohojlj11.isEmpty()) {
                                            sb5.append("Rynx ✦  SOC ID: ");
                                            sb5.append(strOohojlj11);
                                            sb5.append(c);
                                        }
                                        ArrayList<ohwxijw> arrayListRpdxrib2 = x.zamkzqg.rpdxrib(strTrim6);
                                        if (!arrayListRpdxrib2.isEmpty()) {
                                            sb5.append("Rynx ✦  Retrieving partition information...\nRynx ✦  Partition Table:\n");
                                            for (ohwxijw ohwxijwVar : arrayListRpdxrib2) {
                                                Locale locale = Locale.ROOT;
                                                String str23 = ohwxijwVar.nmpwovh;
                                                long j2 = ohwxijwVar.vivhedu;
                                                sb5.append(String.format(locale, "Rynx ✦  Name: %-30s Addr: %-18s       Size: 0x%016X %-14s Section: %s%n", str23, ohwxijwVar.ojyssqt, Long.valueOf(j2), "(" + x.zamkzqg.jybecxv(j2) + ")", ohwxijwVar.lthborb));
                                            }
                                        }
                                        strTrim6 = sb5.toString().trim();
                                        mainActivity2 = mainActivity3;
                                    } else {
                                        mainActivity2 = mainActivity3;
                                    }
                                }
                                mainActivity2.nmpwovh(strTrim6);
                            }
                            if (mainActivity2.nsyqsfj) {
                                mainActivity2.nmpwovh(mainActivity2.getString(R.string.gui_session_persistent));
                                suqlntgVar2 = suqlntgVar2;
                                i11 = i13;
                            } else {
                                if (mainActivity2.qwgjehf) {
                                    i11 = i13;
                                    if (i11 == mainActivity2.bgmsltp) {
                                        suqlntgVar2 = suqlntgVar2;
                                        mainActivity2.nmpwovh(mainActivity2.getString(R.string.gui_session_failed, Integer.valueOf(suqlntgVar2.nmpwovh)));
                                    }
                                } else {
                                    i11 = i13;
                                }
                                mainActivity2.nmpwovh(mainActivity2.getString(R.string.gui_session_discarded));
                            }
                            mainActivity2.gefzxcg();
                            if (str20 != null && mainActivity2.qwgjehf && i11 == mainActivity2.bgmsltp) {
                                if (mainActivity2.rpilpcp) {
                                    return;
                                }
                                String str24 = "DA".equalsIgnoreCase(str20) ? "DA" : "BROM";
                                mainActivity2.rpilpcp = true;
                                ednetju ednetjuVarYrgokys = mainActivity2.yrgokys(str24);
                                mainActivity2.nmpwovh("[SLA] Remote authorization is required; login requested only for this SLA device.");
                                x.zamkzqg.nsbgblf(mainActivity2, str24, ednetjuVarYrgokys, new suqlntg(mainActivity2, i11));
                                return;
                            }
                            if (z6 && mainActivity2.qwgjehf && i11 == mainActivity2.bgmsltp && !mainActivity2.nsyqsfj && !mainActivity2.gzokllk) {
                                if (mainActivity2.wygqgxb != i11) {
                                    mainActivity2.wygqgxb = i11;
                                    mainActivity2.yjbrzgu = 0;
                                }
                                if (mainActivity2.yjbrzgu < 1) {
                                    mainActivity2.yjbrzgu++;
                                    mainActivity2.nmpwovh("[USB] DA bootstrap transport failed; recycling UsbDeviceConnection before one fresh retry.");
                                    mainActivity2.nkemejx();
                                    wdznaie wdznaieVar = new wdznaie(mainActivity2, i11, 2);
                                    View decorView = mainActivity2.getWindow() == null ? null : mainActivity2.getWindow().getDecorView();
                                    if (decorView != null) {
                                        decorView.postDelayed(wdznaieVar, 200L);
                                        return;
                                    } else {
                                        wdznaieVar.run();
                                        return;
                                    }
                                }
                                mainActivity2.nmpwovh("[USB] Fresh USB retry already used; leaving the failed session stopped.");
                                mainActivity2.qwgjehf = false;
                                mainActivity2.mwngani = false;
                                mainActivity2.bgmsltp++;
                                mainActivity2.wygqgxb = -1;
                                mainActivity2.yjbrzgu = 0;
                                mainActivity2.gefzxcg();
                            }
                            if (!mainActivity2.nsyqsfj && mainActivity2.qwgjehf && i11 == mainActivity2.bgmsltp) {
                                String str25 = (String) suqlntgVar2.ojyssqt;
                                if (i14 > 0 && (i12 = i14) == mainActivity2.zyxfuka && i12 == mainActivity2.zsbaukl && (vlyywxvVar = mainActivity2.zwccvwt) != null && vlyywxvVar.ojyssqt.isShowing() && !vlyywxvVar.pvkaerr) {
                                    boolean z7 = vlyywxvVar.uiqyzsp;
                                    boolean z8 = (mainActivity2.dreanqi == null || mainActivity2.dreanqi.isEmpty()) ? false : true;
                                    mainActivity2.nativeSetXiaomiAuthGeneration(0);
                                    if (!z8) {
                                        mainActivity2.ysluikv("session failure");
                                    }
                                    String strReplaceAll = (str25 == null ? "Device/session initialization failed." : str25.replace('\r', ' ').replace('\n', ' ').replace('\t', ' ').trim()).replaceAll("(?i)(?:0x)?[0-9a-f]{32,}", "[HEX_REDACTED]").replaceAll("[A-Za-z0-9+/]{40,}={0,2}", "[DATA_REDACTED]");
                                    if (strReplaceAll.length() > 220) {
                                        strReplaceAll = strReplaceAll.substring(0, 220) + "…";
                                    }
                                    mainActivity2.pmsrvoc(i12, "Session stopped: ".concat(strReplaceAll.isEmpty() ? "Device/session initialization failed." : strReplaceAll), (z7 || z8) ? false : true);
                                }
                            }
                            if (mainActivity2.nsyqsfj && mainActivity2.mwngani) {
                                mainActivity2.yxcmoyp();
                            } else if ("scatter_flash".equals(mainActivity2.ayzlrnr)) {
                                mainActivity2.gzokllk();
                            }
                            mainActivity2.wdvdxhb();
                        }
                    });
                }
            });
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final String yjbrzgu(String str) {
        return getSharedPreferences("rynx_persistent_session", 0).getString(str, "");
    }

    @Override // com.rynx.app.ojyssqt
    public final void yonoayx() {
        ysluikv("stop");
        boolean z = this.qwgjehf || this.gzokllk || this.nsyqsfj || qyeibyo();
        boolean z2 = this.lpkdqgx || this.gzokllk;
        this.qwgjehf = false;
        this.mwngani = false;
        this.jvtqflj = null;
        this.rvrflql = null;
        this.tmdubwv = false;
        this.bgmsltp++;
        this.wygqgxb = -1;
        this.yjbrzgu = 0;
        this.otaqyat = false;
        this.nsyqsfj = false;
        this.cnctlxz = x.ednetju.ojyssqt();
        this.xvxmcgn = "—";
        this.ygdccqg = "";
        this.cxxnoho = "";
        this.jbmzxye.clear();
        this.ezuzoct = null;
        if (this.wdznaie != null) {
            this.iasgsgq = true;
            this.ghkjjru = "";
            ljwltks();
        }
        if (this.gjpruie != null) {
            rvrflql();
        }
        if (this.pvkaerr) {
            try {
                nativeCancelIo();
            } catch (Throwable unused) {
            }
        }
        nkemejx();
        if (this.pvkaerr) {
            this.czidoiw.execute(new yrgokys(this, 11));
        }
        TextView textView = this.hjlrtqw;
        if (textView != null && z2) {
            textView.setText(R.string.gui_stopping);
            this.hjlrtqw.setTextColor(this.oqexvyb);
        }
        nmpwovh(getString(z ? R.string.gui_stop_requested : R.string.gui_already_stopped));
        gefzxcg();
    }

    public final ednetju yrgokys(String str) {
        String str2;
        ednetju ednetjuVarOjyssqt = this.cnctlxz == null ? x.ednetju.ojyssqt() : this.cnctlxz;
        String str3 = ednetjuVarOjyssqt.nmpwovh;
        String str4 = ednetjuVarOjyssqt.vivhedu;
        String str5 = ednetjuVarOjyssqt.lthborb;
        UsbDevice usbDevice = this.ulafhci;
        if ((str3 == null || str3.isEmpty()) && usbDevice != null) {
            str3 = String.format(Locale.US, "MediaTek USB %04X:%04X", Integer.valueOf(usbDevice.getVendorId()), Integer.valueOf(usbDevice.getProductId()));
        }
        String str6 = str3;
        if ((str4 == null || str4.isEmpty()) && usbDevice != null) {
            if (usbDevice.getProductId() == 8192) {
                str4 = "PRELOADER";
            } else if (usbDevice.getProductId() == 3) {
                str2 = "BROM";
            }
            str2 = str4;
        } else {
            str2 = str4;
        }
        if (str5 == null || str5.isEmpty()) {
            str5 = "DA".equalsIgnoreCase(str) ? "Download Agent" : "BROM";
        }
        return new ednetju(str6, ednetjuVarOjyssqt.ojyssqt, str2, str5, ednetjuVarOjyssqt.qxvquar, ednetjuVarOjyssqt.oqexvyb, ednetjuVarOjyssqt.nkemejx, ednetjuVarOjyssqt.imuemzb, ednetjuVarOjyssqt.dytyqos, ednetjuVarOjyssqt.wqrnifx, ednetjuVarOjyssqt.dasxvpc, ednetjuVarOjyssqt.dplrlfq, ednetjuVarOjyssqt.ulafhci, ednetjuVarOjyssqt.ekyqleu, ednetjuVarOjyssqt.utmeivs);
    }

    public final suqlntg zamkzqg(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.qwgjehf || this.gzokllk || this.nsyqsfj) {
            return new suqlntg(2, getString(R.string.error_terminal_gui_active_native));
        }
        if (this.ulafhci == null || x.zamkzqg.pmsrvoc(this.ulafhci)) {
            if (!qyeibyo()) {
                runOnUiThread(new yrgokys(this, 10));
                long jCurrentTimeMillis = System.currentTimeMillis() + 60000;
                while (true) {
                    if (System.currentTimeMillis() < jCurrentTimeMillis) {
                        if (qyeibyo()) {
                            break;
                        }
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
            oxoagud oxoagudVarEzxxysz = ezxxysz();
            if (oxoagudVarEzxxysz.nmpwovh < 0) {
                return new suqlntg(2, getString(R.string.error_usb_lost_command));
            }
            this.otaqyat = true;
            try {
                String strNativeRunCommand = nativeRunCommand(oxoagudVarEzxxysz.nmpwovh, oxoagudVarEzxxysz.ojyssqt, str == null ? "" : str, str2 == null ? "" : str2, str3 == null ? "" : str3, str4 == null ? "" : str4, str5 == null ? "" : str5, str6 == null ? "" : str6);
                int i = ((strNativeRunCommand == null || !strNativeRunCommand.startsWith("OK\n")) ? 0 : 1) ^ 1;
                if (strNativeRunCommand == null) {
                    strNativeRunCommand = getString(R.string.error_jni_null);
                }
                suqlntg suqlntgVar = new suqlntg(i, strNativeRunCommand);
                this.otaqyat = false;
                return suqlntgVar;
            } catch (Throwable th) {
                try {
                    return new suqlntg(1, getString(R.string.error_jni, String.valueOf(th)));
                } finally {
                    this.otaqyat = false;
                }
            }
        }
        return new suqlntg(2, getString(R.string.error_no_authorized_mtk));
    }

    /* JADX WARN: Code duplicated, block: B:187:0x032b  */
    /* JADX WARN: Code duplicated, block: B:191:0x0337  */
    /* JADX WARN: Code duplicated, block: B:198:0x0348  */
    /* JADX WARN: Code duplicated, block: B:205:0x0378  */
    public final String zfmpmio(boolean z, String str, String str2) {
        byte[] bArrQxvquar;
        String str3;
        boolean z2;
        boolean z3;
        String str4;
        String str5;
        String message;
        String str6;
        int iMin;
        xhyvkax xhyvkaxVar = this.iqvvlnh;
        hiofinr hiofinrVar = this.qdiugcp;
        final int i = this.zyxfuka;
        if (!rrpfqyy() || xhyvkaxVar == null || hiofinrVar == null) {
            return "ERR:Xiaomi authorization must be prepared before opening the BROM challenge";
        }
        if (z != kggugdp()) {
            return "ERR:Xiaomi authorization mode changed before request dispatch";
        }
        String str7 = z ? "new_security" : "legacy";
        String strGucwjqz = gucwjqz();
        String strMcdstyz = mcdstyz();
        String str8 = this.wrbqriz;
        if (strGucwjqz.isEmpty() || strMcdstyz.isEmpty() || str8.isEmpty() || !strGucwjqz.equals(this.gdkopre) || !strMcdstyz.equalsIgnoreCase(this.vlyywxv) || !str7.equalsIgnoreCase(this.nlcdwap)) {
            return "ERR:Prepared Xiaomi authorization profile no longer matches the selected device";
        }
        byte[] bArrQxvquar2 = com.rynx.app.ojyssqt.qxvquar(str2);
        if (bArrQxvquar2 == null || bArrQxvquar2.length != 16) {
            return "ERR:Xiaomi BROM SLA requires a 16-byte challenge";
        }
        for (byte b : bArrQxvquar2) {
            if (b != 0) {
                String strYwhgqsi = ywhgqsi(bArrQxvquar2);
                if (z) {
                    bArrQxvquar = com.rynx.app.ojyssqt.qxvquar(str);
                    if (bArrQxvquar == null || bArrQxvquar.length != 32) {
                        return "ERR:SLA_NEW requires a 32-byte SOCID";
                    }
                    for (byte b2 : bArrQxvquar) {
                        if (b2 == 0) {
                        }
                    }
                    return "ERR:SLA_NEW requires a 32-byte SOCID";
                }
                bArrQxvquar = null;
                String strYwhgqsi2 = bArrQxvquar == null ? "" : ywhgqsi(bArrQxvquar);
                StringBuilder sb = new StringBuilder();
                sb.append(z ? "4e4557534543" + strYwhgqsi2 : "4c4547414359");
                sb.append(strYwhgqsi);
                String strJybecxv = com.rynx.app.ojyssqt.jybecxv(sb.toString());
                if (strJybecxv.isEmpty()) {
                    return "ERR:Duplicate Xiaomi authorization request blocked";
                }
                synchronized (this.haevqmd) {
                    if (this.eldycgp.isEmpty() && !this.icjnmlh.contains(strJybecxv)) {
                        this.eldycgp = strJybecxv;
                        try {
                            runOnUiThread(new pwnmyid(this, str7, i, 0));
                            z2 = true;
                            str3 = strJybecxv;
                            try {
                                try {
                                    try {
                                        dasxvpc dasxvpcVarXhyvkax = xhyvkax(xhyvkaxVar, hiofinrVar, str8, strGucwjqz, strMcdstyz, str7, strYwhgqsi, strYwhgqsi2, i);
                                        try {
                                            fixfqug(str3);
                                            this.dreanqi = (String) dasxvpcVarXhyvkax.ojyssqt;
                                            this.qdiugcp = null;
                                            this.gdkopre = "";
                                            this.vlyywxv = "";
                                            this.nlcdwap = "";
                                            this.wrbqriz = "";
                                            runOnUiThread(new rrpfqyy(this, (String) dasxvpcVarXhyvkax.ojyssqt, dasxvpcVarXhyvkax, i, 4));
                                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                                            int i2 = dasxvpcVarXhyvkax.nmpwovh;
                                            String str9 = (String) dasxvpcVarXhyvkax.vivhedu;
                                            if (str9 == null) {
                                                str9 = "";
                                            }
                                            int i3 = 0;
                                            while (true) {
                                                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                                if (jElapsedRealtime2 > 105000) {
                                                    runOnUiThread(new wdznaie(this, i, 1));
                                                    return "ERR:Xiaomi authorization timed out waiting for a terminal server result";
                                                }
                                                if (i3 <= 0) {
                                                    iMin = 250;
                                                } else {
                                                    int i4 = jElapsedRealtime2 < 10000 ? 500 : 1000;
                                                    if (i2 <= 0) {
                                                        i2 = i4;
                                                    }
                                                    iMin = Math.min(1000, Math.max(i4, i2));
                                                }
                                                Thread.sleep(iMin);
                                                i3++;
                                                try {
                                                    nnkxxji nnkxxjiVarYztlqms = yztlqms((String) dasxvpcVarXhyvkax.ojyssqt, xhyvkaxVar);
                                                    int i5 = nnkxxjiVarYztlqms.qxvquar;
                                                    if (!nnkxxjiVarYztlqms.ojyssqt.isEmpty() && !nnkxxjiVarYztlqms.ojyssqt.equals(str9)) {
                                                        str9 = nnkxxjiVarYztlqms.ojyssqt;
                                                        runOnUiThread(new pwnmyid(this, str9, i, 2));
                                                    }
                                                    if (nnkxxjiVarYztlqms.nmpwovh()) {
                                                        final String str10 = nnkxxjiVarYztlqms.vivhedu.isEmpty() ? "AUTHORIZATION_FAILED" : nnkxxjiVarYztlqms.vivhedu;
                                                        final String str11 = str10 + (nnkxxjiVarYztlqms.lthborb.isEmpty() ? "" : ": " + nnkxxjiVarYztlqms.lthborb);
                                                        final String str12 = nnkxxjiVarYztlqms.lthborb;
                                                        final boolean zEqualsIgnoreCase = "review_required".equalsIgnoreCase(nnkxxjiVarYztlqms.nmpwovh);
                                                        runOnUiThread(new Runnable() { // from class: x.ijakhcl
                                                            public final /* synthetic */ MainActivity nmpwovh = MainActivity.this;
                                                            @Override // java.lang.Runnable
                                                            public final void run() {
                                                                int[] iArr = MainActivity.rzsxsyc;
                                                                MainActivity mainActivity = this.nmpwovh;
                                                                x.vlyywxv vlyywxvVar = mainActivity.zwccvwt;
                                                                if (vlyywxvVar == null || !vlyywxvVar.ojyssqt.isShowing() || !zEqualsIgnoreCase) {
                                                                    mainActivity.pmsrvoc(i, "Server failed: " + str11, false);
                                                                    return;
                                                                }
                                                                x.nlcdwap nlcdwapVar = vlyywxvVar.vivhedu;
                                                                nlcdwapVar.lthborb = "review_required";
                                                                nlcdwapVar.utmeivs = x.nlcdwap.oqexvyb(str10);
                                                                nlcdwapVar.oqexvyb = "Authorization needs review";
                                                                String str13 = str12;
                                                                nlcdwapVar.nkemejx = x.nlcdwap.qxvquar(str13, "The upstream result is uncertain and needs manual review.");
                                                                nlcdwapVar.ojyssqt(str13);
                                                                nlcdwapVar.buswjhz = true;
                                                                nlcdwapVar.pvbzgon = false;
                                                                com.rynx.app.nmpwovh nmpwovhVar = vlyywxvVar.nmpwovh;
                                                                nlcdwapVar.nkemejx(nmpwovhVar.getString(R.string.xiaomi_auth_progress_hero_review), nmpwovhVar.getString(R.string.xiaomi_auth_progress_status_review), (str13 == null || str13.trim().isEmpty()) ? nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_review) : nlcdwapVar.nkemejx);
                                                                vlyywxvVar.pvkaerr = true;
                                                                vlyywxvVar.uiqyzsp = false;
                                                                vlyywxvVar.qwgjehf = null;
                                                                vlyywxvVar.ekyqleu(true);
                                                                vlyywxvVar.lthborb(false);
                                                                vlyywxvVar.qxvquar();
                                                            }
                                                        });
                                                        return "ERR:" + str11;
                                                    }
                                                    if ("ready".equalsIgnoreCase(nnkxxjiVarYztlqms.nmpwovh)) {
                                                        try {
                                                            dplrlfq dplrlfqVarTqcgjht = tqcgjht((String) dasxvpcVarXhyvkax.ojyssqt, xhyvkaxVar);
                                                            byte[] bArrLthborb = dplrlfqVarTqcgjht.lthborb();
                                                            if (!z && bArrLthborb.length != 256) {
                                                                return "ERR:Xiaomi legacy response must be exactly 256 bytes";
                                                            }
                                                            String strYwhgqsi3 = ywhgqsi(bArrLthborb);
                                                            String strJybecxv2 = com.rynx.app.ojyssqt.jybecxv(strYwhgqsi3);
                                                            if (!((String) dplrlfqVarTqcgjht.ojyssqt).isEmpty() && !((String) dplrlfqVarTqcgjht.ojyssqt).equalsIgnoreCase(strJybecxv2)) {
                                                                return "ERR:Xiaomi authorization response hash mismatch";
                                                            }
                                                            if (!((String) dplrlfqVarTqcgjht.ojyssqt).isEmpty()) {
                                                                strJybecxv2 = (String) dplrlfqVarTqcgjht.ojyssqt;
                                                            }
                                                            this.ebrwptg = strJybecxv2;
                                                            runOnUiThread(new mwocrhx(this, bArrLthborb.length, i, 2));
                                                            return "OK:" + strYwhgqsi3;
                                                        } catch (IOException e) {
                                                            runOnUiThread(new pwnmyid(this, i, e.getClass().getSimpleName(), 3));
                                                            i2 = 250;
                                                        } catch (czgynww e2) {
                                                            if (!xbdyiew(e2)) {
                                                                throw e2;
                                                            }
                                                            runOnUiThread(new mwocrhx(this, i, e2.ojyssqt, 1));
                                                            i2 = 250;
                                                        }
                                                    } else {
                                                        i2 = i5;
                                                    }
                                                } catch (IOException e3) {
                                                    runOnUiThread(new pwnmyid(this, i, e3.getClass().getSimpleName(), 1));
                                                } catch (czgynww e4) {
                                                    if (!xbdyiew(e4)) {
                                                        throw e4;
                                                    }
                                                    runOnUiThread(new mwocrhx(this, i, e4.ojyssqt, 0));
                                                }
                                            }
                                        } catch (czgynww e5) {
                                            z3 = true;
                                            if (!z2) {
                                                if (z3) {
                                                    hfkdhls(str3);
                                                } else {
                                                    hfkdhls(str3);
                                                }
                                            }
                                            str4 = e5.nmpwovh;
                                            if (str4 != null) {
                                                str5 = "BROKER_ERROR";
                                            } else {
                                                str5 = "BROKER_ERROR";
                                            }
                                            message = e5.getMessage();
                                            StringBuilder sb2 = new StringBuilder("ERR:");
                                            sb2.append(str5);
                                            if (message != null) {
                                                str6 = "";
                                            } else {
                                                str6 = "";
                                            }
                                            sb2.append(str6);
                                            return sb2.toString();
                                        }
                                    } catch (czgynww e6) {
                                        z3 = true;
                                        z2 = false;
                                        if (!z2) {
                                            if (z3 || !xbdyiew(e6)) {
                                                hfkdhls(str3);
                                            } else {
                                                fixfqug(str3);
                                            }
                                        }
                                        str4 = e6.nmpwovh;
                                        if (str4 != null || str4.isEmpty()) {
                                            str5 = "BROKER_ERROR";
                                        } else {
                                            str5 = e6.nmpwovh;
                                        }
                                        message = e6.getMessage();
                                        StringBuilder sb3 = new StringBuilder("ERR:");
                                        sb3.append(str5);
                                        if (message != null || message.trim().isEmpty()) {
                                            str6 = "";
                                        } else {
                                            str6 = ": " + message.trim();
                                        }
                                        sb3.append(str6);
                                        return sb3.toString();
                                    }
                                } catch (IOException e7) {
                                    if (z2) {
                                        fixfqug(str3);
                                    } else {
                                        hfkdhls(str3);
                                    }
                                    return "ERR:Xiaomi authorization transport failed after same-job recovery deadline: ".concat(e7.getClass().getSimpleName());
                                }
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                if (z2) {
                                    fixfqug(str3);
                                    return "ERR:Xiaomi authorization wait interrupted";
                                }
                                hfkdhls(str3);
                                return "ERR:Xiaomi authorization wait interrupted";
                            } catch (Throwable th) {
                                if (z2) {
                                    fixfqug(str3);
                                } else {
                                    hfkdhls(str3);
                                }
                                return "ERR:Xiaomi authorization failed: ".concat(th.getClass().getSimpleName());
                            }
                        } catch (Throwable th2) {
                            str3 = strJybecxv;
                            z2 = false;
                        }
                    }
                    return "ERR:Duplicate Xiaomi authorization request blocked";
                }
            }
        }
        return "ERR:Xiaomi BROM SLA requires a 16-byte challenge";
    }

    public final File zhpnlmy(String str) {
        if (str == null || str.isEmpty() || str.equals(".")) {
            return this.sfildfy;
        }
        if (str.equals("~") || str.equals("/sdcard")) {
            return new File("/storage/emulated/0");
        }
        if (str.startsWith("/sdcard/")) {
            str = "/storage/emulated/0/" + str.substring(8);
        }
        File file = new File(str);
        return file.isAbsolute() ? file : new File(this.sfildfy, str);
    }

    public final void znfyiic() {
        if (this.nxumtuo || this.dvzxbaj || this.ltnesel == null) {
            return;
        }
        UsbDevice usbDevice = this.ulafhci;
        if (x.zamkzqg.nsyqsfj(usbDevice) != 2 || !qyeibyo()) {
            wfxzfba(false);
            return;
        }
        UsbDeviceConnection usbDeviceConnectionCzgynww = czgynww(usbDevice);
        if (usbDeviceConnectionCzgynww == null) {
            wfxzfba(false);
            return;
        }
        this.nxumtuo = true;
        wfxzfba(false);
        this.slxntng.execute(new ekyqleu(this, usbDevice, usbDeviceConnectionCzgynww, 0));
    }
}
