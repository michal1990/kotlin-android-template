import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import kotlinx.kover.api.DefaultIntellijEngine
import kotlinx.kover.api.DefaultJacocoEngine
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    kotlin(Plugins.Kotlin.android) version Kotlin.version apply false
    kotlin(Plugins.Kotlin.jvm) version Kotlin.version apply false
    id(Plugins.Android.application) version Plugins.Android.version apply false
    id(Plugins.Android.library) version Plugins.Android.version apply false
    id(Plugins.Detekt.plugin) version Plugins.Detekt.version apply true
    id(Plugins.KtLint.plugin) version Plugins.KtLint.version apply true
    id(Plugins.Dokka.plugin) version Plugins.Dokka.version apply true
    id(Plugins.Kover.plugin) version Plugins.Kover.version apply true
    id(Plugins.DependenciesVersions.plugin) version Plugins.DependenciesVersions.version apply true
    id(Plugins.Hilt.plugin) version Hilt.version apply false
}

buildscript {
    repositories {
        gradlePluginPortal()
    }

    dependencies {
        classpath(Plugins.KtLint.classpathDependency)
        classpath(Plugins.Kover.classpathDependency)
        // Enable Crashlytics when needed
//        classpath(Plugins.GoogleServices.classpathDependency)
//        classpath(Plugins.Crashlytics.classpathDependency)
    }
}

dependencies {
    detektPlugins(Plugins.Detekt.formattingPlugin)
}

subprojects {
    repositories {
        google()
        mavenCentral()
    }

    apply(plugin = Plugins.KtLint.plugin)
    apply(plugin = Plugins.Detekt.plugin)
    apply(plugin = Plugins.Kover.plugin)
}

//https://github.com/JLLeitschuh/ktlint-gradle
configure<KtlintExtension> {
    verbose.set(true)
    outputColorName.set("RED")
    enableExperimentalRules.set(true)
    reporters {
        reporter(ReporterType.JSON) // output format
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}

//https://detekt.dev/docs/gettingstarted/gradle/#kotlin-dsl-3
detekt {
    config = files("$rootDir/config/detekt.yml")
}

/**
 * We can define separate [kover] config for each module. [koverMerged] disallows setting coverage engine so we have to
 * specify it separately in [kover] block.
 * Basically, we have two engines to select: [DefaultIntellijEngine] and [DefaultJacocoEngine]. The main difference
 * between them is how they calculate coverage of particular line. [DefaultIntellijEngine] treats line as covered as
 * soon as at least one branch is tested. [DefaultJacocoEngine] treats line as covered only when every branch is tested.
 *
 * https://kotlin.github.io/kotlinx-kover/
 */
koverMerged {
    enable()
    filters {
        classes {
            excludes += listOf<String>()
        }
    }
    verify {
        rule {
            name = "Minimum code coverage level"
            bound {
                minValue = 0
            }
        }
    }
}

tasks {
    //https://github.com/ben-manes/gradle-versions-plugin
    withType<DependencyUpdatesTask>().configureEach {
        // check only stable versions of dependencies
        rejectVersionIf {
            candidate.version.isStableVersion().not()
        }
    }
    //Runs multiple unit test cases in parallel
    //https://docs.gradle.org/current/userguide/performance.html#execute_tests_in_parallel
    withType<Test>().configureEach {
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
    }
    //Runs every 100 unit test cases on a new test VM
    //https://docs.gradle.org/current/userguide/performance.html#fork_tests_into_multiple_processes
    withType<Test>().configureEach {
        setForkEvery(100)
    }
}
