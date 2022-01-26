package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.Collection
import com.sk.splash.local.entities.LocalCollection
import org.threeten.bp.LocalDateTime

interface LocalCollectionMapper : ReverseMapper<LocalCollection, Collection>

class LocalCollectionMapperImpl(
    private val coverPhotoMapper: LocalCoverPhotoMapper,
) : LocalCollectionMapper {
    override fun map(from: LocalCollection): Collection {
        return Collection(
            from.id,
            from.title,
            from.coverPhoto?.let { coverPhotoMapper.map(it) }
        )
    }

    override fun mapBack(to: Collection): LocalCollection {
        return LocalCollection(
            to.id,
            to.title,
            to.coverPhoto?.let { coverPhotoMapper.mapBack(it) },
            LocalDateTime.now()
        )
    }
}
