using System.Text;
using System.Text.RegularExpressions;

namespace PolyglotUtilities.Strings;

public static class StringUtils
{
    private static readonly Regex EmailPattern = new("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$", RegexOptions.Compiled);

    public static bool IsEmpty(string? value)
    {
        return string.IsNullOrEmpty(value);
    }

    public static string? Capitalize(string? value)
    {
        if (string.IsNullOrEmpty(value))
        {
            return value;
        }

        var firstRune = value.EnumerateRunes().First();
        var builder = new StringBuilder();
        builder.Append(firstRune.ToString().ToUpperInvariant());
        builder.Append(value[firstRune.Utf16SequenceLength..]);
        return builder.ToString();
    }

    public static string? ReverseString(string? value)
    {
        if (value is null)
        {
            return null;
        }

        var runes = value.EnumerateRunes().ToArray();
        var builder = new StringBuilder(value.Length);
        for (var index = runes.Length - 1; index >= 0; index--)
        {
            builder.Append(runes[index].ToString());
        }

        return builder.ToString();
    }

    public static bool IsValidEmail(string? value)
    {
        return value is not null && EmailPattern.IsMatch(value);
    }

    public static string? NormalizeWhitespace(string? value)
    {
        return value is null ? null : Regex.Replace(value.Trim(), @"\\s+", " ");
    }

    public static string? ToTitleCase(string? value)
    {
        if (value is null)
        {
            return null;
        }

        var normalized = NormalizeWhitespace(value)!.ToLowerInvariant();
        var builder = new StringBuilder(normalized.Length);
        var capitalizeNext = true;

        foreach (var rune in normalized.EnumerateRunes())
        {
            if (Rune.IsWhiteSpace(rune))
            {
                builder.Append(rune.ToString());
                capitalizeNext = true;
            }
            else if (capitalizeNext)
            {
                builder.Append(rune.ToString().ToUpperInvariant());
                capitalizeNext = false;
            }
            else
            {
                builder.Append(rune.ToString());
            }
        }

        return builder.ToString();
    }
}
