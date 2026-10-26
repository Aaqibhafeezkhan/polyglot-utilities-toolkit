# Contributor Guide

## Start here

Read [docs/getting-started.md](getting-started.md) for the repository layout, language-specific commands, and representative examples.

## Claim an issue

1. Read the full issue and its acceptance criteria. Check the discussion and linked pull requests to make sure the work is still available.
2. Comment on the issue with a short note that you would like to work on it. Mention your intended approach or ask any questions that need clarification.
3. Wait for maintainer confirmation before starting substantial work. A comment does not automatically reserve an issue; maintainers may coordinate contributors to avoid duplicated effort.
4. Keep the implementation scoped to that issue. Follow the capability-first layout and existing conventions rather than reorganizing unrelated code.
5. Open one focused pull request for the issue. Link it with a closing reference such as `Closes #123`, summarize what changed, list the verification you performed, and note any limitations.
6. Review your own diff before requesting review. Check for unrelated files, accidental generated artifacts, secrets, and changes outside the issue's acceptance criteria. Respond constructively to review feedback.

If an issue is unclear, ask before making assumptions. If you can no longer continue, leave a comment so another contributor can pick it up.

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
