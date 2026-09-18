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
    │   └── rust/
    ├── strings/
    │   ├── cpp/
    │   ├── javascript/
    │   ├── python/
    │   ├── java/
    │   ├── go/
    │   └── rust/
    ├── numbers/
    │   ├── cpp/
    │   ├── javascript/
    │   ├── python/
    │   ├── java/
    │   ├── go/
    │   └── rust/
    ├── dates/
    │   ├── typescript/
    │   ├── javascript/
    │   ├── python/
    │   ├── java/
    │   ├── go/
    │   └── rust/
    ├── validation/
    │   ├── typescript/
    │   ├── javascript/
    │   ├── python/
    │   ├── java/
    │   ├── go/
    │   └── rust/
    ├── forms/
    │   └── typescript/
    ├── models/
    │   └── typescript/
    └── runtime/
        └── typescript/

This keeps the utility domain stable as new languages are added. Adding another language means adding an implementation under an existing capability instead of creating a top-level language silo.

## Languages

Current implementations include TypeScript, JavaScript, Python, C++, Java, Go, and Rust.

## Contracts and contribution guidance

- Utility taxonomy: docs/utility-taxonomy.md
- Cross-language contracts: docs/cross-language-contracts.md
- Contributor guide: docs/contributing.md
- Core utility coverage: docs/core-utility-coverage.md
- Dates and validation parity: docs/dates-validation-parity.md
- Models and framework boundaries: docs/models-and-framework-boundaries.md
- Java language expansion: docs/java-language-expansion.md
- Go and Rust language expansion: docs/go-rust-language-expansion.md

## Design principles

- Capability is the primary organizational boundary.
- Language is the implementation boundary.
- Framework-specific code is isolated from general-purpose utilities.
- Equivalent utilities align semantically without forcing identical APIs.
- Existing behavior is preserved when utilities are reorganized.
- The structure is designed to grow without becoming language-centric.
- Code remains free of comments.

## Development

TypeScript tooling is available for the TypeScript utilities and React integrations. JavaScript, Python, C++, Java, Go, and Rust code can be run or compiled with their respective toolchains.

Java capability implementations are independent Maven projects under the relevant capability directory and target Java 17. Go capability implementations are independent Go modules. Rust capability implementations are independent Cargo packages.

Deployment is manual.
