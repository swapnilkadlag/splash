package com.sk.splash.local.service

import androidx.paging.PagingSource
import com.sk.splash.local.db.LocalDatabase
import com.sk.splash.local.entities.LocalCollection
import com.sk.splash.local.entities.LocalPhoto
import com.sk.splash.local.entities.LocalUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalServiceImpl @Inject constructor(
    private val localDatabase: LocalDatabase
) : LocalService {
    override suspend fun saveFavouriteUser(user: LocalUser) = withContext(Dispatchers.IO) {
        localDatabase.userDao().insert(user)
    }

    override suspend fun removeFavouriteUser(username: String) = withContext(Dispatchers.IO) {
        localDatabase.userDao().delete(username)
    }

    override fun getFavouriteUsers(): PagingSource<Int, LocalUser> {
        return localDatabase.userDao().getAll()
    }

    override suspend fun saveFavouritePhoto(photo: LocalPhoto) = withContext(Dispatchers.IO) {
        localDatabase.photoDao().insert(photo)
    }

    override suspend fun removeFavouritePhoto(id: String) = withContext(Dispatchers.IO) {
        localDatabase.photoDao().delete(id)
    }

    override fun getFavouritePhotos(): PagingSource<Int, LocalPhoto> {
        return localDatabase.photoDao().getAll()
    }

    override suspend fun saveFavouriteCollection(collection: LocalCollection) =
        withContext(Dispatchers.IO) {
            localDatabase.collectionDao().insert(collection)
        }

    override suspend fun removeFavouriteCollection(id: String) = withContext(Dispatchers.IO) {
        localDatabase.collectionDao().delete(id)
    }

    override fun getFavouriteCollections(): PagingSource<Int, LocalCollection> {
        return localDatabase.collectionDao().getAll()
    }
}