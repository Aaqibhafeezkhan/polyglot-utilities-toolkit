package io.polyglotutilities.dates

import java.time.Duration
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeParseException
import kotlin.math.floor

object DateUtils {
    fun parseDate(value: String?): OffsetDateTime? {
        if (value.isNullOrBlank()) {
            return null
        }

        val normalized = value.trim()
        return try {
            OffsetDateTime.parse(normalized)
        } catch (_: DateTimeParseException) {
            try {
                LocalDateTime.parse(normalized).atOffset(ZoneOffset.UTC)
            } catch (_: DateTimeParseException) {
                null
            }
        }
    }

    fun daysBetween(start: String?, end: String?): Long? {
        val startDate = parseDate(start)
        val endDate = parseDate(end)
        if (startDate == null || endDate == null) {
            return null
        }

        val days = Duration.between(startDate, endDate).seconds / 86400.0
        return floor(days + 0.5).toLong()
    }
}
