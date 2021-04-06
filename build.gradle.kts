// This is project root directory
buildscript {
    val kotlinVersion = "1.4.10"
    val buildGradleVersion = "4.0.1"
    val sqlDelightVersion: String by project
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()

    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.android.tools.build:gradle:$buildGradleVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
    }
}

allprojects {
    repositories {
        google()
        jcenter()

        mavenCentral()

    }
}