package x;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class qxvquar {
    public boolean nmpwovh;
    public final com.rynx.app.nmpwovh ojyssqt;

    public qxvquar(com.rynx.app.nmpwovh nmpwovhVar) {
        this.ojyssqt = nmpwovhVar;
    }

    public void nmpwovh(boolean z) {
        com.rynx.app.nmpwovh nmpwovhVar = this.ojyssqt;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            nmpwovhVar.runOnUiThread(new lthborb(this, z, 0));
            return;
        }
        if (this.nmpwovh == z) {
            return;
        }
        this.nmpwovh = z;
        if (z) {
            nmpwovhVar.getWindow().addFlags(128);
        } else {
            nmpwovhVar.getWindow().clearFlags(128);
        }
    }

    public qxvquar(kggugdp kggugdpVar, boolean z) {
        this.ojyssqt = kggugdpVar;
        this.nmpwovh = z;
    }
}
