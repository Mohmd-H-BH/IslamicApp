package com.mhmdbh.quran.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mhmdbh.quran.qurani.navigation.athkarScreen
import com.mhmdbh.quran.qurani.navigation.bookmarkScreen
import com.mhmdbh.quran.qurani.navigation.inThisDayScreen
import com.mhmdbh.quran.qurani.navigation.prayerScreen
import com.mhmdbh.quran.feature.qurani.navigation.quranNavigationRoute
import com.mhmdbh.quran.feature.qurani.navigation.quranScreen

@Composable
fun NavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = quranNavigationRoute
) {
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.padding(start = 16.dp, end = 16.dp),
    ) {
        quranScreen(navController)
        inThisDayScreen(navController)
        prayerScreen(navController)
        athkarScreen(navController)
        bookmarkScreen(navController)
    }
}
