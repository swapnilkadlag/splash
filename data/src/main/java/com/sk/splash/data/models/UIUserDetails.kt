package com.sk.splash.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDateTime

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
    val saved: Boolean,
    val savedAt: LocalDateTime?,
) : Parcelable
