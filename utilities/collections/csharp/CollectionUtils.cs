namespace PolyglotUtilities.Collections;

public static class CollectionUtils
{
    public static List<T> Unique<T>(IEnumerable<T> items)
    {
        return items.Distinct().ToList();
    }

    public static Dictionary<TKey, List<T>> GroupBy<T, TKey>(
        IEnumerable<T> items,
        Func<T, TKey> keySelector) where TKey : notnull
    {
        var groups = new Dictionary<TKey, List<T>>();
        foreach (var item in items)
        {
            var key = keySelector(item);
            if (!groups.TryGetValue(key, out var values))
            {
                values = new List<T>();
                groups[key] = values;
            }

            values.Add(item);
        }

        return groups;
    }

    public static double Sum(IEnumerable<double> values)
    {
        return values.Sum();
    }

    public static double Average(IEnumerable<double> values)
    {
        var materialized = values.ToList();
        return materialized.Count == 0 ? 0 : materialized.Average();
    }
}
