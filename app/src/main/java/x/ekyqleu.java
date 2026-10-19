package x;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.os.ParcelFileDescriptor;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import com.rynx.app.adbfastboot.AdbFastbootNative;
import java.io.File;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ekyqleu implements Runnable {
    public final /* synthetic */ Object lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Activity ojyssqt;
    public final /* synthetic */ Object vivhedu;

    public /* synthetic */ ekyqleu(Activity activity, Object obj, Object obj2, int i) {
        this.nmpwovh = i;
        this.ojyssqt = activity;
        this.vivhedu = obj;
        this.lthborb = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:146:0x0348  */
    /* JADX WARN: Code duplicated, block: B:151:0x035b A[Catch: all -> 0x0393, TryCatch #8 {all -> 0x0393, blocks: (B:148:0x034b, B:149:0x0355, B:151:0x035b, B:164:0x0398, B:154:0x0362, B:156:0x0372, B:158:0x0382, B:163:0x0395, B:165:0x039b, B:166:0x03b3), top: B:241:0x034b }] */
    /* JADX WARN: Code duplicated, block: B:153:0x0361 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:154:0x0362 A[Catch: all -> 0x0393, TryCatch #8 {all -> 0x0393, blocks: (B:148:0x034b, B:149:0x0355, B:151:0x035b, B:164:0x0398, B:154:0x0362, B:156:0x0372, B:158:0x0382, B:163:0x0395, B:165:0x039b, B:166:0x03b3), top: B:241:0x034b }] */
    /* JADX WARN: Code duplicated, block: B:238:0x0341 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:241:0x034b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        String string;
        boolean z;
        String strNkemejx;
        mslkofp mslkofpVar;
        final Throwable th;
        final boolean z2;
        final boolean z3;
        JSONArray jSONArrayQwpvrdy;
        JSONArray jSONArray;
        int i;
        JSONObject jSONObjectOptJSONObject;
        int i2;
        long[] jArr;
        EditText editText;
        wqrnifx wqrnifxVar = null;
        czgynww czgynwwVar = null;
        wqrnifxVar = null;
        int i3 = 6;
        long j = 0;
        boolean z4 = true;
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity = (MainActivity) this.ojyssqt;
                UsbDevice usbDevice = (UsbDevice) this.vivhedu;
                UsbDeviceConnection usbDeviceConnection = (UsbDeviceConnection) this.lthborb;
                mainActivity.getClass();
                try {
                    wqrnifx wqrnifxVarJdqigmr = ulafhci.jdqigmr(mainActivity.getApplicationContext(), usbDevice, usbDeviceConnection);
                    z = false;
                    z4 = false;
                    wqrnifxVar = wqrnifxVarJdqigmr;
                    string = null;
                } catch (nkemejx e) {
                    string = e.getMessage();
                    z = false;
                } catch (Throwable th2) {
                    string = th2.toString();
                    z = false;
                    z4 = false;
                }
                mainActivity.nxumtuo = z;
                mainActivity.runOnUiThread(new qwgjehf(mainActivity, wqrnifxVar, z4, string));
                return;
            case 1:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) this.lthborb;
                MainActivity mainActivity2 = (MainActivity) this.ojyssqt;
                mainActivity2.getClass();
                try {
                    try {
                        strNkemejx = AdbFastbootNative.nkemejx(parcelFileDescriptor.getFd());
                        parcelFileDescriptor.close();
                    } catch (Throwable th3) {
                        try {
                            parcelFileDescriptor.close();
                            throw th3;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                            throw th3;
                        }
                    }
                } catch (Throwable th5) {
                    strNkemejx = "ERROR\n" + th5;
                }
                if (strNkemejx == null) {
                    strNkemejx = "ERROR\nNative Fastboot returned null";
                }
                mainActivity2.runOnUiThread(new ekyqleu(mainActivity2, (UsbDevice) this.vivhedu, strNkemejx, 2));
                return;
            case 2:
                MainActivity mainActivity3 = (MainActivity) this.ojyssqt;
                UsbDevice usbDevice2 = (UsbDevice) this.vivhedu;
                String str = (String) this.lthborb;
                mainActivity3.jbmzxye();
                mainActivity3.nysvajy();
                if (mainActivity3.ulafhci == null || mainActivity3.ulafhci.getDeviceId() != usbDevice2.getDeviceId() || mainActivity3.ltnesel == null || !"android_tools".equals(mainActivity3.ayzlrnr)) {
                    return;
                }
                if (!str.startsWith("OK\n")) {
                    mainActivity3.mwocrhx();
                    mainActivity3.ltnesel.vivhedu.setText(R.string.android_tools_fastboot_failed);
                    mainActivity3.ltnesel.vivhedu.setTextColor(mainActivity3.nkemejx);
                    zamkzqg.enxkjpu(mainActivity3, mainActivity3.ltnesel.vivhedu, R.drawable.ic_warning, mainActivity3.nkemejx);
                    mainActivity3.nmpwovh("[FASTBOOT] " + str.replaceFirst("^ERROR\\n", "").trim());
                    return;
                }
                String strOohojlj = zamkzqg.oohojlj(str, "MODE:");
                String strOohojlj2 = zamkzqg.oohojlj(str, "PRODUCT:");
                String strOohojlj3 = zamkzqg.oohojlj(str, "SERIAL:");
                String strOohojlj4 = zamkzqg.oohojlj(str, "CURRENT SLOT:");
                String strOohojlj5 = zamkzqg.oohojlj(str, "UNLOCKED:");
                String strOohojlj6 = zamkzqg.oohojlj(str, "BOOTLOADER:");
                TextView textView = mainActivity3.ltnesel.nmpwovh;
                if (com.rynx.app.ojyssqt.zwaqeaz(strOohojlj)) {
                    strOohojlj = mainActivity3.getString(R.string.android_tools_transport_fastboot);
                }
                textView.setText(strOohojlj);
                TextView textView2 = mainActivity3.ltnesel.utmeivs;
                if (com.rynx.app.ojyssqt.zwaqeaz(strOohojlj2)) {
                    strOohojlj2 = "—";
                }
                textView2.setText(strOohojlj2);
                TextView textView3 = mainActivity3.ltnesel.buswjhz;
                if (com.rynx.app.ojyssqt.zwaqeaz(strOohojlj3)) {
                    strOohojlj3 = "—";
                }
                textView3.setText(strOohojlj3);
                TextView textView4 = mainActivity3.ltnesel.pvbzgon;
                if (com.rynx.app.ojyssqt.zwaqeaz(strOohojlj4)) {
                    strOohojlj4 = "—";
                }
                textView4.setText(strOohojlj4);
                TextView textView5 = mainActivity3.ltnesel.qyeibyo;
                if (com.rynx.app.ojyssqt.zwaqeaz(strOohojlj5)) {
                    strOohojlj5 = "—";
                }
                textView5.setText(strOohojlj5);
                TextView textView6 = mainActivity3.ltnesel.vntpaom;
                if (com.rynx.app.ojyssqt.zwaqeaz(strOohojlj6)) {
                    strOohojlj6 = "—";
                }
                textView6.setText(strOohojlj6);
                mainActivity3.ltnesel.vivhedu.setText(R.string.android_tools_fastboot_ready);
                mainActivity3.ltnesel.vivhedu.setTextColor(mainActivity3.qxvquar);
                zamkzqg.enxkjpu(mainActivity3, mainActivity3.ltnesel.vivhedu, R.drawable.ic_usb, mainActivity3.qxvquar);
                return;
            case 3:
                final MainActivity mainActivity4 = (MainActivity) this.ojyssqt;
                final xhyvkax xhyvkaxVar = (xhyvkax) this.vivhedu;
                mslkofp mslkofpVar2 = (mslkofp) this.lthborb;
                int[] iArr = MainActivity.rzsxsyc;
                mainActivity4.getClass();
                long[] jArr2 = {0, 500, 1000, 2000, 4000, 8000};
                int i4 = 0;
                while (true) {
                    if (i4 < i3) {
                        try {
                            long j2 = jArr2[i4];
                            if (j2 > j) {
                                try {
                                    Thread.sleep(j2);
                                    if (mainActivity4.iqvvlnh != xhyvkaxVar && xhyvkaxVar.nmpwovh.equals(mslkofpVar2.nmpwovh)) {
                                        try {
                                            i2 = i4;
                                            jArr = jArr2;
                                            mslkofpVar = mslkofpVar2;
                                            try {
                                                zamkzqg.vivhedu(com.rynx.app.ojyssqt.jxvdcpb(), xhyvkaxVar, mslkofpVar2.ojyssqt, mslkofpVar2.vivhedu, mslkofpVar2.lthborb, mslkofpVar2.qxvquar);
                                                th = czgynwwVar;
                                                z3 = false;
                                                z2 = true;
                                            } catch (czgynww e2) {
                                                e = e2;
                                                if ("ACK_REJECTED".equals(e.nmpwovh) || "RESULT_EXPIRED".equals(e.nmpwovh) || "JOB_NOT_FOUND".equals(e.nmpwovh)) {
                                                    th = e;
                                                    z2 = false;
                                                    z3 = true;
                                                }
                                                czgynwwVar = e;
                                                i4 = i2 + 1;
                                                mslkofpVar2 = mslkofpVar;
                                                jArr2 = jArr;
                                                i3 = 6;
                                                j = 0;
                                            } catch (Throwable th6) {
                                                e = th6;
                                                czgynwwVar = e;
                                                i4 = i2 + 1;
                                                mslkofpVar2 = mslkofpVar;
                                                jArr2 = jArr;
                                                i3 = 6;
                                                j = 0;
                                            }
                                        } catch (czgynww e3) {
                                            e = e3;
                                            i2 = i4;
                                            jArr = jArr2;
                                            mslkofpVar = mslkofpVar2;
                                        } catch (Throwable th7) {
                                            e = th7;
                                            i2 = i4;
                                            jArr = jArr2;
                                            mslkofpVar = mslkofpVar2;
                                        }
                                    }
                                } catch (InterruptedException e4) {
                                    Thread.currentThread().interrupt();
                                    z2 = false;
                                    z3 = false;
                                    mslkofpVar = mslkofpVar2;
                                    th = e4;
                                }
                            } else if (mainActivity4.iqvvlnh != xhyvkaxVar) {
                            }
                            synchronized (mainActivity4.lbyddwl) {
                                mainActivity4.sxcwslq = false;
                                break;
                            }
                            if (!z2 || z3) {
                                synchronized (mainActivity4.lbyddwl) {
                                    try {
                                        jSONArrayQwpvrdy = mainActivity4.qwpvrdy();
                                        jSONArray = new JSONArray();
                                        for (i = 0; i < jSONArrayQwpvrdy.length(); i++) {
                                            jSONObjectOptJSONObject = jSONArrayQwpvrdy.optJSONObject(i);
                                            if (jSONObjectOptJSONObject == null && (!mslkofpVar.nmpwovh.equals(jSONObjectOptJSONObject.optString("owner_user_id", "")) || !mslkofpVar.ojyssqt.equals(jSONObjectOptJSONObject.optString("job_id", "")) || !mslkofpVar.vivhedu.equalsIgnoreCase(jSONObjectOptJSONObject.optString("response_sha256", "")))) {
                                                jSONArray.put(jSONObjectOptJSONObject);
                                            }
                                        }
                                        mainActivity4.getSharedPreferences("xiaomi_auth_pending_ack", 0).edit().putString("queue_json", jSONArray.toString()).commit();
                                    } catch (Throwable th8) {
                                        throw th8;
                                    }
                                    break;
                                }
                            }
                            final mslkofp mslkofpVar3 = mslkofpVar;
                            mainActivity4.runOnUiThread(new Runnable() { // from class: x.lsgjyur
                                @Override // java.lang.Runnable
                                public final void run() {
                                    MainActivity mainActivity5 = mainActivity4;
                                    boolean z5 = z2;
                                    mslkofp mslkofpVar4 = mslkofpVar3;
                                    boolean z6 = z3;
                                    Throwable th9 = th;
                                    xhyvkax xhyvkaxVar2 = xhyvkaxVar;
                                    int[] iArr2 = MainActivity.rzsxsyc;
                                    mainActivity5.getClass();
                                    if (z5) {
                                        if (mslkofpVar4.ojyssqt.equals(mainActivity5.dreanqi) && mslkofpVar4.vivhedu.equalsIgnoreCase(mainActivity5.ebrwptg)) {
                                            mainActivity5.dreanqi = "";
                                            mainActivity5.ebrwptg = "";
                                        }
                                        mainActivity5.nmpwovh("[SLA] Final device outcome acknowledged by the broker.");
                                    } else if (z6) {
                                        mainActivity5.nmpwovh("[SLA] Stored device outcome is terminal on the owning account; retry record cleared.");
                                    } else {
                                        mainActivity5.nmpwovh("[SLA] Device outcome remains queued for the owning account; ACK will retry later: ".concat(th9 == null ? "network unavailable" : th9.getClass().getSimpleName()));
                                    }
                                    if (mainActivity5.iqvvlnh == xhyvkaxVar2) {
                                        mainActivity5.fadblxi();
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th9) {
                            synchronized (mainActivity4.lbyddwl) {
                                mainActivity4.sxcwslq = false;
                                throw th9;
                            }
                        }
                    }
                    mslkofpVar = mslkofpVar2;
                    th = czgynwwVar;
                    z2 = false;
                    z3 = false;
                    synchronized (mainActivity4.lbyddwl) {
                        mainActivity4.sxcwslq = false;
                        if (!z2) {
                            synchronized (mainActivity4.lbyddwl) {
                                jSONArrayQwpvrdy = mainActivity4.qwpvrdy();
                                jSONArray = new JSONArray();
                                while (i < jSONArrayQwpvrdy.length()) {
                                    jSONObjectOptJSONObject = jSONArrayQwpvrdy.optJSONObject(i);
                                    if (jSONObjectOptJSONObject == null) {
                                        jSONArray.put(jSONObjectOptJSONObject);
                                    }
                                }
                                mainActivity4.getSharedPreferences("xiaomi_auth_pending_ack", 0).edit().putString("queue_json", jSONArray.toString()).commit();
                                break;
                            }
                        } else {
                            synchronized (mainActivity4.lbyddwl) {
                                jSONArrayQwpvrdy = mainActivity4.qwpvrdy();
                                jSONArray = new JSONArray();
                                while (i < jSONArrayQwpvrdy.length()) {
                                    jSONObjectOptJSONObject = jSONArrayQwpvrdy.optJSONObject(i);
                                    if (jSONObjectOptJSONObject == null) {
                                        jSONArray.put(jSONObjectOptJSONObject);
                                    }
                                }
                                mainActivity4.getSharedPreferences("xiaomi_auth_pending_ack", 0).edit().putString("queue_json", jSONArray.toString()).commit();
                                break;
                            }
                        }
                        final mslkofp mslkofpVar4 = mslkofpVar;
                        mainActivity4.runOnUiThread(new Runnable() { // from class: x.lsgjyur
                            @Override // java.lang.Runnable
                            public final void run() {
                                MainActivity mainActivity5 = mainActivity4;
                                boolean z5 = z2;
                                mslkofp mslkofpVar5 = mslkofpVar4;
                                boolean z6 = z3;
                                Throwable th10 = th;
                                xhyvkax xhyvkaxVar2 = xhyvkaxVar;
                                int[] iArr2 = MainActivity.rzsxsyc;
                                mainActivity5.getClass();
                                if (z5) {
                                    if (mslkofpVar5.ojyssqt.equals(mainActivity5.dreanqi) && mslkofpVar5.vivhedu.equalsIgnoreCase(mainActivity5.ebrwptg)) {
                                        mainActivity5.dreanqi = "";
                                        mainActivity5.ebrwptg = "";
                                    }
                                    mainActivity5.nmpwovh("[SLA] Final device outcome acknowledged by the broker.");
                                } else if (z6) {
                                    mainActivity5.nmpwovh("[SLA] Stored device outcome is terminal on the owning account; retry record cleared.");
                                } else {
                                    mainActivity5.nmpwovh("[SLA] Device outcome remains queued for the owning account; ACK will retry later: ".concat(th10 == null ? "network unavailable" : th10.getClass().getSimpleName()));
                                }
                                if (mainActivity5.iqvvlnh == xhyvkaxVar2) {
                                    mainActivity5.fadblxi();
                                }
                            }
                        });
                        return;
                    }
                    i4 = i2 + 1;
                    mslkofpVar2 = mslkofpVar;
                    jArr2 = jArr;
                    i3 = 6;
                    j = 0;
                }
                break;
            case 4:
                kggugdp kggugdpVar = (kggugdp) this.ojyssqt;
                suqlntg suqlntgVar = (suqlntg) this.vivhedu;
                ohwxijw ohwxijwVar = (ohwxijw) this.lthborb;
                kggugdpVar.getClass();
                if (suqlntgVar.oqexvyb()) {
                    ProgressBar progressBar = kggugdpVar.vhimehb;
                    if (progressBar != null) {
                        progressBar.setProgress(100);
                    }
                    TextView textView7 = kggugdpVar.naaizwn;
                    if (textView7 != null) {
                        textView7.setText(R.string.progress_complete_percent);
                    }
                    if (kggugdpVar.hjlrtqw != null) {
                        kggugdpVar.hjlrtqw.setText(kggugdpVar.getString(R.string.parts_erase_complete, zamkzqg.civyupy(Math.max(0L, System.currentTimeMillis() - kggugdpVar.clczezu))));
                        kggugdpVar.hjlrtqw.setTextColor(kggugdpVar.qxvquar);
                    }
                    ((MainActivity) kggugdpVar).nmpwovh(kggugdpVar.getString(R.string.log_parts_erase_complete, ohwxijwVar.nmpwovh));
                    zfmpmio.nmpwovh(kggugdpVar, kggugdpVar.getString(R.string.parts_erase_complete_partition, ohwxijwVar.nmpwovh), true);
                } else {
                    TextView textView8 = kggugdpVar.hjlrtqw;
                    if (textView8 != null) {
                        textView8.setText(R.string.parts_erase_failed);
                        kggugdpVar.hjlrtqw.setTextColor(kggugdpVar.nkemejx);
                    }
                    String str2 = (String) suqlntgVar.ojyssqt;
                    ((MainActivity) kggugdpVar).nmpwovh(str2 == null ? kggugdpVar.getString(R.string.parts_erase_failed) : str2.trim());
                }
                kggugdpVar.ygdccqg = "";
                kggugdpVar.cxxnoho = "";
                kggugdpVar.gefzxcg();
                return;
            case 5:
                kggugdp kggugdpVar2 = (kggugdp) this.ojyssqt;
                suqlntg suqlntgVar2 = (suqlntg) this.vivhedu;
                File file = (File) this.lthborb;
                kggugdpVar2.getClass();
                if (suqlntgVar2.oqexvyb()) {
                    ProgressBar progressBar2 = kggugdpVar2.vhimehb;
                    if (progressBar2 != null) {
                        progressBar2.setProgress(100);
                    }
                    TextView textView9 = kggugdpVar2.naaizwn;
                    if (textView9 != null) {
                        textView9.setText(R.string.progress_complete_percent);
                    }
                    if (kggugdpVar2.hjlrtqw != null) {
                        kggugdpVar2.hjlrtqw.setText(kggugdpVar2.getString(R.string.parts_backup_complete, zamkzqg.civyupy(Math.max(0L, System.currentTimeMillis() - kggugdpVar2.clczezu))));
                        kggugdpVar2.hjlrtqw.setTextColor(kggugdpVar2.qxvquar);
                    }
                    ((MainActivity) kggugdpVar2).nmpwovh(kggugdpVar2.getString(R.string.log_parts_backup_complete, file.getAbsolutePath()));
                    zfmpmio.nmpwovh(kggugdpVar2, kggugdpVar2.getString(R.string.parts_backup_complete_file, file.getName()), true);
                } else {
                    TextView textView10 = kggugdpVar2.hjlrtqw;
                    if (textView10 != null) {
                        textView10.setText(R.string.parts_backup_failed);
                        kggugdpVar2.hjlrtqw.setTextColor(kggugdpVar2.nkemejx);
                    }
                    String str3 = (String) suqlntgVar2.ojyssqt;
                    ((MainActivity) kggugdpVar2).nmpwovh(str3 == null ? kggugdpVar2.getString(R.string.parts_backup_failed) : str3.trim());
                }
                kggugdpVar2.ygdccqg = "";
                kggugdpVar2.cxxnoho = "";
                kggugdpVar2.gefzxcg();
                return;
            case 6:
                kggugdp kggugdpVar3 = (kggugdp) this.ojyssqt;
                suqlntg suqlntgVar3 = (suqlntg) this.vivhedu;
                ArrayList arrayList = (ArrayList) this.lthborb;
                kggugdpVar3.getClass();
                if (suqlntgVar3.oqexvyb()) {
                    kggugdpVar3.zegwdrn(arrayList.size(), arrayList.size());
                    ProgressBar progressBar3 = kggugdpVar3.vhimehb;
                    if (progressBar3 != null) {
                        progressBar3.setProgress(100);
                    }
                    TextView textView11 = kggugdpVar3.naaizwn;
                    if (textView11 != null) {
                        textView11.setText(R.string.progress_complete_percent);
                    }
                    TextView textView12 = kggugdpVar3.hjlrtqw;
                    if (textView12 != null) {
                        textView12.setText(R.string.batch_flash_complete);
                        kggugdpVar3.hjlrtqw.setTextColor(kggugdpVar3.qxvquar);
                    }
                    Toast.makeText(kggugdpVar3, kggugdpVar3.getString(R.string.batch_flash_complete_toast, Integer.valueOf(arrayList.size())), 1).show();
                } else {
                    TextView textView13 = kggugdpVar3.hjlrtqw;
                    if (textView13 != null) {
                        textView13.setText(R.string.batch_flash_failed_toast);
                        kggugdpVar3.hjlrtqw.setTextColor(kggugdpVar3.nkemejx);
                    }
                    Toast.makeText(kggugdpVar3, kggugdpVar3.getString(R.string.batch_flash_failed_toast), 1).show();
                }
                kggugdpVar3.ygdccqg = "";
                kggugdpVar3.cxxnoho = "";
                kggugdpVar3.gefzxcg();
                return;
            case 7:
                MainActivity mainActivity5 = (MainActivity) this.ojyssqt;
                mainActivity5.getClass();
                suqlntg suqlntgVar4 = (suqlntg) this.vivhedu;
                String str4 = (String) suqlntgVar4.ojyssqt;
                if (str4 != null && !str4.trim().isEmpty()) {
                    mainActivity5.nmpwovh(str4.trim());
                }
                mainActivity5.nmpwovh(mainActivity5.getString(R.string.terminal_exit, Integer.valueOf(suqlntgVar4.nmpwovh)));
                mainActivity5.nmpwovh("");
                if ("crash".equals((String) this.lthborb)) {
                    mainActivity5.nkemejx();
                    mainActivity5.cgcdpmq();
                }
                mainActivity5.gefzxcg();
                if (mainActivity5.snilumr.lthborb || ((editText = mainActivity5.eigllth) != null && editText.hasFocus())) {
                    mainActivity5.ekyqleu();
                    return;
                }
                return;
            default:
                TextView textView14 = (TextView) this.lthborb;
                if (textView14.getParent() == null) {
                    return;
                }
                WeakHashMap weakHashMap = zfmpmio.ojyssqt;
                Activity activity = this.ojyssqt;
                if (weakHashMap.get(activity) == textView14) {
                    weakHashMap.remove(activity);
                }
                boolean zAreAnimatorsEnabled = ValueAnimator.areAnimatorsEnabled();
                FrameLayout frameLayout = (FrameLayout) this.vivhedu;
                if (zAreAnimatorsEnabled) {
                    textView14.animate().alpha(0.0f).translationY(zamkzqg.qunltjs(activity, 10)).setDuration(160L).setListener(new snbdnwo(textView14, frameLayout)).start();
                    return;
                } else {
                    frameLayout.removeView(textView14);
                    return;
                }
        }
    }

    public /* synthetic */ ekyqleu(MainActivity mainActivity, ParcelFileDescriptor parcelFileDescriptor, UsbDevice usbDevice) {
        this.nmpwovh = 1;
        this.ojyssqt = mainActivity;
        this.lthborb = parcelFileDescriptor;
        this.vivhedu = usbDevice;
    }
}
