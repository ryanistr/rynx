package x;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.rynx.app.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class osgyung extends BaseAdapter {
    public final String lthborb;
    public final com.rynx.app.nmpwovh nmpwovh;
    public final ArrayList ojyssqt;
    public final ArrayList vivhedu;

    public osgyung(com.rynx.app.nmpwovh nmpwovhVar, List list, zwccvwt zwccvwtVar) {
        ArrayList arrayList = new ArrayList();
        this.ojyssqt = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.vivhedu = arrayList2;
        this.nmpwovh = nmpwovhVar;
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList2.addAll(arrayList);
        this.lthborb = zwccvwtVar == null ? "" : zwccvwtVar.ojyssqt();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.vivhedu.size();
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        zwccvwt item = getItem(i);
        if (item != null) {
            i = item.ojyssqt().hashCode();
        }
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        qppdydr qppdydrVar;
        boolean z2 = view instanceof LinearLayout;
        String string = "";
        com.rynx.app.nmpwovh nmpwovhVar = this.nmpwovh;
        if (z2 && (view.getTag() instanceof qppdydr)) {
            qppdydrVar = (qppdydr) view.getTag();
            z = true;
        } else {
            LinearLayout linearLayoutXbdyiew = zamkzqg.xbdyiew(nmpwovhVar, 0);
            linearLayoutXbdyiew.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 4), 0, zamkzqg.qunltjs(nmpwovhVar, 4));
            LinearLayout linearLayoutXbdyiew2 = zamkzqg.xbdyiew(nmpwovhVar, 0);
            linearLayoutXbdyiew2.setPadding(zamkzqg.qunltjs(nmpwovhVar, 14), zamkzqg.qunltjs(nmpwovhVar, 11), zamkzqg.qunltjs(nmpwovhVar, 14), zamkzqg.qunltjs(nmpwovhVar, 11));
            linearLayoutXbdyiew.addView(linearLayoutXbdyiew2, new LinearLayout.LayoutParams(-1, -2));
            LinearLayout linearLayoutLvtqoqa = zamkzqg.lvtqoqa(nmpwovhVar);
            linearLayoutLvtqoqa.setGravity(16);
            TextView textViewOxoagud = zamkzqg.oxoagud(nmpwovhVar, "", 14, zamkzqg.zngzleo(nmpwovhVar), true);
            textViewOxoagud.setTypeface(Typeface.DEFAULT, 1);
            linearLayoutLvtqoqa.addView(textViewOxoagud, new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textViewOxoagud2 = zamkzqg.oxoagud(nmpwovhVar, "", 9, zamkzqg.jbmzxye(nmpwovhVar), true);
            textViewOxoagud2.setGravity(17);
            textViewOxoagud2.setPadding(zamkzqg.qunltjs(nmpwovhVar, 8), zamkzqg.qunltjs(nmpwovhVar, 4), zamkzqg.qunltjs(nmpwovhVar, 8), zamkzqg.qunltjs(nmpwovhVar, 4));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = zamkzqg.qunltjs(nmpwovhVar, 8);
            linearLayoutLvtqoqa.addView(textViewOxoagud2, layoutParams);
            linearLayoutXbdyiew2.addView(linearLayoutLvtqoqa);
            TextView textViewOxoagud3 = zamkzqg.oxoagud(nmpwovhVar, "", 11, zamkzqg.jbmzxye(nmpwovhVar), false);
            textViewOxoagud3.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 5), 0, 0);
            linearLayoutXbdyiew2.addView(textViewOxoagud3);
            TextView textViewOxoagud4 = zamkzqg.oxoagud(nmpwovhVar, nmpwovhVar.getString(R.string.xiaomi_device_picker_selected), 10, zamkzqg.nmpwovh(nmpwovhVar), true);
            textViewOxoagud4.setPadding(0, zamkzqg.qunltjs(nmpwovhVar, 7), 0, 0);
            textViewOxoagud4.setVisibility(8);
            linearLayoutXbdyiew2.addView(textViewOxoagud4);
            z = true;
            qppdydr qppdydrVar2 = new qppdydr(linearLayoutXbdyiew, linearLayoutXbdyiew2, textViewOxoagud, textViewOxoagud2, textViewOxoagud3, textViewOxoagud4);
            linearLayoutXbdyiew.setTag(qppdydrVar2);
            qppdydrVar = qppdydrVar2;
        }
        zwccvwt item = getItem(i);
        boolean z3 = (item == null || !this.lthborb.equals(item.ojyssqt())) ? false : z;
        qppdydrVar.vivhedu.setText(item == null ? "—" : item.ojyssqt);
        boolean z4 = (item == null || !"new_security".equalsIgnoreCase(item.dplrlfq)) ? false : z;
        int i2 = (z4 || (item != null && "legacy".equalsIgnoreCase(item.dplrlfq))) ? 0 : 8;
        TextView textView = qppdydrVar.lthborb;
        textView.setVisibility(i2);
        textView.setText(z4 ? R.string.xiaomi_security_mode_new : R.string.xiaomi_security_mode_legacy);
        textView.setTextColor(z4 ? zamkzqg.nmpwovh(nmpwovhVar) : zamkzqg.jbmzxye(nmpwovhVar));
        textView.setBackground(zamkzqg.yhrqvll(nmpwovhVar, z4 ? zamkzqg.ojyssqt(nmpwovhVar) : zamkzqg.czidoiw(nmpwovhVar), z4 ? zamkzqg.nmpwovh(nmpwovhVar) : zamkzqg.slxntng(nmpwovhVar), 999));
        if (item != null) {
            ArrayList<String> arrayList = new ArrayList();
            String str = item.vivhedu;
            if (!str.isEmpty()) {
                arrayList.add(nmpwovhVar.getString(R.string.xiaomi_device_picker_codename, str));
            }
            String str2 = item.qxvquar;
            if (!str2.isEmpty()) {
                arrayList.add(str2);
            }
            String str3 = item.oqexvyb;
            if (!str3.isEmpty() && !str3.equalsIgnoreCase(str2)) {
                arrayList.add(str3);
            }
            String str4 = item.wqrnifx;
            if (!str4.isEmpty()) {
                arrayList.add(str4.toUpperCase(Locale.ROOT));
            }
            if (item.ekyqleu) {
                arrayList.add("AUTH");
            }
            StringBuilder sb = new StringBuilder();
            for (String str5 : arrayList) {
                if (sb.length() > 0) {
                    sb.append(" • ");
                }
                sb.append(str5);
            }
            string = sb.toString();
        }
        TextView textView2 = qppdydrVar.qxvquar;
        textView2.setText(string);
        textView2.setVisibility(string.isEmpty() ? 8 : 0);
        qppdydrVar.oqexvyb.setVisibility(z3 ? 0 : 8);
        qppdydrVar.ojyssqt.setBackground(zamkzqg.jvtqflj(nmpwovhVar, z3 ? zamkzqg.ojyssqt(nmpwovhVar) : zamkzqg.atntgcp(nmpwovhVar), z3 ? zamkzqg.nmpwovh(nmpwovhVar) : zamkzqg.slxntng(nmpwovhVar), zamkzqg.qunltjs(nmpwovhVar, 14)));
        return qppdydrVar.nmpwovh;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: nmpwovh, reason: merged with bridge method [inline-methods] */
    public final zwccvwt getItem(int i) {
        if (i < 0) {
            return null;
        }
        ArrayList arrayList = this.vivhedu;
        if (i >= arrayList.size()) {
            return null;
        }
        return (zwccvwt) arrayList.get(i);
    }
}
