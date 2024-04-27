package com.mhmdbh.quran.feature.prayer

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mhmdbh.quran.core.ui.ComingSoon

@Composable
internal fun PrayerScreenRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    //viewModel: QuranViewModel = hiltViewModel()
) {

    //val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    PrayerScreen(
        //quranUiState: uiState,
        modifier = modifier,
        navController,
    )
}

@Composable
internal fun PrayerScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    ComingSoon()
}