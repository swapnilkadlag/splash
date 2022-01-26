package com.sk.splash.data.utils.repository

import com.sk.splash.data.utils.mappers.*
import com.sk.splash.data.utils.models.*
import com.sk.splash.data.utils.models.Collection
import com.sk.splash.local.service.LocalService
import com.sk.splash.remote.models.RemoteResult
import com.sk.splash.remote.service.RemoteService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localUserMapper: LocalUserMapper,
    private val localPhotoMapper: LocalPhotoMapper,
    private val localCollectionMapper: LocalCollectionMapper,
    private val remoteUserMapper: RemoteUserMapper,
    private val remotePhotoMapper: RemotePhotoMapper,
    private val remoteCollectionMapper: RemoteCollectionMapper,
    private val remotePhotoDetailsMapper: RemotePhotoDetailsMapper,
    private val remoteCollectionDetailsMapper: RemoteCollectionDetailsMapper,
    private val remoteUserDetailsMapper: RemoteUserDetailsMapper,
    private val localService: LocalService,
    private val remoteService: RemoteService,
    private val scope: CoroutineScope,
) : Repository {
    override suspend fun saveFavouriteUser(user: User) {
        scope.launch {
            localService.saveFavouriteUser(localUserMapper.mapBack(user))
        }
    }

    override suspend fun removeFavouriteUser(username: String) {
        scope.launch {
            localService.removeFavouriteUser(username)
        }
    }

    override fun getFavouriteUsers(): Flow<List<User>> {
        return localService.getFavouriteUsers().map(localUserMapper::map)
    }


    override suspend fun saveFavouritePhoto(photo: Photo) {
        scope.launch {
            localService.saveFavouritePhoto(localPhotoMapper.mapBack(photo))
        }
    }

    override suspend fun removeFavouritePhoto(id: String) {
        scope.launch {
            localService.removeFavouritePhoto(id)
        }
    }

    override fun getFavouritePhotos(): Flow<List<Photo>> {
        return localService.getFavouritePhotos().map(localPhotoMapper::map)
    }

    override suspend fun saveFavouriteCollection(collection: Collection) {
        scope.launch {
            localService.saveFavouriteCollection(localCollectionMapper.mapBack(collection))
        }
    }

    override suspend fun removeFavouriteCollection(id: String) {
        scope.launch {
            localService.removeFavouriteCollection(id)
        }
    }

    override fun getFavouriteCollections(): Flow<List<Collection>> {
        return localService.getFavouriteCollections().map(localCollectionMapper::map)
    }

    override suspend fun getLatestPhotos(page: Int): Result<List<Photo>> {
        return when (val res = remoteService.getLatestPhotos(page)) {
            is RemoteResult.Success -> Result.Success(remotePhotoMapper.map(res.data))
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }

    override suspend fun getPopularPhotos(page: Int): Result<List<Photo>> {
        return when (val res = remoteService.getPopularPhotos(page)) {
            is RemoteResult.Success -> Result.Success(remotePhotoMapper.map(res.data))
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }

    override suspend fun searchPhotos(query: String, page: Int): Result<Search<Photo>> {
        return when (val res = remoteService.searchPhotos(query, page)) {
            is RemoteResult.Success -> Result.Success(
                res.data.run {
                    Search(total, totalPages, remotePhotoMapper.map(results))
                }
            )
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }

    override suspend fun getCollectionPhotos(id: String, page: Int): Result<List<Photo>> {
        return when (val res = remoteService.getCollectionPhotos(id, page)) {
            is RemoteResult.Success -> Result.Success(remotePhotoMapper.map(res.data))
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }

    override suspend fun getUploadedPhotos(username: String, page: Int): Result<List<Photo>> {
        return when (val res = remoteService.getUploadedPhotos(username, page)) {
            is RemoteResult.Success -> Result.Success(remotePhotoMapper.map(res.data))
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }

    override suspend fun getPhoto(id: String): Result<PhotoDetails> {
        return when (val res = remoteService.getPhoto(id)) {
            is RemoteResult.Success -> Result.Success(remotePhotoDetailsMapper.map(res.data))
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }

    override suspend fun getFeaturedCollections(page: Int): Result<List<Collection>> {
        return when (val res = remoteService.getFeaturedCollections(page)) {
            is RemoteResult.Success -> Result.Success(remoteCollectionMapper.map(res.data))
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }

    override suspend fun searchCollections(query: String, page: Int): Result<Search<Collection>> {
        return when (val res = remoteService.searchCollections(query, page)) {
            is RemoteResult.Success -> Result.Success(
                res.data.run {
                    Search(total, totalPages, remoteCollectionMapper.map(results))
                }
            )
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }

    override suspend fun getCreatedCollections(
        username: String,
        page: Int,
    ): Result<List<Collection>> {
        return when (val res = remoteService.getCreatedCollections(username, page)) {
            is RemoteResult.Success -> Result.Success(remoteCollectionMapper.map(res.data))
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }

    override suspend fun getCollection(id: String): Result<CollectionDetails> {
        return when (val res = remoteService.getCollection(id)) {
            is RemoteResult.Success -> Result.Success(remoteCollectionDetailsMapper.map(res.data))
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }

    override suspend fun searchUsers(query: String, page: Int): Result<Search<User>> {
        return when (val res = remoteService.searchUsers(query, page)) {
            is RemoteResult.Success -> Result.Success(
                res.data.run {
                    Search(total, totalPages, remoteUserMapper.map(results))
                }
            )
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }

    override suspend fun getUser(username: String): Result<UserDetails> {
        return when (val res = remoteService.getUser(username)) {
            is RemoteResult.Success -> Result.Success(remoteUserDetailsMapper.map(res.data))
            is RemoteResult.Error -> Result.Error(res.exception)
        }
    }
}