plugins {
    alias(libs.plugins.quran.android.library)
    alias(libs.plugins.quran.android.hilt)
    //alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.mhmdbh.quran.core.data"

       defaultConfig{
           testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
       }
}

dependencies {

    implementation(libs.paging.runtime)
    implementation(libs.paging.compose)

    implementation(libs.retrofit.core)
    implementation(libs.gson.core)
    implementation(libs.gson.converter)
    implementation(libs.okhttp.logging)

    api(libs.androidx.core.ktx)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    debugApi(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
}