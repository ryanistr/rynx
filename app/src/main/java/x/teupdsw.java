package x;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class teupdsw implements DialogInterface.OnClickListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ kggugdp ojyssqt;
    public final /* synthetic */ String vivhedu;

    public /* synthetic */ teupdsw(int i, String str, kggugdp kggugdpVar) {
        this.nmpwovh = i;
        this.ojyssqt = kggugdpVar;
        this.vivhedu = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.nmpwovh) {
            case 0:
                this.ojyssqt.zzqmpyp(this.vivhedu);
                break;
            case 1:
                kggugdp kggugdpVar = this.ojyssqt;
                kggugdpVar.mwocrhx.add(this.vivhedu);
                kggugdpVar.mslkofp = kggugdpVar.xqbcyis();
                kggugdpVar.gzokllk();
                break;
            default:
                kggugdp kggugdpVar2 = this.ojyssqt;
                kggugdpVar2.mwocrhx.add(this.vivhedu);
                kggugdpVar2.mslkofp = kggugdpVar2.xqbcyis();
                kggugdpVar2.gzokllk();
                break;
        }
    }
}
