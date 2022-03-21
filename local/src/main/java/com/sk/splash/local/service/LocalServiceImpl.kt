package com.sk.splash.local.service

import androidx.paging.PagingSource
import com.sk.splash.local.db.LocalDatabase
import com.sk.splash.local.entities.LocalCollection
import com.sk.splash.local.entities.LocalPhoto
import com.sk.splash.local.entities.LocalUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalServiceImpl @Inject constructor(
    private val localDatabase: LocalDatabase
) : LocalService {
    override suspend fun saveUser(user: LocalUser) = withContext(Dispatchers.IO) {
        localDatabase.userDao().insert(user)
    }

    override suspend fun removeUser(username: String) = withContext(Dispatchers.IO) {
        localDatabase.userDao().delete(username)
    }

    override suspend fun getUser(username: String) = withContext(Dispatchers.IO) {
        localDatabase.userDao().get(username)
    }

    override fun getUsers(): PagingSource<Int, LocalUser> {
        return localDatabase.userDao().getAll()
    }

    override suspend fun savePhoto(photo: LocalPhoto) = withContext(Dispatchers.IO) {
        localDatabase.photoDao().insert(photo)
    }

    override suspend fun removePhoto(id: String) = withContext(Dispatchers.IO) {
        localDatabase.photoDao().delete(id)
    }

    override suspend fun getPhoto(id: String) = withContext(Dispatchers.IO) {
        localDatabase.photoDao().get(id)
    }

    override fun getPhotos(): PagingSource<Int, LocalPhoto> {
        return localDatabase.photoDao().getAll()
    }

    override suspend fun saveCollection(collection: LocalCollection) =
        withContext(Dispatchers.IO) {
            localDatabase.collectionDao().insert(collection)
        }

    override suspend fun removeCollection(id: String) = withContext(Dispatchers.IO) {
        localDatabase.collectionDao().delete(id)
    }

    override suspend fun getCollection(id: String) = withContext(Dispatchers.IO) {
        localDatabase.collectionDao().get(id)
    }

    override fun getCollections(): PagingSource<Int, LocalCollection> {
        return localDatabase.collectionDao().getAll()
    }
}