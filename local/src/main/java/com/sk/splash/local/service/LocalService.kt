package com.sk.splash.local.service

import com.sk.splash.local.entities.LocalCollection
import com.sk.splash.local.entities.LocalPhoto
import com.sk.splash.local.entities.LocalUser
import kotlinx.coroutines.flow.Flow

interface LocalService {

    suspend fun saveFavouriteUser(user: LocalUser)

    suspend fun removeFavouriteUser(username: String)

    fun getFavouriteUsers(): Flow<List<LocalUser>>

    suspend fun saveFavouritePhoto(photo: LocalPhoto)

    suspend fun removeFavouritePhoto(id: String)

    fun getFavouritePhotos(): Flow<List<LocalPhoto>>

    suspend fun saveFavouriteCollection(collection: LocalCollection)

    suspend fun removeFavouriteCollection(id: String)

    fun getFavouriteCollections(): Flow<List<LocalCollection>>
}