plugins {
    alias(libs.plugins.quran.android.library)
    alias(libs.plugins.quran.android.library.compose)
}

android {
    namespace = "com.mhmdbh.quran.feature.onthisday"

       defaultConfig{
           testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
       }
}

dependencies {


    implementation(project(":core:common"))
    //implementation(project(":feature:data"))
    implementation(project(":core:ui"))
    //implementation(project(":feature:domain"))
    //implementation(project(":ui:detail"))

    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.activity.compose)
    //implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    //implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.accompanist.systemuicontroller)
    //implementation(libs.hilt.android)
    //kapt(libs.hilt.compiler)
}