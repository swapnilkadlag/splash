package com.sk.splash.data.utils.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UIUserDetails(
    val id: String,
    val username: String,
    val name: String?,
    val portfolioUrl: String?,
    val bio: String?,
    val location: String?,
    val profileImage: UIProfileImageUrls?,
    val webLink: String,
) : Parcelable
