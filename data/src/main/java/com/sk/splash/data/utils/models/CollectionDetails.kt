package com.sk.splash.data.utils.models

data class CollectionDetails(
    val id: String,
    val title: String,
    val description: String?,
    val publishedAt: String,
    val totalPhotos: Int,
    val coverPhoto: PhotoDetails?,
    val user: UserDetails,
    val webLink: String,
)
