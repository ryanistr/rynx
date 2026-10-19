package x;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eigllth implements Runnable {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;

    public /* synthetic */ eigllth(Object obj, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String string;
        int i;
        int i2 = 0;
        switch (this.nmpwovh) {
            case 0:
                ((ScrollView) this.ojyssqt).fullScroll(130);
                return;
            case 1:
                ccuulnt ccuulntVar = (ccuulnt) this.ojyssqt;
                synchronized (ccuulntVar) {
                    ccuulntVar.oqexvyb = false;
                    string = ccuulntVar.nmpwovh.toString();
                }
                kxotgjb kxotgjbVar = ccuulntVar.vivhedu;
                if (kxotgjbVar != null) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                    int iRgb = Color.rgb(232, 236, 233);
                    int iRgb2 = Color.rgb(126, 200, 132);
                    int iRgb3 = Color.rgb(255, 138, 128);
                    int iRgb4 = Color.rgb(255, 209, 128);
                    while (i2 < string.length()) {
                        int iIndexOf = string.indexOf(10, i2);
                        if (iIndexOf < 0) {
                            iIndexOf = string.length();
                        }
                        String strTrim = string.substring(i2, iIndexOf).trim();
                        if (strTrim.startsWith("ERROR") || strTrim.startsWith("FAILED") || strTrim.toLowerCase(Locale.ROOT).contains("permission denied")) {
                            i = iRgb3;
                        } else if (strTrim.startsWith("[cancelled]") || strTrim.startsWith("[direct USB]")) {
                            i = iRgb4;
                        } else {
                            i = (strTrim.startsWith("OKAY") || strTrim.startsWith("Success") || strTrim.startsWith("/sdcard") || strTrim.startsWith("device:") || strTrim.contains(" $ adb ") || strTrim.contains(" $ fastboot ") || strTrim.contains(":/ $ ") || strTrim.contains(":/ # ") || strTrim.matches("^[A-Za-z0-9._-]+:/.* [#$]( .*)?$")) ? iRgb2 : iRgb;
                        }
                        if (iIndexOf > i2) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), i2, iIndexOf, 33);
                        }
                        i2 = iIndexOf + 1;
                    }
                    com.rynx.app.nmpwovh nmpwovhVar = kxotgjbVar.nmpwovh;
                    if (nmpwovhVar.ltnesel == null || !"android_tools".equals(nmpwovhVar.ayzlrnr)) {
                        return;
                    }
                    nmpwovhVar.ltnesel.qxvquar.setText(spannableStringBuilder);
                    nmpwovhVar.ltnesel.oqexvyb.post(new ezxxysz(nmpwovhVar, 4));
                    return;
                }
                return;
            case 2:
                ((FrameLayout) this.ojyssqt).requestApplyInsets();
                return;
            case 3:
                ysaclsr ysaclsrVar = (ysaclsr) this.ojyssqt;
                View childAt = ysaclsrVar.ojyssqt.getChildAt(0);
                if (childAt != null) {
                    ysaclsrVar.ojyssqt.scrollTo(0, Math.max(0, childAt.getHeight() - ysaclsrVar.ojyssqt.getHeight()));
                }
                EditText editText = ysaclsrVar.vivhedu;
                if (editText == null || !editText.hasFocus()) {
                    return;
                }
                ysaclsrVar.vivhedu.requestRectangleOnScreen(new Rect(0, 0, ysaclsrVar.vivhedu.getWidth(), ysaclsrVar.vivhedu.getHeight()), true);
                return;
            case 4:
                int[] iArr = MainActivity.rzsxsyc;
                Dialog dialog = ((Dialog[]) this.ojyssqt)[0];
                if (dialog == null || !dialog.isShowing()) {
                    return;
                }
                dialog.dismiss();
                return;
            case 5:
                Toast.makeText((Activity) this.ojyssqt, R.string.update_check_failed, 0).show();
                return;
            default:
                ((vlyywxv) this.ojyssqt).vntpaom.fullScroll(130);
                return;
        }
    }
}
