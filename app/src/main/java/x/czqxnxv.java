package x;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class czqxnxv implements View.OnClickListener {
    public final /* synthetic */ TextView lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ boolean[] ojyssqt;
    public final /* synthetic */ EditText vivhedu;

    public /* synthetic */ czqxnxv(boolean[] zArr, EditText editText, TextView textView, int i) {
        this.nmpwovh = i;
        this.ojyssqt = zArr;
        this.vivhedu = editText;
        this.lthborb = textView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.nmpwovh) {
            case 0:
                boolean[] zArr = this.ojyssqt;
                boolean z = zArr[0];
                zArr[0] = !z;
                int i = !z ? 144 : 128;
                EditText editText = this.vivhedu;
                editText.setInputType(i | 1);
                editText.setSelection(editText.length());
                this.lthborb.setText(zArr[0] ? R.string.sla_hide : R.string.sla_show);
                break;
            default:
                boolean[] zArr2 = this.ojyssqt;
                boolean z2 = zArr2[0];
                zArr2[0] = !z2;
                TransformationMethod hideReturnsTransformationMethod = !z2 ? HideReturnsTransformationMethod.getInstance() : PasswordTransformationMethod.getInstance();
                EditText editText2 = this.vivhedu;
                editText2.setTransformationMethod(hideReturnsTransformationMethod);
                editText2.setSelection(editText2.length());
                this.lthborb.setText(zArr2[0] ? R.string.xiaomi_authorize_hide : R.string.xiaomi_authorize_show);
                break;
        }
    }
}
