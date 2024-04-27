package com.mhmdbh.quran.feature.onBoarding.domian

import androidx.annotation.DrawableRes
import com.mhmdbh.quran.core.designsystem.icon.Icon
import com.mhmdbh.quran.feature.onBoarding.R
import com.mhmdbh.quran.core.designsystem.R as designSysR



data class BoardModel(
    val id: Int,
    val title: String,
    val icon: Icon
){

    companion object{

        val default = listOf(
            BoardModel(
                id = 1,
                title = "Learn Quran and Recite once everyday",
                icon = Icon.DrawableResourceIcon(designSysR.drawable.ic_quran)
            ),
            BoardModel(
                id = 2,
                title = "Know what is happened in this day",
                icon = Icon.DrawableResourceIcon(designSysR.drawable.ic_in_this_day)
            ),
            BoardModel(
                id = 3,
                title = "Get the prayer times, where you are",
                icon = Icon.DrawableResourceIcon(designSysR.drawable.ic_prayer)
            ),
               BoardModel(
                id = 4,
                title = "Al Athkar for all muslims",
                icon = Icon.DrawableResourceIcon(designSysR.drawable.ic_athkar)
            ),
        )
    }
}
