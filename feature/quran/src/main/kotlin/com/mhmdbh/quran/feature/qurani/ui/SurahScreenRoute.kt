package com.mhmdbh.quran.feature.qurani.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mhmdbh.quran.core.data.model.Chapter
import com.mhmdbh.quran.core.data.model.Verse
import com.mhmdbh.quran.core.designsystem.theme.QuranTheme
import com.mhmdbh.quran.core.ui.DevicePreviews
import com.mhmdbh.quran.core.ui.component.CircularProgressBar
import com.mhmdbh.quran.feature.qurani.screen.SurahUiState
import com.mhmdbh.quran.feature.qurani.screen.ChapterViewModel
import com.mhmdbh.quran.feature.qurani.ui.surah.VerseItem
import com.mhmdbh.quran.feature.qurani.ui.surah.SurahCard

@Composable
internal fun SurahScreenRoute(
    navController: NavController
) {
    val viewModel: ChapterViewModel = hiltViewModel()
    val state by viewModel.surahUiState.collectAsStateWithLifecycle()
    SurahScreen(
        navController = navController,
        surahUiState = state,
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun SurahScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    surahUiState: SurahUiState
) {

    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {

        when (surahUiState) {
            is SurahUiState.Success -> SurahCard(
                modifier = Modifier,
                chapter = surahUiState.chapter
            )
            else -> {}
        }

        when (surahUiState) {
            SurahUiState.Loading ->
                CircularProgressBar(
                    modifier = modifier.align(Alignment.CenterHorizontally)
                )

            is SurahUiState.Success -> {

                FlowRow(
                    verticalArrangement = Arrangement.spacedBy(12.dp),

                    ) {
                    surahUiState.verses.forEach {
                        VerseItem(verse = it)
                    }
                }
            }

            is SurahUiState.Error -> Column(modifier.fillMaxSize()) {

                Text(
                    text = surahUiState.error,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@DevicePreviews
@Composable
private fun SurahScreenPreview() {
    QuranTheme {
        SurahScreen(
            navController = rememberNavController(),
            surahUiState = SurahUiState.Success(
                chapter = Chapter.dummy,
                verses = Verse.dummyList
            )
        )
    }
}