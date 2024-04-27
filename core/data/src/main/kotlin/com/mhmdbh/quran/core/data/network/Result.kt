package com.mhmdbh.quran.core.data.network

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: Throwable? = null) : Result<Nothing>
    data object Loading : Result<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<Result<T>> {
    return this
        .map<T, Result<T>> {
            Log.d("Result", "asResult Success: data= $it")
            //delay(5000L)
            Result.Success(it)
        }
        .onStart {
            Log.d("Result", "asResult Loading")
            emit(Result.Loading)
        }
        .catch {
            Log.d("Result", "asResult Error: msg= ${it.message}")
            Log.e("Result", "asResult: ", it)
            emit(Result.Error(it))
        }
}