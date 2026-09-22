using System.Text.RegularExpressions;

namespace PolyglotUtilities.Validation;

public static class ValidationUtils
{
    private static readonly Regex EmailPattern = new("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$", RegexOptions.Compiled);

    public static bool IsNonEmpty(string? value)
    {
        return !string.IsNullOrWhiteSpace(value);
    }

    public static bool IsEmail(string? value)
    {
        return value is not null && EmailPattern.IsMatch(value);
    }

    public static bool IsWithinRange(double value, double minimum, double maximum)
    {
        return double.IsFinite(value) && value >= minimum && value <= maximum;
    }
}
