package com.mhmdbh.quran.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.util.trace
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.mhmdbh.quran.feature.qurani.navigation.getSurahData
import com.mhmdbh.quran.navigation.TabsDestinations
import com.mhmdbh.quran.qurani.navigation.athkarNavigationRoute
import com.mhmdbh.quran.qurani.navigation.inThisDayRouteNavigationRoute
import com.mhmdbh.quran.qurani.navigation.navigateToAthkar
import com.mhmdbh.quran.qurani.navigation.navigateToBookmark
import com.mhmdbh.quran.qurani.navigation.navigateToInThisDay
import com.mhmdbh.quran.qurani.navigation.navigateToPrayer
import com.mhmdbh.quran.feature.qurani.navigation.navigateToQuran
import com.mhmdbh.quran.qurani.navigation.prayerNavigationRoute
import com.mhmdbh.quran.feature.qurani.navigation.quranNavigationRoute
import com.mhmdbh.quran.feature.qurani.navigation.surahScreenRoute
import com.mhmdbh.quran.navigation.SubDestination
import com.mhmdbh.quran.qurani.navigation.bookmarkRouteNavigationRoute
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberQuranState(
    windowSizeClass: WindowSizeClass,
    //networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): QuranState {
    //NavigationTrackingSideEffect(navController)
    return remember(navController, coroutineScope, windowSizeClass, /*networkMonitor*/) {
        QuranState(navController, coroutineScope, windowSizeClass, /*networkMonitor*/)
    }
}

@Stable
class QuranState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass,
    //networkMonitor: NetworkMonitor
) {

    private val currentBackStackEntry: NavBackStackEntry?
        @Composable get() = navController.currentBackStackEntryAsState().value

    val currentDestination: NavDestination?
        @Composable get() = currentBackStackEntry?.destination

    val topLevelDestinations: List<TabsDestinations> = TabsDestinations.entries

    val currentTopLevelDestination: TabsDestinations?
        @Composable get() = when (currentDestination?.route) {
            quranNavigationRoute -> TabsDestinations.QURAN
            inThisDayRouteNavigationRoute -> TabsDestinations.IN_THIS_DAY
            prayerNavigationRoute -> TabsDestinations.PRAYER
            athkarNavigationRoute -> TabsDestinations.ATHKAR
            bookmarkRouteNavigationRoute -> TabsDestinations.BOOKMARK
            else -> null
        }
    val currentSubLevelDestination: SubDestination?
        @Composable get() = when (currentDestination?.route) {

            surahScreenRoute -> SubDestination.Surah(
                ///currentDestination?.arguments.get("")?.type
                navController.getSurahData() ?: "Unknown AppBar"
            )
            else -> null
        }

    /*val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )*/

    fun navigateToSpecificDestination(topLevelDestination: TabsDestinations) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }

            when (topLevelDestination) {
                TabsDestinations.QURAN -> navController.navigateToQuran(topLevelNavOptions)
                TabsDestinations.IN_THIS_DAY -> navController.navigateToInThisDay(topLevelNavOptions)
                TabsDestinations.PRAYER -> navController.navigateToPrayer(topLevelNavOptions)
                TabsDestinations.ATHKAR -> navController.navigateToAthkar(topLevelNavOptions)
                TabsDestinations.BOOKMARK -> navController.navigateToBookmark(topLevelNavOptions)
            }
        }
    }
}

/*@Composable
private fun NavigationTrackingSideEffect(navController: NavHostController) {
    TrackDisposableJank(navController) { metricsHolder ->
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            metricsHolder.state?.putState("Navigation", destination.route.toString())
        }

        navController.addOnDestinationChangedListener(listener)

        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }
}*/
