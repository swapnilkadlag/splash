package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.UIPhotoUrls
import com.sk.splash.local.entities.LocalPhotoUrls

interface LocalPhotoUrlsMapper : ReverseMapper<LocalPhotoUrls, UIPhotoUrls>

class LocalPhotoUrlsMapperImpl : LocalPhotoUrlsMapper {
    override fun map(from: LocalPhotoUrls): UIPhotoUrls {
        return UIPhotoUrls(
            from.raw,
            from.full,
            from.regular,
            from.small,
            from.thumb
        )
    }

    override fun mapBack(to: UIPhotoUrls): LocalPhotoUrls {
        return LocalPhotoUrls(
            to.raw,
            to.full,
            to.regular,
            to.small,
            to.thumb
        )
    }
}