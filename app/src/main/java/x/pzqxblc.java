package x;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pzqxblc implements View.OnClickListener {
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ Object ojyssqt;
    public final /* synthetic */ Object vivhedu;

    public /* synthetic */ pzqxblc(Object obj, Object obj2, int i) {
        this.nmpwovh = i;
        this.ojyssqt = obj;
        this.vivhedu = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.nmpwovh) {
            case 0:
                ((wjugzfh) this.ojyssqt).vivhedu((String) this.vivhedu);
                break;
            case 1:
                ArrayList<Integer> arrayList = new ArrayList();
                for (rpdxrib rpdxribVar : (ArrayList) this.ojyssqt) {
                    if (rpdxribVar.vivhedu.isChecked()) {
                        arrayList.add(Integer.valueOf(rpdxribVar.nmpwovh.nmpwovh));
                    }
                }
                if (!arrayList.isEmpty()) {
                    mcdstyz mcdstyzVar = (mcdstyz) this.vivhedu;
                    boolean zIsEmpty = arrayList.isEmpty();
                    kggugdp kggugdpVar = mcdstyzVar.nmpwovh;
                    if (zIsEmpty) {
                        Toast.makeText(kggugdpVar, R.string.batch_select_one, 0).show();
                        break;
                    } else {
                        ArrayList<ohwxijw> arrayList2 = new ArrayList();
                        for (Integer num : arrayList) {
                            if (num != null && num.intValue() >= 0 && num.intValue() < kggugdpVar.jbmzxye.size()) {
                                arrayList2.add((ohwxijw) kggugdpVar.jbmzxye.get(num.intValue()));
                            }
                        }
                        if (arrayList2.isEmpty()) {
                            Toast.makeText(kggugdpVar, R.string.batch_select_one, 0).show();
                            break;
                        } else {
                            kggugdpVar.getClass();
                            if (!arrayList2.isEmpty()) {
                                Integer numValueOf = Integer.valueOf(arrayList2.size());
                                StringBuilder sb = new StringBuilder();
                                for (ohwxijw ohwxijwVar : arrayList2) {
                                    sb.append("• ");
                                    sb.append(ohwxijwVar.nmpwovh);
                                    sb.append("  (");
                                    sb.append(zamkzqg.jybecxv(ohwxijwVar.vivhedu));
                                    sb.append(")\n");
                                }
                                new AlertDialog.Builder(kggugdpVar).setTitle(R.string.batch_backup_confirm_title).setMessage(kggugdpVar.getString(R.string.batch_backup_confirm_message, numValueOf, sb.toString().trim())).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.parts_backup_multiple, new pmsrvoc(kggugdpVar, arrayList2, 1)).show();
                                break;
                            }
                        }
                    }
                }
                break;
            case 2:
                oohojlj oohojljVar = (oohojlj) this.vivhedu;
                mcdstyz mcdstyzVar2 = (mcdstyz) this.ojyssqt;
                int i = oohojljVar.nmpwovh;
                kggugdp kggugdpVar2 = mcdstyzVar2.nmpwovh;
                if (i < 0) {
                    kggugdpVar2.getClass();
                } else if (i < kggugdpVar2.pcbbvuj.size() && kggugdpVar2.dplrlfq()) {
                    kggugdpVar2.yrgokys = i;
                    ecffprn.imuemzb(kggugdpVar2, kggugdpVar2.getString(R.string.flash_choose_image), kggugdpVar2.lclupha(), null, new thbdbid(kggugdpVar2, 0));
                }
                break;
            case 3:
                ArrayList<Integer> arrayList3 = new ArrayList();
                for (eqqqfvj eqqqfvjVar : (ArrayList) this.ojyssqt) {
                    if (eqqqfvjVar.vivhedu.isChecked()) {
                        arrayList3.add(Integer.valueOf(eqqqfvjVar.nmpwovh.nmpwovh));
                    }
                }
                if (!arrayList3.isEmpty()) {
                    gucwjqz gucwjqzVar = (gucwjqz) this.vivhedu;
                    boolean zIsEmpty2 = arrayList3.isEmpty();
                    kggugdp kggugdpVar3 = gucwjqzVar.ojyssqt;
                    if (zIsEmpty2) {
                        Toast.makeText(kggugdpVar3, R.string.batch_select_one, 0).show();
                    } else {
                        ArrayList arrayList4 = new ArrayList();
                        for (Integer num2 : arrayList3) {
                            if (num2 != null && num2.intValue() >= 0) {
                                int iIntValue = num2.intValue();
                                ArrayList arrayList5 = gucwjqzVar.nmpwovh;
                                if (iIntValue < arrayList5.size()) {
                                    arrayList4.add((bpqosqe) arrayList5.get(num2.intValue()));
                                }
                            }
                        }
                        if (arrayList4.isEmpty()) {
                            Toast.makeText(kggugdpVar3, R.string.batch_select_one, 0).show();
                        } else {
                            String str = kggugdpVar3.ecffprn;
                            ArrayList arrayList6 = kggugdpVar3.pcbbvuj;
                            arrayList6.clear();
                            arrayList6.addAll(arrayList4);
                            kggugdpVar3.fprgbbe.clear();
                            if (str == null) {
                                str = "all";
                            }
                            kggugdpVar3.ecffprn = str;
                            kggugdpVar3.yrgokys = -1;
                            kggugdpVar3.hknanqb();
                        }
                    }
                }
                break;
            case 4:
                MainActivity mainActivity = ((wjugzfh) this.ojyssqt).nmpwovh;
                if (mainActivity.wjugzfh()) {
                    String upperCase = ((String) this.vivhedu).trim().toUpperCase(Locale.ROOT);
                    if ("A".equals(upperCase) || "B".equals(upperCase)) {
                        if (upperCase.equals(mainActivity.rrpfqyy)) {
                            Toast.makeText(mainActivity, mainActivity.getString(R.string.bootloader_slot_switch_no_change, upperCase), 0).show();
                        } else {
                            new AlertDialog.Builder(mainActivity).setTitle(R.string.bootloader_slot_switch_title).setMessage(mainActivity.getString(R.string.bootloader_slot_switch_message, com.rynx.app.ojyssqt.zwaqeaz(mainActivity.rrpfqyy) ? "?" : mainActivity.rrpfqyy, upperCase)).setNegativeButton(R.string.action_cancel, (DialogInterface.OnClickListener) null).setPositiveButton(mainActivity.getString(R.string.bootloader_slot_switch_confirm, upperCase), new qyeibyo(mainActivity, upperCase, 1)).show();
                        }
                    }
                    break;
                }
                break;
            case 5:
                ((thbdbid) this.ojyssqt).ojyssqt.nhhacgu((String) this.vivhedu);
                break;
            case 6:
                Activity activity = (Activity) this.ojyssqt;
                ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
                if (clipboardManager != null) {
                    TextView textView = (TextView) this.vivhedu;
                    if (textView.getText().length() > 0) {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText("Rynx connection diagnostic", textView.getText().toString()));
                        Toast.makeText(activity, R.string.home_error_copied, 0).show();
                    }
                }
                break;
            case 7:
                ((cxxnoho) this.ojyssqt).ojyssqt((String) this.vivhedu);
                break;
            case 8:
                com.rynx.app.nmpwovh nmpwovhVar = ((gepzcpd) this.ojyssqt).nmpwovh;
                nmpwovhVar.getClass();
                String strEzxxysz = zamkzqg.ezxxysz(nmpwovhVar);
                String str2 = (String) this.vivhedu;
                if (!strEzxxysz.equals(str2)) {
                    String[] strArr = zamkzqg.nmpwovh;
                    for (int i2 = 0; i2 < 8; i2++) {
                        if (strArr[i2].equals(str2)) {
                            nmpwovhVar.getSharedPreferences("rynx_ui", 0).edit().putString("palette", str2).apply();
                            nmpwovhVar.zftrkmx();
                        }
                        break;
                    }
                    str2 = "auto";
                    nmpwovhVar.getSharedPreferences("rynx_ui", 0).edit().putString("palette", str2).apply();
                    nmpwovhVar.zftrkmx();
                    break;
                }
                break;
            default:
                Context context = (Context) this.ojyssqt;
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                if (clipboardManager2 != null) {
                    clipboardManager2.setPrimaryClip(ClipData.newPlainText(context.getString(R.string.sla_brom_manual_challenge_label), ((TextView) this.vivhedu).getText()));
                    Toast.makeText(context, R.string.sla_brom_manual_challenge_copied, 0).show();
                }
                break;
        }
    }
}
