package strings

import (
	"regexp"
	"strings"
	"unicode"
)

var emailPattern = regexp.MustCompile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")

func IsEmpty(value string) bool { return value == "" }

func Capitalize(value string) string {
	if value == "" { return value }
	runes := []rune(value)
	runes[0] = unicode.ToUpper(runes[0])
	return string(runes)
}

func ReverseString(value string) string {
	runes := []rune(value)
	for left, right := 0, len(runes)-1; left < right; left, right = left+1, right-1 {
		runes[left], runes[right] = runes[right], runes[left]
	}
	return string(runes)
}

func IsValidEmail(value string) bool { return emailPattern.MatchString(value) }

func NormalizeWhitespace(value string) string {
	return strings.Join(strings.Fields(value), " ")
}

func ToTitleCase(value string) string {
	normalized := strings.ToLower(strings.TrimSpace(value))
	if normalized == "" { return normalized }
	words := strings.Fields(normalized)
	for i, word := range words {
		runes := []rune(word)
		if len(runes) > 0 { runes[0] = unicode.ToUpper(runes[0]) }
		words[i] = string(runes)
	}
	return strings.Join(words, " ")
}
