package com.sk.splash.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.sk.splash.data.mappers.*
import com.sk.splash.data.models.*
import com.sk.splash.data.models.UICollection
import com.sk.splash.data.paging.FinitePageData
import com.sk.splash.data.paging.finitePager
import com.sk.splash.data.paging.infinitePager
import com.sk.splash.data.paging.infiniteDbPager
import com.sk.splash.local.service.LocalService
import com.sk.splash.remote.models.RemoteResult
import com.sk.splash.remote.service.RemoteService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.ceil

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
    override suspend fun saveFavouriteUser(user: UIUser) {
        scope.launch {
            localService.saveFavouriteUser(localUserMapper.mapBack(user))
        }
    }

    override suspend fun saveFavouriteUser(userDetails: UIUserDetails) {
        scope.launch {
            //localService.saveFavouriteUser(localUserMapper.mapBack(user))
        }
    }

    override suspend fun removeFavouriteUser(username: String) {
        scope.launch {
            localService.removeFavouriteUser(username)
        }
    }

    override fun getFavouriteUsers(): Flow<PagingData<UIUser>> {
        return infiniteDbPager { localService.getFavouriteUsers() }.flow.map {
            it.map(localUserMapper::map)
        }
    }

    override suspend fun saveFavouritePhoto(photo: UIPhoto) {
        scope.launch {
            localService.saveFavouritePhoto(localPhotoMapper.mapBack(photo))
        }
    }

    override suspend fun saveFavouritePhoto(photoDetails: UIPhotoDetails) {
        scope.launch {
            val photo = UIPhoto(
                photoDetails.id,
                photoDetails.width,
                photoDetails.height,
                photoDetails.urls,
                photoDetails.color,
                photoDetails.saved,
                photoDetails.savedDate,
            )
            localService.saveFavouritePhoto(localPhotoMapper.mapBack(photo))
        }
    }

    override suspend fun removeFavouritePhoto(id: String) {
        scope.launch {
            localService.removeFavouritePhoto(id)
        }
    }

    override fun getFavouritePhotos(): Flow<PagingData<UIPhoto>> {
        return infiniteDbPager { localService.getFavouritePhotos() }.flow.map {
            it.map(localPhotoMapper::map)
        }
    }

    override suspend fun saveFavouriteCollection(collection: UICollection) {
        scope.launch {
            localService.saveFavouriteCollection(localCollectionMapper.mapBack(collection))
        }
    }

    override suspend fun saveFavouriteCollection(collectionDetails: UICollectionDetails) {
        scope.launch {
            //localService.saveFavouriteCollection(localCollectionMapper.mapBack(collection))
        }
    }

    override suspend fun removeFavouriteCollection(id: String) {
        scope.launch {
            localService.removeFavouriteCollection(id)
        }
    }

    override fun getFavouriteCollections(): Flow<PagingData<UICollection>> {
        return infiniteDbPager { localService.getFavouriteCollections() }.flow.map {
            it.map(localCollectionMapper::map)
        }
    }

    override fun getLatestPhotos() = infinitePager { page ->
        when (val res = remoteService.getLatestPhotos(page)) {
            is RemoteResult.Success -> remotePhotoMapper.map(res.data)
            is RemoteResult.Error -> emptyList()
        }
    }.flow

    override fun getPopularPhotos() = infinitePager { page ->
        when (val res = remoteService.getPopularPhotos(page)) {
            is RemoteResult.Success -> remotePhotoMapper.map(res.data)
            is RemoteResult.Error -> emptyList()
        }
    }.flow

    override fun searchPhotos(query: MutableStateFlow<String>) = finitePager { page ->
        when (val res = remoteService.searchPhotos(query.value, page)) {
            is RemoteResult.Success -> FinitePageData(
                remotePhotoMapper.map(res.data.results),
                res.data.totalPages
            )
            is RemoteResult.Error -> FinitePageData.empty()
        }
    }.flow

    override fun getCollectionPhotos(id: String) = finitePager { page ->
        when (val res = remoteService.getCollectionPhotos(id, page)) {
            is RemoteResult.Success -> FinitePageData(
                remotePhotoMapper.map(res.data),
                ceil(res.data.size / 30f).toInt(),
            )
            is RemoteResult.Error -> FinitePageData.empty()
        }
    }.flow

    override fun getUploadedPhotos(username: String) = finitePager { page ->
        when (val res = remoteService.getUploadedPhotos(username, page)) {
            is RemoteResult.Success -> FinitePageData(
                remotePhotoMapper.map(res.data),
                ceil(res.data.size / 30f).toInt(),
            )
            is RemoteResult.Error -> FinitePageData.empty()
        }
    }.flow

    override suspend fun getPhoto(id: String): UIResult<UIPhotoDetails> {
        return when (val res = remoteService.getPhoto(id)) {
            is RemoteResult.Success -> UIResult.Success(remotePhotoDetailsMapper.map(res.data))
            is RemoteResult.Error -> UIResult.Error(res.exception)
        }
    }

    override fun getFeaturedCollections() = infinitePager { page ->
        when (val res = remoteService.getFeaturedCollections(page)) {
            is RemoteResult.Success -> remoteCollectionMapper.map(res.data)
            is RemoteResult.Error -> emptyList()
        }
    }.flow

    override fun searchCollections(query: MutableStateFlow<String>) = finitePager { page ->
        when (val res = remoteService.searchCollections(query.value, page)) {
            is RemoteResult.Success -> FinitePageData(
                remoteCollectionMapper.map(res.data.results),
                res.data.totalPages
            )
            is RemoteResult.Error -> FinitePageData.empty()
        }
    }.flow

    override fun getCreatedCollections(username: String) = finitePager { page ->
        when (val res = remoteService.getCreatedCollections(username, page)) {
            is RemoteResult.Success -> FinitePageData(
                remoteCollectionMapper.map(res.data),
                ceil(res.data.size / 30f).toInt(),
            )
            is RemoteResult.Error -> FinitePageData.empty()
        }
    }.flow

    override suspend fun getCollection(id: String): UIResult<UICollectionDetails> {
        return when (val res = remoteService.getCollection(id)) {
            is RemoteResult.Success -> UIResult.Success(remoteCollectionDetailsMapper.map(res.data))
            is RemoteResult.Error -> UIResult.Error(res.exception)
        }
    }

    override fun searchUsers(query: MutableStateFlow<String>) = finitePager { page ->
        when (val res = remoteService.searchUsers(query.value, page)) {
            is RemoteResult.Success -> FinitePageData(
                remoteUserMapper.map(res.data.results),
                res.data.totalPages
            )
            is RemoteResult.Error -> FinitePageData.empty()
        }
    }.flow

    override suspend fun getUser(username: String): UIResult<UIUserDetails> {
        return when (val res = remoteService.getUser(username)) {
            is RemoteResult.Success -> UIResult.Success(remoteUserDetailsMapper.map(res.data))
            is RemoteResult.Error -> UIResult.Error(res.exception)
        }
    }
}