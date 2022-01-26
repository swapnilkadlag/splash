package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.Location
import com.sk.splash.remote.models.RemoteLocation

interface RemoteLocationMapper : Mapper<RemoteLocation, Location>

class RemoteLocationMapperImpl(
    private val positionMapper: RemotePositionMapper,
) : RemoteLocationMapper {
    override fun map(from: RemoteLocation): Location {
        return Location(
            from.city,
            from.country,
            from.position?.let { positionMapper.map(it) },
        )
    }
}