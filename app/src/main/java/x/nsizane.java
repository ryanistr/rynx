package x;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nsizane implements DialogInterface.OnClickListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ com.rynx.app.nmpwovh ojyssqt;

    public /* synthetic */ nsizane(com.rynx.app.nmpwovh nmpwovhVar, int i) {
        this.nmpwovh = i;
        this.ojyssqt = nmpwovhVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
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
