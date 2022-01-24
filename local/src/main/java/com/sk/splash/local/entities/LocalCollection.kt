package com.sk.splash.local.entities

import androidx.room.*
import org.threeten.bp.LocalDateTime

@Entity(
    tableName = "collection",
    indices = [Index("userId"), Index("coverPhotoId")],
    foreignKeys = [ForeignKey(
        entity = LocalUser::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.RESTRICT,
        onUpdate = ForeignKey.RESTRICT,
    ), ForeignKey(
        entity = LocalPhoto::class,
        parentColumns = ["id"],
        childColumns = ["coverPhotoId"],
        onDelete = ForeignKey.RESTRICT,
        onUpdate = ForeignKey.RESTRICT,
    )]
)
data class LocalCollection(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String?,
    val publishedAt: LocalDateTime,
    val totalPhotos: Int,
    val coverPhotoId: String?,
    val userId: String,
    @Embedded
    val links: LocalLinks,
)