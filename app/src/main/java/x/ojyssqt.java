package x;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ojyssqt implements DialogInterface.OnShowListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;

    public /* synthetic */ ojyssqt(Object obj, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        switch (this.nmpwovh) {
            case 0:
                Window window = ((AlertDialog) this.ojyssqt).getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                break;
            default:
                ecffprn ecffprnVar = (ecffprn) this.ojyssqt;
                if (ecffprnVar.vivhedu == 1) {
                    ecffprnVar.wqrnifx.getButton(-1).setOnClickListener(new gjpruie(ecffprnVar, 1));
                }
                ecffprnVar.qxvquar();
                break;
        }
    }
}
