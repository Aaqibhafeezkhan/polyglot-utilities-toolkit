package io.polyglotutilities.validation

object ValidationUtils {
    private val emailPattern = Regex("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")

    fun isNonEmpty(value: String?): Boolean =
        !value.isNullOrBlank()

    fun isEmail(value: String?): Boolean =
        value != null && emailPattern.matches(value)

    fun isWithinRange(value: Double, minimum: Double, maximum: Double): Boolean =
        value.isFinite() && value >= minimum && value <= maximum
}
