package io.polyglotutilities.numbers;

import java.util.List;

public final class NumberUtils {
    private NumberUtils() {
    }

    public static double clamp(double value, double minimum, double maximum) {
        return Math.min(Math.max(value, minimum), maximum);
    }

    public static boolean isNumeric(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static Double minValue(List<? extends Number> values) {
        return values.stream().map(Number::doubleValue).min(Double::compare).orElse(null);
    }

    public static Double maxValue(List<? extends Number> values) {
        return values.stream().map(Number::doubleValue).max(Double::compare).orElse(null);
    }
}
