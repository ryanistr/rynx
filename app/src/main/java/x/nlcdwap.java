package x;

/* JADX INFO: loaded from: classes.dex */
public final class nlcdwap {
    public boolean buswjhz;
    public int dasxvpc;
    public boolean dplrlfq;
    public int dytyqos;
    public String ekyqleu;
    public boolean gisppfs;
    public int imuemzb;
    public boolean jdqigmr;
    public boolean lclupha;
    public String lthborb;
    public String nkemejx;
    public String nmpwovh;
    public String ojyssqt;
    public String oqexvyb;
    public boolean pvbzgon;
    public String qxvquar;
    public boolean qyeibyo;
    public String ulafhci;
    public String utmeivs;
    public String vivhedu;
    public boolean vntpaom;
    public int wqrnifx;

    public static void nmpwovh(StringBuilder sb, String str) {
        if (sb.length() != 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public static String oqexvyb(String str) {
        return str == null ? "" : str.trim();
    }

    public static String qxvquar(String str, String str2) {
        String strReplace = oqexvyb(str).replace("\r\n", "\n").replace('\r', '\n');
        if (strReplace.isEmpty()) {
            return str2;
        }
        int iIndexOf = strReplace.indexOf("\n[SLA][UPSTREAM]");
        if (iIndexOf >= 0) {
            strReplace = strReplace.substring(0, iIndexOf);
        }
        String strTrim = strReplace.trim();
        return strTrim.isEmpty() ? str2 : strTrim;
    }

    public static String vivhedu(String str, boolean z) {
        return (z ? "● " : "○ ").concat(str);
    }

    public final int dytyqos(int i) {
        if (i == 0) {
            if (this.vntpaom) {
                return 2;
            }
            return (!this.buswjhz || this.pvbzgon) ? 1 : 4;
        }
        if (i == 1) {
            if (this.jdqigmr) {
                return 2;
            }
            return this.vntpaom ? 1 : 0;
        }
        if (i != 2) {
            if (i != 3) {
                return 0;
            }
            if ("device_accepted".equals(this.lthborb) || "bypass".equals(this.lthborb)) {
                return 2;
            }
            if ("device_rejected".equals(this.lthborb)) {
                return 4;
            }
            return (this.gisppfs || this.lclupha || "ready".equals(this.lthborb)) ? 1 : 0;
        }
        if ("review_required".equals(this.lthborb)) {
            return 3;
        }
        if (("failed".equals(this.lthborb) || "expired".equals(this.lthborb)) && this.jdqigmr) {
            return 4;
        }
        if (this.lclupha || this.gisppfs || "device_accepted".equals(this.lthborb) || "device_rejected".equals(this.lthborb)) {
            return 2;
        }
        return (this.jdqigmr || "queued".equals(this.lthborb) || "running".equals(this.lthborb) || "upstream_dispatched".equals(this.lthborb)) ? 1 : 0;
    }

    public final String imuemzb() {
        return this.vivhedu.length() <= 8 ? this.vivhedu : this.vivhedu.substring(0, 8);
    }

    public final String lthborb() {
        if (!this.dplrlfq) {
            return "Balance —  •  Held —  •  Available —  •  Cost —";
        }
        return "Balance " + this.imuemzb + "  •  Held " + this.dytyqos + "  •  Available " + this.wqrnifx + "  •  Cost " + this.dasxvpc;
    }

    public final void nkemejx(String str, String str2, String str3) {
        this.qxvquar = oqexvyb(str);
        this.oqexvyb = oqexvyb(str2);
        this.nkemejx = oqexvyb(str3);
    }

    public final void ojyssqt(String str) {
        String strReplace = str == null ? "" : str.replace("\r\n", "\n").replace('\r', '\n');
        int iIndexOf = strReplace.indexOf("[SLA][UPSTREAM] HTTP ");
        if (iIndexOf >= 0) {
            int i = iIndexOf + 21;
            int iIndexOf2 = strReplace.indexOf(10, i);
            if (iIndexOf2 < 0) {
                iIndexOf2 = strReplace.length();
            }
            this.ulafhci = strReplace.substring(i, iIndexOf2).trim();
        }
        int iIndexOf3 = strReplace.indexOf("[SLA][UPSTREAM] Raw: ");
        if (iIndexOf3 >= 0) {
            this.ekyqleu = strReplace.substring(iIndexOf3 + 21).trim();
        }
    }

    public final String wqrnifx() {
        StringBuilder sb = new StringBuilder();
        nmpwovh(sb, vivhedu("Account verified", this.qyeibyo));
        nmpwovh(sb, vivhedu("Credit reserved", this.vntpaom));
        nmpwovh(sb, vivhedu("Device challenge received", this.jdqigmr));
        if ("review_required".equals(this.lthborb)) {
            nmpwovh(sb, "! Manual review required");
        } else if (this.lclupha) {
            nmpwovh(sb, "● Server response ready");
        } else if ("upstream_dispatched".equals(this.lthborb)) {
            nmpwovh(sb, "◉ Contacting authorization server");
        } else if ("queued".equals(this.lthborb)) {
            nmpwovh(sb, "◉ Waiting for signer");
        } else if ("running".equals(this.lthborb)) {
            nmpwovh(sb, "◉ Authorization in progress");
        } else {
            nmpwovh(sb, "○ Server authorization");
        }
        if (this.pvbzgon && "device_accepted".equals(this.lthborb)) {
            nmpwovh(sb, "● Device accepted");
        } else if ("device_rejected".equals(this.lthborb)) {
            nmpwovh(sb, "✕ Device rejected");
        } else if (this.gisppfs || this.lclupha) {
            nmpwovh(sb, "◉ Waiting for device outcome");
        } else {
            nmpwovh(sb, "○ Device outcome");
        }
        return sb.toString();
    }
}
