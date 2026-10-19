package x;

import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rrpfqyy implements Runnable {
    public final /* synthetic */ Serializable lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ com.rynx.app.nmpwovh ojyssqt;
    public final /* synthetic */ Object qxvquar;
    public final /* synthetic */ int vivhedu;

    public /* synthetic */ rrpfqyy(com.rynx.app.nmpwovh nmpwovhVar, int i, xhyvkax xhyvkaxVar, String str) {
        this.nmpwovh = 1;
        this.ojyssqt = nmpwovhVar;
        this.vivhedu = i;
        this.qxvquar = xhyvkaxVar;
        this.lthborb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String message;
        String strTrim;
        xhyvkax xhyvkaxVar = null;
        String strTrim2 = "";
        switch (this.nmpwovh) {
            case 0:
                String str = (String) this.lthborb;
                String str2 = (String) this.qxvquar;
                com.rynx.app.nmpwovh nmpwovhVar = this.ojyssqt;
                nmpwovhVar.getClass();
                try {
                    xhyvkax xhyvkaxVarSuqlntg = zamkzqg.suqlntg(com.rynx.app.ojyssqt.jxvdcpb(), str, str2);
                    message = null;
                    xhyvkaxVar = xhyvkaxVarSuqlntg;
                } catch (Throwable th) {
                    message = th.getMessage();
                    if (message == null || message.trim().isEmpty()) {
                        message = nmpwovhVar.getString(R.string.xiaomi_authorize_unknown_error);
                    }
                }
                nmpwovhVar.runOnUiThread(new rrpfqyy(nmpwovhVar, this.vivhedu, xhyvkaxVar, message));
                break;
            case 1:
                com.rynx.app.nmpwovh nmpwovhVar2 = this.ojyssqt;
                int i = this.vivhedu;
                xhyvkax xhyvkaxVar2 = (xhyvkax) this.qxvquar;
                String str3 = (String) this.lthborb;
                if (i == nmpwovhVar2.nnkxxji && !nmpwovhVar2.isFinishing() && !nmpwovhVar2.isDestroyed()) {
                    nmpwovhVar2.yztlqms = false;
                    nmpwovhVar2.iivesaq = null;
                    if (xhyvkaxVar2 != null && xhyvkaxVar2.vivhedu()) {
                        nmpwovhVar2.iqvvlnh = xhyvkaxVar2;
                        nmpwovhVar2.nysvajy = xhyvkaxVar2.qxvquar;
                        nmpwovhVar2.snbdnwo.vivhedu.setText("");
                        nmpwovhVar2.snbdnwo.qxvquar((String) xhyvkaxVar2.qxvquar.nmpwovh, (String) xhyvkaxVar2.qxvquar.ojyssqt, (String) xhyvkaxVar2.qxvquar.vivhedu, (String) xhyvkaxVar2.qxvquar.lthborb);
                        if ("xiaomi_authorize".equals(nmpwovhVar2.ayzlrnr)) {
                            zfmpmio.nmpwovh(nmpwovhVar2, nmpwovhVar2.getString(R.string.xiaomi_authorize_login_success), true);
                        }
                        ((MainActivity) nmpwovhVar2).fadblxi();
                        if (!nmpwovhVar2.jcyrpko.isEmpty()) {
                            nmpwovhVar2.thbdbid();
                        } else {
                            nmpwovhVar2.dvzxbaj(false);
                        }
                    } else {
                        nmpwovhVar2.iqvvlnh = null;
                        nmpwovhVar2.nysvajy = null;
                        nmpwovhVar2.snbdnwo.wqrnifx(str3, false);
                    }
                    break;
                }
                break;
            case 2:
                kggugdp kggugdpVar = (kggugdp) this.ojyssqt;
                kggugdpVar.getClass();
                kggugdpVar.nauykcf(this.vivhedu, ((ArrayList) this.lthborb).size(), ((ohwxijw) this.qxvquar).nmpwovh);
                break;
            case 3:
                kggugdp kggugdpVar2 = (kggugdp) this.ojyssqt;
                kggugdpVar2.getClass();
                kggugdpVar2.nauykcf(this.vivhedu, ((ArrayList) this.lthborb).size(), ((araemok) this.qxvquar).nmpwovh.nmpwovh);
                break;
            default:
                int[] iArr = MainActivity.rzsxsyc;
                MainActivity mainActivity = (MainActivity) this.ojyssqt;
                mainActivity.getClass();
                StringBuilder sb = new StringBuilder("[SLA] Job ");
                String str4 = (String) this.lthborb;
                if (str4 == null) {
                    strTrim = "";
                } else {
                    strTrim = str4.trim();
                    if (strTrim.length() > 8) {
                        strTrim = strTrim.substring(0, 8);
                    }
                }
                sb.append(strTrim);
                sb.append(" accepted; waiting for signer…");
                mainActivity.nmpwovh(sb.toString());
                vlyywxv vlyywxvVar = mainActivity.zwccvwt;
                if (vlyywxvVar != null && vlyywxvVar.ojyssqt.isShowing()) {
                    vlyywxvVar.vivhedu.vivhedu = nlcdwap.oqexvyb(str4);
                    vlyywxvVar.gzokllk = 0L;
                    vlyywxvVar.wygqgxb.removeCallbacks(vlyywxvVar.yjbrzgu);
                    vlyywxvVar.qxvquar();
                    String str5 = (String) ((dasxvpc) this.qxvquar).vivhedu;
                    if (str5.isEmpty()) {
                        str5 = "queued";
                    }
                    vlyywxvVar.buswjhz(str5);
                }
                StringBuilder sb2 = new StringBuilder("Job ");
                if (str4 != null) {
                    strTrim2 = str4.trim();
                    if (strTrim2.length() > 8) {
                        strTrim2 = strTrim2.substring(0, 8);
                    }
                }
                sb2.append(strTrim2);
                sb2.append(" accepted by server; waiting for signer…");
                mainActivity.jbyhfxz(this.vivhedu, sb2.toString());
                break;
        }
    }

    public /* synthetic */ rrpfqyy(com.rynx.app.nmpwovh nmpwovhVar, String str, Object obj, int i, int i2) {
        this.nmpwovh = i2;
        this.ojyssqt = nmpwovhVar;
        this.lthborb = str;
        this.qxvquar = obj;
        this.vivhedu = i;
    }

    public /* synthetic */ rrpfqyy(kggugdp kggugdpVar, int i, ArrayList arrayList, Object obj, int i2) {
        this.nmpwovh = i2;
        this.ojyssqt = kggugdpVar;
        this.vivhedu = i;
        this.lthborb = arrayList;
        this.qxvquar = obj;
    }
}
