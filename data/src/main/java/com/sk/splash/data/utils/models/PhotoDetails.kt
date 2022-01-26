package com.sk.splash.data.utils.models

data class PhotoDetails(
    val id: String,
    val createdAt: String,
    val width: Int,
    val height: Int,
    val color: String,
    val likes: Int,
    val description: String?,
    val user: UserDetails,
    val exif: Exif?,
    val location: Location?,
    val urls: PhotoUrls,
    val webLink: String,
)
