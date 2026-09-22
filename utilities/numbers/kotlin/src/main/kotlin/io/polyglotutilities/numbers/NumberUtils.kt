package io.polyglotutilities.numbers

object NumberUtils {
    fun clamp(value: Double, minimum: Double, maximum: Double): Double =
        minOf(maxOf(value, minimum), maximum)

    fun isNumeric(value: String?): Boolean =
        value?.isNotEmpty() == true && value.toDoubleOrNull() != null

    fun minValue(values: List<Double>): Double? = values.minOrNull()

    fun maxValue(values: List<Double>): Double? = values.maxOrNull()
}
