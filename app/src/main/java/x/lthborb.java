package x;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lthborb implements Runnable {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ boolean ojyssqt;
    public final /* synthetic */ Object vivhedu;

    public /* synthetic */ lthborb(Object obj, boolean z, int i) {
        this.nmpwovh = i;
        this.vivhedu = obj;
        this.ojyssqt = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                ((qxvquar) this.vivhedu).nmpwovh(this.ojyssqt);
                break;
            case 1:
                try {
                    int i = Build.VERSION.SDK_INT;
                    View view = (View) this.vivhedu;
                    boolean z = this.ojyssqt;
                    if (i < 30) {
                        int systemUiVisibility = view.getSystemUiVisibility();
                        view.setSystemUiVisibility(z ? systemUiVisibility & (-8209) : systemUiVisibility | 8208);
                    } else {
                        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
                        if (windowInsetsController != null) {
                            windowInsetsController.setSystemBarsAppearance(z ? 0 : 24, 24);
                        }
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            default:
                Activity activity = (Activity) this.vivhedu;
                boolean z2 = this.ojyssqt;
                try {
                    activity.runOnUiThread(new pzkwhtn(activity, iivesaq.nmpwovh(), z2, 1));
                } catch (Throwable unused2) {
                    if (z2) {
                        activity.runOnUiThread(new eigllth(activity, 5));
                    }
                    return;
                }
                break;
        }
    }
}
