package x;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes.dex */
public abstract class pwjmwpv {
    public static final BigInteger nmpwovh;

    static {
        BigInteger bigInteger = BigInteger.ONE;
        nmpwovh = bigInteger.shiftLeft(64).subtract(bigInteger);
    }

    /* JADX WARN: Code duplicated, block: B:157:0x0165 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0157 A[SYNTHETIC] */
    public static lcgzsis buswjhz(File file, String str, boolean z) throws IOException {
        long j;
        boolean zEquals = false;
        ArrayList arrayList = new ArrayList();
        String strDasxvpc = dasxvpc(str);
        FileInputStream fileInputStream = new FileInputStream(file);
        CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction)));
        String str2 = "";
        boolean z2 = true;
        String str3 = "";
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        ezuzoct ezuzoctVar = null;
        int i = 0;
        long jUtmeivs = 0;
        int i2 = 0;
        long length = 0;
        boolean z3 = false;
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    long j2 = jUtmeivs;
                    bufferedReader.close();
                    if (ezuzoctVar != null) {
                        arrayList.add(ezuzoctVar.nmpwovh(50000));
                    }
                    if (arrayList.size() > 1024) {
                        throw new IOException("Scatter contains too many partitions");
                    }
                    if (file.length() > 4194304) {
                        throw new IOException("Scatter file changed while it was being parsed");
                    }
                    if (i > 0) {
                        if (!strDasxvpc.isEmpty() && !z3) {
                            throw new IOException("Scatter text has no " + strDasxvpc + " storage section");
                        }
                        if (strDasxvpc.isEmpty() && !z && i > 1) {
                            throw new IOException("Scatter text contains multiple storage sections; device storage is required");
                        }
                    }
                    jdqigmr(str4, str6, arrayList);
                    return new lcgzsis(file.getCanonicalFile(), str3, str4, str5, str6, j2, arrayList);
                }
                int i3 = i2 + 1;
                length = ((long) line.length()) + 1 + length;
                if (length > 4194304) {
                    throw ulafhci(i3, "decoded content is too large");
                }
                i2 = i3;
                if (i2 > 50000) {
                    throw ulafhci(i2, "too many lines");
                }
                if (line.length() > 32768) {
                    throw ulafhci(i2, "line is too long");
                }
                String strTrim = line.trim();
                if (i2 == 1 && strTrim.startsWith("\ufeff")) {
                    strTrim = strTrim.substring(1).trim();
                }
                if (!strTrim.isEmpty() && !strTrim.startsWith("#")) {
                    if (strTrim.startsWith("-")) {
                        strTrim = strTrim.substring(1).trim();
                    }
                    int iIndexOf = strTrim.indexOf(58);
                    if (iIndexOf > 0) {
                        str2 = str2;
                        String lowerCase = strTrim.substring(0, iIndexOf).trim().toLowerCase(Locale.ROOT);
                        String strTrim2 = strTrim.substring(iIndexOf + 1).trim();
                        if (strTrim2 == null || strTrim2.length() < 2) {
                            j = jUtmeivs;
                            if (strTrim2 == null) {
                                strTrim2 = str2;
                            }
                        } else {
                            char cCharAt = strTrim2.charAt(0);
                            char cCharAt2 = strTrim2.charAt(strTrim2.length() - 1);
                            j = jUtmeivs;
                            if ((cCharAt == '\"' && cCharAt2 == '\"') || (cCharAt == '\'' && cCharAt2 == '\'')) {
                                strTrim2 = strTrim2.substring(1, strTrim2.length() - 1).trim();
                            }
                        }
                        if ("storage_type".equals(lowerCase)) {
                            if (ezuzoctVar != null) {
                                arrayList.add(ezuzoctVar.nmpwovh(i2));
                                if (arrayList.size() > 1024) {
                                    throw ulafhci(i2, "too many partitions");
                                }
                                ezuzoctVar = null;
                            }
                            i++;
                            String strDasxvpc2 = dasxvpc(strTrim2);
                            if (strDasxvpc2.isEmpty()) {
                                throw ulafhci(i2, "storage_type is missing");
                            }
                            if (strDasxvpc.isEmpty()) {
                                if (z) {
                                    zEquals = !z3;
                                } else {
                                    z2 = i == 1;
                                }
                                if (z2) {
                                    jUtmeivs = 0;
                                    z3 = true;
                                    str6 = strDasxvpc2;
                                } else {
                                    i2 = i2;
                                    str2 = str2;
                                    jUtmeivs = j;
                                }
                            } else {
                                zEquals = strDasxvpc.equals(strDasxvpc2);
                            }
                            z2 = zEquals;
                            if (z2) {
                                jUtmeivs = 0;
                                z3 = true;
                                str6 = strDasxvpc2;
                            } else {
                                i2 = i2;
                                str2 = str2;
                                jUtmeivs = j;
                            }
                        } else {
                            if ("partition_index".equals(lowerCase)) {
                                if (ezuzoctVar != null) {
                                    arrayList.add(ezuzoctVar.nmpwovh(i2));
                                    if (arrayList.size() > 1024) {
                                        throw ulafhci(i2, "too many partitions");
                                    }
                                }
                                ezuzoctVar = z2 ? new ezuzoct(i2, strTrim2) : null;
                            } else if (i <= 0 || z2) {
                                if (ezuzoctVar == null) {
                                    if ("config_version".equals(lowerCase)) {
                                        str3 = strTrim2;
                                    } else if ("platform".equals(lowerCase)) {
                                        str4 = strTrim2;
                                    } else if ("project".equals(lowerCase)) {
                                        str5 = strTrim2;
                                    } else if ("storage".equals(lowerCase)) {
                                        str6 = strTrim2;
                                    } else if (!"boot_channel".equals(lowerCase) && "block_size".equals(lowerCase)) {
                                        jUtmeivs = utmeivs(i2, strTrim2, lowerCase);
                                        i2 = i2;
                                        str2 = str2;
                                    }
                                    jUtmeivs = j;
                                } else {
                                    ezuzoctVar.ojyssqt(i2, lowerCase, strTrim2);
                                }
                            }
                            i2 = i2;
                            str2 = str2;
                            jUtmeivs = j;
                        }
                    }
                }
                str2 = str2;
                j = jUtmeivs;
                i2 = i2;
                str2 = str2;
                jUtmeivs = j;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
    }

    public static String dasxvpc(String str) {
        String strDplrlfq = dplrlfq(str);
        if (strDplrlfq.contains("UFS")) {
            return "UFS";
        }
        return (strDplrlfq.contains("EMMC") || strDplrlfq.contains("SDMMC")) ? "EMMC" : strDplrlfq;
    }

    public static String dplrlfq(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String upperCase = str.toUpperCase(Locale.ROOT);
        for (int i = 0; i < upperCase.length(); i++) {
            char cCharAt = upperCase.charAt(i);
            if (Character.isLetterOrDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static boolean dytyqos(File file) throws IOException {
        byte[] bArr = new byte[512];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int i = fileInputStream.read(bArr);
            fileInputStream.close();
            if (i <= 0) {
                return false;
            }
            for (int i2 = (i >= 3 && (bArr[0] & 255) == 239 && (bArr[1] & 255) == 187 && (bArr[2] & 255) == 191) ? 3 : 0; i2 < i; i2++) {
                int i3 = bArr[i2] & 255;
                if (i3 != 32 && i3 != 9 && i3 != 13 && i3 != 10) {
                    return i3 == 60;
                }
            }
            return false;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long ekyqleu(int i, String str, String str2) throws IOException {
        int i2;
        String strReplace = str != null ? str.trim().replace("_", "") : "";
        if (strReplace.startsWith("0x") || strReplace.startsWith("0X")) {
            strReplace = strReplace.substring(2);
            i2 = 16;
        } else {
            i2 = 10;
        }
        if (strReplace.isEmpty() || strReplace.startsWith("-") || strReplace.startsWith("+")) {
            throw ulafhci(i, "invalid " + str2 + " number");
        }
        try {
            BigInteger bigInteger = new BigInteger(strReplace, i2);
            if (bigInteger.signum() >= 0 && bigInteger.compareTo(nmpwovh) <= 0) {
                return bigInteger.longValue();
            }
            throw ulafhci(i, str2 + " is out of range");
        } catch (NumberFormatException unused) {
            throw ulafhci(i, "invalid " + str2 + " number");
        }
    }

    public static Element imuemzb(Element element, String str) {
        ArrayList arrayListOqexvyb = oqexvyb(element, str);
        if (arrayListOqexvyb.isEmpty()) {
            return null;
        }
        return (Element) arrayListOqexvyb.get(0);
    }

    public static void jdqigmr(String str, String str2, ArrayList arrayList) throws IOException {
        if (str == null || str.trim().isEmpty()) {
            throw new IOException("Scatter general.platform is missing");
        }
        if (str2 == null || str2.trim().isEmpty()) {
            throw new IOException("Scatter general.storage is missing");
        }
        if (arrayList.isEmpty()) {
            throw new IOException("Scatter contains no partition entries");
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aqyicql aqyicqlVar = (aqyicql) it.next();
            String str3 = aqyicqlVar.ojyssqt;
            Locale locale = Locale.ROOT;
            String lowerCase = str3.toLowerCase(locale);
            String str4 = aqyicqlVar.nmpwovh;
            String lowerCase2 = str4.toLowerCase(locale);
            if (!hashSet.add(lowerCase)) {
                throw new IOException("Duplicate scatter partition: " + aqyicqlVar.ojyssqt);
            }
            if (!hashSet2.add(lowerCase2)) {
                throw new IOException("Duplicate scatter partition index: ".concat(str4));
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            aqyicql aqyicqlVar2 = (aqyicql) arrayList.get(i);
            if (qyeibyo(aqyicqlVar2)) {
                long jVivhedu = vivhedu(aqyicqlVar2);
                for (int i2 = i + 1; i2 < arrayList.size(); i2++) {
                    aqyicql aqyicqlVar3 = (aqyicql) arrayList.get(i2);
                    if (qyeibyo(aqyicqlVar3)) {
                        String str5 = aqyicqlVar2.nkemejx;
                        if (wqrnifx(str5).equals(wqrnifx(aqyicqlVar3.nkemejx))) {
                            if (aqyicqlVar2.qxvquar < vivhedu(aqyicqlVar3) && aqyicqlVar3.qxvquar < jVivhedu) {
                                throw new IOException("Scatter partitions overlap in " + str5 + ": " + aqyicqlVar2.ojyssqt + " / " + aqyicqlVar3.ojyssqt);
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    public static void lclupha(File file) throws IOException {
        if (file == null || !file.isFile() || !file.canRead()) {
            throw new IOException("Scatter file is missing or unreadable");
        }
        if (file.length() <= 0 || file.length() > 4194304) {
            throw new IOException("Scatter file size is invalid");
        }
    }

    public static String lthborb(String str) {
        return str == null ? "" : str.trim();
    }

    public static Element nkemejx(Element element, String str) {
        for (Element element2 : (ArrayList<Element>) oqexvyb(element, "general")) {
            if (str.equalsIgnoreCase(lthborb(element2.getAttribute("name")))) {
                return element2;
            }
        }
        return null;
    }

    public static boolean nmpwovh(int i, String str, String str2) throws IOException {
        String lowerCase = str == null ? "" : str.trim().toLowerCase(Locale.ROOT);
        if ("true".equals(lowerCase) || "yes".equals(lowerCase) || "1".equals(lowerCase)) {
            return true;
        }
        if ("false".equals(lowerCase) || "no".equals(lowerCase) || "0".equals(lowerCase)) {
            return false;
        }
        throw ulafhci(i, "invalid " + str2 + " boolean");
    }

    public static boolean ojyssqt(String str) {
        if (str == null || str.isEmpty() || str.length() > 128) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_' && cCharAt != '-' && cCharAt != '.' && cCharAt != '+') {
                return false;
            }
        }
        return true;
    }

    public static ArrayList oqexvyb(Element element, String str) {
        ArrayList arrayList = new ArrayList();
        if (element == null) {
            return arrayList;
        }
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem instanceof Element) {
                Element element2 = (Element) nodeItem;
                if (str == null || str.equalsIgnoreCase(element2.getTagName())) {
                    arrayList.add(element2);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0220  */
    /* JADX WARN: Code duplicated, block: B:102:0x0228  */
    /* JADX WARN: Code duplicated, block: B:67:0x0146  */
    /* JADX WARN: Code duplicated, block: B:68:0x014e  */
    /* JADX WARN: Instruction removed from duplicated block: B:102:0x0228, please report this as an issue */
    public static lcgzsis pvbzgon(File file, String str, boolean z) throws IOException {
        Element element;
        Exception eAlias = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) Math.min(file.length(), 4194304L));
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[16384];
            long j = 0;
            while (true) {
                int i = fileInputStream.read(bArr);
                int i2 = 0;
                if (i == -1) {
                    fileInputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
                        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
                        String string = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(byteArray)).toString();
                        if (string.indexOf(0) >= 0) {
                            throw new IOException("Scatter XML must use UTF-8 encoding");
                        }
                        String upperCase = string.toUpperCase(Locale.ROOT);
                        if (upperCase.contains("<!DOCTYPE") || upperCase.contains("<!ENTITY")) {
                            throw new IOException("Scatter XML declarations and entities are not allowed");
                        }
                        try {
                            try {
                                DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
                                documentBuilderFactoryNewInstance.setNamespaceAware(false);
                                documentBuilderFactoryNewInstance.setValidating(false);
                                documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
                                try {
                                    documentBuilderFactoryNewInstance.setXIncludeAware(false);
                                } catch (UnsupportedOperationException unused) {
                                }
                                try {
                                    documentBuilderFactoryNewInstance.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
                                } catch (ParserConfigurationException unused2) {
                                }
                                try {
                                    documentBuilderFactoryNewInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
                                } catch (ParserConfigurationException unused3) {
                                }
                                try {
                                    documentBuilderFactoryNewInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
                                } catch (ParserConfigurationException unused4) {
                                }
                                try {
                                    documentBuilderFactoryNewInstance.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
                                } catch (ParserConfigurationException unused5) {
                                }
                                try {
                                    documentBuilderFactoryNewInstance.setAttribute("http://javax.xml.XMLConstants/property/accessExternalDTD", "");
                                } catch (IllegalArgumentException unused6) {
                                }
                                try {
                                    documentBuilderFactoryNewInstance.setAttribute("http://javax.xml.XMLConstants/property/accessExternalSchema", "");
                                } catch (IllegalArgumentException unused7) {
                                }
                                DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactoryNewInstance.newDocumentBuilder();
                                documentBuilderNewDocumentBuilder.setErrorHandler(new mccfjlr());
                                Element documentElement = documentBuilderNewDocumentBuilder.parse(new ByteArrayInputStream(byteArray)).getDocumentElement();
                                if (documentElement == null || !"root".equalsIgnoreCase(documentElement.getTagName())) {
                                    throw new IOException("Scatter XML root element must be <root>");
                                }
                                Element elementNkemejx = nkemejx(documentElement, "MTK_PLATFORM_CFG");
                                Element elementImuemzb = elementNkemejx == null ? null : imuemzb(elementNkemejx, "config_version");
                                String strLthborb = elementImuemzb != null ? lthborb(elementImuemzb.getAttribute("name")) : "";
                                String strQxvquar = qxvquar(elementImuemzb, "platform");
                                String strQxvquar2 = qxvquar(elementImuemzb, "project");
                                ArrayList arrayListOqexvyb = oqexvyb(documentElement, "storage_type");
                                if (arrayListOqexvyb.isEmpty()) {
                                    throw new IOException("Scatter XML has no storage_type section");
                                }
                                String strDasxvpc = dasxvpc(str);
                                if (!strDasxvpc.isEmpty()) {
                                    Iterator it = arrayListOqexvyb.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            element = (Element) it.next();
                                            if (strDasxvpc.equals(dasxvpc(element.getAttribute("name")))) {
                                            }
                                        } else if (arrayListOqexvyb.size() != 1) {
                                            element = (Element) arrayListOqexvyb.get(0);
                                        } else {
                                            if (strDasxvpc.isEmpty() || !z) {
                                                if (strDasxvpc.isEmpty()) {
                                                    throw new IOException("Scatter XML contains multiple storage sections; device storage is required");
                                                }
                                                throw new IOException("Scatter XML has no " + strDasxvpc + " storage section");
                                            }
                                            element = (Element) arrayListOqexvyb.get(0);
                                        }
                                    }
                                } else {
                                    if (arrayListOqexvyb.size() != 1) {
                                        if (strDasxvpc.isEmpty()) {
                                        }
                                        if (strDasxvpc.isEmpty()) {
                                            throw new IOException("Scatter XML contains multiple storage sections; device storage is required");
                                        }
                                        throw new IOException("Scatter XML has no " + strDasxvpc + " storage section");
                                    }
                                    element = (Element) arrayListOqexvyb.get(0);
                                }
                                String strLthborb2 = lthborb(element.getAttribute("name"));
                                Element elementNkemejx2 = nkemejx(element, "MTK_STORAGE_CFG");
                                Element elementImuemzb2 = elementNkemejx2 == null ? null : imuemzb(elementNkemejx2, "storage");
                                if (strLthborb2.isEmpty() && elementImuemzb2 != null) {
                                    strLthborb2 = lthborb(elementImuemzb2.getAttribute("name"));
                                }
                                qxvquar(elementImuemzb2, "boot_channel");
                                String strQxvquar3 = qxvquar(elementImuemzb2, "block_size");
                                long jUtmeivs = strQxvquar3.isEmpty() ? 0L : utmeivs(1, strQxvquar3, "block_size");
                                ArrayList arrayListOqexvyb2 = oqexvyb(element, "partition_index");
                                if (arrayListOqexvyb2.size() > 1024) {
                                    throw new IOException("Scatter XML contains too many partitions");
                                }
                                ArrayList arrayList = new ArrayList();
                                while (i2 < arrayListOqexvyb2.size()) {
                                    Element element2 = (Element) arrayListOqexvyb2.get(i2);
                                    i2++;
                                    ezuzoct ezuzoctVar = new ezuzoct(i2, lthborb(element2.getAttribute("name")));
                                    for (Element element3 : (ArrayList<Element>) oqexvyb(element2, null)) {
                                        ezuzoctVar.ojyssqt(i2, element3.getTagName().toLowerCase(Locale.ROOT), lthborb(element3.getTextContent()));
                                    }
                                    arrayList.add(ezuzoctVar.nmpwovh(i2));
                                }
                                jdqigmr(strQxvquar, strLthborb2, arrayList);
                                return new lcgzsis(file.getCanonicalFile(), strLthborb, strQxvquar, strQxvquar2, strLthborb2, jUtmeivs, arrayList);
                            } catch (SAXException e) {
                                e = e;
                                throw new IOException("Invalid or unsafe scatter XML", e);
                            }
                        } catch (ParserConfigurationException e2) {
                            eAlias = e2;
                            throw new IOException("Invalid or unsafe scatter XML", eAlias);
                        }
                    } catch (CharacterCodingException e3) {
                        throw new IOException("Scatter XML must use valid UTF-8 encoding", e3);
                    }
                }
                if (i != 0) {
                    j += (long) i;
                    if (j > 4194304) {
                        throw new IOException("Scatter file changed while it was being parsed");
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static String qxvquar(Element element, String str) {
        Element elementImuemzb = imuemzb(element, str);
        return elementImuemzb == null ? "" : lthborb(elementImuemzb.getTextContent());
    }

    public static boolean qyeibyo(aqyicql aqyicqlVar) {
        if (!aqyicqlVar.wqrnifx) {
            String str = aqyicqlVar.dasxvpc;
            if (!"INVISIBLE".equalsIgnoreCase(str) && !"RESERVED".equalsIgnoreCase(str) && !"LOGIC".equalsIgnoreCase(str) && aqyicqlVar.qxvquar >= 0 && aqyicqlVar.oqexvyb > 0) {
                return true;
            }
        }
        return false;
    }

    public static IOException ulafhci(int i, String str) {
        return new IOException("Scatter line " + i + ": " + str);
    }

    public static long utmeivs(int i, String str, String str2) throws IOException {
        long jEkyqleu = ekyqleu(i, str, str2);
        if (jEkyqleu > 0) {
            return jEkyqleu;
        }
        throw ulafhci(i, str2 + " must be greater than zero");
    }

    public static long vivhedu(aqyicql aqyicqlVar) throws IOException {
        long j = aqyicqlVar.oqexvyb;
        long j2 = Long.MAX_VALUE - j;
        long j3 = aqyicqlVar.qxvquar;
        if (j3 <= j2) {
            return j3 + j;
        }
        throw new IOException("Scatter address range overflows: " + aqyicqlVar.ojyssqt);
    }

    public static File vntpaom(lcgzsis lcgzsisVar, aqyicql aqyicqlVar) throws IOException {
        File file;
        if (lcgzsisVar == null || (file = lcgzsisVar.nmpwovh) == null || aqyicqlVar == null) {
            throw new IOException("Scatter image context is missing");
        }
        if (!aqyicqlVar.vivhedu()) {
            throw new IOException("No image is assigned to " + aqyicqlVar.ojyssqt);
        }
        String str = aqyicqlVar.vivhedu;
        String strReplace = str.replace('\\', '/');
        if (strReplace.startsWith("/") || strReplace.startsWith("//") || strReplace.matches("^[A-Za-z]:.*") || strReplace.contains("://")) {
            throw new IOException("Absolute image path is not allowed: " + str);
        }
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            throw new IOException("Scatter folder is unavailable");
        }
        File canonicalFile = new File(parentFile, strReplace).getCanonicalFile();
        String canonicalPath = parentFile.getCanonicalPath();
        String canonicalPath2 = canonicalFile.getCanonicalPath();
        String str2 = File.separator;
        if (!canonicalPath.endsWith(str2)) {
            canonicalPath = canonicalPath + str2;
        }
        if (!canonicalPath2.startsWith(canonicalPath)) {
            throw new IOException("Image path escapes the scatter folder: " + str);
        }
        if (canonicalFile.isFile() && canonicalFile.canRead() && canonicalFile.length() > 0) {
            return canonicalFile;
        }
        throw new IOException("Image is missing or unreadable: " + str);
    }

    public static String wqrnifx(String str) {
        return dplrlfq(str).replace("LUA", "LU");
    }
}
