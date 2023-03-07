import kotlinx.kover.api.DefaultJacocoEngine

plugins {
    kotlin(Plugins.Kotlin.android)
    id(Plugins.Android.library)
    //https://kotlinlang.org/docs/dokka-get-started.html
    id(Plugins.Dokka.plugin)
}

android {
    namespace = GradleConfig.libraryAndroidNamespace
    compileSdk = GradleConfig.compileSdkVersion

    defaultConfig {
        minSdk = GradleConfig.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        jvmToolchain(JavaVersion.VERSION_11.toString().toInt())
    }
}

kover {
    engine.set(DefaultJacocoEngine)
}

dependencies {
    implementation(Kotlin.stdlib)
    implementation(AndroidX.AppCompat.dependency)
    implementation(AndroidX.Core.dependency)

    testImplementation(platform(Testing.JUnit.platformDependency))
    testImplementation(Testing.JUnit.jupiter)
    testImplementation(Testing.AssertK.dependency)
    testImplementation(Testing.Mockk.dependency)

    androidTestImplementation(Testing.AndroidX.junit)
    androidTestImplementation(Testing.Espresso.core)
}
