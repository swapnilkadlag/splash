buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(com.sk.splash.buildSrc.Configuration.Gradle.buildTools)
        classpath(com.sk.splash.buildSrc.Configuration.Kotlin.gradlePlugin)
        classpath(com.sk.splash.buildSrc.Configuration.Hilt.gradlePlugin)
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.google.com/")
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}