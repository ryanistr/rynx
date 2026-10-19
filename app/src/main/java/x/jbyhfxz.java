package x;

import android.app.AlertDialog;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jbyhfxz implements Runnable {
    public final /* synthetic */ Object lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ int ojyssqt;
    public final /* synthetic */ Object vivhedu;

    public /* synthetic */ jbyhfxz(Object obj, Object obj2, int i, int i2) {
        this.nmpwovh = i2;
        this.vivhedu = obj;
        this.lthborb = obj2;
        this.ojyssqt = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final ghkjjru ghkjjruVarSaksmfq;
        final String str;
        File[] fileArrListFiles;
        List listEmptyList;
        switch (this.nmpwovh) {
            case 0:
                final xhyvkax xhyvkaxVar = (xhyvkax) this.lthborb;
                final com.rynx.app.nmpwovh nmpwovhVar = (com.rynx.app.nmpwovh) this.vivhedu;
                nmpwovhVar.getClass();
                try {
                    str = null;
                    ghkjjruVarSaksmfq = zamkzqg.saksmfq(com.rynx.app.ojyssqt.jxvdcpb(), xhyvkaxVar);
                } catch (Throwable th) {
                    String message = th.getMessage();
                    if (message == null || message.trim().isEmpty()) {
                        message = nmpwovhVar.getString(R.string.xiaomi_authorize_unknown_error);
                    }
                    ghkjjruVarSaksmfq = null;
                    str = message;
                }
                final int i = this.ojyssqt;
                nmpwovhVar.runOnUiThread(new Runnable() { // from class: x.cszfvxh
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.rynx.app.nmpwovh nmpwovhVar2 = nmpwovhVar;
                        int i2 = i;
                        ghkjjru ghkjjruVar = ghkjjruVarSaksmfq;
                        xhyvkax xhyvkaxVar2 = xhyvkaxVar;
                        String str2 = str;
                        if (i2 != nmpwovhVar2.nnkxxji || nmpwovhVar2.isFinishing() || nmpwovhVar2.isDestroyed()) {
                            return;
                        }
                        nmpwovhVar2.yztlqms = false;
                        nmpwovhVar2.iivesaq = null;
                        if (ghkjjruVar == null) {
                            nmpwovhVar2.snbdnwo.wqrnifx(str2, nmpwovhVar2.nysvajy != null);
                            return;
                        }
                        nmpwovhVar2.nysvajy = ghkjjruVar;
                        xhyvkaxVar2.qxvquar = ghkjjruVar;
                        nmpwovhVar2.snbdnwo.qxvquar((String) ghkjjruVar.nmpwovh, (String) ghkjjruVar.ojyssqt, (String) ghkjjruVar.vivhedu, (String) ghkjjruVar.lthborb);
                        ((MainActivity) nmpwovhVar2).fadblxi();
                    }
                });
                break;
            case 1:
                File file = (File) this.lthborb;
                ecffprn ecffprnVar = (ecffprn) this.vivhedu;
                ecffprnVar.getClass();
                try {
                    fileArrListFiles = file.listFiles();
                } catch (Throwable unused) {
                    fileArrListFiles = null;
                }
                if (fileArrListFiles == null) {
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : fileArrListFiles) {
                        if (file2 != null) {
                            try {
                                if (!file2.isDirectory()) {
                                    if (ecffprnVar.vivhedu == 0 && file2.isFile() && file2.canRead()) {
                                        Set set = ecffprnVar.lthborb;
                                        if (!set.isEmpty()) {
                                            String lowerCase = file2.getName().toLowerCase(Locale.ROOT);
                                            Iterator it = set.iterator();
                                            while (it.hasNext()) {
                                                if (lowerCase.endsWith((String) it.next())) {
                                                }
                                            }
                                        }
                                        arrayList.add(file2.getCanonicalFile());
                                    }
                                    break;
                                } else if (file2.canRead()) {
                                    arrayList.add(file2.getCanonicalFile());
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                    arrayList.sort(new guecdgy(0));
                    listEmptyList = arrayList;
                }
                ecffprnVar.nmpwovh.runOnUiThread(new jbyhfxz(ecffprnVar, this.ojyssqt, listEmptyList));
                break;
            default:
                ecffprn ecffprnVar2 = (ecffprn) this.vivhedu;
                AlertDialog alertDialog = ecffprnVar2.wqrnifx;
                if (alertDialog != null && alertDialog.isShowing()) {
                    if (this.ojyssqt == ecffprnVar2.nkemejx.get()) {
                        pcbbvuj pcbbvujVar = ecffprnVar2.pvbzgon;
                        ArrayList arrayList2 = pcbbvujVar.nmpwovh;
                        arrayList2.clear();
                        List list = (List) this.lthborb;
                        arrayList2.addAll(list);
                        pcbbvujVar.notifyDataSetChanged();
                        ProgressBar progressBar = ecffprnVar2.buswjhz;
                        if (progressBar != null) {
                            progressBar.setVisibility(8);
                        }
                        ListView listView = ecffprnVar2.utmeivs;
                        if (listView != null) {
                            listView.setEnabled(true);
                            ecffprnVar2.utmeivs.setAlpha(1.0f);
                            zfmpmio.lthborb(ecffprnVar2.nmpwovh, ecffprnVar2.utmeivs, ecffprnVar2.qyeibyo);
                        }
                        if (list.isEmpty()) {
                            ecffprnVar2.ekyqleu.setVisibility(0);
                            ecffprnVar2.ekyqleu.setText(ecffprnVar2.vivhedu == 1 ? R.string.internal_picker_no_subfolders : R.string.internal_picker_no_files);
                        } else {
                            ecffprnVar2.ekyqleu.setVisibility(8);
                        }
                        break;
                    }
                }
                break;
        }
    }

    public /* synthetic */ jbyhfxz(ecffprn ecffprnVar, int i, List list) {
        this.nmpwovh = 2;
        this.vivhedu = ecffprnVar;
        this.ojyssqt = i;
        this.lthborb = list;
    }
}
