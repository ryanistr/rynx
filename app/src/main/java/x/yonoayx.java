package x;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yonoayx implements DialogInterface.OnDismissListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ com.rynx.app.nmpwovh ojyssqt;

    public /* synthetic */ yonoayx(com.rynx.app.nmpwovh nmpwovhVar, int i) {
        this.nmpwovh = i;
        this.ojyssqt = nmpwovhVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.nmpwovh) {
            case 0:
                this.ojyssqt.finishAndRemoveTask();
                break;
            default:
                this.ojyssqt.finishAndRemoveTask();
                break;
        }
    }
}
