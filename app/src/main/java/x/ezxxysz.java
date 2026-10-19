package x;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedCallback;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import com.rynx.app.adbfastboot.AdbFastbootNative;
import com.rynx.app.security.EncryptedNativeLoader;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ezxxysz implements Runnable {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ com.rynx.app.nmpwovh ojyssqt;

    public /* synthetic */ ezxxysz(com.rynx.app.nmpwovh nmpwovhVar, int i) {
        this.nmpwovh = i;
        this.ojyssqt = nmpwovhVar;
    }

    /* JADX WARN: Type inference failed for: r12v122, types: [x.gefzxcg] */
    private final void nmpwovh() {
        int i = 6;
        final int i2 = 0;
        final com.rynx.app.nmpwovh nmpwovhVar = this.ojyssqt;
        if (nmpwovhVar.isFinishing() || nmpwovhVar.isDestroyed()) {
            return;
        }
        nmpwovhVar.uiqyzsp = true;
        nmpwovhVar.vopsyhw = null;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            nmpwovhVar.fadblxi = new gefzxcg(nmpwovhVar);
            nmpwovhVar.getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, nmpwovhVar.fadblxi);
        }
        nmpwovhVar.dplrlfq = (UsbManager) nmpwovhVar.getSystemService("usb");
        MainActivity mainActivity = (MainActivity) nmpwovhVar;
        IntentFilter intentFilter = new IntentFilter("com.rynx.app.USB_PERMISSION");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        iasgsgq iasgsgqVar = mainActivity.neppdxk;
        if (i3 >= 33) {
            mainActivity.registerReceiver(iasgsgqVar, intentFilter, 4);
        } else {
            mainActivity.registerReceiver(iasgsgqVar, intentFilter);
        }
        final FrameLayout frameLayout = new FrameLayout(nmpwovhVar);
        frameLayout.setBackgroundColor(nmpwovhVar.nmpwovh);
        FrameLayout frameLayout2 = new FrameLayout(nmpwovhVar);
        nmpwovhVar.exhiehf = frameLayout2;
        frameLayout2.setClipChildren(false);
        nmpwovhVar.exhiehf.setClipToPadding(false);
        frameLayout.addView(nmpwovhVar.exhiehf, new FrameLayout.LayoutParams(-1, -1));
        kxotgjb kxotgjbVar = new kxotgjb(nmpwovhVar);
        ScrollView scrollView = new ScrollView(nmpwovhVar);
        scrollView.setFillViewport(true);
        scrollView.setBackgroundColor(zamkzqg.buswjhz(nmpwovhVar));
        LinearLayout linearLayoutXbdyiew = zamkzqg.xbdyiew(nmpwovhVar, 18);
        scrollView.addView(linearLayoutXbdyiew);
        linearLayoutXbdyiew.addView(zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.app_name), 27, zamkzqg.zngzleo(nmpwovhVar), true));
        TextView textViewOxoagud = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.setup_title), 14, zamkzqg.nmpwovh(nmpwovhVar), true);
        textViewOxoagud.setPadding(0, 0, 0, zamkzqg.qunltjs(nmpwovhVar, 4));
        linearLayoutXbdyiew.addView(textViewOxoagud);
        TextView textViewOxoagud2 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.setup_intro), 13, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud2.setLineSpacing(0.0f, 1.12f);
        textViewOxoagud2.setPadding(0, 0, 0, zamkzqg.qunltjs(nmpwovhVar, 12));
        linearLayoutXbdyiew.addView(textViewOxoagud2);
        LinearLayout linearLayoutZwaqeaz = zamkzqg.zwaqeaz(nmpwovhVar);
        linearLayoutZwaqeaz.addView(zamkzqg.ysaclsr(nmpwovhVar, R.string.setup_storage_access));
        TextView textViewOxoagud3 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.setup_required), 19, zamkzqg.ohwxijw(nmpwovhVar), true);
        zamkzqg.enxkjpu(nmpwovhVar, textViewOxoagud3, R.drawable.ic_warning, zamkzqg.ohwxijw(nmpwovhVar));
        textViewOxoagud3.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 6), 0, zamkzqg.qunltjs(nmpwovhVar, 7));
        linearLayoutZwaqeaz.addView(textViewOxoagud3);
        TextView textViewOxoagud4 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.setup_storage_desc), 12, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud4.setLineSpacing(0.0f, 1.12f);
        linearLayoutZwaqeaz.addView(textViewOxoagud4);
        int iNmpwovh = zamkzqg.nmpwovh(nmpwovhVar);
        TextView textViewLclupha = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.setup_grant_storage), new nmpwovh(kxotgjbVar, i));
        zamkzqg.enxkjpu(nmpwovhVar, textViewLclupha, R.drawable.ic_file, iNmpwovh);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(nmpwovhVar, 48));
        layoutParams.topMargin = zamkzqg.qunltjs(nmpwovhVar, 12);
        linearLayoutZwaqeaz.addView(textViewLclupha, layoutParams);
        linearLayoutXbdyiew.addView(linearLayoutZwaqeaz, zamkzqg.uiqyzsp(nmpwovhVar));
        LinearLayout linearLayoutZwaqeaz2 = zamkzqg.zwaqeaz(nmpwovhVar);
        linearLayoutZwaqeaz2.addView(zamkzqg.ysaclsr(nmpwovhVar, R.string.setup_after_storage));
        TextView textViewOxoagud5 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.setup_flow), 12, zamkzqg.zngzleo(nmpwovhVar), true);
        textViewOxoagud5.setLineSpacing(0.0f, 1.14f);
        linearLayoutZwaqeaz2.addView(textViewOxoagud5);
        TextView textViewOxoagud6 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.setup_flow_help), 12, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud6.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 8), 0, 0);
        textViewOxoagud6.setLineSpacing(0.0f, 1.12f);
        linearLayoutZwaqeaz2.addView(textViewOxoagud6);
        linearLayoutXbdyiew.addView(linearLayoutZwaqeaz2, zamkzqg.uiqyzsp(nmpwovhVar));
        nmpwovhVar.bpqosqe = textViewOxoagud3;
        nmpwovhVar.araemok = textViewLclupha;
        nmpwovhVar.jofyvuh = textViewOxoagud5;
        nmpwovhVar.yonoayx = scrollView;
        final gepzcpd gepzcpdVar = new gepzcpd(nmpwovhVar);
        FrameLayout frameLayout3 = new FrameLayout(nmpwovhVar);
        frameLayout3.setBackgroundColor(zamkzqg.buswjhz(nmpwovhVar));
        if (zamkzqg.jlgwuft(nmpwovhVar)) {
            View view = new View(nmpwovhVar);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(1);
            gradientDrawable.setGradientCenter(0.5f, 0.0f);
            gradientDrawable.setGradientRadius(zamkzqg.qunltjs(nmpwovhVar, 260));
            gradientDrawable.setColors(new int[]{zamkzqg.uzyihoe(zamkzqg.nmpwovh(nmpwovhVar), zamkzqg.ysluikv(nmpwovhVar) ? 54 : 36), zamkzqg.uzyihoe(zamkzqg.nmpwovh(nmpwovhVar), 0)});
            view.setBackground(gradientDrawable);
            frameLayout3.addView(view, new FrameLayout.LayoutParams(-1, zamkzqg.qunltjs(nmpwovhVar, 300), 48));
        }
        ScrollView scrollView2 = new ScrollView(nmpwovhVar);
        scrollView2.setFillViewport(true);
        scrollView2.setBackgroundColor(nmpwovhVar.getColor(R.color.rynx_transparent));
        scrollView2.setClipToPadding(false);
        frameLayout3.addView(scrollView2, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayoutXbdyiew2 = zamkzqg.xbdyiew(nmpwovhVar, 16);
        linearLayoutXbdyiew2.setBackgroundColor(nmpwovhVar.getColor(R.color.rynx_transparent));
        linearLayoutXbdyiew2.setPadding(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_page_padding), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_page_padding_top), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_page_padding), 0);
        scrollView2.addView(linearLayoutXbdyiew2);
        FrameLayout frameLayout4 = new FrameLayout(nmpwovhVar);
        frameLayout4.addView(zamkzqg.wfxzfba(nmpwovhVar, R.drawable.ic_hamburger, R.string.nav_menu, new View.OnClickListener() { // from class: x.npkgpdo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i2) {
                    case 0:
                        gepzcpdVar.nmpwovh.nhhacgu("menu");
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.home_preloader_file), mainActivity2.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity2, 2));
                            break;
                        }
                        break;
                    case 2:
                        MainActivity mainActivity3 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity3.yjbrzgu("preloader_path"))) {
                            mainActivity3.rpilpcp();
                            mainActivity3.lcgzsis("", "");
                            mainActivity3.iasgsgq(null, "selected-preloader");
                            mainActivity3.nmpwovh(mainActivity3.getString(R.string.gui_preloader_cleared));
                            Toast.makeText(mainActivity3, R.string.gui_preloader_cleared_toast, 0).show();
                            mainActivity3.gefzxcg();
                            break;
                        }
                        break;
                    case 3:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 4:
                        gepzcpdVar.nmpwovh.yonoayx();
                        break;
                    case 5:
                        gepzcpdVar.nmpwovh.nhhacgu("settings");
                        break;
                    case 6:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 7:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity4.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity4, mainActivity4.getString(R.string.home_da_file), mainActivity4.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity4, 3));
                            break;
                        }
                        break;
                    case 8:
                        MainActivity mainActivity5 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity5.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.home_auth_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 1));
                            break;
                        }
                        break;
                    default:
                        MainActivity mainActivity6 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity6.yjbrzgu("auth_path"))) {
                            mainActivity6.rpilpcp();
                            mainActivity6.getSharedPreferences("rynx_persistent_session", 0).edit().putString("auth_path", "").apply();
                            mainActivity6.iasgsgq(null, "selected-auth");
                            mainActivity6.nmpwovh(mainActivity6.getString(R.string.gui_auth_cleared));
                            Toast.makeText(mainActivity6, R.string.gui_auth_cleared_toast, 0).show();
                            mainActivity6.gefzxcg();
                            break;
                        }
                        break;
                }
            }
        }), new FrameLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_header_button_size), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_header_button_size), 8388627));
        final int i4 = 5;
        frameLayout4.addView(zamkzqg.wfxzfba(nmpwovhVar, R.drawable.ic_settings, R.string.nav_settings, new View.OnClickListener() { // from class: x.npkgpdo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i4) {
                    case 0:
                        gepzcpdVar.nmpwovh.nhhacgu("menu");
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.home_preloader_file), mainActivity2.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity2, 2));
                            break;
                        }
                        break;
                    case 2:
                        MainActivity mainActivity3 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity3.yjbrzgu("preloader_path"))) {
                            mainActivity3.rpilpcp();
                            mainActivity3.lcgzsis("", "");
                            mainActivity3.iasgsgq(null, "selected-preloader");
                            mainActivity3.nmpwovh(mainActivity3.getString(R.string.gui_preloader_cleared));
                            Toast.makeText(mainActivity3, R.string.gui_preloader_cleared_toast, 0).show();
                            mainActivity3.gefzxcg();
                            break;
                        }
                        break;
                    case 3:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 4:
                        gepzcpdVar.nmpwovh.yonoayx();
                        break;
                    case 5:
                        gepzcpdVar.nmpwovh.nhhacgu("settings");
                        break;
                    case 6:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 7:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity4.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity4, mainActivity4.getString(R.string.home_da_file), mainActivity4.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity4, 3));
                            break;
                        }
                        break;
                    case 8:
                        MainActivity mainActivity5 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity5.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.home_auth_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 1));
                            break;
                        }
                        break;
                    default:
                        MainActivity mainActivity6 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity6.yjbrzgu("auth_path"))) {
                            mainActivity6.rpilpcp();
                            mainActivity6.getSharedPreferences("rynx_persistent_session", 0).edit().putString("auth_path", "").apply();
                            mainActivity6.iasgsgq(null, "selected-auth");
                            mainActivity6.nmpwovh(mainActivity6.getString(R.string.gui_auth_cleared));
                            Toast.makeText(mainActivity6, R.string.gui_auth_cleared_toast, 0).show();
                            mainActivity6.gefzxcg();
                            break;
                        }
                        break;
                }
            }
        }), new FrameLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_header_button_size), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_header_button_size), 8388629));
        LinearLayout linearLayout = new LinearLayout(nmpwovhVar);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        FrameLayout frameLayout5 = new FrameLayout(nmpwovhVar);
        ljhdwjr ljhdwjrVar = new ljhdwjr(nmpwovhVar);
        ljhdwjrVar.setContentDescription(nmpwovhVar.getString(R.string.creator_logo_content_description));
        int i5 = 17;
        frameLayout5.addView(ljhdwjrVar, new FrameLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_creator_logo_compact_size), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_creator_logo_compact_size), 17));
        linearLayout.addView(frameLayout5, new LinearLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_creator_logo_slot_width), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_header_button_size)));
        LinearLayout linearLayout2 = new LinearLayout(nmpwovhVar);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        TextView textViewAxbavsj = zamkzqg.axbavsj(nmpwovhVar, R.string.app_name, R.dimen.home_page_title_text_size, zamkzqg.zngzleo(nmpwovhVar), true);
        String string = nmpwovhVar.getString(R.string.app_name);
        int iLastIndexOf = string.lastIndexOf("Link");
        if (iLastIndexOf >= 0) {
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(new ForegroundColorSpan(zamkzqg.nmpwovh(nmpwovhVar)), iLastIndexOf, string.length(), 33);
            textViewAxbavsj.setText(spannableString);
            i5 = 17;
        }
        textViewAxbavsj.setGravity(i5);
        TextView textViewAxbavsj2 = zamkzqg.axbavsj(nmpwovhVar, R.string.app_subtitle, R.dimen.home_page_subtitle_text_size, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewAxbavsj2.setGravity(i5);
        linearLayout2.addView(textViewAxbavsj);
        linearLayout2.addView(textViewAxbavsj2);
        linearLayout.addView(linearLayout2);
        frameLayout4.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, i5));
        linearLayoutXbdyiew2.addView(frameLayout4, new LinearLayout.LayoutParams(-1, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_header_height)));
        LinearLayout linearLayoutZwaqeaz3 = zamkzqg.zwaqeaz(nmpwovhVar);
        linearLayoutZwaqeaz3.addView(zamkzqg.kpmmknm(nmpwovhVar, R.string.home_usb_status));
        LinearLayout linearLayoutLvtqoqa = zamkzqg.lvtqoqa(nmpwovhVar);
        linearLayoutLvtqoqa.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_card_content_gap);
        linearLayoutZwaqeaz3.addView(linearLayoutLvtqoqa, layoutParams2);
        LinearLayout linearLayoutLvtqoqa2 = zamkzqg.lvtqoqa(nmpwovhVar);
        linearLayoutLvtqoqa2.setGravity(16);
        ImageView imageView = new ImageView(nmpwovhVar);
        imageView.setImageResource(R.drawable.ic_usb);
        imageView.setImageTintList(ColorStateList.valueOf(zamkzqg.nmpwovh(nmpwovhVar)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int dimensionPixelSize = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_usb_orb_icon_padding);
        imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        imageView.setBackground(zamkzqg.jtfjrri(nmpwovhVar, zamkzqg.atntgcp(nmpwovhVar), zamkzqg.nmpwovh(nmpwovhVar), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_usb_orb_ring_width)));
        linearLayoutLvtqoqa2.addView(imageView, new LinearLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_usb_orb_size), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_usb_orb_size)));
        LinearLayout linearLayout3 = new LinearLayout(nmpwovhVar);
        linearLayout3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams3.leftMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_usb_orb_text_gap);
        linearLayoutLvtqoqa2.addView(linearLayout3, layoutParams3);
        TextView textViewAxbavsj3 = zamkzqg.axbavsj(nmpwovhVar, R.string.home_gui_stopped, R.dimen.home_status_chip_text_size, zamkzqg.zngzleo(nmpwovhVar), true);
        textViewAxbavsj3.setMaxLines(2);
        textViewAxbavsj3.setTag(imageView);
        linearLayout3.addView(textViewAxbavsj3);
        TextView textViewOxoagud7 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.home_usb_transport_hint), 10, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud7.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 3), 0, 0);
        linearLayout3.addView(textViewOxoagud7);
        linearLayoutLvtqoqa.addView(linearLayoutLvtqoqa2, new LinearLayout.LayoutParams(0, -2, 0.95f));
        View view2 = new View(nmpwovhVar);
        view2.setBackgroundColor(zamkzqg.qyeibyo(nmpwovhVar));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_stroke_width), -1);
        layoutParams4.setMargins(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_status_column_gap), 0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_status_column_gap), 0);
        linearLayoutLvtqoqa.addView(view2, layoutParams4);
        LinearLayout linearLayout4 = new LinearLayout(nmpwovhVar);
        linearLayout4.setOrientation(1);
        TextView textViewNkemejx = zamkzqg.nkemejx(nmpwovhVar, linearLayout4, R.string.home_mode, nmpwovhVar.getString(R.string.status_waiting_usb));
        TextView textViewNkemejx2 = zamkzqg.nkemejx(nmpwovhVar, linearLayout4, R.string.home_session, nmpwovhVar.getString(R.string.status_stopped_upper));
        TextView textViewNkemejx3 = zamkzqg.nkemejx(nmpwovhVar, linearLayout4, R.string.home_cpu, nmpwovhVar.getString(R.string.value_not_available));
        TextView textViewNkemejx4 = zamkzqg.nkemejx(nmpwovhVar, linearLayout4, R.string.home_vid_pid, nmpwovhVar.getString(R.string.value_not_available));
        TextView textViewNkemejx5 = zamkzqg.nkemejx(nmpwovhVar, linearLayout4, R.string.home_da_file, nmpwovhVar.getString(R.string.status_not_configured));
        linearLayoutLvtqoqa.addView(linearLayout4, new LinearLayout.LayoutParams(0, -2, 1.15f));
        linearLayoutXbdyiew2.addView(linearLayoutZwaqeaz3, zamkzqg.uiqyzsp(nmpwovhVar));
        LinearLayout linearLayoutZwaqeaz4 = zamkzqg.zwaqeaz(nmpwovhVar);
        linearLayoutZwaqeaz4.addView(zamkzqg.kpmmknm(nmpwovhVar, R.string.home_connection_steps));
        LinearLayout linearLayoutLvtqoqa3 = zamkzqg.lvtqoqa(nmpwovhVar);
        linearLayoutLvtqoqa3.setGravity(49);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_card_content_gap);
        linearLayoutZwaqeaz4.addView(linearLayoutLvtqoqa3, layoutParams5);
        TextView textViewUlafhci = zamkzqg.ulafhci(nmpwovhVar, linearLayoutLvtqoqa3, 1, R.string.home_step_usb, R.drawable.ic_usb, null);
        View view3 = new View(nmpwovhVar);
        view3.setBackgroundColor(zamkzqg.qyeibyo(nmpwovhVar));
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_step_connector_width), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_step_line_height));
        layoutParams6.topMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_step_connector_top);
        linearLayoutLvtqoqa3.addView(view3, layoutParams6);
        TextView textViewUlafhci2 = zamkzqg.ulafhci(nmpwovhVar, linearLayoutLvtqoqa3, 2, R.string.home_step_brom, R.drawable.ic_cpu_chip, view3);
        View view4 = new View(nmpwovhVar);
        view4.setBackgroundColor(zamkzqg.qyeibyo(nmpwovhVar));
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_step_connector_width), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_step_line_height));
        layoutParams7.topMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_step_connector_top);
        linearLayoutLvtqoqa3.addView(view4, layoutParams7);
        TextView textViewUlafhci3 = zamkzqg.ulafhci(nmpwovhVar, linearLayoutLvtqoqa3, 3, R.string.home_step_da, R.drawable.ic_send_da, view4);
        View view5 = new View(nmpwovhVar);
        view5.setBackgroundColor(zamkzqg.qyeibyo(nmpwovhVar));
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_step_connector_width), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_step_line_height));
        layoutParams8.topMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_step_connector_top);
        linearLayoutLvtqoqa3.addView(view5, layoutParams8);
        TextView textViewUlafhci4 = zamkzqg.ulafhci(nmpwovhVar, linearLayoutLvtqoqa3, 4, R.string.home_step_ready, R.drawable.ic_status_done, view5);
        LinearLayout linearLayoutXbdyiew3 = zamkzqg.xbdyiew(nmpwovhVar, 0);
        linearLayoutXbdyiew3.setVisibility(8);
        linearLayoutXbdyiew3.setPadding(zamkzqg.qunltjs(nmpwovhVar, 12), zamkzqg.qunltjs(nmpwovhVar, 10), zamkzqg.qunltjs(nmpwovhVar, 12), zamkzqg.qunltjs(nmpwovhVar, 10));
        linearLayoutXbdyiew3.setBackground(zamkzqg.jvtqflj(nmpwovhVar, zamkzqg.atntgcp(nmpwovhVar), zamkzqg.pzqxblc(nmpwovhVar), zamkzqg.qunltjs(nmpwovhVar, 12)));
        TextView textViewOxoagud8 = zamkzqg.oxoagud(nmpwovhVar, "", 11, zamkzqg.pzqxblc(nmpwovhVar), false);
        textViewOxoagud8.setLineSpacing(0.0f, 1.12f);
        linearLayoutXbdyiew3.addView(textViewOxoagud8, new LinearLayout.LayoutParams(-1, -2));
        textViewOxoagud8.setTextIsSelectable(true);
        TextView textViewOxoagud9 = zamkzqg.oxoagud(nmpwovhVar, "", 10, zamkzqg.zngzleo(nmpwovhVar), false);
        textViewOxoagud9.setTypeface(Typeface.MONOSPACE);
        textViewOxoagud9.setTextIsSelectable(true);
        textViewOxoagud9.setLineSpacing(0.0f, 1.1f);
        textViewOxoagud9.setVisibility(8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.topMargin = zamkzqg.qunltjs(nmpwovhVar, 8);
        linearLayoutXbdyiew3.addView(textViewOxoagud9, layoutParams9);
        LinearLayout linearLayoutLvtqoqa4 = zamkzqg.lvtqoqa(nmpwovhVar);
        linearLayoutLvtqoqa4.setGravity(16);
        TextView textViewLclupha2 = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.home_error_show_details), new nmpwovh(textViewOxoagud9, 4));
        TextView textViewLclupha3 = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.home_error_copy), new pzqxblc(nmpwovhVar, textViewOxoagud9, 6));
        linearLayoutLvtqoqa4.addView(textViewLclupha2, new LinearLayout.LayoutParams(0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height), 1.0f));
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height), 1.0f);
        layoutParams10.leftMargin = zamkzqg.qunltjs(nmpwovhVar, 8);
        linearLayoutLvtqoqa4.addView(textViewLclupha3, layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams11.topMargin = zamkzqg.qunltjs(nmpwovhVar, 8);
        linearLayoutXbdyiew3.addView(linearLayoutLvtqoqa4, layoutParams11);
        int iPzqxblc = zamkzqg.pzqxblc(nmpwovhVar);
        final int i6 = 6;
        TextView textViewLclupha4 = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.action_retry), new View.OnClickListener() { // from class: x.npkgpdo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                switch (i6) {
                    case 0:
                        gepzcpdVar.nmpwovh.nhhacgu("menu");
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.home_preloader_file), mainActivity2.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity2, 2));
                            break;
                        }
                        break;
                    case 2:
                        MainActivity mainActivity3 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity3.yjbrzgu("preloader_path"))) {
                            mainActivity3.rpilpcp();
                            mainActivity3.lcgzsis("", "");
                            mainActivity3.iasgsgq(null, "selected-preloader");
                            mainActivity3.nmpwovh(mainActivity3.getString(R.string.gui_preloader_cleared));
                            Toast.makeText(mainActivity3, R.string.gui_preloader_cleared_toast, 0).show();
                            mainActivity3.gefzxcg();
                            break;
                        }
                        break;
                    case 3:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 4:
                        gepzcpdVar.nmpwovh.yonoayx();
                        break;
                    case 5:
                        gepzcpdVar.nmpwovh.nhhacgu("settings");
                        break;
                    case 6:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 7:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity4.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity4, mainActivity4.getString(R.string.home_da_file), mainActivity4.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity4, 3));
                            break;
                        }
                        break;
                    case 8:
                        MainActivity mainActivity5 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity5.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.home_auth_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 1));
                            break;
                        }
                        break;
                    default:
                        MainActivity mainActivity6 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity6.yjbrzgu("auth_path"))) {
                            mainActivity6.rpilpcp();
                            mainActivity6.getSharedPreferences("rynx_persistent_session", 0).edit().putString("auth_path", "").apply();
                            mainActivity6.iasgsgq(null, "selected-auth");
                            mainActivity6.nmpwovh(mainActivity6.getString(R.string.gui_auth_cleared));
                            Toast.makeText(mainActivity6, R.string.gui_auth_cleared_toast, 0).show();
                            mainActivity6.gefzxcg();
                            break;
                        }
                        break;
                }
            }
        });
        zamkzqg.enxkjpu(nmpwovhVar, textViewLclupha4, R.drawable.ic_refresh, iPzqxblc);
        textViewLclupha4.setTextColor(zamkzqg.pzqxblc(nmpwovhVar));
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
        layoutParams12.topMargin = zamkzqg.qunltjs(nmpwovhVar, 8);
        linearLayoutXbdyiew3.addView(textViewLclupha4, layoutParams12);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams13.topMargin = zamkzqg.qunltjs(nmpwovhVar, 12);
        linearLayoutZwaqeaz4.addView(linearLayoutXbdyiew3, layoutParams13);
        linearLayoutXbdyiew2.addView(linearLayoutZwaqeaz4, zamkzqg.uiqyzsp(nmpwovhVar));
        LinearLayout linearLayoutZwaqeaz5 = zamkzqg.zwaqeaz(nmpwovhVar);
        TextView textViewKpmmknm = zamkzqg.kpmmknm(nmpwovhVar, R.string.home_device_info);
        zamkzqg.enxkjpu(nmpwovhVar, textViewKpmmknm, R.drawable.ic_device_info, zamkzqg.nmpwovh(nmpwovhVar));
        linearLayoutZwaqeaz5.addView(textViewKpmmknm);
        LinearLayout linearLayoutLvtqoqa5 = zamkzqg.lvtqoqa(nmpwovhVar);
        linearLayoutLvtqoqa5.setGravity(48);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams14.topMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_card_content_gap);
        linearLayoutZwaqeaz5.addView(linearLayoutLvtqoqa5, layoutParams14);
        LinearLayout linearLayoutJbyhfxz = zamkzqg.jbyhfxz(nmpwovhVar, 0);
        TextView textViewOqexvyb = zamkzqg.oqexvyb(nmpwovhVar, linearLayoutJbyhfxz, R.string.home_storage, false);
        TextView textViewOqexvyb2 = zamkzqg.oqexvyb(nmpwovhVar, linearLayoutJbyhfxz, R.string.home_da_protocol, false);
        linearLayoutLvtqoqa5.addView(linearLayoutJbyhfxz, new LinearLayout.LayoutParams(0, -2, 0.8f));
        View view6 = new View(nmpwovhVar);
        view6.setBackgroundColor(zamkzqg.qyeibyo(nmpwovhVar));
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_stroke_width), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_info_column_height));
        layoutParams15.setMargins(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_info_column_gap), 0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_info_column_gap), 0);
        linearLayoutLvtqoqa5.addView(view6, layoutParams15);
        LinearLayout linearLayoutJbyhfxz2 = zamkzqg.jbyhfxz(nmpwovhVar, R.string.home_device_identifiers);
        TextView textViewOqexvyb3 = zamkzqg.oqexvyb(nmpwovhVar, linearLayoutJbyhfxz2, R.string.home_meid, true);
        TextView textViewOqexvyb4 = zamkzqg.oqexvyb(nmpwovhVar, linearLayoutJbyhfxz2, R.string.home_soc_id, true);
        linearLayoutLvtqoqa5.addView(linearLayoutJbyhfxz2, new LinearLayout.LayoutParams(0, -2, 1.15f));
        View view7 = new View(nmpwovhVar);
        view7.setBackgroundColor(zamkzqg.qyeibyo(nmpwovhVar));
        LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_stroke_width), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_info_column_height));
        layoutParams16.setMargins(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_info_column_gap), 0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_info_column_gap), 0);
        linearLayoutLvtqoqa5.addView(view7, layoutParams16);
        LinearLayout linearLayoutJbyhfxz3 = zamkzqg.jbyhfxz(nmpwovhVar, R.string.home_security);
        TextView textViewDasxvpc = zamkzqg.dasxvpc(nmpwovhVar, linearLayoutJbyhfxz3, R.string.home_sbc);
        TextView textViewDasxvpc2 = zamkzqg.dasxvpc(nmpwovhVar, linearLayoutJbyhfxz3, R.string.home_sla);
        TextView textViewDasxvpc3 = zamkzqg.dasxvpc(nmpwovhVar, linearLayoutJbyhfxz3, R.string.home_daa);
        linearLayoutLvtqoqa5.addView(linearLayoutJbyhfxz3, new LinearLayout.LayoutParams(0, -2, 0.9f));
        linearLayoutXbdyiew2.addView(linearLayoutZwaqeaz5, zamkzqg.uiqyzsp(nmpwovhVar));
        LinearLayout linearLayoutZwaqeaz6 = zamkzqg.zwaqeaz(nmpwovhVar);
        linearLayoutZwaqeaz6.addView(zamkzqg.kpmmknm(nmpwovhVar, R.string.home_gui_session));
        TextView textViewOxoagud10 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.home_da_file), 10, zamkzqg.nmpwovh(nmpwovhVar), true);
        textViewOxoagud10.setPadding(0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_session_action_spacing), 0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_session_value_spacing));
        linearLayoutZwaqeaz6.addView(textViewOxoagud10);
        TextView textViewOxoagud11 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.status_not_configured), 13, zamkzqg.ohwxijw(nmpwovhVar), true);
        textViewOxoagud11.setTextIsSelectable(true);
        linearLayoutZwaqeaz6.addView(textViewOxoagud11);
        final int i7 = 7;
        TextView textViewBpqosqe = zamkzqg.bpqosqe(nmpwovhVar, R.string.home_select_da, R.drawable.ic_download_agent, new View.OnClickListener() { // from class: x.npkgpdo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i7) {
                    case 0:
                        gepzcpdVar.nmpwovh.nhhacgu("menu");
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.home_preloader_file), mainActivity2.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity2, 2));
                            break;
                        }
                        break;
                    case 2:
                        MainActivity mainActivity3 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity3.yjbrzgu("preloader_path"))) {
                            mainActivity3.rpilpcp();
                            mainActivity3.lcgzsis("", "");
                            mainActivity3.iasgsgq(null, "selected-preloader");
                            mainActivity3.nmpwovh(mainActivity3.getString(R.string.gui_preloader_cleared));
                            Toast.makeText(mainActivity3, R.string.gui_preloader_cleared_toast, 0).show();
                            mainActivity3.gefzxcg();
                            break;
                        }
                        break;
                    case 3:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 4:
                        gepzcpdVar.nmpwovh.yonoayx();
                        break;
                    case 5:
                        gepzcpdVar.nmpwovh.nhhacgu("settings");
                        break;
                    case 6:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 7:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity4.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity4, mainActivity4.getString(R.string.home_da_file), mainActivity4.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity4, 3));
                            break;
                        }
                        break;
                    case 8:
                        MainActivity mainActivity5 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity5.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.home_auth_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 1));
                            break;
                        }
                        break;
                    default:
                        MainActivity mainActivity6 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity6.yjbrzgu("auth_path"))) {
                            mainActivity6.rpilpcp();
                            mainActivity6.getSharedPreferences("rynx_persistent_session", 0).edit().putString("auth_path", "").apply();
                            mainActivity6.iasgsgq(null, "selected-auth");
                            mainActivity6.nmpwovh(mainActivity6.getString(R.string.gui_auth_cleared));
                            Toast.makeText(mainActivity6, R.string.gui_auth_cleared_toast, 0).show();
                            mainActivity6.gefzxcg();
                            break;
                        }
                        break;
                }
            }
        });
        LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-1, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
        layoutParams17.topMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_session_action_spacing);
        linearLayoutZwaqeaz6.addView(textViewBpqosqe, layoutParams17);
        TextView textViewOxoagud12 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.home_auth_file), 10, zamkzqg.nmpwovh(nmpwovhVar), true);
        textViewOxoagud12.setPadding(0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_session_action_spacing), 0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_session_value_spacing));
        linearLayoutZwaqeaz6.addView(textViewOxoagud12);
        TextView textViewOxoagud13 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.home_auth_not_selected), 12, zamkzqg.jbmzxye(nmpwovhVar), true);
        textViewOxoagud13.setTextIsSelectable(true);
        linearLayoutZwaqeaz6.addView(textViewOxoagud13);
        TextView textViewOxoagud14 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.home_auth_help), 9, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud14.setLineSpacing(0.0f, 1.05f);
        textViewOxoagud14.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 3), 0, 0);
        linearLayoutZwaqeaz6.addView(textViewOxoagud14);
        LinearLayout linearLayoutLvtqoqa6 = zamkzqg.lvtqoqa(nmpwovhVar);
        final int i8 = 8;
        TextView textViewBpqosqe2 = zamkzqg.bpqosqe(nmpwovhVar, R.string.home_select_auth, R.drawable.ic_file, new View.OnClickListener() { // from class: x.npkgpdo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i8) {
                    case 0:
                        gepzcpdVar.nmpwovh.nhhacgu("menu");
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.home_preloader_file), mainActivity2.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity2, 2));
                            break;
                        }
                        break;
                    case 2:
                        MainActivity mainActivity3 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity3.yjbrzgu("preloader_path"))) {
                            mainActivity3.rpilpcp();
                            mainActivity3.lcgzsis("", "");
                            mainActivity3.iasgsgq(null, "selected-preloader");
                            mainActivity3.nmpwovh(mainActivity3.getString(R.string.gui_preloader_cleared));
                            Toast.makeText(mainActivity3, R.string.gui_preloader_cleared_toast, 0).show();
                            mainActivity3.gefzxcg();
                            break;
                        }
                        break;
                    case 3:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 4:
                        gepzcpdVar.nmpwovh.yonoayx();
                        break;
                    case 5:
                        gepzcpdVar.nmpwovh.nhhacgu("settings");
                        break;
                    case 6:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 7:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity4.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity4, mainActivity4.getString(R.string.home_da_file), mainActivity4.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity4, 3));
                            break;
                        }
                        break;
                    case 8:
                        MainActivity mainActivity5 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity5.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.home_auth_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 1));
                            break;
                        }
                        break;
                    default:
                        MainActivity mainActivity6 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity6.yjbrzgu("auth_path"))) {
                            mainActivity6.rpilpcp();
                            mainActivity6.getSharedPreferences("rynx_persistent_session", 0).edit().putString("auth_path", "").apply();
                            mainActivity6.iasgsgq(null, "selected-auth");
                            mainActivity6.nmpwovh(mainActivity6.getString(R.string.gui_auth_cleared));
                            Toast.makeText(mainActivity6, R.string.gui_auth_cleared_toast, 0).show();
                            mainActivity6.gefzxcg();
                            break;
                        }
                        break;
                }
            }
        });
        final int i9 = 9;
        TextView textViewLclupha5 = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.home_clear_auth), new View.OnClickListener() { // from class: x.npkgpdo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i9) {
                    case 0:
                        gepzcpdVar.nmpwovh.nhhacgu("menu");
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.home_preloader_file), mainActivity2.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity2, 2));
                            break;
                        }
                        break;
                    case 2:
                        MainActivity mainActivity3 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity3.yjbrzgu("preloader_path"))) {
                            mainActivity3.rpilpcp();
                            mainActivity3.lcgzsis("", "");
                            mainActivity3.iasgsgq(null, "selected-preloader");
                            mainActivity3.nmpwovh(mainActivity3.getString(R.string.gui_preloader_cleared));
                            Toast.makeText(mainActivity3, R.string.gui_preloader_cleared_toast, 0).show();
                            mainActivity3.gefzxcg();
                            break;
                        }
                        break;
                    case 3:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 4:
                        gepzcpdVar.nmpwovh.yonoayx();
                        break;
                    case 5:
                        gepzcpdVar.nmpwovh.nhhacgu("settings");
                        break;
                    case 6:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 7:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity4.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity4, mainActivity4.getString(R.string.home_da_file), mainActivity4.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity4, 3));
                            break;
                        }
                        break;
                    case 8:
                        MainActivity mainActivity5 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity5.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.home_auth_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 1));
                            break;
                        }
                        break;
                    default:
                        MainActivity mainActivity6 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity6.yjbrzgu("auth_path"))) {
                            mainActivity6.rpilpcp();
                            mainActivity6.getSharedPreferences("rynx_persistent_session", 0).edit().putString("auth_path", "").apply();
                            mainActivity6.iasgsgq(null, "selected-auth");
                            mainActivity6.nmpwovh(mainActivity6.getString(R.string.gui_auth_cleared));
                            Toast.makeText(mainActivity6, R.string.gui_auth_cleared_toast, 0).show();
                            mainActivity6.gefzxcg();
                            break;
                        }
                        break;
                }
            }
        });
        textViewLclupha5.setTextSize(10.0f);
        linearLayoutLvtqoqa6.addView(textViewBpqosqe2, new LinearLayout.LayoutParams(0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height), 1.0f));
        LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_auth_clear_width), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
        layoutParams18.leftMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_auth_button_gap);
        linearLayoutLvtqoqa6.addView(textViewLclupha5, layoutParams18);
        LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams19.topMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_session_action_spacing);
        linearLayoutZwaqeaz6.addView(linearLayoutLvtqoqa6, layoutParams19);
        TextView textViewOxoagud15 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.home_preloader_file), 10, zamkzqg.nmpwovh(nmpwovhVar), true);
        textViewOxoagud15.setPadding(0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_session_action_spacing), 0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_session_value_spacing));
        linearLayoutZwaqeaz6.addView(textViewOxoagud15);
        TextView textViewOxoagud16 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.home_preloader_not_selected), 12, zamkzqg.jbmzxye(nmpwovhVar), true);
        textViewOxoagud16.setTextIsSelectable(true);
        linearLayoutZwaqeaz6.addView(textViewOxoagud16);
        TextView textViewOxoagud17 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.home_preloader_help), 9, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud17.setLineSpacing(0.0f, 1.05f);
        textViewOxoagud17.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 3), 0, 0);
        linearLayoutZwaqeaz6.addView(textViewOxoagud17);
        LinearLayout linearLayoutLvtqoqa7 = zamkzqg.lvtqoqa(nmpwovhVar);
        final int i10 = 1;
        TextView textViewBpqosqe3 = zamkzqg.bpqosqe(nmpwovhVar, R.string.home_select_preloader, R.drawable.ic_file, new View.OnClickListener() { // from class: x.npkgpdo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i10) {
                    case 0:
                        gepzcpdVar.nmpwovh.nhhacgu("menu");
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.home_preloader_file), mainActivity2.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity2, 2));
                            break;
                        }
                        break;
                    case 2:
                        MainActivity mainActivity3 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity3.yjbrzgu("preloader_path"))) {
                            mainActivity3.rpilpcp();
                            mainActivity3.lcgzsis("", "");
                            mainActivity3.iasgsgq(null, "selected-preloader");
                            mainActivity3.nmpwovh(mainActivity3.getString(R.string.gui_preloader_cleared));
                            Toast.makeText(mainActivity3, R.string.gui_preloader_cleared_toast, 0).show();
                            mainActivity3.gefzxcg();
                            break;
                        }
                        break;
                    case 3:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 4:
                        gepzcpdVar.nmpwovh.yonoayx();
                        break;
                    case 5:
                        gepzcpdVar.nmpwovh.nhhacgu("settings");
                        break;
                    case 6:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 7:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity4.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity4, mainActivity4.getString(R.string.home_da_file), mainActivity4.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity4, 3));
                            break;
                        }
                        break;
                    case 8:
                        MainActivity mainActivity5 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity5.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.home_auth_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 1));
                            break;
                        }
                        break;
                    default:
                        MainActivity mainActivity6 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity6.yjbrzgu("auth_path"))) {
                            mainActivity6.rpilpcp();
                            mainActivity6.getSharedPreferences("rynx_persistent_session", 0).edit().putString("auth_path", "").apply();
                            mainActivity6.iasgsgq(null, "selected-auth");
                            mainActivity6.nmpwovh(mainActivity6.getString(R.string.gui_auth_cleared));
                            Toast.makeText(mainActivity6, R.string.gui_auth_cleared_toast, 0).show();
                            mainActivity6.gefzxcg();
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 2;
        TextView textViewLclupha6 = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.home_clear_preloader), new View.OnClickListener() { // from class: x.npkgpdo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i11) {
                    case 0:
                        gepzcpdVar.nmpwovh.nhhacgu("menu");
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.home_preloader_file), mainActivity2.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity2, 2));
                            break;
                        }
                        break;
                    case 2:
                        MainActivity mainActivity3 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity3.yjbrzgu("preloader_path"))) {
                            mainActivity3.rpilpcp();
                            mainActivity3.lcgzsis("", "");
                            mainActivity3.iasgsgq(null, "selected-preloader");
                            mainActivity3.nmpwovh(mainActivity3.getString(R.string.gui_preloader_cleared));
                            Toast.makeText(mainActivity3, R.string.gui_preloader_cleared_toast, 0).show();
                            mainActivity3.gefzxcg();
                            break;
                        }
                        break;
                    case 3:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 4:
                        gepzcpdVar.nmpwovh.yonoayx();
                        break;
                    case 5:
                        gepzcpdVar.nmpwovh.nhhacgu("settings");
                        break;
                    case 6:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 7:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity4.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity4, mainActivity4.getString(R.string.home_da_file), mainActivity4.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity4, 3));
                            break;
                        }
                        break;
                    case 8:
                        MainActivity mainActivity5 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity5.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.home_auth_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 1));
                            break;
                        }
                        break;
                    default:
                        MainActivity mainActivity6 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity6.yjbrzgu("auth_path"))) {
                            mainActivity6.rpilpcp();
                            mainActivity6.getSharedPreferences("rynx_persistent_session", 0).edit().putString("auth_path", "").apply();
                            mainActivity6.iasgsgq(null, "selected-auth");
                            mainActivity6.nmpwovh(mainActivity6.getString(R.string.gui_auth_cleared));
                            Toast.makeText(mainActivity6, R.string.gui_auth_cleared_toast, 0).show();
                            mainActivity6.gefzxcg();
                            break;
                        }
                        break;
                }
            }
        });
        textViewLclupha6.setTextSize(10.0f);
        linearLayoutLvtqoqa7.addView(textViewBpqosqe3, new LinearLayout.LayoutParams(0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height), 1.0f));
        LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_auth_clear_width), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
        layoutParams20.leftMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_auth_button_gap);
        linearLayoutLvtqoqa7.addView(textViewLclupha6, layoutParams20);
        LinearLayout.LayoutParams layoutParams21 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams21.topMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_session_action_spacing);
        linearLayoutZwaqeaz6.addView(linearLayoutLvtqoqa7, layoutParams21);
        LinearLayout linearLayoutLvtqoqa8 = zamkzqg.lvtqoqa(nmpwovhVar);
        int iKggugdp = zamkzqg.kggugdp(nmpwovhVar);
        final int i12 = 3;
        TextView textViewLclupha7 = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.action_start), new View.OnClickListener() { // from class: x.npkgpdo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i12) {
                    case 0:
                        gepzcpdVar.nmpwovh.nhhacgu("menu");
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.home_preloader_file), mainActivity2.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity2, 2));
                            break;
                        }
                        break;
                    case 2:
                        MainActivity mainActivity3 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity3.yjbrzgu("preloader_path"))) {
                            mainActivity3.rpilpcp();
                            mainActivity3.lcgzsis("", "");
                            mainActivity3.iasgsgq(null, "selected-preloader");
                            mainActivity3.nmpwovh(mainActivity3.getString(R.string.gui_preloader_cleared));
                            Toast.makeText(mainActivity3, R.string.gui_preloader_cleared_toast, 0).show();
                            mainActivity3.gefzxcg();
                            break;
                        }
                        break;
                    case 3:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 4:
                        gepzcpdVar.nmpwovh.yonoayx();
                        break;
                    case 5:
                        gepzcpdVar.nmpwovh.nhhacgu("settings");
                        break;
                    case 6:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 7:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity4.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity4, mainActivity4.getString(R.string.home_da_file), mainActivity4.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity4, 3));
                            break;
                        }
                        break;
                    case 8:
                        MainActivity mainActivity5 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity5.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.home_auth_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 1));
                            break;
                        }
                        break;
                    default:
                        MainActivity mainActivity6 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity6.yjbrzgu("auth_path"))) {
                            mainActivity6.rpilpcp();
                            mainActivity6.getSharedPreferences("rynx_persistent_session", 0).edit().putString("auth_path", "").apply();
                            mainActivity6.iasgsgq(null, "selected-auth");
                            mainActivity6.nmpwovh(mainActivity6.getString(R.string.gui_auth_cleared));
                            Toast.makeText(mainActivity6, R.string.gui_auth_cleared_toast, 0).show();
                            mainActivity6.gefzxcg();
                            break;
                        }
                        break;
                }
            }
        });
        zamkzqg.enxkjpu(nmpwovhVar, textViewLclupha7, R.drawable.ic_start, iKggugdp);
        textViewLclupha7.setTextColor(zamkzqg.kggugdp(nmpwovhVar));
        textViewLclupha7.setBackground(zamkzqg.jvtqflj(nmpwovhVar, zamkzqg.ojyssqt(nmpwovhVar), zamkzqg.nmpwovh(nmpwovhVar), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_button_radius)));
        zamkzqg.enxkjpu(nmpwovhVar, textViewLclupha7, R.drawable.ic_start, zamkzqg.kggugdp(nmpwovhVar));
        int iPzqxblc2 = zamkzqg.pzqxblc(nmpwovhVar);
        final int i13 = 4;
        TextView textViewLclupha8 = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.action_stop), new View.OnClickListener() { // from class: x.npkgpdo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i13) {
                    case 0:
                        gepzcpdVar.nmpwovh.nhhacgu("menu");
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.home_preloader_file), mainActivity2.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity2, 2));
                            break;
                        }
                        break;
                    case 2:
                        MainActivity mainActivity3 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity3.yjbrzgu("preloader_path"))) {
                            mainActivity3.rpilpcp();
                            mainActivity3.lcgzsis("", "");
                            mainActivity3.iasgsgq(null, "selected-preloader");
                            mainActivity3.nmpwovh(mainActivity3.getString(R.string.gui_preloader_cleared));
                            Toast.makeText(mainActivity3, R.string.gui_preloader_cleared_toast, 0).show();
                            mainActivity3.gefzxcg();
                            break;
                        }
                        break;
                    case 3:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 4:
                        gepzcpdVar.nmpwovh.yonoayx();
                        break;
                    case 5:
                        gepzcpdVar.nmpwovh.nhhacgu("settings");
                        break;
                    case 6:
                        gepzcpdVar.nmpwovh.nsizane();
                        break;
                    case 7:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity4.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity4, mainActivity4.getString(R.string.home_da_file), mainActivity4.lclupha(), new String[]{".bin"}, new pvbzgon(mainActivity4, 3));
                            break;
                        }
                        break;
                    case 8:
                        MainActivity mainActivity5 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (mainActivity5.dplrlfq()) {
                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.home_auth_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 1));
                            break;
                        }
                        break;
                    default:
                        MainActivity mainActivity6 = (MainActivity) gepzcpdVar.nmpwovh;
                        if (!com.rynx.app.ojyssqt.zwaqeaz(mainActivity6.yjbrzgu("auth_path"))) {
                            mainActivity6.rpilpcp();
                            mainActivity6.getSharedPreferences("rynx_persistent_session", 0).edit().putString("auth_path", "").apply();
                            mainActivity6.iasgsgq(null, "selected-auth");
                            mainActivity6.nmpwovh(mainActivity6.getString(R.string.gui_auth_cleared));
                            Toast.makeText(mainActivity6, R.string.gui_auth_cleared_toast, 0).show();
                            mainActivity6.gefzxcg();
                            break;
                        }
                        break;
                }
            }
        });
        zamkzqg.enxkjpu(nmpwovhVar, textViewLclupha8, R.drawable.ic_stop, iPzqxblc2);
        linearLayoutLvtqoqa8.addView(textViewLclupha7, zamkzqg.qxvquar(nmpwovhVar));
        linearLayoutLvtqoqa8.addView(textViewLclupha8, zamkzqg.qxvquar(nmpwovhVar));
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams22.topMargin = nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_session_action_spacing);
        linearLayoutZwaqeaz6.addView(linearLayoutLvtqoqa8, layoutParams22);
        TextView textViewOxoagud18 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.home_session_stopped_hint), 10, zamkzqg.jbmzxye(nmpwovhVar), false);
        zamkzqg.enxkjpu(nmpwovhVar, textViewOxoagud18, R.drawable.ic_info, zamkzqg.nmpwovh(nmpwovhVar));
        textViewOxoagud18.setPadding(0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.home_section_spacing_top), 0, 0);
        linearLayoutZwaqeaz6.addView(textViewOxoagud18);
        linearLayoutXbdyiew2.addView(linearLayoutZwaqeaz6, zamkzqg.uiqyzsp(nmpwovhVar));
        linearLayoutXbdyiew2.addView(new View(nmpwovhVar), new LinearLayout.LayoutParams(-1, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
        nmpwovhVar.gefzxcg = new tmdubwv(frameLayout3, ljhdwjrVar, textViewAxbavsj3, textViewNkemejx, textViewNkemejx2, textViewNkemejx3, textViewNkemejx4, textViewNkemejx5, textViewUlafhci, textViewUlafhci2, textViewUlafhci3, textViewUlafhci4, textViewOxoagud8, textViewLclupha4, textViewOxoagud9, textViewLclupha2, textViewLclupha3, textViewOqexvyb, textViewOqexvyb2, textViewOqexvyb3, textViewOqexvyb4, textViewDasxvpc, textViewDasxvpc2, textViewDasxvpc3, textViewBpqosqe, textViewOxoagud11, textViewBpqosqe2, textViewLclupha5, textViewOxoagud13, textViewBpqosqe3, textViewLclupha6, textViewOxoagud16, textViewLclupha7, textViewLclupha8, textViewOxoagud18);
        nmpwovhVar.kggugdp = textViewAxbavsj3;
        nmpwovhVar.mamlotu = textViewNkemejx;
        nmpwovhVar.yojulhu = textViewNkemejx2;
        nmpwovhVar.jtfjrri = textViewNkemejx3;
        nmpwovhVar.iwjoiry = textViewNkemejx4;
        nmpwovhVar.marclvq = textViewNkemejx5;
        nmpwovhVar.eenkamx = textViewUlafhci;
        nmpwovhVar.rpdxrib = textViewUlafhci2;
        nmpwovhVar.hiygjel = textViewUlafhci3;
        nmpwovhVar.oohojlj = textViewUlafhci4;
        nmpwovhVar.zegwdrn = textViewOxoagud8;
        nmpwovhVar.iilntfn = textViewLclupha4;
        nmpwovhVar.chwohho = textViewOxoagud9;
        nmpwovhVar.ljwltks = textViewLclupha2;
        nmpwovhVar.yhrqvll = (View) textViewOxoagud8.getParent();
        nmpwovhVar.ljhdwjr = textViewOqexvyb;
        nmpwovhVar.ednetju = textViewOqexvyb2;
        nmpwovhVar.ydsyayx = textViewOqexvyb3;
        nmpwovhVar.ysaclsr = textViewOqexvyb4;
        nmpwovhVar.hknanqb = textViewDasxvpc;
        nmpwovhVar.kpmmknm = textViewDasxvpc2;
        nmpwovhVar.kffvigz = textViewDasxvpc3;
        nmpwovhVar.yjvhftf = textViewBpqosqe;
        nmpwovhVar.yxcmoyp = textViewOxoagud11;
        nmpwovhVar.tnejqcj = textViewBpqosqe2;
        nmpwovhVar.mdepcqh = textViewLclupha5;
        nmpwovhVar.xqbcyis = textViewOxoagud13;
        nmpwovhVar.zzqmpyp = textViewBpqosqe3;
        nmpwovhVar.nuoqzvr = textViewLclupha6;
        nmpwovhVar.eqqqfvj = textViewOxoagud16;
        nmpwovhVar.ftrcqfq = textViewLclupha7;
        nmpwovhVar.udgizdi = textViewLclupha8;
        nmpwovhVar.saksmfq = textViewOxoagud18;
        nmpwovhVar.lvtqoqa = frameLayout3;
        final gepzcpd gepzcpdVar2 = new gepzcpd(nmpwovhVar);
        ScrollView scrollView3 = new ScrollView(nmpwovhVar);
        scrollView3.setFillViewport(true);
        scrollView3.setBackgroundColor(zamkzqg.buswjhz(nmpwovhVar));
        LinearLayout linearLayoutXbdyiew4 = zamkzqg.xbdyiew(nmpwovhVar, 16);
        scrollView3.addView(linearLayoutXbdyiew4);
        linearLayoutXbdyiew4.addView(zamkzqg.ywhgqsi(nmpwovhVar, nmpwovhVar.getString(R.string.menu_title)));
        final int i14 = 0;
        TextView textViewOxoagud19 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.menu_subtitle), 12, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud19.setPadding(0, 0, 0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.menu_header_bottom_gap));
        linearLayoutXbdyiew4.addView(textViewOxoagud19);
        final int i15 = 1;
        linearLayoutXbdyiew4.addView(zamkzqg.eigllth(nmpwovhVar, R.string.menu_flash_tool, R.string.menu_flash_tool_desc, R.drawable.ic_flash, new View.OnClickListener() { // from class: x.axbavsj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i14) {
                    case 0:
                        gepzcpdVar2.nmpwovh.gzokllk();
                        return;
                    case 1:
                        gepzcpdVar2.nmpwovh.nhhacgu("xiaomi_authorize");
                        return;
                    case 2:
                        gepzcpdVar2.nmpwovh.nhhacgu("parts");
                        return;
                    case 3:
                        final MainActivity mainActivity2 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity2.getClass();
                        final wjugzfh wjugzfhVar = new wjugzfh(mainActivity2);
                        ScrollView scrollView4 = new ScrollView(mainActivity2);
                        scrollView4.setFillViewport(true);
                        scrollView4.setBackgroundColor(zamkzqg.buswjhz(mainActivity2));
                        LinearLayout linearLayoutXbdyiew5 = zamkzqg.xbdyiew(mainActivity2, 16);
                        scrollView4.addView(linearLayoutXbdyiew5);
                        int iNmpwovh2 = zamkzqg.nmpwovh(mainActivity2);
                        final int i16 = 0;
                        TextView textViewLclupha9 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_back), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i16) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha9, R.drawable.ic_back, iNmpwovh2);
                        textViewLclupha9.setGravity(8388627);
                        linearLayoutXbdyiew5.addView(textViewLclupha9);
                        TextView textViewYwhgqsi = zamkzqg.ywhgqsi(mainActivity2, mainActivity2.getString(R.string.bootloader_page_title));
                        zamkzqg.enxkjpu(mainActivity2, textViewYwhgqsi, R.drawable.ic_device_info, zamkzqg.nmpwovh(mainActivity2));
                        linearLayoutXbdyiew5.addView(textViewYwhgqsi);
                        linearLayoutXbdyiew5.addView(zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_page_subtitle), 12, zamkzqg.jbmzxye(mainActivity2), false));
                        LinearLayout linearLayoutLvtqoqa9 = zamkzqg.lvtqoqa(mainActivity2);
                        linearLayoutLvtqoqa9.setGravity(17);
                        linearLayoutLvtqoqa9.setPadding(zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4));
                        linearLayoutLvtqoqa9.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity2, 12)));
                        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity2, 48));
                        layoutParams23.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        final TextView textViewMslkofp = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_status);
                        final TextView textViewMslkofp2 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_slot);
                        final TextView textViewMslkofp3 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_security);
                        LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs = zamkzqg.qunltjs(mainActivity2, 2);
                        layoutParams24.setMargins(iQunltjs, 0, iQunltjs, 0);
                        linearLayoutLvtqoqa9.addView(textViewMslkofp, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp2, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp3, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutXbdyiew5.addView(linearLayoutLvtqoqa9, layoutParams23);
                        final LinearLayout linearLayoutXbdyiew6 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew7 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew8 = zamkzqg.xbdyiew(mainActivity2, 0);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew6);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew7);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew8);
                        final int i17 = 0;
                        textViewMslkofp.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i17) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i18 = 1;
                        textViewMslkofp2.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i18) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i19 = 2;
                        textViewMslkofp3.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i19) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                        LinearLayout linearLayoutZwaqeaz7 = zamkzqg.zwaqeaz(mainActivity2);
                        TextView textViewOxoagud20 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_reading), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud20, R.drawable.ic_refresh, zamkzqg.ohwxijw(mainActivity2));
                        linearLayoutZwaqeaz7.addView(textViewOxoagud20);
                        TextView textViewDkpobjg = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg2 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg3 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg4 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg5 = zamkzqg.dkpobjg(mainActivity2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_offset, textViewDkpobjg);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_slot_count, textViewDkpobjg2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_active, textViewDkpobjg3);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_suffix, textViewDkpobjg4);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_crc, textViewDkpobjg5);
                        linearLayoutXbdyiew6.addView(linearLayoutZwaqeaz7, zamkzqg.uiqyzsp(mainActivity2));
                        int iNmpwovh3 = zamkzqg.nmpwovh(mainActivity2);
                        final int i20 = 1;
                        TextView textViewLclupha10 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_refresh), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i20) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha10, R.drawable.ic_refresh, iNmpwovh3);
                        linearLayoutXbdyiew6.addView(textViewLclupha10, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        TextView textViewOxoagud21 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_slot_intro), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams25.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        linearLayoutXbdyiew7.addView(textViewOxoagud21, layoutParams25);
                        iilntfn iilntfnVarDplrlfq = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "A", wjugzfhVar);
                        iilntfn iilntfnVarDplrlfq2 = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "B", wjugzfhVar);
                        LinearLayout linearLayout5 = new LinearLayout(mainActivity2);
                        linearLayout5.setOrientation(1);
                        int dimensionPixelSize2 = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_padding);
                        linearLayout5.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
                        linearLayout5.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), zamkzqg.ohwxijw(mainActivity2), mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_radius)));
                        TextView textViewOxoagud22 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_warning), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud22, R.drawable.ic_warning, zamkzqg.ohwxijw(mainActivity2));
                        linearLayout5.addView(textViewOxoagud22);
                        TextView textViewOxoagud23 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_detail), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        textViewOxoagud23.setPadding(0, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top), 0, 0);
                        linearLayout5.addView(textViewOxoagud23);
                        linearLayoutXbdyiew8.addView(linearLayout5, zamkzqg.uiqyzsp(mainActivity2));
                        int iKggugdp2 = zamkzqg.kggugdp(mainActivity2);
                        final int i21 = 2;
                        TextView textViewLclupha11 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_unlock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i21) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha11, R.drawable.ic_unlock, iKggugdp2);
                        textViewLclupha11.setTextColor(zamkzqg.kggugdp(mainActivity2));
                        textViewLclupha11.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.ojyssqt(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_button_radius)));
                        linearLayoutXbdyiew8.addView(textViewLclupha11, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        int iOhwxijw = zamkzqg.ohwxijw(mainActivity2);
                        final int i22 = 3;
                        TextView textViewLclupha12 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_lock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i22) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha12, R.drawable.ic_lock, iOhwxijw);
                        LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                        layoutParams26.topMargin = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_page_action_gap);
                        linearLayoutXbdyiew8.addView(textViewLclupha12, layoutParams26);
                        linearLayoutXbdyiew5.addView(new View(mainActivity2), new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        iilntfn iilntfnVar = new iilntfn(scrollView4, mainActivity2, textViewOxoagud20, textViewDkpobjg, textViewDkpobjg2, textViewDkpobjg3, textViewDkpobjg4, textViewDkpobjg5, iilntfnVarDplrlfq, iilntfnVarDplrlfq2);
                        iilntfnVar.vivhedu();
                        mainActivity2.pmsrvoc = iilntfnVar;
                        mainActivity2.kffvigz(scrollView4, "bootloader_manager");
                        if (mainActivity2.nsyqsfj) {
                            mainActivity2.odhctch();
                            return;
                        } else {
                            mainActivity2.rrpfqyy = "";
                            mainActivity2.pmsrvoc.lthborb(mainActivity2.getString(mainActivity2.gzokllk ? R.string.error_da_connecting : R.string.error_wait_da_ready));
                            return;
                        }
                    case 4:
                        final MainActivity mainActivity3 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity3.getClass();
                        final wjugzfh wjugzfhVar2 = new wjugzfh(mainActivity3);
                        ScrollView scrollView5 = new ScrollView(mainActivity3);
                        scrollView5.setFillViewport(true);
                        scrollView5.setBackgroundColor(zamkzqg.buswjhz(mainActivity3));
                        LinearLayout linearLayoutXbdyiew9 = zamkzqg.xbdyiew(mainActivity3, 16);
                        scrollView5.addView(linearLayoutXbdyiew9);
                        int iNmpwovh4 = zamkzqg.nmpwovh(mainActivity3);
                        final int i23 = 0;
                        TextView textViewLclupha13 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_back), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i23) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha13, R.drawable.ic_back, iNmpwovh4);
                        textViewLclupha13.setGravity(8388627);
                        linearLayoutXbdyiew9.addView(textViewLclupha13);
                        TextView textViewYwhgqsi2 = zamkzqg.ywhgqsi(mainActivity3, mainActivity3.getString(R.string.android_tools_title));
                        zamkzqg.enxkjpu(mainActivity3, textViewYwhgqsi2, R.drawable.ic_usb, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutXbdyiew9.addView(textViewYwhgqsi2);
                        linearLayoutXbdyiew9.addView(zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_subtitle), 12, zamkzqg.jbmzxye(mainActivity3), false));
                        LinearLayout linearLayoutLvtqoqa10 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa10.setGravity(17);
                        linearLayoutLvtqoqa10.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4));
                        linearLayoutLvtqoqa10.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), mainActivity3.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity3, 12)));
                        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity3, 48));
                        layoutParams27.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        final TextView textViewOxoagud24 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_device), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud24.setGravity(17);
                        textViewOxoagud24.setClickable(true);
                        textViewOxoagud24.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud24);
                        TextView textViewOxoagud25 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_terminal), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud25.setGravity(17);
                        textViewOxoagud25.setClickable(true);
                        textViewOxoagud25.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud25);
                        LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs2 = zamkzqg.qunltjs(mainActivity3, 2);
                        layoutParams28.setMargins(iQunltjs2, 0, iQunltjs2, 0);
                        linearLayoutLvtqoqa10.addView(textViewOxoagud24, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutLvtqoqa10.addView(textViewOxoagud25, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutXbdyiew9.addView(linearLayoutLvtqoqa10, layoutParams27);
                        final LinearLayout linearLayoutXbdyiew10 = zamkzqg.xbdyiew(mainActivity3, 0);
                        final LinearLayout linearLayoutXbdyiew11 = zamkzqg.xbdyiew(mainActivity3, 0);
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew10, new LinearLayout.LayoutParams(-1, -2));
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew11, new LinearLayout.LayoutParams(-1, -2));
                        textViewOxoagud24.setOnClickListener(new bwvplah(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, 0));
                        zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, false);
                        LinearLayout linearLayoutZwaqeaz8 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz8.setOrientation(1);
                        TextView textViewOxoagud26 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_scanning), 13, zamkzqg.ohwxijw(mainActivity3), true);
                        zamkzqg.enxkjpu(mainActivity3, textViewOxoagud26, R.drawable.ic_usb, zamkzqg.ohwxijw(mainActivity3));
                        linearLayoutZwaqeaz8.addView(textViewOxoagud26);
                        TextView textViewHjlrtqw = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw2 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_transport, textViewHjlrtqw);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_usb_id, textViewHjlrtqw2);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz8, zamkzqg.uiqyzsp(mainActivity3));
                        int iNmpwovh5 = zamkzqg.nmpwovh(mainActivity3);
                        final int i24 = 9;
                        TextView textViewLclupha14 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_refresh), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i24) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha14, R.drawable.ic_refresh, iNmpwovh5);
                        linearLayoutXbdyiew10.addView(textViewLclupha14, new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        LinearLayout linearLayoutZwaqeaz9 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz9.setOrientation(1);
                        TextView textViewYsaclsr = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_terminal_title);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz9.addView(textViewYsaclsr);
                        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(mainActivity3);
                        horizontalScrollView.setHorizontalScrollBarEnabled(false);
                        horizontalScrollView.setFillViewport(false);
                        LinearLayout linearLayoutLvtqoqa11 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa11.setPadding(0, zamkzqg.qunltjs(mainActivity3, 10), 0, zamkzqg.qunltjs(mainActivity3, 10));
                        String[][] strArr = {new String[]{"adb devices", "adb devices"}, new String[]{"adb shell", "adb shell"}, new String[]{"getprop", "adb shell getprop"}, new String[]{"fastboot devices", "fastboot devices"}, new String[]{"getvar product", "fastboot getvar product"}};
                        int i25 = 0;
                        while (i25 < 5) {
                            String[] strArr2 = strArr[i25];
                            String str = strArr2[0];
                            String str2 = strArr2[1];
                            String[][] strArr3 = strArr;
                            TextView textViewOxoagud27 = zamkzqg.oxoagud(mainActivity3, str, 11, zamkzqg.zngzleo(mainActivity3), true);
                            textViewOxoagud27.setGravity(17);
                            textViewOxoagud27.setSingleLine(true);
                            textViewOxoagud27.setPadding(zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8));
                            textViewOxoagud27.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 18)));
                            textViewOxoagud27.setClickable(true);
                            textViewOxoagud27.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textViewOxoagud27);
                            textViewOxoagud27.setOnClickListener(new pzqxblc(wjugzfhVar2, str2, 0));
                            LinearLayout.LayoutParams layoutParams29 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams29.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 7));
                            linearLayoutLvtqoqa11.addView(textViewOxoagud27, layoutParams29);
                            i25++;
                            strArr = strArr3;
                            textViewHjlrtqw = textViewHjlrtqw;
                        }
                        TextView textView = textViewHjlrtqw;
                        horizontalScrollView.addView(linearLayoutLvtqoqa11, new FrameLayout.LayoutParams(-2, -2));
                        linearLayoutZwaqeaz9.addView(horizontalScrollView);
                        int iRgb = Color.rgb(30, 37, 40);
                        int iRgb2 = Color.rgb(232, 236, 233);
                        int iRgb3 = Color.rgb(72, 112, 76);
                        ScrollView scrollView6 = new ScrollView(mainActivity3);
                        scrollView6.setFillViewport(true);
                        scrollView6.setVerticalScrollBarEnabled(true);
                        scrollView6.setScrollbarFadingEnabled(true);
                        scrollView6.setBackground(zamkzqg.jvtqflj(mainActivity3, iRgb, iRgb3, zamkzqg.qunltjs(mainActivity3, 12)));
                        TextView textViewOxoagud28 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_terminal_banner), 12, iRgb2, false);
                        textViewOxoagud28.setTextColor(iRgb2);
                        Typeface typeface = Typeface.MONOSPACE;
                        textViewOxoagud28.setTypeface(typeface);
                        textViewOxoagud28.setTextIsSelectable(true);
                        textViewOxoagud28.setGravity(8388659);
                        textViewOxoagud28.setLineSpacing(0.0f, 1.08f);
                        textViewOxoagud28.setPadding(zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12));
                        scrollView6.addView(textViewOxoagud28, new FrameLayout.LayoutParams(-1, -2));
                        linearLayoutZwaqeaz9.addView(scrollView6, new LinearLayout.LayoutParams(-1, Math.max(zamkzqg.qunltjs(mainActivity3, 310), Math.min(zamkzqg.qunltjs(mainActivity3, 440), Math.round(mainActivity3.getResources().getDisplayMetrics().heightPixels * 0.43f)))));
                        LinearLayout linearLayoutLvtqoqa12 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa12.setGravity(16);
                        linearLayoutLvtqoqa12.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 2), zamkzqg.qunltjs(mainActivity3, 5), zamkzqg.qunltjs(mainActivity3, 2));
                        linearLayoutLvtqoqa12.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.czidoiw(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 10)));
                        LinearLayout.LayoutParams layoutParams30 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams30.topMargin = zamkzqg.qunltjs(mainActivity3, 9);
                        final EditText editText = new EditText(mainActivity3);
                        editText.setSingleLine(true);
                        editText.setInputType(524289);
                        editText.setTextColor(zamkzqg.zngzleo(mainActivity3));
                        editText.setHintTextColor(zamkzqg.jbmzxye(mainActivity3));
                        editText.setTypeface(typeface);
                        editText.setTextSize(13.0f);
                        editText.setHint(R.string.android_tools_terminal_hint_compact);
                        editText.setImeOptions(4);
                        editText.setBackgroundColor(mainActivity3.getColor(R.color.rynx_transparent));
                        editText.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8));
                        linearLayoutLvtqoqa12.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
                        TextView textViewOxoagud29 = zamkzqg.oxoagud(mainActivity3, "CTRL+C", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud29.setGravity(17);
                        textViewOxoagud29.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud29.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud29.setEnabled(false);
                        textViewOxoagud29.setAlpha(0.35f);
                        textViewOxoagud29.setClickable(true);
                        textViewOxoagud29.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud29);
                        final int i26 = 1;
                        textViewOxoagud29.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i26) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        TextView textViewOxoagud30 = zamkzqg.oxoagud(mainActivity3, "FILE", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud30.setGravity(17);
                        textViewOxoagud30.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud30.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud30.setClickable(true);
                        textViewOxoagud30.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud30);
                        final int i27 = 2;
                        textViewOxoagud30.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i27) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        LinearLayout.LayoutParams layoutParams31 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams31.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 6));
                        linearLayoutLvtqoqa12.addView(textViewOxoagud30, layoutParams31);
                        linearLayoutLvtqoqa12.addView(textViewOxoagud29);
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa12, layoutParams30);
                        LinearLayout linearLayoutLvtqoqa13 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa13.setGravity(17);
                        TextView textViewOxoagud31 = zamkzqg.oxoagud(mainActivity3, "↑ PREV", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud32 = zamkzqg.oxoagud(mainActivity3, "↓ NEXT", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud33 = zamkzqg.oxoagud(mainActivity3, "TAB", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        TextView[] textViewArr = {textViewOxoagud31, textViewOxoagud32, textViewOxoagud33};
                        int i28 = 0;
                        while (i28 < 3) {
                            TextView textView2 = textViewArr[i28];
                            textView2.setGravity(17);
                            textView2.setPadding(zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 6));
                            textView2.setClickable(true);
                            textView2.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textView2);
                            linearLayoutLvtqoqa13.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
                            i28++;
                            textViewOxoagud25 = textViewOxoagud25;
                            textViewArr = textViewArr;
                            textViewOxoagud29 = textViewOxoagud29;
                            scrollView6 = scrollView6;
                        }
                        TextView textView3 = textViewOxoagud29;
                        final TextView textView4 = textViewOxoagud25;
                        final ScrollView scrollView7 = scrollView6;
                        final int i29 = 0;
                        textViewOxoagud31.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i29) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        final int i30 = 1;
                        textViewOxoagud32.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i30) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        textViewOxoagud33.setOnClickListener(new nmpwovh(editText, 2));
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa13);
                        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: x.qunltjs
                            @Override // android.widget.TextView.OnEditorActionListener
                            public final boolean onEditorAction(TextView textView5, int i31, KeyEvent keyEvent) {
                                if (i31 != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
                                    return false;
                                }
                                EditText editText2 = editText;
                                String strTrim = editText2.getText() == null ? "" : editText2.getText().toString().trim();
                                if (!strTrim.isEmpty()) {
                                    editText2.setText("");
                                    wjugzfhVar2.vivhedu(strTrim);
                                }
                                return true;
                            }
                        });
                        editText.setOnKeyListener(new View.OnKeyListener() { // from class: x.cgcdpmq
                            @Override // android.view.View.OnKeyListener
                            public final boolean onKey(View view9, int i31, KeyEvent keyEvent) {
                                if (keyEvent.getAction() != 0) {
                                    return false;
                                }
                                wjugzfh wjugzfhVar3 = wjugzfhVar2;
                                EditText editText2 = editText;
                                if (i31 == 19) {
                                    String strOjyssqt = wjugzfhVar3.ojyssqt();
                                    if (strOjyssqt != null) {
                                        editText2.setText(strOjyssqt);
                                        editText2.setSelection(strOjyssqt.length());
                                    }
                                } else if (i31 == 20) {
                                    String strNmpwovh = wjugzfhVar3.nmpwovh();
                                    if (strNmpwovh != null) {
                                        editText2.setText(strNmpwovh);
                                        editText2.setSelection(strNmpwovh.length());
                                    }
                                } else {
                                    if (i31 != 61) {
                                        return false;
                                    }
                                    zamkzqg.qwgjehf(editText2);
                                }
                                return true;
                            }
                        });
                        textView4.setOnClickListener(new View.OnClickListener() { // from class: x.exhiehf
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textView4, linearLayoutXbdyiew10, linearLayoutXbdyiew11, true);
                                ScrollView scrollView8 = scrollView7;
                                scrollView8.post(new eigllth(scrollView8, 0));
                            }
                        });
                        LinearLayout.LayoutParams layoutParamsUiqyzsp = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew11.addView(linearLayoutZwaqeaz9, layoutParamsUiqyzsp);
                        LinearLayout linearLayoutZwaqeaz10 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz10.setOrientation(1);
                        TextView textViewYsaclsr2 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_device);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr2, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr2);
                        TextView textViewOxoagud34 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_note), 11, zamkzqg.jbmzxye(mainActivity3), false);
                        textViewOxoagud34.setPadding(0, zamkzqg.qunltjs(mainActivity3, 4), 0, zamkzqg.qunltjs(mainActivity3, 5));
                        linearLayoutZwaqeaz10.addView(textViewOxoagud34);
                        TextView textViewHjlrtqw3 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw4 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw5 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw6 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw7 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw8 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_state, textViewHjlrtqw3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_model, textViewHjlrtqw4);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_product, textViewHjlrtqw5);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_android, textViewHjlrtqw6);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_sdk, textViewHjlrtqw7);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_serial, textViewHjlrtqw8);
                        TextView textViewYsaclsr3 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_actions);
                        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams32.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr3, layoutParams32);
                        final int i31 = 3;
                        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i31) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh6 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha15 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha15, R.drawable.ic_reboot, iNmpwovh6);
                        final int i32 = 4;
                        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i32) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh7 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha16 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_reboot_recovery), onClickListener2);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha16, R.drawable.ic_reboot, iNmpwovh7);
                        final int i33 = 5;
                        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i33) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh8 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha17 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener3);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha17, R.drawable.ic_unlock, iNmpwovh8);
                        TextView[] textViewArr2 = {textViewLclupha15, textViewLclupha16, textViewLclupha17};
                        int i34 = 0;
                        for (int i35 = 3; i34 < i35; i35 = 3) {
                            TextView textView5 = textViewArr2[i34];
                            LinearLayout.LayoutParams layoutParams33 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams33.topMargin = zamkzqg.qunltjs(mainActivity3, 7);
                            linearLayoutZwaqeaz10.addView(textView5, layoutParams33);
                            i34++;
                        }
                        LinearLayout.LayoutParams layoutParamsUiqyzsp2 = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp2.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz10, layoutParamsUiqyzsp2);
                        linearLayoutZwaqeaz10.setVisibility(8);
                        LinearLayout linearLayoutZwaqeaz11 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz11.setOrientation(1);
                        linearLayoutZwaqeaz11.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_device_info));
                        TextView textViewHjlrtqw9 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw10 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw11 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw12 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw13 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_product, textViewHjlrtqw9);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_serial, textViewHjlrtqw10);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_current_slot, textViewHjlrtqw11);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_unlocked, textViewHjlrtqw12);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_bootloader_version, textViewHjlrtqw13);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz11, zamkzqg.uiqyzsp(mainActivity3));
                        linearLayoutZwaqeaz11.setVisibility(8);
                        LinearLayout linearLayout6 = new LinearLayout(mainActivity3);
                        linearLayout6.setOrientation(1);
                        linearLayout6.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_fastboot_actions));
                        final int i36 = 6;
                        View.OnClickListener onClickListener4 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i36) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh9 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha18 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener4);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha18, R.drawable.ic_reboot, iNmpwovh9);
                        final int i37 = 7;
                        View.OnClickListener onClickListener5 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i37) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh10 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha19 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener5);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha19, R.drawable.ic_unlock, iNmpwovh10);
                        final int i38 = 8;
                        View.OnClickListener onClickListener6 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i38) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh11 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha20 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_fastbootd), onClickListener6);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha20, R.drawable.ic_partitions, iNmpwovh11);
                        TextView[] textViewArr3 = {textViewLclupha18, textViewLclupha19, textViewLclupha20};
                        int i39 = 0;
                        while (i39 < 3) {
                            TextView textView6 = textViewArr3[i39];
                            LinearLayout.LayoutParams layoutParams34 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams34.topMargin = zamkzqg.qunltjs(mainActivity3, 8);
                            linearLayout6.addView(textView6, layoutParams34);
                            i39++;
                            textViewArr3 = textViewArr3;
                        }
                        LinearLayout.LayoutParams layoutParams35 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams35.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayout6, layoutParams35);
                        linearLayout6.setVisibility(8);
                        linearLayoutXbdyiew10.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        linearLayoutXbdyiew11.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        mainActivity3.ltnesel = new jybecxv(scrollView5, textView, textViewHjlrtqw2, textViewOxoagud26, editText, textViewOxoagud28, scrollView7, textView3, linearLayoutZwaqeaz10, textViewHjlrtqw3, textViewHjlrtqw4, textViewHjlrtqw5, textViewHjlrtqw6, textViewHjlrtqw7, textViewHjlrtqw8, textViewHjlrtqw9, textViewHjlrtqw10, textViewHjlrtqw11, textViewHjlrtqw12, textViewHjlrtqw13, linearLayoutZwaqeaz11, linearLayout6);
                        ccuulnt ccuulntVar = mainActivity3.suqlntg;
                        String string2 = mainActivity3.getString(R.string.android_tools_terminal_banner);
                        synchronized (ccuulntVar) {
                            try {
                                if (ccuulntVar.nmpwovh.length() == 0 && string2 != null && !string2.isEmpty()) {
                                    ccuulntVar.nmpwovh.append(string2.replace("\r\n", "\n").replace('\r', '\n'));
                                    ccuulntVar.ojyssqt();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        ccuulnt ccuulntVar2 = mainActivity3.suqlntg;
                        ccuulntVar2.qxvquar = true;
                        ccuulntVar2.nmpwovh(true);
                        mainActivity3.suqlntg.nmpwovh(true);
                        mainActivity3.gdkopre();
                        mainActivity3.kffvigz(scrollView5, "android_tools");
                        mainActivity3.jzcfpou();
                        return;
                    default:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar2.nmpwovh;
                        if (mainActivity4.lpkdqgx || mainActivity4.gzokllk) {
                            Toast.makeText(mainActivity4, R.string.error_busy, 0).show();
                            return;
                        } else {
                            new AlertDialog.Builder(mainActivity4).setTitle(R.string.power_menu_title).setItems(new String[]{mainActivity4.getString(R.string.power_normal_reboot), mainActivity4.getString(R.string.power_shutdown)}, new nsyqsfj(mainActivity4, 1)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
                            return;
                        }
                }
            }
        }), zamkzqg.exhiehf(nmpwovhVar, true));
        linearLayoutXbdyiew4.addView(zamkzqg.eigllth(nmpwovhVar, R.string.menu_xiaomi_authorize, R.string.menu_xiaomi_authorize_desc, R.drawable.ic_lock, new View.OnClickListener() { // from class: x.axbavsj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i15) {
                    case 0:
                        gepzcpdVar2.nmpwovh.gzokllk();
                        return;
                    case 1:
                        gepzcpdVar2.nmpwovh.nhhacgu("xiaomi_authorize");
                        return;
                    case 2:
                        gepzcpdVar2.nmpwovh.nhhacgu("parts");
                        return;
                    case 3:
                        final MainActivity mainActivity2 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity2.getClass();
                        final wjugzfh wjugzfhVar = new wjugzfh(mainActivity2);
                        ScrollView scrollView4 = new ScrollView(mainActivity2);
                        scrollView4.setFillViewport(true);
                        scrollView4.setBackgroundColor(zamkzqg.buswjhz(mainActivity2));
                        LinearLayout linearLayoutXbdyiew5 = zamkzqg.xbdyiew(mainActivity2, 16);
                        scrollView4.addView(linearLayoutXbdyiew5);
                        int iNmpwovh2 = zamkzqg.nmpwovh(mainActivity2);
                        final int i16 = 0;
                        TextView textViewLclupha9 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_back), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i16) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha9, R.drawable.ic_back, iNmpwovh2);
                        textViewLclupha9.setGravity(8388627);
                        linearLayoutXbdyiew5.addView(textViewLclupha9);
                        TextView textViewYwhgqsi = zamkzqg.ywhgqsi(mainActivity2, mainActivity2.getString(R.string.bootloader_page_title));
                        zamkzqg.enxkjpu(mainActivity2, textViewYwhgqsi, R.drawable.ic_device_info, zamkzqg.nmpwovh(mainActivity2));
                        linearLayoutXbdyiew5.addView(textViewYwhgqsi);
                        linearLayoutXbdyiew5.addView(zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_page_subtitle), 12, zamkzqg.jbmzxye(mainActivity2), false));
                        LinearLayout linearLayoutLvtqoqa9 = zamkzqg.lvtqoqa(mainActivity2);
                        linearLayoutLvtqoqa9.setGravity(17);
                        linearLayoutLvtqoqa9.setPadding(zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4));
                        linearLayoutLvtqoqa9.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity2, 12)));
                        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity2, 48));
                        layoutParams23.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        final TextView textViewMslkofp = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_status);
                        final TextView textViewMslkofp2 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_slot);
                        final TextView textViewMslkofp3 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_security);
                        LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs = zamkzqg.qunltjs(mainActivity2, 2);
                        layoutParams24.setMargins(iQunltjs, 0, iQunltjs, 0);
                        linearLayoutLvtqoqa9.addView(textViewMslkofp, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp2, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp3, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutXbdyiew5.addView(linearLayoutLvtqoqa9, layoutParams23);
                        final LinearLayout linearLayoutXbdyiew6 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew7 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew8 = zamkzqg.xbdyiew(mainActivity2, 0);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew6);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew7);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew8);
                        final int i17 = 0;
                        textViewMslkofp.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i17) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i18 = 1;
                        textViewMslkofp2.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i18) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i19 = 2;
                        textViewMslkofp3.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i19) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                        LinearLayout linearLayoutZwaqeaz7 = zamkzqg.zwaqeaz(mainActivity2);
                        TextView textViewOxoagud20 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_reading), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud20, R.drawable.ic_refresh, zamkzqg.ohwxijw(mainActivity2));
                        linearLayoutZwaqeaz7.addView(textViewOxoagud20);
                        TextView textViewDkpobjg = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg2 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg3 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg4 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg5 = zamkzqg.dkpobjg(mainActivity2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_offset, textViewDkpobjg);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_slot_count, textViewDkpobjg2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_active, textViewDkpobjg3);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_suffix, textViewDkpobjg4);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_crc, textViewDkpobjg5);
                        linearLayoutXbdyiew6.addView(linearLayoutZwaqeaz7, zamkzqg.uiqyzsp(mainActivity2));
                        int iNmpwovh3 = zamkzqg.nmpwovh(mainActivity2);
                        final int i20 = 1;
                        TextView textViewLclupha10 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_refresh), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i20) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha10, R.drawable.ic_refresh, iNmpwovh3);
                        linearLayoutXbdyiew6.addView(textViewLclupha10, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        TextView textViewOxoagud21 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_slot_intro), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams25.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        linearLayoutXbdyiew7.addView(textViewOxoagud21, layoutParams25);
                        iilntfn iilntfnVarDplrlfq = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "A", wjugzfhVar);
                        iilntfn iilntfnVarDplrlfq2 = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "B", wjugzfhVar);
                        LinearLayout linearLayout5 = new LinearLayout(mainActivity2);
                        linearLayout5.setOrientation(1);
                        int dimensionPixelSize2 = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_padding);
                        linearLayout5.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
                        linearLayout5.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), zamkzqg.ohwxijw(mainActivity2), mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_radius)));
                        TextView textViewOxoagud22 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_warning), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud22, R.drawable.ic_warning, zamkzqg.ohwxijw(mainActivity2));
                        linearLayout5.addView(textViewOxoagud22);
                        TextView textViewOxoagud23 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_detail), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        textViewOxoagud23.setPadding(0, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top), 0, 0);
                        linearLayout5.addView(textViewOxoagud23);
                        linearLayoutXbdyiew8.addView(linearLayout5, zamkzqg.uiqyzsp(mainActivity2));
                        int iKggugdp2 = zamkzqg.kggugdp(mainActivity2);
                        final int i21 = 2;
                        TextView textViewLclupha11 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_unlock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i21) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha11, R.drawable.ic_unlock, iKggugdp2);
                        textViewLclupha11.setTextColor(zamkzqg.kggugdp(mainActivity2));
                        textViewLclupha11.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.ojyssqt(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_button_radius)));
                        linearLayoutXbdyiew8.addView(textViewLclupha11, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        int iOhwxijw = zamkzqg.ohwxijw(mainActivity2);
                        final int i22 = 3;
                        TextView textViewLclupha12 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_lock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i22) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha12, R.drawable.ic_lock, iOhwxijw);
                        LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                        layoutParams26.topMargin = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_page_action_gap);
                        linearLayoutXbdyiew8.addView(textViewLclupha12, layoutParams26);
                        linearLayoutXbdyiew5.addView(new View(mainActivity2), new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        iilntfn iilntfnVar = new iilntfn(scrollView4, mainActivity2, textViewOxoagud20, textViewDkpobjg, textViewDkpobjg2, textViewDkpobjg3, textViewDkpobjg4, textViewDkpobjg5, iilntfnVarDplrlfq, iilntfnVarDplrlfq2);
                        iilntfnVar.vivhedu();
                        mainActivity2.pmsrvoc = iilntfnVar;
                        mainActivity2.kffvigz(scrollView4, "bootloader_manager");
                        if (mainActivity2.nsyqsfj) {
                            mainActivity2.odhctch();
                            return;
                        } else {
                            mainActivity2.rrpfqyy = "";
                            mainActivity2.pmsrvoc.lthborb(mainActivity2.getString(mainActivity2.gzokllk ? R.string.error_da_connecting : R.string.error_wait_da_ready));
                            return;
                        }
                    case 4:
                        final MainActivity mainActivity3 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity3.getClass();
                        final wjugzfh wjugzfhVar2 = new wjugzfh(mainActivity3);
                        ScrollView scrollView5 = new ScrollView(mainActivity3);
                        scrollView5.setFillViewport(true);
                        scrollView5.setBackgroundColor(zamkzqg.buswjhz(mainActivity3));
                        LinearLayout linearLayoutXbdyiew9 = zamkzqg.xbdyiew(mainActivity3, 16);
                        scrollView5.addView(linearLayoutXbdyiew9);
                        int iNmpwovh4 = zamkzqg.nmpwovh(mainActivity3);
                        final int i23 = 0;
                        TextView textViewLclupha13 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_back), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i23) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha13, R.drawable.ic_back, iNmpwovh4);
                        textViewLclupha13.setGravity(8388627);
                        linearLayoutXbdyiew9.addView(textViewLclupha13);
                        TextView textViewYwhgqsi2 = zamkzqg.ywhgqsi(mainActivity3, mainActivity3.getString(R.string.android_tools_title));
                        zamkzqg.enxkjpu(mainActivity3, textViewYwhgqsi2, R.drawable.ic_usb, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutXbdyiew9.addView(textViewYwhgqsi2);
                        linearLayoutXbdyiew9.addView(zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_subtitle), 12, zamkzqg.jbmzxye(mainActivity3), false));
                        LinearLayout linearLayoutLvtqoqa10 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa10.setGravity(17);
                        linearLayoutLvtqoqa10.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4));
                        linearLayoutLvtqoqa10.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), mainActivity3.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity3, 12)));
                        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity3, 48));
                        layoutParams27.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        final TextView textViewOxoagud24 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_device), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud24.setGravity(17);
                        textViewOxoagud24.setClickable(true);
                        textViewOxoagud24.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud24);
                        TextView textViewOxoagud25 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_terminal), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud25.setGravity(17);
                        textViewOxoagud25.setClickable(true);
                        textViewOxoagud25.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud25);
                        LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs2 = zamkzqg.qunltjs(mainActivity3, 2);
                        layoutParams28.setMargins(iQunltjs2, 0, iQunltjs2, 0);
                        linearLayoutLvtqoqa10.addView(textViewOxoagud24, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutLvtqoqa10.addView(textViewOxoagud25, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutXbdyiew9.addView(linearLayoutLvtqoqa10, layoutParams27);
                        final LinearLayout linearLayoutXbdyiew10 = zamkzqg.xbdyiew(mainActivity3, 0);
                        final LinearLayout linearLayoutXbdyiew11 = zamkzqg.xbdyiew(mainActivity3, 0);
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew10, new LinearLayout.LayoutParams(-1, -2));
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew11, new LinearLayout.LayoutParams(-1, -2));
                        textViewOxoagud24.setOnClickListener(new bwvplah(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, 0));
                        zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, false);
                        LinearLayout linearLayoutZwaqeaz8 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz8.setOrientation(1);
                        TextView textViewOxoagud26 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_scanning), 13, zamkzqg.ohwxijw(mainActivity3), true);
                        zamkzqg.enxkjpu(mainActivity3, textViewOxoagud26, R.drawable.ic_usb, zamkzqg.ohwxijw(mainActivity3));
                        linearLayoutZwaqeaz8.addView(textViewOxoagud26);
                        TextView textViewHjlrtqw = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw2 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_transport, textViewHjlrtqw);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_usb_id, textViewHjlrtqw2);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz8, zamkzqg.uiqyzsp(mainActivity3));
                        int iNmpwovh5 = zamkzqg.nmpwovh(mainActivity3);
                        final int i24 = 9;
                        TextView textViewLclupha14 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_refresh), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i24) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha14, R.drawable.ic_refresh, iNmpwovh5);
                        linearLayoutXbdyiew10.addView(textViewLclupha14, new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        LinearLayout linearLayoutZwaqeaz9 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz9.setOrientation(1);
                        TextView textViewYsaclsr = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_terminal_title);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz9.addView(textViewYsaclsr);
                        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(mainActivity3);
                        horizontalScrollView.setHorizontalScrollBarEnabled(false);
                        horizontalScrollView.setFillViewport(false);
                        LinearLayout linearLayoutLvtqoqa11 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa11.setPadding(0, zamkzqg.qunltjs(mainActivity3, 10), 0, zamkzqg.qunltjs(mainActivity3, 10));
                        String[][] strArr = {new String[]{"adb devices", "adb devices"}, new String[]{"adb shell", "adb shell"}, new String[]{"getprop", "adb shell getprop"}, new String[]{"fastboot devices", "fastboot devices"}, new String[]{"getvar product", "fastboot getvar product"}};
                        int i25 = 0;
                        while (i25 < 5) {
                            String[] strArr2 = strArr[i25];
                            String str = strArr2[0];
                            String str2 = strArr2[1];
                            String[][] strArr3 = strArr;
                            TextView textViewOxoagud27 = zamkzqg.oxoagud(mainActivity3, str, 11, zamkzqg.zngzleo(mainActivity3), true);
                            textViewOxoagud27.setGravity(17);
                            textViewOxoagud27.setSingleLine(true);
                            textViewOxoagud27.setPadding(zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8));
                            textViewOxoagud27.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 18)));
                            textViewOxoagud27.setClickable(true);
                            textViewOxoagud27.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textViewOxoagud27);
                            textViewOxoagud27.setOnClickListener(new pzqxblc(wjugzfhVar2, str2, 0));
                            LinearLayout.LayoutParams layoutParams29 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams29.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 7));
                            linearLayoutLvtqoqa11.addView(textViewOxoagud27, layoutParams29);
                            i25++;
                            strArr = strArr3;
                            textViewHjlrtqw = textViewHjlrtqw;
                        }
                        TextView textView = textViewHjlrtqw;
                        horizontalScrollView.addView(linearLayoutLvtqoqa11, new FrameLayout.LayoutParams(-2, -2));
                        linearLayoutZwaqeaz9.addView(horizontalScrollView);
                        int iRgb = Color.rgb(30, 37, 40);
                        int iRgb2 = Color.rgb(232, 236, 233);
                        int iRgb3 = Color.rgb(72, 112, 76);
                        ScrollView scrollView6 = new ScrollView(mainActivity3);
                        scrollView6.setFillViewport(true);
                        scrollView6.setVerticalScrollBarEnabled(true);
                        scrollView6.setScrollbarFadingEnabled(true);
                        scrollView6.setBackground(zamkzqg.jvtqflj(mainActivity3, iRgb, iRgb3, zamkzqg.qunltjs(mainActivity3, 12)));
                        TextView textViewOxoagud28 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_terminal_banner), 12, iRgb2, false);
                        textViewOxoagud28.setTextColor(iRgb2);
                        Typeface typeface = Typeface.MONOSPACE;
                        textViewOxoagud28.setTypeface(typeface);
                        textViewOxoagud28.setTextIsSelectable(true);
                        textViewOxoagud28.setGravity(8388659);
                        textViewOxoagud28.setLineSpacing(0.0f, 1.08f);
                        textViewOxoagud28.setPadding(zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12));
                        scrollView6.addView(textViewOxoagud28, new FrameLayout.LayoutParams(-1, -2));
                        linearLayoutZwaqeaz9.addView(scrollView6, new LinearLayout.LayoutParams(-1, Math.max(zamkzqg.qunltjs(mainActivity3, 310), Math.min(zamkzqg.qunltjs(mainActivity3, 440), Math.round(mainActivity3.getResources().getDisplayMetrics().heightPixels * 0.43f)))));
                        LinearLayout linearLayoutLvtqoqa12 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa12.setGravity(16);
                        linearLayoutLvtqoqa12.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 2), zamkzqg.qunltjs(mainActivity3, 5), zamkzqg.qunltjs(mainActivity3, 2));
                        linearLayoutLvtqoqa12.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.czidoiw(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 10)));
                        LinearLayout.LayoutParams layoutParams30 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams30.topMargin = zamkzqg.qunltjs(mainActivity3, 9);
                        final EditText editText = new EditText(mainActivity3);
                        editText.setSingleLine(true);
                        editText.setInputType(524289);
                        editText.setTextColor(zamkzqg.zngzleo(mainActivity3));
                        editText.setHintTextColor(zamkzqg.jbmzxye(mainActivity3));
                        editText.setTypeface(typeface);
                        editText.setTextSize(13.0f);
                        editText.setHint(R.string.android_tools_terminal_hint_compact);
                        editText.setImeOptions(4);
                        editText.setBackgroundColor(mainActivity3.getColor(R.color.rynx_transparent));
                        editText.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8));
                        linearLayoutLvtqoqa12.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
                        TextView textViewOxoagud29 = zamkzqg.oxoagud(mainActivity3, "CTRL+C", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud29.setGravity(17);
                        textViewOxoagud29.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud29.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud29.setEnabled(false);
                        textViewOxoagud29.setAlpha(0.35f);
                        textViewOxoagud29.setClickable(true);
                        textViewOxoagud29.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud29);
                        final int i26 = 1;
                        textViewOxoagud29.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i26) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        TextView textViewOxoagud30 = zamkzqg.oxoagud(mainActivity3, "FILE", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud30.setGravity(17);
                        textViewOxoagud30.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud30.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud30.setClickable(true);
                        textViewOxoagud30.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud30);
                        final int i27 = 2;
                        textViewOxoagud30.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i27) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        LinearLayout.LayoutParams layoutParams31 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams31.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 6));
                        linearLayoutLvtqoqa12.addView(textViewOxoagud30, layoutParams31);
                        linearLayoutLvtqoqa12.addView(textViewOxoagud29);
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa12, layoutParams30);
                        LinearLayout linearLayoutLvtqoqa13 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa13.setGravity(17);
                        TextView textViewOxoagud31 = zamkzqg.oxoagud(mainActivity3, "↑ PREV", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud32 = zamkzqg.oxoagud(mainActivity3, "↓ NEXT", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud33 = zamkzqg.oxoagud(mainActivity3, "TAB", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        TextView[] textViewArr = {textViewOxoagud31, textViewOxoagud32, textViewOxoagud33};
                        int i28 = 0;
                        while (i28 < 3) {
                            TextView textView2 = textViewArr[i28];
                            textView2.setGravity(17);
                            textView2.setPadding(zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 6));
                            textView2.setClickable(true);
                            textView2.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textView2);
                            linearLayoutLvtqoqa13.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
                            i28++;
                            textViewOxoagud25 = textViewOxoagud25;
                            textViewArr = textViewArr;
                            textViewOxoagud29 = textViewOxoagud29;
                            scrollView6 = scrollView6;
                        }
                        TextView textView3 = textViewOxoagud29;
                        final TextView textView4 = textViewOxoagud25;
                        final ScrollView scrollView7 = scrollView6;
                        final int i29 = 0;
                        textViewOxoagud31.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i29) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        final int i30 = 1;
                        textViewOxoagud32.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i30) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        textViewOxoagud33.setOnClickListener(new nmpwovh(editText, 2));
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa13);
                        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: x.qunltjs
                            @Override // android.widget.TextView.OnEditorActionListener
                            public final boolean onEditorAction(TextView textView5, int i31, KeyEvent keyEvent) {
                                if (i31 != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
                                    return false;
                                }
                                EditText editText2 = editText;
                                String strTrim = editText2.getText() == null ? "" : editText2.getText().toString().trim();
                                if (!strTrim.isEmpty()) {
                                    editText2.setText("");
                                    wjugzfhVar2.vivhedu(strTrim);
                                }
                                return true;
                            }
                        });
                        editText.setOnKeyListener(new View.OnKeyListener() { // from class: x.cgcdpmq
                            @Override // android.view.View.OnKeyListener
                            public final boolean onKey(View view9, int i31, KeyEvent keyEvent) {
                                if (keyEvent.getAction() != 0) {
                                    return false;
                                }
                                wjugzfh wjugzfhVar3 = wjugzfhVar2;
                                EditText editText2 = editText;
                                if (i31 == 19) {
                                    String strOjyssqt = wjugzfhVar3.ojyssqt();
                                    if (strOjyssqt != null) {
                                        editText2.setText(strOjyssqt);
                                        editText2.setSelection(strOjyssqt.length());
                                    }
                                } else if (i31 == 20) {
                                    String strNmpwovh = wjugzfhVar3.nmpwovh();
                                    if (strNmpwovh != null) {
                                        editText2.setText(strNmpwovh);
                                        editText2.setSelection(strNmpwovh.length());
                                    }
                                } else {
                                    if (i31 != 61) {
                                        return false;
                                    }
                                    zamkzqg.qwgjehf(editText2);
                                }
                                return true;
                            }
                        });
                        textView4.setOnClickListener(new View.OnClickListener() { // from class: x.exhiehf
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textView4, linearLayoutXbdyiew10, linearLayoutXbdyiew11, true);
                                ScrollView scrollView8 = scrollView7;
                                scrollView8.post(new eigllth(scrollView8, 0));
                            }
                        });
                        LinearLayout.LayoutParams layoutParamsUiqyzsp = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew11.addView(linearLayoutZwaqeaz9, layoutParamsUiqyzsp);
                        LinearLayout linearLayoutZwaqeaz10 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz10.setOrientation(1);
                        TextView textViewYsaclsr2 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_device);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr2, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr2);
                        TextView textViewOxoagud34 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_note), 11, zamkzqg.jbmzxye(mainActivity3), false);
                        textViewOxoagud34.setPadding(0, zamkzqg.qunltjs(mainActivity3, 4), 0, zamkzqg.qunltjs(mainActivity3, 5));
                        linearLayoutZwaqeaz10.addView(textViewOxoagud34);
                        TextView textViewHjlrtqw3 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw4 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw5 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw6 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw7 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw8 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_state, textViewHjlrtqw3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_model, textViewHjlrtqw4);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_product, textViewHjlrtqw5);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_android, textViewHjlrtqw6);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_sdk, textViewHjlrtqw7);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_serial, textViewHjlrtqw8);
                        TextView textViewYsaclsr3 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_actions);
                        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams32.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr3, layoutParams32);
                        final int i31 = 3;
                        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i31) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh6 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha15 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha15, R.drawable.ic_reboot, iNmpwovh6);
                        final int i32 = 4;
                        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i32) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh7 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha16 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_reboot_recovery), onClickListener2);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha16, R.drawable.ic_reboot, iNmpwovh7);
                        final int i33 = 5;
                        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i33) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh8 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha17 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener3);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha17, R.drawable.ic_unlock, iNmpwovh8);
                        TextView[] textViewArr2 = {textViewLclupha15, textViewLclupha16, textViewLclupha17};
                        int i34 = 0;
                        for (int i35 = 3; i34 < i35; i35 = 3) {
                            TextView textView5 = textViewArr2[i34];
                            LinearLayout.LayoutParams layoutParams33 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams33.topMargin = zamkzqg.qunltjs(mainActivity3, 7);
                            linearLayoutZwaqeaz10.addView(textView5, layoutParams33);
                            i34++;
                        }
                        LinearLayout.LayoutParams layoutParamsUiqyzsp2 = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp2.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz10, layoutParamsUiqyzsp2);
                        linearLayoutZwaqeaz10.setVisibility(8);
                        LinearLayout linearLayoutZwaqeaz11 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz11.setOrientation(1);
                        linearLayoutZwaqeaz11.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_device_info));
                        TextView textViewHjlrtqw9 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw10 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw11 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw12 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw13 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_product, textViewHjlrtqw9);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_serial, textViewHjlrtqw10);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_current_slot, textViewHjlrtqw11);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_unlocked, textViewHjlrtqw12);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_bootloader_version, textViewHjlrtqw13);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz11, zamkzqg.uiqyzsp(mainActivity3));
                        linearLayoutZwaqeaz11.setVisibility(8);
                        LinearLayout linearLayout6 = new LinearLayout(mainActivity3);
                        linearLayout6.setOrientation(1);
                        linearLayout6.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_fastboot_actions));
                        final int i36 = 6;
                        View.OnClickListener onClickListener4 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i36) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh9 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha18 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener4);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha18, R.drawable.ic_reboot, iNmpwovh9);
                        final int i37 = 7;
                        View.OnClickListener onClickListener5 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i37) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh10 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha19 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener5);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha19, R.drawable.ic_unlock, iNmpwovh10);
                        final int i38 = 8;
                        View.OnClickListener onClickListener6 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i38) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh11 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha20 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_fastbootd), onClickListener6);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha20, R.drawable.ic_partitions, iNmpwovh11);
                        TextView[] textViewArr3 = {textViewLclupha18, textViewLclupha19, textViewLclupha20};
                        int i39 = 0;
                        while (i39 < 3) {
                            TextView textView6 = textViewArr3[i39];
                            LinearLayout.LayoutParams layoutParams34 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams34.topMargin = zamkzqg.qunltjs(mainActivity3, 8);
                            linearLayout6.addView(textView6, layoutParams34);
                            i39++;
                            textViewArr3 = textViewArr3;
                        }
                        LinearLayout.LayoutParams layoutParams35 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams35.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayout6, layoutParams35);
                        linearLayout6.setVisibility(8);
                        linearLayoutXbdyiew10.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        linearLayoutXbdyiew11.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        mainActivity3.ltnesel = new jybecxv(scrollView5, textView, textViewHjlrtqw2, textViewOxoagud26, editText, textViewOxoagud28, scrollView7, textView3, linearLayoutZwaqeaz10, textViewHjlrtqw3, textViewHjlrtqw4, textViewHjlrtqw5, textViewHjlrtqw6, textViewHjlrtqw7, textViewHjlrtqw8, textViewHjlrtqw9, textViewHjlrtqw10, textViewHjlrtqw11, textViewHjlrtqw12, textViewHjlrtqw13, linearLayoutZwaqeaz11, linearLayout6);
                        ccuulnt ccuulntVar = mainActivity3.suqlntg;
                        String string2 = mainActivity3.getString(R.string.android_tools_terminal_banner);
                        synchronized (ccuulntVar) {
                            try {
                                if (ccuulntVar.nmpwovh.length() == 0 && string2 != null && !string2.isEmpty()) {
                                    ccuulntVar.nmpwovh.append(string2.replace("\r\n", "\n").replace('\r', '\n'));
                                    ccuulntVar.ojyssqt();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        ccuulnt ccuulntVar2 = mainActivity3.suqlntg;
                        ccuulntVar2.qxvquar = true;
                        ccuulntVar2.nmpwovh(true);
                        mainActivity3.suqlntg.nmpwovh(true);
                        mainActivity3.gdkopre();
                        mainActivity3.kffvigz(scrollView5, "android_tools");
                        mainActivity3.jzcfpou();
                        return;
                    default:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar2.nmpwovh;
                        if (mainActivity4.lpkdqgx || mainActivity4.gzokllk) {
                            Toast.makeText(mainActivity4, R.string.error_busy, 0).show();
                            return;
                        } else {
                            new AlertDialog.Builder(mainActivity4).setTitle(R.string.power_menu_title).setItems(new String[]{mainActivity4.getString(R.string.power_normal_reboot), mainActivity4.getString(R.string.power_shutdown)}, new nsyqsfj(mainActivity4, 1)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
                            return;
                        }
                }
            }
        }), zamkzqg.exhiehf(nmpwovhVar, false));
        final int i16 = 2;
        linearLayoutXbdyiew4.addView(zamkzqg.eigllth(nmpwovhVar, R.string.menu_partition_manager, R.string.menu_partition_manager_desc, R.drawable.ic_partitions, new View.OnClickListener() { // from class: x.axbavsj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i16) {
                    case 0:
                        gepzcpdVar2.nmpwovh.gzokllk();
                        return;
                    case 1:
                        gepzcpdVar2.nmpwovh.nhhacgu("xiaomi_authorize");
                        return;
                    case 2:
                        gepzcpdVar2.nmpwovh.nhhacgu("parts");
                        return;
                    case 3:
                        final MainActivity mainActivity2 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity2.getClass();
                        final wjugzfh wjugzfhVar = new wjugzfh(mainActivity2);
                        ScrollView scrollView4 = new ScrollView(mainActivity2);
                        scrollView4.setFillViewport(true);
                        scrollView4.setBackgroundColor(zamkzqg.buswjhz(mainActivity2));
                        LinearLayout linearLayoutXbdyiew5 = zamkzqg.xbdyiew(mainActivity2, 16);
                        scrollView4.addView(linearLayoutXbdyiew5);
                        int iNmpwovh2 = zamkzqg.nmpwovh(mainActivity2);
                        final int i17 = 0;
                        TextView textViewLclupha9 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_back), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i17) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha9, R.drawable.ic_back, iNmpwovh2);
                        textViewLclupha9.setGravity(8388627);
                        linearLayoutXbdyiew5.addView(textViewLclupha9);
                        TextView textViewYwhgqsi = zamkzqg.ywhgqsi(mainActivity2, mainActivity2.getString(R.string.bootloader_page_title));
                        zamkzqg.enxkjpu(mainActivity2, textViewYwhgqsi, R.drawable.ic_device_info, zamkzqg.nmpwovh(mainActivity2));
                        linearLayoutXbdyiew5.addView(textViewYwhgqsi);
                        linearLayoutXbdyiew5.addView(zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_page_subtitle), 12, zamkzqg.jbmzxye(mainActivity2), false));
                        LinearLayout linearLayoutLvtqoqa9 = zamkzqg.lvtqoqa(mainActivity2);
                        linearLayoutLvtqoqa9.setGravity(17);
                        linearLayoutLvtqoqa9.setPadding(zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4));
                        linearLayoutLvtqoqa9.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity2, 12)));
                        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity2, 48));
                        layoutParams23.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        final TextView textViewMslkofp = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_status);
                        final TextView textViewMslkofp2 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_slot);
                        final TextView textViewMslkofp3 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_security);
                        LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs = zamkzqg.qunltjs(mainActivity2, 2);
                        layoutParams24.setMargins(iQunltjs, 0, iQunltjs, 0);
                        linearLayoutLvtqoqa9.addView(textViewMslkofp, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp2, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp3, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutXbdyiew5.addView(linearLayoutLvtqoqa9, layoutParams23);
                        final LinearLayout linearLayoutXbdyiew6 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew7 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew8 = zamkzqg.xbdyiew(mainActivity2, 0);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew6);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew7);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew8);
                        final int i18 = 0;
                        textViewMslkofp.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i18) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i19 = 1;
                        textViewMslkofp2.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i19) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i110 = 2;
                        textViewMslkofp3.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i110) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                        LinearLayout linearLayoutZwaqeaz7 = zamkzqg.zwaqeaz(mainActivity2);
                        TextView textViewOxoagud20 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_reading), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud20, R.drawable.ic_refresh, zamkzqg.ohwxijw(mainActivity2));
                        linearLayoutZwaqeaz7.addView(textViewOxoagud20);
                        TextView textViewDkpobjg = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg2 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg3 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg4 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg5 = zamkzqg.dkpobjg(mainActivity2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_offset, textViewDkpobjg);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_slot_count, textViewDkpobjg2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_active, textViewDkpobjg3);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_suffix, textViewDkpobjg4);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_crc, textViewDkpobjg5);
                        linearLayoutXbdyiew6.addView(linearLayoutZwaqeaz7, zamkzqg.uiqyzsp(mainActivity2));
                        int iNmpwovh3 = zamkzqg.nmpwovh(mainActivity2);
                        final int i20 = 1;
                        TextView textViewLclupha10 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_refresh), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i20) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha10, R.drawable.ic_refresh, iNmpwovh3);
                        linearLayoutXbdyiew6.addView(textViewLclupha10, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        TextView textViewOxoagud21 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_slot_intro), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams25.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        linearLayoutXbdyiew7.addView(textViewOxoagud21, layoutParams25);
                        iilntfn iilntfnVarDplrlfq = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "A", wjugzfhVar);
                        iilntfn iilntfnVarDplrlfq2 = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "B", wjugzfhVar);
                        LinearLayout linearLayout5 = new LinearLayout(mainActivity2);
                        linearLayout5.setOrientation(1);
                        int dimensionPixelSize2 = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_padding);
                        linearLayout5.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
                        linearLayout5.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), zamkzqg.ohwxijw(mainActivity2), mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_radius)));
                        TextView textViewOxoagud22 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_warning), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud22, R.drawable.ic_warning, zamkzqg.ohwxijw(mainActivity2));
                        linearLayout5.addView(textViewOxoagud22);
                        TextView textViewOxoagud23 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_detail), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        textViewOxoagud23.setPadding(0, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top), 0, 0);
                        linearLayout5.addView(textViewOxoagud23);
                        linearLayoutXbdyiew8.addView(linearLayout5, zamkzqg.uiqyzsp(mainActivity2));
                        int iKggugdp2 = zamkzqg.kggugdp(mainActivity2);
                        final int i21 = 2;
                        TextView textViewLclupha11 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_unlock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i21) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha11, R.drawable.ic_unlock, iKggugdp2);
                        textViewLclupha11.setTextColor(zamkzqg.kggugdp(mainActivity2));
                        textViewLclupha11.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.ojyssqt(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_button_radius)));
                        linearLayoutXbdyiew8.addView(textViewLclupha11, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        int iOhwxijw = zamkzqg.ohwxijw(mainActivity2);
                        final int i22 = 3;
                        TextView textViewLclupha12 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_lock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i22) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha12, R.drawable.ic_lock, iOhwxijw);
                        LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                        layoutParams26.topMargin = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_page_action_gap);
                        linearLayoutXbdyiew8.addView(textViewLclupha12, layoutParams26);
                        linearLayoutXbdyiew5.addView(new View(mainActivity2), new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        iilntfn iilntfnVar = new iilntfn(scrollView4, mainActivity2, textViewOxoagud20, textViewDkpobjg, textViewDkpobjg2, textViewDkpobjg3, textViewDkpobjg4, textViewDkpobjg5, iilntfnVarDplrlfq, iilntfnVarDplrlfq2);
                        iilntfnVar.vivhedu();
                        mainActivity2.pmsrvoc = iilntfnVar;
                        mainActivity2.kffvigz(scrollView4, "bootloader_manager");
                        if (mainActivity2.nsyqsfj) {
                            mainActivity2.odhctch();
                            return;
                        } else {
                            mainActivity2.rrpfqyy = "";
                            mainActivity2.pmsrvoc.lthborb(mainActivity2.getString(mainActivity2.gzokllk ? R.string.error_da_connecting : R.string.error_wait_da_ready));
                            return;
                        }
                    case 4:
                        final MainActivity mainActivity3 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity3.getClass();
                        final wjugzfh wjugzfhVar2 = new wjugzfh(mainActivity3);
                        ScrollView scrollView5 = new ScrollView(mainActivity3);
                        scrollView5.setFillViewport(true);
                        scrollView5.setBackgroundColor(zamkzqg.buswjhz(mainActivity3));
                        LinearLayout linearLayoutXbdyiew9 = zamkzqg.xbdyiew(mainActivity3, 16);
                        scrollView5.addView(linearLayoutXbdyiew9);
                        int iNmpwovh4 = zamkzqg.nmpwovh(mainActivity3);
                        final int i23 = 0;
                        TextView textViewLclupha13 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_back), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i23) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha13, R.drawable.ic_back, iNmpwovh4);
                        textViewLclupha13.setGravity(8388627);
                        linearLayoutXbdyiew9.addView(textViewLclupha13);
                        TextView textViewYwhgqsi2 = zamkzqg.ywhgqsi(mainActivity3, mainActivity3.getString(R.string.android_tools_title));
                        zamkzqg.enxkjpu(mainActivity3, textViewYwhgqsi2, R.drawable.ic_usb, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutXbdyiew9.addView(textViewYwhgqsi2);
                        linearLayoutXbdyiew9.addView(zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_subtitle), 12, zamkzqg.jbmzxye(mainActivity3), false));
                        LinearLayout linearLayoutLvtqoqa10 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa10.setGravity(17);
                        linearLayoutLvtqoqa10.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4));
                        linearLayoutLvtqoqa10.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), mainActivity3.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity3, 12)));
                        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity3, 48));
                        layoutParams27.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        final TextView textViewOxoagud24 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_device), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud24.setGravity(17);
                        textViewOxoagud24.setClickable(true);
                        textViewOxoagud24.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud24);
                        TextView textViewOxoagud25 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_terminal), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud25.setGravity(17);
                        textViewOxoagud25.setClickable(true);
                        textViewOxoagud25.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud25);
                        LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs2 = zamkzqg.qunltjs(mainActivity3, 2);
                        layoutParams28.setMargins(iQunltjs2, 0, iQunltjs2, 0);
                        linearLayoutLvtqoqa10.addView(textViewOxoagud24, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutLvtqoqa10.addView(textViewOxoagud25, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutXbdyiew9.addView(linearLayoutLvtqoqa10, layoutParams27);
                        final LinearLayout linearLayoutXbdyiew10 = zamkzqg.xbdyiew(mainActivity3, 0);
                        final LinearLayout linearLayoutXbdyiew11 = zamkzqg.xbdyiew(mainActivity3, 0);
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew10, new LinearLayout.LayoutParams(-1, -2));
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew11, new LinearLayout.LayoutParams(-1, -2));
                        textViewOxoagud24.setOnClickListener(new bwvplah(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, 0));
                        zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, false);
                        LinearLayout linearLayoutZwaqeaz8 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz8.setOrientation(1);
                        TextView textViewOxoagud26 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_scanning), 13, zamkzqg.ohwxijw(mainActivity3), true);
                        zamkzqg.enxkjpu(mainActivity3, textViewOxoagud26, R.drawable.ic_usb, zamkzqg.ohwxijw(mainActivity3));
                        linearLayoutZwaqeaz8.addView(textViewOxoagud26);
                        TextView textViewHjlrtqw = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw2 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_transport, textViewHjlrtqw);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_usb_id, textViewHjlrtqw2);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz8, zamkzqg.uiqyzsp(mainActivity3));
                        int iNmpwovh5 = zamkzqg.nmpwovh(mainActivity3);
                        final int i24 = 9;
                        TextView textViewLclupha14 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_refresh), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i24) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha14, R.drawable.ic_refresh, iNmpwovh5);
                        linearLayoutXbdyiew10.addView(textViewLclupha14, new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        LinearLayout linearLayoutZwaqeaz9 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz9.setOrientation(1);
                        TextView textViewYsaclsr = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_terminal_title);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz9.addView(textViewYsaclsr);
                        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(mainActivity3);
                        horizontalScrollView.setHorizontalScrollBarEnabled(false);
                        horizontalScrollView.setFillViewport(false);
                        LinearLayout linearLayoutLvtqoqa11 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa11.setPadding(0, zamkzqg.qunltjs(mainActivity3, 10), 0, zamkzqg.qunltjs(mainActivity3, 10));
                        String[][] strArr = {new String[]{"adb devices", "adb devices"}, new String[]{"adb shell", "adb shell"}, new String[]{"getprop", "adb shell getprop"}, new String[]{"fastboot devices", "fastboot devices"}, new String[]{"getvar product", "fastboot getvar product"}};
                        int i25 = 0;
                        while (i25 < 5) {
                            String[] strArr2 = strArr[i25];
                            String str = strArr2[0];
                            String str2 = strArr2[1];
                            String[][] strArr3 = strArr;
                            TextView textViewOxoagud27 = zamkzqg.oxoagud(mainActivity3, str, 11, zamkzqg.zngzleo(mainActivity3), true);
                            textViewOxoagud27.setGravity(17);
                            textViewOxoagud27.setSingleLine(true);
                            textViewOxoagud27.setPadding(zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8));
                            textViewOxoagud27.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 18)));
                            textViewOxoagud27.setClickable(true);
                            textViewOxoagud27.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textViewOxoagud27);
                            textViewOxoagud27.setOnClickListener(new pzqxblc(wjugzfhVar2, str2, 0));
                            LinearLayout.LayoutParams layoutParams29 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams29.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 7));
                            linearLayoutLvtqoqa11.addView(textViewOxoagud27, layoutParams29);
                            i25++;
                            strArr = strArr3;
                            textViewHjlrtqw = textViewHjlrtqw;
                        }
                        TextView textView = textViewHjlrtqw;
                        horizontalScrollView.addView(linearLayoutLvtqoqa11, new FrameLayout.LayoutParams(-2, -2));
                        linearLayoutZwaqeaz9.addView(horizontalScrollView);
                        int iRgb = Color.rgb(30, 37, 40);
                        int iRgb2 = Color.rgb(232, 236, 233);
                        int iRgb3 = Color.rgb(72, 112, 76);
                        ScrollView scrollView6 = new ScrollView(mainActivity3);
                        scrollView6.setFillViewport(true);
                        scrollView6.setVerticalScrollBarEnabled(true);
                        scrollView6.setScrollbarFadingEnabled(true);
                        scrollView6.setBackground(zamkzqg.jvtqflj(mainActivity3, iRgb, iRgb3, zamkzqg.qunltjs(mainActivity3, 12)));
                        TextView textViewOxoagud28 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_terminal_banner), 12, iRgb2, false);
                        textViewOxoagud28.setTextColor(iRgb2);
                        Typeface typeface = Typeface.MONOSPACE;
                        textViewOxoagud28.setTypeface(typeface);
                        textViewOxoagud28.setTextIsSelectable(true);
                        textViewOxoagud28.setGravity(8388659);
                        textViewOxoagud28.setLineSpacing(0.0f, 1.08f);
                        textViewOxoagud28.setPadding(zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12));
                        scrollView6.addView(textViewOxoagud28, new FrameLayout.LayoutParams(-1, -2));
                        linearLayoutZwaqeaz9.addView(scrollView6, new LinearLayout.LayoutParams(-1, Math.max(zamkzqg.qunltjs(mainActivity3, 310), Math.min(zamkzqg.qunltjs(mainActivity3, 440), Math.round(mainActivity3.getResources().getDisplayMetrics().heightPixels * 0.43f)))));
                        LinearLayout linearLayoutLvtqoqa12 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa12.setGravity(16);
                        linearLayoutLvtqoqa12.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 2), zamkzqg.qunltjs(mainActivity3, 5), zamkzqg.qunltjs(mainActivity3, 2));
                        linearLayoutLvtqoqa12.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.czidoiw(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 10)));
                        LinearLayout.LayoutParams layoutParams30 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams30.topMargin = zamkzqg.qunltjs(mainActivity3, 9);
                        final EditText editText = new EditText(mainActivity3);
                        editText.setSingleLine(true);
                        editText.setInputType(524289);
                        editText.setTextColor(zamkzqg.zngzleo(mainActivity3));
                        editText.setHintTextColor(zamkzqg.jbmzxye(mainActivity3));
                        editText.setTypeface(typeface);
                        editText.setTextSize(13.0f);
                        editText.setHint(R.string.android_tools_terminal_hint_compact);
                        editText.setImeOptions(4);
                        editText.setBackgroundColor(mainActivity3.getColor(R.color.rynx_transparent));
                        editText.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8));
                        linearLayoutLvtqoqa12.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
                        TextView textViewOxoagud29 = zamkzqg.oxoagud(mainActivity3, "CTRL+C", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud29.setGravity(17);
                        textViewOxoagud29.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud29.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud29.setEnabled(false);
                        textViewOxoagud29.setAlpha(0.35f);
                        textViewOxoagud29.setClickable(true);
                        textViewOxoagud29.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud29);
                        final int i26 = 1;
                        textViewOxoagud29.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i26) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        TextView textViewOxoagud30 = zamkzqg.oxoagud(mainActivity3, "FILE", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud30.setGravity(17);
                        textViewOxoagud30.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud30.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud30.setClickable(true);
                        textViewOxoagud30.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud30);
                        final int i27 = 2;
                        textViewOxoagud30.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i27) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        LinearLayout.LayoutParams layoutParams31 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams31.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 6));
                        linearLayoutLvtqoqa12.addView(textViewOxoagud30, layoutParams31);
                        linearLayoutLvtqoqa12.addView(textViewOxoagud29);
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa12, layoutParams30);
                        LinearLayout linearLayoutLvtqoqa13 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa13.setGravity(17);
                        TextView textViewOxoagud31 = zamkzqg.oxoagud(mainActivity3, "↑ PREV", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud32 = zamkzqg.oxoagud(mainActivity3, "↓ NEXT", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud33 = zamkzqg.oxoagud(mainActivity3, "TAB", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        TextView[] textViewArr = {textViewOxoagud31, textViewOxoagud32, textViewOxoagud33};
                        int i28 = 0;
                        while (i28 < 3) {
                            TextView textView2 = textViewArr[i28];
                            textView2.setGravity(17);
                            textView2.setPadding(zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 6));
                            textView2.setClickable(true);
                            textView2.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textView2);
                            linearLayoutLvtqoqa13.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
                            i28++;
                            textViewOxoagud25 = textViewOxoagud25;
                            textViewArr = textViewArr;
                            textViewOxoagud29 = textViewOxoagud29;
                            scrollView6 = scrollView6;
                        }
                        TextView textView3 = textViewOxoagud29;
                        final TextView textView4 = textViewOxoagud25;
                        final ScrollView scrollView7 = scrollView6;
                        final int i29 = 0;
                        textViewOxoagud31.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i29) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        final int i30 = 1;
                        textViewOxoagud32.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i30) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        textViewOxoagud33.setOnClickListener(new nmpwovh(editText, 2));
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa13);
                        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: x.qunltjs
                            @Override // android.widget.TextView.OnEditorActionListener
                            public final boolean onEditorAction(TextView textView5, int i31, KeyEvent keyEvent) {
                                if (i31 != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
                                    return false;
                                }
                                EditText editText2 = editText;
                                String strTrim = editText2.getText() == null ? "" : editText2.getText().toString().trim();
                                if (!strTrim.isEmpty()) {
                                    editText2.setText("");
                                    wjugzfhVar2.vivhedu(strTrim);
                                }
                                return true;
                            }
                        });
                        editText.setOnKeyListener(new View.OnKeyListener() { // from class: x.cgcdpmq
                            @Override // android.view.View.OnKeyListener
                            public final boolean onKey(View view9, int i31, KeyEvent keyEvent) {
                                if (keyEvent.getAction() != 0) {
                                    return false;
                                }
                                wjugzfh wjugzfhVar3 = wjugzfhVar2;
                                EditText editText2 = editText;
                                if (i31 == 19) {
                                    String strOjyssqt = wjugzfhVar3.ojyssqt();
                                    if (strOjyssqt != null) {
                                        editText2.setText(strOjyssqt);
                                        editText2.setSelection(strOjyssqt.length());
                                    }
                                } else if (i31 == 20) {
                                    String strNmpwovh = wjugzfhVar3.nmpwovh();
                                    if (strNmpwovh != null) {
                                        editText2.setText(strNmpwovh);
                                        editText2.setSelection(strNmpwovh.length());
                                    }
                                } else {
                                    if (i31 != 61) {
                                        return false;
                                    }
                                    zamkzqg.qwgjehf(editText2);
                                }
                                return true;
                            }
                        });
                        textView4.setOnClickListener(new View.OnClickListener() { // from class: x.exhiehf
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textView4, linearLayoutXbdyiew10, linearLayoutXbdyiew11, true);
                                ScrollView scrollView8 = scrollView7;
                                scrollView8.post(new eigllth(scrollView8, 0));
                            }
                        });
                        LinearLayout.LayoutParams layoutParamsUiqyzsp = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew11.addView(linearLayoutZwaqeaz9, layoutParamsUiqyzsp);
                        LinearLayout linearLayoutZwaqeaz10 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz10.setOrientation(1);
                        TextView textViewYsaclsr2 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_device);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr2, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr2);
                        TextView textViewOxoagud34 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_note), 11, zamkzqg.jbmzxye(mainActivity3), false);
                        textViewOxoagud34.setPadding(0, zamkzqg.qunltjs(mainActivity3, 4), 0, zamkzqg.qunltjs(mainActivity3, 5));
                        linearLayoutZwaqeaz10.addView(textViewOxoagud34);
                        TextView textViewHjlrtqw3 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw4 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw5 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw6 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw7 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw8 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_state, textViewHjlrtqw3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_model, textViewHjlrtqw4);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_product, textViewHjlrtqw5);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_android, textViewHjlrtqw6);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_sdk, textViewHjlrtqw7);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_serial, textViewHjlrtqw8);
                        TextView textViewYsaclsr3 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_actions);
                        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams32.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr3, layoutParams32);
                        final int i31 = 3;
                        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i31) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh6 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha15 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha15, R.drawable.ic_reboot, iNmpwovh6);
                        final int i32 = 4;
                        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i32) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh7 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha16 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_reboot_recovery), onClickListener2);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha16, R.drawable.ic_reboot, iNmpwovh7);
                        final int i33 = 5;
                        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i33) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh8 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha17 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener3);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha17, R.drawable.ic_unlock, iNmpwovh8);
                        TextView[] textViewArr2 = {textViewLclupha15, textViewLclupha16, textViewLclupha17};
                        int i34 = 0;
                        for (int i35 = 3; i34 < i35; i35 = 3) {
                            TextView textView5 = textViewArr2[i34];
                            LinearLayout.LayoutParams layoutParams33 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams33.topMargin = zamkzqg.qunltjs(mainActivity3, 7);
                            linearLayoutZwaqeaz10.addView(textView5, layoutParams33);
                            i34++;
                        }
                        LinearLayout.LayoutParams layoutParamsUiqyzsp2 = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp2.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz10, layoutParamsUiqyzsp2);
                        linearLayoutZwaqeaz10.setVisibility(8);
                        LinearLayout linearLayoutZwaqeaz11 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz11.setOrientation(1);
                        linearLayoutZwaqeaz11.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_device_info));
                        TextView textViewHjlrtqw9 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw10 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw11 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw12 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw13 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_product, textViewHjlrtqw9);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_serial, textViewHjlrtqw10);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_current_slot, textViewHjlrtqw11);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_unlocked, textViewHjlrtqw12);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_bootloader_version, textViewHjlrtqw13);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz11, zamkzqg.uiqyzsp(mainActivity3));
                        linearLayoutZwaqeaz11.setVisibility(8);
                        LinearLayout linearLayout6 = new LinearLayout(mainActivity3);
                        linearLayout6.setOrientation(1);
                        linearLayout6.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_fastboot_actions));
                        final int i36 = 6;
                        View.OnClickListener onClickListener4 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i36) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh9 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha18 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener4);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha18, R.drawable.ic_reboot, iNmpwovh9);
                        final int i37 = 7;
                        View.OnClickListener onClickListener5 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i37) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh10 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha19 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener5);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha19, R.drawable.ic_unlock, iNmpwovh10);
                        final int i38 = 8;
                        View.OnClickListener onClickListener6 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i38) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh11 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha20 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_fastbootd), onClickListener6);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha20, R.drawable.ic_partitions, iNmpwovh11);
                        TextView[] textViewArr3 = {textViewLclupha18, textViewLclupha19, textViewLclupha20};
                        int i39 = 0;
                        while (i39 < 3) {
                            TextView textView6 = textViewArr3[i39];
                            LinearLayout.LayoutParams layoutParams34 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams34.topMargin = zamkzqg.qunltjs(mainActivity3, 8);
                            linearLayout6.addView(textView6, layoutParams34);
                            i39++;
                            textViewArr3 = textViewArr3;
                        }
                        LinearLayout.LayoutParams layoutParams35 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams35.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayout6, layoutParams35);
                        linearLayout6.setVisibility(8);
                        linearLayoutXbdyiew10.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        linearLayoutXbdyiew11.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        mainActivity3.ltnesel = new jybecxv(scrollView5, textView, textViewHjlrtqw2, textViewOxoagud26, editText, textViewOxoagud28, scrollView7, textView3, linearLayoutZwaqeaz10, textViewHjlrtqw3, textViewHjlrtqw4, textViewHjlrtqw5, textViewHjlrtqw6, textViewHjlrtqw7, textViewHjlrtqw8, textViewHjlrtqw9, textViewHjlrtqw10, textViewHjlrtqw11, textViewHjlrtqw12, textViewHjlrtqw13, linearLayoutZwaqeaz11, linearLayout6);
                        ccuulnt ccuulntVar = mainActivity3.suqlntg;
                        String string2 = mainActivity3.getString(R.string.android_tools_terminal_banner);
                        synchronized (ccuulntVar) {
                            try {
                                if (ccuulntVar.nmpwovh.length() == 0 && string2 != null && !string2.isEmpty()) {
                                    ccuulntVar.nmpwovh.append(string2.replace("\r\n", "\n").replace('\r', '\n'));
                                    ccuulntVar.ojyssqt();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        ccuulnt ccuulntVar2 = mainActivity3.suqlntg;
                        ccuulntVar2.qxvquar = true;
                        ccuulntVar2.nmpwovh(true);
                        mainActivity3.suqlntg.nmpwovh(true);
                        mainActivity3.gdkopre();
                        mainActivity3.kffvigz(scrollView5, "android_tools");
                        mainActivity3.jzcfpou();
                        return;
                    default:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar2.nmpwovh;
                        if (mainActivity4.lpkdqgx || mainActivity4.gzokllk) {
                            Toast.makeText(mainActivity4, R.string.error_busy, 0).show();
                            return;
                        } else {
                            new AlertDialog.Builder(mainActivity4).setTitle(R.string.power_menu_title).setItems(new String[]{mainActivity4.getString(R.string.power_normal_reboot), mainActivity4.getString(R.string.power_shutdown)}, new nsyqsfj(mainActivity4, 1)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
                            return;
                        }
                }
            }
        }), zamkzqg.exhiehf(nmpwovhVar, false));
        final int i17 = 3;
        linearLayoutXbdyiew4.addView(zamkzqg.eigllth(nmpwovhVar, R.string.menu_bootloader_manager, R.string.menu_bootloader_manager_desc, R.drawable.ic_unlock, new View.OnClickListener() { // from class: x.axbavsj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i17) {
                    case 0:
                        gepzcpdVar2.nmpwovh.gzokllk();
                        return;
                    case 1:
                        gepzcpdVar2.nmpwovh.nhhacgu("xiaomi_authorize");
                        return;
                    case 2:
                        gepzcpdVar2.nmpwovh.nhhacgu("parts");
                        return;
                    case 3:
                        final MainActivity mainActivity2 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity2.getClass();
                        final wjugzfh wjugzfhVar = new wjugzfh(mainActivity2);
                        ScrollView scrollView4 = new ScrollView(mainActivity2);
                        scrollView4.setFillViewport(true);
                        scrollView4.setBackgroundColor(zamkzqg.buswjhz(mainActivity2));
                        LinearLayout linearLayoutXbdyiew5 = zamkzqg.xbdyiew(mainActivity2, 16);
                        scrollView4.addView(linearLayoutXbdyiew5);
                        int iNmpwovh2 = zamkzqg.nmpwovh(mainActivity2);
                        final int i18 = 0;
                        TextView textViewLclupha9 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_back), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i18) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha9, R.drawable.ic_back, iNmpwovh2);
                        textViewLclupha9.setGravity(8388627);
                        linearLayoutXbdyiew5.addView(textViewLclupha9);
                        TextView textViewYwhgqsi = zamkzqg.ywhgqsi(mainActivity2, mainActivity2.getString(R.string.bootloader_page_title));
                        zamkzqg.enxkjpu(mainActivity2, textViewYwhgqsi, R.drawable.ic_device_info, zamkzqg.nmpwovh(mainActivity2));
                        linearLayoutXbdyiew5.addView(textViewYwhgqsi);
                        linearLayoutXbdyiew5.addView(zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_page_subtitle), 12, zamkzqg.jbmzxye(mainActivity2), false));
                        LinearLayout linearLayoutLvtqoqa9 = zamkzqg.lvtqoqa(mainActivity2);
                        linearLayoutLvtqoqa9.setGravity(17);
                        linearLayoutLvtqoqa9.setPadding(zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4));
                        linearLayoutLvtqoqa9.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity2, 12)));
                        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity2, 48));
                        layoutParams23.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        final TextView textViewMslkofp = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_status);
                        final TextView textViewMslkofp2 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_slot);
                        final TextView textViewMslkofp3 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_security);
                        LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs = zamkzqg.qunltjs(mainActivity2, 2);
                        layoutParams24.setMargins(iQunltjs, 0, iQunltjs, 0);
                        linearLayoutLvtqoqa9.addView(textViewMslkofp, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp2, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp3, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutXbdyiew5.addView(linearLayoutLvtqoqa9, layoutParams23);
                        final LinearLayout linearLayoutXbdyiew6 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew7 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew8 = zamkzqg.xbdyiew(mainActivity2, 0);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew6);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew7);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew8);
                        final int i19 = 0;
                        textViewMslkofp.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i19) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i110 = 1;
                        textViewMslkofp2.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i110) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i111 = 2;
                        textViewMslkofp3.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i111) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                        LinearLayout linearLayoutZwaqeaz7 = zamkzqg.zwaqeaz(mainActivity2);
                        TextView textViewOxoagud20 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_reading), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud20, R.drawable.ic_refresh, zamkzqg.ohwxijw(mainActivity2));
                        linearLayoutZwaqeaz7.addView(textViewOxoagud20);
                        TextView textViewDkpobjg = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg2 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg3 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg4 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg5 = zamkzqg.dkpobjg(mainActivity2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_offset, textViewDkpobjg);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_slot_count, textViewDkpobjg2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_active, textViewDkpobjg3);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_suffix, textViewDkpobjg4);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_crc, textViewDkpobjg5);
                        linearLayoutXbdyiew6.addView(linearLayoutZwaqeaz7, zamkzqg.uiqyzsp(mainActivity2));
                        int iNmpwovh3 = zamkzqg.nmpwovh(mainActivity2);
                        final int i20 = 1;
                        TextView textViewLclupha10 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_refresh), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i20) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha10, R.drawable.ic_refresh, iNmpwovh3);
                        linearLayoutXbdyiew6.addView(textViewLclupha10, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        TextView textViewOxoagud21 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_slot_intro), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams25.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        linearLayoutXbdyiew7.addView(textViewOxoagud21, layoutParams25);
                        iilntfn iilntfnVarDplrlfq = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "A", wjugzfhVar);
                        iilntfn iilntfnVarDplrlfq2 = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "B", wjugzfhVar);
                        LinearLayout linearLayout5 = new LinearLayout(mainActivity2);
                        linearLayout5.setOrientation(1);
                        int dimensionPixelSize2 = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_padding);
                        linearLayout5.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
                        linearLayout5.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), zamkzqg.ohwxijw(mainActivity2), mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_radius)));
                        TextView textViewOxoagud22 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_warning), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud22, R.drawable.ic_warning, zamkzqg.ohwxijw(mainActivity2));
                        linearLayout5.addView(textViewOxoagud22);
                        TextView textViewOxoagud23 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_detail), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        textViewOxoagud23.setPadding(0, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top), 0, 0);
                        linearLayout5.addView(textViewOxoagud23);
                        linearLayoutXbdyiew8.addView(linearLayout5, zamkzqg.uiqyzsp(mainActivity2));
                        int iKggugdp2 = zamkzqg.kggugdp(mainActivity2);
                        final int i21 = 2;
                        TextView textViewLclupha11 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_unlock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i21) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha11, R.drawable.ic_unlock, iKggugdp2);
                        textViewLclupha11.setTextColor(zamkzqg.kggugdp(mainActivity2));
                        textViewLclupha11.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.ojyssqt(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_button_radius)));
                        linearLayoutXbdyiew8.addView(textViewLclupha11, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        int iOhwxijw = zamkzqg.ohwxijw(mainActivity2);
                        final int i22 = 3;
                        TextView textViewLclupha12 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_lock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i22) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha12, R.drawable.ic_lock, iOhwxijw);
                        LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                        layoutParams26.topMargin = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_page_action_gap);
                        linearLayoutXbdyiew8.addView(textViewLclupha12, layoutParams26);
                        linearLayoutXbdyiew5.addView(new View(mainActivity2), new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        iilntfn iilntfnVar = new iilntfn(scrollView4, mainActivity2, textViewOxoagud20, textViewDkpobjg, textViewDkpobjg2, textViewDkpobjg3, textViewDkpobjg4, textViewDkpobjg5, iilntfnVarDplrlfq, iilntfnVarDplrlfq2);
                        iilntfnVar.vivhedu();
                        mainActivity2.pmsrvoc = iilntfnVar;
                        mainActivity2.kffvigz(scrollView4, "bootloader_manager");
                        if (mainActivity2.nsyqsfj) {
                            mainActivity2.odhctch();
                            return;
                        } else {
                            mainActivity2.rrpfqyy = "";
                            mainActivity2.pmsrvoc.lthborb(mainActivity2.getString(mainActivity2.gzokllk ? R.string.error_da_connecting : R.string.error_wait_da_ready));
                            return;
                        }
                    case 4:
                        final MainActivity mainActivity3 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity3.getClass();
                        final wjugzfh wjugzfhVar2 = new wjugzfh(mainActivity3);
                        ScrollView scrollView5 = new ScrollView(mainActivity3);
                        scrollView5.setFillViewport(true);
                        scrollView5.setBackgroundColor(zamkzqg.buswjhz(mainActivity3));
                        LinearLayout linearLayoutXbdyiew9 = zamkzqg.xbdyiew(mainActivity3, 16);
                        scrollView5.addView(linearLayoutXbdyiew9);
                        int iNmpwovh4 = zamkzqg.nmpwovh(mainActivity3);
                        final int i23 = 0;
                        TextView textViewLclupha13 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_back), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i23) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha13, R.drawable.ic_back, iNmpwovh4);
                        textViewLclupha13.setGravity(8388627);
                        linearLayoutXbdyiew9.addView(textViewLclupha13);
                        TextView textViewYwhgqsi2 = zamkzqg.ywhgqsi(mainActivity3, mainActivity3.getString(R.string.android_tools_title));
                        zamkzqg.enxkjpu(mainActivity3, textViewYwhgqsi2, R.drawable.ic_usb, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutXbdyiew9.addView(textViewYwhgqsi2);
                        linearLayoutXbdyiew9.addView(zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_subtitle), 12, zamkzqg.jbmzxye(mainActivity3), false));
                        LinearLayout linearLayoutLvtqoqa10 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa10.setGravity(17);
                        linearLayoutLvtqoqa10.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4));
                        linearLayoutLvtqoqa10.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), mainActivity3.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity3, 12)));
                        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity3, 48));
                        layoutParams27.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        final TextView textViewOxoagud24 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_device), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud24.setGravity(17);
                        textViewOxoagud24.setClickable(true);
                        textViewOxoagud24.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud24);
                        TextView textViewOxoagud25 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_terminal), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud25.setGravity(17);
                        textViewOxoagud25.setClickable(true);
                        textViewOxoagud25.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud25);
                        LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs2 = zamkzqg.qunltjs(mainActivity3, 2);
                        layoutParams28.setMargins(iQunltjs2, 0, iQunltjs2, 0);
                        linearLayoutLvtqoqa10.addView(textViewOxoagud24, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutLvtqoqa10.addView(textViewOxoagud25, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutXbdyiew9.addView(linearLayoutLvtqoqa10, layoutParams27);
                        final LinearLayout linearLayoutXbdyiew10 = zamkzqg.xbdyiew(mainActivity3, 0);
                        final LinearLayout linearLayoutXbdyiew11 = zamkzqg.xbdyiew(mainActivity3, 0);
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew10, new LinearLayout.LayoutParams(-1, -2));
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew11, new LinearLayout.LayoutParams(-1, -2));
                        textViewOxoagud24.setOnClickListener(new bwvplah(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, 0));
                        zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, false);
                        LinearLayout linearLayoutZwaqeaz8 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz8.setOrientation(1);
                        TextView textViewOxoagud26 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_scanning), 13, zamkzqg.ohwxijw(mainActivity3), true);
                        zamkzqg.enxkjpu(mainActivity3, textViewOxoagud26, R.drawable.ic_usb, zamkzqg.ohwxijw(mainActivity3));
                        linearLayoutZwaqeaz8.addView(textViewOxoagud26);
                        TextView textViewHjlrtqw = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw2 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_transport, textViewHjlrtqw);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_usb_id, textViewHjlrtqw2);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz8, zamkzqg.uiqyzsp(mainActivity3));
                        int iNmpwovh5 = zamkzqg.nmpwovh(mainActivity3);
                        final int i24 = 9;
                        TextView textViewLclupha14 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_refresh), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i24) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha14, R.drawable.ic_refresh, iNmpwovh5);
                        linearLayoutXbdyiew10.addView(textViewLclupha14, new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        LinearLayout linearLayoutZwaqeaz9 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz9.setOrientation(1);
                        TextView textViewYsaclsr = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_terminal_title);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz9.addView(textViewYsaclsr);
                        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(mainActivity3);
                        horizontalScrollView.setHorizontalScrollBarEnabled(false);
                        horizontalScrollView.setFillViewport(false);
                        LinearLayout linearLayoutLvtqoqa11 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa11.setPadding(0, zamkzqg.qunltjs(mainActivity3, 10), 0, zamkzqg.qunltjs(mainActivity3, 10));
                        String[][] strArr = {new String[]{"adb devices", "adb devices"}, new String[]{"adb shell", "adb shell"}, new String[]{"getprop", "adb shell getprop"}, new String[]{"fastboot devices", "fastboot devices"}, new String[]{"getvar product", "fastboot getvar product"}};
                        int i25 = 0;
                        while (i25 < 5) {
                            String[] strArr2 = strArr[i25];
                            String str = strArr2[0];
                            String str2 = strArr2[1];
                            String[][] strArr3 = strArr;
                            TextView textViewOxoagud27 = zamkzqg.oxoagud(mainActivity3, str, 11, zamkzqg.zngzleo(mainActivity3), true);
                            textViewOxoagud27.setGravity(17);
                            textViewOxoagud27.setSingleLine(true);
                            textViewOxoagud27.setPadding(zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8));
                            textViewOxoagud27.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 18)));
                            textViewOxoagud27.setClickable(true);
                            textViewOxoagud27.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textViewOxoagud27);
                            textViewOxoagud27.setOnClickListener(new pzqxblc(wjugzfhVar2, str2, 0));
                            LinearLayout.LayoutParams layoutParams29 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams29.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 7));
                            linearLayoutLvtqoqa11.addView(textViewOxoagud27, layoutParams29);
                            i25++;
                            strArr = strArr3;
                            textViewHjlrtqw = textViewHjlrtqw;
                        }
                        TextView textView = textViewHjlrtqw;
                        horizontalScrollView.addView(linearLayoutLvtqoqa11, new FrameLayout.LayoutParams(-2, -2));
                        linearLayoutZwaqeaz9.addView(horizontalScrollView);
                        int iRgb = Color.rgb(30, 37, 40);
                        int iRgb2 = Color.rgb(232, 236, 233);
                        int iRgb3 = Color.rgb(72, 112, 76);
                        ScrollView scrollView6 = new ScrollView(mainActivity3);
                        scrollView6.setFillViewport(true);
                        scrollView6.setVerticalScrollBarEnabled(true);
                        scrollView6.setScrollbarFadingEnabled(true);
                        scrollView6.setBackground(zamkzqg.jvtqflj(mainActivity3, iRgb, iRgb3, zamkzqg.qunltjs(mainActivity3, 12)));
                        TextView textViewOxoagud28 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_terminal_banner), 12, iRgb2, false);
                        textViewOxoagud28.setTextColor(iRgb2);
                        Typeface typeface = Typeface.MONOSPACE;
                        textViewOxoagud28.setTypeface(typeface);
                        textViewOxoagud28.setTextIsSelectable(true);
                        textViewOxoagud28.setGravity(8388659);
                        textViewOxoagud28.setLineSpacing(0.0f, 1.08f);
                        textViewOxoagud28.setPadding(zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12));
                        scrollView6.addView(textViewOxoagud28, new FrameLayout.LayoutParams(-1, -2));
                        linearLayoutZwaqeaz9.addView(scrollView6, new LinearLayout.LayoutParams(-1, Math.max(zamkzqg.qunltjs(mainActivity3, 310), Math.min(zamkzqg.qunltjs(mainActivity3, 440), Math.round(mainActivity3.getResources().getDisplayMetrics().heightPixels * 0.43f)))));
                        LinearLayout linearLayoutLvtqoqa12 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa12.setGravity(16);
                        linearLayoutLvtqoqa12.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 2), zamkzqg.qunltjs(mainActivity3, 5), zamkzqg.qunltjs(mainActivity3, 2));
                        linearLayoutLvtqoqa12.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.czidoiw(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 10)));
                        LinearLayout.LayoutParams layoutParams30 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams30.topMargin = zamkzqg.qunltjs(mainActivity3, 9);
                        final EditText editText = new EditText(mainActivity3);
                        editText.setSingleLine(true);
                        editText.setInputType(524289);
                        editText.setTextColor(zamkzqg.zngzleo(mainActivity3));
                        editText.setHintTextColor(zamkzqg.jbmzxye(mainActivity3));
                        editText.setTypeface(typeface);
                        editText.setTextSize(13.0f);
                        editText.setHint(R.string.android_tools_terminal_hint_compact);
                        editText.setImeOptions(4);
                        editText.setBackgroundColor(mainActivity3.getColor(R.color.rynx_transparent));
                        editText.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8));
                        linearLayoutLvtqoqa12.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
                        TextView textViewOxoagud29 = zamkzqg.oxoagud(mainActivity3, "CTRL+C", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud29.setGravity(17);
                        textViewOxoagud29.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud29.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud29.setEnabled(false);
                        textViewOxoagud29.setAlpha(0.35f);
                        textViewOxoagud29.setClickable(true);
                        textViewOxoagud29.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud29);
                        final int i26 = 1;
                        textViewOxoagud29.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i26) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        TextView textViewOxoagud30 = zamkzqg.oxoagud(mainActivity3, "FILE", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud30.setGravity(17);
                        textViewOxoagud30.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud30.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud30.setClickable(true);
                        textViewOxoagud30.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud30);
                        final int i27 = 2;
                        textViewOxoagud30.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i27) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        LinearLayout.LayoutParams layoutParams31 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams31.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 6));
                        linearLayoutLvtqoqa12.addView(textViewOxoagud30, layoutParams31);
                        linearLayoutLvtqoqa12.addView(textViewOxoagud29);
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa12, layoutParams30);
                        LinearLayout linearLayoutLvtqoqa13 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa13.setGravity(17);
                        TextView textViewOxoagud31 = zamkzqg.oxoagud(mainActivity3, "↑ PREV", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud32 = zamkzqg.oxoagud(mainActivity3, "↓ NEXT", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud33 = zamkzqg.oxoagud(mainActivity3, "TAB", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        TextView[] textViewArr = {textViewOxoagud31, textViewOxoagud32, textViewOxoagud33};
                        int i28 = 0;
                        while (i28 < 3) {
                            TextView textView2 = textViewArr[i28];
                            textView2.setGravity(17);
                            textView2.setPadding(zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 6));
                            textView2.setClickable(true);
                            textView2.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textView2);
                            linearLayoutLvtqoqa13.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
                            i28++;
                            textViewOxoagud25 = textViewOxoagud25;
                            textViewArr = textViewArr;
                            textViewOxoagud29 = textViewOxoagud29;
                            scrollView6 = scrollView6;
                        }
                        TextView textView3 = textViewOxoagud29;
                        final TextView textView4 = textViewOxoagud25;
                        final ScrollView scrollView7 = scrollView6;
                        final int i29 = 0;
                        textViewOxoagud31.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i29) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        final int i30 = 1;
                        textViewOxoagud32.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i30) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        textViewOxoagud33.setOnClickListener(new nmpwovh(editText, 2));
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa13);
                        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: x.qunltjs
                            @Override // android.widget.TextView.OnEditorActionListener
                            public final boolean onEditorAction(TextView textView5, int i31, KeyEvent keyEvent) {
                                if (i31 != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
                                    return false;
                                }
                                EditText editText2 = editText;
                                String strTrim = editText2.getText() == null ? "" : editText2.getText().toString().trim();
                                if (!strTrim.isEmpty()) {
                                    editText2.setText("");
                                    wjugzfhVar2.vivhedu(strTrim);
                                }
                                return true;
                            }
                        });
                        editText.setOnKeyListener(new View.OnKeyListener() { // from class: x.cgcdpmq
                            @Override // android.view.View.OnKeyListener
                            public final boolean onKey(View view9, int i31, KeyEvent keyEvent) {
                                if (keyEvent.getAction() != 0) {
                                    return false;
                                }
                                wjugzfh wjugzfhVar3 = wjugzfhVar2;
                                EditText editText2 = editText;
                                if (i31 == 19) {
                                    String strOjyssqt = wjugzfhVar3.ojyssqt();
                                    if (strOjyssqt != null) {
                                        editText2.setText(strOjyssqt);
                                        editText2.setSelection(strOjyssqt.length());
                                    }
                                } else if (i31 == 20) {
                                    String strNmpwovh = wjugzfhVar3.nmpwovh();
                                    if (strNmpwovh != null) {
                                        editText2.setText(strNmpwovh);
                                        editText2.setSelection(strNmpwovh.length());
                                    }
                                } else {
                                    if (i31 != 61) {
                                        return false;
                                    }
                                    zamkzqg.qwgjehf(editText2);
                                }
                                return true;
                            }
                        });
                        textView4.setOnClickListener(new View.OnClickListener() { // from class: x.exhiehf
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textView4, linearLayoutXbdyiew10, linearLayoutXbdyiew11, true);
                                ScrollView scrollView8 = scrollView7;
                                scrollView8.post(new eigllth(scrollView8, 0));
                            }
                        });
                        LinearLayout.LayoutParams layoutParamsUiqyzsp = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew11.addView(linearLayoutZwaqeaz9, layoutParamsUiqyzsp);
                        LinearLayout linearLayoutZwaqeaz10 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz10.setOrientation(1);
                        TextView textViewYsaclsr2 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_device);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr2, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr2);
                        TextView textViewOxoagud34 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_note), 11, zamkzqg.jbmzxye(mainActivity3), false);
                        textViewOxoagud34.setPadding(0, zamkzqg.qunltjs(mainActivity3, 4), 0, zamkzqg.qunltjs(mainActivity3, 5));
                        linearLayoutZwaqeaz10.addView(textViewOxoagud34);
                        TextView textViewHjlrtqw3 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw4 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw5 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw6 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw7 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw8 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_state, textViewHjlrtqw3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_model, textViewHjlrtqw4);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_product, textViewHjlrtqw5);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_android, textViewHjlrtqw6);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_sdk, textViewHjlrtqw7);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_serial, textViewHjlrtqw8);
                        TextView textViewYsaclsr3 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_actions);
                        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams32.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr3, layoutParams32);
                        final int i31 = 3;
                        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i31) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh6 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha15 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha15, R.drawable.ic_reboot, iNmpwovh6);
                        final int i32 = 4;
                        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i32) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh7 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha16 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_reboot_recovery), onClickListener2);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha16, R.drawable.ic_reboot, iNmpwovh7);
                        final int i33 = 5;
                        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i33) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh8 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha17 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener3);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha17, R.drawable.ic_unlock, iNmpwovh8);
                        TextView[] textViewArr2 = {textViewLclupha15, textViewLclupha16, textViewLclupha17};
                        int i34 = 0;
                        for (int i35 = 3; i34 < i35; i35 = 3) {
                            TextView textView5 = textViewArr2[i34];
                            LinearLayout.LayoutParams layoutParams33 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams33.topMargin = zamkzqg.qunltjs(mainActivity3, 7);
                            linearLayoutZwaqeaz10.addView(textView5, layoutParams33);
                            i34++;
                        }
                        LinearLayout.LayoutParams layoutParamsUiqyzsp2 = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp2.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz10, layoutParamsUiqyzsp2);
                        linearLayoutZwaqeaz10.setVisibility(8);
                        LinearLayout linearLayoutZwaqeaz11 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz11.setOrientation(1);
                        linearLayoutZwaqeaz11.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_device_info));
                        TextView textViewHjlrtqw9 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw10 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw11 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw12 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw13 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_product, textViewHjlrtqw9);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_serial, textViewHjlrtqw10);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_current_slot, textViewHjlrtqw11);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_unlocked, textViewHjlrtqw12);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_bootloader_version, textViewHjlrtqw13);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz11, zamkzqg.uiqyzsp(mainActivity3));
                        linearLayoutZwaqeaz11.setVisibility(8);
                        LinearLayout linearLayout6 = new LinearLayout(mainActivity3);
                        linearLayout6.setOrientation(1);
                        linearLayout6.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_fastboot_actions));
                        final int i36 = 6;
                        View.OnClickListener onClickListener4 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i36) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh9 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha18 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener4);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha18, R.drawable.ic_reboot, iNmpwovh9);
                        final int i37 = 7;
                        View.OnClickListener onClickListener5 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i37) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh10 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha19 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener5);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha19, R.drawable.ic_unlock, iNmpwovh10);
                        final int i38 = 8;
                        View.OnClickListener onClickListener6 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i38) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh11 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha20 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_fastbootd), onClickListener6);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha20, R.drawable.ic_partitions, iNmpwovh11);
                        TextView[] textViewArr3 = {textViewLclupha18, textViewLclupha19, textViewLclupha20};
                        int i39 = 0;
                        while (i39 < 3) {
                            TextView textView6 = textViewArr3[i39];
                            LinearLayout.LayoutParams layoutParams34 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams34.topMargin = zamkzqg.qunltjs(mainActivity3, 8);
                            linearLayout6.addView(textView6, layoutParams34);
                            i39++;
                            textViewArr3 = textViewArr3;
                        }
                        LinearLayout.LayoutParams layoutParams35 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams35.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayout6, layoutParams35);
                        linearLayout6.setVisibility(8);
                        linearLayoutXbdyiew10.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        linearLayoutXbdyiew11.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        mainActivity3.ltnesel = new jybecxv(scrollView5, textView, textViewHjlrtqw2, textViewOxoagud26, editText, textViewOxoagud28, scrollView7, textView3, linearLayoutZwaqeaz10, textViewHjlrtqw3, textViewHjlrtqw4, textViewHjlrtqw5, textViewHjlrtqw6, textViewHjlrtqw7, textViewHjlrtqw8, textViewHjlrtqw9, textViewHjlrtqw10, textViewHjlrtqw11, textViewHjlrtqw12, textViewHjlrtqw13, linearLayoutZwaqeaz11, linearLayout6);
                        ccuulnt ccuulntVar = mainActivity3.suqlntg;
                        String string2 = mainActivity3.getString(R.string.android_tools_terminal_banner);
                        synchronized (ccuulntVar) {
                            try {
                                if (ccuulntVar.nmpwovh.length() == 0 && string2 != null && !string2.isEmpty()) {
                                    ccuulntVar.nmpwovh.append(string2.replace("\r\n", "\n").replace('\r', '\n'));
                                    ccuulntVar.ojyssqt();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        ccuulnt ccuulntVar2 = mainActivity3.suqlntg;
                        ccuulntVar2.qxvquar = true;
                        ccuulntVar2.nmpwovh(true);
                        mainActivity3.suqlntg.nmpwovh(true);
                        mainActivity3.gdkopre();
                        mainActivity3.kffvigz(scrollView5, "android_tools");
                        mainActivity3.jzcfpou();
                        return;
                    default:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar2.nmpwovh;
                        if (mainActivity4.lpkdqgx || mainActivity4.gzokllk) {
                            Toast.makeText(mainActivity4, R.string.error_busy, 0).show();
                            return;
                        } else {
                            new AlertDialog.Builder(mainActivity4).setTitle(R.string.power_menu_title).setItems(new String[]{mainActivity4.getString(R.string.power_normal_reboot), mainActivity4.getString(R.string.power_shutdown)}, new nsyqsfj(mainActivity4, 1)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
                            return;
                        }
                }
            }
        }), zamkzqg.exhiehf(nmpwovhVar, false));
        final int i18 = 4;
        linearLayoutXbdyiew4.addView(zamkzqg.eigllth(nmpwovhVar, R.string.menu_android_tools, R.string.menu_android_tools_desc, R.drawable.ic_android_tools, new View.OnClickListener() { // from class: x.axbavsj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i18) {
                    case 0:
                        gepzcpdVar2.nmpwovh.gzokllk();
                        return;
                    case 1:
                        gepzcpdVar2.nmpwovh.nhhacgu("xiaomi_authorize");
                        return;
                    case 2:
                        gepzcpdVar2.nmpwovh.nhhacgu("parts");
                        return;
                    case 3:
                        final MainActivity mainActivity2 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity2.getClass();
                        final wjugzfh wjugzfhVar = new wjugzfh(mainActivity2);
                        ScrollView scrollView4 = new ScrollView(mainActivity2);
                        scrollView4.setFillViewport(true);
                        scrollView4.setBackgroundColor(zamkzqg.buswjhz(mainActivity2));
                        LinearLayout linearLayoutXbdyiew5 = zamkzqg.xbdyiew(mainActivity2, 16);
                        scrollView4.addView(linearLayoutXbdyiew5);
                        int iNmpwovh2 = zamkzqg.nmpwovh(mainActivity2);
                        final int i19 = 0;
                        TextView textViewLclupha9 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_back), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i19) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha9, R.drawable.ic_back, iNmpwovh2);
                        textViewLclupha9.setGravity(8388627);
                        linearLayoutXbdyiew5.addView(textViewLclupha9);
                        TextView textViewYwhgqsi = zamkzqg.ywhgqsi(mainActivity2, mainActivity2.getString(R.string.bootloader_page_title));
                        zamkzqg.enxkjpu(mainActivity2, textViewYwhgqsi, R.drawable.ic_device_info, zamkzqg.nmpwovh(mainActivity2));
                        linearLayoutXbdyiew5.addView(textViewYwhgqsi);
                        linearLayoutXbdyiew5.addView(zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_page_subtitle), 12, zamkzqg.jbmzxye(mainActivity2), false));
                        LinearLayout linearLayoutLvtqoqa9 = zamkzqg.lvtqoqa(mainActivity2);
                        linearLayoutLvtqoqa9.setGravity(17);
                        linearLayoutLvtqoqa9.setPadding(zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4));
                        linearLayoutLvtqoqa9.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity2, 12)));
                        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity2, 48));
                        layoutParams23.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        final TextView textViewMslkofp = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_status);
                        final TextView textViewMslkofp2 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_slot);
                        final TextView textViewMslkofp3 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_security);
                        LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs = zamkzqg.qunltjs(mainActivity2, 2);
                        layoutParams24.setMargins(iQunltjs, 0, iQunltjs, 0);
                        linearLayoutLvtqoqa9.addView(textViewMslkofp, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp2, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp3, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutXbdyiew5.addView(linearLayoutLvtqoqa9, layoutParams23);
                        final LinearLayout linearLayoutXbdyiew6 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew7 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew8 = zamkzqg.xbdyiew(mainActivity2, 0);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew6);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew7);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew8);
                        final int i110 = 0;
                        textViewMslkofp.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i110) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i111 = 1;
                        textViewMslkofp2.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i111) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i112 = 2;
                        textViewMslkofp3.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i112) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                        LinearLayout linearLayoutZwaqeaz7 = zamkzqg.zwaqeaz(mainActivity2);
                        TextView textViewOxoagud20 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_reading), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud20, R.drawable.ic_refresh, zamkzqg.ohwxijw(mainActivity2));
                        linearLayoutZwaqeaz7.addView(textViewOxoagud20);
                        TextView textViewDkpobjg = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg2 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg3 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg4 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg5 = zamkzqg.dkpobjg(mainActivity2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_offset, textViewDkpobjg);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_slot_count, textViewDkpobjg2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_active, textViewDkpobjg3);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_suffix, textViewDkpobjg4);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_crc, textViewDkpobjg5);
                        linearLayoutXbdyiew6.addView(linearLayoutZwaqeaz7, zamkzqg.uiqyzsp(mainActivity2));
                        int iNmpwovh3 = zamkzqg.nmpwovh(mainActivity2);
                        final int i20 = 1;
                        TextView textViewLclupha10 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_refresh), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i20) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha10, R.drawable.ic_refresh, iNmpwovh3);
                        linearLayoutXbdyiew6.addView(textViewLclupha10, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        TextView textViewOxoagud21 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_slot_intro), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams25.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        linearLayoutXbdyiew7.addView(textViewOxoagud21, layoutParams25);
                        iilntfn iilntfnVarDplrlfq = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "A", wjugzfhVar);
                        iilntfn iilntfnVarDplrlfq2 = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "B", wjugzfhVar);
                        LinearLayout linearLayout5 = new LinearLayout(mainActivity2);
                        linearLayout5.setOrientation(1);
                        int dimensionPixelSize2 = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_padding);
                        linearLayout5.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
                        linearLayout5.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), zamkzqg.ohwxijw(mainActivity2), mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_radius)));
                        TextView textViewOxoagud22 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_warning), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud22, R.drawable.ic_warning, zamkzqg.ohwxijw(mainActivity2));
                        linearLayout5.addView(textViewOxoagud22);
                        TextView textViewOxoagud23 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_detail), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        textViewOxoagud23.setPadding(0, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top), 0, 0);
                        linearLayout5.addView(textViewOxoagud23);
                        linearLayoutXbdyiew8.addView(linearLayout5, zamkzqg.uiqyzsp(mainActivity2));
                        int iKggugdp2 = zamkzqg.kggugdp(mainActivity2);
                        final int i21 = 2;
                        TextView textViewLclupha11 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_unlock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i21) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha11, R.drawable.ic_unlock, iKggugdp2);
                        textViewLclupha11.setTextColor(zamkzqg.kggugdp(mainActivity2));
                        textViewLclupha11.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.ojyssqt(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_button_radius)));
                        linearLayoutXbdyiew8.addView(textViewLclupha11, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        int iOhwxijw = zamkzqg.ohwxijw(mainActivity2);
                        final int i22 = 3;
                        TextView textViewLclupha12 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_lock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i22) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha12, R.drawable.ic_lock, iOhwxijw);
                        LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                        layoutParams26.topMargin = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_page_action_gap);
                        linearLayoutXbdyiew8.addView(textViewLclupha12, layoutParams26);
                        linearLayoutXbdyiew5.addView(new View(mainActivity2), new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        iilntfn iilntfnVar = new iilntfn(scrollView4, mainActivity2, textViewOxoagud20, textViewDkpobjg, textViewDkpobjg2, textViewDkpobjg3, textViewDkpobjg4, textViewDkpobjg5, iilntfnVarDplrlfq, iilntfnVarDplrlfq2);
                        iilntfnVar.vivhedu();
                        mainActivity2.pmsrvoc = iilntfnVar;
                        mainActivity2.kffvigz(scrollView4, "bootloader_manager");
                        if (mainActivity2.nsyqsfj) {
                            mainActivity2.odhctch();
                            return;
                        } else {
                            mainActivity2.rrpfqyy = "";
                            mainActivity2.pmsrvoc.lthborb(mainActivity2.getString(mainActivity2.gzokllk ? R.string.error_da_connecting : R.string.error_wait_da_ready));
                            return;
                        }
                    case 4:
                        final MainActivity mainActivity3 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity3.getClass();
                        final wjugzfh wjugzfhVar2 = new wjugzfh(mainActivity3);
                        ScrollView scrollView5 = new ScrollView(mainActivity3);
                        scrollView5.setFillViewport(true);
                        scrollView5.setBackgroundColor(zamkzqg.buswjhz(mainActivity3));
                        LinearLayout linearLayoutXbdyiew9 = zamkzqg.xbdyiew(mainActivity3, 16);
                        scrollView5.addView(linearLayoutXbdyiew9);
                        int iNmpwovh4 = zamkzqg.nmpwovh(mainActivity3);
                        final int i23 = 0;
                        TextView textViewLclupha13 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_back), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i23) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha13, R.drawable.ic_back, iNmpwovh4);
                        textViewLclupha13.setGravity(8388627);
                        linearLayoutXbdyiew9.addView(textViewLclupha13);
                        TextView textViewYwhgqsi2 = zamkzqg.ywhgqsi(mainActivity3, mainActivity3.getString(R.string.android_tools_title));
                        zamkzqg.enxkjpu(mainActivity3, textViewYwhgqsi2, R.drawable.ic_usb, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutXbdyiew9.addView(textViewYwhgqsi2);
                        linearLayoutXbdyiew9.addView(zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_subtitle), 12, zamkzqg.jbmzxye(mainActivity3), false));
                        LinearLayout linearLayoutLvtqoqa10 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa10.setGravity(17);
                        linearLayoutLvtqoqa10.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4));
                        linearLayoutLvtqoqa10.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), mainActivity3.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity3, 12)));
                        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity3, 48));
                        layoutParams27.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        final TextView textViewOxoagud24 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_device), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud24.setGravity(17);
                        textViewOxoagud24.setClickable(true);
                        textViewOxoagud24.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud24);
                        TextView textViewOxoagud25 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_terminal), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud25.setGravity(17);
                        textViewOxoagud25.setClickable(true);
                        textViewOxoagud25.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud25);
                        LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs2 = zamkzqg.qunltjs(mainActivity3, 2);
                        layoutParams28.setMargins(iQunltjs2, 0, iQunltjs2, 0);
                        linearLayoutLvtqoqa10.addView(textViewOxoagud24, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutLvtqoqa10.addView(textViewOxoagud25, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutXbdyiew9.addView(linearLayoutLvtqoqa10, layoutParams27);
                        final LinearLayout linearLayoutXbdyiew10 = zamkzqg.xbdyiew(mainActivity3, 0);
                        final LinearLayout linearLayoutXbdyiew11 = zamkzqg.xbdyiew(mainActivity3, 0);
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew10, new LinearLayout.LayoutParams(-1, -2));
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew11, new LinearLayout.LayoutParams(-1, -2));
                        textViewOxoagud24.setOnClickListener(new bwvplah(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, 0));
                        zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, false);
                        LinearLayout linearLayoutZwaqeaz8 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz8.setOrientation(1);
                        TextView textViewOxoagud26 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_scanning), 13, zamkzqg.ohwxijw(mainActivity3), true);
                        zamkzqg.enxkjpu(mainActivity3, textViewOxoagud26, R.drawable.ic_usb, zamkzqg.ohwxijw(mainActivity3));
                        linearLayoutZwaqeaz8.addView(textViewOxoagud26);
                        TextView textViewHjlrtqw = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw2 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_transport, textViewHjlrtqw);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_usb_id, textViewHjlrtqw2);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz8, zamkzqg.uiqyzsp(mainActivity3));
                        int iNmpwovh5 = zamkzqg.nmpwovh(mainActivity3);
                        final int i24 = 9;
                        TextView textViewLclupha14 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_refresh), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i24) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha14, R.drawable.ic_refresh, iNmpwovh5);
                        linearLayoutXbdyiew10.addView(textViewLclupha14, new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        LinearLayout linearLayoutZwaqeaz9 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz9.setOrientation(1);
                        TextView textViewYsaclsr = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_terminal_title);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz9.addView(textViewYsaclsr);
                        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(mainActivity3);
                        horizontalScrollView.setHorizontalScrollBarEnabled(false);
                        horizontalScrollView.setFillViewport(false);
                        LinearLayout linearLayoutLvtqoqa11 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa11.setPadding(0, zamkzqg.qunltjs(mainActivity3, 10), 0, zamkzqg.qunltjs(mainActivity3, 10));
                        String[][] strArr = {new String[]{"adb devices", "adb devices"}, new String[]{"adb shell", "adb shell"}, new String[]{"getprop", "adb shell getprop"}, new String[]{"fastboot devices", "fastboot devices"}, new String[]{"getvar product", "fastboot getvar product"}};
                        int i25 = 0;
                        while (i25 < 5) {
                            String[] strArr2 = strArr[i25];
                            String str = strArr2[0];
                            String str2 = strArr2[1];
                            String[][] strArr3 = strArr;
                            TextView textViewOxoagud27 = zamkzqg.oxoagud(mainActivity3, str, 11, zamkzqg.zngzleo(mainActivity3), true);
                            textViewOxoagud27.setGravity(17);
                            textViewOxoagud27.setSingleLine(true);
                            textViewOxoagud27.setPadding(zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8));
                            textViewOxoagud27.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 18)));
                            textViewOxoagud27.setClickable(true);
                            textViewOxoagud27.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textViewOxoagud27);
                            textViewOxoagud27.setOnClickListener(new pzqxblc(wjugzfhVar2, str2, 0));
                            LinearLayout.LayoutParams layoutParams29 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams29.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 7));
                            linearLayoutLvtqoqa11.addView(textViewOxoagud27, layoutParams29);
                            i25++;
                            strArr = strArr3;
                            textViewHjlrtqw = textViewHjlrtqw;
                        }
                        TextView textView = textViewHjlrtqw;
                        horizontalScrollView.addView(linearLayoutLvtqoqa11, new FrameLayout.LayoutParams(-2, -2));
                        linearLayoutZwaqeaz9.addView(horizontalScrollView);
                        int iRgb = Color.rgb(30, 37, 40);
                        int iRgb2 = Color.rgb(232, 236, 233);
                        int iRgb3 = Color.rgb(72, 112, 76);
                        ScrollView scrollView6 = new ScrollView(mainActivity3);
                        scrollView6.setFillViewport(true);
                        scrollView6.setVerticalScrollBarEnabled(true);
                        scrollView6.setScrollbarFadingEnabled(true);
                        scrollView6.setBackground(zamkzqg.jvtqflj(mainActivity3, iRgb, iRgb3, zamkzqg.qunltjs(mainActivity3, 12)));
                        TextView textViewOxoagud28 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_terminal_banner), 12, iRgb2, false);
                        textViewOxoagud28.setTextColor(iRgb2);
                        Typeface typeface = Typeface.MONOSPACE;
                        textViewOxoagud28.setTypeface(typeface);
                        textViewOxoagud28.setTextIsSelectable(true);
                        textViewOxoagud28.setGravity(8388659);
                        textViewOxoagud28.setLineSpacing(0.0f, 1.08f);
                        textViewOxoagud28.setPadding(zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12));
                        scrollView6.addView(textViewOxoagud28, new FrameLayout.LayoutParams(-1, -2));
                        linearLayoutZwaqeaz9.addView(scrollView6, new LinearLayout.LayoutParams(-1, Math.max(zamkzqg.qunltjs(mainActivity3, 310), Math.min(zamkzqg.qunltjs(mainActivity3, 440), Math.round(mainActivity3.getResources().getDisplayMetrics().heightPixels * 0.43f)))));
                        LinearLayout linearLayoutLvtqoqa12 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa12.setGravity(16);
                        linearLayoutLvtqoqa12.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 2), zamkzqg.qunltjs(mainActivity3, 5), zamkzqg.qunltjs(mainActivity3, 2));
                        linearLayoutLvtqoqa12.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.czidoiw(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 10)));
                        LinearLayout.LayoutParams layoutParams30 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams30.topMargin = zamkzqg.qunltjs(mainActivity3, 9);
                        final EditText editText = new EditText(mainActivity3);
                        editText.setSingleLine(true);
                        editText.setInputType(524289);
                        editText.setTextColor(zamkzqg.zngzleo(mainActivity3));
                        editText.setHintTextColor(zamkzqg.jbmzxye(mainActivity3));
                        editText.setTypeface(typeface);
                        editText.setTextSize(13.0f);
                        editText.setHint(R.string.android_tools_terminal_hint_compact);
                        editText.setImeOptions(4);
                        editText.setBackgroundColor(mainActivity3.getColor(R.color.rynx_transparent));
                        editText.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8));
                        linearLayoutLvtqoqa12.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
                        TextView textViewOxoagud29 = zamkzqg.oxoagud(mainActivity3, "CTRL+C", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud29.setGravity(17);
                        textViewOxoagud29.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud29.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud29.setEnabled(false);
                        textViewOxoagud29.setAlpha(0.35f);
                        textViewOxoagud29.setClickable(true);
                        textViewOxoagud29.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud29);
                        final int i26 = 1;
                        textViewOxoagud29.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i26) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        TextView textViewOxoagud30 = zamkzqg.oxoagud(mainActivity3, "FILE", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud30.setGravity(17);
                        textViewOxoagud30.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud30.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud30.setClickable(true);
                        textViewOxoagud30.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud30);
                        final int i27 = 2;
                        textViewOxoagud30.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i27) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        LinearLayout.LayoutParams layoutParams31 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams31.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 6));
                        linearLayoutLvtqoqa12.addView(textViewOxoagud30, layoutParams31);
                        linearLayoutLvtqoqa12.addView(textViewOxoagud29);
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa12, layoutParams30);
                        LinearLayout linearLayoutLvtqoqa13 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa13.setGravity(17);
                        TextView textViewOxoagud31 = zamkzqg.oxoagud(mainActivity3, "↑ PREV", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud32 = zamkzqg.oxoagud(mainActivity3, "↓ NEXT", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud33 = zamkzqg.oxoagud(mainActivity3, "TAB", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        TextView[] textViewArr = {textViewOxoagud31, textViewOxoagud32, textViewOxoagud33};
                        int i28 = 0;
                        while (i28 < 3) {
                            TextView textView2 = textViewArr[i28];
                            textView2.setGravity(17);
                            textView2.setPadding(zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 6));
                            textView2.setClickable(true);
                            textView2.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textView2);
                            linearLayoutLvtqoqa13.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
                            i28++;
                            textViewOxoagud25 = textViewOxoagud25;
                            textViewArr = textViewArr;
                            textViewOxoagud29 = textViewOxoagud29;
                            scrollView6 = scrollView6;
                        }
                        TextView textView3 = textViewOxoagud29;
                        final TextView textView4 = textViewOxoagud25;
                        final ScrollView scrollView7 = scrollView6;
                        final int i29 = 0;
                        textViewOxoagud31.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i29) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        final int i30 = 1;
                        textViewOxoagud32.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i30) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        textViewOxoagud33.setOnClickListener(new nmpwovh(editText, 2));
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa13);
                        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: x.qunltjs
                            @Override // android.widget.TextView.OnEditorActionListener
                            public final boolean onEditorAction(TextView textView5, int i31, KeyEvent keyEvent) {
                                if (i31 != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
                                    return false;
                                }
                                EditText editText2 = editText;
                                String strTrim = editText2.getText() == null ? "" : editText2.getText().toString().trim();
                                if (!strTrim.isEmpty()) {
                                    editText2.setText("");
                                    wjugzfhVar2.vivhedu(strTrim);
                                }
                                return true;
                            }
                        });
                        editText.setOnKeyListener(new View.OnKeyListener() { // from class: x.cgcdpmq
                            @Override // android.view.View.OnKeyListener
                            public final boolean onKey(View view9, int i31, KeyEvent keyEvent) {
                                if (keyEvent.getAction() != 0) {
                                    return false;
                                }
                                wjugzfh wjugzfhVar3 = wjugzfhVar2;
                                EditText editText2 = editText;
                                if (i31 == 19) {
                                    String strOjyssqt = wjugzfhVar3.ojyssqt();
                                    if (strOjyssqt != null) {
                                        editText2.setText(strOjyssqt);
                                        editText2.setSelection(strOjyssqt.length());
                                    }
                                } else if (i31 == 20) {
                                    String strNmpwovh = wjugzfhVar3.nmpwovh();
                                    if (strNmpwovh != null) {
                                        editText2.setText(strNmpwovh);
                                        editText2.setSelection(strNmpwovh.length());
                                    }
                                } else {
                                    if (i31 != 61) {
                                        return false;
                                    }
                                    zamkzqg.qwgjehf(editText2);
                                }
                                return true;
                            }
                        });
                        textView4.setOnClickListener(new View.OnClickListener() { // from class: x.exhiehf
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textView4, linearLayoutXbdyiew10, linearLayoutXbdyiew11, true);
                                ScrollView scrollView8 = scrollView7;
                                scrollView8.post(new eigllth(scrollView8, 0));
                            }
                        });
                        LinearLayout.LayoutParams layoutParamsUiqyzsp = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew11.addView(linearLayoutZwaqeaz9, layoutParamsUiqyzsp);
                        LinearLayout linearLayoutZwaqeaz10 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz10.setOrientation(1);
                        TextView textViewYsaclsr2 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_device);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr2, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr2);
                        TextView textViewOxoagud34 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_note), 11, zamkzqg.jbmzxye(mainActivity3), false);
                        textViewOxoagud34.setPadding(0, zamkzqg.qunltjs(mainActivity3, 4), 0, zamkzqg.qunltjs(mainActivity3, 5));
                        linearLayoutZwaqeaz10.addView(textViewOxoagud34);
                        TextView textViewHjlrtqw3 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw4 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw5 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw6 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw7 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw8 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_state, textViewHjlrtqw3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_model, textViewHjlrtqw4);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_product, textViewHjlrtqw5);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_android, textViewHjlrtqw6);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_sdk, textViewHjlrtqw7);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_serial, textViewHjlrtqw8);
                        TextView textViewYsaclsr3 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_actions);
                        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams32.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr3, layoutParams32);
                        final int i31 = 3;
                        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i31) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh6 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha15 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha15, R.drawable.ic_reboot, iNmpwovh6);
                        final int i32 = 4;
                        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i32) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh7 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha16 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_reboot_recovery), onClickListener2);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha16, R.drawable.ic_reboot, iNmpwovh7);
                        final int i33 = 5;
                        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i33) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh8 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha17 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener3);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha17, R.drawable.ic_unlock, iNmpwovh8);
                        TextView[] textViewArr2 = {textViewLclupha15, textViewLclupha16, textViewLclupha17};
                        int i34 = 0;
                        for (int i35 = 3; i34 < i35; i35 = 3) {
                            TextView textView5 = textViewArr2[i34];
                            LinearLayout.LayoutParams layoutParams33 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams33.topMargin = zamkzqg.qunltjs(mainActivity3, 7);
                            linearLayoutZwaqeaz10.addView(textView5, layoutParams33);
                            i34++;
                        }
                        LinearLayout.LayoutParams layoutParamsUiqyzsp2 = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp2.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz10, layoutParamsUiqyzsp2);
                        linearLayoutZwaqeaz10.setVisibility(8);
                        LinearLayout linearLayoutZwaqeaz11 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz11.setOrientation(1);
                        linearLayoutZwaqeaz11.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_device_info));
                        TextView textViewHjlrtqw9 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw10 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw11 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw12 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw13 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_product, textViewHjlrtqw9);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_serial, textViewHjlrtqw10);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_current_slot, textViewHjlrtqw11);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_unlocked, textViewHjlrtqw12);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_bootloader_version, textViewHjlrtqw13);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz11, zamkzqg.uiqyzsp(mainActivity3));
                        linearLayoutZwaqeaz11.setVisibility(8);
                        LinearLayout linearLayout6 = new LinearLayout(mainActivity3);
                        linearLayout6.setOrientation(1);
                        linearLayout6.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_fastboot_actions));
                        final int i36 = 6;
                        View.OnClickListener onClickListener4 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i36) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh9 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha18 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener4);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha18, R.drawable.ic_reboot, iNmpwovh9);
                        final int i37 = 7;
                        View.OnClickListener onClickListener5 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i37) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh10 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha19 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener5);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha19, R.drawable.ic_unlock, iNmpwovh10);
                        final int i38 = 8;
                        View.OnClickListener onClickListener6 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i38) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh11 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha20 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_fastbootd), onClickListener6);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha20, R.drawable.ic_partitions, iNmpwovh11);
                        TextView[] textViewArr3 = {textViewLclupha18, textViewLclupha19, textViewLclupha20};
                        int i39 = 0;
                        while (i39 < 3) {
                            TextView textView6 = textViewArr3[i39];
                            LinearLayout.LayoutParams layoutParams34 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams34.topMargin = zamkzqg.qunltjs(mainActivity3, 8);
                            linearLayout6.addView(textView6, layoutParams34);
                            i39++;
                            textViewArr3 = textViewArr3;
                        }
                        LinearLayout.LayoutParams layoutParams35 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams35.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayout6, layoutParams35);
                        linearLayout6.setVisibility(8);
                        linearLayoutXbdyiew10.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        linearLayoutXbdyiew11.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        mainActivity3.ltnesel = new jybecxv(scrollView5, textView, textViewHjlrtqw2, textViewOxoagud26, editText, textViewOxoagud28, scrollView7, textView3, linearLayoutZwaqeaz10, textViewHjlrtqw3, textViewHjlrtqw4, textViewHjlrtqw5, textViewHjlrtqw6, textViewHjlrtqw7, textViewHjlrtqw8, textViewHjlrtqw9, textViewHjlrtqw10, textViewHjlrtqw11, textViewHjlrtqw12, textViewHjlrtqw13, linearLayoutZwaqeaz11, linearLayout6);
                        ccuulnt ccuulntVar = mainActivity3.suqlntg;
                        String string2 = mainActivity3.getString(R.string.android_tools_terminal_banner);
                        synchronized (ccuulntVar) {
                            try {
                                if (ccuulntVar.nmpwovh.length() == 0 && string2 != null && !string2.isEmpty()) {
                                    ccuulntVar.nmpwovh.append(string2.replace("\r\n", "\n").replace('\r', '\n'));
                                    ccuulntVar.ojyssqt();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        ccuulnt ccuulntVar2 = mainActivity3.suqlntg;
                        ccuulntVar2.qxvquar = true;
                        ccuulntVar2.nmpwovh(true);
                        mainActivity3.suqlntg.nmpwovh(true);
                        mainActivity3.gdkopre();
                        mainActivity3.kffvigz(scrollView5, "android_tools");
                        mainActivity3.jzcfpou();
                        return;
                    default:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar2.nmpwovh;
                        if (mainActivity4.lpkdqgx || mainActivity4.gzokllk) {
                            Toast.makeText(mainActivity4, R.string.error_busy, 0).show();
                            return;
                        } else {
                            new AlertDialog.Builder(mainActivity4).setTitle(R.string.power_menu_title).setItems(new String[]{mainActivity4.getString(R.string.power_normal_reboot), mainActivity4.getString(R.string.power_shutdown)}, new nsyqsfj(mainActivity4, 1)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
                            return;
                        }
                }
            }
        }), zamkzqg.exhiehf(nmpwovhVar, false));
        final int i19 = 5;
        LinearLayout linearLayoutEigllth = zamkzqg.eigllth(nmpwovhVar, R.string.menu_power_manager, R.string.menu_power_manager_desc, R.drawable.ic_reboot, new View.OnClickListener() { // from class: x.axbavsj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i19) {
                    case 0:
                        gepzcpdVar2.nmpwovh.gzokllk();
                        return;
                    case 1:
                        gepzcpdVar2.nmpwovh.nhhacgu("xiaomi_authorize");
                        return;
                    case 2:
                        gepzcpdVar2.nmpwovh.nhhacgu("parts");
                        return;
                    case 3:
                        final MainActivity mainActivity2 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity2.getClass();
                        final wjugzfh wjugzfhVar = new wjugzfh(mainActivity2);
                        ScrollView scrollView4 = new ScrollView(mainActivity2);
                        scrollView4.setFillViewport(true);
                        scrollView4.setBackgroundColor(zamkzqg.buswjhz(mainActivity2));
                        LinearLayout linearLayoutXbdyiew5 = zamkzqg.xbdyiew(mainActivity2, 16);
                        scrollView4.addView(linearLayoutXbdyiew5);
                        int iNmpwovh2 = zamkzqg.nmpwovh(mainActivity2);
                        final int i110 = 0;
                        TextView textViewLclupha9 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_back), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i110) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha9, R.drawable.ic_back, iNmpwovh2);
                        textViewLclupha9.setGravity(8388627);
                        linearLayoutXbdyiew5.addView(textViewLclupha9);
                        TextView textViewYwhgqsi = zamkzqg.ywhgqsi(mainActivity2, mainActivity2.getString(R.string.bootloader_page_title));
                        zamkzqg.enxkjpu(mainActivity2, textViewYwhgqsi, R.drawable.ic_device_info, zamkzqg.nmpwovh(mainActivity2));
                        linearLayoutXbdyiew5.addView(textViewYwhgqsi);
                        linearLayoutXbdyiew5.addView(zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_page_subtitle), 12, zamkzqg.jbmzxye(mainActivity2), false));
                        LinearLayout linearLayoutLvtqoqa9 = zamkzqg.lvtqoqa(mainActivity2);
                        linearLayoutLvtqoqa9.setGravity(17);
                        linearLayoutLvtqoqa9.setPadding(zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4), zamkzqg.qunltjs(mainActivity2, 4));
                        linearLayoutLvtqoqa9.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity2, 12)));
                        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity2, 48));
                        layoutParams23.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        final TextView textViewMslkofp = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_status);
                        final TextView textViewMslkofp2 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_slot);
                        final TextView textViewMslkofp3 = zamkzqg.mslkofp(mainActivity2, R.string.bootloader_tab_security);
                        LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs = zamkzqg.qunltjs(mainActivity2, 2);
                        layoutParams24.setMargins(iQunltjs, 0, iQunltjs, 0);
                        linearLayoutLvtqoqa9.addView(textViewMslkofp, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp2, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutLvtqoqa9.addView(textViewMslkofp3, new LinearLayout.LayoutParams(layoutParams24));
                        linearLayoutXbdyiew5.addView(linearLayoutLvtqoqa9, layoutParams23);
                        final LinearLayout linearLayoutXbdyiew6 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew7 = zamkzqg.xbdyiew(mainActivity2, 0);
                        final LinearLayout linearLayoutXbdyiew8 = zamkzqg.xbdyiew(mainActivity2, 0);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew6);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew7);
                        linearLayoutXbdyiew5.addView(linearLayoutXbdyiew8);
                        final int i111 = 0;
                        textViewMslkofp.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i111) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i112 = 1;
                        textViewMslkofp2.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i112) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        final int i113 = 2;
                        textViewMslkofp3.setOnClickListener(new View.OnClickListener() { // from class: x.zegwdrn
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i113) {
                                    case 0:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                                        break;
                                    case 1:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 1);
                                        break;
                                    default:
                                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 2);
                                        break;
                                }
                            }
                        });
                        zamkzqg.npkgpdo(mainActivity2, textViewMslkofp, textViewMslkofp2, textViewMslkofp3, linearLayoutXbdyiew6, linearLayoutXbdyiew7, linearLayoutXbdyiew8, 0);
                        LinearLayout linearLayoutZwaqeaz7 = zamkzqg.zwaqeaz(mainActivity2);
                        TextView textViewOxoagud20 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_reading), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud20, R.drawable.ic_refresh, zamkzqg.ohwxijw(mainActivity2));
                        linearLayoutZwaqeaz7.addView(textViewOxoagud20);
                        TextView textViewDkpobjg = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg2 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg3 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg4 = zamkzqg.dkpobjg(mainActivity2);
                        TextView textViewDkpobjg5 = zamkzqg.dkpobjg(mainActivity2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_offset, textViewDkpobjg);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_slot_count, textViewDkpobjg2);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_active, textViewDkpobjg3);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_suffix, textViewDkpobjg4);
                        zamkzqg.wqrnifx(mainActivity2, linearLayoutZwaqeaz7, R.string.bootloader_bootctrl_crc, textViewDkpobjg5);
                        linearLayoutXbdyiew6.addView(linearLayoutZwaqeaz7, zamkzqg.uiqyzsp(mainActivity2));
                        int iNmpwovh3 = zamkzqg.nmpwovh(mainActivity2);
                        final int i20 = 1;
                        TextView textViewLclupha10 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_bootctrl_refresh), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i20) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha10, R.drawable.ic_refresh, iNmpwovh3);
                        linearLayoutXbdyiew6.addView(textViewLclupha10, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        TextView textViewOxoagud21 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_slot_intro), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams25.topMargin = zamkzqg.qunltjs(mainActivity2, 12);
                        linearLayoutXbdyiew7.addView(textViewOxoagud21, layoutParams25);
                        iilntfn iilntfnVarDplrlfq = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "A", wjugzfhVar);
                        iilntfn iilntfnVarDplrlfq2 = zamkzqg.dplrlfq(mainActivity2, linearLayoutXbdyiew7, "B", wjugzfhVar);
                        LinearLayout linearLayout5 = new LinearLayout(mainActivity2);
                        linearLayout5.setOrientation(1);
                        int dimensionPixelSize2 = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_padding);
                        linearLayout5.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
                        linearLayout5.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.atntgcp(mainActivity2), zamkzqg.ohwxijw(mainActivity2), mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_warning_radius)));
                        TextView textViewOxoagud22 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_warning), 13, zamkzqg.ohwxijw(mainActivity2), true);
                        zamkzqg.enxkjpu(mainActivity2, textViewOxoagud22, R.drawable.ic_warning, zamkzqg.ohwxijw(mainActivity2));
                        linearLayout5.addView(textViewOxoagud22);
                        TextView textViewOxoagud23 = zamkzqg.oxoagud(mainActivity2, mainActivity2.getString(R.string.bootloader_support_detail), 11, zamkzqg.jbmzxye(mainActivity2), false);
                        textViewOxoagud23.setPadding(0, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top), 0, 0);
                        linearLayout5.addView(textViewOxoagud23);
                        linearLayoutXbdyiew8.addView(linearLayout5, zamkzqg.uiqyzsp(mainActivity2));
                        int iKggugdp2 = zamkzqg.kggugdp(mainActivity2);
                        final int i21 = 2;
                        TextView textViewLclupha11 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_unlock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i21) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha11, R.drawable.ic_unlock, iKggugdp2);
                        textViewLclupha11.setTextColor(zamkzqg.kggugdp(mainActivity2));
                        textViewLclupha11.setBackground(zamkzqg.jvtqflj(mainActivity2, zamkzqg.ojyssqt(mainActivity2), mainActivity2.getColor(R.color.rynx_transparent), mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_button_radius)));
                        linearLayoutXbdyiew8.addView(textViewLclupha11, new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        int iOhwxijw = zamkzqg.ohwxijw(mainActivity2);
                        final int i22 = 3;
                        TextView textViewLclupha12 = zamkzqg.lclupha(mainActivity2, mainActivity2.getString(R.string.bootloader_lock_full), new View.OnClickListener() { // from class: x.saksmfq
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i22) {
                                    case 0:
                                        wjugzfhVar.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        wjugzfhVar.nmpwovh.odhctch();
                                        break;
                                    case 2:
                                        wjugzfhVar.nmpwovh.ghkjjru(true);
                                        break;
                                    default:
                                        wjugzfhVar.nmpwovh.ghkjjru(false);
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity2, textViewLclupha12, R.drawable.ic_lock, iOhwxijw);
                        LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                        layoutParams26.topMargin = mainActivity2.getResources().getDimensionPixelSize(R.dimen.bootloader_page_action_gap);
                        linearLayoutXbdyiew8.addView(textViewLclupha12, layoutParams26);
                        linearLayoutXbdyiew5.addView(new View(mainActivity2), new LinearLayout.LayoutParams(-1, mainActivity2.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        iilntfn iilntfnVar = new iilntfn(scrollView4, mainActivity2, textViewOxoagud20, textViewDkpobjg, textViewDkpobjg2, textViewDkpobjg3, textViewDkpobjg4, textViewDkpobjg5, iilntfnVarDplrlfq, iilntfnVarDplrlfq2);
                        iilntfnVar.vivhedu();
                        mainActivity2.pmsrvoc = iilntfnVar;
                        mainActivity2.kffvigz(scrollView4, "bootloader_manager");
                        if (mainActivity2.nsyqsfj) {
                            mainActivity2.odhctch();
                            return;
                        } else {
                            mainActivity2.rrpfqyy = "";
                            mainActivity2.pmsrvoc.lthborb(mainActivity2.getString(mainActivity2.gzokllk ? R.string.error_da_connecting : R.string.error_wait_da_ready));
                            return;
                        }
                    case 4:
                        final MainActivity mainActivity3 = (MainActivity) gepzcpdVar2.nmpwovh;
                        mainActivity3.getClass();
                        final wjugzfh wjugzfhVar2 = new wjugzfh(mainActivity3);
                        ScrollView scrollView5 = new ScrollView(mainActivity3);
                        scrollView5.setFillViewport(true);
                        scrollView5.setBackgroundColor(zamkzqg.buswjhz(mainActivity3));
                        LinearLayout linearLayoutXbdyiew9 = zamkzqg.xbdyiew(mainActivity3, 16);
                        scrollView5.addView(linearLayoutXbdyiew9);
                        int iNmpwovh4 = zamkzqg.nmpwovh(mainActivity3);
                        final int i23 = 0;
                        TextView textViewLclupha13 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_back), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i23) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha13, R.drawable.ic_back, iNmpwovh4);
                        textViewLclupha13.setGravity(8388627);
                        linearLayoutXbdyiew9.addView(textViewLclupha13);
                        TextView textViewYwhgqsi2 = zamkzqg.ywhgqsi(mainActivity3, mainActivity3.getString(R.string.android_tools_title));
                        zamkzqg.enxkjpu(mainActivity3, textViewYwhgqsi2, R.drawable.ic_usb, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutXbdyiew9.addView(textViewYwhgqsi2);
                        linearLayoutXbdyiew9.addView(zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_subtitle), 12, zamkzqg.jbmzxye(mainActivity3), false));
                        LinearLayout linearLayoutLvtqoqa10 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa10.setGravity(17);
                        linearLayoutLvtqoqa10.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 4));
                        linearLayoutLvtqoqa10.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), mainActivity3.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(mainActivity3, 12)));
                        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-1, zamkzqg.qunltjs(mainActivity3, 48));
                        layoutParams27.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        final TextView textViewOxoagud24 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_device), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud24.setGravity(17);
                        textViewOxoagud24.setClickable(true);
                        textViewOxoagud24.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud24);
                        TextView textViewOxoagud25 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_tab_terminal), 12, zamkzqg.jbmzxye(mainActivity3), true);
                        textViewOxoagud25.setGravity(17);
                        textViewOxoagud25.setClickable(true);
                        textViewOxoagud25.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud25);
                        LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(0, -1, 1.0f);
                        int iQunltjs2 = zamkzqg.qunltjs(mainActivity3, 2);
                        layoutParams28.setMargins(iQunltjs2, 0, iQunltjs2, 0);
                        linearLayoutLvtqoqa10.addView(textViewOxoagud24, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutLvtqoqa10.addView(textViewOxoagud25, new LinearLayout.LayoutParams(layoutParams28));
                        linearLayoutXbdyiew9.addView(linearLayoutLvtqoqa10, layoutParams27);
                        final LinearLayout linearLayoutXbdyiew10 = zamkzqg.xbdyiew(mainActivity3, 0);
                        final LinearLayout linearLayoutXbdyiew11 = zamkzqg.xbdyiew(mainActivity3, 0);
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew10, new LinearLayout.LayoutParams(-1, -2));
                        linearLayoutXbdyiew9.addView(linearLayoutXbdyiew11, new LinearLayout.LayoutParams(-1, -2));
                        textViewOxoagud24.setOnClickListener(new bwvplah(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, 0));
                        zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textViewOxoagud25, linearLayoutXbdyiew10, linearLayoutXbdyiew11, false);
                        LinearLayout linearLayoutZwaqeaz8 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz8.setOrientation(1);
                        TextView textViewOxoagud26 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_scanning), 13, zamkzqg.ohwxijw(mainActivity3), true);
                        zamkzqg.enxkjpu(mainActivity3, textViewOxoagud26, R.drawable.ic_usb, zamkzqg.ohwxijw(mainActivity3));
                        linearLayoutZwaqeaz8.addView(textViewOxoagud26);
                        TextView textViewHjlrtqw = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw2 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_transport, textViewHjlrtqw);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz8, R.string.android_tools_usb_id, textViewHjlrtqw2);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz8, zamkzqg.uiqyzsp(mainActivity3));
                        int iNmpwovh5 = zamkzqg.nmpwovh(mainActivity3);
                        final int i24 = 9;
                        TextView textViewLclupha14 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_refresh), new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i24) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha14, R.drawable.ic_refresh, iNmpwovh5);
                        linearLayoutXbdyiew10.addView(textViewLclupha14, new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height)));
                        LinearLayout linearLayoutZwaqeaz9 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz9.setOrientation(1);
                        TextView textViewYsaclsr = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_terminal_title);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz9.addView(textViewYsaclsr);
                        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(mainActivity3);
                        horizontalScrollView.setHorizontalScrollBarEnabled(false);
                        horizontalScrollView.setFillViewport(false);
                        LinearLayout linearLayoutLvtqoqa11 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa11.setPadding(0, zamkzqg.qunltjs(mainActivity3, 10), 0, zamkzqg.qunltjs(mainActivity3, 10));
                        String[][] strArr = {new String[]{"adb devices", "adb devices"}, new String[]{"adb shell", "adb shell"}, new String[]{"getprop", "adb shell getprop"}, new String[]{"fastboot devices", "fastboot devices"}, new String[]{"getvar product", "fastboot getvar product"}};
                        int i25 = 0;
                        while (i25 < 5) {
                            String[] strArr2 = strArr[i25];
                            String str = strArr2[0];
                            String str2 = strArr2[1];
                            String[][] strArr3 = strArr;
                            TextView textViewOxoagud27 = zamkzqg.oxoagud(mainActivity3, str, 11, zamkzqg.zngzleo(mainActivity3), true);
                            textViewOxoagud27.setGravity(17);
                            textViewOxoagud27.setSingleLine(true);
                            textViewOxoagud27.setPadding(zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 8));
                            textViewOxoagud27.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.atntgcp(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 18)));
                            textViewOxoagud27.setClickable(true);
                            textViewOxoagud27.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textViewOxoagud27);
                            textViewOxoagud27.setOnClickListener(new pzqxblc(wjugzfhVar2, str2, 0));
                            LinearLayout.LayoutParams layoutParams29 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams29.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 7));
                            linearLayoutLvtqoqa11.addView(textViewOxoagud27, layoutParams29);
                            i25++;
                            strArr = strArr3;
                            textViewHjlrtqw = textViewHjlrtqw;
                        }
                        TextView textView = textViewHjlrtqw;
                        horizontalScrollView.addView(linearLayoutLvtqoqa11, new FrameLayout.LayoutParams(-2, -2));
                        linearLayoutZwaqeaz9.addView(horizontalScrollView);
                        int iRgb = Color.rgb(30, 37, 40);
                        int iRgb2 = Color.rgb(232, 236, 233);
                        int iRgb3 = Color.rgb(72, 112, 76);
                        ScrollView scrollView6 = new ScrollView(mainActivity3);
                        scrollView6.setFillViewport(true);
                        scrollView6.setVerticalScrollBarEnabled(true);
                        scrollView6.setScrollbarFadingEnabled(true);
                        scrollView6.setBackground(zamkzqg.jvtqflj(mainActivity3, iRgb, iRgb3, zamkzqg.qunltjs(mainActivity3, 12)));
                        TextView textViewOxoagud28 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_terminal_banner), 12, iRgb2, false);
                        textViewOxoagud28.setTextColor(iRgb2);
                        Typeface typeface = Typeface.MONOSPACE;
                        textViewOxoagud28.setTypeface(typeface);
                        textViewOxoagud28.setTextIsSelectable(true);
                        textViewOxoagud28.setGravity(8388659);
                        textViewOxoagud28.setLineSpacing(0.0f, 1.08f);
                        textViewOxoagud28.setPadding(zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12), zamkzqg.qunltjs(mainActivity3, 13), zamkzqg.qunltjs(mainActivity3, 12));
                        scrollView6.addView(textViewOxoagud28, new FrameLayout.LayoutParams(-1, -2));
                        linearLayoutZwaqeaz9.addView(scrollView6, new LinearLayout.LayoutParams(-1, Math.max(zamkzqg.qunltjs(mainActivity3, 310), Math.min(zamkzqg.qunltjs(mainActivity3, 440), Math.round(mainActivity3.getResources().getDisplayMetrics().heightPixels * 0.43f)))));
                        LinearLayout linearLayoutLvtqoqa12 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa12.setGravity(16);
                        linearLayoutLvtqoqa12.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 2), zamkzqg.qunltjs(mainActivity3, 5), zamkzqg.qunltjs(mainActivity3, 2));
                        linearLayoutLvtqoqa12.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.czidoiw(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 10)));
                        LinearLayout.LayoutParams layoutParams30 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams30.topMargin = zamkzqg.qunltjs(mainActivity3, 9);
                        final EditText editText = new EditText(mainActivity3);
                        editText.setSingleLine(true);
                        editText.setInputType(524289);
                        editText.setTextColor(zamkzqg.zngzleo(mainActivity3));
                        editText.setHintTextColor(zamkzqg.jbmzxye(mainActivity3));
                        editText.setTypeface(typeface);
                        editText.setTextSize(13.0f);
                        editText.setHint(R.string.android_tools_terminal_hint_compact);
                        editText.setImeOptions(4);
                        editText.setBackgroundColor(mainActivity3.getColor(R.color.rynx_transparent));
                        editText.setPadding(zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 4), zamkzqg.qunltjs(mainActivity3, 8));
                        linearLayoutLvtqoqa12.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
                        TextView textViewOxoagud29 = zamkzqg.oxoagud(mainActivity3, "CTRL+C", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud29.setGravity(17);
                        textViewOxoagud29.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud29.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud29.setEnabled(false);
                        textViewOxoagud29.setAlpha(0.35f);
                        textViewOxoagud29.setClickable(true);
                        textViewOxoagud29.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud29);
                        final int i26 = 1;
                        textViewOxoagud29.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i26) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        TextView textViewOxoagud30 = zamkzqg.oxoagud(mainActivity3, "FILE", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        textViewOxoagud30.setGravity(17);
                        textViewOxoagud30.setPadding(zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8));
                        textViewOxoagud30.setBackground(zamkzqg.jvtqflj(mainActivity3, zamkzqg.ojyssqt(mainActivity3), zamkzqg.qyeibyo(mainActivity3), zamkzqg.qunltjs(mainActivity3, 9)));
                        textViewOxoagud30.setClickable(true);
                        textViewOxoagud30.setFocusable(true);
                        zamkzqg.utmeivs(mainActivity3, textViewOxoagud30);
                        final int i27 = 2;
                        textViewOxoagud30.setOnClickListener(new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i27) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        });
                        LinearLayout.LayoutParams layoutParams31 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams31.setMarginEnd(zamkzqg.qunltjs(mainActivity3, 6));
                        linearLayoutLvtqoqa12.addView(textViewOxoagud30, layoutParams31);
                        linearLayoutLvtqoqa12.addView(textViewOxoagud29);
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa12, layoutParams30);
                        LinearLayout linearLayoutLvtqoqa13 = zamkzqg.lvtqoqa(mainActivity3);
                        linearLayoutLvtqoqa13.setGravity(17);
                        TextView textViewOxoagud31 = zamkzqg.oxoagud(mainActivity3, "↑ PREV", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud32 = zamkzqg.oxoagud(mainActivity3, "↓ NEXT", 10, zamkzqg.jbmzxye(mainActivity3), true);
                        TextView textViewOxoagud33 = zamkzqg.oxoagud(mainActivity3, "TAB", 10, zamkzqg.nmpwovh(mainActivity3), true);
                        TextView[] textViewArr = {textViewOxoagud31, textViewOxoagud32, textViewOxoagud33};
                        int i28 = 0;
                        while (i28 < 3) {
                            TextView textView2 = textViewArr[i28];
                            textView2.setGravity(17);
                            textView2.setPadding(zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 10), zamkzqg.qunltjs(mainActivity3, 8), zamkzqg.qunltjs(mainActivity3, 6));
                            textView2.setClickable(true);
                            textView2.setFocusable(true);
                            zamkzqg.utmeivs(mainActivity3, textView2);
                            linearLayoutLvtqoqa13.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
                            i28++;
                            textViewOxoagud25 = textViewOxoagud25;
                            textViewArr = textViewArr;
                            textViewOxoagud29 = textViewOxoagud29;
                            scrollView6 = scrollView6;
                        }
                        TextView textView3 = textViewOxoagud29;
                        final TextView textView4 = textViewOxoagud25;
                        final ScrollView scrollView7 = scrollView6;
                        final int i29 = 0;
                        textViewOxoagud31.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i29) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        final int i30 = 1;
                        textViewOxoagud32.setOnClickListener(new View.OnClickListener() { // from class: x.ivvkvsj
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i30) {
                                    case 0:
                                        String strOjyssqt = wjugzfhVar2.ojyssqt();
                                        if (strOjyssqt != null) {
                                            EditText editText2 = editText;
                                            editText2.setText(strOjyssqt);
                                            editText2.setSelection(strOjyssqt.length());
                                        }
                                        break;
                                    default:
                                        String strNmpwovh = wjugzfhVar2.nmpwovh();
                                        if (strNmpwovh != null) {
                                            EditText editText3 = editText;
                                            editText3.setText(strNmpwovh);
                                            editText3.setSelection(strNmpwovh.length());
                                        }
                                        break;
                                }
                            }
                        });
                        textViewOxoagud33.setOnClickListener(new nmpwovh(editText, 2));
                        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa13);
                        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: x.qunltjs
                            @Override // android.widget.TextView.OnEditorActionListener
                            public final boolean onEditorAction(TextView textView5, int i31, KeyEvent keyEvent) {
                                if (i31 != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
                                    return false;
                                }
                                EditText editText2 = editText;
                                String strTrim = editText2.getText() == null ? "" : editText2.getText().toString().trim();
                                if (!strTrim.isEmpty()) {
                                    editText2.setText("");
                                    wjugzfhVar2.vivhedu(strTrim);
                                }
                                return true;
                            }
                        });
                        editText.setOnKeyListener(new View.OnKeyListener() { // from class: x.cgcdpmq
                            @Override // android.view.View.OnKeyListener
                            public final boolean onKey(View view9, int i31, KeyEvent keyEvent) {
                                if (keyEvent.getAction() != 0) {
                                    return false;
                                }
                                wjugzfh wjugzfhVar3 = wjugzfhVar2;
                                EditText editText2 = editText;
                                if (i31 == 19) {
                                    String strOjyssqt = wjugzfhVar3.ojyssqt();
                                    if (strOjyssqt != null) {
                                        editText2.setText(strOjyssqt);
                                        editText2.setSelection(strOjyssqt.length());
                                    }
                                } else if (i31 == 20) {
                                    String strNmpwovh = wjugzfhVar3.nmpwovh();
                                    if (strNmpwovh != null) {
                                        editText2.setText(strNmpwovh);
                                        editText2.setSelection(strNmpwovh.length());
                                    }
                                } else {
                                    if (i31 != 61) {
                                        return false;
                                    }
                                    zamkzqg.qwgjehf(editText2);
                                }
                                return true;
                            }
                        });
                        textView4.setOnClickListener(new View.OnClickListener() { // from class: x.exhiehf
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                zamkzqg.cnctlxz(mainActivity3, textViewOxoagud24, textView4, linearLayoutXbdyiew10, linearLayoutXbdyiew11, true);
                                ScrollView scrollView8 = scrollView7;
                                scrollView8.post(new eigllth(scrollView8, 0));
                            }
                        });
                        LinearLayout.LayoutParams layoutParamsUiqyzsp = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew11.addView(linearLayoutZwaqeaz9, layoutParamsUiqyzsp);
                        LinearLayout linearLayoutZwaqeaz10 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz10.setOrientation(1);
                        TextView textViewYsaclsr2 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_device);
                        zamkzqg.enxkjpu(mainActivity3, textViewYsaclsr2, R.drawable.ic_terminal, zamkzqg.nmpwovh(mainActivity3));
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr2);
                        TextView textViewOxoagud34 = zamkzqg.oxoagud(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_note), 11, zamkzqg.jbmzxye(mainActivity3), false);
                        textViewOxoagud34.setPadding(0, zamkzqg.qunltjs(mainActivity3, 4), 0, zamkzqg.qunltjs(mainActivity3, 5));
                        linearLayoutZwaqeaz10.addView(textViewOxoagud34);
                        TextView textViewHjlrtqw3 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw4 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw5 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw6 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw7 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw8 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_state, textViewHjlrtqw3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_model, textViewHjlrtqw4);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_product, textViewHjlrtqw5);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_android, textViewHjlrtqw6);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_adb_sdk, textViewHjlrtqw7);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz10, R.string.android_tools_serial, textViewHjlrtqw8);
                        TextView textViewYsaclsr3 = zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_adb_actions);
                        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams32.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutZwaqeaz10.addView(textViewYsaclsr3, layoutParams32);
                        final int i31 = 3;
                        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i31) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh6 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha15 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha15, R.drawable.ic_reboot, iNmpwovh6);
                        final int i32 = 4;
                        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i32) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh7 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha16 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_adb_reboot_recovery), onClickListener2);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha16, R.drawable.ic_reboot, iNmpwovh7);
                        final int i33 = 5;
                        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i33) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh8 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha17 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener3);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha17, R.drawable.ic_unlock, iNmpwovh8);
                        TextView[] textViewArr2 = {textViewLclupha15, textViewLclupha16, textViewLclupha17};
                        int i34 = 0;
                        for (int i35 = 3; i34 < i35; i35 = 3) {
                            TextView textView5 = textViewArr2[i34];
                            LinearLayout.LayoutParams layoutParams33 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams33.topMargin = zamkzqg.qunltjs(mainActivity3, 7);
                            linearLayoutZwaqeaz10.addView(textView5, layoutParams33);
                            i34++;
                        }
                        LinearLayout.LayoutParams layoutParamsUiqyzsp2 = zamkzqg.uiqyzsp(mainActivity3);
                        layoutParamsUiqyzsp2.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz10, layoutParamsUiqyzsp2);
                        linearLayoutZwaqeaz10.setVisibility(8);
                        LinearLayout linearLayoutZwaqeaz11 = zamkzqg.zwaqeaz(mainActivity3);
                        linearLayoutZwaqeaz11.setOrientation(1);
                        linearLayoutZwaqeaz11.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_device_info));
                        TextView textViewHjlrtqw9 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw10 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw11 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw12 = zamkzqg.hjlrtqw(mainActivity3);
                        TextView textViewHjlrtqw13 = zamkzqg.hjlrtqw(mainActivity3);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_product, textViewHjlrtqw9);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_serial, textViewHjlrtqw10);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_current_slot, textViewHjlrtqw11);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_unlocked, textViewHjlrtqw12);
                        zamkzqg.dytyqos(mainActivity3, linearLayoutZwaqeaz11, R.string.android_tools_bootloader_version, textViewHjlrtqw13);
                        linearLayoutXbdyiew10.addView(linearLayoutZwaqeaz11, zamkzqg.uiqyzsp(mainActivity3));
                        linearLayoutZwaqeaz11.setVisibility(8);
                        LinearLayout linearLayout6 = new LinearLayout(mainActivity3);
                        linearLayout6.setOrientation(1);
                        linearLayout6.addView(zamkzqg.ysaclsr(mainActivity3, R.string.android_tools_fastboot_actions));
                        final int i36 = 6;
                        View.OnClickListener onClickListener4 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i36) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh9 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha18 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_system), onClickListener4);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha18, R.drawable.ic_reboot, iNmpwovh9);
                        final int i37 = 7;
                        View.OnClickListener onClickListener5 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i37) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh10 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha19 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_bootloader), onClickListener5);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha19, R.drawable.ic_unlock, iNmpwovh10);
                        final int i38 = 8;
                        View.OnClickListener onClickListener6 = new View.OnClickListener() { // from class: x.rpilpcp
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view9) {
                                switch (i38) {
                                    case 0:
                                        wjugzfhVar2.nmpwovh.buswjhz();
                                        break;
                                    case 1:
                                        MainActivity mainActivity4 = wjugzfhVar2.nmpwovh;
                                        Future future = mainActivity4.zftrkmx;
                                        if (!mainActivity4.nxumtuo && !mainActivity4.dvzxbaj && (future == null || future.isDone())) {
                                            Toast.makeText(mainActivity4, "No terminal operation is running", 0).show();
                                        } else if (!mainActivity4.dvzxbaj) {
                                            mainActivity4.gepzcpd++;
                                            if (future != null) {
                                                future.cancel(true);
                                            }
                                            mainActivity4.nxumtuo = false;
                                            mainActivity4.dvzxbaj = false;
                                            if (zamkzqg.rrpfqyy(mainActivity4.ulafhci)) {
                                                mainActivity4.nkemejx();
                                                if (mainActivity4.ulafhci != null) {
                                                    mainActivity4.cgcdpmq();
                                                }
                                            }
                                            mainActivity4.fusjbbl("[cancelled] command stopped; USB transport is reconnecting.");
                                            if (mainActivity4.thbdbid) {
                                                mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                                            }
                                            mainActivity4.gdkopre();
                                        } else {
                                            mainActivity4.qppdydr = true;
                                            AdbFastbootNative.nmpwovh();
                                            mainActivity4.fusjbbl("[cancelling] Waiting for Fastboot I/O to stop; the partition may be incomplete.");
                                        }
                                        break;
                                    case 2:
                                        MainActivity mainActivity5 = wjugzfhVar2.nmpwovh;
                                        if (mainActivity5.dplrlfq()) {
                                            ecffprn.imuemzb(mainActivity5, mainActivity5.getString(R.string.internal_picker_select_file), mainActivity5.lclupha(), null, new pvbzgon(mainActivity5, 0));
                                            break;
                                        }
                                        break;
                                    case 3:
                                        wjugzfhVar2.nmpwovh.seujokk("system");
                                        break;
                                    case 4:
                                        wjugzfhVar2.nmpwovh.seujokk("recovery");
                                        break;
                                    case 5:
                                        wjugzfhVar2.nmpwovh.seujokk("bootloader");
                                        break;
                                    case 6:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot");
                                        break;
                                    case 7:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-bootloader");
                                        break;
                                    case 8:
                                        wjugzfhVar2.nmpwovh.bsimxgu("reboot-fastboot");
                                        break;
                                    default:
                                        wjugzfhVar2.nmpwovh.jzcfpou();
                                        break;
                                }
                            }
                        };
                        int iNmpwovh11 = zamkzqg.nmpwovh(mainActivity3);
                        TextView textViewLclupha20 = zamkzqg.lclupha(mainActivity3, mainActivity3.getString(R.string.android_tools_reboot_fastbootd), onClickListener6);
                        zamkzqg.enxkjpu(mainActivity3, textViewLclupha20, R.drawable.ic_partitions, iNmpwovh11);
                        TextView[] textViewArr3 = {textViewLclupha18, textViewLclupha19, textViewLclupha20};
                        int i39 = 0;
                        while (i39 < 3) {
                            TextView textView6 = textViewArr3[i39];
                            LinearLayout.LayoutParams layoutParams34 = new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
                            layoutParams34.topMargin = zamkzqg.qunltjs(mainActivity3, 8);
                            linearLayout6.addView(textView6, layoutParams34);
                            i39++;
                            textViewArr3 = textViewArr3;
                        }
                        LinearLayout.LayoutParams layoutParams35 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams35.topMargin = zamkzqg.qunltjs(mainActivity3, 12);
                        linearLayoutXbdyiew10.addView(linearLayout6, layoutParams35);
                        linearLayout6.setVisibility(8);
                        linearLayoutXbdyiew10.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        linearLayoutXbdyiew11.addView(new View(mainActivity3), new LinearLayout.LayoutParams(-1, mainActivity3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                        mainActivity3.ltnesel = new jybecxv(scrollView5, textView, textViewHjlrtqw2, textViewOxoagud26, editText, textViewOxoagud28, scrollView7, textView3, linearLayoutZwaqeaz10, textViewHjlrtqw3, textViewHjlrtqw4, textViewHjlrtqw5, textViewHjlrtqw6, textViewHjlrtqw7, textViewHjlrtqw8, textViewHjlrtqw9, textViewHjlrtqw10, textViewHjlrtqw11, textViewHjlrtqw12, textViewHjlrtqw13, linearLayoutZwaqeaz11, linearLayout6);
                        ccuulnt ccuulntVar = mainActivity3.suqlntg;
                        String string2 = mainActivity3.getString(R.string.android_tools_terminal_banner);
                        synchronized (ccuulntVar) {
                            try {
                                if (ccuulntVar.nmpwovh.length() == 0 && string2 != null && !string2.isEmpty()) {
                                    ccuulntVar.nmpwovh.append(string2.replace("\r\n", "\n").replace('\r', '\n'));
                                    ccuulntVar.ojyssqt();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        ccuulnt ccuulntVar2 = mainActivity3.suqlntg;
                        ccuulntVar2.qxvquar = true;
                        ccuulntVar2.nmpwovh(true);
                        mainActivity3.suqlntg.nmpwovh(true);
                        mainActivity3.gdkopre();
                        mainActivity3.kffvigz(scrollView5, "android_tools");
                        mainActivity3.jzcfpou();
                        return;
                    default:
                        MainActivity mainActivity4 = (MainActivity) gepzcpdVar2.nmpwovh;
                        if (mainActivity4.lpkdqgx || mainActivity4.gzokllk) {
                            Toast.makeText(mainActivity4, R.string.error_busy, 0).show();
                            return;
                        } else {
                            new AlertDialog.Builder(mainActivity4).setTitle(R.string.power_menu_title).setItems(new String[]{mainActivity4.getString(R.string.power_normal_reboot), mainActivity4.getString(R.string.power_shutdown)}, new nsyqsfj(mainActivity4, 1)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
                            return;
                        }
                }
            }
        });
        linearLayoutXbdyiew4.addView(linearLayoutEigllth, zamkzqg.exhiehf(nmpwovhVar, false));
        linearLayoutXbdyiew4.addView(new View(nmpwovhVar), new LinearLayout.LayoutParams(-1, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
        nmpwovhVar.rceuwfv = linearLayoutEigllth;
        nmpwovhVar.btazysh = scrollView3;
        final gepzcpd gepzcpdVar3 = new gepzcpd(nmpwovhVar);
        ScrollView scrollView4 = new ScrollView(nmpwovhVar);
        scrollView4.setFillViewport(true);
        scrollView4.setBackgroundColor(zamkzqg.buswjhz(nmpwovhVar));
        LinearLayout linearLayoutXbdyiew5 = zamkzqg.xbdyiew(nmpwovhVar, 16);
        scrollView4.addView(linearLayoutXbdyiew5);
        int iNmpwovh2 = zamkzqg.nmpwovh(nmpwovhVar);
        final int i20 = 0;
        TextView textViewLclupha9 = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_authorize_back), new View.OnClickListener() { // from class: x.wrbqriz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i20) {
                    case 0:
                        gepzcpdVar3.nmpwovh.buswjhz();
                        break;
                    case 1:
                        gepzcpdVar3.nmpwovh.ankiohq();
                        break;
                    case 2:
                        gepzcpdVar3.nmpwovh.nxumtuo();
                        break;
                    case 3:
                        com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                        if (nmpwovhVar2.snbdnwo != null && nmpwovhVar2.nysvajy != null && !nmpwovhVar2.xhyvkax) {
                            if (!nmpwovhVar2.jcyrpko.isEmpty()) {
                                nmpwovhVar2.yojulhu();
                            } else {
                                nmpwovhVar2.dvzxbaj(true);
                            }
                            break;
                        }
                        break;
                    case 4:
                        gepzcpdVar3.nmpwovh.dvzxbaj(true);
                        break;
                    default:
                        com.rynx.app.nmpwovh nmpwovhVar3 = gepzcpdVar3.nmpwovh;
                        if (!nmpwovhVar3.rrpfqyy()) {
                            zfmpmio.nmpwovh(nmpwovhVar3, nmpwovhVar3.getString(R.string.xiaomi_new_security_not_ready), false);
                        } else if (!nmpwovhVar3.vntpaom()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_da_missing));
                        } else if (nmpwovhVar3.silhone("auth_path") == null) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_auth_missing));
                        } else if (!nmpwovhVar3.jdqigmr()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_preloader_invalid));
                        } else {
                            nmpwovhVar3.suqlntg();
                        }
                        break;
                }
            }
        });
        zamkzqg.enxkjpu(nmpwovhVar, textViewLclupha9, R.drawable.ic_back, iNmpwovh2);
        textViewLclupha9.setGravity(8388627);
        linearLayoutXbdyiew5.addView(textViewLclupha9);
        TextView textViewYwhgqsi = zamkzqg.ywhgqsi(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_authorize_title));
        zamkzqg.enxkjpu(nmpwovhVar, textViewYwhgqsi, R.drawable.ic_lock, zamkzqg.nmpwovh(nmpwovhVar));
        linearLayoutXbdyiew5.addView(textViewYwhgqsi);
        linearLayoutXbdyiew5.addView(zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_authorize_subtitle), 12, zamkzqg.jbmzxye(nmpwovhVar), false));
        LinearLayout linearLayoutZwaqeaz7 = zamkzqg.zwaqeaz(nmpwovhVar);
        linearLayoutZwaqeaz7.addView(zamkzqg.ysaclsr(nmpwovhVar, R.string.xiaomi_authorize_server_status));
        TextView textViewOxoagud20 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_authorize_signed_out), 13, zamkzqg.jbmzxye(nmpwovhVar), true);
        textViewOxoagud20.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 10), 0, 0);
        zamkzqg.enxkjpu(nmpwovhVar, textViewOxoagud20, R.drawable.ic_lock, zamkzqg.jbmzxye(nmpwovhVar));
        linearLayoutZwaqeaz7.addView(textViewOxoagud20);
        linearLayoutXbdyiew5.addView(linearLayoutZwaqeaz7, zamkzqg.uiqyzsp(nmpwovhVar));
        LinearLayout linearLayoutZwaqeaz8 = zamkzqg.zwaqeaz(nmpwovhVar);
        linearLayoutZwaqeaz8.addView(zamkzqg.ysaclsr(nmpwovhVar, R.string.xiaomi_authorize_account));
        final EditText editTextCszfvxh = zamkzqg.cszfvxh(nmpwovhVar, R.string.xiaomi_authorize_username, false);
        editTextCszfvxh.setImeOptions(5);
        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams23.topMargin = zamkzqg.qunltjs(nmpwovhVar, 12);
        linearLayoutZwaqeaz8.addView(editTextCszfvxh, layoutParams23);
        LinearLayout linearLayoutLvtqoqa9 = zamkzqg.lvtqoqa(nmpwovhVar);
        LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams24.topMargin = zamkzqg.qunltjs(nmpwovhVar, 10);
        final EditText editTextCszfvxh2 = zamkzqg.cszfvxh(nmpwovhVar, R.string.xiaomi_authorize_password, true);
        editTextCszfvxh2.setImeOptions(6);
        linearLayoutLvtqoqa9.addView(editTextCszfvxh2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textViewOxoagud21 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_authorize_show), 11, zamkzqg.nmpwovh(nmpwovhVar), true);
        textViewOxoagud21.setGravity(17);
        textViewOxoagud21.setPadding(zamkzqg.qunltjs(nmpwovhVar, 12), zamkzqg.qunltjs(nmpwovhVar, 11), zamkzqg.qunltjs(nmpwovhVar, 12), zamkzqg.qunltjs(nmpwovhVar, 11));
        textViewOxoagud21.setBackground(zamkzqg.jvtqflj(nmpwovhVar, zamkzqg.ojyssqt(nmpwovhVar), nmpwovhVar.getColor(R.color.rynx_transparent), zamkzqg.qunltjs(nmpwovhVar, 12)));
        textViewOxoagud21.setClickable(true);
        textViewOxoagud21.setFocusable(true);
        zamkzqg.utmeivs(nmpwovhVar, textViewOxoagud21);
        LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams25.leftMargin = zamkzqg.qunltjs(nmpwovhVar, 8);
        linearLayoutLvtqoqa9.addView(textViewOxoagud21, layoutParams25);
        linearLayoutZwaqeaz8.addView(linearLayoutLvtqoqa9, layoutParams24);
        TextView textViewOxoagud22 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_authorize_security_note), 11, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud22.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 10), 0, 0);
        linearLayoutZwaqeaz8.addView(textViewOxoagud22);
        TextView textViewTnejqcj = zamkzqg.tnejqcj(nmpwovhVar, R.string.xiaomi_authorize_login, R.drawable.ic_lock, new bsimxgu(gepzcpdVar3, editTextCszfvxh, editTextCszfvxh2, 1));
        LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(-1, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
        layoutParams26.topMargin = zamkzqg.qunltjs(nmpwovhVar, 14);
        linearLayoutZwaqeaz8.addView(textViewTnejqcj, layoutParams26);
        linearLayoutXbdyiew5.addView(linearLayoutZwaqeaz8, zamkzqg.uiqyzsp(nmpwovhVar));
        LinearLayout linearLayoutZwaqeaz9 = zamkzqg.zwaqeaz(nmpwovhVar);
        linearLayoutZwaqeaz9.addView(zamkzqg.ysaclsr(nmpwovhVar, R.string.xiaomi_authorize_profile));
        TextView textViewXqbcyis = zamkzqg.xqbcyis(nmpwovhVar);
        TextView textViewXqbcyis2 = zamkzqg.xqbcyis(nmpwovhVar);
        TextView textViewXqbcyis3 = zamkzqg.xqbcyis(nmpwovhVar);
        TextView textViewXqbcyis4 = zamkzqg.xqbcyis(nmpwovhVar);
        zamkzqg.imuemzb(nmpwovhVar, linearLayoutZwaqeaz9, R.string.xiaomi_authorize_user_label, textViewXqbcyis);
        zamkzqg.imuemzb(nmpwovhVar, linearLayoutZwaqeaz9, R.string.xiaomi_authorize_email_label, textViewXqbcyis2);
        zamkzqg.imuemzb(nmpwovhVar, linearLayoutZwaqeaz9, R.string.xiaomi_authorize_status_label, textViewXqbcyis3);
        zamkzqg.imuemzb(nmpwovhVar, linearLayoutZwaqeaz9, R.string.xiaomi_authorize_credit_label, textViewXqbcyis4);
        LinearLayout linearLayoutLvtqoqa10 = zamkzqg.lvtqoqa(nmpwovhVar);
        int iNmpwovh3 = zamkzqg.nmpwovh(nmpwovhVar);
        final int i21 = 1;
        TextView textViewLclupha10 = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_authorize_refresh), new View.OnClickListener() { // from class: x.wrbqriz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i21) {
                    case 0:
                        gepzcpdVar3.nmpwovh.buswjhz();
                        break;
                    case 1:
                        gepzcpdVar3.nmpwovh.ankiohq();
                        break;
                    case 2:
                        gepzcpdVar3.nmpwovh.nxumtuo();
                        break;
                    case 3:
                        com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                        if (nmpwovhVar2.snbdnwo != null && nmpwovhVar2.nysvajy != null && !nmpwovhVar2.xhyvkax) {
                            if (!nmpwovhVar2.jcyrpko.isEmpty()) {
                                nmpwovhVar2.yojulhu();
                            } else {
                                nmpwovhVar2.dvzxbaj(true);
                            }
                            break;
                        }
                        break;
                    case 4:
                        gepzcpdVar3.nmpwovh.dvzxbaj(true);
                        break;
                    default:
                        com.rynx.app.nmpwovh nmpwovhVar3 = gepzcpdVar3.nmpwovh;
                        if (!nmpwovhVar3.rrpfqyy()) {
                            zfmpmio.nmpwovh(nmpwovhVar3, nmpwovhVar3.getString(R.string.xiaomi_new_security_not_ready), false);
                        } else if (!nmpwovhVar3.vntpaom()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_da_missing));
                        } else if (nmpwovhVar3.silhone("auth_path") == null) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_auth_missing));
                        } else if (!nmpwovhVar3.jdqigmr()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_preloader_invalid));
                        } else {
                            nmpwovhVar3.suqlntg();
                        }
                        break;
                }
            }
        });
        zamkzqg.enxkjpu(nmpwovhVar, textViewLclupha10, R.drawable.ic_refresh, iNmpwovh3);
        int iPzqxblc3 = zamkzqg.pzqxblc(nmpwovhVar);
        final int i22 = 2;
        TextView textViewLclupha11 = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_authorize_logout), new View.OnClickListener() { // from class: x.wrbqriz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i22) {
                    case 0:
                        gepzcpdVar3.nmpwovh.buswjhz();
                        break;
                    case 1:
                        gepzcpdVar3.nmpwovh.ankiohq();
                        break;
                    case 2:
                        gepzcpdVar3.nmpwovh.nxumtuo();
                        break;
                    case 3:
                        com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                        if (nmpwovhVar2.snbdnwo != null && nmpwovhVar2.nysvajy != null && !nmpwovhVar2.xhyvkax) {
                            if (!nmpwovhVar2.jcyrpko.isEmpty()) {
                                nmpwovhVar2.yojulhu();
                            } else {
                                nmpwovhVar2.dvzxbaj(true);
                            }
                            break;
                        }
                        break;
                    case 4:
                        gepzcpdVar3.nmpwovh.dvzxbaj(true);
                        break;
                    default:
                        com.rynx.app.nmpwovh nmpwovhVar3 = gepzcpdVar3.nmpwovh;
                        if (!nmpwovhVar3.rrpfqyy()) {
                            zfmpmio.nmpwovh(nmpwovhVar3, nmpwovhVar3.getString(R.string.xiaomi_new_security_not_ready), false);
                        } else if (!nmpwovhVar3.vntpaom()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_da_missing));
                        } else if (nmpwovhVar3.silhone("auth_path") == null) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_auth_missing));
                        } else if (!nmpwovhVar3.jdqigmr()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_preloader_invalid));
                        } else {
                            nmpwovhVar3.suqlntg();
                        }
                        break;
                }
            }
        });
        zamkzqg.enxkjpu(nmpwovhVar, textViewLclupha11, R.drawable.ic_close, iPzqxblc3);
        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height), 1.0f);
        LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(layoutParams27);
        layoutParams28.leftMargin = zamkzqg.qunltjs(nmpwovhVar, 8);
        linearLayoutLvtqoqa10.addView(textViewLclupha10, layoutParams27);
        linearLayoutLvtqoqa10.addView(textViewLclupha11, layoutParams28);
        LinearLayout.LayoutParams layoutParams29 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams29.topMargin = zamkzqg.qunltjs(nmpwovhVar, 14);
        linearLayoutZwaqeaz9.addView(linearLayoutLvtqoqa10, layoutParams29);
        linearLayoutZwaqeaz9.setVisibility(8);
        linearLayoutXbdyiew5.addView(linearLayoutZwaqeaz9, zamkzqg.uiqyzsp(nmpwovhVar));
        LinearLayout linearLayoutZwaqeaz10 = zamkzqg.zwaqeaz(nmpwovhVar);
        linearLayoutZwaqeaz10.addView(zamkzqg.ysaclsr(nmpwovhVar, R.string.xiaomi_device_model_section));
        TextView textViewOxoagud23 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_device_model_description), 11, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud23.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 8), 0, 0);
        linearLayoutZwaqeaz10.addView(textViewOxoagud23);
        TextView textViewOxoagud24 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_device_model_not_selected), 15, zamkzqg.zngzleo(nmpwovhVar), true);
        textViewOxoagud24.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 14), 0, 0);
        linearLayoutZwaqeaz10.addView(textViewOxoagud24);
        TextView textViewOxoagud25 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_device_model_prompt), 11, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud25.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 5), 0, 0);
        linearLayoutZwaqeaz10.addView(textViewOxoagud25);
        TextView textViewOxoagud26 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_device_catalog_idle), 11, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud26.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 12), 0, 0);
        zamkzqg.enxkjpu(nmpwovhVar, textViewOxoagud26, R.drawable.ic_info, zamkzqg.jbmzxye(nmpwovhVar));
        linearLayoutZwaqeaz10.addView(textViewOxoagud26);
        TextView textViewOxoagud27 = zamkzqg.oxoagud(nmpwovhVar, "", 10, zamkzqg.nmpwovh(nmpwovhVar), true);
        textViewOxoagud27.setGravity(17);
        textViewOxoagud27.setPadding(zamkzqg.qunltjs(nmpwovhVar, 10), zamkzqg.qunltjs(nmpwovhVar, 5), zamkzqg.qunltjs(nmpwovhVar, 10), zamkzqg.qunltjs(nmpwovhVar, 5));
        textViewOxoagud27.setVisibility(8);
        LinearLayout.LayoutParams layoutParams30 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams30.topMargin = zamkzqg.qunltjs(nmpwovhVar, 12);
        linearLayoutZwaqeaz10.addView(textViewOxoagud27, layoutParams30);
        TextView textViewOxoagud28 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_new_security_description), 11, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud28.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 4), 0, 0);
        linearLayoutZwaqeaz10.addView(textViewOxoagud28);
        TextView textViewOxoagud29 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_loader_bundle_idle), 11, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud29.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 10), 0, 0);
        zamkzqg.enxkjpu(nmpwovhVar, textViewOxoagud29, R.drawable.ic_info, zamkzqg.jbmzxye(nmpwovhVar));
        linearLayoutZwaqeaz10.addView(textViewOxoagud29);
        LinearLayout linearLayoutLvtqoqa11 = zamkzqg.lvtqoqa(nmpwovhVar);
        final int i23 = 3;
        TextView textViewTnejqcj2 = zamkzqg.tnejqcj(nmpwovhVar, R.string.xiaomi_device_select_model, R.drawable.ic_device_info, new View.OnClickListener() { // from class: x.wrbqriz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i23) {
                    case 0:
                        gepzcpdVar3.nmpwovh.buswjhz();
                        break;
                    case 1:
                        gepzcpdVar3.nmpwovh.ankiohq();
                        break;
                    case 2:
                        gepzcpdVar3.nmpwovh.nxumtuo();
                        break;
                    case 3:
                        com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                        if (nmpwovhVar2.snbdnwo != null && nmpwovhVar2.nysvajy != null && !nmpwovhVar2.xhyvkax) {
                            if (!nmpwovhVar2.jcyrpko.isEmpty()) {
                                nmpwovhVar2.yojulhu();
                            } else {
                                nmpwovhVar2.dvzxbaj(true);
                            }
                            break;
                        }
                        break;
                    case 4:
                        gepzcpdVar3.nmpwovh.dvzxbaj(true);
                        break;
                    default:
                        com.rynx.app.nmpwovh nmpwovhVar3 = gepzcpdVar3.nmpwovh;
                        if (!nmpwovhVar3.rrpfqyy()) {
                            zfmpmio.nmpwovh(nmpwovhVar3, nmpwovhVar3.getString(R.string.xiaomi_new_security_not_ready), false);
                        } else if (!nmpwovhVar3.vntpaom()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_da_missing));
                        } else if (nmpwovhVar3.silhone("auth_path") == null) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_auth_missing));
                        } else if (!nmpwovhVar3.jdqigmr()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_preloader_invalid));
                        } else {
                            nmpwovhVar3.suqlntg();
                        }
                        break;
                }
            }
        });
        int iNmpwovh4 = zamkzqg.nmpwovh(nmpwovhVar);
        final int i24 = 4;
        TextView textViewLclupha12 = zamkzqg.lclupha(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_device_refresh_models), new View.OnClickListener() { // from class: x.wrbqriz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i24) {
                    case 0:
                        gepzcpdVar3.nmpwovh.buswjhz();
                        break;
                    case 1:
                        gepzcpdVar3.nmpwovh.ankiohq();
                        break;
                    case 2:
                        gepzcpdVar3.nmpwovh.nxumtuo();
                        break;
                    case 3:
                        com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                        if (nmpwovhVar2.snbdnwo != null && nmpwovhVar2.nysvajy != null && !nmpwovhVar2.xhyvkax) {
                            if (!nmpwovhVar2.jcyrpko.isEmpty()) {
                                nmpwovhVar2.yojulhu();
                            } else {
                                nmpwovhVar2.dvzxbaj(true);
                            }
                            break;
                        }
                        break;
                    case 4:
                        gepzcpdVar3.nmpwovh.dvzxbaj(true);
                        break;
                    default:
                        com.rynx.app.nmpwovh nmpwovhVar3 = gepzcpdVar3.nmpwovh;
                        if (!nmpwovhVar3.rrpfqyy()) {
                            zfmpmio.nmpwovh(nmpwovhVar3, nmpwovhVar3.getString(R.string.xiaomi_new_security_not_ready), false);
                        } else if (!nmpwovhVar3.vntpaom()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_da_missing));
                        } else if (nmpwovhVar3.silhone("auth_path") == null) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_auth_missing));
                        } else if (!nmpwovhVar3.jdqigmr()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_preloader_invalid));
                        } else {
                            nmpwovhVar3.suqlntg();
                        }
                        break;
                }
            }
        });
        zamkzqg.enxkjpu(nmpwovhVar, textViewLclupha12, R.drawable.ic_refresh, iNmpwovh4);
        LinearLayout.LayoutParams layoutParams31 = new LinearLayout.LayoutParams(0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height), 1.0f);
        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(0, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height), 1.0f);
        layoutParams32.leftMargin = zamkzqg.qunltjs(nmpwovhVar, 8);
        linearLayoutLvtqoqa11.addView(textViewTnejqcj2, layoutParams31);
        linearLayoutLvtqoqa11.addView(textViewLclupha12, layoutParams32);
        LinearLayout.LayoutParams layoutParams33 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams33.topMargin = zamkzqg.qunltjs(nmpwovhVar, 14);
        linearLayoutZwaqeaz10.addView(linearLayoutLvtqoqa11, layoutParams33);
        final int i25 = 5;
        TextView textViewTnejqcj3 = zamkzqg.tnejqcj(nmpwovhVar, R.string.xiaomi_new_security_test, R.drawable.ic_lock, new View.OnClickListener() { // from class: x.wrbqriz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                switch (i25) {
                    case 0:
                        gepzcpdVar3.nmpwovh.buswjhz();
                        break;
                    case 1:
                        gepzcpdVar3.nmpwovh.ankiohq();
                        break;
                    case 2:
                        gepzcpdVar3.nmpwovh.nxumtuo();
                        break;
                    case 3:
                        com.rynx.app.nmpwovh nmpwovhVar2 = gepzcpdVar3.nmpwovh;
                        if (nmpwovhVar2.snbdnwo != null && nmpwovhVar2.nysvajy != null && !nmpwovhVar2.xhyvkax) {
                            if (!nmpwovhVar2.jcyrpko.isEmpty()) {
                                nmpwovhVar2.yojulhu();
                            } else {
                                nmpwovhVar2.dvzxbaj(true);
                            }
                            break;
                        }
                        break;
                    case 4:
                        gepzcpdVar3.nmpwovh.dvzxbaj(true);
                        break;
                    default:
                        com.rynx.app.nmpwovh nmpwovhVar3 = gepzcpdVar3.nmpwovh;
                        if (!nmpwovhVar3.rrpfqyy()) {
                            zfmpmio.nmpwovh(nmpwovhVar3, nmpwovhVar3.getString(R.string.xiaomi_new_security_not_ready), false);
                        } else if (!nmpwovhVar3.vntpaom()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_da_missing));
                        } else if (nmpwovhVar3.silhone("auth_path") == null) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_auth_missing));
                        } else if (!nmpwovhVar3.jdqigmr()) {
                            nmpwovhVar3.snbdnwo.dasxvpc(nmpwovhVar3.getString(R.string.xiaomi_local_preloader_invalid));
                        } else {
                            nmpwovhVar3.suqlntg();
                        }
                        break;
                }
            }
        });
        LinearLayout.LayoutParams layoutParams34 = new LinearLayout.LayoutParams(-1, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
        layoutParams34.topMargin = zamkzqg.qunltjs(nmpwovhVar, 10);
        linearLayoutZwaqeaz10.addView(textViewTnejqcj3, layoutParams34);
        linearLayoutZwaqeaz10.setVisibility(8);
        linearLayoutXbdyiew5.addView(linearLayoutZwaqeaz10, zamkzqg.uiqyzsp(nmpwovhVar));
        linearLayoutLvtqoqa10.setVisibility(8);
        LinearLayout linearLayoutZwaqeaz11 = zamkzqg.zwaqeaz(nmpwovhVar);
        linearLayoutZwaqeaz11.addView(zamkzqg.ysaclsr(nmpwovhVar, R.string.xiaomi_authorize_info_title));
        TextView textViewOxoagud30 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_authorize_info_message), 11, zamkzqg.jbmzxye(nmpwovhVar), false);
        textViewOxoagud30.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 8), 0, 0);
        linearLayoutZwaqeaz11.addView(textViewOxoagud30);
        linearLayoutXbdyiew5.addView(linearLayoutZwaqeaz11, zamkzqg.uiqyzsp(nmpwovhVar));
        linearLayoutXbdyiew5.addView(new View(nmpwovhVar), new LinearLayout.LayoutParams(-1, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
        textViewOxoagud21.setOnClickListener(new czqxnxv(new boolean[]{false}, editTextCszfvxh2, textViewOxoagud21, 1));
        editTextCszfvxh2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: x.dreanqi
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i26, KeyEvent keyEvent) {
                if (i26 != 6) {
                    return false;
                }
                gepzcpdVar3.nmpwovh(editTextCszfvxh.getText().toString(), editTextCszfvxh2.getText().toString());
                return true;
            }
        });
        ebrwptg ebrwptgVar = new ebrwptg(scrollView4, nmpwovhVar, editTextCszfvxh, editTextCszfvxh2, textViewOxoagud20, textViewOxoagud21, textViewTnejqcj, textViewLclupha10, textViewLclupha11, linearLayoutZwaqeaz8, linearLayoutZwaqeaz9, linearLayoutZwaqeaz10, linearLayoutLvtqoqa10, textViewXqbcyis, textViewXqbcyis2, textViewXqbcyis3, textViewXqbcyis4, textViewOxoagud24, textViewOxoagud25, textViewOxoagud26, textViewOxoagud29, textViewTnejqcj2, textViewLclupha12, textViewOxoagud27, textViewTnejqcj3);
        ebrwptgVar.ulafhci();
        nmpwovhVar.snbdnwo = ebrwptgVar;
        nmpwovhVar.gzvolsx();
        nmpwovhVar.zamkzqg = nmpwovhVar.snbdnwo.nmpwovh;
        nmpwovhVar.jbyhfxz = nmpwovhVar.ojyssqt();
        nmpwovhVar.cszfvxh = nmpwovhVar.vivhedu();
        nmpwovhVar.ioxmphz = nmpwovhVar.lthborb();
        nmpwovhVar.jlgwuft = nmpwovhVar.jlgwuft();
        kggugdp kggugdpVar = (kggugdp) nmpwovhVar;
        thbdbid thbdbidVar = new thbdbid(kggugdpVar, 2);
        FrameLayout frameLayout6 = new FrameLayout(kggugdpVar);
        frameLayout6.setBackgroundColor(kggugdpVar.getColor(R.color.rynx_transparent));
        frameLayout6.setElevation(0.0f);
        frameLayout6.setStateListAnimator(null);
        frameLayout6.setClipChildren(false);
        frameLayout6.setClipToPadding(false);
        int dimensionPixelSize2 = kggugdpVar.getResources().getDimensionPixelSize(R.dimen.bottom_nav_shell_padding_horizontal);
        int dimensionPixelSize3 = kggugdpVar.getResources().getDimensionPixelSize(R.dimen.bottom_nav_shell_padding_vertical);
        frameLayout6.setPadding(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3);
        LinearLayout linearLayout5 = new LinearLayout(kggugdpVar);
        linearLayout5.setOrientation(0);
        linearLayout5.setGravity(16);
        int dimensionPixelSize4 = kggugdpVar.getResources().getDimensionPixelSize(R.dimen.bottom_nav_surface_padding_horizontal);
        int dimensionPixelSize5 = kggugdpVar.getResources().getDimensionPixelSize(R.dimen.bottom_nav_surface_padding_vertical);
        linearLayout5.setPadding(dimensionPixelSize4, dimensionPixelSize5, dimensionPixelSize4, dimensionPixelSize5);
        linearLayout5.setBackground(zamkzqg.jvtqflj(kggugdpVar, zamkzqg.czidoiw(kggugdpVar), zamkzqg.qyeibyo(kggugdpVar), kggugdpVar.getResources().getDimensionPixelSize(R.dimen.bottom_nav_surface_radius)));
        linearLayout5.setElevation(kggugdpVar.getResources().getDimensionPixelSize(R.dimen.bottom_nav_surface_elevation));
        frameLayout6.addView(linearLayout5, new FrameLayout.LayoutParams(Math.min(kggugdpVar.getResources().getDimensionPixelSize(R.dimen.bottom_nav_surface_max_width), Math.max(1, kggugdpVar.getResources().getDisplayMetrics().widthPixels - (dimensionPixelSize2 * 2))), kggugdpVar.getResources().getDimensionPixelSize(R.dimen.bottom_nav_surface_height), 17));
        float integer = kggugdpVar.getResources().getInteger(R.integer.bottom_nav_active_weight_x100) / 100.0f;
        float integer2 = kggugdpVar.getResources().getInteger(R.integer.bottom_nav_inactive_weight_x100) / 100.0f;
        TextView textViewZftrkmx = zamkzqg.zftrkmx(kggugdpVar, "home", R.string.nav_home, R.drawable.ic_home, integer, thbdbidVar);
        TextView textViewZftrkmx2 = zamkzqg.zftrkmx(kggugdpVar, "menu", R.string.nav_menu, R.drawable.ic_menu_grid, integer2, thbdbidVar);
        TextView textViewZftrkmx3 = zamkzqg.zftrkmx(kggugdpVar, "terminal", R.string.nav_terminal, R.drawable.ic_terminal, integer2, thbdbidVar);
        TextView textViewZftrkmx4 = zamkzqg.zftrkmx(kggugdpVar, "settings", R.string.nav_settings, R.drawable.ic_settings, integer2, thbdbidVar);
        linearLayout5.addView(textViewZftrkmx, zamkzqg.marclvq(kggugdpVar, integer));
        linearLayout5.addView(textViewZftrkmx2, zamkzqg.marclvq(kggugdpVar, integer2));
        linearLayout5.addView(textViewZftrkmx3, zamkzqg.marclvq(kggugdpVar, integer2));
        linearLayout5.addView(textViewZftrkmx4, zamkzqg.marclvq(kggugdpVar, integer2));
        rvrflql rvrflqlVar = new rvrflql(kggugdpVar, frameLayout6, textViewZftrkmx, textViewZftrkmx2, textViewZftrkmx3, textViewZftrkmx4);
        rvrflqlVar.vivhedu = "__initial__";
        rvrflqlVar.vivhedu("home");
        kggugdpVar.jybecxv = rvrflqlVar;
        kggugdpVar.ysluikv = textViewZftrkmx2;
        nmpwovhVar.bwvplah = frameLayout6;
        frameLayout.addView(nmpwovhVar.bwvplah, new FrameLayout.LayoutParams(-2, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.bottom_nav_container_height), 81));
        if (i3 >= 30) {
            frameLayout.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: x.ioxmphz
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view8, WindowInsets windowInsets) {
                    com.rynx.app.nmpwovh nmpwovhVar2 = nmpwovhVar;
                    nmpwovhVar2.getClass();
                    Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
                    Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
                    boolean zIsVisible = windowInsets.isVisible(WindowInsets.Type.ime());
                    view8.setPadding(0, insets.top, 0, zIsVisible ? Math.max(insets.bottom, insets2.bottom) : insets.bottom);
                    nmpwovhVar2.ioxmphz(zIsVisible);
                    return windowInsets;
                }
            });
            frameLayout.post(new eigllth(frameLayout, 2));
        } else {
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: x.jlgwuft
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    com.rynx.app.nmpwovh nmpwovhVar2 = nmpwovhVar;
                    nmpwovhVar2.getClass();
                    Rect rect = new Rect();
                    FrameLayout frameLayout7 = frameLayout;
                    frameLayout7.getWindowVisibleDisplayFrame(rect);
                    nmpwovhVar2.ioxmphz(Math.max(0, frameLayout7.getRootView().getHeight() - rect.bottom) > nmpwovhVar2.dasxvpc(140));
                }
            });
        }
        nmpwovhVar.nhhacgu("home");
        nmpwovhVar.gefzxcg();
        nmpwovhVar.setContentView(frameLayout);
        nmpwovhVar.cszfvxh();
        nmpwovhVar.gefzxcg();
        nmpwovhVar.bgmsltp();
        Pattern pattern = iivesaq.nmpwovh;
        new Thread(new lthborb(nmpwovhVar, false, 2), "rynx-update-check").start();
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                com.rynx.app.nmpwovh nmpwovhVar = this.ojyssqt;
                EditText editText = nmpwovhVar.eigllth;
                if (editText != null && editText.hasFocus()) {
                    nmpwovhVar.eigllth.requestRectangleOnScreen(new Rect(0, 0, Math.max(1, nmpwovhVar.eigllth.getWidth()), Math.max(1, nmpwovhVar.eigllth.getHeight())), true);
                    ysaclsr ysaclsrVar = ((MainActivity) nmpwovhVar).snilumr;
                    ysaclsrVar.lthborb = true;
                    ScrollView scrollView = ysaclsrVar.ojyssqt;
                    if (scrollView != null) {
                        scrollView.post(new eigllth(ysaclsrVar, 3));
                        break;
                    }
                }
                break;
            case 1:
                com.rynx.app.nmpwovh nmpwovhVar2 = this.ojyssqt;
                nmpwovhVar2.getClass();
                try {
                    nmpwovhVar2.runOnUiThread(new btazysh(nmpwovhVar2, R.string.core_loading_mtk, 0));
                    EncryptedNativeLoader.nmpwovh("rynx_core");
                    nmpwovhVar2.pvkaerr = true;
                    nmpwovhVar2.runOnUiThread(new btazysh(nmpwovhVar2, R.string.core_loading_fastboot, 0));
                    EncryptedNativeLoader.nmpwovh("rynx_adbfastboot");
                    nmpwovhVar2.runOnUiThread(new btazysh(nmpwovhVar2, R.string.core_loading_ready, 0));
                    nmpwovhVar2.runOnUiThread(new ezxxysz(nmpwovhVar2, 2));
                } catch (Throwable th) {
                    android.util.Log.e("RynxCore", "native core load failed", th);
                    nmpwovhVar2.runOnUiThread(new ezxxysz(nmpwovhVar2, th));
                    return;
                }
                break;
            case 2:
                nmpwovh();
                break;
            case 3:
                com.rynx.app.nmpwovh nmpwovhVar3 = this.ojyssqt;
                if (!nmpwovhVar3.isFinishing() && !nmpwovhVar3.isDestroyed()) {
                    nmpwovhVar3.getWindow().addFlags(8192);
                    dplrlfq dplrlfqVar = nmpwovhVar3.vopsyhw;
                    if (dplrlfqVar != null) {
                        ((ProgressBar) dplrlfqVar.nmpwovh).setVisibility(8);
                        ((TextView) nmpwovhVar3.vopsyhw.ojyssqt).setText(R.string.core_loading_failed_title);
                        ((TextView) nmpwovhVar3.vopsyhw.ojyssqt).setTextColor(nmpwovhVar3.nkemejx);
                    }
                    new AlertDialog.Builder(nmpwovhVar3).setTitle(R.string.core_loading_failed_title).setMessage(R.string.core_loading_failed_message).setCancelable(false).setPositiveButton(android.R.string.ok, new nsizane(nmpwovhVar3, 1)).setOnDismissListener(new yonoayx(nmpwovhVar3, 1)).show();
                    break;
                }
                break;
            default:
                this.ojyssqt.ltnesel.oqexvyb.fullScroll(130);
                break;
        }
    }

    public /* synthetic */ ezxxysz(com.rynx.app.nmpwovh nmpwovhVar, Throwable th) {
        this.nmpwovh = 3;
        this.ojyssqt = nmpwovhVar;
    }
}
