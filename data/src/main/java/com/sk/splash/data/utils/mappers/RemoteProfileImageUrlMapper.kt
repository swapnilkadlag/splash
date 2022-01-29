package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.UIProfileImageUrls
import com.sk.splash.remote.models.RemoteProfileImageUrls

interface RemoteProfileImageUrlMapper : Mapper<RemoteProfileImageUrls, UIProfileImageUrls>

class RemoteProfileImageUrlMapperImpl : RemoteProfileImageUrlMapper {
    override fun map(from: RemoteProfileImageUrls): UIProfileImageUrls {
        return UIProfileImageUrls(
            from.small,
            from.medium,
            from.large,
        )
    }
}