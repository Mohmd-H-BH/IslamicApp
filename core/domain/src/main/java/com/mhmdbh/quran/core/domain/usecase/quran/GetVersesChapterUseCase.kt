package com.mhmdbh.quran.core.domain.usecase.quran

import com.mhmdbh.quran.core.data.model.Chapter
import com.mhmdbh.quran.core.data.model.Verse
import com.mhmdbh.quran.core.data.repository.quran.QuranRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetVersesChapterUseCase @Inject constructor(
    private val quranRepository: QuranRepository
) {

    operator fun invoke(chapterNum: Int): Flow<Chapter> =
        combine(
            quranRepository.getChapterInfo(chapterNum),
            quranRepository.getVersesByChapter(chapterNum),
            quranRepository.getVersesInArabic(chapterNum),
        ) { chapterInfo, versesByChapter, versesInArabic ->

            Chapter(
                id = chapterInfo.id,
                revelationPlace = chapterInfo.revelationPlace,
                nameSimple = chapterInfo.nameSimple,
                nameComplex = chapterInfo.nameComplex,
                nameArabic = chapterInfo.nameArabic,
                translatedName = chapterInfo.translated_name.name,
                versesCount = chapterInfo.versesCount,
                verses = versesByChapter.verses.map { chapterVerse ->
                    Verse(
                        id = chapterVerse.id,
                        verseNumber = chapterVerse.verseNumber,
                        primary = versesInArabic.verses.find {
                            it.id == chapterVerse.id
                        }?.textUthmani ?: "Not Exist",
                        secondary = chapterVerse.words.joinToString { it.translation.text }
                    )
                },

            )

        }
}