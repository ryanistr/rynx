package x;

import android.app.Dialog;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lpkdqgx implements Runnable {
    public final /* synthetic */ Object imuemzb;
    public final /* synthetic */ Serializable lthborb;
    public final /* synthetic */ Object nkemejx;
    public final /* synthetic */ int nmpwovh = 2;
    public final /* synthetic */ String ojyssqt;
    public final /* synthetic */ kggugdp oqexvyb;
    public final /* synthetic */ Serializable qxvquar;
    public final /* synthetic */ Object vivhedu;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ lpkdqgx(MainActivity mainActivity, Object obj, boolean[] zArr, Dialog[] dialogArr, String str, String[] strArr, CountDownLatch countDownLatch) {
        this.oqexvyb = mainActivity;
        this.vivhedu = obj;
        this.lthborb = zArr;
        this.qxvquar = dialogArr;
        this.ojyssqt = str;
        this.nkemejx = strArr;
        this.imuemzb = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        MainActivity mainActivity;
        suqlntg suqlntgVar = null;
        boolean z;
        String str4;
        ohwxijw ohwxijwVar;
        suqlntg suqlntgVar2 = null;
        Throwable thAlias = null;
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity2 = (MainActivity) this.oqexvyb;
                String str5 = this.ojyssqt;
                String str6 = (String) this.vivhedu;
                String str7 = (String) this.lthborb;
                String str8 = (String) this.qxvquar;
                String str9 = (String) this.nkemejx;
                String str10 = (String) this.imuemzb;
                oxoagud oxoagudVarEzxxysz = mainActivity2.ezxxysz();
                int i = oxoagudVarEzxxysz.nmpwovh;
                if (i < 0) {
                    suqlntgVar = new suqlntg(2, mainActivity2.getString(R.string.error_usb_lost_gui_action));
                    z = false;
                    str2 = str6;
                    str3 = str5;
                    mainActivity = mainActivity2;
                } else {
                    try {
                        long j = oxoagudVarEzxxysz.ojyssqt;
                        String str11 = str6 == null ? "" : str6;
                        if (str7 == null) {
                            str7 = "";
                        }
                        str = "—";
                        str2 = str6;
                        str3 = str5;
                        mainActivity = mainActivity2;
                        try {
                            String strNativeRunGuiAction = mainActivity2.nativeRunGuiAction(i, j, str5, str11, str7, str8 == null ? "" : str8, str9 == null ? "" : str9, str10 == null ? "" : str10);
                            int i2 = (strNativeRunGuiAction == null || !strNativeRunGuiAction.startsWith("OK\n")) ? 0 : 1;
                            mainActivity.nsyqsfj = mainActivity.qwgjehf && mainActivity.nativeHasSession();
                            if (!mainActivity.nsyqsfj) {
                                mainActivity.xvxmcgn = str;
                            }
                            int i3 = i2 ^ 1;
                            if (strNativeRunGuiAction == null) {
                                strNativeRunGuiAction = mainActivity.getString(R.string.error_jni_null);
                            }
                            suqlntgVar = new suqlntg(i3, strNativeRunGuiAction);
                        } catch (Throwable th) {
                            th = th;
                            mainActivity.nsyqsfj = mainActivity.qwgjehf && mainActivity.nativeHasSession();
                            if (!mainActivity.nsyqsfj) {
                                mainActivity.xvxmcgn = str;
                            }
                            suqlntgVar = new suqlntg(1, mainActivity.getString(R.string.error_gui_jni, String.valueOf(th)));
                        }
                    } catch (Throwable th2) {
                        thAlias = th2;
                        str = "—";
                        str2 = str6;
                        str3 = str5;
                        mainActivity = mainActivity2;
                    }
                    z = false;
                }
                mainActivity.lpkdqgx = z;
                mainActivity.runOnUiThread(new vntpaom(mainActivity, suqlntgVar, str3, str2));
                return;
            case 1:
                MainActivity mainActivity3 = (MainActivity) this.oqexvyb;
                String str12 = this.ojyssqt;
                ohwxijw ohwxijwVar2 = (ohwxijw) this.nkemejx;
                File file = (File) this.imuemzb;
                String str13 = (String) this.vivhedu;
                String str14 = (String) this.lthborb;
                String str15 = (String) this.qxvquar;
                oxoagud oxoagudVarEzxxysz2 = mainActivity3.ezxxysz();
                int i4 = oxoagudVarEzxxysz2.nmpwovh;
                if (i4 < 0) {
                    suqlntgVar2 = new suqlntg(2, mainActivity3.getString(R.string.error_usb_lost_flash));
                    ohwxijwVar = ohwxijwVar2;
                } else {
                    try {
                        str4 = "—";
                        ohwxijwVar = ohwxijwVar2;
                        try {
                            String strNativeRunGuiAction2 = mainActivity3.nativeRunGuiAction(i4, oxoagudVarEzxxysz2.ojyssqt, str12, ohwxijwVar2.nmpwovh, file.getAbsolutePath(), str13 == null ? "" : str13, str14 == null ? "" : str14, str15 == null ? "" : str15);
                            int i5 = (strNativeRunGuiAction2 == null || !strNativeRunGuiAction2.startsWith("OK\n")) ? 0 : 1;
                            mainActivity3.nsyqsfj = mainActivity3.qwgjehf && mainActivity3.nativeHasSession();
                            if (!mainActivity3.nsyqsfj) {
                                mainActivity3.xvxmcgn = str4;
                            }
                            int i6 = i5 ^ 1;
                            if (strNativeRunGuiAction2 == null) {
                                strNativeRunGuiAction2 = mainActivity3.getString(R.string.error_jni_null);
                            }
                            suqlntgVar2 = new suqlntg(i6, strNativeRunGuiAction2);
                        } catch (Throwable th3) {
                            thAlias = th3;
                            mainActivity3.nsyqsfj = mainActivity3.qwgjehf && mainActivity3.nativeHasSession();
                            if (!mainActivity3.nsyqsfj) {
                                mainActivity3.xvxmcgn = str4;
                            }
                            suqlntgVar2 = new suqlntg(1, mainActivity3.getString(R.string.error_gui_jni, String.valueOf(thAlias)));
                        }
                    } catch (Throwable th4) {
                        thAlias = th4;
                        str4 = "—";
                        ohwxijwVar = ohwxijwVar2;
                    }
                }
                mainActivity3.lpkdqgx = false;
                mainActivity3.runOnUiThread(new vntpaom(mainActivity3, suqlntgVar2, ohwxijwVar, file, 6));
                return;
            case 2:
                MainActivity mainActivity4 = (MainActivity) this.oqexvyb;
                Object obj = this.vivhedu;
                boolean[] zArr = (boolean[]) this.lthborb;
                Dialog[] dialogArr = (Dialog[]) this.qxvquar;
                String str16 = this.ojyssqt;
                String[] strArr = (String[]) this.nkemejx;
                CountDownLatch countDownLatch = (CountDownLatch) this.imuemzb;
                int[] iArr = MainActivity.rzsxsyc;
                mainActivity4.getClass();
                synchronized (obj) {
                    try {
                        if (zArr[0]) {
                            mainActivity4.nmpwovh("[SLA] Xiaomi signer token ready (SOC_ID + BROM challenge); waiting for manual response.");
                            dialogArr[0] = zamkzqg.nauykcf(mainActivity4, str16, new ghkjjru(obj, zArr, strArr, countDownLatch));
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        throw th5;
                    }
                }
            default:
                kggugdp kggugdpVar = this.oqexvyb;
                File file2 = (File) this.qxvquar;
                File file3 = (File) this.nkemejx;
                String str17 = this.ojyssqt;
                String str18 = (String) this.vivhedu;
                String str19 = (String) this.lthborb;
                ArrayList arrayList = (ArrayList) this.imuemzb;
                kggugdpVar.getClass();
                MainActivity mainActivity5 = (MainActivity) kggugdpVar;
                mainActivity5.nmpwovh("[FWUP] Worker started; entering native Firmware Upgrade");
                try {
                    try {
                        suqlntg suqlntgVarYhrqvll = kggugdpVar.yhrqvll("scatter-firmware-upgrade", file2.getAbsolutePath(), file3.getAbsolutePath(), str17, str18, str19);
                        if (!file2.delete()) {
                            file2.deleteOnExit();
                        }
                        String str20 = (String) suqlntgVarYhrqvll.ojyssqt;
                        if (str20 != null && !str20.trim().isEmpty()) {
                            ((MainActivity) kggugdpVar).nmpwovh(((String) suqlntgVarYhrqvll.ojyssqt).trim());
                        }
                        kggugdpVar.lpkdqgx = false;
                        kggugdpVar.runOnUiThread(new vntpaom(kggugdpVar, suqlntgVarYhrqvll, arrayList, file3, 8));
                        return;
                    } catch (Throwable th6) {
                        if (!file2.delete()) {
                            file2.deleteOnExit();
                        }
                        throw th6;
                    }
                } catch (Throwable th7) {
                    kggugdpVar.lpkdqgx = false;
                    String str21 = "[FWUP] Worker exception contained: " + th7.getClass().getSimpleName() + ": " + String.valueOf(th7.getMessage());
                    mainActivity5.nmpwovh(str21);
                    kggugdpVar.runOnUiThread(new gngavpw(0, str21, kggugdpVar));
                    return;
                }
        }
    }

    public /* synthetic */ lpkdqgx(MainActivity mainActivity, String str, String str2, String str3, String str4, String str5, String str6) {
        this.oqexvyb = mainActivity;
        this.ojyssqt = str;
        this.vivhedu = str2;
        this.lthborb = str3;
        this.qxvquar = str4;
        this.nkemejx = str5;
        this.imuemzb = str6;
    }

    public /* synthetic */ lpkdqgx(MainActivity mainActivity, String str, ohwxijw ohwxijwVar, File file, String str2, String str3, String str4) {
        this.oqexvyb = mainActivity;
        this.ojyssqt = str;
        this.nkemejx = ohwxijwVar;
        this.imuemzb = file;
        this.vivhedu = str2;
        this.lthborb = str3;
        this.qxvquar = str4;
    }

    public /* synthetic */ lpkdqgx(kggugdp kggugdpVar, File file, File file2, String str, String str2, String str3, ArrayList arrayList) {
        this.oqexvyb = kggugdpVar;
        this.qxvquar = file;
        this.nkemejx = file2;
        this.ojyssqt = str;
        this.vivhedu = str2;
        this.lthborb = str3;
        this.imuemzb = arrayList;
    }
}
