package x;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zrcmcht implements TextWatcher {
    public final /* synthetic */ osgyung nmpwovh;
    public final /* synthetic */ hhqpjvl ojyssqt;

    public zrcmcht(osgyung osgyungVar, hhqpjvl hhqpjvlVar) {
        this.nmpwovh = osgyungVar;
        this.ojyssqt = hhqpjvlVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String string = charSequence == null ? "" : charSequence.toString();
        osgyung osgyungVar = this.nmpwovh;
        String lowerCase = string != null ? string.trim().toLowerCase(Locale.ROOT) : "";
        ArrayList arrayList = osgyungVar.vivhedu;
        arrayList.clear();
        boolean zIsEmpty = lowerCase.isEmpty();
        ArrayList<zwccvwt> arrayList2 = osgyungVar.ojyssqt;
        if (zIsEmpty) {
            arrayList.addAll(arrayList2);
        } else {
            for (zwccvwt zwccvwtVar : arrayList2) {
                if (zwccvwtVar.nmpwovh().contains(lowerCase)) {
                    arrayList.add(zwccvwtVar);
                }
            }
        }
        osgyungVar.notifyDataSetChanged();
        this.ojyssqt.run();
    }
}
