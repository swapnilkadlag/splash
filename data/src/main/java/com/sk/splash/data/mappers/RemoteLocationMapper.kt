package com.sk.splash.data.mappers

import com.sk.splash.data.models.UILocation
import com.sk.splash.remote.models.RemoteLocation

interface RemoteLocationMapper : Mapper<RemoteLocation, UILocation>

class RemoteLocationMapperImpl(
    private val positionMapper: RemotePositionMapper,
) : RemoteLocationMapper {
    override fun map(from: RemoteLocation): UILocation {
        return UILocation(
            from.city,
            from.country,
            from.position?.let { positionMapper.map(it) },
        )
    }
}