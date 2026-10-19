package x;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import com.rynx.app.R;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pmsrvoc implements DialogInterface.OnClickListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Activity ojyssqt;
    public final /* synthetic */ Object vivhedu;

    public /* synthetic */ pmsrvoc(Activity activity, Object obj, int i) {
        this.nmpwovh = i;
        this.ojyssqt = activity;
        this.vivhedu = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.nmpwovh) {
            case 0:
                com.rynx.app.nmpwovh nmpwovhVar = (com.rynx.app.nmpwovh) this.ojyssqt;
                String[] strArr = (String[]) this.vivhedu;
                nmpwovhVar.getClass();
                dialogInterface.dismiss();
                String str = strArr[i];
                if (!zamkzqg.jxvdcpb(nmpwovhVar).equals(str)) {
                    nmpwovhVar.getSharedPreferences("rynx_app_preferences", 0).edit().putString("language", zamkzqg.mcdstyz(str)).apply();
                    if (nmpwovhVar.nsyqsfj || nmpwovhVar.gzokllk || nmpwovhVar.lpkdqgx) {
                        nmpwovhVar.iwjoiry();
                        Toast.makeText(nmpwovhVar, R.string.settings_language_deferred, 1).show();
                    } else {
                        nmpwovhVar.recreate();
                    }
                    break;
                }
                break;
            case 1:
                kggugdp kggugdpVar = (kggugdp) this.ojyssqt;
                ArrayList arrayList = (ArrayList) this.vivhedu;
                kggugdpVar.getClass();
                ArrayList arrayList2 = new ArrayList(arrayList);
                if (!arrayList2.isEmpty() && kggugdpVar.wjugzfh()) {
                    File file = new File(Environment.getExternalStorageDirectory(), "rynx/Backup");
                    if (file.exists() || file.mkdirs()) {
                        kggugdpVar.kpmmknm(arrayList2.size(), false);
                        kggugdpVar.lpkdqgx = true;
                        kggugdpVar.ygdccqg = "READ";
                        kggugdpVar.gefzxcg();
                        kggugdpVar.slxntng.execute(new silhone(kggugdpVar, arrayList2, file, kggugdpVar.yjbrzgu("da_path"), kggugdpVar.yjbrzgu("auth_path"), kggugdpVar.yjbrzgu("preloader_path"), 0));
                    } else {
                        Toast.makeText(kggugdpVar, R.string.parts_create_backup_dir_failed, 1).show();
                    }
                    break;
                }
                break;
            default:
                Activity activity = this.ojyssqt;
                try {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((ziuhthw) this.vivhedu).lthborb)));
                } catch (Throwable unused) {
                    Toast.makeText(activity, R.string.update_open_failed, 0).show();
                }
                break;
        }
    }
}
