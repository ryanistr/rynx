package x;

/* JADX INFO: loaded from: classes.dex */
public final class mcdstyz {
    public final /* synthetic */ kggugdp nmpwovh;

    public mcdstyz(kggugdp nmpwovhVar) {
        this.nmpwovh = nmpwovhVar;
    }

    public void nmpwovh(String str) {
        kggugdp kggugdpVar = this.nmpwovh;
        kggugdpVar.getClass();
        if ("download_only".equals(str) || "firmware_upgrade".equals(str)) {
            kggugdpVar.ijakhcl = str;
            if (!"firmware_upgrade".equals(str)) {
                kggugdpVar.lsgjyur = false;
            }
            kggugdpVar.osgyung = 0;
            kggugdpVar.ljwltks();
            kggugdpVar.ydsyayx();
            kggugdpVar.gzokllk();
        }
    }
}
