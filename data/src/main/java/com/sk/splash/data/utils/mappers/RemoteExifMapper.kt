package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.Exif
import com.sk.splash.remote.models.RemoteExif

interface RemoteExifMapper : Mapper<RemoteExif, Exif>

class RemoteExifMapperImpl : RemoteExifMapper {
    override fun map(from: RemoteExif): Exif {
        return Exif(
            from.make,
            from.model,
            from.exposureTime,
            from.aperture,
            from.focalLength,
            from.iso,
        )
    }
}