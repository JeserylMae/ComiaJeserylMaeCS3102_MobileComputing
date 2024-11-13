import com.android.tools.r8.internal.pl

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.androidLab"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidLab"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    viewBinding{
        enable = true
    }
    sourceSets {
        getByName("main") {
            res {
                srcDirs("src\\main\\res", "src\\main\\res\\layout-popups",
                    "src\\main\\res",
                    "src\\main\\res\\drawable-img", "src\\main\\res", "src\\main\\res\\drawable-bg",
                    "src\\main\\res",
                    "src\\main\\res\\drawable-ripple"
                )
            }
        }
    }
}

dependencies {
    // For loading GIF files.
    implementation(libs.android.gif.drawable)
    // For CardView
    implementation(libs.material.v121)
    // For implementation 'net.objecthunter:exp4j:0.4.8'
    implementation(libs.exp4j)
    implementation(libs.squareup.retrofit) // Retrofit
    implementation(libs.converter.gson) // Gson converter
    implementation(libs.okhttp3.logging.interceptor)
    implementation(libs.com.github.bumptech.glide.glide)
    annotationProcessor(libs.compiler)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    implementation(libs.firebase.crashlytics.buildtools)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}