package x;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class ezuzoct {
    public boolean buswjhz;
    public boolean dasxvpc;
    public boolean dytyqos;
    public boolean ekyqleu;
    public boolean imuemzb;
    public long nkemejx;
    public final int nmpwovh;
    public final String ojyssqt;
    public boolean oqexvyb;
    public boolean pvbzgon;
    public boolean qxvquar;
    public boolean utmeivs;
    public long wqrnifx;
    public String vivhedu = "";
    public String lthborb = "";
    public String dplrlfq = "";
    public String ulafhci = "";
    public String qyeibyo = "";

    public ezuzoct(int i, String str) {
        this.ojyssqt = str != null ? str.trim() : "";
        this.nmpwovh = i;
    }

    public final aqyicql nmpwovh(int i) throws IOException {
        String str;
        int i2 = i > 0 ? this.nmpwovh : i;
        String str2 = this.ojyssqt;
        if (!pwjmwpv.ojyssqt(str2)) {
            throw pwjmwpv.ulafhci(i2, "invalid partition_index");
        }
        if (!pwjmwpv.ojyssqt(this.vivhedu)) {
            throw pwjmwpv.ulafhci(i2, "invalid partition_name for " + str2);
        }
        if (!this.oqexvyb) {
            throw pwjmwpv.ulafhci(i2, "is_download is missing for " + this.vivhedu);
        }
        if (!this.imuemzb || !this.dytyqos || !this.dasxvpc) {
            throw pwjmwpv.ulafhci(i2, "address or size is missing for " + this.vivhedu);
        }
        String str3 = this.dplrlfq;
        if (str3 == null || str3.trim().isEmpty()) {
            throw pwjmwpv.ulafhci(i2, "region is missing for " + this.vivhedu);
        }
        String str4 = this.ulafhci;
        if (str4 == null || str4.trim().isEmpty()) {
            throw pwjmwpv.ulafhci(i2, "storage is missing for " + this.vivhedu);
        }
        boolean z = this.qxvquar && !((!"UPDATE".equalsIgnoreCase(this.qyeibyo) && !"NEEDRESIZE".equalsIgnoreCase(this.qyeibyo) && !"BOOTLOADERS".equalsIgnoreCase(this.qyeibyo)) || this.buswjhz || "seccfg".equalsIgnoreCase(this.vivhedu));
        if (z && ((str = this.lthborb) == null || str.trim().isEmpty() || "NONE".equalsIgnoreCase(str.trim()))) {
            throw pwjmwpv.ulafhci(i2, "downloadable partition has no image: " + this.vivhedu);
        }
        if (!z || this.wqrnifx != 0 || "NEEDRESIZE".equalsIgnoreCase(this.qyeibyo)) {
            return new aqyicql(this.ojyssqt, this.vivhedu, this.lthborb, this.qxvquar, this.nkemejx, this.wqrnifx, this.dplrlfq, this.ulafhci, this.utmeivs && this.ekyqleu, this.pvbzgon && this.buswjhz, this.qyeibyo);
        }
        throw pwjmwpv.ulafhci(i2, "downloadable partition has zero size: " + this.vivhedu);
    }

    public final void ojyssqt(int i, String str, String str2) throws IOException {
        if ("partition_name".equals(str)) {
            this.vivhedu = str2;
            return;
        }
        if ("file_name".equals(str)) {
            this.lthborb = str2;
            return;
        }
        if ("is_download".equals(str)) {
            this.qxvquar = pwjmwpv.nmpwovh(i, str2, str);
            this.oqexvyb = true;
            return;
        }
        if ("type".equals(str)) {
            return;
        }
        if ("linear_start_addr".equals(str)) {
            this.nkemejx = pwjmwpv.ekyqleu(i, str2, str);
            this.imuemzb = true;
            return;
        }
        if ("physical_start_addr".equals(str)) {
            pwjmwpv.ekyqleu(i, str2, str);
            this.dytyqos = true;
            return;
        }
        if ("partition_size".equals(str)) {
            long jEkyqleu = pwjmwpv.ekyqleu(i, str2, str);
            this.wqrnifx = jEkyqleu;
            if (jEkyqleu < 0) {
                throw pwjmwpv.ulafhci(i, "partition_size exceeds signed Android limits");
            }
            this.dasxvpc = true;
            return;
        }
        if ("region".equals(str)) {
            this.dplrlfq = str2;
            return;
        }
        if ("storage".equals(str)) {
            this.ulafhci = str2;
            return;
        }
        if ("boundary_check".equals(str)) {
            this.ekyqleu = pwjmwpv.nmpwovh(i, str2, str);
            this.utmeivs = true;
        } else if ("is_reserved".equals(str)) {
            this.buswjhz = pwjmwpv.nmpwovh(i, str2, str);
            this.pvbzgon = true;
        } else if ("operation_type".equals(str)) {
            this.qyeibyo = str2;
        }
    }
}
