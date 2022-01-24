package com.sk.splash.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class LocalUser(
    @PrimaryKey
    val id: String,
    val username: String,
    val name: String?,
    val portfolioUrl: String?,
    val bio: String?,
    val location: String?,
    @Embedded
    val profileImage: LocalProfileImageUrls?,
    @Embedded
    val links: LocalLinks,
)