plugins {
    id("kotlin-multiplatform")
}

initDeps(project)

kotlin {
    jvm("desktop")

    sourceSets {
        named("commonTest") {
            dependencies {
                implementation(Deps.JetBrains.Kotlin.testCommon)
                implementation(Deps.JetBrains.Kotlin.testAnnotationsCommon)
            }
        }

        named("desktopTest") {
            dependencies {
                implementation(Deps.JetBrains.Kotlin.testJunit)
            }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}
