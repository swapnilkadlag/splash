package com.sk.splash.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UIPhotoDetails(
    val id: String,
    val createdAt: String,
    val width: Int,
    val height: Int,
    val color: String,
    val likes: Int,
    val description: String?,
    val user: UIUserDetails,
    val exif: UIExif?,
    val location: UILocation?,
    val urls: UIPhotoUrls,
    val webLink: String,
) : Parcelable