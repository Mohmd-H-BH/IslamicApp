package com.mhmdbh.quran.feature.qurani.domain.quran.surah

import android.os.Parcelable
import com.mhmdbh.quran.core.data.model.Chapter
import kotlinx.parcelize.Parcelize

@Parcelize
data class SurahModel(
    val id: Int,
    val num: Int,
    val engName: String,
    val arName: String,
    val type: String,
    val verses: String,
    val ayahList: List<AyahModel>,
) : Parcelable {
    companion object {

        val dummy = listOf(
            SurahModel(
                1,
                1,
                "Al-Fatiah",
                "الفاتحة",
                "Meccan",
                "7",
                AyahModel.dummyList(13),
            ),
            SurahModel(
                2,
                2,
                "Al-Baqarah",
                "البقرة",
                "Medinian",
                "286",
                AyahModel.dummyList(3),
            ),
            SurahModel(
                3,
                3,
                "Al 'Imran",
                "آل عمران",
                "Meccan",
                "200",
                AyahModel.dummyList(3),
            ),
            SurahModel(
                4,
                4,
                "An-Nisa",
                "النساء",
                "Meccan",
                "176",
                AyahModel.dummyList(3),
            ),
            SurahModel(
                5,
                5,
                "Al-Fatiah",
                "الفاتحة",
                "Meccan",
                "7",
                AyahModel.dummyList(3),
            ),
            SurahModel(
                6,
                6,
                "Al-Baqarah",
                "البقرة",
                "Medinian",
                "286",
                AyahModel.dummyList(3),
            ),
            SurahModel(
                7,
                7,
                "Al 'Imran",
                "آل عمران",
                "Meccan",
                "200",
                AyahModel.dummyList(3),
            ),
            SurahModel(
                8,
                8,
                "An-Nisa",
                "النساء",
                "Meccan",
                "176",
                AyahModel.dummyList(3),
            ),
        )
    }
}

fun Chapter.toSurahModel(): SurahModel =
    SurahModel(
        id = this.id,
        num = this.id,
        arName = nameArabic,
        engName = nameSimple,
        ayahList = emptyList(),
        type = revelationPlace,
        verses = versesCount.toString()
    )
