package com.sk.splash.local.entities

import androidx.room.*
import org.threeten.bp.LocalDateTime

@Entity(
    tableName = "photo",
    indices = [Index("userId")],
    foreignKeys = [ForeignKey(
        entity = LocalUser::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.RESTRICT,
        onUpdate = ForeignKey.RESTRICT,
    )]
)
data class LocalPhoto(
    @PrimaryKey
    val id: String,
    val createdAt: LocalDateTime,
    val width: Int,
    val height: Int,
    val color: String,
    val likes: Int,
    val description: String?,
    val userId: String,
    @Embedded
    val exif: LocalExif?,
    @Embedded
    val location: LocalLocation?,
    @Embedded
    val urls: LocalPhotoUrls,
    @Embedded
    val links: LocalLinks,
)