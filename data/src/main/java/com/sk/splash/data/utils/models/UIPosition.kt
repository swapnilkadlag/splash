package com.sk.splash.data.utils.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UIPosition(
    val latitude: Double?,
    val longitude: Double?
):Parcelable

