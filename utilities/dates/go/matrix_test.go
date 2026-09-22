package dates

import "testing"

func TestCrossLanguageMatrix(t *testing.T) {
    if value, err := ParseDate("2026-01-01T00:00:00Z"); err != nil || value == nil { t.Fatal(value, err) }
    if value, err := ParseDate("not-a-date"); err == nil || value != nil { t.Fatal(value, err) }
    if got, err := DaysBetween("2026-01-01T00:00:00Z", "2026-01-03T00:00:00Z"); err != nil || got == nil || *got != 2 { t.Fatal(got, err) }
    if value, err := ParseDate("2026-01-01 00:00:00"); err != nil || value == nil { t.Fatal(value, err) }
}
