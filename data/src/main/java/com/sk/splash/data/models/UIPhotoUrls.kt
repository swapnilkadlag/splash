package com.sk.splash.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UIPhotoUrls(
    var raw: String,
    var full: String,
    var regular: String,
    var small: String,
    var thumb: String
) : Parcelable
