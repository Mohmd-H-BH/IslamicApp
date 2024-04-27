package com.mhmdbh.quran.feature.qurani.domain.quran.surah

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AyahModel(
    val id: Int,
    val num: Int,
    val primaryContent: String,
    val secondaryContent: String,
):Parcelable{

    companion object{
        val dummy = AyahModel(
            id = 1,
            num = 1,
            primaryContent = "الرحمن",
            secondaryContent = "Al-Rahman"
        )

        fun dummyList(size: Int): List<AyahModel>{

            val temp = mutableListOf<AyahModel>()
            repeat(size){
                temp.add(dummy.copy(num = it+1))
            }
            return temp
        }
    }


}
