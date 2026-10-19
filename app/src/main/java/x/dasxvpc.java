package x;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class dasxvpc {
    public int nmpwovh;
    public final Object ojyssqt;
    public Serializable vivhedu;

    public dasxvpc(int i, String str, String str2) {
        this.ojyssqt = str.trim();
        this.vivhedu = zamkzqg.ydsyayx(str2);
        this.nmpwovh = i;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [byte[], java.io.Serializable] */
    public byte[] nmpwovh(int i) {
        if (i < 0 || i > 1048576) {
            throw new IllegalStateException("Invalid ADB stream length: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            if (this.nmpwovh >= ((byte[]) this.vivhedu).length) {
                byte[] Nmpwovh = ((oqexvyb) this.ojyssqt).nmpwovh();
                this.vivhedu = Nmpwovh;
                this.nmpwovh = 0;
                if (Nmpwovh == null) {
                    throw new IllegalStateException("ADB stream closed unexpectedly");
                }
            }
            int iMin = Math.min(i - i2, ((byte[]) this.vivhedu).length - this.nmpwovh);
            System.arraycopy((byte[]) this.vivhedu, this.nmpwovh, bArr, i2, iMin);
            this.nmpwovh += iMin;
            i2 += iMin;
        }
        return bArr;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [byte[], java.io.Serializable] */
    public dasxvpc(oqexvyb oqexvybVar) {
        this.vivhedu = new byte[0];
        this.ojyssqt = oqexvybVar;
    }
}
