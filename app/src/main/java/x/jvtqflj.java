package x;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class jvtqflj {
    public static final Pattern nmpwovh = Pattern.compile("(?i)\\b0x[0-9a-f]{4,8}\\b|\\berrno\\s*[:=]?\\s*-?\\d+\\b");
    public static final Pattern ojyssqt = Pattern.compile("(?i)(\\b(?:password|passwd|authorization|token|access[_ -]?token|refresh[_ -]?token|api[_ -]?key|secret|signature|challenge|soc[_ ]?id|meid|hrid)\\b\\s*[:=]\\s*)(?:bearer\\s+)?[^\\s,;]+");
    public static final Pattern vivhedu = Pattern.compile("(?i)(\\bbearer\\s+)\\S+");

    public static String nmpwovh(String str) {
        return vivhedu.matcher(ojyssqt.matcher(str).replaceAll("$1[REDACTED]")).replaceAll("$1[REDACTED]");
    }
}
