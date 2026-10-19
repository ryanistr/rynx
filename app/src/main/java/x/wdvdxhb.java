package x;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wdvdxhb implements DialogInterface.OnCancelListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ sfildfy ojyssqt;

    public /* synthetic */ wdvdxhb(sfildfy sfildfyVar, int i) {
        this.nmpwovh = i;
        this.ojyssqt = sfildfyVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        switch (this.nmpwovh) {
            case 0:
                this.ojyssqt.nmpwovh();
                break;
            default:
                this.ojyssqt.nmpwovh();
                break;
        }
    }
}
