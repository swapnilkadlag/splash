package com.sk.splash.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UIProfileImageUrls(
    var small: String,
    var medium: String,
    var large: String
):Parcelable
