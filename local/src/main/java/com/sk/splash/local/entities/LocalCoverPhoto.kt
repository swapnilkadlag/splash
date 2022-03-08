package com.sk.splash.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDateTime

data class LocalCoverPhoto(
    val width: Int,
    val height: Int,
    @Embedded
    val urls: LocalPhotoUrls,
    val color: String,
)