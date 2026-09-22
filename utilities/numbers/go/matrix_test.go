package numbers

import "testing"

func TestCrossLanguageMatrix(t *testing.T) {
    if got := Clamp(-2, 0, 10); got != 0 { t.Fatal(got) }
    if got := Clamp(12, 0, 10); got != 10 { t.Fatal(got) }
    if got := Clamp(10, 0, 10); got != 10 { t.Fatal(got) }
    if !IsNumeric("12.5") || IsNumeric("12x") { t.Fatal("numeric") }
    if got := *MinValue([]float64{4, 2, 7}); got != 2 { t.Fatal(got) }
    if got := *MaxValue([]float64{4, 2, 7}); got != 7 { t.Fatal(got) }
}
