package x;

import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class oqexvyb implements AutoCloseable {
    public final ArrayDeque lthborb = new ArrayDeque();
    public final int nmpwovh;
    public final int ojyssqt;
    public final /* synthetic */ ulafhci oqexvyb;
    public long qxvquar;
    public boolean vivhedu;

    public oqexvyb(ulafhci ulafhciVar, int i, int i2) {
        this.oqexvyb = ulafhciVar;
        this.nmpwovh = i;
        this.ojyssqt = i2;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.vivhedu) {
            return;
        }
        try {
            this.oqexvyb.buswjhz(1163086915, this.nmpwovh, this.ojyssqt, new byte[0]);
        } catch (Throwable unused) {
        }
        this.vivhedu = true;
    }

    public final byte[] nmpwovh() {
        imuemzb imuemzbVarDplrlfq;
        ulafhci ulafhciVar = this.oqexvyb;
        ArrayDeque arrayDeque = this.lthborb;
        if (!arrayDeque.isEmpty()) {
            byte[] bArr = (byte[]) arrayDeque.removeFirst();
            this.qxvquar -= (long) bArr.length;
            return bArr;
        }
        if (this.vivhedu) {
            return null;
        }
        while (true) {
            int i = 0;
            while (true) {
                if (i >= 60) {
                    throw new IllegalStateException("ADB stream read timed out");
                }
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException("ADB stream cancelled");
                }
                try {
                    imuemzbVarDplrlfq = ulafhciVar.dplrlfq();
                } catch (dytyqos unused) {
                    i++;
                }
            }
            int i2 = this.ojyssqt;
            int i3 = this.nmpwovh;
            int i4 = imuemzbVarDplrlfq.ojyssqt;
            int i5 = imuemzbVarDplrlfq.vivhedu;
            int i6 = imuemzbVarDplrlfq.nmpwovh;
            if (i6 == 1163154007 && i5 == i3 && i4 == i2) {
                ulafhciVar.buswjhz(1497451343, i3, i2, new byte[0]);
                return imuemzbVarDplrlfq.lthborb;
            }
            if (i6 == 1163086915 && i5 == i3 && i4 == i2) {
                this.vivhedu = true;
                return null;
            }
        }
    }

    public final void ojyssqt(byte[] bArr) throws InterruptedException {
        imuemzb imuemzbVarDplrlfq;
        if (this.vivhedu) {
            throw new IllegalStateException("ADB stream is closed");
        }
        int i = 0;
        while (i < bArr.length) {
            ulafhci ulafhciVar = this.oqexvyb;
            int iMin = Math.min(ulafhciVar.dplrlfq, bArr.length - i) + i;
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, iMin);
            int i2 = this.nmpwovh;
            int i3 = this.ojyssqt;
            ulafhciVar.buswjhz(1163154007, i2, i3, bArrCopyOfRange);
            while (true) {
                int i4 = 0;
                while (true) {
                    if (i4 >= 60) {
                        throw new IllegalStateException("Timed out waiting for ADB stream acknowledgement");
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException("ADB stream cancelled");
                    }
                    try {
                        imuemzbVarDplrlfq = ulafhciVar.dplrlfq();
                    } catch (dytyqos unused) {
                        i4++;
                    }
                }
                int i5 = imuemzbVarDplrlfq.ojyssqt;
                int i6 = imuemzbVarDplrlfq.vivhedu;
                int i7 = imuemzbVarDplrlfq.nmpwovh;
                if (i7 != 1497451343 || i6 != i2 || i5 != i3) {
                    if (i7 == 1163154007 && i6 == i2 && i5 == i3) {
                        ArrayDeque arrayDeque = this.lthborb;
                        if (arrayDeque.size() < 1024) {
                            long j = this.qxvquar;
                            byte[] bArr2 = imuemzbVarDplrlfq.lthborb;
                            if (j + ((long) bArr2.length) <= 4194304) {
                                arrayDeque.addLast(bArr2);
                                this.qxvquar += (long) bArr2.length;
                                ulafhciVar.buswjhz(1497451343, i2, i3, new byte[0]);
                            }
                        }
                        ulafhciVar.buswjhz(1163086915, i2, i3, new byte[0]);
                        this.vivhedu = true;
                        throw new IllegalStateException("ADB peer exceeded the bounded inbound stream queue");
                    }
                    if (i7 == 1163086915 && i6 == i2 && i5 == i3) {
                        this.vivhedu = true;
                        throw new IllegalStateException("ADB stream closed while writing");
                    }
                }
            }
            i = iMin;
        }
    }
}
