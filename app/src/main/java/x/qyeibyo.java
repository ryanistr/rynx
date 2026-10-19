package x;

import android.content.DialogInterface;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qyeibyo implements DialogInterface.OnClickListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ String vivhedu;

    public /* synthetic */ qyeibyo(MainActivity mainActivity, String str, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
        this.vivhedu = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity = this.ojyssqt;
                String str = this.vivhedu;
                if (mainActivity.wjugzfh()) {
                    mainActivity.ivvkvsj = true;
                    mainActivity.qwgjehf = false;
                    mainActivity.bgmsltp++;
                    mainActivity.gefzxcg();
                    try {
                        ArrayList arrayListIqvvlnh = mainActivity.iqvvlnh(str);
                        if (!arrayListIqvvlnh.isEmpty()) {
                            mainActivity.casbgpb(cugubfc.nmpwovh((String) arrayListIqvvlnh.get(0)), arrayListIqvvlnh.size() > 1 ? (String) arrayListIqvvlnh.get(1) : "", arrayListIqvvlnh.size() > 2 ? mainActivity.ayzlrnr((String) arrayListIqvvlnh.get(2)) : "");
                            break;
                        }
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(mainActivity, mainActivity.getString(R.string.error_invalid_gui_action, e.getMessage()), 0).show();
                        return;
                    }
                }
                break;
            default:
                MainActivity mainActivity2 = this.ojyssqt;
                String str2 = this.vivhedu;
                if (mainActivity2.wjugzfh()) {
                    if (mainActivity2.lpkdqgx || mainActivity2.gzokllk) {
                        Toast.makeText(mainActivity2, R.string.error_busy, 0).show();
                    } else if (!mainActivity2.qyeibyo()) {
                        Toast.makeText(mainActivity2, R.string.error_usb_unavailable, 0).show();
                    } else {
                        Toast.makeText(mainActivity2, mainActivity2.getString(R.string.bootloader_slot_switching, str2), 0).show();
                        iilntfn iilntfnVar = mainActivity2.pmsrvoc;
                        if (iilntfnVar != null) {
                            iilntfnVar.vivhedu();
                        }
                        String strYjbrzgu = mainActivity2.yjbrzgu("da_path");
                        String strYjbrzgu2 = mainActivity2.yjbrzgu("auth_path");
                        String strYjbrzgu3 = mainActivity2.yjbrzgu("preloader_path");
                        mainActivity2.lpkdqgx = true;
                        mainActivity2.gefzxcg();
                        mainActivity2.slxntng.execute(new hhqpjvl((Object) mainActivity2, (Object) str2, (Object) strYjbrzgu, (Object) strYjbrzgu2, (Object) strYjbrzgu3, 0));
                    }
                    break;
                }
                break;
        }
    }
}
