package com.mhmdbh.quran.feature.bookmark

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mhmdbh.quran.core.ui.ComingSoon

@Composable
internal fun BookmarkScreenRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    //viewModel: QuranViewModel = hiltViewModel()
) {

    //val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    BookmarkScreen(
        //quranUiState: uiState,
        modifier = modifier,
        navController,
    )
}

@Composable
internal fun BookmarkScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    ComingSoon()
}