package x;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import com.rynx.app.MainActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jdqigmr implements mwngani {
    public final /* synthetic */ String lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ File vivhedu;

    public /* synthetic */ jdqigmr(MainActivity mainActivity, File file, String str, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
        this.vivhedu = file;
        this.lthborb = str;
    }

    @Override // x.mwngani
    public final String nmpwovh(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) throws IOException {
        switch (this.nmpwovh) {
            case 0:
                Context applicationContext = this.ojyssqt.getApplicationContext();
                String str = this.lthborb;
                if (str == null || str.trim().isEmpty()) {
                    throw new IllegalArgumentException("ADB exec command is empty");
                }
                File file = this.vivhedu;
                if (file == null) {
                    throw new IllegalArgumentException("ADB exec output path is empty");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IllegalStateException("Unable to create local directory: " + parentFile);
                }
                File fileQxvquar = ulafhci.qxvquar(file);
                try {
                    ulafhci ulafhciVar = new ulafhci(applicationContext, usbDevice, usbDeviceConnection);
                    try {
                        ulafhciVar.lthborb();
                        oqexvyb oqexvybVarImuemzb = ulafhciVar.imuemzb("exec:" + str.trim());
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(fileQxvquar, false);
                            long length = 0;
                            while (true) {
                                try {
                                    byte[] bArrNmpwovh = oqexvybVarImuemzb.nmpwovh();
                                    if (bArrNmpwovh == null) {
                                        fileOutputStream.flush();
                                        fileOutputStream.getFD().sync();
                                        fileOutputStream.close();
                                        oqexvybVarImuemzb.close();
                                        ulafhciVar.close();
                                        ulafhci.vivhedu(fileQxvquar, file);
                                        return file.getAbsolutePath() + "\n" + length + " bytes written";
                                    }
                                    fileOutputStream.write(bArrNmpwovh);
                                    length += (long) bArrNmpwovh.length;
                                } catch (Throwable th) {
                                    try {
                                        fileOutputStream.close();
                                        break;
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                    throw th;
                                }
                                try {
                                    oqexvybVarImuemzb.close();
                                    break;
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            oqexvybVarImuemzb.close();
                            throw th4;
                        }
                    } catch (Throwable th5) {
                        try {
                            ulafhciVar.close();
                            break;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                } catch (Throwable th7) {
                    if (fileQxvquar != null && fileQxvquar.exists() && !fileQxvquar.delete()) {
                        fileQxvquar.deleteOnExit();
                    }
                    throw th7;
                }
            case 1:
                Context applicationContext2 = this.ojyssqt.getApplicationContext();
                File file2 = this.vivhedu;
                if (file2 == null || !file2.isFile()) {
                    throw new IllegalArgumentException("Local file not found: " + file2);
                }
                String str2 = this.lthborb;
                if (str2 == null || str2.trim().isEmpty()) {
                    throw new IllegalArgumentException("Remote path is empty");
                }
                ulafhci ulafhciVar2 = new ulafhci(applicationContext2, usbDevice, usbDeviceConnection);
                try {
                    ulafhciVar2.lthborb();
                    ulafhciVar2.atntgcp(file2, str2.trim());
                    long length2 = file2.length();
                    ulafhciVar2.close();
                    return file2.getAbsolutePath() + " -> " + str2 + "\n" + length2 + " bytes pushed";
                } catch (Throwable th8) {
                    try {
                        ulafhciVar2.close();
                        break;
                    } catch (Throwable th9) {
                        th8.addSuppressed(th9);
                    }
                    throw th8;
                }
            case 2:
                Context applicationContext3 = this.ojyssqt.getApplicationContext();
                String str3 = this.lthborb;
                if (str3.trim().isEmpty()) {
                    throw new IllegalArgumentException("Remote path is empty");
                }
                File file3 = this.vivhedu;
                File parentFile2 = file3.getParentFile();
                if (parentFile2 != null && !parentFile2.exists() && !parentFile2.mkdirs() && !parentFile2.isDirectory()) {
                    throw new IllegalStateException("Unable to create local directory: " + parentFile2);
                }
                ulafhci ulafhciVar3 = new ulafhci(applicationContext3, usbDevice, usbDeviceConnection);
                try {
                    ulafhciVar3.lthborb();
                    long jZwaqeaz = ulafhciVar3.zwaqeaz(file3, str3.trim());
                    ulafhciVar3.close();
                    return str3 + " -> " + file3.getAbsolutePath() + "\n" + jZwaqeaz + " bytes pulled";
                } catch (Throwable th10) {
                    try {
                        ulafhciVar3.close();
                        break;
                    } catch (Throwable th11) {
                        th10.addSuppressed(th11);
                    }
                    throw th10;
                }
            default:
                Context applicationContext4 = this.ojyssqt.getApplicationContext();
                File file4 = this.vivhedu;
                if (file4 == null || !file4.isFile()) {
                    throw new IllegalArgumentException("APK not found: " + file4);
                }
                String str4 = "/data/local/tmp/rynx-" + System.currentTimeMillis() + "-" + file4.getName().replaceAll("[^A-Za-z0-9._-]", "_");
                ulafhci ulafhciVar4 = new ulafhci(applicationContext4, usbDevice, usbDeviceConnection);
                try {
                    ulafhciVar4.lthborb();
                    ulafhciVar4.atntgcp(file4, str4);
                    String str5 = this.lthborb;
                    String strConcat = "";
                    String strTrim = str5 == null ? "" : str5.trim();
                    StringBuilder sb = new StringBuilder("pm install ");
                    if (!strTrim.isEmpty()) {
                        strConcat = strTrim.concat(" ");
                    }
                    sb.append(strConcat);
                    sb.append(ulafhci.qyeibyo(str4));
                    try {
                        String strPvbzgon = ulafhciVar4.pvbzgon(sb.toString());
                        try {
                            ulafhciVar4.pvbzgon("rm -f " + ulafhci.qyeibyo(str4));
                            break;
                        } catch (Throwable unused) {
                        }
                        ulafhciVar4.close();
                        return strPvbzgon;
                    } catch (Throwable th12) {
                        try {
                            ulafhciVar4.pvbzgon("rm -f " + ulafhci.qyeibyo(str4));
                            break;
                        } catch (Throwable unused2) {
                        }
                        throw th12;
                    }
                } catch (Throwable th13) {
                    try {
                        ulafhciVar4.close();
                        break;
                    } catch (Throwable th14) {
                        th13.addSuppressed(th14);
                    }
                    throw th13;
                }
        }
    }

    public /* synthetic */ jdqigmr(MainActivity mainActivity, String str, File file, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
        this.lthborb = str;
        this.vivhedu = file;
    }
}
