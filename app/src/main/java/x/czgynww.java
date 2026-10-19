package x;

/* JADX INFO: loaded from: classes.dex */
public final class czgynww extends Exception {
    public final String nmpwovh;
    public final int ojyssqt;

    public czgynww(String str) {
        this("BROKER_ERROR", 0, str, null);
    }

    public czgynww(String str, int i, String str2, Exception exc) {
        super(str2, exc);
        this.nmpwovh = zamkzqg.ydsyayx(str);
        this.ojyssqt = i;
    }
}
