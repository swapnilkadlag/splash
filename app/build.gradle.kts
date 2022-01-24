import com.sk.splash.buildSrc.Configuration

plugins {
    id(com.sk.splash.buildSrc.Configuration.Plugins.androidApplication)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kotlinAndroid)
    id(com.sk.splash.buildSrc.Configuration.Plugins.kapt)
    id(com.sk.splash.buildSrc.Configuration.Plugins.hiltAndroid)
}

android {
    compileSdk = Configuration.compileSdkVersion

    defaultConfig {
        applicationId = Configuration.applicationId
        minSdk = Configuration.minSdkVersion
        targetSdk = Configuration.targetSdkVersion
        versionCode = Configuration.versionCode
        versionName = Configuration.versionName
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":ui"))

    implementation(Configuration.AndroidX.coreKtx)
    implementation(Configuration.AndroidX.appCompat)
    implementation(Configuration.AndroidX.constraintLayout)
    implementation(Configuration.Google.material)

    implementation(Configuration.Hilt.daggerAndroid)
    kapt(Configuration.Hilt.daggerAndroidCompiler)

    implementation(Configuration.ThreeTen.abp)
}