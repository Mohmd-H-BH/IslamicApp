package com.mhmdbh.quran.core.data.model

data class Chapter(
    val id: Int,
    val revelationPlace: String,
    val nameSimple: String,
    val nameComplex: String,
    val nameArabic: String,
    val translatedName: String,
    val versesCount: Int,
    val verses: List<Verse>? = emptyList()
){

    companion object{

        val dummy = Chapter(
            id = 1,
            revelationPlace = "makka",
            nameSimple = "Al-Fatiah",
            nameComplex = "Al-Fatiah",
            nameArabic = "الفاتحة",
            translatedName = "The Opener",
            versesCount = 5
        )

        val an_nasir = Chapter(
            id = 110,
            revelationPlace = "madinah",
            nameSimple = "An-Nasr",
            nameComplex = "An-Naşr",
            nameArabic = "النصر",
            translatedName = "The Divine Support",
            versesCount = 3
        )

        val dummyList = listOf(
            dummy,
            dummy,
            dummy,
        )
    }
}

data class TranslatedName(
    val languageName: String,
    val name: String
)