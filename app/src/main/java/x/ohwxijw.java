package x;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ohwxijw {
    public final String lthborb;
    public final boolean nkemejx;
    public final String nmpwovh;
    public final String ojyssqt;
    public final String oqexvyb;
    public final String qxvquar;
    public final long vivhedu;

    public ohwxijw(long j, String str, String str2, String str3) {
        String strSubstring;
        String str4;
        byte b = 0;
        this.nmpwovh = str;
        this.ojyssqt = str2;
        this.vivhedu = j;
        this.lthborb = (str3 == null || str3.isEmpty()) ? "UNKNOWN" : str3;
        String str5 = "—";
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            if (lowerCase.endsWith("_a") || lowerCase.endsWith("-a")) {
                str5 = "A";
            } else if (lowerCase.endsWith("_b") || lowerCase.endsWith("-b")) {
                str5 = "B";
            }
        }
        this.qxvquar = str5;
        if (str == null) {
            strSubstring = "";
        } else {
            String lowerCase2 = str.trim().toLowerCase(Locale.ROOT);
            strSubstring = (lowerCase2.endsWith("_a") || lowerCase2.endsWith("_b") || lowerCase2.endsWith("-a") || lowerCase2.endsWith("-b")) ? lowerCase2.substring(0, lowerCase2.length() - 2) : lowerCase2;
        }
        strSubstring.getClass();
        switch (strSubstring.hashCode()) {
            case -1146626914:
                if (!strSubstring.equals("flashinfo")) {
                    b = -1;
                }
                break;
            case -1079093847:
                b = !strSubstring.equals("md_sec") ? (byte) -1 : (byte) 1;
                break;
            case -1065387668:
                b = !strSubstring.equals("blackbox") ? (byte) -1 : (byte) 2;
                break;
            case -1033709198:
                b = !strSubstring.equals("nvdata") ? (byte) -1 : (byte) 3;
                break;
            case -989461694:
                b = !strSubstring.equals("protect1") ? (byte) -1 : (byte) 4;
                break;
            case -989461693:
                b = !strSubstring.equals("protect2") ? (byte) -1 : (byte) 5;
                break;
            case -906291597:
                b = !strSubstring.equals("seccfg") ? (byte) -1 : (byte) 6;
                break;
            case -678446636:
                b = !strSubstring.equals("persist") ? (byte) -1 : (byte) 7;
                break;
            case -309331749:
                b = !strSubstring.equals("proinfo") ? (byte) -1 : (byte) 8;
                break;
            case -139648059:
                b = !strSubstring.equals("dram_para") ? (byte) -1 : (byte) 9;
                break;
            case 3756:
                b = !strSubstring.equals("vb") ? (byte) -1 : (byte) 10;
                break;
            case 107989:
                b = !strSubstring.equals("mem") ? (byte) -1 : (byte) 11;
                break;
            case 110379:
                b = !strSubstring.equals("otp") ? (byte) -1 : (byte) 12;
                break;
            case 3417059:
                b = !strSubstring.equals("oops") ? (byte) -1 : (byte) 13;
                break;
            case 3433440:
                b = !strSubstring.equals("para") ? (byte) -1 : (byte) 14;
                break;
            case 3439163:
                b = !strSubstring.equals("pgpt") ? (byte) -1 : (byte) 15;
                break;
            case 3526144:
                b = !strSubstring.equals("sec1") ? (byte) -1 : (byte) 16;
                break;
            case 3528536:
                b = !strSubstring.equals("sgpt") ? (byte) -1 : (byte) 17;
                break;
            case 96430406:
                b = !strSubstring.equals("efuse") ? (byte) -1 : (byte) 18;
                break;
            case 98658949:
                b = !strSubstring.equals("gsort") ? (byte) -1 : (byte) 19;
                break;
            case 105201052:
                b = !strSubstring.equals("nvcfg") ? (byte) -1 : (byte) 20;
                break;
            case 105215318:
                b = !strSubstring.equals("nvram") ? (byte) -1 : (byte) 21;
                break;
            case 739062846:
                b = !strSubstring.equals("charger") ? (byte) -1 : (byte) 22;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                str4 = "red";
                break;
            default:
                str4 = !strSubstring.startsWith("preloader") ? "green" : "yellow";
                break;
        }
        this.oqexvyb = str4;
        this.nkemejx = !"green".equals(str4);
    }

    public final boolean nmpwovh() {
        return "red".equals(this.oqexvyb);
    }
}
