package x;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class zamkzqg {
    public static final String[] nmpwovh = {"auto", "azure", "cyan", "mint", "violet", "amber", "rose", "titanium"};

    public static LinearLayout.LayoutParams ankiohq() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public static JSONObject araemok(String str, String str2, JSONObject jSONObject, int i, int i2) throws Throwable {
        try {
            URL url = new URL(str.trim());
            HttpURLConnection httpURLConnection = null;
            if (!"https".equalsIgnoreCase(url.getProtocol())) {
                throw new czgynww("INVALID_ENDPOINT", 0, "Authorization server must use HTTPS.", null);
            }
            String lowerCase = ydsyayx(url.getHost()).toLowerCase(Locale.ROOT);
            if (lowerCase.isEmpty() || lowerCase.contains("ghostauth")) {
                throw new czgynww("INVALID_ENDPOINT", 0, "Authorization server host is invalid.", null);
            }
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setConnectTimeout(Math.max(500, i));
                    httpURLConnection2.setReadTimeout(Math.max(1000, i2));
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    httpURLConnection2.setRequestProperty("Accept", "application/json");
                    if (!ydsyayx(str2).isEmpty()) {
                        httpURLConnection2.setRequestProperty("Authorization", "Bearer " + str2);
                    }
                    byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
                    if (bytes.length > 16384) {
                        throw new czgynww("REQUEST_TOO_LARGE", 0, "Authorization request is too large.", null);
                    }
                    httpURLConnection2.setFixedLengthStreamingMode(bytes.length);
                    OutputStream outputStream = httpURLConnection2.getOutputStream();
                    try {
                        outputStream.write(bytes);
                        outputStream.flush();
                        outputStream.close();
                        int responseCode = httpURLConnection2.getResponseCode();
                        String strTrim = ftrcqfq((responseCode < 200 || responseCode >= 300) ? httpURLConnection2.getErrorStream() : httpURLConnection2.getInputStream()).trim();
                        if (strTrim == null || strTrim.trim().isEmpty()) {
                            throw new czgynww("INVALID_RESPONSE", 0, "Authorization server returned an empty response.", null);
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject(strTrim);
                            if (responseCode < 200 || responseCode >= 300 || !jSONObject2.optBoolean("ok", true)) {
                                throw new czgynww(jSONObject2.optString("error", jSONObject2.optString("code", jSONObject2.optString("error_code", "BROKER_ERROR"))), responseCode, jSONObject2.optString("message", jSONObject2.optString("error_description", jSONObject2.optString("error", "Authorization request failed."))), null);
                            }
                            httpURLConnection2.disconnect();
                            return jSONObject2;
                        } catch (JSONException e) {
                            throw new czgynww("INVALID_RESPONSE", 0, "Authorization server returned invalid JSON.", e);
                        }
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e2) {
            throw new czgynww("INVALID_ENDPOINT", 0, "Authorization server URL is invalid.", e2);
        }
    }

    public static int atntgcp(Context context) {
        int iThbdbid = thbdbid(context, "system_neutral2_50", "system_neutral2_800", R.color.rynx_light_surface_alt, R.color.rynx_dark_surface_alt);
        if (nsizane(context) == 0 && ysluikv(context)) {
            return -15724268;
        }
        return nsizane(context) == 1 ? pvbzgon(iThbdbid, nmpwovh(context), 0.06f) : iThbdbid;
    }

    public static TextView axbavsj(Context context, int i, int i2, int i3, boolean z) {
        TextView textViewOxoagud = oxoagud(context, context.getString(i), 12, i3, z);
        textViewOxoagud.setTextSize(0, context.getResources().getDimension(i2));
        return textViewOxoagud;
    }

    public static void bgmsltp(final com.rynx.app.nmpwovh nmpwovhVar, int i, String str, int i2, final boolean z, DialogInterface.OnClickListener onClickListener) {
        LinearLayout linearLayout = new LinearLayout(nmpwovhVar);
        linearLayout.setOrientation(1);
        int iQunltjs = qunltjs(nmpwovhVar, 20);
        linearLayout.setPadding(iQunltjs, qunltjs(nmpwovhVar, 8), iQunltjs, qunltjs(nmpwovhVar, 6));
        TextView textView = new TextView(nmpwovhVar);
        textView.setText(str);
        textView.setTextSize(14.0f);
        textView.setTextColor(zngzleo(nmpwovhVar));
        textView.setLineSpacing(0.0f, 1.15f);
        linearLayout.addView(textView);
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(nmpwovhVar).setTitle(i).setView(linearLayout).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(i2, onClickListener).create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: x.vivhedu
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                com.rynx.app.nmpwovh nmpwovhVar2 = nmpwovhVar;
                int iCugubfc = z ? zamkzqg.cugubfc(nmpwovhVar2, "red") : zamkzqg.nmpwovh(nmpwovhVar2);
                AlertDialog alertDialog = alertDialogCreate;
                alertDialog.getButton(-1).setTextColor(iCugubfc);
                alertDialog.getButton(-1).setTypeface(Typeface.DEFAULT, 1);
                if (!ValueAnimator.areAnimatorsEnabled() || alertDialog.getWindow() == null) {
                    return;
                }
                View decorView = alertDialog.getWindow().getDecorView();
                decorView.setAlpha(0.0f);
                decorView.setScaleX(0.97f);
                decorView.setScaleY(0.97f);
                decorView.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(160L).start();
            }
        });
        alertDialogCreate.show();
    }

    public static TextView bpqosqe(Activity activity, int i, int i2, View.OnClickListener onClickListener) {
        TextView textViewLclupha = lclupha(activity, activity.getString(i), onClickListener);
        textViewLclupha.setGravity(16);
        textViewLclupha.setTextSize(12.0f);
        textViewLclupha.setCompoundDrawablesWithIntrinsicBounds(i2, 0, R.drawable.ic_internal_picker_chevron_right, 0);
        textViewLclupha.setCompoundDrawableTintList(ColorStateList.valueOf(nmpwovh(activity)));
        textViewLclupha.setCompoundDrawablePadding(activity.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap));
        return textViewLclupha;
    }

    public static TextView btazysh(Context context, int i, int i2, int i3, View.OnClickListener onClickListener) {
        TextView textViewLclupha = lclupha(context, "", onClickListener);
        textViewLclupha.setContentDescription(context.getString(i3));
        textViewLclupha.setCompoundDrawablePadding(0);
        textViewLclupha.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        textViewLclupha.setCompoundDrawableTintList(ColorStateList.valueOf(i2));
        return textViewLclupha;
    }

    public static int buswjhz(Context context) {
        return thbdbid(context, "system_neutral1_10", "system_neutral1_900", R.color.rynx_light_bg, R.color.rynx_dark_bg);
    }

    public static TextView bwvplah(kggugdp kggugdpVar, int i, int i2, View.OnClickListener onClickListener) {
        TextView textViewOxoagud = oxoagud(kggugdpVar, kggugdpVar.getString(i), 14, zngzleo(kggugdpVar), true);
        textViewOxoagud.setGravity(16);
        int dimensionPixelSize = kggugdpVar.getResources().getDimensionPixelSize(R.dimen.ui_field_padding);
        textViewOxoagud.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textViewOxoagud.setBackground(jvtqflj(kggugdpVar, atntgcp(kggugdpVar), qyeibyo(kggugdpVar), kggugdpVar.getResources().getDimensionPixelSize(R.dimen.ui_field_radius)));
        textViewOxoagud.setClickable(true);
        textViewOxoagud.setFocusable(true);
        utmeivs(kggugdpVar, textViewOxoagud);
        textViewOxoagud.setOnClickListener(onClickListener);
        if (i2 != 0) {
            enxkjpu(kggugdpVar, textViewOxoagud, i2, nmpwovh(kggugdpVar));
        }
        return textViewOxoagud;
    }

    public static String ccuulnt(long j) {
        return j < 0 ? "—" : jybecxv(j);
    }

    public static int cgcdpmq(Context context, int i) {
        return Math.round(i * context.getResources().getDisplayMetrics().density);
    }

    public static int[] chwohho(long j, int i, int i2) throws IOException {
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        if (jCurrentTimeMillis < 1500) {
            throw new IOException("authorization request deadline exhausted");
        }
        int iMin = (int) Math.min(i, Math.max(500L, jCurrentTimeMillis / 3));
        long j2 = jCurrentTimeMillis - ((long) iMin);
        if (j2 >= 1000) {
            return new int[]{iMin, (int) Math.min(i2, j2)};
        }
        throw new IOException("authorization request deadline exhausted");
    }

    public static String civyupy(long j) {
        long jMax = Math.max(0L, j / 1000);
        long j2 = jMax / 3600;
        long j3 = (jMax % 3600) / 60;
        long j4 = jMax % 60;
        return j2 > 0 ? String.format(Locale.US, "%02d:%02d:%02d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)) : String.format(Locale.US, "%02d:%02d", Long.valueOf(j3), Long.valueOf(j4));
    }

    public static void cnctlxz(Activity activity, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, boolean z) {
        mwocrhx(activity, textView, !z);
        mwocrhx(activity, textView2, z);
        linearLayout.setVisibility(z ? 8 : 0);
        linearLayout2.setVisibility(z ? 0 : 8);
    }

    public static EditText cszfvxh(Activity activity, int i, boolean z) {
        EditText editText = new EditText(activity);
        editText.setSingleLine(true);
        editText.setHint(i);
        editText.setHintTextColor(jbmzxye(activity));
        editText.setTextColor(zngzleo(activity));
        editText.setTextSize(14.0f);
        editText.setPadding(qunltjs(activity, 14), qunltjs(activity, 11), qunltjs(activity, 14), qunltjs(activity, 11));
        editText.setBackground(jvtqflj(activity, atntgcp(activity), slxntng(activity), qunltjs(activity, 14)));
        editText.setInputType((z ? 128 : 32) | 524289);
        if (z) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        return editText;
    }

    public static int cugubfc(Context context, String str) {
        boolean zYsluikv = ysluikv(context);
        if ("red".equals(str)) {
            return context.getColor(zYsluikv ? R.color.rynx_dark_risk_red_border : R.color.rynx_light_risk_red_border);
        }
        if ("yellow".equals(str)) {
            return context.getColor(zYsluikv ? R.color.rynx_dark_risk_yellow_border : R.color.rynx_light_risk_yellow_border);
        }
        return context.getColor(zYsluikv ? R.color.rynx_dark_risk_green_border : R.color.rynx_light_risk_green_border);
    }

    public static int czidoiw(Context context) {
        int iThbdbid = thbdbid(context, "system_neutral1_50", "system_neutral1_800", R.color.rynx_light_surface, R.color.rynx_dark_surface);
        int iNsizane = nsizane(context);
        if (iNsizane != 0) {
            if (iNsizane != 1) {
                return iNsizane != 2 ? iThbdbid : pvbzgon(iThbdbid, buswjhz(context), 0.12f);
            }
            return pvbzgon(iThbdbid, nmpwovh(context), ysluikv(context) ? 0.055f : 0.035f);
        }
        if (ysluikv(context)) {
            return -16448250;
        }
        return pvbzgon(iThbdbid, -1, 0.35f);
    }

    public static TextView dasxvpc(Activity activity, LinearLayout linearLayout, int i) {
        LinearLayout linearLayoutLvtqoqa = lvtqoqa(activity);
        linearLayoutLvtqoqa.setGravity(16);
        TextView textViewOxoagud = oxoagud(activity, activity.getString(i), 10, jbmzxye(activity), false);
        TextView textViewOxoagud2 = oxoagud(activity, activity.getString(R.string.value_not_available), 10, zngzleo(activity), true);
        textViewOxoagud2.setGravity(8388613);
        textViewOxoagud2.setSingleLine(true);
        linearLayoutLvtqoqa.addView(textViewOxoagud, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayoutLvtqoqa.addView(textViewOxoagud2, new LinearLayout.LayoutParams(0, -2, 0.8f));
        linearLayoutLvtqoqa.setPadding(0, qunltjs(activity, 2), 0, qunltjs(activity, 2));
        linearLayout.addView(linearLayoutLvtqoqa);
        return textViewOxoagud2;
    }

    public static TextView dkpobjg(Activity activity) {
        return oxoagud(activity, "—", 12, zngzleo(activity), true);
    }

    public static iilntfn dplrlfq(Activity activity, LinearLayout linearLayout, String str, wjugzfh wjugzfhVar) {
        LinearLayout linearLayoutZwaqeaz = zwaqeaz(activity);
        TextView textViewOxoagud = oxoagud(activity, activity.getString(R.string.bootloader_slot_title, str), 14, zngzleo(activity), true);
        linearLayoutZwaqeaz.addView(textViewOxoagud);
        TextView textViewDkpobjg = dkpobjg(activity);
        TextView textViewDkpobjg2 = dkpobjg(activity);
        TextView textViewDkpobjg3 = dkpobjg(activity);
        TextView textViewDkpobjg4 = dkpobjg(activity);
        TextView textViewDkpobjg5 = dkpobjg(activity);
        wqrnifx(activity, linearLayoutZwaqeaz, R.string.bootloader_slot_priority, textViewDkpobjg);
        wqrnifx(activity, linearLayoutZwaqeaz, R.string.bootloader_slot_tries, textViewDkpobjg2);
        wqrnifx(activity, linearLayoutZwaqeaz, R.string.bootloader_slot_successful, textViewDkpobjg3);
        wqrnifx(activity, linearLayoutZwaqeaz, R.string.bootloader_slot_bootable, textViewDkpobjg4);
        wqrnifx(activity, linearLayoutZwaqeaz, R.string.bootloader_slot_verity, textViewDkpobjg5);
        int iNmpwovh = nmpwovh(activity);
        TextView textViewLclupha = lclupha(activity, activity.getString(R.string.bootloader_slot_set_active_generic), new pzqxblc(wjugzfhVar, str, 4));
        enxkjpu(activity, textViewLclupha, R.drawable.ic_reboot, iNmpwovh);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, activity.getResources().getDimensionPixelSize(R.dimen.ui_action_height));
        layoutParams.topMargin = qunltjs(activity, 12);
        linearLayoutZwaqeaz.addView(textViewLclupha, layoutParams);
        linearLayout.addView(linearLayoutZwaqeaz, uiqyzsp(activity));
        return new iilntfn(activity, str, textViewOxoagud, textViewDkpobjg, textViewDkpobjg2, textViewDkpobjg3, textViewDkpobjg4, textViewDkpobjg5, textViewLclupha);
    }

    public static boolean dvzxbaj(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 127 || cCharAt == ':' || Character.isWhitespace(cCharAt) || Character.isISOControl(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static void dytyqos(Activity activity, LinearLayout linearLayout, int i, TextView textView) {
        LinearLayout linearLayoutLvtqoqa = lvtqoqa(activity);
        linearLayoutLvtqoqa.setPadding(0, qunltjs(activity, 5), 0, qunltjs(activity, 5));
        linearLayoutLvtqoqa.addView(oxoagud(activity, activity.getString(i), 12, jbmzxye(activity), false), new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayoutLvtqoqa.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.15f));
        linearLayout.addView(linearLayoutLvtqoqa);
    }

    public static LinearLayout.LayoutParams ecffprn(Activity activity) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, rpilpcp(activity, R.dimen.batch_compact_step_height), 1.0f);
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_step_gap);
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        return layoutParams;
    }

    public static LinearLayout ednetju(com.rynx.app.nmpwovh nmpwovhVar, int i, int i2, boolean z) {
        LinearLayout linearLayoutLvtqoqa = lvtqoqa(nmpwovhVar);
        linearLayoutLvtqoqa.setGravity(16);
        LinearLayout linearLayout = new LinearLayout(nmpwovhVar);
        linearLayout.setOrientation(1);
        linearLayout.addView(oxoagud(nmpwovhVar, nmpwovhVar.getString(i), 13, zngzleo(nmpwovhVar), false));
        linearLayout.addView(oxoagud(nmpwovhVar, nmpwovhVar.getString(i2), 11, jbmzxye(nmpwovhVar), false));
        linearLayoutLvtqoqa.addView(linearLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
        Switch r8 = new Switch(nmpwovhVar);
        r8.setContentDescription(nmpwovhVar.getString(i));
        r8.setChecked(z);
        sdchfks(nmpwovhVar, r8);
        r8.setOnCheckedChangeListener(null);
        linearLayoutLvtqoqa.addView(r8);
        linearLayoutLvtqoqa.setTag(r8);
        return linearLayoutLvtqoqa;
    }

    public static Boolean eenkamx(String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String upperCase = str.trim().toUpperCase(Locale.ROOT);
        if ("ENABLED".equals(upperCase) || "ON".equals(upperCase) || "TRUE".equals(upperCase)) {
            return Boolean.TRUE;
        }
        if ("DISABLED".equals(upperCase) || "OFF".equals(upperCase) || "FALSE".equals(upperCase)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static LinearLayout eigllth(Activity activity, int i, int i2, int i3, View.OnClickListener onClickListener) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(rpilpcp(activity, R.dimen.menu_feature_card_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_card_padding_vertical), activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_card_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_card_padding_vertical));
        linearLayout.setBackground(jvtqflj(activity, czidoiw(activity), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_card_radius)));
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        utmeivs(activity, linearLayout);
        linearLayout.setOnClickListener(onClickListener);
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setGravity(17);
        linearLayout2.setBackground(jvtqflj(activity, ojyssqt(activity), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_icon_radius)));
        ImageView imageView = new ImageView(activity);
        imageView.setImageResource(i3);
        imageView.setImageTintList(ColorStateList.valueOf(nmpwovh(activity)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_icon_size);
        linearLayout2.addView(imageView, new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        int dimensionPixelSize2 = activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_icon_container);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2));
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout3.setOrientation(1);
        linearLayout3.setGravity(16);
        linearLayout3.addView(oxoagud(activity, activity.getString(i), 16, zngzleo(activity), true));
        TextView textViewOxoagud = oxoagud(activity, activity.getString(i2), 12, jbmzxye(activity), false);
        textViewOxoagud.setPadding(0, activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_description_gap), 0, 0);
        linearLayout3.addView(textViewOxoagud);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_text_gap);
        linearLayout.addView(linearLayout3, layoutParams);
        TextView textViewOxoagud2 = oxoagud(activity, "›", 28, jbmzxye(activity), false);
        textViewOxoagud2.setGravity(17);
        textViewOxoagud2.setClickable(false);
        textViewOxoagud2.setFocusable(false);
        textViewOxoagud2.setBackground(jvtqflj(activity, atntgcp(activity), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_chevron_radius)));
        linearLayout.addView(textViewOxoagud2, new LinearLayout.LayoutParams(activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_chevron_container_width), activity.getResources().getDimensionPixelSize(R.dimen.menu_feature_chevron_container_height)));
        return linearLayout;
    }

    public static void ekyqleu(Dialog dialog, ViewGroup viewGroup) {
        dialog.setContentView(viewGroup);
        dialog.show();
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = (int) (viewGroup.getResources().getDisplayMetrics().widthPixels * 0.92f);
        layoutParams.height = viewGroup instanceof ScrollView ? (int) (viewGroup.getResources().getDisplayMetrics().heightPixels * 0.88f) : -2;
        layoutParams.dimAmount = 0.62f;
        window.setAttributes(layoutParams);
        window.addFlags(2);
    }

    public static void enxkjpu(Context context, TextView textView, int i, int i2) {
        if (textView == null) {
            return;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        textView.setCompoundDrawablePadding(rpilpcp(context, R.dimen.ui_start_icon_gap));
        textView.setCompoundDrawableTintList(ColorStateList.valueOf(i2));
    }

    public static yztlqms eqqqfvj(String str, xhyvkax xhyvkaxVar, String str2, String str3, String str4) {
        JSONObject jSONObjectJofyvuh = jofyvuh(str, xhyvkaxVar, mdepcqh("xiaomi_quote", str2, str3, str4));
        int iOptInt = jSONObjectJofyvuh.optInt("balance", -1);
        int iOptInt2 = jSONObjectJofyvuh.optInt("held", 0);
        return new yztlqms(jSONObjectJofyvuh.optString("mode", str4), jSONObjectJofyvuh.optString("chipset", str3), jSONObjectJofyvuh.optInt("cost", -1), iOptInt, iOptInt2, jSONObjectJofyvuh.optInt("available", iOptInt >= 0 ? Math.max(0, iOptInt - iOptInt2) : -1));
    }

    public static LinearLayout.LayoutParams exhiehf(Activity activity, boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (!z) {
            layoutParams.topMargin = rpilpcp(activity, R.dimen.menu_feature_card_gap);
        }
        return layoutParams;
    }

    public static String ezxxysz(Context context) {
        String string = context.getSharedPreferences("rynx_ui", 0).getString("palette", "auto");
        if (string == null) {
            return "auto";
        }
        String[] strArr = nmpwovh;
        for (int i = 0; i < 8; i++) {
            if (strArr[i].equals(string)) {
                return string;
            }
        }
        return "auto";
    }

    public static TextView ffhrwhh(kggugdp kggugdpVar, int i, boolean z, View.OnClickListener onClickListener) {
        TextView textViewOxoagud = oxoagud(kggugdpVar, kggugdpVar.getString(i), 10, z ? kggugdp(kggugdpVar) : zngzleo(kggugdpVar), true);
        textViewOxoagud.setGravity(17);
        textViewOxoagud.setBackground(sjexbpf.nmpwovh(kggugdpVar, R.dimen.risk_segment_item_radius, kggugdpVar, z ? ojyssqt(kggugdpVar) : kggugdpVar.getColor(R.color.rynx_transparent), kggugdpVar.getColor(R.color.rynx_transparent)));
        textViewOxoagud.setOnClickListener(onClickListener);
        return textViewOxoagud;
    }

    public static TextView fprgbbe(kggugdp kggugdpVar, int i, boolean z) {
        TextView textViewOxoagud = oxoagud(kggugdpVar, kggugdpVar.getString(i), 8, z ? kggugdp(kggugdpVar) : jbmzxye(kggugdpVar), true);
        textViewOxoagud.setGravity(17);
        textViewOxoagud.setBackground(sjexbpf.nmpwovh(kggugdpVar, R.dimen.batch_compact_step_radius, kggugdpVar, z ? ojyssqt(kggugdpVar) : atntgcp(kggugdpVar), kggugdpVar.getColor(R.color.rynx_transparent)));
        return textViewOxoagud;
    }

    public static String ftrcqfq(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 < 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                        byteArrayOutputStream.close();
                        inputStream.close();
                        return str;
                    }
                    if (i2 != 0) {
                        i += i2;
                        if (i > 524288) {
                            throw new IOException("Server response is too large.");
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                inputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static TextView fusjbbl(Activity activity, int i) {
        TextView textViewIasgsgq = iasgsgq(activity, i, 8, kggugdp(activity));
        textViewIasgsgq.setGravity(17);
        textViewIasgsgq.setBackground(jvtqflj(activity, ojyssqt(activity), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_step_radius)));
        return textViewIasgsgq;
    }

    public static LinearLayout gefzxcg(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        return linearLayout;
    }

    public static LinearLayout.LayoutParams gepzcpd(Activity activity) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        int iRpilpcp = rpilpcp(activity, R.dimen.risk_segment_gap);
        layoutParams.setMargins(iRpilpcp, 0, iRpilpcp, 0);
        return layoutParams;
    }

    public static LinearLayout ghkjjru(Activity activity) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(rpilpcp(activity, R.dimen.ui_card_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.ui_card_padding_vertical), activity.getResources().getDimensionPixelSize(R.dimen.ui_card_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.ui_card_padding_vertical));
        linearLayout.setBackground(jvtqflj(activity, czidoiw(activity), nsizane(activity) == 3 ? activity.getColor(R.color.rynx_transparent) : slxntng(activity), qunltjs(activity, nhhacgu(activity))));
        return linearLayout;
    }

    public static File gisppfs(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalFile();
        } catch (Exception unused) {
            return file.getAbsoluteFile();
        }
    }

    public static String gjpruie(ArrayList arrayList, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append('\'');
            sb.append(((String) arrayList.get(i)).replace("'", "'\\''"));
            sb.append('\'');
            i++;
        }
        return sb.toString();
    }

    public static int gucwjqz(Context context) {
        if (naaizwn(context)) {
            return thbdbid(context, "system_accent1_0", "system_accent1_800", R.color.rynx_light_on_accent, R.color.rynx_dark_on_accent);
        }
        int iNmpwovh = nmpwovh(context);
        return ((((double) (iNmpwovh & 255)) / 255.0d) * 0.0722d) + (((((double) ((iNmpwovh >>> 8) & 255)) / 255.0d) * 0.7152d) + ((((double) ((iNmpwovh >>> 16) & 255)) / 255.0d) * 0.2126d)) > 0.62d ? -15724524 : -1;
    }

    public static nnkxxji guecdgy(String str, xhyvkax xhyvkaxVar, String str2, int i, int i2) throws czgynww, IOException {
        JSONObject jSONObject = new JSONObject();
        zzqmpyp(jSONObject, "action", "xiaomi_status");
        zzqmpyp(jSONObject, "job_id", str2);
        JSONObject jSONObjectYjvhftf = yjvhftf(str, xhyvkaxVar, jSONObject, i, i2);
        return new nnkxxji(jSONObjectYjvhftf.optString("status", ""), jSONObjectYjvhftf.optString("phase", ""), jSONObjectYjvhftf.optString("error_code", ""), jSONObjectYjvhftf.optString("message", ""), Math.min(1000, Math.max(250, jSONObjectYjvhftf.optInt("poll_after_ms", 500))));
    }

    public static TextView gzokllk(com.rynx.app.nmpwovh nmpwovhVar, String str, String str2, int i, boolean z, View.OnClickListener onClickListener) {
        int iAtntgcp;
        StringBuilder sb = new StringBuilder();
        sb.append((str2 == null || str2.isEmpty()) ? "" : str2.concat("  "));
        sb.append(str);
        TextView textViewOxoagud = oxoagud(nmpwovhVar, sb.toString(), 11, z ? zngzleo(nmpwovhVar) : jbmzxye(nmpwovhVar), z);
        textViewOxoagud.setGravity(16);
        textViewOxoagud.setSingleLine(true);
        textViewOxoagud.setPadding(qunltjs(nmpwovhVar, 11), qunltjs(nmpwovhVar, 8), qunltjs(nmpwovhVar, 11), qunltjs(nmpwovhVar, 8));
        if (z) {
            iAtntgcp = uzyihoe(i, ysluikv(nmpwovhVar) ? 52 : 34);
        } else {
            iAtntgcp = atntgcp(nmpwovhVar);
        }
        if (!z) {
            i = qyeibyo(nmpwovhVar);
        }
        textViewOxoagud.setBackground(jvtqflj(nmpwovhVar, iAtntgcp, i, qunltjs(nmpwovhVar, 14)));
        textViewOxoagud.setClickable(true);
        textViewOxoagud.setFocusable(true);
        utmeivs(nmpwovhVar, textViewOxoagud);
        textViewOxoagud.setOnClickListener(onClickListener);
        return textViewOxoagud;
    }

    public static TextView gzvolsx(kggugdp kggugdpVar, int i, boolean z, View.OnClickListener onClickListener) {
        TextView textViewLclupha = lclupha(kggugdpVar, kggugdpVar.getString(i), onClickListener);
        textViewLclupha.setTextSize(9.0f);
        textViewLclupha.setTextColor(z ? kggugdp(kggugdpVar) : jbmzxye(kggugdpVar));
        textViewLclupha.setBackground(sjexbpf.nmpwovh(kggugdpVar, R.dimen.batch_flow_segment_radius, kggugdpVar, z ? ojyssqt(kggugdpVar) : atntgcp(kggugdpVar), z ? nmpwovh(kggugdpVar) : qyeibyo(kggugdpVar)));
        return textViewLclupha;
    }

    public static TextView hhqpjvl(int i, String str, kggugdp kggugdpVar) {
        TextView textViewOxoagud = oxoagud(kggugdpVar, kggugdpVar.getString(i) + ":  " + str, 11, jbmzxye(kggugdpVar), false);
        textViewOxoagud.setPadding(0, kggugdpVar.getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
        return textViewOxoagud;
    }

    public static xhyvkax hiygjel(JSONObject jSONObject, String str) throws czgynww {
        String strOptString = jSONObject.optString("access_token", "");
        String strOptString2 = jSONObject.optString("refresh_token", "");
        if (strOptString.isEmpty()) {
            throw new czgynww("AUTH_FAILED", 401, "Login did not return an access token.", null);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("account");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = jSONObject.optJSONObject("user");
        }
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = jSONObject;
        }
        String strOptString3 = jSONObjectOptJSONObject.optString("email", str);
        ghkjjru ghkjjruVar = new ghkjjru(jSONObjectOptJSONObject.optString("username", strOptString3), strOptString3, jSONObjectOptJSONObject.optString("status", "user"), String.valueOf(jSONObjectOptJSONObject.opt("credit") == null ? Integer.valueOf(jSONObject.optInt("balance", 0)) : jSONObjectOptJSONObject.opt("credit")));
        long jOptLong = jSONObject.optLong("expires_at", jSONObject.optLong("expires_at_epoch", 0L));
        String strOptString4 = jSONObject.optString("user_id", jSONObjectOptJSONObject.optString("id", ""));
        if (strOptString4.isEmpty()) {
            throw new czgynww("AUTH_FAILED", 401, "Login did not return a user id.", null);
        }
        return new xhyvkax(strOptString4, strOptString, strOptString2, jOptLong, ghkjjruVar);
    }

    public static TextView hjlrtqw(Activity activity) {
        TextView textViewOxoagud = oxoagud(activity, activity.getString(R.string.value_not_available), 13, zngzleo(activity), true);
        textViewOxoagud.setGravity(8388629);
        return textViewOxoagud;
    }

    public static TextView hknanqb(com.rynx.app.nmpwovh nmpwovhVar, int i) {
        TextView textViewOxoagud = oxoagud(nmpwovhVar, nmpwovhVar.getString(i), 10, jbmzxye(nmpwovhVar), false);
        textViewOxoagud.setAllCaps(true);
        textViewOxoagud.setLetterSpacing(0.12f);
        textViewOxoagud.setPadding(qunltjs(nmpwovhVar, 2), qunltjs(nmpwovhVar, 3), 0, qunltjs(nmpwovhVar, 6));
        return textViewOxoagud;
    }

    public static TextView iasgsgq(Activity activity, int i, int i2, int i3) {
        return oxoagud(activity, activity.getString(i), i2, i3, true);
    }

    public static TextView ibfmasn(Activity activity, ohwxijw ohwxijwVar) {
        int i;
        boolean zNmpwovh = ohwxijwVar.nmpwovh();
        String str = ohwxijwVar.oqexvyb;
        if (zNmpwovh) {
            i = R.string.parts_risk_red;
        } else {
            i = "yellow".equals(str) ? R.string.parts_risk_yellow : R.string.parts_risk_green;
        }
        TextView textViewOxoagud = oxoagud(activity, activity.getString(i), 9, cugubfc(activity, str), true);
        textViewOxoagud.setGravity(17);
        textViewOxoagud.setPadding(activity.getResources().getDimensionPixelSize(R.dimen.partition_risk_badge_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.partition_risk_badge_padding_vertical), activity.getResources().getDimensionPixelSize(R.dimen.partition_risk_badge_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.partition_risk_badge_padding_vertical));
        textViewOxoagud.setBackground(jvtqflj(activity, tmdubwv(activity, str), cugubfc(activity, str), activity.getResources().getDimensionPixelSize(R.dimen.partition_risk_badge_radius)));
        return textViewOxoagud;
    }

    public static xhyvkax iilntfn(String str, xhyvkax xhyvkaxVar, int i, int i2) throws czgynww {
        if (xhyvkaxVar == null || xhyvkaxVar.vivhedu.isEmpty()) {
            throw new czgynww("AUTH_REQUIRED", 401, "Account session is not available.", null);
        }
        JSONObject jSONObject = new JSONObject();
        zzqmpyp(jSONObject, "action", "account_refresh");
        zzqmpyp(jSONObject, "refresh_token", xhyvkaxVar.vivhedu);
        return hiygjel(araemok(str, "", jSONObject, i, i2), xhyvkaxVar.qxvquar != null ? (String) xhyvkaxVar.qxvquar.ojyssqt : "");
    }

    public static void ijakhcl(Activity activity, TextView textView, boolean z) {
        textView.setTextColor(z ? kggugdp(activity) : jbmzxye(activity));
        textView.setBackground(jvtqflj(activity, z ? ojyssqt(activity) : activity.getColor(R.color.rynx_transparent), activity.getColor(R.color.rynx_transparent), qunltjs(activity, 10)));
        textView.setAlpha(z ? 1.0f : 0.82f);
    }

    public static void imuemzb(Activity activity, LinearLayout linearLayout, int i, TextView textView) {
        LinearLayout linearLayoutLvtqoqa = lvtqoqa(activity);
        linearLayoutLvtqoqa.addView(oxoagud(activity, activity.getString(i), 11, jbmzxye(activity), false), new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayoutLvtqoqa.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = qunltjs(activity, 10);
        linearLayout.addView(linearLayoutLvtqoqa, layoutParams);
    }

    public static EditText ioxmphz(Context context, int i, boolean z) {
        EditText editText = new EditText(context);
        editText.setSingleLine(true);
        editText.setHint(i);
        editText.setHintTextColor(jbmzxye(context));
        editText.setTextColor(zngzleo(context));
        editText.setTextSize(14.0f);
        editText.setPadding(cgcdpmq(context, 14), cgcdpmq(context, 11), cgcdpmq(context, 14), cgcdpmq(context, 11));
        editText.setBackground(jvtqflj(context, atntgcp(context), slxntng(context), qunltjs(context, 14)));
        editText.setInputType((z ? 128 : 0) | 1);
        return editText;
    }

    public static View ivvkvsj(com.rynx.app.nmpwovh nmpwovhVar) {
        View view = new View(nmpwovhVar);
        view.setBackgroundColor(qyeibyo(nmpwovhVar));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, Math.max(1, nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.ui_stroke_width)));
        layoutParams.setMargins(0, qunltjs(nmpwovhVar, 14), 0, qunltjs(nmpwovhVar, 14));
        view.setLayoutParams(layoutParams);
        return view;
    }

    public static int iwjoiry(String str) {
        if (str == null) {
            str = "auto";
        }
        switch (str) {
            case "titanium":
                return R.string.settings_palette_titanium;
            case "violet":
                return R.string.settings_palette_violet;
            case "cyan":
                return R.string.settings_palette_cyan;
            case "mint":
                return R.string.settings_palette_mint;
            case "rose":
                return R.string.settings_palette_rose;
            case "amber":
                return R.string.settings_palette_amber;
            case "azure":
                return R.string.settings_palette_azure;
            default:
                return R.string.settings_palette_auto;
        }
    }

    public static int jbmzxye(Context context) {
        return thbdbid(context, "system_neutral2_700", "system_neutral2_200", R.color.rynx_light_text_secondary, R.color.rynx_dark_text_secondary);
    }

    public static LinearLayout jbyhfxz(Activity activity, int i) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        if (i != 0) {
            TextView textViewOxoagud = oxoagud(activity, activity.getString(i), 9, jbmzxye(activity), true);
            textViewOxoagud.setLetterSpacing(0.03f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = activity.getResources().getDimensionPixelSize(R.dimen.home_info_column_title_gap);
            linearLayout.addView(textViewOxoagud, layoutParams);
        }
        return linearLayout;
    }

    public static ghkjjru jdqigmr(Activity activity, String str, cxxnoho cxxnohoVar) {
        LinearLayout linearLayoutLvtqoqa = lvtqoqa(activity);
        linearLayoutLvtqoqa.setGravity(17);
        int iRpilpcp = rpilpcp(activity, R.dimen.risk_segment_container_padding);
        linearLayoutLvtqoqa.setPadding(iRpilpcp, iRpilpcp, iRpilpcp, iRpilpcp);
        linearLayoutLvtqoqa.setBackground(jvtqflj(activity, atntgcp(activity), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.risk_segment_container_radius)));
        TextView textViewNxumtuo = nxumtuo(activity, R.string.parts_filter_green, "green", cxxnohoVar);
        TextView textViewNxumtuo2 = nxumtuo(activity, R.string.parts_filter_yellow, "yellow", cxxnohoVar);
        TextView textViewNxumtuo3 = nxumtuo(activity, R.string.parts_filter_red, "red", cxxnohoVar);
        linearLayoutLvtqoqa.addView(textViewNxumtuo, gepzcpd(activity));
        linearLayoutLvtqoqa.addView(textViewNxumtuo2, gepzcpd(activity));
        linearLayoutLvtqoqa.addView(textViewNxumtuo3, gepzcpd(activity));
        ghkjjru ghkjjruVar = new ghkjjru(linearLayoutLvtqoqa, textViewNxumtuo, textViewNxumtuo2, textViewNxumtuo3);
        pwnmyid(activity, textViewNxumtuo, "green", "green".equals(str));
        pwnmyid(activity, textViewNxumtuo2, "yellow", "yellow".equals(str));
        pwnmyid(activity, textViewNxumtuo3, "red", "red".equals(str));
        return ghkjjruVar;
    }

    public static boolean jlgwuft(Context context) {
        return context.getSharedPreferences("rynx_ui", 0).getBoolean("ambient_halo", true);
    }

    public static JSONObject jofyvuh(String str, xhyvkax xhyvkaxVar, JSONObject jSONObject) {
        return yjvhftf(str, xhyvkaxVar, jSONObject, 10000, 30000);
    }

    public static GradientDrawable jtfjrri(Activity activity, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i);
        if (i2 != activity.getColor(R.color.rynx_transparent)) {
            gradientDrawable.setStroke(Math.max(1, i3), i2);
        }
        return gradientDrawable;
    }

    public static GradientDrawable jvtqflj(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        if (i2 != context.getColor(R.color.rynx_transparent)) {
            gradientDrawable.setStroke(context.getResources().getDimensionPixelSize(R.dimen.ui_stroke_width), i2);
        }
        gradientDrawable.setCornerRadius(i3);
        return gradientDrawable;
    }

    public static String jxvdcpb(Context context) {
        return mcdstyz(context.getSharedPreferences("rynx_app_preferences", 0).getString("language", "system"));
    }

    public static String jybecxv(long j) {
        if (j < 1024) {
            return j + " B";
        }
        double d = j;
        String[] strArr = {"B", "KB", "MB", "GB", "TB"};
        int i = 0;
        while (d >= 1024.0d && i < 4) {
            d /= 1024.0d;
            i++;
        }
        if (i > 1 && d < 100.0d) {
            return d >= 10.0d ? String.format(Locale.US, "%.1f %s", Double.valueOf(d), strArr[i]) : String.format(Locale.US, "%.2f %s", Double.valueOf(d), strArr[i]);
        }
        return String.format(Locale.US, "%.0f %s", Double.valueOf(d), strArr[i]);
    }

    public static LinearLayout.LayoutParams kffvigz(kggugdp kggugdpVar) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        int dimensionPixelSize = kggugdpVar.getResources().getDimensionPixelSize(R.dimen.risk_segment_gap);
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        return layoutParams;
    }

    public static int kggugdp(Context context) {
        if (naaizwn(context)) {
            return thbdbid(context, "system_accent1_900", "system_accent1_100", R.color.rynx_light_on_accent_container, R.color.rynx_dark_on_accent_container);
        }
        int iSilhone = silhone(ljwltks(context));
        return ysluikv(context) ? pvbzgon(iSilhone, -1, 0.72f) : pvbzgon(iSilhone, -16777216, 0.62f);
    }

    public static TextView kpmmknm(Activity activity, int i) {
        TextView textViewAxbavsj = axbavsj(activity, i, R.dimen.home_card_title_text_size, nmpwovh(activity), true);
        textViewAxbavsj.setLetterSpacing(0.04f);
        return textViewAxbavsj;
    }

    public static boolean kxotgjb(String str) {
        return (str == null || str.trim().isEmpty()) ? false : true;
    }

    public static TextView lclupha(Context context, String str, View.OnClickListener onClickListener) {
        TextView textViewOxoagud = oxoagud(context, str, 12, zngzleo(context), true);
        int iRpilpcp = rpilpcp(context, R.dimen.ui_button_padding);
        textViewOxoagud.setGravity(17);
        textViewOxoagud.setPadding(iRpilpcp, iRpilpcp, iRpilpcp, iRpilpcp);
        textViewOxoagud.setBackground(jvtqflj(context, atntgcp(context), qyeibyo(context), context.getResources().getDimensionPixelSize(R.dimen.ui_button_radius)));
        textViewOxoagud.setClickable(true);
        textViewOxoagud.setFocusable(true);
        utmeivs(context, textViewOxoagud);
        textViewOxoagud.setOnClickListener(onClickListener);
        return textViewOxoagud;
    }

    public static TextView ljhdwjr(com.rynx.app.nmpwovh nmpwovhVar, LinearLayout linearLayout, int i, String str) {
        LinearLayout linearLayoutLvtqoqa = lvtqoqa(nmpwovhVar);
        TextView textViewOxoagud = oxoagud(nmpwovhVar, nmpwovhVar.getString(i), 11, jbmzxye(nmpwovhVar), false);
        TextView textViewOxoagud2 = oxoagud(nmpwovhVar, str, 11, zngzleo(nmpwovhVar), true);
        textViewOxoagud2.setGravity(8388613);
        linearLayoutLvtqoqa.addView(textViewOxoagud, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayoutLvtqoqa.addView(textViewOxoagud2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(linearLayoutLvtqoqa);
        return textViewOxoagud2;
    }

    public static String ljwltks(Context context) {
        String strEzxxysz = ezxxysz(context);
        if ("auto".equals(strEzxxysz)) {
            return yonoayx(context) ? "auto" : new String[]{"azure", "cyan", "mint", "violet", "amber", "rose"}[(int) Math.floorMod(Math.floorDiv(System.currentTimeMillis(), 86400000L), 6)];
        }
        return strEzxxysz;
    }

    public static TextView lpkdqgx(com.rynx.app.nmpwovh nmpwovhVar, int i) {
        return oxoagud(nmpwovhVar, nmpwovhVar.getString(i), 14, zngzleo(nmpwovhVar), false);
    }

    public static dasxvpc lsgjyur(String str, xhyvkax xhyvkaxVar, hiofinr hiofinrVar, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2) throws czgynww, IOException {
        if (hiofinrVar != null) {
            String str8 = hiofinrVar.nmpwovh;
            if (!str8.isEmpty()) {
                if (ydsyayx(str2).isEmpty()) {
                    str2 = UUID.randomUUID().toString();
                }
                byte[] bArrYjbrzgu = yjbrzgu(16, str6, "challenge");
                byte[] bArrYjbrzgu2 = "new_security".equals(str5) ? yjbrzgu(32, str7, "SOCID") : new byte[0];
                JSONObject jSONObjectMdepcqh = mdepcqh("xiaomi_submit", str3, str4, str5);
                zzqmpyp(jSONObjectMdepcqh, "attempt_id", str8);
                zzqmpyp(jSONObjectMdepcqh, "client_request_id", str2);
                zzqmpyp(jSONObjectMdepcqh, "challenge", Base64.encodeToString(bArrYjbrzgu, 2));
                if (bArrYjbrzgu2.length != 0) {
                    zzqmpyp(jSONObjectMdepcqh, "soc_id", Base64.encodeToString(bArrYjbrzgu2, 2));
                }
                JSONObject jSONObjectYjvhftf = yjvhftf(str, xhyvkaxVar, jSONObjectMdepcqh, i, i2);
                String strOptString = jSONObjectYjvhftf.optString("job_id", "");
                if (strOptString.isEmpty()) {
                    throw new czgynww("INVALID_RESPONSE", 0, "Authorization server did not return a job id.", null);
                }
                jSONObjectYjvhftf.optString("status", "queued");
                return new dasxvpc(Math.min(1000, Math.max(250, jSONObjectYjvhftf.optInt("poll_after_ms", 250))), strOptString, jSONObjectYjvhftf.optString("phase", "queued"));
            }
        }
        throw new czgynww("ATTEMPT_REQUIRED", 409, "No prepared Xiaomi authorization attempt exists.", null);
    }

    public static TextView lthborb(Context context, int i, boolean z) {
        TextView textViewMwngani = mwngani(context, context.getString(i), 13.0f, true, z ? gucwjqz(context) : nmpwovh(context));
        textViewMwngani.setGravity(17);
        textViewMwngani.setPadding(cgcdpmq(context, 12), cgcdpmq(context, 13), cgcdpmq(context, 12), cgcdpmq(context, 13));
        textViewMwngani.setBackground(jvtqflj(context, z ? nmpwovh(context) : atntgcp(context), z ? nmpwovh(context) : slxntng(context), qunltjs(context, 14)));
        textViewMwngani.setClickable(true);
        textViewMwngani.setFocusable(true);
        return textViewMwngani;
    }

    public static boolean ltnesel(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int i = (str.startsWith("0x") || str.startsWith("0X")) ? 2 : 0;
        if (i == str.length()) {
            return false;
        }
        int i2 = i;
        while (true) {
            boolean z = true;
            if (i2 >= str.length()) {
                try {
                    return new BigInteger(str.substring(i), i == 2 ? 16 : 10).bitLength() <= 64;
                } catch (NumberFormatException unused) {
                    return false;
                }
            }
            char cCharAt = str.charAt(i2);
            boolean z2 = cCharAt >= '0' && cCharAt <= '9';
            if (i == 2) {
                if (!z2 && ((cCharAt < 'a' || cCharAt > 'f') && (cCharAt < 'A' || cCharAt > 'F'))) {
                    z = false;
                }
                z2 = z;
            }
            if (!z2) {
                return false;
            }
            i2++;
        }
    }

    public static LinearLayout lvtqoqa(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        return linearLayout;
    }

    public static int mamlotu(Context context) {
        if (naaizwn(context)) {
            return thbdbid(context, "system_accent2_900", "system_accent2_100", R.color.rynx_light_on_nav_active, R.color.rynx_dark_on_nav_active);
        }
        int iSilhone = silhone(ljwltks(context));
        return ysluikv(context) ? pvbzgon(iSilhone, -1, 0.78f) : pvbzgon(iSilhone, -16777216, 0.7f);
    }

    public static LinearLayout.LayoutParams marclvq(Activity activity, float f) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, rpilpcp(activity, R.dimen.bottom_nav_item_height), f);
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.bottom_nav_item_margin_horizontal);
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        return layoutParams;
    }

    public static String mcdstyz(String str) {
        if ("en".equals(str)) {
            return "en";
        }
        return "id".equals(str) ? "id" : "system";
    }

    public static JSONObject mdepcqh(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        zzqmpyp(jSONObject, "action", str);
        zzqmpyp(jSONObject, "model", str2.trim());
        zzqmpyp(jSONObject, "chipset", str3.trim());
        zzqmpyp(jSONObject, "mode", str4.trim());
        return jSONObject;
    }

    public static TextView mslkofp(Activity activity, int i) {
        TextView textViewOxoagud = oxoagud(activity, activity.getString(i), 12, jbmzxye(activity), true);
        textViewOxoagud.setGravity(17);
        textViewOxoagud.setClickable(true);
        textViewOxoagud.setFocusable(true);
        utmeivs(activity, textViewOxoagud);
        return textViewOxoagud;
    }

    public static TextView mwngani(Context context, String str, float f, boolean z, int i) {
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setTextSize(f);
        if (z) {
            textView.setTypeface(Typeface.DEFAULT, 1);
        }
        textView.setLineSpacing(0.0f, 1.08f);
        return textView;
    }

    public static void mwocrhx(Activity activity, TextView textView, boolean z) {
        textView.setTextColor(z ? kggugdp(activity) : jbmzxye(activity));
        textView.setBackground(jvtqflj(activity, z ? ojyssqt(activity) : activity.getColor(R.color.rynx_transparent), activity.getColor(R.color.rynx_transparent), qunltjs(activity, 10)));
        textView.setAlpha(z ? 1.0f : 0.82f);
    }

    public static boolean naaizwn(Context context) {
        return "auto".equals(ezxxysz(context)) && yonoayx(context);
    }

    public static Dialog nauykcf(Context context, String str, ghkjjru ghkjjruVar) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        ScrollView scrollView = new ScrollView(context);
        scrollView.setFillViewport(true);
        LinearLayout linearLayoutVopsyhw = vopsyhw(context, cgcdpmq(context, 22));
        scrollView.addView(linearLayoutVopsyhw, new FrameLayout.LayoutParams(-1, -2));
        TextView textViewMwngani = mwngani(context, context.getString(R.string.sla_brom_manual_title), 21.0f, true, zngzleo(context));
        enxkjpu(context, textViewMwngani, R.drawable.ic_lock, nmpwovh(context));
        linearLayoutVopsyhw.addView(textViewMwngani, ankiohq());
        View viewMwngani = mwngani(context, context.getString(R.string.sla_brom_manual_message), 14.0f, false, jbmzxye(context));
        LinearLayout.LayoutParams layoutParamsAnkiohq = ankiohq();
        layoutParamsAnkiohq.topMargin = cgcdpmq(context, 8);
        linearLayoutVopsyhw.addView(viewMwngani, layoutParamsAnkiohq);
        TextView textViewMwngani2 = mwngani(context, context.getString(R.string.sla_brom_manual_challenge_label), 12.0f, true, nmpwovh(context));
        textViewMwngani2.setAllCaps(true);
        LinearLayout.LayoutParams layoutParamsAnkiohq2 = ankiohq();
        layoutParamsAnkiohq2.topMargin = cgcdpmq(context, 18);
        linearLayoutVopsyhw.addView(textViewMwngani2, layoutParamsAnkiohq2);
        TextView textViewMwngani3 = mwngani(context, str == null ? "" : str, 12.0f, false, zngzleo(context));
        Typeface typeface = Typeface.MONOSPACE;
        textViewMwngani3.setTypeface(typeface);
        textViewMwngani3.setTextIsSelectable(true);
        textViewMwngani3.setPadding(cgcdpmq(context, 14), cgcdpmq(context, 12), cgcdpmq(context, 14), cgcdpmq(context, 12));
        textViewMwngani3.setBackground(jvtqflj(context, atntgcp(context), slxntng(context), qunltjs(context, 14)));
        LinearLayout.LayoutParams layoutParamsAnkiohq3 = ankiohq();
        layoutParamsAnkiohq3.topMargin = cgcdpmq(context, 8);
        linearLayoutVopsyhw.addView(textViewMwngani3, layoutParamsAnkiohq3);
        View viewLthborb = lthborb(context, R.string.sla_brom_manual_copy_challenge, false);
        LinearLayout.LayoutParams layoutParamsAnkiohq4 = ankiohq();
        layoutParamsAnkiohq4.topMargin = cgcdpmq(context, 8);
        linearLayoutVopsyhw.addView(viewLthborb, layoutParamsAnkiohq4);
        viewLthborb.setOnClickListener(new pzqxblc(context, textViewMwngani3, 9));
        TextView textViewMwngani4 = mwngani(context, context.getString(R.string.sla_brom_manual_response_label), 12.0f, true, nmpwovh(context));
        textViewMwngani4.setAllCaps(true);
        LinearLayout.LayoutParams layoutParamsAnkiohq5 = ankiohq();
        layoutParamsAnkiohq5.topMargin = cgcdpmq(context, 18);
        linearLayoutVopsyhw.addView(textViewMwngani4, layoutParamsAnkiohq5);
        EditText editText = new EditText(context);
        editText.setHint(R.string.sla_brom_manual_response_hint);
        editText.setHintTextColor(jbmzxye(context));
        editText.setTextColor(zngzleo(context));
        editText.setTextSize(13.0f);
        editText.setTypeface(typeface);
        editText.setGravity(8388659);
        editText.setMinLines(5);
        editText.setInputType(655361);
        editText.setPadding(cgcdpmq(context, 14), cgcdpmq(context, 12), cgcdpmq(context, 14), cgcdpmq(context, 12));
        editText.setBackground(jvtqflj(context, atntgcp(context), slxntng(context), qunltjs(context, 14)));
        LinearLayout.LayoutParams layoutParamsAnkiohq6 = ankiohq();
        layoutParamsAnkiohq6.topMargin = cgcdpmq(context, 8);
        linearLayoutVopsyhw.addView(editText, layoutParamsAnkiohq6);
        View viewMwngani2 = mwngani(context, context.getString(R.string.sla_brom_manual_timeout_note, Long.valueOf(Math.max(1L, 15L))), 11.5f, false, jbmzxye(context));
        LinearLayout.LayoutParams layoutParamsAnkiohq7 = ankiohq();
        layoutParamsAnkiohq7.topMargin = cgcdpmq(context, 12);
        linearLayoutVopsyhw.addView(viewMwngani2, layoutParamsAnkiohq7);
        LinearLayout linearLayoutGefzxcg = gefzxcg(context);
        LinearLayout.LayoutParams layoutParamsAnkiohq8 = ankiohq();
        layoutParamsAnkiohq8.topMargin = cgcdpmq(context, 18);
        linearLayoutVopsyhw.addView(linearLayoutGefzxcg, layoutParamsAnkiohq8);
        TextView textViewLthborb = lthborb(context, R.string.action_cancel, false);
        TextView textViewLthborb2 = lthborb(context, R.string.sla_brom_manual_send_response, true);
        linearLayoutGefzxcg.addView(textViewLthborb, yomtcav());
        LinearLayout.LayoutParams layoutParamsYomtcav = yomtcav();
        layoutParamsYomtcav.leftMargin = cgcdpmq(context, 10);
        linearLayoutGefzxcg.addView(textViewLthborb2, layoutParamsYomtcav);
        boolean[] zArr = {false};
        textViewLthborb.setOnClickListener(new bsimxgu(zArr, dialog, ghkjjruVar, 0));
        textViewLthborb2.setOnClickListener(new bwvplah(editText, context, ghkjjruVar, zArr, dialog, 1));
        dialog.setOnCancelListener(new aylswsn(zArr, ghkjjruVar, 0));
        ekyqleu(dialog, scrollView);
        editText.requestFocus();
        Window window = dialog.getWindow();
        if (window != null) {
            window.clearFlags(8192);
            window.setSoftInputMode(16);
        }
        return dialog;
    }

    public static int nhhacgu(Context context) {
        int i = context.getSharedPreferences("rynx_ui", 0).getInt("card_radius_dp", 22);
        if (i == 10 || i == 16 || i == 22 || i == 28) {
            return i;
        }
        return 22;
    }

    public static TextView nkemejx(Activity activity, LinearLayout linearLayout, int i, String str) {
        LinearLayout linearLayoutLvtqoqa = lvtqoqa(activity);
        linearLayoutLvtqoqa.setGravity(16);
        TextView textViewOxoagud = oxoagud(activity, activity.getString(i), 11, jbmzxye(activity), false);
        TextView textViewOxoagud2 = oxoagud(activity, str, 11, zngzleo(activity), true);
        textViewOxoagud2.setGravity(8388613);
        textViewOxoagud2.setMaxLines(2);
        textViewOxoagud2.setEllipsize(null);
        textViewOxoagud2.setHorizontallyScrolling(false);
        textViewOxoagud2.setBreakStrategy(0);
        linearLayoutLvtqoqa.addView(textViewOxoagud, new LinearLayout.LayoutParams(0, -2, 0.72f));
        linearLayoutLvtqoqa.addView(textViewOxoagud2, new LinearLayout.LayoutParams(0, -2, 1.55f));
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.home_detail_row_padding_vertical);
        linearLayoutLvtqoqa.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        linearLayout.addView(linearLayoutLvtqoqa);
        return textViewOxoagud2;
    }

    public static int nmpwovh(Context context) {
        if (naaizwn(context)) {
            return thbdbid(context, "system_accent1_600", "system_accent1_200", R.color.rynx_light_accent, R.color.rynx_dark_accent);
        }
        int iSilhone = silhone(ljwltks(context));
        return ysluikv(context) ? pvbzgon(iSilhone, -1, 0.48f) : iSilhone;
    }

    public static void npkgpdo(Activity activity, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, int i) {
        ijakhcl(activity, textView, i == 0);
        ijakhcl(activity, textView2, i == 1);
        ijakhcl(activity, textView3, i == 2);
        linearLayout.setVisibility(i == 0 ? 0 : 8);
        linearLayout2.setVisibility(i == 1 ? 0 : 8);
        linearLayout3.setVisibility(i != 2 ? 8 : 0);
    }

    public static void nsbgblf(Context context, String str, ednetju ednetjuVar, sfildfy sfildfyVar) {
        String string;
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        LinearLayout linearLayoutVopsyhw = vopsyhw(context, cgcdpmq(context, 22));
        boolean zEqualsIgnoreCase = "DA".equalsIgnoreCase(str);
        int i = zEqualsIgnoreCase ? R.string.sla_da_intro_title : R.string.sla_brom_intro_title;
        int i2 = zEqualsIgnoreCase ? R.string.sla_da_intro_message : R.string.sla_brom_intro_message;
        TextView textViewMwngani = mwngani(context, context.getString(i), 20.0f, true, zngzleo(context));
        enxkjpu(context, textViewMwngani, R.drawable.ic_lock, nmpwovh(context));
        linearLayoutVopsyhw.addView(textViewMwngani, ankiohq());
        View viewMwngani = mwngani(context, context.getString(i2), 14.0f, false, jbmzxye(context));
        LinearLayout.LayoutParams layoutParamsAnkiohq = ankiohq();
        layoutParamsAnkiohq.topMargin = cgcdpmq(context, 10);
        linearLayoutVopsyhw.addView(viewMwngani, layoutParamsAnkiohq);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        int iCgcdpmq = cgcdpmq(context, 16);
        linearLayout.setPadding(iCgcdpmq, iCgcdpmq, iCgcdpmq, iCgcdpmq);
        linearLayout.setBackground(jvtqflj(context, atntgcp(context), slxntng(context), qunltjs(context, 16)));
        LinearLayout.LayoutParams layoutParamsAnkiohq2 = ankiohq();
        layoutParamsAnkiohq2.topMargin = cgcdpmq(context, 18);
        linearLayoutVopsyhw.addView(linearLayout, layoutParamsAnkiohq2);
        String string2 = context.getString(R.string.sla_unknown_device);
        String str2 = ednetjuVar.nmpwovh;
        if (str2 != null && !str2.trim().isEmpty()) {
            string2 = str2.trim();
        }
        TextView textViewMwngani2 = mwngani(context, context.getString(R.string.sla_device_line, string2), 14.0f, true, zngzleo(context));
        enxkjpu(context, textViewMwngani2, R.drawable.ic_cpu_chip, nmpwovh(context));
        linearLayout.addView(textViewMwngani2, ankiohq());
        String string3 = context.getString(R.string.value_not_available);
        String str3 = ednetjuVar.vivhedu;
        if (str3 != null && !str3.trim().isEmpty()) {
            string3 = str3.trim();
        }
        TextView textViewMwngani3 = mwngani(context, context.getString(R.string.sla_boot_mode_line, string3), 13.0f, false, jbmzxye(context));
        LinearLayout.LayoutParams layoutParamsAnkiohq3 = ankiohq();
        layoutParamsAnkiohq3.topMargin = cgcdpmq(context, 7);
        linearLayout.addView(textViewMwngani3, layoutParamsAnkiohq3);
        if (zEqualsIgnoreCase) {
            String string4 = context.getString(R.string.value_not_available);
            String str4 = ednetjuVar.lthborb;
            if (str4 != null && !str4.trim().isEmpty()) {
                string4 = str4.trim();
            }
            string = context.getString(R.string.sla_da_protocol_line, string4);
        } else {
            string = context.getString(R.string.sla_brom_protocol_line);
        }
        TextView textViewMwngani4 = mwngani(context, string, 13.0f, false, jbmzxye(context));
        LinearLayout.LayoutParams layoutParamsAnkiohq4 = ankiohq();
        layoutParamsAnkiohq4.topMargin = cgcdpmq(context, 4);
        linearLayout.addView(textViewMwngani4, layoutParamsAnkiohq4);
        LinearLayout linearLayoutGefzxcg = gefzxcg(context);
        LinearLayout.LayoutParams layoutParamsAnkiohq5 = ankiohq();
        layoutParamsAnkiohq5.topMargin = cgcdpmq(context, 20);
        linearLayoutVopsyhw.addView(linearLayoutGefzxcg, layoutParamsAnkiohq5);
        TextView textViewLthborb = lthborb(context, R.string.action_cancel, false);
        TextView textViewLthborb2 = lthborb(context, R.string.sla_authorize, true);
        enxkjpu(context, textViewLthborb2, R.drawable.ic_lock, gucwjqz(context));
        linearLayoutGefzxcg.addView(textViewLthborb, yomtcav());
        LinearLayout.LayoutParams layoutParamsYomtcav = yomtcav();
        layoutParamsYomtcav.leftMargin = cgcdpmq(context, 10);
        linearLayoutGefzxcg.addView(textViewLthborb2, layoutParamsYomtcav);
        textViewLthborb.setOnClickListener(new otaqyat(dialog, sfildfyVar, 0));
        textViewLthborb2.setOnClickListener(new dkpobjg(dialog, context, str, ednetjuVar, sfildfyVar));
        dialog.setOnCancelListener(new wdvdxhb(sfildfyVar, 1));
        ekyqleu(dialog, linearLayoutVopsyhw);
    }

    public static int nsizane(Context context) {
        int i = context.getSharedPreferences("rynx_ui", 0).getInt("surface_style", 3);
        if (i < 0 || i > 3) {
            return 3;
        }
        return i;
    }

    public static int nsyqsfj(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return 4;
        }
        for (int i = 0; i < usbDevice.getInterfaceCount(); i++) {
            UsbInterface usbInterface = usbDevice.getInterface(i);
            if (usbInterface != null && usbInterface.getInterfaceClass() == 255 && usbInterface.getInterfaceSubclass() == 66) {
                if (usbInterface.getInterfaceProtocol() == 3) {
                    return 3;
                }
                if (usbInterface.getInterfaceProtocol() == 1) {
                    return 2;
                }
            }
        }
        int vendorId = usbDevice.getVendorId();
        int productId = usbDevice.getProductId();
        if (vendorId == 3725 && (productId == 3 || productId == 24576 || productId == 8192 || productId == 8193 || productId == 8447 || productId == 12288)) {
            return 1;
        }
        if (vendorId == 4100 && productId == 24576) {
            return 1;
        }
        if (vendorId == 8921 && productId == 6) {
            return 1;
        }
        return (vendorId == 4046 && (productId == 61952 || productId == 53737 || productId == 53730 || productId == 53740 || productId == 53725)) ? 1 : 4;
    }

    public static String nuoqzvr(MainActivity mainActivity, Uri uri) {
        Cursor cursorQuery;
        try {
            cursorQuery = mainActivity.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex("_data");
                        if (columnIndex < 0) {
                            cursorQuery.close();
                            return null;
                        }
                        String string = cursorQuery.getString(columnIndex);
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
    }

    public static TextView nxumtuo(Activity activity, int i, String str, cxxnoho cxxnohoVar) {
        TextView textViewOxoagud = oxoagud(activity, activity.getString(i), 11, cugubfc(activity, str), true);
        textViewOxoagud.setGravity(17);
        textViewOxoagud.setClickable(true);
        textViewOxoagud.setFocusable(true);
        utmeivs(activity, textViewOxoagud);
        textViewOxoagud.setOnClickListener(new pzqxblc(cxxnohoVar, str, 7));
        return textViewOxoagud;
    }

    public static int ohwxijw(Context context) {
        return context.getColor(ysluikv(context) ? R.color.rynx_dark_warning : R.color.rynx_light_warning);
    }

    public static int ojyssqt(Context context) {
        if (naaizwn(context)) {
            return thbdbid(context, "system_accent1_100", "system_accent1_700", R.color.rynx_light_accent_container, R.color.rynx_dark_accent_container);
        }
        int iSilhone = silhone(ljwltks(context));
        return ysluikv(context) ? pvbzgon(iSilhone, -15264485, 0.54f) : pvbzgon(iSilhone, -1, 0.82f);
    }

    public static String oohojlj(String str, String str2) {
        if (str != null) {
            for (String str3 : str.split("\\r?\\n")) {
                String strTrim = str3.trim();
                if (strTrim.startsWith(str2)) {
                    return strTrim.substring(str2.length()).trim();
                }
            }
        }
        return "";
    }

    public static TextView oqexvyb(Activity activity, LinearLayout linearLayout, int i, boolean z) {
        TextView textViewOxoagud = oxoagud(activity, activity.getString(i), 9, jbmzxye(activity), true);
        textViewOxoagud.setAllCaps(false);
        linearLayout.addView(textViewOxoagud);
        TextView textViewOxoagud2 = oxoagud(activity, activity.getString(R.string.value_not_available), 11, zngzleo(activity), true);
        if (z) {
            textViewOxoagud2.setTypeface(Typeface.MONOSPACE);
        }
        textViewOxoagud2.setTextIsSelectable(true);
        textViewOxoagud2.setMaxLines(z ? 4 : 2);
        textViewOxoagud2.setEllipsize(null);
        textViewOxoagud2.setHorizontallyScrolling(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = activity.getResources().getDimensionPixelSize(R.dimen.home_info_value_gap);
        linearLayout.addView(textViewOxoagud2, layoutParams);
        return textViewOxoagud2;
    }

    public static TextView oxoagud(Context context, String str, int i, int i2, boolean z) {
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextSize(i);
        textView.setTextColor(i2);
        textView.setTypeface(Typeface.DEFAULT, z ? 1 : 0);
        return textView;
    }

    public static TextView pcbbvuj(kggugdp kggugdpVar, int i, boolean z) {
        TextView textViewOxoagud = oxoagud(kggugdpVar, kggugdpVar.getString(i), 8, z ? kggugdp(kggugdpVar) : jbmzxye(kggugdpVar), true);
        textViewOxoagud.setGravity(17);
        textViewOxoagud.setBackground(sjexbpf.nmpwovh(kggugdpVar, R.dimen.batch_compact_step_radius, kggugdpVar, z ? ojyssqt(kggugdpVar) : atntgcp(kggugdpVar), kggugdpVar.getColor(R.color.rynx_transparent)));
        return textViewOxoagud;
    }

    public static boolean pmsrvoc(UsbDevice usbDevice) {
        return nsyqsfj(usbDevice) == 1;
    }

    public static int pvbzgon(int i, int i2, float f) {
        float fMax = Math.max(0.0f, Math.min(1.0f, f));
        float f2 = 1.0f - fMax;
        return Math.round(((i2 & 255) * fMax) + ((i & 255) * f2)) | (Math.round((((i2 >>> 24) & 255) * fMax) + (((i >>> 24) & 255) * f2)) << 24) | (Math.round((((i2 >>> 16) & 255) * fMax) + (((i >>> 16) & 255) * f2)) << 16) | (Math.round((((i2 >>> 8) & 255) * fMax) + (((i >>> 8) & 255) * f2)) << 8);
    }

    public static TextView pvkaerr(com.rynx.app.nmpwovh nmpwovhVar, int i) {
        TextView textViewOxoagud = oxoagud(nmpwovhVar, nmpwovhVar.getString(i), 11, jbmzxye(nmpwovhVar), false);
        textViewOxoagud.setPadding(0, qunltjs(nmpwovhVar, 3), 0, 0);
        return textViewOxoagud;
    }

    public static void pwnmyid(Activity activity, TextView textView, String str, boolean z) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(z ? zngzleo(activity) : cugubfc(activity, str));
        textView.setBackground(jvtqflj(activity, z ? tmdubwv(activity, str) : activity.getColor(R.color.rynx_transparent), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.risk_segment_item_radius)));
        textView.setAlpha(z ? 1.0f : 0.82f);
    }

    public static int pzkwhtn(Context context) {
        return context.getColor(ysluikv(context) ? R.color.rynx_dark_success : R.color.rynx_light_success);
    }

    public static int pzqxblc(Context context) {
        return context.getColor(ysluikv(context) ? R.color.rynx_dark_error : R.color.rynx_light_error);
    }

    public static int qunltjs(Context context, int i) {
        return Math.round(i * context.getResources().getDisplayMetrics().density);
    }

    public static void qwgjehf(EditText editText) {
        String strTrim = (editText.getText() == null ? "" : editText.getText().toString()).trim();
        if (strTrim.isEmpty()) {
            return;
        }
        String[] strArr = {"adb devices", "adb shell", "adb shell getprop", "adb logcat", "adb reboot bootloader", "adb reboot recovery", "fastboot devices", "fastboot getvar all", "fastboot getvar product", "fastboot flash ", "fastboot erase ", "fastboot reboot", "help", "clear", "pwd", "ls", "stat "};
        String str = null;
        for (int i = 0; i < 17; i++) {
            String str2 = strArr[i];
            if (str2.startsWith(strTrim)) {
                if (str != null) {
                    return;
                } else {
                    str = str2;
                }
            }
        }
        if (str != null) {
            editText.setText(str);
            editText.setSelection(str.length());
        }
    }

    public static LinearLayout.LayoutParams qxvquar(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, rpilpcp(context, R.dimen.ui_action_height), 1.0f);
        layoutParams.setMargins(context.getResources().getDimensionPixelSize(R.dimen.ui_action_margin_horizontal), context.getResources().getDimensionPixelSize(R.dimen.ui_action_margin_vertical), context.getResources().getDimensionPixelSize(R.dimen.ui_action_margin_horizontal), context.getResources().getDimensionPixelSize(R.dimen.ui_action_margin_vertical));
        return layoutParams;
    }

    public static int qyeibyo(Context context) {
        return thbdbid(context, "system_neutral2_300", "system_neutral2_600", R.color.rynx_light_border, R.color.rynx_dark_border);
    }

    public static boolean rceuwfv(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static ArrayList rpdxrib(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        String[] strArrSplit = str.split("\\r?\\n");
        int length = strArrSplit.length;
        for (int i = 0; i < length; i++) {
            String str2 = strArrSplit[i];
            String strTrim = str2 == null ? "" : str2.trim();
            int iIndexOf = strTrim.indexOf("addr=0x");
            int iIndexOf2 = strTrim.indexOf("size=0x");
            int iIndexOf3 = strTrim.indexOf("section=");
            if (iIndexOf > 0 && iIndexOf2 > iIndexOf && iIndexOf3 > iIndexOf2) {
                String strTrim2 = strTrim.substring(0, iIndexOf).trim();
                String strTrim3 = strTrim.substring(iIndexOf + 5, iIndexOf2).trim();
                String strTrim4 = strTrim.substring(iIndexOf2 + 5, iIndexOf3).trim();
                String strTrim5 = strTrim.substring(iIndexOf3 + 8).trim();
                try {
                    if (strTrim4.startsWith("0x")) {
                        strTrim4 = strTrim4.substring(2);
                    }
                    BigInteger bigInteger = new BigInteger(strTrim4, 16);
                    if (bigInteger.signum() >= 0 && bigInteger.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
                        arrayList.add(new ohwxijw(bigInteger.longValue(), strTrim2, strTrim3, strTrim5));
                    }
                } catch (RuntimeException unused) {
                }
            }
        }
        return arrayList;
    }

    public static int rpilpcp(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static boolean rrpfqyy(UsbDevice usbDevice) {
        int iNsyqsfj = nsyqsfj(usbDevice);
        return iNsyqsfj == 2 || iNsyqsfj == 3;
    }

    public static dplrlfq rvrflql(String str, xhyvkax xhyvkaxVar, String str2, int i, int i2) throws czgynww, IOException {
        JSONObject jSONObject = new JSONObject();
        zzqmpyp(jSONObject, "action", "xiaomi_result");
        zzqmpyp(jSONObject, "job_id", str2);
        JSONObject jSONObjectYjvhftf = yjvhftf(str, xhyvkaxVar, jSONObject, i, i2);
        String strOptString = jSONObjectYjvhftf.optString("response", jSONObjectYjvhftf.optString("signature", ""));
        if (strOptString.isEmpty()) {
            throw new czgynww("INVALID_RESPONSE", 0, "Authorization result is empty.", null);
        }
        return new dplrlfq(strOptString, jSONObjectYjvhftf.optString("response_sha256", ""));
    }

    public static ghkjjru saksmfq(String str, xhyvkax xhyvkaxVar) {
        JSONObject jSONObject = new JSONObject();
        zzqmpyp(jSONObject, "action", "credit_balance");
        JSONObject jSONObjectJofyvuh = jofyvuh(str, xhyvkaxVar, jSONObject);
        int iOptInt = jSONObjectJofyvuh.optInt("available", jSONObjectJofyvuh.optInt("credit", jSONObjectJofyvuh.optInt("balance", 0)));
        ghkjjru ghkjjruVar = xhyvkaxVar.qxvquar;
        return new ghkjjru(ghkjjruVar == null ? "" : (String) ghkjjruVar.nmpwovh, ghkjjruVar != null ? (String) ghkjjruVar.ojyssqt : "", ghkjjruVar == null ? "user" : (String) ghkjjruVar.vivhedu, String.valueOf(iOptInt));
    }

    public static void sdchfks(Activity activity, Switch r5) {
        int[][] iArr = {new int[]{android.R.attr.state_checked}, new int[]{-16842912}};
        r5.setThumbTintList(new ColorStateList(iArr, new int[]{nmpwovh(activity), jbmzxye(activity)}));
        r5.setTrackTintList(new ColorStateList(iArr, new int[]{ojyssqt(activity), atntgcp(activity)}));
    }

    public static int silhone(String str) {
        str.getClass();
        switch (str) {
            case "titanium":
                return -7233360;
            case "violet":
                return -6590733;
            case "cyan":
                return -16728876;
            case "mint":
                return -14628457;
            case "rose":
                return -45189;
            case "amber":
                return -24765;
            default:
                return -13260301;
        }
    }

    public static int sjexbpf(Context context) {
        if (naaizwn(context)) {
            return thbdbid(context, "system_accent2_100", "system_accent2_700", R.color.rynx_light_nav_active, R.color.rynx_dark_nav_active);
        }
        int iSilhone = silhone(ljwltks(context));
        return ysluikv(context) ? pvbzgon(iSilhone, -15264485, 0.64f) : pvbzgon(iSilhone, -1, 0.86f);
    }

    public static int slxntng(Context context) {
        int iNsizane = nsizane(context);
        if (iNsizane == 0) {
            if (ysluikv(context)) {
                return -14671578;
            }
            return qyeibyo(context);
        }
        if (iNsizane == 1) {
            return pvbzgon(qyeibyo(context), nmpwovh(context), 0.16f);
        }
        if (iNsizane != 2) {
            return qyeibyo(context);
        }
        return pvbzgon(nmpwovh(context), qyeibyo(context), ysluikv(context) ? 0.22f : 0.38f);
    }

    public static void sthdtww(Activity activity, LinearLayout linearLayout, int i, String str) {
        LinearLayout linearLayoutLvtqoqa = lvtqoqa(activity);
        TextView textViewOxoagud = oxoagud(activity, activity.getString(i), 12, jbmzxye(activity), false);
        TextView textViewOxoagud2 = oxoagud(activity, str, 12, zngzleo(activity), true);
        textViewOxoagud2.setGravity(8388613);
        linearLayoutLvtqoqa.addView(textViewOxoagud, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayoutLvtqoqa.addView(textViewOxoagud2, new LinearLayout.LayoutParams(0, -2, 1.6f));
        linearLayout.addView(linearLayoutLvtqoqa);
    }

    public static xhyvkax suqlntg(String str, String str2, String str3) throws czgynww {
        String lowerCase = str2.trim().toLowerCase(Locale.ROOT);
        if (lowerCase.isEmpty() || str3.isEmpty()) {
            throw new czgynww("Email and password are required.");
        }
        JSONObject jSONObject = new JSONObject();
        zzqmpyp(jSONObject, "action", "account_login");
        zzqmpyp(jSONObject, "email", lowerCase);
        zzqmpyp(jSONObject, "password", str3);
        return hiygjel(araemok(str, "", jSONObject, 10000, 30000), lowerCase);
    }

    public static int thbdbid(Context context, String str, String str2, int i, int i2) {
        boolean zYsluikv = ysluikv(context);
        if (naaizwn(context) && Build.VERSION.SDK_INT >= 31) {
            if (zYsluikv) {
                str = str2;
            }
            int identifier = context.getResources().getIdentifier(str, "color", "android");
            if (identifier != 0) {
                try {
                    return context.getColor(identifier);
                } catch (Throwable unused) {
                }
            }
        }
        if (zYsluikv) {
            i = i2;
        }
        return context.getColor(i);
    }

    public static int tmdubwv(Context context, String str) {
        boolean zYsluikv = ysluikv(context);
        if ("red".equals(str)) {
            return context.getColor(zYsluikv ? R.color.rynx_dark_risk_red_surface : R.color.rynx_light_risk_red_surface);
        }
        if ("yellow".equals(str)) {
            return context.getColor(zYsluikv ? R.color.rynx_dark_risk_yellow_surface : R.color.rynx_light_risk_yellow_surface);
        }
        return context.getColor(zYsluikv ? R.color.rynx_dark_risk_green_surface : R.color.rynx_light_risk_green_surface);
    }

    public static TextView tnejqcj(Activity activity, int i, int i2, View.OnClickListener onClickListener) {
        int iGucwjqz = gucwjqz(activity);
        TextView textViewLclupha = lclupha(activity, activity.getString(i), onClickListener);
        enxkjpu(activity, textViewLclupha, i2, iGucwjqz);
        textViewLclupha.setTextColor(gucwjqz(activity));
        textViewLclupha.setBackground(jvtqflj(activity, nmpwovh(activity), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.ui_button_radius)));
        return textViewLclupha;
    }

    public static File udgizdi(String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        File file = new File(str);
        if (file.isFile() && file.canRead()) {
            return gisppfs(file);
        }
        return null;
    }

    public static LinearLayout.LayoutParams uiqyzsp(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, rpilpcp(context, R.dimen.ui_card_margin_top), 0, context.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom));
        return layoutParams;
    }

    public static TextView ulafhci(Activity activity, LinearLayout linearLayout, int i, int i2, int i3, View view) {
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        ImageView imageView = new ImageView(activity);
        imageView.setImageResource(i3);
        imageView.setImageTintList(ColorStateList.valueOf(jbmzxye(activity)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.home_step_icon_padding);
        imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        imageView.setBackground(jtfjrri(activity, activity.getColor(R.color.rynx_transparent), qyeibyo(activity), activity.getResources().getDimensionPixelSize(R.dimen.home_step_ring_width)));
        linearLayout2.addView(imageView, new LinearLayout.LayoutParams(activity.getResources().getDimensionPixelSize(R.dimen.home_step_icon_size), activity.getResources().getDimensionPixelSize(R.dimen.home_step_icon_size)));
        TextView textViewOxoagud = oxoagud(activity, Integer.toString(i), 9, jbmzxye(activity), true);
        textViewOxoagud.setGravity(17);
        textViewOxoagud.setBackground(jtfjrri(activity, atntgcp(activity), qyeibyo(activity), activity.getResources().getDimensionPixelSize(R.dimen.ui_stroke_width)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(activity.getResources().getDimensionPixelSize(R.dimen.home_step_badge_size), activity.getResources().getDimensionPixelSize(R.dimen.home_step_badge_size));
        layoutParams.topMargin = -qunltjs(activity, 4);
        linearLayout2.addView(textViewOxoagud, layoutParams);
        TextView textViewOxoagud2 = oxoagud(activity, activity.getString(i2), 10, jbmzxye(activity), false);
        textViewOxoagud2.setGravity(17);
        textViewOxoagud2.setLineSpacing(0.0f, 1.05f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = qunltjs(activity, 3);
        linearLayout2.addView(textViewOxoagud2, layoutParams2);
        textViewOxoagud2.setTag(new enxkjpu(imageView, textViewOxoagud, view));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        return textViewOxoagud2;
    }

    public static void utmeivs(Context context, View view) {
        final int integer = context.getResources().getInteger(R.integer.ui_press_in_ms);
        final int integer2 = context.getResources().getInteger(R.integer.ui_press_out_ms);
        final float integer3 = context.getResources().getInteger(R.integer.ui_press_scale_x1000) / 1000.0f;
        final float integer4 = context.getResources().getInteger(R.integer.ui_press_alpha_x1000) / 1000.0f;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: x.casbgpb
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                if (!view2.isEnabled() || !ValueAnimator.areAnimatorsEnabled()) {
                    return false;
                }
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    view2.animate().cancel();
                    ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
                    float f = integer3;
                    viewPropertyAnimatorAnimate.scaleX(f).scaleY(f).alpha(integer4).setDuration(integer).setInterpolator(new DecelerateInterpolator()).start();
                    return false;
                }
                if (actionMasked != 1 && actionMasked != 3) {
                    return false;
                }
                view2.animate().cancel();
                view2.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(integer2).setInterpolator(new DecelerateInterpolator()).start();
                return false;
            }
        });
    }

    public static int uzyihoe(int i, int i2) {
        return (i & 16777215) | (Math.max(0, Math.min(255, i2)) << 24);
    }

    public static String vhimehb(String str) {
        String strSubstring;
        String str2;
        if (str == null || str.isEmpty()) {
            return str;
        }
        if (str.startsWith("[CORE][WARN] ")) {
            strSubstring = str.substring(13);
            str2 = "✧";
        } else if (str.startsWith("[CORE][ERROR] ")) {
            strSubstring = str.substring(14);
            str2 = "❂";
        } else {
            if (str.startsWith("[CORE][INFO] ")) {
                strSubstring = str.substring(13);
            } else if (str.startsWith("[RYNX] ")) {
                strSubstring = str.substring(11);
            } else {
                if (!str.startsWith("[CORE] ")) {
                    return str;
                }
                strSubstring = str.substring(7);
            }
            str2 = "✦";
        }
        return "Rynx " + str2 + "  " + strSubstring;
    }

    public static void vivhedu(String str, xhyvkax xhyvkaxVar, String str2, String str3, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        zzqmpyp(jSONObject, "action", "xiaomi_ack");
        zzqmpyp(jSONObject, "job_id", str2);
        zzqmpyp(jSONObject, "response_sha256", str3);
        zzqmpyp(jSONObject, "device_outcome", z ? "accepted" : "rejected");
        zzqmpyp(jSONObject, "device_status_code", Integer.valueOf(i));
        jofyvuh(str, xhyvkaxVar, jSONObject);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x02d2  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v17 */
    public static LinearLayout vntpaom(Activity activity, String str, ArrayList arrayList, boolean z, final yjvhftf yjvhftfVar) {
        LinearLayout linearLayout = new LinearLayout(activity);
        int r3 = 1;
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(buswjhz(activity));
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
        LinearLayout linearLayoutLvtqoqa = lvtqoqa(activity);
        linearLayoutLvtqoqa.setGravity(16);
        final int i = 0;
        linearLayoutLvtqoqa.addView(btazysh(activity, R.drawable.ic_back, nmpwovh(activity), R.string.batch_flash_back_assign, new View.OnClickListener() { // from class: x.jofyvuh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        yjvhftfVar.nmpwovh();
                        break;
                    default:
                        yjvhftfVar.ojyssqt();
                        break;
                }
            }
        }), new LinearLayout.LayoutParams(activity.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), activity.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
        TextView textViewOxoagud = oxoagud(activity, activity.getString(R.string.batch_flash_review_page_title), 20, zngzleo(activity), true);
        int i2 = 0;
        int i3 = -2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
        linearLayoutLvtqoqa.addView(textViewOxoagud, layoutParams);
        linearLayout2.addView(linearLayoutLvtqoqa);
        LinearLayout linearLayoutLvtqoqa2 = lvtqoqa(activity);
        linearLayoutLvtqoqa2.setGravity(16);
        TextView textViewOxoagud2 = oxoagud(activity, activity.getString(R.string.batch_flash_review_writes, Integer.valueOf(arrayList.size()), str), 11, nmpwovh(activity), true);
        textViewOxoagud2.setGravity(17);
        textViewOxoagud2.setPadding(activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
        textViewOxoagud2.setBackground(jvtqflj(activity, atntgcp(activity), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_radius)));
        linearLayoutLvtqoqa2.addView(textViewOxoagud2);
        linearLayoutLvtqoqa2.addView(new View(activity), new LinearLayout.LayoutParams(0, 1, 1.0f));
        String string = activity.getString(R.string.batch_flash_execute_compact, Integer.valueOf(arrayList.size()));
        int iKggugdp = kggugdp(activity);
        final int i4 = 1;
        TextView textViewLclupha = lclupha(activity, string, new View.OnClickListener() { // from class: x.jofyvuh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        yjvhftfVar.nmpwovh();
                        break;
                    default:
                        yjvhftfVar.ojyssqt();
                        break;
                }
            }
        });
        enxkjpu(activity, textViewLclupha, R.drawable.ic_flash, iKggugdp);
        textViewLclupha.setTextColor(kggugdp(activity));
        textViewLclupha.setBackground(jvtqflj(activity, ojyssqt(activity), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_radius)));
        linearLayoutLvtqoqa2.addView(textViewLclupha, new LinearLayout.LayoutParams(-2, activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
        linearLayout2.addView(linearLayoutLvtqoqa2, layoutParams2);
        linearLayout.addView(linearLayout2);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setFillViewport(true);
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout3.setOrientation(1);
        linearLayout3.setPadding(activity.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), activity.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
        scrollView.addView(linearLayout3);
        linearLayout3.addView(oxoagud(activity, activity.getString(R.string.batch_flash_review_page_subtitle), 11, jbmzxye(activity), false));
        LinearLayout linearLayoutLvtqoqa3 = lvtqoqa(activity);
        linearLayoutLvtqoqa3.addView(fusjbbl(activity, R.string.batch_flash_step_target), ecffprn(activity));
        linearLayoutLvtqoqa3.addView(fusjbbl(activity, R.string.batch_flash_step_partitions), ecffprn(activity));
        linearLayoutLvtqoqa3.addView(fusjbbl(activity, R.string.batch_flash_step_images), ecffprn(activity));
        linearLayoutLvtqoqa3.addView(fusjbbl(activity, R.string.batch_flash_step_review), ecffprn(activity));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = activity.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
        layoutParams3.bottomMargin = activity.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
        linearLayout3.addView(linearLayoutLvtqoqa3, layoutParams3);
        TextView textViewOxoagud3 = oxoagud(activity, activity.getString(R.string.batch_flash_slot_chip, str), 10, nmpwovh(activity), true);
        textViewOxoagud3.setPadding(activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
        textViewOxoagud3.setBackground(jvtqflj(activity, atntgcp(activity), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_radius)));
        linearLayout3.addView(textViewOxoagud3);
        ArrayList<yxcmoyp> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        yxcmoyp yxcmoypVar = null;
        while (it.hasNext()) {
            tnejqcj tnejqcjVar = (tnejqcj) it.next();
            if (yxcmoypVar == null) {
                yxcmoypVar = new yxcmoyp(tnejqcjVar.nmpwovh, tnejqcjVar.vivhedu, tnejqcjVar.qxvquar);
                arrayList2.add(yxcmoypVar);
            } else if (!yxcmoypVar.nmpwovh.equals(tnejqcjVar.nmpwovh) || !yxcmoypVar.ojyssqt.equals(tnejqcjVar.vivhedu)) {
                yxcmoypVar = new yxcmoyp(tnejqcjVar.nmpwovh, tnejqcjVar.vivhedu, tnejqcjVar.qxvquar);
                arrayList2.add(yxcmoypVar);
            }
            yxcmoypVar.lthborb.add(tnejqcjVar);
        }
        for (yxcmoyp yxcmoypVar2 : arrayList2) {
            LinearLayout linearLayout4 = new LinearLayout(activity);
            linearLayout4.setOrientation(r3);
            linearLayout4.setPadding(activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
            int iTmdubwv = tmdubwv(activity, yxcmoypVar2.vivhedu);
            String str2 = yxcmoypVar2.vivhedu;
            linearLayout4.setBackground(jvtqflj(activity, iTmdubwv, cugubfc(activity, str2), activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_radius)));
            LinearLayout linearLayoutLvtqoqa4 = lvtqoqa(activity);
            linearLayoutLvtqoqa4.setGravity(16);
            linearLayoutLvtqoqa4.addView(oxoagud(activity, yxcmoypVar2.nmpwovh, 14, zngzleo(activity), r3), new LinearLayout.LayoutParams(i2, i3, 1.0f));
            TextView textViewOxoagud4 = oxoagud(activity, activity.getString("red".equals(str2) ? R.string.parts_risk_red : "yellow".equals(str2) ? R.string.parts_risk_yellow : R.string.parts_risk_green), 9, cugubfc(activity, str2), r3);
            textViewOxoagud4.setPadding(activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
            textViewOxoagud4.setBackground(jvtqflj(activity, tmdubwv(activity, str2), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_radius)));
            linearLayoutLvtqoqa4.addView(textViewOxoagud4);
            linearLayout4.addView(linearLayoutLvtqoqa4);
            TextView textViewOxoagud5 = oxoagud(activity, yxcmoypVar2.ojyssqt, 11, nmpwovh(activity), true);
            textViewOxoagud5.setPadding(0, activity.getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, activity.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top));
            linearLayout4.addView(textViewOxoagud5);
            for (tnejqcj tnejqcjVar2 : yxcmoypVar2.lthborb) {
                LinearLayout linearLayoutLvtqoqa5 = lvtqoqa(activity);
                linearLayoutLvtqoqa5.setGravity(16);
                linearLayoutLvtqoqa5.setPadding(0, activity.getResources().getDimensionPixelSize(R.dimen.batch_review_destination_padding_vertical), 0, activity.getResources().getDimensionPixelSize(R.dimen.batch_review_destination_padding_vertical));
                linearLayoutLvtqoqa5.addView(oxoagud(activity, "• " + tnejqcjVar2.ojyssqt, 11, zngzleo(activity), true), new LinearLayout.LayoutParams(0, -2, 0.42f));
                TextView textViewOxoagud6 = oxoagud(activity, tnejqcjVar2.lthborb, 9, jbmzxye(activity), false);
                textViewOxoagud6.setGravity(8388613);
                linearLayoutLvtqoqa5.addView(textViewOxoagud6, new LinearLayout.LayoutParams(0, -2, 0.58f));
                linearLayout4.addView(linearLayoutLvtqoqa5);
            }
            linearLayout3.addView(linearLayout4, uiqyzsp(activity));
            r3 = 1;
            i2 = 0;
            i3 = -2;
        }
        if (z) {
            TextView textViewOxoagud7 = oxoagud(activity, activity.getString(R.string.batch_flash_critical_note), 10, ohwxijw(activity), true);
            enxkjpu(activity, textViewOxoagud7, R.drawable.ic_warning, ohwxijw(activity));
            linearLayout3.addView(textViewOxoagud7);
        }
        View viewOxoagud = oxoagud(activity, activity.getString(R.string.batch_flash_review_no_size_change), 10, jbmzxye(activity), false);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = activity.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
        linearLayout3.addView(viewOxoagud, layoutParams4);
        linearLayout3.addView(new View(activity), new LinearLayout.LayoutParams(-1, activity.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return linearLayout;
    }

    public static LinearLayout vopsyhw(Context context, int i) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(i, i, i, i);
        linearLayout.setBackground(jvtqflj(context, czidoiw(context), slxntng(context), Math.max(qunltjs(context, nhhacgu(context)), cgcdpmq(context, 20))));
        return linearLayout;
    }

    public static LinearLayout.LayoutParams wdznaie(kggugdp kggugdpVar) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, kggugdpVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_step_height), 1.0f);
        int dimensionPixelSize = kggugdpVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_step_gap);
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        return layoutParams;
    }

    public static ImageView wfxzfba(Activity activity, int i, int i2, View.OnClickListener onClickListener) {
        ImageView imageView = new ImageView(activity);
        imageView.setImageResource(i);
        imageView.setImageTintList(ColorStateList.valueOf(zngzleo(activity)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.home_header_icon_padding);
        imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        imageView.setContentDescription(activity.getString(i2));
        imageView.setBackground(jvtqflj(activity, czidoiw(activity), qyeibyo(activity), activity.getResources().getDimensionPixelSize(R.dimen.home_header_button_radius)));
        imageView.setClickable(true);
        imageView.setFocusable(true);
        utmeivs(activity, imageView);
        imageView.setOnClickListener(onClickListener);
        return imageView;
    }

    public static TextView wjugzfh(kggugdp kggugdpVar, LinearLayout linearLayout, int i, String str) {
        LinearLayout linearLayoutLvtqoqa = lvtqoqa(kggugdpVar);
        TextView textViewOxoagud = oxoagud(kggugdpVar, kggugdpVar.getString(i), 12, jbmzxye(kggugdpVar), false);
        TextView textViewOxoagud2 = oxoagud(kggugdpVar, str, 12, zngzleo(kggugdpVar), true);
        textViewOxoagud2.setGravity(8388613);
        linearLayoutLvtqoqa.addView(textViewOxoagud, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayoutLvtqoqa.addView(textViewOxoagud2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(linearLayoutLvtqoqa);
        return textViewOxoagud2;
    }

    public static void wqrnifx(Activity activity, LinearLayout linearLayout, int i, TextView textView) {
        LinearLayout linearLayoutLvtqoqa = lvtqoqa(activity);
        linearLayoutLvtqoqa.setGravity(16);
        linearLayoutLvtqoqa.addView(oxoagud(activity, activity.getString(i), 11, jbmzxye(activity), false), new LinearLayout.LayoutParams(0, -2, 1.0f));
        textView.setGravity(8388629);
        linearLayoutLvtqoqa.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = qunltjs(activity, 10);
        linearLayout.addView(linearLayoutLvtqoqa, layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static suqlntg wygqgxb(String str) {
        if (str != null && str.startsWith("@PLOG\t")) {
            String[] strArrSplit = str.split("\\t", -1);
            if (strArrSplit.length >= 2 && "@PLOG".equals(strArrSplit[0])) {
                try {
                    return new suqlntg(Integer.parseInt(strArrSplit[1]), (Serializable) (strArrSplit.length <= 2 ? new String[0] : (String[]) Arrays.copyOfRange(strArrSplit, 2, strArrSplit.length)));
                } catch (NumberFormatException unused) {
                }
            }
        }
        return null;
    }

    public static LinearLayout xbdyiew(Context context, int i) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        int iRpilpcp = i == 16 ? rpilpcp(context, R.dimen.ui_page_padding) : qunltjs(context, i);
        linearLayout.setPadding(iRpilpcp, iRpilpcp, iRpilpcp, iRpilpcp);
        linearLayout.setBackgroundColor(buswjhz(context));
        return linearLayout;
    }

    public static TextView xqbcyis(Activity activity) {
        TextView textViewOxoagud = oxoagud(activity, "—", 12, zngzleo(activity), true);
        textViewOxoagud.setTextIsSelectable(true);
        textViewOxoagud.setGravity(8388629);
        return textViewOxoagud;
    }

    public static ednetju xvxmcgn(String str) {
        int i;
        String strTrim;
        int iIndexOf;
        if (str == null || str.isEmpty()) {
            return ednetju.ojyssqt();
        }
        HashMap map = new HashMap();
        for (String str2 : str.split("\\r?\\n")) {
            if (str2 != null && (iIndexOf = (strTrim = str2.trim()).indexOf(58)) > 0) {
                map.put(strTrim.substring(0, iIndexOf).trim().toUpperCase(Locale.ROOT), strTrim.substring(iIndexOf + 1).trim());
            }
        }
        String str3 = (String) map.get("CHIP");
        String str4 = (String) map.get("STORAGE");
        String str5 = (String) map.get("BOOT MODE");
        String str6 = (String) map.get("DA PROTOCOL");
        String str7 = (String) map.get("HW CODE");
        String str8 = (String) map.get("HW SUBCODE");
        String str9 = (String) map.get("HW VERSION");
        String str10 = (String) map.get("SW VERSION");
        String str11 = (String) map.get("TARGET CONFIG");
        String str12 = (String) map.get("MEID");
        String str13 = (String) map.get("SOC ID");
        Boolean boolEenkamx = eenkamx((String) map.get("SBC"));
        Boolean boolEenkamx2 = eenkamx((String) map.get("SLA"));
        Boolean boolEenkamx3 = eenkamx((String) map.get("DAA"));
        String str14 = (String) map.get("PARTITIONS");
        if (str14 == null || str14.trim().isEmpty()) {
            i = -1;
        } else {
            try {
                i = Integer.parseInt(str14.trim());
            } catch (NumberFormatException unused) {
                i = -1;
            }
        }
        return new ednetju(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, boolEenkamx, boolEenkamx2, boolEenkamx3, i);
    }

    public static String ydsyayx(String str) {
        return str == null ? "" : str.trim();
    }

    public static GradientDrawable yhrqvll(Context context, int i, int i2, int i3) {
        return jvtqflj(context, i, i2, qunltjs(context, i3));
    }

    public static byte[] yjbrzgu(int i, String str, String str2) throws czgynww {
        String strReplace = ydsyayx(str).replace(" ", "");
        if (strReplace.startsWith("0x") || strReplace.startsWith("0X")) {
            strReplace = strReplace.substring(2);
        }
        if (strReplace.length() != i * 2 || !strReplace.matches("(?i)[0-9a-f]+")) {
            throw new czgynww("INVALID_CHALLENGE", 0, str2 + " must be exactly " + i + " bytes.", null);
        }
        byte[] bArr = new byte[i];
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            int i4 = Integer.parseInt(strReplace.substring(i3, i3 + 2), 16);
            bArr[i2] = (byte) i4;
            z |= i4 != 0;
        }
        if (z) {
            return bArr;
        }
        throw new czgynww("INVALID_CHALLENGE", 0, str2.concat(" cannot be all zero."), null);
    }

    public static JSONObject yjvhftf(String str, xhyvkax xhyvkaxVar, JSONObject jSONObject, int i, int i2) throws czgynww, IOException {
        if (xhyvkaxVar == null || !xhyvkaxVar.vivhedu()) {
            throw new czgynww("AUTH_REQUIRED", 401, "Account session is not available.", null);
        }
        long jMax = Math.max(1500L, ((long) i) + ((long) i2)) + System.currentTimeMillis();
        zegwdrn(str, xhyvkaxVar, false, jMax, i, i2);
        int[] iArrChwohho = chwohho(jMax, i, i2);
        try {
            return araemok(str, xhyvkaxVar.ojyssqt, jSONObject, iArrChwohho[0], iArrChwohho[1]);
        } catch (czgynww e) {
            if (e.ojyssqt != 401 || xhyvkaxVar.vivhedu.isEmpty()) {
                throw e;
            }
            zegwdrn(str, xhyvkaxVar, true, jMax, i, i2);
            int[] iArrChwohho2 = chwohho(jMax, i, i2);
            return araemok(str, xhyvkaxVar.ojyssqt, jSONObject, iArrChwohho2[0], iArrChwohho2[1]);
        }
    }

    public static LinearLayout yojulhu(Activity activity, int i, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        LinearLayout linearLayoutGhkjjru = ghkjjru(activity);
        TextView textViewYsaclsr = ysaclsr(activity, i);
        enxkjpu(activity, textViewYsaclsr, i3, nmpwovh(activity));
        linearLayoutGhkjjru.addView(textViewYsaclsr);
        TextView textViewOxoagud = oxoagud(activity, activity.getString(i2), 12, jbmzxye(activity), false);
        textViewOxoagud.setPadding(0, activity.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top), 0, activity.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom));
        linearLayoutGhkjjru.addView(textViewOxoagud);
        TextView textViewLclupha = lclupha(activity, activity.getString(i4), onClickListener);
        enxkjpu(activity, textViewLclupha, i3, i5);
        if (i4 == R.string.parts_flash_multiple) {
            textViewLclupha.setTextColor(kggugdp(activity));
            enxkjpu(activity, textViewLclupha, i3, kggugdp(activity));
            textViewLclupha.setBackground(jvtqflj(activity, ojyssqt(activity), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.ui_button_radius)));
        }
        linearLayoutGhkjjru.addView(textViewLclupha, new LinearLayout.LayoutParams(-1, activity.getResources().getDimensionPixelSize(R.dimen.batch_flow_action_height)));
        return linearLayoutGhkjjru;
    }

    public static LinearLayout.LayoutParams yomtcav() {
        return new LinearLayout.LayoutParams(0, -2, 1.0f);
    }

    public static boolean yonoayx(Context context) {
        return (Build.VERSION.SDK_INT < 31 || context.getResources().getIdentifier("system_accent1_600", "color", "android") == 0 || context.getResources().getIdentifier("system_neutral1_10", "color", "android") == 0) ? false : true;
    }

    public static LinearLayout.LayoutParams yrgokys(kggugdp kggugdpVar) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, kggugdpVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_step_height), 1.0f);
        int dimensionPixelSize = kggugdpVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_step_gap);
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        return layoutParams;
    }

    public static TextView ysaclsr(Context context, int i) {
        TextView textViewOxoagud = oxoagud(context, context.getString(i), 11, nmpwovh(context), true);
        textViewOxoagud.setLetterSpacing(0.06f);
        return textViewOxoagud;
    }

    public static boolean ysluikv(Context context) {
        return context.getSharedPreferences("rynx_ui", 0).getBoolean("dark_mode", false);
    }

    public static TextView ywhgqsi(Context context, String str) {
        TextView textViewOxoagud = oxoagud(context, str, 23, zngzleo(context), true);
        textViewOxoagud.setPadding(0, 0, 0, context.getResources().getDimensionPixelSize(R.dimen.ui_title_bottom_spacing));
        return textViewOxoagud;
    }

    public static hiofinr yxcmoyp(String str, xhyvkax xhyvkaxVar, String str2, String str3, String str4, int i) throws czgynww {
        JSONObject jSONObjectMdepcqh = mdepcqh("xiaomi_prepare", str2, str3, str4);
        zzqmpyp(jSONObjectMdepcqh, "expected_cost", Integer.valueOf(i));
        JSONObject jSONObjectJofyvuh = jofyvuh(str, xhyvkaxVar, jSONObjectMdepcqh);
        String strOptString = jSONObjectJofyvuh.optString("attempt_id", "");
        if (strOptString.isEmpty()) {
            throw new czgynww("INVALID_RESPONSE", 0, "Authorization server did not return an attempt id.", null);
        }
        int iOptInt = jSONObjectJofyvuh.optInt("balance", -1);
        int iOptInt2 = jSONObjectJofyvuh.optInt("held", 0);
        return new hiofinr(strOptString, jSONObjectJofyvuh.optString("mode", str4), jSONObjectJofyvuh.optString("chipset", str3), jSONObjectJofyvuh.optInt("cost", i), iOptInt, iOptInt2, jSONObjectJofyvuh.optInt("available", iOptInt >= 0 ? Math.max(0, iOptInt - iOptInt2) : -1), jSONObjectJofyvuh.optLong("expires_at_epoch", 0L));
    }

    public static void zegwdrn(String str, xhyvkax xhyvkaxVar, boolean z, long j, int i, int i2) {
        if (z || xhyvkax.nmpwovh(xhyvkaxVar)) {
            synchronized (xhyvkaxVar) {
                if (!z) {
                    try {
                        if (!xhyvkax.nmpwovh(xhyvkaxVar)) {
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                int[] iArrChwohho = chwohho(j, i, i2);
                xhyvkax.ojyssqt(xhyvkaxVar, iilntfn(str, xhyvkaxVar, iArrChwohho[0], iArrChwohho[1]));
            }
        }
    }

    public static TextView zftrkmx(Activity activity, String str, int i, int i2, float f, thbdbid thbdbidVar) {
        TextView textViewOxoagud = oxoagud(activity, "", 12, jbmzxye(activity), true);
        textViewOxoagud.setGravity(17);
        textViewOxoagud.setSingleLine(true);
        textViewOxoagud.setMaxLines(1);
        textViewOxoagud.setEllipsize(TextUtils.TruncateAt.END);
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.bottom_nav_item_padding_horizontal);
        textViewOxoagud.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        textViewOxoagud.setContentDescription(activity.getString(i));
        textViewOxoagud.setTag(new ibfmasn(i, i2, str));
        enxkjpu(activity, textViewOxoagud, i2, jbmzxye(activity));
        textViewOxoagud.setCompoundDrawablePadding(0);
        textViewOxoagud.setBackground(jvtqflj(activity, activity.getColor(R.color.rynx_transparent), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.bottom_nav_item_radius)));
        final int integer = activity.getResources().getInteger(R.integer.bottom_nav_press_in_ms);
        final int integer2 = activity.getResources().getInteger(R.integer.bottom_nav_press_out_ms);
        textViewOxoagud.setOnTouchListener(new View.OnTouchListener() { // from class: x.ljwltks
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.animate().scaleX(0.96f).scaleY(0.96f).setDuration(integer).start();
                    return false;
                }
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return false;
                }
                view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(integer2).start();
                return false;
            }
        });
        textViewOxoagud.setOnClickListener(new pzqxblc(thbdbidVar, str, 5));
        return textViewOxoagud;
    }

    public static int zngzleo(Context context) {
        return thbdbid(context, "system_neutral1_900", "system_neutral1_100", R.color.rynx_light_text_primary, R.color.rynx_dark_text_primary);
    }

    public static LinearLayout zwaqeaz(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(rpilpcp(context, R.dimen.ui_card_padding_horizontal), context.getResources().getDimensionPixelSize(R.dimen.ui_card_padding_vertical), context.getResources().getDimensionPixelSize(R.dimen.ui_card_padding_horizontal), context.getResources().getDimensionPixelSize(R.dimen.ui_card_padding_vertical));
        linearLayout.setBackground(jvtqflj(context, czidoiw(context), slxntng(context), qunltjs(context, nhhacgu(context))));
        return linearLayout;
    }

    public static void zzqmpyp(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }
}
