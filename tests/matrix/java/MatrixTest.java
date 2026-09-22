import io.polyglotutilities.collections.CollectionUtils;
import io.polyglotutilities.strings.StringUtils;
import io.polyglotutilities.numbers.NumberUtils;
import io.polyglotutilities.dates.DateUtils;
import io.polyglotutilities.validation.ValidationUtils;
import java.util.List;

public final class MatrixTest {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    public static void main(String[] args) {
        check(CollectionUtils.unique(List.of(3, 1, 3, 2, 1)).equals(List.of(3, 1, 2)), "collections unique");
        check(CollectionUtils.sum(List.of(1, 2, 3, 4)) == 10.0, "collections sum");
        check(CollectionUtils.average(List.of(1, 2, 3, 4)) == 2.5, "collections average");
        check(CollectionUtils.average(List.of()) == 0.0, "collections empty average");
        check(StringUtils.isEmpty("") && StringUtils.capitalize("hello").equals("Hello"), "strings basics");
        check(StringUtils.reverseString("A🙂B").equals("B🙂A"), "strings unicode reverse");
        check(StringUtils.isValidEmail("user@example.com"), "strings valid email");
        check(!StringUtils.isValidEmail("user@@example.com"), "strings invalid email");
        check(StringUtils.normalizeWhitespace("  hello \t world  ").equals("hello world"), "strings whitespace");
        check(StringUtils.toTitleCase("hello world").equals("Hello World"), "strings title");
        check(NumberUtils.clamp(-2, 0, 10) == 0 && NumberUtils.clamp(12, 0, 10) == 10, "numbers clamp");
        check(NumberUtils.isNumeric("12.5") && !NumberUtils.isNumeric("12x"), "numbers numeric");
        check(NumberUtils.minValue(List.of(4, 2, 7)) == 2.0 && NumberUtils.maxValue(List.of(4, 2, 7)) == 7.0, "numbers min max");
        check(DateUtils.parseDate("2026-01-01T00:00:00Z") != null, "dates valid");
        check(DateUtils.parseDate("not-a-date") == null, "dates invalid");
        check(DateUtils.daysBetween("2026-01-01T00:00:00Z", "2026-01-03T00:00:00Z") == 2L, "dates days");
        check(DateUtils.parseDate("2026-01-01T00:00:00") != null, "dates local");
        check(ValidationUtils.isNonEmpty("ready") && !ValidationUtils.isNonEmpty("   "), "validation non-empty");
        check(ValidationUtils.isEmail("user@example.com") && !ValidationUtils.isEmail("user@@example.com"), "validation email");
        check(ValidationUtils.isWithinRange(0, 0, 10) && ValidationUtils.isWithinRange(10, 0, 10) && !ValidationUtils.isWithinRange(11, 0, 10), "validation range");
    }
}
