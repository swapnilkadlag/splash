package com.sk.splash.remote.api

import com.sk.splash.remote.BuildConfig
import com.sk.splash.remote.models.RemoteCollection
import com.sk.splash.remote.utils.Constants.PAGE_SIZE
import com.sk.splash.remote.models.RemoteCollectionDetails
import com.sk.splash.remote.models.RemotePhotoDetails
import com.sk.splash.remote.models.RemoteSearch
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionApi {
    @GET("collections")
    suspend fun getFeaturedCollections(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE,
        @Query("client_id") clientId: String = BuildConfig.API_KEY
    ): List<RemoteCollection>

    @GET("search/collections")
    suspend fun searchCollections(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE,
        @Query("client_id") clientId: String = BuildConfig.API_KEY
    ): RemoteSearch<RemoteCollection>

    @GET("users/{username}/collections")
    suspend fun getCreatedCollections(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE,
        @Query("client_id") clientId: String = BuildConfig.API_KEY
    ): List<RemoteCollection>

    @GET("collections/{id}")
    suspend fun getCollection(
        @Path("id") id: String,
        @Query("client_id") client_id: String = BuildConfig.API_KEY
    ): RemoteCollectionDetails

}