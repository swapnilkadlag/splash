package com.sk.splash.data.utils.models

data class UserDetails(
    val id: String,
    val username: String,
    val name: String?,
    val portfolioUrl: String?,
    val bio: String?,
    val location: String?,
    val profileImage: ProfileImageUrls?,
    val webLink: String,
)
