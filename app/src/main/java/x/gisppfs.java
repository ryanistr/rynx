package x;

import android.app.Activity;
import android.widget.TextView;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gisppfs implements Runnable {
    public final /* synthetic */ String lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ String vivhedu;

    public /* synthetic */ gisppfs(MainActivity mainActivity, String str, String str2, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
        this.vivhedu = str;
        this.lthborb = str2;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0095 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0097  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b0  */
    @Override // java.lang.Runnable
    public final void run() {
        String string;
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity = this.ojyssqt;
                String str = this.vivhedu;
                if (str != null) {
                    mainActivity.getClass();
                    if (str.startsWith("OK\n")) {
                        chwohho chwohhoVarClczezu = MainActivity.clczezu(str);
                        String str2 = chwohhoVarClczezu.vivhedu;
                        mainActivity.rrpfqyy = (str2 != null ? str2 : "").trim().toUpperCase(Locale.ROOT);
                        if (mainActivity.pmsrvoc != null && "bootloader_manager".equals(mainActivity.ayzlrnr)) {
                            iilntfn iilntfnVar = mainActivity.pmsrvoc;
                            TextView textView = iilntfnVar.ojyssqt;
                            textView.setText(R.string.bootloader_bootctrl_valid);
                            Activity activity = iilntfnVar.nmpwovh;
                            textView.setTextColor(zamkzqg.pzkwhtn(activity));
                            zamkzqg.enxkjpu(activity, textView, R.drawable.ic_status_done, zamkzqg.pzkwhtn(activity));
                            iilntfnVar.qxvquar(chwohhoVarClczezu, true);
                        }
                        boolean zContains = str.contains("BOOTCTRL NOT CHANGED");
                        String str3 = this.lthborb;
                        zfmpmio.nmpwovh(mainActivity, zContains ? mainActivity.getString(R.string.bootloader_slot_switch_no_change, str3) : mainActivity.getString(R.string.bootloader_slot_switch_complete, str3), true);
                        mainActivity.nmpwovh(str.trim());
                    } else {
                        if (str != null) {
                            mainActivity.getClass();
                            if (str.trim().isEmpty()) {
                                string = mainActivity.getString(R.string.error_jni_null);
                            } else {
                                string = str.replaceFirst("^ERROR\\n", "").trim();
                            }
                        } else {
                            string = mainActivity.getString(R.string.error_jni_null);
                        }
                        if (mainActivity.pmsrvoc != null && "bootloader_manager".equals(mainActivity.ayzlrnr)) {
                            mainActivity.pmsrvoc.lthborb(string);
                        }
                        zfmpmio.nmpwovh(mainActivity, mainActivity.getString(R.string.bootloader_slot_switch_failed), false);
                        mainActivity.nmpwovh("BOOTCTRL ERROR\n" + string);
                    }
                } else {
                    if (str != null) {
                        mainActivity.getClass();
                        if (str.trim().isEmpty()) {
                            string = mainActivity.getString(R.string.error_jni_null);
                        } else {
                            string = str.replaceFirst("^ERROR\\n", "").trim();
                        }
                    } else {
                        string = mainActivity.getString(R.string.error_jni_null);
                    }
                    if (mainActivity.pmsrvoc != null) {
                        mainActivity.pmsrvoc.lthborb(string);
                    }
                    zfmpmio.nmpwovh(mainActivity, mainActivity.getString(R.string.bootloader_slot_switch_failed), false);
                    mainActivity.nmpwovh("BOOTCTRL ERROR\n" + string);
                }
                mainActivity.gefzxcg();
                break;
            default:
                this.ojyssqt.czqxnxv("flash", this.vivhedu, this.lthborb);
                break;
        }
    }
}
