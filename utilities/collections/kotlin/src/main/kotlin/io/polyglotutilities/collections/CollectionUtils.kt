package io.polyglotutilities.collections

object CollectionUtils {
    fun <T> unique(items: List<T>): List<T> = items.distinct()

    fun <T, K> groupBy(items: List<T>, keySelector: (T) -> K): Map<K, List<T>> =
        items.groupBy(keySelector)

    fun sum(values: List<Double>): Double = values.sum()

    fun average(values: List<Double>): Double = if (values.isEmpty()) 0.0 else values.average()
}
