import com.sk.splash.buildSrc.Configuration

plugins {
    id(com.sk.splash.buildSrc.Configuration.Plugins.androidLibrary)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kotlinAndroid)
}

android {
    compileSdk = Configuration.compileSdkVersion

    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    implementation(Configuration.AndroidX.coreKtx)
    implementation(Configuration.AndroidX.appCompat)
    implementation(Configuration.AndroidX.constraintLayout)
    implementation(Configuration.Google.material)

    implementation(Configuration.Hilt.daggerAndroid)
    implementation(Configuration.Hilt.lifecycleViewModel)
    kotlin(Configuration.Hilt.daggerAndroidCompiler)
    kotlin(Configuration.Hilt.compiler)
}