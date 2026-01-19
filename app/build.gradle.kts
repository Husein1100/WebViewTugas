plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.webviewtugas" // Pastikan namespace ini sesuai dengan proyek Anda
    compileSdk = 36 // Anda bisa menggunakan SDK terbaru yang stabil

    defaultConfig {
        applicationId = "com.example.webviewtugas" // Pastikan applicationId ini sesuai
        minSdk = 24 // Target minimum SDK
        targetSdk = 36 // Target SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false // Atur ke true untuk rilis produksi jika diinginkan
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Mengatur kompatibilitas Java dan target JVM untuk Kotlin
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    // Mengaktifkan fitur seperti ViewBinding jika Anda menggunakannya
    buildFeatures {
        viewBinding = true // Atau false jika tidak digunakan
        // viewBinding = true // Jika Anda menggunakan View Binding
        // dataBinding = true // Jika Anda menggunakan Data Binding
    }
}

dependencies {
    // Pastikan Anda menggunakan versi terbaru yang stabil dari pustaka-pustaka ini
    // Anda bisa memeriksa versi terbaru di situs developer Android atau Maven Central

    // Core Android libraries
    implementation(libs.androidx.core.ktx) // Untuk ekstensi Kotlin
    implementation(libs.androidx.appcompat) // Untuk kompatibilitas mundur komponen UI
    implementation(libs.material) // Untuk komponen Material Design

    // Layout libraries
    implementation(libs.androidx.constraintlayout) // Untuk layout yang kompleks dan fleksibel
    implementation(libs.androidx.activity) // Untuk komponen Activity

    // Testing libraries
    testImplementation(libs.junit) // Untuk unit testing
    androidTestImplementation(libs.androidx.junit) // Untuk instrumented testing (UI tests)
    androidTestImplementation(libs.androidx.espresso.core) // Untuk UI testing
}
