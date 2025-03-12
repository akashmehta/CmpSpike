plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

buildscript {
    repositories {
        val companyMaven = { companyUrl: String ->
            maven {
                credentials {
                    username = "readonly"
                    password = "123qweasdzxc"
                }
                setUrl(companyUrl)
            }
        }
        companyMaven("https://artifactory-ehv.ta.philips.com/artifactory")
        companyMaven("https://artifactory-ehv.ta.philips.com/artifactory/platform-pkgs-android-release")
        companyMaven("https://artifactory-ehv.ta.philips.com/artifactory/platform-plugins-release-local")
        companyMaven("https://artifactory-ehv.ta.philips.com/artifactory/platform-jcenter-remote")
    }
    dependencies {
        classpath("com.philips.cdp:cdpSCM:5.5.0") {
            exclude("com.android.support")
        }
        classpath("org.jfrog.buildinfo:build-info-extractor-gradle:5.1.4")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
    }
}
