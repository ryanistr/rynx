package x;

/* JADX INFO: loaded from: classes.dex */
public final class aqyicql {
    public final String dasxvpc;
    public final boolean dytyqos;
    public final String imuemzb;
    public final boolean lthborb;
    public final String nkemejx;
    public final String nmpwovh;
    public final String ojyssqt;
    public final long oqexvyb;
    public final long qxvquar;
    public final String vivhedu;
    public final boolean wqrnifx;

    public aqyicql(String str, String str2, String str3, boolean z, long j, long j2, String str4, String str5, boolean z2, boolean z3, String str6) {
        this.nmpwovh = ojyssqt(str);
        this.ojyssqt = ojyssqt(str2);
        this.vivhedu = ojyssqt(str3);
        this.lthborb = z;
        this.qxvquar = j;
        this.oqexvyb = j2;
        this.nkemejx = ojyssqt(str4);
        this.imuemzb = ojyssqt(str5);
        this.dytyqos = z2;
        this.wqrnifx = z3;
        this.dasxvpc = ojyssqt(str6);
    }

    public static String ojyssqt(String str) {
        return str == null ? "" : str.trim();
    }

    public final String nmpwovh() {
        return String.format("0x%016X", Long.valueOf(this.qxvquar));
    }

    public final boolean vivhedu() {
        String str = this.vivhedu;
        return (str.isEmpty() || "NONE".equalsIgnoreCase(str)) ? false : true;
    }
}
