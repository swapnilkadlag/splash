package com.sk.splash.data.utils.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class UIUser(
    val username: String,
    val name: String?,
    val profileImage: UIProfileImageUrls?,
) : Parcelable

