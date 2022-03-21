package com.sk.splash.data.mappers

import com.sk.splash.data.models.UICollectionDetails
import com.sk.splash.data.utils.UIDateTimeConverter
import com.sk.splash.remote.models.RemoteCollectionDetails

interface RemoteCollectionDetailsMapper : Mapper<RemoteCollectionDetails, UICollectionDetails>

class RemoteCollectionDetailsMapperImpl(
    private val dateTimeConverter: UIDateTimeConverter,
    private val coverPhotoMapper: RemotePhotoDetailsMapper,
    private val userDetailsMapper: RemoteUserDetailsMapper,
) : RemoteCollectionDetailsMapper {
    override fun map(from: RemoteCollectionDetails): UICollectionDetails {
        return UICollectionDetails(
            from.id,
            from.title,
            from.description,
            dateTimeConverter.toString(from.publishedAt) ?: "",
            from.totalPhotos,
            from.coverPhoto?.let { coverPhotoMapper.map(it) },
            userDetailsMapper.map(from.user),
            from.links.html,
            false,
            null,
        )
    }
}