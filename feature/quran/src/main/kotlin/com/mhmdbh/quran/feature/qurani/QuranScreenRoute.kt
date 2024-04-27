package com.mhmdbh.quran.feature.qurani

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mhmdbh.quran.core.data.model.Chapter
import com.mhmdbh.quran.core.designsystem.theme.QuranTheme
import com.mhmdbh.quran.core.ui.DevicePreviews
import com.mhmdbh.quran.core.ui.component.CircularProgressBar
import com.mhmdbh.quran.feature.qurani.domain.quran.surah.SurahModel
import com.mhmdbh.quran.feature.qurani.navigation.navigateToChapter
import com.mhmdbh.quran.feature.qurani.ui.LastReadCard
import com.mhmdbh.quran.feature.qurani.ui.ChapterItem

@Composable
internal fun QuranScreenRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: QuranViewModel = hiltViewModel()
) {

    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner) {
        val tempLifeObserver = LifecycleEventObserver { source, event ->
            Log.d("TAG", "QuranScreenRoute: event= $event")
            Log.d("TAG", "QuranScreenRoute: event.targetState= ${event.targetState}")
            Log.d("TAG", "QuranScreenRoute: event.name= ${event.name}")
        }
        lifecycleOwner.lifecycle.addObserver(tempLifeObserver)
//
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(tempLifeObserver)
        }
    }

    val quranUiState by viewModel.quranChapters.collectAsStateWithLifecycle(
        lifecycle = lifecycleOwner.lifecycle,
        minActiveState = Lifecycle.State.CREATED
    )

    QuranScreen(
        modifier = modifier,
        navController,
        quranUiState = quranUiState,//viewModel.quranChapters.value,
        //lastChapterState = lastChapterState
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
internal fun QuranScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    quranUiState: QuranUiState,
    //lastChapterState: LastChapterUiState
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState()),

        ) {

        Text(
            text = "Asslamualaikum",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "Mohammad BaniHani",
            style = MaterialTheme.typography.headlineMedium
        )

        when(quranUiState){
            QuranUiState.Loading ->{

                CircularProgressBar(
                    modifier = modifier
                        .padding(46.dp)
                        //.height(260.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
            is QuranUiState.Success ->{
                LastReadCard(
                    surah = quranUiState.lastChapterRead.nameSimple,
                    ayah  =  quranUiState.lastChapterRead.id.toString()
                ) {
                    navController.navigateToChapter(
                        surahId = quranUiState.lastChapterRead.id,
                        chapterName = quranUiState.lastChapterRead.nameSimple
                    )
                }
            }
            is QuranUiState.Error->{}
        }


        val tabsList = listOf(
            "Surah",
            "Para",
            "Page",
            "Hijb",
        )

        var currentTabIndex by remember { mutableIntStateOf(0) }

        PrimaryTabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = currentTabIndex
        ) {
            tabsList.forEachIndexed { index, tab ->

                Tab(
                    text = {
                        Text(
                            text = tab,
                            color = if (currentTabIndex == index)
                                MaterialTheme.colorScheme.onSecondary
                            else
                                MaterialTheme.colorScheme.secondary,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    selected = index == currentTabIndex,
                    onClick = {
                        currentTabIndex = index
                    }
                )
            }
        }

        val surahList = SurahModel.dummy

        Spacer(modifier = Modifier.size(16.dp))

        when (quranUiState) {
            //is QuranUiState.Error -> {}
            QuranUiState.Loading -> {
                CircularProgressBar(
                    modifier = modifier
                        .height(260.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            is QuranUiState.Success -> {

                FlowRow(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    quranUiState.chapters.forEachIndexed { index, chapter ->

                        ChapterItem(
                            chapter = chapter
                        ) {
                            navController.navigateToChapter(
                                chapter.id,
                                chapter.nameSimple
                            )
                        }

                        if (index != surahList.size - 1) {
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(MaterialTheme.colorScheme.secondary.copy(0.3f))
                            )
                        }
                    }

                }
            }

            else -> {}
        }
    }
}

@DevicePreviews
@Composable
fun QuranScreenPreview() {
    QuranTheme {
        QuranScreen(
            navController = rememberNavController(),
            quranUiState = QuranUiState.Loading,
            //lastChapterState = LastChapterUiState.Loading
        )

    }
}