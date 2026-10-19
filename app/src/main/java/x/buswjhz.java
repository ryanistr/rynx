package x;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class buswjhz implements Comparator {
    public final /* synthetic */ int nmpwovh;

    public buswjhz(int i) {
        this.nmpwovh = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        File file = (File) obj;
        File file2 = (File) obj2;
        switch (this.nmpwovh) {
            case 0:
                if (file.isDirectory() != file2.isDirectory()) {
                    return file.isDirectory() ? -1 : 1;
                }
                return file.getName().compareToIgnoreCase(file2.getName());
            default:
                if (file.isDirectory() != file2.isDirectory()) {
                    return file.isDirectory() ? -1 : 1;
                }
                return file.getName().compareToIgnoreCase(file2.getName());
        }
    }
}
