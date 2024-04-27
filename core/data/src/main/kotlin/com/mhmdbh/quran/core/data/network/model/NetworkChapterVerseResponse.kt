package com.mhmdbh.quran.core.data.network.model

import com.google.gson.annotations.SerializedName

data class NetworkChapterVerseResponse(
    val verses: List<NetworkVerseResponse>,
    val pagination: NetworkPaginationResponse
)
data class NetworkVerseResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("verse_number")
    val verseNumber: Int,
    @SerializedName("verse_key")
    val verseKey: String,
    @SerializedName("hizb_number")
    val hizbNumber: Int,
    @SerializedName("rub_el_hizb_number")
    val rubElHizbNumber: Int,
    @SerializedName("ruku_number")
    val rukuNumber: Int,
    @SerializedName("manzil_number")
    val manzilNumber: Int,
    @SerializedName("sajdah_number")
    val sajdahNumber: Any?,
    @SerializedName("page_number")
    val pageNumber: Int,
    @SerializedName("juz_number")
    val juzNumber: Int,
    @SerializedName("words")
    val words: List<NetworkWordResponse>
)

data class NetworkWordResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("position")
    val position: Int,
    @SerializedName("audio_url")
    val audioUrl: String?,
    @SerializedName("char_type_name")
    val charTypeName: String,
    @SerializedName("code_v1")
    val codeV1: String,
    @SerializedName("page_number")
    val pageNumber: Int,
    @SerializedName("line_number")
    val line_number: Int, // Corrected typo
    @SerializedName("text")
    var text: String,
    @SerializedName("translation")
    val translation: NetworkTranslationResponse,
    @SerializedName("transliteration")
    val transliteration: NetworkTranslationResponse
)

data class NetworkTranslationResponse(
    @SerializedName("text")
    val text: String,
    @SerializedName("language_name")
    val languageName: String
)

data class NetworkPaginationResponse(
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("next_page")
    val nextPage: Any?, // Can be null
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_records")
    val totalRecords: Int
)


