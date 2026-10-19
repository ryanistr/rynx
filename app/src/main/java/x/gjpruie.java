package x;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gjpruie implements View.OnClickListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ ecffprn ojyssqt;

    public /* synthetic */ gjpruie(ecffprn ecffprnVar, int i) {
        this.nmpwovh = i;
        this.ojyssqt = ecffprnVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.nmpwovh) {
            case 0:
                this.ojyssqt.vivhedu();
                break;
            default:
                ecffprn ecffprnVar = this.ojyssqt;
                ecffprnVar.ojyssqt(ecffprnVar.dytyqos);
                break;
        }
    }
}
