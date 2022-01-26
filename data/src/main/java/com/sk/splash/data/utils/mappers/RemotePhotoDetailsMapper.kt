package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.*
import com.sk.splash.data.utils.utils.UIDateTimeConverter
import com.sk.splash.remote.models.*

interface RemotePhotoDetailsMapper : Mapper<RemotePhotoDetails, PhotoDetails>

class RemotePhotoDetailsMapperImpl(
    private val dateTimeConverter: UIDateTimeConverter,
    private val userDetailsMapper: RemoteUserDetailsMapper,
    private val exifMapper: RemoteExifMapper,
    private val locationMapper: RemoteLocationMapper,
    private val photoUrlsMapper: RemotePhotoUrlsMapper,
) : RemotePhotoDetailsMapper {
    override fun map(from: RemotePhotoDetails): PhotoDetails {
        return PhotoDetails(
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
        )
    }

}