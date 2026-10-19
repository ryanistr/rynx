package x;

import android.animation.ValueAnimator;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nauykcf implements DialogInterface.OnDismissListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;

    public /* synthetic */ nauykcf(Object obj, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.nmpwovh) {
            case 0:
                ecffprn ecffprnVar = (ecffprn) this.ojyssqt;
                ecffprnVar.nkemejx.incrementAndGet();
                ecffprnVar.oqexvyb.shutdownNow();
                break;
            default:
                vlyywxv vlyywxvVar = (vlyywxv) this.ojyssqt;
                vlyywxvVar.wygqgxb.removeCallbacks(vlyywxvVar.yjbrzgu);
                ValueAnimator valueAnimator = vlyywxvVar.bgmsltp;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    vlyywxvVar.bgmsltp.removeAllUpdateListeners();
                    vlyywxvVar.bgmsltp = null;
                }
                break;
        }
    }
}
