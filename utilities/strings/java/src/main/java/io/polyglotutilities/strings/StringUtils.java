package io.polyglotutilities.strings;

import java.util.Locale;
import java.util.regex.Pattern;

public final class StringUtils {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    private StringUtils() {
    }

    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static String capitalize(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }
        int firstCodePoint = value.codePointAt(0);
        return new String(Character.toChars(Character.toUpperCase(firstCodePoint))) + value.substring(Character.charCount(firstCodePoint));
    }

    public static String reverseString(String value) {
        if (value == null) {
            return null;
        }
        return value.codePoints()
                .mapToObj(codePoint -> new String(Character.toChars(codePoint)))
                .reduce("", (result, character) -> character + result);
    }

    public static boolean isValidEmail(String value) {
        return value != null && EMAIL_PATTERN.matcher(value).matches();
    }

    public static String normalizeWhitespace(String value) {
        return value == null ? null : value.trim().replaceAll("\\s+", " ");
    }

    public static String toTitleCase(String value) {
        if (value == null) {
            return null;
        }
        String normalized = normalizeWhitespace(value).toLowerCase(Locale.ROOT);
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        for (int i = 0; i < normalized.length(); i++) {
            char character = normalized.charAt(i);
            if (Character.isWhitespace(character)) {
                result.append(character);
                capitalizeNext = true;
            } else if (capitalizeNext) {
                result.append(Character.toUpperCase(character));
                capitalizeNext = false;
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
