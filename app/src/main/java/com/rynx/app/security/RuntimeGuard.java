package com.rynx.app.security;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class RuntimeGuard {
    private RuntimeGuard() {
    }

    public static String lthborb(byte[] bArr, byte b) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i] = (char) ((bArr[i] ^ b) & 255);
        }
        return new String(cArr);
    }

    public static byte[] nmpwovh(Context context) throws GeneralSecurityException, PackageManager.NameNotFoundException {
        Signature[] apkContentsSigners;
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 28) {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 134217728);
            if (packageInfo.signingInfo == null) {
                throw new GeneralSecurityException("Application signing information is unavailable");
            }
            apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners();
        } else {
            apkContentsSigners = packageManager.getPackageInfo(context.getPackageName(), 64).signatures;
        }
        if (apkContentsSigners == null || apkContentsSigners.length == 0) {
            throw new GeneralSecurityException("Application signer is unavailable");
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return messageDigest.digest(apkContentsSigners[0].toByteArray());
    }

    public static boolean ojyssqt() {
        String lowerCase;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/self/maps")));
            do {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        return false;
                    }
                    lowerCase = line.toLowerCase(Locale.ROOT);
                    if (lowerCase.contains(lthborb(new byte[]{36, 48, 43, 38, 35}, (byte) 66))) {
                        break;
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
                return false;
            } while (!lowerCase.contains(lthborb(new byte[]{18, 0, 24, 88, 31, 6, 88, 25, 26, 26, 5}, (byte) 117)));
            bufferedReader.close();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean vivhedu() {
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/self/status")));
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        return true;
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
                return true;
            } while (!line.startsWith("TracerPid:"));
            boolean z = !"0".equals(line.substring(line.indexOf(58) + 1).trim());
            bufferedReader.close();
            return z;
        } catch (Throwable unused) {
            return true;
        }
    }
}
