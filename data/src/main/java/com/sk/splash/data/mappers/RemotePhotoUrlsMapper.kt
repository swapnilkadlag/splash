package com.sk.splash.data.mappers

import com.sk.splash.data.models.UIPhotoUrls
import com.sk.splash.remote.models.RemotePhotoUrls

interface RemotePhotoUrlsMapper : Mapper<RemotePhotoUrls, UIPhotoUrls>

class RemotePhotoUrlsMapperImpl : RemotePhotoUrlsMapper {
    override fun map(from: RemotePhotoUrls): UIPhotoUrls {
        return UIPhotoUrls(
            from.raw,
            from.full,
            from.regular,
            from.small,
            from.thumb
        )
    }
}