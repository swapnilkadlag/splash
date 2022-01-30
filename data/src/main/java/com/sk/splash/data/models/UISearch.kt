package com.sk.splash.data.models

import android.os.Parcelable

data class UISearch<T : Parcelable>(
    val total: Int,
    val totalPages: Int,
    val results: List<T>,
)