package com.sk.splash.data.utils.models

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
