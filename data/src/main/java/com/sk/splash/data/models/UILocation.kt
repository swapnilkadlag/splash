package com.sk.splash.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UILocation(
    val city: String?,
    val country: String?,
    val position: UIPosition?,
):Parcelable
