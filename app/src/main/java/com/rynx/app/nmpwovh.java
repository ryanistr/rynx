package com.rynx.app;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.hardware.usb.UsbDevice;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.LocaleList;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import com.rynx.app.security.RuntimeGuard;
import java.io.File;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import x.atntgcp;
import x.ccuulnt;
import x.dplrlfq;
import x.ebrwptg;
import x.ezxxysz;
import x.fadblxi;
import x.gepzcpd;
import x.ghkjjru;
import x.hhqpjvl;
import x.hiofinr;
import x.jbyhfxz;
import x.kxotgjb;
import x.lataqgm;
import x.lthborb;
import x.nlcdwap;
import x.nsizane;
import x.osgyung;
import x.pzqxblc;
import x.qxvquar;
import x.seujokk;
import x.suqlntg;
import x.vlyywxv;
import x.xhyvkax;
import x.yonoayx;
import x.zamkzqg;
import x.zfmpmio;
import x.pmsrvoc;
import x.ljhdwjr;
import x.yztlqms;
import x.czgynww;
import x.zftrkmx;
import x.zrcmcht;
import x.zwccvwt;

/* JADX INFO: loaded from: classes.dex */
public abstract class nmpwovh extends ojyssqt {
    public static final String[] zrcmcht = {"klimt", "goya", "rodin", "dash", "lapis", "spinel"};
    public Future czgynww;
    public volatile int hiofinr;
    public Future iivesaq;
    public volatile xhyvkax iqvvlnh;
    public volatile zwccvwt laodqsm;
    public volatile int nnkxxji;
    public volatile ghkjjru nysvajy;
    public volatile hiofinr qdiugcp;
    public ebrwptg snbdnwo;
    public volatile boolean xhyvkax;
    public volatile boolean yztlqms;
    public ScrollView zamkzqg;
    public volatile int zsbaukl;
    public vlyywxv zwccvwt;
    public volatile int zyxfuka;
    public final ExecutorService zfmpmio = Executors.newSingleThreadExecutor();
    public final ExecutorService ziuhthw = Executors.newSingleThreadExecutor();
    public volatile String gdkopre = "";
    public volatile String vlyywxv = "";
    public volatile String nlcdwap = "";
    public volatile String wrbqriz = "";
    public volatile String dreanqi = "";
    public volatile String ebrwptg = "";
    public List jcyrpko = Collections.emptyList();

    public final void ankiohq() {
        if (this.yztlqms || this.snbdnwo == null) {
            return;
        }
        xhyvkax xhyvkaxVar = this.iqvvlnh;
        if (xhyvkaxVar == null || !xhyvkaxVar.vivhedu()) {
            nxumtuo();
            return;
        }
        int i = this.nnkxxji + 1;
        this.nnkxxji = i;
        this.yztlqms = true;
        this.snbdnwo.nkemejx(true);
        this.iivesaq = this.zfmpmio.submit(new jbyhfxz(this, xhyvkaxVar, i, 0));
    }

    @Override // com.rynx.app.ojyssqt, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        String strJxvdcpb = x.zamkzqg.jxvdcpb(context);
        Configuration configuration = context.getResources().getConfiguration();
        if ("system".equals(strJxvdcpb)) {
            LocaleList locales = configuration.getLocales();
            if (!locales.isEmpty()) {
                Locale.setDefault(locales.get(0));
            }
        } else {
            Locale localeForLanguageTag = Locale.forLanguageTag(strJxvdcpb);
            Locale.setDefault(localeForLanguageTag);
            Configuration configuration2 = new Configuration(configuration);
            configuration2.setLocale(localeForLanguageTag);
            configuration2.setLocales(new LocaleList(localeForLanguageTag));
            configuration2.setLayoutDirection(localeForLanguageTag);
            context = context.createConfigurationContext(configuration2);
        }
        super.attachBaseContext(context);
    }

    public final void cszfvxh() {
        boolean zYsluikv = x.zamkzqg.ysluikv(this);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setStatusBarColor(this.nmpwovh);
        window.setNavigationBarColor(this.nmpwovh);
        View decorView = window.getDecorView();
        if (decorView == null) {
            return;
        }
        lthborb lthborbVar = new lthborb(decorView, zYsluikv, 1);
        if (decorView.isAttachedToWindow()) {
            lthborbVar.run();
        } else {
            decorView.post(lthborbVar);
        }
    }

    public final void dvzxbaj(final boolean z) {
        if (this.snbdnwo == null || this.nysvajy == null || this.xhyvkax) {
            return;
        }
        final int i = this.hiofinr + 1;
        this.hiofinr = i;
        this.xhyvkax = true;
        this.snbdnwo.imuemzb();
        this.czgynww = this.zfmpmio.submit(new Runnable() { // from class: x.ltnesel
            @Override // java.lang.Runnable
            public final void run() {
                List listLthborbTmp = null;
                String strTmp = null;
                final com.rynx.app.nmpwovh nmpwovhVar = nmpwovh.this;
                final int i2 = i;
                final boolean z2 = z;
                nmpwovhVar.getClass();
                try {

                    listLthborbTmp = x.zsbaukl.lthborb(com.rynx.app.ojyssqt.jxvdcpb(), nmpwovhVar.iqvvlnh);
                } catch (Throwable th) {
                    String message = th.getMessage();
                    if (message == null || message.trim().isEmpty()) {
                        message = nmpwovhVar.getString(R.string.xiaomi_authorize_unknown_error);
                    }

                    strTmp = message;
                }
                final List listLthborb = listLthborbTmp;
                final String str = strTmp;
                nmpwovhVar.runOnUiThread(new Runnable() { // from class: x.dvzxbaj
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.rynx.app.nmpwovh nmpwovhVar2 = nmpwovhVar;
                        int i3 = i2;
                        List<zwccvwt> list = listLthborb;
                        String str2 = str;
                        boolean z3 = z2;
                        if (i3 != nmpwovhVar2.hiofinr || nmpwovhVar2.isFinishing() || nmpwovhVar2.isDestroyed() || nmpwovhVar2.nysvajy == null) {
                            return;
                        }
                        nmpwovhVar2.xhyvkax = false;
                        zwccvwt zwccvwtVar = null;
                        nmpwovhVar2.czgynww = null;
                        if (list == null) {
                            ebrwptg ebrwptgVar = nmpwovhVar2.snbdnwo;
                            ebrwptgVar.uiqyzsp = false;
                            Activity activity = ebrwptgVar.lthborb;
                            String string = activity.getString(R.string.xiaomi_device_catalog_failed, (str2 == null || str2.trim().isEmpty()) ? activity.getString(R.string.xiaomi_authorize_unknown_error) : str2.trim());
                            TextView textView = ebrwptgVar.jdqigmr;
                            textView.setText(string);
                            textView.setTextColor(x.zamkzqg.pzqxblc(activity));
                            x.zamkzqg.enxkjpu(activity, textView, R.drawable.ic_warning, x.zamkzqg.pzqxblc(activity));
                            ebrwptgVar.ekyqleu();
                            return;
                        }
                        String strOjyssqt = nmpwovhVar2.laodqsm == null ? "" : nmpwovhVar2.laodqsm.ojyssqt();
                        nmpwovhVar2.jcyrpko = list;
                        zwccvwt zwccvwtVar2 = nmpwovhVar2.laodqsm;
                        if (strOjyssqt != null && !strOjyssqt.isEmpty()) {
                            for (zwccvwt zwccvwtVar3 : list) {
                                if (zwccvwtVar3 != null && strOjyssqt.equals(zwccvwtVar3.ojyssqt())) {
                                    zwccvwtVar = zwccvwtVar3;
                                    break;
                                }
                            }
                        }
                        nmpwovhVar2.laodqsm = zwccvwtVar;
                        if ((nmpwovhVar2.laodqsm == null || zwccvwtVar2 == null || !nmpwovhVar2.laodqsm.ojyssqt().equals(zwccvwtVar2.ojyssqt())) && zwccvwtVar2 != null) {
                            nmpwovhVar2.rpilpcp();
                        }
                        nmpwovhVar2.snbdnwo.dytyqos(list.size());
                        nmpwovhVar2.sjexbpf();
                        if (z3 && "xiaomi_authorize".equals(nmpwovhVar2.ayzlrnr)) {
                            nmpwovhVar2.yojulhu();
                        }
                    }
                });
            }
        });
    }

    public final void gepzcpd(int i, int i2) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(i))));
        } catch (Throwable unused) {
            Toast.makeText(this, i2, 0).show();
        }
    }

    public final String gucwjqz() {
        zwccvwt zwccvwtVar = this.laodqsm;
        if (zwccvwtVar == null) {
            return "";
        }
        String str = zwccvwtVar.vivhedu;
        String lowerCase = str == null ? "" : str.trim().replaceAll("^[\\[\\](){}]+|[\\[\\](){}]+$", "").trim().toLowerCase(Locale.ROOT);
        String str2 = zwccvwtVar.nmpwovh;
        String lowerCase2 = str2 != null ? str2.trim().replaceAll("^[\\[\\](){}]+|[\\[\\](){}]+$", "").trim().toLowerCase(Locale.ROOT) : "";
        String str3 = zwccvwtVar.dplrlfq;
        if (str3 != null && !str3.isEmpty()) {
            return !lowerCase.isEmpty() ? lowerCase : lowerCase2;
        }
        String str4 = " " + zwccvwtVar.nmpwovh().replaceAll("[^a-z0-9]+", " ") + " ";
        String[] strArr = zrcmcht;
        for (int i = 0; i < 6; i++) {
            String str5 = strArr[i];
            if (!str5.equals(lowerCase) && !str5.equals(lowerCase2)) {
                if (!str4.contains(" " + str5 + " ")) {
                }
            }
            return str5;
        }
        return !lowerCase.isEmpty() ? lowerCase : lowerCase2;
    }

    public final void gzvolsx() {
        if (this.snbdnwo == null) {
            return;
        }
        ghkjjru ghkjjruVar = this.nysvajy;
        if (ghkjjruVar == null) {
            this.snbdnwo.ulafhci();
        } else {
            this.snbdnwo.qxvquar((String) ghkjjruVar.nmpwovh, (String) ghkjjruVar.ojyssqt, (String) ghkjjruVar.vivhedu, (String) ghkjjruVar.lthborb);
            thbdbid();
        }
    }

    public final void ioxmphz(boolean z) {
        if (this.civyupy == z) {
            if (z && this.lataqgm) {
                ltnesel();
                return;
            }
            return;
        }
        this.civyupy = z;
        jtfjrri(true);
        if (z && this.lataqgm) {
            ltnesel();
        }
    }

    public final void iwjoiry() {
        int i;
        if (this.ccuulnt == null) {
            return;
        }
        boolean zYsluikv = x.zamkzqg.ysluikv(this);
        if (this.ccuulnt.ojyssqt.isChecked() != zYsluikv) {
            this.ccuulnt.ojyssqt.setChecked(zYsluikv);
        }
        x.zamkzqg.sdchfks(this, this.ccuulnt.ojyssqt);
        boolean zJlgwuft = x.zamkzqg.jlgwuft(this);
        if (this.ccuulnt.vivhedu.isChecked() != zJlgwuft) {
            this.ccuulnt.vivhedu.setChecked(zJlgwuft);
        }
        x.zamkzqg.sdchfks(this, this.ccuulnt.vivhedu);
        TextView textView = this.ccuulnt.lthborb;
        String strMcdstyz = x.zamkzqg.mcdstyz(x.zamkzqg.jxvdcpb(this));
        if (strMcdstyz.equals("en")) {
            i = R.string.settings_language_english;
        } else {
            i = !strMcdstyz.equals("id") ? R.string.settings_language_system : R.string.settings_language_indonesian;
        }
        textView.setText(i);
        boolean zPvbzgon = pvbzgon();
        this.ccuulnt.qxvquar.setText(zPvbzgon ? R.string.settings_storage_granted : R.string.settings_storage_not_granted);
        this.ccuulnt.qxvquar.setTextColor(zPvbzgon ? this.qxvquar : this.oqexvyb);
    }

    public final void jbyhfxz(int i, String str) {
        vlyywxv vlyywxvVar;
        if (i == this.zsbaukl && (vlyywxvVar = this.zwccvwt) != null && vlyywxvVar.ojyssqt.isShowing()) {
            vlyywxvVar.vivhedu(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x02af  */
    /* JADX WARN: Code duplicated, block: B:36:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:39:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:41:0x02da  */
    /* JADX WARN: Code duplicated, block: B:43:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:45:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:50:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:56:0x0410  */
    /* JADX WARN: Code duplicated, block: B:58:0x0420  */
    /* JADX WARN: Code duplicated, block: B:59:0x0422  */
    /* JADX WARN: Code duplicated, block: B:63:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:65:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:70:0x069c  */
    /* JADX WARN: Code duplicated, block: B:71:0x069f  */
    /* JADX WARN: Code duplicated, block: B:75:0x02fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x043a A[EDGE_INSN: B:80:0x043a->B:61:0x043a BREAK  A[LOOP:1: B:54:0x040d->B:60:0x0423], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r0v58, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r0v64, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r11v18, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r1v14, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r30v0 */
    /* JADX WARN: Type inference failed for: r30v1 */
    /* JADX WARN: Type inference failed for: r30v2 */
    /* JADX WARN: Type inference failed for: r30v3 */
    /* JADX WARN: Type inference failed for: r30v5 */
    /* JADX WARN: Type inference failed for: r30v6 */
    /* JADX WARN: Type inference failed for: r30v7 */
    /* JADX WARN: Type inference failed for: r30v8 */
    /* JADX WARN: Type inference failed for: r30v9 */
    /* JADX WARN: Type inference failed for: r32v0, types: [android.widget.ScrollView] */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.View, android.view.ViewGroup, android.widget.ScrollView] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r8v17, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r9v29, types: [android.view.View, android.view.ViewGroup, x.lataqgm] */
    public final View jlgwuft() {
        String str;
        String string = null;
        String string2 = null;
        lataqgm lataqgmVar;
        String strEzxxysz;
        String[] strArr;
        int length;
        int i;
        ScrollView r4;
        LinearLayout r2;
        final gepzcpd gepzcpdVar;
        lataqgm lataqgmVar2 = null;
        int iNhhacgu = 0;
        int[] iArr = null;
        int[] iArr2 = null;
        String[] strArr2 = null;
        int i2 = 0;
        int i3 = 0;
        lataqgm lataqgmVar3;
        int iNsizane;
        int[] iArr3;
        int[] iArr4;
        String[] strArr3;
        int i4;
        int i5;
        int i6;
        boolean z;
        int i7;
        boolean z2;
        String str2;
        int i8;
        LinearLayout r30;
        String[] strArr4;
        int iSilhone;
        String str3;
        int identifier;
        LinearLayout r31;
        LinearLayout r32 = null;
        String str4 = "";
        try {
            str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            while (true) {
                if (i2 < 4) {
                    break;
                }
                i7 = iArr[i2];
                String string3 = getString(iArr2[i2]);
                String str5 = strArr2[i2];
                int iNmpwovh = x.zamkzqg.nmpwovh(this);
                if (iNhhacgu == i7) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int i9 = i2;
                final int i10 = 0;
                final int i7site1 = i7;
                lataqgmVar2.addView(x.zamkzqg.gzokllk(this, string3, str5, iNmpwovh, z2, new View.OnClickListener() { // from class: x.tqcgjht
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i10) {
                            case 0:
                                com.rynx.app.nmpwovh nmpwovhVar = nmpwovh.this;
                                nmpwovhVar.getClass();
                                int iNhhacgu2 = x.zamkzqg.nhhacgu(nmpwovhVar);
                                int i11 = i7site1;
                                if (iNhhacgu2 != i11) {
                                    if (i11 != 10 && i11 != 16 && i11 != 28) {
                                        i11 = 22;
                                    }
                                    nmpwovhVar.getSharedPreferences("rynx_ui", 0).edit().putInt("card_radius_dp", i11).apply();
                                    nmpwovhVar.zftrkmx();
                                    break;
                                }
                                break;
                            default:
                                com.rynx.app.nmpwovh nmpwovhVar2 = nmpwovh.this;
                                nmpwovhVar2.getClass();
                                int iNsizane2 = x.zamkzqg.nsizane(nmpwovhVar2);
                                int i12 = i7site1;
                                if (iNsizane2 != i12) {
                                    if (i12 < 0 || i12 > 3) {
                                        i12 = 3;
                                    }
                                    nmpwovhVar2.getSharedPreferences("rynx_ui", 0).edit().putInt("surface_style", i12).apply();
                                    nmpwovhVar2.zftrkmx();
                                    break;
                                }
                                break;
                        }
                    }
                }));
                i2 = i9 + 1;
            }
        } catch (Throwable unused) {
            str = "";
        }
        getPackageName();
        boolean zYsluikv = x.zamkzqg.ysluikv(this);
        String strMcdstyz = x.zamkzqg.mcdstyz(x.zamkzqg.jxvdcpb(this));
        String string4 = getString(strMcdstyz.equals("en") ? R.string.settings_language_english : !strMcdstyz.equals("id") ? R.string.settings_language_system : R.string.settings_language_indonesian);
        gepzcpd gepzcpdVar2 = new gepzcpd(this);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setClipToPadding(false);
        scrollView.setBackgroundColor(x.zamkzqg.buswjhz(this));
        LinearLayout Xbdyiew = x.zamkzqg.xbdyiew(this, 16);
        scrollView.addView(Xbdyiew);
        Xbdyiew.addView(x.zamkzqg.ywhgqsi(this, getString(R.string.settings_title)));
        TextView textViewOxoagud = x.zamkzqg.oxoagud(this, getString(R.string.settings_subtitle), 12, x.zamkzqg.jbmzxye(this), false);
        textViewOxoagud.setPadding(0, 0, 0, x.zamkzqg.qunltjs(this, 15));
        Xbdyiew.addView(textViewOxoagud);
        Xbdyiew.addView(x.zamkzqg.hknanqb(this, R.string.settings_live_preview_section));
        LinearLayout Zwaqeaz = x.zamkzqg.zwaqeaz(this);
        LinearLayout linearLayoutLvtqoqa = x.zamkzqg.lvtqoqa(this);
        View view = new View(this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(x.zamkzqg.nmpwovh(this));
        view.setBackground(gradientDrawable);
        linearLayoutLvtqoqa.addView(view, new LinearLayout.LayoutParams(x.zamkzqg.qunltjs(this, 9), x.zamkzqg.qunltjs(this, 9)));
        TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, getString(R.string.settings_active_style_preview), 10, x.zamkzqg.nmpwovh(this), true);
        textViewOxoagud2.setLetterSpacing(0.1f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = x.zamkzqg.qunltjs(this, 8);
        linearLayoutLvtqoqa.addView(textViewOxoagud2, layoutParams);
        TextView textViewOxoagud3 = x.zamkzqg.oxoagud(this, getString(R.string.settings_radius_badge, Integer.valueOf(x.zamkzqg.nhhacgu(this))), 10, x.zamkzqg.nmpwovh(this), false);
        textViewOxoagud3.setPadding(x.zamkzqg.qunltjs(this, 10), x.zamkzqg.qunltjs(this, 5), x.zamkzqg.qunltjs(this, 10), x.zamkzqg.qunltjs(this, 5));
        textViewOxoagud3.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.uzyihoe(x.zamkzqg.nmpwovh(this), x.zamkzqg.ysluikv(this) ? 48 : 28), x.zamkzqg.uzyihoe(x.zamkzqg.nmpwovh(this), 90), x.zamkzqg.qunltjs(this, 99)));
        linearLayoutLvtqoqa.addView(textViewOxoagud3);
        Zwaqeaz.addView(linearLayoutLvtqoqa);
        LinearLayout Lvtqoqa = x.zamkzqg.lvtqoqa(this);
        Lvtqoqa.setPadding(0, x.zamkzqg.qunltjs(this, 16), 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_settings);
        imageView.setImageTintList(ColorStateList.valueOf(x.zamkzqg.nmpwovh(this)));
        imageView.setPadding(x.zamkzqg.qunltjs(this, 11), x.zamkzqg.qunltjs(this, 11), x.zamkzqg.qunltjs(this, 11), x.zamkzqg.qunltjs(this, 11));
        imageView.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.uzyihoe(x.zamkzqg.nmpwovh(this), x.zamkzqg.ysluikv(this) ? 40 : 22), x.zamkzqg.uzyihoe(x.zamkzqg.nmpwovh(this), 60), x.zamkzqg.qunltjs(this, 16)));
        Lvtqoqa.addView(imageView, new LinearLayout.LayoutParams(x.zamkzqg.qunltjs(this, 52), x.zamkzqg.qunltjs(this, 52)));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        linearLayout.addView(x.zamkzqg.oxoagud(this, getString(R.string.settings_preview_surface_name), 15, x.zamkzqg.zngzleo(this), false));
        String string5 = getString(x.zamkzqg.iwjoiry(x.zamkzqg.ezxxysz(this)));
        int iNsizane2 = x.zamkzqg.nsizane(this);
        if (iNsizane2 != 0) {
            if (iNsizane2 != 1) {
                string2 = iNsizane2 != 2 ? getString(R.string.settings_surface_slate) : getString(R.string.settings_surface_neon);
            } else {
                string = getString(R.string.settings_surface_glass);
            }
            TextView textViewOxoagud4 = x.zamkzqg.oxoagud(this, getString(R.string.settings_preview_surface_desc, string5, string2), 11, x.zamkzqg.jbmzxye(this), false);
            textViewOxoagud4.setPadding(0, x.zamkzqg.qunltjs(this, 3), 0, 0);
            linearLayout.addView(textViewOxoagud4);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams2.leftMargin = x.zamkzqg.qunltjs(this, 14);
            Lvtqoqa.addView(linearLayout, layoutParams2);
            Zwaqeaz.addView(Lvtqoqa);
            Xbdyiew.addView(Zwaqeaz, x.zamkzqg.uiqyzsp(this));
            Xbdyiew.addView(x.zamkzqg.hknanqb(this, R.string.settings_accent_color_section));
            LinearLayout Zwaqeaz2 = x.zamkzqg.zwaqeaz(this);
            Zwaqeaz2.addView(x.zamkzqg.lpkdqgx(this, R.string.settings_signature_palette));
            Zwaqeaz2.addView(x.zamkzqg.pvkaerr(this, R.string.settings_signature_palette_desc));
            lataqgmVar = new lataqgm(this, x.zamkzqg.qunltjs(this, 8), x.zamkzqg.qunltjs(this, 8));
            lataqgmVar.setPadding(0, x.zamkzqg.qunltjs(this, 12), 0, 0);
            strEzxxysz = x.zamkzqg.ezxxysz(this);
            strArr = (String[]) x.zamkzqg.nmpwovh.clone();
            length = strArr.length;
            i = 0;
            r2 = Xbdyiew;
            r4 = scrollView;
            while (i < length) {
                str2 = strArr[i];
                boolean zEquals = str2.equals(strEzxxysz);
                int i11 = i;
                pzqxblc pzqxblcVar = new pzqxblc(gepzcpdVar2, str2, 8);
                if ("auto".equals(str2)) {
                    if (x.zamkzqg.yonoayx(this)) {
                        if (x.zamkzqg.ysluikv(this)) {
                            str3 = "system_accent1_200";
                        } else {
                            str3 = "system_accent1_600";
                        }
                        i8 = length;
                        r30 = r2;
                        strArr4 = strArr;
                        identifier = getResources().getIdentifier(str3, "color", "android");
                        if (identifier != 0) {
                            try {
                                iSilhone = getColor(identifier);
                                r32 = r30;
                            } catch (Throwable unused2) {
                                iSilhone = x.zamkzqg.silhone(new String[]{"azure", "cyan", "mint", "violet", "amber", "rose"}[(int) Math.floorMod(Math.floorDiv(System.currentTimeMillis(), 86400000L), 6)]);
                                r31 = r30;
                            }
                        }
                    } else {
                        i8 = length;
                        r30 = r2;
                        strArr4 = strArr;
                    }
                    iSilhone = x.zamkzqg.silhone(new String[]{"azure", "cyan", "mint", "violet", "amber", "rose"}[(int) Math.floorMod(Math.floorDiv(System.currentTimeMillis(), 86400000L), 6)]);
                    r31 = r30;
                    int i12 = iSilhone;
                    String str6 = "●  " + getString(x.zamkzqg.iwjoiry(str2));
                    TextView textViewGzokllk = x.zamkzqg.gzokllk(this, str6, "", i12, zEquals, pzqxblcVar);
                    SpannableString spannableString = new SpannableString(str6);
                    spannableString.setSpan(new ForegroundColorSpan(i12), 0, 1, 33);
                    textViewGzokllk.setText(spannableString);
                    lataqgmVar.addView(textViewGzokllk);
                    i = i11 + 1;
                    r2 = r31;
                    gepzcpdVar2 = gepzcpdVar2;
                    str4 = str4;
                    length = i8;
                    strEzxxysz = strEzxxysz;
                    strArr = strArr4;
                    r4 = r4;
                    str = str;
                } else {
                    iSilhone = x.zamkzqg.silhone(str2);
                    i8 = length;
                    r32 = r2;
                    strArr4 = strArr;
                }
                r31 = r32;
                int i13 = iSilhone;
                String str7 = "●  " + getString(x.zamkzqg.iwjoiry(str2));
                TextView textViewGzokllk2 = x.zamkzqg.gzokllk(this, str7, "", i13, zEquals, pzqxblcVar);
                SpannableString spannableString2 = new SpannableString(str7);
                spannableString2.setSpan(new ForegroundColorSpan(i13), 0, 1, 33);
                textViewGzokllk2.setText(spannableString2);
                lataqgmVar.addView(textViewGzokllk2);
                i = i11 + 1;
                r2 = r31;
                gepzcpdVar2 = gepzcpdVar2;
                str4 = str4;
                length = i8;
                strEzxxysz = strEzxxysz;
                strArr = strArr4;
                r4 = r4;
                str = str;
            }
            LinearLayout r11 = r2;
            ScrollView r33 = r4;
            String str8 = str4;
            String str9 = str;
            gepzcpdVar = gepzcpdVar2;
            Zwaqeaz2.addView(lataqgmVar, new LinearLayout.LayoutParams(-1, -2));
            r11.addView(Zwaqeaz2, x.zamkzqg.uiqyzsp(this));
            r11.addView(x.zamkzqg.hknanqb(this, R.string.settings_card_surface_section));
            LinearLayout linearLayoutZwaqeaz = x.zamkzqg.zwaqeaz(this);
            linearLayoutZwaqeaz.addView(x.zamkzqg.lpkdqgx(this, R.string.settings_corner_curvature));
            linearLayoutZwaqeaz.addView(x.zamkzqg.pvkaerr(this, R.string.settings_corner_curvature_desc));
            lataqgmVar2 = new lataqgm(this, x.zamkzqg.qunltjs(this, 8), x.zamkzqg.qunltjs(this, 8));
            lataqgmVar2.setPadding(0, x.zamkzqg.qunltjs(this, 11), 0, 0);
            iNhhacgu = x.zamkzqg.nhhacgu(this);
            iArr = new int[]{10, 16, 22, 28};
            iArr2 = new int[]{R.string.settings_radius_sharp, R.string.settings_radius_classic, R.string.settings_radius_squircle, R.string.settings_radius_pill};
            strArr2 = new String[]{"□", "▢", "▣", "○"};
            i2 = 0;
            while (true) {
                if (i2 < 4) {
                    break;

                }
                i7 = iArr[i2];
                String string6 = getString(iArr2[i2]);
                String str10 = strArr2[i2];
                int iNmpwovh2 = x.zamkzqg.nmpwovh(this);
                if (iNhhacgu == i7) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int i14 = i2;
                final int i15 = 0;
                final int i7site2 = i7;
                lataqgmVar2.addView(x.zamkzqg.gzokllk(this, string6, str10, iNmpwovh2, z2, new View.OnClickListener() { // from class: x.tqcgjht
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i15) {
                            case 0:
                                com.rynx.app.nmpwovh nmpwovhVar = gepzcpdVar.nmpwovh;
                                nmpwovhVar.getClass();
                                int iNhhacgu2 = x.zamkzqg.nhhacgu(nmpwovhVar);
                                int i16 = i7site2;
                                if (iNhhacgu2 != i16) {
                                    if (i16 != 10 && i16 != 16 && i16 != 28) {
                                        i16 = 22;
                                    }
                                    nmpwovhVar.getSharedPreferences("rynx_ui", 0).edit().putInt("card_radius_dp", i16).apply();
                                    nmpwovhVar.zftrkmx();
                                    break;
                                }
                                break;
                            default:
                                com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar.nmpwovh;
                                nmpwovhVar2.getClass();
                                int iNsizane3 = x.zamkzqg.nsizane(nmpwovhVar2);
                                int i17 = i7site2;
                                if (iNsizane3 != i17) {
                                    if (i17 < 0 || i17 > 3) {
                                        i17 = 3;
                                    }
                                    nmpwovhVar2.getSharedPreferences("rynx_ui", 0).edit().putInt("surface_style", i17).apply();
                                    nmpwovhVar2.zftrkmx();
                                    break;
                                }
                                break;
                        }
                    }
                }));
                i2 = i14 + 1;
            }
            linearLayoutZwaqeaz.addView(lataqgmVar2, new LinearLayout.LayoutParams(-1, -2));
            linearLayoutZwaqeaz.addView(x.zamkzqg.ivvkvsj(this));
            linearLayoutZwaqeaz.addView(x.zamkzqg.lpkdqgx(this, R.string.settings_surface_visual_style));
            linearLayoutZwaqeaz.addView(x.zamkzqg.pvkaerr(this, R.string.settings_surface_visual_style_desc));
            lataqgmVar3 = new lataqgm(this, x.zamkzqg.qunltjs(this, 8), x.zamkzqg.qunltjs(this, 8));
            lataqgmVar3.setPadding(0, x.zamkzqg.qunltjs(this, 11), 0, 0);
            iNsizane = x.zamkzqg.nsizane(this);
            iArr3 = new int[]{0, 1, 2, 3};
            iArr4 = new int[]{R.string.settings_surface_amoled, R.string.settings_surface_glass, R.string.settings_surface_neon, R.string.settings_surface_slate};
            strArr3 = new String[]{"◔", "░", "✦", "◇"};
            i4 = 0;
            for (i3 = 4; i4 < i3; i3 = 4) {
                i6 = iArr3[i4];
                String string7 = getString(iArr4[i4]);
                String str11 = strArr3[i4];
                int iNmpwovh3 = x.zamkzqg.nmpwovh(this);
                int i16 = i4;
                if (iNsizane == i6) {
                    z = true;
                } else {
                    z = false;
                }
                int i17 = iNsizane;
                final int i18 = 1;
                final int i6site3 = i6;
                lataqgmVar3.addView(x.zamkzqg.gzokllk(this, string7, str11, iNmpwovh3, z, new View.OnClickListener() { // from class: x.tqcgjht
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i18) {
                            case 0:
                                com.rynx.app.nmpwovh nmpwovhVar = gepzcpdVar.nmpwovh;
                                nmpwovhVar.getClass();
                                int iNhhacgu2 = x.zamkzqg.nhhacgu(nmpwovhVar);
                                int i19 = i6site3;
                                if (iNhhacgu2 != i19) {
                                    if (i19 != 10 && i19 != 16 && i19 != 28) {
                                        i19 = 22;
                                    }
                                    nmpwovhVar.getSharedPreferences("rynx_ui", 0).edit().putInt("card_radius_dp", i19).apply();
                                    nmpwovhVar.zftrkmx();
                                    break;
                                }
                                break;
                            default:
                                com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar.nmpwovh;
                                nmpwovhVar2.getClass();
                                int iNsizane3 = x.zamkzqg.nsizane(nmpwovhVar2);
                                int i110 = i6site3;
                                if (iNsizane3 != i110) {
                                    if (i110 < 0 || i110 > 3) {
                                        i110 = 3;
                                    }
                                    nmpwovhVar2.getSharedPreferences("rynx_ui", 0).edit().putInt("surface_style", i110).apply();
                                    nmpwovhVar2.zftrkmx();
                                    break;
                                }
                                break;
                        }
                    }
                }));
                i4 = i16 + 1;
                iNsizane = i17;
            }
            linearLayoutZwaqeaz.addView(lataqgmVar3, new LinearLayout.LayoutParams(-1, -2));
            r11.addView(linearLayoutZwaqeaz, x.zamkzqg.uiqyzsp(this));
            r11.addView(x.zamkzqg.hknanqb(this, R.string.settings_visual_elements_section));
            LinearLayout linearLayoutZwaqeaz2 = x.zamkzqg.zwaqeaz(this);
            LinearLayout linearLayoutEdnetju = x.zamkzqg.ednetju(this, R.string.settings_ambient_halo, R.string.settings_ambient_halo_desc, x.zamkzqg.jlgwuft(this));
            Switch r3 = (Switch) linearLayoutEdnetju.getTag();
            r3.setOnCheckedChangeListener(new fadblxi(gepzcpdVar, 0));
            linearLayoutZwaqeaz2.addView(linearLayoutEdnetju);
            r11.addView(linearLayoutZwaqeaz2, x.zamkzqg.uiqyzsp(this));
            r11.addView(x.zamkzqg.hknanqb(this, R.string.settings_theme_section));
            LinearLayout Zwaqeaz3 = x.zamkzqg.zwaqeaz(this);
            LinearLayout linearLayoutEdnetju2 = x.zamkzqg.ednetju(this, R.string.settings_dark_mode, R.string.settings_dark_mode_desc, zYsluikv);
            Switch r5 = (Switch) linearLayoutEdnetju2.getTag();
            r5.setOnCheckedChangeListener(new fadblxi(gepzcpdVar, 1));
            Zwaqeaz3.addView(linearLayoutEdnetju2);
            Zwaqeaz3.addView(x.zamkzqg.ivvkvsj(this));
            LinearLayout linearLayoutLvtqoqa2 = x.zamkzqg.lvtqoqa(this);
            linearLayoutLvtqoqa2.setGravity(16);
            linearLayoutLvtqoqa2.setClickable(true);
            linearLayoutLvtqoqa2.setFocusable(true);
            x.zamkzqg.utmeivs(this, linearLayoutLvtqoqa2);
            final int i19 = 0;
            linearLayoutLvtqoqa2.setOnClickListener(new View.OnClickListener() { // from class: x.snilumr
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    String str12;
                    int i20 = 2;
                    gepzcpd gepzcpdVar3 = gepzcpdVar;
                    boolean z3 = true;
                    char c = 1;
                    final int i21 = 0;
                    switch (i19) {
                        case 0:
                            String[] strArr5 = {"system", "en", "id"};
                            com.rynx.app.nmpwovh nmpwovhVar = gepzcpdVar3.nmpwovh;
                            CharSequence[] charSequenceArr = {nmpwovhVar.getString(R.string.settings_language_system), nmpwovhVar.getString(R.string.settings_language_english), nmpwovhVar.getString(R.string.settings_language_indonesian)};
                            String strJxvdcpb = x.zamkzqg.jxvdcpb(nmpwovhVar);
                            int i22 = 0;
                            while (i22 < 3) {
                                if (strArr5[i22].equals(strJxvdcpb)) {
                                    new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i22, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                                } else {
                                    i22++;
                                }
                                break;
                            }
                            i22 = 0;
                            new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i22, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                            break;
                        case 1:
                            gepzcpdVar3.nmpwovh.sthdtww();
                            break;
                        case 2:
                            final com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                            nmpwovhVar2.getClass();
                            try {
                                str12 = nmpwovhVar2.getPackageManager().getPackageInfo(nmpwovhVar2.getPackageName(), 0).versionName;
                            } catch (Throwable unused3) {
                                str12 = "";
                            }
                            String str13 = str12 != null ? str12 : "";
                            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.ysluikv
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    switch (i21) {
                                        case 0:
                                            nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                            break;
                                        default:
                                            nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                            break;
                                    }
                                }
                            };
                            final int c2 = c != 0 ? 1 : 0;
                            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.ysluikv
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    switch (c2) {
                                        case 0:
                                            nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                            break;
                                        default:
                                            nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                            break;
                                    }
                                }
                            };
                            LinearLayout linearLayout2 = new LinearLayout(nmpwovhVar2);
                            linearLayout2.setOrientation(1);
                            linearLayout2.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical));
                            linearLayout2.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.czidoiw(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_radius)));
                            LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa3.setGravity(48);
                            ImageView imageView2 = new ImageView(nmpwovhVar2);
                            imageView2.setImageResource(R.drawable.ic_android_tools);
                            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            linearLayoutLvtqoqa3.addView(imageView2, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size)));
                            LinearLayout linearLayout3 = new LinearLayout(nmpwovhVar2);
                            linearLayout3.setOrientation(1);
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_app_name), 20, x.zamkzqg.zngzleo(nmpwovhVar2), true));
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_subtitle), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_version, str13), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                            layoutParams3.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_gap);
                            linearLayoutLvtqoqa3.addView(linearLayout3, layoutParams3);
                            View viewBtazysh = x.zamkzqg.btazysh(nmpwovhVar2, R.drawable.ic_close, x.zamkzqg.zngzleo(nmpwovhVar2), R.string.about_close, null);
                            viewBtazysh.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.atntgcp(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_radius)));
                            linearLayoutLvtqoqa3.addView(viewBtazysh, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size)));
                            linearLayout2.addView(linearLayoutLvtqoqa3);
                            View view3 = new View(nmpwovhVar2);
                            view3.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 1);
                            layoutParams4.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_header_bottom_gap);
                            layoutParams4.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            linearLayout2.addView(view3, layoutParams4);
                            LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa4.setGravity(16);
                            linearLayoutLvtqoqa4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_join_us_on), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud5 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_telegram_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud5.setGravity(17);
                            textViewOxoagud5.setClickable(true);
                            textViewOxoagud5.setFocusable(true);
                            textViewOxoagud5.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud5);
                            textViewOxoagud5.setOnClickListener(onClickListener);
                            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams5.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                            linearLayoutLvtqoqa4.addView(textViewOxoagud5, layoutParams5);
                            linearLayout2.addView(linearLayoutLvtqoqa4);
                            LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa5.setGravity(16);
                            linearLayoutLvtqoqa5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_intro), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud6 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud6.setGravity(17);
                            textViewOxoagud6.setClickable(true);
                            textViewOxoagud6.setFocusable(true);
                            textViewOxoagud6.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud6);
                            textViewOxoagud6.setOnClickListener(onClickListener2);
                            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams6.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                            linearLayoutLvtqoqa5.addView(textViewOxoagud6, layoutParams6);
                            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams7.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical);
                            linearLayout2.addView(linearLayoutLvtqoqa5, layoutParams7);
                            ljhdwjr ljhdwjrVar = new ljhdwjr(nmpwovhVar2);
                            ljhdwjrVar.setContentDescription(nmpwovhVar2.getString(R.string.creator_logo_content_description));
                            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size));
                            layoutParams8.gravity = 1;
                            layoutParams8.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_top_gap);
                            linearLayout2.addView(ljhdwjrVar, layoutParams8);
                            ljhdwjrVar.ojyssqt(true);
                            View view4 = new View(nmpwovhVar2);
                            view4.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, 1);
                            layoutParams9.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            layoutParams9.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            linearLayout2.addView(view4, layoutParams9);
                            linearLayout2.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credits_title), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), true));
                            linearLayout2.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_android), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            linearLayout2.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_ui_design), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            linearLayout2.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_core), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud7 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_summary), 12, x.zamkzqg.zngzleo(nmpwovhVar2), true);
                            textViewOxoagud7.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap), 0, 0);
                            linearLayout2.addView(textViewOxoagud7);
                            linearLayout2.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_notice), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            TextView textViewOxoagud8 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_view_license), 12, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud8.setClickable(true);
                            textViewOxoagud8.setFocusable(true);
                            textViewOxoagud8.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), 0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud8);
                            textViewOxoagud8.setOnClickListener(new x.nmpwovh(nmpwovhVar2, 0));
                            linearLayout2.addView(textViewOxoagud8);
                            ScrollView scrollView2 = new ScrollView(nmpwovhVar2);
                            scrollView2.setFillViewport(false);
                            scrollView2.setClipToPadding(false);
                            scrollView2.addView(linearLayout2, new FrameLayout.LayoutParams(-1, -2));
                            AlertDialog alertDialogCreate = new AlertDialog.Builder(nmpwovhVar2).setView(scrollView2).create();
                            viewBtazysh.setOnClickListener(new x.nmpwovh(alertDialogCreate, 1));
                            alertDialogCreate.setOnShowListener(new x.ojyssqt(alertDialogCreate, 0));
                            alertDialogCreate.show();
                            break;
                        default:
                            Pattern pattern = x.iivesaq.nmpwovh;
                            new Thread(new lthborb(gepzcpdVar3.nmpwovh, z3, i20), "rynx-update-check").start();
                            break;
                    }
                }
            });
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(1);
            linearLayout2.addView(x.zamkzqg.oxoagud(this, getString(R.string.settings_language), 13, x.zamkzqg.zngzleo(this), false));
            linearLayout2.addView(x.zamkzqg.oxoagud(this, getString(R.string.settings_language_desc), 11, x.zamkzqg.jbmzxye(this), false));
            linearLayoutLvtqoqa2.addView(linearLayout2, new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textViewOxoagud5 = x.zamkzqg.oxoagud(this, string4, 11, x.zamkzqg.nmpwovh(this), true);
            textViewOxoagud5.setGravity(8388629);
            linearLayoutLvtqoqa2.addView(textViewOxoagud5);
            TextView textViewOxoagud6 = x.zamkzqg.oxoagud(this, "›", 22, x.zamkzqg.jbmzxye(this), false);
            textViewOxoagud6.setPadding(x.zamkzqg.qunltjs(this, 8), 0, 0, 0);
            linearLayoutLvtqoqa2.addView(textViewOxoagud6);
            Zwaqeaz3.addView(linearLayoutLvtqoqa2);
            r11.addView(Zwaqeaz3, x.zamkzqg.uiqyzsp(this));
            r11.addView(x.zamkzqg.hknanqb(this, R.string.settings_storage_section));
            LinearLayout linearLayoutZwaqeaz3 = x.zamkzqg.zwaqeaz(this);
            TextView textViewOxoagud7 = x.zamkzqg.oxoagud(this, str8, 12, x.zamkzqg.zngzleo(this), false);
            linearLayoutZwaqeaz3.addView(x.zamkzqg.lpkdqgx(this, R.string.settings_storage_status));
            textViewOxoagud7.setPadding(0, x.zamkzqg.qunltjs(this, 4), 0, x.zamkzqg.qunltjs(this, 12));
            linearLayoutZwaqeaz3.addView(textViewOxoagud7);
            int iNmpwovh4 = x.zamkzqg.nmpwovh(this);
            final int i20 = 1;
            TextView textViewLclupha = x.zamkzqg.lclupha(this, getString(R.string.settings_storage_manage), new View.OnClickListener() { // from class: x.snilumr
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    String str12;
                    int i21 = 2;
                    gepzcpd gepzcpdVar3 = gepzcpdVar;
                    boolean z3 = true;
                    char c = 1;
                    final int i22 = 0;
                    switch (i20) {
                        case 0:
                            String[] strArr5 = {"system", "en", "id"};
                            com.rynx.app.nmpwovh nmpwovhVar = gepzcpdVar3.nmpwovh;
                            CharSequence[] charSequenceArr = {nmpwovhVar.getString(R.string.settings_language_system), nmpwovhVar.getString(R.string.settings_language_english), nmpwovhVar.getString(R.string.settings_language_indonesian)};
                            String strJxvdcpb = x.zamkzqg.jxvdcpb(nmpwovhVar);
                            int i23 = 0;
                            while (i23 < 3) {
                                if (strArr5[i23].equals(strJxvdcpb)) {
                                    new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i23, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                                } else {
                                    i23++;
                                }
                                break;
                            }
                            i23 = 0;
                            new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i23, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                            break;
                        case 1:
                            gepzcpdVar3.nmpwovh.sthdtww();
                            break;
                        case 2:
                            final com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                            nmpwovhVar2.getClass();
                            try {
                                str12 = nmpwovhVar2.getPackageManager().getPackageInfo(nmpwovhVar2.getPackageName(), 0).versionName;
                            } catch (Throwable unused3) {
                                str12 = "";
                            }
                            String str13 = str12 != null ? str12 : "";
                            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.ysluikv
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    switch (i22) {
                                        case 0:
                                            nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                            break;
                                        default:
                                            nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                            break;
                                    }
                                }
                            };
                            final int c2 = c != 0 ? 1 : 0;
                            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.ysluikv
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    switch (c2) {
                                        case 0:
                                            nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                            break;
                                        default:
                                            nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                            break;
                                    }
                                }
                            };
                            LinearLayout linearLayout3 = new LinearLayout(nmpwovhVar2);
                            linearLayout3.setOrientation(1);
                            linearLayout3.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical));
                            linearLayout3.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.czidoiw(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_radius)));
                            LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa3.setGravity(48);
                            ImageView imageView2 = new ImageView(nmpwovhVar2);
                            imageView2.setImageResource(R.drawable.ic_android_tools);
                            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            linearLayoutLvtqoqa3.addView(imageView2, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size)));
                            LinearLayout linearLayout4 = new LinearLayout(nmpwovhVar2);
                            linearLayout4.setOrientation(1);
                            linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_app_name), 20, x.zamkzqg.zngzleo(nmpwovhVar2), true));
                            linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_subtitle), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_version, str13), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                            layoutParams3.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_gap);
                            linearLayoutLvtqoqa3.addView(linearLayout4, layoutParams3);
                            View viewBtazysh = x.zamkzqg.btazysh(nmpwovhVar2, R.drawable.ic_close, x.zamkzqg.zngzleo(nmpwovhVar2), R.string.about_close, null);
                            viewBtazysh.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.atntgcp(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_radius)));
                            linearLayoutLvtqoqa3.addView(viewBtazysh, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size)));
                            linearLayout3.addView(linearLayoutLvtqoqa3);
                            View view3 = new View(nmpwovhVar2);
                            view3.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 1);
                            layoutParams4.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_header_bottom_gap);
                            layoutParams4.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            linearLayout3.addView(view3, layoutParams4);
                            LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa4.setGravity(16);
                            linearLayoutLvtqoqa4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_join_us_on), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud8 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_telegram_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud8.setGravity(17);
                            textViewOxoagud8.setClickable(true);
                            textViewOxoagud8.setFocusable(true);
                            textViewOxoagud8.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud8);
                            textViewOxoagud8.setOnClickListener(onClickListener);
                            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams5.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                            linearLayoutLvtqoqa4.addView(textViewOxoagud8, layoutParams5);
                            linearLayout3.addView(linearLayoutLvtqoqa4);
                            LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa5.setGravity(16);
                            linearLayoutLvtqoqa5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_intro), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud9 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud9.setGravity(17);
                            textViewOxoagud9.setClickable(true);
                            textViewOxoagud9.setFocusable(true);
                            textViewOxoagud9.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud9);
                            textViewOxoagud9.setOnClickListener(onClickListener2);
                            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams6.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                            linearLayoutLvtqoqa5.addView(textViewOxoagud9, layoutParams6);
                            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams7.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical);
                            linearLayout3.addView(linearLayoutLvtqoqa5, layoutParams7);
                            ljhdwjr ljhdwjrVar = new ljhdwjr(nmpwovhVar2);
                            ljhdwjrVar.setContentDescription(nmpwovhVar2.getString(R.string.creator_logo_content_description));
                            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size));
                            layoutParams8.gravity = 1;
                            layoutParams8.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_top_gap);
                            linearLayout3.addView(ljhdwjrVar, layoutParams8);
                            ljhdwjrVar.ojyssqt(true);
                            View view4 = new View(nmpwovhVar2);
                            view4.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, 1);
                            layoutParams9.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            layoutParams9.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            linearLayout3.addView(view4, layoutParams9);
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credits_title), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), true));
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_android), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_ui_design), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_core), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud10 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_summary), 12, x.zamkzqg.zngzleo(nmpwovhVar2), true);
                            textViewOxoagud10.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap), 0, 0);
                            linearLayout3.addView(textViewOxoagud10);
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_notice), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            TextView textViewOxoagud11 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_view_license), 12, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud11.setClickable(true);
                            textViewOxoagud11.setFocusable(true);
                            textViewOxoagud11.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), 0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud11);
                            textViewOxoagud11.setOnClickListener(new x.nmpwovh(nmpwovhVar2, 0));
                            linearLayout3.addView(textViewOxoagud11);
                            ScrollView scrollView2 = new ScrollView(nmpwovhVar2);
                            scrollView2.setFillViewport(false);
                            scrollView2.setClipToPadding(false);
                            scrollView2.addView(linearLayout3, new FrameLayout.LayoutParams(-1, -2));
                            AlertDialog alertDialogCreate = new AlertDialog.Builder(nmpwovhVar2).setView(scrollView2).create();
                            viewBtazysh.setOnClickListener(new x.nmpwovh(alertDialogCreate, 1));
                            alertDialogCreate.setOnShowListener(new x.ojyssqt(alertDialogCreate, 0));
                            alertDialogCreate.show();
                            break;
                        default:
                            Pattern pattern = x.iivesaq.nmpwovh;
                            new Thread(new lthborb(gepzcpdVar3.nmpwovh, z3, i21), "rynx-update-check").start();
                            break;
                    }
                }
            });
            x.zamkzqg.enxkjpu(this, textViewLclupha, R.drawable.ic_file, iNmpwovh4);
            linearLayoutZwaqeaz3.addView(textViewLclupha, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
            r11.addView(linearLayoutZwaqeaz3, x.zamkzqg.uiqyzsp(this));
            r11.addView(x.zamkzqg.hknanqb(this, R.string.settings_about_section));
            LinearLayout Zwaqeaz4 = x.zamkzqg.zwaqeaz(this);
            LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(this);
            linearLayoutLvtqoqa3.setGravity(16);
            linearLayoutLvtqoqa3.setClickable(true);
            linearLayoutLvtqoqa3.setFocusable(true);
            x.zamkzqg.utmeivs(this, linearLayoutLvtqoqa3);
            final int i21 = 2;
            linearLayoutLvtqoqa3.setOnClickListener(new View.OnClickListener() { // from class: x.snilumr
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    String str12;
                    int i22 = 2;
                    gepzcpd gepzcpdVar3 = gepzcpdVar;
                    boolean z3 = true;
                    char c = 1;
                    final int i23 = 0;
                    switch (i21) {
                        case 0:
                            String[] strArr5 = {"system", "en", "id"};
                            com.rynx.app.nmpwovh nmpwovhVar = gepzcpdVar3.nmpwovh;
                            CharSequence[] charSequenceArr = {nmpwovhVar.getString(R.string.settings_language_system), nmpwovhVar.getString(R.string.settings_language_english), nmpwovhVar.getString(R.string.settings_language_indonesian)};
                            String strJxvdcpb = x.zamkzqg.jxvdcpb(nmpwovhVar);
                            int i24 = 0;
                            while (i24 < 3) {
                                if (strArr5[i24].equals(strJxvdcpb)) {
                                    new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i24, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                                } else {
                                    i24++;
                                }
                                break;
                            }
                            i24 = 0;
                            new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i24, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                            break;
                        case 1:
                            gepzcpdVar3.nmpwovh.sthdtww();
                            break;
                        case 2:
                            final com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                            nmpwovhVar2.getClass();
                            try {
                                str12 = nmpwovhVar2.getPackageManager().getPackageInfo(nmpwovhVar2.getPackageName(), 0).versionName;
                            } catch (Throwable unused3) {
                                str12 = "";
                            }
                            String str13 = str12 != null ? str12 : "";
                            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.ysluikv
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    switch (i23) {
                                        case 0:
                                            nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                            break;
                                        default:
                                            nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                            break;
                                    }
                                }
                            };
                            final int c2 = c != 0 ? 1 : 0;
                            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.ysluikv
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    switch (c2) {
                                        case 0:
                                            nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                            break;
                                        default:
                                            nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                            break;
                                    }
                                }
                            };
                            LinearLayout linearLayout3 = new LinearLayout(nmpwovhVar2);
                            linearLayout3.setOrientation(1);
                            linearLayout3.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical));
                            linearLayout3.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.czidoiw(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_radius)));
                            LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa4.setGravity(48);
                            ImageView imageView2 = new ImageView(nmpwovhVar2);
                            imageView2.setImageResource(R.drawable.ic_android_tools);
                            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            linearLayoutLvtqoqa4.addView(imageView2, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size)));
                            LinearLayout linearLayout4 = new LinearLayout(nmpwovhVar2);
                            linearLayout4.setOrientation(1);
                            linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_app_name), 20, x.zamkzqg.zngzleo(nmpwovhVar2), true));
                            linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_subtitle), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_version, str13), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                            layoutParams3.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_gap);
                            linearLayoutLvtqoqa4.addView(linearLayout4, layoutParams3);
                            View viewBtazysh = x.zamkzqg.btazysh(nmpwovhVar2, R.drawable.ic_close, x.zamkzqg.zngzleo(nmpwovhVar2), R.string.about_close, null);
                            viewBtazysh.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.atntgcp(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_radius)));
                            linearLayoutLvtqoqa4.addView(viewBtazysh, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size)));
                            linearLayout3.addView(linearLayoutLvtqoqa4);
                            View view3 = new View(nmpwovhVar2);
                            view3.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 1);
                            layoutParams4.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_header_bottom_gap);
                            layoutParams4.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            linearLayout3.addView(view3, layoutParams4);
                            LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa5.setGravity(16);
                            linearLayoutLvtqoqa5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_join_us_on), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud8 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_telegram_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud8.setGravity(17);
                            textViewOxoagud8.setClickable(true);
                            textViewOxoagud8.setFocusable(true);
                            textViewOxoagud8.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud8);
                            textViewOxoagud8.setOnClickListener(onClickListener);
                            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams5.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                            linearLayoutLvtqoqa5.addView(textViewOxoagud8, layoutParams5);
                            linearLayout3.addView(linearLayoutLvtqoqa5);
                            LinearLayout linearLayoutLvtqoqa6 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa6.setGravity(16);
                            linearLayoutLvtqoqa6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_intro), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud9 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud9.setGravity(17);
                            textViewOxoagud9.setClickable(true);
                            textViewOxoagud9.setFocusable(true);
                            textViewOxoagud9.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud9);
                            textViewOxoagud9.setOnClickListener(onClickListener2);
                            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams6.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                            linearLayoutLvtqoqa6.addView(textViewOxoagud9, layoutParams6);
                            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams7.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical);
                            linearLayout3.addView(linearLayoutLvtqoqa6, layoutParams7);
                            ljhdwjr ljhdwjrVar = new ljhdwjr(nmpwovhVar2);
                            ljhdwjrVar.setContentDescription(nmpwovhVar2.getString(R.string.creator_logo_content_description));
                            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size));
                            layoutParams8.gravity = 1;
                            layoutParams8.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_top_gap);
                            linearLayout3.addView(ljhdwjrVar, layoutParams8);
                            ljhdwjrVar.ojyssqt(true);
                            View view4 = new View(nmpwovhVar2);
                            view4.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, 1);
                            layoutParams9.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            layoutParams9.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            linearLayout3.addView(view4, layoutParams9);
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credits_title), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), true));
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_android), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_ui_design), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_core), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud10 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_summary), 12, x.zamkzqg.zngzleo(nmpwovhVar2), true);
                            textViewOxoagud10.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap), 0, 0);
                            linearLayout3.addView(textViewOxoagud10);
                            linearLayout3.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_notice), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            TextView textViewOxoagud11 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_view_license), 12, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud11.setClickable(true);
                            textViewOxoagud11.setFocusable(true);
                            textViewOxoagud11.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), 0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud11);
                            textViewOxoagud11.setOnClickListener(new x.nmpwovh(nmpwovhVar2, 0));
                            linearLayout3.addView(textViewOxoagud11);
                            ScrollView scrollView2 = new ScrollView(nmpwovhVar2);
                            scrollView2.setFillViewport(false);
                            scrollView2.setClipToPadding(false);
                            scrollView2.addView(linearLayout3, new FrameLayout.LayoutParams(-1, -2));
                            AlertDialog alertDialogCreate = new AlertDialog.Builder(nmpwovhVar2).setView(scrollView2).create();
                            viewBtazysh.setOnClickListener(new x.nmpwovh(alertDialogCreate, 1));
                            alertDialogCreate.setOnShowListener(new x.ojyssqt(alertDialogCreate, 0));
                            alertDialogCreate.show();
                            break;
                        default:
                            Pattern pattern = x.iivesaq.nmpwovh;
                            new Thread(new lthborb(gepzcpdVar3.nmpwovh, z3, i22), "rynx-update-check").start();
                            break;
                    }
                }
            });
            ImageView imageView2 = new ImageView(this);
            imageView2.setImageResource(R.drawable.ic_info);
            imageView2.setImageTintList(ColorStateList.valueOf(x.zamkzqg.nmpwovh(this)));
            imageView2.setPadding(x.zamkzqg.qunltjs(this, 7), x.zamkzqg.qunltjs(this, 7), x.zamkzqg.qunltjs(this, 7), x.zamkzqg.qunltjs(this, 7));
            int iNmpwovh5 = x.zamkzqg.nmpwovh(this);
            if (x.zamkzqg.ysluikv(this)) {
                i5 = 35;
            } else {
                i5 = 20;
            }
            imageView2.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.uzyihoe(iNmpwovh5, i5), getColor(R.color.rynx_transparent), x.zamkzqg.qunltjs(this, 14)));
            linearLayoutLvtqoqa3.addView(imageView2, new LinearLayout.LayoutParams(x.zamkzqg.qunltjs(this, 42), x.zamkzqg.qunltjs(this, 42)));
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(1);
            linearLayout3.addView(x.zamkzqg.oxoagud(this, getString(R.string.settings_about_title), 13, x.zamkzqg.zngzleo(this), false));
            linearLayout3.addView(x.zamkzqg.oxoagud(this, getString(R.string.settings_about_desc, str9), 11, x.zamkzqg.jbmzxye(this), false));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams3.leftMargin = x.zamkzqg.qunltjs(this, 12);
            linearLayoutLvtqoqa3.addView(linearLayout3, layoutParams3);
            linearLayoutLvtqoqa3.addView(x.zamkzqg.oxoagud(this, "›", 24, x.zamkzqg.jbmzxye(this), false));
            Zwaqeaz4.addView(linearLayoutLvtqoqa3);
            Zwaqeaz4.addView(x.zamkzqg.ivvkvsj(this));
            int iNmpwovh6 = x.zamkzqg.nmpwovh(this);
            final int i22 = 3;
            TextView textViewLclupha2 = x.zamkzqg.lclupha(this, getString(R.string.settings_check_updates), new View.OnClickListener() { // from class: x.snilumr
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    String str12;
                    int i23 = 2;
                    gepzcpd gepzcpdVar3 = gepzcpdVar;
                    boolean z3 = true;
                    char c = 1;
                    final int i24 = 0;
                    switch (i22) {
                        case 0:
                            String[] strArr5 = {"system", "en", "id"};
                            com.rynx.app.nmpwovh nmpwovhVar = gepzcpdVar3.nmpwovh;
                            CharSequence[] charSequenceArr = {nmpwovhVar.getString(R.string.settings_language_system), nmpwovhVar.getString(R.string.settings_language_english), nmpwovhVar.getString(R.string.settings_language_indonesian)};
                            String strJxvdcpb = x.zamkzqg.jxvdcpb(nmpwovhVar);
                            int i25 = 0;
                            while (i25 < 3) {
                                if (strArr5[i25].equals(strJxvdcpb)) {
                                    new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i25, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                                } else {
                                    i25++;
                                }
                                break;
                            }
                            i25 = 0;
                            new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i25, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                            break;
                        case 1:
                            gepzcpdVar3.nmpwovh.sthdtww();
                            break;
                        case 2:
                            final com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                            nmpwovhVar2.getClass();
                            try {
                                str12 = nmpwovhVar2.getPackageManager().getPackageInfo(nmpwovhVar2.getPackageName(), 0).versionName;
                            } catch (Throwable unused3) {
                                str12 = "";
                            }
                            String str13 = str12 != null ? str12 : "";
                            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.ysluikv
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    switch (i24) {
                                        case 0:
                                            nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                            break;
                                        default:
                                            nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                            break;
                                    }
                                }
                            };
                            final int c2 = c != 0 ? 1 : 0;
                            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.ysluikv
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view3) {
                                    switch (c2) {
                                        case 0:
                                            nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                            break;
                                        default:
                                            nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                            break;
                                    }
                                }
                            };
                            LinearLayout linearLayout4 = new LinearLayout(nmpwovhVar2);
                            linearLayout4.setOrientation(1);
                            linearLayout4.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical));
                            linearLayout4.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.czidoiw(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_radius)));
                            LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa4.setGravity(48);
                            ImageView imageView3 = new ImageView(nmpwovhVar2);
                            imageView3.setImageResource(R.drawable.ic_android_tools);
                            imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            linearLayoutLvtqoqa4.addView(imageView3, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size)));
                            LinearLayout linearLayout5 = new LinearLayout(nmpwovhVar2);
                            linearLayout5.setOrientation(1);
                            linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_app_name), 20, x.zamkzqg.zngzleo(nmpwovhVar2), true));
                            linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_subtitle), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_version, str13), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                            layoutParams4.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_gap);
                            linearLayoutLvtqoqa4.addView(linearLayout5, layoutParams4);
                            View viewBtazysh = x.zamkzqg.btazysh(nmpwovhVar2, R.drawable.ic_close, x.zamkzqg.zngzleo(nmpwovhVar2), R.string.about_close, null);
                            viewBtazysh.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.atntgcp(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_radius)));
                            linearLayoutLvtqoqa4.addView(viewBtazysh, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size)));
                            linearLayout4.addView(linearLayoutLvtqoqa4);
                            View view3 = new View(nmpwovhVar2);
                            view3.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 1);
                            layoutParams5.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_header_bottom_gap);
                            layoutParams5.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            linearLayout4.addView(view3, layoutParams5);
                            LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa5.setGravity(16);
                            linearLayoutLvtqoqa5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_join_us_on), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud8 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_telegram_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud8.setGravity(17);
                            textViewOxoagud8.setClickable(true);
                            textViewOxoagud8.setFocusable(true);
                            textViewOxoagud8.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud8);
                            textViewOxoagud8.setOnClickListener(onClickListener);
                            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams6.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                            linearLayoutLvtqoqa5.addView(textViewOxoagud8, layoutParams6);
                            linearLayout4.addView(linearLayoutLvtqoqa5);
                            LinearLayout linearLayoutLvtqoqa6 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                            linearLayoutLvtqoqa6.setGravity(16);
                            linearLayoutLvtqoqa6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_intro), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud9 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud9.setGravity(17);
                            textViewOxoagud9.setClickable(true);
                            textViewOxoagud9.setFocusable(true);
                            textViewOxoagud9.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud9);
                            textViewOxoagud9.setOnClickListener(onClickListener2);
                            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams7.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                            linearLayoutLvtqoqa6.addView(textViewOxoagud9, layoutParams7);
                            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams8.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical);
                            linearLayout4.addView(linearLayoutLvtqoqa6, layoutParams8);
                            ljhdwjr ljhdwjrVar = new ljhdwjr(nmpwovhVar2);
                            ljhdwjrVar.setContentDescription(nmpwovhVar2.getString(R.string.creator_logo_content_description));
                            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size));
                            layoutParams9.gravity = 1;
                            layoutParams9.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_top_gap);
                            linearLayout4.addView(ljhdwjrVar, layoutParams9);
                            ljhdwjrVar.ojyssqt(true);
                            View view4 = new View(nmpwovhVar2);
                            view4.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, 1);
                            layoutParams10.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            layoutParams10.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                            linearLayout4.addView(view4, layoutParams10);
                            linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credits_title), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), true));
                            linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_android), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_ui_design), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_core), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                            TextView textViewOxoagud10 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_summary), 12, x.zamkzqg.zngzleo(nmpwovhVar2), true);
                            textViewOxoagud10.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap), 0, 0);
                            linearLayout4.addView(textViewOxoagud10);
                            linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_notice), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                            TextView textViewOxoagud11 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_view_license), 12, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                            textViewOxoagud11.setClickable(true);
                            textViewOxoagud11.setFocusable(true);
                            textViewOxoagud11.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), 0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                            x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud11);
                            textViewOxoagud11.setOnClickListener(new x.nmpwovh(nmpwovhVar2, 0));
                            linearLayout4.addView(textViewOxoagud11);
                            ScrollView scrollView2 = new ScrollView(nmpwovhVar2);
                            scrollView2.setFillViewport(false);
                            scrollView2.setClipToPadding(false);
                            scrollView2.addView(linearLayout4, new FrameLayout.LayoutParams(-1, -2));
                            AlertDialog alertDialogCreate = new AlertDialog.Builder(nmpwovhVar2).setView(scrollView2).create();
                            viewBtazysh.setOnClickListener(new x.nmpwovh(alertDialogCreate, 1));
                            alertDialogCreate.setOnShowListener(new x.ojyssqt(alertDialogCreate, 0));
                            alertDialogCreate.show();
                            break;
                        default:
                            Pattern pattern = x.iivesaq.nmpwovh;
                            new Thread(new lthborb(gepzcpdVar3.nmpwovh, z3, i23), "rynx-update-check").start();
                            break;
                    }
                }
            });
            x.zamkzqg.enxkjpu(this, textViewLclupha2, R.drawable.ic_info, iNmpwovh6);
            Zwaqeaz4.addView(textViewLclupha2, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
            r11.addView(Zwaqeaz4, x.zamkzqg.uiqyzsp(this));
            r11.addView(new View(this), new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
            this.ccuulnt = new seujokk(r33, r5, r3, textViewOxoagud5, textViewOxoagud7);
            iwjoiry();
            return this.ccuulnt.nmpwovh;
        }
        string = getString(R.string.settings_surface_amoled);
        string2 = string;
        TextView textViewOxoagud8 = x.zamkzqg.oxoagud(this, getString(R.string.settings_preview_surface_desc, string5, string2), 11, x.zamkzqg.jbmzxye(this), false);
        textViewOxoagud8.setPadding(0, x.zamkzqg.qunltjs(this, 3), 0, 0);
        linearLayout.addView(textViewOxoagud8);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams4.leftMargin = x.zamkzqg.qunltjs(this, 14);
        Lvtqoqa.addView(linearLayout, layoutParams4);
        Zwaqeaz.addView(Lvtqoqa);
        Xbdyiew.addView(Zwaqeaz, x.zamkzqg.uiqyzsp(this));
        Xbdyiew.addView(x.zamkzqg.hknanqb(this, R.string.settings_accent_color_section));
        LinearLayout Zwaqeaz5 = x.zamkzqg.zwaqeaz(this);
        Zwaqeaz5.addView(x.zamkzqg.lpkdqgx(this, R.string.settings_signature_palette));
        Zwaqeaz5.addView(x.zamkzqg.pvkaerr(this, R.string.settings_signature_palette_desc));
        lataqgmVar = new lataqgm(this, x.zamkzqg.qunltjs(this, 8), x.zamkzqg.qunltjs(this, 8));
        lataqgmVar.setPadding(0, x.zamkzqg.qunltjs(this, 12), 0, 0);
        strEzxxysz = x.zamkzqg.ezxxysz(this);
        strArr = (String[]) x.zamkzqg.nmpwovh.clone();
        length = strArr.length;
        i = 0;
        r2 = Xbdyiew;
        r4 = scrollView;
        while (i < length) {
            str2 = strArr[i];
            boolean zEquals2 = str2.equals(strEzxxysz);
            int i110 = i;
            pzqxblc pzqxblcVar2 = new pzqxblc(gepzcpdVar2, str2, 8);
            if ("auto".equals(str2)) {
                iSilhone = x.zamkzqg.silhone(str2);
                i8 = length;
                r32 = r2;
                strArr4 = strArr;
            } else {
                if (x.zamkzqg.yonoayx(this)) {
                    if (x.zamkzqg.ysluikv(this)) {
                        str3 = "system_accent1_200";
                    } else {
                        str3 = "system_accent1_600";
                    }
                    i8 = length;
                    r30 = r2;
                    strArr4 = strArr;
                    identifier = getResources().getIdentifier(str3, "color", "android");
                    if (identifier != 0) {
                        iSilhone = getColor(identifier);
                        r32 = r30;
                    }
                } else {
                    i8 = length;
                    r30 = r2;
                    strArr4 = strArr;
                }
                iSilhone = x.zamkzqg.silhone(new String[]{"azure", "cyan", "mint", "violet", "amber", "rose"}[(int) Math.floorMod(Math.floorDiv(System.currentTimeMillis(), 86400000L), 6)]);
                r31 = r30;
                int i111 = iSilhone;
                String str12 = "●  " + getString(x.zamkzqg.iwjoiry(str2));
                TextView textViewGzokllk3 = x.zamkzqg.gzokllk(this, str12, "", i111, zEquals2, pzqxblcVar2);
                SpannableString spannableString3 = new SpannableString(str12);
                spannableString3.setSpan(new ForegroundColorSpan(i111), 0, 1, 33);
                textViewGzokllk3.setText(spannableString3);
                lataqgmVar.addView(textViewGzokllk3);
                i = i110 + 1;
                r2 = r31;
                gepzcpdVar2 = gepzcpdVar2;
                str4 = str4;
                length = i8;
                strEzxxysz = strEzxxysz;
                strArr = strArr4;
                r4 = r4;
                str = str;
            }
            r31 = r32;
            int i112 = iSilhone;
            String str13 = "●  " + getString(x.zamkzqg.iwjoiry(str2));
            TextView textViewGzokllk4 = x.zamkzqg.gzokllk(this, str13, "", i112, zEquals2, pzqxblcVar2);
            SpannableString spannableString4 = new SpannableString(str13);
            spannableString4.setSpan(new ForegroundColorSpan(i112), 0, 1, 33);
            textViewGzokllk4.setText(spannableString4);
            lataqgmVar.addView(textViewGzokllk4);
            i = i110 + 1;
            r2 = r31;
            gepzcpdVar2 = gepzcpdVar2;
            str4 = str4;
            length = i8;
            strEzxxysz = strEzxxysz;
            strArr = strArr4;
            r4 = r4;
            str = str;
        }
        LinearLayout r12 = r2;
        ScrollView r34 = r4;
        String str14 = str4;
        String str15 = str;
        gepzcpdVar = gepzcpdVar2;
        Zwaqeaz5.addView(lataqgmVar, new LinearLayout.LayoutParams(-1, -2));
        r12.addView(Zwaqeaz5, x.zamkzqg.uiqyzsp(this));
        r12.addView(x.zamkzqg.hknanqb(this, R.string.settings_card_surface_section));
        LinearLayout linearLayoutZwaqeaz4 = x.zamkzqg.zwaqeaz(this);
        linearLayoutZwaqeaz4.addView(x.zamkzqg.lpkdqgx(this, R.string.settings_corner_curvature));
        linearLayoutZwaqeaz4.addView(x.zamkzqg.pvkaerr(this, R.string.settings_corner_curvature_desc));
        lataqgmVar2 = new lataqgm(this, x.zamkzqg.qunltjs(this, 8), x.zamkzqg.qunltjs(this, 8));
        lataqgmVar2.setPadding(0, x.zamkzqg.qunltjs(this, 11), 0, 0);
        iNhhacgu = x.zamkzqg.nhhacgu(this);
        iArr = new int[]{10, 16, 22, 28};
        iArr2 = new int[]{R.string.settings_radius_sharp, R.string.settings_radius_classic, R.string.settings_radius_squircle, R.string.settings_radius_pill};
        strArr2 = new String[]{"□", "▢", "▣", "○"};
        i2 = 0;
        linearLayoutZwaqeaz4.addView(lataqgmVar2, new LinearLayout.LayoutParams(-1, -2));
        linearLayoutZwaqeaz4.addView(x.zamkzqg.ivvkvsj(this));
        linearLayoutZwaqeaz4.addView(x.zamkzqg.lpkdqgx(this, R.string.settings_surface_visual_style));
        linearLayoutZwaqeaz4.addView(x.zamkzqg.pvkaerr(this, R.string.settings_surface_visual_style_desc));
        lataqgmVar3 = new lataqgm(this, x.zamkzqg.qunltjs(this, 8), x.zamkzqg.qunltjs(this, 8));
        lataqgmVar3.setPadding(0, x.zamkzqg.qunltjs(this, 11), 0, 0);
        iNsizane = x.zamkzqg.nsizane(this);
        iArr3 = new int[]{0, 1, 2, 3};
        iArr4 = new int[]{R.string.settings_surface_amoled, R.string.settings_surface_glass, R.string.settings_surface_neon, R.string.settings_surface_slate};
        strArr3 = new String[]{"◔", "░", "✦", "◇"};
        i4 = 0;
        while (i4 < i3) {
            i6 = iArr3[i4];
            String string8 = getString(iArr4[i4]);
            String str16 = strArr3[i4];
            int iNmpwovh7 = x.zamkzqg.nmpwovh(this);
            int i113 = i4;
            if (iNsizane == i6) {
                z = true;
            } else {
                z = false;
            }
            int i114 = iNsizane;
            final int i115 = 1;
            final int i6site4 = i6;
            lataqgmVar3.addView(x.zamkzqg.gzokllk(this, string8, str16, iNmpwovh7, z, new View.OnClickListener() { // from class: x.tqcgjht
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i115) {
                        case 0:
                            com.rynx.app.nmpwovh nmpwovhVar = gepzcpdVar.nmpwovh;
                            nmpwovhVar.getClass();
                            int iNhhacgu2 = x.zamkzqg.nhhacgu(nmpwovhVar);
                            int i116 = i6site4;
                            if (iNhhacgu2 != i116) {
                                if (i116 != 10 && i116 != 16 && i116 != 28) {
                                    i116 = 22;
                                }
                                nmpwovhVar.getSharedPreferences("rynx_ui", 0).edit().putInt("card_radius_dp", i116).apply();
                                nmpwovhVar.zftrkmx();
                                break;
                            }
                            break;
                        default:
                            com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar.nmpwovh;
                            nmpwovhVar2.getClass();
                            int iNsizane3 = x.zamkzqg.nsizane(nmpwovhVar2);
                            int i117 = i6site4;
                            if (iNsizane3 != i117) {
                                if (i117 < 0 || i117 > 3) {
                                    i117 = 3;
                                }
                                nmpwovhVar2.getSharedPreferences("rynx_ui", 0).edit().putInt("surface_style", i117).apply();
                                nmpwovhVar2.zftrkmx();
                                break;
                            }
                            break;
                    }
                }
            }));
            i4 = i113 + 1;
            iNsizane = i114;
        }
        linearLayoutZwaqeaz4.addView(lataqgmVar3, new LinearLayout.LayoutParams(-1, -2));
        r12.addView(linearLayoutZwaqeaz4, x.zamkzqg.uiqyzsp(this));
        r12.addView(x.zamkzqg.hknanqb(this, R.string.settings_visual_elements_section));
        LinearLayout linearLayoutZwaqeaz5 = x.zamkzqg.zwaqeaz(this);
        LinearLayout linearLayoutEdnetju3 = x.zamkzqg.ednetju(this, R.string.settings_ambient_halo, R.string.settings_ambient_halo_desc, x.zamkzqg.jlgwuft(this));
        Switch r6 = (Switch) linearLayoutEdnetju3.getTag();
        r6.setOnCheckedChangeListener(new fadblxi(gepzcpdVar, 0));
        linearLayoutZwaqeaz5.addView(linearLayoutEdnetju3);
        r12.addView(linearLayoutZwaqeaz5, x.zamkzqg.uiqyzsp(this));
        r12.addView(x.zamkzqg.hknanqb(this, R.string.settings_theme_section));
        LinearLayout Zwaqeaz6 = x.zamkzqg.zwaqeaz(this);
        LinearLayout linearLayoutEdnetju4 = x.zamkzqg.ednetju(this, R.string.settings_dark_mode, R.string.settings_dark_mode_desc, zYsluikv);
        Switch r7 = (Switch) linearLayoutEdnetju4.getTag();
        r7.setOnCheckedChangeListener(new fadblxi(gepzcpdVar, 1));
        Zwaqeaz6.addView(linearLayoutEdnetju4);
        Zwaqeaz6.addView(x.zamkzqg.ivvkvsj(this));
        LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(this);
        linearLayoutLvtqoqa4.setGravity(16);
        linearLayoutLvtqoqa4.setClickable(true);
        linearLayoutLvtqoqa4.setFocusable(true);
        x.zamkzqg.utmeivs(this, linearLayoutLvtqoqa4);
        final int i116 = 0;
        linearLayoutLvtqoqa4.setOnClickListener(new View.OnClickListener() { // from class: x.snilumr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String str17;
                int i23 = 2;
                gepzcpd gepzcpdVar3 = gepzcpdVar;
                boolean z3 = true;
                char c = 1;
                final int i24 = 0;
                switch (i116) {
                    case 0:
                        String[] strArr5 = {"system", "en", "id"};
                        com.rynx.app.nmpwovh nmpwovhVar = gepzcpdVar3.nmpwovh;
                        CharSequence[] charSequenceArr = {nmpwovhVar.getString(R.string.settings_language_system), nmpwovhVar.getString(R.string.settings_language_english), nmpwovhVar.getString(R.string.settings_language_indonesian)};
                        String strJxvdcpb = x.zamkzqg.jxvdcpb(nmpwovhVar);
                        int i25 = 0;
                        while (i25 < 3) {
                            if (strArr5[i25].equals(strJxvdcpb)) {
                                new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i25, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                            } else {
                                i25++;
                            }
                            break;
                        }
                        i25 = 0;
                        new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i25, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                        break;
                    case 1:
                        gepzcpdVar3.nmpwovh.sthdtww();
                        break;
                    case 2:
                        final com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                        nmpwovhVar2.getClass();
                        try {
                            str17 = nmpwovhVar2.getPackageManager().getPackageInfo(nmpwovhVar2.getPackageName(), 0).versionName;
                        } catch (Throwable unused3) {
                            str17 = "";
                        }
                        String str18 = str17 != null ? str17 : "";
                        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.ysluikv
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                switch (i24) {
                                    case 0:
                                        nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                        break;
                                    default:
                                        nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                        break;
                                }
                            }
                        };
                        final int c2 = c != 0 ? 1 : 0;
                        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.ysluikv
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                switch (c2) {
                                    case 0:
                                        nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                        break;
                                    default:
                                        nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                        break;
                                }
                            }
                        };
                        LinearLayout linearLayout4 = new LinearLayout(nmpwovhVar2);
                        linearLayout4.setOrientation(1);
                        linearLayout4.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical));
                        linearLayout4.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.czidoiw(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_radius)));
                        LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa5.setGravity(48);
                        ImageView imageView3 = new ImageView(nmpwovhVar2);
                        imageView3.setImageResource(R.drawable.ic_android_tools);
                        imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        linearLayoutLvtqoqa5.addView(imageView3, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size)));
                        LinearLayout linearLayout5 = new LinearLayout(nmpwovhVar2);
                        linearLayout5.setOrientation(1);
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_app_name), 20, x.zamkzqg.zngzleo(nmpwovhVar2), true));
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_subtitle), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_version, str18), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                        layoutParams5.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_gap);
                        linearLayoutLvtqoqa5.addView(linearLayout5, layoutParams5);
                        View viewBtazysh = x.zamkzqg.btazysh(nmpwovhVar2, R.drawable.ic_close, x.zamkzqg.zngzleo(nmpwovhVar2), R.string.about_close, null);
                        viewBtazysh.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.atntgcp(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_radius)));
                        linearLayoutLvtqoqa5.addView(viewBtazysh, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size)));
                        linearLayout4.addView(linearLayoutLvtqoqa5);
                        View view3 = new View(nmpwovhVar2);
                        view3.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 1);
                        layoutParams6.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_header_bottom_gap);
                        layoutParams6.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        linearLayout4.addView(view3, layoutParams6);
                        LinearLayout linearLayoutLvtqoqa6 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa6.setGravity(16);
                        linearLayoutLvtqoqa6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_join_us_on), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud9 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_telegram_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud9.setGravity(17);
                        textViewOxoagud9.setClickable(true);
                        textViewOxoagud9.setFocusable(true);
                        textViewOxoagud9.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud9);
                        textViewOxoagud9.setOnClickListener(onClickListener);
                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams7.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                        linearLayoutLvtqoqa6.addView(textViewOxoagud9, layoutParams7);
                        linearLayout4.addView(linearLayoutLvtqoqa6);
                        LinearLayout linearLayoutLvtqoqa7 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa7.setGravity(16);
                        linearLayoutLvtqoqa7.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_intro), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud10 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud10.setGravity(17);
                        textViewOxoagud10.setClickable(true);
                        textViewOxoagud10.setFocusable(true);
                        textViewOxoagud10.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud10);
                        textViewOxoagud10.setOnClickListener(onClickListener2);
                        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams8.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                        linearLayoutLvtqoqa7.addView(textViewOxoagud10, layoutParams8);
                        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams9.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical);
                        linearLayout4.addView(linearLayoutLvtqoqa7, layoutParams9);
                        ljhdwjr ljhdwjrVar = new ljhdwjr(nmpwovhVar2);
                        ljhdwjrVar.setContentDescription(nmpwovhVar2.getString(R.string.creator_logo_content_description));
                        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size));
                        layoutParams10.gravity = 1;
                        layoutParams10.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_top_gap);
                        linearLayout4.addView(ljhdwjrVar, layoutParams10);
                        ljhdwjrVar.ojyssqt(true);
                        View view4 = new View(nmpwovhVar2);
                        view4.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, 1);
                        layoutParams11.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        layoutParams11.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        linearLayout4.addView(view4, layoutParams11);
                        linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credits_title), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), true));
                        linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_android), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_ui_design), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_core), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud11 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_summary), 12, x.zamkzqg.zngzleo(nmpwovhVar2), true);
                        textViewOxoagud11.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap), 0, 0);
                        linearLayout4.addView(textViewOxoagud11);
                        linearLayout4.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_notice), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        TextView textViewOxoagud12 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_view_license), 12, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud12.setClickable(true);
                        textViewOxoagud12.setFocusable(true);
                        textViewOxoagud12.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), 0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud12);
                        textViewOxoagud12.setOnClickListener(new x.nmpwovh(nmpwovhVar2, 0));
                        linearLayout4.addView(textViewOxoagud12);
                        ScrollView scrollView2 = new ScrollView(nmpwovhVar2);
                        scrollView2.setFillViewport(false);
                        scrollView2.setClipToPadding(false);
                        scrollView2.addView(linearLayout4, new FrameLayout.LayoutParams(-1, -2));
                        AlertDialog alertDialogCreate = new AlertDialog.Builder(nmpwovhVar2).setView(scrollView2).create();
                        viewBtazysh.setOnClickListener(new x.nmpwovh(alertDialogCreate, 1));
                        alertDialogCreate.setOnShowListener(new x.ojyssqt(alertDialogCreate, 0));
                        alertDialogCreate.show();
                        break;
                    default:
                        Pattern pattern = x.iivesaq.nmpwovh;
                        new Thread(new lthborb(gepzcpdVar3.nmpwovh, z3, i23), "rynx-update-check").start();
                        break;
                }
            }
        });
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setOrientation(1);
        linearLayout4.addView(x.zamkzqg.oxoagud(this, getString(R.string.settings_language), 13, x.zamkzqg.zngzleo(this), false));
        linearLayout4.addView(x.zamkzqg.oxoagud(this, getString(R.string.settings_language_desc), 11, x.zamkzqg.jbmzxye(this), false));
        linearLayoutLvtqoqa4.addView(linearLayout4, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textViewOxoagud9 = x.zamkzqg.oxoagud(this, string4, 11, x.zamkzqg.nmpwovh(this), true);
        textViewOxoagud9.setGravity(8388629);
        linearLayoutLvtqoqa4.addView(textViewOxoagud9);
        TextView textViewOxoagud10 = x.zamkzqg.oxoagud(this, "›", 22, x.zamkzqg.jbmzxye(this), false);
        textViewOxoagud10.setPadding(x.zamkzqg.qunltjs(this, 8), 0, 0, 0);
        linearLayoutLvtqoqa4.addView(textViewOxoagud10);
        Zwaqeaz6.addView(linearLayoutLvtqoqa4);
        r12.addView(Zwaqeaz6, x.zamkzqg.uiqyzsp(this));
        r12.addView(x.zamkzqg.hknanqb(this, R.string.settings_storage_section));
        LinearLayout linearLayoutZwaqeaz6 = x.zamkzqg.zwaqeaz(this);
        TextView textViewOxoagud11 = x.zamkzqg.oxoagud(this, str14, 12, x.zamkzqg.zngzleo(this), false);
        linearLayoutZwaqeaz6.addView(x.zamkzqg.lpkdqgx(this, R.string.settings_storage_status));
        textViewOxoagud11.setPadding(0, x.zamkzqg.qunltjs(this, 4), 0, x.zamkzqg.qunltjs(this, 12));
        linearLayoutZwaqeaz6.addView(textViewOxoagud11);
        int iNmpwovh8 = x.zamkzqg.nmpwovh(this);
        final int i23 = 1;
        TextView textViewLclupha3 = x.zamkzqg.lclupha(this, getString(R.string.settings_storage_manage), new View.OnClickListener() { // from class: x.snilumr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String str17;
                int i24 = 2;
                gepzcpd gepzcpdVar3 = gepzcpdVar;
                boolean z3 = true;
                char c = 1;
                final int i25 = 0;
                switch (i23) {
                    case 0:
                        String[] strArr5 = {"system", "en", "id"};
                        com.rynx.app.nmpwovh nmpwovhVar = gepzcpdVar3.nmpwovh;
                        CharSequence[] charSequenceArr = {nmpwovhVar.getString(R.string.settings_language_system), nmpwovhVar.getString(R.string.settings_language_english), nmpwovhVar.getString(R.string.settings_language_indonesian)};
                        String strJxvdcpb = x.zamkzqg.jxvdcpb(nmpwovhVar);
                        int i26 = 0;
                        while (i26 < 3) {
                            if (strArr5[i26].equals(strJxvdcpb)) {
                                new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i26, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                            } else {
                                i26++;
                            }
                            break;
                        }
                        i26 = 0;
                        new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i26, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                        break;
                    case 1:
                        gepzcpdVar3.nmpwovh.sthdtww();
                        break;
                    case 2:
                        final com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                        nmpwovhVar2.getClass();
                        try {
                            str17 = nmpwovhVar2.getPackageManager().getPackageInfo(nmpwovhVar2.getPackageName(), 0).versionName;
                        } catch (Throwable unused3) {
                            str17 = "";
                        }
                        String str18 = str17 != null ? str17 : "";
                        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.ysluikv
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                switch (i25) {
                                    case 0:
                                        nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                        break;
                                    default:
                                        nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                        break;
                                }
                            }
                        };
                        final int c2 = c != 0 ? 1 : 0;
                        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.ysluikv
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                switch (c2) {
                                    case 0:
                                        nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                        break;
                                    default:
                                        nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                        break;
                                }
                            }
                        };
                        LinearLayout linearLayout5 = new LinearLayout(nmpwovhVar2);
                        linearLayout5.setOrientation(1);
                        linearLayout5.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical));
                        linearLayout5.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.czidoiw(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_radius)));
                        LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa5.setGravity(48);
                        ImageView imageView3 = new ImageView(nmpwovhVar2);
                        imageView3.setImageResource(R.drawable.ic_android_tools);
                        imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        linearLayoutLvtqoqa5.addView(imageView3, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size)));
                        LinearLayout linearLayout6 = new LinearLayout(nmpwovhVar2);
                        linearLayout6.setOrientation(1);
                        linearLayout6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_app_name), 20, x.zamkzqg.zngzleo(nmpwovhVar2), true));
                        linearLayout6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_subtitle), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        linearLayout6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_version, str18), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                        layoutParams5.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_gap);
                        linearLayoutLvtqoqa5.addView(linearLayout6, layoutParams5);
                        View viewBtazysh = x.zamkzqg.btazysh(nmpwovhVar2, R.drawable.ic_close, x.zamkzqg.zngzleo(nmpwovhVar2), R.string.about_close, null);
                        viewBtazysh.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.atntgcp(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_radius)));
                        linearLayoutLvtqoqa5.addView(viewBtazysh, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size)));
                        linearLayout5.addView(linearLayoutLvtqoqa5);
                        View view3 = new View(nmpwovhVar2);
                        view3.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 1);
                        layoutParams6.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_header_bottom_gap);
                        layoutParams6.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        linearLayout5.addView(view3, layoutParams6);
                        LinearLayout linearLayoutLvtqoqa6 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa6.setGravity(16);
                        linearLayoutLvtqoqa6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_join_us_on), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud12 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_telegram_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud12.setGravity(17);
                        textViewOxoagud12.setClickable(true);
                        textViewOxoagud12.setFocusable(true);
                        textViewOxoagud12.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud12);
                        textViewOxoagud12.setOnClickListener(onClickListener);
                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams7.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                        linearLayoutLvtqoqa6.addView(textViewOxoagud12, layoutParams7);
                        linearLayout5.addView(linearLayoutLvtqoqa6);
                        LinearLayout linearLayoutLvtqoqa7 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa7.setGravity(16);
                        linearLayoutLvtqoqa7.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_intro), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud13 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud13.setGravity(17);
                        textViewOxoagud13.setClickable(true);
                        textViewOxoagud13.setFocusable(true);
                        textViewOxoagud13.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud13);
                        textViewOxoagud13.setOnClickListener(onClickListener2);
                        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams8.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                        linearLayoutLvtqoqa7.addView(textViewOxoagud13, layoutParams8);
                        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams9.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical);
                        linearLayout5.addView(linearLayoutLvtqoqa7, layoutParams9);
                        ljhdwjr ljhdwjrVar = new ljhdwjr(nmpwovhVar2);
                        ljhdwjrVar.setContentDescription(nmpwovhVar2.getString(R.string.creator_logo_content_description));
                        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size));
                        layoutParams10.gravity = 1;
                        layoutParams10.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_top_gap);
                        linearLayout5.addView(ljhdwjrVar, layoutParams10);
                        ljhdwjrVar.ojyssqt(true);
                        View view4 = new View(nmpwovhVar2);
                        view4.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, 1);
                        layoutParams11.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        layoutParams11.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        linearLayout5.addView(view4, layoutParams11);
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credits_title), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), true));
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_android), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_ui_design), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_core), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud14 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_summary), 12, x.zamkzqg.zngzleo(nmpwovhVar2), true);
                        textViewOxoagud14.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap), 0, 0);
                        linearLayout5.addView(textViewOxoagud14);
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_notice), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        TextView textViewOxoagud15 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_view_license), 12, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud15.setClickable(true);
                        textViewOxoagud15.setFocusable(true);
                        textViewOxoagud15.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), 0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud15);
                        textViewOxoagud15.setOnClickListener(new x.nmpwovh(nmpwovhVar2, 0));
                        linearLayout5.addView(textViewOxoagud15);
                        ScrollView scrollView2 = new ScrollView(nmpwovhVar2);
                        scrollView2.setFillViewport(false);
                        scrollView2.setClipToPadding(false);
                        scrollView2.addView(linearLayout5, new FrameLayout.LayoutParams(-1, -2));
                        AlertDialog alertDialogCreate = new AlertDialog.Builder(nmpwovhVar2).setView(scrollView2).create();
                        viewBtazysh.setOnClickListener(new x.nmpwovh(alertDialogCreate, 1));
                        alertDialogCreate.setOnShowListener(new x.ojyssqt(alertDialogCreate, 0));
                        alertDialogCreate.show();
                        break;
                    default:
                        Pattern pattern = x.iivesaq.nmpwovh;
                        new Thread(new lthborb(gepzcpdVar3.nmpwovh, z3, i24), "rynx-update-check").start();
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha3, R.drawable.ic_file, iNmpwovh8);
        linearLayoutZwaqeaz6.addView(textViewLclupha3, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
        r12.addView(linearLayoutZwaqeaz6, x.zamkzqg.uiqyzsp(this));
        r12.addView(x.zamkzqg.hknanqb(this, R.string.settings_about_section));
        LinearLayout Zwaqeaz7 = x.zamkzqg.zwaqeaz(this);
        LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(this);
        linearLayoutLvtqoqa5.setGravity(16);
        linearLayoutLvtqoqa5.setClickable(true);
        linearLayoutLvtqoqa5.setFocusable(true);
        x.zamkzqg.utmeivs(this, linearLayoutLvtqoqa5);
        final int i24 = 2;
        linearLayoutLvtqoqa5.setOnClickListener(new View.OnClickListener() { // from class: x.snilumr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String str17;
                int i25 = 2;
                gepzcpd gepzcpdVar3 = gepzcpdVar;
                boolean z3 = true;
                char c = 1;
                final int i26 = 0;
                switch (i24) {
                    case 0:
                        String[] strArr5 = {"system", "en", "id"};
                        com.rynx.app.nmpwovh nmpwovhVar = gepzcpdVar3.nmpwovh;
                        CharSequence[] charSequenceArr = {nmpwovhVar.getString(R.string.settings_language_system), nmpwovhVar.getString(R.string.settings_language_english), nmpwovhVar.getString(R.string.settings_language_indonesian)};
                        String strJxvdcpb = x.zamkzqg.jxvdcpb(nmpwovhVar);
                        int i27 = 0;
                        while (i27 < 3) {
                            if (strArr5[i27].equals(strJxvdcpb)) {
                                new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i27, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                            } else {
                                i27++;
                            }
                            break;
                        }
                        i27 = 0;
                        new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i27, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                        break;
                    case 1:
                        gepzcpdVar3.nmpwovh.sthdtww();
                        break;
                    case 2:
                        final com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                        nmpwovhVar2.getClass();
                        try {
                            str17 = nmpwovhVar2.getPackageManager().getPackageInfo(nmpwovhVar2.getPackageName(), 0).versionName;
                        } catch (Throwable unused3) {
                            str17 = "";
                        }
                        String str18 = str17 != null ? str17 : "";
                        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.ysluikv
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                switch (i26) {
                                    case 0:
                                        nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                        break;
                                    default:
                                        nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                        break;
                                }
                            }
                        };
                        final int c2 = c != 0 ? 1 : 0;
                        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.ysluikv
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                switch (c2) {
                                    case 0:
                                        nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                        break;
                                    default:
                                        nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                        break;
                                }
                            }
                        };
                        LinearLayout linearLayout5 = new LinearLayout(nmpwovhVar2);
                        linearLayout5.setOrientation(1);
                        linearLayout5.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical));
                        linearLayout5.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.czidoiw(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_radius)));
                        LinearLayout linearLayoutLvtqoqa6 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa6.setGravity(48);
                        ImageView imageView3 = new ImageView(nmpwovhVar2);
                        imageView3.setImageResource(R.drawable.ic_android_tools);
                        imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        linearLayoutLvtqoqa6.addView(imageView3, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size)));
                        LinearLayout linearLayout6 = new LinearLayout(nmpwovhVar2);
                        linearLayout6.setOrientation(1);
                        linearLayout6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_app_name), 20, x.zamkzqg.zngzleo(nmpwovhVar2), true));
                        linearLayout6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_subtitle), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        linearLayout6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_version, str18), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                        layoutParams5.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_gap);
                        linearLayoutLvtqoqa6.addView(linearLayout6, layoutParams5);
                        View viewBtazysh = x.zamkzqg.btazysh(nmpwovhVar2, R.drawable.ic_close, x.zamkzqg.zngzleo(nmpwovhVar2), R.string.about_close, null);
                        viewBtazysh.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.atntgcp(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_radius)));
                        linearLayoutLvtqoqa6.addView(viewBtazysh, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size)));
                        linearLayout5.addView(linearLayoutLvtqoqa6);
                        View view3 = new View(nmpwovhVar2);
                        view3.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 1);
                        layoutParams6.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_header_bottom_gap);
                        layoutParams6.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        linearLayout5.addView(view3, layoutParams6);
                        LinearLayout linearLayoutLvtqoqa7 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa7.setGravity(16);
                        linearLayoutLvtqoqa7.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_join_us_on), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud12 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_telegram_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud12.setGravity(17);
                        textViewOxoagud12.setClickable(true);
                        textViewOxoagud12.setFocusable(true);
                        textViewOxoagud12.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud12);
                        textViewOxoagud12.setOnClickListener(onClickListener);
                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams7.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                        linearLayoutLvtqoqa7.addView(textViewOxoagud12, layoutParams7);
                        linearLayout5.addView(linearLayoutLvtqoqa7);
                        LinearLayout linearLayoutLvtqoqa8 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa8.setGravity(16);
                        linearLayoutLvtqoqa8.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_intro), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud13 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud13.setGravity(17);
                        textViewOxoagud13.setClickable(true);
                        textViewOxoagud13.setFocusable(true);
                        textViewOxoagud13.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud13);
                        textViewOxoagud13.setOnClickListener(onClickListener2);
                        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams8.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                        linearLayoutLvtqoqa8.addView(textViewOxoagud13, layoutParams8);
                        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams9.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical);
                        linearLayout5.addView(linearLayoutLvtqoqa8, layoutParams9);
                        ljhdwjr ljhdwjrVar = new ljhdwjr(nmpwovhVar2);
                        ljhdwjrVar.setContentDescription(nmpwovhVar2.getString(R.string.creator_logo_content_description));
                        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size));
                        layoutParams10.gravity = 1;
                        layoutParams10.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_top_gap);
                        linearLayout5.addView(ljhdwjrVar, layoutParams10);
                        ljhdwjrVar.ojyssqt(true);
                        View view4 = new View(nmpwovhVar2);
                        view4.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, 1);
                        layoutParams11.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        layoutParams11.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        linearLayout5.addView(view4, layoutParams11);
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credits_title), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), true));
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_android), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_ui_design), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_core), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud14 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_summary), 12, x.zamkzqg.zngzleo(nmpwovhVar2), true);
                        textViewOxoagud14.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap), 0, 0);
                        linearLayout5.addView(textViewOxoagud14);
                        linearLayout5.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_notice), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        TextView textViewOxoagud15 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_view_license), 12, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud15.setClickable(true);
                        textViewOxoagud15.setFocusable(true);
                        textViewOxoagud15.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), 0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud15);
                        textViewOxoagud15.setOnClickListener(new x.nmpwovh(nmpwovhVar2, 0));
                        linearLayout5.addView(textViewOxoagud15);
                        ScrollView scrollView2 = new ScrollView(nmpwovhVar2);
                        scrollView2.setFillViewport(false);
                        scrollView2.setClipToPadding(false);
                        scrollView2.addView(linearLayout5, new FrameLayout.LayoutParams(-1, -2));
                        AlertDialog alertDialogCreate = new AlertDialog.Builder(nmpwovhVar2).setView(scrollView2).create();
                        viewBtazysh.setOnClickListener(new x.nmpwovh(alertDialogCreate, 1));
                        alertDialogCreate.setOnShowListener(new x.ojyssqt(alertDialogCreate, 0));
                        alertDialogCreate.show();
                        break;
                    default:
                        Pattern pattern = x.iivesaq.nmpwovh;
                        new Thread(new lthborb(gepzcpdVar3.nmpwovh, z3, i25), "rynx-update-check").start();
                        break;
                }
            }
        });
        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.drawable.ic_info);
        imageView3.setImageTintList(ColorStateList.valueOf(x.zamkzqg.nmpwovh(this)));
        imageView3.setPadding(x.zamkzqg.qunltjs(this, 7), x.zamkzqg.qunltjs(this, 7), x.zamkzqg.qunltjs(this, 7), x.zamkzqg.qunltjs(this, 7));
        int iNmpwovh9 = x.zamkzqg.nmpwovh(this);
        if (x.zamkzqg.ysluikv(this)) {
            i5 = 35;
        } else {
            i5 = 20;
        }
        imageView3.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.uzyihoe(iNmpwovh9, i5), getColor(R.color.rynx_transparent), x.zamkzqg.qunltjs(this, 14)));
        linearLayoutLvtqoqa5.addView(imageView3, new LinearLayout.LayoutParams(x.zamkzqg.qunltjs(this, 42), x.zamkzqg.qunltjs(this, 42)));
        LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setOrientation(1);
        linearLayout5.addView(x.zamkzqg.oxoagud(this, getString(R.string.settings_about_title), 13, x.zamkzqg.zngzleo(this), false));
        linearLayout5.addView(x.zamkzqg.oxoagud(this, getString(R.string.settings_about_desc, str15), 11, x.zamkzqg.jbmzxye(this), false));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams5.leftMargin = x.zamkzqg.qunltjs(this, 12);
        linearLayoutLvtqoqa5.addView(linearLayout5, layoutParams5);
        linearLayoutLvtqoqa5.addView(x.zamkzqg.oxoagud(this, "›", 24, x.zamkzqg.jbmzxye(this), false));
        Zwaqeaz7.addView(linearLayoutLvtqoqa5);
        Zwaqeaz7.addView(x.zamkzqg.ivvkvsj(this));
        int iNmpwovh10 = x.zamkzqg.nmpwovh(this);
        final int i25 = 3;
        TextView textViewLclupha4 = x.zamkzqg.lclupha(this, getString(R.string.settings_check_updates), new View.OnClickListener() { // from class: x.snilumr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String str17;
                int i26 = 2;
                gepzcpd gepzcpdVar3 = gepzcpdVar;
                boolean z3 = true;
                char c = 1;
                final int i27 = 0;
                switch (i25) {
                    case 0:
                        String[] strArr5 = {"system", "en", "id"};
                        com.rynx.app.nmpwovh nmpwovhVar = gepzcpdVar3.nmpwovh;
                        CharSequence[] charSequenceArr = {nmpwovhVar.getString(R.string.settings_language_system), nmpwovhVar.getString(R.string.settings_language_english), nmpwovhVar.getString(R.string.settings_language_indonesian)};
                        String strJxvdcpb = x.zamkzqg.jxvdcpb(nmpwovhVar);
                        int i28 = 0;
                        while (i28 < 3) {
                            if (strArr5[i28].equals(strJxvdcpb)) {
                                new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i28, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                            } else {
                                i28++;
                            }
                            break;
                        }
                        i28 = 0;
                        new AlertDialog.Builder(nmpwovhVar).setTitle(R.string.settings_language_dialog_title).setSingleChoiceItems(charSequenceArr, i28, new pmsrvoc(nmpwovhVar, strArr5, 0)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
                        break;
                    case 1:
                        gepzcpdVar3.nmpwovh.sthdtww();
                        break;
                    case 2:
                        final com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                        nmpwovhVar2.getClass();
                        try {
                            str17 = nmpwovhVar2.getPackageManager().getPackageInfo(nmpwovhVar2.getPackageName(), 0).versionName;
                        } catch (Throwable unused3) {
                            str17 = "";
                        }
                        String str18 = str17 != null ? str17 : "";
                        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.ysluikv
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                switch (i27) {
                                    case 0:
                                        nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                        break;
                                    default:
                                        nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                        break;
                                }
                            }
                        };
                        final int c2 = c != 0 ? 1 : 0;
                        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.ysluikv
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                switch (c2) {
                                    case 0:
                                        nmpwovhVar2.gepzcpd(R.string.about_telegram_url, R.string.about_telegram_link);
                                        break;
                                    default:
                                        nmpwovhVar2.gepzcpd(R.string.about_donate_url, R.string.about_donate_link);
                                        break;
                                }
                            }
                        };
                        LinearLayout linearLayout6 = new LinearLayout(nmpwovhVar2);
                        linearLayout6.setOrientation(1);
                        linearLayout6.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_padding_vertical));
                        linearLayout6.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.czidoiw(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_radius)));
                        LinearLayout linearLayoutLvtqoqa6 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa6.setGravity(48);
                        ImageView imageView4 = new ImageView(nmpwovhVar2);
                        imageView4.setImageResource(R.drawable.ic_android_tools);
                        imageView4.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        linearLayoutLvtqoqa6.addView(imageView4, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_size)));
                        LinearLayout linearLayout7 = new LinearLayout(nmpwovhVar2);
                        linearLayout7.setOrientation(1);
                        linearLayout7.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_app_name), 20, x.zamkzqg.zngzleo(nmpwovhVar2), true));
                        linearLayout7.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_subtitle), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        linearLayout7.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_version, str18), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                        layoutParams6.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_icon_gap);
                        linearLayoutLvtqoqa6.addView(linearLayout7, layoutParams6);
                        View viewBtazysh = x.zamkzqg.btazysh(nmpwovhVar2, R.drawable.ic_close, x.zamkzqg.zngzleo(nmpwovhVar2), R.string.about_close, null);
                        viewBtazysh.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar2, x.zamkzqg.atntgcp(nmpwovhVar2), nmpwovhVar2.getColor(R.color.rynx_transparent), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_radius)));
                        linearLayoutLvtqoqa6.addView(viewBtazysh, new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_close_size)));
                        linearLayout6.addView(linearLayoutLvtqoqa6);
                        View view3 = new View(nmpwovhVar2);
                        view3.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, 1);
                        layoutParams7.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_header_bottom_gap);
                        layoutParams7.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        linearLayout6.addView(view3, layoutParams7);
                        LinearLayout linearLayoutLvtqoqa7 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa7.setGravity(16);
                        linearLayoutLvtqoqa7.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_join_us_on), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud12 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_telegram_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud12.setGravity(17);
                        textViewOxoagud12.setClickable(true);
                        textViewOxoagud12.setFocusable(true);
                        textViewOxoagud12.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud12);
                        textViewOxoagud12.setOnClickListener(onClickListener);
                        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams8.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                        linearLayoutLvtqoqa7.addView(textViewOxoagud12, layoutParams8);
                        linearLayout6.addView(linearLayoutLvtqoqa7);
                        LinearLayout linearLayoutLvtqoqa8 = x.zamkzqg.lvtqoqa(nmpwovhVar2);
                        linearLayoutLvtqoqa8.setGravity(16);
                        linearLayoutLvtqoqa8.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_intro), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud13 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_donate_button), 13, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud13.setGravity(17);
                        textViewOxoagud13.setClickable(true);
                        textViewOxoagud13.setFocusable(true);
                        textViewOxoagud13.setPadding(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_horizontal), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud13);
                        textViewOxoagud13.setOnClickListener(onClickListener2);
                        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams9.leftMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_word_gap);
                        linearLayoutLvtqoqa8.addView(textViewOxoagud13, layoutParams9);
                        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams10.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical);
                        linearLayout6.addView(linearLayoutLvtqoqa8, layoutParams10);
                        ljhdwjr ljhdwjrVar = new ljhdwjr(nmpwovhVar2);
                        ljhdwjrVar.setContentDescription(nmpwovhVar2.getString(R.string.creator_logo_content_description));
                        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size), nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_size));
                        layoutParams11.gravity = 1;
                        layoutParams11.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_creator_logo_top_gap);
                        linearLayout6.addView(ljhdwjrVar, layoutParams11);
                        ljhdwjrVar.ojyssqt(true);
                        View view4 = new View(nmpwovhVar2);
                        view4.setBackgroundColor(x.zamkzqg.qyeibyo(nmpwovhVar2));
                        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, 1);
                        layoutParams12.topMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        layoutParams12.bottomMargin = nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap);
                        linearLayout6.addView(view4, layoutParams12);
                        linearLayout6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credits_title), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), true));
                        linearLayout6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_android), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        linearLayout6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_ui_design), 12, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        linearLayout6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_credit_core), 12, x.zamkzqg.zngzleo(nmpwovhVar2), false));
                        TextView textViewOxoagud14 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_summary), 12, x.zamkzqg.zngzleo(nmpwovhVar2), true);
                        textViewOxoagud14.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_dialog_section_gap), 0, 0);
                        linearLayout6.addView(textViewOxoagud14);
                        linearLayout6.addView(x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_license_notice), 11, x.zamkzqg.jbmzxye(nmpwovhVar2), false));
                        TextView textViewOxoagud15 = x.zamkzqg.oxoagud(nmpwovhVar2, nmpwovhVar2.getString(R.string.about_view_license), 12, x.zamkzqg.nmpwovh(nmpwovhVar2), true);
                        textViewOxoagud15.setClickable(true);
                        textViewOxoagud15.setFocusable(true);
                        textViewOxoagud15.setPadding(0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical), 0, nmpwovhVar2.getResources().getDimensionPixelSize(R.dimen.about_telegram_touch_padding_vertical));
                        x.zamkzqg.utmeivs(nmpwovhVar2, textViewOxoagud15);
                        textViewOxoagud15.setOnClickListener(new x.nmpwovh(nmpwovhVar2, 0));
                        linearLayout6.addView(textViewOxoagud15);
                        ScrollView scrollView2 = new ScrollView(nmpwovhVar2);
                        scrollView2.setFillViewport(false);
                        scrollView2.setClipToPadding(false);
                        scrollView2.addView(linearLayout6, new FrameLayout.LayoutParams(-1, -2));
                        AlertDialog alertDialogCreate = new AlertDialog.Builder(nmpwovhVar2).setView(scrollView2).create();
                        viewBtazysh.setOnClickListener(new x.nmpwovh(alertDialogCreate, 1));
                        alertDialogCreate.setOnShowListener(new x.ojyssqt(alertDialogCreate, 0));
                        alertDialogCreate.show();
                        break;
                    default:
                        Pattern pattern = x.iivesaq.nmpwovh;
                        new Thread(new lthborb(gepzcpdVar3.nmpwovh, z3, i26), "rynx-update-check").start();
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha4, R.drawable.ic_info, iNmpwovh10);
        Zwaqeaz7.addView(textViewLclupha4, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
        r12.addView(Zwaqeaz7, x.zamkzqg.uiqyzsp(this));
        r12.addView(new View(this), new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
        this.ccuulnt = new seujokk(r34, r7, r6, textViewOxoagud9, textViewOxoagud11);
        iwjoiry();
        return this.ccuulnt.nmpwovh;
    }

    public final void jtfjrri(boolean z) {
        FrameLayout frameLayout = this.bwvplah;
        if (frameLayout == null) {
            return;
        }
        if (z) {
            this.nhhacgu = false;
            this.jxvdcpb = 0;
            frameLayout.animate().cancel();
            this.bwvplah.setTranslationY(0.0f);
            this.bwvplah.setAlpha(1.0f);
        }
        this.bwvplah.setVisibility(this.kxotgjb || (this.lataqgm && this.civyupy) ? 8 : 0);
    }

    public final boolean kggugdp() {
        String str;
        zwccvwt zwccvwtVar = this.laodqsm;
        if (zwccvwtVar != null && (str = zwccvwtVar.dplrlfq) != null && !str.isEmpty()) {
            return "new_security".equalsIgnoreCase(zwccvwtVar.dplrlfq);
        }
        String strGucwjqz = gucwjqz();
        String[] strArr = zrcmcht;
        for (int i = 0; i < 6; i++) {
            if (strArr[i].equals(strGucwjqz)) {
                return true;
            }
        }
        return false;
    }

    public final void ltnesel() {
        if (this.eigllth == null || !this.lataqgm) {
            return;
        }
        this.eigllth.postDelayed(new ezxxysz(this, 0), 80L);
    }

    public final void mamlotu(boolean z) {
        if (this.bwvplah == null || this.kxotgjb) {
            return;
        }
        if ((this.lataqgm && this.civyupy) || this.nhhacgu == z) {
            return;
        }
        this.nhhacgu = z;
        this.bwvplah.animate().cancel();
        this.bwvplah.setVisibility(0);
        float fDasxvpc = dasxvpc(8) + Math.max(this.bwvplah.getHeight(), getResources().getDimensionPixelSize(R.dimen.bottom_nav_container_height));
        ViewPropertyAnimator viewPropertyAnimatorAnimate = this.bwvplah.animate();
        if (!z) {
            fDasxvpc = 0.0f;
        }
        viewPropertyAnimatorAnimate.translationY(fDasxvpc).alpha(z ? 0.0f : 1.0f).setDuration(180).setInterpolator(new DecelerateInterpolator()).start();
    }

    public final void marclvq(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof ScrollView) {
            final ScrollView scrollView = (ScrollView) view;
            if (scrollView == this.pzqxblc || !this.ezxxysz.add(scrollView)) {
                return;
            }
            this.nsizane.put(scrollView, Integer.valueOf(scrollView.getScrollY()));
            scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: x.lvtqoqa
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    com.rynx.app.nmpwovh nmpwovhVar = nmpwovh.this;
                    ScrollView scrollView2 = scrollView;
                    nmpwovhVar.getClass();
                    if (scrollView2 == null) {
                        return;
                    }
                    int scrollY = scrollView2.getScrollY();
                    Integer num = (Integer) nmpwovhVar.nsizane.put(scrollView2, Integer.valueOf(scrollY));
                    int iIntValue = num == null ? scrollY : num.intValue();
                    FrameLayout frameLayout = nmpwovhVar.bwvplah;
                    if (frameLayout == null || frameLayout.getVisibility() != 0 || nmpwovhVar.kxotgjb) {
                        return;
                    }
                    if (!(nmpwovhVar.lataqgm && nmpwovhVar.civyupy) && scrollView2.isShown()) {
                        if (scrollY <= 0) {
                            nmpwovhVar.jxvdcpb = 0;
                            nmpwovhVar.mamlotu(false);
                            return;
                        }
                        int i = scrollY - iIntValue;
                        if (i == 0) {
                            return;
                        }
                        if ((i > 0 && nmpwovhVar.jxvdcpb < 0) || (i < 0 && nmpwovhVar.jxvdcpb > 0)) {
                            nmpwovhVar.jxvdcpb = 0;
                        }
                        nmpwovhVar.jxvdcpb += i;
                        int iDasxvpc = nmpwovhVar.dasxvpc(18);
                        int i2 = nmpwovhVar.jxvdcpb;
                        if (i2 >= iDasxvpc) {
                            nmpwovhVar.jxvdcpb = 0;
                            nmpwovhVar.mamlotu(true);
                        } else if (i2 <= (-iDasxvpc)) {
                            nmpwovhVar.jxvdcpb = 0;
                            nmpwovhVar.mamlotu(false);
                        }
                    }
                }
            });
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                marclvq(viewGroup.getChildAt(i));
            }
        }
    }

    public final String mcdstyz() {
        String str;
        String str2;
        String str3;
        String str4;
        zwccvwt zwccvwtVar = this.laodqsm;
        if (zwccvwtVar != null && (str4 = zwccvwtVar.ulafhci) != null && !str4.isEmpty()) {
            return zwccvwtVar.ulafhci;
        }
        zwccvwt zwccvwtVar2 = this.laodqsm;
        if (zwccvwtVar2 == null || !"new_security".equalsIgnoreCase(zwccvwtVar2.dplrlfq) || (str3 = zwccvwtVar2.ulafhci) == null || str3.isEmpty()) {
            String strGucwjqz = gucwjqz();
            strGucwjqz.getClass();
            switch (strGucwjqz) {
                case "spinel":
                    str = "MT6789";
                    break;
                case "dash":
                case "klimt":
                    str = "MT6991";
                    break;
                case "goya":
                case "rodin":
                    str = "MT6899";
                    break;
                case "lapis":
                    str = "MT6878";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = zwccvwtVar2.ulafhci;
        }
        if (!str.isEmpty()) {
            return str;
        }
        if (zwccvwtVar == null || (str2 = zwccvwtVar.qxvquar) == null) {
            return "";
        }
        String upperCase = str2.trim().toUpperCase(Locale.ROOT);
        if (upperCase.isEmpty()) {
            return "";
        }
        for (String str5 : upperCase.replaceAll("[^A-Z0-9]+", " ").split(" +")) {
            if (str5.matches("MT[0-9]{4,5}[A-Z0-9]*")) {
                return str5;
            }
        }
        return upperCase;
    }

    public final void nxumtuo() {
        this.nnkxxji++;
        Future future = this.iivesaq;
        this.iivesaq = null;
        if (future != null) {
            future.cancel(true);
        }
        this.yztlqms = false;
        ysluikv("logout");
        this.iqvvlnh = null;
        this.nysvajy = null;
        this.hiofinr++;
        Future future2 = this.czgynww;
        this.czgynww = null;
        if (future2 != null) {
            future2.cancel(true);
        }
        this.xhyvkax = false;
        this.jcyrpko = Collections.emptyList();
        this.laodqsm = null;
        ebrwptg ebrwptgVar = this.snbdnwo;
        if (ebrwptgVar != null) {
            ebrwptgVar.vivhedu.setText("");
            this.snbdnwo.ulafhci();
        }
        if ("xiaomi_authorize".equals(this.ayzlrnr)) {
            x.zfmpmio.nmpwovh(this, getString(R.string.xiaomi_authorize_logged_out), true);
        }
    }

    @Override // com.rynx.app.ojyssqt, android.app.Activity
    public final void onCreate(Bundle bundle) {
        setTheme(x.zamkzqg.ysluikv(this) ? R.style.Theme_Rynx_Dark : R.style.Theme_Rynx_Light);
        super.onCreate(bundle);
        try {
            ((MainActivity) this).getSharedPreferences("rynx_sla_credentials", 0).edit().clear().apply();
        } catch (Throwable unused) {
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.containsAlias("rynx_sla_credentials_v1")) {
                keyStore.deleteEntry("rynx_sla_credentials_v1");
            }
        } catch (Throwable unused2) {
        }
        SharedPreferences sharedPreferences = getSharedPreferences("rynx_persistent_session", 0);
        boolean zContains = sharedPreferences.contains("xiaomi_loader_model");
        boolean zContains2 = sharedPreferences.contains("xiaomi_loader_revision");
        if (zContains || zContains2) {
            SharedPreferences.Editor editorRemove = sharedPreferences.edit().remove("xiaomi_loader_model").remove("xiaomi_loader_revision");
            if (zContains) {
                editorRemove.remove("da_path").remove("da_display_name").remove("auth_path").remove("preloader_path").remove("preloader_display_name").apply();
            } else {
                editorRemove.apply();
            }
        }
        try {
            if ((getApplicationInfo().flags & 2) == 0) {
                try {
                    try {
                        Arrays.fill(RuntimeGuard.nmpwovh(this), (byte) 0);
                        if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger() && !RuntimeGuard.vivhedu() && !RuntimeGuard.ojyssqt()) {
                            this.seujokk = new qxvquar(this);
                            this.suqlntg = new ccuulnt(new kxotgjb(this));
                            this.nmpwovh = x.zamkzqg.buswjhz(this);
                            x.zamkzqg.czidoiw(this);
                            this.ojyssqt = x.zamkzqg.atntgcp(this);
                            this.vivhedu = x.zamkzqg.qyeibyo(this);
                            this.lthborb = x.zamkzqg.nmpwovh(this);
                            this.qxvquar = x.zamkzqg.pzkwhtn(this);
                            this.oqexvyb = x.zamkzqg.ohwxijw(this);
                            this.nkemejx = x.zamkzqg.pzqxblc(this);
                            this.imuemzb = x.zamkzqg.zngzleo(this);
                            this.dytyqos = x.zamkzqg.jbmzxye(this);
                            x.zamkzqg.gucwjqz(this);
                            this.wqrnifx = x.zamkzqg.ojyssqt(this);
                            this.dasxvpc = x.zamkzqg.kggugdp(this);
                            getColor(R.color.rynx_transparent);
                            getWindow().setSoftInputMode(16);
                            FrameLayout frameLayout = new FrameLayout(this);
                            frameLayout.setBackgroundColor(x.zamkzqg.buswjhz(this));
                            LinearLayout linearLayoutZwaqeaz = x.zamkzqg.zwaqeaz(this);
                            linearLayoutZwaqeaz.setGravity(1);
                            TextView textViewOxoagud = x.zamkzqg.oxoagud(this, getString(R.string.app_name), 28, x.zamkzqg.zngzleo(this), true);
                            textViewOxoagud.setGravity(17);
                            linearLayoutZwaqeaz.addView(textViewOxoagud);
                            TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, getString(R.string.core_loading_subtitle), 14, x.zamkzqg.nmpwovh(this), true);
                            textViewOxoagud2.setGravity(17);
                            textViewOxoagud2.setPadding(0, x.zamkzqg.qunltjs(this, 4), 0, x.zamkzqg.qunltjs(this, 18));
                            linearLayoutZwaqeaz.addView(textViewOxoagud2);
                            ProgressBar progressBar = new ProgressBar(this);
                            progressBar.setIndeterminate(true);
                            progressBar.setIndeterminateTintList(ColorStateList.valueOf(x.zamkzqg.nmpwovh(this)));
                            linearLayoutZwaqeaz.addView(progressBar, new LinearLayout.LayoutParams(x.zamkzqg.qunltjs(this, 48), x.zamkzqg.qunltjs(this, 48)));
                            TextView textViewOxoagud3 = x.zamkzqg.oxoagud(this, getString(R.string.core_loading_status), 13, x.zamkzqg.zngzleo(this), true);
                            textViewOxoagud3.setGravity(17);
                            textViewOxoagud3.setPadding(0, x.zamkzqg.qunltjs(this, 16), 0, 0);
                            linearLayoutZwaqeaz.addView(textViewOxoagud3);
                            TextView textViewOxoagud4 = x.zamkzqg.oxoagud(this, getString(R.string.core_loading_note), 11, x.zamkzqg.jbmzxye(this), false);
                            textViewOxoagud4.setGravity(17);
                            textViewOxoagud4.setLineSpacing(0.0f, 1.12f);
                            textViewOxoagud4.setPadding(0, x.zamkzqg.qunltjs(this, 8), 0, 0);
                            linearLayoutZwaqeaz.addView(textViewOxoagud4);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 17);
                            layoutParams.setMargins(x.zamkzqg.qunltjs(this, 24), x.zamkzqg.qunltjs(this, 24), x.zamkzqg.qunltjs(this, 24), x.zamkzqg.qunltjs(this, 24));
                            frameLayout.addView(linearLayoutZwaqeaz, layoutParams);
                            this.vopsyhw = new dplrlfq(frameLayout, progressBar, textViewOxoagud3);
                            setContentView(frameLayout);
                            cszfvxh();
                            this.slxntng.execute(new ezxxysz(this, 1));
                            return;
                        }
                    } catch (GeneralSecurityException e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    GeneralSecurityException generalSecurityException = new GeneralSecurityException("Unable to verify the application signer");
                    generalSecurityException.initCause(e2);
                    throw generalSecurityException;
                }
            }
        } catch (Throwable unused3) {
        }
        getWindow().addFlags(8192);
        new AlertDialog.Builder(this).setTitle("Integrity check failed").setMessage("This release cannot start because its integrity could not be verified.").setCancelable(false).setPositiveButton(android.R.string.ok, new nsizane(this, 0)).setOnDismissListener(new yonoayx(this, 0)).show();
    }

    @Override // com.rynx.app.ojyssqt, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        UsbDevice usbDeviceUtmeivs = utmeivs(intent);
        if (usbDeviceUtmeivs == null || x.zamkzqg.nsyqsfj(usbDeviceUtmeivs) == 4) {
            return;
        }
        this.ulafhci = usbDeviceUtmeivs;
        if (this.uiqyzsp) {
            gefzxcg();
            if (civyupy()) {
                hhqpjvl(usbDeviceUtmeivs);
            }
        }
    }

    @Override // com.rynx.app.ojyssqt, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.uiqyzsp) {
            bgmsltp();
            ivvkvsj();
        }
    }

    public final void pmsrvoc(int i, String str, boolean z) {
        vlyywxv vlyywxvVar;
        if (i == this.zsbaukl && (vlyywxvVar = this.zwccvwt) != null && vlyywxvVar.ojyssqt.isShowing() && !vlyywxvVar.pvkaerr) {
            nlcdwap nlcdwapVar = vlyywxvVar.vivhedu;
            if (nlcdwapVar.lthborb.isEmpty()) {
                nlcdwapVar.lthborb = "failed";
            }
            nlcdwapVar.utmeivs = "";
            nlcdwapVar.oqexvyb = "Authorization failed";
            nlcdwapVar.nkemejx = x.nlcdwap.qxvquar(str, "Authorization failed.");
            nlcdwapVar.ojyssqt(str);
            nlcdwapVar.buswjhz = true;
            nlcdwapVar.pvbzgon = false;
            boolean zEquals = "expired".equals(nlcdwapVar.lthborb);
            int i2 = zEquals ? R.string.xiaomi_auth_progress_hero_expired : R.string.xiaomi_auth_progress_hero_failed;
            nmpwovh nmpwovhVar = vlyywxvVar.nmpwovh;
            nlcdwapVar.nkemejx(nmpwovhVar.getString(i2), nmpwovhVar.getString(zEquals ? R.string.xiaomi_auth_progress_status_expired : R.string.xiaomi_auth_progress_status_failed), (str == null || str.trim().isEmpty()) ? nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_failed) : nlcdwapVar.nkemejx);
            vlyywxvVar.pvkaerr = true;
            vlyywxvVar.uiqyzsp = false;
            vlyywxvVar.qwgjehf = null;
            if (!nlcdwapVar.ekyqleu.isEmpty()) {
                vlyywxvVar.ekyqleu(true);
            }
            vlyywxvVar.lthborb(z);
            vlyywxvVar.qxvquar();
        }
    }

    public final void rceuwfv(String str, xhyvkax xhyvkaxVar) {
        if (xhyvkaxVar == null || str == null || str.trim().isEmpty()) {
            return;
        }
        this.zfmpmio.submit(new atntgcp(xhyvkaxVar, str, 1));
    }

    public final boolean rrpfqyy() {
        return (this.nysvajy == null || this.iqvvlnh == null || !this.iqvvlnh.vivhedu() || this.laodqsm == null) ? false : true;
    }

    public final File silhone(String str) {
        String strYjbrzgu = yjbrzgu(str);
        if (strYjbrzgu == null || strYjbrzgu.trim().isEmpty()) {
            return null;
        }
        File file = new File(strYjbrzgu);
        if (file.isFile() && file.canRead() && file.length() > 0) {
            return file;
        }
        return null;
    }

    public final void sjexbpf() {
        if (this.snbdnwo == null) {
            return;
        }
        zwccvwt zwccvwtVar = this.laodqsm;
        if (zwccvwtVar == null) {
            ebrwptg ebrwptgVar = this.snbdnwo;
            ebrwptgVar.qyeibyo.setText(R.string.xiaomi_device_model_not_selected);
            ebrwptgVar.vntpaom.setText(R.string.xiaomi_device_model_prompt);
            ebrwptgVar.vopsyhw = false;
            ebrwptgVar.atntgcp.setVisibility(8);
            ebrwptgVar.dplrlfq();
            return;
        }
        String str = zwccvwtVar.vivhedu;
        if (str.isEmpty() && !zwccvwtVar.nmpwovh.equalsIgnoreCase(zwccvwtVar.ojyssqt)) {
            str = zwccvwtVar.nmpwovh;
        }
        boolean zKggugdp = kggugdp();
        String strConcat = zwccvwtVar.oqexvyb;
        if (zwccvwtVar.ekyqleu) {
            strConcat = strConcat.isEmpty() ? "AUTH" : strConcat.concat(" | AUTH");
        }
        ebrwptg ebrwptgVar2 = this.snbdnwo;
        String str2 = zwccvwtVar.ojyssqt;
        String str3 = zwccvwtVar.qxvquar;
        ebrwptgVar2.qyeibyo.setText(x.ebrwptg.ojyssqt(str2));
        StringBuilder sb = new StringBuilder();
        ebrwptgVar2.nmpwovh(sb, str, R.string.xiaomi_device_codename_value);
        ebrwptgVar2.nmpwovh(sb, str3, R.string.xiaomi_device_platform_value);
        ebrwptgVar2.nmpwovh(sb, strConcat, R.string.xiaomi_device_service_value);
        int length = sb.length();
        Activity activity = ebrwptgVar2.lthborb;
        ebrwptgVar2.vntpaom.setText(length == 0 ? activity.getString(R.string.xiaomi_device_model_metadata_unavailable) : sb.toString());
        ebrwptgVar2.vopsyhw = true;
        int i = zKggugdp ? R.string.xiaomi_security_mode_new : R.string.xiaomi_security_mode_legacy;
        TextView textView = ebrwptgVar2.atntgcp;
        textView.setText(i);
        textView.setTextColor(zKggugdp ? x.zamkzqg.nmpwovh(activity) : x.zamkzqg.jbmzxye(activity));
        textView.setBackground(x.zamkzqg.yhrqvll(activity, zKggugdp ? x.zamkzqg.ojyssqt(activity) : x.zamkzqg.atntgcp(activity), zKggugdp ? x.zamkzqg.nmpwovh(activity) : x.zamkzqg.slxntng(activity), 999));
        textView.setVisibility(0);
        ebrwptgVar2.ekyqleu();
        if (this.snbdnwo == null) {
            return;
        }
        if (this.laodqsm == null || !vntpaom()) {
            this.snbdnwo.dplrlfq();
            return;
        }
        if (silhone("auth_path") == null) {
            this.snbdnwo.dasxvpc(getString(R.string.xiaomi_local_auth_missing));
            return;
        }
        if (!jdqigmr()) {
            this.snbdnwo.dasxvpc(getString(R.string.xiaomi_local_preloader_invalid));
            return;
        }
        File fileSilhone = silhone("preloader_path");
        ebrwptg ebrwptgVar3 = this.snbdnwo;
        StringBuilder sb2 = new StringBuilder("DA + AUTH");
        if (fileSilhone != null) {
            sb2.append(" + preloader");
        }
        String string = sb2.toString();
        ebrwptgVar3.lpkdqgx = true;
        Object[] objArr = {x.ebrwptg.ojyssqt(string)};
        Activity activity2 = ebrwptgVar3.lthborb;
        String string2 = activity2.getString(R.string.xiaomi_loader_bundle_ready, objArr);
        TextView textView2 = ebrwptgVar3.lclupha;
        textView2.setText(string2);
        textView2.setTextColor(x.zamkzqg.pzkwhtn(activity2));
        x.zamkzqg.enxkjpu(activity2, textView2, R.drawable.ic_status_done, x.zamkzqg.pzkwhtn(activity2));
        ebrwptgVar3.ekyqleu();
    }

    public final void suqlntg() {
        if (!rrpfqyy() || this.yztlqms) {
            return;
        }
        final xhyvkax xhyvkaxVar = this.iqvvlnh;
        final zwccvwt zwccvwtVar = this.laodqsm;
        if (xhyvkaxVar == null || zwccvwtVar == null) {
            return;
        }
        final boolean zKggugdp = kggugdp();
        final String str = zKggugdp ? "new_security" : "legacy";
        final String strGucwjqz = gucwjqz();
        final String strMcdstyz = mcdstyz();
        if (strGucwjqz.isEmpty() || strMcdstyz.isEmpty()) {
            this.snbdnwo.wqrnifx(getString(R.string.xiaomi_authorize_profile_incomplete), true);
            return;
        }
        ysluikv("replace");
        final int i = this.zyxfuka + 1;
        this.zyxfuka = i;
        vlyywxv vlyywxvVar = this.zwccvwt;
        vlyywxv vlyywxvVar2 = null;
        if (vlyywxvVar != null) {
            ValueAnimator valueAnimator = vlyywxvVar.bgmsltp;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                vlyywxvVar.bgmsltp.removeAllUpdateListeners();
                vlyywxvVar.bgmsltp = null;
            }
            AlertDialog alertDialog = vlyywxvVar.ojyssqt;
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            }
        }
        this.zsbaukl = i;
        String string = getString(R.string.xiaomi_authorize_title);
        suqlntg suqlntgVar = new suqlntg(this, i);
        if (!isFinishing() && !isDestroyed()) {
            vlyywxvVar2 = new vlyywxv(this, string, suqlntgVar);
        }
        this.zwccvwt = vlyywxvVar2;
        if (vlyywxvVar2 != null && vlyywxvVar2.ojyssqt.isShowing()) {
            String str2 = zwccvwtVar.ojyssqt;
            vlyywxvVar2.nsyqsfj = str.trim();
            String strOqexvyb = x.nlcdwap.oqexvyb(str2);
            nlcdwap nlcdwapVar = vlyywxvVar2.vivhedu;
            nlcdwapVar.nmpwovh = strOqexvyb;
            nlcdwapVar.ojyssqt = strMcdstyz.trim();
            vlyywxvVar2.qxvquar();
        }
        this.yztlqms = true;
        this.snbdnwo.oqexvyb(R.string.xiaomi_authorize_checking_quote, true);
        jbyhfxz(i, "Checking server profile, price, and available credit…");
        ((MainActivity) this).nmpwovh("[SLA] Checking Xiaomi authorization quote...");
        this.iivesaq = this.zfmpmio.submit(new Runnable() { // from class: x.rceuwfv
            @Override // java.lang.Runnable
            public final void run() {
                yztlqms yztlqmsVarEqqqfvj;
                Throwable th;
                final xhyvkax xhyvkaxVar2 = xhyvkaxVar;
                final String str3 = strGucwjqz;
                final String str4 = strMcdstyz;
                final String str5 = str;
                final com.rynx.app.nmpwovh nmpwovhVar = nmpwovh.this;
                nmpwovhVar.getClass();
                String message = null;
                try {
                    yztlqmsVarEqqqfvj = x.zamkzqg.eqqqfvj(com.rynx.app.ojyssqt.jxvdcpb(), xhyvkaxVar2, str3, str4, str5);
                    try {
                        if (!str5.equalsIgnoreCase(yztlqmsVarEqqqfvj.nmpwovh)) {
                            throw new czgynww("MODE_MISMATCH", 409, "Server mode does not match the selected Xiaomi model.", null);
                        }
                        if (!str4.equalsIgnoreCase(yztlqmsVarEqqqfvj.ojyssqt)) {
                            throw new czgynww("CHIPSET_MISMATCH", 409, "Server chipset does not match the selected Xiaomi model.", null);
                        }
                        int i2 = yztlqmsVarEqqqfvj.vivhedu;
                        if (i2 <= 0 || yztlqmsVarEqqqfvj.oqexvyb < i2) {
                            throw new czgynww("INSUFFICIENT_CREDIT", 402, "Insufficient available Xiaomi authorization credit.", null);
                        }
                        final String str6 = message;
                        final yztlqms yztlqmsVar = yztlqmsVarEqqqfvj;
                        final zwccvwt zwccvwtVar2 = zwccvwtVar;
                        final boolean z = zKggugdp;
                        final int i3 = i;
                        nmpwovhVar.runOnUiThread(new Runnable() { // from class: x.nxumtuo
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.rynx.app.nmpwovh nmpwovhVar2 = nmpwovhVar;
                                int i4 = i3;
                                xhyvkax xhyvkaxVar3 = xhyvkaxVar2;
                                zwccvwt zwccvwtVar3 = zwccvwtVar2;
                                yztlqms yztlqmsVar2 = yztlqmsVar;
                                String str7 = str6;
                                String str8 = str5;
                                String str9 = str4;
                                String str10 = str3;
                                boolean z2 = z;
                                if (i4 == nmpwovhVar2.zyxfuka && xhyvkaxVar3 == nmpwovhVar2.iqvvlnh && zwccvwtVar3 == nmpwovhVar2.laodqsm && !nmpwovhVar2.isFinishing() && !nmpwovhVar2.isDestroyed()) {
                                    nmpwovhVar2.yztlqms = false;
                                    nmpwovhVar2.iivesaq = null;
                                    if (yztlqmsVar2 == null) {
                                        nmpwovhVar2.snbdnwo.wqrnifx(str7, true);
                                        ((MainActivity) nmpwovhVar2).nmpwovh("[SLA] Quote failed: " + str7);
                                        nmpwovhVar2.pmsrvoc(i4, "Quote failed: " + str7, true);
                                        return;
                                    }
                                    nmpwovhVar2.snbdnwo.oqexvyb(R.string.xiaomi_authorize_quote_ready, false);
                                    int i5 = yztlqmsVar2.vivhedu;
                                    int i6 = yztlqmsVar2.oqexvyb;
                                    ((MainActivity) nmpwovhVar2).nmpwovh("[SLA] Quote accepted; cost=" + i5 + " credit, available=" + i6 + ".");
                                    nmpwovhVar2.jbyhfxz(i4, "Account accepted by server; available credit " + i6 + ", authorization cost " + i5 + ".");
                                    vlyywxv vlyywxvVar3 = nmpwovhVar2.zwccvwt;
                                    if (vlyywxvVar3 == null || !vlyywxvVar3.ojyssqt.isShowing()) {
                                        return;
                                    }
                                    String str11 = zwccvwtVar3.ojyssqt;
                                    vlyywxvVar3.nsyqsfj = str8.trim();
                                    String strOqexvyb2 = x.nlcdwap.oqexvyb(str11);
                                    nlcdwap nlcdwapVar2 = vlyywxvVar3.vivhedu;
                                    nlcdwapVar2.nmpwovh = strOqexvyb2;
                                    nlcdwapVar2.ojyssqt = str9.trim();
                                    vlyywxvVar3.qxvquar();
                                    vlyywxvVar3.ulafhci(yztlqmsVar2.lthborb, yztlqmsVar2.qxvquar, yztlqmsVar2.oqexvyb, yztlqmsVar2.vivhedu);
                                    nlcdwap nlcdwapVar3 = vlyywxvVar3.vivhedu;
                                    nlcdwapVar3.qyeibyo = true;
                                    nlcdwapVar3.oqexvyb = "Account verified";
                                    nlcdwapVar3.nkemejx = "Server profile, security mode, and authorization price are ready.";
                                    com.rynx.app.nmpwovh nmpwovhVar3 = vlyywxvVar3.nmpwovh;
                                    nlcdwapVar3.nkemejx(nmpwovhVar3.getString(R.string.xiaomi_auth_progress_hero_ready), nmpwovhVar3.getString(R.string.xiaomi_auth_progress_status_account_verified), nmpwovhVar3.getString(R.string.xiaomi_auth_progress_detail_quote_ready));
                                    vlyywxvVar3.qxvquar();
                                    String str12 = "Quote ready — " + str8 + " / " + str9 + ", cost " + i5 + " credit, available " + i6 + ". Tap AUTHORIZE to reserve credit and the signing slot.";
                                    zftrkmx zftrkmxVar = new zftrkmx(nmpwovhVar2, i4, xhyvkaxVar3, zwccvwtVar3, str10, str9, str8, i5, z2);
                                    if (vlyywxvVar3.pvkaerr) {
                                        return;
                                    }
                                    vlyywxvVar3.vivhedu(str12);
                                    vlyywxvVar3.qwgjehf = zftrkmxVar;
                                    vlyywxvVar3.uiqyzsp = false;
                                    AlertDialog alertDialog2 = vlyywxvVar3.ojyssqt;
                                    alertDialog2.setCancelable(true);
                                    alertDialog2.setCanceledOnTouchOutside(false);
                                    vlyywxvVar3.czidoiw.setText(R.string.xiaomi_new_security_confirm_action);
                                    vlyywxvVar3.oqexvyb();
                                }
                            }
                        });
                    } catch (Throwable th2) {
                        th = th2;
                        message = th.getMessage();
                        if (message == null || message.trim().isEmpty()) {
                            message = nmpwovhVar.getString(R.string.xiaomi_authorize_unknown_error);
                        }
                    }
                } catch (Throwable th3) {
                    yztlqmsVarEqqqfvj = null;
                    th = th3;
                }
            }
        });
    }

    public final void thbdbid() {
        if (this.snbdnwo == null || this.nysvajy == null) {
            return;
        }
        if (this.xhyvkax) {
            this.snbdnwo.imuemzb();
        } else if (!this.jcyrpko.isEmpty()) {
            this.snbdnwo.dytyqos(this.jcyrpko.size());
        }
        sjexbpf();
    }

    @Override // com.rynx.app.ojyssqt
    public final UsbDevice utmeivs(Intent intent) {
        return Build.VERSION.SDK_INT >= 33 ? (UsbDevice) intent.getParcelableExtra("device", UsbDevice.class) : (UsbDevice) intent.getParcelableExtra("device");
    }

    public final void yojulhu() {
        if (this.nysvajy == null || this.jcyrpko.isEmpty() || isFinishing() || isDestroyed()) {
            return;
        }
        List list = this.jcyrpko;
        zwccvwt zwccvwtVar = this.laodqsm;
        final kxotgjb kxotgjbVar = new kxotgjb(this);
        if (isFinishing() || isDestroyed()) {
            return;
        }
        int size = list == null ? 0 : list.size();
        int iQunltjs = x.zamkzqg.qunltjs(this, 14);
        LinearLayout linearLayoutXbdyiew = x.zamkzqg.xbdyiew(this, 0);
        linearLayoutXbdyiew.setPadding(iQunltjs, x.zamkzqg.qunltjs(this, 6), iQunltjs, x.zamkzqg.qunltjs(this, 4));
        EditText editText = new EditText(this);
        editText.setSingleLine(true);
        editText.setHint(R.string.xiaomi_device_picker_search_hint);
        editText.setTextColor(x.zamkzqg.zngzleo(this));
        editText.setHintTextColor(x.zamkzqg.jbmzxye(this));
        editText.setTextSize(14.0f);
        editText.setInputType(524289);
        editText.setPadding(x.zamkzqg.qunltjs(this, 14), x.zamkzqg.qunltjs(this, 11), x.zamkzqg.qunltjs(this, 14), x.zamkzqg.qunltjs(this, 11));
        editText.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.atntgcp(this), x.zamkzqg.slxntng(this), x.zamkzqg.qunltjs(this, 14)));
        x.zamkzqg.enxkjpu(this, editText, R.drawable.ic_search, x.zamkzqg.jbmzxye(this));
        linearLayoutXbdyiew.addView(editText, new LinearLayout.LayoutParams(-1, -2));
        TextView textViewOxoagud = x.zamkzqg.oxoagud(this, getString(R.string.xiaomi_device_picker_result_count, Integer.valueOf(size)), 11, x.zamkzqg.jbmzxye(this), false);
        textViewOxoagud.setPadding(0, x.zamkzqg.qunltjs(this, 10), 0, x.zamkzqg.qunltjs(this, 6));
        linearLayoutXbdyiew.addView(textViewOxoagud);
        FrameLayout frameLayout = new FrameLayout(this);
        int iMin = Math.min(x.zamkzqg.qunltjs(this, 500), Math.max(x.zamkzqg.qunltjs(this, 260), (int) (getResources().getDisplayMetrics().heightPixels * 0.58f)));
        final ListView listView = new ListView(this);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setClipToPadding(false);
        listView.setPadding(0, 0, 0, x.zamkzqg.qunltjs(this, 6));
        frameLayout.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, getString(R.string.xiaomi_device_picker_empty), 13, x.zamkzqg.jbmzxye(this), false);
        textViewOxoagud2.setGravity(17);
        textViewOxoagud2.setVisibility(8);
        frameLayout.addView(textViewOxoagud2, new FrameLayout.LayoutParams(-1, -1));
        linearLayoutXbdyiew.addView(frameLayout, new LinearLayout.LayoutParams(-1, iMin));
        final osgyung osgyungVar = new osgyung(this, list, zwccvwtVar);
        listView.setAdapter((ListAdapter) osgyungVar);
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(R.string.xiaomi_device_picker_title).setView(linearLayoutXbdyiew).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).create();
        final hhqpjvl hhqpjvlVar = new hhqpjvl(osgyungVar, textViewOxoagud, this, listView, textViewOxoagud2, 5);
        editText.addTextChangedListener(new zrcmcht(osgyungVar, hhqpjvlVar));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: x.jcyrpko
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                osgyung osgyungVar2 = osgyungVar;
                AlertDialog alertDialog = alertDialogCreate;
                kxotgjb kxotgjbVar2 = kxotgjbVar;
                zwccvwt item = osgyungVar2.getItem(i);
                if (item == null) {
                    return;
                }
                alertDialog.dismiss();
                com.rynx.app.nmpwovh nmpwovhVar = kxotgjbVar2.nmpwovh;
                if (nmpwovhVar.nysvajy == null || nmpwovhVar.isFinishing() || nmpwovhVar.isDestroyed()) {
                    return;
                }
                nmpwovhVar.rpilpcp();
                nmpwovhVar.laodqsm = item;
                nmpwovhVar.sjexbpf();
                x.zfmpmio.nmpwovh(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_device_model_selected, item.ojyssqt), true);
            }
        });
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: x.laodqsm
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                hhqpjvlVar.run();
                osgyung osgyungVar2 = osgyungVar;
                String str = osgyungVar2.lthborb;
                int i = -1;
                if (!str.isEmpty()) {
                    int i2 = 0;
                    while (true) {
                        ArrayList arrayList = osgyungVar2.vivhedu;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        if (str.equals(((zwccvwt) arrayList.get(i2)).ojyssqt())) {
                            i = i2;
                            break;
                        }
                        i2++;
                    }
                }
                if (i >= 0) {
                    listView.setSelection(i);
                }
            }
        });
        alertDialogCreate.show();
    }

    public final void ysluikv(String str) {
        hiofinr hiofinrVar = this.qdiugcp;
        xhyvkax xhyvkaxVar = this.iqvvlnh;
        this.qdiugcp = null;
        this.gdkopre = "";
        this.vlyywxv = "";
        this.nlcdwap = "";
        this.wrbqriz = "";
        if (hiofinrVar == null || xhyvkaxVar == null || !this.dreanqi.isEmpty()) {
            return;
        }
        rceuwfv(hiofinrVar.nmpwovh, xhyvkaxVar);
        if ("replace".equals(str)) {
            return;
        }
        ((MainActivity) this).nmpwovh("[SLA] Prepared Xiaomi authorization released (" + str + ").");
    }

    public final void zftrkmx() {
        if (!this.nsyqsfj && !this.gzokllk && !this.lpkdqgx) {
            recreate();
        } else {
            iwjoiry();
            Toast.makeText(this, R.string.settings_appearance_deferred, 1).show();
        }
    }
}
