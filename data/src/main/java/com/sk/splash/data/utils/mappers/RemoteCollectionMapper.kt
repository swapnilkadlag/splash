package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.UICollection
import com.sk.splash.remote.models.RemoteCollection

interface RemoteCollectionMapper : Mapper<RemoteCollection, UICollection>

class RemoteCollectionMapperImpl(
    private val photoMapper: RemotePhotoMapper,
) : RemoteCollectionMapper {
    override fun map(from: RemoteCollection): UICollection {
        return UICollection(
            from.id,
            from.title,
            from.coverPhoto?.let { photoMapper.map(it) }
        )
    }
}