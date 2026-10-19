package x;

import com.rynx.app.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pwnmyid implements Runnable {
    public final /* synthetic */ String lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ int vivhedu;

    public /* synthetic */ pwnmyid(MainActivity mainActivity, int i, String str, int i2) {
        this.nmpwovh = i2;
        this.ojyssqt = mainActivity;
        this.vivhedu = i;
        this.lthborb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        vlyywxv vlyywxvVar;
        switch (this.nmpwovh) {
            case 0:
                int[] iArr = MainActivity.rzsxsyc;
                MainActivity mainActivity = this.ojyssqt;
                mainActivity.getClass();
                mainActivity.nmpwovh("[SLA] " + this.lthborb + " challenge captured; submitting prepared job…");
                int i = this.vivhedu;
                if (i == mainActivity.zsbaukl && (vlyywxvVar = mainActivity.zwccvwt) != null && vlyywxvVar.ojyssqt.isShowing()) {
                    vlyywxvVar.pvbzgon(true);
                }
                vlyywxv vlyywxvVar2 = mainActivity.zwccvwt;
                if (vlyywxvVar2 != null && vlyywxvVar2.ojyssqt.isShowing()) {
                    vlyywxvVar2.dplrlfq();
                }
                mainActivity.jbyhfxz(i, "Live challenge captured; submitting the prepared job…");
                break;
            case 1:
                int[] iArr2 = MainActivity.rzsxsyc;
                MainActivity mainActivity2 = this.ojyssqt;
                mainActivity2.getClass();
                mainActivity2.jbyhfxz(this.vivhedu, "Temporary network error while checking the SAME server job (" + this.lthborb + "); continuing without re-submitting the challenge.");
                break;
            case 2:
                int[] iArr3 = MainActivity.rzsxsyc;
                MainActivity mainActivity3 = this.ojyssqt;
                mainActivity3.getClass();
                StringBuilder sb = new StringBuilder("[SLA] Server phase: ");
                String str = this.lthborb;
                sb.append(str);
                mainActivity3.nmpwovh(sb.toString());
                vlyywxv vlyywxvVar3 = mainActivity3.zwccvwt;
                if (vlyywxvVar3 != null && vlyywxvVar3.ojyssqt.isShowing()) {
                    vlyywxvVar3.buswjhz(str);
                }
                mainActivity3.jbyhfxz(this.vivhedu, "Server: " + str);
                break;
            default:
                int[] iArr4 = MainActivity.rzsxsyc;
                MainActivity mainActivity4 = this.ojyssqt;
                mainActivity4.getClass();
                mainActivity4.jbyhfxz(this.vivhedu, "Server is READY but result transfer hit " + this.lthborb + "; retrying the SAME job without a new signing request.");
                break;
        }
    }

    public /* synthetic */ pwnmyid(MainActivity mainActivity, String str, int i, int i2) {
        this.nmpwovh = i2;
        this.ojyssqt = mainActivity;
        this.lthborb = str;
        this.vivhedu = i;
    }
}
