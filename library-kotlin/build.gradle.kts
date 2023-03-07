import kotlinx.kover.api.DefaultJacocoEngine
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Plugins.Java.library)
    kotlin(Plugins.Kotlin.jvm)
    //https://kotlinlang.org/docs/dokka-get-started.html
    id(Plugins.Dokka.plugin)
}

dependencies {
    testImplementation(platform(Testing.JUnit.platformDependency))
    testImplementation(Testing.JUnit.jupiter)
    testImplementation(Testing.AssertK.dependency)
    testImplementation(Testing.Mockk.dependency)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withSourcesJar()
    withJavadocJar()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

kover {
    engine.set(DefaultJacocoEngine)
}
