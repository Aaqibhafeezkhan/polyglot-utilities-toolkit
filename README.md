# Polyglot Utilities Toolkit

A language-agnostic collection of reusable utilities, helpers, validators, models, and problem-solving patterns.

## Architecture

The repository is organized by **capability first, language second**. A utility belongs to a domain such as strings, collections, numbers, dates, validation, forms, models, or runtime behavior; language-specific implementations live beneath that domain.

```text
utilities/
├── collections/
│   ├── cpp/
│   ├── javascript/
│   ├── python/
│   └── java/
├── strings/
│   ├── cpp/
│   ├── javascript/
│   ├── python/
│   └── java/
├── numbers/
│   ├── cpp/
│   ├── javascript/
│   ├── python/
│   └── java/
├── dates/
│   ├── typescript/
│   ├── javascript/
│   ├── python/
│   └── java/
├── validation/
│   ├── typescript/
│   ├── javascript/
│   ├── python/
│   └── java/
├── forms/
│   └── typescript/
├── models/
│   └── typescript/
└── runtime/
    └── typescript/

ui/
└── typescript/
    └── react/
```

This keeps the utility domain stable as new languages are added. Adding Rust, Go, Java, C#, Kotlin, or another language means adding an implementation under an existing capability instead of creating another top-level language silo.

## Languages

Current implementations include TypeScript, JavaScript, Python, C++, and Java.

## Contracts and contribution guidance

- [Utility taxonomy](docs/utility-taxonomy.md) defines capability domains and placement rules.
- [Cross-language contracts](docs/cross-language-contracts.md) defines shared behavioral expectations and intentional language differences.
- [Contributor guide](docs/contributing.md) explains how to add capabilities, utilities, and languages.
- [Core utility coverage](docs/core-utility-coverage.md) tracks representative coverage across current languages.
- [Dates and validation parity](docs/dates-validation-parity.md) defines date, validation, boundary, and timezone expectations.
- [Models and framework boundaries](docs/models-and-framework-boundaries.md) defines shared model ownership, import boundaries, and UI isolation.
- [Java language expansion](docs/java-language-expansion.md) documents Java coverage, build paths, and intentional differences.

## Design principles

- Capability is the primary organizational boundary.
- Language is the implementation boundary.
- Framework-specific code is isolated from general-purpose utilities.
- Equivalent utilities align semantically without forcing identical APIs.
- Existing behavior is preserved when utilities are reorganized.
- The structure is designed to grow without becoming language-centric.
- Code remains free of comments.

## Development

TypeScript tooling is available for the TypeScript utilities and React integrations. JavaScript, Python, C++, and Java code can be run or compiled with their respective toolchains.

Java capability implementations are independent Maven projects under the relevant capability directory and target Java 17.

Deployment is manual.
