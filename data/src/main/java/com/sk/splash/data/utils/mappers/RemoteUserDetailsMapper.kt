package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.UserDetails
import com.sk.splash.remote.models.RemoteUserDetails

interface RemoteUserDetailsMapper : Mapper<RemoteUserDetails, UserDetails>

class RemoteUserDetailsMapperImpl(
    private val profileImageUrlMapper: RemoteProfileImageUrlMapper,
) : RemoteUserDetailsMapper {
    override fun map(from: RemoteUserDetails): UserDetails {
        return UserDetails(
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