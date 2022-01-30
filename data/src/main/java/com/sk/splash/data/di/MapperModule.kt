package com.sk.splash.data.di

import com.sk.splash.data.mappers.*
import com.sk.splash.data.utils.UIDateTimeConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideLocalPhotoUrlsMapper(): LocalPhotoUrlsMapper {
        return LocalPhotoUrlsMapperImpl()
    }

    @Provides
    @Singleton
    fun provideLocalCoverPhotoMapper(
        photoUrlsMapper: LocalPhotoUrlsMapper,
    ): LocalCoverPhotoMapper {
        return LocalCoverPhotoMapperImpl(photoUrlsMapper)
    }

    @Provides
    @Singleton
    fun provideLocalCollectionMapper(
        coverPhotoMapper: LocalCoverPhotoMapper,
    ): LocalCollectionMapper {
        return LocalCollectionMapperImpl(coverPhotoMapper)
    }

    @Provides
    @Singleton
    fun provideLocalPhotoMapper(
        photoUrlsMapper: LocalPhotoUrlsMapper,
    ): LocalPhotoMapper {
        return LocalPhotoMapperImpl(photoUrlsMapper)
    }

    @Provides
    @Singleton
    fun provideLocalProfileImageUrlsMapper(): LocalProfileImageUrlsMapper {
        return LocalProfileImageUrlsMapperImpl()
    }

    @Provides
    @Singleton
    fun provideLocalUserMapper(
        profileImageUrlsMapper: LocalProfileImageUrlsMapper,
    ): LocalUserMapper {
        return LocalUserMapperImpl(profileImageUrlsMapper)
    }

    @Provides
    @Singleton
    fun provideRemoteProfileImageUrlMapper(): RemoteProfileImageUrlMapper {
        return RemoteProfileImageUrlMapperImpl()
    }

    @Provides
    @Singleton
    fun provideRemoteUserDetailsMapper(
        profileImageUrlMapper: RemoteProfileImageUrlMapper,
    ): RemoteUserDetailsMapper {
        return RemoteUserDetailsMapperImpl(profileImageUrlMapper)
    }

    @Provides
    @Singleton
    fun provideRemoteExifMapper(): RemoteExifMapper {
        return RemoteExifMapperImpl()
    }

    @Provides
    @Singleton
    fun provideRemotePositionMapper(): RemotePositionMapper {
        return RemotePositionMapperImpl()
    }

    @Provides
    @Singleton
    fun provideRemoteLocationMapper(
        positionMapper: RemotePositionMapper,
    ): RemoteLocationMapper {
        return RemoteLocationMapperImpl(positionMapper)
    }

    @Provides
    @Singleton
    fun provideRemotePhotoUrlsMapper(): RemotePhotoUrlsMapper {
        return RemotePhotoUrlsMapperImpl()
    }

    @Provides
    @Singleton
    fun provideRemotePhotoDetailsMapper(
        dateTimeConverter: UIDateTimeConverter,
        userDetailsMapper: RemoteUserDetailsMapper,
        exifMapper: RemoteExifMapper,
        locationMapper: RemoteLocationMapper,
        photoUrlsMapper: RemotePhotoUrlsMapper,
    ): RemotePhotoDetailsMapper {
        return RemotePhotoDetailsMapperImpl(
            dateTimeConverter,
            userDetailsMapper,
            exifMapper,
            locationMapper,
            photoUrlsMapper
        )
    }

    @Provides
    @Singleton
    fun provideRemoteCollectionDetailsMapper(
        dateTimeConverter: UIDateTimeConverter,
        coverPhotoMapper: RemotePhotoDetailsMapper,
        userDetailsMapper: RemoteUserDetailsMapper,
    ): RemoteCollectionDetailsMapper {
        return RemoteCollectionDetailsMapperImpl(
            dateTimeConverter,
            coverPhotoMapper,
            userDetailsMapper
        )
    }

    @Provides
    @Singleton
    fun provideRemotePhotoMapper(photoUrlsMapper: RemotePhotoUrlsMapper): RemotePhotoMapper {
        return RemotePhotoMapperImpl(photoUrlsMapper)
    }

    @Provides
    @Singleton
    fun provideRemoteCollectionMapper(photoMapper: RemotePhotoMapper): RemoteCollectionMapper {
        return RemoteCollectionMapperImpl(photoMapper)
    }

    @Provides
    @Singleton
    fun provideRemoteUserMapper(profileImageUrlMapper: RemoteProfileImageUrlMapper): RemoteUserMapper {
        return RemoteUserMapperImpl(profileImageUrlMapper)
    }
}