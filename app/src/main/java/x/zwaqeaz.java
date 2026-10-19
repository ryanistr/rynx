package x;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import com.rynx.app.MainActivity;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zwaqeaz implements mwngani {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ File vivhedu;

    public /* synthetic */ zwaqeaz(MainActivity mainActivity, File file, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
        this.vivhedu = file;
    }

    @Override // x.mwngani
    public final String nmpwovh(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        switch (this.nmpwovh) {
            case 0:
                Context applicationContext = this.ojyssqt.getApplicationContext();
                File file = this.vivhedu;
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IllegalStateException("Unable to create local directory: " + parentFile);
                }
                ulafhci ulafhciVar = new ulafhci(applicationContext, usbDevice, usbDeviceConnection);
                try {
                    ulafhciVar.lthborb();
                    String strTrim = null;
                    String strTrim2 = null;
                    for (String str : ulafhciVar.nkemejx(900, "shell:bugreportz -p", false).replace("\r", "").split("\n")) {
                        String strTrim3 = str.trim();
                        if (strTrim3.startsWith("OK:")) {
                            strTrim2 = strTrim3.substring(3).trim();
                        }
                        if (strTrim3.startsWith("FAIL:")) {
                            strTrim = strTrim3.substring(5).trim();
                        }
                    }
                    if (strTrim != null && !strTrim.isEmpty()) {
                        throw new IllegalStateException("Device failed to generate bugreport: " + strTrim);
                    }
                    if (strTrim2 == null || strTrim2.isEmpty()) {
                        throw new IllegalStateException("Device did not return a zipped bugreport path (bugreportz unsupported or failed)");
                    }
                    String str2 = strTrim2 + " -> " + file.getAbsolutePath() + "\n" + ulafhciVar.zwaqeaz(file, strTrim2) + " bytes pulled";
                    ulafhciVar.close();
                    return str2;
                } catch (Throwable th) {
                    try {
                        ulafhciVar.close();
                        break;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            default:
                Context applicationContext2 = this.ojyssqt.getApplicationContext();
                File file2 = this.vivhedu;
                if (!file2.isFile()) {
                    throw new IllegalArgumentException("OTA package not found: " + file2);
                }
                ulafhci ulafhciVar2 = new ulafhci(applicationContext2, usbDevice, usbDeviceConnection);
                try {
                    ulafhciVar2.lthborb();
                    long jVntpaom = ulafhciVar2.vntpaom(file2);
                    ulafhciVar2.close();
                    return jVntpaom + " bytes sideloaded";
                } catch (Throwable th3) {
                    try {
                        ulafhciVar2.close();
                        break;
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
        }
    }
}
