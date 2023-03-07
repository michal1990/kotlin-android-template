import kotlinx.kover.api.DefaultJacocoEngine

plugins {
    kotlin(Plugins.Kotlin.android)
    id(Plugins.Android.application)
    kotlin(Plugins.Kotlin.parcelize)
    kotlin(Plugins.Kotlin.kapt)
    id(Plugins.Hilt.plugin)

//  Enable Crashlytics when needed
//    id(Google.Services.plugin)
//    id(Google.Firebase.Crashlytics.plugin)
}

android {
    namespace = GradleConfig.appNamespace
    compileSdk = GradleConfig.compileSdkVersion

    defaultConfig {
        applicationId = GradleConfig.applicationId
        minSdk = GradleConfig.minSdkVersion
        targetSdk = GradleConfig.compileSdkVersion
        versionCode = GradleConfig.versionCode
        versionName = GradleConfig.versionName
    }

    signingConfigs {
        create("release") {
            storeFile = file("../release.jks")
            storePassword = getEnvElseLocal("STORE_PASSWORD", project)
            keyAlias = getEnvElseLocal("KEY_ALIAS", project)
            keyPassword = getEnvElseLocal("KEY_PASSWORD", project)
        }
    }

    buildTypes {
        debug {
            manifestPlaceholders["crashlyticsCollectionEnabled"] = false
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
            manifestPlaceholders["crashlyticsCollectionEnabled"] = true
        }
    }

    // Use this block to configure different flavors
//    flavorDimensions("version")
//    productFlavors {
//        create("full") {
//            dimension = "version"
//            applicationIdSuffix = ".full"
//        }
//        create("demo") {
//            dimension = "version"
//            applicationIdSuffix = ".demo"
//        }
//    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        jvmToolchain(JavaVersion.VERSION_11.toString().toInt())
    }

    kotlinOptions {
        freeCompilerArgs = listOf(
            "-opt-in=kotlin.RequiresOptIn",
        )
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AndroidX.Compose.compilerVersion
    }

    packagingOptions {
        resources.excludes.addAll(listOf("META-INF/AL2.0", "META-INF/LGPL2.1"))
    }

    /*  Enable Crashlytics when needed
    applicationVariants.all {
        enableGoogleServicesForVariant(this)
    }

    fun enableGoogleServicesForVariant(variant: com.android.build.gradle.api.ApplicationVariant) {
        val googleTask = tasks.findByName("process${variant.name.capitalize()}GoogleServices")
        val firebaseCrashlyticsTask =
            tasks.findByName("injectCrashlyticsMappingFileId${variant.name.capitalize()}")
        val enable = variant.buildType.name == "release"
        googleTask?.enabled = enable
        firebaseCrashlyticsTask?.enabled = enable
    }*/
}

kover {
    engine.set(DefaultJacocoEngine)
}

dependencies {
    implementation(Kotlin.stdlib)
    implementation(AndroidX.AppCompat.dependency)
    implementation(AndroidX.Core.dependency)
    implementation(AndroidX.Lifecycle.viewModel)
    implementation(AndroidX.Lifecycle.viewModelCompose)
    implementation(AndroidX.Compose.ui)
    implementation(AndroidX.Compose.material)
    implementation(AndroidX.Compose.tooling)
    implementation(AndroidX.Activity.compose)

    implementation(Hilt.dependency)
    kapt(Hilt.compiler)
    implementation(Hilt.JavaXInject.dependency)
    implementation(Hilt.ComposeNavigation.dependency)

    implementation(Timber.dependency)

    debugImplementation(LeakCanary.dependency)

    testImplementation(platform(Testing.JUnit.platformDependency))
    testImplementation(Testing.JUnit.jupiter)
    testImplementation(Testing.AssertK.dependency)
    testImplementation(Testing.Mockk.dependency)
    testImplementation(Testing.Arch.core)
    testImplementation(Kotlin.Coroutines.test)

    androidTestImplementation(Testing.AndroidX.junit)
    androidTestImplementation(Testing.Espresso.core)
}
