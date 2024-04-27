package com.mhmdbh.quran.navigation


sealed class SubDestination(
    val title:String
){

    data class Surah(private val surahName: String): SubDestination(surahName)
}