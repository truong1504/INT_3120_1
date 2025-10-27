plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}



android {
    namespace = "com.example.unit7_internetconnection"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.unit7_internetconnection"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.5"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {
    // BoM để đồng bộ tất cả version Compose
    implementation(platform("androidx.compose:compose-bom:2024.09.00"))

    // Các thành phần Compose
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.activity:activity-compose:1.9.3")

    // Material Design 3 (XML support)
    implementation("com.google.android.material:material:1.12.0")

    // Optional: Lifecycle, ViewModel (nếu có dùng)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
}
