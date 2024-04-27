package com.mhmdbh.quran.navigation

import com.mhmdbh.quran.R
import com.mhmdbh.quran.feature.qurani.R as quranR
import com.mhmdbh.quran.feature.onthisday.R as inThisDayR
import com.mhmdbh.quran.feature.prayer.R as prayerR
import com.mhmdbh.quran.feature.athkar.R as athkarR
import com.mhmdbh.quran.feature.bookmark.R as bookmarkR
import com.mhmdbh.quran.core.designsystem.icon.Icon
import com.mhmdbh.quran.core.designsystem.icon.QuranIcons

enum class TabsDestinations(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int,
    val titleTextId: Int,
){

    QURAN(
        selectedIcon = Icon.DrawableResourceIcon(QuranIcons.QuranSelected),
        unselectedIcon = Icon.DrawableResourceIcon(QuranIcons.Quran),
        iconTextId = R.string.app_name,//quranR.string.quran,
        titleTextId = R.string.app_name//quranR.string.quran,
    ),
    IN_THIS_DAY(
        selectedIcon = Icon.DrawableResourceIcon(QuranIcons.InThisDaySelected),
        unselectedIcon = Icon.DrawableResourceIcon(QuranIcons.InThisDay),
        iconTextId = inThisDayR.string.in_this_day,//quranR.string.quran,
        titleTextId = inThisDayR.string.in_this_day//quranR.string.quran,
    ),
    PRAYER(
        selectedIcon = Icon.DrawableResourceIcon(QuranIcons.PrayerSelected),
        unselectedIcon = Icon.DrawableResourceIcon(QuranIcons.Prayer),
        iconTextId = prayerR.string.paryer,//quranR.string.quran,
        titleTextId = prayerR.string.paryer//quranR.string.quran,
    ),
    ATHKAR(
        selectedIcon = Icon.DrawableResourceIcon(QuranIcons.AthkarSelected),
        unselectedIcon = Icon.DrawableResourceIcon(QuranIcons.Athkar),
        iconTextId = athkarR.string.athkar,//quranR.string.quran,
        titleTextId = athkarR.string.athkar//quranR.string.quran,
    ),
    BOOKMARK(
        selectedIcon = Icon.DrawableResourceIcon(QuranIcons.BookmarkSelected),
        unselectedIcon = Icon.DrawableResourceIcon(QuranIcons.Bookmark),
        iconTextId = bookmarkR.string.bookmarks,//quranR.string.quran,
        titleTextId = bookmarkR.string.bookmarks//quranR.string.quran,
    )
}