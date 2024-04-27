package com.mhmdbh.quran.core.data.repository.quran

import com.mhmdbh.quran.core.data.network.model.NetworkChapterItem
import com.mhmdbh.quran.core.data.network.di.Dispatcher
import com.mhmdbh.quran.core.data.network.di.QuranDispatchers
import com.mhmdbh.quran.core.data.network.model.NetworkChapterVerseResponse
import com.mhmdbh.quran.core.data.network.model.NetworkVersesUthmaniResponse
import com.mhmdbh.quran.core.data.network.model.Query
import com.mhmdbh.quran.core.data.retrofit.QuranApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuranRepositoryImpl @Inject constructor(
    @Dispatcher(QuranDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val quranApi: QuranApi
) : QuranRepository {

    override fun getChapters(): Flow<List<NetworkChapterItem>> = flow {
        emit(getChaptersCall())
    }.flowOn(ioDispatcher)

    override fun getVersesByChapter(chapterNum: Int): Flow<NetworkChapterVerseResponse> = flow {
        emit(getVersesByChapterCall(chapterNum))
    }.flowOn(ioDispatcher)

    override fun getVersesInArabic(chapterNum: Int): Flow<NetworkVersesUthmaniResponse> =
        flow<NetworkVersesUthmaniResponse> {
            emit(getVersesInArabicCall(chapterNum))
        }.flowOn(ioDispatcher)

    override fun getChapterInfo(chapterNum: Int): Flow<NetworkChapterItem> =
        flow<NetworkChapterItem> {
            emit(getChapterInfoCall(chapterNum))
    }.flowOn(ioDispatcher)

    private suspend fun getChapterInfoCall(chapterNum: Int): NetworkChapterItem =
        withContext(ioDispatcher){
            return@withContext quranApi.getChapterInfo(chapterNum).chapter
        }
    private suspend fun getVersesInArabicCall(chapterNum: Int): NetworkVersesUthmaniResponse =
        withContext(ioDispatcher) {
            return@withContext quranApi
                .getVersesInArabic(mapOf(Query.CHAPTER_NUM.key to chapterNum.toString()))
        }

    private suspend fun getChaptersCall(): List<NetworkChapterItem> =
        withContext(ioDispatcher) {
            //delay(5000L)
            return@withContext quranApi
                .getChapters()
                .chapters
        }

    private suspend fun getVersesByChapterCall(chapterNum: Int): NetworkChapterVerseResponse =
        withContext(ioDispatcher) {
            return@withContext quranApi.getVersesByChapter(
                chapterNum = chapterNum,
                query = mapOf(
                    "words" to "1",
                    "per_page" to "50",
                    )
            )
        }
}