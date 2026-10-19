package x;

import android.app.Activity;
import android.widget.TextView;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class utmeivs implements Runnable {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ String vivhedu;

    public /* synthetic */ utmeivs(MainActivity mainActivity, String str, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
        this.vivhedu = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.vivhedu;
        MainActivity mainActivity = this.ojyssqt;
        switch (this.nmpwovh) {
            case 0:
                mainActivity.czqxnxv("boot", "", str);
                break;
            case 1:
                mainActivity.getClass();
                mainActivity.bsimxgu("erase:" + str);
                break;
            case 2:
                mainActivity.getClass();
                mainActivity.bsimxgu("flashing " + str);
                break;
            case 3:
                mainActivity.bsimxgu(str);
                break;
            case 4:
                mainActivity.bsimxgu(str);
                break;
            case 5:
                mainActivity.bsimxgu(str);
                break;
            case 6:
                mainActivity.bsimxgu(str);
                break;
            case 7:
                mainActivity.bsimxgu(str);
                break;
            case 8:
                mainActivity.bsimxgu(str);
                break;
            case 9:
                mainActivity.aylswsn(str);
                break;
            case 10:
                if (mainActivity.pmsrvoc != null && "bootloader_manager".equals(mainActivity.ayzlrnr)) {
                    if (str == null || !str.startsWith("OK\n")) {
                        mainActivity.rrpfqyy = "";
                        mainActivity.pmsrvoc.lthborb((str == null || str.trim().isEmpty()) ? mainActivity.getString(R.string.error_jni_null) : str.replaceFirst("^ERROR\\n", "").trim());
                    } else {
                        chwohho chwohhoVarClczezu = MainActivity.clczezu(str);
                        String str2 = chwohhoVarClczezu.vivhedu;
                        mainActivity.rrpfqyy = (str2 != null ? str2 : "").trim().toUpperCase(Locale.ROOT);
                        iilntfn iilntfnVar = mainActivity.pmsrvoc;
                        TextView textView = iilntfnVar.ojyssqt;
                        textView.setText(R.string.bootloader_bootctrl_valid);
                        Activity activity = iilntfnVar.nmpwovh;
                        textView.setTextColor(zamkzqg.pzkwhtn(activity));
                        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_status_done, zamkzqg.pzkwhtn(activity));
                        iilntfnVar.qxvquar(chwohhoVarClczezu, true);
                    }
                }
                mainActivity.gefzxcg();
                break;
            case 11:
                int[] iArr = MainActivity.rzsxsyc;
                mainActivity.getClass();
                mainActivity.nmpwovh("[SLA] Sending live " + str + " challenge to authorization server…");
                break;
            default:
                mainActivity.nmpwovh(str);
                break;
        }
    }
}
