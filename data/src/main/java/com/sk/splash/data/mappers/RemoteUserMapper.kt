package com.sk.splash.data.mappers

import com.sk.splash.data.models.UIUser
import com.sk.splash.remote.models.RemoteUser

interface RemoteUserMapper : Mapper<RemoteUser, UIUser>

class RemoteUserMapperImpl(
    private val profileImageUrlMapper: RemoteProfileImageUrlMapper,
) : RemoteUserMapper {
    override fun map(from: RemoteUser): UIUser {
        return UIUser(
            from.username,
            from.name,
            from.profileImage?.let { profileImageUrlMapper.map(it) },
            false,
            null,
        )
    }
}