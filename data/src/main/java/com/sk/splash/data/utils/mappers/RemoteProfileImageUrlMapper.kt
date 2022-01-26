package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.ProfileImageUrls
import com.sk.splash.remote.models.RemoteProfileImageUrls

interface RemoteProfileImageUrlMapper : Mapper<RemoteProfileImageUrls, ProfileImageUrls>

class RemoteProfileImageUrlMapperImpl : RemoteProfileImageUrlMapper {
    override fun map(from: RemoteProfileImageUrls): ProfileImageUrls {
        return ProfileImageUrls(
            from.small,
            from.medium,
            from.large,
        )
    }
}