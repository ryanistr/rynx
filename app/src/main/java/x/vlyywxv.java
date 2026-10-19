package x;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.rynx.app.R;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class vlyywxv {
    public static final int[] sthdtww = {R.string.xiaomi_auth_progress_step_credit, R.string.xiaomi_auth_progress_step_challenge, R.string.xiaomi_auth_progress_step_server, R.string.xiaomi_auth_progress_step_device};
    public final TextView atntgcp;
    public ValueAnimator bgmsltp;
    public final View[] buswjhz;
    public final TextView czidoiw;
    public final TextView dasxvpc;
    public final TextView dplrlfq;
    public final TextView dytyqos;
    public final TextView ekyqleu;
    public final TextView gisppfs;
    public long gzokllk;
    public final TextView imuemzb;
    public final TextView jdqigmr;
    public final TextView lclupha;
    public boolean lpkdqgx;
    public final ArrayDeque lthborb;
    public final TextView nkemejx;
    public final com.rynx.app.nmpwovh nmpwovh;
    public String nsyqsfj;
    public final AlertDialog ojyssqt;
    public final TextView oqexvyb;
    public final TextView[] pvbzgon;
    public boolean pvkaerr;
    public zftrkmx qwgjehf;
    public final TextView qxvquar;
    public final TextView qyeibyo;
    public final TextView slxntng;
    public boolean uiqyzsp;
    public final TextView ulafhci;
    public final TextView[] utmeivs;
    public final nlcdwap vivhedu;
    public final ScrollView vntpaom;
    public boolean vopsyhw;
    public final TextView wqrnifx;
    public final Handler wygqgxb;
    public final gdkopre yjbrzgu;
    public final TextView zwaqeaz;

    public vlyywxv(com.rynx.app.nmpwovh nmpwovhVar, String str, final suqlntg suqlntgVar) {
        nlcdwap nlcdwapVar = new nlcdwap();
        nlcdwapVar.nmpwovh = "";
        nlcdwapVar.ojyssqt = "";
        nlcdwapVar.vivhedu = "";
        nlcdwapVar.lthborb = "";
        nlcdwapVar.qxvquar = "";
        nlcdwapVar.oqexvyb = "Preparing authorization";
        nlcdwapVar.nkemejx = "Checking account and server policy.";
        nlcdwapVar.ulafhci = "";
        nlcdwapVar.ekyqleu = "";
        nlcdwapVar.utmeivs = "";
        this.vivhedu = nlcdwapVar;
        this.lthborb = new ArrayDeque();
        this.utmeivs = new TextView[4];
        this.buswjhz = new View[3];
        this.pvbzgon = new TextView[4];
        this.nsyqsfj = "";
        this.wygqgxb = new Handler(Looper.getMainLooper());
        this.yjbrzgu = new gdkopre(this);
        this.nmpwovh = nmpwovhVar;
        nlcdwapVar.nkemejx(nmpwovhVar.getString(R.string.xiaomi_auth_progress_hero_preparing), nmpwovhVar.getString(R.string.xiaomi_auth_progress_status_preparing), nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_preparing));
        int iQunltjs = zamkzqg.qunltjs(nmpwovhVar, 18);
        LinearLayout linearLayoutXbdyiew = zamkzqg.xbdyiew(nmpwovhVar, 0);
        linearLayoutXbdyiew.setPadding(iQunltjs, zamkzqg.qunltjs(nmpwovhVar, 14), iQunltjs, zamkzqg.qunltjs(nmpwovhVar, 6));
        LinearLayout linearLayout = new LinearLayout(nmpwovhVar);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(48);
        LinearLayout linearLayoutXbdyiew2 = zamkzqg.xbdyiew(nmpwovhVar, 0);
        TextView textViewOxoagud = zamkzqg.oxoagud(nmpwovhVar, (str == null || str.trim().isEmpty()) ? nmpwovhVar.getString(R.string.xiaomi_authorize_title) : str.trim(), 10, zamkzqg.nmpwovh(nmpwovhVar), true);
        textViewOxoagud.setLetterSpacing(0.09f);
        linearLayoutXbdyiew2.addView(textViewOxoagud);
        TextView textViewOxoagud2 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_auth_progress_preparing_device), 18, zamkzqg.zngzleo(nmpwovhVar), true);
        this.qxvquar = textViewOxoagud2;
        textViewOxoagud2.setTextIsSelectable(true);
        textViewOxoagud2.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 2), 0, 0);
        linearLayoutXbdyiew2.addView(textViewOxoagud2);
        TextView textViewOxoagud3 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_auth_progress_waiting_profile), 11, zamkzqg.jbmzxye(nmpwovhVar), false);
        this.oqexvyb = textViewOxoagud3;
        textViewOxoagud3.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 1), 0, 0);
        linearLayoutXbdyiew2.addView(textViewOxoagud3);
        linearLayout.addView(linearLayoutXbdyiew2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textViewOxoagud4 = zamkzqg.oxoagud(nmpwovhVar, "", 9, zamkzqg.nmpwovh(nmpwovhVar), true);
        this.nkemejx = textViewOxoagud4;
        textViewOxoagud4.setGravity(17);
        textViewOxoagud4.setPadding(zamkzqg.qunltjs(nmpwovhVar, 9), zamkzqg.qunltjs(nmpwovhVar, 5), zamkzqg.qunltjs(nmpwovhVar, 9), zamkzqg.qunltjs(nmpwovhVar, 5));
        textViewOxoagud4.setBackground(zamkzqg.jvtqflj(nmpwovhVar, zamkzqg.atntgcp(nmpwovhVar), zamkzqg.nmpwovh(nmpwovhVar), zamkzqg.qunltjs(nmpwovhVar, 999)));
        textViewOxoagud4.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = zamkzqg.qunltjs(nmpwovhVar, 10);
        linearLayout.addView(textViewOxoagud4, layoutParams);
        linearLayoutXbdyiew.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(nmpwovhVar);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 14), 0, zamkzqg.qunltjs(nmpwovhVar, 10));
        TextView textViewOxoagud5 = zamkzqg.oxoagud(nmpwovhVar, "●", 22, zamkzqg.nmpwovh(nmpwovhVar), true);
        this.imuemzb = textViewOxoagud5;
        textViewOxoagud5.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(zamkzqg.qunltjs(nmpwovhVar, 30), zamkzqg.qunltjs(nmpwovhVar, 30));
        layoutParams2.rightMargin = zamkzqg.qunltjs(nmpwovhVar, 9);
        linearLayout2.addView(textViewOxoagud5, layoutParams2);
        LinearLayout linearLayoutXbdyiew3 = zamkzqg.xbdyiew(nmpwovhVar, 0);
        TextView textViewOxoagud6 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_auth_progress_hero_preparing), 9, zamkzqg.nmpwovh(nmpwovhVar), true);
        this.dytyqos = textViewOxoagud6;
        textViewOxoagud6.setLetterSpacing(0.09f);
        linearLayoutXbdyiew3.addView(textViewOxoagud6);
        TextView textViewOxoagud7 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_auth_progress_status_preparing), 19, zamkzqg.zngzleo(nmpwovhVar), true);
        this.wqrnifx = textViewOxoagud7;
        textViewOxoagud7.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 1), 0, 0);
        linearLayoutXbdyiew3.addView(textViewOxoagud7);
        TextView textViewOxoagud8 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_preparing), 11, zamkzqg.jbmzxye(nmpwovhVar), false);
        this.dasxvpc = textViewOxoagud8;
        textViewOxoagud8.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 3), 0, 0);
        linearLayoutXbdyiew3.addView(textViewOxoagud8);
        linearLayout2.addView(linearLayoutXbdyiew3, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayoutXbdyiew.addView(linearLayout2);
        TextView textViewOxoagud9 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_auth_progress_credit_unknown), 11, zamkzqg.zngzleo(nmpwovhVar), true);
        this.ulafhci = textViewOxoagud9;
        textViewOxoagud9.setPadding(zamkzqg.qunltjs(nmpwovhVar, 2), zamkzqg.qunltjs(nmpwovhVar, 2), zamkzqg.qunltjs(nmpwovhVar, 2), zamkzqg.qunltjs(nmpwovhVar, 11));
        linearLayoutXbdyiew.addView(textViewOxoagud9);
        TextView textViewOxoagud10 = zamkzqg.oxoagud(nmpwovhVar, nlcdwapVar.lthborb(), 1, 0, false);
        this.dplrlfq = textViewOxoagud10;
        textViewOxoagud10.setVisibility(8);
        linearLayoutXbdyiew.addView(textViewOxoagud10, new LinearLayout.LayoutParams(1, 1));
        TextView textViewOxoagud11 = zamkzqg.oxoagud(nmpwovhVar, "", 10, zamkzqg.jbmzxye(nmpwovhVar), true);
        this.ekyqleu = textViewOxoagud11;
        textViewOxoagud11.setPadding(zamkzqg.qunltjs(nmpwovhVar, 2), 0, zamkzqg.qunltjs(nmpwovhVar, 2), zamkzqg.qunltjs(nmpwovhVar, 10));
        textViewOxoagud11.setVisibility(8);
        linearLayoutXbdyiew.addView(textViewOxoagud11);
        LinearLayout linearLayoutXbdyiew4 = zamkzqg.xbdyiew(nmpwovhVar, 0);
        LinearLayout linearLayout3 = new LinearLayout(nmpwovhVar);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        for (int i = 0; i < this.utmeivs.length; i++) {
            TextView textViewOxoagud12 = zamkzqg.oxoagud(nmpwovhVar, "", 7, zamkzqg.gucwjqz(nmpwovhVar), true);
            textViewOxoagud12.setGravity(17);
            this.utmeivs[i] = textViewOxoagud12;
            linearLayout3.addView(textViewOxoagud12, new LinearLayout.LayoutParams(zamkzqg.qunltjs(nmpwovhVar, 13), zamkzqg.qunltjs(nmpwovhVar, 13)));
            if (i < this.buswjhz.length) {
                View view = new View(nmpwovhVar);
                this.buswjhz[i] = view;
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, zamkzqg.qunltjs(nmpwovhVar, 1), 1.0f);
                layoutParams3.leftMargin = zamkzqg.qunltjs(nmpwovhVar, 5);
                layoutParams3.rightMargin = zamkzqg.qunltjs(nmpwovhVar, 5);
                linearLayout3.addView(view, layoutParams3);
            }
        }
        linearLayoutXbdyiew4.addView(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(nmpwovhVar);
        linearLayout4.setOrientation(0);
        linearLayout4.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 5), 0, zamkzqg.qunltjs(nmpwovhVar, 10));
        int i2 = 0;
        for (int i3 = 4; i2 < i3; i3 = 4) {
            TextView textViewOxoagud13 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(sthdtww[i2]), 9, zamkzqg.jbmzxye(nmpwovhVar), i2 == 0);
            textViewOxoagud13.setGravity(i2 == 0 ? 8388611 : i2 == 3 ? 8388613 : 17);
            this.pvbzgon[i2] = textViewOxoagud13;
            linearLayout4.addView(textViewOxoagud13, new LinearLayout.LayoutParams(0, -2, 1.0f));
            i2++;
        }
        linearLayoutXbdyiew4.addView(linearLayout4);
        TextView textViewOxoagud14 = zamkzqg.oxoagud(nmpwovhVar, this.vivhedu.wqrnifx(), 1, 0, false);
        this.qyeibyo = textViewOxoagud14;
        textViewOxoagud14.setVisibility(8);
        linearLayoutXbdyiew4.addView(textViewOxoagud14, new LinearLayout.LayoutParams(1, 1));
        linearLayoutXbdyiew.addView(linearLayoutXbdyiew4);
        TextView textViewOxoagud15 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_auth_progress_hint), 10, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud15.setPadding(zamkzqg.qunltjs(nmpwovhVar, 2), 0, zamkzqg.qunltjs(nmpwovhVar, 2), zamkzqg.qunltjs(nmpwovhVar, 10));
        zamkzqg.enxkjpu(nmpwovhVar, textViewOxoagud15, R.drawable.ic_info, zamkzqg.jbmzxye(nmpwovhVar));
        linearLayoutXbdyiew.addView(textViewOxoagud15);
        LinearLayout linearLayoutXbdyiew5 = zamkzqg.xbdyiew(nmpwovhVar, zamkzqg.qunltjs(nmpwovhVar, 12));
        linearLayoutXbdyiew5.setBackground(zamkzqg.jvtqflj(nmpwovhVar, zamkzqg.atntgcp(nmpwovhVar), zamkzqg.atntgcp(nmpwovhVar), zamkzqg.qunltjs(nmpwovhVar, 14)));
        LinearLayout linearLayout5 = new LinearLayout(nmpwovhVar);
        linearLayout5.setOrientation(0);
        linearLayout5.setGravity(16);
        TextView textViewOxoagud16 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_auth_progress_live_log), 10, zamkzqg.nmpwovh(nmpwovhVar), true);
        textViewOxoagud16.setLetterSpacing(0.08f);
        linearLayout5.addView(textViewOxoagud16, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textViewOxoagud17 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_auth_progress_live), 9, zamkzqg.jbmzxye(nmpwovhVar), true);
        this.lclupha = textViewOxoagud17;
        linearLayout5.addView(textViewOxoagud17);
        linearLayoutXbdyiew5.addView(linearLayout5);
        ScrollView scrollView = new ScrollView(nmpwovhVar);
        this.vntpaom = scrollView;
        scrollView.setFillViewport(true);
        TextView textViewOxoagud18 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_auth_progress_waiting_events), 10, zamkzqg.zngzleo(nmpwovhVar), false);
        this.jdqigmr = textViewOxoagud18;
        Typeface typeface = Typeface.MONOSPACE;
        textViewOxoagud18.setTypeface(typeface);
        textViewOxoagud18.setTextIsSelectable(true);
        textViewOxoagud18.setLineSpacing(0.0f, 1.1f);
        textViewOxoagud18.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 7), 0, 0);
        scrollView.addView(textViewOxoagud18, new FrameLayout.LayoutParams(-1, -2));
        linearLayoutXbdyiew5.addView(scrollView, new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(nmpwovhVar, 190)));
        linearLayoutXbdyiew.addView(linearLayoutXbdyiew5);
        TextView textViewOxoagud19 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_auth_progress_details_collapsed), 11, zamkzqg.jbmzxye(nmpwovhVar), true);
        this.gisppfs = textViewOxoagud19;
        textViewOxoagud19.setGravity(16);
        textViewOxoagud19.setPadding(zamkzqg.qunltjs(nmpwovhVar, 2), zamkzqg.qunltjs(nmpwovhVar, 11), zamkzqg.qunltjs(nmpwovhVar, 2), zamkzqg.qunltjs(nmpwovhVar, 7));
        final int i4 = 0;
        textViewOxoagud19.setOnClickListener(new View.OnClickListener(this) { // from class: x.iqvvlnh
            public final /* synthetic */ vlyywxv ojyssqt;

            {
                this.ojyssqt = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws czgynww {
                switch (i4) {
                    case 0:
                        vlyywxv vlyywxvVar = this.ojyssqt;
                        vlyywxvVar.ekyqleu(!vlyywxvVar.vopsyhw);
                        break;
                    default:
                        vlyywxv vlyywxvVar2 = this.ojyssqt;
                        zftrkmx zftrkmxVar = vlyywxvVar2.qwgjehf;
                        if (zftrkmxVar != null && !vlyywxvVar2.pvkaerr) {
                            vlyywxvVar2.qwgjehf = null;
                            vlyywxvVar2.pvbzgon(true);
                            zftrkmxVar.run();
                        } else if (vlyywxvVar2.pvkaerr) {
                            ValueAnimator valueAnimator = vlyywxvVar2.bgmsltp;
                            if (valueAnimator != null) {
                                valueAnimator.cancel();
                                vlyywxvVar2.bgmsltp.removeAllUpdateListeners();
                                vlyywxvVar2.bgmsltp = null;
                            }
                            AlertDialog alertDialog = vlyywxvVar2.ojyssqt;
                            if (alertDialog.isShowing()) {
                                alertDialog.dismiss();
                            }
                        }
                        break;
                }
            }
        });
        linearLayoutXbdyiew.addView(textViewOxoagud19);
        TextView textViewOxoagud20 = zamkzqg.oxoagud(nmpwovhVar, "", 10, zamkzqg.zngzleo(nmpwovhVar), false);
        this.zwaqeaz = textViewOxoagud20;
        textViewOxoagud20.setTypeface(typeface);
        textViewOxoagud20.setTextIsSelectable(true);
        textViewOxoagud20.setLineSpacing(0.0f, 1.07f);
        textViewOxoagud20.setPadding(zamkzqg.qunltjs(nmpwovhVar, 10), zamkzqg.qunltjs(nmpwovhVar, 9), zamkzqg.qunltjs(nmpwovhVar, 10), zamkzqg.qunltjs(nmpwovhVar, 9));
        textViewOxoagud20.setBackground(zamkzqg.jvtqflj(nmpwovhVar, zamkzqg.atntgcp(nmpwovhVar), zamkzqg.slxntng(nmpwovhVar), zamkzqg.qunltjs(nmpwovhVar, 12)));
        textViewOxoagud20.setVisibility(8);
        linearLayoutXbdyiew.addView(textViewOxoagud20);
        ScrollView scrollView2 = new ScrollView(nmpwovhVar);
        scrollView2.setFillViewport(false);
        scrollView2.setClipToPadding(false);
        scrollView2.addView(linearLayoutXbdyiew, new FrameLayout.LayoutParams(-1, -2));
        int iMin = Math.min(zamkzqg.qunltjs(nmpwovhVar, 560), Math.max(zamkzqg.qunltjs(nmpwovhVar, 390), (int) (nmpwovhVar.getResources().getDisplayMetrics().heightPixels * 0.66f)));
        LinearLayout linearLayoutXbdyiew6 = zamkzqg.xbdyiew(nmpwovhVar, 0);
        linearLayoutXbdyiew6.setBackground(zamkzqg.jvtqflj(nmpwovhVar, zamkzqg.czidoiw(nmpwovhVar), zamkzqg.slxntng(nmpwovhVar), zamkzqg.qunltjs(nmpwovhVar, 22)));
        linearLayoutXbdyiew6.addView(scrollView2, new LinearLayout.LayoutParams(-1, iMin));
        LinearLayout linearLayout6 = new LinearLayout(nmpwovhVar);
        linearLayout6.setOrientation(0);
        linearLayout6.setGravity(8388629);
        linearLayout6.setPadding(iQunltjs, zamkzqg.qunltjs(nmpwovhVar, 5), iQunltjs, zamkzqg.qunltjs(nmpwovhVar, 11));
        TextView textViewNmpwovh = nmpwovh(R.string.xiaomi_auth_progress_stop, false);
        this.atntgcp = textViewNmpwovh;
        TextView textViewNmpwovh2 = nmpwovh(R.string.xiaomi_auth_progress_retry, false);
        this.slxntng = textViewNmpwovh2;
        TextView textViewNmpwovh3 = nmpwovh(R.string.xiaomi_auth_progress_close, true);
        this.czidoiw = textViewNmpwovh3;
        final int i5 = 0;
        textViewNmpwovh.setOnClickListener(new View.OnClickListener(this) { // from class: x.qdiugcp
            public final /* synthetic */ vlyywxv ojyssqt;

            {
                this.ojyssqt = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i5) {
                    case 0:
                        vlyywxv vlyywxvVar = this.ojyssqt;
                        if (!vlyywxvVar.pvkaerr && !vlyywxvVar.uiqyzsp) {
                            suqlntgVar.nkemejx();
                            break;
                        }
                        break;
                    default:
                        vlyywxv vlyywxvVar2 = this.ojyssqt;
                        suqlntg suqlntgVar2 = suqlntgVar;
                        if (vlyywxvVar2.pvkaerr && vlyywxvVar2.lpkdqgx && suqlntgVar2.nmpwovh == ((com.rynx.app.nmpwovh) suqlntgVar2.ojyssqt).zsbaukl) {
                            vlyywxv vlyywxvVar3 = ((com.rynx.app.nmpwovh) suqlntgVar2.ojyssqt).zwccvwt;
                            if (vlyywxvVar3 != null) {
                                ValueAnimator valueAnimator = vlyywxvVar3.bgmsltp;
                                if (valueAnimator != null) {
                                    valueAnimator.cancel();
                                    vlyywxvVar3.bgmsltp.removeAllUpdateListeners();
                                    vlyywxvVar3.bgmsltp = null;
                                }
                                AlertDialog alertDialog = vlyywxvVar3.ojyssqt;
                                if (alertDialog.isShowing()) {
                                    alertDialog.dismiss();
                                }
                            }
                            com.rynx.app.nmpwovh nmpwovhVar2 = (com.rynx.app.nmpwovh) suqlntgVar2.ojyssqt;
                            nmpwovhVar2.zwccvwt = null;
                            nmpwovhVar2.suqlntg();
                            break;
                        }
                        break;
                }
            }
        });
        final int i6 = 1;
        textViewNmpwovh2.setOnClickListener(new View.OnClickListener(this) { // from class: x.qdiugcp
            public final /* synthetic */ vlyywxv ojyssqt;

            {
                this.ojyssqt = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i6) {
                    case 0:
                        vlyywxv vlyywxvVar = this.ojyssqt;
                        if (!vlyywxvVar.pvkaerr && !vlyywxvVar.uiqyzsp) {
                            suqlntgVar.nkemejx();
                            break;
                        }
                        break;
                    default:
                        vlyywxv vlyywxvVar2 = this.ojyssqt;
                        suqlntg suqlntgVar2 = suqlntgVar;
                        if (vlyywxvVar2.pvkaerr && vlyywxvVar2.lpkdqgx && suqlntgVar2.nmpwovh == ((com.rynx.app.nmpwovh) suqlntgVar2.ojyssqt).zsbaukl) {
                            vlyywxv vlyywxvVar3 = ((com.rynx.app.nmpwovh) suqlntgVar2.ojyssqt).zwccvwt;
                            if (vlyywxvVar3 != null) {
                                ValueAnimator valueAnimator = vlyywxvVar3.bgmsltp;
                                if (valueAnimator != null) {
                                    valueAnimator.cancel();
                                    vlyywxvVar3.bgmsltp.removeAllUpdateListeners();
                                    vlyywxvVar3.bgmsltp = null;
                                }
                                AlertDialog alertDialog = vlyywxvVar3.ojyssqt;
                                if (alertDialog.isShowing()) {
                                    alertDialog.dismiss();
                                }
                            }
                            com.rynx.app.nmpwovh nmpwovhVar2 = (com.rynx.app.nmpwovh) suqlntgVar2.ojyssqt;
                            nmpwovhVar2.zwccvwt = null;
                            nmpwovhVar2.suqlntg();
                            break;
                        }
                        break;
                }
            }
        });
        textViewNmpwovh3.setOnClickListener(new View.OnClickListener(this) { // from class: x.iqvvlnh
            public final /* synthetic */ vlyywxv ojyssqt;

            {
                this.ojyssqt = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws czgynww {
                switch (i6) {
                    case 0:
                        vlyywxv vlyywxvVar = this.ojyssqt;
                        vlyywxvVar.ekyqleu(!vlyywxvVar.vopsyhw);
                        break;
                    default:
                        vlyywxv vlyywxvVar2 = this.ojyssqt;
                        zftrkmx zftrkmxVar = vlyywxvVar2.qwgjehf;
                        if (zftrkmxVar != null && !vlyywxvVar2.pvkaerr) {
                            vlyywxvVar2.qwgjehf = null;
                            vlyywxvVar2.pvbzgon(true);
                            zftrkmxVar.run();
                        } else if (vlyywxvVar2.pvkaerr) {
                            ValueAnimator valueAnimator = vlyywxvVar2.bgmsltp;
                            if (valueAnimator != null) {
                                valueAnimator.cancel();
                                vlyywxvVar2.bgmsltp.removeAllUpdateListeners();
                                vlyywxvVar2.bgmsltp = null;
                            }
                            AlertDialog alertDialog = vlyywxvVar2.ojyssqt;
                            if (alertDialog.isShowing()) {
                                alertDialog.dismiss();
                            }
                        }
                        break;
                }
            }
        });
        linearLayout6.addView(textViewNmpwovh, ojyssqt(false));
        linearLayout6.addView(textViewNmpwovh2, ojyssqt(false));
        linearLayout6.addView(textViewNmpwovh3, ojyssqt(true));
        linearLayoutXbdyiew6.addView(linearLayout6, new LinearLayout.LayoutParams(-1, -2));
        AlertDialog alertDialogCreate = new AlertDialog.Builder(nmpwovhVar).setView(linearLayoutXbdyiew6).create();
        this.ojyssqt = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setCancelable(true);
        alertDialogCreate.setOnCancelListener(new aylswsn(this, suqlntgVar, 1));
        alertDialogCreate.setOnDismissListener(new nauykcf(this, 1));
        alertDialogCreate.show();
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(Math.max(zamkzqg.qunltjs(nmpwovhVar, 300), Math.min(nmpwovhVar.getResources().getDisplayMetrics().widthPixels - zamkzqg.qunltjs(nmpwovhVar, 28), zamkzqg.qunltjs(nmpwovhVar, 520))), -2);
            window.setDimAmount(0.52f);
        }
        qxvquar();
        dytyqos();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:39:0x0096  */
    /* JADX WARN: Code duplicated, block: B:4:0x0035  */
    /* JADX WARN: Code duplicated, block: B:71:0x00df  */
    /* JADX WARN: Code duplicated, block: B:94:0x0187  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    public final void buswjhz(String str) {
        boolean z;
        int r16;
        String string;
        nlcdwap nlcdwapVar = this.vivhedu;
        String strOqexvyb = nlcdwap.oqexvyb(str);
        Locale locale = Locale.ROOT;
        String lowerCase = strOqexvyb.toLowerCase(locale);
        nlcdwapVar.lthborb = lowerCase;
        nlcdwapVar.buswjhz = false;
        nlcdwapVar.pvbzgon = false;
        lowerCase.getClass();
        String str2 = "Waiting for signer";
        String str3 = "Authorization in progress";
        switch (lowerCase) {
            case "expired":
                z = true;
                nlcdwapVar.oqexvyb = "Authorization expired";
                nlcdwapVar.nkemejx = "The server result expired before completion.";
                nlcdwapVar.buswjhz = true;
                break;
            case "failed":
                nlcdwapVar.oqexvyb = "Authorization failed";
                nlcdwapVar.nkemejx = "The server marked this authorization as failed.";
                z = true;
                nlcdwapVar.buswjhz = true;
                break;
            case "queued":
                nlcdwapVar.oqexvyb = "Waiting for signer";
                nlcdwapVar.nkemejx = "The server accepted this job and queued it for authorization.";
                z = true;
                break;
            case "ready":
                nlcdwapVar.oqexvyb = "Response ready";
                nlcdwapVar.nkemejx = "The server returned an authorization response. Preparing device delivery.";
                z = true;
                break;
            case "upstream_dispatched":
                nlcdwapVar.oqexvyb = "Contacting authorization server";
                nlcdwapVar.nkemejx = "The request was dispatched upstream. Do not resubmit this challenge.";
                z = true;
                break;
            case "running":
                nlcdwapVar.oqexvyb = "Authorization in progress";
                nlcdwapVar.nkemejx = "The same server job is still being processed.";
                z = true;
                break;
            case "review_required":
                nlcdwapVar.oqexvyb = "Authorization needs review";
                nlcdwapVar.nkemejx = "The upstream result is uncertain and needs manual review.";
                z = true;
                nlcdwapVar.buswjhz = true;
                break;
            default:
                if (!nlcdwapVar.lthborb.isEmpty()) {
                    String lowerCase2 = nlcdwap.oqexvyb(nlcdwapVar.lthborb).toLowerCase(locale);
                    lowerCase2.getClass();
                    switch (lowerCase2) {
                        case "expired":
                            str2 = "Expired";
                            break;
                        case "failed":
                            str2 = "Failed";
                            break;
                        case "queued":
                            break;
                        case "ready":
                            str2 = "Response ready";
                            break;
                        case "upstream_dispatched":
                            str2 = "Contacting authorization server";
                            break;
                        case "running":
                            str2 = "Authorization in progress";
                            break;
                        case "review_required":
                            str2 = "Manual review required";
                            break;
                        default:
                            if (lowerCase2.isEmpty()) {
                                str2 = "Authorization in progress";
                                break;
                            } else {
                                String strReplace = lowerCase2.replace('_', ' ');
                                str2 = Character.toUpperCase(strReplace.charAt(0)) + strReplace.substring(1);
                                break;
                            }
                            break;
                    }
                    str3 = str2;
                }
                nlcdwapVar.oqexvyb = str3;
                nlcdwapVar.nkemejx = nlcdwapVar.lthborb.isEmpty() ? "Waiting for the next server state." : "Server phase: " + nlcdwapVar.lthborb;
                z = true;
                break;
        }
        String str4 = nlcdwapVar.lthborb;
        str4.getClass();
        com.rynx.app.nmpwovh nmpwovhVar = this.nmpwovh;
        int i = R.string.xiaomi_auth_progress_hero_authorizing;
        int i2 = R.string.xiaomi_auth_progress_status_authorizing;
        switch (str4.hashCode()) {
            case -1309235419:
                if (!str4.equals("expired")) {
                    r16 = -1;
                } else {
                    r16 = 0;
                }
                break;
            case -1281977283:
                if (!str4.equals("failed")) {
                    r16 = -1;
                } else {
                    r16 = z;
                }
                break;
            case -948696717:
                if (!str4.equals("queued")) {
                    r16 = -1;
                } else {
                    r16 = 2;
                }
                break;
            case 108386723:
                if (!str4.equals("ready")) {
                    r16 = -1;
                } else {
                    r16 = 3;
                }
                break;
            case 808455037:
                if (!str4.equals("upstream_dispatched")) {
                    r16 = -1;
                } else {
                    r16 = 4;
                }
                break;
            case 1550783935:
                if (!str4.equals("running")) {
                    r16 = -1;
                } else {
                    r16 = 5;
                }
                break;
            case 1925982374:
                if (!str4.equals("review_required")) {
                    r16 = -1;
                } else {
                    r16 = 6;
                }
                break;
            default:
                r16 = -1;
                break;
        }
        switch (r16) {
            case 0:
                string = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_expired);
                i = R.string.xiaomi_auth_progress_hero_expired;
                i2 = R.string.xiaomi_auth_progress_status_expired;
                break;
            case 1:
                string = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_server_failed);
                i = R.string.xiaomi_auth_progress_hero_failed;
                i2 = R.string.xiaomi_auth_progress_status_failed;
                break;
            case 2:
                string = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_queued);
                i2 = R.string.xiaomi_auth_progress_status_waiting_signer;
                break;
            case 3:
                string = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_ready);
                i = R.string.xiaomi_auth_progress_hero_device_verification;
                i2 = R.string.xiaomi_auth_progress_status_response_ready;
                break;
            case 4:
                string = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_upstream);
                i2 = R.string.xiaomi_auth_progress_status_contacting_server;
                break;
            case 5:
                string = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_running);
                break;
            case 6:
                string = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_review);
                i = R.string.xiaomi_auth_progress_hero_review;
                i2 = R.string.xiaomi_auth_progress_status_review;
                break;
            default:
                string = !nlcdwapVar.lthborb.isEmpty() ? nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_server_phase, nlcdwapVar.lthborb) : nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_waiting_state);
                break;
        }
        nlcdwapVar.nkemejx(nmpwovhVar.getString(i), nmpwovhVar.getString(i2), string);
        qxvquar();
    }

    public final void dasxvpc(String str) {
        nlcdwap nlcdwapVar = this.vivhedu;
        nlcdwapVar.lthborb = "bypass";
        nlcdwapVar.oqexvyb = "Remote authorization not required";
        nlcdwapVar.nkemejx = nlcdwap.oqexvyb(str);
        nlcdwapVar.buswjhz = true;
        nlcdwapVar.pvbzgon = true;
        com.rynx.app.nmpwovh nmpwovhVar = this.nmpwovh;
        String string = nmpwovhVar.getString(R.string.xiaomi_auth_progress_hero_bypass);
        String string2 = nmpwovhVar.getString(R.string.xiaomi_auth_progress_status_bypass);
        if (str == null || str.trim().isEmpty()) {
            str = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_bypass);
        }
        nlcdwapVar.nkemejx(string, string2, str);
        this.pvkaerr = true;
        this.uiqyzsp = true;
        this.qwgjehf = null;
        lthborb(false);
        qxvquar();
    }

    public final void dplrlfq() {
        nlcdwap nlcdwapVar = this.vivhedu;
        nlcdwapVar.qyeibyo = true;
        nlcdwapVar.vntpaom = true;
        nlcdwapVar.jdqigmr = true;
        nlcdwapVar.oqexvyb = "Device challenge received";
        nlcdwapVar.nkemejx = "Submitting this live challenge to the existing authorization attempt.";
        com.rynx.app.nmpwovh nmpwovhVar = this.nmpwovh;
        nlcdwapVar.nkemejx(nmpwovhVar.getString(R.string.xiaomi_auth_progress_hero_challenge_ready), nmpwovhVar.getString(R.string.xiaomi_auth_progress_status_challenge_received), nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_challenge_received));
        qxvquar();
    }

    public final void dytyqos() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.lthborb) {
            if (sb.length() != 0) {
                sb.append('\n');
            }
            sb.append(str);
        }
        this.jdqigmr.setText(sb.length() == 0 ? this.nmpwovh.getString(R.string.xiaomi_auth_progress_waiting_events) : sb.toString());
        this.vntpaom.post(new eigllth(this, 6));
    }

    public final void ekyqleu(boolean z) {
        this.vopsyhw = z;
        this.gisppfs.setText(z ? R.string.xiaomi_auth_progress_details_expanded : R.string.xiaomi_auth_progress_details_collapsed);
        this.zwaqeaz.setVisibility(z ? 0 : 8);
        if (z) {
            nkemejx();
        }
    }

    public final void imuemzb() {
        long j = this.gzokllk;
        long jMax = j <= 0 ? -1L : Math.max(0L, j - Math.max(0L, System.currentTimeMillis() / 1000));
        Handler handler = this.wygqgxb;
        TextView textView = this.ekyqleu;
        gdkopre gdkopreVar = this.yjbrzgu;
        if (jMax < 0 || this.pvkaerr) {
            textView.setVisibility(8);
            handler.removeCallbacks(gdkopreVar);
            return;
        }
        textView.setVisibility(0);
        com.rynx.app.nmpwovh nmpwovhVar = this.nmpwovh;
        if (jMax == 0) {
            textView.setText(R.string.xiaomi_auth_progress_reservation_expired);
            textView.setTextColor(zamkzqg.pzqxblc(nmpwovhVar));
            handler.removeCallbacks(gdkopreVar);
        } else {
            long jMax2 = Math.max(0L, jMax);
            long j2 = jMax2 / 3600;
            long j3 = (jMax2 % 3600) / 60;
            long j4 = jMax2 % 60;
            textView.setText(nmpwovhVar.getString(R.string.xiaomi_auth_progress_reservation_expires, j2 > 0 ? String.format(Locale.ROOT, "%d:%02d:%02d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)) : String.format(Locale.ROOT, "%02d:%02d", Long.valueOf(j3), Long.valueOf(j4))));
            textView.setTextColor(jMax <= 60 ? zamkzqg.ohwxijw(nmpwovhVar) : zamkzqg.jbmzxye(nmpwovhVar));
        }
    }

    public final void lthborb(boolean z) {
        this.lpkdqgx = z;
        AlertDialog alertDialog = this.ojyssqt;
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        oqexvyb();
    }

    public final void nkemejx() {
        if (this.vopsyhw) {
            StringBuilder sb = new StringBuilder();
            nlcdwap nlcdwapVar = this.vivhedu;
            if (!nlcdwapVar.imuemzb().isEmpty()) {
                sb.append("Job: ");
                sb.append(nlcdwapVar.imuemzb());
            }
            if (!nlcdwapVar.vivhedu.isEmpty() && !nlcdwapVar.vivhedu.equals(nlcdwapVar.imuemzb())) {
                nlcdwap.nmpwovh(sb, "Full job: " + nlcdwapVar.vivhedu);
            }
            if (!nlcdwapVar.lthborb.isEmpty()) {
                nlcdwap.nmpwovh(sb, "Raw phase: " + nlcdwapVar.lthborb);
            }
            if (!nlcdwapVar.utmeivs.isEmpty()) {
                nlcdwap.nmpwovh(sb, "Error: " + nlcdwapVar.utmeivs);
            }
            if (!nlcdwapVar.ulafhci.isEmpty()) {
                nlcdwap.nmpwovh(sb, "Provider HTTP: " + nlcdwapVar.ulafhci);
            }
            if (!nlcdwapVar.ekyqleu.isEmpty()) {
                nlcdwap.nmpwovh(sb, "Provider raw:");
                sb.append(nlcdwapVar.ekyqleu);
            }
            String string = sb.toString();
            if (string.isEmpty()) {
                string = this.nmpwovh.getString(R.string.xiaomi_auth_progress_no_details);
            }
            this.zwaqeaz.setText(string);
        }
    }

    public final TextView nmpwovh(int i, boolean z) {
        com.rynx.app.nmpwovh nmpwovhVar = this.nmpwovh;
        TextView textViewIasgsgq = zamkzqg.iasgsgq(nmpwovhVar, i, 12, z ? zamkzqg.gucwjqz(nmpwovhVar) : zamkzqg.zngzleo(nmpwovhVar));
        textViewIasgsgq.setGravity(17);
        textViewIasgsgq.setMinWidth(zamkzqg.qunltjs(nmpwovhVar, 82));
        textViewIasgsgq.setPadding(zamkzqg.qunltjs(nmpwovhVar, 15), 0, zamkzqg.qunltjs(nmpwovhVar, 15), 0);
        textViewIasgsgq.setBackground(zamkzqg.jvtqflj(nmpwovhVar, z ? zamkzqg.nmpwovh(nmpwovhVar) : zamkzqg.atntgcp(nmpwovhVar), z ? zamkzqg.nmpwovh(nmpwovhVar) : zamkzqg.slxntng(nmpwovhVar), zamkzqg.qunltjs(nmpwovhVar, 999)));
        return textViewIasgsgq;
    }

    public final LinearLayout.LayoutParams ojyssqt(boolean z) {
        com.rynx.app.nmpwovh nmpwovhVar = this.nmpwovh;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, zamkzqg.qunltjs(nmpwovhVar, 40));
        layoutParams.leftMargin = zamkzqg.qunltjs(nmpwovhVar, z ? 9 : 5);
        return layoutParams;
    }

    public final void oqexvyb() {
        boolean z = this.pvkaerr;
        TextView textView = this.slxntng;
        TextView textView2 = this.atntgcp;
        TextView textView3 = this.czidoiw;
        if (z) {
            textView2.setVisibility(8);
            textView.setVisibility(this.lpkdqgx ? 0 : 8);
            textView3.setVisibility(0);
            textView3.setText(R.string.xiaomi_auth_progress_close);
            wqrnifx(textView3, true, true);
            wqrnifx(textView, this.lpkdqgx, false);
            return;
        }
        textView.setVisibility(8);
        textView2.setVisibility(this.uiqyzsp ? 8 : 0);
        wqrnifx(textView2, !this.uiqyzsp, false);
        if (this.qwgjehf == null) {
            textView3.setVisibility(8);
            return;
        }
        textView3.setVisibility(0);
        textView3.setText(R.string.xiaomi_new_security_confirm_action);
        wqrnifx(textView3, !this.uiqyzsp, true);
    }

    public final void pvbzgon(boolean z) {
        this.uiqyzsp = z;
        boolean z2 = (z || this.pvkaerr) ? false : true;
        AlertDialog alertDialog = this.ojyssqt;
        alertDialog.setCancelable(z2);
        alertDialog.setCanceledOnTouchOutside(false);
        oqexvyb();
    }

    /* JADX WARN: Code duplicated, block: B:131:0x027e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0283  */
    /* JADX WARN: Code duplicated, block: B:135:0x028e  */
    /* JADX WARN: Code duplicated, block: B:136:0x0291  */
    /* JADX WARN: Code duplicated, block: B:139:0x029b  */
    /* JADX WARN: Code duplicated, block: B:143:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:146:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:147:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:149:0x02b6  */
    public final void qxvquar() {
        String string;
        int iPzqxblc;
        String str;
        String str2;
        String str3;
        int i;
        int iCzidoiw;
        String str4;
        int iPzqxblc2;
        int iJbmzxye;
        Typeface typeface;
        View[] viewArr;
        int i2;
        boolean z;
        int i3;
        int i4 = 2;
        int i5 = 1;
        nlcdwap nlcdwapVar = this.vivhedu;
        String string2 = nlcdwapVar.nmpwovh;
        boolean zIsEmpty = string2.isEmpty();
        com.rynx.app.nmpwovh nmpwovhVar = this.nmpwovh;
        if (zIsEmpty) {
            string2 = nmpwovhVar.getString(R.string.xiaomi_auth_progress_preparing_device);
        }
        this.qxvquar.setText(string2);
        boolean zIsEmpty2 = this.nsyqsfj.isEmpty();
        TextView textView = this.nkemejx;
        if (zIsEmpty2) {
            textView.setVisibility(8);
        } else {
            boolean zEqualsIgnoreCase = "new_security".equalsIgnoreCase(this.nsyqsfj);
            textView.setVisibility(0);
            textView.setText(zEqualsIgnoreCase ? R.string.xiaomi_security_mode_new : R.string.xiaomi_security_mode_legacy);
            textView.setTextColor(zEqualsIgnoreCase ? zamkzqg.nmpwovh(nmpwovhVar) : zamkzqg.jbmzxye(nmpwovhVar));
            textView.setBackground(zamkzqg.yhrqvll(nmpwovhVar, zEqualsIgnoreCase ? zamkzqg.ojyssqt(nmpwovhVar) : zamkzqg.atntgcp(nmpwovhVar), zEqualsIgnoreCase ? zamkzqg.nmpwovh(nmpwovhVar) : zamkzqg.slxntng(nmpwovhVar), 999));
        }
        String string3 = nlcdwapVar.ojyssqt;
        if (string3.isEmpty()) {
            string3 = nmpwovhVar.getString(R.string.xiaomi_auth_progress_waiting_chipset);
        }
        this.oqexvyb.setText(string3);
        this.dplrlfq.setText(nlcdwapVar.lthborb());
        if (nlcdwapVar.dplrlfq) {
            string = nmpwovhVar.getString(R.string.xiaomi_auth_progress_credit_summary, Integer.valueOf(nlcdwapVar.imuemzb), Integer.valueOf(nlcdwapVar.dasxvpc), Integer.valueOf(nlcdwapVar.dytyqos > 0 ? nlcdwapVar.wqrnifx : Math.max(0, nlcdwapVar.wqrnifx - nlcdwapVar.dasxvpc)));
        } else {
            string = nmpwovhVar.getString(R.string.xiaomi_auth_progress_credit_unknown);
        }
        this.ulafhci.setText(string);
        if (nlcdwapVar.pvbzgon) {
            iPzqxblc = zamkzqg.pzkwhtn(nmpwovhVar);
        } else if ("review_required".equals(nlcdwapVar.lthborb)) {
            iPzqxblc = zamkzqg.ohwxijw(nmpwovhVar);
        } else {
            iPzqxblc = nlcdwapVar.buswjhz ? zamkzqg.pzqxblc(nmpwovhVar) : zamkzqg.nmpwovh(nmpwovhVar);
        }
        if (!nlcdwapVar.qxvquar.isEmpty()) {
            str = nlcdwapVar.qxvquar;
        } else if (nlcdwapVar.pvbzgon && "device_accepted".equals(nlcdwapVar.lthborb)) {
            str = "AUTHORIZED";
        } else if ("bypass".equals(nlcdwapVar.lthborb)) {
            str = "BYPASS";
        } else if ("review_required".equals(nlcdwapVar.lthborb)) {
            str = "REVIEW REQUIRED";
        } else if ("device_rejected".equals(nlcdwapVar.lthborb)) {
            str = "DEVICE REJECTED";
        } else if ("expired".equals(nlcdwapVar.lthborb)) {
            str = "EXPIRED";
        } else if (nlcdwapVar.buswjhz || "failed".equals(nlcdwapVar.lthborb)) {
            str = "FAILED";
        } else if (nlcdwapVar.gisppfs || nlcdwapVar.lclupha || "ready".equals(nlcdwapVar.lthborb)) {
            str = "DEVICE VERIFICATION";
        } else if ("queued".equals(nlcdwapVar.lthborb) || "running".equals(nlcdwapVar.lthborb) || "upstream_dispatched".equals(nlcdwapVar.lthborb)) {
            str = "AUTHORIZING";
        } else if (nlcdwapVar.jdqigmr) {
            str = "CHALLENGE READY";
        } else if (nlcdwapVar.vntpaom) {
            str = "WAITING FOR DEVICE";
        } else {
            str = nlcdwapVar.qyeibyo ? "READY TO AUTHORIZE" : "PREPARING";
        }
        TextView textView2 = this.dytyqos;
        textView2.setText(str);
        textView2.setTextColor(iPzqxblc);
        this.wqrnifx.setText(nlcdwapVar.oqexvyb);
        this.dasxvpc.setText(nlcdwapVar.nkemejx);
        if (nlcdwapVar.pvbzgon) {
            str2 = "✓";
        } else if ("review_required".equals(nlcdwapVar.lthborb)) {
            str2 = "!";
        } else {
            str2 = nlcdwapVar.buswjhz ? "×" : "●";
        }
        TextView textView3 = this.imuemzb;
        textView3.setText(str2);
        textView3.setTextColor(iPzqxblc);
        this.qyeibyo.setText(nlcdwapVar.wqrnifx());
        int iNmpwovh = zamkzqg.nmpwovh(nmpwovhVar);
        int iSlxntng = zamkzqg.slxntng(nmpwovhVar);
        int iCzidoiw2 = zamkzqg.czidoiw(nmpwovhVar);
        int i6 = 0;
        while (true) {
            TextView[] textViewArr = this.utmeivs;
            if (i6 >= textViewArr.length) {
                break;
            }
            int iDytyqos = nlcdwapVar.dytyqos(i6);
            if (iDytyqos == i4) {
                iPzqxblc2 = zamkzqg.pzkwhtn(nmpwovhVar);
                iCzidoiw = nmpwovhVar.getColor(zamkzqg.ysluikv(nmpwovhVar) ? R.color.rynx_dark_success_chip : R.color.rynx_light_success_chip);
                str4 = "✓";
            } else if (iDytyqos == 3) {
                iPzqxblc2 = zamkzqg.ohwxijw(nmpwovhVar);
                iCzidoiw = zamkzqg.tmdubwv(nmpwovhVar, "yellow");
                str4 = "!";
            } else {
                if (iDytyqos == 4) {
                    iPzqxblc2 = zamkzqg.pzqxblc(nmpwovhVar);
                    iCzidoiw = zamkzqg.tmdubwv(nmpwovhVar, "red");
                    str4 = "×";
                } else {
                    if (iDytyqos == i5) {
                        iCzidoiw = zamkzqg.czidoiw(nmpwovhVar);
                        str3 = "•";
                        i = iNmpwovh;
                        iNmpwovh = i;
                    } else {
                        str3 = "";
                        iNmpwovh = iNmpwovh;
                        i = iSlxntng;
                        iCzidoiw = iCzidoiw2;
                    }
                    str4 = str3;
                }
                textViewArr[i6].setText(str4);
                textViewArr[i6].setTextColor(i);
                TextView textView4 = textViewArr[i6];
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(1);
                gradientDrawable.setColor(iCzidoiw);
                gradientDrawable.setStroke(zamkzqg.qunltjs(nmpwovhVar, 1), i);
                textView4.setBackground(gradientDrawable);
                TextView[] textViewArr2 = this.pvbzgon;
                TextView textView5 = textViewArr2[i6];
                if (iDytyqos == 1) {
                    iJbmzxye = zamkzqg.zngzleo(nmpwovhVar);
                } else {
                    iJbmzxye = zamkzqg.jbmzxye(nmpwovhVar);
                }
                textView5.setTextColor(iJbmzxye);
                TextView textView6 = textViewArr2[i6];
                if (iDytyqos == 1) {
                    typeface = Typeface.DEFAULT_BOLD;
                } else {
                    typeface = Typeface.DEFAULT;
                }
                textView6.setTypeface(typeface);
                viewArr = this.buswjhz;
                if (i6 < viewArr.length) {
                    int iDytyqos2 = nlcdwapVar.dytyqos(i6 + 1);
                    if (iDytyqos == 2 || iDytyqos2 == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    View view = viewArr[i6];
                    if (z) {
                        i3 = iNmpwovh;
                    } else {
                        i3 = iSlxntng;
                    }
                    view.setBackgroundColor(i3);
                    i2 = 1;
                } else {
                    i2 = 1;
                }
                i6 += i2;
                i5 = i2;
                iNmpwovh = iNmpwovh;
                i4 = 2;
            }
            i = iPzqxblc2;
            textViewArr[i6].setText(str4);
            textViewArr[i6].setTextColor(i);
            TextView textView7 = textViewArr[i6];
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(iCzidoiw);
            gradientDrawable2.setStroke(zamkzqg.qunltjs(nmpwovhVar, 1), i);
            textView7.setBackground(gradientDrawable2);
            TextView[] textViewArr3 = this.pvbzgon;
            TextView textView8 = textViewArr3[i6];
            if (iDytyqos == 1) {
                iJbmzxye = zamkzqg.zngzleo(nmpwovhVar);
            } else {
                iJbmzxye = zamkzqg.jbmzxye(nmpwovhVar);
            }
            textView8.setTextColor(iJbmzxye);
            TextView textView9 = textViewArr3[i6];
            if (iDytyqos == 1) {
                typeface = Typeface.DEFAULT_BOLD;
            } else {
                typeface = Typeface.DEFAULT;
            }
            textView9.setTypeface(typeface);
            viewArr = this.buswjhz;
            if (i6 < viewArr.length) {
                int iDytyqos3 = nlcdwapVar.dytyqos(i6 + 1);
                if (iDytyqos == 2) {
                    z = false;
                } else {
                    z = false;
                }
                View view2 = viewArr[i6];
                if (z) {
                    i3 = iNmpwovh;
                } else {
                    i3 = iSlxntng;
                }
                view2.setBackgroundColor(i3);
                i2 = 1;
            } else {
                i2 = 1;
            }
            i6 += i2;
            i5 = i2;
            iNmpwovh = iNmpwovh;
            i4 = 2;
        }
        String strImuemzb = nlcdwapVar.imuemzb();
        boolean zIsEmpty3 = strImuemzb.isEmpty();
        TextView textView10 = this.lclupha;
        if (!zIsEmpty3) {
            textView10.setText(nmpwovhVar.getString(R.string.xiaomi_auth_progress_job, strImuemzb));
        } else if (this.pvkaerr) {
            textView10.setText(R.string.xiaomi_auth_progress_done);
        } else {
            textView10.setText(R.string.xiaomi_auth_progress_live);
        }
        nkemejx();
        oqexvyb();
        imuemzb();
        if (nlcdwapVar.buswjhz) {
            ValueAnimator valueAnimator = this.bgmsltp;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.bgmsltp.removeAllUpdateListeners();
                this.bgmsltp = null;
            }
            textView3.setAlpha(1.0f);
            return;
        }
        ValueAnimator valueAnimator2 = this.bgmsltp;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.45f, 1.0f);
            this.bgmsltp = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(860L);
            this.bgmsltp.setRepeatMode(2);
            this.bgmsltp.setRepeatCount(-1);
            this.bgmsltp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: x.nysvajy
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    this.nmpwovh.imuemzb.setAlpha(((Float) valueAnimator3.getAnimatedValue()).floatValue());
                }
            });
            this.bgmsltp.start();
        }
    }

    public final void ulafhci(int i, int i2, int i3, int i4) {
        nlcdwap nlcdwapVar = this.vivhedu;
        nlcdwapVar.getClass();
        nlcdwapVar.imuemzb = Math.max(0, i);
        nlcdwapVar.dytyqos = Math.max(0, i2);
        nlcdwapVar.wqrnifx = Math.max(0, i3);
        nlcdwapVar.dasxvpc = Math.max(0, i4);
        nlcdwapVar.dplrlfq = true;
        qxvquar();
    }

    public final void utmeivs() {
        nlcdwap nlcdwapVar = this.vivhedu;
        nlcdwapVar.gisppfs = true;
        nlcdwapVar.oqexvyb = "Sending response to device";
        nlcdwapVar.nkemejx = "Waiting for the device to accept or reject the authorization response.";
        nlcdwapVar.buswjhz = false;
        nlcdwapVar.pvbzgon = false;
        com.rynx.app.nmpwovh nmpwovhVar = this.nmpwovh;
        nlcdwapVar.nkemejx(nmpwovhVar.getString(R.string.xiaomi_auth_progress_hero_device_verification), nmpwovhVar.getString(R.string.xiaomi_auth_progress_status_sending_device), nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_sending_device));
        qxvquar();
    }

    public final void vivhedu(String str) {
        String str2;
        if (str == null || str.trim().isEmpty()) {
            return;
        }
        String strTrim = str.trim();
        String str3 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        ArrayDeque arrayDeque = this.lthborb;
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append("  ");
        String lowerCase = strTrim.toLowerCase(Locale.ROOT);
        if (lowerCase.contains("failed") || lowerCase.contains("reject") || lowerCase.contains("error") || lowerCase.contains("review")) {
            str2 = "!";
        } else {
            str2 = (lowerCase.contains("accepted") || lowerCase.contains("ready") || lowerCase.contains("received") || lowerCase.contains("captured") || lowerCase.contains("reserved") || lowerCase.contains("valid response")) ? "✓" : "→";
        }
        sb.append(str2);
        sb.append(" ");
        sb.append(strTrim);
        arrayDeque.addLast(sb.toString());
        while (arrayDeque.size() > 100) {
            arrayDeque.removeFirst();
        }
        dytyqos();
    }

    public final void wqrnifx(TextView textView, boolean z, boolean z2) {
        textView.setEnabled(z);
        textView.setAlpha(z ? 1.0f : 0.42f);
        com.rynx.app.nmpwovh nmpwovhVar = this.nmpwovh;
        textView.setTextColor(z2 ? zamkzqg.gucwjqz(nmpwovhVar) : zamkzqg.zngzleo(nmpwovhVar));
        textView.setBackground(zamkzqg.yhrqvll(nmpwovhVar, z2 ? zamkzqg.nmpwovh(nmpwovhVar) : zamkzqg.atntgcp(nmpwovhVar), z2 ? zamkzqg.nmpwovh(nmpwovhVar) : zamkzqg.slxntng(nmpwovhVar), 999));
    }
}
