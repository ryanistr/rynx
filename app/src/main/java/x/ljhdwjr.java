package x;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.view.View;
import com.rynx.app.R;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class ljhdwjr extends View {
    public boolean lthborb;
    public int nkemejx;
    public final Movie nmpwovh;
    public boolean ojyssqt;
    public long oqexvyb;
    public boolean qxvquar;
    public boolean vivhedu;

    public ljhdwjr(Context context) {
        super(context);
        Movie movieDecodeStream = null;
        this.ojyssqt = false;
        this.vivhedu = false;
        this.lthborb = false;
        this.qxvquar = false;
        this.oqexvyb = 0L;
        this.nkemejx = 0;
        this.nmpwovh = movieDecodeStream;
        setLayerType(1, null);
        setVisibility(8);
    }

    public final void nmpwovh(Canvas canvas) {
        Movie movie = this.nmpwovh;
        float fMax = Math.max(1, movie.width());
        float fMax2 = Math.max(1, movie.height());
        float fMin = Math.min(getWidth() / fMax, getHeight() / fMax2);
        canvas.save();
        canvas.translate((getWidth() - (fMax * fMin)) / 2.0f, (getHeight() - (fMax2 * fMin)) / 2.0f);
        canvas.scale(fMin, fMin);
        movie.draw(canvas, 0.0f, 0.0f);
        canvas.restore();
    }

    public final void ojyssqt(boolean z) {
        this.nkemejx++;
        this.lthborb = z;
        this.qxvquar = false;
        this.vivhedu = false;
        this.ojyssqt = true;
        setVisibility(0);
        if (!isAttachedToWindow()) {
            invalidate();
            return;
        }
        this.ojyssqt = false;
        this.vivhedu = true;
        this.qxvquar = false;
        this.oqexvyb = SystemClock.uptimeMillis();
        invalidate();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ojyssqt) {
            this.ojyssqt = false;
            this.vivhedu = true;
            this.qxvquar = false;
            this.oqexvyb = SystemClock.uptimeMillis();
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.nkemejx++;
        this.vivhedu = false;
        this.ojyssqt = false;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Movie movie = this.nmpwovh;
        if (movie == null) {
            if (this.lthborb) {
                return;
            }
            setVisibility(8);
            return;
        }
        int iDuration = movie.duration() <= 0 ? 6000 : movie.duration();
        if (!this.vivhedu) {
            if (this.qxvquar) {
                movie.setTime(Math.max(0, iDuration - 1));
                nmpwovh(canvas);
                return;
            }
            return;
        }
        long jMax = Math.max(0L, SystemClock.uptimeMillis() - this.oqexvyb);
        if (jMax < iDuration) {
            movie.setTime((int) jMax);
            nmpwovh(canvas);
            postInvalidateOnAnimation();
            return;
        }
        this.vivhedu = false;
        this.qxvquar = this.lthborb;
        movie.setTime(Math.max(0, iDuration - 1));
        nmpwovh(canvas);
        if (this.lthborb) {
            return;
        }
        post(new btazysh(this, this.nkemejx, 1));
    }
}
