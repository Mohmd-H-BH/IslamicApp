package com.mhmdbh.quran.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.mhmdbh.quran.core.common.NavRoutes
import com.mhmdbh.quran.core.designsystem.component.NavigationBarItem
import com.mhmdbh.quran.core.designsystem.icon.Icon
import com.mhmdbh.quran.core.designsystem.title.AppBarTitle
import com.mhmdbh.quran.navigation.NavHost
import com.mhmdbh.quran.navigation.TabsDestinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuranApp(
    //networkMonitor: NetworkMonitor,
    windowSizeClass: WindowSizeClass,
    appState: QuranState = rememberQuranState(
        //networkMonitor = networkMonitor,
        windowSizeClass = windowSizeClass
    )
) {
    val isOffline by remember { mutableStateOf(false) }
    //val isOffline by appState.isOffline.collectAsStateWithLifecycle()

    val snackBarHostState = remember { SnackbarHostState() }
    val currentDestination = appState.currentDestination
    val destination = appState.currentTopLevelDestination
    val subDestination = appState.currentSubLevelDestination
    val isDestinationBookmark = currentDestination?.route == NavRoutes.bookmarkRoute
    val isDestinationAthkar = currentDestination?.route == NavRoutes.athikarRoute
    val isDestinationSurah = currentDestination?.route == NavRoutes.surahRoute

    Scaffold(
        contentColor = MaterialTheme.colorScheme.onBackground,
        snackbarHost = { SnackbarHost(snackBarHostState) },
        topBar = {
            /*TopAppBar(
                appBarTitle = when {
                    destination != null -> AppBarTitle.StringResourceTitle(destination.titleTextId)
                    subDestination != null -> AppBarTitle.StringTitle(subDestination.title)
                    else -> AppBarTitle.StringTitle("Unknown")
                },
                navController = appState.navController,
                destination = currentDestination
            )*/

            when {
                destination != null /*&& !isDestinationBookmark*/ -> {
                    TopAppBar(
                        appBarTitle = AppBarTitle.StringResourceTitle(destination.titleTextId),
                        navController = appState.navController,
                        destination = currentDestination
                    )
                }

                isDestinationAthkar -> {
                    TopAppBar(
                        navController = appState.navController,
                        destination = currentDestination
                    )
                }

                subDestination != null -> {
                    TopAppBar(
                        appBarTitle = AppBarTitle.StringTitle(subDestination.title),
                        navController = appState.navController,
                        destination = currentDestination
                    )
                }
            }
        },
        bottomBar = {
            if (destination != null)
                BottomBar(
                    destinations = appState.topLevelDestinations.filter { it != TabsDestinations.BOOKMARK },
                    onNavigateToDestination = appState::navigateToSpecificDestination,
                    currentDestination = currentDestination,
                    modifier = Modifier.testTag("home:bottomBar")
                )
            else
                Spacer(modifier = Modifier.size(36.dp))
        },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { padding ->

        Column(Modifier.fillMaxSize()) {


            /*
            when {
                destination != null /*&& !isDestinationBookmark*/ -> {
                    TopAppBar(
                        appBarTitle = AppBarTitle.StringResourceTitle(destination.titleTextId),
                        navController = appState.navController,
                        destination = currentDestination
                    )
                }
                isDestinationAthkar -> {
                    TopAppBar(
                        navController = appState.navController,
                        destination = currentDestination
                    )
                }
                subDestination != null ->{
                    TopAppBar(
                        appBarTitle = AppBarTitle.StringTitle(subDestination.title),
                        navController = appState.navController,
                        destination = currentDestination
                    )
                }*/
        }

        AppNavigation(
            appState = appState,
            padding = padding
        )
    }

    /*val notConnected = stringResource(R.string.no_internet_connection)
    val arPrayerForMyParent = "لا تحرمني من دعائك/ لوالدي"
    val enPrayerForMyParent = "Do not deprive me of your prayers for my parents"

    var haveToShow by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = Unit) {
     haveToShow = true
    }

    if(haveToShow){

        Dialog(onDismissRequest = { haveToShow = false}) {
            Card(shape = RoundedCornerShape(16.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    androidx.compose.material3.Icon(
                        modifier = Modifier.size(44.dp),
                        painter = painterResource(id = Icon.DrawableResourceIcon(QuranIcons.Athkar).id),
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.size(12.dp))
                    Text(text = arPrayerForMyParent, fontFamily = arFontFamily)
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(text = enPrayerForMyParent, textAlign = TextAlign.Center)
                }
            }
        }
    }*/

    /*LaunchedEffect(haveToShow) {
        if (haveToShow) {
            snackBarHostState.showSnackbar(
                message = prayerForMyParent,
                duration = SnackbarDuration.Long
            )
        }
    }*/

}

@Composable
private fun BottomBar(
    destinations: List<TabsDestinations>,
    onNavigateToDestination: (TabsDestinations) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            NavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }
                    when (icon) {
                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null
                        )

                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(id = icon.id),
                            contentDescription = null
                        )
                    }
                },
                label = { Text(stringResource(destination.iconTextId)) }
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AppNavigation(appState: QuranState, padding: PaddingValues) {
    NavHost(
        navController = appState.navController,
        modifier = Modifier
            .padding(padding)
            .consumeWindowInsets(padding)
    )
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TabsDestinations) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
