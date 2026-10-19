package x;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Environment;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class kggugdp extends com.rynx.app.nmpwovh {
    public int osgyung;

    public static boolean bpqosqe(bpqosqe bpqosqeVar, File file, String str) {
        if (file == null || !file.isFile() || !file.canRead() || file.length() <= 0) {
            return false;
        }
        ArrayList arrayListCugubfc = cugubfc(bpqosqeVar, str);
        if (arrayListCugubfc.isEmpty()) {
            return false;
        }
        Iterator it = arrayListCugubfc.iterator();
        while (it.hasNext()) {
            if (file.length() > ((ohwxijw) it.next()).vivhedu) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList cugubfc(bpqosqe bpqosqeVar, String str) {
        ArrayList arrayList = new ArrayList();
        ohwxijw ohwxijwVar = bpqosqeVar.vivhedu;
        ohwxijw ohwxijwVar2 = bpqosqeVar.ojyssqt;
        if (ohwxijwVar2 == null && ohwxijwVar == null) {
            ohwxijw ohwxijwVar3 = bpqosqeVar.lthborb;
            if (ohwxijwVar3 != null) {
                arrayList.add(ohwxijwVar3);
            }
            return arrayList;
        }
        if ("a".equals(str)) {
            if (ohwxijwVar2 != null) {
                arrayList.add(ohwxijwVar2);
            }
            return arrayList;
        }
        if ("b".equals(str)) {
            if (ohwxijwVar != null) {
                arrayList.add(ohwxijwVar);
            }
            return arrayList;
        }
        if (ohwxijwVar2 != null) {
            arrayList.add(ohwxijwVar2);
        }
        if (ohwxijwVar != null) {
            arrayList.add(ohwxijwVar);
        }
        return arrayList;
    }

    public static void ibfmasn(View view) {
        if (view == null) {
            return;
        }
        view.animate().cancel();
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public static int iilntfn(String str) {
        if ("home".equals(str)) {
            return 0;
        }
        if ("menu".equals(str) || "parts".equals(str) || "flash".equals(str) || "xiaomi_authorize".equals(str)) {
            return 1;
        }
        if ("terminal".equals(str)) {
            return 2;
        }
        return "settings".equals(str) ? 3 : -1;
    }

    public static String jvtqflj(String str) {
        if (str == null) {
            str = "";
        }
        if (str.length() > 2) {
            return str.regionMatches(true, str.length() + (-2), "_a", 0, 2) ? str.substring(0, str.length() - 2) : str;
        }
        return str;
    }

    public static String npkgpdo(String str) {
        if (str == null) {
            return "";
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return (lowerCase.endsWith("_a") || lowerCase.endsWith("_b") || lowerCase.endsWith("-a") || lowerCase.endsWith("-b")) ? lowerCase.substring(0, lowerCase.length() - 2) : lowerCase;
    }

    public static void nsbgblf(TextView textView) {
        CharSequence text = textView.getText();
        if (text == null || text.length() <= 24000) {
            return;
        }
        int iMax = Math.max(0, text.length() - 18000);
        int i = iMax;
        while (i < text.length() - 1 && text.charAt(i) != '\n') {
            i++;
        }
        if (i < text.length() - 1) {
            iMax = i + 1;
        }
        textView.setText(text.subSequence(iMax, text.length()).toString());
    }

    public static String oohojlj(bpqosqe bpqosqeVar, String str) {
        String str2 = "green";
        for (ohwxijw ohwxijwVar : (ArrayList<ohwxijw>) cugubfc(bpqosqeVar, str)) {
            if (ohwxijwVar.nmpwovh()) {
                return "red";
            }
            if ("yellow".equals(ohwxijwVar.oqexvyb)) {
                str2 = "yellow";
            }
        }
        return str2;
    }

    public final String araemok(String str) {
        if ("a".equals(str)) {
            return getString(R.string.batch_flash_slot_a);
        }
        return "b".equals(str) ? getString(R.string.batch_flash_slot_b) : getString(R.string.batch_flash_slot_all);
    }

    @Override // com.rynx.app.ojyssqt
    public final void buswjhz() {
        vhimehb vhimehbVar;
        if (this.kxotgjb) {
            finish();
            return;
        }
        if (this.lataqgm && this.civyupy && this.eigllth != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.eigllth.getWindowToken(), 0);
            }
            this.eigllth.clearFocus();
            this.civyupy = false;
            jtfjrri(true);
            return;
        }
        if (this.lpkdqgx && ("partition_backup_progress".equals(this.ayzlrnr) || "flash_progress".equals(this.ayzlrnr) || "batch_operation_progress".equals(this.ayzlrnr))) {
            Toast.makeText(this, "flash_progress".equals(this.ayzlrnr) ? R.string.flash_still_running : R.string.parts_backup_running_warning, 0).show();
            return;
        }
        if (this.tqcgjht.isEmpty() || (vhimehbVar = (vhimehb) this.tqcgjht.removeLast()) == null) {
            if ("home".equals(this.ayzlrnr)) {
                finish();
                return;
            }
            eigllth("home");
            this.zhpnlmy = "home";
            this.lataqgm = false;
            kxotgjb(this.lvtqoqa, -1);
            rvrflql rvrflqlVar = this.jybecxv;
            if (rvrflqlVar != null) {
                rvrflqlVar.vivhedu(this.zhpnlmy);
            }
            gefzxcg();
            return;
        }
        boolean z = this.lataqgm;
        int iIilntfn = iilntfn(this.zhpnlmy);
        eigllth(vhimehbVar.vivhedu);
        this.zhpnlmy = vhimehbVar.ojyssqt;
        this.lataqgm = vhimehbVar.lthborb;
        jtfjrri(true);
        int iIilntfn2 = iilntfn(this.zhpnlmy);
        int iCompare = Integer.compare(iIilntfn2, iIilntfn);
        if (iIilntfn2 < 0 || iIilntfn < 0) {
            iCompare = 0;
        }
        kxotgjb(vhimehbVar.nmpwovh, iCompare);
        rvrflql rvrflqlVar2 = this.jybecxv;
        if (rvrflqlVar2 != null) {
            rvrflqlVar2.vivhedu(this.zhpnlmy);
        }
        if (!this.lataqgm && this.eigllth != null) {
            InputMethodManager inputMethodManager2 = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager2 != null) {
                inputMethodManager2.hideSoftInputFromWindow(this.eigllth.getWindowToken(), 0);
            }
            this.eigllth.clearFocus();
        }
        if (this.lataqgm && this.civyupy) {
            ltnesel();
        }
        if (!z || this.lataqgm) {
            gefzxcg();
        } else {
            bgmsltp();
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void bwvplah(boolean z) {
        this.prywqjr = z;
        TextView textView = this.jzcfpou;
        if (textView != null) {
            textView.setBackground(x.zamkzqg.jvtqflj(this, z ? this.ojyssqt : this.wqrnifx, z ? this.vivhedu : this.wqrnifx, x.zamkzqg.qunltjs(this, 9)));
            this.jzcfpou.setTextColor(z ? this.imuemzb : this.dasxvpc);
        }
        TextView textView2 = this.odhctch;
        if (textView2 != null) {
            textView2.setBackground(x.zamkzqg.jvtqflj(this, z ? this.oqexvyb : this.ojyssqt, z ? this.oqexvyb : this.vivhedu, x.zamkzqg.qunltjs(this, 9)));
            this.odhctch.setTextColor(z ? -16777216 : this.imuemzb);
        }
        lvtqoqa();
    }

    public final File chwohho() throws IOException {
        File file = new File(Environment.getExternalStorageDirectory(), "rynx/Backup");
        if ((!file.isDirectory() && !file.mkdirs()) || !file.isDirectory()) {
            throw new IOException(getString(R.string.parts_create_backup_dir_failed));
        }
        String str = !com.rynx.app.ojyssqt.zwaqeaz(this.cnctlxz.wqrnifx) ? this.cnctlxz.wqrnifx : this.cnctlxz.dasxvpc;
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() && sb.length() < 12; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isLetterOrDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        if (sb.length() == 0) {
            sb.append("device");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (int i2 = 0; i2 < 100; i2++) {
            StringBuilder sb2 = new StringBuilder("FirmwareUpgrade-");
            sb2.append((Object) sb);
            sb2.append("-");
            sb2.append(jCurrentTimeMillis);
            sb2.append(i2 == 0 ? "" : "-" + i2);
            File file2 = new File(file, sb2.toString());
            if (!file2.exists()) {
                return file2;
            }
        }
        throw new IOException("Unable to reserve a unique Firmware Upgrade backup folder");
    }

    public final void cnctlxz() {
        try {
            ArrayList<araemok> arrayListYjvhftf = yjvhftf();
            String strLjhdwjr = ljhdwjr(arrayListYjvhftf);
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (araemok araemokVar : arrayListYjvhftf) {
                ohwxijw ohwxijwVar = araemokVar.nmpwovh;
                z |= ohwxijwVar.nkemejx;
                String strJvtqflj = jvtqflj(ohwxijwVar.nmpwovh);
                ohwxijw ohwxijwVar2 = araemokVar.nmpwovh;
                String strJvtqflj2 = jvtqflj(ohwxijwVar2.nmpwovh);
                File file = araemokVar.ojyssqt;
                arrayList.add(new tnejqcj(strJvtqflj, strJvtqflj2, file.getName(), getString(R.string.batch_flash_review_image_meta, ohwxijwVar2.lthborb, x.zamkzqg.jybecxv(file.length()), x.zamkzqg.jybecxv(ohwxijwVar2.vivhedu)), ohwxijwVar2.oqexvyb));
            }
            kffvigz(x.zamkzqg.vntpaom(this, getString("firmware_upgrade".equals(this.ijakhcl) ? R.string.scatter_firmware_upgrade_review_target : R.string.scatter_review_target), arrayList, z, new dplrlfq(this, strLjhdwjr)), "scatter_review");
        } catch (Throwable th) {
            Toast.makeText(this, String.valueOf(th.getMessage()), 1).show();
            gzokllk();
        }
    }

    public final String ednetju(File file) {
        boolean zUdgizdi;
        String strTrim;
        if (!this.nsyqsfj || file == null) {
            return "";
        }
        try {
            x.pwjmwpv.lclupha(file);
            boolean zDytyqos = x.pwjmwpv.dytyqos(file);
            if (zDytyqos) {
                zUdgizdi = udgizdi();
            } else {
                boolean z = false;
                if (this.cnctlxz != null && this.cnctlxz.lthborb != null) {
                    String upperCase = this.cnctlxz.lthborb.trim().toUpperCase(Locale.ROOT);
                    if (upperCase.contains("XFLASH") && upperCase.contains("V5")) {
                        z = true;
                    }
                }
                zUdgizdi = z;
            }
            if (zUdgizdi) {
                return "";
            }
            if (this.cnctlxz == null) {
                strTrim = "UNKNOWN";
            } else {
                String str = this.cnctlxz.lthborb;
                strTrim = (str != null ? str : "").trim();
            }
            return getString(R.string.scatter_protocol_mismatch, zDytyqos ? "XML" : "TXT", zDytyqos ? "XML/V6" : "XFlash/V5", strTrim.isEmpty() ? "UNKNOWN" : strTrim);
        } catch (IOException e) {
            return String.valueOf(e.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0064 A[LOOP:0: B:30:0x005a->B:33:0x0064, LOOP_END] */
    public final void eenkamx(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            runOnUiThread(new naaizwn(0, str, this));
            return;
        }
        TextView textView = this.dkpobjg;
        if (textView == null || isFinishing() || isDestroyed()) {
            return;
        }
        if (this.qwpvrdy != textView) {
            this.qwpvrdy = textView;
            this.fixfqug = false;
        }
        CharSequence text = textView.getText();
        if (!this.fixfqug || text == null || text.length() <= 0) {
            textView.append(str);
            textView.append("\n");
        } else {
            int length = text.length();
            if (length > 0) {
                if (text.charAt(length - 1) == '\n') {
                    length--;
                } else {
                    length--;
                }
                while (length > 0 && text.charAt(length - 1) != '\n') {
                    length--;
                }
                StringBuilder sb = new StringBuilder(str.length() + length + 1);
                sb.append(text, 0, length);
                sb.append(str);
                sb.append('\n');
                textView.setText(sb.toString());
            }
            while (length > 0) {
                length--;
            }
            StringBuilder sb2 = new StringBuilder(str.length() + length + 1);
            sb2.append(text, 0, length);
            sb2.append(str);
            sb2.append('\n');
            textView.setText(sb2.toString());
        }
        this.fixfqug = true;
        nsbgblf(textView);
    }

    @Override // com.rynx.app.ojyssqt
    public final void eigllth(String str) {
        if (str == null) {
            str = "home";
        }
        this.ayzlrnr = str;
        ccuulnt ccuulntVar = this.suqlntg;
        if (ccuulntVar != null) {
            boolean zEquals = "android_tools".equals(str);
            ccuulntVar.qxvquar = zEquals;
            if (zEquals) {
                ccuulntVar.nmpwovh(true);
            }
        }
    }

    public final void enxkjpu(ohwxijw ohwxijwVar) {
        if (wjugzfh()) {
            if (this.lpkdqgx || this.ywhgqsi) {
                Toast.makeText(this, R.string.error_busy, 0).show();
                return;
            }
            File file = new File(Environment.getExternalStorageDirectory(), "rynx/Backup");
            if (!file.exists() && !file.mkdirs()) {
                Toast.makeText(this, R.string.parts_create_backup_dir_failed, 1).show();
                return;
            }
            File fileCzidoiw = com.rynx.app.ojyssqt.czidoiw(file, ohwxijwVar.nmpwovh);
            final xbdyiew xbdyiewVar = new xbdyiew(this);
            ScrollView scrollView = new ScrollView(this);
            scrollView.setFillViewport(true);
            LinearLayout linearLayoutXbdyiew = x.zamkzqg.xbdyiew(this, 16);
            scrollView.addView(linearLayoutXbdyiew);
            int iNmpwovh = x.zamkzqg.nmpwovh(this);
            final int i = 0;
            TextView textViewLclupha = x.zamkzqg.lclupha(this, getString(R.string.parts_title), new View.OnClickListener() { // from class: x.fixfqug
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            xbdyiew xbdyiewVar2 = xbdyiewVar;
                            if (!xbdyiewVar2.nmpwovh.lpkdqgx) {
                                xbdyiewVar2.nmpwovh.buswjhz();
                            } else {
                                Toast.makeText(xbdyiewVar2.nmpwovh, R.string.parts_backup_running_warning, 0).show();
                            }
                            break;
                        default:
                            xbdyiew xbdyiewVar3 = xbdyiewVar;
                            if (xbdyiewVar3.nmpwovh.lpkdqgx) {
                                kggugdp kggugdpVar = xbdyiewVar3.nmpwovh;
                                ((MainActivity) kggugdpVar).nmpwovh(kggugdpVar.getString(R.string.log_parts_stop_backup));
                            }
                            xbdyiewVar3.nmpwovh.yonoayx();
                            break;
                    }
                }
            });
            x.zamkzqg.enxkjpu(this, textViewLclupha, R.drawable.ic_back, iNmpwovh);
            textViewLclupha.setGravity(8388627);
            textViewLclupha.setPadding(0, x.zamkzqg.qunltjs(this, 4), 0, x.zamkzqg.qunltjs(this, 8));
            linearLayoutXbdyiew.addView(textViewLclupha);
            linearLayoutXbdyiew.addView(x.zamkzqg.ywhgqsi(this, getString(R.string.parts_backup_title)));
            LinearLayout linearLayoutZwaqeaz = x.zamkzqg.zwaqeaz(this);
            linearLayoutZwaqeaz.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.tmdubwv(this, ohwxijwVar.oqexvyb), x.zamkzqg.cugubfc(this, ohwxijwVar.oqexvyb), x.zamkzqg.qunltjs(this, x.zamkzqg.nhhacgu(this))));
            linearLayoutZwaqeaz.addView(x.zamkzqg.ysaclsr(this, R.string.parts_selected_partition));
            TextView textViewOxoagud = x.zamkzqg.oxoagud(this, ohwxijwVar.nmpwovh, 18, x.zamkzqg.zngzleo(this), true);
            x.zamkzqg.enxkjpu(this, textViewOxoagud, R.drawable.ic_partition, x.zamkzqg.nmpwovh(this));
            linearLayoutZwaqeaz.addView(textViewOxoagud);
            linearLayoutZwaqeaz.addView(x.zamkzqg.oxoagud(this, ohwxijwVar.lthborb + " • " + x.zamkzqg.jybecxv(ohwxijwVar.vivhedu), 11, x.zamkzqg.jbmzxye(this), false));
            linearLayoutXbdyiew.addView(linearLayoutZwaqeaz, x.zamkzqg.uiqyzsp(this));
            LinearLayout linearLayoutZwaqeaz2 = x.zamkzqg.zwaqeaz(this);
            linearLayoutZwaqeaz2.addView(x.zamkzqg.ysaclsr(this, R.string.parts_output_file));
            TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, fileCzidoiw.getAbsolutePath(), 12, x.zamkzqg.zngzleo(this), true);
            x.zamkzqg.enxkjpu(this, textViewOxoagud2, R.drawable.ic_file, x.zamkzqg.nmpwovh(this));
            linearLayoutZwaqeaz2.addView(textViewOxoagud2);
            linearLayoutXbdyiew.addView(linearLayoutZwaqeaz2, x.zamkzqg.uiqyzsp(this));
            LinearLayout linearLayoutZwaqeaz3 = x.zamkzqg.zwaqeaz(this);
            linearLayoutZwaqeaz3.addView(x.zamkzqg.ysaclsr(this, R.string.progress_title));
            LinearLayout linearLayoutLvtqoqa = x.zamkzqg.lvtqoqa(this);
            TextView textViewOxoagud3 = x.zamkzqg.oxoagud(this, "0%", 22, x.zamkzqg.pzkwhtn(this), true);
            TextView textViewOxoagud4 = x.zamkzqg.oxoagud(this, getString(R.string.parts_backup_preparing), 11, x.zamkzqg.jbmzxye(this), false);
            textViewOxoagud4.setGravity(8388613);
            linearLayoutLvtqoqa.addView(textViewOxoagud3, new LinearLayout.LayoutParams(0, x.zamkzqg.qunltjs(this, 34), 1.0f));
            linearLayoutLvtqoqa.addView(textViewOxoagud4, new LinearLayout.LayoutParams(0, x.zamkzqg.qunltjs(this, 34), 2.0f));
            linearLayoutZwaqeaz3.addView(linearLayoutLvtqoqa);
            ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            progressBar.setMax(100);
            progressBar.setProgress(0);
            linearLayoutZwaqeaz3.addView(progressBar, new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(this, 12)));
            linearLayoutXbdyiew.addView(linearLayoutZwaqeaz3, x.zamkzqg.uiqyzsp(this));
            LinearLayout linearLayoutZwaqeaz4 = x.zamkzqg.zwaqeaz(this);
            linearLayoutZwaqeaz4.addView(x.zamkzqg.ysaclsr(this, R.string.progress_log_preview));
            TextView textViewOxoagud5 = x.zamkzqg.oxoagud(this, getString(R.string.progress_waiting_backend), 10, x.zamkzqg.zngzleo(this), false);
            textViewOxoagud5.setTypeface(Typeface.MONOSPACE);
            linearLayoutZwaqeaz4.addView(textViewOxoagud5);
            linearLayoutXbdyiew.addView(linearLayoutZwaqeaz4, x.zamkzqg.uiqyzsp(this));
            int iPzqxblc = x.zamkzqg.pzqxblc(this);
            final int i2 = 1;
            TextView textViewLclupha2 = x.zamkzqg.lclupha(this, getString(R.string.progress_stop_session), new View.OnClickListener() { // from class: x.fixfqug
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            xbdyiew xbdyiewVar2 = xbdyiewVar;
                            if (!xbdyiewVar2.nmpwovh.lpkdqgx) {
                                xbdyiewVar2.nmpwovh.buswjhz();
                            } else {
                                Toast.makeText(xbdyiewVar2.nmpwovh, R.string.parts_backup_running_warning, 0).show();
                            }
                            break;
                        default:
                            xbdyiew xbdyiewVar3 = xbdyiewVar;
                            if (xbdyiewVar3.nmpwovh.lpkdqgx) {
                                kggugdp kggugdpVar = xbdyiewVar3.nmpwovh;
                                ((MainActivity) kggugdpVar).nmpwovh(kggugdpVar.getString(R.string.log_parts_stop_backup));
                            }
                            xbdyiewVar3.nmpwovh.yonoayx();
                            break;
                    }
                }
            });
            x.zamkzqg.enxkjpu(this, textViewLclupha2, R.drawable.ic_stop, iPzqxblc);
            textViewLclupha2.setTextColor(x.zamkzqg.pzqxblc(this));
            linearLayoutXbdyiew.addView(textViewLclupha2, new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(this, 50)));
            this.vhimehb = progressBar;
            this.naaizwn = textViewOxoagud3;
            this.hjlrtqw = textViewOxoagud4;
            this.dkpobjg = textViewOxoagud5;
            this.xbdyiew = null;
            this.ohwxijw = null;
            this.yomtcav = null;
            this.uzyihoe = null;
            this.ygdccqg = "READ";
            this.cxxnoho = ohwxijwVar.nmpwovh;
            this.clczezu = System.currentTimeMillis();
            kffvigz(scrollView, "partition_backup_progress");
            this.lpkdqgx = true;
            gefzxcg();
            ((MainActivity) this).nmpwovh(getString(R.string.log_parts_backup_start, ohwxijwVar.nmpwovh, fileCzidoiw.getAbsolutePath()));
            this.slxntng.execute(new silhone(this, ohwxijwVar, fileCzidoiw, yjbrzgu("da_path"), yjbrzgu("auth_path"), yjbrzgu("preloader_path"), 2));
        }
    }

    public final void eqqqfvj(File file) {
        int i = this.yrgokys;
        this.yrgokys = -1;
        if (i >= 0) {
            ArrayList arrayList = this.pcbbvuj;
            if (i >= arrayList.size()) {
                return;
            }
            try {
                File fileGisppfs = x.zamkzqg.gisppfs(file);
                if (!fileGisppfs.isFile() || !fileGisppfs.canRead() || fileGisppfs.length() <= 0) {
                    throw new IllegalArgumentException(getString(R.string.error_selected_image_realpath));
                }
                bpqosqe bpqosqeVar = (bpqosqe) arrayList.get(i);
                this.fprgbbe.put(bpqosqeVar.nmpwovh, fileGisppfs);
                ((MainActivity) this).nmpwovh(bpqosqeVar.nmpwovh + " ← " + fileGisppfs.getAbsolutePath());
                hknanqb();
            } catch (Throwable unused) {
                Toast.makeText(this, R.string.error_use_selected_image, 1).show();
                hknanqb();
            }
        }
    }

    public final void ftrcqfq(File file) {
        lcgzsis lcgzsisVarPvbzgon;
        try {
            boolean z = this.nsyqsfj && !this.jbmzxye.isEmpty();
            if (z) {
                String str = this.cnctlxz.ojyssqt;
                x.pwjmwpv.lclupha(file);
                lcgzsisVarPvbzgon = x.pwjmwpv.dytyqos(file) ? x.pwjmwpv.pvbzgon(file, str, false) : x.pwjmwpv.buswjhz(file, str, false);
            } else {
                x.pwjmwpv.lclupha(file);
                lcgzsisVarPvbzgon = x.pwjmwpv.dytyqos(file) ? x.pwjmwpv.pvbzgon(file, "", true) : x.pwjmwpv.buswjhz(file, "", true);
            }
            if (z) {
                String strEdnetju = ednetju(file);
                if (!strEdnetju.isEmpty()) {
                    throw new IOException(strEdnetju);
                }
            }
            this.wdznaie = lcgzsisVarPvbzgon;
            this.ijakhcl = "download_only";
            this.osgyung = 0;
            this.lsgjyur = false;
            this.iasgsgq = !z;
            this.ghkjjru = "";
            this.mwocrhx.clear();
            ljwltks();
            if (z) {
                ydsyayx();
            }
            Iterator it = this.pwnmyid.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (((znfyiic) it.next()).qxvquar) {
                    i++;
                }
            }
            ((MainActivity) this).nmpwovh(getString(R.string.log_scatter_loaded, lcgzsisVarPvbzgon.nmpwovh.getAbsolutePath(), lcgzsisVarPvbzgon.vivhedu, lcgzsisVarPvbzgon.qxvquar, Integer.valueOf(com.rynx.app.ojyssqt.wqrnifx(lcgzsisVarPvbzgon))));
            Toast.makeText(this, z ? getString(R.string.scatter_loaded, Integer.valueOf(com.rynx.app.ojyssqt.wqrnifx(lcgzsisVarPvbzgon)), Integer.valueOf(i)) : getString(R.string.scatter_loaded_preview, Integer.valueOf(com.rynx.app.ojyssqt.wqrnifx(lcgzsisVarPvbzgon))), 1).show();
        } catch (Throwable th) {
            this.wdznaie = null;
            this.lsgjyur = false;
            this.iasgsgq = false;
            this.ghkjjru = "";
            this.pwnmyid.clear();
            this.mwocrhx.clear();
            this.pzkwhtn = "";
            Toast.makeText(this, getString(R.string.scatter_parse_failed, String.valueOf(th.getMessage())), 1).show();
        }
        gzokllk();
    }

    public final void gjpruie(int i, boolean z) {
        znfyiic znfyiicVar;
        Iterator it = this.pwnmyid.iterator();
        do {
            if (!it.hasNext()) {
                znfyiicVar = null;
                break;
            }
            znfyiicVar = (znfyiic) it.next();
        } while (znfyiicVar.nmpwovh != i);
        if (znfyiicVar == null || !znfyiicVar.qxvquar) {
            gzokllk();
            return;
        }
        if ("firmware_upgrade".equals(this.ijakhcl)) {
            this.ijakhcl = "download_only";
            this.lsgjyur = false;
            ljwltks();
            gjpruie(i, z);
            return;
        }
        String str = znfyiicVar.ojyssqt.ojyssqt;
        String strPzqxblc = com.rynx.app.ojyssqt.pzqxblc(str);
        HashSet hashSet = this.mwocrhx;
        if (!z) {
            hashSet.remove(strPzqxblc);
            this.mslkofp = xqbcyis();
            gzokllk();
            return;
        }
        ohwxijw ohwxijwVar = znfyiicVar.vivhedu;
        if (ohwxijwVar != null && ohwxijwVar.nmpwovh()) {
            final int i2 = 0;
            new AlertDialog.Builder(this).setTitle(R.string.scatter_red_partition_title).setMessage(getString(R.string.scatter_red_partition_message, jvtqflj(str))).setNegativeButton(R.string.action_cancel, new DialogInterface.OnClickListener() { // from class: x.duxkmyb
                public final /* synthetic */ kggugdp ojyssqt;

                {
                    this.ojyssqt = kggugdp.this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    switch (i2) {
                        case 0:
                            this.ojyssqt.gzokllk();
                            break;
                        default:
                            this.ojyssqt.gzokllk();
                            break;
                    }
                }
            }).setPositiveButton(R.string.scatter_red_partition_select, new teupdsw(1, strPzqxblc, this)).show();
        } else if (znfyiicVar.oqexvyb) {
            final int i3 = 1;
            new AlertDialog.Builder(this).setTitle(R.string.scatter_warning_partition_title).setMessage(getString(R.string.scatter_warning_partition_message, str, znfyiicVar.imuemzb)).setNegativeButton(R.string.action_cancel, new DialogInterface.OnClickListener() { // from class: x.duxkmyb
                public final /* synthetic */ kggugdp ojyssqt;

                {
                    this.ojyssqt = kggugdp.this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    switch (i3) {
                        case 0:
                            this.ojyssqt.gzokllk();
                            break;
                        default:
                            this.ojyssqt.gzokllk();
                            break;
                    }
                }
            }).setPositiveButton(R.string.scatter_warning_partition_select, new teupdsw(2, strPzqxblc, this)).show();
        } else {
            hashSet.add(strPzqxblc);
            this.mslkofp = xqbcyis();
            gzokllk();
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void gzokllk() {
        int i;
        String str;
        String string;
        int iPzkwhtn;
        if (this.wdznaie != null) {
            ljwltks();
        }
        boolean z = this.nsyqsfj && !this.jbmzxye.isEmpty();
        boolean z2 = z && !this.iasgsgq && this.ghkjjru.isEmpty();
        boolean z3 = this.gzokllk || (this.qwgjehf && !this.nsyqsfj);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.pwnmyid.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            znfyiic znfyiicVar = (znfyiic) it.next();
            aqyicql aqyicqlVar = znfyiicVar.ojyssqt;
            if (aqyicqlVar.lthborb) {
                boolean z4 = znfyiicVar.qxvquar && this.mwocrhx.contains(com.rynx.app.ojyssqt.pzqxblc(aqyicqlVar.ojyssqt));
                if (z4) {
                    i2++;
                }
                ohwxijw ohwxijwVar = znfyiicVar.vivhedu;
                String str2 = ohwxijwVar != null ? ohwxijwVar.oqexvyb : "yellow";
                long j = znfyiicVar.ojyssqt.oqexvyb;
                arrayList.add(new hfkdhls(znfyiicVar.nmpwovh, jvtqflj(znfyiicVar.ojyssqt.ojyssqt), znfyiicVar.ojyssqt.vivhedu() ? znfyiicVar.ojyssqt.vivhedu : "NONE", znfyiicVar.ojyssqt.nmpwovh(), j > 0 ? x.zamkzqg.jybecxv(j) : String.format("0x%016X", Long.valueOf(j)), znfyiicVar.ojyssqt.nkemejx, znfyiicVar.imuemzb, str2, znfyiicVar.qxvquar, znfyiicVar.oqexvyb, z4));
            }
        }
        boolean z5 = z2 && this.wdznaie != null && ("download_only".equals(this.ijakhcl) || "firmware_upgrade".equals(this.ijakhcl)) && this.pzkwhtn.isEmpty() && i2 > 0;
        if (z3) {
            i = R.string.scatter_start_waiting;
        } else {
            i = z ? R.string.scatter_start_revalidate : R.string.scatter_start_wait_da;
        }
        boolean z6 = (this.lpkdqgx || this.ywhgqsi || z3) ? false : true;
        boolean z7 = !this.ghkjjru.isEmpty() || (z2 && !this.pzkwhtn.isEmpty());
        lcgzsis lcgzsisVar = this.wdznaie;
        boolean z8 = lcgzsisVar != null && lcgzsisVar.nkemejx.stream().anyMatch(new tqfwohl());
        if (!z8) {
            this.lsgjyur = false;
        }
        lcgzsis lcgzsisVar2 = this.wdznaie;
        String name = lcgzsisVar2 == null ? "" : lcgzsisVar2.nmpwovh.getName();
        lcgzsis lcgzsisVar3 = this.wdznaie;
        String absolutePath = lcgzsisVar3 == null ? "" : lcgzsisVar3.nmpwovh.getAbsolutePath();
        lcgzsis lcgzsisVar4 = this.wdznaie;
        String string2 = "";
        String str3 = lcgzsisVar4 != null ? lcgzsisVar4.vivhedu : "";
        String str4 = "yellow";
        String str5 = lcgzsisVar4 == null ? string2 : lcgzsisVar4.lthborb;
        String str6 = (lcgzsisVar4 == null || !this.nsyqsfj) ? string2 : this.cnctlxz.ojyssqt;
        lcgzsis lcgzsisVar5 = this.wdznaie;
        string2 = lcgzsisVar5 != null ? lcgzsisVar5.ojyssqt : "";
        String str7 = this.ijakhcl;
        boolean z9 = z2;
        boolean z10 = this.lsgjyur;
        boolean z11 = z7;
        String str8 = this.pzkwhtn;
        int i3 = this.osgyung;
        final mcdstyz mcdstyzVar = new mcdstyz(this);
        boolean z12 = z8;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(x.zamkzqg.buswjhz(this));
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        String str9 = str6;
        String str10 = str5;
        linearLayout2.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
        LinearLayout linearLayoutLvtqoqa = x.zamkzqg.lvtqoqa(this);
        final int i4 = 0;
        String str11 = str3;
        linearLayoutLvtqoqa.addView(x.zamkzqg.btazysh(this, R.drawable.ic_back, x.zamkzqg.nmpwovh(this), R.string.scatter_back, new View.OnClickListener() { // from class: x.jzcfpou
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        mcdstyzVar.nmpwovh.buswjhz();
                        break;
                    case 1:
                        kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                        if ("firmware_upgrade".equals(kggugdpVar.ijakhcl)) {
                            kggugdpVar.ysaclsr();
                        } else {
                            kggugdpVar.mwocrhx.clear();
                        }
                        kggugdpVar.gzokllk();
                        break;
                    case 2:
                        kggugdp kggugdpVar2 = mcdstyzVar.nmpwovh;
                        if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi || kggugdpVar2.gzokllk) {
                            Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                        } else {
                            kggugdpVar2.mwngani = true;
                            if (!kggugdpVar2.nsyqsfj) {
                                kggugdpVar2.nsizane();
                                if (kggugdpVar2.qwgjehf || kggugdpVar2.gzokllk) {
                                    Toast.makeText(kggugdpVar2, R.string.scatter_start_armed, 1).show();
                                    kggugdpVar2.gzokllk();
                                }
                            } else {
                                kggugdpVar2.yxcmoyp();
                            }
                        }
                        break;
                    case 3:
                        mcdstyzVar.nmpwovh.cnctlxz();
                        break;
                    case 4:
                        kggugdp kggugdpVar3 = mcdstyzVar.nmpwovh;
                        if (kggugdpVar3.dplrlfq()) {
                            x.ecffprn.imuemzb(kggugdpVar3, kggugdpVar3.getString(R.string.scatter_choose_file), kggugdpVar3.lclupha(), new String[]{".txt", ".xml", ".scatter"}, new thbdbid(kggugdpVar3, 3));
                            break;
                        }
                        break;
                    case 5:
                        mcdstyzVar.nmpwovh("download_only");
                        break;
                    case 6:
                        mcdstyzVar.nmpwovh("firmware_upgrade");
                        break;
                    default:
                        kggugdp kggugdpVar4 = mcdstyzVar.nmpwovh;
                        kggugdpVar4.ysaclsr();
                        kggugdpVar4.gzokllk();
                        break;
                }
            }
        }), new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
        TextView textViewOxoagud = x.zamkzqg.oxoagud(this, getString(R.string.scatter_title), 20, x.zamkzqg.zngzleo(this), true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
        linearLayoutLvtqoqa.addView(textViewOxoagud, layoutParams);
        TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, getString(R.string.scatter_selected_count, Integer.valueOf(i2)), 10, i2 > 0 ? x.zamkzqg.nmpwovh(this) : x.zamkzqg.jbmzxye(this), true);
        textViewOxoagud2.setGravity(17);
        textViewOxoagud2.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
        textViewOxoagud2.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_sticky_action_radius, this, x.zamkzqg.atntgcp(this), getColor(R.color.rynx_transparent)));
        linearLayoutLvtqoqa.addView(textViewOxoagud2);
        linearLayout2.addView(linearLayoutLvtqoqa);
        LinearLayout linearLayoutLvtqoqa2 = x.zamkzqg.lvtqoqa(this);
        int iKggugdp = z6 ? x.zamkzqg.kggugdp(this) : x.zamkzqg.jbmzxye(this);
        final int i5 = 2;
        TextView textViewLclupha = x.zamkzqg.lclupha(this, getString(i), new View.OnClickListener() { // from class: x.jzcfpou
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        mcdstyzVar.nmpwovh.buswjhz();
                        break;
                    case 1:
                        kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                        if ("firmware_upgrade".equals(kggugdpVar.ijakhcl)) {
                            kggugdpVar.ysaclsr();
                        } else {
                            kggugdpVar.mwocrhx.clear();
                        }
                        kggugdpVar.gzokllk();
                        break;
                    case 2:
                        kggugdp kggugdpVar2 = mcdstyzVar.nmpwovh;
                        if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi || kggugdpVar2.gzokllk) {
                            Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                        } else {
                            kggugdpVar2.mwngani = true;
                            if (!kggugdpVar2.nsyqsfj) {
                                kggugdpVar2.nsizane();
                                if (kggugdpVar2.qwgjehf || kggugdpVar2.gzokllk) {
                                    Toast.makeText(kggugdpVar2, R.string.scatter_start_armed, 1).show();
                                    kggugdpVar2.gzokllk();
                                }
                            } else {
                                kggugdpVar2.yxcmoyp();
                            }
                        }
                        break;
                    case 3:
                        mcdstyzVar.nmpwovh.cnctlxz();
                        break;
                    case 4:
                        kggugdp kggugdpVar3 = mcdstyzVar.nmpwovh;
                        if (kggugdpVar3.dplrlfq()) {
                            x.ecffprn.imuemzb(kggugdpVar3, kggugdpVar3.getString(R.string.scatter_choose_file), kggugdpVar3.lclupha(), new String[]{".txt", ".xml", ".scatter"}, new thbdbid(kggugdpVar3, 3));
                            break;
                        }
                        break;
                    case 5:
                        mcdstyzVar.nmpwovh("download_only");
                        break;
                    case 6:
                        mcdstyzVar.nmpwovh("firmware_upgrade");
                        break;
                    default:
                        kggugdp kggugdpVar4 = mcdstyzVar.nmpwovh;
                        kggugdpVar4.ysaclsr();
                        kggugdpVar4.gzokllk();
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha, R.drawable.ic_start, iKggugdp);
        textViewLclupha.setTextColor(z6 ? x.zamkzqg.kggugdp(this) : x.zamkzqg.jbmzxye(this));
        textViewLclupha.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_sticky_action_radius, this, z6 ? x.zamkzqg.ojyssqt(this) : x.zamkzqg.atntgcp(this), getColor(R.color.rynx_transparent)));
        textViewLclupha.setEnabled(z6);
        textViewLclupha.setAlpha(z6 ? 1.0f : 0.55f);
        linearLayoutLvtqoqa2.addView(textViewLclupha, new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height), 1.35f));
        linearLayoutLvtqoqa2.addView(new View(this), new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap), 1));
        int iKggugdp2 = z5 ? x.zamkzqg.kggugdp(this) : x.zamkzqg.jbmzxye(this);
        final int i6 = 3;
        TextView textViewLclupha2 = x.zamkzqg.lclupha(this, getString(R.string.scatter_review), new View.OnClickListener() { // from class: x.jzcfpou
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        mcdstyzVar.nmpwovh.buswjhz();
                        break;
                    case 1:
                        kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                        if ("firmware_upgrade".equals(kggugdpVar.ijakhcl)) {
                            kggugdpVar.ysaclsr();
                        } else {
                            kggugdpVar.mwocrhx.clear();
                        }
                        kggugdpVar.gzokllk();
                        break;
                    case 2:
                        kggugdp kggugdpVar2 = mcdstyzVar.nmpwovh;
                        if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi || kggugdpVar2.gzokllk) {
                            Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                        } else {
                            kggugdpVar2.mwngani = true;
                            if (!kggugdpVar2.nsyqsfj) {
                                kggugdpVar2.nsizane();
                                if (kggugdpVar2.qwgjehf || kggugdpVar2.gzokllk) {
                                    Toast.makeText(kggugdpVar2, R.string.scatter_start_armed, 1).show();
                                    kggugdpVar2.gzokllk();
                                }
                            } else {
                                kggugdpVar2.yxcmoyp();
                            }
                        }
                        break;
                    case 3:
                        mcdstyzVar.nmpwovh.cnctlxz();
                        break;
                    case 4:
                        kggugdp kggugdpVar3 = mcdstyzVar.nmpwovh;
                        if (kggugdpVar3.dplrlfq()) {
                            x.ecffprn.imuemzb(kggugdpVar3, kggugdpVar3.getString(R.string.scatter_choose_file), kggugdpVar3.lclupha(), new String[]{".txt", ".xml", ".scatter"}, new thbdbid(kggugdpVar3, 3));
                            break;
                        }
                        break;
                    case 5:
                        mcdstyzVar.nmpwovh("download_only");
                        break;
                    case 6:
                        mcdstyzVar.nmpwovh("firmware_upgrade");
                        break;
                    default:
                        kggugdp kggugdpVar4 = mcdstyzVar.nmpwovh;
                        kggugdpVar4.ysaclsr();
                        kggugdpVar4.gzokllk();
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha2, R.drawable.ic_flash, iKggugdp2);
        textViewLclupha2.setTextColor(z5 ? x.zamkzqg.kggugdp(this) : x.zamkzqg.jbmzxye(this));
        textViewLclupha2.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_sticky_action_radius, this, z5 ? x.zamkzqg.ojyssqt(this) : x.zamkzqg.atntgcp(this), getColor(R.color.rynx_transparent)));
        textViewLclupha2.setEnabled(z5);
        textViewLclupha2.setAlpha(z5 ? 1.0f : 0.55f);
        linearLayoutLvtqoqa2.addView(textViewLclupha2, new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height), 0.65f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
        linearLayout2.addView(linearLayoutLvtqoqa2, layoutParams2);
        linearLayout.addView(linearLayout2);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: x.sxhcynd
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i7, int i8, int i9, int i10) {
                mcdstyz mcdstyzVar2 = mcdstyzVar;
                mcdstyzVar2.getClass();
                mcdstyzVar2.nmpwovh.osgyung = Math.max(0, i8);
            }
        });
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(1);
        linearLayout3.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
        scrollView.addView(linearLayout3);
        linearLayout3.addView(x.zamkzqg.oxoagud(this, getString(R.string.scatter_subtitle), 11, x.zamkzqg.jbmzxye(this), false));
        LinearLayout linearLayoutGhkjjru = x.zamkzqg.ghkjjru(this);
        linearLayoutGhkjjru.addView(x.zamkzqg.ysaclsr(this, R.string.scatter_file_label));
        TextView textViewOxoagud3 = x.zamkzqg.oxoagud(this, x.zamkzqg.rceuwfv(name) ? getString(R.string.scatter_no_file) : name, 14, x.zamkzqg.zngzleo(this), true);
        textViewOxoagud3.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top), 0, 0);
        linearLayoutGhkjjru.addView(textViewOxoagud3);
        if (!x.zamkzqg.rceuwfv(absolutePath)) {
            TextView textViewOxoagud4 = x.zamkzqg.oxoagud(this, absolutePath, 9, x.zamkzqg.jbmzxye(this), false);
            textViewOxoagud4.setPadding(0, getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom));
            linearLayoutGhkjjru.addView(textViewOxoagud4);
        }
        int i7 = x.zamkzqg.rceuwfv(name) ? R.string.scatter_choose_file : R.string.scatter_change_file;
        int iNmpwovh = x.zamkzqg.nmpwovh(this);
        final int i8 = 4;
        TextView textViewLclupha3 = x.zamkzqg.lclupha(this, getString(i7), new View.OnClickListener() { // from class: x.jzcfpou
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i8) {
                    case 0:
                        mcdstyzVar.nmpwovh.buswjhz();
                        break;
                    case 1:
                        kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                        if ("firmware_upgrade".equals(kggugdpVar.ijakhcl)) {
                            kggugdpVar.ysaclsr();
                        } else {
                            kggugdpVar.mwocrhx.clear();
                        }
                        kggugdpVar.gzokllk();
                        break;
                    case 2:
                        kggugdp kggugdpVar2 = mcdstyzVar.nmpwovh;
                        if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi || kggugdpVar2.gzokllk) {
                            Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                        } else {
                            kggugdpVar2.mwngani = true;
                            if (!kggugdpVar2.nsyqsfj) {
                                kggugdpVar2.nsizane();
                                if (kggugdpVar2.qwgjehf || kggugdpVar2.gzokllk) {
                                    Toast.makeText(kggugdpVar2, R.string.scatter_start_armed, 1).show();
                                    kggugdpVar2.gzokllk();
                                }
                            } else {
                                kggugdpVar2.yxcmoyp();
                            }
                        }
                        break;
                    case 3:
                        mcdstyzVar.nmpwovh.cnctlxz();
                        break;
                    case 4:
                        kggugdp kggugdpVar3 = mcdstyzVar.nmpwovh;
                        if (kggugdpVar3.dplrlfq()) {
                            x.ecffprn.imuemzb(kggugdpVar3, kggugdpVar3.getString(R.string.scatter_choose_file), kggugdpVar3.lclupha(), new String[]{".txt", ".xml", ".scatter"}, new thbdbid(kggugdpVar3, 3));
                            break;
                        }
                        break;
                    case 5:
                        mcdstyzVar.nmpwovh("download_only");
                        break;
                    case 6:
                        mcdstyzVar.nmpwovh("firmware_upgrade");
                        break;
                    default:
                        kggugdp kggugdpVar4 = mcdstyzVar.nmpwovh;
                        kggugdpVar4.ysaclsr();
                        kggugdpVar4.gzokllk();
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha3, R.drawable.ic_file, iNmpwovh);
        linearLayoutGhkjjru.addView(textViewLclupha3, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.batch_flow_action_height)));
        linearLayout3.addView(linearLayoutGhkjjru, x.zamkzqg.uiqyzsp(this));
        if (!x.zamkzqg.rceuwfv(name)) {
            LinearLayout linearLayoutGhkjjru2 = x.zamkzqg.ghkjjru(this);
            linearLayoutGhkjjru2.addView(x.zamkzqg.ysaclsr(this, R.string.scatter_general_label));
            linearLayoutGhkjjru2.addView(x.zamkzqg.hhqpjvl(R.string.scatter_platform, x.zamkzqg.rceuwfv(str11) ? getString(R.string.value_not_available) : str11, this));
            linearLayoutGhkjjru2.addView(x.zamkzqg.hhqpjvl(R.string.scatter_project, x.zamkzqg.rceuwfv(str10) ? getString(R.string.value_not_available) : str10, this));
            if (!x.zamkzqg.rceuwfv(str9)) {
                linearLayoutGhkjjru2.addView(x.zamkzqg.hhqpjvl(R.string.scatter_storage, str9, this));
            }
            if (x.zamkzqg.rceuwfv(string2)) {
                string2 = getString(R.string.value_not_available);
            }
            linearLayoutGhkjjru2.addView(x.zamkzqg.hhqpjvl(R.string.scatter_config_version, string2, this));
            linearLayout3.addView(linearLayoutGhkjjru2, x.zamkzqg.uiqyzsp(this));
            linearLayout3.addView(x.zamkzqg.ysaclsr(this, R.string.scatter_mode_label));
            LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(this);
            final int i9 = 5;
            TextView textViewGzvolsx = x.zamkzqg.gzvolsx(this, R.string.scatter_mode_download_only, "download_only".equals(str7), new View.OnClickListener() { // from class: x.jzcfpou
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i9) {
                        case 0:
                            mcdstyzVar.nmpwovh.buswjhz();
                            break;
                        case 1:
                            kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                            if ("firmware_upgrade".equals(kggugdpVar.ijakhcl)) {
                                kggugdpVar.ysaclsr();
                            } else {
                                kggugdpVar.mwocrhx.clear();
                            }
                            kggugdpVar.gzokllk();
                            break;
                        case 2:
                            kggugdp kggugdpVar2 = mcdstyzVar.nmpwovh;
                            if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi || kggugdpVar2.gzokllk) {
                                Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                            } else {
                                kggugdpVar2.mwngani = true;
                                if (!kggugdpVar2.nsyqsfj) {
                                    kggugdpVar2.nsizane();
                                    if (kggugdpVar2.qwgjehf || kggugdpVar2.gzokllk) {
                                        Toast.makeText(kggugdpVar2, R.string.scatter_start_armed, 1).show();
                                        kggugdpVar2.gzokllk();
                                    }
                                } else {
                                    kggugdpVar2.yxcmoyp();
                                }
                            }
                            break;
                        case 3:
                            mcdstyzVar.nmpwovh.cnctlxz();
                            break;
                        case 4:
                            kggugdp kggugdpVar3 = mcdstyzVar.nmpwovh;
                            if (kggugdpVar3.dplrlfq()) {
                                x.ecffprn.imuemzb(kggugdpVar3, kggugdpVar3.getString(R.string.scatter_choose_file), kggugdpVar3.lclupha(), new String[]{".txt", ".xml", ".scatter"}, new thbdbid(kggugdpVar3, 3));
                                break;
                            }
                            break;
                        case 5:
                            mcdstyzVar.nmpwovh("download_only");
                            break;
                        case 6:
                            mcdstyzVar.nmpwovh("firmware_upgrade");
                            break;
                        default:
                            kggugdp kggugdpVar4 = mcdstyzVar.nmpwovh;
                            kggugdpVar4.ysaclsr();
                            kggugdpVar4.gzokllk();
                            break;
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.batch_flow_segment_height), 1.0f);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.batch_flow_segment_gap);
            layoutParams3.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
            linearLayoutLvtqoqa3.addView(textViewGzvolsx, layoutParams3);
            final int i10 = 6;
            TextView textViewGzvolsx2 = x.zamkzqg.gzvolsx(this, R.string.scatter_mode_firmware_upgrade, "firmware_upgrade".equals(str7), new View.OnClickListener() { // from class: x.jzcfpou
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i10) {
                        case 0:
                            mcdstyzVar.nmpwovh.buswjhz();
                            break;
                        case 1:
                            kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                            if ("firmware_upgrade".equals(kggugdpVar.ijakhcl)) {
                                kggugdpVar.ysaclsr();
                            } else {
                                kggugdpVar.mwocrhx.clear();
                            }
                            kggugdpVar.gzokllk();
                            break;
                        case 2:
                            kggugdp kggugdpVar2 = mcdstyzVar.nmpwovh;
                            if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi || kggugdpVar2.gzokllk) {
                                Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                            } else {
                                kggugdpVar2.mwngani = true;
                                if (!kggugdpVar2.nsyqsfj) {
                                    kggugdpVar2.nsizane();
                                    if (kggugdpVar2.qwgjehf || kggugdpVar2.gzokllk) {
                                        Toast.makeText(kggugdpVar2, R.string.scatter_start_armed, 1).show();
                                        kggugdpVar2.gzokllk();
                                    }
                                } else {
                                    kggugdpVar2.yxcmoyp();
                                }
                            }
                            break;
                        case 3:
                            mcdstyzVar.nmpwovh.cnctlxz();
                            break;
                        case 4:
                            kggugdp kggugdpVar3 = mcdstyzVar.nmpwovh;
                            if (kggugdpVar3.dplrlfq()) {
                                x.ecffprn.imuemzb(kggugdpVar3, kggugdpVar3.getString(R.string.scatter_choose_file), kggugdpVar3.lclupha(), new String[]{".txt", ".xml", ".scatter"}, new thbdbid(kggugdpVar3, 3));
                                break;
                            }
                            break;
                        case 5:
                            mcdstyzVar.nmpwovh("download_only");
                            break;
                        case 6:
                            mcdstyzVar.nmpwovh("firmware_upgrade");
                            break;
                        default:
                            kggugdp kggugdpVar4 = mcdstyzVar.nmpwovh;
                            kggugdpVar4.ysaclsr();
                            kggugdpVar4.gzokllk();
                            break;
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.batch_flow_segment_height), 1.0f);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.batch_flow_segment_gap);
            layoutParams4.setMargins(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
            linearLayoutLvtqoqa3.addView(textViewGzvolsx2, layoutParams4);
            linearLayout3.addView(linearLayoutLvtqoqa3);
            boolean zEquals = "firmware_upgrade".equals(str7);
            int i11 = android.R.attr.state_checked;
            if (zEquals) {
                LinearLayout linearLayoutGhkjjru3 = x.zamkzqg.ghkjjru(this);
                CheckBox checkBox = new CheckBox(this);
                checkBox.setText(R.string.scatter_firmware_upgrade_format_seccfg);
                checkBox.setTextSize(13.0f);
                checkBox.setTextColor(x.zamkzqg.zngzleo(this));
                checkBox.setChecked(z10);
                checkBox.setEnabled(z12);
                checkBox.setAlpha(z12 ? 1.0f : 0.55f);
                checkBox.setButtonTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_checked}, new int[]{-16842912}}, new int[]{x.zamkzqg.ohwxijw(this), x.zamkzqg.jbmzxye(this)}));
                checkBox.setOnCheckedChangeListener(new fadblxi(mcdstyzVar, 2));
                linearLayoutGhkjjru3.addView(checkBox);
                TextView textViewOxoagud5 = x.zamkzqg.oxoagud(this, getString(z12 ? R.string.scatter_firmware_upgrade_format_seccfg_note : R.string.scatter_firmware_upgrade_format_seccfg_unavailable), 10, (z10 && z12) ? x.zamkzqg.ohwxijw(this) : x.zamkzqg.jbmzxye(this), false);
                textViewOxoagud5.setPadding(0, getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                linearLayoutGhkjjru3.addView(textViewOxoagud5);
                linearLayout3.addView(linearLayoutGhkjjru3, x.zamkzqg.uiqyzsp(this));
            }
            TextView textViewOxoagud6 = x.zamkzqg.oxoagud(this, getString(R.string.scatter_mode_safety_note), 10, x.zamkzqg.ohwxijw(this), true);
            x.zamkzqg.enxkjpu(this, textViewOxoagud6, R.drawable.ic_warning, x.zamkzqg.ohwxijw(this));
            textViewOxoagud6.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom), 0, getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom));
            linearLayout3.addView(textViewOxoagud6);
            if (!x.zamkzqg.rceuwfv(str8)) {
                int iPzqxblc = z11 ? x.zamkzqg.pzqxblc(this) : x.zamkzqg.ohwxijw(this);
                TextView textViewOxoagud7 = x.zamkzqg.oxoagud(this, str8, 10, iPzqxblc, true);
                x.zamkzqg.enxkjpu(this, textViewOxoagud7, R.drawable.ic_warning, iPzqxblc);
                textViewOxoagud7.setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom));
                linearLayout3.addView(textViewOxoagud7);
            }
            LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(this);
            final int i12 = 7;
            TextView textViewLclupha4 = x.zamkzqg.lclupha(this, getString(R.string.scatter_select_safe), new View.OnClickListener() { // from class: x.jzcfpou
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i12) {
                        case 0:
                            mcdstyzVar.nmpwovh.buswjhz();
                            break;
                        case 1:
                            kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                            if ("firmware_upgrade".equals(kggugdpVar.ijakhcl)) {
                                kggugdpVar.ysaclsr();
                            } else {
                                kggugdpVar.mwocrhx.clear();
                            }
                            kggugdpVar.gzokllk();
                            break;
                        case 2:
                            kggugdp kggugdpVar2 = mcdstyzVar.nmpwovh;
                            if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi || kggugdpVar2.gzokllk) {
                                Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                            } else {
                                kggugdpVar2.mwngani = true;
                                if (!kggugdpVar2.nsyqsfj) {
                                    kggugdpVar2.nsizane();
                                    if (kggugdpVar2.qwgjehf || kggugdpVar2.gzokllk) {
                                        Toast.makeText(kggugdpVar2, R.string.scatter_start_armed, 1).show();
                                        kggugdpVar2.gzokllk();
                                    }
                                } else {
                                    kggugdpVar2.yxcmoyp();
                                }
                            }
                            break;
                        case 3:
                            mcdstyzVar.nmpwovh.cnctlxz();
                            break;
                        case 4:
                            kggugdp kggugdpVar3 = mcdstyzVar.nmpwovh;
                            if (kggugdpVar3.dplrlfq()) {
                                x.ecffprn.imuemzb(kggugdpVar3, kggugdpVar3.getString(R.string.scatter_choose_file), kggugdpVar3.lclupha(), new String[]{".txt", ".xml", ".scatter"}, new thbdbid(kggugdpVar3, 3));
                                break;
                            }
                            break;
                        case 5:
                            mcdstyzVar.nmpwovh("download_only");
                            break;
                        case 6:
                            mcdstyzVar.nmpwovh("firmware_upgrade");
                            break;
                        default:
                            kggugdp kggugdpVar4 = mcdstyzVar.nmpwovh;
                            kggugdpVar4.ysaclsr();
                            kggugdpVar4.gzokllk();
                            break;
                    }
                }
            });
            textViewLclupha4.setEnabled(z9);
            textViewLclupha4.setAlpha(z9 ? 1.0f : 0.55f);
            linearLayoutLvtqoqa4.addView(textViewLclupha4, x.zamkzqg.qxvquar(this));
            final int i13 = 1;
            linearLayoutLvtqoqa4.addView(x.zamkzqg.lclupha(this, getString(R.string.scatter_clear_selection), new View.OnClickListener() { // from class: x.jzcfpou
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i13) {
                        case 0:
                            mcdstyzVar.nmpwovh.buswjhz();
                            break;
                        case 1:
                            kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                            if ("firmware_upgrade".equals(kggugdpVar.ijakhcl)) {
                                kggugdpVar.ysaclsr();
                            } else {
                                kggugdpVar.mwocrhx.clear();
                            }
                            kggugdpVar.gzokllk();
                            break;
                        case 2:
                            kggugdp kggugdpVar2 = mcdstyzVar.nmpwovh;
                            if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi || kggugdpVar2.gzokllk) {
                                Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                            } else {
                                kggugdpVar2.mwngani = true;
                                if (!kggugdpVar2.nsyqsfj) {
                                    kggugdpVar2.nsizane();
                                    if (kggugdpVar2.qwgjehf || kggugdpVar2.gzokllk) {
                                        Toast.makeText(kggugdpVar2, R.string.scatter_start_armed, 1).show();
                                        kggugdpVar2.gzokllk();
                                    }
                                } else {
                                    kggugdpVar2.yxcmoyp();
                                }
                            }
                            break;
                        case 3:
                            mcdstyzVar.nmpwovh.cnctlxz();
                            break;
                        case 4:
                            kggugdp kggugdpVar3 = mcdstyzVar.nmpwovh;
                            if (kggugdpVar3.dplrlfq()) {
                                x.ecffprn.imuemzb(kggugdpVar3, kggugdpVar3.getString(R.string.scatter_choose_file), kggugdpVar3.lclupha(), new String[]{".txt", ".xml", ".scatter"}, new thbdbid(kggugdpVar3, 3));
                                break;
                            }
                            break;
                        case 5:
                            mcdstyzVar.nmpwovh("download_only");
                            break;
                        case 6:
                            mcdstyzVar.nmpwovh("firmware_upgrade");
                            break;
                        default:
                            kggugdp kggugdpVar4 = mcdstyzVar.nmpwovh;
                            kggugdpVar4.ysaclsr();
                            kggugdpVar4.gzokllk();
                            break;
                    }
                }
            }), x.zamkzqg.qxvquar(this));
            linearLayout3.addView(linearLayoutLvtqoqa4);
            TextView textViewYsaclsr = x.zamkzqg.ysaclsr(this, R.string.scatter_partitions_label);
            textViewYsaclsr.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom), 0, getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top));
            linearLayout3.addView(textViewYsaclsr);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                final hfkdhls hfkdhlsVar = (hfkdhls) it2.next();
                LinearLayout linearLayout4 = new LinearLayout(this);
                linearLayout4.setOrientation(1);
                linearLayout4.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
                boolean z13 = hfkdhlsVar.dytyqos;
                String str12 = hfkdhlsVar.imuemzb;
                int iTmdubwv = z13 ? x.zamkzqg.tmdubwv(this, str12) : x.zamkzqg.atntgcp(this);
                boolean z14 = hfkdhlsVar.dytyqos;
                linearLayout4.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_compact_row_radius, this, iTmdubwv, z14 ? x.zamkzqg.cugubfc(this, str12) : x.zamkzqg.qyeibyo(this)));
                LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(this);
                CheckBox checkBox2 = new CheckBox(this);
                checkBox2.setText(hfkdhlsVar.ojyssqt);
                checkBox2.setTextSize(14.0f);
                checkBox2.setTextColor(x.zamkzqg.zngzleo(this));
                checkBox2.setTypeface(Typeface.DEFAULT, 1);
                checkBox2.setChecked(hfkdhlsVar.dasxvpc);
                checkBox2.setEnabled(z14);
                checkBox2.setAlpha(z14 ? 1.0f : 0.58f);
                checkBox2.setButtonTintList(new ColorStateList(new int[][]{new int[]{i11}, new int[]{-16842912}}, new int[]{x.zamkzqg.nmpwovh(this), x.zamkzqg.jbmzxye(this)}));
                checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: x.odhctch
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z15) {
                        mcdstyzVar.nmpwovh.gjpruie(hfkdhlsVar.nmpwovh, z15);
                    }
                });
                linearLayoutLvtqoqa5.addView(checkBox2, new LinearLayout.LayoutParams(0, -2, 1.0f));
                if ("red".equals(str12)) {
                    string = getString(R.string.parts_risk_red);
                    str = str4;
                } else {
                    str = str4;
                    string = str.equals(str12) ? getString(R.string.parts_risk_yellow) : getString(R.string.parts_risk_green);
                }
                TextView textViewOxoagud8 = x.zamkzqg.oxoagud(this, string, 8, x.zamkzqg.cugubfc(this, str12), true);
                textViewOxoagud8.setGravity(17);
                Iterator it3 = it2;
                str4 = str;
                textViewOxoagud8.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
                textViewOxoagud8.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_compact_badge_radius, this, x.zamkzqg.tmdubwv(this, str12), getColor(R.color.rynx_transparent)));
                linearLayoutLvtqoqa5.addView(textViewOxoagud8);
                linearLayout4.addView(linearLayoutLvtqoqa5);
                TextView textViewOxoagud9 = x.zamkzqg.oxoagud(this, hfkdhlsVar.vivhedu, 11, z14 ? x.zamkzqg.nmpwovh(this) : x.zamkzqg.jbmzxye(this), true);
                textViewOxoagud9.setPadding(0, getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top));
                linearLayout4.addView(textViewOxoagud9);
                linearLayout4.addView(x.zamkzqg.oxoagud(this, getString(R.string.scatter_row_layout, hfkdhlsVar.lthborb, hfkdhlsVar.qxvquar, hfkdhlsVar.oqexvyb), 9, x.zamkzqg.jbmzxye(this), false));
                if (hfkdhlsVar.wqrnifx) {
                    iPzkwhtn = x.zamkzqg.ohwxijw(this);
                } else {
                    iPzkwhtn = z14 ? x.zamkzqg.pzkwhtn(this) : x.zamkzqg.pzqxblc(this);
                }
                TextView textViewOxoagud10 = x.zamkzqg.oxoagud(this, hfkdhlsVar.nkemejx, 9, iPzkwhtn, true);
                textViewOxoagud10.setPadding(0, getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                linearLayout4.addView(textViewOxoagud10);
                linearLayout3.addView(linearLayout4, x.zamkzqg.uiqyzsp(this));
                it2 = it3;
                i11 = android.R.attr.state_checked;
            }
        }
        linearLayout3.addView(new View(this), new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        if (i3 > 0) {
            scrollView.post(new btazysh(scrollView, i3, 2));
        }
        kffvigz(linearLayout, "scatter_flash");
    }

    public final void hiygjel(String str, int i, long j, long j2) {
        String str2;
        int i2;
        long jMax = Math.max(1L, System.currentTimeMillis() - this.clczezu);
        double d = j >= 0 ? j / (jMax / 1000.0d) : 0.0d;
        x.zfmpmio.vivhedu(this.vhimehb, false);
        ProgressBar progressBar = this.vhimehb;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
        TextView textView = this.naaizwn;
        if (textView != null) {
            textView.setText(getString(R.string.progress_percent, Integer.valueOf(i)));
        }
        TextView textView2 = this.hjlrtqw;
        if (textView2 != null) {
            if ("WRITE".equals(str)) {
                i2 = R.string.flash_running;
            } else {
                i2 = "ERASE".equals(str) ? R.string.parts_erase_running : R.string.parts_backup_running;
            }
            textView2.setText(i2);
        }
        TextView textView3 = this.xbdyiew;
        if (textView3 != null && j >= 0) {
            textView3.setText(j2 > 0 ? getString(R.string.progress_transfer_pair, x.zamkzqg.jybecxv(j), x.zamkzqg.jybecxv(j2)) : x.zamkzqg.jybecxv(j));
        }
        TextView textView4 = this.ohwxijw;
        if (textView4 != null) {
            textView4.setText(d > 0.0d ? getString(R.string.progress_rate, x.zamkzqg.jybecxv((long) d)) : getString(R.string.value_not_available));
        }
        TextView textView5 = this.yomtcav;
        if (textView5 != null) {
            textView5.setText(x.zamkzqg.civyupy(jMax));
        }
        TextView textView6 = this.uzyihoe;
        if (textView6 != null) {
            if (d <= 0.0d || j2 <= j || j < 0) {
                textView6.setText(i >= 100 ? getString(R.string.progress_zero_time) : getString(R.string.value_not_available));
            } else {
                textView6.setText(x.zamkzqg.civyupy((long) (((j2 - j) / d) * 1000.0d)));
            }
        }
        String str3 = null;
        String strJybecxv = j >= 0 ? x.zamkzqg.jybecxv(j) : null;
        String strJybecxv2 = j2 > 0 ? x.zamkzqg.jybecxv(j2) : null;
        if (d > 0.0d) {
            str3 = x.zamkzqg.jybecxv((long) d) + "/s";
        }
        String str4 = this.cxxnoho;
        int iMax = Math.max(0, Math.min(100, i));
        int i3 = ((iMax * 20) + 50) / 100;
        if (i3 > 20) {
            i3 = 20;
        }
        StringBuilder sb = new StringBuilder(112);
        if ("READ".equals(str)) {
            str2 = "[BACKUP]";
        } else {
            str2 = "ERASE".equals(str) ? "[ERASE ]" : "[FLASH ]";
        }
        sb.append(str2);
        sb.append(' ');
        sb.append(String.format(Locale.US, "%-11s ", x.zamkzqg.kxotgjb(str4) ? str4.trim() : "unknown"));
        sb.append('[');
        int i4 = 0;
        while (i4 < 20) {
            sb.append(i4 < i3 ? '#' : '-');
            i4++;
        }
        sb.append("] ");
        sb.append(String.format(Locale.US, "%3d%%", Integer.valueOf(iMax)));
        if (x.zamkzqg.kxotgjb(strJybecxv)) {
            sb.append("  ");
            sb.append(strJybecxv.trim());
            if (x.zamkzqg.kxotgjb(strJybecxv2)) {
                sb.append(" / ");
                sb.append(strJybecxv2.trim());
            }
        }
        if (x.zamkzqg.kxotgjb(str3)) {
            sb.append("  ");
            sb.append(str3.trim());
        }
        String string = sb.toString();
        eenkamx(string);
        ysaclsr ysaclsrVar = this.snilumr;
        if (string == null) {
            ysaclsrVar.getClass();
            return;
        }
        TextView textView7 = ysaclsrVar.nmpwovh;
        if (textView7 == null) {
            return;
        }
        boolean z = ysaclsrVar.lthborb;
        CharSequence text = textView7.getText();
        if (!ysaclsrVar.qxvquar || text == null || text.length() <= 0) {
            ysaclsrVar.nmpwovh.append(string);
            ysaclsrVar.nmpwovh.append("\n");
        } else {
            int length = text.length();
            int i5 = (length <= 0 || text.charAt(length + (-1)) != '\n') ? length : length - 1;
            while (i5 > 0 && text.charAt(i5 - 1) != '\n') {
                i5--;
            }
            StringBuilder sb2 = new StringBuilder(Math.max(string.length() + i5 + 1, length));
            sb2.append(text, 0, i5);
            sb2.append(string);
            sb2.append('\n');
            ysaclsrVar.nmpwovh.setText(sb2.toString());
        }
        ysaclsrVar.qxvquar = true;
        ysaclsrVar.nmpwovh();
        if (z) {
            ysaclsrVar.lthborb = true;
            ScrollView scrollView = ysaclsrVar.ojyssqt;
            if (scrollView == null) {
                return;
            }
            scrollView.post(new eigllth(ysaclsrVar, 3));
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00de  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:54:0x010c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0112  */
    public final void hknanqb() {
        String string = null;
        String string2 = null;
        String str;
        boolean z = false;
        String str2;
        String string3 = null;
        String name;
        ArrayList arrayList = this.pcbbvuj;
        if (arrayList.isEmpty()) {
            vopsyhw(this.ecffprn);
            return;
        }
        ArrayList<oohojlj> arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            bpqosqe bpqosqeVar = (bpqosqe) arrayList.get(i);
            File file = (File) this.fprgbbe.get(bpqosqeVar.nmpwovh);
            boolean z2 = file != null && file.isFile() && file.canRead();
            boolean z3 = z2 && bpqosqe(bpqosqeVar, file, this.ecffprn);
            if (z2) {
                if (z3) {
                    string2 = getString(R.string.batch_flash_image_ready, x.zamkzqg.jybecxv(file.length()));
                } else {
                    String strJybecxv = x.zamkzqg.jybecxv(file.length());
                    Iterator it = cugubfc(bpqosqeVar, this.ecffprn).iterator();
                    long jMin = Long.MAX_VALUE;
                    while (it.hasNext()) {
                        jMin = Math.min(jMin, ((ohwxijw) it.next()).vivhedu);
                        strJybecxv = strJybecxv;
                    }
                    String str3 = strJybecxv;
                    if (jMin == Long.MAX_VALUE) {
                        jMin = 0;
                    }
                    string = getString(R.string.batch_flash_image_too_large_row, str3, x.zamkzqg.jybecxv(jMin));
                }
                str = this.ecffprn;
                if (bpqosqeVar.ojyssqt == null || bpqosqeVar.vivhedu != null) {
                    z = true;
                } else {
                    z = false;
                }
                str2 = bpqosqeVar.nmpwovh;
                if (!z) {
                    string3 = getString(R.string.batch_flash_target_summary_plain, str2);
                } else if ("a".equals(str)) {
                    string3 = getString(R.string.batch_flash_target_summary_a, str2);
                } else if ("b".equals(str)) {
                    string3 = getString(R.string.batch_flash_target_summary_b, str2);
                } else {
                    string3 = getString(R.string.batch_flash_target_summary_all, str2);
                }
                String str4 = string3;
                if (z2) {
                    name = file.getName();
                } else {
                    name = "";
                }
                arrayList2.add(new oohojlj(i, bpqosqeVar.nmpwovh, str4, name, string, z3, z2, oohojlj(bpqosqeVar, this.ecffprn)));
            } else {
                string2 = getString(R.string.batch_flash_no_image);
            }
            string = string2;
            str = this.ecffprn;
            if (bpqosqeVar.ojyssqt == null) {
                z = true;
            } else {
                z = true;
            }
            str2 = bpqosqeVar.nmpwovh;
            if (!z) {
                string3 = getString(R.string.batch_flash_target_summary_plain, str2);
            } else if ("a".equals(str)) {
                string3 = getString(R.string.batch_flash_target_summary_a, str2);
            } else if ("b".equals(str)) {
                string3 = getString(R.string.batch_flash_target_summary_b, str2);
            } else {
                string3 = getString(R.string.batch_flash_target_summary_all, str2);
            }
            String str5 = string3;
            if (z2) {
                name = file.getName();
            } else {
                name = "";
            }
            arrayList2.add(new oohojlj(i, bpqosqeVar.nmpwovh, str5, name, string, z3, z2, oohojlj(bpqosqeVar, this.ecffprn)));
        }
        String strAraemok = araemok(this.ecffprn);
        final mcdstyz mcdstyzVar = new mcdstyz(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(x.zamkzqg.buswjhz(this));
        Iterator it2 = arrayList2.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            if (((oohojlj) it2.next()).nkemejx) {
                i2++;
            }
        }
        boolean z4 = !arrayList2.isEmpty() && i2 == arrayList2.size();
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
        LinearLayout linearLayoutLvtqoqa = x.zamkzqg.lvtqoqa(this);
        linearLayoutLvtqoqa.setGravity(16);
        final int i3 = 0;
        linearLayoutLvtqoqa.addView(x.zamkzqg.btazysh(this, R.drawable.ic_back, x.zamkzqg.nmpwovh(this), R.string.batch_flash_back_setup, new View.OnClickListener() { // from class: x.hiygjel
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i3) {
                    case 0:
                        mcdstyzVar.nmpwovh.buswjhz();
                        break;
                    case 1:
                        kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                        kggugdpVar.getClass();
                        try {
                            ArrayList<araemok> arrayListJofyvuh = kggugdpVar.jofyvuh();
                            ArrayList arrayList3 = new ArrayList();
                            boolean z5 = false;
                            for (araemok araemokVar : arrayListJofyvuh) {
                                ohwxijw ohwxijwVar = araemokVar.nmpwovh;
                                z5 |= ohwxijwVar.nkemejx;
                                String strNpkgpdo = x.kggugdp.npkgpdo(ohwxijwVar.nmpwovh);
                                ohwxijw ohwxijwVar2 = araemokVar.nmpwovh;
                                String str6 = ohwxijwVar2.nmpwovh;
                                File file2 = araemokVar.ojyssqt;
                                arrayList3.add(new tnejqcj(strNpkgpdo, str6, file2.getName(), kggugdpVar.getString(R.string.batch_flash_review_image_meta, ohwxijwVar2.lthborb, x.zamkzqg.jybecxv(file2.length()), x.zamkzqg.jybecxv(ohwxijwVar2.vivhedu)), ohwxijwVar2.oqexvyb));
                            }
                            kggugdpVar.kffvigz(x.zamkzqg.vntpaom(kggugdpVar, kggugdpVar.araemok(kggugdpVar.ecffprn), arrayList3, z5, new gucwjqz(kggugdpVar, arrayListJofyvuh)), "batch_flash_review");
                        } catch (Throwable th) {
                            Toast.makeText(kggugdpVar, String.valueOf(th.getMessage()), 1).show();
                            kggugdpVar.hknanqb();
                            return;
                        }
                        break;
                    default:
                        kggugdp kggugdpVar2 = mcdstyzVar.nmpwovh;
                        if (kggugdpVar2.dplrlfq()) {
                            new ecffprn(kggugdpVar2, kggugdpVar2.getString(R.string.batch_flash_auto_match_short), kggugdpVar2.lclupha(), 1, null, new thbdbid(kggugdpVar2, 1)).nkemejx();
                            break;
                        }
                        break;
                }
            }
        }), new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
        TextView textViewOxoagud = x.zamkzqg.oxoagud(this, getString(R.string.batch_flash_assign_title), 20, x.zamkzqg.zngzleo(this), true);
        int i4 = -2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
        linearLayoutLvtqoqa.addView(textViewOxoagud, layoutParams);
        linearLayout2.addView(linearLayoutLvtqoqa);
        LinearLayout linearLayoutLvtqoqa2 = x.zamkzqg.lvtqoqa(this);
        linearLayoutLvtqoqa2.setGravity(16);
        TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, getString(R.string.batch_flash_ready_compact, Integer.valueOf(i2), Integer.valueOf(arrayList2.size())), 11, z4 ? x.zamkzqg.pzkwhtn(this) : x.zamkzqg.ohwxijw(this), true);
        textViewOxoagud2.setGravity(17);
        textViewOxoagud2.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
        textViewOxoagud2.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_sticky_action_radius, this, z4 ? getColor(x.zamkzqg.ysluikv(this) ? R.color.rynx_dark_success_chip : R.color.rynx_light_success_chip) : x.zamkzqg.atntgcp(this), getColor(R.color.rynx_transparent)));
        linearLayoutLvtqoqa2.addView(textViewOxoagud2);
        linearLayoutLvtqoqa2.addView(new View(this), new LinearLayout.LayoutParams(0, 1, 1.0f));
        int iKggugdp = x.zamkzqg.kggugdp(this);
        final int i5 = 1;
        TextView textViewLclupha = x.zamkzqg.lclupha(this, getString(R.string.batch_flash_review_compact), new View.OnClickListener() { // from class: x.hiygjel
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        mcdstyzVar.nmpwovh.buswjhz();
                        break;
                    case 1:
                        kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                        kggugdpVar.getClass();
                        try {
                            ArrayList<araemok> arrayListJofyvuh = kggugdpVar.jofyvuh();
                            ArrayList arrayList3 = new ArrayList();
                            boolean z5 = false;
                            for (araemok araemokVar : arrayListJofyvuh) {
                                ohwxijw ohwxijwVar = araemokVar.nmpwovh;
                                z5 |= ohwxijwVar.nkemejx;
                                String strNpkgpdo = x.kggugdp.npkgpdo(ohwxijwVar.nmpwovh);
                                ohwxijw ohwxijwVar2 = araemokVar.nmpwovh;
                                String str6 = ohwxijwVar2.nmpwovh;
                                File file2 = araemokVar.ojyssqt;
                                arrayList3.add(new tnejqcj(strNpkgpdo, str6, file2.getName(), kggugdpVar.getString(R.string.batch_flash_review_image_meta, ohwxijwVar2.lthborb, x.zamkzqg.jybecxv(file2.length()), x.zamkzqg.jybecxv(ohwxijwVar2.vivhedu)), ohwxijwVar2.oqexvyb));
                            }
                            kggugdpVar.kffvigz(x.zamkzqg.vntpaom(kggugdpVar, kggugdpVar.araemok(kggugdpVar.ecffprn), arrayList3, z5, new gucwjqz(kggugdpVar, arrayListJofyvuh)), "batch_flash_review");
                        } catch (Throwable th) {
                            Toast.makeText(kggugdpVar, String.valueOf(th.getMessage()), 1).show();
                            kggugdpVar.hknanqb();
                            return;
                        }
                        break;
                    default:
                        kggugdp kggugdpVar2 = mcdstyzVar.nmpwovh;
                        if (kggugdpVar2.dplrlfq()) {
                            new ecffprn(kggugdpVar2, kggugdpVar2.getString(R.string.batch_flash_auto_match_short), kggugdpVar2.lclupha(), 1, null, new thbdbid(kggugdpVar2, 1)).nkemejx();
                            break;
                        }
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha, R.drawable.ic_flash, iKggugdp);
        textViewLclupha.setTextColor(x.zamkzqg.kggugdp(this));
        textViewLclupha.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_sticky_action_radius, this, x.zamkzqg.ojyssqt(this), getColor(R.color.rynx_transparent)));
        textViewLclupha.setEnabled(z4);
        textViewLclupha.setAlpha(z4 ? 1.0f : 0.42f);
        linearLayoutLvtqoqa2.addView(textViewLclupha, new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
        linearLayout2.addView(linearLayoutLvtqoqa2, layoutParams2);
        linearLayout.addView(linearLayout2);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(1);
        linearLayout3.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
        scrollView.addView(linearLayout3);
        linearLayout3.addView(x.zamkzqg.oxoagud(this, getString(R.string.batch_flash_assign_subtitle), 11, x.zamkzqg.jbmzxye(this), false));
        TextView textViewOxoagud3 = x.zamkzqg.oxoagud(this, getString(R.string.batch_flash_slot_chip, strAraemok), 10, x.zamkzqg.nmpwovh(this), true);
        textViewOxoagud3.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
        textViewOxoagud3.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_sticky_action_radius, this, x.zamkzqg.atntgcp(this), getColor(R.color.rynx_transparent)));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
        linearLayout3.addView(textViewOxoagud3, layoutParams3);
        LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(this);
        linearLayoutLvtqoqa3.addView(x.zamkzqg.pcbbvuj(this, R.string.batch_flash_step_target, true), x.zamkzqg.yrgokys(this));
        linearLayoutLvtqoqa3.addView(x.zamkzqg.pcbbvuj(this, R.string.batch_flash_step_partitions, true), x.zamkzqg.yrgokys(this));
        linearLayoutLvtqoqa3.addView(x.zamkzqg.pcbbvuj(this, R.string.batch_flash_step_images, true), x.zamkzqg.yrgokys(this));
        linearLayoutLvtqoqa3.addView(x.zamkzqg.pcbbvuj(this, R.string.batch_flash_step_review, false), x.zamkzqg.yrgokys(this));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
        linearLayout3.addView(linearLayoutLvtqoqa3, layoutParams4);
        LinearLayout linearLayoutGhkjjru = x.zamkzqg.ghkjjru(this);
        TextView textViewYsaclsr = x.zamkzqg.ysaclsr(this, R.string.batch_flash_auto_match_short);
        x.zamkzqg.enxkjpu(this, textViewYsaclsr, R.drawable.ic_folder, x.zamkzqg.nmpwovh(this));
        linearLayoutGhkjjru.addView(textViewYsaclsr);
        TextView textViewOxoagud4 = x.zamkzqg.oxoagud(this, getString(R.string.batch_flash_auto_match_desc), 10, x.zamkzqg.jbmzxye(this), false);
        textViewOxoagud4.setPadding(0, getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom));
        linearLayoutGhkjjru.addView(textViewOxoagud4);
        final int i6 = 2;
        TextView textViewLclupha2 = x.zamkzqg.lclupha(this, getString(R.string.batch_flash_auto_match_short), new View.OnClickListener() { // from class: x.hiygjel
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        mcdstyzVar.nmpwovh.buswjhz();
                        break;
                    case 1:
                        kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                        kggugdpVar.getClass();
                        try {
                            ArrayList<araemok> arrayListJofyvuh = kggugdpVar.jofyvuh();
                            ArrayList arrayList3 = new ArrayList();
                            boolean z5 = false;
                            for (araemok araemokVar : arrayListJofyvuh) {
                                ohwxijw ohwxijwVar = araemokVar.nmpwovh;
                                z5 |= ohwxijwVar.nkemejx;
                                String strNpkgpdo = x.kggugdp.npkgpdo(ohwxijwVar.nmpwovh);
                                ohwxijw ohwxijwVar2 = araemokVar.nmpwovh;
                                String str6 = ohwxijwVar2.nmpwovh;
                                File file2 = araemokVar.ojyssqt;
                                arrayList3.add(new tnejqcj(strNpkgpdo, str6, file2.getName(), kggugdpVar.getString(R.string.batch_flash_review_image_meta, ohwxijwVar2.lthborb, x.zamkzqg.jybecxv(file2.length()), x.zamkzqg.jybecxv(ohwxijwVar2.vivhedu)), ohwxijwVar2.oqexvyb));
                            }
                            kggugdpVar.kffvigz(x.zamkzqg.vntpaom(kggugdpVar, kggugdpVar.araemok(kggugdpVar.ecffprn), arrayList3, z5, new gucwjqz(kggugdpVar, arrayListJofyvuh)), "batch_flash_review");
                        } catch (Throwable th) {
                            Toast.makeText(kggugdpVar, String.valueOf(th.getMessage()), 1).show();
                            kggugdpVar.hknanqb();
                            return;
                        }
                        break;
                    default:
                        kggugdp kggugdpVar2 = mcdstyzVar.nmpwovh;
                        if (kggugdpVar2.dplrlfq()) {
                            new ecffprn(kggugdpVar2, kggugdpVar2.getString(R.string.batch_flash_auto_match_short), kggugdpVar2.lclupha(), 1, null, new thbdbid(kggugdpVar2, 1)).nkemejx();
                            break;
                        }
                        break;
                }
            }
        });
        textViewLclupha2.setTextSize(10.0f);
        linearLayoutGhkjjru.addView(textViewLclupha2, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height)));
        linearLayout3.addView(linearLayoutGhkjjru, x.zamkzqg.uiqyzsp(this));
        for (oohojlj oohojljVar : arrayList2) {
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.setOrientation(1);
            linearLayout4.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
            int iTmdubwv = x.zamkzqg.tmdubwv(this, oohojljVar.oqexvyb);
            String str6 = oohojljVar.oqexvyb;
            linearLayout4.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_compact_row_radius, this, iTmdubwv, x.zamkzqg.cugubfc(this, str6)));
            LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(this);
            linearLayoutLvtqoqa4.setGravity(16);
            linearLayoutLvtqoqa4.addView(x.zamkzqg.oxoagud(this, oohojljVar.ojyssqt, 14, x.zamkzqg.zngzleo(this), true), new LinearLayout.LayoutParams(0, i4, 1.0f));
            TextView textViewOxoagud5 = x.zamkzqg.oxoagud(this, getString("red".equals(str6) ? R.string.parts_risk_red : "yellow".equals(str6) ? R.string.parts_risk_yellow : R.string.parts_risk_green), 9, x.zamkzqg.cugubfc(this, str6), true);
            textViewOxoagud5.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
            textViewOxoagud5.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_compact_badge_radius, this, x.zamkzqg.tmdubwv(this, str6), getColor(R.color.rynx_transparent)));
            linearLayoutLvtqoqa4.addView(textViewOxoagud5);
            linearLayout4.addView(linearLayoutLvtqoqa4);
            TextView textViewOxoagud6 = x.zamkzqg.oxoagud(this, oohojljVar.vivhedu, 10, x.zamkzqg.jbmzxye(this), false);
            textViewOxoagud6.setPadding(0, getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top));
            linearLayout4.addView(textViewOxoagud6);
            LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(this);
            linearLayoutLvtqoqa5.setGravity(16);
            linearLayoutLvtqoqa5.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_compact_file_padding), 0, getResources().getDimensionPixelSize(R.dimen.batch_compact_file_padding), 0);
            linearLayoutLvtqoqa5.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_compact_file_radius, this, x.zamkzqg.atntgcp(this), getColor(R.color.rynx_transparent)));
            LinearLayout linearLayout5 = new LinearLayout(this);
            linearLayout5.setOrientation(1);
            boolean z5 = oohojljVar.imuemzb;
            linearLayout5.addView(x.zamkzqg.oxoagud(this, z5 ? oohojljVar.lthborb : getString(R.string.batch_flash_no_image), 11, z5 ? x.zamkzqg.zngzleo(this) : x.zamkzqg.jbmzxye(this), z5));
            TextView textViewOxoagud7 = x.zamkzqg.oxoagud(this, oohojljVar.qxvquar, 9, oohojljVar.nkemejx ? x.zamkzqg.pzkwhtn(this) : z5 ? x.zamkzqg.pzqxblc(this) : x.zamkzqg.ohwxijw(this), true);
            textViewOxoagud7.setPadding(0, getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
            linearLayout5.addView(textViewOxoagud7);
            linearLayoutLvtqoqa5.addView(linearLayout5, new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textViewLclupha3 = x.zamkzqg.lclupha(this, getString(z5 ? R.string.batch_flash_change_image : R.string.batch_flash_select_image), new pzqxblc(mcdstyzVar, oohojljVar, 2));
            textViewLclupha3.setTextSize(9.0f);
            linearLayoutLvtqoqa5.addView(textViewLclupha3, new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height)));
            linearLayout4.addView(linearLayoutLvtqoqa5, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.batch_compact_file_height)));
            linearLayout3.addView(linearLayout4, x.zamkzqg.uiqyzsp(this));
            i4 = -2;
        }
        linearLayout3.addView(new View(this), new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        kffvigz(linearLayout, "batch_flash_assign");
    }

    @Override // com.rynx.app.ojyssqt
    public final void ivvkvsj() {
        if (!this.mwngani || this.qwgjehf || this.gzokllk || this.nsyqsfj || !pvbzgon() || !vntpaom()) {
            return;
        }
        nsizane();
        if (this.qwgjehf && "scatter_flash".equals(this.ayzlrnr)) {
            gzokllk();
        }
    }

    public final ArrayList jofyvuh() {
        ArrayList arrayList = new ArrayList();
        for (bpqosqe bpqosqeVar : (java.util.ArrayList<bpqosqe>) this.pcbbvuj) {
            File file = (File) this.fprgbbe.get(bpqosqeVar.nmpwovh);
            boolean zBpqosqe = bpqosqe(bpqosqeVar, file, this.ecffprn);
            String str = bpqosqeVar.nmpwovh;
            if (!zBpqosqe) {
                throw new IllegalArgumentException(getString(R.string.batch_flash_no_match, str));
            }
            ArrayList<ohwxijw> arrayListCugubfc = cugubfc(bpqosqeVar, this.ecffprn);
            if (arrayListCugubfc.isEmpty()) {
                throw new IllegalArgumentException(getString(R.string.batch_flash_missing_slot, str, araemok(this.ecffprn)));
            }
            for (ohwxijw ohwxijwVar : arrayListCugubfc) {
                if (file.length() > ohwxijwVar.vivhedu) {
                    throw new IllegalArgumentException(getString(R.string.batch_flash_too_large, file.getName(), x.zamkzqg.jybecxv(file.length()), ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar.vivhedu)));
                }
                arrayList.add(new araemok(ohwxijwVar, file, false));
            }
        }
        return arrayList;
    }

    public final void kffvigz(ViewGroup viewGroup, String str) {
        if (this.exhiehf != null) {
            nsyqsfj(str);
            boolean z = this.lataqgm;
            eigllth(str);
            this.zhpnlmy = "menu";
            this.lataqgm = false;
            jtfjrri(true);
            kxotgjb(viewGroup, 0);
            rvrflql rvrflqlVar = this.jybecxv;
            if (rvrflqlVar != null) {
                rvrflqlVar.vivhedu(this.zhpnlmy);
            }
            if (z) {
                bgmsltp();
            } else {
                gefzxcg();
            }
        }
    }

    public final void kpmmknm(int i, boolean z) {
        int i2 = z ? R.string.batch_flash_progress_title : R.string.batch_backup_progress_title;
        final qxvquar qxvquarVar = new qxvquar(this, z);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        LinearLayout linearLayoutXbdyiew = x.zamkzqg.xbdyiew(this, 16);
        scrollView.addView(linearLayoutXbdyiew);
        int iNmpwovh = x.zamkzqg.nmpwovh(this);
        final int i3 = 0;
        TextView textViewLclupha = x.zamkzqg.lclupha(this, getString(R.string.parts_title), new View.OnClickListener() { // from class: x.ftrcqfq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i3) {
                    case 0:
                        qxvquar qxvquarVar2 = qxvquarVar;
                        if (!((kggugdp) qxvquarVar2.ojyssqt).lpkdqgx) {
                            ((kggugdp) qxvquarVar2.ojyssqt).buswjhz();
                        } else {
                            Toast.makeText((kggugdp) qxvquarVar2.ojyssqt, qxvquarVar2.nmpwovh ? R.string.flash_still_running : R.string.parts_backup_running_warning, 0).show();
                        }
                        break;
                    default:
                        qxvquar qxvquarVar3 = qxvquarVar;
                        boolean z2 = qxvquarVar3.nmpwovh;
                        kggugdp kggugdpVar = (kggugdp) qxvquarVar3.ojyssqt;
                        if (!z2) {
                            kggugdpVar.yonoayx();
                        } else {
                            kggugdpVar.imuemzb();
                        }
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha, R.drawable.ic_back, iNmpwovh);
        textViewLclupha.setGravity(8388627);
        linearLayoutXbdyiew.addView(textViewLclupha);
        linearLayoutXbdyiew.addView(x.zamkzqg.ywhgqsi(this, getString(i2)));
        LinearLayout linearLayoutZwaqeaz = x.zamkzqg.zwaqeaz(this);
        linearLayoutZwaqeaz.addView(x.zamkzqg.ysaclsr(this, R.string.batch_overall_progress));
        TextView textViewOxoagud = x.zamkzqg.oxoagud(this, getString(R.string.batch_overall_initial, Integer.valueOf(i)), 12, x.zamkzqg.zngzleo(this), true);
        linearLayoutZwaqeaz.addView(textViewOxoagud);
        ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setMax(Math.max(1, i));
        progressBar.setProgress(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(this, 12));
        layoutParams.topMargin = x.zamkzqg.qunltjs(this, 8);
        linearLayoutZwaqeaz.addView(progressBar, layoutParams);
        linearLayoutXbdyiew.addView(linearLayoutZwaqeaz, x.zamkzqg.uiqyzsp(this));
        LinearLayout linearLayoutZwaqeaz2 = x.zamkzqg.zwaqeaz(this);
        linearLayoutZwaqeaz2.addView(x.zamkzqg.ysaclsr(this, R.string.batch_current_partition));
        TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, getString(R.string.batch_preparing), 17, x.zamkzqg.zngzleo(this), true);
        linearLayoutZwaqeaz2.addView(textViewOxoagud2);
        LinearLayout linearLayoutLvtqoqa = x.zamkzqg.lvtqoqa(this);
        TextView textViewOxoagud3 = x.zamkzqg.oxoagud(this, "0%", 22, x.zamkzqg.pzkwhtn(this), true);
        TextView textViewOxoagud4 = x.zamkzqg.oxoagud(this, getString(R.string.batch_waiting), 11, x.zamkzqg.jbmzxye(this), false);
        textViewOxoagud4.setGravity(8388613);
        linearLayoutLvtqoqa.addView(textViewOxoagud3, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayoutLvtqoqa.addView(textViewOxoagud4, new LinearLayout.LayoutParams(0, -2, 2.0f));
        linearLayoutZwaqeaz2.addView(linearLayoutLvtqoqa);
        ProgressBar progressBar2 = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        progressBar2.setMax(100);
        progressBar2.setProgress(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(this, 12));
        layoutParams2.topMargin = x.zamkzqg.qunltjs(this, 8);
        linearLayoutZwaqeaz2.addView(progressBar2, layoutParams2);
        linearLayoutXbdyiew.addView(linearLayoutZwaqeaz2, x.zamkzqg.uiqyzsp(this));
        LinearLayout linearLayoutZwaqeaz3 = x.zamkzqg.zwaqeaz(this);
        linearLayoutZwaqeaz3.addView(x.zamkzqg.ysaclsr(this, R.string.progress_log_preview));
        TextView textViewOxoagud5 = x.zamkzqg.oxoagud(this, getString(R.string.progress_waiting_backend), 10, x.zamkzqg.zngzleo(this), false);
        textViewOxoagud5.setTypeface(Typeface.MONOSPACE);
        textViewOxoagud5.setTextIsSelectable(true);
        linearLayoutZwaqeaz3.addView(textViewOxoagud5);
        linearLayoutXbdyiew.addView(linearLayoutZwaqeaz3, x.zamkzqg.uiqyzsp(this));
        if (z) {
            TextView textViewOxoagud6 = x.zamkzqg.oxoagud(this, getString(R.string.batch_flash_disconnect_warning), 12, x.zamkzqg.ohwxijw(this), true);
            x.zamkzqg.enxkjpu(this, textViewOxoagud6, R.drawable.ic_warning, x.zamkzqg.ohwxijw(this));
            linearLayoutXbdyiew.addView(textViewOxoagud6);
        }
        int iPzqxblc = x.zamkzqg.pzqxblc(this);
        final int i4 = 1;
        TextView textViewLclupha2 = x.zamkzqg.lclupha(this, getString(R.string.progress_stop_session), new View.OnClickListener() { // from class: x.ftrcqfq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        qxvquar qxvquarVar2 = qxvquarVar;
                        if (!((kggugdp) qxvquarVar2.ojyssqt).lpkdqgx) {
                            ((kggugdp) qxvquarVar2.ojyssqt).buswjhz();
                        } else {
                            Toast.makeText((kggugdp) qxvquarVar2.ojyssqt, qxvquarVar2.nmpwovh ? R.string.flash_still_running : R.string.parts_backup_running_warning, 0).show();
                        }
                        break;
                    default:
                        qxvquar qxvquarVar3 = qxvquarVar;
                        boolean z2 = qxvquarVar3.nmpwovh;
                        kggugdp kggugdpVar = (kggugdp) qxvquarVar3.ojyssqt;
                        if (!z2) {
                            kggugdpVar.yonoayx();
                        } else {
                            kggugdpVar.imuemzb();
                        }
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha2, R.drawable.ic_stop, iPzqxblc);
        textViewLclupha2.setTextColor(x.zamkzqg.pzqxblc(this));
        linearLayoutXbdyiew.addView(textViewLclupha2, new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(this, 50)));
        this.oxoagud = progressBar;
        this.axbavsj = textViewOxoagud;
        this.zngzleo = textViewOxoagud2;
        this.vhimehb = progressBar2;
        this.naaizwn = textViewOxoagud3;
        this.hjlrtqw = textViewOxoagud4;
        this.dkpobjg = textViewOxoagud5;
        this.xbdyiew = null;
        this.ohwxijw = null;
        this.yomtcav = null;
        this.uzyihoe = null;
        kffvigz(scrollView, "batch_operation_progress");
    }

    @Override // com.rynx.app.ojyssqt
    public final void kxotgjb(View view, int i) {
        View childAt;
        tmdubwv tmdubwvVar;
        if (this.exhiehf == null || view == null) {
            return;
        }
        if (view == this.lvtqoqa && (tmdubwvVar = this.gefzxcg) != null) {
            ((ljhdwjr) tmdubwvVar.nmpwovh).ojyssqt(false);
        }
        marclvq(view);
        jtfjrri(true);
        if (this.exhiehf.getChildCount() > 0) {
            FrameLayout frameLayout = this.exhiehf;
            childAt = frameLayout.getChildAt(frameLayout.getChildCount() - 1);
        } else {
            childAt = null;
        }
        if (childAt == view) {
            ibfmasn(view);
            return;
        }
        for (int childCount = this.exhiehf.getChildCount() - 2; childCount >= 0; childCount--) {
            View childAt2 = this.exhiehf.getChildAt(childCount);
            ibfmasn(childAt2);
            this.exhiehf.removeView(childAt2);
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        view.setLayoutParams(layoutParams);
        if (childAt == null || !ValueAnimator.areAnimatorsEnabled()) {
            this.exhiehf.removeAllViews();
            ibfmasn(view);
            this.exhiehf.addView(view, layoutParams);
            return;
        }
        float dimensionPixelSize = i == 0 ? 0.0f : getResources().getDimensionPixelSize(R.dimen.ui_page_transition_x) * i;
        float dimensionPixelSize2 = i == 0 ? getResources().getDimensionPixelSize(R.dimen.ui_page_transition_y) : 0.0f;
        int integer = getResources().getInteger(R.integer.ui_page_enter_ms);
        int integer2 = getResources().getInteger(R.integer.ui_page_exit_ms);
        ibfmasn(view);
        view.setAlpha(0.0f);
        view.setTranslationX(dimensionPixelSize);
        view.setTranslationY(dimensionPixelSize2);
        this.exhiehf.addView(view, layoutParams);
        childAt.animate().cancel();
        childAt.animate().alpha(0.0f).translationX((-dimensionPixelSize) * 0.55f).translationY((-dimensionPixelSize2) * 0.45f).setDuration(integer2).setInterpolator(new DecelerateInterpolator()).withEndAction(new atntgcp(this, childAt, 2)).start();
        view.animate().cancel();
        view.animate().alpha(1.0f).translationX(0.0f).translationY(0.0f).setDuration(integer).setInterpolator(new DecelerateInterpolator()).start();
    }

    public final String ljhdwjr(ArrayList arrayList) throws IOException {
        File file;
        lcgzsis lcgzsisVar = this.wdznaie;
        if (lcgzsisVar == null || (file = lcgzsisVar.nmpwovh) == null) {
            throw new IOException(getString(R.string.scatter_no_file));
        }
        File canonicalFile = file.getCanonicalFile();
        StringBuilder sb = new StringBuilder();
        sb.append(xqbcyis());
        sb.append('\n');
        String str = this.cnctlxz.lthborb;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append('\n');
        sb.append(this.ijakhcl);
        sb.append('\n');
        sb.append(this.lsgjyur);
        sb.append('\n');
        sb.append(canonicalFile.getCanonicalPath());
        sb.append('|');
        sb.append(canonicalFile.length());
        sb.append('|');
        sb.append(canonicalFile.lastModified());
        sb.append('\n');
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            araemok araemokVar = (araemok) it.next();
            File canonicalFile2 = araemokVar.ojyssqt.getCanonicalFile();
            sb.append(com.rynx.app.ojyssqt.pzqxblc(araemokVar.nmpwovh.nmpwovh));
            sb.append('|');
            sb.append(araemokVar.nmpwovh.ojyssqt);
            sb.append('|');
            sb.append(araemokVar.nmpwovh.vivhedu);
            sb.append('|');
            sb.append(araemokVar.nmpwovh.lthborb);
            sb.append('|');
            sb.append(canonicalFile2.getCanonicalPath());
            sb.append('|');
            sb.append(canonicalFile2.length());
            sb.append('|');
            sb.append(canonicalFile2.lastModified());
            sb.append('\n');
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:209:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x0139  */
    public final void ljwltks() {
        ohwxijw ohwxijwVar;
        String string = null;
        String string2 = null;
        boolean z = false;
        boolean z2 = false;
        ohwxijw ohwxijwVar2;
        String string3 = null;
        boolean z3 = false;
        boolean z4 = false;
        String string4 = null;
        this.pwnmyid.clear();
        String string5 = "";
        if (this.wdznaie == null) {
            this.pzkwhtn = "";
            return;
        }
        boolean z5 = this.nsyqsfj && !this.jbmzxye.isEmpty() && !this.iasgsgq && this.ghkjjru.isEmpty();
        if (!this.ghkjjru.isEmpty()) {
            this.pzkwhtn = this.ghkjjru;
        } else if (z5) {
            lcgzsis lcgzsisVar = this.wdznaie;
            String strEdnetju = ednetju(lcgzsisVar.nmpwovh);
            if (strEdnetju.isEmpty()) {
                String strDasxvpc = x.pwjmwpv.dasxvpc(lcgzsisVar.qxvquar);
                String strDasxvpc2 = x.pwjmwpv.dasxvpc(this.cnctlxz.ojyssqt);
                if (strDasxvpc.isEmpty() || strDasxvpc2.isEmpty() || strDasxvpc.equals(strDasxvpc2)) {
                    String strUlafhci = com.rynx.app.ojyssqt.ulafhci(lcgzsisVar.vivhedu);
                    String strUlafhci2 = com.rynx.app.ojyssqt.ulafhci(this.cnctlxz.nmpwovh);
                    if (!strUlafhci.isEmpty() && !strUlafhci2.isEmpty() && !strUlafhci.equals(strUlafhci2)) {
                        string5 = getString(R.string.scatter_global_platform_mismatch, lcgzsisVar.vivhedu, this.cnctlxz.nmpwovh);
                    }
                } else {
                    string5 = getString(R.string.scatter_global_storage_mismatch, lcgzsisVar.qxvquar, this.cnctlxz.ojyssqt);
                }
            } else {
                string5 = strEdnetju;
            }
            this.pzkwhtn = string5;
        } else {
            this.pzkwhtn = getString(R.string.scatter_offline_preview_status);
        }
        boolean zEquals = "firmware_upgrade".equals(this.ijakhcl);
        String strDasxvpc3 = x.pwjmwpv.dasxvpc(this.wdznaie.qxvquar);
        int i = 0;
        while (i < this.wdznaie.nkemejx.size()) {
            aqyicql aqyicqlVar = (aqyicql) this.wdznaie.nkemejx.get(i);
            if (!aqyicqlVar.lthborb || (zEquals && !com.rynx.app.ojyssqt.atntgcp(aqyicqlVar))) {
                strDasxvpc3 = strDasxvpc3;
            } else {
                String str = aqyicqlVar.ojyssqt;
                File fileVntpaom = null;
                if (str == null) {
                    ohwxijwVar = null;
                    break;
                }
                Iterator it = this.jbmzxye.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        ohwxijwVar = null;
                        break;
                    }
                    ohwxijwVar = (ohwxijw) it.next();
                    String str2 = ohwxijwVar.nmpwovh;
                    if (str2 != null && str2.equalsIgnoreCase(str)) {
                        break;
                    }
                }
                boolean z6 = ohwxijwVar == null;
                boolean z7 = zEquals && "NEEDRESIZE".equalsIgnoreCase(aqyicqlVar.dasxvpc);
                if (aqyicqlVar.wqrnifx || ((!zEquals && "INVISIBLE".equalsIgnoreCase(aqyicqlVar.dasxvpc)) || aqyicqlVar.qxvquar < 0)) {
                    string = getString(R.string.scatter_status_reserved);
                    string2 = string;
                    ohwxijwVar2 = ohwxijwVar;
                    z2 = false;
                    z = false;
                } else {
                    long j = aqyicqlVar.oqexvyb;
                    if (j < 0 || (j == 0 && !z7)) {
                        string = getString(R.string.scatter_status_reserved);
                    } else {
                        String strPzqxblc = com.rynx.app.ojyssqt.pzqxblc(aqyicqlVar.ojyssqt);
                        if (("pgpt".equals(strPzqxblc) || "sgpt".equals(strPzqxblc) || "gpt".equals(strPzqxblc) || "pmt".equals(strPzqxblc) || "mbr".equals(strPzqxblc) || strPzqxblc.startsWith("ebr")) && !zEquals) {
                            string3 = getString(R.string.scatter_status_layout_locked);
                        } else {
                            String strPzqxblc2 = com.rynx.app.ojyssqt.pzqxblc(aqyicqlVar.ojyssqt);
                            if ("otp".equals(strPzqxblc2) || "rpmb".equals(strPzqxblc2)) {
                                string = getString(R.string.scatter_status_irreversible_locked);
                            } else if (!this.ghkjjru.isEmpty()) {
                                string3 = this.ghkjjru;
                            } else if (!z5) {
                                try {
                                    fileVntpaom = x.pwjmwpv.vntpaom(this.wdznaie, aqyicqlVar);
                                    string3 = getString(R.string.scatter_status_waiting_da, x.zamkzqg.jybecxv(fileVntpaom.length()));
                                } catch (Throwable unused) {
                                    string3 = getString(R.string.scatter_status_missing_image, aqyicqlVar.vivhedu);
                                }
                            } else if (this.pzkwhtn.isEmpty()) {
                                String strDasxvpc4 = x.pwjmwpv.dasxvpc(aqyicqlVar.imuemzb);
                                if (!("EMMC".equals(strDasxvpc4) || "UFS".equals(strDasxvpc4)) || strDasxvpc3.isEmpty() || strDasxvpc4.equals(strDasxvpc3)) {
                                    try {
                                        fileVntpaom = x.pwjmwpv.vntpaom(this.wdznaie, aqyicqlVar);
                                        if (z7) {
                                            strDasxvpc3 = strDasxvpc3;
                                        } else {
                                            strDasxvpc3 = strDasxvpc3;
                                            try {
                                                if (fileVntpaom.length() > aqyicqlVar.oqexvyb) {
                                                    string4 = getString(R.string.scatter_status_image_too_large_scatter, x.zamkzqg.jybecxv(fileVntpaom.length()), x.zamkzqg.jybecxv(aqyicqlVar.oqexvyb));
                                                }
                                                z3 = false;
                                                z4 = false;
                                            } catch (Throwable unused2) {
                                                z3 = false;
                                            }
                                            string2 = string4;
                                            z6 = z6;
                                            ohwxijwVar2 = ohwxijwVar;
                                            z = z4;
                                            z2 = z3;
                                        }
                                        if (zEquals) {
                                            ohwxijw ohwxijwVar3 = new ohwxijw(aqyicqlVar.oqexvyb, aqyicqlVar.ojyssqt, aqyicqlVar.nmpwovh(), aqyicqlVar.nkemejx);
                                            try {
                                                ohwxijwVar = ohwxijwVar3;
                                                string4 = getString(R.string.scatter_status_firmware_upgrade_ready, x.zamkzqg.jybecxv(fileVntpaom.length()));
                                                z3 = true;
                                                z6 = true;
                                                z4 = false;
                                            } catch (Throwable unused3) {
                                                ohwxijwVar = ohwxijwVar3;
                                                z3 = true;
                                                z6 = true;
                                                z4 = false;
                                                string4 = getString(R.string.scatter_status_missing_image, aqyicqlVar.vivhedu);
                                            }
                                            string2 = string4;
                                            z6 = z6;
                                            ohwxijwVar2 = ohwxijwVar;
                                            z = z4;
                                            z2 = z3;
                                        } else {
                                            if (ohwxijwVar == null) {
                                                ohwxijw ohwxijwVar4 = new ohwxijw(aqyicqlVar.oqexvyb, aqyicqlVar.ojyssqt, aqyicqlVar.nmpwovh(), aqyicqlVar.nkemejx);
                                                try {
                                                    ohwxijwVar = ohwxijwVar4;
                                                    string4 = getString(aqyicqlVar.dytyqos ? R.string.scatter_status_ready_scatter_only : R.string.scatter_status_ready_scatter_only_no_boundary, x.zamkzqg.jybecxv(fileVntpaom.length()));
                                                    z3 = true;
                                                    z4 = true;
                                                } catch (Throwable unused4) {
                                                    ohwxijwVar = ohwxijwVar4;
                                                    z3 = true;
                                                    z4 = true;
                                                    string4 = getString(R.string.scatter_status_missing_image, aqyicqlVar.vivhedu);
                                                }
                                            } else {
                                                if (fileVntpaom.length() > ohwxijwVar.vivhedu) {
                                                    string4 = getString(R.string.scatter_status_image_too_large_live, x.zamkzqg.jybecxv(fileVntpaom.length()), x.zamkzqg.jybecxv(ohwxijwVar.vivhedu));
                                                } else {
                                                    String str3 = aqyicqlVar.nkemejx;
                                                    String str4 = ohwxijwVar.lthborb;
                                                    String strWqrnifx = x.pwjmwpv.wqrnifx(str3);
                                                    String strWqrnifx2 = x.pwjmwpv.wqrnifx(str4);
                                                    if (strWqrnifx.isEmpty() || strWqrnifx2.isEmpty() || !(strWqrnifx.equals(strWqrnifx2) || ("EMMCBOOT1BOOT2".equals(strWqrnifx) && ("EMMCBOOT1".equals(strWqrnifx2) || "EMMCBOOT2".equals(strWqrnifx2))))) {
                                                        string4 = getString(R.string.scatter_status_region_mismatch, aqyicqlVar.nkemejx, ohwxijwVar.lthborb);
                                                    } else {
                                                        String str5 = ohwxijwVar.ojyssqt;
                                                        long jLongValue = -1;
                                                        if (str5 != null) {
                                                            String strTrim = str5.trim();
                                                            if (strTrim.startsWith("0x") || strTrim.startsWith("0X")) {
                                                                strTrim = strTrim.substring(2);
                                                            }
                                                            try {
                                                                BigInteger bigInteger = new BigInteger(strTrim, 16);
                                                                if (bigInteger.signum() >= 0 && bigInteger.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
                                                                    jLongValue = bigInteger.longValue();
                                                                }
                                                            } catch (Throwable unused5) {
                                                            }
                                                        }
                                                        String str6 = aqyicqlVar.nkemejx;
                                                        String str7 = ohwxijwVar.lthborb;
                                                        String strWqrnifx3 = x.pwjmwpv.wqrnifx(str6);
                                                        String strWqrnifx4 = x.pwjmwpv.wqrnifx(str7);
                                                        boolean z8 = (strWqrnifx3.isEmpty() || strWqrnifx4.isEmpty() || !strWqrnifx3.equals(strWqrnifx4)) ? false : true;
                                                        boolean z9 = jLongValue < 0 || jLongValue != aqyicqlVar.qxvquar;
                                                        long j2 = ohwxijwVar.vivhedu;
                                                        long j3 = aqyicqlVar.oqexvyb;
                                                        boolean z10 = j2 != j3;
                                                        if (!z8 || z9 || z10) {
                                                            z4 = true;
                                                        } else {
                                                            try {
                                                                if (aqyicqlVar.dytyqos) {
                                                                    z4 = false;
                                                                } else {
                                                                    z4 = true;
                                                                }
                                                            } catch (Throwable unused6) {
                                                                z3 = true;
                                                                z4 = false;
                                                            }
                                                        }
                                                        if (!z8) {
                                                            try {
                                                                string4 = getString(R.string.scatter_status_ready_region_compatible, aqyicqlVar.nkemejx, ohwxijwVar.lthborb, x.zamkzqg.jybecxv(fileVntpaom.length()));
                                                            } catch (Throwable unused7) {
                                                                z3 = true;
                                                                string4 = getString(R.string.scatter_status_missing_image, aqyicqlVar.vivhedu);
                                                            }
                                                        } else if (z9 && z10) {
                                                            string4 = getString(R.string.scatter_status_ready_layout_mismatch, aqyicqlVar.nmpwovh(), ohwxijwVar.ojyssqt, x.zamkzqg.jybecxv(aqyicqlVar.oqexvyb), x.zamkzqg.jybecxv(ohwxijwVar.vivhedu), x.zamkzqg.jybecxv(fileVntpaom.length()));
                                                        } else if (z9) {
                                                            string4 = getString(R.string.scatter_status_ready_address_mismatch, aqyicqlVar.nmpwovh(), ohwxijwVar.ojyssqt, x.zamkzqg.jybecxv(fileVntpaom.length()));
                                                        } else if (z10) {
                                                            string4 = getString(R.string.scatter_status_ready_size_mismatch, x.zamkzqg.jybecxv(j3), x.zamkzqg.jybecxv(ohwxijwVar.vivhedu), x.zamkzqg.jybecxv(fileVntpaom.length()));
                                                        } else {
                                                            string4 = getString(aqyicqlVar.dytyqos ? R.string.scatter_status_ready : R.string.scatter_status_ready_no_boundary, x.zamkzqg.jybecxv(fileVntpaom.length()));
                                                        }
                                                        z3 = true;
                                                    }
                                                }
                                                z3 = false;
                                                z4 = false;
                                            }
                                            string2 = string4;
                                            z6 = z6;
                                            ohwxijwVar2 = ohwxijwVar;
                                            z = z4;
                                            z2 = z3;
                                        }
                                    } catch (Throwable unused8) {
                                        strDasxvpc3 = strDasxvpc3;
                                    }
                                    z4 = false;
                                    string4 = getString(R.string.scatter_status_missing_image, aqyicqlVar.vivhedu);
                                    string2 = string4;
                                    z6 = z6;
                                    ohwxijwVar2 = ohwxijwVar;
                                    z = z4;
                                    z2 = z3;
                                } else {
                                    string2 = getString(R.string.scatter_status_entry_storage_mismatch, aqyicqlVar.imuemzb, this.wdznaie.qxvquar);
                                    strDasxvpc3 = strDasxvpc3;
                                    ohwxijwVar2 = ohwxijwVar;
                                    z2 = false;
                                    z = false;
                                }
                            } else {
                                string3 = this.pzkwhtn;
                            }
                        }
                        strDasxvpc3 = strDasxvpc3;
                        string2 = string3;
                        ohwxijwVar2 = ohwxijwVar;
                        z2 = false;
                        z = false;
                    }
                    string2 = string;
                    ohwxijwVar2 = ohwxijwVar;
                    z2 = false;
                    z = false;
                }
                this.pwnmyid.add(new znfyiic(i, aqyicqlVar, ohwxijwVar2, fileVntpaom, z2, z, z6, string2));
            }
            i++;
            strDasxvpc3 = strDasxvpc3;
        }
        String strXqbcyis = xqbcyis();
        if (!this.mwocrhx.isEmpty() && !this.mslkofp.isEmpty() && !this.mslkofp.equals(strXqbcyis)) {
            this.mwocrhx.clear();
        }
        HashSet hashSet = new HashSet();
        for (znfyiic znfyiicVar : (java.util.ArrayList<znfyiic>) this.pwnmyid) {
            if (znfyiicVar.qxvquar) {
                hashSet.add(com.rynx.app.ojyssqt.pzqxblc(znfyiicVar.ojyssqt.ojyssqt));
            }
        }
        this.mwocrhx.retainAll(hashSet);
    }

    @Override // com.rynx.app.ojyssqt
    public final LinearLayout lthborb() {
        final mcdstyz mcdstyzVar = new mcdstyz(this);
        LinearLayout linearLayoutXbdyiew = x.zamkzqg.xbdyiew(this, 12);
        linearLayoutXbdyiew.setPadding(x.zamkzqg.qunltjs(this, 12), x.zamkzqg.qunltjs(this, 10), x.zamkzqg.qunltjs(this, 12), x.zamkzqg.qunltjs(this, 8));
        linearLayoutXbdyiew.addView(x.zamkzqg.ywhgqsi(this, getString(R.string.terminal_title)));
        TextView textViewOxoagud = x.zamkzqg.oxoagud(this, getString(R.string.terminal_subtitle), 11, x.zamkzqg.jbmzxye(this), false);
        textViewOxoagud.setPadding(0, 0, 0, x.zamkzqg.qunltjs(this, 8));
        linearLayoutXbdyiew.addView(textViewOxoagud);
        LinearLayout linearLayoutLvtqoqa = x.zamkzqg.lvtqoqa(this);
        int iNmpwovh = x.zamkzqg.nmpwovh(this);
        final int i = 0;
        TextView textViewLclupha = x.zamkzqg.lclupha(this, getString(R.string.logs_copy), new View.OnClickListener() { // from class: x.neppdxk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        MainActivity mainActivity = (MainActivity) mcdstyzVar.nmpwovh;
                        TextView textView = mainActivity.cgcdpmq;
                        CharSequence text = textView == null ? "" : textView.getText();
                        ClipboardManager clipboardManager = (ClipboardManager) mainActivity.getSystemService("clipboard");
                        if (clipboardManager != null) {
                            clipboardManager.setPrimaryClip(ClipData.newPlainText(mainActivity.getString(R.string.logs_clip_label), text));
                        }
                        Toast.makeText(mainActivity, R.string.logs_copied, 0).show();
                        return;
                    default:
                        MainActivity mainActivity2 = (MainActivity) mcdstyzVar.nmpwovh;
                        mainActivity2.getClass();
                        try {
                            File externalFilesDir = mainActivity2.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
                            if (externalFilesDir == null) {
                                externalFilesDir = mainActivity2.getFilesDir();
                            }
                            File file = new File(externalFilesDir, "rynx");
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            File file2 = new File(file, "rynx-log.txt");
                            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
                            try {
                                TextView textView2 = mainActivity2.cgcdpmq;
                                fileOutputStream.write((textView2 == null ? "" : textView2.getText().toString()).getBytes("UTF-8"));
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                Toast.makeText(mainActivity2, mainActivity2.getString(R.string.logs_saved, file2.getAbsolutePath()), 1).show();
                                return;
                            } catch (Throwable th) {
                                try {
                                    fileOutputStream.close();
                                    break;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            Toast.makeText(mainActivity2, mainActivity2.getString(R.string.logs_save_failed, th3.getMessage()), 1).show();
                            return;
                        }
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha, R.drawable.ic_copy, iNmpwovh);
        int iNmpwovh2 = x.zamkzqg.nmpwovh(this);
        final int i2 = 1;
        TextView textViewLclupha2 = x.zamkzqg.lclupha(this, getString(R.string.logs_save), new View.OnClickListener() { // from class: x.neppdxk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        MainActivity mainActivity = (MainActivity) mcdstyzVar.nmpwovh;
                        TextView textView = mainActivity.cgcdpmq;
                        CharSequence text = textView == null ? "" : textView.getText();
                        ClipboardManager clipboardManager = (ClipboardManager) mainActivity.getSystemService("clipboard");
                        if (clipboardManager != null) {
                            clipboardManager.setPrimaryClip(ClipData.newPlainText(mainActivity.getString(R.string.logs_clip_label), text));
                        }
                        Toast.makeText(mainActivity, R.string.logs_copied, 0).show();
                        return;
                    default:
                        MainActivity mainActivity2 = (MainActivity) mcdstyzVar.nmpwovh;
                        mainActivity2.getClass();
                        try {
                            File externalFilesDir = mainActivity2.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
                            if (externalFilesDir == null) {
                                externalFilesDir = mainActivity2.getFilesDir();
                            }
                            File file = new File(externalFilesDir, "rynx");
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            File file2 = new File(file, "rynx-log.txt");
                            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
                            try {
                                TextView textView2 = mainActivity2.cgcdpmq;
                                fileOutputStream.write((textView2 == null ? "" : textView2.getText().toString()).getBytes("UTF-8"));
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                Toast.makeText(mainActivity2, mainActivity2.getString(R.string.logs_saved, file2.getAbsolutePath()), 1).show();
                                return;
                            } catch (Throwable th) {
                                try {
                                    fileOutputStream.close();
                                    break;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            Toast.makeText(mainActivity2, mainActivity2.getString(R.string.logs_save_failed, th3.getMessage()), 1).show();
                            return;
                        }
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha2, R.drawable.ic_save, iNmpwovh2);
        linearLayoutLvtqoqa.addView(textViewLclupha, x.zamkzqg.qxvquar(this));
        linearLayoutLvtqoqa.addView(textViewLclupha2, x.zamkzqg.qxvquar(this));
        linearLayoutXbdyiew.addView(linearLayoutLvtqoqa);
        TextView textView = new TextView(this);
        Typeface typeface = Typeface.MONOSPACE;
        textView.setTypeface(typeface, 1);
        textView.setTextColor(x.zamkzqg.pzkwhtn(this));
        textView.setTextSize(12.0f);
        textView.setPadding(x.zamkzqg.qunltjs(this, 10), x.zamkzqg.qunltjs(this, 8), x.zamkzqg.qunltjs(this, 10), x.zamkzqg.qunltjs(this, 8));
        textView.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.czidoiw(this), x.zamkzqg.qyeibyo(this), x.zamkzqg.qunltjs(this, 9)));
        linearLayoutXbdyiew.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setTypeface(typeface);
        textView2.setTextColor(x.zamkzqg.thbdbid(this, "system_neutral1_900", "system_neutral1_100", R.color.rynx_light_terminal_text, R.color.rynx_dark_terminal_text));
        textView2.setTextSize(12.0f);
        textView2.setTextIsSelectable(true);
        textView2.setLongClickable(true);
        textView2.setFocusableInTouchMode(true);
        textView2.setHorizontallyScrolling(false);
        textView2.setPadding(x.zamkzqg.qunltjs(this, 4), x.zamkzqg.qunltjs(this, 8), x.zamkzqg.qunltjs(this, 4), x.zamkzqg.qunltjs(this, 8));
        final ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setVerticalScrollBarEnabled(true);
        scrollView.setScrollbarFadingEnabled(false);
        scrollView.setSmoothScrollingEnabled(true);
        scrollView.setOverScrollMode(0);
        scrollView.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.thbdbid(this, "system_neutral1_10", "system_neutral1_900", R.color.rynx_light_terminal_bg, R.color.rynx_dark_terminal_bg), x.zamkzqg.qyeibyo(this), x.zamkzqg.qunltjs(this, 10)));
        scrollView.addView(textView2, new FrameLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        layoutParams.setMargins(0, x.zamkzqg.qunltjs(this, 10), 0, x.zamkzqg.qunltjs(this, 8));
        linearLayoutXbdyiew.addView(scrollView, layoutParams);
        LinearLayout linearLayoutLvtqoqa2 = x.zamkzqg.lvtqoqa(this);
        linearLayoutLvtqoqa2.setPadding(x.zamkzqg.qunltjs(this, 10), x.zamkzqg.qunltjs(this, 2), x.zamkzqg.qunltjs(this, 4), x.zamkzqg.qunltjs(this, 2));
        linearLayoutLvtqoqa2.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.czidoiw(this), x.zamkzqg.qyeibyo(this), x.zamkzqg.qunltjs(this, 10)));
        TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, "$ ", 15, x.zamkzqg.pzkwhtn(this), true);
        textViewOxoagud2.setTypeface(typeface, 1);
        linearLayoutLvtqoqa2.addView(textViewOxoagud2);
        EditText editText = new EditText(this);
        editText.setSingleLine(true);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.setCursorVisible(true);
        editText.setShowSoftInputOnFocus(true);
        editText.setInputType(524289);
        editText.setTextColor(x.zamkzqg.thbdbid(this, "system_neutral1_900", "system_neutral1_100", R.color.rynx_light_terminal_text, R.color.rynx_dark_terminal_text));
        editText.setHintTextColor(x.zamkzqg.jbmzxye(this));
        editText.setTypeface(typeface);
        editText.setTextSize(13.0f);
        editText.setHint(R.string.terminal_command_hint);
        editText.setImeOptions(4);
        editText.setBackgroundColor(getColor(R.color.rynx_transparent));
        editText.setPadding(x.zamkzqg.qunltjs(this, 4), x.zamkzqg.qunltjs(this, 7), x.zamkzqg.qunltjs(this, 4), x.zamkzqg.qunltjs(this, 7));
        linearLayoutLvtqoqa2.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayoutXbdyiew.addView(linearLayoutLvtqoqa2);
        linearLayoutXbdyiew.addView(new View(this), new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
        this.qunltjs = textView;
        this.cgcdpmq = textView2;
        this.pzqxblc = scrollView;
        this.eigllth = editText;
        final int iDasxvpc = dasxvpc(24);
        final ysaclsr ysaclsrVar = this.snilumr;
        ysaclsrVar.nmpwovh = textView2;
        ysaclsrVar.ojyssqt = scrollView;
        ysaclsrVar.vivhedu = editText;
        ysaclsrVar.qxvquar = false;
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: x.ydsyayx
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i3, int i4, int i5, int i6) {
                ysaclsr ysaclsrVar2 = ysaclsrVar;
                ysaclsrVar2.getClass();
                ScrollView scrollView2 = scrollView;
                View childAt = scrollView2.getChildAt(0);
                if (childAt == null) {
                    return;
                }
                ysaclsrVar2.lthborb = i4 >= Math.max(0, Math.max(0, childAt.getHeight() - scrollView2.getHeight()) - iDasxvpc);
            }
        });
        EditText editText2 = this.eigllth;
        if (editText2 != null) {
            editText2.setOnTouchListener(new View.OnTouchListener() { // from class: x.jbmzxye
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    kggugdp kggugdpVar = kggugdp.this;
                    kggugdpVar.getClass();
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    kggugdpVar.eigllth.setFocusableInTouchMode(true);
                    kggugdpVar.eigllth.requestFocus();
                    InputMethodManager inputMethodManager = (InputMethodManager) kggugdpVar.getSystemService("input_method");
                    if (inputMethodManager == null) {
                        return false;
                    }
                    kggugdpVar.eigllth.postDelayed(new atntgcp(kggugdpVar, inputMethodManager, 3), 50L);
                    return false;
                }
            });
            this.eigllth.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: x.sdchfks
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    kggugdp kggugdpVar = kggugdp.this;
                    if (!z) {
                        kggugdpVar.getClass();
                        return;
                    }
                    kggugdpVar.snilumr.lthborb = true;
                    view.postDelayed(new zngzleo(kggugdpVar, 1), 80L);
                    view.postDelayed(new zngzleo(kggugdpVar, 2), 180L);
                }
            });
            this.eigllth.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: x.ywhgqsi
                /* JADX WARN: Code duplicated, block: B:222:0x05d0  */
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView3, int i3, KeyEvent keyEvent) {
                    String string;
                    kggugdp kggugdpVar = kggugdp.this;
                    kggugdpVar.getClass();
                    if (i3 != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0)) {
                        return false;
                    }
                    MainActivity mainActivity = (MainActivity) kggugdpVar;
                    String strTrim = mainActivity.eigllth.getText().toString().trim();
                    if (!strTrim.isEmpty()) {
                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_prompt_echo, strTrim));
                        mainActivity.eigllth.setText("");
                        mainActivity.ekyqleu();
                        try {
                            ArrayList arrayListIqvvlnh = mainActivity.iqvvlnh(strTrim);
                            boolean z = !arrayListIqvvlnh.isEmpty() && ((String) arrayListIqvvlnh.get(0)).equalsIgnoreCase("rynx");
                            if (z && arrayListIqvvlnh.size() >= 2 && (((String) arrayListIqvvlnh.get(1)).equalsIgnoreCase("--help") || ((String) arrayListIqvvlnh.get(1)).equalsIgnoreCase("-h"))) {
                                mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_help));
                            } else {
                                if (z) {
                                    arrayListIqvvlnh.remove(0);
                                }
                                if (arrayListIqvvlnh.isEmpty()) {
                                    mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_help));
                                } else {
                                    String str = (String) arrayListIqvvlnh.get(0);
                                    Locale locale = Locale.ROOT;
                                    String lowerCase = str.toLowerCase(locale);
                                    if (lowerCase.equals("help") || lowerCase.equals("--help") || lowerCase.equals("-h")) {
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_help));
                                    } else if (lowerCase.equals("scan")) {
                                        mainActivity.cgcdpmq();
                                    } else if (lowerCase.equals("su") || lowerCase.equals("mode")) {
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_root_removed));
                                    } else if (lowerCase.equals("clear")) {
                                        ysaclsr ysaclsrVar2 = mainActivity.snilumr;
                                        TextView textView4 = ysaclsrVar2.nmpwovh;
                                        if (textView4 != null) {
                                            textView4.setText("");
                                        }
                                        ysaclsrVar2.lthborb = true;
                                        ysaclsrVar2.qxvquar = false;
                                    } else if (lowerCase.equals("status")) {
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_status_mode_nonroot));
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_status_usb, mainActivity.ulafhci == null ? mainActivity.getString(R.string.terminal_status_none) : String.format(Locale.US, "%04X:%04X", Integer.valueOf(mainActivity.ulafhci.getVendorId()), Integer.valueOf(mainActivity.ulafhci.getProductId()))));
                                        if (mainActivity.nsyqsfj) {
                                            string = mainActivity.getString(R.string.session_da_ready_upper);
                                        } else if (mainActivity.gzokllk) {
                                            string = mainActivity.qwgjehf ? mainActivity.getString(R.string.session_connecting_upper) : mainActivity.getString(R.string.session_stopping_upper);
                                        } else {
                                            string = mainActivity.qwgjehf ? mainActivity.getString(R.string.session_started_waiting) : mainActivity.getString(R.string.session_stopped_upper);
                                        }
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_status_gui_session, string));
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_status_terminal_flow, mainActivity.getString(mainActivity.lataqgm ? R.string.terminal_flow_expert : R.string.terminal_flow_inactive)));
                                        String strYjbrzgu = mainActivity.yjbrzgu("da_path");
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_status_gui_da, strYjbrzgu.isEmpty() ? mainActivity.getString(R.string.terminal_not_configured) : mainActivity.ezuzoct(strYjbrzgu)));
                                        String string2 = mainActivity.czqxnxv;
                                        if (string2 == null) {
                                            string2 = mainActivity.getString(R.string.terminal_none);
                                        }
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_status_armed, string2));
                                    } else if (lowerCase.equals("storage")) {
                                        if (arrayListIqvvlnh.size() == 1 || ((String) arrayListIqvvlnh.get(1)).equalsIgnoreCase("status")) {
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.storage_access_state, mainActivity.getString(mainActivity.pvbzgon() ? R.string.storage_granted_upper : R.string.storage_not_granted_upper)));
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_cwd, mainActivity.sfildfy.getAbsolutePath()));
                                            if (!mainActivity.pvbzgon()) {
                                                mainActivity.nmpwovh(mainActivity.getString(R.string.storage_grant_hint));
                                            }
                                        } else if (((String) arrayListIqvvlnh.get(1)).toLowerCase(locale).equals("grant")) {
                                            mainActivity.sthdtww();
                                        } else {
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.storage_usage));
                                        }
                                    } else if (lowerCase.equals("ls")) {
                                        File fileZhpnlmy = arrayListIqvvlnh.size() >= 2 ? mainActivity.zhpnlmy((String) arrayListIqvvlnh.get(1)) : mainActivity.sfildfy;
                                        if (!fileZhpnlmy.exists()) {
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_ls_not_found, fileZhpnlmy.getAbsolutePath()));
                                        } else if (fileZhpnlmy.isFile()) {
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_dir_bytes, fileZhpnlmy.getName(), Long.valueOf(fileZhpnlmy.length())));
                                        } else {
                                            File[] fileArrListFiles = fileZhpnlmy.listFiles();
                                            if (fileArrListFiles == null) {
                                                mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_ls_permission, fileZhpnlmy.getAbsolutePath()));
                                                if (!mainActivity.pvbzgon()) {
                                                    mainActivity.nmpwovh(mainActivity.getString(R.string.storage_grant_hint));
                                                }
                                            } else {
                                                Arrays.sort(fileArrListFiles, new buswjhz(1));
                                                mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_directory, fileZhpnlmy.getAbsolutePath()));
                                                for (File file : fileArrListFiles) {
                                                    mainActivity.nmpwovh(file.isDirectory() ? mainActivity.getString(R.string.terminal_list_directory, file.getName()) : mainActivity.getString(R.string.terminal_list_file, file.getName(), file.isFile() ? mainActivity.getString(R.string.terminal_list_file_size, Long.valueOf(file.length())) : ""));
                                                }
                                            }
                                        }
                                    } else if (lowerCase.equals("cd")) {
                                        File fileZhpnlmy2 = arrayListIqvvlnh.size() >= 2 ? mainActivity.zhpnlmy((String) arrayListIqvvlnh.get(1)) : new File("/storage/emulated/0");
                                        if (!fileZhpnlmy2.exists()) {
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_cd_not_found, fileZhpnlmy2.getAbsolutePath()));
                                        } else if (!fileZhpnlmy2.isDirectory()) {
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_cd_not_dir, fileZhpnlmy2.getAbsolutePath()));
                                        } else if (fileZhpnlmy2.listFiles() != null || fileZhpnlmy2.canRead()) {
                                            try {
                                                mainActivity.sfildfy = fileZhpnlmy2.getCanonicalFile();
                                            } catch (Exception unused) {
                                                mainActivity.sfildfy = fileZhpnlmy2.getAbsoluteFile();
                                            }
                                            mainActivity.nmpwovh(mainActivity.sfildfy.getAbsolutePath());
                                        } else {
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_cd_permission, fileZhpnlmy2.getAbsolutePath()));
                                            if (!mainActivity.pvbzgon()) {
                                                mainActivity.nmpwovh(mainActivity.getString(R.string.storage_grant_hint));
                                            }
                                        }
                                    } else if (lowerCase.equals("pwd")) {
                                        mainActivity.nmpwovh(mainActivity.sfildfy.getAbsolutePath());
                                    } else if (arrayListIqvvlnh.size() == 1 && (((String) arrayListIqvvlnh.get(0)).equals("--da") || ((String) arrayListIqvvlnh.get(0)).equals("-d"))) {
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_da_path_example));
                                    } else if (arrayListIqvvlnh.size() == 1 && (((String) arrayListIqvvlnh.get(0)).equals("--auth") || ((String) arrayListIqvvlnh.get(0)).equals("-a"))) {
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_auth_path_required));
                                    } else if (arrayListIqvvlnh.size() == 1 && (((String) arrayListIqvvlnh.get(0)).equals("--pl") || ((String) arrayListIqvvlnh.get(0)).equals("-p"))) {
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_preloader_path_required));
                                    } else if ((mainActivity.lpkdqgx || mainActivity.gzokllk) && x.cugubfc.vivhedu(arrayListIqvvlnh) >= 0) {
                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_busy_session));
                                    } else {
                                        tmdubwv tmdubwvVar = new tmdubwv(arrayListIqvvlnh);
                                        mainActivity.wdvdxhb = tmdubwvVar;
                                        ArrayList arrayList = (ArrayList) tmdubwvVar.nmpwovh;
                                        if (x.cugubfc.vivhedu(arrayList) < 0) {
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_unsupported_console));
                                            mainActivity.wdvdxhb = null;
                                        } else if (x.cugubfc.nkemejx("--da", "-d", arrayList) >= 0) {
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_da_direct_path));
                                            mainActivity.wdvdxhb = null;
                                        } else if (x.cugubfc.nkemejx("--auth", "-a", arrayList) >= 0) {
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_auth_direct_path));
                                            mainActivity.wdvdxhb = null;
                                        } else if (x.cugubfc.nkemejx("--pl", "-p", arrayList) >= 0) {
                                            mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_pl_direct_path));
                                            mainActivity.wdvdxhb = null;
                                        } else {
                                            int iVivhedu = x.cugubfc.vivhedu(arrayList);
                                            String strNmpwovh = x.cugubfc.nmpwovh((String) arrayList.get(iVivhedu));
                                            if (!x.cugubfc.ojyssqt.contains(strNmpwovh)) {
                                                mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_backend_unimplemented, strNmpwovh));
                                                mainActivity.wdvdxhb = null;
                                            } else if (strNmpwovh.equals("probe")) {
                                                mainActivity.snbdnwo(iVivhedu, strNmpwovh);
                                            } else if (x.cugubfc.vivhedu.contains(((String) arrayList.get(iVivhedu)).toLowerCase(locale))) {
                                                int iOjyssqt = x.cugubfc.ojyssqt(arrayList, iVivhedu);
                                                if (iOjyssqt < 1) {
                                                    mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_partition_required, arrayList.get(iVivhedu)));
                                                    mainActivity.wdvdxhb = null;
                                                } else {
                                                    x.cugubfc.dytyqos(arrayList, iVivhedu, 1);
                                                    if (iOjyssqt < 2) {
                                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_output_required, arrayList.get(iVivhedu), x.cugubfc.dytyqos(arrayList, iVivhedu, 0)));
                                                        mainActivity.wdvdxhb = null;
                                                    } else {
                                                        mainActivity.snbdnwo(iVivhedu, strNmpwovh);
                                                    }
                                                }
                                            } else if (x.cugubfc.lthborb.contains(((String) arrayList.get(iVivhedu)).toLowerCase(locale))) {
                                                int iOjyssqt2 = x.cugubfc.ojyssqt(arrayList, iVivhedu);
                                                if (iOjyssqt2 < 1) {
                                                    mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_partition_required, arrayList.get(iVivhedu)));
                                                    mainActivity.wdvdxhb = null;
                                                } else {
                                                    x.cugubfc.dytyqos(arrayList, iVivhedu, 1);
                                                    if (iOjyssqt2 < 2) {
                                                        mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_input_required, arrayList.get(iVivhedu), x.cugubfc.dytyqos(arrayList, iVivhedu, 0)));
                                                        mainActivity.wdvdxhb = null;
                                                    } else {
                                                        mainActivity.snbdnwo(iVivhedu, strNmpwovh);
                                                    }
                                                }
                                            } else {
                                                mainActivity.snbdnwo(iVivhedu, strNmpwovh);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (IllegalArgumentException e) {
                            mainActivity.nmpwovh(mainActivity.getString(R.string.terminal_parse_error, e.getMessage()));
                        }
                    }
                    return true;
                }
            });
        }
        linearLayoutXbdyiew.postDelayed(new zngzleo(this, 0), 100L);
        return linearLayoutXbdyiew;
    }

    public final File mdepcqh(ArrayList arrayList) throws Throwable {
        String str;
        aqyicql aqyicqlVar;
        if (this.wdznaie == null) {
            throw new IOException(getString(R.string.scatter_no_file));
        }
        if (arrayList.isEmpty()) {
            throw new IOException("No V6 Download Only payloads are selected");
        }
        File fileCreateTempFile = File.createTempFile("rynx-dlv6-", ".plan", getCacheDir());
        boolean z = false;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile, false);
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                try {
                    dataOutputStream.write("RYNXDLV61".getBytes(StandardCharsets.US_ASCII));
                    dataOutputStream.writeInt(1);
                    com.rynx.app.ojyssqt.btazysh(dataOutputStream, this.wdznaie.nmpwovh.getCanonicalPath(), 4096, "scatter path");
                    com.rynx.app.ojyssqt.btazysh(dataOutputStream, this.wdznaie.vivhedu, 256, "platform");
                    com.rynx.app.ojyssqt.btazysh(dataOutputStream, this.wdznaie.qxvquar, 64, "storage");
                    dataOutputStream.writeInt(arrayList.size());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        araemok araemokVar = (araemok) it.next();
                        if (araemokVar != null) {
                            File file = araemokVar.ojyssqt;
                            ohwxijw ohwxijwVar = araemokVar.nmpwovh;
                            if (ohwxijwVar != null && file != null) {
                                Iterator it2 = this.wdznaie.nkemejx.iterator();
                                while (true) {
                                    boolean zHasNext = it2.hasNext();
                                    str = ohwxijwVar.nmpwovh;
                                    if (!zHasNext) {
                                        aqyicqlVar = null;
                                        break;
                                    }
                                    aqyicqlVar = (aqyicql) it2.next();
                                    if (aqyicqlVar != null && aqyicqlVar.ojyssqt.equalsIgnoreCase(str)) {
                                        break;
                                    }
                                }
                                if (aqyicqlVar == null || !aqyicqlVar.lthborb || !aqyicqlVar.vivhedu()) {
                                    throw new IOException("Invalid V6 Download Only scatter entry: " + str);
                                }
                                if (!x.pwjmwpv.vntpaom(this.wdznaie, aqyicqlVar).getCanonicalFile().equals(file.getCanonicalFile())) {
                                    throw new IOException("V6 Download Only image no longer matches scatter: " + str);
                                }
                                com.rynx.app.ojyssqt.btazysh(dataOutputStream, aqyicqlVar.ojyssqt, 128, "partition name");
                                com.rynx.app.ojyssqt.btazysh(dataOutputStream, file.getCanonicalPath(), 4096, "image path");
                                dataOutputStream.writeLong(aqyicqlVar.oqexvyb);
                            }
                        }
                        throw new IOException("Invalid V6 Download Only selection");
                    }
                    dataOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    try {
                        dataOutputStream.close();
                        try {
                            fileOutputStream.close();
                            return fileCreateTempFile;
                        } catch (Throwable th) {
                            z = true;
                            if (!z) {
                                fileCreateTempFile.delete();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        z = true;
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    try {
                        dataOutputStream.close();
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                    throw th4;
                }
            } catch (Throwable th6) {
                fileOutputStream.close();
                throw th6;
            }
        } catch (Throwable th7) {
            // smali catchall_6: a failure before the streams closed cleanly deletes the plan file.
            if (!z) {
                fileCreateTempFile.delete();
            }
            throw th7;
        }
    }

    public final void nauykcf(int i, int i2, String str) {
        TextView textView = this.axbavsj;
        if (textView != null) {
            textView.setText(getString(R.string.batch_overall_running, Integer.valueOf(i + 1), Integer.valueOf(i2)));
        }
        TextView textView2 = this.zngzleo;
        if (textView2 != null) {
            textView2.setText(str);
        }
        ProgressBar progressBar = this.vhimehb;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        TextView textView3 = this.naaizwn;
        if (textView3 != null) {
            textView3.setText("0%");
        }
        TextView textView4 = this.hjlrtqw;
        if (textView4 != null) {
            textView4.setText(R.string.batch_running);
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void nhhacgu(String str) {
        View view;
        if (this.exhiehf == null) {
            return;
        }
        if (!this.kxotgjb || "setup".equals(str)) {
            if ("flash".equals(str) && !this.nsyqsfj) {
                Toast.makeText(this, R.string.terminal_wait_da, 0).show();
                return;
            }
            nsyqsfj(str);
            int iIilntfn = iilntfn(this.zhpnlmy);
            boolean z = this.lataqgm;
            this.lataqgm = "terminal".equals(str);
            jtfjrri(true);
            if (this.lataqgm && !z && this.nsyqsfj) {
                nmpwovh(getString(R.string.terminal_gui_session_active));
            }
            this.zhpnlmy = str;
            switch (str) {
                case "terminal":
                    view = this.ioxmphz;
                    this.zhpnlmy = "terminal";
                    break;
                case "xiaomi_authorize":
                    view = this.zamkzqg;
                    this.zhpnlmy = "menu";
                    break;
                case "menu":
                    view = this.btazysh;
                    this.zhpnlmy = "menu";
                    break;
                case "flash":
                    view = this.jbyhfxz;
                    this.zhpnlmy = "menu";
                    break;
                case "parts":
                    view = this.cszfvxh;
                    this.zhpnlmy = "menu";
                    break;
                case "setup":
                    view = this.yonoayx;
                    this.zhpnlmy = "setup";
                    break;
                case "settings":
                    View view2 = this.jlgwuft;
                    this.zhpnlmy = "settings";
                    view = view2;
                    break;
                default:
                    view = this.lvtqoqa;
                    this.zhpnlmy = "home";
                    break;
            }
            if (view == null) {
                return;
            }
            eigllth(str);
            int iIilntfn2 = iilntfn(this.zhpnlmy);
            int iCompare = Integer.compare(iIilntfn2, iIilntfn);
            if (iIilntfn < 0 || iIilntfn2 < 0) {
                iCompare = 0;
            }
            kxotgjb(view, iCompare);
            if (this.lataqgm && this.civyupy) {
                ltnesel();
            }
            rvrflql rvrflqlVar = this.jybecxv;
            if (rvrflqlVar != null) {
                rvrflqlVar.vivhedu(this.zhpnlmy);
            }
            if ("parts".equals(str) && this.nsyqsfj && !this.ywhgqsi && !this.lpkdqgx) {
                saksmfq();
            }
            if (!"terminal".equals(str) && this.eigllth != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.eigllth.getWindowToken(), 0);
                }
                this.eigllth.clearFocus();
            }
            if (!z || this.lataqgm) {
                gefzxcg();
            } else {
                bgmsltp();
            }
        }
    }

    @Override // com.rynx.app.ojyssqt
    public final void nsyqsfj(String str) {
        View childAt;
        if (this.kxotgjb) {
            return;
        }
        FrameLayout frameLayout = this.exhiehf;
        if (frameLayout == null || frameLayout.getChildCount() == 0) {
            childAt = null;
        } else {
            FrameLayout frameLayout2 = this.exhiehf;
            childAt = frameLayout2.getChildAt(frameLayout2.getChildCount() - 1);
        }
        if (childAt == null || str.equals(this.ayzlrnr)) {
            return;
        }
        if (this.tqcgjht.size() >= 32) {
            this.tqcgjht.removeFirst();
        }
        this.tqcgjht.addLast(new vhimehb(childAt, this.zhpnlmy, this.ayzlrnr, this.lataqgm));
    }

    public final void nuoqzvr(File file) {
        LinkedHashMap linkedHashMap;
        String str;
        File[] fileArr;
        Iterator it;
        String strSubstring;
        File[] fileArrListFiles = x.zamkzqg.gisppfs(file).listFiles();
        if (fileArrListFiles == null) {
            Toast.makeText(this, R.string.batch_flash_folder_not_real, 1).show();
            hknanqb();
            return;
        }
        ArrayList<bpqosqe> arrayList = this.pcbbvuj;
        Iterator it2 = arrayList.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean zHasNext = it2.hasNext();
            linkedHashMap = this.fprgbbe;
            if (!zHasNext) {
                break;
            }
            bpqosqe bpqosqeVar = (bpqosqe) it2.next();
            if (!linkedHashMap.containsKey(bpqosqeVar.nmpwovh)) {
                ArrayList arrayList2 = new ArrayList();
                int length = fileArrListFiles.length;
                int i3 = 0;
                while (true) {
                    str = bpqosqeVar.nmpwovh;
                    if (i3 >= length) {
                        break;
                    }
                    File file2 = fileArrListFiles[i3];
                    if (file2 != null && file2.isFile() && file2.canRead()) {
                        String lowerCase = file2.getName().toLowerCase(Locale.ROOT);
                        fileArr = fileArrListFiles;
                        it = it2;
                        String[] strArr = {".img", ".bin", ".raw", ".mbn"};
                        int i4 = 0;
                        while (true) {
                            if (i4 >= 4) {
                                int iLastIndexOf = lowerCase.lastIndexOf(46);
                                if (iLastIndexOf > 0) {
                                    lowerCase = lowerCase.substring(0, iLastIndexOf);
                                }
                                strSubstring = lowerCase;
                                break;
                            }
                            String str2 = strArr[i4];
                            if (lowerCase.endsWith(str2) && lowerCase.length() > str2.length()) {
                                strSubstring = lowerCase.substring(0, lowerCase.length() - str2.length());
                                break;
                            }
                            i4++;
                            strArr = strArr;
                        }
                        if (str.equals(strSubstring)) {
                            arrayList2.add(file2);
                        }
                    } else {
                        fileArr = fileArrListFiles;
                        it = it2;
                    }
                    i3++;
                    fileArrListFiles = fileArr;
                    it2 = it;
                }
                File[] fileArr2 = fileArrListFiles;
                Iterator it3 = it2;
                if (arrayList2.size() == 1) {
                    linkedHashMap.put(str, (File) arrayList2.get(0));
                    i++;
                } else if (arrayList2.size() > 1) {
                    i2++;
                }
                fileArrListFiles = fileArr2;
                it2 = it3;
            }
        }
        int i5 = 0;
        for (bpqosqe bpqosqeVar2 : arrayList) {
            if (!bpqosqe(bpqosqeVar2, (File) linkedHashMap.get(bpqosqeVar2.nmpwovh), this.ecffprn)) {
                i5++;
            }
        }
        String string = getString(R.string.batch_flash_folder_result, Integer.valueOf(i), Integer.valueOf(i5));
        if (i2 > 0) {
            string = string + "\n" + getString(R.string.batch_flash_folder_ambiguous, Integer.valueOf(i2));
        }
        Toast.makeText(this, string, 1).show();
        hknanqb();
    }

    @Override // com.rynx.app.ojyssqt
    public final ScrollView ojyssqt() {
        final xbdyiew xbdyiewVar = new xbdyiew(this);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        LinearLayout linearLayoutXbdyiew = x.zamkzqg.xbdyiew(this, 16);
        scrollView.addView(linearLayoutXbdyiew);
        linearLayoutXbdyiew.addView(x.zamkzqg.ywhgqsi(this, getString(R.string.flash_title)));
        LinearLayout linearLayoutZwaqeaz = x.zamkzqg.zwaqeaz(this);
        linearLayoutZwaqeaz.addView(x.zamkzqg.ysaclsr(this, R.string.flash_partition));
        final int i = 0;
        TextView textViewBwvplah = x.zamkzqg.bwvplah(this, R.string.flash_select_partition, R.drawable.ic_partition, new View.OnClickListener() { // from class: x.kffvigz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        MainActivity mainActivity = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity.wjugzfh()) {
                            if (mainActivity.jbmzxye.isEmpty()) {
                                Toast.makeText(mainActivity, mainActivity.ywhgqsi ? R.string.error_partition_loading : R.string.error_reading_partition_first, 0).show();
                                if (!mainActivity.ywhgqsi) {
                                    mainActivity.saksmfq();
                                }
                            } else {
                                String[] strArr = new String[mainActivity.jbmzxye.size()];
                                for (int i2 = 0; i2 < mainActivity.jbmzxye.size(); i2++) {
                                    strArr[i2] = ((ohwxijw) mainActivity.jbmzxye.get(i2)).nmpwovh;
                                }
                                new AlertDialog.Builder(mainActivity).setTitle(R.string.error_select_partition).setItems(strArr, new hknanqb(mainActivity, 1)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
                            }
                            break;
                        }
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            x.ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.flash_choose_image), mainActivity2.lclupha(), null, new kpmmknm(mainActivity2));
                            break;
                        }
                        break;
                    case 2:
                        xbdyiewVar.nmpwovh.bwvplah(false);
                        break;
                    case 3:
                        xbdyiewVar.nmpwovh.bwvplah(true);
                        break;
                    default:
                        MainActivity mainActivity3 = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity3.wjugzfh()) {
                            if (mainActivity3.lpkdqgx || mainActivity3.gzokllk) {
                                Toast.makeText(mainActivity3, R.string.error_busy, 0).show();
                            } else if (mainActivity3.ezuzoct == null) {
                                Toast.makeText(mainActivity3, R.string.flash_select_partition_first, 0).show();
                            } else {
                                File file = mainActivity3.pwjmwpv;
                                if (file != null && file.isFile() && mainActivity3.pwjmwpv.canRead()) {
                                    long length = mainActivity3.pwjmwpv.length();
                                    ohwxijw ohwxijwVar = mainActivity3.ezuzoct;
                                    long j = ohwxijwVar.vivhedu;
                                    if (length <= 0 || length > j) {
                                        mainActivity3.lvtqoqa();
                                        Toast.makeText(mainActivity3, R.string.flash_invalid_size, 1).show();
                                    } else {
                                        StringBuilder sb = new StringBuilder(mainActivity3.getString(R.string.flash_confirm_message, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(j), mainActivity3.pwjmwpv.getName(), x.zamkzqg.jybecxv(length), mainActivity3.prywqjr ? mainActivity3.getString(R.string.flash_method_raw) : mainActivity3.getString(R.string.flash_method_download)));
                                        if (mainActivity3.ezuzoct.nkemejx) {
                                            sb.append(mainActivity3.getString(R.string.flash_confirm_critical));
                                        }
                                        if (mainActivity3.prywqjr && length < j) {
                                            sb.append(mainActivity3.getString(R.string.flash_confirm_raw_padding, x.zamkzqg.jybecxv(j - length)));
                                        }
                                        x.zamkzqg.bgmsltp(mainActivity3, R.string.flash_confirm_title, sb.toString(), R.string.flash_confirm_action, mainActivity3.ezuzoct.nkemejx, new hknanqb(mainActivity3, 2));
                                    }
                                } else {
                                    Toast.makeText(mainActivity3, R.string.flash_select_readable_image, 0).show();
                                }
                            }
                            break;
                        }
                        break;
                }
            }
        });
        linearLayoutZwaqeaz.addView(textViewBwvplah);
        TextView textViewOxoagud = x.zamkzqg.oxoagud(this, getString(R.string.flash_load_parts_hint), 11, x.zamkzqg.jbmzxye(this), false);
        textViewOxoagud.setPadding(0, x.zamkzqg.qunltjs(this, 7), 0, 0);
        linearLayoutZwaqeaz.addView(textViewOxoagud);
        linearLayoutXbdyiew.addView(linearLayoutZwaqeaz, x.zamkzqg.uiqyzsp(this));
        LinearLayout linearLayoutZwaqeaz2 = x.zamkzqg.zwaqeaz(this);
        linearLayoutZwaqeaz2.addView(x.zamkzqg.ysaclsr(this, R.string.flash_image_file));
        final int i2 = 1;
        TextView textViewBwvplah2 = x.zamkzqg.bwvplah(this, R.string.flash_choose_image, R.drawable.ic_file, new View.OnClickListener() { // from class: x.kffvigz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        MainActivity mainActivity = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity.wjugzfh()) {
                            if (mainActivity.jbmzxye.isEmpty()) {
                                Toast.makeText(mainActivity, mainActivity.ywhgqsi ? R.string.error_partition_loading : R.string.error_reading_partition_first, 0).show();
                                if (!mainActivity.ywhgqsi) {
                                    mainActivity.saksmfq();
                                }
                            } else {
                                String[] strArr = new String[mainActivity.jbmzxye.size()];
                                for (int i3 = 0; i3 < mainActivity.jbmzxye.size(); i3++) {
                                    strArr[i3] = ((ohwxijw) mainActivity.jbmzxye.get(i3)).nmpwovh;
                                }
                                new AlertDialog.Builder(mainActivity).setTitle(R.string.error_select_partition).setItems(strArr, new hknanqb(mainActivity, 1)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
                            }
                            break;
                        }
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            x.ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.flash_choose_image), mainActivity2.lclupha(), null, new kpmmknm(mainActivity2));
                            break;
                        }
                        break;
                    case 2:
                        xbdyiewVar.nmpwovh.bwvplah(false);
                        break;
                    case 3:
                        xbdyiewVar.nmpwovh.bwvplah(true);
                        break;
                    default:
                        MainActivity mainActivity3 = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity3.wjugzfh()) {
                            if (mainActivity3.lpkdqgx || mainActivity3.gzokllk) {
                                Toast.makeText(mainActivity3, R.string.error_busy, 0).show();
                            } else if (mainActivity3.ezuzoct == null) {
                                Toast.makeText(mainActivity3, R.string.flash_select_partition_first, 0).show();
                            } else {
                                File file = mainActivity3.pwjmwpv;
                                if (file != null && file.isFile() && mainActivity3.pwjmwpv.canRead()) {
                                    long length = mainActivity3.pwjmwpv.length();
                                    ohwxijw ohwxijwVar = mainActivity3.ezuzoct;
                                    long j = ohwxijwVar.vivhedu;
                                    if (length <= 0 || length > j) {
                                        mainActivity3.lvtqoqa();
                                        Toast.makeText(mainActivity3, R.string.flash_invalid_size, 1).show();
                                    } else {
                                        StringBuilder sb = new StringBuilder(mainActivity3.getString(R.string.flash_confirm_message, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(j), mainActivity3.pwjmwpv.getName(), x.zamkzqg.jybecxv(length), mainActivity3.prywqjr ? mainActivity3.getString(R.string.flash_method_raw) : mainActivity3.getString(R.string.flash_method_download)));
                                        if (mainActivity3.ezuzoct.nkemejx) {
                                            sb.append(mainActivity3.getString(R.string.flash_confirm_critical));
                                        }
                                        if (mainActivity3.prywqjr && length < j) {
                                            sb.append(mainActivity3.getString(R.string.flash_confirm_raw_padding, x.zamkzqg.jybecxv(j - length)));
                                        }
                                        x.zamkzqg.bgmsltp(mainActivity3, R.string.flash_confirm_title, sb.toString(), R.string.flash_confirm_action, mainActivity3.ezuzoct.nkemejx, new hknanqb(mainActivity3, 2));
                                    }
                                } else {
                                    Toast.makeText(mainActivity3, R.string.flash_select_readable_image, 0).show();
                                }
                            }
                            break;
                        }
                        break;
                }
            }
        });
        linearLayoutZwaqeaz2.addView(textViewBwvplah2);
        TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, getString(R.string.flash_real_path_hint), 11, x.zamkzqg.jbmzxye(this), false);
        textViewOxoagud2.setPadding(0, x.zamkzqg.qunltjs(this, 7), 0, 0);
        linearLayoutZwaqeaz2.addView(textViewOxoagud2);
        linearLayoutXbdyiew.addView(linearLayoutZwaqeaz2, x.zamkzqg.uiqyzsp(this));
        LinearLayout linearLayoutZwaqeaz3 = x.zamkzqg.zwaqeaz(this);
        linearLayoutZwaqeaz3.addView(x.zamkzqg.ysaclsr(this, R.string.flash_method));
        LinearLayout linearLayoutLvtqoqa = x.zamkzqg.lvtqoqa(this);
        int iNmpwovh = x.zamkzqg.nmpwovh(this);
        final int i3 = 2;
        TextView textViewLclupha = x.zamkzqg.lclupha(this, getString(R.string.flash_method_download), new View.OnClickListener() { // from class: x.kffvigz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i3) {
                    case 0:
                        MainActivity mainActivity = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity.wjugzfh()) {
                            if (mainActivity.jbmzxye.isEmpty()) {
                                Toast.makeText(mainActivity, mainActivity.ywhgqsi ? R.string.error_partition_loading : R.string.error_reading_partition_first, 0).show();
                                if (!mainActivity.ywhgqsi) {
                                    mainActivity.saksmfq();
                                }
                            } else {
                                String[] strArr = new String[mainActivity.jbmzxye.size()];
                                for (int i4 = 0; i4 < mainActivity.jbmzxye.size(); i4++) {
                                    strArr[i4] = ((ohwxijw) mainActivity.jbmzxye.get(i4)).nmpwovh;
                                }
                                new AlertDialog.Builder(mainActivity).setTitle(R.string.error_select_partition).setItems(strArr, new hknanqb(mainActivity, 1)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
                            }
                            break;
                        }
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            x.ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.flash_choose_image), mainActivity2.lclupha(), null, new kpmmknm(mainActivity2));
                            break;
                        }
                        break;
                    case 2:
                        xbdyiewVar.nmpwovh.bwvplah(false);
                        break;
                    case 3:
                        xbdyiewVar.nmpwovh.bwvplah(true);
                        break;
                    default:
                        MainActivity mainActivity3 = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity3.wjugzfh()) {
                            if (mainActivity3.lpkdqgx || mainActivity3.gzokllk) {
                                Toast.makeText(mainActivity3, R.string.error_busy, 0).show();
                            } else if (mainActivity3.ezuzoct == null) {
                                Toast.makeText(mainActivity3, R.string.flash_select_partition_first, 0).show();
                            } else {
                                File file = mainActivity3.pwjmwpv;
                                if (file != null && file.isFile() && mainActivity3.pwjmwpv.canRead()) {
                                    long length = mainActivity3.pwjmwpv.length();
                                    ohwxijw ohwxijwVar = mainActivity3.ezuzoct;
                                    long j = ohwxijwVar.vivhedu;
                                    if (length <= 0 || length > j) {
                                        mainActivity3.lvtqoqa();
                                        Toast.makeText(mainActivity3, R.string.flash_invalid_size, 1).show();
                                    } else {
                                        StringBuilder sb = new StringBuilder(mainActivity3.getString(R.string.flash_confirm_message, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(j), mainActivity3.pwjmwpv.getName(), x.zamkzqg.jybecxv(length), mainActivity3.prywqjr ? mainActivity3.getString(R.string.flash_method_raw) : mainActivity3.getString(R.string.flash_method_download)));
                                        if (mainActivity3.ezuzoct.nkemejx) {
                                            sb.append(mainActivity3.getString(R.string.flash_confirm_critical));
                                        }
                                        if (mainActivity3.prywqjr && length < j) {
                                            sb.append(mainActivity3.getString(R.string.flash_confirm_raw_padding, x.zamkzqg.jybecxv(j - length)));
                                        }
                                        x.zamkzqg.bgmsltp(mainActivity3, R.string.flash_confirm_title, sb.toString(), R.string.flash_confirm_action, mainActivity3.ezuzoct.nkemejx, new hknanqb(mainActivity3, 2));
                                    }
                                } else {
                                    Toast.makeText(mainActivity3, R.string.flash_select_readable_image, 0).show();
                                }
                            }
                            break;
                        }
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha, R.drawable.ic_flash, iNmpwovh);
        int iOhwxijw = x.zamkzqg.ohwxijw(this);
        final int i4 = 3;
        TextView textViewLclupha2 = x.zamkzqg.lclupha(this, getString(R.string.flash_method_raw), new View.OnClickListener() { // from class: x.kffvigz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        MainActivity mainActivity = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity.wjugzfh()) {
                            if (mainActivity.jbmzxye.isEmpty()) {
                                Toast.makeText(mainActivity, mainActivity.ywhgqsi ? R.string.error_partition_loading : R.string.error_reading_partition_first, 0).show();
                                if (!mainActivity.ywhgqsi) {
                                    mainActivity.saksmfq();
                                }
                            } else {
                                String[] strArr = new String[mainActivity.jbmzxye.size()];
                                for (int i5 = 0; i5 < mainActivity.jbmzxye.size(); i5++) {
                                    strArr[i5] = ((ohwxijw) mainActivity.jbmzxye.get(i5)).nmpwovh;
                                }
                                new AlertDialog.Builder(mainActivity).setTitle(R.string.error_select_partition).setItems(strArr, new hknanqb(mainActivity, 1)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
                            }
                            break;
                        }
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            x.ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.flash_choose_image), mainActivity2.lclupha(), null, new kpmmknm(mainActivity2));
                            break;
                        }
                        break;
                    case 2:
                        xbdyiewVar.nmpwovh.bwvplah(false);
                        break;
                    case 3:
                        xbdyiewVar.nmpwovh.bwvplah(true);
                        break;
                    default:
                        MainActivity mainActivity3 = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity3.wjugzfh()) {
                            if (mainActivity3.lpkdqgx || mainActivity3.gzokllk) {
                                Toast.makeText(mainActivity3, R.string.error_busy, 0).show();
                            } else if (mainActivity3.ezuzoct == null) {
                                Toast.makeText(mainActivity3, R.string.flash_select_partition_first, 0).show();
                            } else {
                                File file = mainActivity3.pwjmwpv;
                                if (file != null && file.isFile() && mainActivity3.pwjmwpv.canRead()) {
                                    long length = mainActivity3.pwjmwpv.length();
                                    ohwxijw ohwxijwVar = mainActivity3.ezuzoct;
                                    long j = ohwxijwVar.vivhedu;
                                    if (length <= 0 || length > j) {
                                        mainActivity3.lvtqoqa();
                                        Toast.makeText(mainActivity3, R.string.flash_invalid_size, 1).show();
                                    } else {
                                        StringBuilder sb = new StringBuilder(mainActivity3.getString(R.string.flash_confirm_message, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(j), mainActivity3.pwjmwpv.getName(), x.zamkzqg.jybecxv(length), mainActivity3.prywqjr ? mainActivity3.getString(R.string.flash_method_raw) : mainActivity3.getString(R.string.flash_method_download)));
                                        if (mainActivity3.ezuzoct.nkemejx) {
                                            sb.append(mainActivity3.getString(R.string.flash_confirm_critical));
                                        }
                                        if (mainActivity3.prywqjr && length < j) {
                                            sb.append(mainActivity3.getString(R.string.flash_confirm_raw_padding, x.zamkzqg.jybecxv(j - length)));
                                        }
                                        x.zamkzqg.bgmsltp(mainActivity3, R.string.flash_confirm_title, sb.toString(), R.string.flash_confirm_action, mainActivity3.ezuzoct.nkemejx, new hknanqb(mainActivity3, 2));
                                    }
                                } else {
                                    Toast.makeText(mainActivity3, R.string.flash_select_readable_image, 0).show();
                                }
                            }
                            break;
                        }
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha2, R.drawable.ic_warning, iOhwxijw);
        linearLayoutLvtqoqa.addView(textViewLclupha, x.zamkzqg.qxvquar(this));
        linearLayoutLvtqoqa.addView(textViewLclupha2, x.zamkzqg.qxvquar(this));
        linearLayoutZwaqeaz3.addView(linearLayoutLvtqoqa);
        TextView textViewOxoagud3 = x.zamkzqg.oxoagud(this, getString(R.string.flash_method_hint), 11, x.zamkzqg.jbmzxye(this), false);
        textViewOxoagud3.setPadding(0, x.zamkzqg.qunltjs(this, 7), 0, 0);
        linearLayoutZwaqeaz3.addView(textViewOxoagud3);
        linearLayoutXbdyiew.addView(linearLayoutZwaqeaz3, x.zamkzqg.uiqyzsp(this));
        LinearLayout linearLayoutZwaqeaz4 = x.zamkzqg.zwaqeaz(this);
        linearLayoutZwaqeaz4.addView(x.zamkzqg.ysaclsr(this, R.string.flash_validation));
        TextView textViewWjugzfh = x.zamkzqg.wjugzfh(this, linearLayoutZwaqeaz4, R.string.flash_image_size, getString(R.string.value_not_available));
        TextView textViewWjugzfh2 = x.zamkzqg.wjugzfh(this, linearLayoutZwaqeaz4, R.string.flash_partition_size, getString(R.string.value_not_available));
        TextView textViewOxoagud4 = x.zamkzqg.oxoagud(this, getString(R.string.flash_select_validation), 12, x.zamkzqg.jbmzxye(this), true);
        textViewOxoagud4.setPadding(0, x.zamkzqg.qunltjs(this, 9), 0, 0);
        linearLayoutZwaqeaz4.addView(textViewOxoagud4);
        linearLayoutXbdyiew.addView(linearLayoutZwaqeaz4, x.zamkzqg.uiqyzsp(this));
        LinearLayout linearLayoutZwaqeaz5 = x.zamkzqg.zwaqeaz(this);
        linearLayoutZwaqeaz5.addView(x.zamkzqg.ysaclsr(this, R.string.flash_da_file));
        TextView textViewOxoagud5 = x.zamkzqg.oxoagud(this, getString(R.string.status_not_configured), 13, x.zamkzqg.zngzleo(this), true);
        textViewOxoagud5.setPadding(x.zamkzqg.qunltjs(this, 10), x.zamkzqg.qunltjs(this, 10), x.zamkzqg.qunltjs(this, 10), x.zamkzqg.qunltjs(this, 10));
        textViewOxoagud5.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.atntgcp(this), x.zamkzqg.qyeibyo(this), x.zamkzqg.qunltjs(this, 10)));
        linearLayoutZwaqeaz5.addView(textViewOxoagud5);
        linearLayoutXbdyiew.addView(linearLayoutZwaqeaz5, x.zamkzqg.uiqyzsp(this));
        int iKggugdp = x.zamkzqg.kggugdp(this);
        final int i5 = 4;
        TextView textViewLclupha3 = x.zamkzqg.lclupha(this, getString(R.string.flash_action), new View.OnClickListener() { // from class: x.kffvigz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        MainActivity mainActivity = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity.wjugzfh()) {
                            if (mainActivity.jbmzxye.isEmpty()) {
                                Toast.makeText(mainActivity, mainActivity.ywhgqsi ? R.string.error_partition_loading : R.string.error_reading_partition_first, 0).show();
                                if (!mainActivity.ywhgqsi) {
                                    mainActivity.saksmfq();
                                }
                            } else {
                                String[] strArr = new String[mainActivity.jbmzxye.size()];
                                for (int i6 = 0; i6 < mainActivity.jbmzxye.size(); i6++) {
                                    strArr[i6] = ((ohwxijw) mainActivity.jbmzxye.get(i6)).nmpwovh;
                                }
                                new AlertDialog.Builder(mainActivity).setTitle(R.string.error_select_partition).setItems(strArr, new hknanqb(mainActivity, 1)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).show();
                            }
                            break;
                        }
                        break;
                    case 1:
                        MainActivity mainActivity2 = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity2.dplrlfq()) {
                            x.ecffprn.imuemzb(mainActivity2, mainActivity2.getString(R.string.flash_choose_image), mainActivity2.lclupha(), null, new kpmmknm(mainActivity2));
                            break;
                        }
                        break;
                    case 2:
                        xbdyiewVar.nmpwovh.bwvplah(false);
                        break;
                    case 3:
                        xbdyiewVar.nmpwovh.bwvplah(true);
                        break;
                    default:
                        MainActivity mainActivity3 = (MainActivity) xbdyiewVar.nmpwovh;
                        if (mainActivity3.wjugzfh()) {
                            if (mainActivity3.lpkdqgx || mainActivity3.gzokllk) {
                                Toast.makeText(mainActivity3, R.string.error_busy, 0).show();
                            } else if (mainActivity3.ezuzoct == null) {
                                Toast.makeText(mainActivity3, R.string.flash_select_partition_first, 0).show();
                            } else {
                                File file = mainActivity3.pwjmwpv;
                                if (file != null && file.isFile() && mainActivity3.pwjmwpv.canRead()) {
                                    long length = mainActivity3.pwjmwpv.length();
                                    ohwxijw ohwxijwVar = mainActivity3.ezuzoct;
                                    long j = ohwxijwVar.vivhedu;
                                    if (length <= 0 || length > j) {
                                        mainActivity3.lvtqoqa();
                                        Toast.makeText(mainActivity3, R.string.flash_invalid_size, 1).show();
                                    } else {
                                        StringBuilder sb = new StringBuilder(mainActivity3.getString(R.string.flash_confirm_message, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(j), mainActivity3.pwjmwpv.getName(), x.zamkzqg.jybecxv(length), mainActivity3.prywqjr ? mainActivity3.getString(R.string.flash_method_raw) : mainActivity3.getString(R.string.flash_method_download)));
                                        if (mainActivity3.ezuzoct.nkemejx) {
                                            sb.append(mainActivity3.getString(R.string.flash_confirm_critical));
                                        }
                                        if (mainActivity3.prywqjr && length < j) {
                                            sb.append(mainActivity3.getString(R.string.flash_confirm_raw_padding, x.zamkzqg.jybecxv(j - length)));
                                        }
                                        x.zamkzqg.bgmsltp(mainActivity3, R.string.flash_confirm_title, sb.toString(), R.string.flash_confirm_action, mainActivity3.ezuzoct.nkemejx, new hknanqb(mainActivity3, 2));
                                    }
                                } else {
                                    Toast.makeText(mainActivity3, R.string.flash_select_readable_image, 0).show();
                                }
                            }
                            break;
                        }
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha3, R.drawable.ic_flash, iKggugdp);
        textViewLclupha3.setTextSize(15.0f);
        textViewLclupha3.setTextColor(x.zamkzqg.kggugdp(this));
        textViewLclupha3.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.ojyssqt(this), x.zamkzqg.ojyssqt(this), x.zamkzqg.qunltjs(this, 11)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(this, 54));
        layoutParams.setMargins(0, x.zamkzqg.qunltjs(this, 4), 0, x.zamkzqg.qunltjs(this, 12));
        linearLayoutXbdyiew.addView(textViewLclupha3, layoutParams);
        linearLayoutXbdyiew.addView(new View(this), new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
        this.gngavpw = textViewBwvplah;
        this.teupdsw = textViewOxoagud;
        this.duxkmyb = textViewBwvplah2;
        this.znfyiic = textViewOxoagud2;
        this.jzcfpou = textViewLclupha;
        this.odhctch = textViewLclupha2;
        this.sxhcynd = textViewWjugzfh;
        this.hfkdhls = textViewWjugzfh2;
        this.lcgzsis = textViewOxoagud4;
        this.mccfjlr = textViewOxoagud5;
        this.tqfwohl = textViewLclupha3;
        bwvplah(false);
        lvtqoqa();
        return scrollView;
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        buswjhz();
    }

    public final void rpdxrib(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder("[SUCCESS] ");
        if ("READ".equals(str)) {
            str3 = "BACKUP";
        } else {
            str3 = "ERASE".equals(str) ? "ERASE" : "FLASH";
        }
        sb.append(str3);
        sb.append(" ");
        sb.append(x.zamkzqg.kxotgjb(str2) ? str2.trim() : "unknown");
        String string = sb.toString();
        xvxmcgn(string);
        ((MainActivity) this).nmpwovh(string);
    }

    public final void rvrflql() {
        String string;
        int i;
        LinearLayout linearLayout = this.gjpruie;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        EditText editText = this.enxkjpu;
        String lowerCase = editText == null ? "" : editText.getText().toString().trim().toLowerCase(Locale.ROOT);
        Iterator it = this.jbmzxye.iterator();
        long j = 0;
        long j2 = 0;
        int i2 = 0;
        while (it.hasNext()) {
            final ohwxijw ohwxijwVar = (ohwxijw) it.next();
            if (ohwxijwVar == null ? false : this.sdchfks.equals(ohwxijwVar.oqexvyb)) {
                if (!lowerCase.isEmpty()) {
                    String str = ohwxijwVar.nmpwovh;
                    Locale locale = Locale.ROOT;
                    if (str.toLowerCase(locale).contains(lowerCase) || ohwxijwVar.lthborb.toLowerCase(locale).contains(lowerCase)) {
                    }
                }
                i2++;
                long j3 = ohwxijwVar.vivhedu;
                j2 = (j3 <= j || j2 <= Long.MAX_VALUE - j3) ? j2 + j3 : Long.MAX_VALUE;
                LinearLayout linearLayout2 = this.gjpruie;
                final xbdyiew xbdyiewVar = new xbdyiew(this);
                LinearLayout linearLayout3 = new LinearLayout(this);
                linearLayout3.setOrientation(1);
                linearLayout3.setPadding(getResources().getDimensionPixelSize(R.dimen.partition_compact_card_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.partition_compact_card_padding_vertical), getResources().getDimensionPixelSize(R.dimen.partition_compact_card_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.partition_compact_card_padding_vertical));
                int iTmdubwv = x.zamkzqg.tmdubwv(this, ohwxijwVar.oqexvyb);
                String str2 = ohwxijwVar.oqexvyb;
                linearLayout3.setBackground(x.zamkzqg.jvtqflj(this, iTmdubwv, x.zamkzqg.cugubfc(this, str2), getResources().getDimensionPixelSize(R.dimen.partition_compact_card_radius)));
                linearLayout3.setClickable(true);
                linearLayout3.setFocusable(true);
                x.zamkzqg.utmeivs(this, linearLayout3);
                final int i3 = 0;
                linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: x.qwpvrdy
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i4;
                        switch (i3) {
                            case 0:
                                kggugdp kggugdpVar = xbdyiewVar.nmpwovh;
                                kggugdpVar.getClass();
                                final ohwxijw ohwxijwVar2 = ohwxijwVar;
                                final xbdyiew xbdyiewVar2 = new xbdyiew(kggugdpVar);
                                ScrollView scrollView = new ScrollView(kggugdpVar);
                                scrollView.setFillViewport(true);
                                LinearLayout linearLayoutXbdyiew = x.zamkzqg.xbdyiew(kggugdpVar, 16);
                                scrollView.addView(linearLayoutXbdyiew);
                                int iNmpwovh = x.zamkzqg.nmpwovh(kggugdpVar);
                                TextView textViewLclupha = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_title), new nmpwovh(xbdyiewVar2, 5));
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha, R.drawable.ic_back, iNmpwovh);
                                textViewLclupha.setGravity(8388627);
                                textViewLclupha.setPadding(0, x.zamkzqg.qunltjs(kggugdpVar, 4), 0, x.zamkzqg.qunltjs(kggugdpVar, 8));
                                linearLayoutXbdyiew.addView(textViewLclupha);
                                linearLayoutXbdyiew.addView(x.zamkzqg.ywhgqsi(kggugdpVar, kggugdpVar.getString(R.string.parts_details)));
                                LinearLayout linearLayoutZwaqeaz = x.zamkzqg.zwaqeaz(kggugdpVar);
                                String str3 = ohwxijwVar2.oqexvyb;
                                linearLayoutZwaqeaz.setBackground(x.zamkzqg.jvtqflj(kggugdpVar, x.zamkzqg.tmdubwv(kggugdpVar, str3), x.zamkzqg.cugubfc(kggugdpVar, str3), x.zamkzqg.qunltjs(kggugdpVar, x.zamkzqg.nhhacgu(kggugdpVar))));
                                LinearLayout linearLayoutLvtqoqa = x.zamkzqg.lvtqoqa(kggugdpVar);
                                int iZngzleo = x.zamkzqg.zngzleo(kggugdpVar);
                                String str4 = ohwxijwVar2.nmpwovh;
                                TextView textViewOxoagud = x.zamkzqg.oxoagud(kggugdpVar, str4, 20, iZngzleo, true);
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewOxoagud, "green".equals(str3) ? R.drawable.ic_partition : R.drawable.ic_warning, x.zamkzqg.cugubfc(kggugdpVar, str3));
                                linearLayoutLvtqoqa.addView(textViewOxoagud, new LinearLayout.LayoutParams(0, -2, 1.0f));
                                linearLayoutLvtqoqa.addView(x.zamkzqg.ibfmasn(kggugdpVar, ohwxijwVar2));
                                linearLayoutZwaqeaz.addView(linearLayoutLvtqoqa);
                                StringBuilder sb = new StringBuilder();
                                long j4 = ohwxijwVar2.vivhedu;
                                sb.append(x.zamkzqg.jybecxv(j4));
                                sb.append(" • ");
                                String str5 = ohwxijwVar2.qxvquar;
                                boolean zEquals = "—".equals(str5);
                                String str6 = ohwxijwVar2.lthborb;
                                sb.append(zEquals ? str6 : kggugdpVar.getString(R.string.parts_meta_slot, str6, str5));
                                TextView textViewOxoagud2 = x.zamkzqg.oxoagud(kggugdpVar, sb.toString(), 12, x.zamkzqg.jbmzxye(kggugdpVar), false);
                                textViewOxoagud2.setPadding(0, x.zamkzqg.qunltjs(kggugdpVar, 4), 0, 0);
                                linearLayoutZwaqeaz.addView(textViewOxoagud2);
                                linearLayoutXbdyiew.addView(linearLayoutZwaqeaz, x.zamkzqg.uiqyzsp(kggugdpVar));
                                LinearLayout linearLayoutZwaqeaz2 = x.zamkzqg.zwaqeaz(kggugdpVar);
                                linearLayoutZwaqeaz2.addView(x.zamkzqg.ysaclsr(kggugdpVar, R.string.parts_info));
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_name, str4);
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_size, kggugdpVar.getString(R.string.parts_size_exact, x.zamkzqg.jybecxv(j4), Long.valueOf(j4)));
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_region, str6);
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_start_address, ohwxijwVar2.ojyssqt);
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_slot, str5);
                                linearLayoutXbdyiew.addView(linearLayoutZwaqeaz2, x.zamkzqg.uiqyzsp(kggugdpVar));
                                int iNmpwovh2 = x.zamkzqg.nmpwovh(kggugdpVar);
                                final int i5 = 2;
                                TextView textViewLclupha2 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_backup_partition), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i5) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha2, R.drawable.ic_backup, iNmpwovh2);
                                textViewLclupha2.setTextColor(x.zamkzqg.nmpwovh(kggugdpVar));
                                linearLayoutXbdyiew.addView(textViewLclupha2, new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 50)));
                                int iOhwxijw = x.zamkzqg.ohwxijw(kggugdpVar);
                                final int i6 = 3;
                                TextView textViewLclupha3 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_flash_image), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i6) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha3, R.drawable.ic_flash, iOhwxijw);
                                textViewLclupha3.setTextColor(x.zamkzqg.ohwxijw(kggugdpVar));
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 50));
                                layoutParams.topMargin = x.zamkzqg.qunltjs(kggugdpVar, 8);
                                linearLayoutXbdyiew.addView(textViewLclupha3, layoutParams);
                                int iPzqxblc = x.zamkzqg.pzqxblc(kggugdpVar);
                                final int i7 = 0;
                                TextView textViewLclupha4 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_erase_partition), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i7) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha4, R.drawable.ic_erase, iPzqxblc);
                                textViewLclupha4.setTextColor(x.zamkzqg.pzqxblc(kggugdpVar));
                                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 50));
                                layoutParams2.topMargin = x.zamkzqg.qunltjs(kggugdpVar, 8);
                                linearLayoutXbdyiew.addView(textViewLclupha4, layoutParams2);
                                int iJbmzxye = x.zamkzqg.jbmzxye(kggugdpVar);
                                final int i8 = 1;
                                TextView textViewLclupha5 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_copy_address), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i8) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha5, R.drawable.ic_copy, iJbmzxye);
                                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 46));
                                layoutParams3.topMargin = x.zamkzqg.qunltjs(kggugdpVar, 8);
                                linearLayoutXbdyiew.addView(textViewLclupha5, layoutParams3);
                                LinearLayout linearLayoutZwaqeaz3 = x.zamkzqg.zwaqeaz(kggugdpVar);
                                linearLayoutZwaqeaz3.setBackground(x.zamkzqg.jvtqflj(kggugdpVar, x.zamkzqg.tmdubwv(kggugdpVar, str3), x.zamkzqg.cugubfc(kggugdpVar, str3), x.zamkzqg.qunltjs(kggugdpVar, x.zamkzqg.nhhacgu(kggugdpVar))));
                                if (ohwxijwVar2.nmpwovh()) {
                                    i4 = R.string.parts_red_warning;
                                } else {
                                    i4 = "yellow".equals(str3) ? R.string.parts_yellow_warning : R.string.parts_green_note;
                                }
                                TextView textViewOxoagud3 = x.zamkzqg.oxoagud(kggugdpVar, kggugdpVar.getString(i4), 12, x.zamkzqg.cugubfc(kggugdpVar, str3), ohwxijwVar2.nkemejx);
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewOxoagud3, "green".equals(str3) ? R.drawable.ic_partition : R.drawable.ic_warning, x.zamkzqg.cugubfc(kggugdpVar, str3));
                                textViewOxoagud3.setLineSpacing(0.0f, 1.12f);
                                linearLayoutZwaqeaz3.addView(textViewOxoagud3);
                                linearLayoutXbdyiew.addView(linearLayoutZwaqeaz3, x.zamkzqg.uiqyzsp(kggugdpVar));
                                kggugdpVar.kffvigz(scrollView, "partition_details");
                                break;
                            case 1:
                                xbdyiewVar.nmpwovh.enxkjpu(ohwxijwVar);
                                break;
                            default:
                                xbdyiew xbdyiewVar3 = xbdyiewVar;
                                ohwxijw ohwxijwVar3 = ohwxijwVar;
                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                kggugdpVar2.ezuzoct = ohwxijwVar3;
                                kggugdpVar2.lvtqoqa();
                                kggugdpVar2.nhhacgu("flash");
                                break;
                        }
                    }
                });
                LinearLayout linearLayoutLvtqoqa = x.zamkzqg.lvtqoqa(this);
                linearLayoutLvtqoqa.setGravity(16);
                LinearLayout linearLayout4 = new LinearLayout(this);
                linearLayout4.setOrientation(1);
                String str3 = lowerCase;
                Iterator it2 = it;
                linearLayout4.addView(x.zamkzqg.oxoagud(this, ohwxijwVar.nmpwovh, 14, x.zamkzqg.zngzleo(this), true));
                StringBuilder sb = new StringBuilder();
                sb.append(x.zamkzqg.jybecxv(ohwxijwVar.vivhedu));
                sb.append(" • ");
                String str4 = ohwxijwVar.qxvquar;
                boolean zEquals = "—".equals(str4);
                String string2 = ohwxijwVar.lthborb;
                if (!zEquals) {
                    string2 = getString(R.string.parts_meta_slot, string2, str4);
                }
                sb.append(string2);
                TextView textViewOxoagud = x.zamkzqg.oxoagud(this, sb.toString(), 10, x.zamkzqg.jbmzxye(this), false);
                textViewOxoagud.setPadding(0, getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                linearLayout4.addView(textViewOxoagud);
                if (ohwxijwVar.nmpwovh() || "yellow".equals(ohwxijwVar.oqexvyb)) {
                    TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, getString(ohwxijwVar.nmpwovh() ? R.string.parts_red_card_note : R.string.parts_yellow_card_note), 9, x.zamkzqg.cugubfc(this, str2), true);
                    i = 0;
                    textViewOxoagud2.setPadding(0, getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                    linearLayout4.addView(textViewOxoagud2);
                } else {
                    i = 0;
                }
                linearLayoutLvtqoqa.addView(linearLayout4, new LinearLayout.LayoutParams(i, -2, 1.0f));
                linearLayoutLvtqoqa.addView(x.zamkzqg.ibfmasn(this, ohwxijwVar));
                linearLayout3.addView(linearLayoutLvtqoqa);
                LinearLayout linearLayoutLvtqoqa2 = x.zamkzqg.lvtqoqa(this);
                linearLayoutLvtqoqa2.setGravity(8388613);
                final int i4 = 1;
                TextView textViewBtazysh = x.zamkzqg.btazysh(this, R.drawable.ic_backup, x.zamkzqg.nmpwovh(this), R.string.cd_backup, new View.OnClickListener() { // from class: x.qwpvrdy
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i5;
                        switch (i4) {
                            case 0:
                                kggugdp kggugdpVar = xbdyiewVar.nmpwovh;
                                kggugdpVar.getClass();
                                final ohwxijw ohwxijwVar2 = ohwxijwVar;
                                final xbdyiew xbdyiewVar2 = new xbdyiew(kggugdpVar);
                                ScrollView scrollView = new ScrollView(kggugdpVar);
                                scrollView.setFillViewport(true);
                                LinearLayout linearLayoutXbdyiew = x.zamkzqg.xbdyiew(kggugdpVar, 16);
                                scrollView.addView(linearLayoutXbdyiew);
                                int iNmpwovh = x.zamkzqg.nmpwovh(kggugdpVar);
                                TextView textViewLclupha = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_title), new nmpwovh(xbdyiewVar2, 5));
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha, R.drawable.ic_back, iNmpwovh);
                                textViewLclupha.setGravity(8388627);
                                textViewLclupha.setPadding(0, x.zamkzqg.qunltjs(kggugdpVar, 4), 0, x.zamkzqg.qunltjs(kggugdpVar, 8));
                                linearLayoutXbdyiew.addView(textViewLclupha);
                                linearLayoutXbdyiew.addView(x.zamkzqg.ywhgqsi(kggugdpVar, kggugdpVar.getString(R.string.parts_details)));
                                LinearLayout linearLayoutZwaqeaz = x.zamkzqg.zwaqeaz(kggugdpVar);
                                String str5 = ohwxijwVar2.oqexvyb;
                                linearLayoutZwaqeaz.setBackground(x.zamkzqg.jvtqflj(kggugdpVar, x.zamkzqg.tmdubwv(kggugdpVar, str5), x.zamkzqg.cugubfc(kggugdpVar, str5), x.zamkzqg.qunltjs(kggugdpVar, x.zamkzqg.nhhacgu(kggugdpVar))));
                                LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(kggugdpVar);
                                int iZngzleo = x.zamkzqg.zngzleo(kggugdpVar);
                                String str6 = ohwxijwVar2.nmpwovh;
                                TextView textViewOxoagud3 = x.zamkzqg.oxoagud(kggugdpVar, str6, 20, iZngzleo, true);
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewOxoagud3, "green".equals(str5) ? R.drawable.ic_partition : R.drawable.ic_warning, x.zamkzqg.cugubfc(kggugdpVar, str5));
                                linearLayoutLvtqoqa3.addView(textViewOxoagud3, new LinearLayout.LayoutParams(0, -2, 1.0f));
                                linearLayoutLvtqoqa3.addView(x.zamkzqg.ibfmasn(kggugdpVar, ohwxijwVar2));
                                linearLayoutZwaqeaz.addView(linearLayoutLvtqoqa3);
                                StringBuilder sb2 = new StringBuilder();
                                long j4 = ohwxijwVar2.vivhedu;
                                sb2.append(x.zamkzqg.jybecxv(j4));
                                sb2.append(" • ");
                                String str7 = ohwxijwVar2.qxvquar;
                                boolean zEquals2 = "—".equals(str7);
                                String str8 = ohwxijwVar2.lthborb;
                                sb2.append(zEquals2 ? str8 : kggugdpVar.getString(R.string.parts_meta_slot, str8, str7));
                                TextView textViewOxoagud4 = x.zamkzqg.oxoagud(kggugdpVar, sb2.toString(), 12, x.zamkzqg.jbmzxye(kggugdpVar), false);
                                textViewOxoagud4.setPadding(0, x.zamkzqg.qunltjs(kggugdpVar, 4), 0, 0);
                                linearLayoutZwaqeaz.addView(textViewOxoagud4);
                                linearLayoutXbdyiew.addView(linearLayoutZwaqeaz, x.zamkzqg.uiqyzsp(kggugdpVar));
                                LinearLayout linearLayoutZwaqeaz2 = x.zamkzqg.zwaqeaz(kggugdpVar);
                                linearLayoutZwaqeaz2.addView(x.zamkzqg.ysaclsr(kggugdpVar, R.string.parts_info));
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_name, str6);
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_size, kggugdpVar.getString(R.string.parts_size_exact, x.zamkzqg.jybecxv(j4), Long.valueOf(j4)));
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_region, str8);
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_start_address, ohwxijwVar2.ojyssqt);
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_slot, str7);
                                linearLayoutXbdyiew.addView(linearLayoutZwaqeaz2, x.zamkzqg.uiqyzsp(kggugdpVar));
                                int iNmpwovh2 = x.zamkzqg.nmpwovh(kggugdpVar);
                                final int i6 = 2;
                                TextView textViewLclupha2 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_backup_partition), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i6) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha2, R.drawable.ic_backup, iNmpwovh2);
                                textViewLclupha2.setTextColor(x.zamkzqg.nmpwovh(kggugdpVar));
                                linearLayoutXbdyiew.addView(textViewLclupha2, new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 50)));
                                int iOhwxijw = x.zamkzqg.ohwxijw(kggugdpVar);
                                final int i7 = 3;
                                TextView textViewLclupha3 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_flash_image), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i7) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha3, R.drawable.ic_flash, iOhwxijw);
                                textViewLclupha3.setTextColor(x.zamkzqg.ohwxijw(kggugdpVar));
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 50));
                                layoutParams.topMargin = x.zamkzqg.qunltjs(kggugdpVar, 8);
                                linearLayoutXbdyiew.addView(textViewLclupha3, layoutParams);
                                int iPzqxblc = x.zamkzqg.pzqxblc(kggugdpVar);
                                final int i8 = 0;
                                TextView textViewLclupha4 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_erase_partition), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i8) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha4, R.drawable.ic_erase, iPzqxblc);
                                textViewLclupha4.setTextColor(x.zamkzqg.pzqxblc(kggugdpVar));
                                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 50));
                                layoutParams2.topMargin = x.zamkzqg.qunltjs(kggugdpVar, 8);
                                linearLayoutXbdyiew.addView(textViewLclupha4, layoutParams2);
                                int iJbmzxye = x.zamkzqg.jbmzxye(kggugdpVar);
                                final int i9 = 1;
                                TextView textViewLclupha5 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_copy_address), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i9) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha5, R.drawable.ic_copy, iJbmzxye);
                                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 46));
                                layoutParams3.topMargin = x.zamkzqg.qunltjs(kggugdpVar, 8);
                                linearLayoutXbdyiew.addView(textViewLclupha5, layoutParams3);
                                LinearLayout linearLayoutZwaqeaz3 = x.zamkzqg.zwaqeaz(kggugdpVar);
                                linearLayoutZwaqeaz3.setBackground(x.zamkzqg.jvtqflj(kggugdpVar, x.zamkzqg.tmdubwv(kggugdpVar, str5), x.zamkzqg.cugubfc(kggugdpVar, str5), x.zamkzqg.qunltjs(kggugdpVar, x.zamkzqg.nhhacgu(kggugdpVar))));
                                if (ohwxijwVar2.nmpwovh()) {
                                    i5 = R.string.parts_red_warning;
                                } else {
                                    i5 = "yellow".equals(str5) ? R.string.parts_yellow_warning : R.string.parts_green_note;
                                }
                                TextView textViewOxoagud5 = x.zamkzqg.oxoagud(kggugdpVar, kggugdpVar.getString(i5), 12, x.zamkzqg.cugubfc(kggugdpVar, str5), ohwxijwVar2.nkemejx);
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewOxoagud5, "green".equals(str5) ? R.drawable.ic_partition : R.drawable.ic_warning, x.zamkzqg.cugubfc(kggugdpVar, str5));
                                textViewOxoagud5.setLineSpacing(0.0f, 1.12f);
                                linearLayoutZwaqeaz3.addView(textViewOxoagud5);
                                linearLayoutXbdyiew.addView(linearLayoutZwaqeaz3, x.zamkzqg.uiqyzsp(kggugdpVar));
                                kggugdpVar.kffvigz(scrollView, "partition_details");
                                break;
                            case 1:
                                xbdyiewVar.nmpwovh.enxkjpu(ohwxijwVar);
                                break;
                            default:
                                xbdyiew xbdyiewVar3 = xbdyiewVar;
                                ohwxijw ohwxijwVar3 = ohwxijwVar;
                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                kggugdpVar2.ezuzoct = ohwxijwVar3;
                                kggugdpVar2.lvtqoqa();
                                kggugdpVar2.nhhacgu("flash");
                                break;
                        }
                    }
                });
                final int i5 = 2;
                TextView textViewBtazysh2 = x.zamkzqg.btazysh(this, R.drawable.ic_flash, x.zamkzqg.cugubfc(this, str2), R.string.cd_flash, new View.OnClickListener() { // from class: x.qwpvrdy
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i6;
                        switch (i5) {
                            case 0:
                                kggugdp kggugdpVar = xbdyiewVar.nmpwovh;
                                kggugdpVar.getClass();
                                final ohwxijw ohwxijwVar2 = ohwxijwVar;
                                final xbdyiew xbdyiewVar2 = new xbdyiew(kggugdpVar);
                                ScrollView scrollView = new ScrollView(kggugdpVar);
                                scrollView.setFillViewport(true);
                                LinearLayout linearLayoutXbdyiew = x.zamkzqg.xbdyiew(kggugdpVar, 16);
                                scrollView.addView(linearLayoutXbdyiew);
                                int iNmpwovh = x.zamkzqg.nmpwovh(kggugdpVar);
                                TextView textViewLclupha = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_title), new nmpwovh(xbdyiewVar2, 5));
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha, R.drawable.ic_back, iNmpwovh);
                                textViewLclupha.setGravity(8388627);
                                textViewLclupha.setPadding(0, x.zamkzqg.qunltjs(kggugdpVar, 4), 0, x.zamkzqg.qunltjs(kggugdpVar, 8));
                                linearLayoutXbdyiew.addView(textViewLclupha);
                                linearLayoutXbdyiew.addView(x.zamkzqg.ywhgqsi(kggugdpVar, kggugdpVar.getString(R.string.parts_details)));
                                LinearLayout linearLayoutZwaqeaz = x.zamkzqg.zwaqeaz(kggugdpVar);
                                String str5 = ohwxijwVar2.oqexvyb;
                                linearLayoutZwaqeaz.setBackground(x.zamkzqg.jvtqflj(kggugdpVar, x.zamkzqg.tmdubwv(kggugdpVar, str5), x.zamkzqg.cugubfc(kggugdpVar, str5), x.zamkzqg.qunltjs(kggugdpVar, x.zamkzqg.nhhacgu(kggugdpVar))));
                                LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(kggugdpVar);
                                int iZngzleo = x.zamkzqg.zngzleo(kggugdpVar);
                                String str6 = ohwxijwVar2.nmpwovh;
                                TextView textViewOxoagud3 = x.zamkzqg.oxoagud(kggugdpVar, str6, 20, iZngzleo, true);
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewOxoagud3, "green".equals(str5) ? R.drawable.ic_partition : R.drawable.ic_warning, x.zamkzqg.cugubfc(kggugdpVar, str5));
                                linearLayoutLvtqoqa3.addView(textViewOxoagud3, new LinearLayout.LayoutParams(0, -2, 1.0f));
                                linearLayoutLvtqoqa3.addView(x.zamkzqg.ibfmasn(kggugdpVar, ohwxijwVar2));
                                linearLayoutZwaqeaz.addView(linearLayoutLvtqoqa3);
                                StringBuilder sb2 = new StringBuilder();
                                long j4 = ohwxijwVar2.vivhedu;
                                sb2.append(x.zamkzqg.jybecxv(j4));
                                sb2.append(" • ");
                                String str7 = ohwxijwVar2.qxvquar;
                                boolean zEquals2 = "—".equals(str7);
                                String str8 = ohwxijwVar2.lthborb;
                                sb2.append(zEquals2 ? str8 : kggugdpVar.getString(R.string.parts_meta_slot, str8, str7));
                                TextView textViewOxoagud4 = x.zamkzqg.oxoagud(kggugdpVar, sb2.toString(), 12, x.zamkzqg.jbmzxye(kggugdpVar), false);
                                textViewOxoagud4.setPadding(0, x.zamkzqg.qunltjs(kggugdpVar, 4), 0, 0);
                                linearLayoutZwaqeaz.addView(textViewOxoagud4);
                                linearLayoutXbdyiew.addView(linearLayoutZwaqeaz, x.zamkzqg.uiqyzsp(kggugdpVar));
                                LinearLayout linearLayoutZwaqeaz2 = x.zamkzqg.zwaqeaz(kggugdpVar);
                                linearLayoutZwaqeaz2.addView(x.zamkzqg.ysaclsr(kggugdpVar, R.string.parts_info));
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_name, str6);
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_size, kggugdpVar.getString(R.string.parts_size_exact, x.zamkzqg.jybecxv(j4), Long.valueOf(j4)));
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_region, str8);
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_start_address, ohwxijwVar2.ojyssqt);
                                x.zamkzqg.sthdtww(kggugdpVar, linearLayoutZwaqeaz2, R.string.parts_slot, str7);
                                linearLayoutXbdyiew.addView(linearLayoutZwaqeaz2, x.zamkzqg.uiqyzsp(kggugdpVar));
                                int iNmpwovh2 = x.zamkzqg.nmpwovh(kggugdpVar);
                                final int i7 = 2;
                                TextView textViewLclupha2 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_backup_partition), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i7) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha2, R.drawable.ic_backup, iNmpwovh2);
                                textViewLclupha2.setTextColor(x.zamkzqg.nmpwovh(kggugdpVar));
                                linearLayoutXbdyiew.addView(textViewLclupha2, new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 50)));
                                int iOhwxijw = x.zamkzqg.ohwxijw(kggugdpVar);
                                final int i8 = 3;
                                TextView textViewLclupha3 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_flash_image), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i8) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha3, R.drawable.ic_flash, iOhwxijw);
                                textViewLclupha3.setTextColor(x.zamkzqg.ohwxijw(kggugdpVar));
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 50));
                                layoutParams.topMargin = x.zamkzqg.qunltjs(kggugdpVar, 8);
                                linearLayoutXbdyiew.addView(textViewLclupha3, layoutParams);
                                int iPzqxblc = x.zamkzqg.pzqxblc(kggugdpVar);
                                final int i9 = 0;
                                TextView textViewLclupha4 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_erase_partition), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i9) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha4, R.drawable.ic_erase, iPzqxblc);
                                textViewLclupha4.setTextColor(x.zamkzqg.pzqxblc(kggugdpVar));
                                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 50));
                                layoutParams2.topMargin = x.zamkzqg.qunltjs(kggugdpVar, 8);
                                linearLayoutXbdyiew.addView(textViewLclupha4, layoutParams2);
                                int iJbmzxye = x.zamkzqg.jbmzxye(kggugdpVar);
                                final int i10 = 1;
                                TextView textViewLclupha5 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_copy_address), new View.OnClickListener() { // from class: x.uzyihoe
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i10) {
                                            case 0:
                                                xbdyiew xbdyiewVar3 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar3 = ohwxijwVar2;
                                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                                if (kggugdpVar2.wjugzfh()) {
                                                    if (kggugdpVar2.lpkdqgx || kggugdpVar2.ywhgqsi) {
                                                        Toast.makeText(kggugdpVar2, R.string.error_busy, 0).show();
                                                    } else {
                                                        EditText editText2 = new EditText(kggugdpVar2);
                                                        editText2.setSingleLine(true);
                                                        editText2.setHint(kggugdpVar2.getString(R.string.parts_erase_type_hint, ohwxijwVar3.nmpwovh));
                                                        editText2.setInputType(1);
                                                        int iDasxvpc = kggugdpVar2.dasxvpc(16);
                                                        editText2.setPadding(iDasxvpc, iDasxvpc, iDasxvpc, iDasxvpc);
                                                        AlertDialog alertDialogCreate = new AlertDialog.Builder(kggugdpVar2).setTitle(R.string.parts_erase_confirm_title).setMessage(kggugdpVar2.getString(R.string.parts_erase_confirm_message, ohwxijwVar3.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar3.vivhedu), ohwxijwVar3.lthborb, ohwxijwVar3.nmpwovh)).setView(editText2).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_erase_action, (DialogInterface.OnClickListener) null).create();
                                                        alertDialogCreate.setOnShowListener(new hjlrtqw(alertDialogCreate, editText2, kggugdpVar2, ohwxijwVar3));
                                                        alertDialogCreate.show();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                kggugdp kggugdpVar3 = xbdyiewVar2.nmpwovh;
                                                ClipboardManager clipboardManager = (ClipboardManager) kggugdpVar3.getSystemService("clipboard");
                                                if (clipboardManager != null) {
                                                    clipboardManager.setPrimaryClip(ClipData.newPlainText(kggugdpVar3.getString(R.string.parts_address_clip_label), ohwxijwVar2.ojyssqt));
                                                }
                                                Toast.makeText(kggugdpVar3, R.string.parts_address_copied, 0).show();
                                                break;
                                            case 2:
                                                xbdyiewVar2.nmpwovh.enxkjpu(ohwxijwVar2);
                                                break;
                                            default:
                                                xbdyiew xbdyiewVar4 = xbdyiewVar2;
                                                ohwxijw ohwxijwVar4 = ohwxijwVar2;
                                                kggugdp kggugdpVar4 = xbdyiewVar4.nmpwovh;
                                                kggugdpVar4.ezuzoct = ohwxijwVar4;
                                                kggugdpVar4.lvtqoqa();
                                                kggugdpVar4.nhhacgu("flash");
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha5, R.drawable.ic_copy, iJbmzxye);
                                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, x.zamkzqg.qunltjs(kggugdpVar, 46));
                                layoutParams3.topMargin = x.zamkzqg.qunltjs(kggugdpVar, 8);
                                linearLayoutXbdyiew.addView(textViewLclupha5, layoutParams3);
                                LinearLayout linearLayoutZwaqeaz3 = x.zamkzqg.zwaqeaz(kggugdpVar);
                                linearLayoutZwaqeaz3.setBackground(x.zamkzqg.jvtqflj(kggugdpVar, x.zamkzqg.tmdubwv(kggugdpVar, str5), x.zamkzqg.cugubfc(kggugdpVar, str5), x.zamkzqg.qunltjs(kggugdpVar, x.zamkzqg.nhhacgu(kggugdpVar))));
                                if (ohwxijwVar2.nmpwovh()) {
                                    i6 = R.string.parts_red_warning;
                                } else {
                                    i6 = "yellow".equals(str5) ? R.string.parts_yellow_warning : R.string.parts_green_note;
                                }
                                TextView textViewOxoagud5 = x.zamkzqg.oxoagud(kggugdpVar, kggugdpVar.getString(i6), 12, x.zamkzqg.cugubfc(kggugdpVar, str5), ohwxijwVar2.nkemejx);
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewOxoagud5, "green".equals(str5) ? R.drawable.ic_partition : R.drawable.ic_warning, x.zamkzqg.cugubfc(kggugdpVar, str5));
                                textViewOxoagud5.setLineSpacing(0.0f, 1.12f);
                                linearLayoutZwaqeaz3.addView(textViewOxoagud5);
                                linearLayoutXbdyiew.addView(linearLayoutZwaqeaz3, x.zamkzqg.uiqyzsp(kggugdpVar));
                                kggugdpVar.kffvigz(scrollView, "partition_details");
                                break;
                            case 1:
                                xbdyiewVar.nmpwovh.enxkjpu(ohwxijwVar);
                                break;
                            default:
                                xbdyiew xbdyiewVar3 = xbdyiewVar;
                                ohwxijw ohwxijwVar3 = ohwxijwVar;
                                kggugdp kggugdpVar2 = xbdyiewVar3.nmpwovh;
                                kggugdpVar2.ezuzoct = ohwxijwVar3;
                                kggugdpVar2.lvtqoqa();
                                kggugdpVar2.nhhacgu("flash");
                                break;
                        }
                    }
                });
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.partition_compact_action_size);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.partition_compact_action_gap);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.setMargins(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, 0);
                linearLayoutLvtqoqa2.addView(textViewBtazysh, layoutParams);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams2.setMargins(dimensionPixelSize2, dimensionPixelSize2, 0, 0);
                linearLayoutLvtqoqa2.addView(textViewBtazysh2, layoutParams2);
                linearLayout3.addView(linearLayoutLvtqoqa2);
                linearLayout2.addView(linearLayout3, x.zamkzqg.uiqyzsp(this));
                lowerCase = str3;
                it = it2;
                j = 0;
            }
        }
        if (this.nsbgblf != null) {
            if (!this.jbmzxye.isEmpty()) {
                if ("red".equals(this.sdchfks)) {
                    string = getString(R.string.parts_filter_red);
                } else {
                    string = "yellow".equals(this.sdchfks) ? getString(R.string.parts_filter_yellow) : getString(R.string.parts_filter_green);
                }
                this.nsbgblf.setText(getString(R.string.parts_risk_summary, string, Integer.valueOf(i2), x.zamkzqg.jybecxv(j2)));
                this.nsbgblf.setTextColor(x.zamkzqg.cugubfc(this, this.sdchfks));
            } else if (this.ywhgqsi) {
                this.nsbgblf.setText(R.string.parts_reading);
                this.nsbgblf.setTextColor(this.oqexvyb);
            } else if (this.nsyqsfj) {
                this.nsbgblf.setText(R.string.parts_none_loaded);
                this.nsbgblf.setTextColor(this.dytyqos);
            } else {
                this.nsbgblf.setText(R.string.parts_offline_summary);
                this.nsbgblf.setTextColor(this.dytyqos);
            }
        }
        if (this.jbmzxye.isEmpty() || i2 != 0) {
            return;
        }
        TextView textViewOxoagud3 = x.zamkzqg.oxoagud(this, getString(R.string.parts_none_match), 13, this.dytyqos, false);
        textViewOxoagud3.setGravity(17);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ui_card_padding_vertical);
        textViewOxoagud3.setPadding(0, dimensionPixelSize3, 0, dimensionPixelSize3);
        this.gjpruie.addView(textViewOxoagud3);
    }

    public final void saksmfq() {
        if (!this.nsyqsfj) {
            Toast.makeText(this, R.string.error_da_not_ready, 0).show();
            return;
        }
        if (this.ywhgqsi || this.lpkdqgx) {
            Toast.makeText(this, R.string.error_busy, 0).show();
            return;
        }
        if (!qyeibyo()) {
            Toast.makeText(this, R.string.error_usb_unavailable, 0).show();
            return;
        }
        this.jbmzxye.clear();
        this.ezuzoct = null;
        rvrflql();
        this.ywhgqsi = true;
        this.lpkdqgx = true;
        TextView textView = this.nsbgblf;
        if (textView != null) {
            textView.setText(R.string.parts_reading);
            this.nsbgblf.setTextColor(this.oqexvyb);
        }
        exhiehf(this.npkgpdo, false);
        gefzxcg();
        ((MainActivity) this).nmpwovh(getString(R.string.log_parts_reading));
        this.slxntng.execute(new vntpaom(this, yjbrzgu("da_path"), yjbrzgu("auth_path"), yjbrzgu("preloader_path"), 7));
    }

    public final void tmdubwv(ArrayList arrayList) {
        if (arrayList.isEmpty() || !wjugzfh()) {
            return;
        }
        kpmmknm(arrayList.size(), true);
        this.lpkdqgx = true;
        this.ygdccqg = "WRITE";
        gefzxcg();
        this.slxntng.execute(new hhqpjvl(this, (Object) arrayList, yjbrzgu("da_path"), yjbrzgu("auth_path"), yjbrzgu("preloader_path"), 1));
    }

    public final File tnejqcj(ArrayList arrayList) throws IOException {
        ohwxijw ohwxijwVar;
        if (this.wdznaie == null) {
            throw new IOException(getString(R.string.scatter_no_file));
        }
        if (arrayList.isEmpty()) {
            throw new IOException("Firmware Upgrade review contains no payloads");
        }
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            araemok araemokVar = (araemok) it.next();
            if (araemokVar == null || (ohwxijwVar = araemokVar.nmpwovh) == null || araemokVar.ojyssqt == null) {
                throw new IOException("Firmware Upgrade review contains an invalid payload");
            }
            String str = ohwxijwVar.nmpwovh;
            String strPzqxblc = com.rynx.app.ojyssqt.pzqxblc(str);
            if (strPzqxblc.isEmpty() || map.put(strPzqxblc, araemokVar) != null) {
                throw new IOException("Firmware Upgrade review contains a duplicate payload: " + str);
            }
        }
        int i = 0;
        for (aqyicql aqyicqlVar : (java.util.ArrayList<aqyicql>) this.wdznaie.nkemejx) {
            if (com.rynx.app.ojyssqt.atntgcp(aqyicqlVar)) {
                i++;
                araemok araemokVar2 = (araemok) map.get(com.rynx.app.ojyssqt.pzqxblc(aqyicqlVar.ojyssqt));
                String str2 = aqyicqlVar.ojyssqt;
                if (araemokVar2 == null) {
                    throw new IOException("Firmware Upgrade review is missing payload: " + str2);
                }
                if (!x.pwjmwpv.vntpaom(this.wdznaie, aqyicqlVar).getCanonicalFile().equals(araemokVar2.ojyssqt.getCanonicalFile())) {
                    throw new IOException("Firmware Upgrade image changed after review: " + str2);
                }
            }
        }
        if (i != map.size()) {
            throw new IOException("Firmware Upgrade review contains a payload not present in the scatter");
        }
        File canonicalFile = this.wdznaie.nmpwovh.getCanonicalFile();
        if (!canonicalFile.isFile() || !canonicalFile.canRead()) {
            throw new IOException("Scatter source is no longer readable");
        }
        File fileCreateTempFile = File.createTempFile("rynx-fwupgrade-", ".plan", getCacheDir());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile, false);
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                try {
                    dataOutputStream.write("RYNXFWU2!".getBytes(StandardCharsets.US_ASCII));
                    dataOutputStream.writeInt(2);
                    com.rynx.app.ojyssqt.btazysh(dataOutputStream, canonicalFile.getCanonicalPath(), 4096, "scatter path");
                    com.rynx.app.ojyssqt.btazysh(dataOutputStream, this.wdznaie.vivhedu, 256, "platform");
                    com.rynx.app.ojyssqt.btazysh(dataOutputStream, this.wdznaie.qxvquar, 64, "storage");
                    dataOutputStream.writeLong(this.wdznaie.oqexvyb);
                    dataOutputStream.writeLong(canonicalFile.length());
                    dataOutputStream.writeLong(canonicalFile.lastModified());
                    dataOutputStream.writeInt(this.wdznaie.nkemejx.size());
                    for (aqyicql aqyicqlVar2 : (java.util.ArrayList<aqyicql>) this.wdznaie.nkemejx) {
                        boolean zAtntgcp = com.rynx.app.ojyssqt.atntgcp(aqyicqlVar2);
                        String canonicalPath = zAtntgcp ? x.pwjmwpv.vntpaom(this.wdznaie, aqyicqlVar2).getCanonicalPath() : "";
                        com.rynx.app.ojyssqt.btazysh(dataOutputStream, aqyicqlVar2.ojyssqt, 128, "partition name");
                        com.rynx.app.ojyssqt.btazysh(dataOutputStream, canonicalPath, 4096, "image path");
                        com.rynx.app.ojyssqt.btazysh(dataOutputStream, aqyicqlVar2.dasxvpc, 64, "operation type");
                        com.rynx.app.ojyssqt.btazysh(dataOutputStream, aqyicqlVar2.nkemejx, 64, "region");
                        com.rynx.app.ojyssqt.btazysh(dataOutputStream, aqyicqlVar2.imuemzb, 64, "entry storage");
                        dataOutputStream.writeLong(aqyicqlVar2.qxvquar);
                        dataOutputStream.writeLong(aqyicqlVar2.oqexvyb);
                        File file = canonicalPath.isEmpty() ? null : new File(canonicalPath);
                        long jLastModified = 0;
                        dataOutputStream.writeLong(file == null ? 0L : file.length());
                        if (file != null) {
                            jLastModified = file.lastModified();
                        }
                        dataOutputStream.writeLong(jLastModified);
                        dataOutputStream.writeByte(((this.lsgjyur && "seccfg".equalsIgnoreCase(aqyicqlVar2.ojyssqt)) ? 8 : 0) | (zAtntgcp ? 1 : 0) | (aqyicqlVar2.wqrnifx ? 2 : 0) | (aqyicqlVar2.dytyqos ? 4 : 0));
                    }
                    dataOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    dataOutputStream.close();
                    fileOutputStream.close();
                    return fileCreateTempFile;
                } catch (Throwable th) {
                    try {
                        dataOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                fileCreateTempFile.delete();
            }
            throw th5;
        }
    }

    public final boolean udgizdi() {
        if (this.cnctlxz == null || this.cnctlxz.lthborb == null) {
            return false;
        }
        String upperCase = this.cnctlxz.lthborb.trim().toUpperCase(Locale.ROOT);
        return upperCase.contains("XML") && upperCase.contains("V6");
    }

    @Override // com.rynx.app.ojyssqt
    public final ScrollView vivhedu() {
        final xbdyiew xbdyiewVar = new xbdyiew(this);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setBackgroundColor(x.zamkzqg.buswjhz(this));
        LinearLayout linearLayoutXbdyiew = x.zamkzqg.xbdyiew(this, 16);
        scrollView.addView(linearLayoutXbdyiew);
        LinearLayout linearLayoutLvtqoqa = x.zamkzqg.lvtqoqa(this);
        linearLayoutLvtqoqa.setGravity(16);
        linearLayoutLvtqoqa.addView(x.zamkzqg.ywhgqsi(this, getString(R.string.parts_title)), new LinearLayout.LayoutParams(0, -2, 1.0f));
        final int i = 0;
        TextView textViewBtazysh = x.zamkzqg.btazysh(this, R.drawable.ic_refresh, x.zamkzqg.nmpwovh(this), R.string.action_refresh, new View.OnClickListener() { // from class: x.ygdccqg
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        xbdyiewVar.nmpwovh.saksmfq();
                        break;
                    default:
                        kggugdp kggugdpVar = xbdyiewVar.nmpwovh;
                        if (kggugdpVar.wjugzfh()) {
                            if (kggugdpVar.lpkdqgx || kggugdpVar.ywhgqsi) {
                                Toast.makeText(kggugdpVar, R.string.error_busy, 0).show();
                            } else if (!kggugdpVar.jbmzxye.isEmpty()) {
                                final mcdstyz mcdstyzVar = new mcdstyz(kggugdpVar);
                                ScrollView scrollView2 = new ScrollView(kggugdpVar);
                                scrollView2.setFillViewport(true);
                                LinearLayout linearLayoutXbdyiew2 = x.zamkzqg.xbdyiew(kggugdpVar, 16);
                                scrollView2.addView(linearLayoutXbdyiew2);
                                int iNmpwovh = x.zamkzqg.nmpwovh(kggugdpVar);
                                final int i2 = 0;
                                TextView textViewLclupha = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_title), new View.OnClickListener() { // from class: x.udgizdi
                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r10v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v1 */
                                    /* JADX WARN: Type inference failed for: r13v11 */
                                    /* JADX WARN: Type inference failed for: r13v9 */
                                    /* JADX WARN: Type inference failed for: r15v13 */
                                    /* JADX WARN: Type inference failed for: r15v14 */
                                    /* JADX WARN: Type inference failed for: r15v5, types: [android.widget.ScrollView] */
                                    /* JADX WARN: Type inference failed for: r15v6 */
                                    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r20v1, types: [android.view.ViewGroup] */
                                    /* JADX WARN: Type inference failed for: r20v2 */
                                    /* JADX WARN: Type inference failed for: r26v0, types: [android.view.View] */
                                    /* JADX WARN: Type inference failed for: r26v1 */
                                    /* JADX WARN: Type inference failed for: r3v2, types: [android.app.Activity, android.content.Context, com.rynx.app.nmpwovh, com.rynx.app.ojyssqt, java.lang.Object, x.kggugdp] */
                                    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r6v18, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i2) {
                                            case 0:
                                                mcdstyzVar.nmpwovh.buswjhz();
                                                break;
                                            case 1:
                                                final kggugdp r3 = mcdstyzVar.nmpwovh;
                                                if (r3.wjugzfh()) {
                                                    if (!r3.lpkdqgx && !r3.ywhgqsi) {
                                                        if (r3.jbmzxye.isEmpty()) {
                                                            Toast.makeText((Context) r3, R.string.error_reading_partition_first, 0).show();
                                                            break;
                                                        } else if (r3.wjugzfh()) {
                                                            ArrayList arrayList = new ArrayList();
                                                            int i3 = 0;
                                                            while (true) {
                                                                ArrayList arrayList2 = r3.jbmzxye;
                                                                if (i3 >= arrayList2.size()) {
                                                                    mcdstyz mcdstyzVar2 = new mcdstyz(r3);
                                                                    LinearLayout linearLayout = new LinearLayout(r3);
                                                                    linearLayout.setOrientation(1);
                                                                    linearLayout.setBackgroundColor(x.zamkzqg.buswjhz(r3));
                                                                    LinearLayout linearLayout2 = new LinearLayout(r3);
                                                                    linearLayout2.setOrientation(1);
                                                                    linearLayout2.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
                                                                    LinearLayout linearLayoutLvtqoqa2 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa2.setGravity(16);
                                                                    linearLayoutLvtqoqa2.addView(x.zamkzqg.btazysh(r3, R.drawable.ic_back, x.zamkzqg.nmpwovh(r3), R.string.batch_hub_title, new nmpwovh(mcdstyzVar2, 3)), new LinearLayout.LayoutParams(r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
                                                                    TextView textViewOxoagud = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_title), 20, x.zamkzqg.zngzleo(r3), true);
                                                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                    layoutParams.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa2.addView(textViewOxoagud, layoutParams);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa2);
                                                                    LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa3.setGravity(16);
                                                                    TextView textViewOxoagud2 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_selected_count, 0), 11, x.zamkzqg.jbmzxye(r3), true);
                                                                    textViewOxoagud2.setGravity(17);
                                                                    textViewOxoagud2.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
                                                                    textViewOxoagud2.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    linearLayoutLvtqoqa3.addView(textViewOxoagud2);
                                                                    linearLayoutLvtqoqa3.addView(new View(r3), new LinearLayout.LayoutParams(0, 1, 1.0f));
                                                                    String string = r3.getString(R.string.batch_backup_action_compact, 0);
                                                                    int iKggugdp = x.zamkzqg.kggugdp(r3);
                                                                    TextView textViewLclupha2 = x.zamkzqg.lclupha(r3, string, null);
                                                                    x.zamkzqg.enxkjpu(r3, textViewLclupha2, R.drawable.ic_backup, iKggugdp);
                                                                    textViewLclupha2.setTextColor(x.zamkzqg.kggugdp(r3));
                                                                    textViewLclupha2.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.ojyssqt(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    textViewLclupha2.setEnabled(false);
                                                                    textViewLclupha2.setAlpha(0.42f);
                                                                    linearLayoutLvtqoqa3.addView(textViewLclupha2, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams2.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa3, layoutParams2);
                                                                    linearLayout.addView(linearLayout2);
                                                                    ScrollView scrollView3 = new ScrollView(r3);
                                                                    scrollView3.setFillViewport(true);
                                                                    LinearLayout linearLayout3 = new LinearLayout(r3);
                                                                    linearLayout3.setOrientation(1);
                                                                    linearLayout3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
                                                                    scrollView3.addView(linearLayout3);
                                                                    linearLayout3.addView(x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_subtitle), 11, x.zamkzqg.jbmzxye(r3), false));
                                                                    EditText editText = new EditText(r3);
                                                                    editText.setSingleLine(true);
                                                                    editText.setTextColor(x.zamkzqg.zngzleo(r3));
                                                                    editText.setHintTextColor(x.zamkzqg.jbmzxye(r3));
                                                                    editText.setHint(R.string.batch_backup_search_hint);
                                                                    editText.setTextSize(13.0f);
                                                                    editText.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0, r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0);
                                                                    editText.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.ui_field_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, 0, 0);
                                                                    editText.setCompoundDrawablePadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap));
                                                                    editText.setCompoundDrawableTintList(ColorStateList.valueOf(x.zamkzqg.jbmzxye(r3)));
                                                                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.batch_backup_search_height));
                                                                    layoutParams3.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams3.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    linearLayout3.addView(editText, layoutParams3);
                                                                    final String[] strArr = {"green"};
                                                                    ghkjjru ghkjjruVarJdqigmr = x.zamkzqg.jdqigmr(r3, strArr[0], new jtfjrri(strArr, 0));
                                                                    linearLayout3.addView((LinearLayout) ghkjjruVarJdqigmr.nmpwovh, new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.risk_segment_container_height)));
                                                                    LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa4.setGravity(8388613);
                                                                    TextView textViewLclupha3 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_select_visible_short), null);
                                                                    textViewLclupha3.setTextSize(10.0f);
                                                                    TextView textViewLclupha4 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_clear), null);
                                                                    textViewLclupha4.setTextSize(10.0f);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha3, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height));
                                                                    layoutParams4.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha4, layoutParams4);
                                                                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams5.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams5.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top);
                                                                    linearLayout3.addView(linearLayoutLvtqoqa4, layoutParams5);
                                                                    final LinearLayout linearLayout4 = new LinearLayout(r3);
                                                                    linearLayout4.setOrientation(1);
                                                                    linearLayout3.addView(linearLayout4);
                                                                    ArrayList arrayList3 = new ArrayList();
                                                                    final boolean[] zArr = {false};
                                                                    ArrayList arrayList4 = arrayList3;
                                                                    final vntpaom vntpaomVar = new vntpaom(arrayList3, textViewOxoagud2, (Object) r3, textViewLclupha2, 3);
                                                                    final hhqpjvl hhqpjvlVar = new hhqpjvl(editText, arrayList4, strArr, (Object) r3, ghkjjruVarJdqigmr, 2);
                                                                    final int i4 = 0;
                                                                    ((TextView) ghkjjruVarJdqigmr.ojyssqt).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i4) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i5 = 1;
                                                                    ((TextView) ghkjjruVarJdqigmr.vivhedu).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i5) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i6 = 2;
                                                                    ((TextView) ghkjjruVarJdqigmr.lthborb).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i6) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    int[][] iArr = {new int[]{android.R.attr.state_checked}, new int[]{-16842912}};
                                                                    Iterator it = arrayList.iterator();
                                                                    LinearLayout r13 = linearLayout;
                                                                    ScrollView r15 = scrollView3;
                                                                    while (it.hasNext()) {
                                                                        final eenkamx eenkamxVar = (eenkamx) it.next();
                                                                        final LinearLayout linearLayout5 = new LinearLayout(r3);
                                                                        linearLayout5.setOrientation(0);
                                                                        linearLayout5.setGravity(16);
                                                                        linearLayout5.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
                                                                        String str = eenkamxVar.oqexvyb;
                                                                        linearLayout5.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_row_radius, r3, x.zamkzqg.tmdubwv(r3, str), x.zamkzqg.cugubfc(r3, str)));
                                                                        CheckBox checkBox = new CheckBox(r3);
                                                                        String str2 = eenkamxVar.oqexvyb;
                                                                        checkBox.setButtonTintList(new ColorStateList(iArr, new int[]{x.zamkzqg.cugubfc(r3, str2), x.zamkzqg.jbmzxye(r3)}));
                                                                        String str3 = eenkamxVar.ojyssqt;
                                                                        checkBox.setContentDescription(str3);
                                                                        linearLayout5.addView(checkBox);
                                                                        LinearLayout linearLayout6 = new LinearLayout(r3);
                                                                        linearLayout6.setOrientation(1);
                                                                        LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(r3);
                                                                        int[][] iArr2 = iArr;
                                                                        linearLayoutLvtqoqa5.setGravity(16);
                                                                        Iterator it2 = it;
                                                                        LinearLayout r20 = r13;
                                                                        mcdstyz mcdstyzVar3 = mcdstyzVar2;
                                                                        ScrollView r26 = r15;
                                                                        linearLayoutLvtqoqa5.addView(x.zamkzqg.oxoagud(r3, str3, 13, x.zamkzqg.zngzleo(r3), true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                                                                        TextView textViewOxoagud3 = x.zamkzqg.oxoagud(r3, r3.getString("red".equals(str2) ? R.string.parts_risk_red : "yellow".equals(str2) ? R.string.parts_risk_yellow : R.string.parts_risk_green), 9, x.zamkzqg.cugubfc(r3, str2), true);
                                                                        TextView textView = textViewLclupha3;
                                                                        textViewOxoagud3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
                                                                        textViewOxoagud3.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_badge_radius, r3, x.zamkzqg.tmdubwv(r3, str2), r3.getColor(R.color.rynx_transparent)));
                                                                        linearLayoutLvtqoqa5.addView(textViewOxoagud3);
                                                                        linearLayout6.addView(linearLayoutLvtqoqa5);
                                                                        String str4 = eenkamxVar.qxvquar;
                                                                        boolean zEquals = "—".equals(str4);
                                                                        String str5 = eenkamxVar.lthborb;
                                                                        String str6 = eenkamxVar.vivhedu;
                                                                        TextView textViewOxoagud4 = x.zamkzqg.oxoagud(r3, zEquals ? r3.getString(R.string.batch_backup_partition_meta, str6, str5) : r3.getString(R.string.batch_backup_partition_meta_slot, str6, str5, str4), 10, x.zamkzqg.jbmzxye(r3), false);
                                                                        textViewOxoagud4.setPadding(0, r3.getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                                                                        linearLayout6.addView(textViewOxoagud4);
                                                                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                        layoutParams6.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap);
                                                                        linearLayout5.addView(linearLayout6, layoutParams6);
                                                                        ArrayList arrayList5 = arrayList4;
                                                                        arrayList5.add(new rpdxrib(eenkamxVar, linearLayout5, checkBox, (str3 + " " + str5 + " " + str4).toLowerCase(Locale.ROOT)));
                                                                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                                                                        int dimensionPixelSize = r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_gap);
                                                                        layoutParams7.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                                                                        linearLayout4.addView(linearLayout5, layoutParams7);
                                                                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: x.marclvq
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                                                                String str7 = eenkamxVar.oqexvyb;
                                                                                com.rynx.app.nmpwovh nmpwovhVar = r3;
                                                                                LinearLayout linearLayout7 = linearLayout5;
                                                                                linearLayout7.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar, x.zamkzqg.tmdubwv(nmpwovhVar, str7), z ? x.zamkzqg.nmpwovh(nmpwovhVar) : x.zamkzqg.cugubfc(nmpwovhVar, str7), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_radius)));
                                                                                if (zArr[0]) {
                                                                                    return;
                                                                                }
                                                                                x.zfmpmio.ojyssqt(linearLayout7);
                                                                                vntpaomVar.run();
                                                                            }
                                                                        });
                                                                        x.zamkzqg.utmeivs(r3, linearLayout5);
                                                                        linearLayout5.setOnClickListener(new mamlotu(checkBox, 0));
                                                                        arrayList4 = arrayList5;
                                                                        iArr = iArr2;
                                                                        it = it2;
                                                                        r13 = r20;
                                                                        r15 = r26;
                                                                        mcdstyzVar2 = mcdstyzVar3;
                                                                        textViewLclupha3 = textView;
                                                                    }
                                                                    LinearLayout r21 = r13;
                                                                    final ArrayList arrayList6 = arrayList4;
                                                                    final int i7 = 0;
                                                                    editText.addTextChangedListener(new xvxmcgn(hhqpjvlVar, 0));
                                                                    textViewLclupha3.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i7) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i8 = 1;
                                                                    textViewLclupha4.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i8) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    textViewLclupha2.setOnClickListener(new pzqxblc(arrayList6, mcdstyzVar2, i8));
                                                                    linearLayout3.addView(new View(r3), new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                                                                    vntpaomVar.run();
                                                                    hhqpjvlVar.run();
                                                                    r21.addView(r15, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                                                                    r3.kffvigz(r21, "batch_backup_selector");
                                                                } else {
                                                                    ohwxijw ohwxijwVar = (ohwxijw) arrayList2.get(i3);
                                                                    arrayList.add(new eenkamx(i3, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar.vivhedu), ohwxijwVar.lthborb, ohwxijwVar.qxvquar, ohwxijwVar.oqexvyb));
                                                                    i3++;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        Toast.makeText((Context) r3, R.string.error_busy, 0).show();
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                mcdstyzVar.nmpwovh.vopsyhw("all");
                                                break;
                                            default:
                                                mcdstyzVar.nmpwovh.gzokllk();
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha, R.drawable.ic_back, iNmpwovh);
                                textViewLclupha.setGravity(8388627);
                                linearLayoutXbdyiew2.addView(textViewLclupha);
                                linearLayoutXbdyiew2.addView(x.zamkzqg.ywhgqsi(kggugdpVar, kggugdpVar.getString(R.string.batch_hub_title)));
                                TextView textViewOxoagud = x.zamkzqg.oxoagud(kggugdpVar, kggugdpVar.getString(R.string.batch_hub_subtitle), 12, x.zamkzqg.jbmzxye(kggugdpVar), false);
                                textViewOxoagud.setPadding(0, 0, 0, kggugdpVar.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom));
                                linearLayoutXbdyiew2.addView(textViewOxoagud);
                                final int i3 = 1;
                                linearLayoutXbdyiew2.addView(x.zamkzqg.yojulhu(kggugdpVar, R.string.batch_hub_backup_title, R.string.batch_hub_backup_desc, R.drawable.ic_backup, R.string.parts_backup_multiple, x.zamkzqg.nmpwovh(kggugdpVar), new View.OnClickListener() { // from class: x.udgizdi
                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r10v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v1 */
                                    /* JADX WARN: Type inference failed for: r13v11 */
                                    /* JADX WARN: Type inference failed for: r13v9 */
                                    /* JADX WARN: Type inference failed for: r15v13 */
                                    /* JADX WARN: Type inference failed for: r15v14 */
                                    /* JADX WARN: Type inference failed for: r15v5, types: [android.widget.ScrollView] */
                                    /* JADX WARN: Type inference failed for: r15v6 */
                                    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r20v1, types: [android.view.ViewGroup] */
                                    /* JADX WARN: Type inference failed for: r20v2 */
                                    /* JADX WARN: Type inference failed for: r26v0, types: [android.view.View] */
                                    /* JADX WARN: Type inference failed for: r26v1 */
                                    /* JADX WARN: Type inference failed for: r3v2, types: [android.app.Activity, android.content.Context, com.rynx.app.nmpwovh, com.rynx.app.ojyssqt, java.lang.Object, x.kggugdp] */
                                    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r6v18, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i3) {
                                            case 0:
                                                mcdstyzVar.nmpwovh.buswjhz();
                                                break;
                                            case 1:
                                                final kggugdp r3 = mcdstyzVar.nmpwovh;
                                                if (r3.wjugzfh()) {
                                                    if (!r3.lpkdqgx && !r3.ywhgqsi) {
                                                        if (r3.jbmzxye.isEmpty()) {
                                                            Toast.makeText((Context) r3, R.string.error_reading_partition_first, 0).show();
                                                            break;
                                                        } else if (r3.wjugzfh()) {
                                                            ArrayList arrayList = new ArrayList();
                                                            int i4 = 0;
                                                            while (true) {
                                                                ArrayList arrayList2 = r3.jbmzxye;
                                                                if (i4 >= arrayList2.size()) {
                                                                    mcdstyz mcdstyzVar2 = new mcdstyz(r3);
                                                                    LinearLayout linearLayout = new LinearLayout(r3);
                                                                    linearLayout.setOrientation(1);
                                                                    linearLayout.setBackgroundColor(x.zamkzqg.buswjhz(r3));
                                                                    LinearLayout linearLayout2 = new LinearLayout(r3);
                                                                    linearLayout2.setOrientation(1);
                                                                    linearLayout2.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
                                                                    LinearLayout linearLayoutLvtqoqa2 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa2.setGravity(16);
                                                                    linearLayoutLvtqoqa2.addView(x.zamkzqg.btazysh(r3, R.drawable.ic_back, x.zamkzqg.nmpwovh(r3), R.string.batch_hub_title, new nmpwovh(mcdstyzVar2, 3)), new LinearLayout.LayoutParams(r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
                                                                    TextView textViewOxoagud2 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_title), 20, x.zamkzqg.zngzleo(r3), true);
                                                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                    layoutParams.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa2.addView(textViewOxoagud2, layoutParams);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa2);
                                                                    LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa3.setGravity(16);
                                                                    TextView textViewOxoagud3 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_selected_count, 0), 11, x.zamkzqg.jbmzxye(r3), true);
                                                                    textViewOxoagud3.setGravity(17);
                                                                    textViewOxoagud3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
                                                                    textViewOxoagud3.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    linearLayoutLvtqoqa3.addView(textViewOxoagud3);
                                                                    linearLayoutLvtqoqa3.addView(new View(r3), new LinearLayout.LayoutParams(0, 1, 1.0f));
                                                                    String string = r3.getString(R.string.batch_backup_action_compact, 0);
                                                                    int iKggugdp = x.zamkzqg.kggugdp(r3);
                                                                    TextView textViewLclupha2 = x.zamkzqg.lclupha(r3, string, null);
                                                                    x.zamkzqg.enxkjpu(r3, textViewLclupha2, R.drawable.ic_backup, iKggugdp);
                                                                    textViewLclupha2.setTextColor(x.zamkzqg.kggugdp(r3));
                                                                    textViewLclupha2.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.ojyssqt(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    textViewLclupha2.setEnabled(false);
                                                                    textViewLclupha2.setAlpha(0.42f);
                                                                    linearLayoutLvtqoqa3.addView(textViewLclupha2, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams2.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa3, layoutParams2);
                                                                    linearLayout.addView(linearLayout2);
                                                                    ScrollView scrollView3 = new ScrollView(r3);
                                                                    scrollView3.setFillViewport(true);
                                                                    LinearLayout linearLayout3 = new LinearLayout(r3);
                                                                    linearLayout3.setOrientation(1);
                                                                    linearLayout3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
                                                                    scrollView3.addView(linearLayout3);
                                                                    linearLayout3.addView(x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_subtitle), 11, x.zamkzqg.jbmzxye(r3), false));
                                                                    EditText editText = new EditText(r3);
                                                                    editText.setSingleLine(true);
                                                                    editText.setTextColor(x.zamkzqg.zngzleo(r3));
                                                                    editText.setHintTextColor(x.zamkzqg.jbmzxye(r3));
                                                                    editText.setHint(R.string.batch_backup_search_hint);
                                                                    editText.setTextSize(13.0f);
                                                                    editText.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0, r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0);
                                                                    editText.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.ui_field_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, 0, 0);
                                                                    editText.setCompoundDrawablePadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap));
                                                                    editText.setCompoundDrawableTintList(ColorStateList.valueOf(x.zamkzqg.jbmzxye(r3)));
                                                                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.batch_backup_search_height));
                                                                    layoutParams3.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams3.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    linearLayout3.addView(editText, layoutParams3);
                                                                    final String[] strArr = {"green"};
                                                                    ghkjjru ghkjjruVarJdqigmr = x.zamkzqg.jdqigmr(r3, strArr[0], new jtfjrri(strArr, 0));
                                                                    linearLayout3.addView((LinearLayout) ghkjjruVarJdqigmr.nmpwovh, new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.risk_segment_container_height)));
                                                                    LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa4.setGravity(8388613);
                                                                    TextView textViewLclupha3 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_select_visible_short), null);
                                                                    textViewLclupha3.setTextSize(10.0f);
                                                                    TextView textViewLclupha4 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_clear), null);
                                                                    textViewLclupha4.setTextSize(10.0f);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha3, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height));
                                                                    layoutParams4.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha4, layoutParams4);
                                                                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams5.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams5.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top);
                                                                    linearLayout3.addView(linearLayoutLvtqoqa4, layoutParams5);
                                                                    final LinearLayout linearLayout4 = new LinearLayout(r3);
                                                                    linearLayout4.setOrientation(1);
                                                                    linearLayout3.addView(linearLayout4);
                                                                    ArrayList arrayList3 = new ArrayList();
                                                                    final boolean[] zArr = {false};
                                                                    ArrayList arrayList4 = arrayList3;
                                                                    final vntpaom vntpaomVar = new vntpaom(arrayList3, textViewOxoagud3, (Object) r3, textViewLclupha2, 3);
                                                                    final hhqpjvl hhqpjvlVar = new hhqpjvl(editText, arrayList4, strArr, (Object) r3, ghkjjruVarJdqigmr, 2);
                                                                    final int i5 = 0;
                                                                    ((TextView) ghkjjruVarJdqigmr.ojyssqt).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i5) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i6 = 1;
                                                                    ((TextView) ghkjjruVarJdqigmr.vivhedu).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i6) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i7 = 2;
                                                                    ((TextView) ghkjjruVarJdqigmr.lthborb).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i7) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    int[][] iArr = {new int[]{android.R.attr.state_checked}, new int[]{-16842912}};
                                                                    Iterator it = arrayList.iterator();
                                                                    LinearLayout r13 = linearLayout;
                                                                    ScrollView r15 = scrollView3;
                                                                    while (it.hasNext()) {
                                                                        final eenkamx eenkamxVar = (eenkamx) it.next();
                                                                        final LinearLayout linearLayout5 = new LinearLayout(r3);
                                                                        linearLayout5.setOrientation(0);
                                                                        linearLayout5.setGravity(16);
                                                                        linearLayout5.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
                                                                        String str = eenkamxVar.oqexvyb;
                                                                        linearLayout5.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_row_radius, r3, x.zamkzqg.tmdubwv(r3, str), x.zamkzqg.cugubfc(r3, str)));
                                                                        CheckBox checkBox = new CheckBox(r3);
                                                                        String str2 = eenkamxVar.oqexvyb;
                                                                        checkBox.setButtonTintList(new ColorStateList(iArr, new int[]{x.zamkzqg.cugubfc(r3, str2), x.zamkzqg.jbmzxye(r3)}));
                                                                        String str3 = eenkamxVar.ojyssqt;
                                                                        checkBox.setContentDescription(str3);
                                                                        linearLayout5.addView(checkBox);
                                                                        LinearLayout linearLayout6 = new LinearLayout(r3);
                                                                        linearLayout6.setOrientation(1);
                                                                        LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(r3);
                                                                        int[][] iArr2 = iArr;
                                                                        linearLayoutLvtqoqa5.setGravity(16);
                                                                        Iterator it2 = it;
                                                                        LinearLayout r20 = r13;
                                                                        mcdstyz mcdstyzVar3 = mcdstyzVar2;
                                                                        ScrollView r26 = r15;
                                                                        linearLayoutLvtqoqa5.addView(x.zamkzqg.oxoagud(r3, str3, 13, x.zamkzqg.zngzleo(r3), true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                                                                        TextView textViewOxoagud4 = x.zamkzqg.oxoagud(r3, r3.getString("red".equals(str2) ? R.string.parts_risk_red : "yellow".equals(str2) ? R.string.parts_risk_yellow : R.string.parts_risk_green), 9, x.zamkzqg.cugubfc(r3, str2), true);
                                                                        TextView textView = textViewLclupha3;
                                                                        textViewOxoagud4.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
                                                                        textViewOxoagud4.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_badge_radius, r3, x.zamkzqg.tmdubwv(r3, str2), r3.getColor(R.color.rynx_transparent)));
                                                                        linearLayoutLvtqoqa5.addView(textViewOxoagud4);
                                                                        linearLayout6.addView(linearLayoutLvtqoqa5);
                                                                        String str4 = eenkamxVar.qxvquar;
                                                                        boolean zEquals = "—".equals(str4);
                                                                        String str5 = eenkamxVar.lthborb;
                                                                        String str6 = eenkamxVar.vivhedu;
                                                                        TextView textViewOxoagud5 = x.zamkzqg.oxoagud(r3, zEquals ? r3.getString(R.string.batch_backup_partition_meta, str6, str5) : r3.getString(R.string.batch_backup_partition_meta_slot, str6, str5, str4), 10, x.zamkzqg.jbmzxye(r3), false);
                                                                        textViewOxoagud5.setPadding(0, r3.getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                                                                        linearLayout6.addView(textViewOxoagud5);
                                                                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                        layoutParams6.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap);
                                                                        linearLayout5.addView(linearLayout6, layoutParams6);
                                                                        ArrayList arrayList5 = arrayList4;
                                                                        arrayList5.add(new rpdxrib(eenkamxVar, linearLayout5, checkBox, (str3 + " " + str5 + " " + str4).toLowerCase(Locale.ROOT)));
                                                                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                                                                        int dimensionPixelSize = r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_gap);
                                                                        layoutParams7.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                                                                        linearLayout4.addView(linearLayout5, layoutParams7);
                                                                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: x.marclvq
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                                                                String str7 = eenkamxVar.oqexvyb;
                                                                                com.rynx.app.nmpwovh nmpwovhVar = r3;
                                                                                LinearLayout linearLayout7 = linearLayout5;
                                                                                linearLayout7.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar, x.zamkzqg.tmdubwv(nmpwovhVar, str7), z ? x.zamkzqg.nmpwovh(nmpwovhVar) : x.zamkzqg.cugubfc(nmpwovhVar, str7), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_radius)));
                                                                                if (zArr[0]) {
                                                                                    return;
                                                                                }
                                                                                x.zfmpmio.ojyssqt(linearLayout7);
                                                                                vntpaomVar.run();
                                                                            }
                                                                        });
                                                                        x.zamkzqg.utmeivs(r3, linearLayout5);
                                                                        linearLayout5.setOnClickListener(new mamlotu(checkBox, 0));
                                                                        arrayList4 = arrayList5;
                                                                        iArr = iArr2;
                                                                        it = it2;
                                                                        r13 = r20;
                                                                        r15 = r26;
                                                                        mcdstyzVar2 = mcdstyzVar3;
                                                                        textViewLclupha3 = textView;
                                                                    }
                                                                    LinearLayout r21 = r13;
                                                                    final ArrayList arrayList6 = arrayList4;
                                                                    final int i8 = 0;
                                                                    editText.addTextChangedListener(new xvxmcgn(hhqpjvlVar, 0));
                                                                    textViewLclupha3.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i8) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i9 = 1;
                                                                    textViewLclupha4.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i9) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    textViewLclupha2.setOnClickListener(new pzqxblc(arrayList6, mcdstyzVar2, i9));
                                                                    linearLayout3.addView(new View(r3), new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                                                                    vntpaomVar.run();
                                                                    hhqpjvlVar.run();
                                                                    r21.addView(r15, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                                                                    r3.kffvigz(r21, "batch_backup_selector");
                                                                } else {
                                                                    ohwxijw ohwxijwVar = (ohwxijw) arrayList2.get(i4);
                                                                    arrayList.add(new eenkamx(i4, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar.vivhedu), ohwxijwVar.lthborb, ohwxijwVar.qxvquar, ohwxijwVar.oqexvyb));
                                                                    i4++;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        Toast.makeText((Context) r3, R.string.error_busy, 0).show();
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                mcdstyzVar.nmpwovh.vopsyhw("all");
                                                break;
                                            default:
                                                mcdstyzVar.nmpwovh.gzokllk();
                                                break;
                                        }
                                    }
                                }), x.zamkzqg.uiqyzsp(kggugdpVar));
                                final int i4 = 2;
                                linearLayoutXbdyiew2.addView(x.zamkzqg.yojulhu(kggugdpVar, R.string.batch_hub_flash_title, R.string.batch_hub_flash_desc, R.drawable.ic_flash, R.string.parts_flash_multiple, x.zamkzqg.kggugdp(kggugdpVar), new View.OnClickListener() { // from class: x.udgizdi
                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r10v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v1 */
                                    /* JADX WARN: Type inference failed for: r13v11 */
                                    /* JADX WARN: Type inference failed for: r13v9 */
                                    /* JADX WARN: Type inference failed for: r15v13 */
                                    /* JADX WARN: Type inference failed for: r15v14 */
                                    /* JADX WARN: Type inference failed for: r15v5, types: [android.widget.ScrollView] */
                                    /* JADX WARN: Type inference failed for: r15v6 */
                                    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r20v1, types: [android.view.ViewGroup] */
                                    /* JADX WARN: Type inference failed for: r20v2 */
                                    /* JADX WARN: Type inference failed for: r26v0, types: [android.view.View] */
                                    /* JADX WARN: Type inference failed for: r26v1 */
                                    /* JADX WARN: Type inference failed for: r3v2, types: [android.app.Activity, android.content.Context, com.rynx.app.nmpwovh, com.rynx.app.ojyssqt, java.lang.Object, x.kggugdp] */
                                    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r6v18, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i4) {
                                            case 0:
                                                mcdstyzVar.nmpwovh.buswjhz();
                                                break;
                                            case 1:
                                                final kggugdp r3 = mcdstyzVar.nmpwovh;
                                                if (r3.wjugzfh()) {
                                                    if (!r3.lpkdqgx && !r3.ywhgqsi) {
                                                        if (r3.jbmzxye.isEmpty()) {
                                                            Toast.makeText((Context) r3, R.string.error_reading_partition_first, 0).show();
                                                            break;
                                                        } else if (r3.wjugzfh()) {
                                                            ArrayList arrayList = new ArrayList();
                                                            int i5 = 0;
                                                            while (true) {
                                                                ArrayList arrayList2 = r3.jbmzxye;
                                                                if (i5 >= arrayList2.size()) {
                                                                    mcdstyz mcdstyzVar2 = new mcdstyz(r3);
                                                                    LinearLayout linearLayout = new LinearLayout(r3);
                                                                    linearLayout.setOrientation(1);
                                                                    linearLayout.setBackgroundColor(x.zamkzqg.buswjhz(r3));
                                                                    LinearLayout linearLayout2 = new LinearLayout(r3);
                                                                    linearLayout2.setOrientation(1);
                                                                    linearLayout2.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
                                                                    LinearLayout linearLayoutLvtqoqa2 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa2.setGravity(16);
                                                                    linearLayoutLvtqoqa2.addView(x.zamkzqg.btazysh(r3, R.drawable.ic_back, x.zamkzqg.nmpwovh(r3), R.string.batch_hub_title, new nmpwovh(mcdstyzVar2, 3)), new LinearLayout.LayoutParams(r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
                                                                    TextView textViewOxoagud2 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_title), 20, x.zamkzqg.zngzleo(r3), true);
                                                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                    layoutParams.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa2.addView(textViewOxoagud2, layoutParams);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa2);
                                                                    LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa3.setGravity(16);
                                                                    TextView textViewOxoagud3 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_selected_count, 0), 11, x.zamkzqg.jbmzxye(r3), true);
                                                                    textViewOxoagud3.setGravity(17);
                                                                    textViewOxoagud3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
                                                                    textViewOxoagud3.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    linearLayoutLvtqoqa3.addView(textViewOxoagud3);
                                                                    linearLayoutLvtqoqa3.addView(new View(r3), new LinearLayout.LayoutParams(0, 1, 1.0f));
                                                                    String string = r3.getString(R.string.batch_backup_action_compact, 0);
                                                                    int iKggugdp = x.zamkzqg.kggugdp(r3);
                                                                    TextView textViewLclupha2 = x.zamkzqg.lclupha(r3, string, null);
                                                                    x.zamkzqg.enxkjpu(r3, textViewLclupha2, R.drawable.ic_backup, iKggugdp);
                                                                    textViewLclupha2.setTextColor(x.zamkzqg.kggugdp(r3));
                                                                    textViewLclupha2.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.ojyssqt(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    textViewLclupha2.setEnabled(false);
                                                                    textViewLclupha2.setAlpha(0.42f);
                                                                    linearLayoutLvtqoqa3.addView(textViewLclupha2, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams2.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa3, layoutParams2);
                                                                    linearLayout.addView(linearLayout2);
                                                                    ScrollView scrollView3 = new ScrollView(r3);
                                                                    scrollView3.setFillViewport(true);
                                                                    LinearLayout linearLayout3 = new LinearLayout(r3);
                                                                    linearLayout3.setOrientation(1);
                                                                    linearLayout3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
                                                                    scrollView3.addView(linearLayout3);
                                                                    linearLayout3.addView(x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_subtitle), 11, x.zamkzqg.jbmzxye(r3), false));
                                                                    EditText editText = new EditText(r3);
                                                                    editText.setSingleLine(true);
                                                                    editText.setTextColor(x.zamkzqg.zngzleo(r3));
                                                                    editText.setHintTextColor(x.zamkzqg.jbmzxye(r3));
                                                                    editText.setHint(R.string.batch_backup_search_hint);
                                                                    editText.setTextSize(13.0f);
                                                                    editText.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0, r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0);
                                                                    editText.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.ui_field_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, 0, 0);
                                                                    editText.setCompoundDrawablePadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap));
                                                                    editText.setCompoundDrawableTintList(ColorStateList.valueOf(x.zamkzqg.jbmzxye(r3)));
                                                                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.batch_backup_search_height));
                                                                    layoutParams3.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams3.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    linearLayout3.addView(editText, layoutParams3);
                                                                    final String[] strArr = {"green"};
                                                                    ghkjjru ghkjjruVarJdqigmr = x.zamkzqg.jdqigmr(r3, strArr[0], new jtfjrri(strArr, 0));
                                                                    linearLayout3.addView((LinearLayout) ghkjjruVarJdqigmr.nmpwovh, new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.risk_segment_container_height)));
                                                                    LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa4.setGravity(8388613);
                                                                    TextView textViewLclupha3 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_select_visible_short), null);
                                                                    textViewLclupha3.setTextSize(10.0f);
                                                                    TextView textViewLclupha4 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_clear), null);
                                                                    textViewLclupha4.setTextSize(10.0f);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha3, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height));
                                                                    layoutParams4.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha4, layoutParams4);
                                                                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams5.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams5.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top);
                                                                    linearLayout3.addView(linearLayoutLvtqoqa4, layoutParams5);
                                                                    final LinearLayout linearLayout4 = new LinearLayout(r3);
                                                                    linearLayout4.setOrientation(1);
                                                                    linearLayout3.addView(linearLayout4);
                                                                    ArrayList arrayList3 = new ArrayList();
                                                                    final boolean[] zArr = {false};
                                                                    ArrayList arrayList4 = arrayList3;
                                                                    final vntpaom vntpaomVar = new vntpaom(arrayList3, textViewOxoagud3, (Object) r3, textViewLclupha2, 3);
                                                                    final hhqpjvl hhqpjvlVar = new hhqpjvl(editText, arrayList4, strArr, (Object) r3, ghkjjruVarJdqigmr, 2);
                                                                    final int i6 = 0;
                                                                    ((TextView) ghkjjruVarJdqigmr.ojyssqt).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i6) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i7 = 1;
                                                                    ((TextView) ghkjjruVarJdqigmr.vivhedu).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i7) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i8 = 2;
                                                                    ((TextView) ghkjjruVarJdqigmr.lthborb).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i8) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    int[][] iArr = {new int[]{android.R.attr.state_checked}, new int[]{-16842912}};
                                                                    Iterator it = arrayList.iterator();
                                                                    LinearLayout r13 = linearLayout;
                                                                    ScrollView r15 = scrollView3;
                                                                    while (it.hasNext()) {
                                                                        final eenkamx eenkamxVar = (eenkamx) it.next();
                                                                        final LinearLayout linearLayout5 = new LinearLayout(r3);
                                                                        linearLayout5.setOrientation(0);
                                                                        linearLayout5.setGravity(16);
                                                                        linearLayout5.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
                                                                        String str = eenkamxVar.oqexvyb;
                                                                        linearLayout5.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_row_radius, r3, x.zamkzqg.tmdubwv(r3, str), x.zamkzqg.cugubfc(r3, str)));
                                                                        CheckBox checkBox = new CheckBox(r3);
                                                                        String str2 = eenkamxVar.oqexvyb;
                                                                        checkBox.setButtonTintList(new ColorStateList(iArr, new int[]{x.zamkzqg.cugubfc(r3, str2), x.zamkzqg.jbmzxye(r3)}));
                                                                        String str3 = eenkamxVar.ojyssqt;
                                                                        checkBox.setContentDescription(str3);
                                                                        linearLayout5.addView(checkBox);
                                                                        LinearLayout linearLayout6 = new LinearLayout(r3);
                                                                        linearLayout6.setOrientation(1);
                                                                        LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(r3);
                                                                        int[][] iArr2 = iArr;
                                                                        linearLayoutLvtqoqa5.setGravity(16);
                                                                        Iterator it2 = it;
                                                                        LinearLayout r20 = r13;
                                                                        mcdstyz mcdstyzVar3 = mcdstyzVar2;
                                                                        ScrollView r26 = r15;
                                                                        linearLayoutLvtqoqa5.addView(x.zamkzqg.oxoagud(r3, str3, 13, x.zamkzqg.zngzleo(r3), true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                                                                        TextView textViewOxoagud4 = x.zamkzqg.oxoagud(r3, r3.getString("red".equals(str2) ? R.string.parts_risk_red : "yellow".equals(str2) ? R.string.parts_risk_yellow : R.string.parts_risk_green), 9, x.zamkzqg.cugubfc(r3, str2), true);
                                                                        TextView textView = textViewLclupha3;
                                                                        textViewOxoagud4.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
                                                                        textViewOxoagud4.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_badge_radius, r3, x.zamkzqg.tmdubwv(r3, str2), r3.getColor(R.color.rynx_transparent)));
                                                                        linearLayoutLvtqoqa5.addView(textViewOxoagud4);
                                                                        linearLayout6.addView(linearLayoutLvtqoqa5);
                                                                        String str4 = eenkamxVar.qxvquar;
                                                                        boolean zEquals = "—".equals(str4);
                                                                        String str5 = eenkamxVar.lthborb;
                                                                        String str6 = eenkamxVar.vivhedu;
                                                                        TextView textViewOxoagud5 = x.zamkzqg.oxoagud(r3, zEquals ? r3.getString(R.string.batch_backup_partition_meta, str6, str5) : r3.getString(R.string.batch_backup_partition_meta_slot, str6, str5, str4), 10, x.zamkzqg.jbmzxye(r3), false);
                                                                        textViewOxoagud5.setPadding(0, r3.getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                                                                        linearLayout6.addView(textViewOxoagud5);
                                                                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                        layoutParams6.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap);
                                                                        linearLayout5.addView(linearLayout6, layoutParams6);
                                                                        ArrayList arrayList5 = arrayList4;
                                                                        arrayList5.add(new rpdxrib(eenkamxVar, linearLayout5, checkBox, (str3 + " " + str5 + " " + str4).toLowerCase(Locale.ROOT)));
                                                                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                                                                        int dimensionPixelSize = r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_gap);
                                                                        layoutParams7.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                                                                        linearLayout4.addView(linearLayout5, layoutParams7);
                                                                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: x.marclvq
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                                                                String str7 = eenkamxVar.oqexvyb;
                                                                                com.rynx.app.nmpwovh nmpwovhVar = r3;
                                                                                LinearLayout linearLayout7 = linearLayout5;
                                                                                linearLayout7.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar, x.zamkzqg.tmdubwv(nmpwovhVar, str7), z ? x.zamkzqg.nmpwovh(nmpwovhVar) : x.zamkzqg.cugubfc(nmpwovhVar, str7), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_radius)));
                                                                                if (zArr[0]) {
                                                                                    return;
                                                                                }
                                                                                x.zfmpmio.ojyssqt(linearLayout7);
                                                                                vntpaomVar.run();
                                                                            }
                                                                        });
                                                                        x.zamkzqg.utmeivs(r3, linearLayout5);
                                                                        linearLayout5.setOnClickListener(new mamlotu(checkBox, 0));
                                                                        arrayList4 = arrayList5;
                                                                        iArr = iArr2;
                                                                        it = it2;
                                                                        r13 = r20;
                                                                        r15 = r26;
                                                                        mcdstyzVar2 = mcdstyzVar3;
                                                                        textViewLclupha3 = textView;
                                                                    }
                                                                    LinearLayout r21 = r13;
                                                                    final ArrayList arrayList6 = arrayList4;
                                                                    final int i9 = 0;
                                                                    editText.addTextChangedListener(new xvxmcgn(hhqpjvlVar, 0));
                                                                    textViewLclupha3.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i9) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i10 = 1;
                                                                    textViewLclupha4.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i10) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    textViewLclupha2.setOnClickListener(new pzqxblc(arrayList6, mcdstyzVar2, i10));
                                                                    linearLayout3.addView(new View(r3), new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                                                                    vntpaomVar.run();
                                                                    hhqpjvlVar.run();
                                                                    r21.addView(r15, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                                                                    r3.kffvigz(r21, "batch_backup_selector");
                                                                } else {
                                                                    ohwxijw ohwxijwVar = (ohwxijw) arrayList2.get(i5);
                                                                    arrayList.add(new eenkamx(i5, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar.vivhedu), ohwxijwVar.lthborb, ohwxijwVar.qxvquar, ohwxijwVar.oqexvyb));
                                                                    i5++;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        Toast.makeText((Context) r3, R.string.error_busy, 0).show();
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                mcdstyzVar.nmpwovh.vopsyhw("all");
                                                break;
                                            default:
                                                mcdstyzVar.nmpwovh.gzokllk();
                                                break;
                                        }
                                    }
                                }), x.zamkzqg.uiqyzsp(kggugdpVar));
                                final int i5 = 3;
                                linearLayoutXbdyiew2.addView(x.zamkzqg.yojulhu(kggugdpVar, R.string.batch_hub_scatter_title, R.string.batch_hub_scatter_desc, R.drawable.ic_file, R.string.batch_hub_scatter_action, x.zamkzqg.ohwxijw(kggugdpVar), new View.OnClickListener() { // from class: x.udgizdi
                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r10v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v1 */
                                    /* JADX WARN: Type inference failed for: r13v11 */
                                    /* JADX WARN: Type inference failed for: r13v9 */
                                    /* JADX WARN: Type inference failed for: r15v13 */
                                    /* JADX WARN: Type inference failed for: r15v14 */
                                    /* JADX WARN: Type inference failed for: r15v5, types: [android.widget.ScrollView] */
                                    /* JADX WARN: Type inference failed for: r15v6 */
                                    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r20v1, types: [android.view.ViewGroup] */
                                    /* JADX WARN: Type inference failed for: r20v2 */
                                    /* JADX WARN: Type inference failed for: r26v0, types: [android.view.View] */
                                    /* JADX WARN: Type inference failed for: r26v1 */
                                    /* JADX WARN: Type inference failed for: r3v2, types: [android.app.Activity, android.content.Context, com.rynx.app.nmpwovh, com.rynx.app.ojyssqt, java.lang.Object, x.kggugdp] */
                                    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r6v18, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i5) {
                                            case 0:
                                                mcdstyzVar.nmpwovh.buswjhz();
                                                break;
                                            case 1:
                                                final kggugdp r3 = mcdstyzVar.nmpwovh;
                                                if (r3.wjugzfh()) {
                                                    if (!r3.lpkdqgx && !r3.ywhgqsi) {
                                                        if (r3.jbmzxye.isEmpty()) {
                                                            Toast.makeText((Context) r3, R.string.error_reading_partition_first, 0).show();
                                                            break;
                                                        } else if (r3.wjugzfh()) {
                                                            ArrayList arrayList = new ArrayList();
                                                            int i6 = 0;
                                                            while (true) {
                                                                ArrayList arrayList2 = r3.jbmzxye;
                                                                if (i6 >= arrayList2.size()) {
                                                                    mcdstyz mcdstyzVar2 = new mcdstyz(r3);
                                                                    LinearLayout linearLayout = new LinearLayout(r3);
                                                                    linearLayout.setOrientation(1);
                                                                    linearLayout.setBackgroundColor(x.zamkzqg.buswjhz(r3));
                                                                    LinearLayout linearLayout2 = new LinearLayout(r3);
                                                                    linearLayout2.setOrientation(1);
                                                                    linearLayout2.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
                                                                    LinearLayout linearLayoutLvtqoqa2 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa2.setGravity(16);
                                                                    linearLayoutLvtqoqa2.addView(x.zamkzqg.btazysh(r3, R.drawable.ic_back, x.zamkzqg.nmpwovh(r3), R.string.batch_hub_title, new nmpwovh(mcdstyzVar2, 3)), new LinearLayout.LayoutParams(r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
                                                                    TextView textViewOxoagud2 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_title), 20, x.zamkzqg.zngzleo(r3), true);
                                                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                    layoutParams.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa2.addView(textViewOxoagud2, layoutParams);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa2);
                                                                    LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa3.setGravity(16);
                                                                    TextView textViewOxoagud3 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_selected_count, 0), 11, x.zamkzqg.jbmzxye(r3), true);
                                                                    textViewOxoagud3.setGravity(17);
                                                                    textViewOxoagud3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
                                                                    textViewOxoagud3.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    linearLayoutLvtqoqa3.addView(textViewOxoagud3);
                                                                    linearLayoutLvtqoqa3.addView(new View(r3), new LinearLayout.LayoutParams(0, 1, 1.0f));
                                                                    String string = r3.getString(R.string.batch_backup_action_compact, 0);
                                                                    int iKggugdp = x.zamkzqg.kggugdp(r3);
                                                                    TextView textViewLclupha2 = x.zamkzqg.lclupha(r3, string, null);
                                                                    x.zamkzqg.enxkjpu(r3, textViewLclupha2, R.drawable.ic_backup, iKggugdp);
                                                                    textViewLclupha2.setTextColor(x.zamkzqg.kggugdp(r3));
                                                                    textViewLclupha2.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.ojyssqt(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    textViewLclupha2.setEnabled(false);
                                                                    textViewLclupha2.setAlpha(0.42f);
                                                                    linearLayoutLvtqoqa3.addView(textViewLclupha2, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams2.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa3, layoutParams2);
                                                                    linearLayout.addView(linearLayout2);
                                                                    ScrollView scrollView3 = new ScrollView(r3);
                                                                    scrollView3.setFillViewport(true);
                                                                    LinearLayout linearLayout3 = new LinearLayout(r3);
                                                                    linearLayout3.setOrientation(1);
                                                                    linearLayout3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
                                                                    scrollView3.addView(linearLayout3);
                                                                    linearLayout3.addView(x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_subtitle), 11, x.zamkzqg.jbmzxye(r3), false));
                                                                    EditText editText = new EditText(r3);
                                                                    editText.setSingleLine(true);
                                                                    editText.setTextColor(x.zamkzqg.zngzleo(r3));
                                                                    editText.setHintTextColor(x.zamkzqg.jbmzxye(r3));
                                                                    editText.setHint(R.string.batch_backup_search_hint);
                                                                    editText.setTextSize(13.0f);
                                                                    editText.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0, r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0);
                                                                    editText.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.ui_field_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, 0, 0);
                                                                    editText.setCompoundDrawablePadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap));
                                                                    editText.setCompoundDrawableTintList(ColorStateList.valueOf(x.zamkzqg.jbmzxye(r3)));
                                                                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.batch_backup_search_height));
                                                                    layoutParams3.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams3.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    linearLayout3.addView(editText, layoutParams3);
                                                                    final String[] strArr = {"green"};
                                                                    ghkjjru ghkjjruVarJdqigmr = x.zamkzqg.jdqigmr(r3, strArr[0], new jtfjrri(strArr, 0));
                                                                    linearLayout3.addView((LinearLayout) ghkjjruVarJdqigmr.nmpwovh, new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.risk_segment_container_height)));
                                                                    LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa4.setGravity(8388613);
                                                                    TextView textViewLclupha3 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_select_visible_short), null);
                                                                    textViewLclupha3.setTextSize(10.0f);
                                                                    TextView textViewLclupha4 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_clear), null);
                                                                    textViewLclupha4.setTextSize(10.0f);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha3, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height));
                                                                    layoutParams4.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha4, layoutParams4);
                                                                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams5.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams5.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top);
                                                                    linearLayout3.addView(linearLayoutLvtqoqa4, layoutParams5);
                                                                    final LinearLayout linearLayout4 = new LinearLayout(r3);
                                                                    linearLayout4.setOrientation(1);
                                                                    linearLayout3.addView(linearLayout4);
                                                                    ArrayList arrayList3 = new ArrayList();
                                                                    final boolean[] zArr = {false};
                                                                    ArrayList arrayList4 = arrayList3;
                                                                    final vntpaom vntpaomVar = new vntpaom(arrayList3, textViewOxoagud3, (Object) r3, textViewLclupha2, 3);
                                                                    final hhqpjvl hhqpjvlVar = new hhqpjvl(editText, arrayList4, strArr, (Object) r3, ghkjjruVarJdqigmr, 2);
                                                                    final int i7 = 0;
                                                                    ((TextView) ghkjjruVarJdqigmr.ojyssqt).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i7) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i8 = 1;
                                                                    ((TextView) ghkjjruVarJdqigmr.vivhedu).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i8) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i9 = 2;
                                                                    ((TextView) ghkjjruVarJdqigmr.lthborb).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i9) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    int[][] iArr = {new int[]{android.R.attr.state_checked}, new int[]{-16842912}};
                                                                    Iterator it = arrayList.iterator();
                                                                    LinearLayout r13 = linearLayout;
                                                                    ScrollView r15 = scrollView3;
                                                                    while (it.hasNext()) {
                                                                        final eenkamx eenkamxVar = (eenkamx) it.next();
                                                                        final LinearLayout linearLayout5 = new LinearLayout(r3);
                                                                        linearLayout5.setOrientation(0);
                                                                        linearLayout5.setGravity(16);
                                                                        linearLayout5.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
                                                                        String str = eenkamxVar.oqexvyb;
                                                                        linearLayout5.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_row_radius, r3, x.zamkzqg.tmdubwv(r3, str), x.zamkzqg.cugubfc(r3, str)));
                                                                        CheckBox checkBox = new CheckBox(r3);
                                                                        String str2 = eenkamxVar.oqexvyb;
                                                                        checkBox.setButtonTintList(new ColorStateList(iArr, new int[]{x.zamkzqg.cugubfc(r3, str2), x.zamkzqg.jbmzxye(r3)}));
                                                                        String str3 = eenkamxVar.ojyssqt;
                                                                        checkBox.setContentDescription(str3);
                                                                        linearLayout5.addView(checkBox);
                                                                        LinearLayout linearLayout6 = new LinearLayout(r3);
                                                                        linearLayout6.setOrientation(1);
                                                                        LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(r3);
                                                                        int[][] iArr2 = iArr;
                                                                        linearLayoutLvtqoqa5.setGravity(16);
                                                                        Iterator it2 = it;
                                                                        LinearLayout r20 = r13;
                                                                        mcdstyz mcdstyzVar3 = mcdstyzVar2;
                                                                        ScrollView r26 = r15;
                                                                        linearLayoutLvtqoqa5.addView(x.zamkzqg.oxoagud(r3, str3, 13, x.zamkzqg.zngzleo(r3), true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                                                                        TextView textViewOxoagud4 = x.zamkzqg.oxoagud(r3, r3.getString("red".equals(str2) ? R.string.parts_risk_red : "yellow".equals(str2) ? R.string.parts_risk_yellow : R.string.parts_risk_green), 9, x.zamkzqg.cugubfc(r3, str2), true);
                                                                        TextView textView = textViewLclupha3;
                                                                        textViewOxoagud4.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
                                                                        textViewOxoagud4.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_badge_radius, r3, x.zamkzqg.tmdubwv(r3, str2), r3.getColor(R.color.rynx_transparent)));
                                                                        linearLayoutLvtqoqa5.addView(textViewOxoagud4);
                                                                        linearLayout6.addView(linearLayoutLvtqoqa5);
                                                                        String str4 = eenkamxVar.qxvquar;
                                                                        boolean zEquals = "—".equals(str4);
                                                                        String str5 = eenkamxVar.lthborb;
                                                                        String str6 = eenkamxVar.vivhedu;
                                                                        TextView textViewOxoagud5 = x.zamkzqg.oxoagud(r3, zEquals ? r3.getString(R.string.batch_backup_partition_meta, str6, str5) : r3.getString(R.string.batch_backup_partition_meta_slot, str6, str5, str4), 10, x.zamkzqg.jbmzxye(r3), false);
                                                                        textViewOxoagud5.setPadding(0, r3.getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                                                                        linearLayout6.addView(textViewOxoagud5);
                                                                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                        layoutParams6.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap);
                                                                        linearLayout5.addView(linearLayout6, layoutParams6);
                                                                        ArrayList arrayList5 = arrayList4;
                                                                        arrayList5.add(new rpdxrib(eenkamxVar, linearLayout5, checkBox, (str3 + " " + str5 + " " + str4).toLowerCase(Locale.ROOT)));
                                                                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                                                                        int dimensionPixelSize = r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_gap);
                                                                        layoutParams7.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                                                                        linearLayout4.addView(linearLayout5, layoutParams7);
                                                                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: x.marclvq
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                                                                String str7 = eenkamxVar.oqexvyb;
                                                                                com.rynx.app.nmpwovh nmpwovhVar = r3;
                                                                                LinearLayout linearLayout7 = linearLayout5;
                                                                                linearLayout7.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar, x.zamkzqg.tmdubwv(nmpwovhVar, str7), z ? x.zamkzqg.nmpwovh(nmpwovhVar) : x.zamkzqg.cugubfc(nmpwovhVar, str7), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_radius)));
                                                                                if (zArr[0]) {
                                                                                    return;
                                                                                }
                                                                                x.zfmpmio.ojyssqt(linearLayout7);
                                                                                vntpaomVar.run();
                                                                            }
                                                                        });
                                                                        x.zamkzqg.utmeivs(r3, linearLayout5);
                                                                        linearLayout5.setOnClickListener(new mamlotu(checkBox, 0));
                                                                        arrayList4 = arrayList5;
                                                                        iArr = iArr2;
                                                                        it = it2;
                                                                        r13 = r20;
                                                                        r15 = r26;
                                                                        mcdstyzVar2 = mcdstyzVar3;
                                                                        textViewLclupha3 = textView;
                                                                    }
                                                                    LinearLayout r21 = r13;
                                                                    final ArrayList arrayList6 = arrayList4;
                                                                    final int i10 = 0;
                                                                    editText.addTextChangedListener(new xvxmcgn(hhqpjvlVar, 0));
                                                                    textViewLclupha3.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i10) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i11 = 1;
                                                                    textViewLclupha4.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i11) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    textViewLclupha2.setOnClickListener(new pzqxblc(arrayList6, mcdstyzVar2, i11));
                                                                    linearLayout3.addView(new View(r3), new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                                                                    vntpaomVar.run();
                                                                    hhqpjvlVar.run();
                                                                    r21.addView(r15, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                                                                    r3.kffvigz(r21, "batch_backup_selector");
                                                                } else {
                                                                    ohwxijw ohwxijwVar = (ohwxijw) arrayList2.get(i6);
                                                                    arrayList.add(new eenkamx(i6, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar.vivhedu), ohwxijwVar.lthborb, ohwxijwVar.qxvquar, ohwxijwVar.oqexvyb));
                                                                    i6++;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        Toast.makeText((Context) r3, R.string.error_busy, 0).show();
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                mcdstyzVar.nmpwovh.vopsyhw("all");
                                                break;
                                            default:
                                                mcdstyzVar.nmpwovh.gzokllk();
                                                break;
                                        }
                                    }
                                }), x.zamkzqg.uiqyzsp(kggugdpVar));
                                linearLayoutXbdyiew2.addView(new View(kggugdpVar), new LinearLayout.LayoutParams(-1, kggugdpVar.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                                kggugdpVar.kffvigz(scrollView2, "batch_hub");
                            } else {
                                Toast.makeText(kggugdpVar, R.string.error_reading_partition_first, 0).show();
                            }
                            break;
                        }
                        break;
                }
            }
        });
        linearLayoutLvtqoqa.addView(textViewBtazysh, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
        linearLayoutXbdyiew.addView(linearLayoutLvtqoqa);
        LinearLayout linearLayoutLvtqoqa2 = x.zamkzqg.lvtqoqa(this);
        linearLayoutLvtqoqa2.setGravity(16);
        TextView textViewOxoagud = x.zamkzqg.oxoagud(this, getString(R.string.status_da_ready), 10, x.zamkzqg.pzkwhtn(this), true);
        textViewOxoagud.setGravity(17);
        textViewOxoagud.setPadding(getResources().getDimensionPixelSize(R.dimen.partition_header_action_padding_horizontal), 0, getResources().getDimensionPixelSize(R.dimen.partition_header_action_padding_horizontal), 0);
        textViewOxoagud.setBackground(x.zamkzqg.jvtqflj(this, getColor(x.zamkzqg.ysluikv(this) ? R.color.rynx_dark_success_chip : R.color.rynx_light_success_chip), getColor(R.color.rynx_transparent), getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_radius)));
        linearLayoutLvtqoqa2.addView(textViewOxoagud, new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
        linearLayoutLvtqoqa2.addView(new View(this), new LinearLayout.LayoutParams(0, 1, 1.0f));
        int iNmpwovh = x.zamkzqg.nmpwovh(this);
        final int i2 = 1;
        TextView textViewLclupha = x.zamkzqg.lclupha(this, getString(R.string.parts_batch_compact), new View.OnClickListener() { // from class: x.ygdccqg
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        xbdyiewVar.nmpwovh.saksmfq();
                        break;
                    default:
                        kggugdp kggugdpVar = xbdyiewVar.nmpwovh;
                        if (kggugdpVar.wjugzfh()) {
                            if (kggugdpVar.lpkdqgx || kggugdpVar.ywhgqsi) {
                                Toast.makeText(kggugdpVar, R.string.error_busy, 0).show();
                            } else if (!kggugdpVar.jbmzxye.isEmpty()) {
                                final mcdstyz mcdstyzVar = new mcdstyz(kggugdpVar);
                                ScrollView scrollView2 = new ScrollView(kggugdpVar);
                                scrollView2.setFillViewport(true);
                                LinearLayout linearLayoutXbdyiew2 = x.zamkzqg.xbdyiew(kggugdpVar, 16);
                                scrollView2.addView(linearLayoutXbdyiew2);
                                int iNmpwovh2 = x.zamkzqg.nmpwovh(kggugdpVar);
                                final int i3 = 0;
                                TextView textViewLclupha2 = x.zamkzqg.lclupha(kggugdpVar, kggugdpVar.getString(R.string.parts_title), new View.OnClickListener() { // from class: x.udgizdi
                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r10v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v1 */
                                    /* JADX WARN: Type inference failed for: r13v11 */
                                    /* JADX WARN: Type inference failed for: r13v9 */
                                    /* JADX WARN: Type inference failed for: r15v13 */
                                    /* JADX WARN: Type inference failed for: r15v14 */
                                    /* JADX WARN: Type inference failed for: r15v5, types: [android.widget.ScrollView] */
                                    /* JADX WARN: Type inference failed for: r15v6 */
                                    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r20v1, types: [android.view.ViewGroup] */
                                    /* JADX WARN: Type inference failed for: r20v2 */
                                    /* JADX WARN: Type inference failed for: r26v0, types: [android.view.View] */
                                    /* JADX WARN: Type inference failed for: r26v1 */
                                    /* JADX WARN: Type inference failed for: r3v2, types: [android.app.Activity, android.content.Context, com.rynx.app.nmpwovh, com.rynx.app.ojyssqt, java.lang.Object, x.kggugdp] */
                                    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r6v18, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i3) {
                                            case 0:
                                                mcdstyzVar.nmpwovh.buswjhz();
                                                break;
                                            case 1:
                                                final kggugdp r3 = mcdstyzVar.nmpwovh;
                                                if (r3.wjugzfh()) {
                                                    if (!r3.lpkdqgx && !r3.ywhgqsi) {
                                                        if (r3.jbmzxye.isEmpty()) {
                                                            Toast.makeText((Context) r3, R.string.error_reading_partition_first, 0).show();
                                                            break;
                                                        } else if (r3.wjugzfh()) {
                                                            ArrayList arrayList = new ArrayList();
                                                            int i6 = 0;
                                                            while (true) {
                                                                ArrayList arrayList2 = r3.jbmzxye;
                                                                if (i6 >= arrayList2.size()) {
                                                                    mcdstyz mcdstyzVar2 = new mcdstyz(r3);
                                                                    LinearLayout linearLayout = new LinearLayout(r3);
                                                                    linearLayout.setOrientation(1);
                                                                    linearLayout.setBackgroundColor(x.zamkzqg.buswjhz(r3));
                                                                    LinearLayout linearLayout2 = new LinearLayout(r3);
                                                                    linearLayout2.setOrientation(1);
                                                                    linearLayout2.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
                                                                    LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa3.setGravity(16);
                                                                    linearLayoutLvtqoqa3.addView(x.zamkzqg.btazysh(r3, R.drawable.ic_back, x.zamkzqg.nmpwovh(r3), R.string.batch_hub_title, new nmpwovh(mcdstyzVar2, 3)), new LinearLayout.LayoutParams(r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
                                                                    TextView textViewOxoagud2 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_title), 20, x.zamkzqg.zngzleo(r3), true);
                                                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                    layoutParams.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa3.addView(textViewOxoagud2, layoutParams);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa3);
                                                                    LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa4.setGravity(16);
                                                                    TextView textViewOxoagud3 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_selected_count, 0), 11, x.zamkzqg.jbmzxye(r3), true);
                                                                    textViewOxoagud3.setGravity(17);
                                                                    textViewOxoagud3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
                                                                    textViewOxoagud3.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    linearLayoutLvtqoqa4.addView(textViewOxoagud3);
                                                                    linearLayoutLvtqoqa4.addView(new View(r3), new LinearLayout.LayoutParams(0, 1, 1.0f));
                                                                    String string = r3.getString(R.string.batch_backup_action_compact, 0);
                                                                    int iKggugdp = x.zamkzqg.kggugdp(r3);
                                                                    TextView textViewLclupha3 = x.zamkzqg.lclupha(r3, string, null);
                                                                    x.zamkzqg.enxkjpu(r3, textViewLclupha3, R.drawable.ic_backup, iKggugdp);
                                                                    textViewLclupha3.setTextColor(x.zamkzqg.kggugdp(r3));
                                                                    textViewLclupha3.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.ojyssqt(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    textViewLclupha3.setEnabled(false);
                                                                    textViewLclupha3.setAlpha(0.42f);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha3, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams2.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa4, layoutParams2);
                                                                    linearLayout.addView(linearLayout2);
                                                                    ScrollView scrollView3 = new ScrollView(r3);
                                                                    scrollView3.setFillViewport(true);
                                                                    LinearLayout linearLayout3 = new LinearLayout(r3);
                                                                    linearLayout3.setOrientation(1);
                                                                    linearLayout3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
                                                                    scrollView3.addView(linearLayout3);
                                                                    linearLayout3.addView(x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_subtitle), 11, x.zamkzqg.jbmzxye(r3), false));
                                                                    EditText editText = new EditText(r3);
                                                                    editText.setSingleLine(true);
                                                                    editText.setTextColor(x.zamkzqg.zngzleo(r3));
                                                                    editText.setHintTextColor(x.zamkzqg.jbmzxye(r3));
                                                                    editText.setHint(R.string.batch_backup_search_hint);
                                                                    editText.setTextSize(13.0f);
                                                                    editText.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0, r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0);
                                                                    editText.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.ui_field_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, 0, 0);
                                                                    editText.setCompoundDrawablePadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap));
                                                                    editText.setCompoundDrawableTintList(ColorStateList.valueOf(x.zamkzqg.jbmzxye(r3)));
                                                                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.batch_backup_search_height));
                                                                    layoutParams3.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams3.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    linearLayout3.addView(editText, layoutParams3);
                                                                    final String[] strArr = {"green"};
                                                                    ghkjjru ghkjjruVarJdqigmr = x.zamkzqg.jdqigmr(r3, strArr[0], new jtfjrri(strArr, 0));
                                                                    linearLayout3.addView((LinearLayout) ghkjjruVarJdqigmr.nmpwovh, new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.risk_segment_container_height)));
                                                                    LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa5.setGravity(8388613);
                                                                    TextView textViewLclupha4 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_select_visible_short), null);
                                                                    textViewLclupha4.setTextSize(10.0f);
                                                                    TextView textViewLclupha5 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_clear), null);
                                                                    textViewLclupha5.setTextSize(10.0f);
                                                                    linearLayoutLvtqoqa5.addView(textViewLclupha4, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height));
                                                                    layoutParams4.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa5.addView(textViewLclupha5, layoutParams4);
                                                                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams5.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams5.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top);
                                                                    linearLayout3.addView(linearLayoutLvtqoqa5, layoutParams5);
                                                                    final LinearLayout linearLayout4 = new LinearLayout(r3);
                                                                    linearLayout4.setOrientation(1);
                                                                    linearLayout3.addView(linearLayout4);
                                                                    ArrayList arrayList3 = new ArrayList();
                                                                    final boolean[] zArr = {false};
                                                                    ArrayList arrayList4 = arrayList3;
                                                                    final vntpaom vntpaomVar = new vntpaom(arrayList3, textViewOxoagud3, (Object) r3, textViewLclupha3, 3);
                                                                    final hhqpjvl hhqpjvlVar = new hhqpjvl(editText, arrayList4, strArr, (Object) r3, ghkjjruVarJdqigmr, 2);
                                                                    final int i7 = 0;
                                                                    ((TextView) ghkjjruVarJdqigmr.ojyssqt).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i7) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i8 = 1;
                                                                    ((TextView) ghkjjruVarJdqigmr.vivhedu).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i8) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i9 = 2;
                                                                    ((TextView) ghkjjruVarJdqigmr.lthborb).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i9) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    int[][] iArr = {new int[]{android.R.attr.state_checked}, new int[]{-16842912}};
                                                                    Iterator it = arrayList.iterator();
                                                                    LinearLayout r13 = linearLayout;
                                                                    ScrollView r15 = scrollView3;
                                                                    while (it.hasNext()) {
                                                                        final eenkamx eenkamxVar = (eenkamx) it.next();
                                                                        final LinearLayout linearLayout5 = new LinearLayout(r3);
                                                                        linearLayout5.setOrientation(0);
                                                                        linearLayout5.setGravity(16);
                                                                        linearLayout5.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
                                                                        String str = eenkamxVar.oqexvyb;
                                                                        linearLayout5.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_row_radius, r3, x.zamkzqg.tmdubwv(r3, str), x.zamkzqg.cugubfc(r3, str)));
                                                                        CheckBox checkBox = new CheckBox(r3);
                                                                        String str2 = eenkamxVar.oqexvyb;
                                                                        checkBox.setButtonTintList(new ColorStateList(iArr, new int[]{x.zamkzqg.cugubfc(r3, str2), x.zamkzqg.jbmzxye(r3)}));
                                                                        String str3 = eenkamxVar.ojyssqt;
                                                                        checkBox.setContentDescription(str3);
                                                                        linearLayout5.addView(checkBox);
                                                                        LinearLayout linearLayout6 = new LinearLayout(r3);
                                                                        linearLayout6.setOrientation(1);
                                                                        LinearLayout linearLayoutLvtqoqa6 = x.zamkzqg.lvtqoqa(r3);
                                                                        int[][] iArr2 = iArr;
                                                                        linearLayoutLvtqoqa6.setGravity(16);
                                                                        Iterator it2 = it;
                                                                        LinearLayout r20 = r13;
                                                                        mcdstyz mcdstyzVar3 = mcdstyzVar2;
                                                                        ScrollView r26 = r15;
                                                                        linearLayoutLvtqoqa6.addView(x.zamkzqg.oxoagud(r3, str3, 13, x.zamkzqg.zngzleo(r3), true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                                                                        TextView textViewOxoagud4 = x.zamkzqg.oxoagud(r3, r3.getString("red".equals(str2) ? R.string.parts_risk_red : "yellow".equals(str2) ? R.string.parts_risk_yellow : R.string.parts_risk_green), 9, x.zamkzqg.cugubfc(r3, str2), true);
                                                                        TextView textView = textViewLclupha4;
                                                                        textViewOxoagud4.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
                                                                        textViewOxoagud4.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_badge_radius, r3, x.zamkzqg.tmdubwv(r3, str2), r3.getColor(R.color.rynx_transparent)));
                                                                        linearLayoutLvtqoqa6.addView(textViewOxoagud4);
                                                                        linearLayout6.addView(linearLayoutLvtqoqa6);
                                                                        String str4 = eenkamxVar.qxvquar;
                                                                        boolean zEquals = "—".equals(str4);
                                                                        String str5 = eenkamxVar.lthborb;
                                                                        String str6 = eenkamxVar.vivhedu;
                                                                        TextView textViewOxoagud5 = x.zamkzqg.oxoagud(r3, zEquals ? r3.getString(R.string.batch_backup_partition_meta, str6, str5) : r3.getString(R.string.batch_backup_partition_meta_slot, str6, str5, str4), 10, x.zamkzqg.jbmzxye(r3), false);
                                                                        textViewOxoagud5.setPadding(0, r3.getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                                                                        linearLayout6.addView(textViewOxoagud5);
                                                                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                        layoutParams6.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap);
                                                                        linearLayout5.addView(linearLayout6, layoutParams6);
                                                                        ArrayList arrayList5 = arrayList4;
                                                                        arrayList5.add(new rpdxrib(eenkamxVar, linearLayout5, checkBox, (str3 + " " + str5 + " " + str4).toLowerCase(Locale.ROOT)));
                                                                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                                                                        int dimensionPixelSize = r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_gap);
                                                                        layoutParams7.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                                                                        linearLayout4.addView(linearLayout5, layoutParams7);
                                                                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: x.marclvq
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                                                                String str7 = eenkamxVar.oqexvyb;
                                                                                com.rynx.app.nmpwovh nmpwovhVar = r3;
                                                                                LinearLayout linearLayout7 = linearLayout5;
                                                                                linearLayout7.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar, x.zamkzqg.tmdubwv(nmpwovhVar, str7), z ? x.zamkzqg.nmpwovh(nmpwovhVar) : x.zamkzqg.cugubfc(nmpwovhVar, str7), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_radius)));
                                                                                if (zArr[0]) {
                                                                                    return;
                                                                                }
                                                                                x.zfmpmio.ojyssqt(linearLayout7);
                                                                                vntpaomVar.run();
                                                                            }
                                                                        });
                                                                        x.zamkzqg.utmeivs(r3, linearLayout5);
                                                                        linearLayout5.setOnClickListener(new mamlotu(checkBox, 0));
                                                                        arrayList4 = arrayList5;
                                                                        iArr = iArr2;
                                                                        it = it2;
                                                                        r13 = r20;
                                                                        r15 = r26;
                                                                        mcdstyzVar2 = mcdstyzVar3;
                                                                        textViewLclupha4 = textView;
                                                                    }
                                                                    LinearLayout r21 = r13;
                                                                    final ArrayList arrayList6 = arrayList4;
                                                                    final int i10 = 0;
                                                                    editText.addTextChangedListener(new xvxmcgn(hhqpjvlVar, 0));
                                                                    textViewLclupha4.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i10) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i11 = 1;
                                                                    textViewLclupha5.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i11) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    textViewLclupha3.setOnClickListener(new pzqxblc(arrayList6, mcdstyzVar2, i11));
                                                                    linearLayout3.addView(new View(r3), new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                                                                    vntpaomVar.run();
                                                                    hhqpjvlVar.run();
                                                                    r21.addView(r15, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                                                                    r3.kffvigz(r21, "batch_backup_selector");
                                                                } else {
                                                                    ohwxijw ohwxijwVar = (ohwxijw) arrayList2.get(i6);
                                                                    arrayList.add(new eenkamx(i6, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar.vivhedu), ohwxijwVar.lthborb, ohwxijwVar.qxvquar, ohwxijwVar.oqexvyb));
                                                                    i6++;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        Toast.makeText((Context) r3, R.string.error_busy, 0).show();
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                mcdstyzVar.nmpwovh.vopsyhw("all");
                                                break;
                                            default:
                                                mcdstyzVar.nmpwovh.gzokllk();
                                                break;
                                        }
                                    }
                                });
                                x.zamkzqg.enxkjpu(kggugdpVar, textViewLclupha2, R.drawable.ic_back, iNmpwovh2);
                                textViewLclupha2.setGravity(8388627);
                                linearLayoutXbdyiew2.addView(textViewLclupha2);
                                linearLayoutXbdyiew2.addView(x.zamkzqg.ywhgqsi(kggugdpVar, kggugdpVar.getString(R.string.batch_hub_title)));
                                TextView textViewOxoagud2 = x.zamkzqg.oxoagud(kggugdpVar, kggugdpVar.getString(R.string.batch_hub_subtitle), 12, x.zamkzqg.jbmzxye(kggugdpVar), false);
                                textViewOxoagud2.setPadding(0, 0, 0, kggugdpVar.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom));
                                linearLayoutXbdyiew2.addView(textViewOxoagud2);
                                final int i4 = 1;
                                linearLayoutXbdyiew2.addView(x.zamkzqg.yojulhu(kggugdpVar, R.string.batch_hub_backup_title, R.string.batch_hub_backup_desc, R.drawable.ic_backup, R.string.parts_backup_multiple, x.zamkzqg.nmpwovh(kggugdpVar), new View.OnClickListener() { // from class: x.udgizdi
                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r10v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v1 */
                                    /* JADX WARN: Type inference failed for: r13v11 */
                                    /* JADX WARN: Type inference failed for: r13v9 */
                                    /* JADX WARN: Type inference failed for: r15v13 */
                                    /* JADX WARN: Type inference failed for: r15v14 */
                                    /* JADX WARN: Type inference failed for: r15v5, types: [android.widget.ScrollView] */
                                    /* JADX WARN: Type inference failed for: r15v6 */
                                    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r20v1, types: [android.view.ViewGroup] */
                                    /* JADX WARN: Type inference failed for: r20v2 */
                                    /* JADX WARN: Type inference failed for: r26v0, types: [android.view.View] */
                                    /* JADX WARN: Type inference failed for: r26v1 */
                                    /* JADX WARN: Type inference failed for: r3v2, types: [android.app.Activity, android.content.Context, com.rynx.app.nmpwovh, com.rynx.app.ojyssqt, java.lang.Object, x.kggugdp] */
                                    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r6v18, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i4) {
                                            case 0:
                                                mcdstyzVar.nmpwovh.buswjhz();
                                                break;
                                            case 1:
                                                final kggugdp r3 = mcdstyzVar.nmpwovh;
                                                if (r3.wjugzfh()) {
                                                    if (!r3.lpkdqgx && !r3.ywhgqsi) {
                                                        if (r3.jbmzxye.isEmpty()) {
                                                            Toast.makeText((Context) r3, R.string.error_reading_partition_first, 0).show();
                                                            break;
                                                        } else if (r3.wjugzfh()) {
                                                            ArrayList arrayList = new ArrayList();
                                                            int i6 = 0;
                                                            while (true) {
                                                                ArrayList arrayList2 = r3.jbmzxye;
                                                                if (i6 >= arrayList2.size()) {
                                                                    mcdstyz mcdstyzVar2 = new mcdstyz(r3);
                                                                    LinearLayout linearLayout = new LinearLayout(r3);
                                                                    linearLayout.setOrientation(1);
                                                                    linearLayout.setBackgroundColor(x.zamkzqg.buswjhz(r3));
                                                                    LinearLayout linearLayout2 = new LinearLayout(r3);
                                                                    linearLayout2.setOrientation(1);
                                                                    linearLayout2.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
                                                                    LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa3.setGravity(16);
                                                                    linearLayoutLvtqoqa3.addView(x.zamkzqg.btazysh(r3, R.drawable.ic_back, x.zamkzqg.nmpwovh(r3), R.string.batch_hub_title, new nmpwovh(mcdstyzVar2, 3)), new LinearLayout.LayoutParams(r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
                                                                    TextView textViewOxoagud3 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_title), 20, x.zamkzqg.zngzleo(r3), true);
                                                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                    layoutParams.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa3.addView(textViewOxoagud3, layoutParams);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa3);
                                                                    LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa4.setGravity(16);
                                                                    TextView textViewOxoagud4 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_selected_count, 0), 11, x.zamkzqg.jbmzxye(r3), true);
                                                                    textViewOxoagud4.setGravity(17);
                                                                    textViewOxoagud4.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
                                                                    textViewOxoagud4.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    linearLayoutLvtqoqa4.addView(textViewOxoagud4);
                                                                    linearLayoutLvtqoqa4.addView(new View(r3), new LinearLayout.LayoutParams(0, 1, 1.0f));
                                                                    String string = r3.getString(R.string.batch_backup_action_compact, 0);
                                                                    int iKggugdp = x.zamkzqg.kggugdp(r3);
                                                                    TextView textViewLclupha3 = x.zamkzqg.lclupha(r3, string, null);
                                                                    x.zamkzqg.enxkjpu(r3, textViewLclupha3, R.drawable.ic_backup, iKggugdp);
                                                                    textViewLclupha3.setTextColor(x.zamkzqg.kggugdp(r3));
                                                                    textViewLclupha3.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.ojyssqt(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    textViewLclupha3.setEnabled(false);
                                                                    textViewLclupha3.setAlpha(0.42f);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha3, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams2.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa4, layoutParams2);
                                                                    linearLayout.addView(linearLayout2);
                                                                    ScrollView scrollView3 = new ScrollView(r3);
                                                                    scrollView3.setFillViewport(true);
                                                                    LinearLayout linearLayout3 = new LinearLayout(r3);
                                                                    linearLayout3.setOrientation(1);
                                                                    linearLayout3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
                                                                    scrollView3.addView(linearLayout3);
                                                                    linearLayout3.addView(x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_subtitle), 11, x.zamkzqg.jbmzxye(r3), false));
                                                                    EditText editText = new EditText(r3);
                                                                    editText.setSingleLine(true);
                                                                    editText.setTextColor(x.zamkzqg.zngzleo(r3));
                                                                    editText.setHintTextColor(x.zamkzqg.jbmzxye(r3));
                                                                    editText.setHint(R.string.batch_backup_search_hint);
                                                                    editText.setTextSize(13.0f);
                                                                    editText.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0, r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0);
                                                                    editText.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.ui_field_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, 0, 0);
                                                                    editText.setCompoundDrawablePadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap));
                                                                    editText.setCompoundDrawableTintList(ColorStateList.valueOf(x.zamkzqg.jbmzxye(r3)));
                                                                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.batch_backup_search_height));
                                                                    layoutParams3.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams3.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    linearLayout3.addView(editText, layoutParams3);
                                                                    final String[] strArr = {"green"};
                                                                    ghkjjru ghkjjruVarJdqigmr = x.zamkzqg.jdqigmr(r3, strArr[0], new jtfjrri(strArr, 0));
                                                                    linearLayout3.addView((LinearLayout) ghkjjruVarJdqigmr.nmpwovh, new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.risk_segment_container_height)));
                                                                    LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa5.setGravity(8388613);
                                                                    TextView textViewLclupha4 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_select_visible_short), null);
                                                                    textViewLclupha4.setTextSize(10.0f);
                                                                    TextView textViewLclupha5 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_clear), null);
                                                                    textViewLclupha5.setTextSize(10.0f);
                                                                    linearLayoutLvtqoqa5.addView(textViewLclupha4, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height));
                                                                    layoutParams4.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa5.addView(textViewLclupha5, layoutParams4);
                                                                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams5.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams5.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top);
                                                                    linearLayout3.addView(linearLayoutLvtqoqa5, layoutParams5);
                                                                    final LinearLayout linearLayout4 = new LinearLayout(r3);
                                                                    linearLayout4.setOrientation(1);
                                                                    linearLayout3.addView(linearLayout4);
                                                                    ArrayList arrayList3 = new ArrayList();
                                                                    final boolean[] zArr = {false};
                                                                    ArrayList arrayList4 = arrayList3;
                                                                    final vntpaom vntpaomVar = new vntpaom(arrayList3, textViewOxoagud4, (Object) r3, textViewLclupha3, 3);
                                                                    final hhqpjvl hhqpjvlVar = new hhqpjvl(editText, arrayList4, strArr, (Object) r3, ghkjjruVarJdqigmr, 2);
                                                                    final int i7 = 0;
                                                                    ((TextView) ghkjjruVarJdqigmr.ojyssqt).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i7) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i8 = 1;
                                                                    ((TextView) ghkjjruVarJdqigmr.vivhedu).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i8) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i9 = 2;
                                                                    ((TextView) ghkjjruVarJdqigmr.lthborb).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i9) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    int[][] iArr = {new int[]{android.R.attr.state_checked}, new int[]{-16842912}};
                                                                    Iterator it = arrayList.iterator();
                                                                    LinearLayout r13 = linearLayout;
                                                                    ScrollView r15 = scrollView3;
                                                                    while (it.hasNext()) {
                                                                        final eenkamx eenkamxVar = (eenkamx) it.next();
                                                                        final LinearLayout linearLayout5 = new LinearLayout(r3);
                                                                        linearLayout5.setOrientation(0);
                                                                        linearLayout5.setGravity(16);
                                                                        linearLayout5.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
                                                                        String str = eenkamxVar.oqexvyb;
                                                                        linearLayout5.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_row_radius, r3, x.zamkzqg.tmdubwv(r3, str), x.zamkzqg.cugubfc(r3, str)));
                                                                        CheckBox checkBox = new CheckBox(r3);
                                                                        String str2 = eenkamxVar.oqexvyb;
                                                                        checkBox.setButtonTintList(new ColorStateList(iArr, new int[]{x.zamkzqg.cugubfc(r3, str2), x.zamkzqg.jbmzxye(r3)}));
                                                                        String str3 = eenkamxVar.ojyssqt;
                                                                        checkBox.setContentDescription(str3);
                                                                        linearLayout5.addView(checkBox);
                                                                        LinearLayout linearLayout6 = new LinearLayout(r3);
                                                                        linearLayout6.setOrientation(1);
                                                                        LinearLayout linearLayoutLvtqoqa6 = x.zamkzqg.lvtqoqa(r3);
                                                                        int[][] iArr2 = iArr;
                                                                        linearLayoutLvtqoqa6.setGravity(16);
                                                                        Iterator it2 = it;
                                                                        LinearLayout r20 = r13;
                                                                        mcdstyz mcdstyzVar3 = mcdstyzVar2;
                                                                        ScrollView r26 = r15;
                                                                        linearLayoutLvtqoqa6.addView(x.zamkzqg.oxoagud(r3, str3, 13, x.zamkzqg.zngzleo(r3), true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                                                                        TextView textViewOxoagud5 = x.zamkzqg.oxoagud(r3, r3.getString("red".equals(str2) ? R.string.parts_risk_red : "yellow".equals(str2) ? R.string.parts_risk_yellow : R.string.parts_risk_green), 9, x.zamkzqg.cugubfc(r3, str2), true);
                                                                        TextView textView = textViewLclupha4;
                                                                        textViewOxoagud5.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
                                                                        textViewOxoagud5.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_badge_radius, r3, x.zamkzqg.tmdubwv(r3, str2), r3.getColor(R.color.rynx_transparent)));
                                                                        linearLayoutLvtqoqa6.addView(textViewOxoagud5);
                                                                        linearLayout6.addView(linearLayoutLvtqoqa6);
                                                                        String str4 = eenkamxVar.qxvquar;
                                                                        boolean zEquals = "—".equals(str4);
                                                                        String str5 = eenkamxVar.lthborb;
                                                                        String str6 = eenkamxVar.vivhedu;
                                                                        TextView textViewOxoagud6 = x.zamkzqg.oxoagud(r3, zEquals ? r3.getString(R.string.batch_backup_partition_meta, str6, str5) : r3.getString(R.string.batch_backup_partition_meta_slot, str6, str5, str4), 10, x.zamkzqg.jbmzxye(r3), false);
                                                                        textViewOxoagud6.setPadding(0, r3.getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                                                                        linearLayout6.addView(textViewOxoagud6);
                                                                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                        layoutParams6.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap);
                                                                        linearLayout5.addView(linearLayout6, layoutParams6);
                                                                        ArrayList arrayList5 = arrayList4;
                                                                        arrayList5.add(new rpdxrib(eenkamxVar, linearLayout5, checkBox, (str3 + " " + str5 + " " + str4).toLowerCase(Locale.ROOT)));
                                                                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                                                                        int dimensionPixelSize = r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_gap);
                                                                        layoutParams7.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                                                                        linearLayout4.addView(linearLayout5, layoutParams7);
                                                                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: x.marclvq
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                                                                String str7 = eenkamxVar.oqexvyb;
                                                                                com.rynx.app.nmpwovh nmpwovhVar = r3;
                                                                                LinearLayout linearLayout7 = linearLayout5;
                                                                                linearLayout7.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar, x.zamkzqg.tmdubwv(nmpwovhVar, str7), z ? x.zamkzqg.nmpwovh(nmpwovhVar) : x.zamkzqg.cugubfc(nmpwovhVar, str7), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_radius)));
                                                                                if (zArr[0]) {
                                                                                    return;
                                                                                }
                                                                                x.zfmpmio.ojyssqt(linearLayout7);
                                                                                vntpaomVar.run();
                                                                            }
                                                                        });
                                                                        x.zamkzqg.utmeivs(r3, linearLayout5);
                                                                        linearLayout5.setOnClickListener(new mamlotu(checkBox, 0));
                                                                        arrayList4 = arrayList5;
                                                                        iArr = iArr2;
                                                                        it = it2;
                                                                        r13 = r20;
                                                                        r15 = r26;
                                                                        mcdstyzVar2 = mcdstyzVar3;
                                                                        textViewLclupha4 = textView;
                                                                    }
                                                                    LinearLayout r21 = r13;
                                                                    final ArrayList arrayList6 = arrayList4;
                                                                    final int i10 = 0;
                                                                    editText.addTextChangedListener(new xvxmcgn(hhqpjvlVar, 0));
                                                                    textViewLclupha4.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i10) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i11 = 1;
                                                                    textViewLclupha5.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i11) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    textViewLclupha3.setOnClickListener(new pzqxblc(arrayList6, mcdstyzVar2, i11));
                                                                    linearLayout3.addView(new View(r3), new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                                                                    vntpaomVar.run();
                                                                    hhqpjvlVar.run();
                                                                    r21.addView(r15, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                                                                    r3.kffvigz(r21, "batch_backup_selector");
                                                                } else {
                                                                    ohwxijw ohwxijwVar = (ohwxijw) arrayList2.get(i6);
                                                                    arrayList.add(new eenkamx(i6, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar.vivhedu), ohwxijwVar.lthborb, ohwxijwVar.qxvquar, ohwxijwVar.oqexvyb));
                                                                    i6++;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        Toast.makeText((Context) r3, R.string.error_busy, 0).show();
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                mcdstyzVar.nmpwovh.vopsyhw("all");
                                                break;
                                            default:
                                                mcdstyzVar.nmpwovh.gzokllk();
                                                break;
                                        }
                                    }
                                }), x.zamkzqg.uiqyzsp(kggugdpVar));
                                final int i5 = 2;
                                linearLayoutXbdyiew2.addView(x.zamkzqg.yojulhu(kggugdpVar, R.string.batch_hub_flash_title, R.string.batch_hub_flash_desc, R.drawable.ic_flash, R.string.parts_flash_multiple, x.zamkzqg.kggugdp(kggugdpVar), new View.OnClickListener() { // from class: x.udgizdi
                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r10v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v1 */
                                    /* JADX WARN: Type inference failed for: r13v11 */
                                    /* JADX WARN: Type inference failed for: r13v9 */
                                    /* JADX WARN: Type inference failed for: r15v13 */
                                    /* JADX WARN: Type inference failed for: r15v14 */
                                    /* JADX WARN: Type inference failed for: r15v5, types: [android.widget.ScrollView] */
                                    /* JADX WARN: Type inference failed for: r15v6 */
                                    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r20v1, types: [android.view.ViewGroup] */
                                    /* JADX WARN: Type inference failed for: r20v2 */
                                    /* JADX WARN: Type inference failed for: r26v0, types: [android.view.View] */
                                    /* JADX WARN: Type inference failed for: r26v1 */
                                    /* JADX WARN: Type inference failed for: r3v2, types: [android.app.Activity, android.content.Context, com.rynx.app.nmpwovh, com.rynx.app.ojyssqt, java.lang.Object, x.kggugdp] */
                                    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r6v18, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i5) {
                                            case 0:
                                                mcdstyzVar.nmpwovh.buswjhz();
                                                break;
                                            case 1:
                                                final kggugdp r3 = mcdstyzVar.nmpwovh;
                                                if (r3.wjugzfh()) {
                                                    if (!r3.lpkdqgx && !r3.ywhgqsi) {
                                                        if (r3.jbmzxye.isEmpty()) {
                                                            Toast.makeText((Context) r3, R.string.error_reading_partition_first, 0).show();
                                                            break;
                                                        } else if (r3.wjugzfh()) {
                                                            ArrayList arrayList = new ArrayList();
                                                            int i6 = 0;
                                                            while (true) {
                                                                ArrayList arrayList2 = r3.jbmzxye;
                                                                if (i6 >= arrayList2.size()) {
                                                                    mcdstyz mcdstyzVar2 = new mcdstyz(r3);
                                                                    LinearLayout linearLayout = new LinearLayout(r3);
                                                                    linearLayout.setOrientation(1);
                                                                    linearLayout.setBackgroundColor(x.zamkzqg.buswjhz(r3));
                                                                    LinearLayout linearLayout2 = new LinearLayout(r3);
                                                                    linearLayout2.setOrientation(1);
                                                                    linearLayout2.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
                                                                    LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa3.setGravity(16);
                                                                    linearLayoutLvtqoqa3.addView(x.zamkzqg.btazysh(r3, R.drawable.ic_back, x.zamkzqg.nmpwovh(r3), R.string.batch_hub_title, new nmpwovh(mcdstyzVar2, 3)), new LinearLayout.LayoutParams(r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
                                                                    TextView textViewOxoagud3 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_title), 20, x.zamkzqg.zngzleo(r3), true);
                                                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                    layoutParams.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa3.addView(textViewOxoagud3, layoutParams);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa3);
                                                                    LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa4.setGravity(16);
                                                                    TextView textViewOxoagud4 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_selected_count, 0), 11, x.zamkzqg.jbmzxye(r3), true);
                                                                    textViewOxoagud4.setGravity(17);
                                                                    textViewOxoagud4.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
                                                                    textViewOxoagud4.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    linearLayoutLvtqoqa4.addView(textViewOxoagud4);
                                                                    linearLayoutLvtqoqa4.addView(new View(r3), new LinearLayout.LayoutParams(0, 1, 1.0f));
                                                                    String string = r3.getString(R.string.batch_backup_action_compact, 0);
                                                                    int iKggugdp = x.zamkzqg.kggugdp(r3);
                                                                    TextView textViewLclupha3 = x.zamkzqg.lclupha(r3, string, null);
                                                                    x.zamkzqg.enxkjpu(r3, textViewLclupha3, R.drawable.ic_backup, iKggugdp);
                                                                    textViewLclupha3.setTextColor(x.zamkzqg.kggugdp(r3));
                                                                    textViewLclupha3.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.ojyssqt(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    textViewLclupha3.setEnabled(false);
                                                                    textViewLclupha3.setAlpha(0.42f);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha3, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams2.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa4, layoutParams2);
                                                                    linearLayout.addView(linearLayout2);
                                                                    ScrollView scrollView3 = new ScrollView(r3);
                                                                    scrollView3.setFillViewport(true);
                                                                    LinearLayout linearLayout3 = new LinearLayout(r3);
                                                                    linearLayout3.setOrientation(1);
                                                                    linearLayout3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
                                                                    scrollView3.addView(linearLayout3);
                                                                    linearLayout3.addView(x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_subtitle), 11, x.zamkzqg.jbmzxye(r3), false));
                                                                    EditText editText = new EditText(r3);
                                                                    editText.setSingleLine(true);
                                                                    editText.setTextColor(x.zamkzqg.zngzleo(r3));
                                                                    editText.setHintTextColor(x.zamkzqg.jbmzxye(r3));
                                                                    editText.setHint(R.string.batch_backup_search_hint);
                                                                    editText.setTextSize(13.0f);
                                                                    editText.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0, r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0);
                                                                    editText.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.ui_field_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, 0, 0);
                                                                    editText.setCompoundDrawablePadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap));
                                                                    editText.setCompoundDrawableTintList(ColorStateList.valueOf(x.zamkzqg.jbmzxye(r3)));
                                                                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.batch_backup_search_height));
                                                                    layoutParams3.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams3.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    linearLayout3.addView(editText, layoutParams3);
                                                                    final String[] strArr = {"green"};
                                                                    ghkjjru ghkjjruVarJdqigmr = x.zamkzqg.jdqigmr(r3, strArr[0], new jtfjrri(strArr, 0));
                                                                    linearLayout3.addView((LinearLayout) ghkjjruVarJdqigmr.nmpwovh, new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.risk_segment_container_height)));
                                                                    LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa5.setGravity(8388613);
                                                                    TextView textViewLclupha4 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_select_visible_short), null);
                                                                    textViewLclupha4.setTextSize(10.0f);
                                                                    TextView textViewLclupha5 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_clear), null);
                                                                    textViewLclupha5.setTextSize(10.0f);
                                                                    linearLayoutLvtqoqa5.addView(textViewLclupha4, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height));
                                                                    layoutParams4.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa5.addView(textViewLclupha5, layoutParams4);
                                                                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams5.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams5.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top);
                                                                    linearLayout3.addView(linearLayoutLvtqoqa5, layoutParams5);
                                                                    final LinearLayout linearLayout4 = new LinearLayout(r3);
                                                                    linearLayout4.setOrientation(1);
                                                                    linearLayout3.addView(linearLayout4);
                                                                    ArrayList arrayList3 = new ArrayList();
                                                                    final boolean[] zArr = {false};
                                                                    ArrayList arrayList4 = arrayList3;
                                                                    final vntpaom vntpaomVar = new vntpaom(arrayList3, textViewOxoagud4, (Object) r3, textViewLclupha3, 3);
                                                                    final hhqpjvl hhqpjvlVar = new hhqpjvl(editText, arrayList4, strArr, (Object) r3, ghkjjruVarJdqigmr, 2);
                                                                    final int i7 = 0;
                                                                    ((TextView) ghkjjruVarJdqigmr.ojyssqt).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i7) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i8 = 1;
                                                                    ((TextView) ghkjjruVarJdqigmr.vivhedu).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i8) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i9 = 2;
                                                                    ((TextView) ghkjjruVarJdqigmr.lthborb).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i9) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    int[][] iArr = {new int[]{android.R.attr.state_checked}, new int[]{-16842912}};
                                                                    Iterator it = arrayList.iterator();
                                                                    LinearLayout r13 = linearLayout;
                                                                    ScrollView r15 = scrollView3;
                                                                    while (it.hasNext()) {
                                                                        final eenkamx eenkamxVar = (eenkamx) it.next();
                                                                        final LinearLayout linearLayout5 = new LinearLayout(r3);
                                                                        linearLayout5.setOrientation(0);
                                                                        linearLayout5.setGravity(16);
                                                                        linearLayout5.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
                                                                        String str = eenkamxVar.oqexvyb;
                                                                        linearLayout5.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_row_radius, r3, x.zamkzqg.tmdubwv(r3, str), x.zamkzqg.cugubfc(r3, str)));
                                                                        CheckBox checkBox = new CheckBox(r3);
                                                                        String str2 = eenkamxVar.oqexvyb;
                                                                        checkBox.setButtonTintList(new ColorStateList(iArr, new int[]{x.zamkzqg.cugubfc(r3, str2), x.zamkzqg.jbmzxye(r3)}));
                                                                        String str3 = eenkamxVar.ojyssqt;
                                                                        checkBox.setContentDescription(str3);
                                                                        linearLayout5.addView(checkBox);
                                                                        LinearLayout linearLayout6 = new LinearLayout(r3);
                                                                        linearLayout6.setOrientation(1);
                                                                        LinearLayout linearLayoutLvtqoqa6 = x.zamkzqg.lvtqoqa(r3);
                                                                        int[][] iArr2 = iArr;
                                                                        linearLayoutLvtqoqa6.setGravity(16);
                                                                        Iterator it2 = it;
                                                                        LinearLayout r20 = r13;
                                                                        mcdstyz mcdstyzVar3 = mcdstyzVar2;
                                                                        ScrollView r26 = r15;
                                                                        linearLayoutLvtqoqa6.addView(x.zamkzqg.oxoagud(r3, str3, 13, x.zamkzqg.zngzleo(r3), true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                                                                        TextView textViewOxoagud5 = x.zamkzqg.oxoagud(r3, r3.getString("red".equals(str2) ? R.string.parts_risk_red : "yellow".equals(str2) ? R.string.parts_risk_yellow : R.string.parts_risk_green), 9, x.zamkzqg.cugubfc(r3, str2), true);
                                                                        TextView textView = textViewLclupha4;
                                                                        textViewOxoagud5.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
                                                                        textViewOxoagud5.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_badge_radius, r3, x.zamkzqg.tmdubwv(r3, str2), r3.getColor(R.color.rynx_transparent)));
                                                                        linearLayoutLvtqoqa6.addView(textViewOxoagud5);
                                                                        linearLayout6.addView(linearLayoutLvtqoqa6);
                                                                        String str4 = eenkamxVar.qxvquar;
                                                                        boolean zEquals = "—".equals(str4);
                                                                        String str5 = eenkamxVar.lthborb;
                                                                        String str6 = eenkamxVar.vivhedu;
                                                                        TextView textViewOxoagud6 = x.zamkzqg.oxoagud(r3, zEquals ? r3.getString(R.string.batch_backup_partition_meta, str6, str5) : r3.getString(R.string.batch_backup_partition_meta_slot, str6, str5, str4), 10, x.zamkzqg.jbmzxye(r3), false);
                                                                        textViewOxoagud6.setPadding(0, r3.getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                                                                        linearLayout6.addView(textViewOxoagud6);
                                                                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                        layoutParams6.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap);
                                                                        linearLayout5.addView(linearLayout6, layoutParams6);
                                                                        ArrayList arrayList5 = arrayList4;
                                                                        arrayList5.add(new rpdxrib(eenkamxVar, linearLayout5, checkBox, (str3 + " " + str5 + " " + str4).toLowerCase(Locale.ROOT)));
                                                                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                                                                        int dimensionPixelSize = r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_gap);
                                                                        layoutParams7.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                                                                        linearLayout4.addView(linearLayout5, layoutParams7);
                                                                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: x.marclvq
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                                                                String str7 = eenkamxVar.oqexvyb;
                                                                                com.rynx.app.nmpwovh nmpwovhVar = r3;
                                                                                LinearLayout linearLayout7 = linearLayout5;
                                                                                linearLayout7.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar, x.zamkzqg.tmdubwv(nmpwovhVar, str7), z ? x.zamkzqg.nmpwovh(nmpwovhVar) : x.zamkzqg.cugubfc(nmpwovhVar, str7), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_radius)));
                                                                                if (zArr[0]) {
                                                                                    return;
                                                                                }
                                                                                x.zfmpmio.ojyssqt(linearLayout7);
                                                                                vntpaomVar.run();
                                                                            }
                                                                        });
                                                                        x.zamkzqg.utmeivs(r3, linearLayout5);
                                                                        linearLayout5.setOnClickListener(new mamlotu(checkBox, 0));
                                                                        arrayList4 = arrayList5;
                                                                        iArr = iArr2;
                                                                        it = it2;
                                                                        r13 = r20;
                                                                        r15 = r26;
                                                                        mcdstyzVar2 = mcdstyzVar3;
                                                                        textViewLclupha4 = textView;
                                                                    }
                                                                    LinearLayout r21 = r13;
                                                                    final ArrayList arrayList6 = arrayList4;
                                                                    final int i10 = 0;
                                                                    editText.addTextChangedListener(new xvxmcgn(hhqpjvlVar, 0));
                                                                    textViewLclupha4.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i10) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i11 = 1;
                                                                    textViewLclupha5.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i11) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    textViewLclupha3.setOnClickListener(new pzqxblc(arrayList6, mcdstyzVar2, i11));
                                                                    linearLayout3.addView(new View(r3), new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                                                                    vntpaomVar.run();
                                                                    hhqpjvlVar.run();
                                                                    r21.addView(r15, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                                                                    r3.kffvigz(r21, "batch_backup_selector");
                                                                } else {
                                                                    ohwxijw ohwxijwVar = (ohwxijw) arrayList2.get(i6);
                                                                    arrayList.add(new eenkamx(i6, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar.vivhedu), ohwxijwVar.lthborb, ohwxijwVar.qxvquar, ohwxijwVar.oqexvyb));
                                                                    i6++;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        Toast.makeText((Context) r3, R.string.error_busy, 0).show();
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                mcdstyzVar.nmpwovh.vopsyhw("all");
                                                break;
                                            default:
                                                mcdstyzVar.nmpwovh.gzokllk();
                                                break;
                                        }
                                    }
                                }), x.zamkzqg.uiqyzsp(kggugdpVar));
                                final int i6 = 3;
                                linearLayoutXbdyiew2.addView(x.zamkzqg.yojulhu(kggugdpVar, R.string.batch_hub_scatter_title, R.string.batch_hub_scatter_desc, R.drawable.ic_file, R.string.batch_hub_scatter_action, x.zamkzqg.ohwxijw(kggugdpVar), new View.OnClickListener() { // from class: x.udgizdi
                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Type inference failed for: r10v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r13v1 */
                                    /* JADX WARN: Type inference failed for: r13v11 */
                                    /* JADX WARN: Type inference failed for: r13v9 */
                                    /* JADX WARN: Type inference failed for: r15v13 */
                                    /* JADX WARN: Type inference failed for: r15v14 */
                                    /* JADX WARN: Type inference failed for: r15v5, types: [android.widget.ScrollView] */
                                    /* JADX WARN: Type inference failed for: r15v6 */
                                    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r20v1, types: [android.view.ViewGroup] */
                                    /* JADX WARN: Type inference failed for: r20v2 */
                                    /* JADX WARN: Type inference failed for: r26v0, types: [android.view.View] */
                                    /* JADX WARN: Type inference failed for: r26v1 */
                                    /* JADX WARN: Type inference failed for: r3v2, types: [android.app.Activity, android.content.Context, com.rynx.app.nmpwovh, com.rynx.app.ojyssqt, java.lang.Object, x.kggugdp] */
                                    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference failed for: r6v18, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
                                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
                                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                                     */
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i6) {
                                            case 0:
                                                mcdstyzVar.nmpwovh.buswjhz();
                                                break;
                                            case 1:
                                                final kggugdp r3 = mcdstyzVar.nmpwovh;
                                                if (r3.wjugzfh()) {
                                                    if (!r3.lpkdqgx && !r3.ywhgqsi) {
                                                        if (r3.jbmzxye.isEmpty()) {
                                                            Toast.makeText((Context) r3, R.string.error_reading_partition_first, 0).show();
                                                            break;
                                                        } else if (r3.wjugzfh()) {
                                                            ArrayList arrayList = new ArrayList();
                                                            int i7 = 0;
                                                            while (true) {
                                                                ArrayList arrayList2 = r3.jbmzxye;
                                                                if (i7 >= arrayList2.size()) {
                                                                    mcdstyz mcdstyzVar2 = new mcdstyz(r3);
                                                                    LinearLayout linearLayout = new LinearLayout(r3);
                                                                    linearLayout.setOrientation(1);
                                                                    linearLayout.setBackgroundColor(x.zamkzqg.buswjhz(r3));
                                                                    LinearLayout linearLayout2 = new LinearLayout(r3);
                                                                    linearLayout2.setOrientation(1);
                                                                    linearLayout2.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
                                                                    LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa3.setGravity(16);
                                                                    linearLayoutLvtqoqa3.addView(x.zamkzqg.btazysh(r3, R.drawable.ic_back, x.zamkzqg.nmpwovh(r3), R.string.batch_hub_title, new nmpwovh(mcdstyzVar2, 3)), new LinearLayout.LayoutParams(r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), r3.getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
                                                                    TextView textViewOxoagud3 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_title), 20, x.zamkzqg.zngzleo(r3), true);
                                                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                    layoutParams.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa3.addView(textViewOxoagud3, layoutParams);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa3);
                                                                    LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa4.setGravity(16);
                                                                    TextView textViewOxoagud4 = x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_selected_count, 0), 11, x.zamkzqg.jbmzxye(r3), true);
                                                                    textViewOxoagud4.setGravity(17);
                                                                    textViewOxoagud4.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
                                                                    textViewOxoagud4.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    linearLayoutLvtqoqa4.addView(textViewOxoagud4);
                                                                    linearLayoutLvtqoqa4.addView(new View(r3), new LinearLayout.LayoutParams(0, 1, 1.0f));
                                                                    String string = r3.getString(R.string.batch_backup_action_compact, 0);
                                                                    int iKggugdp = x.zamkzqg.kggugdp(r3);
                                                                    TextView textViewLclupha3 = x.zamkzqg.lclupha(r3, string, null);
                                                                    x.zamkzqg.enxkjpu(r3, textViewLclupha3, R.drawable.ic_backup, iKggugdp);
                                                                    textViewLclupha3.setTextColor(x.zamkzqg.kggugdp(r3));
                                                                    textViewLclupha3.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_sticky_action_radius, r3, x.zamkzqg.ojyssqt(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    textViewLclupha3.setEnabled(false);
                                                                    textViewLclupha3.setAlpha(0.42f);
                                                                    linearLayoutLvtqoqa4.addView(textViewLclupha3, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams2.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayout2.addView(linearLayoutLvtqoqa4, layoutParams2);
                                                                    linearLayout.addView(linearLayout2);
                                                                    ScrollView scrollView3 = new ScrollView(r3);
                                                                    scrollView3.setFillViewport(true);
                                                                    LinearLayout linearLayout3 = new LinearLayout(r3);
                                                                    linearLayout3.setOrientation(1);
                                                                    linearLayout3.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), r3.getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
                                                                    scrollView3.addView(linearLayout3);
                                                                    linearLayout3.addView(x.zamkzqg.oxoagud(r3, r3.getString(R.string.batch_backup_select_subtitle), 11, x.zamkzqg.jbmzxye(r3), false));
                                                                    EditText editText = new EditText(r3);
                                                                    editText.setSingleLine(true);
                                                                    editText.setTextColor(x.zamkzqg.zngzleo(r3));
                                                                    editText.setHintTextColor(x.zamkzqg.jbmzxye(r3));
                                                                    editText.setHint(R.string.batch_backup_search_hint);
                                                                    editText.setTextSize(13.0f);
                                                                    editText.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0, r3.getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0);
                                                                    editText.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.ui_field_radius, r3, x.zamkzqg.atntgcp(r3), r3.getColor(R.color.rynx_transparent)));
                                                                    editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, 0, 0);
                                                                    editText.setCompoundDrawablePadding(r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap));
                                                                    editText.setCompoundDrawableTintList(ColorStateList.valueOf(x.zamkzqg.jbmzxye(r3)));
                                                                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.batch_backup_search_height));
                                                                    layoutParams3.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams3.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    linearLayout3.addView(editText, layoutParams3);
                                                                    final String[] strArr = {"green"};
                                                                    ghkjjru ghkjjruVarJdqigmr = x.zamkzqg.jdqigmr(r3, strArr[0], new jtfjrri(strArr, 0));
                                                                    linearLayout3.addView((LinearLayout) ghkjjruVarJdqigmr.nmpwovh, new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.risk_segment_container_height)));
                                                                    LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(r3);
                                                                    linearLayoutLvtqoqa5.setGravity(8388613);
                                                                    TextView textViewLclupha4 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_select_visible_short), null);
                                                                    textViewLclupha4.setTextSize(10.0f);
                                                                    TextView textViewLclupha5 = x.zamkzqg.lclupha(r3, r3.getString(R.string.batch_backup_clear), null);
                                                                    textViewLclupha5.setTextSize(10.0f);
                                                                    linearLayoutLvtqoqa5.addView(textViewLclupha4, new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height)));
                                                                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_small_action_height));
                                                                    layoutParams4.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
                                                                    linearLayoutLvtqoqa5.addView(textViewLclupha5, layoutParams4);
                                                                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                                                                    layoutParams5.topMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
                                                                    layoutParams5.bottomMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top);
                                                                    linearLayout3.addView(linearLayoutLvtqoqa5, layoutParams5);
                                                                    final LinearLayout linearLayout4 = new LinearLayout(r3);
                                                                    linearLayout4.setOrientation(1);
                                                                    linearLayout3.addView(linearLayout4);
                                                                    ArrayList arrayList3 = new ArrayList();
                                                                    final boolean[] zArr = {false};
                                                                    ArrayList arrayList4 = arrayList3;
                                                                    final vntpaom vntpaomVar = new vntpaom(arrayList3, textViewOxoagud4, (Object) r3, textViewLclupha3, 3);
                                                                    final hhqpjvl hhqpjvlVar = new hhqpjvl(editText, arrayList4, strArr, (Object) r3, ghkjjruVarJdqigmr, 2);
                                                                    final int i8 = 0;
                                                                    ((TextView) ghkjjruVarJdqigmr.ojyssqt).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i8) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i9 = 1;
                                                                    ((TextView) ghkjjruVarJdqigmr.vivhedu).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i9) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i10 = 2;
                                                                    ((TextView) ghkjjruVarJdqigmr.lthborb).setOnClickListener(new View.OnClickListener() { // from class: x.iwjoiry
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i10) {
                                                                                case 0:
                                                                                    strArr[0] = "green";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                case 1:
                                                                                    strArr[0] = "yellow";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                                default:
                                                                                    strArr[0] = "red";
                                                                                    hhqpjvlVar.run();
                                                                                    x.zfmpmio.lthborb(r3, linearLayout4, true);
                                                                                    break;
                                                                            }
                                                                        }
                                                                    });
                                                                    int[][] iArr = {new int[]{android.R.attr.state_checked}, new int[]{-16842912}};
                                                                    Iterator it = arrayList.iterator();
                                                                    LinearLayout r13 = linearLayout;
                                                                    ScrollView r15 = scrollView3;
                                                                    while (it.hasNext()) {
                                                                        final eenkamx eenkamxVar = (eenkamx) it.next();
                                                                        final LinearLayout linearLayout5 = new LinearLayout(r3);
                                                                        linearLayout5.setOrientation(0);
                                                                        linearLayout5.setGravity(16);
                                                                        linearLayout5.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
                                                                        String str = eenkamxVar.oqexvyb;
                                                                        linearLayout5.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_row_radius, r3, x.zamkzqg.tmdubwv(r3, str), x.zamkzqg.cugubfc(r3, str)));
                                                                        CheckBox checkBox = new CheckBox(r3);
                                                                        String str2 = eenkamxVar.oqexvyb;
                                                                        checkBox.setButtonTintList(new ColorStateList(iArr, new int[]{x.zamkzqg.cugubfc(r3, str2), x.zamkzqg.jbmzxye(r3)}));
                                                                        String str3 = eenkamxVar.ojyssqt;
                                                                        checkBox.setContentDescription(str3);
                                                                        linearLayout5.addView(checkBox);
                                                                        LinearLayout linearLayout6 = new LinearLayout(r3);
                                                                        linearLayout6.setOrientation(1);
                                                                        LinearLayout linearLayoutLvtqoqa6 = x.zamkzqg.lvtqoqa(r3);
                                                                        int[][] iArr2 = iArr;
                                                                        linearLayoutLvtqoqa6.setGravity(16);
                                                                        Iterator it2 = it;
                                                                        LinearLayout r20 = r13;
                                                                        mcdstyz mcdstyzVar3 = mcdstyzVar2;
                                                                        ScrollView r26 = r15;
                                                                        linearLayoutLvtqoqa6.addView(x.zamkzqg.oxoagud(r3, str3, 13, x.zamkzqg.zngzleo(r3), true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                                                                        TextView textViewOxoagud5 = x.zamkzqg.oxoagud(r3, r3.getString("red".equals(str2) ? R.string.parts_risk_red : "yellow".equals(str2) ? R.string.parts_risk_yellow : R.string.parts_risk_green), 9, x.zamkzqg.cugubfc(r3, str2), true);
                                                                        TextView textView = textViewLclupha4;
                                                                        textViewOxoagud5.setPadding(r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
                                                                        textViewOxoagud5.setBackground(x.sjexbpf.nmpwovh(r3, R.dimen.batch_compact_badge_radius, r3, x.zamkzqg.tmdubwv(r3, str2), r3.getColor(R.color.rynx_transparent)));
                                                                        linearLayoutLvtqoqa6.addView(textViewOxoagud5);
                                                                        linearLayout6.addView(linearLayoutLvtqoqa6);
                                                                        String str4 = eenkamxVar.qxvquar;
                                                                        boolean zEquals = "—".equals(str4);
                                                                        String str5 = eenkamxVar.lthborb;
                                                                        String str6 = eenkamxVar.vivhedu;
                                                                        TextView textViewOxoagud6 = x.zamkzqg.oxoagud(r3, zEquals ? r3.getString(R.string.batch_backup_partition_meta, str6, str5) : r3.getString(R.string.batch_backup_partition_meta_slot, str6, str5, str4), 10, x.zamkzqg.jbmzxye(r3), false);
                                                                        textViewOxoagud6.setPadding(0, r3.getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                                                                        linearLayout6.addView(textViewOxoagud6);
                                                                        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                                                                        layoutParams6.leftMargin = r3.getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap);
                                                                        linearLayout5.addView(linearLayout6, layoutParams6);
                                                                        ArrayList arrayList5 = arrayList4;
                                                                        arrayList5.add(new rpdxrib(eenkamxVar, linearLayout5, checkBox, (str3 + " " + str5 + " " + str4).toLowerCase(Locale.ROOT)));
                                                                        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                                                                        int dimensionPixelSize = r3.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_gap);
                                                                        layoutParams7.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                                                                        linearLayout4.addView(linearLayout5, layoutParams7);
                                                                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: x.marclvq
                                                                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                                                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                                                                String str7 = eenkamxVar.oqexvyb;
                                                                                com.rynx.app.nmpwovh nmpwovhVar = r3;
                                                                                LinearLayout linearLayout7 = linearLayout5;
                                                                                linearLayout7.setBackground(x.zamkzqg.jvtqflj(nmpwovhVar, x.zamkzqg.tmdubwv(nmpwovhVar, str7), z ? x.zamkzqg.nmpwovh(nmpwovhVar) : x.zamkzqg.cugubfc(nmpwovhVar, str7), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.batch_compact_row_radius)));
                                                                                if (zArr[0]) {
                                                                                    return;
                                                                                }
                                                                                x.zfmpmio.ojyssqt(linearLayout7);
                                                                                vntpaomVar.run();
                                                                            }
                                                                        });
                                                                        x.zamkzqg.utmeivs(r3, linearLayout5);
                                                                        linearLayout5.setOnClickListener(new mamlotu(checkBox, 0));
                                                                        arrayList4 = arrayList5;
                                                                        iArr = iArr2;
                                                                        it = it2;
                                                                        r13 = r20;
                                                                        r15 = r26;
                                                                        mcdstyzVar2 = mcdstyzVar3;
                                                                        textViewLclupha4 = textView;
                                                                    }
                                                                    LinearLayout r21 = r13;
                                                                    final ArrayList arrayList6 = arrayList4;
                                                                    final int i11 = 0;
                                                                    editText.addTextChangedListener(new xvxmcgn(hhqpjvlVar, 0));
                                                                    textViewLclupha4.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i11) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    final int i12 = 1;
                                                                    textViewLclupha5.setOnClickListener(new View.OnClickListener() { // from class: x.yojulhu
                                                                        @Override // android.view.View.OnClickListener
                                                                        public final void onClick(View view3) {
                                                                            switch (i12) {
                                                                                case 0:
                                                                                    ArrayList<rpdxrib> arrayList7 = arrayList6;
                                                                                    boolean[] zArr2 = zArr;
                                                                                    zArr2[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar : arrayList7) {
                                                                                            LinearLayout linearLayout7 = rpdxribVar.ojyssqt;
                                                                                            CheckBox checkBox2 = rpdxribVar.vivhedu;
                                                                                            if (linearLayout7.getVisibility() == 0 && !checkBox2.isChecked()) {
                                                                                                checkBox2.setChecked(true);
                                                                                            }
                                                                                        }
                                                                                        zArr2[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th) {
                                                                                        zArr2[0] = false;
                                                                                        throw th;
                                                                                    }
                                                                                default:
                                                                                    ArrayList<rpdxrib> arrayList8 = arrayList6;
                                                                                    boolean[] zArr3 = zArr;
                                                                                    zArr3[0] = true;
                                                                                    try {
                                                                                        for (rpdxrib rpdxribVar2 : arrayList8) {
                                                                                            if (rpdxribVar2.vivhedu.isChecked()) {
                                                                                                rpdxribVar2.vivhedu.setChecked(false);
                                                                                            }
                                                                                        }
                                                                                        zArr3[0] = false;
                                                                                        vntpaomVar.run();
                                                                                        return;
                                                                                    } catch (Throwable th2) {
                                                                                        zArr3[0] = false;
                                                                                        throw th2;
                                                                                    }
                                                                            }
                                                                        }
                                                                    });
                                                                    textViewLclupha3.setOnClickListener(new pzqxblc(arrayList6, mcdstyzVar2, i12));
                                                                    linearLayout3.addView(new View(r3), new LinearLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                                                                    vntpaomVar.run();
                                                                    hhqpjvlVar.run();
                                                                    r21.addView(r15, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                                                                    r3.kffvigz(r21, "batch_backup_selector");
                                                                } else {
                                                                    ohwxijw ohwxijwVar = (ohwxijw) arrayList2.get(i7);
                                                                    arrayList.add(new eenkamx(i7, ohwxijwVar.nmpwovh, x.zamkzqg.jybecxv(ohwxijwVar.vivhedu), ohwxijwVar.lthborb, ohwxijwVar.qxvquar, ohwxijwVar.oqexvyb));
                                                                    i7++;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        Toast.makeText((Context) r3, R.string.error_busy, 0).show();
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                mcdstyzVar.nmpwovh.vopsyhw("all");
                                                break;
                                            default:
                                                mcdstyzVar.nmpwovh.gzokllk();
                                                break;
                                        }
                                    }
                                }), x.zamkzqg.uiqyzsp(kggugdpVar));
                                linearLayoutXbdyiew2.addView(new View(kggugdpVar), new LinearLayout.LayoutParams(-1, kggugdpVar.getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
                                kggugdpVar.kffvigz(scrollView2, "batch_hub");
                            } else {
                                Toast.makeText(kggugdpVar, R.string.error_reading_partition_first, 0).show();
                            }
                            break;
                        }
                        break;
                }
            }
        });
        x.zamkzqg.enxkjpu(this, textViewLclupha, R.drawable.ic_more, iNmpwovh);
        textViewLclupha.setTextSize(10.0f);
        linearLayoutLvtqoqa2.addView(textViewLclupha, new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.partition_header_gap);
        linearLayoutXbdyiew.addView(linearLayoutLvtqoqa2, layoutParams);
        EditText editText = new EditText(this);
        editText.setSingleLine(true);
        editText.setTextColor(x.zamkzqg.zngzleo(this));
        editText.setHintTextColor(x.zamkzqg.jbmzxye(this));
        editText.setHint(R.string.parts_search_hint);
        editText.setTextSize(13.0f);
        editText.setPadding(getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0, getResources().getDimensionPixelSize(R.dimen.ui_field_padding), 0);
        editText.setBackground(x.zamkzqg.jvtqflj(this, x.zamkzqg.atntgcp(this), getColor(R.color.rynx_transparent), getResources().getDimensionPixelSize(R.dimen.ui_field_radius)));
        editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, 0, 0);
        editText.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap));
        editText.setCompoundDrawableTintList(ColorStateList.valueOf(x.zamkzqg.jbmzxye(this)));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.batch_backup_search_height));
        layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
        linearLayoutXbdyiew.addView(editText, layoutParams2);
        editText.addTextChangedListener(new xvxmcgn(xbdyiewVar, 1));
        ghkjjru ghkjjruVarJdqigmr = x.zamkzqg.jdqigmr(this, "green", new kpmmknm(xbdyiewVar));
        linearLayoutXbdyiew.addView((LinearLayout) ghkjjruVarJdqigmr.nmpwovh, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.risk_segment_container_height)));
        TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, getString(R.string.parts_ready_read), 11, x.zamkzqg.jbmzxye(this), true);
        textViewOxoagud2.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom), 0, getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top));
        linearLayoutXbdyiew.addView(textViewOxoagud2);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayoutXbdyiew.addView(linearLayout);
        linearLayoutXbdyiew.addView(new View(this), new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
        this.aqyicql = textViewOxoagud;
        this.npkgpdo = textViewBtazysh;
        this.nsbgblf = textViewOxoagud2;
        TextView textView = (TextView) ghkjjruVarJdqigmr.ojyssqt;
        this.nauykcf = textView;
        TextView textView2 = (TextView) ghkjjruVarJdqigmr.vivhedu;
        this.ffhrwhh = textView2;
        TextView textView3 = (TextView) ghkjjruVarJdqigmr.lthborb;
        this.guecdgy = textView3;
        this.fusjbbl = textViewLclupha;
        this.enxkjpu = editText;
        this.gjpruie = linearLayout;
        String str = this.sdchfks;
        x.zamkzqg.pwnmyid(this, textView, "green", "green".equals(str));
        x.zamkzqg.pwnmyid(this, textView2, "yellow", "yellow".equals(str));
        x.zamkzqg.pwnmyid(this, textView3, "red", "red".equals(str));
        return scrollView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r12v27, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v59 */
    /* JADX WARN: Type inference failed for: r13v21, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r21v1, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r25v0, types: [android.app.Activity, android.content.Context, com.rynx.app.ojyssqt, java.lang.Object, x.kggugdp] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r2v27, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r7v8, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r8v17, types: [android.view.View, android.widget.ScrollView] */
    @Override // com.rynx.app.ojyssqt
    public final void vopsyhw(String str) {
        String string;
        if (wjugzfh()) {
            String str2 = str == null ? "all" : str;
            this.ecffprn = str2;
            ArrayList arrayList = new ArrayList();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            ArrayList<String> arrayList2 = new ArrayList();
            for (ohwxijw ohwxijwVar : (java.util.ArrayList<ohwxijw>) this.jbmzxye) {
                String strNpkgpdo = npkgpdo(ohwxijwVar.nmpwovh);
                String str3 = ohwxijwVar.nmpwovh;
                String lowerCase = str3 == null ? "" : str3.toLowerCase(Locale.ROOT);
                boolean z = lowerCase.endsWith("_a") || lowerCase.endsWith("-a");
                boolean z2 = lowerCase.endsWith("_b") || lowerCase.endsWith("-b");
                if (!arrayList2.contains(strNpkgpdo)) {
                    arrayList2.add(strNpkgpdo);
                }
                if (z) {
                    linkedHashMap.put(strNpkgpdo, ohwxijwVar);
                } else if (z2) {
                    linkedHashMap2.put(strNpkgpdo, ohwxijwVar);
                } else {
                    linkedHashMap3.put(strNpkgpdo, ohwxijwVar);
                }
            }
            ArrayList<bpqosqe> arrayList3 = new ArrayList();
            for (String str4 : arrayList2) {
                arrayList3.add(new bpqosqe(str4, (ohwxijw) linkedHashMap.get(str4), (ohwxijw) linkedHashMap2.get(str4), (ohwxijw) linkedHashMap3.get(str4)));
            }
            for (bpqosqe bpqosqeVar : arrayList3) {
                ohwxijw ohwxijwVar2 = bpqosqeVar.ojyssqt;
                ohwxijw ohwxijwVar3 = bpqosqeVar.vivhedu;
                if (ohwxijwVar2 == null && ohwxijwVar3 == null) {
                    arrayList.add(bpqosqeVar);
                } else {
                    boolean zEquals = "a".equals(str2);
                    ohwxijw ohwxijwVar4 = bpqosqeVar.ojyssqt;
                    if (zEquals) {
                        if (ohwxijwVar4 != null) {
                            arrayList.add(bpqosqeVar);
                        }
                    } else if ("b".equals(str2)) {
                        if (ohwxijwVar3 != null) {
                            arrayList.add(bpqosqeVar);
                        }
                    } else if (ohwxijwVar4 != null || ohwxijwVar3 != null) {
                        arrayList.add(bpqosqeVar);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                Toast.makeText((Context) this, R.string.batch_flash_no_partitions_for_slot, 1).show();
                return;
            }
            ArrayList arrayList4 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                bpqosqe bpqosqeVar2 = (bpqosqe) arrayList.get(i);
                String str5 = bpqosqeVar2.nmpwovh;
                String str6 = this.ecffprn;
                ohwxijw ohwxijwVar5 = bpqosqeVar2.vivhedu;
                ohwxijw ohwxijwVar6 = bpqosqeVar2.ojyssqt;
                if ((ohwxijwVar6 == null && ohwxijwVar5 == null) ? false : true) {
                    boolean zEquals2 = "a".equals(str6);
                    int i2 = R.string.batch_flash_group_slot_a;
                    if (zEquals2 && ohwxijwVar6 != null) {
                        string = getString(R.string.batch_flash_group_slot_a, str5, x.zamkzqg.jybecxv(ohwxijwVar6.vivhedu));
                    } else if ("b".equals(str6) && ohwxijwVar5 != null) {
                        string = getString(R.string.batch_flash_group_slot_b, str5, x.zamkzqg.jybecxv(ohwxijwVar5.vivhedu));
                    } else if (ohwxijwVar6 == null || ohwxijwVar5 == null) {
                        if (ohwxijwVar6 != null) {
                            ohwxijwVar5 = ohwxijwVar6;
                        }
                        if (ohwxijwVar6 == null) {
                            i2 = R.string.batch_flash_group_slot_b;
                        }
                        string = getString(i2, str5, x.zamkzqg.jybecxv(ohwxijwVar5 != null ? ohwxijwVar5.vivhedu : 0L));
                    } else {
                        string = getString(R.string.batch_flash_group_all_slots, str5, x.zamkzqg.jybecxv(Math.min(ohwxijwVar6.vivhedu, ohwxijwVar5.vivhedu)));
                    }
                } else {
                    ohwxijw ohwxijwVar7 = bpqosqeVar2.lthborb;
                    string = getString(R.string.batch_flash_group_plain, str5, x.zamkzqg.jybecxv(ohwxijwVar7 != null ? ohwxijwVar7.vivhedu : 0L));
                }
                arrayList4.add(new nuoqzvr(i, str5, string, oohojlj(bpqosqeVar2, this.ecffprn)));
            }
            String str7 = this.ecffprn;
            final gucwjqz gucwjqzVar = new gucwjqz(this, arrayList);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(x.zamkzqg.buswjhz(this));
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(1);
            linearLayout2.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_top), getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_header_padding_bottom));
            LinearLayout linearLayoutLvtqoqa = x.zamkzqg.lvtqoqa(this);
            linearLayoutLvtqoqa.setGravity(16);
            final int i3 = 0;
            linearLayoutLvtqoqa.addView(x.zamkzqg.btazysh(this, R.drawable.ic_back, x.zamkzqg.nmpwovh(this), R.string.batch_hub_title, new View.OnClickListener() { // from class: x.mdepcqh
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i3) {
                        case 0:
                            gucwjqzVar.ojyssqt.buswjhz();
                            break;
                        case 1:
                            gucwjqzVar.ojyssqt.vopsyhw("all");
                            break;
                        case 2:
                            gucwjqzVar.ojyssqt.vopsyhw("a");
                            break;
                        default:
                            gucwjqzVar.ojyssqt.vopsyhw("b");
                            break;
                    }
                }
            }), new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.partition_header_action_height), getResources().getDimensionPixelSize(R.dimen.partition_header_action_height)));
            TextView textViewOxoagud = x.zamkzqg.oxoagud(this, getString(R.string.batch_flash_setup_title), 20, x.zamkzqg.zngzleo(this), true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
            linearLayoutLvtqoqa.addView(textViewOxoagud, layoutParams);
            linearLayout2.addView(linearLayoutLvtqoqa);
            LinearLayout linearLayoutLvtqoqa2 = x.zamkzqg.lvtqoqa(this);
            linearLayoutLvtqoqa2.addView(x.zamkzqg.fprgbbe(this, R.string.batch_flash_step_target, true), x.zamkzqg.wdznaie(this));
            linearLayoutLvtqoqa2.addView(x.zamkzqg.fprgbbe(this, R.string.batch_flash_step_partitions, true), x.zamkzqg.wdznaie(this));
            linearLayoutLvtqoqa2.addView(x.zamkzqg.fprgbbe(this, R.string.batch_flash_step_images, false), x.zamkzqg.wdznaie(this));
            linearLayoutLvtqoqa2.addView(x.zamkzqg.fprgbbe(this, R.string.batch_flash_step_review, false), x.zamkzqg.wdznaie(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
            linearLayout2.addView(linearLayoutLvtqoqa2, layoutParams2);
            ArrayList arrayList5 = new ArrayList();
            LinearLayout linearLayoutLvtqoqa3 = x.zamkzqg.lvtqoqa(this);
            linearLayoutLvtqoqa3.setGravity(16);
            TextView textViewOxoagud2 = x.zamkzqg.oxoagud(this, getString(R.string.batch_flash_selected_compact, 0), 11, x.zamkzqg.jbmzxye(this), true);
            textViewOxoagud2.setGravity(17);
            textViewOxoagud2.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_sticky_count_padding_vertical));
            textViewOxoagud2.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_sticky_action_radius, this, x.zamkzqg.atntgcp(this), getColor(R.color.rynx_transparent)));
            linearLayoutLvtqoqa3.addView(textViewOxoagud2);
            linearLayoutLvtqoqa3.addView(new View(this), new LinearLayout.LayoutParams(0, 1, 1.0f));
            int iKggugdp = x.zamkzqg.kggugdp(this);
            TextView textViewLclupha = x.zamkzqg.lclupha(this, getString(R.string.batch_flash_continue_compact), null);
            x.zamkzqg.enxkjpu(this, textViewLclupha, R.drawable.ic_flash, iKggugdp);
            textViewLclupha.setTextColor(x.zamkzqg.kggugdp(this));
            textViewLclupha.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_sticky_action_radius, this, x.zamkzqg.ojyssqt(this), getColor(R.color.rynx_transparent)));
            textViewLclupha.setEnabled(false);
            textViewLclupha.setAlpha(0.42f);
            linearLayoutLvtqoqa3.addView(textViewLclupha, new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_height)));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_gap);
            linearLayout2.addView(linearLayoutLvtqoqa3, layoutParams3);
            linearLayout.addView(linearLayout2);
            ScrollView scrollView = new ScrollView(this);
            scrollView.setFillViewport(true);
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(1);
            linearLayout3.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_top), getResources().getDimensionPixelSize(R.dimen.batch_scroll_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.ui_page_padding));
            scrollView.addView(linearLayout3);
            linearLayout3.addView(x.zamkzqg.oxoagud(this, getString(R.string.batch_flash_setup_subtitle), 11, x.zamkzqg.jbmzxye(this), false));
            TextView textViewYsaclsr = x.zamkzqg.ysaclsr(this, R.string.batch_flash_target_label);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.topMargin = getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
            layoutParams4.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top);
            linearLayout3.addView(textViewYsaclsr, layoutParams4);
            LinearLayout linearLayoutLvtqoqa4 = x.zamkzqg.lvtqoqa(this);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.risk_segment_container_padding);
            linearLayoutLvtqoqa4.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            linearLayoutLvtqoqa4.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.risk_segment_container_radius, this, x.zamkzqg.atntgcp(this), getColor(R.color.rynx_transparent)));
            final int i4 = 1;
            linearLayoutLvtqoqa4.addView(x.zamkzqg.ffhrwhh(this, R.string.batch_flash_slot_all, "all".equals(str7), new View.OnClickListener() { // from class: x.mdepcqh
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            gucwjqzVar.ojyssqt.buswjhz();
                            break;
                        case 1:
                            gucwjqzVar.ojyssqt.vopsyhw("all");
                            break;
                        case 2:
                            gucwjqzVar.ojyssqt.vopsyhw("a");
                            break;
                        default:
                            gucwjqzVar.ojyssqt.vopsyhw("b");
                            break;
                    }
                }
            }), x.zamkzqg.kffvigz(this));
            final int i5 = 2;
            linearLayoutLvtqoqa4.addView(x.zamkzqg.ffhrwhh(this, R.string.batch_flash_slot_a, "a".equals(str7), new View.OnClickListener() { // from class: x.mdepcqh
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i5) {
                        case 0:
                            gucwjqzVar.ojyssqt.buswjhz();
                            break;
                        case 1:
                            gucwjqzVar.ojyssqt.vopsyhw("all");
                            break;
                        case 2:
                            gucwjqzVar.ojyssqt.vopsyhw("a");
                            break;
                        default:
                            gucwjqzVar.ojyssqt.vopsyhw("b");
                            break;
                    }
                }
            }), x.zamkzqg.kffvigz(this));
            final int i6 = 3;
            linearLayoutLvtqoqa4.addView(x.zamkzqg.ffhrwhh(this, R.string.batch_flash_slot_b, "b".equals(str7), new View.OnClickListener() { // from class: x.mdepcqh
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i6) {
                        case 0:
                            gucwjqzVar.ojyssqt.buswjhz();
                            break;
                        case 1:
                            gucwjqzVar.ojyssqt.vopsyhw("all");
                            break;
                        case 2:
                            gucwjqzVar.ojyssqt.vopsyhw("a");
                            break;
                        default:
                            gucwjqzVar.ojyssqt.vopsyhw("b");
                            break;
                    }
                }
            }), x.zamkzqg.kffvigz(this));
            linearLayout3.addView(linearLayoutLvtqoqa4, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.risk_segment_container_height)));
            TextView textViewYsaclsr2 = x.zamkzqg.ysaclsr(this, R.string.batch_risk_filter_title);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams5.topMargin = getResources().getDimensionPixelSize(R.dimen.ui_card_margin_bottom);
            layoutParams5.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ui_card_margin_top);
            linearLayout3.addView(textViewYsaclsr2, layoutParams5);
            final String[] strArr = {"green"};
            ghkjjru ghkjjruVarJdqigmr = x.zamkzqg.jdqigmr(this, strArr[0], new jtfjrri(strArr, 1));
            linearLayout3.addView((LinearLayout) ghkjjruVarJdqigmr.nmpwovh, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.risk_segment_container_height)));
            final LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.setOrientation(1);
            linearLayout3.addView(linearLayout4);
            final vntpaom vntpaomVar = new vntpaom(arrayList5, textViewOxoagud2, (Object) this, textViewLclupha, 4);
            final vntpaom vntpaomVar2 = new vntpaom(arrayList5, strArr, (Object) this, ghkjjruVarJdqigmr, 5);
            final int i7 = 0;
            ((TextView) ghkjjruVarJdqigmr.ojyssqt).setOnClickListener(new View.OnClickListener() { // from class: x.xqbcyis
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i7) {
                        case 0:
                            strArr[0] = "green";
                            vntpaomVar2.run();
                            x.zfmpmio.lthborb(kggugdp.this, linearLayout4, true);
                            break;
                        case 1:
                            strArr[0] = "yellow";
                            vntpaomVar2.run();
                            x.zfmpmio.lthborb(kggugdp.this, linearLayout4, true);
                            break;
                        default:
                            strArr[0] = "red";
                            vntpaomVar2.run();
                            x.zfmpmio.lthborb(kggugdp.this, linearLayout4, true);
                            break;
                    }
                }
            });
            final int i8 = 1;
            ((TextView) ghkjjruVarJdqigmr.vivhedu).setOnClickListener(new View.OnClickListener() { // from class: x.xqbcyis
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i8) {
                        case 0:
                            strArr[0] = "green";
                            vntpaomVar2.run();
                            x.zfmpmio.lthborb(kggugdp.this, linearLayout4, true);
                            break;
                        case 1:
                            strArr[0] = "yellow";
                            vntpaomVar2.run();
                            x.zfmpmio.lthborb(kggugdp.this, linearLayout4, true);
                            break;
                        default:
                            strArr[0] = "red";
                            vntpaomVar2.run();
                            x.zfmpmio.lthborb(kggugdp.this, linearLayout4, true);
                            break;
                    }
                }
            });
            final int i9 = 2;
            ((TextView) ghkjjruVarJdqigmr.lthborb).setOnClickListener(new View.OnClickListener() { // from class: x.xqbcyis
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i9) {
                        case 0:
                            strArr[0] = "green";
                            vntpaomVar2.run();
                            x.zfmpmio.lthborb(kggugdp.this, linearLayout4, true);
                            break;
                        case 1:
                            strArr[0] = "yellow";
                            vntpaomVar2.run();
                            x.zfmpmio.lthborb(kggugdp.this, linearLayout4, true);
                            break;
                        default:
                            strArr[0] = "red";
                            vntpaomVar2.run();
                            x.zfmpmio.lthborb(kggugdp.this, linearLayout4, true);
                            break;
                    }
                }
            });
            Iterator it = arrayList4.iterator();
            LinearLayout r12 = linearLayout3;
            while (it.hasNext()) {
                final nuoqzvr nuoqzvrVar = (nuoqzvr) it.next();
                final LinearLayout linearLayout5 = new LinearLayout(this);
                linearLayout5.setOrientation(0);
                linearLayout5.setGravity(16);
                linearLayout5.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical), getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_row_padding_vertical));
                String str8 = nuoqzvrVar.lthborb;
                linearLayout5.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_compact_row_radius, this, x.zamkzqg.tmdubwv(this, str8), x.zamkzqg.cugubfc(this, str8)));
                CheckBox checkBox = new CheckBox(this);
                String str9 = nuoqzvrVar.lthborb;
                checkBox.setButtonTintList(ColorStateList.valueOf(x.zamkzqg.cugubfc(this, str9)));
                String str10 = nuoqzvrVar.ojyssqt;
                checkBox.setContentDescription(str10);
                linearLayout5.addView(checkBox);
                LinearLayout linearLayout6 = new LinearLayout(this);
                linearLayout6.setOrientation(1);
                LinearLayout linearLayoutLvtqoqa5 = x.zamkzqg.lvtqoqa(this);
                linearLayoutLvtqoqa5.setGravity(16);
                Iterator it2 = it;
                LinearLayout r21 = r12;
                TextView textView = textViewLclupha;
                linearLayoutLvtqoqa5.addView(x.zamkzqg.oxoagud(this, str10, 13, x.zamkzqg.zngzleo(this), true), new LinearLayout.LayoutParams(0, -2, 1.0f));
                TextView textViewOxoagud3 = x.zamkzqg.oxoagud(this, getString("red".equals(str9) ? R.string.parts_risk_red : "yellow".equals(str9) ? R.string.parts_risk_yellow : R.string.parts_risk_green), 9, x.zamkzqg.cugubfc(this, str9), true);
                textViewOxoagud3.setPadding(getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical), getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_horizontal), getResources().getDimensionPixelSize(R.dimen.batch_compact_badge_padding_vertical));
                textViewOxoagud3.setBackground(x.sjexbpf.nmpwovh(this, R.dimen.batch_compact_badge_radius, this, x.zamkzqg.tmdubwv(this, str9), getColor(R.color.rynx_transparent)));
                linearLayoutLvtqoqa5.addView(textViewOxoagud3);
                linearLayout6.addView(linearLayoutLvtqoqa5);
                TextView textViewOxoagud4 = x.zamkzqg.oxoagud(this, nuoqzvrVar.vivhedu, 10, x.zamkzqg.jbmzxye(this), false);
                textViewOxoagud4.setPadding(0, getResources().getDimensionPixelSize(R.dimen.partition_compact_note_top), 0, 0);
                linearLayout6.addView(textViewOxoagud4);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                layoutParams6.leftMargin = getResources().getDimensionPixelSize(R.dimen.ui_start_icon_gap);
                linearLayout5.addView(linearLayout6, layoutParams6);
                arrayList5.add(new eqqqfvj(nuoqzvrVar, linearLayout5, checkBox));
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.batch_compact_row_gap);
                layoutParams7.setMargins(0, dimensionPixelSize2, 0, dimensionPixelSize2);
                linearLayout4.addView(linearLayout5, layoutParams7);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: x.zzqmpyp
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                        String str11 = nuoqzvrVar.lthborb;
                        kggugdp kggugdpVar = kggugdp.this;
                        LinearLayout linearLayout7 = linearLayout5;
                        linearLayout7.setBackground(x.sjexbpf.nmpwovh(kggugdpVar, R.dimen.batch_compact_row_radius, kggugdpVar, x.zamkzqg.tmdubwv(kggugdpVar, str11), z3 ? x.zamkzqg.nmpwovh(kggugdpVar) : x.zamkzqg.cugubfc(kggugdpVar, str11)));
                        x.zfmpmio.ojyssqt(linearLayout7);
                        vntpaomVar.run();
                    }
                });
                x.zamkzqg.utmeivs(this, linearLayout5);
                linearLayout5.setOnClickListener(new mamlotu(checkBox, 1));
                it = it2;
                r12 = r21;
                textViewLclupha = textView;
            }
            textViewLclupha.setOnClickListener(new pzqxblc(arrayList5, gucwjqzVar, 3));
            r12.addView(new View(this), new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.floating_nav_content_clearance)));
            vntpaomVar.run();
            vntpaomVar2.run();
            linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
            kffvigz(linearLayout, "batch_flash_setup");
        }
    }

    public final String xqbcyis() {
        String str = !com.rynx.app.ojyssqt.zwaqeaz(this.cnctlxz.dasxvpc) ? this.cnctlxz.dasxvpc : this.cnctlxz.wqrnifx;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("|");
        String str2 = this.cnctlxz.qxvquar;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append("|");
        String str3 = this.cnctlxz.nmpwovh;
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        sb.append("|");
        String str4 = this.cnctlxz.ojyssqt;
        sb.append(str4 != null ? str4 : "");
        return sb.toString().toUpperCase(Locale.ROOT);
    }

    public final void xvxmcgn(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            runOnUiThread(new naaizwn(1, str, this));
            return;
        }
        TextView textView = this.dkpobjg;
        if (textView == null || isFinishing() || isDestroyed()) {
            return;
        }
        this.qwpvrdy = textView;
        this.fixfqug = false;
        textView.append(str);
        textView.append("\n");
        nsbgblf(textView);
    }

    public final void ydsyayx() {
        HashSet hashSet = this.mwocrhx;
        hashSet.clear();
        for (znfyiic znfyiicVar : (java.util.ArrayList<znfyiic>) this.pwnmyid) {
            if (znfyiicVar.qxvquar) {
                hashSet.add(com.rynx.app.ojyssqt.pzqxblc(znfyiicVar.ojyssqt.ojyssqt));
            }
        }
        this.mslkofp = xqbcyis();
    }

    public final suqlntg yhrqvll(String str, String str2, String str3, String str4, String str5, String str6) {
        oxoagud oxoagudVarEzxxysz = ezxxysz();
        int i = oxoagudVarEzxxysz.nmpwovh;
        if (i < 0) {
            return new suqlntg(2, getString(R.string.error_usb_unavailable));
        }
        boolean z = false;
        try {
            String strNativeRunGuiAction = nativeRunGuiAction(i, oxoagudVarEzxxysz.ojyssqt, str, str2, str3, str4 == null ? "" : str4, str5 == null ? "" : str5, str6 == null ? "" : str6);
            int i2 = (strNativeRunGuiAction == null || !strNativeRunGuiAction.startsWith("OK\n")) ? 0 : 1;
            this.nsyqsfj = this.qwgjehf && nativeHasSession();
            if (!this.nsyqsfj) {
                this.cnctlxz = x.ednetju.ojyssqt();
                this.xvxmcgn = "—";
            }
            int i3 = i2 ^ 1;
            if (strNativeRunGuiAction == null) {
                strNativeRunGuiAction = getString(R.string.error_jni_null);
            }
            return new suqlntg(i3, strNativeRunGuiAction);
        } catch (Throwable th) {
            if (this.qwgjehf && nativeHasSession()) {
                z = true;
            }
            this.nsyqsfj = z;
            if (!this.nsyqsfj) {
                this.cnctlxz = x.ednetju.ojyssqt();
                this.xvxmcgn = "—";
            }
            return new suqlntg(1, getString(R.string.error_gui_jni, String.valueOf(th)));
        }
    }

    public final ArrayList yjvhftf() {
        ohwxijw ohwxijwVar;
        File file;
        if (this.wdznaie == null) {
            throw new IllegalArgumentException(getString(R.string.scatter_no_file));
        }
        if (!this.nsyqsfj || this.jbmzxye.isEmpty() || this.iasgsgq || !this.ghkjjru.isEmpty()) {
            throw new IllegalArgumentException(!this.ghkjjru.isEmpty() ? this.ghkjjru : getString(R.string.scatter_offline_preview_status));
        }
        ljwltks();
        if (!this.pzkwhtn.isEmpty()) {
            throw new IllegalArgumentException(this.pzkwhtn);
        }
        boolean zEquals = "firmware_upgrade".equals(this.ijakhcl);
        if (!"download_only".equals(this.ijakhcl) && !zEquals) {
            throw new IllegalArgumentException(getString(R.string.scatter_mode_unavailable_title));
        }
        if (zEquals) {
            for (aqyicql aqyicqlVar : (java.util.ArrayList<aqyicql>) this.wdznaie.nkemejx) {
                if (aqyicqlVar.lthborb && !aqyicqlVar.vivhedu()) {
                    throw new IllegalArgumentException(aqyicqlVar.ojyssqt + ": " + getString(R.string.scatter_status_missing_image, aqyicqlVar.vivhedu));
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (znfyiic znfyiicVar : (java.util.ArrayList<znfyiic>) this.pwnmyid) {
            if (!zEquals || com.rynx.app.ojyssqt.atntgcp(znfyiicVar.ojyssqt)) {
                String strPzqxblc = com.rynx.app.ojyssqt.pzqxblc(znfyiicVar.ojyssqt.ojyssqt);
                if (zEquals || this.mwocrhx.contains(strPzqxblc)) {
                    if (!znfyiicVar.qxvquar || (ohwxijwVar = znfyiicVar.vivhedu) == null || (file = znfyiicVar.lthborb) == null) {
                        throw new IllegalArgumentException(znfyiicVar.ojyssqt.ojyssqt + ": " + znfyiicVar.imuemzb);
                    }
                    arrayList.add(new araemok(ohwxijwVar, file, znfyiicVar.nkemejx));
                }
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException(getString(R.string.scatter_select_one));
        }
        return arrayList;
    }

    public final void ysaclsr() {
        ohwxijw ohwxijwVar;
        HashSet hashSet = this.mwocrhx;
        hashSet.clear();
        boolean zEquals = "firmware_upgrade".equals(this.ijakhcl);
        for (znfyiic znfyiicVar : (java.util.ArrayList<znfyiic>) this.pwnmyid) {
            if (znfyiicVar.qxvquar && (ohwxijwVar = znfyiicVar.vivhedu) != null) {
                aqyicql aqyicqlVar = znfyiicVar.ojyssqt;
                if (zEquals || (!znfyiicVar.oqexvyb && !ohwxijwVar.nmpwovh() && aqyicqlVar.dytyqos)) {
                    hashSet.add(com.rynx.app.ojyssqt.pzqxblc(aqyicqlVar.ojyssqt));
                }
            }
        }
        this.mslkofp = xqbcyis();
    }

    public final void yxcmoyp() {
        if (!this.mwngani || !this.nsyqsfj) {
            return;
        }
        this.mwngani = false;
        this.ghkjjru = "";
        if (this.jbmzxye.isEmpty()) {
            this.iasgsgq = true;
            this.mwocrhx.clear();
            this.ghkjjru = getString(R.string.scatter_device_table_unavailable);
            ljwltks();
            Toast.makeText(this, this.ghkjjru, 1).show();
            gzokllk();
            return;
        }
        lcgzsis lcgzsisVar = this.wdznaie;
        if (lcgzsisVar == null) {
            this.iasgsgq = false;
            Toast.makeText(this, R.string.scatter_da_ready_choose, 1).show();
            gzokllk();
            return;
        }
        File file = lcgzsisVar.nmpwovh;
        try {
            String str = this.cnctlxz.ojyssqt;
            x.pwjmwpv.lclupha(file);
            lcgzsis lcgzsisVarPvbzgon = x.pwjmwpv.dytyqos(file) ? x.pwjmwpv.pvbzgon(file, str, false) : x.pwjmwpv.buswjhz(file, str, false);
            String strEdnetju = ednetju(file);
            if (!strEdnetju.isEmpty()) {
                throw new IOException(strEdnetju);
            }
            this.wdznaie = lcgzsisVarPvbzgon;
            this.iasgsgq = false;
            this.mwocrhx.clear();
            ljwltks();
            ydsyayx();
            ((MainActivity) this).nmpwovh(getString(R.string.log_scatter_revalidated, lcgzsisVarPvbzgon.nmpwovh.getAbsolutePath(), lcgzsisVarPvbzgon.qxvquar, Integer.valueOf(com.rynx.app.ojyssqt.wqrnifx(lcgzsisVarPvbzgon))));
            Toast.makeText(this, R.string.scatter_revalidated, 1).show();
            gzokllk();
        } catch (Throwable th) {
            this.iasgsgq = true;
            this.mwocrhx.clear();
            this.ghkjjru = getString(R.string.scatter_revalidate_failed, String.valueOf(th.getMessage()));
            ljwltks();
            Toast.makeText(this, this.ghkjjru, 1).show();
        }
    }

    public final void zegwdrn(int i, int i2) {
        ProgressBar progressBar = this.oxoagud;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
        TextView textView = this.axbavsj;
        if (textView != null) {
            textView.setText(getString(R.string.batch_overall_completed, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public final void zzqmpyp(String str) {
        if (this.lpkdqgx || this.gzokllk) {
            ((MainActivity) this).nmpwovh("[FWUP] Request rejected: another native operation is active");
            Toast.makeText(this, R.string.error_busy, 0).show();
            return;
        }
        try {
            ArrayList arrayListYjvhftf = yjvhftf();
            if (!ljhdwjr(arrayListYjvhftf).equals(str)) {
                Toast.makeText(this, R.string.scatter_review_changed, 1).show();
                cnctlxz();
                return;
            }
            MainActivity mainActivity = (MainActivity) this;
            mainActivity.nmpwovh(getString("firmware_upgrade".equals(this.ijakhcl) ? R.string.log_scatter_firmware_upgrade_plan : R.string.log_scatter_plan, Integer.valueOf(arrayListYjvhftf.size())));
            if (!"firmware_upgrade".equals(this.ijakhcl)) {
                if (!udgizdi()) {
                    tmdubwv(new ArrayList(arrayListYjvhftf));
                    return;
                }
                ArrayList arrayList = new ArrayList(arrayListYjvhftf);
                if (arrayList.isEmpty() || !wjugzfh()) {
                    return;
                }
                try {
                    File fileMdepcqh = mdepcqh(arrayList);
                    kpmmknm(arrayList.size(), true);
                    this.lpkdqgx = true;
                    this.ygdccqg = "WRITE";
                    this.cxxnoho = "";
                    this.clczezu = System.currentTimeMillis();
                    gefzxcg();
                    nauykcf(0, arrayList.size(), getString(R.string.scatter_download_v6_prepare));
                    String strYjbrzgu = yjbrzgu("da_path");
                    String strYjbrzgu2 = yjbrzgu("auth_path");
                    String strYjbrzgu3 = yjbrzgu("preloader_path");
                    mainActivity.nmpwovh("[SCATTER] XML/V6 Download Only -> CMD:WRITE-PARTITIONS v1.0 • " + arrayList.size() + " selected payload(s)");
                    this.slxntng.execute(new silhone(this, fileMdepcqh, strYjbrzgu, strYjbrzgu2, strYjbrzgu3, arrayList));
                    return;
                } catch (Throwable th) {
                    Toast.makeText(this, String.valueOf(th.getMessage()), 1).show();
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayListYjvhftf);
            if (this.lpkdqgx || this.gzokllk) {
                mainActivity.nmpwovh("[FWUP] Request rejected: worker already queued or active");
                Toast.makeText(this, R.string.error_busy, 0).show();
                return;
            }
            if (arrayList2.isEmpty() || !wjugzfh()) {
                return;
            }
            try {
                File fileChwohho = chwohho();
                File fileTnejqcj = tnejqcj(arrayList2);
                kpmmknm(arrayList2.size(), true);
                this.lpkdqgx = true;
                this.ygdccqg = "WRITE";
                gefzxcg();
                nauykcf(0, arrayList2.size(), getString(R.string.scatter_firmware_upgrade_step));
                String strYjbrzgu4 = yjbrzgu("da_path");
                String strYjbrzgu5 = yjbrzgu("auth_path");
                String strYjbrzgu6 = yjbrzgu("preloader_path");
                mainActivity.nmpwovh("[FWUP] Worker queued; waiting for the native operation executor");
                try {
                    this.slxntng.execute(new lpkdqgx(this, fileTnejqcj, fileChwohho, strYjbrzgu4, strYjbrzgu5, strYjbrzgu6, arrayList2));
                } catch (Throwable th2) {
                    this.lpkdqgx = false;
                    if (!fileTnejqcj.delete()) {
                        fileTnejqcj.deleteOnExit();
                    }
                    this.ygdccqg = "";
                    this.cxxnoho = "";
                    gefzxcg();
                    String str2 = "[FWUP] Unable to start worker: " + th2.getClass().getSimpleName() + ": " + String.valueOf(th2.getMessage());
                    mainActivity.nmpwovh(str2);
                    TextView textView = this.hjlrtqw;
                    if (textView != null) {
                        textView.setText(R.string.scatter_firmware_upgrade_failed);
                        this.hjlrtqw.setTextColor(this.nkemejx);
                    }
                    Toast.makeText(this, str2, 1).show();
                }
            } catch (Throwable th3) {
                Toast.makeText(this, getString(R.string.scatter_firmware_upgrade_plan_failed, String.valueOf(th3.getMessage())), 1).show();
            }
        } catch (Throwable th4) {
            Toast.makeText(this, String.valueOf(th4.getMessage()), 1).show();
            gzokllk();
        }
    }
}
