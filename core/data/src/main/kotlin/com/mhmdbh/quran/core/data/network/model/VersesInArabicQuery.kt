package com.mhmdbh.quran.core.data.network.model

typealias VersesInArabicQuery = Map<String, String>

enum class Query(val key: String){
    CHAPTER_NUM("chapter_number")
}