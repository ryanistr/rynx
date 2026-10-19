package x;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class naaizwn implements Runnable {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ kggugdp ojyssqt;
    public final /* synthetic */ String vivhedu;

    public /* synthetic */ naaizwn(int i, String str, kggugdp kggugdpVar) {
        this.nmpwovh = i;
        this.ojyssqt = kggugdpVar;
        this.vivhedu = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                this.ojyssqt.eenkamx(this.vivhedu);
                break;
            default:
                this.ojyssqt.xvxmcgn(this.vivhedu);
                break;
        }
    }
}
