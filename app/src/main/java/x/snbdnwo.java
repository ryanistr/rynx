package x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class snbdnwo extends AnimatorListenerAdapter {
    public final /* synthetic */ TextView nmpwovh;
    public final /* synthetic */ FrameLayout ojyssqt;

    public snbdnwo(TextView textView, FrameLayout frameLayout) {
        this.nmpwovh = textView;
        this.ojyssqt = frameLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        TextView textView = this.nmpwovh;
        ViewParent parent = textView.getParent();
        FrameLayout frameLayout = this.ojyssqt;
        if (parent == frameLayout) {
            frameLayout.removeView(textView);
        }
    }
}
