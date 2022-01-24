package com.sk.splash.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteUser(
    @Json(name = "id")
    val id: String,
    @Json(name = "username")
    val username: String,
    @Json(name = "name")
    val name: String?,
    @Json(name = "portfolio_url")
    val portfolioUrl: String?,
    @Json(name = "bio")
    val bio: String?,
    @Json(name = "location")
    val location: String?,
    @Json(name = "profile_image")
    val profileImage: RemoteProfileImageUrls?,
    @Json(name = "links")
    val links: RemoteLinks,
)