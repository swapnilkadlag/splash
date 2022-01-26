package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.Photo
import com.sk.splash.local.entities.LocalCoverPhoto

interface LocalCoverPhotoMapper : ReverseMapper<LocalCoverPhoto, Photo>

class LocalCoverPhotoMapperImpl(
    private val photoUrlsMapper: LocalPhotoUrlsMapper,
) : LocalCoverPhotoMapper {
    override fun map(from: LocalCoverPhoto): Photo {
        return Photo(
            "",
            from.width,
            from.height,
            photoUrlsMapper.map(from.urls),
            from.color,
        )
    }

    override fun mapBack(to: Photo): LocalCoverPhoto {
        return LocalCoverPhoto(
            to.width,
            to.height,
            photoUrlsMapper.mapBack(to.urls),
            to.color,
        )
    }
}