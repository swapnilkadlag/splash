package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.PhotoUrls
import com.sk.splash.remote.models.RemotePhotoUrls

interface RemotePhotoUrlsMapper : Mapper<RemotePhotoUrls, PhotoUrls>

class RemotePhotoUrlsMapperImpl : RemotePhotoUrlsMapper {
    override fun map(from: RemotePhotoUrls): PhotoUrls {
        return PhotoUrls(
            from.raw,
            from.full,
            from.regular,
            from.small,
            from.thumb
        )
    }
}