import com.sk.splash.buildSrc.Configuration

plugins {
    id(com.sk.splash.buildSrc.Configuration.Plugins.androidLibrary)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kotlinAndroid)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kapt)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kotlinParcelize)
}

android {
    compileSdk = Configuration.compileSdkVersion
}

dependencies {
    implementation(project(":remote"))
    implementation(project(":local"))

    implementation(Configuration.Hilt.daggerAndroid)
    kapt(Configuration.Hilt.daggerAndroidCompiler)
    implementation(Configuration.ThreeTen.abp)
    implementation(Configuration.Kotlin.coroutinesCore)
    implementation(Configuration.AndroidX.paging)
}