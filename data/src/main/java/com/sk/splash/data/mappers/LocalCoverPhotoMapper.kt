package com.sk.splash.data.mappers

import com.sk.splash.data.models.UIPhoto
import com.sk.splash.local.entities.LocalCoverPhoto
import java.util.*

interface LocalCoverPhotoMapper : ReverseMapper<LocalCoverPhoto, UIPhoto>

class LocalCoverPhotoMapperImpl(
    private val photoUrlsMapper: LocalPhotoUrlsMapper,
) : LocalCoverPhotoMapper {
    override fun map(from: LocalCoverPhoto): UIPhoto {
        return UIPhoto(
            "",
            from.width,
            from.height,
            photoUrlsMapper.map(from.urls),
            from.color,
            false,
            null,
        )
    }

    override fun mapBack(to: UIPhoto): LocalCoverPhoto {
        return LocalCoverPhoto(
            to.width,
            to.height,
            photoUrlsMapper.mapBack(to.urls),
            to.color,
        )
    }
}