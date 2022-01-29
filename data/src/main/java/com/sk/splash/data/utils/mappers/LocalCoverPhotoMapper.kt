package com.sk.splash.data.utils.mappers

import com.sk.splash.data.utils.models.UIPhoto
import com.sk.splash.local.entities.LocalCoverPhoto

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