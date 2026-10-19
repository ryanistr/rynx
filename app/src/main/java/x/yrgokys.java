package x;

import android.hardware.usb.UsbDevice;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yrgokys implements Runnable {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;

    public /* synthetic */ yrgokys(MainActivity mainActivity, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                int[] iArr = MainActivity.rzsxsyc;
                this.ojyssqt.nmpwovh("[SLA] DA server request blocked: malformed Transsion XML challenge.");
                break;
            case 1:
                int[] iArr2 = MainActivity.rzsxsyc;
                this.ojyssqt.nmpwovh("[SLA] Credential wait timed out after 180 seconds.");
                break;
            case 2:
                int[] iArr3 = MainActivity.rzsxsyc;
                this.ojyssqt.nmpwovh("[SLA] ERROR: BROM returned an invalid live challenge.");
                break;
            case 3:
                int[] iArr4 = MainActivity.rzsxsyc;
                this.ojyssqt.nmpwovh("[SLA] Manual Xiaomi BROM response accepted; sending it to the phone.");
                break;
            case 4:
                int[] iArr5 = MainActivity.rzsxsyc;
                this.ojyssqt.nmpwovh("[SLA] ERROR: SLA server URL is empty in this APK build.");
                break;
            case 5:
                int[] iArr6 = MainActivity.rzsxsyc;
                MainActivity mainActivity = this.ojyssqt;
                mainActivity.getClass();
                Toast.makeText(mainActivity, R.string.sla_wrong_credentials, 0).show();
                break;
            case 6:
                int[] iArr7 = MainActivity.rzsxsyc;
                this.ojyssqt.nmpwovh("[SLA] Using the connected Xiaomi Authorize account from RAM.");
                break;
            case 7:
                int[] iArr8 = MainActivity.rzsxsyc;
                this.ojyssqt.nmpwovh("[SLA] Open Xiaomi Authorize and select the matching New Security model.");
                break;
            case 8:
                int[] iArr9 = MainActivity.rzsxsyc;
                this.ojyssqt.nmpwovh("[SLA] Using Xiaomi Authorize for Legacy BROM authorization.");
                break;
            case 9:
                int[] iArr10 = MainActivity.rzsxsyc;
                this.ojyssqt.nmpwovh("[SLA] Connect Xiaomi Authorize and select the target model first.");
                break;
            case 10:
                MainActivity mainActivity2 = this.ojyssqt;
                UsbDevice usbDevice = mainActivity2.ulafhci;
                if (usbDevice != null) {
                    mainActivity2.hhqpjvl(usbDevice);
                } else {
                    mainActivity2.cgcdpmq();
                }
                break;
            case 11:
                MainActivity mainActivity3 = this.ojyssqt;
                mainActivity3.getClass();
                try {
                    mainActivity3.nativeDisconnectSession();
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 12:
                MainActivity mainActivity4 = this.ojyssqt;
                mainActivity4.getClass();
                try {
                    mainActivity4.nativeDisconnectSession();
                } catch (Throwable unused2) {
                    return;
                }
                break;
            default:
                MainActivity mainActivity5 = this.ojyssqt;
                mainActivity5.nmpwovh(mainActivity5.getString(R.string.terminal_usb_log_disabled));
                break;
        }
    }
}
