package x;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hknanqb implements DialogInterface.OnClickListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;

    public /* synthetic */ hknanqb(MainActivity mainActivity, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        File file;
        switch (this.nmpwovh) {
            case 0:
                this.ojyssqt.yonoayx();
                break;
            case 1:
                MainActivity mainActivity = this.ojyssqt;
                mainActivity.ezuzoct = (ohwxijw) mainActivity.jbmzxye.get(i);
                mainActivity.lvtqoqa();
                break;
            default:
                MainActivity mainActivity2 = this.ojyssqt;
                ohwxijw ohwxijwVar = mainActivity2.ezuzoct;
                if (ohwxijwVar != null && (file = mainActivity2.pwjmwpv) != null) {
                    String str = mainActivity2.prywqjr ? "write-flash" : "download";
                    String str2 = ohwxijwVar.nmpwovh;
                    String absolutePath = file.getAbsolutePath();
                    String string = mainActivity2.getString(str.equals("write-flash") ? R.string.flash_method_raw_advanced : R.string.flash_method_download);
                    final tmdubwv tmdubwvVar = new tmdubwv(mainActivity2);
                    ScrollView scrollView = new ScrollView(mainActivity2);
                    scrollView.setFillViewport(true);
                    LinearLayout linearLayoutXbdyiew = zamkzqg.xbdyiew(mainActivity2, 16);
                    scrollView.addView(linearLayoutXbdyiew);
                    int iNmpwovh = zamkzqg.nmpwovh(mainActivity2);
                    final int i2 = 0;
                    TextView textViewLclupha = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.nav_flash), new View.OnClickListener() { // from class: x.cnctlxz
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            switch (i2) {
                                case 0:
                                    tmdubwv tmdubwvVar2 = tmdubwvVar;
                                    if (!((MainActivity) tmdubwvVar2.nmpwovh).lpkdqgx) {
                                        ((MainActivity) tmdubwvVar2.nmpwovh).buswjhz();
                                    } else {
                                        Toast.makeText((MainActivity) tmdubwvVar2.nmpwovh, R.string.flash_still_running, 0).show();
                                    }
                                    break;
                                default:
                                    ((MainActivity) tmdubwvVar.nmpwovh).imuemzb();
                                    break;
                            }
                        }
                    });
                    zamkzqg.enxkjpu(mainActivity2, textViewLclupha, R.drawable.ic_back, iNmpwovh);
                    textViewLclupha.setGravity(8388627);
                    textViewLclupha.setPadding(0, zamkzqg.qunltjs(mainActivity2, 4), 0, zamkzqg.qunltjs(mainActivity2, 8));
                    linearLayoutXbdyiew.addView(textViewLclupha);
                    linearLayoutXbdyiew.addView(zamkzqg.ywhgqsi(mainActivity2, mainActivity2.getString(R.string.flash_progress_title, str2)));
                    LinearLayout linearLayoutZwaqeaz = zamkzqg.zwaqeaz(mainActivity2);
                    linearLayoutZwaqeaz.addView(zamkzqg.ysaclsr(mainActivity2, R.string.flash_target));
                    linearLayoutZwaqeaz.addView(zamkzqg.oxoagud(mainActivity2, str2, 18, zamkzqg.zngzleo(mainActivity2), true));
                    TextView textViewOxoagud = zamkzqg.oxoagud(mainActivity2, absolutePath, 11, zamkzqg.jbmzxye(mainActivity2), false);
                    textViewOxoagud.setPadding(0, zamkzqg.qunltjs(mainActivity2, 5), 0, 0);
                    linearLayoutZwaqeaz.addView(textViewOxoagud);
                    TextView textViewOxoagud2 = zamkzqg.oxoagud(mainActivity2, string, 11, zamkzqg.nmpwovh(mainActivity2), true);
                    textViewOxoagud2.setPadding(0, zamkzqg.qunltjs(mainActivity2, 5), 0, 0);
                    linearLayoutZwaqeaz.addView(textViewOxoagud2);
                    linearLayoutXbdyiew.addView(linearLayoutZwaqeaz, zamkzqg.uiqyzsp(mainActivity2));
                    LinearLayout linearLayoutZwaqeaz2 = zamkzqg.zwaqeaz(mainActivity2);
                    linearLayoutZwaqeaz2.addView(zamkzqg.ysaclsr(mainActivity2, R.string.progress_title));
                    LinearLayout linearLayoutLvtqoqa = zamkzqg.lvtqoqa(mainActivity2);
                    TextView textViewOxoagud3 = zamkzqg.oxoagud(mainActivity2, "0%", 25, zamkzqg.pzkwhtn(mainActivity2), true);
                    TextView textViewOxoagud4 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.progress_preparing_write), 11, zamkzqg.jbmzxye(mainActivity2), false);
                    textViewOxoagud4.setGravity(8388613);
                    linearLayoutLvtqoqa.addView(textViewOxoagud3, new LinearLayout.LayoutParams(0, -2, 1.0f));
                    linearLayoutLvtqoqa.addView(textViewOxoagud4, new LinearLayout.LayoutParams(0, -2, 2.0f));
                    linearLayoutZwaqeaz2.addView(linearLayoutLvtqoqa);
                    ProgressBar progressBar = new ProgressBar(mainActivity2, null, android.R.attr.progressBarStyleHorizontal);
                    progressBar.setMax(100);
                    progressBar.setProgress(0);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity2, 12));
                    layoutParams.topMargin = zamkzqg.qunltjs(mainActivity2, 8);
                    linearLayoutZwaqeaz2.addView(progressBar, layoutParams);
                    TextView textViewLjhdwjr = zamkzqg.ljhdwjr(mainActivity2, linearLayoutZwaqeaz2, R.string.progress_transferred, mainActivity2.getString(R.string.progress_zero_bytes));
                    TextView textViewLjhdwjr2 = zamkzqg.ljhdwjr(mainActivity2, linearLayoutZwaqeaz2, R.string.progress_speed, mainActivity2.getString(R.string.value_not_available));
                    TextView textViewLjhdwjr3 = zamkzqg.ljhdwjr(mainActivity2, linearLayoutZwaqeaz2, R.string.progress_elapsed, mainActivity2.getString(R.string.progress_zero_time));
                    TextView textViewLjhdwjr4 = zamkzqg.ljhdwjr(mainActivity2, linearLayoutZwaqeaz2, R.string.progress_eta, mainActivity2.getString(R.string.value_not_available));
                    linearLayoutXbdyiew.addView(linearLayoutZwaqeaz2, zamkzqg.uiqyzsp(mainActivity2));
                    LinearLayout linearLayoutZwaqeaz3 = zamkzqg.zwaqeaz(mainActivity2);
                    linearLayoutZwaqeaz3.addView(zamkzqg.ysaclsr(mainActivity2, R.string.progress_log_preview));
                    String str3 = str;
                    TextView textViewOxoagud5 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.progress_waiting_backend), 10, zamkzqg.zngzleo(mainActivity2), false);
                    textViewOxoagud5.setTypeface(Typeface.MONOSPACE);
                    textViewOxoagud5.setPadding(0, zamkzqg.qunltjs(mainActivity2, 6), 0, 0);
                    linearLayoutZwaqeaz3.addView(textViewOxoagud5);
                    linearLayoutXbdyiew.addView(linearLayoutZwaqeaz3, zamkzqg.uiqyzsp(mainActivity2));
                    TextView textViewOxoagud6 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.progress_do_not_disconnect), 12, zamkzqg.ohwxijw(mainActivity2), true);
                    zamkzqg.enxkjpu(mainActivity2, textViewOxoagud6, R.drawable.ic_warning, zamkzqg.ohwxijw(mainActivity2));
                    textViewOxoagud6.setPadding(0, zamkzqg.qunltjs(mainActivity2, 5), 0, zamkzqg.qunltjs(mainActivity2, 8));
                    linearLayoutXbdyiew.addView(textViewOxoagud6);
                    int iPzqxblc = zamkzqg.pzqxblc(mainActivity2);
                    final int i3 = 1;
                    TextView textViewLclupha2 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.progress_stop_session), new View.OnClickListener() { // from class: x.cnctlxz
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            switch (i3) {
                                case 0:
                                    tmdubwv tmdubwvVar2 = tmdubwvVar;
                                    if (!((MainActivity) tmdubwvVar2.nmpwovh).lpkdqgx) {
                                        ((MainActivity) tmdubwvVar2.nmpwovh).buswjhz();
                                    } else {
                                        Toast.makeText((MainActivity) tmdubwvVar2.nmpwovh, R.string.flash_still_running, 0).show();
                                    }
                                    break;
                                default:
                                    ((MainActivity) tmdubwvVar.nmpwovh).imuemzb();
                                    break;
                            }
                        }
                    });
                    zamkzqg.enxkjpu(mainActivity2, textViewLclupha2, R.drawable.ic_stop, iPzqxblc);
                    textViewLclupha2.setTextColor(zamkzqg.pzqxblc(mainActivity2));
                    linearLayoutXbdyiew.addView(textViewLclupha2, new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity2, 50)));
                    mainActivity2.vhimehb = progressBar;
                    mainActivity2.naaizwn = textViewOxoagud3;
                    mainActivity2.hjlrtqw = textViewOxoagud4;
                    mainActivity2.xbdyiew = textViewLjhdwjr;
                    mainActivity2.ohwxijw = textViewLjhdwjr2;
                    mainActivity2.yomtcav = textViewLjhdwjr3;
                    mainActivity2.uzyihoe = textViewLjhdwjr4;
                    mainActivity2.dkpobjg = textViewOxoagud5;
                    mainActivity2.kffvigz(scrollView, "flash_progress");
                    zfmpmio.vivhedu(mainActivity2.vhimehb, true);
                    mainActivity2.lpkdqgx = true;
                    mainActivity2.ygdccqg = "WRITE";
                    mainActivity2.cxxnoho = ohwxijwVar.nmpwovh;
                    mainActivity2.clczezu = System.currentTimeMillis();
                    mainActivity2.nmpwovh(mainActivity2.getString(R.string.log_flash_start, ohwxijwVar.nmpwovh, file.getAbsolutePath(), str3));
                    mainActivity2.gefzxcg();
                    mainActivity2.slxntng.execute(new lpkdqgx(mainActivity2, str3, ohwxijwVar, file, mainActivity2.yjbrzgu("da_path"), mainActivity2.yjbrzgu("auth_path"), mainActivity2.yjbrzgu("preloader_path")));
                    break;
                }
                break;
        }
    }
}
