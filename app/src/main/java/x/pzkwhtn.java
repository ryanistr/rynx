package x;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pzkwhtn implements Runnable {
    public final /* synthetic */ Object lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ boolean ojyssqt;
    public final /* synthetic */ Activity vivhedu;

    public /* synthetic */ pzkwhtn(Activity activity, Object obj, boolean z, int i) {
        this.nmpwovh = i;
        this.vivhedu = activity;
        this.lthborb = obj;
        this.ojyssqt = z;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x029e  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:56:0x010d  */
    /* JADX WARN: Code duplicated, block: B:61:0x012d  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:72:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:73:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:76:0x0219  */
    /* JADX WARN: Code duplicated, block: B:77:0x0221  */
    /* JADX WARN: Code duplicated, block: B:79:0x024b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0260  */
    /* JADX WARN: Code duplicated, block: B:91:0x0275  */
    /* JADX WARN: Instruction removed from duplicated block: B:73:0x01e0, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        String strVhimehb;
        long j;
        long j2;
        String string;
        int i;
        vlyywxv vlyywxvVar;
        vlyywxv vlyywxvVar2;
        vlyywxv vlyywxvVar3;
        vlyywxv vlyywxvVar4;
        int iTqfwohl;
        vlyywxv vlyywxvVar5;
        String str;
        com.rynx.app.nmpwovh nmpwovhVar;
        String string2;
        int iTqfwohl2;
        vlyywxv vlyywxvVar6;
        vlyywxv vlyywxvVar7;
        vlyywxv vlyywxvVar8;
        int i2 = -1;
        int i3 = 2;
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity = (MainActivity) this.vivhedu;
                String str2 = (String) this.lthborb;
                boolean z = this.ojyssqt;
                int[] iArr = MainActivity.rzsxsyc;
                mainActivity.getClass();
                suqlntg suqlntgVarWygqgxb = zamkzqg.wygqgxb(str2);
                if (suqlntgVarWygqgxb != null && (i = suqlntgVarWygqgxb.nmpwovh) >= 301 && i <= 308) {
                    String[] strArr = (String[]) suqlntgVarWygqgxb.ojyssqt;
                    for (int length = strArr.length - 1; length >= 0; length--) {
                        String str3 = strArr[length];
                        if (str3 != null && str3.startsWith("gen=")) {
                            try {
                                i2 = Integer.parseInt(str3.substring(4));
                                break;
                            } catch (RuntimeException unused) {
                            }
                            if (i2 > 0 && i2 == mainActivity.zsbaukl && i2 == mainActivity.zyxfuka) {
                                switch (suqlntgVarWygqgxb.nmpwovh) {
                                    case 301:
                                        mainActivity.jbyhfxz(i2, "BROM authorization challenge opened.");
                                        break;
                                    case 302:
                                        if (i2 == mainActivity.zsbaukl && (vlyywxvVar2 = mainActivity.zwccvwt) != null && vlyywxvVar2.ojyssqt.isShowing()) {
                                            vlyywxvVar2.pvbzgon(true);
                                        }
                                        vlyywxvVar = mainActivity.zwccvwt;
                                        if (vlyywxvVar != null && vlyywxvVar.ojyssqt.isShowing()) {
                                            vlyywxvVar.dplrlfq();
                                        }
                                        mainActivity.jbyhfxz(i2, "Live BROM challenge captured.");
                                        break;
                                    case 303:
                                        vlyywxvVar3 = mainActivity.zwccvwt;
                                        if (vlyywxvVar3 != null && vlyywxvVar3.ojyssqt.isShowing()) {
                                            vlyywxvVar3.utmeivs();
                                        }
                                        mainActivity.jbyhfxz(i2, "Device accepted the response length.");
                                        break;
                                    case 304:
                                        vlyywxvVar4 = mainActivity.zwccvwt;
                                        if (vlyywxvVar4 != null && vlyywxvVar4.ojyssqt.isShowing()) {
                                            vlyywxvVar4.utmeivs();
                                        }
                                        mainActivity.jbyhfxz(i2, "Authorization response sent to the device.");
                                        break;
                                    case 305:
                                        iTqfwohl = MainActivity.tqfwohl(suqlntgVarWygqgxb.vivhedu(1));
                                        mainActivity.ffhrwhh(iTqfwohl, true);
                                        mainActivity.nativeSetXiaomiAuthGeneration(0);
                                        vlyywxvVar5 = mainActivity.zwccvwt;
                                        if (vlyywxvVar5 != null && vlyywxvVar5.ojyssqt.isShowing()) {
                                            nlcdwap nlcdwapVar = vlyywxvVar5.vivhedu;
                                            nlcdwapVar.lthborb = "device_accepted";
                                            nlcdwapVar.gisppfs = false;
                                            nlcdwapVar.lclupha = true;
                                            nlcdwapVar.oqexvyb = "Authorization successful";
                                            if (iTqfwohl == 0) {
                                                str = "The device accepted the authorization response.";
                                            } else {
                                                str = "The device accepted the authorization response (status " + String.format(Locale.ROOT, "0x%04X", Integer.valueOf(iTqfwohl & 65535)) + ").";
                                            }
                                            nlcdwapVar.nkemejx = str;
                                            nlcdwapVar.buswjhz = true;
                                            nlcdwapVar.pvbzgon = true;
                                            nmpwovhVar = vlyywxvVar5.nmpwovh;
                                            String string3 = nmpwovhVar.getString(R.string.xiaomi_auth_progress_hero_authorized);
                                            String string4 = nmpwovhVar.getString(R.string.xiaomi_auth_progress_status_success);
                                            if (iTqfwohl == 0) {
                                                string2 = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_device_accepted);
                                            } else {
                                                string2 = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_device_accepted_status, String.format(Locale.ROOT, "0x%04X", Integer.valueOf(iTqfwohl & 65535)));
                                            }
                                            nlcdwapVar.nkemejx(string3, string4, string2);
                                            vlyywxvVar5.pvkaerr = true;
                                            vlyywxvVar5.uiqyzsp = true;
                                            vlyywxvVar5.qwgjehf = null;
                                            vlyywxvVar5.lthborb(false);
                                            vlyywxvVar5.qxvquar();
                                        }
                                        break;
                                    case 306:
                                        iTqfwohl2 = MainActivity.tqfwohl(suqlntgVarWygqgxb.vivhedu(1));
                                        mainActivity.ffhrwhh(iTqfwohl2, false);
                                        mainActivity.nativeSetXiaomiAuthGeneration(0);
                                        vlyywxvVar6 = mainActivity.zwccvwt;
                                        if (vlyywxvVar6 != null && vlyywxvVar6.ojyssqt.isShowing()) {
                                            nlcdwap nlcdwapVar2 = vlyywxvVar6.vivhedu;
                                            nlcdwapVar2.lthborb = "device_rejected";
                                            nlcdwapVar2.gisppfs = false;
                                            nlcdwapVar2.lclupha = true;
                                            nlcdwapVar2.oqexvyb = "Device rejected authorization";
                                            StringBuilder sb = new StringBuilder("Server authorization completed, but the device rejected the response (status ");
                                            Locale locale = Locale.ROOT;
                                            int i4 = iTqfwohl2 & 65535;
                                            sb.append(String.format(locale, "0x%04X", Integer.valueOf(i4)));
                                            sb.append(").");
                                            nlcdwapVar2.nkemejx = sb.toString();
                                            nlcdwapVar2.buswjhz = true;
                                            nlcdwapVar2.pvbzgon = false;
                                            com.rynx.app.nmpwovh nmpwovhVar2 = vlyywxvVar6.nmpwovh;
                                            nlcdwapVar2.nkemejx(nmpwovhVar2.getString(R.string.xiaomi_auth_progress_hero_device_rejected), nmpwovhVar2.getString(R.string.xiaomi_auth_progress_status_device_rejected), nmpwovhVar2.getString(R.string.xiaomi_auth_progress_detail_device_rejected, String.format(locale, "0x%04X", Integer.valueOf(i4))));
                                            vlyywxvVar6.pvkaerr = true;
                                            vlyywxvVar6.uiqyzsp = false;
                                            vlyywxvVar6.qwgjehf = null;
                                            vlyywxvVar6.lthborb(false);
                                            vlyywxvVar6.qxvquar();
                                        }
                                        break;
                                    case 307:
                                        mainActivity.nativeSetXiaomiAuthGeneration(0);
                                        mainActivity.ysluikv("device accepted without challenge");
                                        vlyywxvVar7 = mainActivity.zwccvwt;
                                        if (vlyywxvVar7 != null && vlyywxvVar7.ojyssqt.isShowing()) {
                                            vlyywxvVar7.dasxvpc(mainActivity.getString(R.string.xiaomi_auth_progress_bypass_device_accepted));
                                        }
                                        break;
                                    case 308:
                                        mainActivity.nativeSetXiaomiAuthGeneration(0);
                                        mainActivity.ysluikv("XFlash/V5 bypass");
                                        vlyywxvVar8 = mainActivity.zwccvwt;
                                        if (vlyywxvVar8 != null && vlyywxvVar8.ojyssqt.isShowing()) {
                                            vlyywxvVar8.dasxvpc(mainActivity.getString(R.string.xiaomi_auth_progress_bypass_xflash));
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    if (i2 > 0) {
                        switch (suqlntgVarWygqgxb.nmpwovh) {
                            case 301:
                                mainActivity.jbyhfxz(i2, "BROM authorization challenge opened.");
                                break;
                            case 302:
                                if (i2 == mainActivity.zsbaukl) {
                                    vlyywxvVar2.pvbzgon(true);
                                }
                                vlyywxvVar = mainActivity.zwccvwt;
                                if (vlyywxvVar != null) {
                                    vlyywxvVar.dplrlfq();
                                }
                                mainActivity.jbyhfxz(i2, "Live BROM challenge captured.");
                                break;
                            case 303:
                                vlyywxvVar3 = mainActivity.zwccvwt;
                                if (vlyywxvVar3 != null) {
                                    vlyywxvVar3.utmeivs();
                                }
                                mainActivity.jbyhfxz(i2, "Device accepted the response length.");
                                break;
                            case 304:
                                vlyywxvVar4 = mainActivity.zwccvwt;
                                if (vlyywxvVar4 != null) {
                                    vlyywxvVar4.utmeivs();
                                }
                                mainActivity.jbyhfxz(i2, "Authorization response sent to the device.");
                                break;
                            case 305:
                                iTqfwohl = MainActivity.tqfwohl(suqlntgVarWygqgxb.vivhedu(1));
                                mainActivity.ffhrwhh(iTqfwohl, true);
                                mainActivity.nativeSetXiaomiAuthGeneration(0);
                                vlyywxvVar5 = mainActivity.zwccvwt;
                                if (vlyywxvVar5 != null) {
                                    nlcdwap nlcdwapVar3 = vlyywxvVar5.vivhedu;
                                    nlcdwapVar3.lthborb = "device_accepted";
                                    nlcdwapVar3.gisppfs = false;
                                    nlcdwapVar3.lclupha = true;
                                    nlcdwapVar3.oqexvyb = "Authorization successful";
                                    if (iTqfwohl == 0) {
                                        str = "The device accepted the authorization response.";
                                    } else {
                                        str = "The device accepted the authorization response (status " + String.format(Locale.ROOT, "0x%04X", Integer.valueOf(iTqfwohl & 65535)) + ").";
                                    }
                                    nlcdwapVar3.nkemejx = str;
                                    nlcdwapVar3.buswjhz = true;
                                    nlcdwapVar3.pvbzgon = true;
                                    nmpwovhVar = vlyywxvVar5.nmpwovh;
                                    String string5 = nmpwovhVar.getString(R.string.xiaomi_auth_progress_hero_authorized);
                                    String string6 = nmpwovhVar.getString(R.string.xiaomi_auth_progress_status_success);
                                    if (iTqfwohl == 0) {
                                        string2 = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_device_accepted);
                                    } else {
                                        string2 = nmpwovhVar.getString(R.string.xiaomi_auth_progress_detail_device_accepted_status, String.format(Locale.ROOT, "0x%04X", Integer.valueOf(iTqfwohl & 65535)));
                                    }
                                    nlcdwapVar3.nkemejx(string5, string6, string2);
                                    vlyywxvVar5.pvkaerr = true;
                                    vlyywxvVar5.uiqyzsp = true;
                                    vlyywxvVar5.qwgjehf = null;
                                    vlyywxvVar5.lthborb(false);
                                    vlyywxvVar5.qxvquar();
                                }
                                break;
                            case 306:
                                iTqfwohl2 = MainActivity.tqfwohl(suqlntgVarWygqgxb.vivhedu(1));
                                mainActivity.ffhrwhh(iTqfwohl2, false);
                                mainActivity.nativeSetXiaomiAuthGeneration(0);
                                vlyywxvVar6 = mainActivity.zwccvwt;
                                if (vlyywxvVar6 != null) {
                                    nlcdwap nlcdwapVar4 = vlyywxvVar6.vivhedu;
                                    nlcdwapVar4.lthborb = "device_rejected";
                                    nlcdwapVar4.gisppfs = false;
                                    nlcdwapVar4.lclupha = true;
                                    nlcdwapVar4.oqexvyb = "Device rejected authorization";
                                    StringBuilder sb2 = new StringBuilder("Server authorization completed, but the device rejected the response (status ");
                                    Locale locale2 = Locale.ROOT;
                                    int i5 = iTqfwohl2 & 65535;
                                    sb2.append(String.format(locale2, "0x%04X", Integer.valueOf(i5)));
                                    sb2.append(").");
                                    nlcdwapVar4.nkemejx = sb2.toString();
                                    nlcdwapVar4.buswjhz = true;
                                    nlcdwapVar4.pvbzgon = false;
                                    com.rynx.app.nmpwovh nmpwovhVar3 = vlyywxvVar6.nmpwovh;
                                    nlcdwapVar4.nkemejx(nmpwovhVar3.getString(R.string.xiaomi_auth_progress_hero_device_rejected), nmpwovhVar3.getString(R.string.xiaomi_auth_progress_status_device_rejected), nmpwovhVar3.getString(R.string.xiaomi_auth_progress_detail_device_rejected, String.format(locale2, "0x%04X", Integer.valueOf(i5))));
                                    vlyywxvVar6.pvkaerr = true;
                                    vlyywxvVar6.uiqyzsp = false;
                                    vlyywxvVar6.qwgjehf = null;
                                    vlyywxvVar6.lthborb(false);
                                    vlyywxvVar6.qxvquar();
                                }
                                break;
                            case 307:
                                mainActivity.nativeSetXiaomiAuthGeneration(0);
                                mainActivity.ysluikv("device accepted without challenge");
                                vlyywxvVar7 = mainActivity.zwccvwt;
                                if (vlyywxvVar7 != null) {
                                    vlyywxvVar7.dasxvpc(mainActivity.getString(R.string.xiaomi_auth_progress_bypass_device_accepted));
                                }
                                break;
                            case 308:
                                mainActivity.nativeSetXiaomiAuthGeneration(0);
                                mainActivity.ysluikv("XFlash/V5 bypass");
                                vlyywxvVar8 = mainActivity.zwccvwt;
                                if (vlyywxvVar8 != null) {
                                    vlyywxvVar8.dasxvpc(mainActivity.getString(R.string.xiaomi_auth_progress_bypass_xflash));
                                }
                                break;
                        }
                    }
                }
                suqlntg suqlntgVarWygqgxb2 = zamkzqg.wygqgxb(str2);
                if (suqlntgVarWygqgxb2 != null) {
                    int i6 = suqlntgVarWygqgxb2.nmpwovh;
                    switch (i6) {
                        case 101:
                            string = mainActivity.getString(R.string.nlog_mtk_transport_open);
                            break;
                        case 102:
                            string = mainActivity.getString(R.string.nlog_mtk_transport_info, suqlntgVarWygqgxb2.vivhedu(0), suqlntgVarWygqgxb2.vivhedu(1));
                            break;
                        case 103:
                            string = mainActivity.getString(R.string.nlog_inputs_loading);
                            break;
                        case 104:
                            string = mainActivity.getString(R.string.nlog_device_context_building);
                            break;
                        case 105:
                            string = mainActivity.getString(R.string.nlog_device_identify_start);
                            break;
                        case 106:
                            string = mainActivity.getString(R.string.nlog_device_identify_ok);
                            break;
                        case 107:
                            string = mainActivity.getString(R.string.nlog_boot_mode, suqlntgVarWygqgxb2.vivhedu(0));
                            break;
                        case 108:
                            string = mainActivity.getString(R.string.nlog_hw_sw_version, suqlntgVarWygqgxb2.vivhedu(0), suqlntgVarWygqgxb2.vivhedu(1), suqlntgVarWygqgxb2.vivhedu(2));
                            break;
                        case 109:
                            string = mainActivity.getString(R.string.nlog_hw_sw_unavailable);
                            break;
                        case 110:
                            string = mainActivity.getString(R.string.nlog_da_protocol, suqlntgVarWygqgxb2.vivhedu(0));
                            break;
                        case 111:
                            string = mainActivity.getString(R.string.nlog_da_enter);
                            break;
                        case 112:
                            string = mainActivity.getString(R.string.nlog_da_ready);
                            break;
                        case 113:
                            string = mainActivity.getString(R.string.nlog_session_reuse);
                            break;
                        case 114:
                            string = mainActivity.getString(R.string.nlog_session_create);
                            break;
                        case 115:
                            string = mainActivity.getString(R.string.nlog_session_stored);
                            break;
                        case 116:
                            string = mainActivity.getString(R.string.nlog_session_already_ready);
                            break;
                        case 117:
                            string = mainActivity.getString(R.string.nlog_command_start, suqlntgVarWygqgxb2.vivhedu(0), suqlntgVarWygqgxb2.vivhedu(1));
                            break;
                        default:
                            switch (i6) {
                                case 119:
                                    string = mainActivity.getString(R.string.nlog_reboot_mode, suqlntgVarWygqgxb2.vivhedu(0));
                                    break;
                                case 120:
                                    string = mainActivity.getString(R.string.nlog_reboot_sent);
                                    break;
                                case 121:
                                    string = mainActivity.getString(R.string.nlog_shutdown_start);
                                    break;
                                case 122:
                                    string = mainActivity.getString(R.string.nlog_shutdown_sent);
                                    break;
                                case 123:
                                    string = mainActivity.getString(R.string.nlog_bootctrl_read);
                                    break;
                                case 124:
                                    string = mainActivity.getString(R.string.nlog_slot_already_active, suqlntgVarWygqgxb2.vivhedu(0));
                                    break;
                                case 125:
                                    string = mainActivity.getString(R.string.nlog_slot_switch, suqlntgVarWygqgxb2.vivhedu(0), suqlntgVarWygqgxb2.vivhedu(1));
                                    break;
                                case 126:
                                    string = mainActivity.getString(R.string.nlog_slot_verified, suqlntgVarWygqgxb2.vivhedu(0));
                                    break;
                                case 127:
                                    string = mainActivity.getString(R.string.nlog_seccfg_action, suqlntgVarWygqgxb2.vivhedu(0));
                                    break;
                                case 128:
                                    string = mainActivity.getString(R.string.nlog_seccfg_changed, suqlntgVarWygqgxb2.vivhedu(0));
                                    break;
                                case 129:
                                    string = mainActivity.getString(R.string.nlog_seccfg_unchanged, suqlntgVarWygqgxb2.vivhedu(0));
                                    break;
                                case 130:
                                    string = mainActivity.getString(R.string.nlog_partition_table_read);
                                    break;
                                case 131:
                                    string = mainActivity.getString(R.string.nlog_partition_info, suqlntgVarWygqgxb2.vivhedu(0), zamkzqg.ccuulnt(suqlntgVarWygqgxb2.qxvquar(1)));
                                    break;
                                case 132:
                                    string = mainActivity.getString(R.string.nlog_output_path, suqlntgVarWygqgxb2.vivhedu(0));
                                    break;
                                case 133:
                                    string = mainActivity.getString(R.string.nlog_read_progress, Integer.valueOf(Math.max(0, Math.min(100, suqlntgVarWygqgxb2.lthborb(0, 0)))), zamkzqg.ccuulnt(suqlntgVarWygqgxb2.qxvquar(1)), zamkzqg.ccuulnt(suqlntgVarWygqgxb2.qxvquar(2)));
                                    break;
                                case 134:
                                    string = mainActivity.getString(R.string.nlog_read_flushing);
                                    break;
                                case 135:
                                    string = mainActivity.getString(R.string.nlog_read_complete);
                                    break;
                                case 136:
                                    string = mainActivity.getString(R.string.nlog_input_info, suqlntgVarWygqgxb2.vivhedu(0), zamkzqg.ccuulnt(suqlntgVarWygqgxb2.qxvquar(1)));
                                    break;
                                case 137:
                                    string = mainActivity.getString(R.string.nlog_write_progress, Integer.valueOf(Math.max(0, Math.min(100, suqlntgVarWygqgxb2.lthborb(0, 0)))), zamkzqg.ccuulnt(suqlntgVarWygqgxb2.qxvquar(1)), zamkzqg.ccuulnt(suqlntgVarWygqgxb2.qxvquar(2)));
                                    break;
                                case 138:
                                    string = mainActivity.getString(R.string.nlog_write_complete);
                                    break;
                                case 139:
                                    string = mainActivity.getString(R.string.nlog_session_connect_start);
                                    break;
                                case 140:
                                    string = mainActivity.getString(R.string.nlog_gui_action_start);
                                    break;
                                case 141:
                                    string = mainActivity.getString(R.string.nlog_native_command_start);
                                    break;
                                case 142:
                                    string = mainActivity.getString(R.string.nlog_crash_mode, suqlntgVarWygqgxb2.vivhedu(0));
                                    break;
                                case 143:
                                    string = mainActivity.getString(R.string.nlog_crash_trigger);
                                    break;
                                case 144:
                                    string = mainActivity.getString(R.string.nlog_crash_reconnect);
                                    break;
                                case 145:
                                    string = mainActivity.getString(R.string.nlog_erase_partition, suqlntgVarWygqgxb2.vivhedu(0), zamkzqg.ccuulnt(suqlntgVarWygqgxb2.qxvquar(1)));
                                    break;
                                case 146:
                                    string = mainActivity.getString(R.string.nlog_erase_progress, Integer.valueOf(Math.max(0, Math.min(100, suqlntgVarWygqgxb2.lthborb(0, 0)))), zamkzqg.ccuulnt(suqlntgVarWygqgxb2.qxvquar(1)), zamkzqg.ccuulnt(suqlntgVarWygqgxb2.qxvquar(2)));
                                    break;
                                case 147:
                                    string = mainActivity.getString(R.string.nlog_erase_complete);
                                    break;
                                case 148:
                                    string = mainActivity.getString(R.string.nlog_fwup_item_start, Integer.valueOf(suqlntgVarWygqgxb2.lthborb(0, 0)), Integer.valueOf(suqlntgVarWygqgxb2.lthborb(1, 0)), suqlntgVarWygqgxb2.vivhedu(2));
                                    break;
                                case 149:
                                    string = mainActivity.getString(R.string.nlog_fwup_item_complete, Integer.valueOf(suqlntgVarWygqgxb2.lthborb(0, 0)), Integer.valueOf(suqlntgVarWygqgxb2.lthborb(1, 0)), suqlntgVarWygqgxb2.vivhedu(2));
                                    break;
                                default:
                                    switch (i6) {
                                        case 201:
                                            string = mainActivity.getString(R.string.nlog_handshake_start);
                                            break;
                                        case 202:
                                            string = mainActivity.getString(R.string.nlog_handshake_ok);
                                            break;
                                        case 203:
                                            string = mainActivity.getString(R.string.nlog_soc_id_start);
                                            break;
                                        case 204:
                                            string = mainActivity.getString(R.string.nlog_soc_id_ok);
                                            break;
                                        case 205:
                                            string = mainActivity.getString(R.string.nlog_meid_start);
                                            break;
                                        case 206:
                                            string = mainActivity.getString(R.string.nlog_meid_ok);
                                            break;
                                        case 207:
                                            string = mainActivity.getString(R.string.nlog_hw_code_start);
                                            break;
                                        case 208:
                                            string = mainActivity.getString(R.string.nlog_hw_code_ok, suqlntgVarWygqgxb2.vivhedu(0));
                                            break;
                                        case 209:
                                            string = mainActivity.getString(R.string.nlog_target_config_start);
                                            break;
                                        case 210:
                                            string = mainActivity.getString(R.string.nlog_target_config_ok, suqlntgVarWygqgxb2.vivhedu(0));
                                            break;
                                        case 211:
                                            string = mainActivity.getString(R.string.nlog_cpu, suqlntgVarWygqgxb2.vivhedu(0));
                                            break;
                                        case 212:
                                            string = mainActivity.getString(R.string.nlog_auth_start);
                                            break;
                                        case 213:
                                            string = mainActivity.getString(R.string.nlog_auth_ok);
                                            break;
                                        case 214:
                                            string = mainActivity.getString(R.string.nlog_da_parse_start);
                                            break;
                                        case 215:
                                            string = mainActivity.getString(R.string.nlog_da_parse_ok);
                                            break;
                                        case 216:
                                            string = mainActivity.getString(R.string.nlog_device_init_ok);
                                            break;
                                        case 217:
                                            string = mainActivity.getString(R.string.nlog_meid_skipped_preloader);
                                            break;
                                        case 218:
                                            string = mainActivity.getString(R.string.nlog_auth_not_sent);
                                            break;
                                        default:
                                            switch (i6) {
                                                case 301:
                                                    string = mainActivity.getString(R.string.nlog_xiaomi_challenge_opened, suqlntgVarWygqgxb2.vivhedu(0));
                                                    break;
                                                case 302:
                                                    string = mainActivity.getString(R.string.nlog_xiaomi_challenge_captured, suqlntgVarWygqgxb2.vivhedu(0));
                                                    break;
                                                case 303:
                                                    string = mainActivity.getString(R.string.nlog_xiaomi_response_length_accepted, suqlntgVarWygqgxb2.vivhedu(0));
                                                    break;
                                                case 304:
                                                    string = mainActivity.getString(R.string.nlog_xiaomi_response_sent, suqlntgVarWygqgxb2.vivhedu(0));
                                                    break;
                                                case 305:
                                                    string = mainActivity.getString(R.string.nlog_xiaomi_final_accepted, suqlntgVarWygqgxb2.vivhedu(1));
                                                    break;
                                                case 306:
                                                    string = mainActivity.getString(R.string.nlog_xiaomi_final_rejected, suqlntgVarWygqgxb2.vivhedu(1));
                                                    break;
                                                case 307:
                                                    string = mainActivity.getString(R.string.nlog_xiaomi_no_challenge, suqlntgVarWygqgxb2.vivhedu(1));
                                                    break;
                                                case 308:
                                                    string = mainActivity.getString(R.string.nlog_xiaomi_xflash_bypass);
                                                    break;
                                                default:
                                                    string = mainActivity.getString(R.string.nlog_unknown_event, Integer.valueOf(i6));
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    strVhimehb = zamkzqg.vhimehb(string);
                } else {
                    strVhimehb = (str2.startsWith("[RYNX]") || str2.startsWith("[CORE]")) ? zamkzqg.vhimehb(str2) : str2;
                }
                if (z) {
                    mainActivity.nmpwovh(strVhimehb);
                } else {
                    if (str2 != null && !mainActivity.ygdccqg.isEmpty()) {
                        suqlntg suqlntgVarWygqgxb3 = zamkzqg.wygqgxb(str2);
                        if (suqlntgVarWygqgxb3 != null) {
                            int i7 = suqlntgVarWygqgxb3.nmpwovh;
                            if (i7 != 113 && i7 != 116 && i7 != 117 && i7 != 140) {
                                if (i7 == 131) {
                                    mainActivity.cxxnoho = suqlntgVarWygqgxb3.vivhedu(0);
                                    mainActivity.clczezu = System.currentTimeMillis();
                                    break;
                                } else if (i7 != 132 && i7 != 134) {
                                    if (i7 == 133) {
                                        mainActivity.hiygjel("READ", Math.max(0, Math.min(100, suqlntgVarWygqgxb3.lthborb(0, 0))), suqlntgVarWygqgxb3.qxvquar(1), suqlntgVarWygqgxb3.qxvquar(2));
                                    } else if (i7 == 135) {
                                        mainActivity.rpdxrib("READ", mainActivity.cxxnoho);
                                    } else if (i7 == 136) {
                                        mainActivity.cxxnoho = suqlntgVarWygqgxb3.vivhedu(0);
                                        mainActivity.clczezu = System.currentTimeMillis();
                                    } else if (i7 == 137) {
                                        mainActivity.hiygjel("WRITE", Math.max(0, Math.min(100, suqlntgVarWygqgxb3.lthborb(0, 0))), suqlntgVarWygqgxb3.qxvquar(1), suqlntgVarWygqgxb3.qxvquar(2));
                                    } else if (i7 == 138) {
                                        mainActivity.rpdxrib("WRITE", mainActivity.cxxnoho);
                                    } else if (i7 == 145) {
                                        mainActivity.cxxnoho = suqlntgVarWygqgxb3.vivhedu(0);
                                        mainActivity.clczezu = System.currentTimeMillis();
                                    } else if (i7 == 146) {
                                        mainActivity.hiygjel("ERASE", Math.max(0, Math.min(100, suqlntgVarWygqgxb3.lthborb(0, 0))), suqlntgVarWygqgxb3.qxvquar(1), suqlntgVarWygqgxb3.qxvquar(2));
                                    } else if (i7 == 147) {
                                        mainActivity.rpdxrib("ERASE", mainActivity.cxxnoho);
                                    } else if (i7 == 148) {
                                        int iMax = Math.max(1, suqlntgVarWygqgxb3.lthborb(0, 1));
                                        int iMax2 = Math.max(iMax, suqlntgVarWygqgxb3.lthborb(1, iMax));
                                        String strVivhedu = suqlntgVarWygqgxb3.vivhedu(2);
                                        mainActivity.cxxnoho = strVivhedu;
                                        mainActivity.clczezu = System.currentTimeMillis();
                                        ProgressBar progressBar = mainActivity.oxoagud;
                                        if (progressBar != null) {
                                            progressBar.setMax(iMax2);
                                            mainActivity.oxoagud.setProgress(Math.max(0, iMax - 1));
                                        }
                                        TextView textView = mainActivity.axbavsj;
                                        if (textView != null) {
                                            textView.setText(mainActivity.getString(R.string.batch_overall_running, Integer.valueOf(iMax), Integer.valueOf(iMax2)));
                                        }
                                        TextView textView2 = mainActivity.zngzleo;
                                        if (textView2 != null) {
                                            textView2.setText(strVivhedu);
                                        }
                                        ProgressBar progressBar2 = mainActivity.vhimehb;
                                        if (progressBar2 != null) {
                                            progressBar2.setProgress(0);
                                        }
                                        TextView textView3 = mainActivity.naaizwn;
                                        if (textView3 != null) {
                                            textView3.setText("0%");
                                        }
                                        TextView textView4 = mainActivity.hjlrtqw;
                                        if (textView4 != null) {
                                            textView4.setText(R.string.batch_running);
                                        }
                                    } else if (i7 == 149) {
                                        int iMax3 = Math.max(1, suqlntgVarWygqgxb3.lthborb(0, 1));
                                        int iMax4 = Math.max(iMax3, suqlntgVarWygqgxb3.lthborb(1, iMax3));
                                        ProgressBar progressBar3 = mainActivity.oxoagud;
                                        if (progressBar3 != null) {
                                            progressBar3.setMax(iMax4);
                                            mainActivity.oxoagud.setProgress(iMax3);
                                        }
                                        TextView textView5 = mainActivity.axbavsj;
                                        if (textView5 != null) {
                                            textView5.setText(mainActivity.getString(R.string.batch_overall_completed, Integer.valueOf(iMax3), Integer.valueOf(iMax4)));
                                        }
                                    }
                                    break;
                                }
                            }
                        } else {
                            String str4 = "[RYNX] " + mainActivity.ygdccqg + " ";
                            int iIndexOf = str2.indexOf(str4);
                            int iIndexOf2 = str2.indexOf(37, iIndexOf < 0 ? 0 : str4.length() + iIndexOf);
                            if (iIndexOf >= 0 && iIndexOf2 >= 0) {
                                try {
                                    int iMax5 = Math.max(0, Math.min(100, Integer.parseInt(str2.substring(iIndexOf + str4.length(), iIndexOf2).trim())));
                                    int iIndexOf3 = str2.indexOf(40, iIndexOf2);
                                    int iIndexOf4 = str2.indexOf(47, iIndexOf3);
                                    int iIndexOf5 = str2.indexOf(41, iIndexOf4);
                                    if (iIndexOf3 < 0 || iIndexOf4 <= iIndexOf3 || iIndexOf5 <= iIndexOf4) {
                                        j = -1;
                                        j2 = -1;
                                    } else {
                                        long j3 = Long.parseLong(str2.substring(iIndexOf3 + 1, iIndexOf4).trim());
                                        j2 = Long.parseLong(str2.substring(iIndexOf4 + 1, iIndexOf5).trim());
                                        j = j3;
                                    }
                                    mainActivity.hiygjel(mainActivity.ygdccqg, iMax5, j, j2);
                                    break;
                                } catch (RuntimeException unused2) {
                                }
                            }
                        }
                    }
                    mainActivity.nmpwovh(strVhimehb);
                }
                break;
            default:
                Activity activity = this.vivhedu;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    ziuhthw ziuhthwVar = (ziuhthw) this.lthborb;
                    if (ziuhthwVar.nmpwovh > 301) {
                        String string7 = activity.getString(R.string.update_available_message, com.rynx.app.BuildConfig.VERSION_NAME, ziuhthwVar.ojyssqt);
                        String str5 = ziuhthwVar.vivhedu;
                        if (!str5.isEmpty()) {
                            string7 = string7 + "\n\n" + str5;
                        }
                        AlertDialog.Builder negativeButton = new AlertDialog.Builder(activity).setTitle(R.string.update_available_title).setMessage(string7).setNegativeButton(R.string.update_later, (DialogInterface.OnClickListener) null);
                        String str6 = ziuhthwVar.lthborb;
                        if (str6 != null && !str6.isEmpty()) {
                            negativeButton.setPositiveButton(R.string.update_download, new pmsrvoc(activity, ziuhthwVar, i3));
                        }
                        negativeButton.show();
                    } else if (this.ojyssqt) {
                        Toast.makeText(activity, R.string.update_up_to_date, 0).show();
                    }
                    break;
                }
                break;
        }
    }
}
