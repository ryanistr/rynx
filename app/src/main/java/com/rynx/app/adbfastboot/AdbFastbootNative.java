package com.rynx.app.adbfastboot;

import com.rynx.app.MainActivity;
import x.pvkaerr;
import x.uiqyzsp;

/* JADX INFO: loaded from: classes.dex */
public abstract class AdbFastbootNative {
    public static final Object nmpwovh = new Object();
    public static volatile pvkaerr ojyssqt;

    public static int dasxvpc(int i, int i2, byte[] bArr, int i3, int i4) {
        return nativeUsbfsWrite(i, i2, bArr, i3, i4, 1000);
    }

    public static int dytyqos(int i, int i2, int i3, byte[] bArr) {
        return nativeUsbfsRead(i, i2, bArr, 0, i3, 1000);
    }

    public static int imuemzb(int i, int i2, int i3) {
        return nativeUsbfsClaim(i, i2, i3);
    }

    public static String lthborb(int i, String str, String str2, String str3, pvkaerr pvkaerrVar) {
        String strNativeFastbootFileCommand;
        synchronized (nmpwovh) {
            try {
                ojyssqt = pvkaerrVar;
                try {
                    strNativeFastbootFileCommand = nativeFastbootFileCommand(i, str, str2, str3);
                    ojyssqt = null;
                } catch (Throwable th) {
                    ojyssqt = null;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strNativeFastbootFileCommand;
    }

    private static native void nativeFastbootCancel();

    private static native String nativeFastbootCommand(int i, String str);

    private static native String nativeFastbootFetch(int i, String str, String str2);

    private static native String nativeFastbootFileCommand(int i, String str, String str2, String str3);

    private static native boolean nativeFastbootPrepare();

    private static native String nativeFastbootReceiveCommand(int i, String str, String str2);

    private static native String nativeFastbootSnapshot(int i);

    private static native int nativeUsbfsClaim(int i, int i2, int i3);

    private static native int nativeUsbfsRead(int i, int i2, byte[] bArr, int i3, int i4, int i5);

    private static native void nativeUsbfsRelease(int i, int i2);

    private static native int nativeUsbfsWrite(int i, int i2, byte[] bArr, int i3, int i4, int i5);

    public static String nkemejx(int i) {
        return nativeFastbootSnapshot(i);
    }

    public static void nmpwovh() {
        nativeFastbootCancel();
    }

    public static String ojyssqt(int i, String str) {
        return nativeFastbootCommand(i, str);
    }

    public static void onNativeFastbootEvent(String str) {
        pvkaerr pvkaerrVar = ojyssqt;
        if (pvkaerrVar == null || str == null || str.isEmpty()) {
            return;
        }
        try {
            MainActivity mainActivity = pvkaerrVar.ojyssqt;
            mainActivity.getClass();
            mainActivity.runOnUiThread(new uiqyzsp(mainActivity, pvkaerrVar.vivhedu, str, 1));
        } catch (Throwable unused) {
        }
    }

    public static String oqexvyb(int i, String str, String str2) {
        return nativeFastbootReceiveCommand(i, str, str2);
    }

    public static boolean qxvquar() {
        return nativeFastbootPrepare();
    }

    public static String vivhedu(int i, String str, String str2) {
        return nativeFastbootFetch(i, str, str2);
    }

    public static void wqrnifx(int i, int i2) {
        nativeUsbfsRelease(i, i2);
    }
}
