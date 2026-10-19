package x;

/* JADX INFO: loaded from: classes.dex */
public final class nnkxxji {
    public final String lthborb;
    public final String nmpwovh;
    public final String ojyssqt;
    public final int qxvquar;
    public final String vivhedu;

    public nnkxxji(String str, String str2, String str3, String str4, int i) {
        this.nmpwovh = zamkzqg.ydsyayx(str);
        this.ojyssqt = zamkzqg.ydsyayx(str2);
        this.vivhedu = zamkzqg.ydsyayx(str3);
        this.lthborb = zamkzqg.ydsyayx(str4);
        this.qxvquar = i;
    }

    public final boolean nmpwovh() {
        String str = this.nmpwovh;
        return "failed".equalsIgnoreCase(str) || "review_required".equalsIgnoreCase(str) || "expired".equalsIgnoreCase(str);
    }
}
