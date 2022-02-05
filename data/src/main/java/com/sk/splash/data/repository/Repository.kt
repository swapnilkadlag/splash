package com.sk.splash.data.repository

import androidx.paging.PagingData
import com.sk.splash.data.models.*
import com.sk.splash.data.models.UICollection
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun saveFavouriteUser(user: UIUser)

    suspend fun removeFavouriteUser(username: String)

    fun getFavouriteUsers(): Flow<List<UIUser>>

    suspend fun saveFavouritePhoto(photo: UIPhoto)

    suspend fun removeFavouritePhoto(id: String)

    fun getFavouritePhotos(): Flow<List<UIPhoto>>

    suspend fun saveFavouriteCollection(collection: UICollection)

    suspend fun removeFavouriteCollection(id: String)

    fun getFavouriteCollections(): Flow<List<UICollection>>

    fun getLatestPhotos(): Flow<PagingData<UIPhoto>>

    fun getPopularPhotos(): Flow<PagingData<UIPhoto>>

    fun searchPhotos(query: String): Flow<PagingData<UIPhoto>>

    fun getCollectionPhotos(id: String): Flow<PagingData<UIPhoto>>

    fun getUploadedPhotos(username: String): Flow<PagingData<UIPhoto>>

    suspend fun getPhoto(id: String): UIResult<UIPhotoDetails>

    fun getFeaturedCollections(): Flow<PagingData<UICollection>>

    fun searchCollections(query: String): Flow<PagingData<UICollection>>

    fun getCreatedCollections(username: String): Flow<PagingData<UICollection>>

    suspend fun getCollection(id: String): UIResult<UICollectionDetails>

    fun searchUsers(query: String): Flow<PagingData<UIUser>>

    suspend fun getUser(username: String): UIResult<UIUserDetails>
}