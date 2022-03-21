package com.sk.splash.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDateTime


@Parcelize
data class UIUser(
    val username: String,
    val name: String?,
    val profileImage: UIProfileImageUrls?,
    val saved: Boolean,
    val savedAt: LocalDateTime?,
) : Parcelable

