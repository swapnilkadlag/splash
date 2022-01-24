package com.sk.splash.remote.models

sealed class RemoteResult<out T> {

    class Success<T>(val data: T) : RemoteResult<T>()

    class Error(val exception: Exception) : RemoteResult<Nothing>()
}