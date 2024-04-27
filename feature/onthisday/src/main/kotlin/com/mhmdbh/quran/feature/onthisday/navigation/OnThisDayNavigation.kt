package com.mhmdbh.quran.qurani.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mhmdbh.quran.core.common.NavRoutes
import com.mhmdbh.quran.feature.onthisday.OnThisDayScreenRoute

const val inThisDayRouteNavigationRoute = NavRoutes.onThisDayRoute

fun NavController.navigateToInThisDay(navOptions: NavOptions? = null){
    this.navigate(inThisDayRouteNavigationRoute, navOptions)
}

fun NavGraphBuilder.inThisDayScreen(navController: NavController){
    composable(route = inThisDayRouteNavigationRoute){
        OnThisDayScreenRoute(
            navController =  navController
        )
    }
}