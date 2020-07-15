package com.acemirr.medium_clean_architecture.data.utils

sealed class DataState<T> {
    data class Success<T>(val data: T) : DataState<T>()
    data class Error<T>(val error: Throwable) : DataState<T>()
}