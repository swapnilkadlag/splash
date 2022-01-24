package com.sk.splash.remote.api

import com.sk.splash.remote.BuildConfig
import com.sk.splash.remote.utils.Constants.PAGE_SIZE
import com.sk.splash.remote.models.RemotePhoto
import com.sk.splash.remote.models.RemoteSearch
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoApi {
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE,
        @Query("order_by") orderBy: String,
        @Query("client_id") clientId: String = BuildConfig.API_KEY
    ): List<RemotePhoto>

    @GET("photos/{id}")
    suspend fun getPhoto(
        @Path("id") id: String,
        @Query("client_id") client_id: String = BuildConfig.API_KEY
    ): RemotePhoto

    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE,
        @Query("client_id") client_id: String = BuildConfig.API_KEY
    ): RemoteSearch<RemotePhoto>

    @GET("collections/{id}/photos")
    suspend fun getCollectionPhotos(
        @Path("id") id: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE,
        @Query("client_id") clientId: String = BuildConfig.API_KEY
    ): List<RemotePhoto>

    @GET("users/{username}/likes")
    suspend fun getLikedPhotos(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE,
        @Query("client_id") clientId: String = BuildConfig.API_KEY
    ): List<RemotePhoto>

    @GET("users/{username}/photos")
    suspend fun getUploadedPhotos(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE,
        @Query("client_id") clientId: String = BuildConfig.API_KEY
    ): List<RemotePhoto>
}