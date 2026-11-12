# Cross-Language Utility Contracts

Equivalent utilities should share observable intent even when their APIs follow language conventions. These contracts describe behavior rather than syntax.

## Common contract

Every reusable utility should make these points clear:

- Input domain and accepted types.
- Output type and meaning.
- Whether the input is mutated.
- Error behavior for invalid input.
- Behavior for empty input.
- Boundary behavior.
- Determinism and ordering guarantees when relevant.
- Any intentional language-specific difference.

## Representative contracts

### Collections

Collection utilities should preserve the source collection unless mutation is explicitly part of the utility's purpose. Empty collections should produce the natural empty result for the operation rather than an unrelated sentinel. Ordering should be preserved unless the utility explicitly changes ordering.

Examples of aligned behavior:

- Filter returns matching elements in source order.
- Map returns one output for each input element in source order.
- Deduplication documents whether the first or last occurrence is retained.
- Partitioning documents the treatment of empty collections.

#### Empty-input behavior across operations

- **Deduplication / Unique**: Passing an empty collection returns an empty collection of the same collection type (`[]` in JS/TS/Python, empty slice in Go, empty `List` in Java/C#/Kotlin, empty `Vec` in Rust, empty `std::vector` in C++).
- **Grouping (`groupBy` / `group_by`)**: Passing an empty collection produces an empty map/dictionary (`{}` in JS/TS/Python, empty `map` in Go, empty `Map` in Java/Kotlin, empty `Dictionary` in C#, empty `HashMap` in Rust).
- **Aggregation (`sum` and `average`)**:
  - `sum` on an empty collection evaluates to `0` / `0.0`.
  - `average` on an empty collection returns `0` / `0.0` rather than raising a division-by-zero exception or returning `NaN`.
- **Minimum and Maximum (`minValue`, `maxValue`)**:
  - Most language implementations return their idiomatic absent representation: `undefined` (JavaScript, TypeScript), `None` (Python), `null` (Java, C#, Kotlin), `nil` pointer (Go), or `None` option (Rust).
  - *Intentional language-specific difference*: In C++, where scalar values without optional wrappers are returned, empty inputs evaluate to `0`.

### Strings

String utilities should treat their input as a value and should not mutate caller-owned state. Empty strings and whitespace-only strings must have explicit behavior. Unicode-sensitive behavior must not be described as ASCII-only unless that restriction is intentional.

Examples of aligned behavior:

- Normalization documents which transformations are applied.
- Truncation documents whether the limit counts characters, code points, or another unit.
- Parsing distinguishes malformed input from a valid empty value.

#### Unicode string reversal and supported units

String reversal implementations across the repository operate at different units of representation depending on the language runtime and standard library capabilities:

- **Unicode Code Points / Scalar Values**:
  The strict-parity matrix fixture in [`tests/matrix/fixtures/core-utility-cases.json`](../tests/matrix/fixtures/core-utility-cases.json) specifies the canonical case `"A🙂B"` $\rightarrow$ `"B🙂A"`. The following implementations iterate by Unicode scalar values / code points so surrogate pairs or multi-byte scalar sequences are preserved intact without corrupting supplementary plane characters:
  - **JavaScript & TypeScript**: Spread operator `[...value].reverse().join('')` iterates by UTF-16 code points.
  - **Python**: In Python 3, strings represent Unicode code points, and slicing `value[::-1]` reverses code points cleanly.
  - **Go**: Operates over UTF-8 runes (`[]rune(value)`).
  - **Rust**: Reverses Unicode scalar values via `value.chars().rev().collect()`.
  - **Java**: Streams Unicode code points with `value.codePoints().mapToObj(...).reduce(...)`.
  - **Kotlin**: Reverses array of Unicode code points via `value.codePoints().toArray()`.
  - **C#**: Reverses `value.EnumerateRunes()` to preserve complete Unicode scalar runes.
- **Bytes (ASCII / Byte-oriented)**:
  - **C++**: The current partial implementation in `utilities/strings/cpp/basic_utils.cpp` uses `std::reverse(result.begin(), result.end())` on `std::string`, which reverses individual `char` bytes. It is verified for ASCII strings (`"ABC"` $\rightarrow$ `"CBA"`) in `tests/matrix/cpp/matrix_test.cpp`. It does not support multi-byte UTF-8 code point or grapheme cluster reversal.
- **Grapheme Clusters**:
  - None of the standard string reversal helpers currently use extended grapheme cluster breaking (e.g. combining accent marks, emoji modifier sequences, or ZWJ sequences). Characters with combining marks will invert relative to their base characters unless normalized or handled by external grapheme segmentation libraries.

### Numbers

Numeric utilities should document boundary inclusion and invalid numeric input. Floating-point behavior should not be described as exact arithmetic when the language runtime uses binary floating point.

Examples of aligned behavior:

- Clamp includes both configured boundaries.
- Range utilities document inclusive or exclusive endpoints.
- Rounding utilities document the tie-breaking rule when it matters.

### Dates

Date utilities must document timezone assumptions, calendar boundaries, and invalid dates. A utility should not silently change a date's timezone semantics between language implementations.

### Validation

Validation utilities should distinguish valid input from invalid input without silently coercing values unless coercion is part of the documented contract. Equivalent validators should agree on the same representative valid, invalid, empty, and boundary cases.

## Errors

Prefer the host language's idiomatic error mechanism while preserving the contract's meaning. An exception in one language and a result object or error value in another can be equivalent when both clearly represent the same invalid-input condition.

Do not require identical error class names or identical API shapes across languages.

## Mutation

Utilities should default to non-mutating behavior unless mutation is explicit, useful, and documented. A language-specific optimization must not silently change the observable mutation contract.

## Intentional differences

Differences are acceptable when they follow language or runtime conventions. Document differences when they affect callers, such as zero-based versus one-based indexing, nullable representations, integer overflow rules, Unicode handling, timezone APIs, or error representation.

The goal is semantic alignment, not artificial API uniformity.
