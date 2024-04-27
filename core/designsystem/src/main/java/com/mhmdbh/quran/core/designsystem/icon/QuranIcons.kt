package com.mhmdbh.quran.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.mhmdbh.quran.core.designsystem.R

object QuranIcons {

    val Quran: Int = R.drawable.ic_quran
    val QuranSelected = R.drawable.ic_quran_selected

    val InThisDay = R.drawable.ic_in_this_day
    val InThisDaySelected = R.drawable.ic_in_this_day_selected

    val Prayer = R.drawable.ic_prayer
    val PrayerSelected = R.drawable.ic_prayer_selected

    val Athkar = R.drawable.ic_athkar
    val AthkarSelected = R.drawable.ic_athkar_selected

    val Bookmark = R.drawable.ic_bookmark
    val BookmarkSelected = R.drawable.ic_bookmark_selected
}

sealed class Icon{

    data class ImageVectorIcon( val imageVector: ImageVector): Icon()
    data class DrawableResourceIcon( @DrawableRes val id: Int): Icon()
}