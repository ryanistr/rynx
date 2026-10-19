package x;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class vntpaom implements Runnable {
    public final /* synthetic */ Object lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;
    public final /* synthetic */ Object qxvquar;
    public final /* synthetic */ Object vivhedu;

    public /* synthetic */ vntpaom(MainActivity mainActivity, suqlntg suqlntgVar, String str, String str2) {
        this.nmpwovh = 1;
        this.ojyssqt = mainActivity;
        this.lthborb = suqlntgVar;
        this.vivhedu = str;
        this.qxvquar = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String string;
        boolean z;
        String strNativeRunGuiAction;
        String str;
        suqlntg suqlntgVar;
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity = (MainActivity) this.ojyssqt;
                UsbDevice usbDevice = (UsbDevice) this.lthborb;
                UsbDeviceConnection usbDeviceConnection = (UsbDeviceConnection) this.qxvquar;
                String str2 = (String) this.vivhedu;
                mainActivity.getClass();
                try {
                    ulafhci.ulafhci(mainActivity.getApplicationContext(), usbDevice, usbDeviceConnection, str2);
                    string = null;
                } catch (nkemejx e) {
                    string = e.getMessage();
                    z = true;
                } catch (Throwable th) {
                    string = th.toString();
                }
                z = false;
                mainActivity.nxumtuo = false;
                mainActivity.runOnUiThread(new qwgjehf(mainActivity, string, str2, z));
                break;
            case 1:
                MainActivity mainActivity2 = (MainActivity) this.ojyssqt;
                mainActivity2.getClass();
                suqlntg suqlntgVar2 = (suqlntg) this.lthborb;
                String str3 = (String) suqlntgVar2.ojyssqt;
                if (str3 != null && !str3.trim().isEmpty()) {
                    mainActivity2.nmpwovh(str3.trim());
                }
                mainActivity2.nmpwovh(mainActivity2.getString(R.string.log_gui_exit, Integer.valueOf(suqlntgVar2.nmpwovh)));
                mainActivity2.nmpwovh("");
                if ("seccfg".equals((String) this.vivhedu)) {
                    if (!suqlntgVar2.oqexvyb()) {
                        Toast.makeText(mainActivity2, R.string.bootloader_action_failed, 1).show();
                    } else if (str3 == null || !str3.contains("SECCFG NOT CHANGED")) {
                        Toast.makeText(mainActivity2, "unlock".equals((String) this.qxvquar) ? R.string.bootloader_unlock_complete : R.string.bootloader_lock_complete, 1).show();
                    } else {
                        Toast.makeText(mainActivity2, R.string.bootloader_no_change, 1).show();
                    }
                }
                mainActivity2.gefzxcg();
                break;
            case 2:
                MainActivity mainActivity3 = (MainActivity) this.ojyssqt;
                String str4 = (String) this.vivhedu;
                String str5 = (String) this.lthborb;
                String str6 = (String) this.qxvquar;
                oxoagud oxoagudVarEzxxysz = mainActivity3.ezxxysz();
                int i = oxoagudVarEzxxysz.nmpwovh;
                if (i < 0) {
                    strNativeRunGuiAction = "ERROR\n" + mainActivity3.getString(R.string.error_usb_lost_gui_action);
                } else {
                    try {
                        long j = oxoagudVarEzxxysz.ojyssqt;
                        if (str4 == null) {
                            str4 = "";
                        }
                        strNativeRunGuiAction = mainActivity3.nativeRunGuiAction(i, j, "bootctrl-info", "", "", str4, str5 == null ? "" : str5, str6 == null ? "" : str6);
                    } catch (Throwable th2) {
                        strNativeRunGuiAction = "ERROR\n" + mainActivity3.getString(R.string.error_gui_jni, String.valueOf(th2));
                    }
                }
                mainActivity3.lpkdqgx = false;
                mainActivity3.runOnUiThread(new utmeivs(mainActivity3, strNativeRunGuiAction, 10));
                break;
            case 3:
                Iterator it = ((ArrayList) this.ojyssqt).iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (((rpdxrib) it.next()).vivhedu.isChecked()) {
                        i2++;
                    }
                }
                Object[] objArr = {Integer.valueOf(i2)};
                com.rynx.app.nmpwovh nmpwovhVar = (com.rynx.app.nmpwovh) this.qxvquar;
                String string2 = nmpwovhVar.getString(R.string.batch_backup_selected_count, objArr);
                TextView textView = (TextView) this.lthborb;
                textView.setText(string2);
                textView.setTextColor(i2 > 0 ? zamkzqg.kggugdp(nmpwovhVar) : zamkzqg.jbmzxye(nmpwovhVar));
                textView.setBackground(zamkzqg.jvtqflj(nmpwovhVar, i2 > 0 ? zamkzqg.ojyssqt(nmpwovhVar) : zamkzqg.atntgcp(nmpwovhVar), nmpwovhVar.getColor(R.color.rynx_transparent), nmpwovhVar.getResources().getDimensionPixelSize(R.dimen.batch_sticky_action_radius)));
                String string3 = nmpwovhVar.getString(R.string.batch_backup_action_compact, Integer.valueOf(i2));
                TextView textView2 = (TextView) this.vivhedu;
                textView2.setText(string3);
                zamkzqg.enxkjpu(nmpwovhVar, textView2, R.drawable.ic_backup, zamkzqg.kggugdp(nmpwovhVar));
                textView2.setEnabled(i2 > 0);
                textView2.setAlpha(i2 > 0 ? 1.0f : 0.42f);
                break;
            case 4:
                Iterator it2 = ((ArrayList) this.ojyssqt).iterator();
                int i3 = 0;
                while (it2.hasNext()) {
                    if (((eqqqfvj) it2.next()).vivhedu.isChecked()) {
                        i3++;
                    }
                }
                Object[] objArr2 = {Integer.valueOf(i3)};
                kggugdp kggugdpVar = (kggugdp) this.qxvquar;
                String string4 = kggugdpVar.getString(R.string.batch_flash_selected_compact, objArr2);
                TextView textView3 = (TextView) this.lthborb;
                textView3.setText(string4);
                textView3.setTextColor(i3 > 0 ? zamkzqg.kggugdp(kggugdpVar) : zamkzqg.jbmzxye(kggugdpVar));
                textView3.setBackground(sjexbpf.nmpwovh(kggugdpVar, R.dimen.batch_sticky_action_radius, kggugdpVar, i3 > 0 ? zamkzqg.ojyssqt(kggugdpVar) : zamkzqg.atntgcp(kggugdpVar), kggugdpVar.getColor(R.color.rynx_transparent)));
                boolean z2 = i3 > 0;
                TextView textView4 = (TextView) this.vivhedu;
                textView4.setEnabled(z2);
                textView4.setAlpha(i3 > 0 ? 1.0f : 0.42f);
                break;
            case 5:
                Iterator it3 = ((ArrayList) this.ojyssqt).iterator();
                while (true) {
                    boolean zHasNext = it3.hasNext();
                    String[] strArr = (String[]) this.lthborb;
                    int i4 = 0;
                    if (!zHasNext) {
                        String str7 = strArr[0];
                        kggugdp kggugdpVar2 = (kggugdp) this.qxvquar;
                        ghkjjru ghkjjruVar = (ghkjjru) this.vivhedu;
                        TextView textView5 = (TextView) ghkjjruVar.vivhedu;
                        TextView textView6 = (TextView) ghkjjruVar.lthborb;
                        zamkzqg.pwnmyid(kggugdpVar2, (TextView) ghkjjruVar.ojyssqt, "green", "green".equals(str7));
                        zamkzqg.pwnmyid(kggugdpVar2, textView5, "yellow", "yellow".equals(str7));
                        zamkzqg.pwnmyid(kggugdpVar2, textView6, "red", "red".equals(str7));
                    } else {
                        eqqqfvj eqqqfvjVar = (eqqqfvj) it3.next();
                        LinearLayout linearLayout = eqqqfvjVar.ojyssqt;
                        if (!strArr[0].equals(eqqqfvjVar.nmpwovh.lthborb)) {
                            i4 = 8;
                        }
                        linearLayout.setVisibility(i4);
                    }
                    break;
                }
                break;
            case 6:
                MainActivity mainActivity4 = (MainActivity) this.ojyssqt;
                suqlntg suqlntgVar3 = (suqlntg) this.lthborb;
                ohwxijw ohwxijwVar = (ohwxijw) this.qxvquar;
                File file = (File) this.vivhedu;
                mainActivity4.getClass();
                if (!suqlntgVar3.oqexvyb() && (str = (String) suqlntgVar3.ojyssqt) != null && !str.trim().isEmpty()) {
                    mainActivity4.nmpwovh(((String) suqlntgVar3.ojyssqt).trim());
                    mainActivity4.xvxmcgn(((String) suqlntgVar3.ojyssqt).trim());
                }
                zfmpmio.vivhedu(mainActivity4.vhimehb, false);
                if (suqlntgVar3.oqexvyb()) {
                    ProgressBar progressBar = mainActivity4.vhimehb;
                    if (progressBar != null) {
                        progressBar.setProgress(100);
                    }
                    TextView textView7 = mainActivity4.naaizwn;
                    if (textView7 != null) {
                        textView7.setText(R.string.progress_complete_percent);
                    }
                    TextView textView8 = mainActivity4.hjlrtqw;
                    if (textView8 != null) {
                        textView8.setText(R.string.flash_complete);
                        mainActivity4.hjlrtqw.setTextColor(mainActivity4.qxvquar);
                    }
                    zfmpmio.nmpwovh(mainActivity4, mainActivity4.getString(R.string.flash_complete_partition, ohwxijwVar.nmpwovh, zamkzqg.jybecxv(ohwxijwVar.vivhedu), zamkzqg.jybecxv(file.length())), true);
                    mainActivity4.nmpwovh(mainActivity4.getString(R.string.log_flash_complete, ohwxijwVar.nmpwovh, zamkzqg.jybecxv(ohwxijwVar.vivhedu), zamkzqg.jybecxv(file.length())));
                } else {
                    TextView textView9 = mainActivity4.hjlrtqw;
                    if (textView9 != null) {
                        textView9.setText(R.string.flash_failed);
                        mainActivity4.hjlrtqw.setTextColor(mainActivity4.nkemejx);
                    }
                    zfmpmio.nmpwovh(mainActivity4, mainActivity4.getString(R.string.flash_failed_logs), false);
                    mainActivity4.nmpwovh(mainActivity4.getString(R.string.log_flash_failed, ohwxijwVar.nmpwovh));
                }
                mainActivity4.ygdccqg = "";
                mainActivity4.cxxnoho = "";
                mainActivity4.gefzxcg();
                mainActivity4.lvtqoqa();
                break;
            case 7:
                kggugdp kggugdpVar3 = (kggugdp) this.ojyssqt;
                String str8 = (String) this.vivhedu;
                String str9 = (String) this.lthborb;
                String str10 = (String) this.qxvquar;
                oxoagud oxoagudVarEzxxysz2 = kggugdpVar3.ezxxysz();
                int i5 = oxoagudVarEzxxysz2.nmpwovh;
                if (i5 < 0) {
                    suqlntgVar = new suqlntg(2, kggugdpVar3.getString(R.string.error_usb_lost_gpt));
                } else {
                    try {
                        long j2 = oxoagudVarEzxxysz2.ojyssqt;
                        if (str8 == null) {
                            str8 = "";
                        }
                        String strNativeRunGuiAction2 = kggugdpVar3.nativeRunGuiAction(i5, j2, "pgpt", "", "", str8, str9 == null ? "" : str9, str10 == null ? "" : str10);
                        int i6 = (strNativeRunGuiAction2 == null || !strNativeRunGuiAction2.startsWith("OK\n")) ? 0 : 1;
                        kggugdpVar3.nsyqsfj = kggugdpVar3.qwgjehf && kggugdpVar3.nativeHasSession();
                        if (!kggugdpVar3.nsyqsfj) {
                            kggugdpVar3.xvxmcgn = "—";
                        }
                        int i7 = i6 ^ 1;
                        if (strNativeRunGuiAction2 == null) {
                            strNativeRunGuiAction2 = kggugdpVar3.getString(R.string.error_jni_null);
                        }
                        suqlntgVar = new suqlntg(i7, strNativeRunGuiAction2);
                    } catch (Throwable th3) {
                        kggugdpVar3.nsyqsfj = kggugdpVar3.qwgjehf && kggugdpVar3.nativeHasSession();
                        if (!kggugdpVar3.nsyqsfj) {
                            kggugdpVar3.xvxmcgn = "—";
                        }
                        suqlntgVar = new suqlntg(1, kggugdpVar3.getString(R.string.error_gui_jni, String.valueOf(th3)));
                    }
                }
                kggugdpVar3.lpkdqgx = false;
                kggugdpVar3.ywhgqsi = false;
                kggugdpVar3.runOnUiThread(new atntgcp(kggugdpVar3, suqlntgVar, 4));
                break;
            default:
                kggugdp kggugdpVar4 = (kggugdp) this.ojyssqt;
                suqlntg suqlntgVar4 = (suqlntg) this.lthborb;
                ArrayList arrayList = (ArrayList) this.qxvquar;
                File file2 = (File) this.vivhedu;
                kggugdpVar4.getClass();
                if (suqlntgVar4.oqexvyb()) {
                    ProgressBar progressBar2 = kggugdpVar4.vhimehb;
                    if (progressBar2 != null) {
                        progressBar2.setProgress(100);
                    }
                    TextView textView10 = kggugdpVar4.naaizwn;
                    if (textView10 != null) {
                        textView10.setText(R.string.progress_complete_percent);
                    }
                    ProgressBar progressBar3 = kggugdpVar4.oxoagud;
                    if (progressBar3 != null) {
                        progressBar3.setProgress(arrayList.size());
                    }
                    TextView textView11 = kggugdpVar4.hjlrtqw;
                    if (textView11 != null) {
                        textView11.setText(R.string.scatter_firmware_upgrade_complete_slot_a);
                        kggugdpVar4.hjlrtqw.setTextColor(kggugdpVar4.qxvquar);
                    }
                    Toast.makeText(kggugdpVar4, kggugdpVar4.getString(R.string.scatter_firmware_upgrade_complete_toast, file2.getAbsolutePath()), 1).show();
                } else {
                    TextView textView12 = kggugdpVar4.hjlrtqw;
                    if (textView12 != null) {
                        textView12.setText(R.string.scatter_firmware_upgrade_failed);
                        kggugdpVar4.hjlrtqw.setTextColor(kggugdpVar4.nkemejx);
                    }
                    Toast.makeText(kggugdpVar4, kggugdpVar4.getString(R.string.scatter_firmware_upgrade_failed_toast, file2.getAbsolutePath()), 1).show();
                }
                kggugdpVar4.ygdccqg = "";
                kggugdpVar4.cxxnoho = "";
                kggugdpVar4.gefzxcg();
                break;
        }
    }

    public /* synthetic */ vntpaom(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
        this.lthborb = obj2;
        this.qxvquar = obj3;
        this.vivhedu = obj4;
    }

    public /* synthetic */ vntpaom(kggugdp kggugdpVar, String str, String str2, String str3, int i) {
        this.nmpwovh = i;
        this.ojyssqt = kggugdpVar;
        this.vivhedu = str;
        this.lthborb = str2;
        this.qxvquar = str3;
    }
}
