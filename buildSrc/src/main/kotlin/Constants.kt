object Plugins {
    object Kotlin {
        const val android = "android"
        const val jvm = "jvm"
        const val parcelize = "plugin.parcelize"
        const val serialization = "plugin.serialization"
        const val kapt = "kapt"
    }

    object Android {
        const val version = "7.4.1"
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Java {
        const val library = "java-library"
    }

    object Detekt {
        const val version = "1.22.0"
        const val plugin = "io.gitlab.arturbosch.detekt"
        const val formattingPlugin = "io.gitlab.arturbosch.detekt:detekt-formatting:$version"
    }

    object Dokka {
        const val version = "1.7.20"
        const val plugin = "org.jetbrains.dokka"
    }

    object KtLint {
        const val version = "11.2.0"
        const val plugin = "org.jlleitschuh.gradle.ktlint"
        const val classpathDependency = "org.jlleitschuh.gradle:ktlint-gradle:$version"
    }

    object Kover {
        const val version = "0.6.1"
        const val plugin = "org.jetbrains.kotlinx.kover"
        const val classpathDependency = "org.jetbrains.kotlinx:kover:$version"
    }

    object DependenciesVersions {
        const val version = "0.45.0"
        const val plugin = "com.github.ben-manes.versions"
    }

    object Hilt {
        const val plugin = "com.google.dagger.hilt.android"
    }

    object GoogleServices {
        private const val version = "4.3.15"
        const val plugin = "com.google.gms.google-services"
        const val classpathDependency = "com.google.gms:google-services:$version"
    }

    object Crashlytics {
        private const val version = "2.9.4"
        const val plugin = "com.google.firebase.crashlytics"
        const val classpathDependency = "com.google.firebase:firebase-crashlytics-gradle:$version"
    }
}

object Kotlin {
    const val version = "1.8.10"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"

    object Coroutines {
        private const val versionTest = "1.6.4"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$versionTest"
    }

    object Serialization {
        private const val version = "1.4.1"
        const val runtime = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:$version"
        const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
        const val core = "org.jetbrains.kotlinx:kotlinx-serialization-core:$version"
    }
}

object AndroidX {

    object AppCompat {
        private const val version = "1.6.1"
        const val dependency = "androidx.appcompat:appcompat:$version"
    }

    object Core {
        private const val version = "1.9.0"
        const val dependency = "androidx.core:core-ktx:$version"
    }

    object Fragment {
        private const val version = "1.5.5"
        const val ktx = "androidx.fragment:fragment-ktx:$version"
        const val testing = "androidx.fragment:fragment-testing:$version"
    }

    object Lifecycle {
        private const val version = "2.5.1"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val process = "androidx.lifecycle:lifecycle-process:$version"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
    }

    object Activity {
        private const val version = "1.6.1"
        const val compose = "androidx.activity:activity-compose:$version"
    }

    object Compose {
        const val version = "1.3.3"
        const val compilerVersion = "1.4.2"
        const val material3version = "1.0.1"
        const val ui = "androidx.compose.ui:ui:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
        const val foundation = "androidx.compose.foundation:foundation:$version"
        const val material = "androidx.compose.material3:material3:$material3version"
        const val icons_core = "androidx.compose.material:material-icons-core:$version"
        const val icons_extended = "androidx.compose.material:material-icons-extended:$version"
        const val livedata = "androidx.compose.runtime:runtime-livedata:$version"
        const val junit = "androidx.compose.ui:ui-test-junit4:$version"
    }

    object Navigation {
        private const val version = "2.5.3"
        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        const val compose = "androidx.navigation:navigation-compose:$version"
    }
}

object Testing {
    object AssertK {
        private const val version = "0.25"
        const val dependency = "com.willowtreeapps.assertk:assertk-jvm:$version"
    }

    object JUnit {
        private const val version = "5.9.2"
        const val platformDependency = "org.junit:junit-bom:$version"
        const val jupiter = "org.junit.jupiter:junit-jupiter"
    }

    object Mockk {
        private const val version = "1.13.4"
        const val dependency = "io.mockk:mockk:$version"
    }

    object Arch {
        private const val version = "2.1.0"
        const val core = "androidx.arch.core:core-testing:$version"
    }

    object AndroidX {
        private const val version = "1.1.5"
        const val junit = "androidx.test.ext:junit:$version"
    }

    object Espresso {
        private const val version = "3.5.1"
        const val core = "androidx.test.espresso:espresso-core:$version"
    }
}

object Google {
    object Crashlytics {
        private const val version = "18.3.4"
        const val dependency = "com.google.firebase:firebase-crashlytics:$version"
    }

    object Material {
        private const val version = "1.8.0"
        const val dependency = "com.google.android.material:material:$version"
    }
}

object Gson {
    private const val version = "2.10.1"
    const val dependency = "com.google.code.gson:gson:$version"
}

object Hilt {
    const val version = "2.45"
    const val dependency = "com.google.dagger:hilt-android:$version"
    const val compiler = "com.google.dagger:hilt-android-compiler:$version"

    object ComposeNavigation {
        private const val version = "1.0.0"
        const val dependency = "androidx.hilt:hilt-navigation-compose:$version"
    }

    object JavaXInject {
        private const val version = "1"
        const val dependency = "javax.inject:javax.inject:$version"
    }
}

object Room {
    private const val version = "2.5.0"
    const val dependency = "androidx.room:room-runtime:$version"
    const val compiler = "androidx.room:room-compiler:$version" // kapt
    const val test = "androidx.room:room-testing:$version"
}

object Retrofit {
    private const val version = "2.9.0"
    const val dependency = "com.squareup.retrofit2:retrofit:$version"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
}

object Timber {
    private const val version = "5.0.1"
    const val dependency = "com.jakewharton.timber:timber:$version"
}

object LeakCanary {
    private const val version = "2.10"
    const val dependency = "com.squareup.leakcanary:leakcanary-android:$version"
}
