import com.sk.splash.buildSrc.Configuration

plugins {
    id(com.sk.splash.buildSrc.Configuration.Plugins.androidLibrary)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kotlinAndroid)
}

android {
    compileSdk = Configuration.compileSdkVersion
}