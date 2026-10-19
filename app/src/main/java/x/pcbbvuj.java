package x;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.rynx.app.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class pcbbvuj extends BaseAdapter {
    public final ArrayList nmpwovh = new ArrayList();
    public final /* synthetic */ ecffprn ojyssqt;

    public pcbbvuj(ecffprn ecffprnVar) {
        this.ojyssqt = ecffprnVar;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.nmpwovh.size();
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        fprgbbe fprgbbeVar;
        View view2;
        String str;
        int i2;
        int i3 = -1;
        if ((view instanceof LinearLayout) && (view.getTag() instanceof fprgbbe)) {
            View view3 = (LinearLayout) view;
            fprgbbeVar = (fprgbbe) view.getTag();
            view2 = view3;
        } else {
            ecffprn ecffprnVar = this.ojyssqt;
            LinearLayout linearLayout = new LinearLayout(ecffprnVar.nmpwovh);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.setPadding(ecffprnVar.nmpwovh(8), ecffprnVar.nmpwovh(8), ecffprnVar.nmpwovh(8), ecffprnVar.nmpwovh(8));
            Activity activity = ecffprnVar.nmpwovh;
            ImageView imageView = new ImageView(activity);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(ecffprnVar.nmpwovh(40), ecffprnVar.nmpwovh(40)));
            LinearLayout linearLayout2 = new LinearLayout(activity);
            linearLayout2.setOrientation(1);
            linearLayout2.setPadding(ecffprnVar.nmpwovh(10), 0, ecffprnVar.nmpwovh(8), 0);
            TextView textView = new TextView(activity);
            textView.setTextSize(15.0f);
            textView.setSingleLine(true);
            linearLayout2.addView(textView, new LinearLayout.LayoutParams(-1, -2));
            TextView textView2 = new TextView(activity);
            textView2.setTextSize(11.0f);
            textView2.setSingleLine(true);
            linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(0, -2, 1.0f));
            ImageView imageView2 = new ImageView(activity);
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            linearLayout.addView(imageView2, new LinearLayout.LayoutParams(ecffprnVar.nmpwovh(28), ecffprnVar.nmpwovh(40)));
            fprgbbeVar = new fprgbbe(imageView, textView, textView2, imageView2);
            linearLayout.setTag(fprgbbeVar);
            view2 = linearLayout;
        }
        File item = getItem(i);
        if (item == null) {
            return view2;
        }
        boolean zIsDirectory = item.isDirectory();
        fprgbbeVar.nmpwovh.setImageResource(zIsDirectory ? R.drawable.ic_internal_picker_folder : R.drawable.ic_internal_picker_file);
        String name = item.getName();
        TextView textView3 = fprgbbeVar.ojyssqt;
        textView3.setText(name);
        textView3.setTypeface(Typeface.DEFAULT, zIsDirectory ? 1 : 0);
        ImageView imageView3 = fprgbbeVar.lthborb;
        TextView textView4 = fprgbbeVar.vivhedu;
        if (zIsDirectory) {
            textView4.setText("");
            textView4.setVisibility(8);
            imageView3.setImageResource(R.drawable.ic_internal_picker_chevron_right);
            imageView3.setVisibility(0);
        } else {
            textView4.setVisibility(0);
            long length = item.length();
            if (length < 1024) {
                str = length + " B";
            } else {
                double d = length;
                String[] strArr = {"KiB", "MiB", "GiB", "TiB"};
                while (d >= 1024.0d && (i2 = i3 + 1) < 4) {
                    d /= 1024.0d;
                    i3 = i2;
                }
                str = String.format(Locale.ROOT, d >= 100.0d ? "%.0f %s" : "%.1f %s", Double.valueOf(d), strArr[i3]);
            }
            textView4.setText(str);
            imageView3.setVisibility(4);
        }
        return view2;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: nmpwovh, reason: merged with bridge method [inline-methods] */
    public final File getItem(int i) {
        if (i >= 0) {
            ArrayList arrayList = this.nmpwovh;
            if (i < arrayList.size()) {
                return (File) arrayList.get(i);
            }
        }
        return null;
    }
}
