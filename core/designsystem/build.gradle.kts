plugins {
    alias(libs.plugins.quran.android.library)
    alias(libs.plugins.quran.android.library.compose)
    //alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.mhmdbh.quran.core.designsystem"

       defaultConfig{

           testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
       }
}

dependencies {

    /*import androidx.compose.foundation.layout.RowScope
            import androidx.compose.material3.MaterialTheme
            import androidx.compose.material3.NavigationBarItem
            import androidx.compose.material3.NavigationBarItemDefaults
            import androidx.compose.runtime.Composable
            import androidx.compose.ui.Modifier*/


    implementation(project(":core:common"))

    implementation(libs.androidx.core.ktx)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    implementation(libs.accompanist.systemuicontroller)
    api(libs.androidx.compose.material3)

    debugApi(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.compose.runtime)
}