package com.sk.splash.data.mappers

import com.sk.splash.data.models.UIPhoto
import com.sk.splash.local.entities.LocalPhoto
import org.threeten.bp.LocalDateTime

interface LocalPhotoMapper : ReverseMapper<LocalPhoto, UIPhoto>

class LocalPhotoMapperImpl(
    private val photoUrlsMapper: LocalPhotoUrlsMapper,
) : LocalPhotoMapper {
    override fun map(from: LocalPhoto): UIPhoto {
        return UIPhoto(
            from.id,
            from.width,
            from.height,
            photoUrlsMapper.map(from.urls),
            from.color,
        )
    }

    override fun mapBack(to: UIPhoto): LocalPhoto {
        return LocalPhoto(
            to.id,
            to.width,
            to.height,
            photoUrlsMapper.mapBack(to.urls),
            to.color,
            LocalDateTime.now(),
        )
    }
}