package com.sk.splash.data.mappers

import com.sk.splash.data.models.UICollection
import com.sk.splash.local.entities.LocalCollection
import org.threeten.bp.LocalDateTime

interface LocalCollectionMapper : ReverseMapper<LocalCollection, UICollection>

class LocalCollectionMapperImpl(
    private val coverPhotoMapper: LocalCoverPhotoMapper,
) : LocalCollectionMapper {
    override fun map(from: LocalCollection): UICollection {
        return UICollection(
            from.id,
            from.title,
            from.coverPhoto?.let { coverPhotoMapper.map(it) }
        )
    }

    override fun mapBack(to: UICollection): LocalCollection {
        return LocalCollection(
            to.id,
            to.title,
            to.coverPhoto?.let { coverPhotoMapper.mapBack(it) },
            LocalDateTime.now()
        )
    }
}
