import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.mhmdbh.quran.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        this.jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies{
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)

}

gradlePlugin {

    plugins {

        register("androidFeature"){
            id = "quran.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"

        }
        register("androidApplication") {
            id = "quran.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibrary"){
            id = "quran.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "quran.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidApplicationCompose"){
            id = "quran.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidHilt"){
            id = "quran.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("jvmLibrary") {
            id = "quran.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}