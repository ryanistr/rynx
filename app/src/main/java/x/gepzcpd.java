package x;

import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final class gepzcpd {
    public final /* synthetic */ com.rynx.app.nmpwovh nmpwovh;

    public gepzcpd(com.rynx.app.nmpwovh nmpwovhVar) {
        this.nmpwovh = nmpwovhVar;
    }

    public void nmpwovh(String str, String str2) {
        com.rynx.app.nmpwovh nmpwovhVar = this.nmpwovh;
        if (nmpwovhVar.yztlqms || nmpwovhVar.snbdnwo == null) {
            return;
        }
        String strTrim = str == null ? "" : str.trim();
        String strTrim2 = str2 == null ? "" : str2.trim();
        if (strTrim.isEmpty() || strTrim2.isEmpty()) {
            nmpwovhVar.snbdnwo.wqrnifx(nmpwovhVar.getString(R.string.xiaomi_authorize_credentials_required), false);
            return;
        }
        int i = nmpwovhVar.nnkxxji + 1;
        nmpwovhVar.nnkxxji = i;
        nmpwovhVar.yztlqms = true;
        nmpwovhVar.snbdnwo.nkemejx(false);
        nmpwovhVar.iivesaq = nmpwovhVar.zfmpmio.submit(new rrpfqyy(nmpwovhVar, strTrim, strTrim2, i, 0));
    }
}
