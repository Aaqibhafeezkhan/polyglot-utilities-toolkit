# C# and Kotlin Language Expansion

C# and Kotlin implementations extend the capability-first structure without introducing top-level language silos.

## Covered capabilities

Both languages now provide implementations for the core utility domains:

- Collections: uniqueness, grouping, sum, and average.
- Strings: empty checks, capitalization, Unicode-aware reversal, email-shape validation, whitespace normalization, and title casing.
- Numbers: clamping, numeric detection, minimum, and maximum.
- Dates: ISO date-time parsing and day differences with explicit UTC handling for local date-time values.
- Validation: non-empty, email-shape, and inclusive numeric-range validation.

## Repository layout

```text
utilities/
├── collections/
│   ├── csharp/
│   ├── java/
│   ├── javascript/
│   ├── kotlin/
│   ├── python/
│   └── rust/
├── dates/
│   ├── csharp/
│   ├── ...
│   └── kotlin/
├── numbers/
│   ├── csharp/
│   ├── ...
│   └── kotlin/
├── strings/
│   ├── csharp/
│   ├── ...
│   └── kotlin/
└── validation/
    ├── csharp/
    ├── ...
    └── kotlin/
```

No C# or Kotlin directory exists directly under `utilities/`; the capability remains the primary architectural boundary.

## C#

Each C# capability is an independent SDK-style .NET project targeting `net8.0`.

From a capability directory:

```text
dotnet build
```

The projects use the BCL only and keep ecosystem-specific project configuration next to the implementation.

C# follows the common contracts with idiomatic .NET representations:

- `Unique` preserves first occurrence order through LINQ `Distinct`.
- `GroupBy` preserves item order inside each group.
- Empty averages return `0`; empty minimum/maximum return nullable `null`.
- String reversal iterates Unicode scalar values through `Rune` rather than UTF-16 code units.
- Numeric parsing uses invariant culture.
- Date values without an explicit offset are interpreted as UTC.
- Invalid dates return nullable `null`.
- Validation does not coerce values.

## Kotlin

Each Kotlin capability is an independent JVM project using Gradle Kotlin DSL and Kotlin 2.4.20.

From a capability directory:

```text
gradle build
```

The projects use the JVM standard library and Java `java.time` APIs without application-framework dependencies.

Kotlin follows the common contracts with idiomatic JVM representations:

- `distinct` preserves first occurrence order.
- `groupBy` preserves source order within grouped lists.
- Empty averages return `0.0`; empty minimum/maximum return `null`.
- String reversal operates on Unicode code points.
- Numeric parsing uses Kotlin's non-coercing `toDoubleOrNull`.
- Date values without an explicit offset are interpreted as UTC.
- Invalid dates return `null`.
- Validation does not coerce values.

## Intentional language differences

The implementations are semantically aligned rather than syntactically identical.

- C# exposes nullable values with `double?` and `DateTimeOffset?`; Kotlin uses nullable types such as `Double?` and `OffsetDateTime?`.
- C# collection APIs use `IEnumerable<T>`, while Kotlin uses `List<T>`.
- C# uses .NET `Rune` APIs for Unicode scalar iteration; Kotlin interoperates with Java code-point APIs.
- C# projects target .NET 8; Kotlin projects target the JVM with toolchain 21. These are ecosystem build choices and do not change the utility contracts.

## Verification

For each new language/capability project:

```text
dotnet build
```

or:

```text
gradle build
```

The phase does not add GitHub Actions. Validation and execution remain manual as specified by the epic.
