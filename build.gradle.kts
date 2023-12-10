// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("io.github.takahirom.roborazzi") version "1.7.0-rc-1" apply false
}

buildscript {
    dependencies {
        classpath("io.github.takahirom.roborazzi:roborazzi-gradle-plugin:1.7.0-rc-1")
    }
}