package com.sk.splash.local.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

@ProvidedTypeConverter
class LocalDateTimeConverter(
    private val dateTimeFormatter: DateTimeFormatter
) {
    @TypeConverter
    fun stringToDateTime(value: String?): LocalDateTime? {
        return if (value == null) null else LocalDateTime.parse(value, dateTimeFormatter)
    }

    @TypeConverter
    fun dateTimeToString(value: LocalDateTime?): String? {
        return value?.format(dateTimeFormatter)
    }
}