package com.sk.splash.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteCollectionDetails(
    @Json(name = "id")
    val id: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "description")
    val description: String?,
    @Json(name = "published_at")
    val publishedAt: String,
    @Json(name = "total_photos")
    val totalPhotos: Int,
    @Json(name = "cover_photo")
    val coverPhoto: RemotePhotoDetails?,
    @Json(name = "user")
    val user: RemoteUserDetails,
    @Json(name = "links")
    val links: RemoteLinks,
)