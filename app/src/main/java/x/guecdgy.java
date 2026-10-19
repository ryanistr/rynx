package x;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class guecdgy implements Comparator {
    public final /* synthetic */ int nmpwovh;

    public /* synthetic */ guecdgy(int i) {
        this.nmpwovh = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.nmpwovh) {
            case 0:
                File file = (File) obj;
                File file2 = (File) obj2;
                if (file.isDirectory() != file2.isDirectory()) {
                    return file.isDirectory() ? -1 : 1;
                }
                return file.getName().compareToIgnoreCase(file2.getName());
            default:
                zwccvwt zwccvwtVar = (zwccvwt) obj;
                zwccvwt zwccvwtVar2 = (zwccvwt) obj2;
                int iCompareToIgnoreCase = zwccvwtVar.lthborb.compareToIgnoreCase(zwccvwtVar2.lthborb);
                if (iCompareToIgnoreCase != 0) {
                    return iCompareToIgnoreCase;
                }
                int iCompareToIgnoreCase2 = zwccvwtVar.ojyssqt.compareToIgnoreCase(zwccvwtVar2.ojyssqt);
                return iCompareToIgnoreCase2 != 0 ? iCompareToIgnoreCase2 : zwccvwtVar.vivhedu.compareToIgnoreCase(zwccvwtVar2.vivhedu);
        }
    }
}
