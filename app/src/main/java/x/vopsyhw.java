package x;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.rynx.app.MainActivity;
import com.rynx.app.adbfastboot.AdbFastbootNative;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class vopsyhw implements Runnable {
    public final /* synthetic */ Object lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ long qxvquar;
    public final /* synthetic */ Parcelable vivhedu;

    public /* synthetic */ vopsyhw(MainActivity mainActivity, Parcelable parcelable, Object obj, long j, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
        this.vivhedu = parcelable;
        this.lthborb = obj;
        this.qxvquar = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String string;
        String string2;
        String strEkyqleu;
        String strOjyssqt;
        switch (this.nmpwovh) {
            case 0:
                UsbDevice usbDevice = (UsbDevice) this.vivhedu;
                UsbDeviceConnection usbDeviceConnection = (UsbDeviceConnection) this.lthborb;
                MainActivity mainActivity = this.ojyssqt;
                mainActivity.getClass();
                String strEkyqleu2 = null;
                try {
                    string = null;
                    strEkyqleu2 = ulafhci.ekyqleu(mainActivity.getApplicationContext(), usbDevice, usbDeviceConnection, "su -c id -u");
                } catch (Throwable th) {
                    string = th.toString();
                }
                mainActivity.runOnUiThread(new yjbrzgu(mainActivity, this.qxvquar, string, strEkyqleu2 != null ? strEkyqleu2.replace("\r", "").trim() : "", 1));
                return;
            case 1:
                UsbDevice usbDevice2 = (UsbDevice) this.vivhedu;
                UsbDeviceConnection usbDeviceConnection2 = (UsbDeviceConnection) this.lthborb;
                MainActivity mainActivity2 = this.ojyssqt;
                mainActivity2.getClass();
                try {
                    strEkyqleu = ulafhci.ekyqleu(mainActivity2.getApplicationContext(), usbDevice2, usbDeviceConnection2, "getprop ro.product.device; pwd; id -u");
                    string2 = null;
                } catch (Throwable th2) {
                    string2 = th2.toString();
                    strEkyqleu = null;
                }
                mainActivity2.runOnUiThread(new yjbrzgu(mainActivity2, this.qxvquar, string2, strEkyqleu, 2));
                return;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) this.vivhedu;
                String str = (String) this.lthborb;
                MainActivity mainActivity3 = this.ojyssqt;
                mainActivity3.getClass();
                try {
                    try {
                        strOjyssqt = AdbFastbootNative.ojyssqt(parcelFileDescriptor.getFd(), str);
                        parcelFileDescriptor.close();
                    } catch (Throwable th3) {
                        try {
                            parcelFileDescriptor.close();
                            break;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    strOjyssqt = "ERROR\n" + th5;
                }
                mainActivity3.runOnUiThread(new uiqyzsp(mainActivity3, this.qxvquar, strOjyssqt == null ? "ERROR\nNative Fastboot returned null" : strOjyssqt, 2));
                return;
        }
    }
}
