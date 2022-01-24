package com.sk.splash.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemotePhotoUrls(
    @Json(name = "raw")
    var raw: String,
    @Json(name = "full")
    var full: String,
    @Json(name = "regular")
    var regular: String,
    @Json(name = "small")
    var small: String,
    @Json(name = "thumb")
    var thumb: String
)