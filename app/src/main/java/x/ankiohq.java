package x;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ankiohq implements Runnable {
    public final /* synthetic */ ArrayList lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ kggugdp ojyssqt;
    public final /* synthetic */ int vivhedu;

    public /* synthetic */ ankiohq(kggugdp kggugdpVar, int i, ArrayList arrayList, int i2) {
        this.nmpwovh = i2;
        this.ojyssqt = kggugdpVar;
        this.vivhedu = i;
        this.lthborb = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                kggugdp kggugdpVar = this.ojyssqt;
                kggugdpVar.getClass();
                kggugdpVar.zegwdrn(this.vivhedu, this.lthborb.size());
                break;
            default:
                kggugdp kggugdpVar2 = this.ojyssqt;
                kggugdpVar2.getClass();
                kggugdpVar2.zegwdrn(this.vivhedu, this.lthborb.size());
                break;
        }
    }
}
