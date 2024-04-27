package com.mhmdbh.quran.qurani.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mhmdbh.quran.core.common.NavRoutes
import com.mhmdbh.quran.feature.prayer.PrayerScreenRoute

const val prayerNavigationRoute = NavRoutes.prayerRoute

fun NavController.navigateToPrayer(navOptions: NavOptions? = null){
    this.navigate(prayerNavigationRoute, navOptions)
}

fun NavGraphBuilder.prayerScreen(navController: NavController){
    composable(route = prayerNavigationRoute){
        PrayerScreenRoute(
            navController =  navController
        )
    }
}