plugins {
    id("com.android.application")
}

android {
    namespace = "com.rynx.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.rynx.app"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0"
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    // Android framework only - no third-party runtime dependencies.
}
