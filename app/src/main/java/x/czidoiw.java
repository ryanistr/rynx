package x;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import com.rynx.app.MainActivity;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class czidoiw implements Runnable {
    public final /* synthetic */ UsbDeviceConnection lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ long oqexvyb;
    public final /* synthetic */ Object qxvquar;
    public final /* synthetic */ UsbDevice vivhedu;

    public /* synthetic */ czidoiw(MainActivity mainActivity, UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, String str, long j, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
        this.vivhedu = usbDevice;
        this.lthborb = usbDeviceConnection;
        this.qxvquar = str;
        this.oqexvyb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String string;
        String string2;
        final String message;
        final boolean z;
        String string3;
        final String string4;
        final String strNmpwovh;
        final boolean z2;
        switch (this.nmpwovh) {
            case 0:
                UsbDevice usbDevice = this.vivhedu;
                UsbDeviceConnection usbDeviceConnection = this.lthborb;
                String str = (String) this.qxvquar;
                MainActivity mainActivity = this.ojyssqt;
                mainActivity.getClass();
                String strEkyqleu = null;
                try {
                    string = null;
                    strEkyqleu = ulafhci.ekyqleu(mainActivity.getApplicationContext(), usbDevice, usbDeviceConnection, str);
                } catch (Throwable th) {
                    string = th.toString();
                }
                mainActivity.runOnUiThread(new yjbrzgu(mainActivity, this.oqexvyb, string, strEkyqleu != null ? strEkyqleu.replace("\r", "").trim() : "", 3));
                break;
            case 1:
                UsbDevice usbDevice2 = this.vivhedu;
                UsbDeviceConnection usbDeviceConnection2 = this.lthborb;
                String str2 = (String) this.qxvquar;
                final long j = this.oqexvyb;
                final MainActivity mainActivity2 = this.ojyssqt;
                mainActivity2.getClass();
                try {
                    ulafhci.utmeivs(mainActivity2.getApplicationContext(), usbDevice2, usbDeviceConnection2, str2, new pvkaerr(mainActivity2, j, 2));
                    string2 = null;
                } catch (nkemejx e) {
                    message = e.getMessage();
                    z = true;
                } catch (Throwable th2) {
                    string2 = th2.toString();
                }
                message = string2;
                z = false;
                mainActivity2.runOnUiThread(new Runnable() { // from class: x.sthdtww
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity mainActivity3 = mainActivity2;
                        long j2 = j;
                        boolean z3 = z;
                        String str3 = message;
                        if (j2 != mainActivity3.gepzcpd) {
                            return;
                        }
                        mainActivity3.nxumtuo = false;
                        if (z3) {
                            mainActivity3.fusjbbl(mainActivity3.getString(R.string.android_tools_adb_allow_prompt));
                        } else if (str3 != null && !str3.contains("InterruptedException")) {
                            mainActivity3.fusjbbl("ERROR: ".concat(str3));
                            if (!com.rynx.app.ojyssqt.zwaqeaz(str3)) {
                                mainActivity3.nmpwovh("[ADB] ".concat(str3));
                            }
                        }
                        mainActivity3.gdkopre();
                        if ("android_tools".equals(mainActivity3.ayzlrnr)) {
                            mainActivity3.wfxzfba(false);
                        }
                    }
                });
                break;
            case 2:
                UsbDevice usbDevice3 = this.vivhedu;
                UsbDeviceConnection usbDeviceConnection3 = this.lthborb;
                String str3 = (String) this.qxvquar;
                long j2 = this.oqexvyb;
                MainActivity mainActivity3 = this.ojyssqt;
                mainActivity3.getClass();
                try {
                    ulafhci.utmeivs(mainActivity3.getApplicationContext(), usbDevice3, usbDeviceConnection3, str3, new pvkaerr(mainActivity3, j2, 0));
                    string3 = null;
                } catch (Throwable th3) {
                    string3 = th3.toString();
                }
                mainActivity3.runOnUiThread(new uiqyzsp(mainActivity3, j2, string3, 0));
                break;
            default:
                mwngani mwnganiVar = (mwngani) this.qxvquar;
                UsbDevice usbDevice4 = this.vivhedu;
                UsbDeviceConnection usbDeviceConnection4 = this.lthborb;
                final MainActivity mainActivity4 = this.ojyssqt;
                mainActivity4.getClass();
                try {
                    strNmpwovh = mwnganiVar.nmpwovh(usbDevice4, usbDeviceConnection4);
                    string4 = null;
                } catch (nkemejx e2) {
                    string4 = e2.getMessage();
                    z2 = true;
                    strNmpwovh = null;
                } catch (Throwable th4) {
                    string4 = th4.toString();
                    strNmpwovh = null;
                }
                z2 = false;
                final long j3 = this.oqexvyb;
                mainActivity4.runOnUiThread(new Runnable() { // from class: x.wygqgxb
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity mainActivity5 = mainActivity4;
                        long j4 = j3;
                        String str4 = strNmpwovh;
                        boolean z3 = z2;
                        String str5 = string4;
                        if (j4 != mainActivity5.gepzcpd) {
                            return;
                        }
                        mainActivity5.nxumtuo = false;
                        if (str4 != null) {
                            mainActivity5.fusjbbl(str4.trim().isEmpty() ? "OKAY" : str4.trim());
                        } else if (z3) {
                            mainActivity5.fusjbbl(mainActivity5.getString(R.string.android_tools_adb_allow_prompt));
                        } else {
                            mainActivity5.fusjbbl("ERROR: " + str5);
                        }
                        mainActivity5.gdkopre();
                        if ("android_tools".equals(mainActivity5.ayzlrnr)) {
                            mainActivity5.wfxzfba(false);
                        }
                    }
                });
                break;
        }
    }

    public /* synthetic */ czidoiw(MainActivity mainActivity, mwngani mwnganiVar, UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection, long j) {
        this.nmpwovh = 3;
        this.ojyssqt = mainActivity;
        this.qxvquar = mwnganiVar;
        this.vivhedu = usbDevice;
        this.lthborb = usbDeviceConnection;
        this.oqexvyb = j;
    }
}
