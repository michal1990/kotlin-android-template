pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

include(
    ":app"
)

rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "Template"
include(":library-android")
include(":library-kotlin")
