package com.sk.splash.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDateTime

@Parcelize
data class UICollection(
    val id: String,
    val title: String,
    val coverPhoto: UIPhoto?,
    val saved: Boolean,
    val savedAt: LocalDateTime?,
) : Parcelable

