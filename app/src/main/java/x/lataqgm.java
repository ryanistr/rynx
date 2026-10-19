package x;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class lataqgm extends ViewGroup {
    public final int nmpwovh;
    public final int ojyssqt;

    public lataqgm(com.rynx.app.nmpwovh nmpwovhVar, int i, int i2) {
        super(nmpwovhVar);
        this.nmpwovh = i;
        this.ojyssqt = i2;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, ((i3 - i) - getPaddingLeft()) - getPaddingRight());
        int paddingTop = getPaddingTop();
        int i5 = 0;
        int iMax2 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = this.nmpwovh;
                int i8 = i5 == 0 ? measuredWidth : i5 + i7 + measuredWidth;
                if (i5 > 0 && i8 > iMax) {
                    paddingTop += iMax2 + this.ojyssqt;
                    i5 = 0;
                    iMax2 = 0;
                }
                if (i5 > 0) {
                    i5 += i7;
                }
                int paddingLeft = getPaddingLeft() + i5;
                childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                i5 += measuredWidth;
                iMax2 = Math.max(iMax2, measuredHeight);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int iMax = Math.max(0, (size - getPaddingLeft()) - getPaddingRight());
        int paddingTop = getPaddingTop();
        int iMax2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i5 = this.nmpwovh;
                int i6 = i3 == 0 ? measuredWidth : i3 + i5 + measuredWidth;
                if (i3 > 0 && i6 > iMax) {
                    paddingTop += iMax2 + this.ojyssqt;
                    iMax2 = 0;
                    i3 = 0;
                }
                if (i3 > 0) {
                    i3 += i5;
                }
                i3 += measuredWidth;
                iMax2 = Math.max(iMax2, measuredHeight);
            }
        }
        setMeasuredDimension(View.resolveSize(size, i), View.resolveSize(getPaddingBottom() + paddingTop + iMax2, i2));
    }
}
