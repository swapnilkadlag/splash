package com.sk.splash.data.mappers

import com.sk.splash.data.models.UIExif
import com.sk.splash.remote.models.RemoteExif

interface RemoteExifMapper : Mapper<RemoteExif, UIExif>

class RemoteExifMapperImpl : RemoteExifMapper {
    override fun map(from: RemoteExif): UIExif {
        return UIExif(
            from.make,
            from.model,
            from.exposureTime,
            from.aperture,
            from.focalLength,
            from.iso,
        )
    }
}