package x;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gzvolsx implements Runnable {
    public final /* synthetic */ int lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ kggugdp ojyssqt;
    public final /* synthetic */ String qxvquar;
    public final /* synthetic */ suqlntg vivhedu;

    public /* synthetic */ gzvolsx(kggugdp kggugdpVar, suqlntg suqlntgVar, int i, String str, int i2) {
        this.nmpwovh = i2;
        this.ojyssqt = kggugdpVar;
        this.vivhedu = suqlntgVar;
        this.lthborb = i;
        this.qxvquar = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                kggugdp kggugdpVar = this.ojyssqt;
                suqlntg suqlntgVar = this.vivhedu;
                int i = this.lthborb;
                String str = this.qxvquar;
                if (suqlntgVar == null) {
                    ProgressBar progressBar = kggugdpVar.vhimehb;
                    if (progressBar != null) {
                        progressBar.setProgress(100);
                    }
                    TextView textView = kggugdpVar.naaizwn;
                    if (textView != null) {
                        textView.setText(R.string.progress_complete_percent);
                    }
                    TextView textView2 = kggugdpVar.hjlrtqw;
                    if (textView2 != null) {
                        textView2.setText(R.string.batch_backup_complete);
                        kggugdpVar.hjlrtqw.setTextColor(kggugdpVar.qxvquar);
                    }
                    Toast.makeText(kggugdpVar, kggugdpVar.getString(R.string.batch_backup_complete_toast, Integer.valueOf(i)), 1).show();
                } else {
                    TextView textView3 = kggugdpVar.hjlrtqw;
                    if (textView3 != null) {
                        if (str == null) {
                            str = "?";
                        }
                        textView3.setText(kggugdpVar.getString(R.string.batch_failed_partition, str));
                        kggugdpVar.hjlrtqw.setTextColor(kggugdpVar.nkemejx);
                    }
                    String str2 = (String) suqlntgVar.ojyssqt;
                    if (str2 != null) {
                        ((MainActivity) kggugdpVar).nmpwovh(str2.trim());
                    }
                    zfmpmio.nmpwovh(kggugdpVar, kggugdpVar.getString(R.string.batch_backup_failed_toast), false);
                }
                kggugdpVar.ygdccqg = "";
                kggugdpVar.cxxnoho = "";
                kggugdpVar.gefzxcg();
                break;
            default:
                kggugdp kggugdpVar2 = this.ojyssqt;
                suqlntg suqlntgVar2 = this.vivhedu;
                int i2 = this.lthborb;
                String str3 = this.qxvquar;
                if (suqlntgVar2 == null) {
                    ProgressBar progressBar2 = kggugdpVar2.vhimehb;
                    if (progressBar2 != null) {
                        progressBar2.setProgress(100);
                    }
                    TextView textView4 = kggugdpVar2.naaizwn;
                    if (textView4 != null) {
                        textView4.setText(R.string.progress_complete_percent);
                    }
                    TextView textView5 = kggugdpVar2.hjlrtqw;
                    if (textView5 != null) {
                        textView5.setText(R.string.batch_flash_complete);
                        kggugdpVar2.hjlrtqw.setTextColor(kggugdpVar2.qxvquar);
                    }
                    Toast.makeText(kggugdpVar2, kggugdpVar2.getString(R.string.batch_flash_complete_toast, Integer.valueOf(i2)), 1).show();
                } else {
                    TextView textView6 = kggugdpVar2.hjlrtqw;
                    if (textView6 != null) {
                        if (str3 == null) {
                            str3 = "?";
                        }
                        textView6.setText(kggugdpVar2.getString(R.string.batch_failed_partition, str3));
                        kggugdpVar2.hjlrtqw.setTextColor(kggugdpVar2.nkemejx);
                    }
                    String str4 = (String) suqlntgVar2.ojyssqt;
                    if (str4 != null) {
                        ((MainActivity) kggugdpVar2).nmpwovh(str4.trim());
                    }
                    zfmpmio.nmpwovh(kggugdpVar2, kggugdpVar2.getString(R.string.batch_flash_failed_toast), false);
                }
                kggugdpVar2.ygdccqg = "";
                kggugdpVar2.cxxnoho = "";
                kggugdpVar2.gefzxcg();
                break;
        }
    }
}
