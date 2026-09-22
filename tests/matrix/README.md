# Cross-Language Test Matrix

The matrix is the manual compatibility suite for the repository's equivalent core utilities.

## Canonical cases

tests/matrix/fixtures/core-utility-cases.json defines representative inputs and expected semantic results for collections, strings, numbers, dates, and validation.

Every native runner uses the same cases. The runners assert behavior locally inside each language; no language executes another language's code.

## Strict parity languages

The strict matrix currently covers JavaScript, Python, Java, Go, Rust, C#, and Kotlin.

These languages expose equivalent core capabilities across the five domains.

C++ remains a partial-capability implementation and is tested separately for the behavior it currently exposes. TypeScript validation files are generated API models rather than an equivalent core validation implementation, so they are not part of the strict parity set.

## Expected semantics

- Collection uniqueness preserves first occurrence order.
- Collection sums and averages use numeric values; empty average returns zero.
- String reversal is Unicode-aware where the language provides scalar/code-point iteration.
- Email checks implement the repository's documented email-shape contract.
- Whitespace normalization collapses runs of whitespace and trims the result.
- Clamp includes both boundaries.
- Numeric parsing does not coerce malformed input.
- Minimum and maximum return the language's absence representation for empty input where supported.
- Dates accept explicit-offset ISO values and interpret local date-time values as UTC.
- Invalid dates are rejected without throwing from the public date helper where the existing contract specifies nullable or optional results.
- Validation range checks are inclusive.
- Validation does not coerce input.

## Manual commands

From the repository root:

### Python

python -m unittest discover -s tests/matrix/python -p "test_*.py"

### JavaScript

node --experimental-default-type=module tests/matrix/javascript/test_matrix.mjs

### Java

Compile the five capability sources and tests/matrix/java/MatrixTest.java with javac, then run MatrixTest with java.

### Go

Run go test in each Go capability directory:
- utilities/collections/go
- utilities/strings/go
- utilities/numbers/go
- utilities/dates/go
- utilities/validation/go

### Rust

Run cargo test in each Rust capability directory:
- utilities/collections/rust
- utilities/strings/rust
- utilities/numbers/rust
- utilities/dates/rust
- utilities/validation/rust

### C#

dotnet run --project tests/matrix/csharp

### Kotlin

gradle -p tests/matrix/kotlin run

### C++

Compile the available C++ utility sources together with tests/matrix/cpp/matrix_test.cpp using a C++17 compiler, then run the executable.

## Verification rule

Phase verification is complete only when every strict-parity runner passes and the C++ partial-capability regression runner passes.

No GitHub Actions are required; validation remains manual by project design.
