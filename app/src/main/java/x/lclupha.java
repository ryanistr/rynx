package x;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import com.rynx.app.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lclupha implements mwngani {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ String vivhedu;

    public /* synthetic */ lclupha(MainActivity mainActivity, String str, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
        this.vivhedu = str;
    }

    @Override // x.mwngani
    public final String nmpwovh(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        switch (this.nmpwovh) {
            case 0:
                Context applicationContext = this.ojyssqt.getApplicationContext();
                String str = this.vivhedu;
                if (str == null || str.trim().isEmpty()) {
                    throw new IllegalArgumentException("ADB exec command is empty");
                }
                ulafhci ulafhciVar = new ulafhci(applicationContext, usbDevice, usbDeviceConnection);
                try {
                    ulafhciVar.lthborb();
                    String strNkemejx = ulafhciVar.nkemejx(60, "exec:" + str.trim(), false);
                    ulafhciVar.close();
                    return strNkemejx;
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
                String str2 = this.vivhedu;
                if (str2 == null || str2.trim().isEmpty()) {
                    throw new IllegalArgumentException("ADB service is empty");
                }
                ulafhci ulafhciVar2 = new ulafhci(applicationContext2, usbDevice, usbDeviceConnection);
                try {
                    ulafhciVar2.lthborb();
                    String strTrim = str2.trim();
                    String strNkemejx2 = ulafhciVar2.nkemejx(60, strTrim, strTrim.startsWith("root:") || strTrim.startsWith("unroot:") || strTrim.startsWith("tcpip:") || strTrim.startsWith("usb:"));
                    ulafhciVar2.close();
                    return strNkemejx2;
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
