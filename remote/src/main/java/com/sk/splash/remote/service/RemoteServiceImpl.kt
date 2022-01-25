package com.sk.splash.remote.service

import com.sk.splash.remote.api.CollectionApi
import com.sk.splash.remote.api.PhotoApi
import com.sk.splash.remote.api.UserApi
import com.sk.splash.remote.models.*
import com.sk.splash.remote.utils.safeApiCall
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RemoteServiceImpl(
    private val photoApi: PhotoApi,
    private val collectionApi: CollectionApi,
    private val userApi: UserApi
) : RemoteService {
    override suspend fun getLatestPhotos(
        page: Int,
        perPage: Int,
    ): RemoteResult<List<RemotePhoto>> = safeApiCall {
        photoApi.getPhotos(page, perPage, "latest")
    }

    override suspend fun getPopularPhotos(
        page: Int,
        perPage: Int,
    ): RemoteResult<List<RemotePhoto>> = safeApiCall {
        photoApi.getPhotos(page, perPage, "popular")
    }

    override suspend fun searchPhotos(
        query: String,
        page: Int,
        perPage: Int
    ): RemoteResult<RemoteSearch<RemotePhoto>> = safeApiCall {
        photoApi.searchPhotos(query, page, perPage)
    }

    override suspend fun getCollectionPhotos(
        id: String,
        page: Int,
        perPage: Int
    ): RemoteResult<List<RemotePhoto>> = safeApiCall {
        photoApi.getCollectionPhotos(id, page, perPage)
    }

    override suspend fun getUploadedPhotos(
        username: String,
        page: Int,
        perPage: Int
    ): RemoteResult<List<RemotePhoto>> = safeApiCall {
        photoApi.getCollectionPhotos(username, page, perPage)
    }

    override suspend fun getPhoto(
        id: String,
    ): RemoteResult<RemotePhotoDetails> = safeApiCall {
        photoApi.getPhoto(id)
    }

    override suspend fun getFeaturedCollections(
        page: Int,
        perPage: Int
    ): RemoteResult<List<RemoteCollection>> = safeApiCall {
        collectionApi.getFeaturedCollections(page, perPage)
    }

    override suspend fun searchCollections(
        query: String,
        page: Int,
        perPage: Int
    ): RemoteResult<RemoteSearch<RemoteCollection>> = safeApiCall {
        collectionApi.searchCollections(query, page, perPage)
    }

    override suspend fun getCreatedCollections(
        username: String,
        page: Int,
        perPage: Int
    ): RemoteResult<List<RemoteCollection>> = safeApiCall {
        collectionApi.getCreatedCollections(username, page, perPage)
    }

    override suspend fun getCollection(
        id: String,
    ): RemoteResult<RemoteCollectionDetails> = safeApiCall {
        collectionApi.getCollection(id)
    }

    override suspend fun searchUsers(
        query: String,
        page: Int,
        perPage: Int
    ): RemoteResult<RemoteSearch<RemoteUser>> = safeApiCall {
        userApi.searchUsers(query, page, perPage)
    }

    override suspend fun getUser(
        username: String,
    ): RemoteResult<RemoteUserDetails> = safeApiCall {
        userApi.getUser(username)
    }
}