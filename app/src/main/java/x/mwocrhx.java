package x;

import com.rynx.app.MainActivity;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mwocrhx implements Runnable {
    public final /* synthetic */ int lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ int vivhedu;

    public /* synthetic */ mwocrhx(MainActivity mainActivity, int i, int i2, int i3) {
        this.nmpwovh = i3;
        this.ojyssqt = mainActivity;
        this.vivhedu = i;
        this.lthborb = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        int i = this.vivhedu;
        int i2 = this.lthborb;
        MainActivity mainActivity = this.ojyssqt;
        switch (this.nmpwovh) {
            case 0:
                int[] iArr = MainActivity.rzsxsyc;
                mainActivity.getClass();
                mainActivity.jbyhfxz(i, "Temporary broker HTTP " + i2 + " while checking the SAME job; continuing without re-submitting the challenge.");
                break;
            case 1:
                int[] iArr2 = MainActivity.rzsxsyc;
                mainActivity.getClass();
                mainActivity.jbyhfxz(i, "Server is READY but result transfer returned HTTP " + i2 + "; retrying the SAME job without a new signing request.");
                break;
            case 2:
                int[] iArr3 = MainActivity.rzsxsyc;
                mainActivity.getClass();
                mainActivity.nmpwovh("[SLA] Server signature ready (" + i + " bytes); sending it to the device…");
                vlyywxv vlyywxvVar = mainActivity.zwccvwt;
                if (vlyywxvVar != null && vlyywxvVar.ojyssqt.isShowing()) {
                    nlcdwap nlcdwapVar = vlyywxvVar.vivhedu;
                    nlcdwapVar.lthborb = "ready";
                    nlcdwapVar.lclupha = true;
                    nlcdwapVar.oqexvyb = "Response ready";
                    if (i > 0) {
                        str = "Server response received (" + i + " bytes).";
                    } else {
                        str = "Server response received.";
                    }
                    nlcdwapVar.nkemejx = str;
                    nlcdwapVar.buswjhz = false;
                    nlcdwapVar.pvbzgon = false;
                    com.rynx.app.nmpwovh nmpwovhVar = vlyywxvVar.nmpwovh;
                    nlcdwapVar.nkemejx(nmpwovhVar.getString(R.string.xiaomi_auth_progress_hero_device_verification), nmpwovhVar.getString(R.string.xiaomi_auth_progress_status_response_ready), i > 0 ? nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_response_ready_bytes, Integer.valueOf(i)) : nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_response_ready));
                    vlyywxvVar.qxvquar();
                }
                mainActivity.jbyhfxz(i2, "Server returned a valid response (" + i + " bytes). Sending it to the device…");
                mainActivity.ankiohq();
                break;
            default:
                int[] iArr4 = MainActivity.rzsxsyc;
                mainActivity.getClass();
                mainActivity.jbyhfxz(i, "Broker response is ambiguous; recovering the SAME idempotent request (#" + i2 + ") without creating another signing job.");
                break;
        }
    }
}
