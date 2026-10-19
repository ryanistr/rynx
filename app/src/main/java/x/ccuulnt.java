package x;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class ccuulnt {
    public boolean oqexvyb;
    public volatile boolean qxvquar;
    public final kxotgjb vivhedu;
    public final StringBuilder nmpwovh = new StringBuilder();
    public final Handler ojyssqt = new Handler(Looper.getMainLooper());
    public final eigllth lthborb = new eigllth(this, 1);

    public ccuulnt(kxotgjb kxotgjbVar) {
        this.vivhedu = kxotgjbVar;
    }

    public final void nmpwovh(boolean z) {
        if (!this.qxvquar || this.vivhedu == null) {
            return;
        }
        synchronized (this) {
            try {
                if (this.oqexvyb) {
                    if (!z) {
                        return;
                    } else {
                        this.ojyssqt.removeCallbacks(this.lthborb);
                    }
                }
                this.oqexvyb = true;
                if (z) {
                    this.ojyssqt.post(this.lthborb);
                } else {
                    this.ojyssqt.postDelayed(this.lthborb, 75L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void ojyssqt() {
        StringBuilder sb = this.nmpwovh;
        if (sb.length() <= 24000) {
            return;
        }
        int length = sb.length() - 18000;
        int iIndexOf = sb.indexOf("\n", length);
        if (iIndexOf >= 0) {
            length = iIndexOf + 1;
        }
        sb.delete(0, Math.min(length, sb.length()));
    }
}
