import com.sk.splash.buildSrc.Configuration

plugins {
    id(com.sk.splash.buildSrc.Configuration.Plugins.androidLibrary)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kotlinAndroid)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kapt)
    id(com.sk.splash.buildSrc.Configuration.Plugins.hiltAndroid)
    id(com.sk.splash.buildSrc.Configuration.Plugins.navigationSafeArgs)
}

android {
    compileSdk = Configuration.compileSdkVersion

    defaultConfig {
        minSdk = Configuration.minSdkVersion
        targetSdk = Configuration.targetSdkVersion
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":data"))
    implementation(Configuration.AndroidX.coreKtx)
    implementation(Configuration.AndroidX.appCompat)
    implementation(Configuration.AndroidX.constraintLayout)
    implementation(Configuration.AndroidX.viewpager2)
    implementation(Configuration.Google.material)
    implementation(Configuration.Hilt.daggerAndroid)
    kapt(Configuration.Hilt.daggerAndroidCompiler)
    implementation(Configuration.ThreeTen.abp)
    implementation(Configuration.Kotlin.coroutinesCore)
    implementation(Configuration.Navigation.fragmentKtx)
    implementation(Configuration.Navigation.uiKtx)
    implementation(Configuration.Glide.glide)
    implementation(Configuration.Glide.glideCompiler)
    implementation(Configuration.AndroidX.pagingRuntime)
}