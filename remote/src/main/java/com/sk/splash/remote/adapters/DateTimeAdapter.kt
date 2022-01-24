package com.sk.splash.remote.adapters

import com.sk.splash.remote.utils.Constants.DATE_TIME_FORMAT
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class DateTimeAdapter(
    private val dateTimeFormatter: DateTimeFormatter,
) {

    @ToJson
    fun toJson(dateTime: LocalDateTime): String {
        return dateTimeFormatter.format(dateTime)
    }

    @FromJson
    fun fromJson(value: String): LocalDateTime {
        return LocalDateTime.parse(value, dateTimeFormatter)
    }
}