package io.polyglotutilities.dates;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;

public final class DateUtils {
    private DateUtils() {
    }

    public static OffsetDateTime parseDate(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return OffsetDateTime.parse(value.trim());
        } catch (DateTimeParseException exception) {
            try {
                return OffsetDateTime.of(
                        java.time.LocalDateTime.parse(value.trim()),
                        ZoneOffset.UTC
                );
            } catch (DateTimeParseException ignored) {
                return null;
            }
        }
    }

    public static Long daysBetween(String start, String end) {
        OffsetDateTime startDate = parseDate(start);
        OffsetDateTime endDate = parseDate(end);
        if (startDate == null || endDate == null) {
            return null;
        }
        return Math.round(Duration.between(startDate, endDate).toSeconds() / 86400.0);
    }
}
