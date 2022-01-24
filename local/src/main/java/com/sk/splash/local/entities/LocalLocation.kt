package com.sk.splash.local.entities

import androidx.room.Embedded

data class LocalLocation(
    val city: String?,
    val country: String?,
    @Embedded
    val position: LocalPosition?,
)