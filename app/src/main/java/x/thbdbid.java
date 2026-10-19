package x;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class thbdbid implements fusjbbl {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ kggugdp ojyssqt;

    public /* synthetic */ thbdbid(kggugdp kggugdpVar, int i) {
        this.nmpwovh = i;
        this.ojyssqt = kggugdpVar;
    }

    @Override // x.fusjbbl
    public void nmpwovh(File file) {
        switch (this.nmpwovh) {
            case 0:
                kggugdp kggugdpVar = this.ojyssqt;
                kggugdpVar.getClass();
                kggugdpVar.wygqgxb(file.getParentFile());
                kggugdpVar.eqqqfvj(file);
                break;
            case 1:
                kggugdp kggugdpVar2 = this.ojyssqt;
                kggugdpVar2.wygqgxb(file);
                kggugdpVar2.nuoqzvr(file);
                break;
            default:
                kggugdp kggugdpVar3 = this.ojyssqt;
                kggugdpVar3.getClass();
                kggugdpVar3.wygqgxb(file.getParentFile());
                kggugdpVar3.ftrcqfq(file);
                break;
        }
    }
}
