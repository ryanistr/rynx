package x;

import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class silhone implements Runnable {
    public final /* synthetic */ String lthborb;
    public final /* synthetic */ Object nkemejx;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ kggugdp ojyssqt;
    public final /* synthetic */ String oqexvyb;
    public final /* synthetic */ String qxvquar;
    public final /* synthetic */ File vivhedu;

    public /* synthetic */ silhone(kggugdp kggugdpVar, File file, String str, String str2, String str3, ArrayList arrayList) {
        this.nmpwovh = 1;
        this.ojyssqt = kggugdpVar;
        this.vivhedu = file;
        this.lthborb = str;
        this.qxvquar = str2;
        this.oqexvyb = str3;
        this.nkemejx = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        suqlntg suqlntgVar;
        String str;
        int i;
        suqlntg suqlntgVar2;
        suqlntg suqlntgVar3;
        switch (this.nmpwovh) {
            case 0:
                kggugdp kggugdpVar = this.ojyssqt;
                ArrayList arrayList = (ArrayList) this.nkemejx;
                File file = this.vivhedu;
                String str2 = this.lthborb;
                String str3 = this.qxvquar;
                String str4 = this.oqexvyb;
                kggugdpVar.getClass();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= arrayList.size()) {
                        suqlntgVar = null;
                        str = null;
                    } else if (kggugdpVar.qwgjehf && kggugdpVar.nsyqsfj) {
                        ohwxijw ohwxijwVar = (ohwxijw) arrayList.get(i2);
                        File fileCzidoiw = com.rynx.app.ojyssqt.czidoiw(file, ohwxijwVar.nmpwovh);
                        kggugdpVar.runOnUiThread(new rrpfqyy(kggugdpVar, i2, arrayList, ohwxijwVar, 2));
                        kggugdpVar.cxxnoho = ohwxijwVar.nmpwovh;
                        kggugdpVar.clczezu = System.currentTimeMillis();
                        int i4 = i2;
                        suqlntg suqlntgVarYhrqvll = kggugdpVar.yhrqvll("upload", ohwxijwVar.nmpwovh, fileCzidoiw.getAbsolutePath(), str2, str3, str4);
                        if (suqlntgVarYhrqvll.oqexvyb()) {
                            i3++;
                            kggugdpVar.runOnUiThread(new ankiohq(kggugdpVar, i3, arrayList, 0));
                            i2 = i4 + 1;
                        } else {
                            str = ohwxijwVar.nmpwovh;
                            suqlntgVar = suqlntgVarYhrqvll;
                        }
                    } else {
                        int i5 = i2;
                        suqlntgVar = new suqlntg(2, kggugdpVar.getString(R.string.error_da_not_ready));
                        str = ((ohwxijw) arrayList.get(i5)).nmpwovh;
                    }
                }
                kggugdpVar.lpkdqgx = false;
                kggugdpVar.runOnUiThread(new gzvolsx(kggugdpVar, suqlntgVar, i3, str, 0));
                return;
            case 1:
                kggugdp kggugdpVar2 = this.ojyssqt;
                File file2 = this.vivhedu;
                String str5 = this.lthborb;
                String str6 = this.qxvquar;
                String str7 = this.oqexvyb;
                ArrayList arrayList2 = (ArrayList) this.nkemejx;
                kggugdpVar2.getClass();
                try {
                    try {
                        suqlntg suqlntgVarYhrqvll2 = kggugdpVar2.yhrqvll("scatter-download-v6", file2.getAbsolutePath(), "", str5, str6, str7);
                        if (!file2.delete()) {
                            file2.deleteOnExit();
                        }
                        String str8 = (String) suqlntgVarYhrqvll2.ojyssqt;
                        if (str8 != null && !str8.trim().isEmpty()) {
                            ((MainActivity) kggugdpVar2).nmpwovh(((String) suqlntgVarYhrqvll2.ojyssqt).trim());
                        }
                        kggugdpVar2.lpkdqgx = false;
                        kggugdpVar2.runOnUiThread(new ekyqleu(kggugdpVar2, suqlntgVarYhrqvll2, arrayList2, 6));
                        return;
                    } catch (Throwable th) {
                        if (!file2.delete()) {
                            file2.deleteOnExit();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    kggugdpVar2.lpkdqgx = false;
                    String str9 = "[SCATTER/V6] Download Only worker failed: " + th2.getClass().getSimpleName() + ": " + String.valueOf(th2.getMessage());
                    ((MainActivity) kggugdpVar2).nmpwovh(str9);
                    kggugdpVar2.runOnUiThread(new gngavpw(1, str9, kggugdpVar2));
                    return;
                }
            default:
                kggugdp kggugdpVar3 = this.ojyssqt;
                ohwxijw ohwxijwVar2 = (ohwxijw) this.nkemejx;
                File file3 = this.vivhedu;
                String str10 = this.lthborb;
                String str11 = this.qxvquar;
                String str12 = this.oqexvyb;
                oxoagud oxoagudVarEzxxysz = kggugdpVar3.ezxxysz();
                int i6 = oxoagudVarEzxxysz.nmpwovh;
                if (i6 >= 0) {
                    try {
                        i = 1;
                        try {
                            String strNativeRunGuiAction = kggugdpVar3.nativeRunGuiAction(i6, oxoagudVarEzxxysz.ojyssqt, "upload", ohwxijwVar2.nmpwovh, file3.getAbsolutePath(), str10 == null ? "" : str10, str11 == null ? "" : str11, str12 == null ? "" : str12);
                            int i7 = (strNativeRunGuiAction == null || !strNativeRunGuiAction.startsWith("OK\n")) ? 0 : 1;
                            kggugdpVar3.nsyqsfj = kggugdpVar3.qwgjehf && kggugdpVar3.nativeHasSession();
                            if (!kggugdpVar3.nsyqsfj) {
                                kggugdpVar3.xvxmcgn = "—";
                            }
                            int i8 = i7 ^ 1;
                            if (strNativeRunGuiAction == null) {
                                strNativeRunGuiAction = kggugdpVar3.getString(R.string.error_jni_null);
                            }
                            suqlntgVar2 = new suqlntg(i8, strNativeRunGuiAction);
                        } catch (Throwable th3) {
                            th = th3;
                            kggugdpVar3.nsyqsfj = (kggugdpVar3.qwgjehf && kggugdpVar3.nativeHasSession()) ? i : 0;
                            if (!kggugdpVar3.nsyqsfj) {
                                kggugdpVar3.xvxmcgn = "—";
                            }
                            suqlntgVar2 = new suqlntg(i, kggugdpVar3.getString(R.string.error_gui_jni, String.valueOf(th)));
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        i = 1;
                    }
                    suqlntgVar3 = suqlntgVar2;
                    break;
                } else {
                    suqlntgVar3 = new suqlntg(2, kggugdpVar3.getString(R.string.error_usb_lost_backup));
                }
                kggugdpVar3.lpkdqgx = false;
                kggugdpVar3.runOnUiThread(new ekyqleu(kggugdpVar3, suqlntgVar3, file3, 5));
                return;
        }
    }

    public /* synthetic */ silhone(kggugdp kggugdpVar, Object obj, File file, String str, String str2, String str3, int i) {
        this.nmpwovh = i;
        this.ojyssqt = kggugdpVar;
        this.nkemejx = obj;
        this.vivhedu = file;
        this.lthborb = str;
        this.qxvquar = str2;
        this.oqexvyb = str3;
    }
}
