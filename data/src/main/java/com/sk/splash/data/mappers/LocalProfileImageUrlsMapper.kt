package com.sk.splash.data.mappers

import com.sk.splash.data.models.UIProfileImageUrls
import com.sk.splash.local.entities.LocalProfileImageUrls

interface LocalProfileImageUrlsMapper : ReverseMapper<LocalProfileImageUrls, UIProfileImageUrls>

class LocalProfileImageUrlsMapperImpl : LocalProfileImageUrlsMapper {
    override fun map(from: LocalProfileImageUrls): UIProfileImageUrls {
        return UIProfileImageUrls(
            from.small,
            from.medium,
            from.large,
        )
    }

    override fun mapBack(to: UIProfileImageUrls): LocalProfileImageUrls {
        return LocalProfileImageUrls(
            to.small,
            to.medium,
            to.large,
        )
    }
}