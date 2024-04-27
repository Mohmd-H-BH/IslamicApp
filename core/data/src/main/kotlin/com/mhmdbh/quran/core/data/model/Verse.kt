package com.mhmdbh.quran.core.data.model

data class Verse(
    val id: Int,
    val verseNumber: Int,
    val primary: String,
    val secondary: String,
){

    companion object{
        val dummy = Verse(
            id = 1,
            verseNumber = 1,
            primary = " الٓر ۚ تِلْكَ ءَايَـٰتُ ٱلْكِتَـٰبِ ٱلْمُبِينِ",
            secondary = " الٓر ۚ تِلْكَ ءَايَـٰتُ ٱلْكِتَـٰبِ ٱلْمُبِينِ",
        )

        val dummyList = listOf(
            dummy,
            dummy,
            dummy
        )
    }
}
