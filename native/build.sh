#!/usr/bin/env bash
# Cross-compile the native core for arm64-v8a and install it into the app module.
#
#   native/build.sh            # release build + install into app/src/main/jniLibs
#   native/build.sh check      # compile-check only, no install
#
# Override the NDK with ANDROID_NDK_HOME, or the API level with API_LEVEL.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$here"
cmd="${1:-build}"
shift || true

target="aarch64-linux-android"
# The engine's transitive dependencies use unstable features, so the core builds on nightly.
toolchain="${RUST_TOOLCHAIN:-nightly}"
api="${API_LEVEL:-26}"
ndk="${ANDROID_NDK_HOME:-/opt/android-sdk/ndk/27.3.13750724}"
ndk_toolchain="$ndk/toolchains/llvm/prebuilt/linux-x86_64"
bin="$ndk_toolchain/bin"
clang="$bin/${target}${api}-clang"

if [ ! -x "$clang" ]; then
    echo "build.sh: no clang for API $api at $clang" >&2
    echo "build.sh: set ANDROID_NDK_HOME to an installed NDK" >&2
    exit 1
fi

export CARGO_TARGET_AARCH64_LINUX_ANDROID_LINKER="$clang"
export CC_aarch64_linux_android="$clang"
export CXX_aarch64_linux_android="${target}${api}-clang++"
export AR_aarch64_linux_android="$bin/llvm-ar"
export RANLIB_aarch64_linux_android="$bin/llvm-ranlib"
export BINDGEN_EXTRA_CLANG_ARGS="--sysroot=$ndk_toolchain/sysroot"
export CFLAGS_aarch64_linux_android="--sysroot=$ndk_toolchain/sysroot -D__ANDROID_API__=$api"

profile="release"
args=(--profile "$profile" --target "$target")
if [ "$cmd" = "dev" ]; then
    cmd="build"
    profile="dev"
    args=(--profile "$profile" --target "$target")
fi

cargo "+$toolchain" "$cmd" "${args[@]}" "$@"

if [ "$cmd" != "build" ]; then
    exit 0
fi

out="$here/../app/src/main/jniLibs/arm64-v8a"
mkdir -p "$out"
for lib in rynx_core rynx_adbfastboot; do
    src="$here/target/$target/$profile/lib$lib.so"
    if [ ! -f "$src" ]; then
        echo "build.sh: expected $src" >&2
        exit 1
    fi
    install -m 644 "$src" "$out/lib$lib.so"
done

echo "installed into $out:"
fd -t f '\.so$' "$out"
