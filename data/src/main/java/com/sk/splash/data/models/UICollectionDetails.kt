package com.sk.splash.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDateTime

@Parcelize
data class UICollectionDetails(
    val id: String,
    val title: String,
    val description: String?,
    val publishedAt: String,
    val totalPhotos: Int,
    val coverPhoto: UIPhotoDetails?,
    val user: UIUserDetails,
    val webLink: String,
    val saved: Boolean,
    val savedAt: LocalDateTime?,
) : Parcelable
