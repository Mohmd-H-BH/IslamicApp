package com.mhmdbh.quran.core.data.repository.quran

import com.mhmdbh.quran.core.data.network.model.NetworkChapterItem
import com.mhmdbh.quran.core.data.network.model.NetworkChapterVerseResponse
import com.mhmdbh.quran.core.data.network.model.NetworkVersesUthmaniResponse
import kotlinx.coroutines.flow.Flow

interface QuranRepository {

    fun getChapters(): Flow<List<NetworkChapterItem>>
    fun getVersesByChapter(chapterNum: Int): Flow<NetworkChapterVerseResponse>
    fun getVersesInArabic(chapterNum: Int): Flow<NetworkVersesUthmaniResponse>
    fun getChapterInfo(chapterNum: Int): Flow<NetworkChapterItem>

}