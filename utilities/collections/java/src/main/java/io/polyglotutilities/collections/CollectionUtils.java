package io.polyglotutilities.collections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> List<T> unique(List<T> items) {
        return new ArrayList<>(new LinkedHashSet<>(items));
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> items, Function<T, K> keyExtractor) {
        return items.stream().collect(Collectors.groupingBy(
                keyExtractor,
                LinkedHashMap::new,
                Collectors.toList()
        ));
    }

    public static double sum(List<? extends Number> values) {
        return values.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static double average(List<? extends Number> values) {
        return values.isEmpty() ? 0 : sum(values) / values.size();
    }
}
