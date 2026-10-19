package x;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class atntgcp implements Runnable {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;
    public final /* synthetic */ Object vivhedu;

    public /* synthetic */ atntgcp(Object obj, Object obj2, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
        this.vivhedu = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity = (MainActivity) this.ojyssqt;
                mainActivity.getClass();
                mainActivity.snilumr("sideload", new zwaqeaz(mainActivity, (File) this.vivhedu, 1));
                break;
            case 1:
                xhyvkax xhyvkaxVar = (xhyvkax) this.ojyssqt;
                String str = (String) this.vivhedu;
                try {
                    String strJxvdcpb = com.rynx.app.ojyssqt.jxvdcpb();
                    if (!zamkzqg.ydsyayx(str).isEmpty()) {
                        JSONObject jSONObject = new JSONObject();
                        zamkzqg.zzqmpyp(jSONObject, "action", "xiaomi_cancel_prepare");
                        zamkzqg.zzqmpyp(jSONObject, "attempt_id", str);
                        zamkzqg.jofyvuh(strJxvdcpb, xhyvkaxVar, jSONObject);
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 2:
                View view = (View) this.vivhedu;
                kggugdp kggugdpVar = (kggugdp) this.ojyssqt;
                kggugdpVar.getClass();
                kggugdp.ibfmasn(view);
                ViewParent parent = view.getParent();
                FrameLayout frameLayout = kggugdpVar.exhiehf;
                if (parent == frameLayout) {
                    frameLayout.removeView(view);
                }
                break;
            case 3:
                ((InputMethodManager) this.vivhedu).showSoftInput(((kggugdp) this.ojyssqt).eigllth, 1);
                break;
            case 4:
                kggugdp kggugdpVar2 = (kggugdp) this.ojyssqt;
                suqlntg suqlntgVar = (suqlntg) this.vivhedu;
                kggugdpVar2.getClass();
                if (suqlntgVar.oqexvyb()) {
                    ArrayList<ohwxijw> arrayListRpdxrib = zamkzqg.rpdxrib((String) suqlntgVar.ojyssqt);
                    ohwxijw ohwxijwVar = kggugdpVar2.ezuzoct;
                    String str2 = ohwxijwVar == null ? null : ohwxijwVar.nmpwovh;
                    kggugdpVar2.jbmzxye.clear();
                    kggugdpVar2.jbmzxye.addAll(arrayListRpdxrib);
                    if (str2 != null) {
                        kggugdpVar2.ezuzoct = null;
                        for (ohwxijw ohwxijwVar2 : arrayListRpdxrib) {
                            if (str2.equals(ohwxijwVar2.nmpwovh)) {
                                kggugdpVar2.ezuzoct = ohwxijwVar2;
                            }
                        }
                    }
                    ((MainActivity) kggugdpVar2).nmpwovh(kggugdpVar2.getString(R.string.log_parts_loaded, Integer.valueOf(arrayListRpdxrib.size())));
                    kggugdpVar2.rvrflql();
                    kggugdpVar2.lvtqoqa();
                } else {
                    TextView textView = kggugdpVar2.nsbgblf;
                    if (textView != null) {
                        textView.setText(R.string.parts_read_failed);
                        kggugdpVar2.nsbgblf.setTextColor(kggugdpVar2.nkemejx);
                    }
                    String str3 = (String) suqlntgVar.ojyssqt;
                    ((MainActivity) kggugdpVar2).nmpwovh(str3 == null ? kggugdpVar2.getString(R.string.parts_gpt_failed_short) : str3.trim());
                }
                kggugdpVar2.exhiehf(kggugdpVar2.npkgpdo, kggugdpVar2.nsyqsfj);
                kggugdpVar2.gefzxcg();
                break;
            default:
                InputMethodManager inputMethodManager = (InputMethodManager) ((Context) this.ojyssqt).getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput((EditText) this.vivhedu, 1);
                }
                break;
        }
    }
}
