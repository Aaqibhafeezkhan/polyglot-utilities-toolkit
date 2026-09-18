package numbers

import (
	"math"
	"strconv"
)

func Clamp(value, minimum, maximum float64) float64 {
	return math.Min(math.Max(value, minimum), maximum)
}

func IsNumeric(value string) bool {
	if value == "" { return false }
	_, err := strconv.ParseFloat(value, 64)
	return err == nil
}

func MinValue(values []float64) *float64 {
	if len(values) == 0 { return nil }
	result := values[0]
	for _, value := range values[1:] {
		if value < result { result = value }
	}
	return &result
}

func MaxValue(values []float64) *float64 {
	if len(values) == 0 { return nil }
	result := values[0]
	for _, value := range values[1:] {
		if value > result { result = value }
	}
	return &result
}
