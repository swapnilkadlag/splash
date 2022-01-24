package com.sk.splash.remote.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteProfileImageUrls(
    var small: String,
    var medium: String,
    var large: String
)