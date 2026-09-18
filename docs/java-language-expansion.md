# Java Language Expansion

Java implementations are added beneath the existing capability domains so the repository remains capability-first.

## Covered capabilities

- Collections: uniqueness, grouping, sum, and average.
- Strings: empty checks, capitalization, Unicode-aware reversal, email-shape validation, whitespace normalization, and title casing.
- Numbers: clamping, numeric detection, minimum, and maximum.
- Dates: ISO date-time parsing and day differences with explicit UTC handling for local date-time values.
- Validation: non-empty, email-shape, and inclusive numeric-range validation.

## Build and run

Each Java capability is an independent Maven project. From a capability directory, run:

```text
mvn test
mvn package
```

The projects use Java 17 and have no external runtime dependencies.

## Cross-language behavior

The implementations follow the repository contracts while using Java idioms:

- Empty collection minimum and maximum return `null`.
- Collection ordering is preserved for uniqueness and grouping.
- String reversal operates on Unicode code points rather than UTF-16 code units.
- Invalid dates return `null`.
- Date values without an explicit offset are interpreted as UTC.
- Validation does not coerce values.
