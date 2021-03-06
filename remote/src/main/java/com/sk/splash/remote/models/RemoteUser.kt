package com.sk.splash.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteUser(
    @Json(name = "username")
    val username: String,
    @Json(name = "name")
    val name: String?,
    @Json(name = "profile_image")
    val profileImage: RemoteProfileImageUrls?,
)