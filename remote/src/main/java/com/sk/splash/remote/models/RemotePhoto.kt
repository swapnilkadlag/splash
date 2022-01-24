package com.sk.splash.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemotePhoto(
    @Json(name = "id")
    val id: String,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "width")
    val width: Int,
    @Json(name = "height")
    val height: Int,
    @Json(name = "color")
    val color: String,
    @Json(name = "likes")
    val likes: Int,
    @Json(name = "description")
    val description: String?,
    @Json(name = "user")
    val user: RemoteUser,
    @Json(name = "exif")
    val exif: RemoteExif?,
    @Json(name = "location")
    val location: RemoteLocation?,
    @Json(name = "urls")
    val urls: RemotePhotoUrls,
    @Json(name = "links")
    val links: RemoteLinks,
)