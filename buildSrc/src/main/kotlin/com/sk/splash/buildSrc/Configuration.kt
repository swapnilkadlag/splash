package com.sk.splash.buildSrc

object Configuration {
    const val compileSdkVersion = 31
    const val applicationId = "com.sk.splash"
    const val minSdkVersion = 21
    const val targetSdkVersion = 31
    const val versionCode = 1
    const val versionName = "1.0"

    object Plugins {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlinAndroid = "kotlin-android"
    }

    object Gradle {
        const val buildTools = "com.android.tools.build:gradle:7.0.4"
    }

    object Kotlin {
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.4.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
    }

    object Google {
        const val material = "com.google.android.material:material:1.5.0"
    }

    object Hilt {
        private const val version = "2.40.5"

        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val daggerAndroid = "com.google.dagger:hilt-android:$version"
        const val daggerAndroidCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val lifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        const val compiler = "androidx.hilt:hilt-compiler:1.0.0"
    }
}