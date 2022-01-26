package com.sk.splash.data.utils.utils

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class UIDateTimeConverter(
    private val dateTimeFormatter: DateTimeFormatter
) {
    fun toDateTime(value: String?): LocalDateTime? {
        return if (value == null) null else LocalDateTime.parse(value, dateTimeFormatter)
    }

    fun toString(value: LocalDateTime?): String? {
        return value?.format(dateTimeFormatter)
    }
}