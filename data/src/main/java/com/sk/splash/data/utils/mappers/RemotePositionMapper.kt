package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.Position
import com.sk.splash.remote.models.RemotePosition

interface RemotePositionMapper : Mapper<RemotePosition, Position>

class RemotePositionMapperImpl : RemotePositionMapper {
    override fun map(from: RemotePosition): Position {
        return Position(
            from.latitude,
            from.longitude,
        )
    }
}