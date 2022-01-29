package com.sk.splash.data.utils.repository

import com.sk.splash.data.utils.models.*
import com.sk.splash.data.utils.models.UICollection
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

    suspend fun getLatestPhotos(page: Int): UIResult<List<UIPhoto>>

    suspend fun getPopularPhotos(page: Int): UIResult<List<UIPhoto>>

    suspend fun searchPhotos(query: String, page: Int): UIResult<UISearch<UIPhoto>>

    suspend fun getCollectionPhotos(id: String, page: Int): UIResult<List<UIPhoto>>

    suspend fun getUploadedPhotos(username: String, page: Int): UIResult<List<UIPhoto>>

    suspend fun getPhoto(id: String): UIResult<UIPhotoDetails>

    suspend fun getFeaturedCollections(page: Int): UIResult<List<UICollection>>

    suspend fun searchCollections(query: String, page: Int): UIResult<UISearch<UICollection>>

    suspend fun getCreatedCollections(username: String, page: Int): UIResult<List<UICollection>>

    suspend fun getCollection(id: String): UIResult<UICollectionDetails>

    suspend fun searchUsers(query: String, page: Int): UIResult<UISearch<UIUser>>

    suspend fun getUser(username: String): UIResult<UIUserDetails>
}