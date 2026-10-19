package x;

import android.widget.ScrollView;
import com.rynx.app.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zngzleo implements Runnable {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ kggugdp ojyssqt;

    public /* synthetic */ zngzleo(kggugdp kggugdpVar, int i) {
        this.nmpwovh = i;
        this.ojyssqt = kggugdpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                this.ojyssqt.ekyqleu();
                break;
            case 1:
                this.ojyssqt.ltnesel();
                break;
            default:
                ysaclsr ysaclsrVar = ((MainActivity) this.ojyssqt).snilumr;
                ysaclsrVar.lthborb = true;
                ScrollView scrollView = ysaclsrVar.ojyssqt;
                if (scrollView != null) {
                    scrollView.post(new eigllth(ysaclsrVar, 3));
                    break;
                }
                break;
        }
    }
}
