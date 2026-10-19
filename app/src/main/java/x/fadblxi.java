package x;

import android.widget.CompoundButton;
import android.widget.Toast;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class fadblxi implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;

    public /* synthetic */ fadblxi(Object obj, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (this.nmpwovh) {
            case 0:
                com.rynx.app.nmpwovh nmpwovhVar = ((gepzcpd) this.ojyssqt).nmpwovh;
                nmpwovhVar.getClass();
                if (zamkzqg.jlgwuft(nmpwovhVar) != z) {
                    nmpwovhVar.getSharedPreferences("rynx_ui", 0).edit().putBoolean("ambient_halo", z).apply();
                    nmpwovhVar.zftrkmx();
                    break;
                }
                break;
            case 1:
                com.rynx.app.nmpwovh nmpwovhVar2 = ((gepzcpd) this.ojyssqt).nmpwovh;
                nmpwovhVar2.getClass();
                if (zamkzqg.ysluikv(nmpwovhVar2) != z) {
                    nmpwovhVar2.getSharedPreferences("rynx_ui", 0).edit().putBoolean("dark_mode", z).apply();
                    if (nmpwovhVar2.nsyqsfj || nmpwovhVar2.gzokllk || nmpwovhVar2.lpkdqgx) {
                        Toast.makeText(nmpwovhVar2, R.string.settings_theme_deferred, 1).show();
                    } else {
                        nmpwovhVar2.recreate();
                    }
                    break;
                }
                break;
            default:
                kggugdp kggugdpVar = ((mcdstyz) this.ojyssqt).nmpwovh;
                if (!"firmware_upgrade".equals(kggugdpVar.ijakhcl)) {
                    kggugdpVar.lsgjyur = false;
                } else {
                    kggugdpVar.lsgjyur = z;
                    kggugdpVar.gzokllk();
                }
                break;
        }
    }
}
