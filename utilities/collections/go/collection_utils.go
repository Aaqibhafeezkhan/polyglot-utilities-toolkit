package collections

func Unique[T comparable](items []T) []T {
	seen := make(map[T]struct{}, len(items))
	result := make([]T, 0, len(items))
	for _, item := range items {
		if _, exists := seen[item]; exists { continue }
		seen[item] = struct{}{}
		result = append(result, item)
	}
	return result
}

func GroupBy[T any, K comparable](items []T, keyExtractor func(T) K) map[K][]T {
	result := make(map[K][]T)
	for _, item := range items {
		key := keyExtractor(item)
		result[key] = append(result[key], item)
	}
	return result
}

func Sum(values []float64) float64 {
	var total float64
	for _, value := range values { total += value }
	return total
}

func Average(values []float64) float64 {
	if len(values) == 0 { return 0 }
	return Sum(values) / float64(len(values))
}
