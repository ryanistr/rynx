package x;

import android.widget.EditText;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pvbzgon implements fusjbbl {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;

    public /* synthetic */ pvbzgon(MainActivity mainActivity, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
    }

    @Override // x.fusjbbl
    public final void nmpwovh(File file) {
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity = this.ojyssqt;
                mainActivity.getClass();
                mainActivity.wygqgxb(file.getParentFile());
                String absolutePath = file.getAbsolutePath();
                jybecxv jybecxvVar = mainActivity.ltnesel;
                if (jybecxvVar == null || jybecxvVar.lthborb == null || com.rynx.app.ojyssqt.zwaqeaz(absolutePath)) {
                    return;
                }
                EditText editText = mainActivity.ltnesel.lthborb;
                String string = editText.getText() == null ? "" : editText.getText().toString();
                int iMax = Math.max(0, editText.getSelectionStart());
                int iMax2 = Math.max(0, editText.getSelectionEnd());
                if (iMax > iMax2) {
                    iMax2 = iMax;
                    iMax = iMax2;
                }
                int iMin = Math.min(iMax, string.length());
                int iMin2 = Math.min(iMax2, string.length());
                if (absolutePath == null) {
                    absolutePath = "";
                } else if (absolutePath.indexOf(32) >= 0 || absolutePath.indexOf(9) >= 0 || absolutePath.indexOf(34) >= 0 || absolutePath.indexOf(39) >= 0) {
                    absolutePath = "\"" + absolutePath.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
                }
                boolean z = iMin > 0 && !Character.isWhitespace(string.charAt(iMin + (-1)));
                boolean z2 = iMin2 < string.length() && !Character.isWhitespace(string.charAt(iMin2));
                StringBuilder sb = new StringBuilder();
                sb.append(z ? " " : "");
                sb.append(absolutePath);
                sb.append(z2 ? " " : "");
                String string2 = sb.toString();
                String str = string.substring(0, iMin) + string2 + string.substring(iMin2);
                editText.setText(str);
                editText.setSelection(Math.min(str.length(), string2.length() + iMin));
                editText.requestFocus();
                return;
            case 1:
                MainActivity mainActivity2 = this.ojyssqt;
                mainActivity2.getClass();
                mainActivity2.wygqgxb(file.getParentFile());
                try {
                    mainActivity2.ecffprn(mainActivity2.naaizwn(file, "selected-auth", "auth-", "AUTH"), file.getName());
                    return;
                } catch (Throwable th) {
                    mainActivity2.nmpwovh(mainActivity2.getString(R.string.log_auth_realpath_error, String.valueOf(th.getMessage())));
                    Toast.makeText(mainActivity2, R.string.error_read_selected_auth, 1).show();
                    return;
                }
            case 2:
                MainActivity mainActivity3 = this.ojyssqt;
                mainActivity3.getClass();
                mainActivity3.wygqgxb(file.getParentFile());
                try {
                    String strPvkaerr = com.rynx.app.ojyssqt.pvkaerr(file.getName());
                    if (!com.rynx.app.ojyssqt.gisppfs(strPvkaerr)) {
                        mainActivity3.nmpwovh(mainActivity3.getString(R.string.log_preloader_extension_rejected, strPvkaerr));
                        Toast.makeText(mainActivity3, R.string.error_preloader_must_be_bin, 1).show();
                        return;
                    }
                    File fileNaaizwn = mainActivity3.naaizwn(file, "selected-preloader", "preloader-", "preloader");
                    if (!fileNaaizwn.isFile() || !fileNaaizwn.canRead() || fileNaaizwn.length() <= 0) {
                        throw new IOException(mainActivity3.getString(R.string.error_read_selected_preloader));
                    }
                    mainActivity3.rpilpcp();
                    mainActivity3.lcgzsis(fileNaaizwn.getAbsolutePath(), strPvkaerr);
                    mainActivity3.iasgsgq(fileNaaizwn, "selected-preloader");
                    mainActivity3.nmpwovh(mainActivity3.getString(R.string.gui_preloader_selected, strPvkaerr));
                    Toast.makeText(mainActivity3, mainActivity3.getString(R.string.gui_preloader_selected_toast, strPvkaerr), 0).show();
                    mainActivity3.gefzxcg();
                    return;
                } catch (Throwable th2) {
                    mainActivity3.nmpwovh(mainActivity3.getString(R.string.log_preloader_import_error, String.valueOf(th2.getMessage())));
                    Toast.makeText(mainActivity3, R.string.error_read_selected_preloader, 1).show();
                    return;
                }
            default:
                MainActivity mainActivity4 = this.ojyssqt;
                mainActivity4.getClass();
                mainActivity4.wygqgxb(file.getParentFile());
                try {
                    String strPvkaerr2 = com.rynx.app.ojyssqt.pvkaerr(file.getName());
                    if (!com.rynx.app.ojyssqt.gisppfs(strPvkaerr2)) {
                        mainActivity4.nmpwovh(mainActivity4.getString(R.string.log_da_extension_rejected, strPvkaerr2));
                        Toast.makeText(mainActivity4, R.string.error_da_must_be_bin, 1).show();
                        return;
                    }
                    File fileNaaizwn2 = mainActivity4.naaizwn(file, "selected-da", "da-", "DA");
                    if (!fileNaaizwn2.isFile() || !fileNaaizwn2.canRead() || fileNaaizwn2.length() <= 0) {
                        throw new IOException(mainActivity4.getString(R.string.error_read_selected_da));
                    }
                    mainActivity4.rpilpcp();
                    mainActivity4.mccfjlr(fileNaaizwn2.getAbsolutePath(), strPvkaerr2, mainActivity4.yjbrzgu("auth_path"), mainActivity4.yjbrzgu("preloader_path"));
                    mainActivity4.iasgsgq(fileNaaizwn2, "selected-da");
                    mainActivity4.nmpwovh(mainActivity4.getString(R.string.gui_da_selected, strPvkaerr2));
                    Toast.makeText(mainActivity4, mainActivity4.getString(R.string.gui_da_selected_toast, strPvkaerr2), 0).show();
                    mainActivity4.bgmsltp();
                    mainActivity4.ivvkvsj();
                    return;
                } catch (Throwable th3) {
                    mainActivity4.nmpwovh(mainActivity4.getString(R.string.log_da_import_error, String.valueOf(th3.getMessage())));
                    Toast.makeText(mainActivity4, R.string.error_read_selected_da, 1).show();
                    return;
                }
        }
    }
}
