package x;

import android.view.KeyEvent;
import android.widget.ScrollView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class btazysh implements Runnable {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ int ojyssqt;
    public final /* synthetic */ KeyEvent.Callback vivhedu;

    public /* synthetic */ btazysh(KeyEvent.Callback callback, int i, int i2) {
        this.nmpwovh = i2;
        this.vivhedu = callback;
        this.ojyssqt = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                com.rynx.app.nmpwovh nmpwovhVar = (com.rynx.app.nmpwovh) this.vivhedu;
                if (nmpwovhVar.vopsyhw != null && !nmpwovhVar.isFinishing() && !nmpwovhVar.isDestroyed()) {
                    ((TextView) nmpwovhVar.vopsyhw.ojyssqt).setText(this.ojyssqt);
                    break;
                }
                break;
            case 1:
                ljhdwjr ljhdwjrVar = (ljhdwjr) this.vivhedu;
                if (this.ojyssqt == ljhdwjrVar.nkemejx && !ljhdwjrVar.vivhedu) {
                    ljhdwjrVar.setVisibility(8);
                    break;
                }
                break;
            default:
                ((ScrollView) this.vivhedu).scrollTo(0, this.ojyssqt);
                break;
        }
    }
}
