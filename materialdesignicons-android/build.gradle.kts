import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.4.10"
    `kotlin-dsl`
}

group = "com.github.penn5"
version = "0.1.2"

gradlePlugin {
    plugins {
        register("materialdesigniconsPlugin") {
            id = "materialdesignicons-android"
            implementationClass = "com.github.penn5.MaterialDesignIconsPlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
}
dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:8.0.1")
    implementation("commons-io:commons-io:2.11.0")
}

java {
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}
