namespace PolyglotUtilities.Numbers;

public static class NumberUtils
{
    public static double Clamp(double value, double minimum, double maximum)
    {
        return Math.Min(Math.Max(value, minimum), maximum);
    }

    public static bool IsNumeric(string? value)
    {
        return value is not null && value.Length > 0 && double.TryParse(
            value,
            System.Globalization.NumberStyles.Float,
            System.Globalization.CultureInfo.InvariantCulture,
            out _);
    }

    public static double? MinValue(IEnumerable<double> values)
    {
        var materialized = values.ToList();
        return materialized.Count == 0 ? null : materialized.Min();
    }

    public static double? MaxValue(IEnumerable<double> values)
    {
        var materialized = values.ToList();
        return materialized.Count == 0 ? null : materialized.Max();
    }
}
