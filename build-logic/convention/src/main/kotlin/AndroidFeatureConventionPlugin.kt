import com.android.build.gradle.LibraryExtension
import com.mhmdbh.quran.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("quran.android.library")
                apply("quran.android.hilt")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    //testInstrumentationRunner = "com.google.samples.apps.nowinandroid.core.testing.NiaTestRunner"
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                testOptions.animationsDisabled = true
                //configureGradleManagedDevices(this)
            }

            dependencies {
                add("implementation", project(":core:ui"))
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:common"))
                add("implementation", project(":core:data"))
                //add("implementation", project(":core:domain"))

                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
                //add("implementation", libs.findLibrary("androidx.tracing.ktx").get())

                //add("androidTestImplementation", libs.findLibrary("androidx.lifecycle.runtimeTesting").get())
            }
        }
    }
}

class AndroidFeatureConventionPlugin2: Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            pluginManager.apply {
                apply("quran.android.library")
                apply("quran.android.hilt")
            }
            extensions.configure<LibraryExtension>{
                defaultConfig{
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                //configureGradleManagedDevices(this)
            }

            val libs = libs

            dependencies {
                add("implementation", project(":core:common"))
                add("implementation", project(":core:data"))
                //add("implementation", project(":core:domain"))
                add("implementation", project(":core:ui"))

                //add("testImplementation", kotlin("test"))
                //add("androidTestImplementation", kotlin("test"))

                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            }

        }
    }
}