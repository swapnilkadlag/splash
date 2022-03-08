package com.sk.splash.data.mappers

import com.sk.splash.data.models.*
import com.sk.splash.data.utils.UIDateTimeConverter
import com.sk.splash.remote.models.*

interface RemotePhotoDetailsMapper : Mapper<RemotePhotoDetails, UIPhotoDetails>

class RemotePhotoDetailsMapperImpl(
    private val dateTimeConverter: UIDateTimeConverter,
    private val userDetailsMapper: RemoteUserDetailsMapper,
    private val exifMapper: RemoteExifMapper,
    private val locationMapper: RemoteLocationMapper,
    private val photoUrlsMapper: RemotePhotoUrlsMapper,
) : RemotePhotoDetailsMapper {
    override fun map(from: RemotePhotoDetails): UIPhotoDetails {
        return UIPhotoDetails(
            from.id,
            dateTimeConverter.toString(from.createdAt) ?: "",
            from.width,
            from.height,
            from.color,
            from.likes,
            from.description,
            userDetailsMapper.map(from.user),
            from.exif?.let { exifMapper.map(it) },
            from.location?.let { locationMapper.map(it) },
            photoUrlsMapper.map(from.urls),
            from.links.html,
            false,
            null,
        )
    }

}