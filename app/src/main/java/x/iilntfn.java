package x;

import android.app.Activity;
import android.widget.ScrollView;
import android.widget.TextView;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final class iilntfn {
    public final Object dytyqos;
    public final Object imuemzb;
    public final TextView lthborb;
    public final TextView nkemejx;
    public final Activity nmpwovh;
    public final TextView ojyssqt;
    public final TextView oqexvyb;
    public final TextView qxvquar;
    public final TextView vivhedu;

    public iilntfn(ScrollView scrollView, Activity activity, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, iilntfn iilntfnVar, iilntfn iilntfnVar2) {
        this.nmpwovh = activity;
        this.ojyssqt = textView;
        this.vivhedu = textView2;
        this.lthborb = textView3;
        this.qxvquar = textView4;
        this.oqexvyb = textView5;
        this.nkemejx = textView6;
        this.imuemzb = iilntfnVar;
        this.dytyqos = iilntfnVar2;
    }

    public static String ojyssqt(String str) {
        return (str == null || str.trim().isEmpty()) ? "—" : str.trim();
    }

    public void lthborb(String str) {
        String strTrim = (str == null || str.trim().isEmpty()) ? "Unknown error" : str.trim();
        Activity activity = this.nmpwovh;
        String string = activity.getString(R.string.bootloader_bootctrl_unavailable, strTrim);
        TextView textView = this.ojyssqt;
        textView.setText(string);
        textView.setTextColor(zamkzqg.ohwxijw(activity));
        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_warning, zamkzqg.ohwxijw(activity));
        qxvquar(new chwohho(), false);
    }

    public void nmpwovh(boolean z, String str, String str2, String str3, String str4, String str5, boolean z2) {
        int i = z ? R.string.bootloader_slot_active_title : R.string.bootloader_slot_title;
        String str6 = (String) this.imuemzb;
        Activity activity = this.nmpwovh;
        String string = activity.getString(i, str6);
        TextView textView = this.ojyssqt;
        textView.setText(string);
        textView.setTextColor(z ? zamkzqg.pzkwhtn(activity) : zamkzqg.zngzleo(activity));
        this.vivhedu.setText(ojyssqt(str));
        this.lthborb.setText(ojyssqt(str2));
        this.qxvquar.setText(ojyssqt(str3));
        this.oqexvyb.setText(ojyssqt(str4));
        this.nkemejx.setText(ojyssqt(str5));
        boolean z3 = z2 && !z;
        TextView textView2 = (TextView) this.dytyqos;
        textView2.setEnabled(z3);
        textView2.setAlpha(z3 ? 1.0f : 0.48f);
        textView2.setText(z ? activity.getString(R.string.bootloader_slot_current) : activity.getString(R.string.bootloader_slot_set_active, str6));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0062  */
    /* JADX WARN: Code duplicated, block: B:19:0x008f  */
    public void qxvquar(chwohho chwohhoVar, boolean z) {
        boolean z2;
        boolean z3;
        int i;
        int i2;
        this.vivhedu.setText(ojyssqt(chwohhoVar.nmpwovh));
        this.lthborb.setText(ojyssqt(chwohhoVar.ojyssqt));
        this.qxvquar.setText(ojyssqt(chwohhoVar.vivhedu));
        this.oqexvyb.setText(ojyssqt(chwohhoVar.lthborb));
        this.nkemejx.setText(ojyssqt(chwohhoVar.qxvquar));
        boolean zEqualsIgnoreCase = "A".equalsIgnoreCase(chwohhoVar.vivhedu);
        String str = chwohhoVar.oqexvyb;
        String str2 = chwohhoVar.nkemejx;
        String str3 = chwohhoVar.imuemzb;
        String str4 = chwohhoVar.dytyqos;
        String str5 = chwohhoVar.wqrnifx;
        if (z) {
            try {
                i2 = Integer.parseInt(ojyssqt(chwohhoVar.ojyssqt));
            } catch (Throwable unused) {
                i2 = 0;
            }
            if (i2 >= 2) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        ((iilntfn) this.imuemzb).nmpwovh(zEqualsIgnoreCase, str, str2, str3, str4, str5, z2);
        boolean zEqualsIgnoreCase2 = "B".equalsIgnoreCase(chwohhoVar.vivhedu);
        String str6 = chwohhoVar.dasxvpc;
        String str7 = chwohhoVar.dplrlfq;
        String str8 = chwohhoVar.ulafhci;
        String str9 = chwohhoVar.ekyqleu;
        String str10 = chwohhoVar.utmeivs;
        if (z) {
            try {
                i = Integer.parseInt(ojyssqt(chwohhoVar.ojyssqt));
            } catch (Throwable unused2) {
                i = 0;
            }
            if (i >= 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            z3 = false;
        }
        ((iilntfn) this.dytyqos).nmpwovh(zEqualsIgnoreCase2, str6, str7, str8, str9, str10, z3);
    }

    public void vivhedu() {
        TextView textView = this.ojyssqt;
        textView.setText(R.string.bootloader_bootctrl_reading);
        Activity activity = this.nmpwovh;
        textView.setTextColor(zamkzqg.ohwxijw(activity));
        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_refresh, zamkzqg.ohwxijw(activity));
        qxvquar(new chwohho(), false);
    }

    public iilntfn(Activity activity, String str, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.nmpwovh = activity;
        this.imuemzb = str;
        this.ojyssqt = textView;
        this.vivhedu = textView2;
        this.lthborb = textView3;
        this.qxvquar = textView4;
        this.oqexvyb = textView5;
        this.nkemejx = textView6;
        this.dytyqos = textView7;
    }
}
