package x;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import com.rynx.app.MainActivity;
import com.rynx.app.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class wjugzfh {
    public final /* synthetic */ MainActivity nmpwovh;

    public /* synthetic */ wjugzfh(MainActivity mainActivity) {
        this.nmpwovh = mainActivity;
    }

    public String nmpwovh() {
        MainActivity mainActivity = this.nmpwovh;
        ArrayList arrayList = mainActivity.silhone;
        if (arrayList.isEmpty()) {
            return null;
        }
        if (mainActivity.ankiohq >= arrayList.size() - 1) {
            mainActivity.ankiohq = arrayList.size();
            return "";
        }
        int i = mainActivity.ankiohq + 1;
        mainActivity.ankiohq = i;
        return (String) arrayList.get(i);
    }

    public String ojyssqt() {
        MainActivity mainActivity = this.nmpwovh;
        ArrayList arrayList = mainActivity.silhone;
        if (arrayList.isEmpty()) {
            return null;
        }
        int i = mainActivity.ankiohq;
        if (i > 0) {
            mainActivity.ankiohq = i - 1;
        }
        return (String) arrayList.get(mainActivity.ankiohq);
    }

    public void vivhedu(String str) {
        String lowerCase;
        MainActivity mainActivity = this.nmpwovh;
        mainActivity.getClass();
        String strTrim = str == null ? "" : str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        String strTrim2 = strTrim.trim();
        if (!strTrim2.isEmpty()) {
            ArrayList arrayList = mainActivity.silhone;
            if (arrayList.isEmpty() || !strTrim2.equals(arrayList.get(arrayList.size() - 1))) {
                arrayList.add(strTrim2);
                if (arrayList.size() > 100) {
                    arrayList.remove(0);
                }
            }
            mainActivity.ankiohq = arrayList.size();
        }
        if ("clear".equalsIgnoreCase(strTrim) || "cls".equalsIgnoreCase(strTrim)) {
            ccuulnt ccuulntVar = mainActivity.suqlntg;
            synchronized (ccuulntVar) {
                ccuulntVar.nmpwovh.setLength(0);
            }
            ccuulntVar.nmpwovh(true);
            jybecxv jybecxvVar = mainActivity.ltnesel;
            if (jybecxvVar != null) {
                jybecxvVar.oqexvyb.scrollTo(0, 0);
            }
            if (mainActivity.thbdbid) {
                mainActivity.fusjbbl(mainActivity.guecdgy().trim());
                return;
            }
            return;
        }
        mainActivity.fusjbbl(mainActivity.guecdgy() + strTrim);
        if (mainActivity.thbdbid) {
            if ("exit".equalsIgnoreCase(strTrim) || "logout".equalsIgnoreCase(strTrim)) {
                if (mainActivity.sjexbpf) {
                    mainActivity.sjexbpf = false;
                    mainActivity.fusjbbl(mainActivity.guecdgy().trim());
                    return;
                } else {
                    mainActivity.thbdbid = false;
                    mainActivity.mcdstyz = "/";
                    mainActivity.gucwjqz = "device";
                    mainActivity.fusjbbl("ADB shell closed.");
                    return;
                }
            }
            String strTrim3 = strTrim.trim();
            if (strTrim3.isEmpty()) {
                return;
            }
            if ("su".equals(strTrim3) || "su 0".equals(strTrim3)) {
                UsbDevice usbDevice = mainActivity.ulafhci;
                if (zamkzqg.nsyqsfj(usbDevice) != 2) {
                    mainActivity.fusjbbl("ERROR: ADB device disconnected");
                    return;
                }
                if (mainActivity.nxumtuo || mainActivity.dvzxbaj) {
                    mainActivity.fusjbbl("ERROR: USB transport is busy");
                    return;
                }
                UsbDeviceConnection usbDeviceConnectionCzgynww = mainActivity.czgynww(usbDevice);
                if (usbDeviceConnectionCzgynww == null) {
                    mainActivity.fusjbbl("ERROR: ADB USB connection unavailable");
                    return;
                }
                mainActivity.nxumtuo = true;
                long j = 1 + mainActivity.gepzcpd;
                mainActivity.gepzcpd = j;
                mainActivity.gdkopre();
                mainActivity.zftrkmx = mainActivity.slxntng.submit(new vopsyhw(mainActivity, usbDevice, usbDeviceConnectionCzgynww, j, 0));
                return;
            }
            try {
                ArrayList arrayListIqvvlnh = mainActivity.iqvvlnh(strTrim3);
                if (arrayListIqvvlnh.isEmpty() || !"cd".equals(arrayListIqvvlnh.get(0))) {
                    UsbDevice usbDevice2 = mainActivity.ulafhci;
                    if (zamkzqg.nsyqsfj(usbDevice2) != 2) {
                        mainActivity.fusjbbl("ERROR: ADB device disconnected");
                        return;
                    }
                    if (mainActivity.nxumtuo || mainActivity.dvzxbaj) {
                        mainActivity.fusjbbl("ERROR: USB transport is busy");
                        return;
                    }
                    UsbDeviceConnection usbDeviceConnectionCzgynww2 = mainActivity.czgynww(usbDevice2);
                    if (usbDeviceConnectionCzgynww2 == null) {
                        mainActivity.fusjbbl("ERROR: ADB USB connection unavailable");
                        return;
                    }
                    String str2 = "cd " + com.rynx.app.ojyssqt.ccuulnt(mainActivity.mcdstyz) + " && " + strTrim3;
                    if (mainActivity.sjexbpf) {
                        str2 = "su -c " + com.rynx.app.ojyssqt.ccuulnt(str2);
                    }
                    mainActivity.nxumtuo = true;
                    long j2 = mainActivity.gepzcpd + 1;
                    mainActivity.gepzcpd = j2;
                    mainActivity.gdkopre();
                    mainActivity.pcbbvuj("\n");
                    mainActivity.zftrkmx = mainActivity.slxntng.submit(new czidoiw(mainActivity, usbDevice2, usbDeviceConnectionCzgynww2, str2, j2, 2));
                    return;
                }
                if (arrayListIqvvlnh.size() > 2) {
                    mainActivity.fusjbbl("cd: too many arguments");
                    return;
                }
                String str3 = arrayListIqvvlnh.size() == 1 ? "/" : (String) arrayListIqvvlnh.get(1);
                UsbDevice usbDevice3 = mainActivity.ulafhci;
                if (zamkzqg.nsyqsfj(usbDevice3) != 2) {
                    mainActivity.fusjbbl("ERROR: ADB device disconnected");
                    return;
                }
                if (mainActivity.nxumtuo || mainActivity.dvzxbaj) {
                    mainActivity.fusjbbl("ERROR: USB transport is busy");
                    return;
                }
                UsbDeviceConnection usbDeviceConnectionCzgynww3 = mainActivity.czgynww(usbDevice3);
                if (usbDeviceConnectionCzgynww3 == null) {
                    mainActivity.fusjbbl("ERROR: ADB USB connection unavailable");
                    return;
                }
                String str4 = "cd " + com.rynx.app.ojyssqt.ccuulnt(mainActivity.mcdstyz) + " && cd " + com.rynx.app.ojyssqt.ccuulnt(str3) + " && pwd";
                if (mainActivity.sjexbpf) {
                    str4 = "su -c " + com.rynx.app.ojyssqt.ccuulnt(str4);
                }
                mainActivity.nxumtuo = true;
                long j3 = mainActivity.gepzcpd + 1;
                mainActivity.gepzcpd = j3;
                mainActivity.gdkopre();
                mainActivity.zftrkmx = mainActivity.slxntng.submit(new czidoiw(mainActivity, usbDevice3, usbDeviceConnectionCzgynww3, str4, j3, 0));
                return;
            } catch (IllegalArgumentException e) {
                mainActivity.fusjbbl("ERROR: " + e.getMessage());
                return;
            }
        }
        Locale locale = Locale.ROOT;
        String lowerCase2 = strTrim.toLowerCase(locale);
        if ("help".equals(lowerCase2) || "?".equals(lowerCase2)) {
            mainActivity.fusjbbl(mainActivity.getString(R.string.android_tools_terminal_help));
            return;
        }
        if ("pwd".equals(lowerCase2)) {
            mainActivity.fusjbbl(mainActivity.gzvolsx.getAbsolutePath());
            return;
        }
        try {
            ArrayList arrayListIqvvlnh2 = mainActivity.iqvvlnh(strTrim);
            if (!arrayListIqvvlnh2.isEmpty()) {
                String lowerCase3 = ((String) arrayListIqvvlnh2.get(0)).toLowerCase(locale);
                if ("cd".equals(lowerCase3)) {
                    if (arrayListIqvvlnh2.size() > 2) {
                        mainActivity.fusjbbl("Usage: cd [directory]");
                        return;
                    }
                    File file = arrayListIqvvlnh2.size() == 1 ? new File("/storage/emulated/0") : mainActivity.pwjmwpv((String) arrayListIqvvlnh2.get(1));
                    if (!file.exists()) {
                        mainActivity.fusjbbl("cd: no such directory: " + file.getAbsolutePath());
                        return;
                    }
                    if (!file.isDirectory()) {
                        mainActivity.fusjbbl("cd: not a directory: " + file.getAbsolutePath());
                        return;
                    }
                    if (file.listFiles() == null && !file.canRead()) {
                        mainActivity.fusjbbl("cd: permission denied: " + file.getAbsolutePath());
                        return;
                    }
                    File fileGisppfs = zamkzqg.gisppfs(file);
                    mainActivity.gzvolsx = fileGisppfs;
                    mainActivity.fusjbbl(fileGisppfs.getAbsolutePath());
                    return;
                }
                if ("ls".equals(lowerCase3) || "ll".equals(lowerCase3)) {
                    boolean zEquals = "ll".equals(lowerCase3);
                    String str5 = null;
                    for (int i = 1; i < arrayListIqvvlnh2.size(); i++) {
                        String str6 = (String) arrayListIqvvlnh2.get(i);
                        if (str6.startsWith("-") && str6.contains("l")) {
                            zEquals = true;
                        } else if (!str6.startsWith("-") && str5 == null) {
                            str5 = str6;
                        } else if (!str6.startsWith("-")) {
                            mainActivity.fusjbbl("Usage: ls [-l] [path]");
                            return;
                        }
                    }
                    File filePwjmwpv = str5 == null ? mainActivity.gzvolsx : mainActivity.pwjmwpv(str5);
                    if (filePwjmwpv == null || !filePwjmwpv.exists()) {
                        StringBuilder sb = new StringBuilder("ls: not found: ");
                        sb.append(filePwjmwpv != null ? filePwjmwpv.getAbsolutePath() : "");
                        mainActivity.fusjbbl(sb.toString());
                        return;
                    }
                    if (filePwjmwpv.isFile()) {
                        mainActivity.fusjbbl(zEquals ? String.format(Locale.US, "%10s  %s", zamkzqg.jybecxv(filePwjmwpv.length()), filePwjmwpv.getName()) : filePwjmwpv.getName());
                        return;
                    }
                    File[] fileArrListFiles = filePwjmwpv.listFiles();
                    if (fileArrListFiles == null) {
                        mainActivity.fusjbbl("ls: permission denied: " + filePwjmwpv.getAbsolutePath());
                        return;
                    }
                    Arrays.sort(fileArrListFiles, new buswjhz(0));
                    if (zEquals) {
                        mainActivity.fusjbbl("Directory: " + filePwjmwpv.getAbsolutePath());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (File file2 : fileArrListFiles) {
                        if (sb2.length() > 0) {
                            sb2.append('\n');
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(file2.getName());
                        sb3.append(file2.isDirectory() ? "/" : "");
                        String string = sb3.toString();
                        if (zEquals) {
                            sb2.append(file2.isDirectory() ? "d " : "- ");
                            sb2.append(String.format(Locale.US, "%10s  ", file2.isDirectory() ? "<DIR>" : zamkzqg.jybecxv(file2.length())));
                            sb2.append(string);
                        } else {
                            sb2.append(string);
                        }
                    }
                    mainActivity.fusjbbl(sb2.length() == 0 ? "(empty)" : sb2.toString());
                    return;
                }
                if ("stat".equals(lowerCase3)) {
                    if (arrayListIqvvlnh2.size() != 2) {
                        mainActivity.fusjbbl("Usage: stat <path>");
                        return;
                    }
                    File filePwjmwpv2 = mainActivity.pwjmwpv((String) arrayListIqvvlnh2.get(1));
                    if (!filePwjmwpv2.exists()) {
                        mainActivity.fusjbbl("stat: not found: " + filePwjmwpv2.getAbsolutePath());
                        return;
                    }
                    StringBuilder sb4 = new StringBuilder("Path: ");
                    sb4.append(filePwjmwpv2.getAbsolutePath());
                    sb4.append("\nType: ");
                    sb4.append(filePwjmwpv2.isDirectory() ? "directory" : filePwjmwpv2.isFile() ? "file" : "other");
                    sb4.append(filePwjmwpv2.isFile() ? "\nSize: " + zamkzqg.jybecxv(filePwjmwpv2.length()) + " (" + filePwjmwpv2.length() + " bytes)" : "");
                    sb4.append("\nReadable: ");
                    sb4.append(filePwjmwpv2.canRead());
                    sb4.append("\nWritable: ");
                    sb4.append(filePwjmwpv2.canWrite());
                    mainActivity.fusjbbl(sb4.toString());
                    return;
                }
            }
            if ("adb".equals(lowerCase2) || "adb help".equals(lowerCase2)) {
                mainActivity.fusjbbl(mainActivity.getString(R.string.android_tools_terminal_adb_help));
                return;
            }
            if ("fastboot".equals(lowerCase2) || "fastboot help".equals(lowerCase2)) {
                mainActivity.fusjbbl(mainActivity.getString(R.string.android_tools_terminal_fastboot_help));
                return;
            }
            if (!lowerCase2.startsWith("adb ")) {
                if (lowerCase2.startsWith("fastboot ")) {
                    mainActivity.neppdxk(strTrim.substring(9).trim());
                    return;
                } else {
                    mainActivity.fusjbbl(mainActivity.getString(R.string.android_tools_terminal_prefix_required));
                    return;
                }
            }
            String strTrim4 = strTrim.substring(4).trim();
            try {
                ArrayList arrayListIqvvlnh3 = mainActivity.iqvvlnh(strTrim4);
                if (arrayListIqvvlnh3.isEmpty()) {
                    mainActivity.fusjbbl(mainActivity.getString(R.string.android_tools_terminal_adb_help));
                    return;
                }
                String lowerCase4 = ((String) arrayListIqvvlnh3.get(0)).toLowerCase(locale);
                String str7 = "device";
                if ("devices".equals(lowerCase4)) {
                    if (zamkzqg.nsyqsfj(mainActivity.ulafhci) != 2) {
                        mainActivity.fusjbbl("List of devices attached\n(no ADB device detected)");
                        return;
                    }
                    jybecxv jybecxvVar2 = mainActivity.ltnesel;
                    if (jybecxvVar2 != null && jybecxvVar2.dytyqos.getText() != null) {
                        String strTrim5 = mainActivity.ltnesel.dytyqos.getText().toString().trim();
                        if (!strTrim5.isEmpty() && !"—".equals(strTrim5) && !mainActivity.getString(R.string.value_not_available).equals(strTrim5)) {
                            str7 = strTrim5;
                        }
                    }
                    StringBuilder sb5 = new StringBuilder("List of devices attached\n");
                    sb5.append(mainActivity.gngavpw(2));
                    sb5.append("\t");
                    sb5.append(str7);
                    sb5.append(arrayListIqvvlnh3.contains("-l") ? " usb:direct" : "");
                    mainActivity.fusjbbl(sb5.toString());
                    return;
                }
                if ("get-state".equals(lowerCase4)) {
                    if (zamkzqg.nsyqsfj(mainActivity.ulafhci) != 2) {
                        str7 = "no device";
                    } else if (mainActivity.ltnesel != null && mainActivity.getString(R.string.android_tools_adb_unauthorized_value).contentEquals(mainActivity.ltnesel.dytyqos.getText())) {
                        str7 = "unauthorized";
                    }
                    mainActivity.fusjbbl(str7);
                    return;
                }
                if ("get-serialno".equals(lowerCase4)) {
                    mainActivity.fusjbbl(zamkzqg.nsyqsfj(mainActivity.ulafhci) == 2 ? mainActivity.gngavpw(2) : "unknown");
                    return;
                }
                if ("get-devpath".equals(lowerCase4)) {
                    mainActivity.fusjbbl(mainActivity.ulafhci != null ? mainActivity.ulafhci.getDeviceName() : "unknown");
                    return;
                }
                if ("version".equals(lowerCase4) || "--version".equals(lowerCase4)) {
                    mainActivity.fusjbbl("rynx direct ADB host (USB transport, no adb server)");
                    return;
                }
                if ("reconnect".equals(lowerCase4)) {
                    mainActivity.fusjbbl("Refreshing direct ADB USB transport...");
                    mainActivity.jzcfpou();
                    return;
                }
                if ("start-server".equals(lowerCase4) || "kill-server".equals(lowerCase4)) {
                    mainActivity.fusjbbl("This APK talks to adbd directly over USB; there is no local adb server.");
                    return;
                }
                if ("wait-for-device".equals(lowerCase4)) {
                    mainActivity.fusjbbl("wait-for-device requires adb-server style transport tracking; direct-USB mode does not block/wait for future devices. Use 'adb devices' or Refresh Device.");
                    return;
                }
                if ("shell".equals(lowerCase4)) {
                    if (arrayListIqvvlnh3.size() >= 2) {
                        int iIndexOf = strTrim4.indexOf(32);
                        mainActivity.otaqyat(iIndexOf < 0 ? "" : strTrim4.substring(iIndexOf + 1).trim());
                        return;
                    }
                    UsbDevice usbDevice4 = mainActivity.ulafhci;
                    if (zamkzqg.nsyqsfj(usbDevice4) != 2) {
                        mainActivity.fusjbbl("ERROR: no device in ADB mode");
                        return;
                    }
                    if (mainActivity.nxumtuo || mainActivity.dvzxbaj || mainActivity.lpkdqgx || mainActivity.gzokllk || mainActivity.nsyqsfj) {
                        mainActivity.fusjbbl("ERROR: USB transport is busy");
                        return;
                    }
                    if (!mainActivity.dplrlfq.hasPermission(usbDevice4) || !mainActivity.qyeibyo()) {
                        mainActivity.hhqpjvl(usbDevice4);
                        mainActivity.fusjbbl("USB permission/open required. Approve the Android USB prompt and retry.");
                        return;
                    }
                    UsbDeviceConnection usbDeviceConnectionCzgynww4 = mainActivity.czgynww(usbDevice4);
                    if (usbDeviceConnectionCzgynww4 == null) {
                        mainActivity.fusjbbl("ERROR: ADB USB connection unavailable");
                        return;
                    }
                    mainActivity.nxumtuo = true;
                    long j4 = 1 + mainActivity.gepzcpd;
                    mainActivity.gepzcpd = j4;
                    mainActivity.gdkopre();
                    mainActivity.zftrkmx = mainActivity.slxntng.submit(new vopsyhw(mainActivity, usbDevice4, usbDeviceConnectionCzgynww4, j4, 1));
                    return;
                }
                if ("exec-out".equals(lowerCase4)) {
                    if (arrayListIqvvlnh3.size() < 2) {
                        mainActivity.fusjbbl("Usage: adb exec-out <command> [> local_file]");
                        return;
                    }
                    int iIndexOf2 = arrayListIqvvlnh3.indexOf(">");
                    if (iIndexOf2 < 0) {
                        int iIndexOf3 = strTrim4.indexOf(32);
                        mainActivity.snilumr("exec-out", new lclupha(mainActivity, iIndexOf3 < 0 ? "" : strTrim4.substring(iIndexOf3 + 1).trim(), 0));
                        return;
                    } else if (iIndexOf2 < 2 || iIndexOf2 != arrayListIqvvlnh3.size() - 2) {
                        mainActivity.fusjbbl("Usage: adb exec-out <command> > <local_file>");
                        return;
                    } else {
                        mainActivity.snilumr("exec-out", new jdqigmr(mainActivity, zamkzqg.gjpruie(arrayListIqvvlnh3, 1, iIndexOf2), mainActivity.pwjmwpv((String) arrayListIqvvlnh3.get(iIndexOf2 + 1)), 0));
                        return;
                    }
                }
                if ("push".equals(lowerCase4)) {
                    if (arrayListIqvvlnh3.size() != 3) {
                        mainActivity.fusjbbl("Usage: adb push <local> <remote>");
                        return;
                    }
                    File filePwjmwpv3 = mainActivity.pwjmwpv((String) arrayListIqvvlnh3.get(1));
                    String str8 = (String) arrayListIqvvlnh3.get(2);
                    if (str8.endsWith("/")) {
                        str8 = str8 + filePwjmwpv3.getName();
                    }
                    mainActivity.snilumr("push", new jdqigmr(mainActivity, filePwjmwpv3, str8, 1));
                    return;
                }
                if ("pull".equals(lowerCase4)) {
                    if (arrayListIqvvlnh3.size() < 2 || arrayListIqvvlnh3.size() > 3) {
                        mainActivity.fusjbbl("Usage: adb pull <remote> [local]");
                        return;
                    }
                    String str9 = (String) arrayListIqvvlnh3.get(1);
                    String strSubstring = str9.substring(str9.lastIndexOf(47) + 1);
                    if (strSubstring.isEmpty()) {
                        strSubstring = "adb-pull.bin";
                    }
                    File filePwjmwpv4 = arrayListIqvvlnh3.size() == 3 ? mainActivity.pwjmwpv((String) arrayListIqvvlnh3.get(2)) : new File(mainActivity.gzvolsx, strSubstring);
                    if (filePwjmwpv4.isDirectory()) {
                        filePwjmwpv4 = new File(filePwjmwpv4, strSubstring);
                    }
                    mainActivity.snilumr("pull", new jdqigmr(mainActivity, str9, filePwjmwpv4, 2));
                    return;
                }
                if ("install".equals(lowerCase4)) {
                    if (arrayListIqvvlnh3.size() < 2) {
                        mainActivity.fusjbbl("Usage: adb install [options] <apk>");
                        return;
                    } else {
                        mainActivity.snilumr("install", new jdqigmr(mainActivity, mainActivity.pwjmwpv((String) arrayListIqvvlnh3.get(arrayListIqvvlnh3.size() - 1)), zamkzqg.gjpruie(arrayListIqvvlnh3, 1, arrayListIqvvlnh3.size() - 1), 3));
                        return;
                    }
                }
                if ("uninstall".equals(lowerCase4)) {
                    if (arrayListIqvvlnh3.size() < 2) {
                        mainActivity.fusjbbl("Usage: adb uninstall [options] <package>");
                        return;
                    }
                    mainActivity.otaqyat("pm uninstall " + zamkzqg.gjpruie(arrayListIqvvlnh3, 1, arrayListIqvvlnh3.size()));
                    return;
                }
                if ("logcat".equals(lowerCase4)) {
                    ArrayList arrayList2 = new ArrayList(arrayListIqvvlnh3.subList(1, arrayListIqvvlnh3.size()));
                    StringBuilder sb6 = new StringBuilder("logcat");
                    sb6.append(arrayList2.isEmpty() ? "" : " " + zamkzqg.gjpruie(arrayList2, 0, arrayList2.size()));
                    mainActivity.otaqyat(sb6.toString());
                    return;
                }
                if ("bugreport".equals(lowerCase4)) {
                    if (arrayListIqvvlnh3.size() > 2) {
                        mainActivity.fusjbbl("Usage: adb bugreport [local.zip]");
                        return;
                    }
                    File filePwjmwpv5 = arrayListIqvvlnh3.size() == 2 ? mainActivity.pwjmwpv((String) arrayListIqvvlnh3.get(1)) : new File(mainActivity.gzvolsx, "bugreport-" + System.currentTimeMillis() + ".zip");
                    if (filePwjmwpv5.isDirectory()) {
                        filePwjmwpv5 = new File(filePwjmwpv5, "bugreport-" + System.currentTimeMillis() + ".zip");
                    }
                    mainActivity.snilumr("bugreport", new zwaqeaz(mainActivity, filePwjmwpv5, 0));
                    return;
                }
                if ("remount".equals(lowerCase4)) {
                    mainActivity.lataqgm("remount:", "remount");
                    return;
                }
                if ("disable-verity".equals(lowerCase4)) {
                    mainActivity.lataqgm("disable-verity:", "disable-verity");
                    return;
                }
                if ("enable-verity".equals(lowerCase4)) {
                    mainActivity.lataqgm("enable-verity:", "enable-verity");
                    return;
                }
                if ("root".equals(lowerCase4)) {
                    mainActivity.lataqgm("root:", "root");
                    return;
                }
                if ("unroot".equals(lowerCase4)) {
                    mainActivity.lataqgm("unroot:", "unroot");
                    return;
                }
                if ("usb".equals(lowerCase4)) {
                    mainActivity.lataqgm("usb:", "usb");
                    return;
                }
                if ("tcpip".equals(lowerCase4)) {
                    if (arrayListIqvvlnh3.size() != 2) {
                        mainActivity.fusjbbl("Usage: adb tcpip <port>");
                        return;
                    }
                    try {
                        int i2 = Integer.parseInt((String) arrayListIqvvlnh3.get(1));
                        if (i2 < 1 || i2 > 65535) {
                            mainActivity.fusjbbl("ERROR: TCP port must be 1..65535");
                            return;
                        }
                        mainActivity.lataqgm("tcpip:" + i2, "tcpip " + i2);
                        return;
                    } catch (NumberFormatException unused) {
                        mainActivity.fusjbbl("ERROR: invalid TCP port");
                        return;
                    }
                }
                if ("reboot".equals(lowerCase4) || "reboot-bootloader".equals(lowerCase4) || "reboot-fastboot".equals(lowerCase4)) {
                    if ("reboot-bootloader".equals(lowerCase4)) {
                        lowerCase = "bootloader";
                    } else if ("reboot-fastboot".equals(lowerCase4)) {
                        lowerCase = "fastboot";
                    } else {
                        lowerCase = arrayListIqvvlnh3.size() >= 2 ? ((String) arrayListIqvvlnh3.get(1)).toLowerCase(locale) : "system";
                    }
                    if ("system".equals(lowerCase) || "bootloader".equals(lowerCase) || "recovery".equals(lowerCase) || "fastboot".equals(lowerCase) || "sideload".equals(lowerCase) || "sideload-auto-reboot".equals(lowerCase)) {
                        mainActivity.seujokk(lowerCase);
                        return;
                    } else {
                        mainActivity.fusjbbl("Usage: adb reboot [bootloader|recovery|fastboot|sideload|sideload-auto-reboot]");
                        return;
                    }
                }
                if (!"sideload".equals(lowerCase4)) {
                    if ("forward".equals(lowerCase4) || "reverse".equals(lowerCase4)) {
                        mainActivity.fusjbbl("Port forwarding is an adb-server feature. This APK is a direct USB host and does not expose a desktop adb server/socket bridge.");
                        return;
                    } else {
                        mainActivity.fusjbbl("Unsupported ADB command in the direct USB backend.\nUse 'adb help' for supported commands.");
                        return;
                    }
                }
                if (arrayListIqvvlnh3.size() != 2) {
                    mainActivity.fusjbbl("Usage: adb sideload <ota.zip>");
                    return;
                }
                File filePwjmwpv6 = mainActivity.pwjmwpv((String) arrayListIqvvlnh3.get(1));
                mainActivity.pzkwhtn("ADB sideload", "Send OTA package to recovery?\n\n" + filePwjmwpv6.getAbsolutePath(), new atntgcp(mainActivity, filePwjmwpv6, 0));
            } catch (IllegalArgumentException e2) {
                mainActivity.fusjbbl("ERROR: " + e2.getMessage());
            }
        } catch (IllegalArgumentException e3) {
            mainActivity.fusjbbl("ERROR: " + e3.getMessage());
        }
    }
}
