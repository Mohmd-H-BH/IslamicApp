plugins {
    //alias(libs.plugins.quran.android.library)
    alias(libs.plugins.quran.android.feature)
    alias(libs.plugins.quran.android.library.compose)
    alias(libs.plugins.quran.android.hilt)
    id("kotlin-parcelize")
}

android {
    namespace = "com.mhmdbh.quran.feature.qurani"

       defaultConfig{
           testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
       }
}

dependencies {

    //implementation(project(":core:common"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))
    //implementation(project(":core:ui"))

    //implementation(project(":feature:data"))
    //implementation(project(":feature:domain"))
    //implementation(project(":ui:detail"))

    implementation(libs.androidx.compose.material3.windowSizeClass)
    //implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.activity.compose)

    //implementation(libs.androidx.navigation.compose)
    //implementation(libs.androidx.lifecycle.runtimeCompose)

    //implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.accompanist.systemuicontroller)
    //implementation(libs.hilt.android)
    //kapt(libs.hilt.compiler)

}