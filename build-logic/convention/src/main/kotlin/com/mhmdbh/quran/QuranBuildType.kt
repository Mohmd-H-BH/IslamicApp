package com.mhmdbh.quran
@Suppress("unused")
enum class QuranBuildType(
    val applicationIdSuffix: String? = null
) {

    DEBUG(".debug"),
    RELEASE
}