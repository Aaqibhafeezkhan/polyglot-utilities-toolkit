# Polyglot Utilities Toolkit

A language-agnostic collection of reusable utilities, helpers, validators, models, and problem-solving patterns.

## Architecture

The repository is organized by **capability first, language second**. A utility belongs to a domain such as strings, collections, numbers, dates, validation, forms, models, or runtime behavior; language-specific implementations live beneath that domain.

```text
utilities/
├── collections/
│   ├── cpp/
│   ├── javascript/
│   └── python/
├── strings/
│   ├── cpp/
│   ├── javascript/
│   └── python/
├── numbers/
│   ├── cpp/
│   ├── javascript/
│   └── python/
├── dates/
│   └── typescript/
├── validation/
│   └── typescript/
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

Current implementations include TypeScript, JavaScript, Python, and C++.

## Design principles

- Capability is the primary organizational boundary.
- Language is the implementation boundary.
- Framework-specific code is isolated from general-purpose utilities.
- Existing behavior is preserved when utilities are reorganized.
- The structure is designed to grow without becoming language-centric.
- Code remains free of comments.

## Development

TypeScript tooling is available for the TypeScript utilities and React integrations. JavaScript, Python, and C++ code can be run or compiled with their respective toolchains.

Deployment is manual.
