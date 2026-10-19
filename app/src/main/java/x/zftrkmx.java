package x;

import android.os.Handler;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zftrkmx implements Runnable {
    public final /* synthetic */ zwccvwt dytyqos;
    public final /* synthetic */ int imuemzb;
    public final /* synthetic */ String lthborb;
    public final /* synthetic */ int nkemejx;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ com.rynx.app.nmpwovh ojyssqt;
    public final /* synthetic */ String oqexvyb;
    public final /* synthetic */ String qxvquar;
    public final /* synthetic */ xhyvkax vivhedu;
    public final /* synthetic */ boolean wqrnifx;

    public /* synthetic */ zftrkmx(com.rynx.app.nmpwovh nmpwovhVar, int i, xhyvkax xhyvkaxVar, zwccvwt zwccvwtVar, String str, String str2, String str3, int i2, boolean z) {
        this.nmpwovh = 0;
        this.ojyssqt = nmpwovhVar;
        this.nkemejx = i;
        this.vivhedu = xhyvkaxVar;
        this.dytyqos = zwccvwtVar;
        this.lthborb = str;
        this.qxvquar = str2;
        this.oqexvyb = str3;
        this.imuemzb = i2;
        this.wqrnifx = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String message;
        hiofinr hiofinrVarYxcmoypTmp;
        switch (this.nmpwovh) {
            case 0:
                com.rynx.app.nmpwovh nmpwovhVar = this.ojyssqt;
                int i = this.nkemejx;
                xhyvkax xhyvkaxVar = this.vivhedu;
                zwccvwt zwccvwtVar = this.dytyqos;
                String str = this.lthborb;
                String str2 = this.qxvquar;
                String str3 = this.oqexvyb;
                int i2 = this.imuemzb;
                boolean z = this.wqrnifx;
                if (i == nmpwovhVar.zyxfuka && xhyvkaxVar == nmpwovhVar.iqvvlnh && zwccvwtVar == nmpwovhVar.laodqsm && !nmpwovhVar.yztlqms) {
                    nmpwovhVar.yztlqms = true;
                    nmpwovhVar.snbdnwo.oqexvyb(R.string.xiaomi_authorize_reserving, true);
                    nmpwovhVar.jbyhfxz(i, "AUTHORIZE confirmed. Keeping this progress window open until the device returns a final result.");
                    nmpwovhVar.jbyhfxz(i, "Reserving credit hold and signing slot…");
                    nmpwovhVar.iivesaq = nmpwovhVar.zfmpmio.submit(new zftrkmx(nmpwovhVar, xhyvkaxVar, str, str2, str3, i2, i, zwccvwtVar, z));
                    break;
                }
                break;
            default:
                final xhyvkax xhyvkaxVar2 = this.vivhedu;
                final String str4 = this.lthborb;
                final String str5 = this.qxvquar;
                final String str6 = this.oqexvyb;
                final int i3 = this.nkemejx;
                final com.rynx.app.nmpwovh nmpwovhVar2 = this.ojyssqt;
                nmpwovhVar2.getClass();
                try {
                    hiofinrVarYxcmoypTmp = zamkzqg.yxcmoyp(com.rynx.app.ojyssqt.jxvdcpb(), xhyvkaxVar2, str4, str5, str6, i3);
                    message = null;
                } catch (Throwable th) {
                    message = th.getMessage();
                    if (message == null || message.trim().isEmpty()) {
                        message = nmpwovhVar2.getString(R.string.xiaomi_authorize_unknown_error);
                    }
                    hiofinrVarYxcmoypTmp = null;
                }
                final hiofinr hiofinrVarYxcmoyp = hiofinrVarYxcmoypTmp;
                final zwccvwt zwccvwtVar2 = this.dytyqos;
                final boolean z2 = this.wqrnifx;
                final int i4 = this.imuemzb;
                final String str7 = message;
                nmpwovhVar2.runOnUiThread(new Runnable() { // from class: x.wfxzfba
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.rynx.app.nmpwovh nmpwovhVar3 = nmpwovhVar2;
                        int i5 = i4;
                        xhyvkax xhyvkaxVar3 = xhyvkaxVar2;
                        zwccvwt zwccvwtVar3 = zwccvwtVar2;
                        hiofinr hiofinrVar = hiofinrVarYxcmoyp;
                        String str8 = str7;
                        String str9 = str6;
                        String str10 = str5;
                        int i6 = i3;
                        String str11 = str4;
                        boolean z3 = z2;
                        if (i5 != nmpwovhVar3.zyxfuka || xhyvkaxVar3 != nmpwovhVar3.iqvvlnh || zwccvwtVar3 != nmpwovhVar3.laodqsm || nmpwovhVar3.isFinishing() || nmpwovhVar3.isDestroyed()) {
                            if (hiofinrVar != null) {
                                nmpwovhVar3.rceuwfv(hiofinrVar.nmpwovh, xhyvkaxVar3);
                                return;
                            }
                            return;
                        }
                        nmpwovhVar3.yztlqms = false;
                        nmpwovhVar3.iivesaq = null;
                        if (hiofinrVar == null) {
                            nmpwovhVar3.snbdnwo.wqrnifx(str8, true);
                            ((MainActivity) nmpwovhVar3).nmpwovh("[SLA] Prepare failed: " + str8);
                            nmpwovhVar3.pmsrvoc(i5, "Prepare failed: " + str8, true);
                            return;
                        }
                        if (!str9.equalsIgnoreCase(hiofinrVar.ojyssqt) || !str10.equalsIgnoreCase(hiofinrVar.vivhedu) || hiofinrVar.lthborb != i6) {
                            nmpwovhVar3.rceuwfv(hiofinrVar.nmpwovh, xhyvkaxVar3);
                            nmpwovhVar3.snbdnwo.wqrnifx(nmpwovhVar3.getString(R.string.xiaomi_authorize_reservation_mismatch), true);
                            nmpwovhVar3.pmsrvoc(i5, nmpwovhVar3.getString(R.string.xiaomi_authorize_reservation_mismatch), true);
                            return;
                        }
                        nmpwovhVar3.qdiugcp = hiofinrVar;
                        nmpwovhVar3.gdkopre = str11;
                        nmpwovhVar3.vlyywxv = str10;
                        nmpwovhVar3.nlcdwap = str9;
                        nmpwovhVar3.wrbqriz = UUID.randomUUID().toString();
                        nmpwovhVar3.dreanqi = "";
                        nmpwovhVar3.ebrwptg = "";
                        vlyywxv vlyywxvVar = nmpwovhVar3.zwccvwt;
                        if (vlyywxvVar != null && vlyywxvVar.ojyssqt.isShowing()) {
                            vlyywxvVar.ulafhci(hiofinrVar.qxvquar, hiofinrVar.oqexvyb, hiofinrVar.nkemejx, hiofinrVar.lthborb);
                            vlyywxvVar.gzokllk = Math.max(0L, hiofinrVar.imuemzb);
                            Handler handler = vlyywxvVar.wygqgxb;
                            gdkopre gdkopreVar = vlyywxvVar.yjbrzgu;
                            handler.removeCallbacks(gdkopreVar);
                            vlyywxvVar.imuemzb();
                            if (vlyywxvVar.gzokllk > 0 && !vlyywxvVar.pvkaerr) {
                                handler.postDelayed(gdkopreVar, 1000L);
                            }
                            nlcdwap nlcdwapVar = vlyywxvVar.vivhedu;
                            nlcdwapVar.qyeibyo = true;
                            nlcdwapVar.vntpaom = true;
                            nlcdwapVar.oqexvyb = "Credit reserved";
                            nlcdwapVar.nkemejx = "Credit and signing slot are reserved. Waiting for the device challenge.";
                            com.rynx.app.nmpwovh nmpwovhVar4 = vlyywxvVar.nmpwovh;
                            nlcdwapVar.nkemejx(nmpwovhVar4.getString(R.string.xiaomi_auth_progress_hero_waiting_device), nmpwovhVar4.getString(R.string.xiaomi_auth_progress_status_credit_reserved), nmpwovhVar4.getString(R.string.xiaomi_auth_progress_detail_credit_reserved));
                            vlyywxvVar.qxvquar();
                            vlyywxvVar.pvbzgon(false);
                        }
                        nmpwovhVar3.snbdnwo.oqexvyb(R.string.xiaomi_authorize_waiting_device, false);
                        MainActivity mainActivity = (MainActivity) nmpwovhVar3;
                        mainActivity.nmpwovh("[SLA] Credit held and signing slot reserved; connect/reconnect the phone now.");
                        nmpwovhVar3.jbyhfxz(i5, "Credit held; signing slot reserved. Waiting for USB/BROM challenge…");
                        mainActivity.nmpwovh(nmpwovhVar3.getString(R.string.xiaomi_authorization_started, zwccvwtVar3.ojyssqt, z3 ? "New Security" : "Legacy"));
                        nmpwovhVar3.nhhacgu("home");
                        nmpwovhVar3.nativeSetXiaomiAuthGeneration(i5);
                        nmpwovhVar3.nsizane();
                    }
                });
                break;
        }
    }

    public /* synthetic */ zftrkmx(com.rynx.app.nmpwovh nmpwovhVar, xhyvkax xhyvkaxVar, String str, String str2, String str3, int i, int i2, zwccvwt zwccvwtVar, boolean z) {
        this.nmpwovh = 1;
        this.ojyssqt = nmpwovhVar;
        this.vivhedu = xhyvkaxVar;
        this.lthborb = str;
        this.qxvquar = str2;
        this.oqexvyb = str3;
        this.nkemejx = i;
        this.imuemzb = i2;
        this.dytyqos = zwccvwtVar;
        this.wqrnifx = z;
    }
}
