package com.sk.splash.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemotePosition(
    @Json(name = "latitude")
    val latitude: Double?,
    @Json(name = "longitude")
    val longitude: Double?
)