package com.sk.splash.data.mappers

import com.sk.splash.data.models.UIUser
import com.sk.splash.local.entities.LocalUser
import org.threeten.bp.LocalDateTime

interface LocalUserMapper : ReverseMapper<LocalUser, UIUser>

class LocalUserMapperImpl(
    private val profileImageUrlMapper: LocalProfileImageUrlsMapper,
) : LocalUserMapper {
    override fun map(from: LocalUser): UIUser {
        return UIUser(
            from.username,
            from.name,
            from.profileImage?.let { profileImageUrlMapper.map(it) },
            true,
            from.savedAt,
        )
    }

    override fun mapBack(to: UIUser): LocalUser {
        return LocalUser(
            to.username,
            to.name,
            to.profileImage?.let { profileImageUrlMapper.mapBack(it) },
            LocalDateTime.now()
        )
    }
}