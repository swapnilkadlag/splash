package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.CollectionDetails
import com.sk.splash.data.utils.utils.UIDateTimeConverter
import com.sk.splash.remote.models.RemoteCollectionDetails

interface RemoteCollectionDetailsMapper : Mapper<RemoteCollectionDetails, CollectionDetails>

class RemoteCollectionDetailsMapperImpl(
    private val dateTimeConverter: UIDateTimeConverter,
    private val coverPhotoMapper: RemotePhotoDetailsMapper,
    private val userDetailsMapper: RemoteUserDetailsMapper,
) : RemoteCollectionDetailsMapper {
    override fun map(from: RemoteCollectionDetails): CollectionDetails {
        return CollectionDetails(
            from.id,
            from.title,
            from.description,
            dateTimeConverter.toString(from.publishedAt) ?: "",
            from.totalPhotos,
            from.coverPhoto?.let { coverPhotoMapper.map(it) },
            userDetailsMapper.map(from.user),
            from.links.html,
        )
    }
}