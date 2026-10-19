package x;

import com.rynx.app.MainActivity;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yjbrzgu implements Runnable {
    public final /* synthetic */ String lthborb;
    public final /* synthetic */ int nmpwovh;
    public final /* synthetic */ MainActivity ojyssqt;
    public final /* synthetic */ String qxvquar;
    public final /* synthetic */ long vivhedu;

    public /* synthetic */ yjbrzgu(MainActivity mainActivity, long j, String str, String str2, int i) {
        this.nmpwovh = i;
        this.ojyssqt = mainActivity;
        this.vivhedu = j;
        this.lthborb = str;
        this.qxvquar = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.nmpwovh) {
            case 0:
                MainActivity mainActivity = this.ojyssqt;
                String str = this.lthborb;
                String str2 = this.qxvquar;
                long j = this.vivhedu;
                if (str != null) {
                    tmdubwv tmdubwvVarUzyihoe = mainActivity.uzyihoe();
                    String strSubstring = str.substring(0, str.indexOf(10));
                    HashSet hashSet = (HashSet) tmdubwvVarUzyihoe.nmpwovh;
                    if (str2.startsWith("OK\nPARTITION: ")) {
                        hashSet.remove(str);
                        StringBuilder sb = new StringBuilder();
                        sb.append(strSubstring);
                        sb.append("\n");
                        String strSubstring2 = str2.substring(14);
                        int iIndexOf = strSubstring2.indexOf(10);
                        if (iIndexOf >= 0) {
                            strSubstring2 = strSubstring2.substring(0, iIndexOf);
                        }
                        sb.append(strSubstring2);
                        hashSet.remove(sb.toString());
                    } else if (str2.startsWith("ERROR\nPREFLIGHT: ")) {
                        hashSet.remove(str);
                    } else if (str2.startsWith("ERROR\nINCOMPLETE FLASH: ")) {
                        hashSet.remove(str);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(strSubstring);
                        sb2.append("\n");
                        String strSubstring3 = str2.substring(24);
                        int iIndexOf2 = strSubstring3.indexOf(10);
                        if (iIndexOf2 >= 0) {
                            strSubstring3 = strSubstring3.substring(0, iIndexOf2);
                        }
                        sb2.append(strSubstring3);
                        hashSet.add(sb2.toString());
                    }
                    mainActivity.getSharedPreferences("fastboot_flash_journal", 0).edit().putStringSet("incomplete", new HashSet((HashSet) tmdubwvVarUzyihoe.nmpwovh)).commit();
                }
                if (j == mainActivity.gepzcpd) {
                    mainActivity.jbmzxye();
                    if (str2.startsWith("OK\n")) {
                        String strTrim = str2.substring(3).trim();
                        mainActivity.fusjbbl(strTrim.isEmpty() ? "OKAY" : strTrim);
                        mainActivity.nmpwovh("[FASTBOOT] ".concat(strTrim));
                    } else {
                        String strTrim2 = str2.replaceFirst("^ERROR\n", "").trim();
                        mainActivity.fusjbbl("ERROR: " + strTrim2);
                        mainActivity.nmpwovh("[FASTBOOT] " + strTrim2);
                    }
                    mainActivity.gdkopre();
                    if ("android_tools".equals(mainActivity.ayzlrnr)) {
                        mainActivity.wfxzfba(false);
                    }
                    break;
                }
                break;
            case 1:
                MainActivity mainActivity2 = this.ojyssqt;
                long j2 = this.vivhedu;
                String str3 = this.lthborb;
                String str4 = this.qxvquar;
                if (j2 == mainActivity2.gepzcpd) {
                    mainActivity2.nxumtuo = false;
                    if (str3 == null && "0".equals(str4)) {
                        mainActivity2.sjexbpf = true;
                        mainActivity2.fusjbbl(mainActivity2.guecdgy().trim());
                    } else {
                        StringBuilder sb3 = new StringBuilder("ERROR: root shell unavailable");
                        sb3.append((str3 == null || str3.isEmpty()) ? str4.isEmpty() ? "" : ": ".concat(str4) : ": ".concat(str3));
                        mainActivity2.fusjbbl(sb3.toString());
                    }
                    mainActivity2.gdkopre();
                    break;
                }
                break;
            case 2:
                MainActivity mainActivity3 = this.ojyssqt;
                long j3 = this.vivhedu;
                String str5 = this.lthborb;
                String str6 = this.qxvquar;
                if (j3 == mainActivity3.gepzcpd) {
                    boolean z = false;
                    mainActivity3.nxumtuo = false;
                    if (str5 == null) {
                        if (str6 == null) {
                            str6 = "";
                        }
                        String[] strArrSplit = str6.replace("\r", "").split("\n", -1);
                        if (strArrSplit.length > 0 && !strArrSplit[0].trim().isEmpty()) {
                            mainActivity3.gucwjqz = strArrSplit[0].trim();
                        }
                        if (strArrSplit.length <= 1 || strArrSplit[1].trim().isEmpty()) {
                            mainActivity3.mcdstyz = "/";
                        } else {
                            mainActivity3.mcdstyz = strArrSplit[1].trim();
                        }
                        if (strArrSplit.length > 2 && "0".equals(strArrSplit[2].trim())) {
                            z = true;
                        }
                        mainActivity3.sjexbpf = z;
                        mainActivity3.thbdbid = true;
                        mainActivity3.fusjbbl(mainActivity3.guecdgy().trim());
                        mainActivity3.gdkopre();
                    } else {
                        mainActivity3.fusjbbl("ERROR: unable to open ADB shell: ".concat(str5));
                        mainActivity3.gdkopre();
                    }
                    break;
                }
                break;
            default:
                MainActivity mainActivity4 = this.ojyssqt;
                long j4 = this.vivhedu;
                String str7 = this.lthborb;
                String str8 = this.qxvquar;
                if (j4 == mainActivity4.gepzcpd) {
                    mainActivity4.nxumtuo = false;
                    if (str7 != null) {
                        mainActivity4.fusjbbl("ERROR: ".concat(str7));
                    } else if (str8.startsWith("/")) {
                        String[] strArrSplit2 = str8.split("\n");
                        mainActivity4.mcdstyz = strArrSplit2[strArrSplit2.length - 1].trim();
                    } else if (!str8.isEmpty()) {
                        mainActivity4.fusjbbl(str8);
                    }
                    if (mainActivity4.thbdbid) {
                        mainActivity4.fusjbbl(mainActivity4.guecdgy().trim());
                    }
                    mainActivity4.gdkopre();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ yjbrzgu(MainActivity mainActivity, String str, String str2, long j) {
        this.nmpwovh = 0;
        this.ojyssqt = mainActivity;
        this.lthborb = str;
        this.qxvquar = str2;
        this.vivhedu = j;
    }
}
