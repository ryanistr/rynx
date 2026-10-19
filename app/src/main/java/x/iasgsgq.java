package x;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import com.rynx.app.MainActivity;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final class iasgsgq extends BroadcastReceiver {
    public final /* synthetic */ com.rynx.app.ojyssqt nmpwovh;

    public iasgsgq(com.rynx.app.ojyssqt ojyssqtVar) {
        this.nmpwovh = ojyssqtVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        UsbDevice usbDeviceUtmeivs;
        String action = intent.getAction();
        if ("com.rynx.app.USB_PERMISSION".equals(action)) {
            UsbDevice usbDeviceUtmeivs2 = this.nmpwovh.utmeivs(intent);
            boolean booleanExtra = intent.getBooleanExtra("permission", false);
            boolean zSlxntng = this.nmpwovh.slxntng(usbDeviceUtmeivs2);
            if (zSlxntng) {
                this.nmpwovh.oqexvyb();
            }
            if (!zSlxntng) {
                ((MainActivity) this.nmpwovh).nmpwovh("[USB] Ignoring stale USB permission callback from an older device instance.");
                return;
            } else if (booleanExtra && usbDeviceUtmeivs2 != null) {
                this.nmpwovh.lpkdqgx(usbDeviceUtmeivs2);
                return;
            } else {
                com.rynx.app.ojyssqt ojyssqtVar = this.nmpwovh;
                ((MainActivity) ojyssqtVar).nmpwovh(ojyssqtVar.getString(R.string.log_usb_permission_denied));
                return;
            }
        }
        boolean z = true;
        if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
            UsbDevice usbDeviceUtmeivs3 = this.nmpwovh.utmeivs(intent);
            if (this.nmpwovh.slxntng(usbDeviceUtmeivs3)) {
                this.nmpwovh.oqexvyb();
            }
            if (this.nmpwovh.ulafhci == null || usbDeviceUtmeivs3 == null || !com.rynx.app.ojyssqt.qunltjs(this.nmpwovh.ulafhci, usbDeviceUtmeivs3)) {
                return;
            }
            if (this.nmpwovh.lpkdqgx) {
                com.rynx.app.ojyssqt ojyssqtVar2 = this.nmpwovh;
                ((MainActivity) ojyssqtVar2).nmpwovh(ojyssqtVar2.getString(R.string.log_usb_detached_command));
            }
            if (!this.nmpwovh.lpkdqgx && (!this.nmpwovh.gzokllk || !this.nmpwovh.qwgjehf)) {
                z = false;
            }
            this.nmpwovh.nkemejx();
            this.nmpwovh.ulafhci = null;
            if (!z && this.nmpwovh.nsyqsfj) {
                this.nmpwovh.nativeDisconnectSession();
                this.nmpwovh.nsyqsfj = false;
                this.nmpwovh.cnctlxz = ednetju.ojyssqt();
                this.nmpwovh.xvxmcgn = "—";
                this.nmpwovh.jbmzxye.clear();
                com.rynx.app.ojyssqt ojyssqtVar3 = this.nmpwovh;
                ojyssqtVar3.ezuzoct = null;
                ((MainActivity) ojyssqtVar3).nmpwovh(ojyssqtVar3.getString(R.string.log_session_usb_detached));
            }
            this.nmpwovh.gefzxcg();
            if ("android_tools".equals(this.nmpwovh.ayzlrnr)) {
                this.nmpwovh.wfxzfba(false);
            }
            if (z && this.nmpwovh.civyupy()) {
                this.nmpwovh.cgcdpmq();
                return;
            }
            return;
        }
        if (!"android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action) || (usbDeviceUtmeivs = this.nmpwovh.utmeivs(intent)) == null || zamkzqg.nsyqsfj(usbDeviceUtmeivs) == 4) {
            return;
        }
        int iNsyqsfj = zamkzqg.nsyqsfj(usbDeviceUtmeivs);
        if ((iNsyqsfj == 2 || iNsyqsfj == 3) && (this.nmpwovh.nsyqsfj || this.nmpwovh.gzokllk || this.nmpwovh.lpkdqgx)) {
            ((MainActivity) this.nmpwovh).nmpwovh("[USB] Platform-tools device detected while DA owns USB; leaving DA session untouched.");
            return;
        }
        if (iNsyqsfj == 1 && (this.nmpwovh.nsyqsfj || this.nmpwovh.gzokllk || this.nmpwovh.lpkdqgx)) {
            synchronized (this.nmpwovh.atntgcp) {
                try {
                    if (this.nmpwovh.ekyqleu != null && this.nmpwovh.ulafhci != null && zamkzqg.pmsrvoc(this.nmpwovh.ulafhci) && !com.rynx.app.ojyssqt.qunltjs(this.nmpwovh.ulafhci, usbDeviceUtmeivs)) {
                        ((MainActivity) this.nmpwovh).nmpwovh("[USB] Additional MTK device appeared while the active MTK connection is still live; ignoring it.");
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.nmpwovh.ulafhci = usbDeviceUtmeivs;
        com.rynx.app.ojyssqt ojyssqtVar4 = this.nmpwovh;
        ((MainActivity) ojyssqtVar4).nmpwovh(ojyssqtVar4.getString(R.string.log_usb_attached, Integer.valueOf(usbDeviceUtmeivs.getVendorId()), Integer.valueOf(usbDeviceUtmeivs.getProductId())));
        this.nmpwovh.gefzxcg();
        if (this.nmpwovh.civyupy()) {
            this.nmpwovh.hhqpjvl(usbDeviceUtmeivs);
        } else if ("android_tools".equals(this.nmpwovh.ayzlrnr) && zamkzqg.rrpfqyy(usbDeviceUtmeivs)) {
            this.nmpwovh.wfxzfba(true);
            this.nmpwovh.hhqpjvl(usbDeviceUtmeivs);
        }
    }
}
