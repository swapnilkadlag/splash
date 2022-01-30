package com.sk.splash.data.di

import com.sk.splash.data.mappers.*
import com.sk.splash.data.repository.Repository
import com.sk.splash.data.repository.RepositoryImpl
import com.sk.splash.data.utils.Constants
import com.sk.splash.data.utils.UIDateTimeConverter
import com.sk.splash.local.service.LocalService
import com.sk.splash.remote.service.RemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import org.threeten.bp.format.DateTimeFormatter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideLocalDateTimeConverter(): UIDateTimeConverter {
        return UIDateTimeConverter(DateTimeFormatter.ofPattern(Constants.DISPLAY_DATE_FORMAT))
    }

    @Provides
    @Singleton
    fun provideRepository(
        localUserMapper: LocalUserMapper,
        localPhotoMapper: LocalPhotoMapper,
        localCollectionMapper: LocalCollectionMapper,
        remoteUserMapper: RemoteUserMapper,
        remotePhotoMapper: RemotePhotoMapper,
        remoteCollectionMapper: RemoteCollectionMapper,
        remotePhotoDetailsMapper: RemotePhotoDetailsMapper,
        remoteCollectionDetailsMapper: RemoteCollectionDetailsMapper,
        remoteUserDetailsMapper: RemoteUserDetailsMapper,
        localService: LocalService,
        remoteService: RemoteService,
        scope: CoroutineScope,
    ): Repository {
        return RepositoryImpl(
            localUserMapper,
            localPhotoMapper,
            localCollectionMapper,
            remoteUserMapper,
            remotePhotoMapper,
            remoteCollectionMapper,
            remotePhotoDetailsMapper,
            remoteCollectionDetailsMapper,
            remoteUserDetailsMapper,
            localService,
            remoteService,
            scope
        )
    }
}