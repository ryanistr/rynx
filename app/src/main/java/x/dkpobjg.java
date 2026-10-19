package x;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dkpobjg implements View.OnClickListener {
    public final /* synthetic */ Object lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;
    public final /* synthetic */ Object qxvquar;
    public final /* synthetic */ Object vivhedu;

    public /* synthetic */ dkpobjg(AlertDialog alertDialog, EditText editText, String str, kggugdp kggugdpVar) {
        this.nmpwovh = 1;
        this.lthborb = kggugdpVar;
        this.ojyssqt = editText;
        this.vivhedu = alertDialog;
        this.qxvquar = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.nmpwovh) {
            case 0:
                kggugdp kggugdpVar = (kggugdp) this.lthborb;
                ohwxijw ohwxijwVar = (ohwxijw) this.qxvquar;
                EditText editText = (EditText) this.ojyssqt;
                AlertDialog alertDialog = (AlertDialog) this.vivhedu;
                kggugdpVar.getClass();
                if (!ohwxijwVar.nmpwovh.equals(editText.getText().toString().trim())) {
                    editText.setError(kggugdpVar.getString(R.string.parts_erase_type_error, ohwxijwVar.nmpwovh));
                } else {
                    alertDialog.dismiss();
                    final xbdyiew xbdyiewVar = new xbdyiew(kggugdpVar);
                    ScrollView scrollView = new ScrollView(kggugdpVar);
                    scrollView.setFillViewport(true);
                    LinearLayout linearLayoutXbdyiew = zamkzqg.xbdyiew(kggugdpVar, 16);
                    scrollView.addView(linearLayoutXbdyiew);
                    int iNmpwovh = zamkzqg.nmpwovh(kggugdpVar);
                    final int i = 0;
                    TextView textViewLclupha = zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_title), new View.OnClickListener() { // from class: x.yomtcav
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            switch (i) {
                                case 0:
                                    xbdyiew xbdyiewVar2 = xbdyiewVar;
                                    if (!xbdyiewVar2.nmpwovh.lpkdqgx) {
                                        xbdyiewVar2.nmpwovh.buswjhz();
                                    } else {
                                        Toast.makeText(xbdyiewVar2.nmpwovh, R.string.parts_erase_running_warning, 0).show();
                                    }
                                    break;
                                default:
                                    xbdyiew xbdyiewVar3 = xbdyiewVar;
                                    if (xbdyiewVar3.nmpwovh.lpkdqgx) {
                                        kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                        ((MainActivity) kggugdpVar2).nmpwovh(kggugdpVar2.getString(R.string.log_parts_stop_erase));
                                    }
                                    xbdyiewVar3.nmpwovh.yonoayx();
                                    break;
                            }
                        }
                    });
                    zamkzqg.enxkjpu(kggugdpVar, textViewLclupha, R.drawable.ic_back, iNmpwovh);
                    textViewLclupha.setGravity(8388627);
                    textViewLclupha.setPadding(0, zamkzqg.qunltjs(kggugdpVar, 4), 0, zamkzqg.qunltjs(kggugdpVar, 8));
                    linearLayoutXbdyiew.addView(textViewLclupha);
                    linearLayoutXbdyiew.addView(zamkzqg.ywhgqsi(kggugdpVar, kggugdpVar.getString(R.string.parts_erase_title)));
                    LinearLayout linearLayoutZwaqeaz = zamkzqg.zwaqeaz(kggugdpVar);
                    linearLayoutZwaqeaz.setBackground(zamkzqg.jvtqflj(kggugdpVar, zamkzqg.tmdubwv(kggugdpVar, ohwxijwVar.oqexvyb), zamkzqg.cugubfc(kggugdpVar, ohwxijwVar.oqexvyb), zamkzqg.qunltjs(kggugdpVar, zamkzqg.nhhacgu(kggugdpVar))));
                    linearLayoutZwaqeaz.addView(zamkzqg.ysaclsr(kggugdpVar, R.string.parts_selected_partition));
                    TextView textViewOxoagud = zamkzqg.oxoagud(kggugdpVar, ohwxijwVar.nmpwovh, 18, zamkzqg.zngzleo(kggugdpVar), true);
                    zamkzqg.enxkjpu(kggugdpVar, textViewOxoagud, R.drawable.ic_erase, zamkzqg.pzqxblc(kggugdpVar));
                    linearLayoutZwaqeaz.addView(textViewOxoagud);
                    linearLayoutZwaqeaz.addView(zamkzqg.oxoagud(kggugdpVar, ohwxijwVar.lthborb + " • " + zamkzqg.jybecxv(ohwxijwVar.vivhedu), 11, zamkzqg.jbmzxye(kggugdpVar), false));
                    linearLayoutXbdyiew.addView(linearLayoutZwaqeaz, zamkzqg.uiqyzsp(kggugdpVar));
                    LinearLayout linearLayoutZwaqeaz2 = zamkzqg.zwaqeaz(kggugdpVar);
                    TextView textViewOxoagud2 = zamkzqg.oxoagud(kggugdpVar, kggugdpVar.getString(R.string.parts_erase_warning), 12, zamkzqg.pzqxblc(kggugdpVar), true);
                    zamkzqg.enxkjpu(kggugdpVar, textViewOxoagud2, R.drawable.ic_warning, zamkzqg.pzqxblc(kggugdpVar));
                    linearLayoutZwaqeaz2.addView(textViewOxoagud2);
                    linearLayoutXbdyiew.addView(linearLayoutZwaqeaz2, zamkzqg.uiqyzsp(kggugdpVar));
                    LinearLayout linearLayoutZwaqeaz3 = zamkzqg.zwaqeaz(kggugdpVar);
                    linearLayoutZwaqeaz3.addView(zamkzqg.ysaclsr(kggugdpVar, R.string.progress_title));
                    LinearLayout linearLayoutLvtqoqa = zamkzqg.lvtqoqa(kggugdpVar);
                    TextView textViewOxoagud3 = zamkzqg.oxoagud(kggugdpVar, "0%", 22, zamkzqg.pzqxblc(kggugdpVar), true);
                    TextView textViewOxoagud4 = zamkzqg.oxoagud(kggugdpVar, kggugdpVar.getString(R.string.parts_erase_preparing), 11, zamkzqg.jbmzxye(kggugdpVar), false);
                    textViewOxoagud4.setGravity(8388613);
                    linearLayoutLvtqoqa.addView(textViewOxoagud3, new LinearLayout.LayoutParams(0, zamkzqg.qunltjs(kggugdpVar, 34), 1.0f));
                    linearLayoutLvtqoqa.addView(textViewOxoagud4, new LinearLayout.LayoutParams(0, zamkzqg.qunltjs(kggugdpVar, 34), 2.0f));
                    linearLayoutZwaqeaz3.addView(linearLayoutLvtqoqa);
                    ProgressBar progressBar = new ProgressBar(kggugdpVar, null, android.R.attr.progressBarStyleHorizontal);
                    progressBar.setMax(100);
                    progressBar.setProgress(0);
                    linearLayoutZwaqeaz3.addView(progressBar, new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(kggugdpVar, 12)));
                    linearLayoutXbdyiew.addView(linearLayoutZwaqeaz3, zamkzqg.uiqyzsp(kggugdpVar));
                    LinearLayout linearLayoutZwaqeaz4 = zamkzqg.zwaqeaz(kggugdpVar);
                    linearLayoutZwaqeaz4.addView(zamkzqg.ysaclsr(kggugdpVar, R.string.progress_log_preview));
                    TextView textViewOxoagud5 = zamkzqg.oxoagud(kggugdpVar, kggugdpVar.getString(R.string.progress_waiting_backend), 10, zamkzqg.zngzleo(kggugdpVar), false);
                    textViewOxoagud5.setTypeface(Typeface.MONOSPACE);
                    linearLayoutZwaqeaz4.addView(textViewOxoagud5);
                    linearLayoutXbdyiew.addView(linearLayoutZwaqeaz4, zamkzqg.uiqyzsp(kggugdpVar));
                    int iPzqxblc = zamkzqg.pzqxblc(kggugdpVar);
                    final int i2 = 1;
                    TextView textViewLclupha2 = zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.progress_stop_session), new View.OnClickListener() { // from class: x.yomtcav
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            switch (i2) {
                                case 0:
                                    xbdyiew xbdyiewVar2 = xbdyiewVar;
                                    if (!xbdyiewVar2.nmpwovh.lpkdqgx) {
                                        xbdyiewVar2.nmpwovh.buswjhz();
                                    } else {
                                        Toast.makeText(xbdyiewVar2.nmpwovh, R.string.parts_erase_running_warning, 0).show();
                                    }
                                    break;
                                default:
                                    xbdyiew xbdyiewVar3 = xbdyiewVar;
                                    if (xbdyiewVar3.nmpwovh.lpkdqgx) {
                                        kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                        ((MainActivity) kggugdpVar2).nmpwovh(kggugdpVar2.getString(R.string.log_parts_stop_erase));
                                    }
                                    xbdyiewVar3.nmpwovh.yonoayx();
                                    break;
                            }
                        }
                    });
                    zamkzqg.enxkjpu(kggugdpVar, textViewLclupha2, R.drawable.ic_stop, iPzqxblc);
                    textViewLclupha2.setTextColor(zamkzqg.pzqxblc(kggugdpVar));
                    linearLayoutXbdyiew.addView(textViewLclupha2, new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(kggugdpVar, 50)));
                    kggugdpVar.vhimehb = progressBar;
                    kggugdpVar.naaizwn = textViewOxoagud3;
                    kggugdpVar.hjlrtqw = textViewOxoagud4;
                    kggugdpVar.dkpobjg = textViewOxoagud5;
                    kggugdpVar.xbdyiew = null;
                    kggugdpVar.ohwxijw = null;
                    kggugdpVar.yomtcav = null;
                    kggugdpVar.uzyihoe = null;
                    kggugdpVar.ygdccqg = "ERASE";
                    kggugdpVar.cxxnoho = ohwxijwVar.nmpwovh;
                    kggugdpVar.clczezu = System.currentTimeMillis();
                    kggugdpVar.kffvigz(scrollView, "partition_erase_progress");
                    kggugdpVar.lpkdqgx = true;
                    kggugdpVar.gefzxcg();
                    ((MainActivity) kggugdpVar).nmpwovh(kggugdpVar.getString(R.string.log_parts_erase_start, ohwxijwVar.nmpwovh));
                    kggugdpVar.slxntng.execute(new hhqpjvl(kggugdpVar, (Object) ohwxijwVar, kggugdpVar.yjbrzgu("da_path"), kggugdpVar.yjbrzgu("auth_path"), kggugdpVar.yjbrzgu("preloader_path"), 4));
                }
                break;
            case 1:
                kggugdp kggugdpVar2 = (kggugdp) this.lthborb;
                kggugdpVar2.getClass();
                EditText editText2 = (EditText) this.ojyssqt;
                if (!"FLASH".equals(editText2.getText().toString().trim())) {
                    editText2.setError(kggugdpVar2.getString(R.string.scatter_confirm_type_error));
                } else {
                    ((AlertDialog) this.vivhedu).dismiss();
                    kggugdpVar2.zzqmpyp((String) this.qxvquar);
                }
                break;
            default:
                ((Dialog) this.lthborb).dismiss();
                Context context = (Context) this.qxvquar;
                Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(1);
                dialog.setCancelable(true);
                ScrollView scrollView2 = new ScrollView(context);
                scrollView2.setFillViewport(true);
                LinearLayout linearLayoutVopsyhw = zamkzqg.vopsyhw(context, zamkzqg.cgcdpmq(context, 22));
                scrollView2.addView(linearLayoutVopsyhw, new FrameLayout.LayoutParams(-1, -2));
                boolean zEqualsIgnoreCase = "DA".equalsIgnoreCase((String) this.ojyssqt);
                int i3 = zEqualsIgnoreCase ? R.string.sla_da_form_title : R.string.sla_brom_form_title;
                int i4 = zEqualsIgnoreCase ? R.string.sla_da_form_message : R.string.sla_brom_form_message;
                int i5 = zEqualsIgnoreCase ? R.string.sla_da_about_title : R.string.sla_brom_about_title;
                int i6 = zEqualsIgnoreCase ? R.string.sla_da_about_message : R.string.sla_brom_about_message;
                TextView textViewMwngani = zamkzqg.mwngani(context, context.getString(i3), 21.0f, true, zamkzqg.zngzleo(context));
                zamkzqg.enxkjpu(context, textViewMwngani, R.drawable.ic_lock, zamkzqg.nmpwovh(context));
                linearLayoutVopsyhw.addView(textViewMwngani, zamkzqg.ankiohq());
                View viewMwngani = zamkzqg.mwngani(context, context.getString(i4), 14.0f, false, zamkzqg.jbmzxye(context));
                LinearLayout.LayoutParams layoutParamsAnkiohq = zamkzqg.ankiohq();
                layoutParamsAnkiohq.topMargin = zamkzqg.cgcdpmq(context, 8);
                linearLayoutVopsyhw.addView(viewMwngani, layoutParamsAnkiohq);
                TextView textViewMwngani2 = zamkzqg.mwngani(context, context.getString(R.string.sla_server_credentials), 12.0f, true, zamkzqg.nmpwovh(context));
                textViewMwngani2.setAllCaps(true);
                LinearLayout.LayoutParams layoutParamsAnkiohq2 = zamkzqg.ankiohq();
                layoutParamsAnkiohq2.topMargin = zamkzqg.cgcdpmq(context, 20);
                linearLayoutVopsyhw.addView(textViewMwngani2, layoutParamsAnkiohq2);
                View viewIoxmphz = zamkzqg.ioxmphz(context, R.string.sla_username, false);
                LinearLayout.LayoutParams layoutParamsAnkiohq3 = zamkzqg.ankiohq();
                layoutParamsAnkiohq3.topMargin = zamkzqg.cgcdpmq(context, 10);
                linearLayoutVopsyhw.addView(viewIoxmphz, layoutParamsAnkiohq3);
                LinearLayout linearLayoutGefzxcg = zamkzqg.gefzxcg(context);
                linearLayoutGefzxcg.setPadding(0, 0, 0, 0);
                linearLayoutGefzxcg.setBackground(zamkzqg.jvtqflj(context, zamkzqg.atntgcp(context), zamkzqg.slxntng(context), zamkzqg.qunltjs(context, 14)));
                LinearLayout.LayoutParams layoutParamsAnkiohq4 = zamkzqg.ankiohq();
                layoutParamsAnkiohq4.topMargin = zamkzqg.cgcdpmq(context, 10);
                linearLayoutVopsyhw.addView(linearLayoutGefzxcg, layoutParamsAnkiohq4);
                EditText editTextIoxmphz = zamkzqg.ioxmphz(context, R.string.sla_password, true);
                editTextIoxmphz.setBackgroundColor(context.getColor(R.color.rynx_transparent));
                linearLayoutGefzxcg.addView(editTextIoxmphz, new LinearLayout.LayoutParams(0, -2, 1.0f));
                TextView textViewMwngani3 = zamkzqg.mwngani(context, context.getString(R.string.sla_show), 12.0f, true, zamkzqg.nmpwovh(context));
                textViewMwngani3.setGravity(17);
                textViewMwngani3.setPadding(zamkzqg.cgcdpmq(context, 12), zamkzqg.cgcdpmq(context, 10), zamkzqg.cgcdpmq(context, 14), zamkzqg.cgcdpmq(context, 10));
                linearLayoutGefzxcg.addView(textViewMwngani3, new LinearLayout.LayoutParams(-2, -1));
                textViewMwngani3.setOnClickListener(new czqxnxv(new boolean[]{false}, editTextIoxmphz, textViewMwngani3, 0));
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                int iCgcdpmq = zamkzqg.cgcdpmq(context, 14);
                linearLayout.setPadding(iCgcdpmq, iCgcdpmq, iCgcdpmq, iCgcdpmq);
                linearLayout.setBackground(zamkzqg.jvtqflj(context, zamkzqg.atntgcp(context), zamkzqg.slxntng(context), zamkzqg.qunltjs(context, 14)));
                LinearLayout.LayoutParams layoutParamsAnkiohq5 = zamkzqg.ankiohq();
                layoutParamsAnkiohq5.topMargin = zamkzqg.cgcdpmq(context, 18);
                linearLayoutVopsyhw.addView(linearLayout, layoutParamsAnkiohq5);
                TextView textViewMwngani4 = zamkzqg.mwngani(context, context.getString(i5), 13.0f, true, zamkzqg.nmpwovh(context));
                zamkzqg.enxkjpu(context, textViewMwngani4, R.drawable.ic_info, zamkzqg.nmpwovh(context));
                linearLayout.addView(textViewMwngani4, zamkzqg.ankiohq());
                TextView textViewMwngani5 = zamkzqg.mwngani(context, context.getString(i6), 12.5f, false, zamkzqg.jbmzxye(context));
                LinearLayout.LayoutParams layoutParamsAnkiohq6 = zamkzqg.ankiohq();
                layoutParamsAnkiohq6.topMargin = zamkzqg.cgcdpmq(context, 5);
                linearLayout.addView(textViewMwngani5, layoutParamsAnkiohq6);
                LinearLayout linearLayoutGefzxcg2 = zamkzqg.gefzxcg(context);
                LinearLayout.LayoutParams layoutParamsAnkiohq7 = zamkzqg.ankiohq();
                layoutParamsAnkiohq7.topMargin = zamkzqg.cgcdpmq(context, 20);
                linearLayoutVopsyhw.addView(linearLayoutGefzxcg2, layoutParamsAnkiohq7);
                TextView textViewLthborb = zamkzqg.lthborb(context, R.string.action_cancel, false);
                TextView textViewLthborb2 = zamkzqg.lthborb(context, R.string.sla_authorize, true);
                zamkzqg.enxkjpu(context, textViewLthborb2, R.drawable.ic_lock, zamkzqg.gucwjqz(context));
                linearLayoutGefzxcg2.addView(textViewLthborb, zamkzqg.yomtcav());
                LinearLayout.LayoutParams layoutParamsYomtcav = zamkzqg.yomtcav();
                layoutParamsYomtcav.leftMargin = zamkzqg.cgcdpmq(context, 10);
                linearLayoutGefzxcg2.addView(textViewLthborb2, layoutParamsYomtcav);
                TextView textViewMwngani6 = zamkzqg.mwngani(context, context.getString(R.string.sla_security_note), 11.5f, false, zamkzqg.jbmzxye(context));
                zamkzqg.enxkjpu(context, textViewMwngani6, R.drawable.ic_lock, zamkzqg.jbmzxye(context));
                LinearLayout.LayoutParams layoutParamsAnkiohq8 = zamkzqg.ankiohq();
                layoutParamsAnkiohq8.topMargin = zamkzqg.cgcdpmq(context, 14);
                linearLayoutVopsyhw.addView(textViewMwngani6, layoutParamsAnkiohq8);
                sfildfy sfildfyVar = (sfildfy) this.vivhedu;
                textViewLthborb.setOnClickListener(new otaqyat(dialog, sfildfyVar, 1));
                textViewLthborb2.setOnClickListener(new bwvplah(viewIoxmphz, editTextIoxmphz, context, dialog, sfildfyVar, 2));
                dialog.setOnCancelListener(new wdvdxhb(sfildfyVar, 0));
                zamkzqg.ekyqleu(dialog, scrollView2);
                viewIoxmphz.requestFocus();
                Window window = dialog.getWindow();
                if (window != null) {
                    window.clearFlags(8192);
                    window.setSoftInputMode(21);
                }
                viewIoxmphz.postDelayed(new atntgcp(context, viewIoxmphz, 5), 120L);
                break;
        }
    }

    public /* synthetic */ dkpobjg(AlertDialog alertDialog, EditText editText, kggugdp kggugdpVar, ohwxijw ohwxijwVar) {
        this.nmpwovh = 0;
        this.lthborb = kggugdpVar;
        this.qxvquar = ohwxijwVar;
        this.ojyssqt = editText;
        this.vivhedu = alertDialog;
    }

    public /* synthetic */ dkpobjg(Dialog dialog, Context context, String str, ednetju ednetjuVar, sfildfy sfildfyVar) {
        this.nmpwovh = 0;
        this.lthborb = dialog;
        this.qxvquar = context;
        this.ojyssqt = str;
        this.vivhedu = sfildfyVar;
    }
}
