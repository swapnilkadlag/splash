package com.sk.splash.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemotePhoto(
    @Json(name = "id")
    val id: String,
    @Json(name = "width")
    val width: Int,
    @Json(name = "height")
    val height: Int,
    @Json(name = "urls")
    val urls: RemotePhotoUrls,
    @Json(name = "color")
    val color: String,
)