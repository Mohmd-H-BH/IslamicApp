package com.mhmdbh.quran.feature.qurani

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhmdbh.quran.core.data.model.Chapter
import com.mhmdbh.quran.core.data.network.asResult
import com.mhmdbh.quran.core.domain.usecase.quran.GetQuranChapterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import com.mhmdbh.quran.core.data.network.Result
import com.mhmdbh.quran.feature.qurani.domain.quran.surah.TempValues
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn

@HiltViewModel
class QuranViewModel @Inject constructor(
    private val getQuranChapterUseCase: GetQuranChapterUseCase
) : ViewModel() {

    val quranChapters: StateFlow<QuranUiState> = getQuranChapterUseCase
        .getChapters()
        .asResult()
        .distinctUntilChanged()
        .map { result ->
            when (result) {
                is Result.Error ->
                    QuranUiState.Error(result.exception?.message.toString())

                Result.Loading -> QuranUiState.Loading
                is Result.Success ->
                    QuranUiState.Success(
                        result.data,
                        result.data.find { it.id == TempValues.lastChapterReadIt }
                            ?: Chapter.an_nasir
                    )
            }

        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = QuranUiState.Loading
        )

    fun getLast() = flow<LastChapterUiState> {



        quranChapters
            .map {

                Log.d(TAG, "getLast: quranChapters=${quranChapters.value}")
                Log.d(TAG, "getLast: TempValues.lastChapterReadIt= ${TempValues.lastChapterReadIt}")

                when (val result = it) {
                    is QuranUiState.Error ->  emit(LastChapterUiState.Error(result.error))
                    QuranUiState.Loading -> emit(LastChapterUiState.Loading)
                    is QuranUiState.Success -> emit(LastChapterUiState.Success(
                        result.chapters.find { it.id == TempValues.lastChapterReadIt }
                            ?: Chapter.an_nasir
                    ))
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = LastChapterUiState.Loading
        )

       /* when (val result = quranChapters.value) {
            is QuranUiState.Error ->  emit(LastChapterUiState.Error(result.error))
            QuranUiState.Loading -> emit(LastChapterUiState.Loading)
            is QuranUiState.Success -> emit(LastChapterUiState.Success(
                result.chapters.find { it.id == TempValues.lastChapterReadIt }
                    ?: Chapter.an_nasir
            ))
        }*/
    }

    val lastChapterState: StateFlow<LastChapterUiState> = getLast().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = LastChapterUiState.Loading
    )

    companion object{
        val TAG: String = QuranViewModel::class.java.simpleName
    }
}


sealed interface QuranUiState {

    data object Loading : QuranUiState

    data class Success(
        val chapters: List<Chapter>,
        val lastChapterRead: Chapter
    ) : QuranUiState

    data class Error(val error: String) : QuranUiState
}

sealed interface LastChapterUiState {

    data object Loading : LastChapterUiState

    data class Success(
        val lastChapterRead: Chapter
    ) : LastChapterUiState

    data class Error(val error: String) : LastChapterUiState
}