package com.sk.splash.data.models

sealed class UIResult<out T> {

    class Success<T>(val data: T) : UIResult<T>()

    class Error(val exception: Exception) : UIResult<Nothing>()
}