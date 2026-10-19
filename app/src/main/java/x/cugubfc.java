package x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class cugubfc {
    public static final HashSet nmpwovh = new HashSet(Arrays.asList("probe", "upload", "up", "read", "r", "read-flash", "rf", "write-flash", "wf", "download", "dl", "write", "w", "pgpt", "gpt", "reboot", "shutdown", "format", "erase", "write-offset", "read-offset", "write-all", "read-all", "seccfg", "peek", "poke", "rpmb", "xflash", "x-flash", "set-active-slot", "crash"));
    public static final HashSet ojyssqt = new HashSet(Arrays.asList("probe", "upload", "read-flash", "write-flash", "download", "pgpt", "reboot", "shutdown", "seccfg", "crash"));
    public static final HashSet vivhedu = new HashSet(Arrays.asList("upload", "up", "read", "r", "read-flash", "rf"));
    public static final HashSet lthborb = new HashSet(Arrays.asList("write-flash", "wf", "download", "dl", "write", "w"));

    public static String dytyqos(ArrayList arrayList, int i, int i2) {
        int i3 = i + 1;
        int i4 = 0;
        while (i3 < arrayList.size()) {
            String str = (String) arrayList.get(i3);
            if (qxvquar(str)) {
                int i5 = i3 + 1;
                if (i5 < arrayList.size()) {
                    i3 = i5;
                }
            } else if (!lthborb(str) && !oqexvyb(str)) {
                if (i4 == i2) {
                    return str;
                }
                i4++;
            }
            i3++;
        }
        return null;
    }

    public static String imuemzb(String str, String str2, ArrayList arrayList) {
        int i;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str3 = (String) arrayList.get(i2);
            if ((str3.equals(str) || str3.equals(str2)) && (i = i2 + 1) < arrayList.size()) {
                return (String) arrayList.get(i);
            }
        }
        return null;
    }

    public static boolean lthborb(String str) {
        return str.equals("--cli") || str.equals("-c") || str.equals("--verbose") || str.equals("-v") || str.equals("--usb-log");
    }

    public static int nkemejx(String str, String str2, ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            String str3 = (String) arrayList.get(i);
            if (str3.equals(str) || str3.equals(str2)) {
                int i2 = i + 1;
                if (i2 >= arrayList.size()) {
                    return i2;
                }
                String str4 = (String) arrayList.get(i2);
                if (oqexvyb(str4) || nmpwovh.contains(str4.toLowerCase(Locale.ROOT))) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public static String nmpwovh(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        if (lowerCase.equals("up") || lowerCase.equals("read") || lowerCase.equals("r")) {
            return "upload";
        }
        if (lowerCase.equals("rf")) {
            return "read-flash";
        }
        if (lowerCase.equals("wf")) {
            return "write-flash";
        }
        if (lowerCase.equals("dl") || lowerCase.equals("write") || lowerCase.equals("w")) {
            return "download";
        }
        if (lowerCase.equals("gpt")) {
            return "pgpt";
        }
        return lowerCase.equals("xflash") ? "x-flash" : lowerCase;
    }

    public static int ojyssqt(ArrayList arrayList, int i) {
        int i2 = i + 1;
        int i3 = 0;
        while (i2 < arrayList.size()) {
            String str = (String) arrayList.get(i2);
            if (qxvquar(str)) {
                int i4 = i2 + 1;
                if (i4 < arrayList.size()) {
                    i2 = i4;
                }
            } else if (!lthborb(str) && !oqexvyb(str)) {
                i3++;
            }
            i2++;
        }
        return i3;
    }

    public static boolean oqexvyb(String str) {
        return str.startsWith("-") && str.length() > 1;
    }

    public static boolean qxvquar(String str) {
        return str.equals("--da") || str.equals("-d") || str.equals("--auth") || str.equals("-a") || str.equals("--pl") || str.equals("-p");
    }

    public static int vivhedu(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (nmpwovh.contains(((String) arrayList.get(i)).toLowerCase(Locale.ROOT))) {
                return i;
            }
        }
        return -1;
    }
}
