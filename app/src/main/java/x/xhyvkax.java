package x;

/* JADX INFO: loaded from: classes.dex */
public final class xhyvkax {
    public volatile long lthborb;
    public final String nmpwovh;
    public volatile String ojyssqt;
    public volatile ghkjjru qxvquar;
    public volatile String vivhedu;

    public xhyvkax(String str, String str2, String str3, long j, ghkjjru ghkjjruVar) {
        this.nmpwovh = str.trim();
        this.ojyssqt = str2.trim();
        this.vivhedu = zamkzqg.ydsyayx(str3);
        this.lthborb = j;
        this.qxvquar = ghkjjruVar;
    }

    public static boolean nmpwovh(xhyvkax xhyvkaxVar) {
        if (xhyvkaxVar.lthborb <= 0) {
            return false;
        }
        return xhyvkaxVar.lthborb <= (System.currentTimeMillis() / 1000) + 180;
    }

    public static void ojyssqt(xhyvkax xhyvkaxVar, xhyvkax xhyvkaxVar2) {
        synchronized (xhyvkaxVar) {
            if (xhyvkaxVar2.vivhedu()) {
                if (xhyvkaxVar.nmpwovh.equals(xhyvkaxVar2.nmpwovh)) {
                    xhyvkaxVar.ojyssqt = xhyvkaxVar2.ojyssqt;
                    xhyvkaxVar.vivhedu = xhyvkaxVar2.vivhedu;
                    xhyvkaxVar.lthborb = xhyvkaxVar2.lthborb;
                    xhyvkaxVar.qxvquar = xhyvkaxVar2.qxvquar;
                }
            }
        }
    }

    public final boolean vivhedu() {
        return (this.ojyssqt.isEmpty() || this.qxvquar == null) ? false : true;
    }
}
