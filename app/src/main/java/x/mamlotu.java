package x;

import android.view.View;
import android.widget.CheckBox;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mamlotu implements View.OnClickListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ CheckBox ojyssqt;

    public /* synthetic */ mamlotu(CheckBox checkBox, int i) {
        this.nmpwovh = i;
        this.ojyssqt = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.nmpwovh) {
            case 0:
                CheckBox checkBox = this.ojyssqt;
                checkBox.setChecked(!checkBox.isChecked());
                break;
            default:
                CheckBox checkBox2 = this.ojyssqt;
                checkBox2.setChecked(!checkBox2.isChecked());
                break;
        }
    }
}
