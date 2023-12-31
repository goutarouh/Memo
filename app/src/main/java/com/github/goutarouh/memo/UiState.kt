package com.github.goutarouh.memo

sealed interface UiState<out T> {
    object Loading: UiState<Nothing>
    data class Success<T>(val data: T): UiState<T>
    data class Error(val throwable: Throwable): UiState<Nothing>
}