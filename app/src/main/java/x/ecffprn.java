package x;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Environment;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.R;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class ecffprn {
    public ProgressBar buswjhz;
    public TextView dasxvpc;
    public TextView dplrlfq;
    public File dytyqos;
    public TextView ekyqleu;
    public final Set lthborb;
    public final Activity nmpwovh;
    public final String ojyssqt;
    public pcbbvuj pvbzgon;
    public final fusjbbl qxvquar;
    public ImageButton ulafhci;
    public ListView utmeivs;
    public final int vivhedu;
    public AlertDialog wqrnifx;
    public final ExecutorService oqexvyb = Executors.newSingleThreadExecutor();
    public final AtomicInteger nkemejx = new AtomicInteger();
    public final ArrayDeque imuemzb = new ArrayDeque();
    public boolean qyeibyo = true;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.HashSet] */
    public ecffprn(Activity activity, String str, File file, int i, String[] strArr, fusjbbl fusjbblVar) {
        Set EmptySet;
        this.nmpwovh = activity;
        this.ojyssqt = str;
        this.vivhedu = i;
        this.qxvquar = fusjbblVar;
        if (strArr == null || strArr.length == 0) {
            EmptySet = Collections.emptySet();
        } else {
            EmptySet = new HashSet();
            for (String str2 : strArr) {
                if (str2 != null) {
                    String lowerCase = str2.trim().toLowerCase(Locale.ROOT);
                    if (!lowerCase.isEmpty()) {
                        EmptySet.add(lowerCase.startsWith(".") ? lowerCase : ".".concat(lowerCase));
                    }
                }
            }
        }
        this.lthborb = EmptySet;
        this.dytyqos = dytyqos(file);
    }

    public static File dytyqos(File file) {
        File file2 = new File(Environment.getExternalStorageDirectory(), "Download");
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file3 = new File("/storage");
        if (!file3.isDirectory() || !file3.canRead()) {
            file3 = Environment.getExternalStorageDirectory();
        }
        File[] fileArr = {file, file2, externalStorageDirectory, file3};
        for (int i = 0; i < 4; i++) {
            File file4 = fileArr[i];
            if (file4 != null) {
                try {
                    File canonicalFile = file4.getCanonicalFile();
                    if (canonicalFile.isDirectory() && canonicalFile.canRead()) {
                        return canonicalFile;
                    }
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
        return new File("/");
    }

    public static void imuemzb(Activity activity, String str, File file, String[] strArr, fusjbbl fusjbblVar) {
        new ecffprn(activity, str, file, 0, strArr, fusjbblVar).nkemejx();
    }

    public static File oqexvyb(File file) {
        if (file == null) {
            return null;
        }
        try {
            File parentFile = file.getCanonicalFile().getParentFile();
            if (parentFile != null && parentFile.isDirectory() && parentFile.canRead()) {
                return parentFile.getCanonicalFile();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void lthborb(File file, boolean z) {
        boolean zEquals;
        File file2;
        File fileDytyqos = dytyqos(file);
        File file3 = this.dytyqos;
        if (file3 != null) {
            try {
                zEquals = file3.getCanonicalFile().equals(fileDytyqos.getCanonicalFile());
            } catch (Throwable unused) {
                zEquals = file3.equals(fileDytyqos);
            }
        } else {
            zEquals = false;
        }
        if (zEquals) {
            qxvquar();
            return;
        }
        if (z && (file2 = this.dytyqos) != null) {
            this.imuemzb.addLast(file2);
        }
        this.dytyqos = fileDytyqos;
        qxvquar();
    }

    public final void nkemejx() {
        int iNmpwovh = nmpwovh(14);
        Activity activity = this.nmpwovh;
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(iNmpwovh, nmpwovh(8), iNmpwovh, nmpwovh(8));
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        ImageButton imageButton = new ImageButton(activity);
        this.ulafhci = imageButton;
        imageButton.setImageResource(R.drawable.ic_internal_picker_back);
        this.ulafhci.setContentDescription(activity.getString(R.string.internal_picker_back));
        this.ulafhci.setPadding(nmpwovh(10), nmpwovh(10), nmpwovh(10), nmpwovh(10));
        this.ulafhci.setScaleType(ImageView.ScaleType.CENTER);
        ImageButton imageButton2 = this.ulafhci;
        TypedValue typedValue = new TypedValue();
        if (activity.getTheme().resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, typedValue, true)) {
            imageButton2.setBackgroundResource(typedValue.resourceId);
        } else {
            imageButton2.setBackgroundColor(0);
        }
        this.ulafhci.setOnClickListener(new gjpruie(this, 0));
        linearLayout2.addView(this.ulafhci, new LinearLayout.LayoutParams(nmpwovh(44), nmpwovh(44)));
        TextView textView = new TextView(activity);
        this.dplrlfq = textView;
        textView.setTextSize(17.0f);
        this.dplrlfq.setTypeface(Typeface.DEFAULT, 1);
        this.dplrlfq.setSingleLine(true);
        this.dplrlfq.setPadding(nmpwovh(8), 0, nmpwovh(8), 0);
        linearLayout2.addView(this.dplrlfq, new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(activity);
        this.dasxvpc = textView2;
        textView2.setTextSize(12.0f);
        this.dasxvpc.setTypeface(Typeface.MONOSPACE);
        this.dasxvpc.setPadding(0, nmpwovh(10), 0, nmpwovh(8));
        this.dasxvpc.setMaxLines(2);
        linearLayout.addView(this.dasxvpc, new LinearLayout.LayoutParams(-1, -2));
        ListView listView = new ListView(activity);
        this.utmeivs = listView;
        listView.setDividerHeight(0);
        pcbbvuj pcbbvujVar = new pcbbvuj(this);
        this.pvbzgon = pcbbvujVar;
        this.utmeivs.setAdapter((ListAdapter) pcbbvujVar);
        this.utmeivs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: x.nsbgblf
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ecffprn ecffprnVar = this.nmpwovh;
                File item = ecffprnVar.pvbzgon.getItem(i);
                if (item == null) {
                    return;
                }
                if (item.isDirectory()) {
                    ecffprnVar.qyeibyo = true;
                    ecffprnVar.lthborb(item, true);
                } else if (ecffprnVar.vivhedu == 0) {
                    ecffprnVar.ojyssqt(item);
                }
            }
        });
        linearLayout.addView(this.utmeivs, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        ProgressBar progressBar = new ProgressBar(activity);
        this.buswjhz = progressBar;
        progressBar.setIndeterminate(true);
        this.buswjhz.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(nmpwovh(28), nmpwovh(28));
        layoutParams.gravity = 1;
        layoutParams.topMargin = nmpwovh(6);
        layoutParams.bottomMargin = nmpwovh(6);
        linearLayout.addView(this.buswjhz, layoutParams);
        TextView textView3 = new TextView(activity);
        this.ekyqleu = textView3;
        textView3.setTextSize(13.0f);
        this.ekyqleu.setGravity(17);
        this.ekyqleu.setPadding(0, nmpwovh(16), 0, nmpwovh(8));
        this.ekyqleu.setVisibility(8);
        linearLayout.addView(this.ekyqleu, new LinearLayout.LayoutParams(-1, -2));
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(activity).setTitle(this.ojyssqt).setView(linearLayout).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        if (this.vivhedu == 1) {
            negativeButton.setPositiveButton(R.string.internal_picker_use_folder, (DialogInterface.OnClickListener) null);
        }
        AlertDialog alertDialogCreate = negativeButton.create();
        this.wqrnifx = alertDialogCreate;
        alertDialogCreate.setOnShowListener(new ojyssqt(this, 1));
        this.wqrnifx.setOnDismissListener(new nauykcf(this, 0));
        this.wqrnifx.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: x.ffhrwhh
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                ecffprn ecffprnVar = this.nmpwovh;
                ecffprnVar.getClass();
                if (i != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                if (!((ecffprnVar.imuemzb.isEmpty() && ecffprn.oqexvyb(ecffprnVar.dytyqos) == null) ? false : true)) {
                    return false;
                }
                ecffprnVar.vivhedu();
                return true;
            }
        });
        this.wqrnifx.show();
    }

    public final int nmpwovh(int i) {
        return Math.max(1, Math.round(i * this.nmpwovh.getResources().getDisplayMetrics().density));
    }

    public final void ojyssqt(File file) {
        if (file == null) {
            return;
        }
        try {
            File canonicalFile = file.getCanonicalFile();
            if (this.vivhedu == 0) {
                if (!canonicalFile.isFile() || !canonicalFile.canRead()) {
                    return;
                }
            } else {
                if (!canonicalFile.isDirectory()) {
                    return;
                }
                if (!canonicalFile.canRead()) {
                    return;
                }
            }
            AlertDialog alertDialog = this.wqrnifx;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            this.qxvquar.nmpwovh(canonicalFile);
        } catch (Throwable unused) {
            Toast.makeText(this.nmpwovh, R.string.internal_picker_path_unreadable, 0).show();
        }
    }

    public final void qxvquar() {
        String name;
        boolean zEquals;
        File file = this.dytyqos;
        int iIncrementAndGet = this.nkemejx.incrementAndGet();
        TextView textView = this.dplrlfq;
        if (textView != null) {
            if (file == null) {
                name = "/";
            } else {
                name = file.getName();
                if (name == null || name.isEmpty()) {
                    name = file.getAbsolutePath();
                } else {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    if (externalStorageDirectory == null) {
                        zEquals = false;
                    } else {
                        try {
                            zEquals = file.getCanonicalFile().equals(externalStorageDirectory.getCanonicalFile());
                        } catch (Throwable unused) {
                            zEquals = file.equals(externalStorageDirectory);
                        }
                    }
                    if (zEquals) {
                        name = "Internal storage";
                    }
                }
            }
            textView.setText(name);
        }
        TextView textView2 = this.dasxvpc;
        if (textView2 != null) {
            textView2.setText(file.getAbsolutePath());
        }
        if (this.ulafhci != null) {
            boolean z = (this.imuemzb.isEmpty() && oqexvyb(this.dytyqos) == null) ? false : true;
            this.ulafhci.setEnabled(z);
            this.ulafhci.setAlpha(z ? 1.0f : 0.35f);
        }
        ProgressBar progressBar = this.buswjhz;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        ListView listView = this.utmeivs;
        if (listView != null) {
            listView.setEnabled(false);
            this.utmeivs.setAlpha(0.6f);
        }
        TextView textView3 = this.ekyqleu;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        this.oqexvyb.execute(new jbyhfxz(this, file, iIncrementAndGet, 1));
    }

    public final void vivhedu() {
        ArrayDeque arrayDeque = this.imuemzb;
        File fileOqexvyb = !arrayDeque.isEmpty() ? (File) arrayDeque.removeLast() : oqexvyb(this.dytyqos);
        if (fileOqexvyb != null) {
            this.qyeibyo = false;
            lthborb(fileOqexvyb, false);
        }
    }
}
