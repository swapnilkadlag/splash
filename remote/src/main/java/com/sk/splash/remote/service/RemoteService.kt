package com.sk.splash.remote.service

import com.sk.splash.remote.utils.Constants
import com.sk.splash.remote.models.*

interface RemoteService {
    suspend fun getLatestPhotos(
        page: Int,
        perPage: Int = Constants.PAGE_SIZE,
        orderBy: String = "latest",
    ): RemoteResult<List<RemotePhoto>>

    suspend fun getPopularPhotos(
        page: Int,
        perPage: Int = Constants.PAGE_SIZE,
        orderBy: String = "popular",
    ): RemoteResult<List<RemotePhoto>>

    suspend fun getPhoto(
        id: String,
    ): RemoteResult<RemotePhoto>

    suspend fun searchPhotos(
        query: String,
        page: Int,
        perPage: Int = Constants.PAGE_SIZE,
    ): RemoteResult<RemoteSearch<RemotePhoto>>

    suspend fun getCollectionPhotos(
        id: String,
        page: Int,
        perPage: Int = Constants.PAGE_SIZE,
    ): RemoteResult<List<RemotePhoto>>

    suspend fun getLikedPhotos(
        username: String,
        page: Int,
        perPage: Int = Constants.PAGE_SIZE,
    ): RemoteResult<List<RemotePhoto>>

    suspend fun getUploadedPhotos(
        username: String,
        page: Int,
        perPage: Int = Constants.PAGE_SIZE,
    ): RemoteResult<List<RemotePhoto>>

    suspend fun getFeaturedCollections(
        page: Int,
        perPage: Int = Constants.PAGE_SIZE
    ): RemoteResult<List<RemoteCollection>>

    suspend fun searchCollections(
        query: String,
        page: Int,
        perPage: Int = Constants.PAGE_SIZE,
    ): RemoteResult<RemoteSearch<RemoteCollection>>

    suspend fun getCreatedCollections(
        username: String,
        page: Int,
        perPage: Int = Constants.PAGE_SIZE,
    ): RemoteResult<List<RemoteCollection>>

    suspend fun searchUsers(
        query: String,
        page: Int,
        perPage: Int = Constants.PAGE_SIZE,
    ): RemoteResult<RemoteSearch<RemoteUser>>
}