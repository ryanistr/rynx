package x;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class rvrflql implements sfildfy {
    public final Object nmpwovh;
    public final Object ojyssqt;
    public Object vivhedu;

    public rvrflql(Activity activity, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.vivhedu = "";
        this.nmpwovh = activity;
        this.ojyssqt = new TextView[]{textView, textView2, textView3, textView4};
    }

    @Override // x.sfildfy
    public void nmpwovh() {
        ((CountDownLatch) this.ojyssqt).countDown();
    }

    @Override // x.sfildfy
    public void ojyssqt(String str, String str2) {
        ((String[]) this.nmpwovh)[0] = str.trim();
        String[] strArr = (String[]) this.nmpwovh;
        strArr[1] = str2;
        if (!strArr[0].isEmpty() && !((String[]) this.nmpwovh)[1].isEmpty()) {
            synchronized (((MainActivity) this.vivhedu).sthdtww) {
                MainActivity mainActivity = (MainActivity) this.vivhedu;
                String[] strArr2 = (String[]) this.nmpwovh;
                mainActivity.hhqpjvl = strArr2[0];
                mainActivity.wjugzfh = strArr2[1];
            }
        }
        ((CountDownLatch) this.ojyssqt).countDown();
    }

    public void vivhedu(String str) {
        String str2 = str == null ? "home" : str;
        if (str2.equals((String) this.vivhedu)) {
            return;
        }
        this.vivhedu = str2;
        Activity activity = (Activity) this.nmpwovh;
        float integer = activity.getResources().getInteger(R.integer.bottom_nav_active_weight_x100) / 100.0f;
        float integer2 = activity.getResources().getInteger(R.integer.bottom_nav_inactive_weight_x100) / 100.0f;
        int integer3 = activity.getResources().getInteger(R.integer.bottom_nav_animation_ms);
        int integer4 = activity.getResources().getInteger(R.integer.bottom_nav_label_delay_ms);
        boolean zAreAnimatorsEnabled = ValueAnimator.areAnimatorsEnabled();
        TextView[] textViewArr = (TextView[]) this.ojyssqt;
        int length = textViewArr.length;
        int i = 0;
        while (i < length) {
            TextView textView = textViewArr[i];
            ibfmasn ibfmasnVar = (ibfmasn) textView.getTag();
            boolean zEquals = str2.equals(ibfmasnVar.nmpwovh);
            ibfmasnVar.lthborb = zEquals;
            float f = zEquals ? integer : integer2;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            float f2 = integer;
            if (layoutParams.weight != f) {
                layoutParams.weight = f;
                textView.setLayoutParams(layoutParams);
            }
            textView.animate().cancel();
            textView.setText("");
            textView.setEllipsize(TextUtils.TruncateAt.END);
            int i2 = ibfmasnVar.vivhedu;
            if (zEquals) {
                textView.setTextColor(zamkzqg.mamlotu(activity));
                textView.setTypeface(Typeface.DEFAULT, 1);
                zamkzqg.enxkjpu(activity, textView, i2, zamkzqg.mamlotu(activity));
                textView.setCompoundDrawablePadding(activity.getResources().getDimensionPixelSize(R.dimen.bottom_nav_item_icon_gap));
                textView.setBackground(zamkzqg.jvtqflj(activity, zamkzqg.sjexbpf(activity), zamkzqg.sjexbpf(activity), activity.getResources().getDimensionPixelSize(R.dimen.bottom_nav_item_radius)));
                textView.setElevation(activity.getResources().getDimensionPixelSize(R.dimen.bottom_nav_item_elevation));
                if (zAreAnimatorsEnabled) {
                    textView.setScaleX(0.96f);
                    textView.setScaleY(0.96f);
                    textView.setAlpha(0.72f);
                    textView.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(integer3).start();
                } else {
                    textView.setScaleX(1.0f);
                    textView.setScaleY(1.0f);
                    textView.setAlpha(1.0f);
                }
                qwgjehf qwgjehfVar = new qwgjehf(this, textView, str2, zAreAnimatorsEnabled);
                if (zAreAnimatorsEnabled) {
                    textView.postDelayed(qwgjehfVar, integer4);
                } else {
                    qwgjehfVar.run();
                }
            } else {
                textView.setTextColor(zamkzqg.jbmzxye(activity));
                textView.setTypeface(Typeface.DEFAULT, 0);
                zamkzqg.enxkjpu(activity, textView, i2, zamkzqg.jbmzxye(activity));
                textView.setCompoundDrawablePadding(0);
                textView.setBackground(zamkzqg.jvtqflj(activity, activity.getColor(R.color.rynx_transparent), activity.getColor(R.color.rynx_transparent), activity.getResources().getDimensionPixelSize(R.dimen.bottom_nav_item_radius)));
                textView.setElevation(0.0f);
                textView.setScaleX(1.0f);
                textView.setScaleY(1.0f);
                textView.setAlpha(0.9f);
            }
            i++;
            integer = f2;
        }
    }

    public rvrflql(MainActivity mainActivity, String[] strArr, CountDownLatch countDownLatch) {
        this.vivhedu = mainActivity;
        this.nmpwovh = strArr;
        this.ojyssqt = countDownLatch;
    }
}
