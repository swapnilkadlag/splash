package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.ProfileImageUrls
import com.sk.splash.local.entities.LocalProfileImageUrls

interface LocalProfileImageUrlsMapper : ReverseMapper<LocalProfileImageUrls, ProfileImageUrls>

class LocalProfileImageUrlsMapperImpl : LocalProfileImageUrlsMapper {
    override fun map(from: LocalProfileImageUrls): ProfileImageUrls {
        return ProfileImageUrls(
            from.small,
            from.medium,
            from.large,
        )
    }

    override fun mapBack(to: ProfileImageUrls): LocalProfileImageUrls {
        return LocalProfileImageUrls(
            to.small,
            to.medium,
            to.large,
        )
    }
}