package x;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class lcgzsis {
    public final String lthborb;
    public final List nkemejx;
    public final File nmpwovh;
    public final String ojyssqt;
    public final long oqexvyb;
    public final String qxvquar;
    public final String vivhedu;

    public lcgzsis(File file, String str, String str2, String str3, String str4, long j, ArrayList arrayList) {
        this.nmpwovh = file;
        this.ojyssqt = str == null ? "" : str.trim();
        this.vivhedu = str2.trim();
        this.lthborb = str3 != null ? str3.trim() : "";
        this.qxvquar = str4.trim();
        this.oqexvyb = j;
        this.nkemejx = Collections.unmodifiableList(new ArrayList(arrayList));
    }
}
