# Polyglot Utilities Toolkit

A language-agnostic collection of reusable utilities, helpers, validators, models, and problem-solving patterns.

## Architecture

The repository is organized by **capability first, language second**. A utility belongs to a domain such as strings, collections, numbers, dates, validation, forms, models, or runtime behavior; language-specific implementations live beneath that domain.

    utilities/
    ├── collections/
    │   ├── cpp/
    │   ├── javascript/
    │   ├── python/
    │   ├── java/
    │   ├── go/
    │   ├── kotlin/
    │   └── rust/
    ├── strings/
    │   ├── cpp/
    │   ├── javascript/
    │   ├── python/
    │   ├── java/
    │   ├── go/
    │   ├── kotlin/
    │   └── rust/
    ├── numbers/
    │   ├── cpp/
    │   ├── javascript/
    │   ├── python/
    │   ├── java/
    │   ├── go/
    │   ├── kotlin/
    │   └── rust/
    ├── dates/
    │   ├── javascript/
    │   ├── python/
    │   ├── java/
    │   ├── go/
    │   ├── kotlin/
    │   └── rust/
    ├── validation/
    │   ├── typescript/
    │   ├── javascript/
    │   ├── python/
    │   ├── java/
    │   ├── go/
    │   ├── kotlin/
    │   └── rust/
    ├── forms/
    │   └── typescript/
    ├── models/
    │   └── typescript/
    └── runtime/
        └── typescript/

This keeps the utility domain stable as new languages are added. Adding another language means adding an implementation under an existing capability instead of creating a top-level language silo.

## Languages

Current implementations include TypeScript, JavaScript, Python, C++, Java, Go, Rust, C#, and Kotlin.

## Quick start

Start with [docs/getting-started.md](docs/getting-started.md) for language-specific setup, representative usage, and manual verification commands.

For the same capability implemented across multiple languages, see [examples/README.md](examples/README.md).

## Contracts and contribution guidance

- Utility taxonomy: [docs/utility-taxonomy.md](docs/utility-taxonomy.md)
- Cross-language contracts: [docs/cross-language-contracts.md](docs/cross-language-contracts.md)
- Cross-language test matrix: [docs/cross-language-test-matrix.md](docs/cross-language-test-matrix.md)
- Contributor guide: [docs/contributing.md](docs/contributing.md)
- Core utility coverage: [docs/core-utility-coverage.md](docs/core-utility-coverage.md)
- Dates and validation parity: [docs/dates-validation-parity.md](docs/dates-validation-parity.md)
- Models and framework boundaries: [docs/models-and-framework-boundaries.md](docs/models-and-framework-boundaries.md)
- Java language expansion: [docs/java-language-expansion.md](docs/java-language-expansion.md)
- Go and Rust language expansion: [docs/go-rust-language-expansion.md](docs/go-rust-language-expansion.md)
- C# and Kotlin language expansion: [docs/csharp-kotlin-language-expansion.md](docs/csharp-kotlin-language-expansion.md)

## Design principles

- Capability is the primary organizational boundary.
- Language is the implementation boundary.
- Framework-specific code is isolated from general-purpose utilities.
- Equivalent utilities align semantically without forcing identical APIs.
- Existing behavior is preserved when utilities are reorganized.
- The structure is designed to grow without becoming language-centric.
- Code remains free of comments.

## Development

TypeScript tooling is available for the TypeScript utilities and React integrations. JavaScript, Python, C++, Java, Go, Rust, C#, and Kotlin code can be run or compiled with their respective toolchains.

Java capability implementations are independent Maven projects under the relevant capability directory and target Java 17. Go capability implementations are independent Go modules. Rust capability implementations are independent Cargo packages. C# capability implementations are independent .NET 8 projects. Kotlin capability implementations are independent JVM projects using Gradle Kotlin DSL.

See [docs/getting-started.md](docs/getting-started.md) for the commands and repository paths used by each supported ecosystem.

## Compatibility testing

The repository has a manual cross-language compatibility matrix covering the equivalent core utilities in collections, strings, numbers, dates, and validation.

See [docs/cross-language-test-matrix.md](docs/cross-language-test-matrix.md) for the canonical cases, language runners, compatibility rules, and manual verification commands.

Deployment is manual.
