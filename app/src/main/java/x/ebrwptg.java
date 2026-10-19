package x;

import android.app.Activity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final class ebrwptg {
    public final TextView atntgcp;
    public final TextView buswjhz;
    public boolean czidoiw;
    public final LinearLayout dasxvpc;
    public final LinearLayout dplrlfq;
    public final TextView dytyqos;
    public final TextView ekyqleu;
    public final TextView gisppfs;
    public final TextView imuemzb;
    public final TextView jdqigmr;
    public final TextView lclupha;
    public boolean lpkdqgx;
    public final Activity lthborb;
    public final TextView nkemejx;
    public final ScrollView nmpwovh;
    public final EditText ojyssqt;
    public final TextView oqexvyb;
    public final TextView pvbzgon;
    public boolean pvkaerr;
    public final TextView qxvquar;
    public final TextView qyeibyo;
    public final TextView slxntng;
    public boolean uiqyzsp;
    public final LinearLayout ulafhci;
    public final TextView utmeivs;
    public final EditText vivhedu;
    public final TextView vntpaom;
    public boolean vopsyhw;
    public final LinearLayout wqrnifx;
    public final TextView zwaqeaz;

    public ebrwptg(ScrollView scrollView, Activity activity, EditText editText, EditText editText2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17) {
        this.nmpwovh = scrollView;
        this.lthborb = activity;
        this.ojyssqt = editText;
        this.vivhedu = editText2;
        this.qxvquar = textView;
        this.oqexvyb = textView2;
        this.nkemejx = textView3;
        this.imuemzb = textView4;
        this.dytyqos = textView5;
        this.wqrnifx = linearLayout;
        this.dasxvpc = linearLayout2;
        this.dplrlfq = linearLayout3;
        this.ulafhci = linearLayout4;
        this.ekyqleu = textView6;
        this.utmeivs = textView7;
        this.buswjhz = textView8;
        this.pvbzgon = textView9;
        this.qyeibyo = textView10;
        this.vntpaom = textView11;
        this.jdqigmr = textView12;
        this.lclupha = textView13;
        this.gisppfs = textView14;
        this.zwaqeaz = textView15;
        this.atntgcp = textView16;
        this.slxntng = textView17;
    }

    public static void lthborb(TextView textView, boolean z) {
        textView.setEnabled(z);
        textView.setAlpha(z ? 1.0f : 0.46f);
    }

    public static String ojyssqt(String str) {
        return (str == null || str.trim().isEmpty()) ? "—" : str.trim();
    }

    public final void dasxvpc(String str) {
        this.lpkdqgx = false;
        Activity activity = this.lthborb;
        String string = activity.getString(R.string.xiaomi_loader_bundle_failed, (str == null || str.trim().isEmpty()) ? activity.getString(R.string.xiaomi_authorize_unknown_error) : str.trim());
        TextView textView = this.lclupha;
        textView.setText(string);
        textView.setTextColor(zamkzqg.pzqxblc(activity));
        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_warning, zamkzqg.pzqxblc(activity));
        ekyqleu();
    }

    public final void dplrlfq() {
        this.lpkdqgx = false;
        TextView textView = this.lclupha;
        textView.setText(R.string.xiaomi_loader_bundle_idle);
        Activity activity = this.lthborb;
        textView.setTextColor(zamkzqg.jbmzxye(activity));
        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_info, zamkzqg.jbmzxye(activity));
        ekyqleu();
    }

    public final void dytyqos(int i) {
        this.uiqyzsp = false;
        Object[] objArr = {Integer.valueOf(i)};
        Activity activity = this.lthborb;
        String string = activity.getString(R.string.xiaomi_device_catalog_ready, objArr);
        TextView textView = this.jdqigmr;
        textView.setText(string);
        textView.setTextColor(zamkzqg.pzkwhtn(activity));
        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_status_done, zamkzqg.pzkwhtn(activity));
        ekyqleu();
    }

    public final void ekyqleu() {
        lthborb(this.ojyssqt, !this.pvkaerr);
        lthborb(this.vivhedu, !this.pvkaerr);
        lthborb(this.oqexvyb, !this.pvkaerr);
        lthborb(this.nkemejx, !this.pvkaerr);
        lthborb(this.imuemzb, this.czidoiw && !this.pvkaerr);
        lthborb(this.dytyqos, this.czidoiw && !this.pvkaerr);
        lthborb(this.gisppfs, (!this.czidoiw || this.pvkaerr || this.uiqyzsp) ? false : true);
        lthborb(this.zwaqeaz, (!this.czidoiw || this.pvkaerr || this.uiqyzsp) ? false : true);
        lthborb(this.slxntng, this.czidoiw && !this.pvkaerr && !this.uiqyzsp && this.vopsyhw && this.lpkdqgx);
    }

    public final void imuemzb() {
        this.uiqyzsp = true;
        TextView textView = this.jdqigmr;
        textView.setText(R.string.xiaomi_device_catalog_loading);
        Activity activity = this.lthborb;
        textView.setTextColor(zamkzqg.ohwxijw(activity));
        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_refresh, zamkzqg.ohwxijw(activity));
        ekyqleu();
    }

    public final void nkemejx(boolean z) {
        int i = z ? R.string.xiaomi_authorize_refreshing : R.string.xiaomi_authorize_logging_in;
        TextView textView = this.qxvquar;
        textView.setText(i);
        Activity activity = this.lthborb;
        textView.setTextColor(zamkzqg.ohwxijw(activity));
        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_refresh, zamkzqg.ohwxijw(activity));
        this.pvkaerr = true;
        ekyqleu();
    }

    public final void nmpwovh(StringBuilder sb, String str, int i) {
        if (str == null || str.trim().isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(" • ");
        }
        sb.append(this.lthborb.getString(i, str.trim()));
    }

    public final void oqexvyb(int i, boolean z) {
        TextView textView = this.qxvquar;
        textView.setText(i);
        Activity activity = this.lthborb;
        textView.setTextColor(z ? zamkzqg.ohwxijw(activity) : zamkzqg.pzkwhtn(activity));
        zamkzqg.enxkjpu(activity, textView, z ? R.drawable.ic_refresh : R.drawable.ic_status_done, z ? zamkzqg.ohwxijw(activity) : zamkzqg.pzkwhtn(activity));
        this.pvkaerr = z;
        ekyqleu();
    }

    public final void qxvquar(String str, String str2, String str3, String str4) {
        this.czidoiw = true;
        this.ekyqleu.setText(ojyssqt(str));
        this.utmeivs.setText(ojyssqt(str2));
        this.buswjhz.setText(ojyssqt(str3));
        this.pvbzgon.setText(ojyssqt(str4));
        TextView textView = this.qxvquar;
        textView.setText(R.string.xiaomi_authorize_connected);
        Activity activity = this.lthborb;
        textView.setTextColor(zamkzqg.pzkwhtn(activity));
        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_status_done, zamkzqg.pzkwhtn(activity));
        this.wqrnifx.setVisibility(8);
        this.dasxvpc.setVisibility(0);
        this.dplrlfq.setVisibility(0);
        this.ulafhci.setVisibility(0);
        this.pvkaerr = false;
        ekyqleu();
    }

    public final void ulafhci() {
        this.czidoiw = false;
        TextView textView = this.qxvquar;
        textView.setText(R.string.xiaomi_authorize_signed_out);
        Activity activity = this.lthborb;
        textView.setTextColor(zamkzqg.jbmzxye(activity));
        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_lock, zamkzqg.jbmzxye(activity));
        this.wqrnifx.setVisibility(0);
        this.dasxvpc.setVisibility(8);
        this.dplrlfq.setVisibility(8);
        this.ulafhci.setVisibility(8);
        vivhedu();
        this.pvkaerr = false;
        ekyqleu();
    }

    public final void vivhedu() {
        this.uiqyzsp = false;
        this.qyeibyo.setText(R.string.xiaomi_device_model_not_selected);
        this.vntpaom.setText(R.string.xiaomi_device_model_prompt);
        this.vopsyhw = false;
        this.atntgcp.setVisibility(8);
        dplrlfq();
        TextView textView = this.jdqigmr;
        textView.setText(R.string.xiaomi_device_catalog_idle);
        Activity activity = this.lthborb;
        textView.setTextColor(zamkzqg.jbmzxye(activity));
        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_info, zamkzqg.jbmzxye(activity));
    }

    public final void wqrnifx(String str, boolean z) {
        this.czidoiw = z;
        Activity activity = this.lthborb;
        String string = activity.getString(R.string.xiaomi_authorize_login_failed, (str == null || str.trim().isEmpty()) ? activity.getString(R.string.xiaomi_authorize_unknown_error) : str.trim());
        TextView textView = this.qxvquar;
        textView.setText(string);
        textView.setTextColor(zamkzqg.pzqxblc(activity));
        zamkzqg.enxkjpu(activity, textView, R.drawable.ic_warning, zamkzqg.pzqxblc(activity));
        this.wqrnifx.setVisibility(z ? 8 : 0);
        this.dasxvpc.setVisibility(z ? 0 : 8);
        this.dplrlfq.setVisibility(z ? 0 : 8);
        this.ulafhci.setVisibility(z ? 0 : 8);
        if (!z) {
            vivhedu();
        }
        this.pvkaerr = false;
        ekyqleu();
    }
}
