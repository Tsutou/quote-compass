import java.util.Properties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.geisha.quote_compass"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.geisha.quote_compass"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val openApiSecretKey = (rootProject.ext["localProperties"] as Properties)["OPRNAPI_SECRET"]
        buildConfigField("String", "OPRNAPI_SECRET", "\"$openApiSecretKey\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    coreLibraryDesugaring(Dep.desugarJdk)

    implementation(Dep.material)

    implementation(Dep.Kotlin.Coroutines.android)

    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.appcompat)
    implementation(Dep.AndroidX.lifecycleRuntime)
    implementation(Dep.AndroidX.dataStorePreferences)
    implementation(Dep.AndroidX.lifecycleProcess)
    implementation(Dep.AndroidX.activityCompose)
    implementation(Dep.AndroidX.viewModelCompose)
    implementation(Dep.AndroidX.navigationCompose)
    implementation(Dep.AndroidX.hiltNavigationCompose)

    implementation(Dep.AndroidX.Compose.ui)
    implementation(Dep.AndroidX.Compose.material)
    implementation(Dep.AndroidX.Compose.materialIconsCore)
    implementation(Dep.AndroidX.Compose.materialIconsExtended)
    implementation(Dep.AndroidX.Compose.uiTooling)

    implementation(Dep.Accompanist.insets)
    implementation(Dep.Accompanist.systemUiController)
    implementation(Dep.Accompanist.navigationAnimation)
    implementation(Dep.Accompanist.pager)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)

    implementation(Dep.OkHttp.okHttp)
    implementation(Dep.OkHttp.logging)

    implementation(Dep.Coil.compose)
    implementation(Dep.Coil.gif)

    implementation(Dep.timber)

    testImplementation(Dep.junit)
    testImplementation(Dep.mockk)
    testImplementation(Dep.truth)
    testImplementation(Dep.robolectric)
    testImplementation(Dep.Kotlin.Coroutines.test)
}
