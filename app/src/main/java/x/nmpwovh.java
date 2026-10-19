package x;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.rynx.app.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nmpwovh implements View.OnClickListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;

    public /* synthetic */ nmpwovh(Object obj, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String string = null;
        switch (this.nmpwovh) {
            case 0:
                Activity activity = (Activity) this.ojyssqt;
                ScrollView scrollView = new ScrollView(activity);
                StringBuilder sb = new StringBuilder();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(activity.getResources().openRawResource(R.raw.apache_2_0)));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                bufferedReader.close();
                                string = sb.toString();
                                TextView textViewOxoagud = zamkzqg.oxoagud(activity, string, 11, zamkzqg.zngzleo(activity), false);
                                textViewOxoagud.setTextIsSelectable(true);
                                int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal);
                                textViewOxoagud.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                                scrollView.addView(textViewOxoagud);
                                new AlertDialog.Builder(activity).setTitle(R.string.about_license_dialog_title).setView(scrollView).setPositiveButton(R.string.about_close, (DialogInterface.OnClickListener) null).show();
                                return;
                            }
                            sb.append(line);
                            sb.append('\n');
                            TextView textViewOxoagud2 = zamkzqg.oxoagud(activity, string, 11, zamkzqg.zngzleo(activity), false);
                            textViewOxoagud2.setTextIsSelectable(true);
                            int dimensionPixelSize2 = activity.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal);
                            textViewOxoagud2.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
                            scrollView.addView(textViewOxoagud2);
                            new AlertDialog.Builder(activity).setTitle(R.string.about_license_dialog_title).setView(scrollView).setPositiveButton(R.string.about_close, (DialogInterface.OnClickListener) null).show();
                            return;
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                                break;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                } catch (Exception unused) {
                    string = activity.getString(R.string.about_license_summary);
                }
                break;
            case 1:
                ((AlertDialog) this.ojyssqt).dismiss();
                return;
            case 2:
                zamkzqg.qwgjehf((EditText) this.ojyssqt);
                return;
            case 3:
                ((mcdstyz) this.ojyssqt).nmpwovh.buswjhz();
                return;
            case 4:
                TextView textView = (TextView) this.ojyssqt;
                boolean z = textView.getVisibility() != 0;
                textView.setVisibility(z ? 0 : 8);
                ((TextView) view).setText(z ? R.string.home_error_hide_details : R.string.home_error_show_details);
                return;
            case 5:
                ((xbdyiew) this.ojyssqt).nmpwovh.buswjhz();
                return;
            default:
                ((kxotgjb) this.ojyssqt).nmpwovh.sthdtww();
                return;
        }
    }
}
