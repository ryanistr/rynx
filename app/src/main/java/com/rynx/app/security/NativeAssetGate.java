package com.rynx.app.security;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
abstract class NativeAssetGate {
    public static final /* synthetic */ int nmpwovh = 0;

    static {
        System.loadLibrary("rynx_guard");
    }

    private static native byte[] nativeOpen(byte[] bArr, int i, byte[] bArr2);

    private static native boolean nativeSignerAccepted(byte[] bArr);

    public static byte[] nmpwovh(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null || bArr2 == null || bArr2.length != 32) {
            throw new GeneralSecurityException("Protected native component metadata is invalid");
        }
        byte[] bArrNativeOpen = nativeOpen(bArr, i, bArr2);
        if (bArrNativeOpen == null || bArrNativeOpen.length == 0) {
            throw new GeneralSecurityException("Protected native component authentication failed");
        }
        return bArrNativeOpen;
    }

    public static boolean ojyssqt(byte[] bArr) {
        return bArr != null && bArr.length == 32 && nativeSignerAccepted(bArr);
    }
}
