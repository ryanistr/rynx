package x;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes.dex */
public final class xvxmcgn implements TextWatcher {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;

    public /* synthetic */ xvxmcgn(Object obj, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
    }

    private final void lthborb(CharSequence charSequence, int i, int i2, int i3) {
    }

    private final void nmpwovh(Editable editable) {
    }

    private final void ojyssqt(Editable editable) {
    }

    private final void vivhedu(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i = this.nmpwovh;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.nmpwovh;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        switch (this.nmpwovh) {
            case 0:
                ((hhqpjvl) this.ojyssqt).run();
                break;
            default:
                if (charSequence != null) {
                    charSequence.toString();
                }
                ((xbdyiew) this.ojyssqt).nmpwovh.rvrflql();
                break;
        }
    }
}
