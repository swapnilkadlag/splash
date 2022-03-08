package com.sk.splash.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UICollection(
    val id: String,
    val title: String,
    val coverPhoto: UIPhoto?,
) : Parcelable

