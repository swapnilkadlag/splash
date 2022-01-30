package com.sk.splash.data.mappers

import com.sk.splash.data.models.UIPhoto
import com.sk.splash.remote.models.RemotePhoto

interface RemotePhotoMapper : Mapper<RemotePhoto, UIPhoto>

class RemotePhotoMapperImpl(
    private val photoUrlsMapper: RemotePhotoUrlsMapper,
) : RemotePhotoMapper {
    override fun map(from: RemotePhoto): UIPhoto {
        return UIPhoto(
            from.id,
            from.width,
            from.height,
            photoUrlsMapper.map(from.urls),
            from.color,
        )
    }
}