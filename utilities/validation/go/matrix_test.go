package validation

import "testing"

func TestCrossLanguageMatrix(t *testing.T) {
    if !IsNonEmpty("ready") || IsNonEmpty("   ") { t.Fatal("non-empty") }
    if !IsEmail("user@example.com") || IsEmail("user@@example.com") { t.Fatal("email") }
    if !IsWithinRange(0, 0, 10) || !IsWithinRange(10, 0, 10) || IsWithinRange(11, 0, 10) { t.Fatal("range") }
}
