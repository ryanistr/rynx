package x;

/* JADX INFO: loaded from: classes.dex */
public final class ednetju {
    public final String dasxvpc;
    public final Boolean dplrlfq;
    public final String dytyqos;
    public final Boolean ekyqleu;
    public final String imuemzb;
    public final String lthborb;
    public final String nkemejx;
    public final String nmpwovh;
    public final String ojyssqt;
    public final String oqexvyb;
    public final String qxvquar;
    public final Boolean ulafhci;
    public final int utmeivs;
    public final String vivhedu;
    public final String wqrnifx;

    public ednetju(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Boolean bool, Boolean bool2, Boolean bool3, int i) {
        this.nmpwovh = nmpwovh(str);
        this.ojyssqt = nmpwovh(str2);
        this.vivhedu = nmpwovh(str3);
        this.lthborb = nmpwovh(str4);
        this.qxvquar = nmpwovh(str5);
        this.oqexvyb = nmpwovh(str6);
        this.nkemejx = nmpwovh(str7);
        this.imuemzb = nmpwovh(str8);
        this.dytyqos = nmpwovh(str9);
        this.wqrnifx = nmpwovh(str10);
        this.dasxvpc = nmpwovh(str11);
        this.dplrlfq = bool;
        this.ulafhci = bool2;
        this.ekyqleu = bool3;
        this.utmeivs = i;
    }

    public static String nmpwovh(String str) {
        if (str == null) {
            return "";
        }
        String strTrim = str.trim();
        return ("UNKNOWN".equalsIgnoreCase(strTrim) || "N/A".equalsIgnoreCase(strTrim) || "NONE".equalsIgnoreCase(strTrim)) ? "" : strTrim;
    }

    public static ednetju ojyssqt() {
        return new ednetju("", "", "", "", "", "", "", "", "", "", "", null, null, null, -1);
    }
}
