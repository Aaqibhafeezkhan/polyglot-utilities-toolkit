package strings

import "testing"

func TestCrossLanguageMatrix(t *testing.T) {
    if IsEmpty("x") || !IsEmpty("") { t.Fatal("empty") }
    if got := Capitalize("hello"); got != "Hello" { t.Fatal(got) }
    if got := ReverseString("A🙂B"); got != "B🙂A" { t.Fatal(got) }
    if !IsValidEmail("user@example.com") || IsValidEmail("user@@example.com") { t.Fatal("email") }
    if got := NormalizeWhitespace("  hello \\t world  "); got != "hello world" { t.Fatal(got) }
    if got := ToTitleCase("hello world"); got != "Hello World" { t.Fatal(got) }
}
