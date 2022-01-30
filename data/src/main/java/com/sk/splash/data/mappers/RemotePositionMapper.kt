package com.sk.splash.data.mappers

import com.sk.splash.data.models.UIPosition
import com.sk.splash.remote.models.RemotePosition

interface RemotePositionMapper : Mapper<RemotePosition, UIPosition>

class RemotePositionMapperImpl : RemotePositionMapper {
    override fun map(from: RemotePosition): UIPosition {
        return UIPosition(
            from.latitude,
            from.longitude,
        )
    }
}