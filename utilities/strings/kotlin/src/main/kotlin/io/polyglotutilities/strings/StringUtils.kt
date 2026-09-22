package io.polyglotutilities.strings

import java.util.Locale

object StringUtils {
    private val emailPattern = Regex("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")

    fun isEmpty(value: String?): Boolean = value.isNullOrEmpty()

    fun capitalize(value: String?): String? {
        if (value.isNullOrEmpty()) {
            return value
        }

        val first = value.codePointAt(0)
        val firstString = String(Character.toChars(first)).uppercase(Locale.ROOT)
        return firstString + value.substring(Character.charCount(first))
    }

    fun reverseString(value: String?): String? {
        if (value == null) {
            return null
        }

        val codePoints = value.codePoints().toArray()
        val builder = StringBuilder(value.length)
        for (index in codePoints.indices.reversed()) {
            builder.appendCodePoint(codePoints[index])
        }
        return builder.toString()
    }

    fun isValidEmail(value: String?): Boolean =
        value != null && emailPattern.matches(value)

    fun normalizeWhitespace(value: String?): String? =
        value?.trim()?.replace(Regex("\\s+"), " ")

    fun toTitleCase(value: String?): String? {
        if (value == null) {
            return null
        }

        val normalized = normalizeWhitespace(value)!!.lowercase(Locale.ROOT)
        val words = normalized.split(' ')
        return words.joinToString(" ") { word ->
            if (word.isEmpty()) word
            else word.substring(0, 1).uppercase(Locale.ROOT) + word.substring(1)
        }
    }
}
