package x;

import android.app.Dialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bsimxgu implements View.OnClickListener {
    public final /* synthetic */ Object lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;
    public final /* synthetic */ KeyEvent.Callback vivhedu;

    public /* synthetic */ bsimxgu(Object obj, KeyEvent.Callback callback, Object obj2, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
        this.vivhedu = callback;
        this.lthborb = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.nmpwovh) {
            case 0:
                boolean[] zArr = (boolean[]) this.ojyssqt;
                if (!zArr[0]) {
                    zArr[0] = true;
                    ((Dialog) this.vivhedu).dismiss();
                    ((ghkjjru) this.lthborb).nmpwovh();
                    break;
                }
                break;
            default:
                ((gepzcpd) this.ojyssqt).nmpwovh(((EditText) this.vivhedu).getText().toString(), ((EditText) this.lthborb).getText().toString());
                break;
        }
    }
}
