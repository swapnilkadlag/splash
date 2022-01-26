package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.PhotoUrls
import com.sk.splash.local.entities.LocalPhotoUrls

interface LocalPhotoUrlsMapper : ReverseMapper<LocalPhotoUrls, PhotoUrls>

class LocalPhotoUrlsMapperImpl : LocalPhotoUrlsMapper {
    override fun map(from: LocalPhotoUrls): PhotoUrls {
        return PhotoUrls(
            from.raw,
            from.full,
            from.regular,
            from.small,
            from.thumb
        )
    }

    override fun mapBack(to: PhotoUrls): LocalPhotoUrls {
        return LocalPhotoUrls(
            to.raw,
            to.full,
            to.regular,
            to.small,
            to.thumb
        )
    }
}