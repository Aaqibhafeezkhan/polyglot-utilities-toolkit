# Getting Started

This repository is organized by capability first and language second. You can work with one ecosystem without installing the others.

## 1. Clone and inspect

Clone the repository, then inspect the capability directories under `utilities/`.

For example, the collections capability contains language-specific implementations under:

`utilities/collections/<language>/`

The same pattern applies to strings, numbers, dates, and validation.

## 2. Choose one language

### JavaScript

Requirements: Node.js.

Representative module:

`utilities/collections/javascript/collection_utils.js`

Run the repository's compatibility runner with:

```text
node --experimental-default-type=module tests/matrix/javascript/test_matrix.mjs
```

### Python

Requirements: Python 3.

Representative module:

`utilities/collections/python/collection_utils.py`

Run the compatibility runner with:

```text
python -m unittest discover -s tests/matrix/python -p "test_*.py"
```

### Java

Requirements: JDK 17 and Maven.

Each Java capability is an independent Maven project. For example:

`utilities/collections/java/`

Build or test from that capability directory with Maven:

```text
mvn test
```

The cross-language matrix uses a small native Java assertion runner; see [docs/cross-language-test-matrix.md](cross-language-test-matrix.md).

### Go

Requirements: Go.

Each Go capability is an independent module. For example:

`utilities/collections/go/`

Run:

```text
go test ./...
```

### Rust

Requirements: Rust and Cargo.

Each Rust capability is an independent Cargo package. For example:

`utilities/collections/rust/`

Run:

```text
cargo test
```

### C#

Requirements: .NET 8 SDK.

Each C# capability is an independent .NET project. For example:

`utilities/collections/csharp/`

Run:

```text
dotnet test
```

The repository also provides a cross-language C# runner at `tests/matrix/csharp/`.

### Kotlin

Requirements: JDK and Gradle.

Each Kotlin capability is an independent JVM project using Gradle Kotlin DSL. For example:

`utilities/collections/kotlin/`

Run:

```text
gradle test
```

The repository also provides a matrix runner at `tests/matrix/kotlin/`.

### C++

Requirements: a C++17 compiler.

C++ currently provides partial capability coverage. The available behavior is covered by the dedicated matrix runner described in [tests/matrix/README.md](../tests/matrix/README.md).

## 3. Compare equivalent behavior

The cross-language contract is about observable behavior rather than identical function signatures.

For example, collection uniqueness preserves first-occurrence order, while the function name, parameter types, and package conventions remain idiomatic to each language.

See [examples/README.md](../examples/README.md) for a side-by-side example.

## 4. Run the compatibility matrix

The canonical fixture is:

`tests/matrix/fixtures/core-utility-cases.json`

The manual runners are documented in [docs/cross-language-test-matrix.md](cross-language-test-matrix.md). No language invokes another language's implementation.

## 5. Extend the toolkit

For an existing capability:

1. Pick the narrowest capability directory.
2. Add the implementation beneath the language directory.
3. Follow the shared behavioral contract.
4. Add tests for the relevant edge cases.
5. Add or update a capability example when useful.
6. Update documentation only where behavior, setup, or contributor workflow changed.

For a new language, add it beneath existing capability directories rather than creating a new top-level language directory.

For a new capability, document its boundary in [docs/utility-taxonomy.md](utility-taxonomy.md) before adding implementations.

## Manual project policy

There are no GitHub Actions in the project. Build, test, and deployment workflows remain manual by design.
