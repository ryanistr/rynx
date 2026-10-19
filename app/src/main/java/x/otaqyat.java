package x;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class otaqyat implements View.OnClickListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Dialog ojyssqt;
    public final /* synthetic */ sfildfy vivhedu;

    public /* synthetic */ otaqyat(Dialog dialog, sfildfy sfildfyVar, int i) {
        this.nmpwovh = i;
        this.ojyssqt = dialog;
        this.vivhedu = sfildfyVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.nmpwovh) {
            case 0:
                this.ojyssqt.dismiss();
                this.vivhedu.nmpwovh();
                break;
            default:
                this.ojyssqt.dismiss();
                this.vivhedu.nmpwovh();
                break;
        }
    }
}
