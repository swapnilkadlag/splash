package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.User
import com.sk.splash.local.entities.LocalUser
import org.threeten.bp.LocalDateTime

interface LocalUserMapper : ReverseMapper<LocalUser, User>

class LocalUserMapperImpl(
    private val profileImageUrlMapper: LocalProfileImageUrlsMapper,
) : LocalUserMapper {
    override fun map(from: LocalUser): User {
        return User(
            from.username,
            from.name,
            from.profileImage?.let { profileImageUrlMapper.map(it) },
        )
    }

    override fun mapBack(to: User): LocalUser {
        return LocalUser(
            to.username,
            to.name,
            to.profileImage?.let { profileImageUrlMapper.mapBack(it) },
            LocalDateTime.now()
        )
    }
}