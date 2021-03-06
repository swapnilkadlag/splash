package com.sk.splash.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sk.splash.local.entities.LocalPhotoUrls
import org.threeten.bp.LocalDateTime

@Entity(tableName = "photo")
data class LocalPhoto(
    @PrimaryKey
    val id: String,
    val width: Int,
    val height: Int,
    @Embedded
    val urls: LocalPhotoUrls,
    val color: String,
    val savedAt: LocalDateTime,
)