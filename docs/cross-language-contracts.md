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

### Strings

String utilities should treat their input as a value and should not mutate caller-owned state. Empty strings and whitespace-only strings must have explicit behavior. Unicode-sensitive behavior must not be described as ASCII-only unless that restriction is intentional.

Examples of aligned behavior:

- Normalization documents which transformations are applied.
- Truncation documents whether the limit counts characters, code points, or another unit.
- Parsing distinguishes malformed input from a valid empty value.

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
