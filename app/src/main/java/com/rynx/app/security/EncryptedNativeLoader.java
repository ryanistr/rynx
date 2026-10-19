package com.rynx.app.security;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class EncryptedNativeLoader {
    public static final HashSet nmpwovh = new HashSet();

    private EncryptedNativeLoader() {
    }

    public static byte[] lthborb(Context context, String str) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(str);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[16384];
                int i = 0;
                while (true) {
                    int i2 = inputStreamOpen.read(bArr);
                    if (i2 == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        inputStreamOpen.close();
                        return byteArray;
                    }
                    i += i2;
                    if (i > 67108864) {
                        throw new IOException("Protected native asset is too large");
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    public static File nkemejx(Context context, String str, String str2, byte[] bArr) throws IOException {
        File file = new File(context.getCodeCacheDir(), ".core");
        if (!file.isDirectory() && !file.mkdirs()) {
            throw new IOException("Unable to create protected native cache");
        }
        String str3 = "l_" + str + "_";
        File file2 = new File(file, str3 + (str2 + ".so"));
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file3 : fileArrListFiles) {
                if (file3.isFile() && file3.getName().startsWith(str3) && !file3.equals(file2)) {
                    file3.delete();
                }
            }
        }
        if (file2.exists() && !file2.delete()) {
            throw new IOException("Unable to refresh protected native cache");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                if (!file2.setReadable(true, true) || !file2.setWritable(false, false)) {
                    throw new IOException("Unable to make protected native cache read-only");
                }
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
                return file2;
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | RuntimeException e) {
            file2.delete();
            throw e;
        }
    }

    public static byte[] nmpwovh(Context context, byte[] bArr, String str) throws Throwable {
        Throwable th;
        byte[] bArrNmpwovh;
        int i;
        try {
            try {
                bArrNmpwovh = RuntimeGuard.nmpwovh(context);
                try {
                    int i2 = NativeAssetGate.nmpwovh;
                    if ("rynx_android".equals(str)) {
                        i = 1;
                    } else {
                        if (!"rynx_adbfastboot".equals(str)) {
                            throw new GeneralSecurityException("Unknown protected native component");
                        }
                        i = 2;
                    }
                    byte[] bArrNmpwovh2 = NativeAssetGate.nmpwovh(bArr, i, bArrNmpwovh);
                    Arrays.fill(bArrNmpwovh, (byte) 0);
                    return bArrNmpwovh2;
                } catch (Throwable th2) {
                    th = th2;
                    if (bArrNmpwovh != null) {
                        Arrays.fill(bArrNmpwovh, (byte) 0);
                    }
                    throw th;
                }
            } catch (GeneralSecurityException e) {
                throw e;
            } catch (Exception e2) {
                GeneralSecurityException generalSecurityException = new GeneralSecurityException("Unable to verify the application signer");
                generalSecurityException.initCause(e2);
                throw generalSecurityException;
            }
        } catch (Throwable th3) {
            th = th3;
            bArrNmpwovh = null;
        }
    }

    public static String ojyssqt(byte[] bArr) {
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(bArr);
        StringBuilder sb = new StringBuilder(24);
        for (int i = 0; i < 12; i++) {
            sb.append(Character.forDigit((bArrDigest[i] >>> 4) & 15, 16));
            sb.append(Character.forDigit(bArrDigest[i] & 15, 16));
        }
        Arrays.fill(bArrDigest, (byte) 0);
        return sb.toString();
    }

    public static void oqexvyb(Context context, String str, String str2, String str3) {
        if (!str.startsWith("core/") || str.contains("..")) {
            throw new IllegalArgumentException("Invalid protected asset name");
        }
        if (context == null) {
            throw new IllegalArgumentException("context == null");
        }
        if (!str2.matches("[a-z0-9_]{1,16}")) {
            throw new IllegalArgumentException("Invalid protected cache identifier");
        }
        if (str3.isEmpty()) {
            throw new IllegalArgumentException("Invalid native component name");
        }
    }

    public static void qxvquar(byte[] bArr) throws IOException {
        if (bArr.length < 20 || bArr[0] != 127 || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
            throw new IOException("Decrypted native component is not ELF");
        }
        if (bArr[4] != 2 || bArr[5] != 1) {
            throw new IOException("Decrypted native component is not 64-bit little-endian ELF");
        }
        if ((((bArr[19] & 255) << 8) | (bArr[18] & 255)) != 183) {
            throw new IOException("Decrypted native component is not AArch64 ELF");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void vivhedu(Context context, String str, String str2, String str3) {
        HashSet hashSet = nmpwovh;
        if (hashSet.contains(str3)) {
            return;
        }
        try {
            oqexvyb(context, str, str2, str3);
            byte[] bArrLthborb = lthborb(context, str);
            try {
                byte[] bArrNmpwovh = nmpwovh(context, bArrLthborb, str3);
                try {
                    qxvquar(bArrNmpwovh);
                    File fileNkemejx = nkemejx(context, str2, ojyssqt(bArrLthborb), bArrNmpwovh);
                    try {
                        System.load(fileNkemejx.getAbsolutePath());
                        hashSet.add(str3);
                        fileNkemejx.delete();
                    } catch (Throwable th) {
                        fileNkemejx.delete();
                        throw th;
                    }
                } finally {
                    Arrays.fill(bArrNmpwovh, (byte) 0);
                }
            } finally {
                if (bArrLthborb != null) {
                    Arrays.fill(bArrLthborb, (byte) 0);
                }
            }
        } catch (IOException e) {
            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Unable to initialize protected native component ".concat(str2));
            unsatisfiedLinkError.initCause(e);
            throw unsatisfiedLinkError;
        } catch (RuntimeException e2) {
            UnsatisfiedLinkError unsatisfiedLinkError2 = new UnsatisfiedLinkError("Unable to initialize protected native component ".concat(str2));
            unsatisfiedLinkError2.initCause(e2);
            throw unsatisfiedLinkError2;
        } catch (UnsatisfiedLinkError e3) {
            throw e3;
        } catch (GeneralSecurityException e4) {
            UnsatisfiedLinkError unsatisfiedLinkError3 = new UnsatisfiedLinkError("Unable to initialize protected native component ".concat(str2));
            unsatisfiedLinkError3.initCause(e4);
            throw unsatisfiedLinkError3;
        }
    }
}