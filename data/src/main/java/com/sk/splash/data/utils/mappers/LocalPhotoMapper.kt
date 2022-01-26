package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.Photo
import com.sk.splash.local.entities.LocalPhoto
import org.threeten.bp.LocalDateTime

interface LocalPhotoMapper : ReverseMapper<LocalPhoto, Photo>

class LocalPhotoMapperImpl(
    private val photoUrlsMapper: LocalPhotoUrlsMapper,
) : LocalPhotoMapper {
    override fun map(from: LocalPhoto): Photo {
        return Photo(
            from.id,
            from.width,
            from.height,
            photoUrlsMapper.map(from.urls),
            from.color,
        )
    }

    override fun mapBack(to: Photo): LocalPhoto {
        return LocalPhoto(
            to.id,
            to.width,
            to.height,
            photoUrlsMapper.mapBack(to.urls),
            to.color,
            LocalDateTime.now(),
        )
    }
}