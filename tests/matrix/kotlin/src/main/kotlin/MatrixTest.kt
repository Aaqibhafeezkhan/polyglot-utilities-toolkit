import io.polyglotutilities.collections.CollectionUtils
import io.polyglotutilities.strings.StringUtils
import io.polyglotutilities.numbers.NumberUtils
import io.polyglotutilities.dates.DateUtils
import io.polyglotutilities.validation.ValidationUtils

fun check(condition: Boolean, message: String) {
    if (!condition) error(message)
}

fun main() {
    check(CollectionUtils.unique(listOf(3, 1, 3, 2, 1)) == listOf(3, 1, 2), "collections unique")
    check(CollectionUtils.sum(listOf(1.0, 2.0, 3.0, 4.0)) == 10.0, "collections sum")
    check(CollectionUtils.average(listOf(1.0, 2.0, 3.0, 4.0)) == 2.5, "collections average")
    check(CollectionUtils.average(emptyList()) == 0.0, "collections empty average")
    check(StringUtils.isEmpty(""), "strings empty")
    check(StringUtils.capitalize("hello") == "Hello", "strings capitalize")
    check(StringUtils.reverseString("A🙂B") == "B🙂A", "strings reverse")
    check(StringUtils.isValidEmail("user@example.com") && !StringUtils.isValidEmail("user@@example.com"), "strings email")
    check(StringUtils.normalizeWhitespace("  hello \t world  ") == "hello world", "strings whitespace")
    check(StringUtils.toTitleCase("hello world") == "Hello World", "strings title")
    check(NumberUtils.clamp(-2.0, 0.0, 10.0) == 0.0, "numbers low clamp")
    check(NumberUtils.clamp(12.0, 0.0, 10.0) == 10.0, "numbers high clamp")
    check(NumberUtils.clamp(10.0, 0.0, 10.0) == 10.0, "numbers boundary clamp")
    check(NumberUtils.isNumeric("12.5") && !NumberUtils.isNumeric("12x"), "numbers numeric")
    check(NumberUtils.minValue(listOf(4.0, 2.0, 7.0)) == 2.0, "numbers min")
    check(NumberUtils.maxValue(listOf(4.0, 2.0, 7.0)) == 7.0, "numbers max")
    check(DateUtils.parseDate("2026-01-01T00:00:00Z") != null, "dates valid")
    check(DateUtils.parseDate("not-a-date") == null, "dates invalid")
    check(DateUtils.daysBetween("2026-01-01T00:00:00Z", "2026-01-03T00:00:00Z") == 2L, "dates days")
    check(DateUtils.parseDate("2026-01-01T00:00:00") != null, "dates local")
    check(ValidationUtils.isNonEmpty("ready") && !ValidationUtils.isNonEmpty("   "), "validation non-empty")
    check(ValidationUtils.isEmail("user@example.com") && !ValidationUtils.isEmail("user@@example.com"), "validation email")
    check(ValidationUtils.isWithinRange(0.0, 0.0, 10.0) && ValidationUtils.isWithinRange(10.0, 0.0, 10.0) && !ValidationUtils.isWithinRange(11.0, 0.0, 10.0), "validation range")
}
