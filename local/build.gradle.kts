import com.sk.splash.buildSrc.Configuration

plugins {
    id(com.sk.splash.buildSrc.Configuration.Plugins.androidLibrary)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kotlinAndroid)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kapt)
}

android {
    compileSdk = Configuration.compileSdkVersion
}

dependencies {
    implementation(Configuration.Hilt.daggerAndroid)
    kapt(Configuration.Hilt.daggerAndroidCompiler)
    implementation(Configuration.ThreeTen.abp)
    implementation(Configuration.Kotlin.coroutinesCore)
    kapt(Configuration.Room.compiler)
    implementation(Configuration.Room.runtime)
    implementation(Configuration.Room.ktx)
}