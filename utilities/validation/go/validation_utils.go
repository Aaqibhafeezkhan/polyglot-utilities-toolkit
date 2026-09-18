package validation

import (
	"math"
	"regexp"
	"strings"
)

var emailPattern = regexp.MustCompile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")

func IsNonEmpty(value string) bool { return strings.TrimSpace(value) != "" }
func IsEmail(value string) bool { return emailPattern.MatchString(value) }
func IsWithinRange(value, minimum, maximum float64) bool {
	return !math.IsNaN(value) && !math.IsInf(value, 0) && value >= minimum && value <= maximum
}
