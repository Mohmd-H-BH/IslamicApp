package com.mhmdbh.quran.qurani.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mhmdbh.quran.core.common.NavRoutes
import com.mhmdbh.quran.feature.bookmark.BookmarkScreenRoute

const val bookmarkRouteNavigationRoute = NavRoutes.bookmarkRoute

fun NavController.navigateToBookmark(navOptions: NavOptions? = null){
    this.navigate(bookmarkRouteNavigationRoute, navOptions)
}

fun NavGraphBuilder.bookmarkScreen(navController: NavController){
    composable(route = bookmarkRouteNavigationRoute){
        BookmarkScreenRoute(
            navController =  navController
        )
    }
}