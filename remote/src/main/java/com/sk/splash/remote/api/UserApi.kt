package com.sk.splash.remote.api

import com.sk.splash.remote.BuildConfig
import com.sk.splash.remote.utils.Constants.PAGE_SIZE
import com.sk.splash.remote.models.RemoteSearch
import com.sk.splash.remote.models.RemoteUser
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("search/users")
    suspend fun searchUsers(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE,
        @Query("client_id") clientId: String = BuildConfig.API_KEY
    ): RemoteSearch<RemoteUser>

}