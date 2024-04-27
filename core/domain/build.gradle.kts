plugins {
    alias(libs.plugins.quran.android.library)
    alias(libs.plugins.quran.android.hilt)
}

android {
    namespace = "com.mhmdbh.quran.core.domain"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))

    api(libs.kotlinx.coroutines.android)
    implementation(libs.hilt.android)
    //ksp(libs.hilt.compiler)
}