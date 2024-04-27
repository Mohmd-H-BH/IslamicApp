plugins {
    alias(libs.plugins.quran.android.library)
    alias(libs.plugins.quran.android.library.compose)
}

android {
    namespace = "com.mhmdbh.quran.core.ui"

       defaultConfig{
           testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
       }
}

dependencies {


    api(libs.androidx.core.ktx)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    debugApi(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
}