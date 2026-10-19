package x;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class ghkjjru {
    public final Object lthborb;
    public final Object nmpwovh;
    public final Object ojyssqt;
    public final Object vivhedu;

    public /* synthetic */ ghkjjru(Object obj, Object obj2, Object obj3, Object obj4) {
        this.nmpwovh = obj;
        this.ojyssqt = obj2;
        this.vivhedu = obj3;
        this.lthborb = obj4;
    }

    public void nmpwovh() {
        synchronized (this.nmpwovh) {
            try {
                boolean[] zArr = (boolean[]) this.ojyssqt;
                if (zArr[0]) {
                    zArr[0] = false;
                    ((CountDownLatch) this.lthborb).countDown();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ghkjjru(String str, String str2, String str3, String str4) {
        this.nmpwovh = zamkzqg.ydsyayx(str);
        this.ojyssqt = zamkzqg.ydsyayx(str2);
        this.vivhedu = zamkzqg.ydsyayx(str3);
        this.lthborb = zamkzqg.ydsyayx(str4).isEmpty() ? "0" : zamkzqg.ydsyayx(str4);
    }
}
