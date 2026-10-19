package x;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Insets;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class zfmpmio {
    public static final WeakHashMap nmpwovh = new WeakHashMap();
    public static final WeakHashMap ojyssqt = new WeakHashMap();

    public static void lthborb(Activity activity, View view, boolean z) {
        if (view == null) {
            return;
        }
        view.animate().cancel();
        if (!ValueAnimator.areAnimatorsEnabled()) {
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
        } else {
            view.setAlpha(0.0f);
            view.setTranslationX(zamkzqg.qunltjs(activity, z ? 12 : -12));
            view.animate().alpha(1.0f).translationX(0.0f).setDuration(190L).setInterpolator(new DecelerateInterpolator()).start();
        }
    }

    public static void nmpwovh(Activity activity, String str, boolean z) {
        FrameLayout frameLayout;
        int iMax;
        if (activity == null || str == null || str.length() == 0 || (frameLayout = (FrameLayout) activity.findViewById(R.id.content)) == null) {
            return;
        }
        WeakHashMap weakHashMap = ojyssqt;
        View view = (View) weakHashMap.remove(activity);
        if (view != null) {
            view.animate().cancel();
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        }
        TextView textView = new TextView(activity);
        textView.setText(str);
        textView.setTextSize(13.0f);
        textView.setMaxLines(2);
        textView.setTypeface(Typeface.DEFAULT, 1);
        textView.setTextColor(z ? zamkzqg.kggugdp(activity) : zamkzqg.zngzleo(activity));
        textView.setGravity(16);
        int iQunltjs = zamkzqg.qunltjs(activity, 16);
        int iQunltjs2 = zamkzqg.qunltjs(activity, 12);
        textView.setPadding(iQunltjs, iQunltjs2, iQunltjs, iQunltjs2);
        textView.setBackground(zamkzqg.jvtqflj(activity, z ? zamkzqg.ojyssqt(activity) : zamkzqg.atntgcp(activity), z ? zamkzqg.nmpwovh(activity) : zamkzqg.qyeibyo(activity), zamkzqg.qunltjs(activity, 14)));
        textView.setElevation(zamkzqg.qunltjs(activity, 12));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        int iQunltjs3 = zamkzqg.qunltjs(activity, 16);
        int iQunltjs4 = zamkzqg.qunltjs(activity, 12);
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(com.rynx.app.R.dimen.bottom_nav_container_height);
        int i = Build.VERSION.SDK_INT;
        WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
        if (rootWindowInsets == null) {
            iMax = dimensionPixelSize + iQunltjs4;
        } else if (i >= 30) {
            Insets insets = rootWindowInsets.getInsets(WindowInsets.Type.systemBars());
            dimensionPixelSize = rootWindowInsets.isVisible(WindowInsets.Type.ime()) ? Math.max(insets.bottom, rootWindowInsets.getInsets(WindowInsets.Type.ime()).bottom) : dimensionPixelSize + insets.bottom;
            iMax = dimensionPixelSize + iQunltjs4;
        } else {
            iMax = Math.max(0, rootWindowInsets.getStableInsetBottom()) + dimensionPixelSize + iQunltjs4;
        }
        layoutParams.setMargins(iQunltjs3, 0, iQunltjs3, iMax);
        frameLayout.addView(textView, layoutParams);
        weakHashMap.put(activity, textView);
        if (ValueAnimator.areAnimatorsEnabled()) {
            textView.setAlpha(0.0f);
            textView.setTranslationY(zamkzqg.qunltjs(activity, 14));
            textView.animate().alpha(1.0f).translationY(0.0f).setDuration(190L).setInterpolator(new DecelerateInterpolator()).start();
        }
        textView.postDelayed(new ekyqleu(activity, frameLayout, textView, 8), z ? 3000L : 5000L);
    }

    public static void ojyssqt(View view) {
        if (view == null || !ValueAnimator.areAnimatorsEnabled()) {
            return;
        }
        view.animate().cancel();
        view.setScaleX(0.94f);
        view.setScaleY(0.94f);
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(130L).setInterpolator(new DecelerateInterpolator()).start();
    }

    public static void vivhedu(ProgressBar progressBar, boolean z) {
        if (progressBar == null || progressBar.isIndeterminate() == z) {
            return;
        }
        progressBar.setIndeterminate(z);
        if (ValueAnimator.areAnimatorsEnabled()) {
            ojyssqt(progressBar);
        }
    }
}
