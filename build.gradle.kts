// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
}

buildscript{
    dependencies{
        //Safe Args
        classpath("androidx.navigation.safeargs:androidx.navigation.safeargs.gradle.plugin:2.7.7")
        //Dagger Hilt
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
    }
}