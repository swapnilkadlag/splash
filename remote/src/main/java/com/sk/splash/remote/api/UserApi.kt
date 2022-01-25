package com.sk.splash.remote.api

import com.sk.splash.remote.BuildConfig
import com.sk.splash.remote.models.RemoteSearch
import com.sk.splash.remote.models.RemoteUser
import com.sk.splash.remote.models.RemoteUserDetails
import com.sk.splash.remote.utils.Constants.PAGE_SIZE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {
    @GET("search/users")
    suspend fun searchUsers(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE,
        @Query("client_id") clientId: String = BuildConfig.API_KEY
    ): RemoteSearch<RemoteUser>

    @GET("users/{username}")
    suspend fun getUser(
        @Path("username") username: String,
        @Query("client_id") client_id: String = BuildConfig.API_KEY
    ): RemoteUserDetails

}