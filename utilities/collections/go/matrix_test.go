package collections

import (
    "reflect"
    "testing"
)

func TestCrossLanguageMatrix(t *testing.T) {
    if got := Unique([]int{3, 1, 3, 2, 1}); !reflect.DeepEqual(got, []int{3, 1, 2}) { t.Fatal(got) }
    if got := Sum([]float64{1, 2, 3, 4}); got != 10 { t.Fatal(got) }
    if got := Average([]float64{1, 2, 3, 4}); got != 2.5 { t.Fatal(got) }
    if got := Average([]float64{}); got != 0 { t.Fatal(got) }
    groups := GroupBy([]struct{ Group string; Value int }{{"a", 1}, {"b", 2}, {"a", 3}}, func(v struct{ Group string; Value int }) string { return v.Group })
    if len(groups["a"]) != 2 || groups["a"][0].Value != 1 || groups["a"][1].Value != 3 { t.Fatal(groups) }
}
