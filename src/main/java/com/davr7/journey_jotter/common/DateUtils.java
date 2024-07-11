package com.davr7.journey_jotter.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtils {
    private static final DateTimeFormatter ISO_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public static LocalDateTime parseIsoDateTime(String dateStr) {
        return LocalDateTime.parse(dateStr, ISO_DATE_TIME_FORMATTER);
    }
}
