import com.android.build.gradle.LibraryExtension
import com.mhmdbh.quran.configureKotlinAndroid
import com.mhmdbh.quran.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target){
            with(pluginManager){
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension>{
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 34
            }

            val libs = libs

            configurations.configureEach {
                resolutionStrategy{
                    force(libs.findLibrary("junit4").get())
                    //force(com.objenesis:objenesis:2.6)
                }
            }

            dependencies{
                add("androidTestImplementation", kotlin("test"))
                add("testImplementation", kotlin("test"))
            }
        }
    }
}