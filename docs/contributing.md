# Contributor Guide

## Start here

Read [docs/getting-started.md](getting-started.md) for the repository layout, language-specific commands, and representative examples.

## Add a utility to an existing capability

1. Choose the narrowest capability from [docs/utility-taxonomy.md](utility-taxonomy.md).
2. Choose the implementation language.
3. Add the utility under `utilities/<capability>/<language>/`.
4. Define observable behavior using [docs/cross-language-contracts.md](cross-language-contracts.md).
5. Preserve existing behavior when extending an existing utility.
6. Keep framework dependencies out of general-purpose utility directories.
7. Add representative edge cases for empty, invalid, and boundary inputs when tests exist for that language.
8. Update documentation when the utility introduces a new contract or intentional language difference.
9. Add or update a practical example when the public usage is not obvious from an existing example.

## Add a new capability

Create a new capability only when an existing domain cannot describe the utility cleanly. Document its purpose, boundary, and representative behavior in the taxonomy before adding implementations.

## Add a new language

A language addition should extend existing capabilities rather than create a language-first top-level structure. Start with the capability that has the clearest reusable value, then add further implementations incrementally.

Use the language's normal build, test, package, and naming conventions. Do not force another language to imitate TypeScript or JavaScript syntax.

## Examples

Examples live under `examples/` and are organized by capability. A cross-language example should demonstrate the same observable utility concept in the languages where the capability is supported.

Examples should:

- use small, realistic inputs
- show the public utility surface rather than internal implementation details
- avoid personal or environment-specific information
- avoid unrelated application boilerplate
- identify intentional language-specific differences when they affect the result

## Contract checklist

Before submitting a change, verify:

- Inputs and outputs are clear.
- Empty input behavior is intentional.
- Invalid input behavior is intentional.
- Boundary behavior is intentional.
- Mutation behavior is clear.
- Ordering behavior is clear when relevant.
- Language-specific differences are documented when they affect callers.

## Framework boundary

Framework-specific code belongs under `ui/` or another explicitly framework-scoped location. General-purpose utilities should not import framework code merely for convenience.

## Repository constraints

Keep the repository free of unnecessary code comments, do not add GitHub Actions, and keep deployment manual. Changes should remain focused on the capability or language being extended.
