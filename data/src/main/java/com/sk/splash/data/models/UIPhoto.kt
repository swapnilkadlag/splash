package com.sk.splash.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDateTime

@Parcelize
data class UIPhoto(
    val id: String,
    val width: Int,
    val height: Int,
    val urls: UIPhotoUrls,
    val color: String,
    val saved: Boolean,
    val savedAt: LocalDateTime?,
) : Parcelable