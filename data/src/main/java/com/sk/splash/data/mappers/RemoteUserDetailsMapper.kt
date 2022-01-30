package com.sk.splash.data.mappers

import com.sk.splash.data.models.UIUserDetails
import com.sk.splash.remote.models.RemoteUserDetails

interface RemoteUserDetailsMapper : Mapper<RemoteUserDetails, UIUserDetails>

class RemoteUserDetailsMapperImpl(
    private val profileImageUrlMapper: RemoteProfileImageUrlMapper,
) : RemoteUserDetailsMapper {
    override fun map(from: RemoteUserDetails): UIUserDetails {
        return UIUserDetails(
            from.id,
            from.username,
            from.name,
            from.portfolioUrl,
            from.bio,
            from.location,
            from.profileImage?.let { profileImageUrlMapper.map(it) },
            from.links.html
        )
    }
}