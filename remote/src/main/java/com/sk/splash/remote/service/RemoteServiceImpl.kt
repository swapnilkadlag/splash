package com.sk.splash.remote.service

import com.sk.splash.remote.api.CollectionApi
import com.sk.splash.remote.api.PhotoApi
import com.sk.splash.remote.api.UserApi
import com.sk.splash.remote.models.*
import com.sk.splash.remote.utils.safeApiCall
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RemoteServiceImpl @Inject constructor(
    private val photoApi: PhotoApi,
    private val collectionApi: CollectionApi,
    private val userApi: UserApi
) : RemoteService {
    override suspend fun getLatestPhotos(
        page: Int,
        perPage: Int,
        orderBy: String
    ): RemoteResult<List<RemotePhoto>> = safeApiCall(Dispatchers.IO) {
        photoApi.getPhotos(page, perPage, orderBy)
    }

    override suspend fun getPopularPhotos(
        page: Int,
        perPage: Int,
        orderBy: String
    ): RemoteResult<List<RemotePhoto>> = safeApiCall(Dispatchers.IO) {
        photoApi.getPhotos(page, perPage, orderBy)
    }

    override suspend fun getPhoto(id: String): RemoteResult<RemotePhoto> =
        safeApiCall(Dispatchers.IO) {
            photoApi.getPhoto(id)
        }

    override suspend fun searchPhotos(
        query: String,
        page: Int,
        perPage: Int
    ): RemoteResult<RemoteSearch<RemotePhoto>> = safeApiCall(Dispatchers.IO) {
        photoApi.searchPhotos(query, page, perPage)
    }

    override suspend fun getCollectionPhotos(
        id: String,
        page: Int,
        perPage: Int
    ): RemoteResult<List<RemotePhoto>> = safeApiCall(Dispatchers.IO) {
        photoApi.getCollectionPhotos(id, page, perPage)
    }


    override suspend fun getLikedPhotos(
        username: String,
        page: Int,
        perPage: Int
    ): RemoteResult<List<RemotePhoto>> = safeApiCall(Dispatchers.IO) {
        photoApi.getLikedPhotos(username, page, perPage)
    }

    override suspend fun getUploadedPhotos(
        username: String,
        page: Int,
        perPage: Int
    ): RemoteResult<List<RemotePhoto>> = safeApiCall(Dispatchers.IO) {
        photoApi.getUploadedPhotos(username, page, perPage)
    }

    override suspend fun getFeaturedCollections(
        page: Int,
        perPage: Int
    ): RemoteResult<List<RemoteCollection>> = safeApiCall(Dispatchers.IO) {
        collectionApi.getFeaturedCollections(page, perPage)
    }

    override suspend fun searchCollections(
        query: String,
        page: Int,
        perPage: Int
    ): RemoteResult<RemoteSearch<RemoteCollection>> = safeApiCall(Dispatchers.IO) {
        collectionApi.searchCollections(query, page, perPage)
    }

    override suspend fun getCreatedCollections(
        username: String,
        page: Int,
        perPage: Int
    ): RemoteResult<List<RemoteCollection>> = safeApiCall(Dispatchers.IO) {
        collectionApi.getCreatedCollections(username, page, perPage)
    }

    override suspend fun searchUsers(
        query: String,
        page: Int,
        perPage: Int
    ): RemoteResult<RemoteSearch<RemoteUser>> = safeApiCall(Dispatchers.IO) {
        userApi.searchUsers(query, page, perPage)
    }
}