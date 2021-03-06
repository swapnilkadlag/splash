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
        const val kotlinParcelize = "kotlin-parcelize"
        const val kapt = "kotlin-kapt"
        const val hiltAndroid = "dagger.hilt.android.plugin"
        const val navigationSafeArgs = "androidx.navigation.safeargs"
    }

    object Gradle {
        const val buildTools = "com.android.tools.build:gradle:7.0.4"
    }

    object Kotlin {
        private const val version = "1.5.2"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    }

    object AndroidX {
        private const val pagingVersion = "3.1.0"

        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.4.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
        const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"
        const val paging = "androidx.paging:paging-common-ktx:$pagingVersion"
        const val pagingRuntime = "androidx.paging:paging-runtime-ktx:$pagingVersion"
        const val pagingRoom = "androidx.room:room-paging:2.5.0-alpha01"

        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
        const val lifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
        const val lifecycleCommon = "androidx.lifecycle:lifecycle-common:2.4.0"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
        const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:2.4.0"
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

    object ThreeTen {
        const val abp = "com.jakewharton.threetenabp:threetenabp:1.3.1"
    }

    object Retrofit {
        private const val retrofitVersion = "2.9.0"
        private const val moshiVersion = "1.13.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val moshi = "com.squareup.moshi:moshi-kotlin:$moshiVersion"
        const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.3"
    }

    object Room {
        private const val version = "2.4.1"

        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"
    }

    object Navigation {
        private const val version = "2.4.0"

        const val safeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
    }

    object Glide {
        private const val version = "4.12.0"

        const val glide = "com.github.bumptech.glide:glide:$version"
        const val glideCompiler = "com.github.bumptech.glide:compiler:$version"
    }

    object LeakCanary {
        const val android = "com.squareup.leakcanary:leakcanary-android:2.8.1"
    }

    object Chucker {
        const val library = "com.github.chuckerteam.chucker:library:3.5.2"
    }
}