package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class zsbaukl {
    static {
        oqexvyb("device", "devicemodel", "entry", "item", "model", "name", "phone", "product", "row");
        oqexvyb("id", "key", "model", "modelid", "modelkey", "models", "value");
        oqexvyb("devices", "display", "displayname", "devicename", "label", "name", "title");
        oqexvyb("code", "codename", "devicecode", "models", "product", "productname");
        oqexvyb("brand", "manufacturer", "vendor");
        oqexvyb("chip", "chipset", "cpu", "platform", "protocol", "soc", "technology");
        oqexvyb("auth", "category", "method", "service", "type", "version");
        oqexvyb("bundle", "file", "filename", "firehose", "firehosefile", "loader", "loaderfile", "loaderpath", "path", "url");
        oqexvyb("conn", "connection", "connectionmode");
        oqexvyb("boot", "bootmode", "brom", "broom");
        oqexvyb("edl", "edlmode");
        oqexvyb("memory", "memorytype", "storage", "storagetype");
        oqexvyb("patch", "patchmode");
    }

    public static List lthborb(String str, xhyvkax xhyvkaxVar) throws zyxfuka {
        JSONArray jSONArray;
        String strConcat;
        try {
            JSONObject jSONObject = new JSONObject();
            zamkzqg.zzqmpyp(jSONObject, "action", "xiaomi_catalog");
            JSONArray jSONArrayOptJSONArray = zamkzqg.jofyvuh(str, xhyvkaxVar, jSONObject).optJSONArray("models");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                throw new zyxfuka("No active Xiaomi model catalog is available on the server.");
            }
            if (jSONArrayOptJSONArray.length() > 5000) {
                throw new zyxfuka("The Xiaomi model catalog contains too many entries.");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            while (i < jSONArrayOptJSONArray.length()) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject == null) {
                    jSONArray = jSONArrayOptJSONArray;
                } else {
                    String strQxvquar = qxvquar(jSONObjectOptJSONObject, "catalog_id", qxvquar(jSONObjectOptJSONObject, "id", qxvquar(jSONObjectOptJSONObject, "model", "")));
                    String strQxvquar2 = qxvquar(jSONObjectOptJSONObject, "display_name", qxvquar(jSONObjectOptJSONObject, "name", strQxvquar));
                    String strQxvquar3 = qxvquar(jSONObjectOptJSONObject, "codename", qxvquar(jSONObjectOptJSONObject, "model", strQxvquar));
                    String strQxvquar4 = qxvquar(jSONObjectOptJSONObject, "brand", "Xiaomi");
                    String strQxvquar5 = qxvquar(jSONObjectOptJSONObject, "platform", qxvquar(jSONObjectOptJSONObject, "chipset", ""));
                    String strQxvquar6 = qxvquar(jSONObjectOptJSONObject, "service", "xiaomi_auth");
                    String strQxvquar7 = qxvquar(jSONObjectOptJSONObject, "connection_mode", "");
                    String strQxvquar8 = qxvquar(jSONObjectOptJSONObject, "boot_mode", "BROM");
                    String strQxvquar9 = qxvquar(jSONObjectOptJSONObject, "edl_mode", "");
                    String strQxvquar10 = qxvquar(jSONObjectOptJSONObject, "memory_type", "");
                    String strQxvquar11 = qxvquar(jSONObjectOptJSONObject, "patch_mode", "AUTH");
                    jSONArray = jSONArrayOptJSONArray;
                    if (!jSONObjectOptJSONObject.optBoolean("requires_auth", true) || vivhedu(strQxvquar11)) {
                        strConcat = strQxvquar11;
                    } else {
                        strConcat = strQxvquar11.isEmpty() ? "AUTH" : strQxvquar11.concat(" | AUTH");
                    }
                    zwccvwt zwccvwtVar = new zwccvwt(strQxvquar, strQxvquar2, strQxvquar3, strQxvquar4, strQxvquar5, strQxvquar6, strQxvquar7, strQxvquar8, strQxvquar9, strQxvquar10, strConcat, qxvquar(jSONObjectOptJSONObject, "mode", ""), qxvquar(jSONObjectOptJSONObject, "chipset", strQxvquar5));
                    if (!zwccvwtVar.ojyssqt.isEmpty() && !zwccvwtVar.nmpwovh.isEmpty()) {
                        linkedHashMap.putIfAbsent(zwccvwtVar.ojyssqt(), zwccvwtVar);
                    }
                }
                i++;
                jSONArrayOptJSONArray = jSONArray;
            }
            if (linkedHashMap.isEmpty()) {
                throw new zyxfuka("No supported device records were returned by the Xiaomi server.");
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.values());
            Collections.sort(arrayList, new guecdgy(1));
            return Collections.unmodifiableList(arrayList);
        } catch (Exception e) {
            throw new zyxfuka(e.getMessage(), e);
        }
    }

    public static String nmpwovh(String str) {
        String strOjyssqt = ojyssqt(str);
        return (strOjyssqt.length() > 2 && strOjyssqt.charAt(0) == '[' && strOjyssqt.charAt(strOjyssqt.length() - 1) == ']') ? ojyssqt(strOjyssqt.substring(1, strOjyssqt.length() - 1)) : strOjyssqt;
    }

    public static String ojyssqt(String str) {
        if (str == null) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(strTrim.length());
        boolean z = false;
        for (int i = 0; i < strTrim.length(); i++) {
            char cCharAt = strTrim.charAt(i);
            if (Character.isWhitespace(cCharAt)) {
                z = true;
            } else {
                if (z && sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(cCharAt);
                z = false;
            }
        }
        return sb.toString();
    }

    public static void oqexvyb(String... strArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Collections.addAll(linkedHashSet, strArr);
        Collections.unmodifiableSet(linkedHashSet);
    }

    public static String qxvquar(JSONObject jSONObject, String str, String str2) {
        Object objOpt = jSONObject.opt(str);
        if (objOpt == null || objOpt == JSONObject.NULL) {
            return str2;
        }
        String strOjyssqt = ojyssqt(String.valueOf(objOpt));
        return strOjyssqt.isEmpty() ? str2 : strOjyssqt;
    }

    public static boolean vivhedu(String str) {
        StringBuilder sb = new StringBuilder(" ");
        String strOjyssqt = ojyssqt(str);
        Locale locale = Locale.ROOT;
        sb.append(strOjyssqt.toLowerCase(locale).replaceAll("[^a-z0-9]+", " "));
        sb.append(" ");
        return sb.toString().contains(" " + "auth".toLowerCase(locale) + " ");
    }
}
