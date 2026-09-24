# Cross-Language Test Matrix

Phase 10 establishes a repeatable compatibility suite for equivalent core utilities.

## Matrix coverage

| Capability | TypeScript | JavaScript | Python | Java | Go | Rust | C# | Kotlin | C++ |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| Collections | strict | strict | strict | strict | strict | strict | strict | strict | partial |
| Strings | strict | strict | strict | strict | strict | strict | strict | strict | partial |
| Numbers | strict | strict | strict | strict | strict | strict | strict | strict | partial |
| Dates | not in core runner | strict | strict | strict | strict | strict | strict | strict | not implemented |
| Validation | not in core runner | strict | strict | strict | strict | strict | strict | strict | not implemented |

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

- TypeScript: tsx
- Python: unittest
- JavaScript: Node assertions
- Java: javac/java assertion harness
- Go: go test
- Rust: cargo test
- C#: dotnet run test project
- Kotlin: Gradle application runner
- C++: C++17 assertion harness

No runner requires one language to invoke another language's code.

## Adding a language

A new implementation can join the matrix by:

1. Implementing the relevant capability under utilities/<capability>/<language>.
2. Adding a native runner that exercises the canonical cases.
3. Recording intentional semantic differences in docs/cross-language-contracts.md.
4. Adding the language to this matrix.
5. Running the existing manual verification commands before merge.

The test strategy intentionally avoids a shared runtime or cross-language execution dependency.

## TypeScript core verification

From the repository root:

npm install
npm run test:typescript

The TypeScript runner currently covers the strict collections, strings, and numbers contracts. Existing TypeScript date and validation implementations remain outside this core parity runner.
