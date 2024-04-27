package com.mhmdbh.quran.qurani.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mhmdbh.Athkar.athkar.AthkarScreenRoute
import com.mhmdbh.quran.core.common.NavRoutes

const val athkarNavigationRoute = NavRoutes.athikarRoute

fun NavController.navigateToAthkar(navOptions: NavOptions? = null){
    this.navigate(athkarNavigationRoute, navOptions)
}

fun NavGraphBuilder.athkarScreen(navController: NavController){
    composable(route = athkarNavigationRoute){
        AthkarScreenRoute(
            navController =  navController
        )
    }
}