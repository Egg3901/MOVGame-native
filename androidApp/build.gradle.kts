plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

// Phase 0 stub: a "Hello Margin of Victory" screen proving the app boots with
// the shared KMP module on its classpath. Real screens (Setup/Game/Results/
// Store/Account) are Phase 3 issues, not this module.
android {
    namespace = "com.lakesidegames.electioneer"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.lakesidegames.electioneer"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.compileSdk.get().toInt()
        versionCode = 1
        versionName = "0.1.0"
        // Play Console public key for receipt verification (Phase 5, #8).
        // Empty until Monetization setup exists; verification fails closed.
        buildConfigField("String", "PLAY_PUBLIC_KEY", "\"\"")
        // Sentry DSN for crash reporting (Phase 6, #24). Empty = disabled.
        // Set via -PPROP or CI secret at release time; never commit a DSN.
        buildConfigField("String", "SENTRY_DSN", "\"\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.icons.core)
    implementation(libs.play.billing)
    // Crash reporting (#24): inert until SENTRY_DSN is set at build time.
    implementation(libs.sentry.android)
}
