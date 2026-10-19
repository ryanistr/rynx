#!/usr/bin/env bash
# Build an installable debug APK with the SDK tools alone — no Gradle needed.
#
#   tools/build-apk.sh [output-dir]
#
# The native libraries are taken from app/src/main/jniLibs/arm64-v8a, so run
# native/build.sh first if you changed anything under native/.
set -euo pipefail

ROOT=$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)
OUT=${1:-$ROOT/build-apk}
SDK=${ANDROID_HOME:-${ANDROID_SDK_ROOT:-$HOME/Android/Sdk}}
KS=${RYNX_KEYSTORE:-$HOME/.android/debug.keystore}
PKG=com.rynx.app

[ -d "$SDK" ] || { echo "no Android SDK at $SDK (set ANDROID_HOME)" >&2; exit 1; }
BT=$(command ls -d "$SDK"/build-tools/* | sort -V | tail -1)
PLATFORM=$(command ls -d "$SDK"/platforms/android-* | sort -V | tail -1)
JAR=$PLATFORM/android.jar
PATH=$BT:$PATH

mkdir -p "$OUT"

# aapt2 needs a package attribute, which the Gradle build injects from `namespace`.
python3 - "$ROOT/app/src/main/AndroidManifest.xml" "$OUT/AndroidManifest.xml" "$PKG" <<'PY'
import re, sys
src, dst, pkg = sys.argv[1], sys.argv[2], sys.argv[3]
xml = open(src, encoding='utf-8').read()
xml = re.sub(r'(<manifest\b[^>]*?)(\s*>)', r'\1 package="%s"\2' % pkg, xml, count=1)
xml = re.sub(r'(<manifest\b[^>]*?>)',
             r'\1\n\n    <uses-sdk android:minSdkVersion="26" android:targetSdkVersion="35" />', xml, count=1)
open(dst, 'w', encoding='utf-8').write(xml)
PY

rm -rf "$OUT/gen" "$OUT/classes" "$OUT/dex" "$OUT/stage"
mkdir -p "$OUT/gen" "$OUT/classes" "$OUT/dex" "$OUT/stage"

aapt2 compile --dir "$ROOT/app/src/main/res" -o "$OUT/res.zip"
aapt2 link -o "$OUT/base.apk" --manifest "$OUT/AndroidManifest.xml" -R "$OUT/res.zip" \
      --java "$OUT/gen" -I "$JAR" --auto-add-overlay

# Gradle generates this from buildConfig = true; keep the values in step with the module.
python3 - "$ROOT/app/build.gradle.kts" "$OUT/gen/$PKG/BuildConfig.java" "$PKG" <<'PY'
import re, sys, os
gradle, dst, pkg = sys.argv[1], sys.argv[2], sys.argv[3]
text = open(gradle, encoding='utf-8').read()
name = re.search(r'versionName\s*=\s*"([^"]+)"', text).group(1)
code = re.search(r'versionCode\s*=\s*(\d+)', text).group(1)
os.makedirs(os.path.dirname(dst), exist_ok=True)
open(dst, 'w', encoding='utf-8').write(f'''package {pkg};

public final class BuildConfig {{
    public static final boolean DEBUG = true;
    public static final String APPLICATION_ID = "{pkg}";
    public static final String BUILD_TYPE = "debug";
    public static final String VERSION_NAME = "{name}";
    public static final int VERSION_CODE = {code};
}}
''')
PY

shopt -s globstar nullglob
srcs=("$ROOT"/app/src/main/java/**/*.java "$OUT"/gen/**/*.java)
printf '%s\n' "${srcs[@]}" > "$OUT/srcs.txt"
javac -encoding UTF-8 -nowarn -source 8 -target 8 -bootclasspath "$JAR" -d "$OUT/classes" @"$OUT/srcs.txt"

jar cf "$OUT/classes.jar" -C "$OUT/classes" .
d8 --lib "$JAR" --min-api 26 --output "$OUT/dex" "$OUT/classes.jar"

cp "$OUT/dex/classes.dex" "$OUT/stage/"
if [ -d "$ROOT/app/src/main/jniLibs/arm64-v8a" ]; then
    mkdir -p "$OUT/stage/lib/arm64-v8a"
    cp "$ROOT"/app/src/main/jniLibs/arm64-v8a/*.so "$OUT/stage/lib/arm64-v8a/"
else
    echo "warning: no jniLibs/arm64-v8a — run native/build.sh first" >&2
fi

cp "$OUT/base.apk" "$OUT/unsigned.apk"
( cd "$OUT/stage" && zip -q -r "$OUT/unsigned.apk" . )
zipalign -f -p 4 "$OUT/unsigned.apk" "$OUT/aligned.apk"
apksigner sign --ks "$KS" --ks-pass pass:android --key-pass pass:android \
          --out "$OUT/rynx-debug.apk" "$OUT/aligned.apk"
apksigner verify --print-certs "$OUT/rynx-debug.apk" | head -2
echo "apk: $OUT/rynx-debug.apk"
