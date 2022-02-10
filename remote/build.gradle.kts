import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.sk.splash.buildSrc.Configuration

plugins {
    id(com.sk.splash.buildSrc.Configuration.Plugins.androidLibrary)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kotlinAndroid)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kapt)
}

android {
    compileSdk = Configuration.compileSdkVersion

    buildTypes {
        debug {
            buildConfigField("String", "API_KEY", gradleLocalProperties(rootDir).getProperty("apiKey"))
        }
    }


}

dependencies {
    implementation(Configuration.Hilt.daggerAndroid)
    kapt(Configuration.Hilt.daggerAndroidCompiler)
    implementation(Configuration.ThreeTen.abp)
    implementation(Configuration.Retrofit.retrofit)
    implementation(Configuration.Retrofit.moshiConverter)
    implementation(Configuration.Retrofit.moshi)
    kapt(Configuration.Retrofit.moshiCodegen)
    implementation(Configuration.Retrofit.loggingInterceptor)
    implementation(Configuration.Kotlin.coroutinesCore)
    debugImplementation(Configuration.Chucker.library)
}