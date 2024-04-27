package com.mhmdbh.quran.core.domain.usecase.quran

import com.mhmdbh.quran.core.data.model.Chapter
import com.mhmdbh.quran.core.data.repository.quran.QuranRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetQuranChapterUseCaseImpl @Inject constructor(
    private val quranRepository: QuranRepository
) : GetQuranChapterUseCase {

    override fun getChapters(): Flow<List<Chapter>> {

        return quranRepository.getChapters().map { chap ->

            chap.map { networkChapter ->
                Chapter(
                    networkChapter.id,
                    revelationPlace = networkChapter.revelationPlace,
                    nameSimple = networkChapter.nameSimple,
                    nameComplex = networkChapter.nameComplex,
                    nameArabic = networkChapter.nameArabic,
                    translatedName = networkChapter.translated_name.name,
                    versesCount = networkChapter.versesCount
                )
            }
        }
    }
}