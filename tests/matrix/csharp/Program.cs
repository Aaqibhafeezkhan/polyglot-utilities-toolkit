using PolyglotUtilities.Collections;
using PolyglotUtilities.Strings;
using PolyglotUtilities.Numbers;
using PolyglotUtilities.Dates;
using PolyglotUtilities.Validation;

static class Program
{
    static void Check(bool condition, string message)
    {
        if (!condition) throw new InvalidOperationException(message);
    }

    static void Main()
    {
        Check(CollectionUtils.Unique(new[] { 3, 1, 3, 2, 1 }).SequenceEqual(new[] { 3, 1, 2 }), "collections unique");
        Check(CollectionUtils.Sum(new[] { 1.0, 2.0, 3.0, 4.0 }) == 10, "collections sum");
        Check(CollectionUtils.Average(new[] { 1.0, 2.0, 3.0, 4.0 }) == 2.5, "collections average");
        Check(CollectionUtils.Average(Array.Empty<double>()) == 0, "collections empty average");
        Check(StringUtils.IsEmpty(""), "strings empty");
        Check(StringUtils.Capitalize("hello") == "Hello", "strings capitalize");
        Check(StringUtils.ReverseString("A🙂B") == "B🙂A", "strings reverse");
        Check(StringUtils.IsValidEmail("user@example.com") && !StringUtils.IsValidEmail("user@@example.com"), "strings email");
        Check(StringUtils.NormalizeWhitespace("  hello \t world  ") == "hello world", "strings whitespace");
        Check(StringUtils.ToTitleCase("hello world") == "Hello World", "strings title");
        Check(NumberUtils.Clamp(-2, 0, 10) == 0 && NumberUtils.Clamp(12, 0, 10) == 10 && NumberUtils.Clamp(10, 0, 10) == 10, "numbers clamp");
        Check(NumberUtils.IsNumeric("12.5") && !NumberUtils.IsNumeric("12x"), "numbers numeric");
        Check(NumberUtils.MinValue(new[] { 4.0, 2.0, 7.0 }) == 2 && NumberUtils.MaxValue(new[] { 4.0, 2.0, 7.0 }) == 7, "numbers min max");
        Check(DateUtils.ParseDate("2026-01-01T00:00:00Z") is not null, "dates valid");
        Check(DateUtils.ParseDate("not-a-date") is null, "dates invalid");
        Check(DateUtils.DaysBetween("2026-01-01T00:00:00Z", "2026-01-03T00:00:00Z") == 2, "dates days");
        Check(DateUtils.ParseDate("2026-01-01T00:00:00") is not null, "dates local");
        Check(ValidationUtils.IsNonEmpty("ready") && !ValidationUtils.IsNonEmpty("   "), "validation non-empty");
        Check(ValidationUtils.IsEmail("user@example.com") && !ValidationUtils.IsEmail("user@@example.com"), "validation email");
        Check(ValidationUtils.IsWithinRange(0, 0, 10) && ValidationUtils.IsWithinRange(10, 0, 10) && !ValidationUtils.IsWithinRange(11, 0, 10), "validation range");
    }
}
