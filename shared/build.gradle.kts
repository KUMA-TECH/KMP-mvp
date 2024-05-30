import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
//    alias(libs.plugins.ksp)
}

kotlin {
    task("testClasses")

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.projectDir.path)
                    }
                }
            }
        }
    }

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    sourceSets {
        val commonMain by getting {
//            kotlin.srcDir("build/generated/ksp/commonMain/kotlin")
            dependencies {
            }
        }
    }
}

android {
    namespace = "com.kmp.mvp.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

//dependencies {
//    add("kspCommonMainMetadata", project(":lib-processor"))
////    add("kspJvm", projects.libProcessor)
////    add("kspJvmTest", projects.libProcessor)
////    add("kspJs", projects.libProcessor)
////    add("kspJsTest", projects.libProcessor)
////    add("kspAndroidNativeX64", projects.libProcessor)
////    add("kspAndroidNativeX64Test", projects.libProcessor)
////    add("kspAndroidNativeArm64", projects.libProcessor)
////    add("kspAndroidNativeArm64Test", projects.libProcessor)
////    add("kspLinuxX64", projects.libProcessor)
////    add("kspLinuxX64Test", projects.libProcessor)
////    add("kspMingwX64", projects.libProcessor)
////    add("kspMingwX64Test", projects.libProcessor)
////    ksp(projects.libProcessor)
//}
//kotlin.sourceSets.commonMain {
//    kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
//}
//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
//    if (name != "kspCommonMainKotlinMetadata") {
//        dependsOn("kspCommonMainKotlinMetadata")
//    }
//}
//ksp {
//    arg("measureDuration", "true")
//}