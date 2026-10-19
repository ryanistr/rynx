package x;

import com.rynx.app.BuildConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class iivesaq {
    public static final Pattern nmpwovh = Pattern.compile("(?m)^\\s*RYNX_VERSION_CODE\\s*=\\s*(\\d+)\\s*$");
    public static final Pattern ojyssqt = Pattern.compile("(?m)^\\s*RYNX_VERSION_NAME\\s*=\\s*(.+?)\\s*$");

    public static ziuhthw nmpwovh() throws ProtocolException, IOException, JSONException {
        String strOptString;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.github.com/repos/ryanistr/rynx/releases/latest").openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(7000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setRequestProperty("Accept", "application/vnd.github+json");
        httpURLConnection.setRequestProperty("X-GitHub-Api-Version", "2022-11-28");
        httpURLConnection.setRequestProperty("User-Agent", "Rynx-Android/" + BuildConfig.VERSION_NAME);
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                throw new IllegalStateException("GitHub HTTP " + responseCode);
            }
            JSONObject jSONObject = new JSONObject(ojyssqt(httpURLConnection.getInputStream()));
            String strOptString2 = jSONObject.optString("body", "");
            Matcher matcher = nmpwovh.matcher(strOptString2);
            Matcher matcher2 = ojyssqt.matcher(strOptString2);
            if (!matcher.find() || !matcher2.find()) {
                throw new IllegalStateException("Release metadata missing");
            }
            long j = Long.parseLong(matcher.group(1));
            String strTrim = matcher2.group(1).trim();
            if (strTrim.isEmpty()) {
                throw new IllegalStateException("Empty version name");
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("assets");
            if (jSONArrayOptJSONArray == null) {
                strOptString = null;
            } else {
            int i = 0;
            while (true) {
                if (i >= jSONArrayOptJSONArray.length()) {
                    strOptString = null;
                    break;
                }
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString3 = jSONObjectOptJSONObject.optString("name", "");
                    strOptString = jSONObjectOptJSONObject.optString("browser_download_url", "");
                    if (strOptString3.toLowerCase(Locale.ROOT).endsWith(".apk") && !strOptString.isEmpty()) {
                        break;
                    }
                }
                i++;
            }
            }
            ziuhthw ziuhthwVar = new ziuhthw(j, strTrim, strOptString2.replaceAll("(?m)^\\s*RYNX_VERSION_CODE\\s*=.*(?:\\R|$)", "").replaceAll("(?m)^\\s*RYNX_VERSION_NAME\\s*=.*(?:\\R|$)", "").trim(), strOptString != null ? strOptString : jSONObject.optString("html_url", ""));
            httpURLConnection.disconnect();
            return ziuhthwVar;
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }

    public static String ojyssqt(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return sb.toString();
                }
                sb.append(line);
                sb.append('\n');
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }
}
