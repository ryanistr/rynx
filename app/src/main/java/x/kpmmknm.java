package x;

import android.widget.TextView;
import com.rynx.app.MainActivity;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kpmmknm implements fusjbbl, cxxnoho {
    public final /* synthetic */ Object nmpwovh;

    public /* synthetic */ kpmmknm(Object obj) {
        this.nmpwovh = obj;
    }

    @Override // x.fusjbbl
    public void nmpwovh(File file) {
        MainActivity mainActivity = (MainActivity) this.nmpwovh;
        mainActivity.getClass();
        mainActivity.wygqgxb(file.getParentFile());
        mainActivity.fprgbbe(file);
    }

    @Override // x.cxxnoho
    public void ojyssqt(String str) {
        kggugdp kggugdpVar = ((xbdyiew) this.nmpwovh).nmpwovh;
        kggugdpVar.getClass();
        if ("red".equals(str) || "yellow".equals(str) || "green".equals(str)) {
            kggugdpVar.sdchfks = str;
        } else {
            kggugdpVar.sdchfks = "green";
        }
        TextView textView = kggugdpVar.nauykcf;
        TextView textView2 = kggugdpVar.ffhrwhh;
        TextView textView3 = kggugdpVar.guecdgy;
        String str2 = kggugdpVar.sdchfks;
        zamkzqg.pwnmyid(kggugdpVar, textView, "green", "green".equals(str2));
        zamkzqg.pwnmyid(kggugdpVar, textView2, "yellow", "yellow".equals(str2));
        zamkzqg.pwnmyid(kggugdpVar, textView3, "red", "red".equals(str2));
        kggugdpVar.rvrflql();
    }
}
