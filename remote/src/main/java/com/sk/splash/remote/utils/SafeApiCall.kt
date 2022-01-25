package com.sk.splash.remote.utils

import com.sk.splash.remote.models.RemoteResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T
): RemoteResult<T> {
    return withContext(dispatcher) {
        try {
            RemoteResult.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> RemoteResult.Error(Exception("Couldn't connect to the internet."))
                is HttpException -> {
                    RemoteResult.Error(Exception(throwable.errorBody))
                }
                else -> RemoteResult.Error(Exception(throwable.message))
            }
        }
    }
}

private val HttpException.errorBody: String?
    get() = try {
        this.response()?.errorBody()?.string()
    } catch (exception: Exception) {
        null
    }