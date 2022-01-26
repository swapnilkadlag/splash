package com.sk.splash.data.utils.repository

import com.sk.splash.data.utils.models.*
import com.sk.splash.data.utils.models.Collection
import com.sk.splash.local.entities.LocalCollection
import com.sk.splash.local.entities.LocalPhoto
import com.sk.splash.local.entities.LocalUser
import com.sk.splash.remote.models.*
import com.sk.splash.remote.utils.Constants
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun saveFavouriteUser(user: User)

    suspend fun removeFavouriteUser(username: String)

    fun getFavouriteUsers(): Flow<List<User>>

    suspend fun saveFavouritePhoto(photo: Photo)

    suspend fun removeFavouritePhoto(id: String)

    fun getFavouritePhotos(): Flow<List<Photo>>

    suspend fun saveFavouriteCollection(collection: Collection)

    suspend fun removeFavouriteCollection(id: String)

    fun getFavouriteCollections(): Flow<List<Collection>>

    suspend fun getLatestPhotos(page: Int): Result<List<Photo>>

    suspend fun getPopularPhotos(page: Int): Result<List<Photo>>

    suspend fun searchPhotos(query: String, page: Int): Result<Search<Photo>>

    suspend fun getCollectionPhotos(id: String, page: Int): Result<List<Photo>>

    suspend fun getUploadedPhotos(username: String, page: Int): Result<List<Photo>>

    suspend fun getPhoto(id: String): Result<PhotoDetails>

    suspend fun getFeaturedCollections(page: Int): Result<List<Collection>>

    suspend fun searchCollections(query: String, page: Int): Result<Search<Collection>>

    suspend fun getCreatedCollections(username: String, page: Int): Result<List<Collection>>

    suspend fun getCollection(id: String): Result<CollectionDetails>

    suspend fun searchUsers(query: String, page: Int): Result<Search<User>>

    suspend fun getUser(username: String): Result<UserDetails>
}