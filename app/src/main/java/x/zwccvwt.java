package x;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zwccvwt {
    public final String dasxvpc;
    public final String dplrlfq;
    public final String dytyqos;
    public final boolean ekyqleu;
    public final String imuemzb;
    public final String lthborb;
    public final String nkemejx;
    public final String nmpwovh;
    public final String ojyssqt;
    public final String oqexvyb;
    public final String qxvquar;
    public final String ulafhci;
    public final String vivhedu;
    public final String wqrnifx;

    public zwccvwt(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.nmpwovh = zsbaukl.nmpwovh(str);
        this.ojyssqt = zsbaukl.ojyssqt(str2);
        this.vivhedu = zsbaukl.nmpwovh(str3);
        this.lthborb = zsbaukl.ojyssqt(str4);
        this.qxvquar = zsbaukl.ojyssqt(str5);
        this.oqexvyb = zsbaukl.ojyssqt(str6);
        zsbaukl.ojyssqt("");
        this.nkemejx = zsbaukl.ojyssqt(str7);
        this.imuemzb = zsbaukl.ojyssqt(str8);
        this.dytyqos = zsbaukl.ojyssqt(str9);
        this.wqrnifx = zsbaukl.ojyssqt(str10);
        String strOjyssqt = zsbaukl.ojyssqt(str11);
        this.dasxvpc = strOjyssqt;
        String strOjyssqt2 = zsbaukl.ojyssqt(str12);
        Locale locale = Locale.ROOT;
        this.dplrlfq = strOjyssqt2.toLowerCase(locale);
        this.ulafhci = zsbaukl.ojyssqt(str13).toUpperCase(locale);
        this.ekyqleu = zsbaukl.vivhedu(strOjyssqt);
    }

    public final String nmpwovh() {
        return (this.lthborb + " " + this.ojyssqt + " " + this.vivhedu + " " + this.nmpwovh + " " + this.qxvquar + " " + this.oqexvyb + " " + this.nkemejx + " " + this.imuemzb + " " + this.dytyqos + " " + this.wqrnifx + " " + this.dasxvpc).toLowerCase(Locale.ROOT);
    }

    public final String ojyssqt() {
        return (this.nmpwovh + "\n" + this.ojyssqt + "\n" + this.vivhedu + "\n" + this.qxvquar).toLowerCase(Locale.ROOT);
    }
}
