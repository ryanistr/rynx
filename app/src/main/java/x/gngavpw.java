package x;

import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gngavpw implements Runnable {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ kggugdp ojyssqt;
    public final /* synthetic */ String vivhedu;

    public /* synthetic */ gngavpw(int i, String str, kggugdp kggugdpVar) {
        this.nmpwovh = i;
        this.ojyssqt = kggugdpVar;
        this.vivhedu = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                kggugdp kggugdpVar = this.ojyssqt;
                String str = this.vivhedu;
                TextView textView = kggugdpVar.hjlrtqw;
                if (textView != null) {
                    textView.setText(R.string.scatter_firmware_upgrade_failed);
                    kggugdpVar.hjlrtqw.setTextColor(kggugdpVar.nkemejx);
                }
                kggugdpVar.ygdccqg = "";
                kggugdpVar.cxxnoho = "";
                kggugdpVar.gefzxcg();
                Toast.makeText(kggugdpVar, str, 1).show();
                break;
            default:
                kggugdp kggugdpVar2 = this.ojyssqt;
                String str2 = this.vivhedu;
                TextView textView2 = kggugdpVar2.hjlrtqw;
                if (textView2 != null) {
                    textView2.setText(R.string.batch_flash_failed_toast);
                    kggugdpVar2.hjlrtqw.setTextColor(kggugdpVar2.nkemejx);
                }
                kggugdpVar2.ygdccqg = "";
                kggugdpVar2.cxxnoho = "";
                kggugdpVar2.gefzxcg();
                Toast.makeText(kggugdpVar2, str2, 1).show();
                break;
        }
    }
}
