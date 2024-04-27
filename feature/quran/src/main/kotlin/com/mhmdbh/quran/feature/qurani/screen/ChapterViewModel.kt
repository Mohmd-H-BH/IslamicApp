package com.mhmdbh.quran.feature.qurani.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhmdbh.quran.core.data.model.Chapter
import com.mhmdbh.quran.core.data.model.Verse
import com.mhmdbh.quran.core.data.network.Result
import com.mhmdbh.quran.core.data.network.asResult
import com.mhmdbh.quran.core.domain.usecase.quran.GetVersesChapterUseCase
import com.mhmdbh.quran.feature.qurani.domain.quran.surah.TempValues
import com.mhmdbh.quran.feature.qurani.navigation.ChapterArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ChapterViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getChapterVersesUseCase: GetVersesChapterUseCase
): ViewModel(){

    private var chapterId: Int? = 1

    init {
        chapterId = ChapterArgs(savedStateHandle).verseId
        TempValues.lastChapterReadIt = chapterId ?: 1
    }

    val surahUiState: StateFlow<SurahUiState> = getChapterVersesUseCase
        .invoke(chapterId ?: 1)
        .asResult()
        .distinctUntilChanged()
        .map { result ->

            when(result){
                Result.Loading -> SurahUiState.Loading
                is Result.Success ->{
                    /*result.data.forEach { verse ->
                        val temp = verse.words.joinToString { it.text }
                        Log.d("TAG", "words= $temp")
                    }*/
                    SurahUiState.Success(
                        chapter = result.data,
                        verses = result.data.verses ?: emptyList()
                    )
                }
                is Result.Error -> SurahUiState.Error(result.exception?.message.toString())
            }


        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = SurahUiState.Loading
        )
}

sealed interface SurahUiState{
    data object Loading: SurahUiState

    data class Success(
        val chapter: Chapter,
        val verses: List<Verse>
    ): SurahUiState

    data class Error(val error: String): SurahUiState
}