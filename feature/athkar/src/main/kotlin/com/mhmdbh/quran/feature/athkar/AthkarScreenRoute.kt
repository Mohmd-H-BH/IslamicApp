package com.mhmdbh.Athkar.athkar

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mhmdbh.quran.core.ui.ComingSoon

@Composable
internal fun AthkarScreenRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    //viewModel: AthkarViewModel = hiltViewModel()
) {

    //val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    AthkarScreen(
        //AthkarUiState: uiState,
        modifier = modifier,
        navController,
    )
}

@Composable
internal fun AthkarScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    ComingSoon()
}