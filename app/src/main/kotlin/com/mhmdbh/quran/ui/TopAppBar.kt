package com.mhmdbh.quran.ui

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mhmdbh.quran.R
import com.mhmdbh.quran.core.common.NavRoutes
import com.mhmdbh.quran.core.designsystem.icon.Icon
import com.mhmdbh.quran.core.designsystem.icon.QuranIcons
import com.mhmdbh.quran.core.designsystem.theme.QuranTheme
import com.mhmdbh.quran.core.designsystem.title.AppBarTitle
import com.mhmdbh.quran.qurani.navigation.navigateToBookmark


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    //@StringRes title: Int = R.string.app_name,
    appBarTitle: AppBarTitle = AppBarTitle.StringResourceTitle(R.string.app_name),
    navController: NavHostController,
    destination: NavDestination?
) {
    val isCurrentRouteQuran = destination?.route == NavRoutes.quranRoute
    TopAppBar(
        title = {
            Text(
                text = when(appBarTitle){
                    is AppBarTitle.StringResourceTitle -> stringResource(id = appBarTitle.id)
                    is AppBarTitle.StringTitle -> appBarTitle.title
                },
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.titleLarge
            )
        },
        modifier = modifier.fillMaxWidth(),
        navigationIcon = {
            if (!isCurrentRouteQuran) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = "Back"
                    )
                }
            } else {
                val context = LocalContext.current
                IconButton(onClick = {
                    Toast.makeText(context, "Menu Coming Soon", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = null
                    )
                }
            }
        },
        actions = {

            if (isCurrentRouteQuran) {
                IconButton(onClick = { navController.navigateToBookmark() }) {
                    Icon(
                        painter = painterResource(Icon.DrawableResourceIcon(QuranIcons.Bookmark).id),
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun TopAppBarPreview() {
    val navController = rememberNavController()
    QuranTheme {
        TopAppBar(
            appBarTitle = AppBarTitle.StringResourceTitle(android.R.string.untitled),
            navController = navController,
            destination = null,
            //actions = {}
        )
    }
}
