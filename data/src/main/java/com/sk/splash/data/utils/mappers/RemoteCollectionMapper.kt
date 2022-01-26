package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.Collection
import com.sk.splash.remote.models.RemoteCollection

interface RemoteCollectionMapper : Mapper<RemoteCollection, Collection>

class RemoteCollectionMapperImpl(
    private val photoMapper: RemotePhotoMapper,
) : RemoteCollectionMapper {
    override fun map(from: RemoteCollection): Collection {
        return Collection(
            from.id,
            from.title,
            from.coverPhoto?.let { photoMapper.map(it) }
        )
    }
}