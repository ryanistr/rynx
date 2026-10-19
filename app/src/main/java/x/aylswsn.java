package x;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aylswsn implements DialogInterface.OnCancelListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;
    public final /* synthetic */ Object vivhedu;

    public /* synthetic */ aylswsn(Object obj, Object obj2, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
        this.vivhedu = obj2;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        switch (this.nmpwovh) {
            case 0:
                boolean[] zArr = (boolean[]) this.ojyssqt;
                if (!zArr[0]) {
                    zArr[0] = true;
                    ((ghkjjru) this.vivhedu).nmpwovh();
                    break;
                }
                break;
            default:
                vlyywxv vlyywxvVar = (vlyywxv) this.ojyssqt;
                if (!vlyywxvVar.pvkaerr && !vlyywxvVar.uiqyzsp) {
                    ((suqlntg) this.vivhedu).nkemejx();
                    break;
                }
                break;
        }
    }
}
