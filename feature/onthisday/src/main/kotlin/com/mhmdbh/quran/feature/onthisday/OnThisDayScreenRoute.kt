package com.mhmdbh.quran.feature.onthisday

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mhmdbh.quran.core.ui.ComingSoon

@Composable
internal fun OnThisDayScreenRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    //viewModel: QuranViewModel = hiltViewModel()
) {

    //val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    OnThisDayScreen(
        //quranUiState: uiState,
        modifier = modifier,
        navController,
    )
}

@Composable
internal fun OnThisDayScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    ComingSoon()

}