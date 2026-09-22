using System.Globalization;

namespace PolyglotUtilities.Dates;

public static class DateUtils
{
    public static DateTimeOffset? ParseDate(string? value)
    {
        if (string.IsNullOrWhiteSpace(value))
        {
            return null;
        }

        return DateTimeOffset.TryParse(
            value.Trim(),
            CultureInfo.InvariantCulture,
            DateTimeStyles.AssumeUniversal | DateTimeStyles.AdjustToUniversal,
            out var result)
            ? result
            : null;
    }

    public static long? DaysBetween(string? start, string? end)
    {
        var startDate = ParseDate(start);
        var endDate = ParseDate(end);
        if (startDate is null || endDate is null)
        {
            return null;
        }

        return (long)Math.Floor(
            (endDate.Value - startDate.Value).TotalSeconds / 86400.0 + 0.5);
    }
}
