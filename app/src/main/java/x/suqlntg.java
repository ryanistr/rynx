package x;

import com.rynx.app.MainActivity;
import java.io.Serializable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final class suqlntg implements sfildfy {
    public final int nmpwovh;
    public final Object ojyssqt;

    public /* synthetic */ suqlntg(int i, Serializable serializable) {
        this.nmpwovh = i;
        this.ojyssqt = serializable;
    }

    public int lthborb(int i, int i2) {
        try {
            return Integer.parseInt(vivhedu(i));
        } catch (RuntimeException unused) {
            return i2;
        }
    }

    public void nkemejx() {
        if (this.nmpwovh != ((com.rynx.app.nmpwovh) this.ojyssqt).zyxfuka) {
            return;
        }
        ((com.rynx.app.nmpwovh) this.ojyssqt).zyxfuka++;
        com.rynx.app.nmpwovh nmpwovhVar = (com.rynx.app.nmpwovh) this.ojyssqt;
        Future future = nmpwovhVar.iivesaq;
        nmpwovhVar.iivesaq = null;
        if (future != null) {
            future.cancel(true);
        }
        ((com.rynx.app.nmpwovh) this.ojyssqt).yztlqms = false;
        ((com.rynx.app.nmpwovh) this.ojyssqt).gzvolsx();
        ((com.rynx.app.nmpwovh) this.ojyssqt).ysluikv("stop");
        ((com.rynx.app.nmpwovh) this.ojyssqt).nativeSetXiaomiAuthGeneration(0);
        ((com.rynx.app.nmpwovh) this.ojyssqt).yonoayx();
        ((com.rynx.app.nmpwovh) this.ojyssqt).pmsrvoc(this.nmpwovh, "Authorization stopped before dispatch.", true);
    }

    @Override // x.sfildfy
    public void nmpwovh() {
        ((MainActivity) this.ojyssqt).rpilpcp = false;
        ((MainActivity) this.ojyssqt).ijakhcl();
        ((MainActivity) this.ojyssqt).qwgjehf = false;
        MainActivity mainActivity = (MainActivity) this.ojyssqt;
        mainActivity.mwngani = false;
        mainActivity.bgmsltp++;
        ((MainActivity) this.ojyssqt).nmpwovh("[SLA] Authorization cancelled.");
        ((MainActivity) this.ojyssqt).gefzxcg();
    }

    @Override // x.sfildfy
    public void ojyssqt(String str, String str2) {
        MainActivity mainActivity;
        boolean z;
        ((MainActivity) this.ojyssqt).rpilpcp = false;
        if (this.nmpwovh == ((MainActivity) this.ojyssqt).bgmsltp && ((MainActivity) this.ojyssqt).qwgjehf) {
            synchronized (((MainActivity) this.ojyssqt).sthdtww) {
                ((MainActivity) this.ojyssqt).hhqpjvl = str.trim();
                mainActivity = (MainActivity) this.ojyssqt;
                mainActivity.wjugzfh = str2;
            }
            synchronized (mainActivity.sthdtww) {
                try {
                    z = (mainActivity.hhqpjvl.isEmpty() || mainActivity.wjugzfh.isEmpty()) ? false : true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z) {
                ((MainActivity) this.ojyssqt).qwgjehf = false;
                ((MainActivity) this.ojyssqt).nmpwovh("[SLA] Empty credentials; START cancelled.");
                ((MainActivity) this.ojyssqt).gefzxcg();
                return;
            }
            ((MainActivity) this.ojyssqt).qwgjehf = false;
            MainActivity mainActivity2 = (MainActivity) this.ojyssqt;
            mainActivity2.mwngani = false;
            mainActivity2.bgmsltp++;
            ((MainActivity) this.ojyssqt).wygqgxb = -1;
            ((MainActivity) this.ojyssqt).yjbrzgu = 0;
            ((MainActivity) this.ojyssqt).nmpwovh("[SLA] Credentials ready in RAM. Press START again to continue with remote SLA.");
            ((MainActivity) this.ojyssqt).gefzxcg();
        }
    }

    public boolean oqexvyb() {
        return this.nmpwovh == 0;
    }

    public long qxvquar(int i) {
        try {
            return Long.parseLong(vivhedu(i));
        } catch (RuntimeException unused) {
            return -1L;
        }
    }

    public String vivhedu(int i) {
        if (i >= 0) {
            String[] strArr = (String[]) this.ojyssqt;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return "";
    }

    public /* synthetic */ suqlntg(com.rynx.app.nmpwovh nmpwovhVar, int i) {
        this.ojyssqt = nmpwovhVar;
        this.nmpwovh = i;
    }
}
