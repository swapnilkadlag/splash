package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.User
import com.sk.splash.remote.models.RemoteUser

interface RemoteUserMapper : Mapper<RemoteUser, User>

class RemoteUserMapperImpl(
    private val profileImageUrlMapper: RemoteProfileImageUrlMapper,
) : RemoteUserMapper {
    override fun map(from: RemoteUser): User {
        return User(
            from.username,
            from.name,
            from.profileImage?.let { profileImageUrlMapper.map(it) },
        )
    }
}