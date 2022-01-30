package com.sk.splash.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UIPhoto(
    val id: String,
    val width: Int,
    val height: Int,
    val urls: UIPhotoUrls,
    val color: String,
):Parcelable