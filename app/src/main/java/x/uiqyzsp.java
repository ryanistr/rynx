package x;

import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class uiqyzsp implements Runnable {
    public final /* synthetic */ String lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ long vivhedu;

    public /* synthetic */ uiqyzsp(MainActivity mainActivity, long j, String str, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
        this.vivhedu = j;
        this.lthborb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity = this.ojyssqt;
                long j = this.vivhedu;
                String str = this.lthborb;
                if (j == mainActivity.gepzcpd) {
                    mainActivity.nxumtuo = false;
                    if (str != null && !str.contains("InterruptedException")) {
                        mainActivity.fusjbbl("ERROR: ".concat(str));
                    }
                    if (mainActivity.thbdbid) {
                        mainActivity.fusjbbl(mainActivity.guecdgy().trim());
                    }
                    mainActivity.gdkopre();
                    break;
                }
                break;
            case 1:
                MainActivity mainActivity2 = this.ojyssqt;
                long j2 = this.vivhedu;
                String str2 = this.lthborb;
                if (j2 == mainActivity2.gepzcpd) {
                    mainActivity2.fusjbbl(str2);
                    break;
                }
                break;
            case 2:
                MainActivity mainActivity3 = this.ojyssqt;
                long j3 = this.vivhedu;
                String str3 = this.lthborb;
                if (j3 == mainActivity3.gepzcpd) {
                    mainActivity3.jbmzxye();
                    if (str3.startsWith("OK\n")) {
                        String strTrim = str3.substring(3).trim();
                        mainActivity3.nmpwovh("[FASTBOOT] " + strTrim);
                        if (strTrim.isEmpty()) {
                            strTrim = "OKAY";
                        }
                        mainActivity3.fusjbbl(strTrim);
                        Toast.makeText(mainActivity3, R.string.android_tools_fastboot_action_ok, 0).show();
                    } else {
                        String strTrim2 = str3.replaceFirst("^ERROR\n", "").trim();
                        mainActivity3.nmpwovh("[FASTBOOT] " + strTrim2);
                        mainActivity3.fusjbbl("ERROR: " + strTrim2);
                        Toast.makeText(mainActivity3, R.string.android_tools_fastboot_failed, 0).show();
                    }
                    mainActivity3.gdkopre();
                    if ("android_tools".equals(mainActivity3.ayzlrnr)) {
                        mainActivity3.wfxzfba(false);
                    }
                    break;
                }
                break;
            default:
                MainActivity mainActivity4 = this.ojyssqt;
                long j4 = this.vivhedu;
                String str4 = this.lthborb;
                if (j4 == mainActivity4.gepzcpd) {
                    mainActivity4.jbmzxye();
                    if (str4.startsWith("OK\n")) {
                        String strTrim3 = str4.substring(3).trim();
                        mainActivity4.fusjbbl(strTrim3.isEmpty() ? "OKAY" : strTrim3);
                        mainActivity4.nmpwovh("[FASTBOOT] ".concat(strTrim3));
                    } else {
                        String strTrim4 = str4.replaceFirst("^ERROR\n", "").trim();
                        mainActivity4.fusjbbl("ERROR: " + strTrim4);
                        mainActivity4.nmpwovh("[FASTBOOT] " + strTrim4);
                    }
                    mainActivity4.gdkopre();
                    if ("android_tools".equals(mainActivity4.ayzlrnr)) {
                        mainActivity4.wfxzfba(false);
                    }
                    break;
                }
                break;
        }
    }
}
