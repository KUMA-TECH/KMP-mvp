@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("multiplatform")
}

kotlin {
    task("testClasses")

    jvm()
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(libs.javapoet)
                implementation(libs.ksp.symbol)
            }
            kotlin.srcDir("src/main/kotlin")
            resources.srcDir("src/main/resources")
        }
    }
}