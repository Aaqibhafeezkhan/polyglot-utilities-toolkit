# Core Utility Coverage

Phase 4 expands reusable coverage across the existing capability domains without changing the capability-first architecture.

## Collections

JavaScript, Python, C++, Java, Go, and Rust provide collection helpers for common operations such as uniqueness, grouping, aggregation, and averages. Existing language-specific names remain idiomatic while equivalent behavior follows the cross-language contracts.

## Strings

JavaScript, Python, Java, Go, and Rust provide reusable string helpers for empty-value detection, capitalization, reversal, email-shape validation, whitespace normalization, and title casing. C++ provides reusable case conversion helpers.

## Numbers

JavaScript, Python, Java, Go, and Rust provide clamp, numeric detection, minimum, and maximum helpers. C++ provides numeric detection plus minimum and maximum helpers under the same capability domain.

For empty collections, minimum and maximum use language-appropriate absence representations where available.

## Dates and validation

Java, Go, Rust, JavaScript, Python, and TypeScript provide reusable date and validation capabilities. Go and Rust date implementations remain independent from framework-specific integrations and document their standard-library differences.

## Forms, models, runtime, and UI

These domains remain intentionally separate from general-purpose utility implementations. Language expansion should not move framework-specific concerns into the shared capability layer.
