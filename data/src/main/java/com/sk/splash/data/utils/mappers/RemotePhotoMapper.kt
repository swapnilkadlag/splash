package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.Photo
import com.sk.splash.remote.models.RemotePhoto

interface RemotePhotoMapper : Mapper<RemotePhoto, Photo>

class RemotePhotoMapperImpl(
    private val photoUrlsMapper: RemotePhotoUrlsMapper,
) : RemotePhotoMapper {
    override fun map(from: RemotePhoto): Photo {
        return Photo(
            from.id,
            from.width,
            from.height,
            photoUrlsMapper.map(from.urls),
            from.color,
        )
    }
}