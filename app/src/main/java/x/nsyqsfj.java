package x;

import android.content.DialogInterface;
import com.rynx.app.MainActivity;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nsyqsfj implements DialogInterface.OnClickListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;

    public /* synthetic */ nsyqsfj(Object obj, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.nmpwovh) {
            case 0:
                ((Runnable) this.ojyssqt).run();
                break;
            default:
                MainActivity mainActivity = (MainActivity) this.ojyssqt;
                if (i == 0) {
                    mainActivity.mslkofp(R.string.power_confirm_normal_title, R.string.power_confirm_normal_message, R.string.action_reboot, "reboot normal");
                } else if (i == 1) {
                    mainActivity.mslkofp(R.string.power_confirm_shutdown_title, R.string.power_confirm_shutdown_message, R.string.power_shutdown, "shutdown");
                } else {
                    mainActivity.getClass();
                }
                break;
        }
    }
}
