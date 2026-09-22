# Cross-Language Test Matrix

Phase 10 establishes a repeatable compatibility suite for equivalent core utilities.

## Matrix coverage

| Capability | JavaScript | Python | Java | Go | Rust | C# | Kotlin | C++ |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Collections | strict | strict | strict | strict | strict | strict | strict | partial |
| Strings | strict | strict | strict | strict | strict | strict | strict | partial |
| Numbers | strict | strict | strict | strict | strict | strict | strict | partial |
| Dates | strict | strict | strict | strict | strict | strict | strict | not implemented |
| Validation | strict | strict | strict | strict | strict | strict | strict | not implemented |

Strict means the implementation exposes the capability required by the common matrix. Partial means only the utility surface currently present in that language is regression-tested.

## Canonical fixture

The representative cases live in tests/matrix/fixtures/core-utility-cases.json.

The fixture covers:

- valid inputs
- invalid and malformed inputs
- empty collections and empty strings
- Unicode string reversal
- inclusive numeric boundaries
- explicit-offset and local date-time parsing
- validation boundaries
- non-coercing numeric and validation behavior

The native runners encode these same cases using each language's idiomatic assertion mechanism.

## Language runners

- Python: unittest
- JavaScript: Node assertions
- Java: javac/java assertion harness
- Go: go test
- Rust: cargo test
- C#: dotnet run test project
- Kotlin: Gradle application runner
- C++: C++17 assertion harness

No runner requires one language to invoke another language's code.

## Compatibility rules

The matrix checks observable semantics, not identical signatures.

- Uniqueness preserves first occurrence order where the strict contract applies.
- Empty averages return zero.
- Unicode reversal operates on code points/scalar values where the language API supports it.
- Clamp includes both configured boundaries.
- Invalid numeric text is rejected rather than coerced.
- Minimum and maximum use the language's idiomatic absence representation for empty input.
- Local date-time values are interpreted as UTC.
- Invalid dates are rejected through the language's existing nullable/optional/error semantics.
- Validation ranges are inclusive.
- Validation does not coerce values.

## Adding a language

A new implementation can join the matrix by:

1. Implementing the relevant capability under utilities/<capability>/<language>.
2. Adding a native runner that exercises the canonical cases.
3. Recording intentional semantic differences in docs/cross-language-contracts.md.
4. Adding the language to this matrix.
5. Running the existing manual verification commands before merge.

The test strategy intentionally avoids a shared runtime or cross-language execution dependency.
