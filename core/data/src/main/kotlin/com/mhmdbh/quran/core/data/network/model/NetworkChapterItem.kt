package com.mhmdbh.quran.core.data.network.model

import com.google.gson.annotations.SerializedName

data class NetworkChapterInfoResponse(
    val chapter: NetworkChapterItem
)

data class NetworkChapterResponse(
    @SerializedName("chapters")
    val chapters: List<NetworkChapterItem>
)

data class NetworkChapterItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("revelation_place") // Adjusted casing here
    val revelationPlace: String, // Adjusted property name
    @SerializedName("revelation_order") // Adjusted casing here
    val revelationOrder: Int, // Adjusted property name
    @SerializedName("bismillah_pre") // Adjusted casing here
    val bismillahPre: Boolean, // Adjusted property name
    @SerializedName("name_simple") // Adjusted casing here
    val nameSimple: String, // Adjusted property name
    @SerializedName("name_complex") // Adjusted casing here
    val nameComplex: String, // Adjusted property name
    @SerializedName("name_arabic") // Adjusted casing here
    val nameArabic: String, // Adjusted property name
    @SerializedName("verses_count") // Adjusted casing here
    val versesCount: Int, // Adjusted property name
    @SerializedName("pages")
    val pages: List<Int>,
    @SerializedName("translated_name")
    val translated_name: NetworkTranslatedNameResp
)

data class NetworkTranslatedNameResp(
    @SerializedName("language_name") // Adjusted casing here
    val languageName: String, // Adjusted property name
    @SerializedName("name")
    val name: String
)

