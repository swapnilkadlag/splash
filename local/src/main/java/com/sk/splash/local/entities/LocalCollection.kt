package com.sk.splash.local.entities

import androidx.room.*
import org.threeten.bp.LocalDateTime

@Entity(tableName = "collection")
data class LocalCollection(
    @PrimaryKey
    val id: String,
    val title: String,
    @Embedded
    val coverPhoto: LocalCoverPhoto?,
    val savedAt: LocalDateTime,
)
