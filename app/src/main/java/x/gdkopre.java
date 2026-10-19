package x;

/* JADX INFO: loaded from: classes.dex */
public final class gdkopre implements Runnable {
    public final /* synthetic */ vlyywxv nmpwovh;

    public gdkopre(vlyywxv vlyywxvVar) {
        this.nmpwovh = vlyywxvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        vlyywxv vlyywxvVar = this.nmpwovh;
        vlyywxvVar.imuemzb();
        long j = vlyywxvVar.gzokllk;
        long jMax = j <= 0 ? -1L : Math.max(0L, j - Math.max(0L, System.currentTimeMillis() / 1000));
        if (!vlyywxvVar.ojyssqt.isShowing() || vlyywxvVar.pvkaerr || jMax <= 0) {
            return;
        }
        vlyywxvVar.wygqgxb.postDelayed(this, 1000L);
    }
}
