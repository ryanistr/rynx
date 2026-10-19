package x;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hhqpjvl implements Runnable {
    public final /* synthetic */ Object lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;
    public final /* synthetic */ Object oqexvyb;
    public final /* synthetic */ Object qxvquar;
    public final /* synthetic */ Object vivhedu;

    public /* synthetic */ hhqpjvl(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
        this.nmpwovh = i;
        this.qxvquar = obj;
        this.ojyssqt = obj2;
        this.vivhedu = obj3;
        this.lthborb = obj4;
        this.oqexvyb = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strNativeRunGuiAction;
        suqlntg suqlntgVar;
        String str;
        String str2;
        ohwxijw ohwxijwVar;
        suqlntg suqlntgVar2;
        int i = 1;
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity = (MainActivity) this.qxvquar;
                String str3 = (String) this.ojyssqt;
                String str4 = (String) this.vivhedu;
                String str5 = (String) this.lthborb;
                String str6 = (String) this.oqexvyb;
                oxoagud oxoagudVarEzxxysz = mainActivity.ezxxysz();
                int i2 = oxoagudVarEzxxysz.nmpwovh;
                if (i2 < 0) {
                    strNativeRunGuiAction = "ERROR\n" + mainActivity.getString(R.string.error_usb_lost_gui_action);
                } else {
                    try {
                        long j = oxoagudVarEzxxysz.ojyssqt;
                        String lowerCase = str3.toLowerCase(Locale.ROOT);
                        if (str4 == null) {
                            str4 = "";
                        }
                        try {
                            strNativeRunGuiAction = mainActivity.nativeRunGuiAction(i2, j, "bootctrl-set", lowerCase, "", str4, str5 == null ? "" : str5, str6 != null ? str6 : "");
                        } catch (Throwable th) {
                            th = th;
                            strNativeRunGuiAction = "ERROR\n" + mainActivity.getString(R.string.error_gui_jni, String.valueOf(th));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                int i3 = 0;
                mainActivity.lpkdqgx = false;
                mainActivity.runOnUiThread(new gisppfs(mainActivity, strNativeRunGuiAction, str3, i3));
                break;
            case 1:
                kggugdp kggugdpVar = (kggugdp) this.qxvquar;
                ArrayList arrayList = (ArrayList) this.oqexvyb;
                String str7 = (String) this.ojyssqt;
                String str8 = (String) this.vivhedu;
                String str9 = (String) this.lthborb;
                kggugdpVar.getClass();
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= arrayList.size()) {
                        suqlntgVar = null;
                        str = null;
                    } else if (kggugdpVar.qwgjehf && kggugdpVar.nsyqsfj) {
                        araemok araemokVar = (araemok) arrayList.get(i4);
                        kggugdpVar.runOnUiThread(new rrpfqyy(kggugdpVar, i4, arrayList, araemokVar, 3));
                        kggugdpVar.cxxnoho = araemokVar.nmpwovh.nmpwovh;
                        kggugdpVar.clczezu = System.currentTimeMillis();
                        boolean z = araemokVar.vivhedu;
                        String str10 = z ? "scatter-download" : "download";
                        String str11 = z ? araemokVar.nmpwovh.nmpwovh + "\t" + Long.toUnsignedString(araemokVar.nmpwovh.vivhedu, 16) : araemokVar.nmpwovh.nmpwovh;
                        int i6 = i4;
                        suqlntg suqlntgVarYhrqvll = kggugdpVar.yhrqvll(str10, str11, araemokVar.ojyssqt.getAbsolutePath(), str7, str8, str9);
                        if (suqlntgVarYhrqvll.oqexvyb()) {
                            int i7 = i5 + 1;
                            kggugdpVar.runOnUiThread(new ankiohq(kggugdpVar, i7, arrayList, i));
                            i4 = i6 + 1;
                            i5 = i7;
                        } else {
                            str = araemokVar.nmpwovh.nmpwovh;
                            suqlntgVar = suqlntgVarYhrqvll;
                        }
                    } else {
                        int i8 = i4;
                        suqlntgVar = new suqlntg(2, kggugdpVar.getString(R.string.error_da_not_ready));
                        str = ((araemok) arrayList.get(i8)).nmpwovh.nmpwovh;
                    }
                }
                kggugdpVar.lpkdqgx = false;
                kggugdpVar.runOnUiThread(new gzvolsx(kggugdpVar, suqlntgVar, i5, str, 1));
                break;
            case 2:
                EditText editText = (EditText) this.qxvquar;
                String lowerCase2 = editText.getText() != null ? editText.getText().toString().trim().toLowerCase(Locale.ROOT) : "";
                Iterator it = ((ArrayList) this.ojyssqt).iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    String[] strArr = (String[]) this.vivhedu;
                    if (!zHasNext) {
                        String str12 = strArr[0];
                        com.rynx.app.nmpwovh nmpwovhVar = (com.rynx.app.nmpwovh) this.lthborb;
                        ghkjjru ghkjjruVar = (ghkjjru) this.oqexvyb;
                        TextView textView = (TextView) ghkjjruVar.vivhedu;
                        TextView textView2 = (TextView) ghkjjruVar.lthborb;
                        zamkzqg.pwnmyid(nmpwovhVar, (TextView) ghkjjruVar.ojyssqt, "green", "green".equals(str12));
                        zamkzqg.pwnmyid(nmpwovhVar, textView, "yellow", "yellow".equals(str12));
                        zamkzqg.pwnmyid(nmpwovhVar, textView2, "red", "red".equals(str12));
                    } else {
                        rpdxrib rpdxribVar = (rpdxrib) it.next();
                        rpdxribVar.ojyssqt.setVisibility((strArr[0].equals(rpdxribVar.nmpwovh.oqexvyb) && (lowerCase2.isEmpty() || rpdxribVar.lthborb.contains(lowerCase2))) ? 0 : 8);
                    }
                    break;
                }
                break;
            case 3:
                int[] iArr = MainActivity.rzsxsyc;
                MainActivity mainActivity2 = (MainActivity) this.qxvquar;
                mainActivity2.nmpwovh("[SLA] Remote signer required; waiting for credentials without closing USB.");
                zamkzqg.nsbgblf(mainActivity2, (String) this.ojyssqt, (ednetju) this.vivhedu, new rvrflql(mainActivity2, (String[]) this.lthborb, (CountDownLatch) this.oqexvyb));
                break;
            case 4:
                kggugdp kggugdpVar2 = (kggugdp) this.qxvquar;
                ohwxijw ohwxijwVar2 = (ohwxijw) this.oqexvyb;
                String str13 = (String) this.ojyssqt;
                String str14 = (String) this.vivhedu;
                String str15 = (String) this.lthborb;
                oxoagud oxoagudVarEzxxysz2 = kggugdpVar2.ezxxysz();
                int i9 = oxoagudVarEzxxysz2.nmpwovh;
                if (i9 < 0) {
                    suqlntgVar2 = new suqlntg(2, kggugdpVar2.getString(R.string.error_usb_lost_gui_action));
                    ohwxijwVar = ohwxijwVar2;
                } else {
                    try {
                        str2 = "—";
                        ohwxijwVar = ohwxijwVar2;
                        try {
                            String strNativeRunGuiAction2 = kggugdpVar2.nativeRunGuiAction(i9, oxoagudVarEzxxysz2.ojyssqt, "erase-partition", ohwxijwVar2.nmpwovh, "", str13 == null ? "" : str13, str14 == null ? "" : str14, str15 != null ? str15 : "");
                            int i10 = (strNativeRunGuiAction2 == null || !strNativeRunGuiAction2.startsWith("OK\n")) ? 0 : 1;
                            kggugdpVar2.nsyqsfj = kggugdpVar2.qwgjehf && kggugdpVar2.nativeHasSession();
                            if (!kggugdpVar2.nsyqsfj) {
                                kggugdpVar2.xvxmcgn = str2;
                            }
                            int i11 = i10 ^ 1;
                            if (strNativeRunGuiAction2 == null) {
                                strNativeRunGuiAction2 = kggugdpVar2.getString(R.string.error_jni_null);
                            }
                            suqlntgVar2 = new suqlntg(i11, strNativeRunGuiAction2);
                        } catch (Throwable th3) {
                            th = th3;
                            kggugdpVar2.nsyqsfj = kggugdpVar2.qwgjehf && kggugdpVar2.nativeHasSession();
                            if (!kggugdpVar2.nsyqsfj) {
                                kggugdpVar2.xvxmcgn = str2;
                            }
                            suqlntgVar2 = new suqlntg(1, kggugdpVar2.getString(R.string.error_gui_jni, String.valueOf(th)));
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str2 = "—";
                        ohwxijwVar = ohwxijwVar2;
                    }
                }
                kggugdpVar2.lpkdqgx = false;
                kggugdpVar2.runOnUiThread(new ekyqleu(kggugdpVar2, suqlntgVar2, ohwxijwVar, 4));
                break;
            default:
                int size = ((osgyung) this.qxvquar).vivhedu.size();
                ((TextView) this.ojyssqt).setText(((com.rynx.app.nmpwovh) this.vivhedu).getString(R.string.xiaomi_device_picker_result_count, Integer.valueOf(size)));
                ((ListView) this.lthborb).setVisibility(size == 0 ? 8 : 0);
                ((TextView) this.oqexvyb).setVisibility(size == 0 ? 0 : 8);
                break;
        }
    }

    public /* synthetic */ hhqpjvl(kggugdp kggugdpVar, Object obj, String str, String str2, String str3, int i) {
        this.nmpwovh = i;
        this.qxvquar = kggugdpVar;
        this.oqexvyb = obj;
        this.ojyssqt = str;
        this.vivhedu = str2;
        this.lthborb = str3;
    }
}
