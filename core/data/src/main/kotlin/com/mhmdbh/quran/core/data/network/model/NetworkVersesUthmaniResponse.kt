package com.mhmdbh.quran.core.data.network.model

import com.google.gson.annotations.SerializedName

data class NetworkVersesUthmaniResponse(
    @SerializedName("verses")
    val verses: List<NetworkVerseUthmani>,
    @SerializedName("meta")
    val meta: NetworkMeta
)

data class NetworkVerseUthmani(
    @SerializedName("id")
    val id: Int,
    @SerializedName("verse_key")
    val verseKey: String,
    @SerializedName("text_uthmani")
    val textUthmani: String
)

data class NetworkMeta(
    @SerializedName("filters")
    val filters: NetworkFilters
)

data class NetworkFilters(
    @SerializedName("chapter_number")
    val chapterNumber: String
)
