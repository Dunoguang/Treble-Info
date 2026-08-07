import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.4.10"
    `kotlin-dsl`
}

group = "com.github.penn5"
version = "0.2.1"

gradlePlugin {
    plugins {
        register("poeditorPlugin") {
            id = "poeditor-android"
            implementationClass = "com.github.penn5.PoEditorPlugin"
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
    implementation("org.redundent:kotlin-xml-builder:1.9.0")
}

java {
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}
