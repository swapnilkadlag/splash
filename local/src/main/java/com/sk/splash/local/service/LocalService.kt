package com.sk.splash.local.service

import androidx.paging.PagingSource
import com.sk.splash.local.entities.LocalCollection
import com.sk.splash.local.entities.LocalPhoto
import com.sk.splash.local.entities.LocalUser
import kotlinx.coroutines.flow.Flow

interface LocalService {

    suspend fun saveUser(user: LocalUser)

    suspend fun removeUser(username: String)

    suspend fun getUser(username: String): LocalUser?

    fun getUsers(): PagingSource<Int, LocalUser>

    suspend fun savePhoto(photo: LocalPhoto)

    suspend fun removePhoto(id: String)

    suspend fun getPhoto(id: String): LocalPhoto?

    fun getPhotos(): PagingSource<Int, LocalPhoto>

    suspend fun saveCollection(collection: LocalCollection)

    suspend fun removeCollection(id: String)

    suspend fun getCollection(id: String): LocalCollection?

    fun getCollections(): PagingSource<Int, LocalCollection>
}