package x;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.R;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bwvplah implements View.OnClickListener {
    public final /* synthetic */ Object lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ KeyEvent.Callback ojyssqt;
    public final /* synthetic */ Object oqexvyb;
    public final /* synthetic */ Object qxvquar;
    public final /* synthetic */ Object vivhedu;

    public /* synthetic */ bwvplah(KeyEvent.Callback callback, Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.nmpwovh = i;
        this.ojyssqt = callback;
        this.vivhedu = obj;
        this.lthborb = obj2;
        this.qxvquar = obj3;
        this.oqexvyb = obj4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.nmpwovh) {
            case 0:
                zamkzqg.cnctlxz((Activity) this.ojyssqt, (TextView) this.vivhedu, (TextView) this.lthborb, (LinearLayout) this.qxvquar, (LinearLayout) this.oqexvyb, false);
                return;
            case 1:
                EditText editText = (EditText) this.ojyssqt;
                Context context = (Context) this.vivhedu;
                ghkjjru ghkjjruVar = (ghkjjru) this.lthborb;
                boolean[] zArr = (boolean[]) this.qxvquar;
                Dialog dialog = (Dialog) this.oqexvyb;
                String string = editText.getText().toString();
                if (string.trim().isEmpty()) {
                    Toast.makeText(context, R.string.sla_brom_manual_response_required, 0).show();
                    return;
                }
                ghkjjruVar.getClass();
                String strUiqyzsp = com.rynx.app.ojyssqt.uiqyzsp(string);
                if (strUiqyzsp != null) {
                    synchronized (ghkjjruVar.nmpwovh) {
                        boolean[] zArr2 = (boolean[]) ghkjjruVar.ojyssqt;
                        if (zArr2[0]) {
                            zArr2[0] = false;
                            ((String[]) ghkjjruVar.vivhedu)[0] = strUiqyzsp;
                            ((CountDownLatch) ghkjjruVar.lthborb).countDown();
                            zArr[0] = true;
                            dialog.dismiss();
                            return;
                        }
                    }
                }
                Toast.makeText(context, R.string.sla_brom_manual_response_invalid, 0).show();
                return;
            default:
                String strTrim = ((EditText) this.ojyssqt).getText().toString().trim();
                String string2 = ((EditText) this.vivhedu).getText().toString();
                if (strTrim.isEmpty() || string2.isEmpty()) {
                    Toast.makeText((Context) this.lthborb, R.string.sla_credentials_required, 0).show();
                    return;
                } else {
                    ((Dialog) this.qxvquar).dismiss();
                    ((sfildfy) this.oqexvyb).ojyssqt(strTrim, string2);
                    return;
                }
        }
    }
}
