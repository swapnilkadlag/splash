package com.sk.splash.data.utils.models

data class Search<T>(
    val total: Int,
    val totalPages: Int,
    val results: List<T>,
)