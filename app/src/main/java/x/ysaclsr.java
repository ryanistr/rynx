package x;

import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class ysaclsr {
    public boolean lthborb;
    public TextView nmpwovh;
    public ScrollView ojyssqt;
    public boolean qxvquar;
    public EditText vivhedu;

    public final void nmpwovh() {
        CharSequence text = this.nmpwovh.getText();
        if (text == null || text.length() <= 120000) {
            return;
        }
        int length = text.length() - 90000;
        int iMax = Math.max(0, length);
        while (true) {
            if (iMax >= text.length()) {
                iMax = -1;
                break;
            } else if (text.charAt(iMax) == '\n') {
                break;
            } else {
                iMax++;
            }
        }
        if (iMax >= 0) {
            length = iMax + 1;
        }
        this.nmpwovh.setText(text.subSequence(Math.min(length, text.length()), text.length()));
    }
}
