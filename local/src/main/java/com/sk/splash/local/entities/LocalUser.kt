package com.sk.splash.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sk.splash.local.entities.LocalProfileImageUrls
import org.threeten.bp.LocalDateTime

@Entity(tableName = "user")
data class LocalUser(
    @PrimaryKey
    val username: String,
    val name: String?,
    @Embedded
    val profileImage: LocalProfileImageUrls?,
    val savedAt: LocalDateTime,
)