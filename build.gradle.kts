// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Config.BuildScriptPlugins.ANDROID_GRADLE)
        classpath(Config.BuildScriptPlugins.KOTLIN_GRADLE)
    }
}

plugins {
    id(Config.ApplyPlugins.KT_LINT) version Config.KTLINT_GRADLE_VERSION
    id(Config.ApplyPlugins.MAVEN_PUBLISH)
    id(Config.ApplyPlugins.DETEKT) version Config.DETEKT_VERSION
}

detekt {
    config =
        files("$rootDir/config/detekt/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior
}

allprojects {
    repositories {
        // Uncomment mavenLocal to use local versions of libraries.
        // This is used for library development of LaunchPad
        mavenLocal()
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}