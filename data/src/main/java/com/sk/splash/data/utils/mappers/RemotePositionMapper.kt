package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.UIPosition
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