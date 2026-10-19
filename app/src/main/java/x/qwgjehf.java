package x;

import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qwgjehf implements Runnable {
    public final /* synthetic */ String lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;
    public final /* synthetic */ Object qxvquar;
    public final /* synthetic */ boolean vivhedu;

    public /* synthetic */ qwgjehf(MainActivity mainActivity, String str, String str2, boolean z) {
        this.nmpwovh = 0;
        this.ojyssqt = mainActivity;
        this.lthborb = str;
        this.qxvquar = str2;
        this.vivhedu = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity = (MainActivity) this.ojyssqt;
                mainActivity.getClass();
                String str = this.lthborb;
                if (str == null) {
                    Toast.makeText(mainActivity, R.string.android_tools_adb_reboot_ok, 0).show();
                    mainActivity.nmpwovh("[ADB] reboot request accepted");
                    mainActivity.fusjbbl("ADB reboot request accepted: " + ((String) this.qxvquar));
                } else if (this.vivhedu) {
                    Toast.makeText(mainActivity, R.string.android_tools_adb_unauthorized, 0).show();
                    mainActivity.nmpwovh("[ADB] ".concat(str));
                    mainActivity.fusjbbl(mainActivity.getString(R.string.android_tools_adb_allow_prompt));
                } else {
                    Toast.makeText(mainActivity, R.string.android_tools_adb_failed, 0).show();
                    mainActivity.nmpwovh("[ADB] ".concat(str));
                    mainActivity.fusjbbl("ERROR: ".concat(str));
                }
                if ("android_tools".equals(mainActivity.ayzlrnr)) {
                    mainActivity.wfxzfba(false);
                }
                break;
            case 1:
                MainActivity mainActivity2 = (MainActivity) this.ojyssqt;
                mainActivity2.nysvajy();
                if (mainActivity2.ltnesel != null && "android_tools".equals(mainActivity2.ayzlrnr)) {
                    wqrnifx wqrnifxVar = (wqrnifx) this.qxvquar;
                    if (wqrnifxVar == null) {
                        boolean z = this.vivhedu;
                        String str2 = this.lthborb;
                        if (!z) {
                            mainActivity2.pwnmyid();
                            mainActivity2.ltnesel.vivhedu.setText(R.string.android_tools_adb_failed);
                            mainActivity2.ltnesel.vivhedu.setTextColor(mainActivity2.nkemejx);
                            zamkzqg.enxkjpu(mainActivity2, mainActivity2.ltnesel.vivhedu, R.drawable.ic_warning, mainActivity2.nkemejx);
                            if (!com.rynx.app.ojyssqt.zwaqeaz(str2)) {
                                mainActivity2.nmpwovh("[ADB] " + str2);
                            }
                        } else {
                            mainActivity2.pwnmyid();
                            mainActivity2.ltnesel.dytyqos.setText(R.string.android_tools_adb_unauthorized_value);
                            mainActivity2.ltnesel.vivhedu.setText(R.string.android_tools_adb_unauthorized);
                            mainActivity2.ltnesel.vivhedu.setTextColor(mainActivity2.oqexvyb);
                            zamkzqg.enxkjpu(mainActivity2, mainActivity2.ltnesel.vivhedu, R.drawable.ic_warning, mainActivity2.oqexvyb);
                            mainActivity2.fusjbbl(mainActivity2.getString(R.string.android_tools_adb_allow_prompt));
                            if (!com.rynx.app.ojyssqt.zwaqeaz(str2)) {
                                mainActivity2.nmpwovh("[ADB] " + str2);
                            }
                        }
                    } else {
                        mainActivity2.ltnesel.dytyqos.setText(com.rynx.app.ojyssqt.zwaqeaz(wqrnifxVar.nmpwovh) ? "device" : wqrnifxVar.nmpwovh);
                        mainActivity2.ltnesel.wqrnifx.setText(com.rynx.app.ojyssqt.zwaqeaz(wqrnifxVar.ojyssqt) ? "—" : wqrnifxVar.ojyssqt);
                        mainActivity2.ltnesel.dasxvpc.setText(com.rynx.app.ojyssqt.zwaqeaz(wqrnifxVar.vivhedu) ? "—" : wqrnifxVar.vivhedu);
                        mainActivity2.ltnesel.dplrlfq.setText(com.rynx.app.ojyssqt.zwaqeaz(wqrnifxVar.lthborb) ? "—" : wqrnifxVar.lthborb);
                        mainActivity2.ltnesel.ulafhci.setText(com.rynx.app.ojyssqt.zwaqeaz(wqrnifxVar.qxvquar) ? "—" : wqrnifxVar.qxvquar);
                        mainActivity2.ltnesel.ekyqleu.setText(com.rynx.app.ojyssqt.zwaqeaz(wqrnifxVar.oqexvyb) ? "—" : wqrnifxVar.oqexvyb);
                        mainActivity2.ltnesel.vivhedu.setText(R.string.android_tools_adb_authorized);
                        mainActivity2.ltnesel.vivhedu.setTextColor(mainActivity2.qxvquar);
                        zamkzqg.enxkjpu(mainActivity2, mainActivity2.ltnesel.vivhedu, R.drawable.ic_terminal, mainActivity2.qxvquar);
                        StringBuilder sb = new StringBuilder("[ADB] connected: ");
                        sb.append(com.rynx.app.ojyssqt.zwaqeaz(wqrnifxVar.ojyssqt) ? "Android device" : wqrnifxVar.ojyssqt);
                        mainActivity2.nmpwovh(sb.toString());
                    }
                    break;
                }
                break;
            default:
                rvrflql rvrflqlVar = (rvrflql) this.ojyssqt;
                rvrflqlVar.getClass();
                TextView textView = (TextView) this.qxvquar;
                ibfmasn ibfmasnVar = (ibfmasn) textView.getTag();
                if (this.lthborb.equals((String) rvrflqlVar.vivhedu) && ibfmasnVar.lthborb) {
                    textView.setText(ibfmasnVar.ojyssqt);
                    if (this.vivhedu) {
                        zfmpmio.ojyssqt(textView);
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ qwgjehf(MainActivity mainActivity, wqrnifx wqrnifxVar, boolean z, String str) {
        this.nmpwovh = 1;
        this.ojyssqt = mainActivity;
        this.qxvquar = wqrnifxVar;
        this.vivhedu = z;
        this.lthborb = str;
    }

    public /* synthetic */ qwgjehf(rvrflql rvrflqlVar, TextView textView, String str, boolean z) {
        this.nmpwovh = 2;
        this.ojyssqt = rvrflqlVar;
        this.qxvquar = textView;
        this.lthborb = str;
        this.vivhedu = z;
    }
}
