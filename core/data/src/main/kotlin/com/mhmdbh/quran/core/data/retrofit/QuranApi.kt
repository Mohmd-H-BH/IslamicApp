package com.mhmdbh.quran.core.data.retrofit

import com.mhmdbh.quran.core.data.network.model.NetworkChapterInfoResponse
import com.mhmdbh.quran.core.data.network.model.NetworkChapterResponse
import com.mhmdbh.quran.core.data.network.model.NetworkChapterVerseResponse
import com.mhmdbh.quran.core.data.network.model.NetworkVersesUthmaniResponse
import com.mhmdbh.quran.core.data.network.model.VersesInArabicQuery
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface QuranApi {

    @GET("chapters")
    suspend fun getChapters(): NetworkChapterResponse

    @GET("verses/by_chapter/{chapter_num}")
    suspend fun getVersesByChapter(
        @Path("chapter_num") chapterNum: Int,
        @QueryMap query: Map<String,String>
    ): NetworkChapterVerseResponse

    @GET("quran/verses/uthmani")
    suspend fun getVersesInArabic(
        @QueryMap query: VersesInArabicQuery,
        //chapterNum: Int
    ): NetworkVersesUthmaniResponse

    @GET("chapters/{id}")
    suspend fun getChapterInfo(@Path("id") chapterNum: Int): NetworkChapterInfoResponse
}