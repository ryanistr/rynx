package x;

import com.rynx.app.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wdznaie implements Runnable {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ int vivhedu;

    public /* synthetic */ wdznaie(MainActivity mainActivity, int i, int i2) {
        this.nmpwovh = i2;
        this.ojyssqt = mainActivity;
        this.vivhedu = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                int[] iArr = MainActivity.rzsxsyc;
                MainActivity mainActivity = this.ojyssqt;
                mainActivity.nmpwovh(mainActivity.getString(this.vivhedu));
                break;
            case 1:
                int[] iArr2 = MainActivity.rzsxsyc;
                this.ojyssqt.pmsrvoc(this.vivhedu, "Server result timed out; the job will not be submitted again automatically.", false);
                break;
            default:
                MainActivity mainActivity2 = this.ojyssqt;
                int i = this.vivhedu;
                if (mainActivity2.qwgjehf && i == mainActivity2.bgmsltp && !mainActivity2.nsyqsfj && !mainActivity2.gzokllk) {
                    mainActivity2.cgcdpmq();
                    break;
                }
                break;
        }
    }
}
