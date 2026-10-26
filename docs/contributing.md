# Contributor Guide

## Start here

Read [docs/getting-started.md](getting-started.md) for the repository layout, language-specific commands, and representative examples. Browse [open issues labeled for contributors](https://github.com/Aaqibhafeezkhan/polyglot-utilities-toolkit/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22) to find a task. Issues labeled `good first issue`, `help wanted`, or `up-for-grabs` are invitations to contribute, not guarantees that work is unclaimed.

## Claim an issue

To help more people contribute fairly, each contributor may have **one active claimed issue at a time** in this repository.

1. Choose one open issue and read its full description, acceptance criteria, discussion, and linked pull requests.
2. Comment once with a brief proposed approach, relevant experience if useful, and any clarification questions. Please do not claim several issues “just in case.”
3. Wait for maintainer confirmation before starting substantial work. A comment alone does not reserve an issue. The maintainer will confirm the claim or help you choose another task.
4. Work on only that confirmed issue until its PR is merged, or until you tell the maintainer you are stepping back and the claim is released. After that, you may request another issue.
5. If you need more time, post a short progress update on the issue. If you cannot continue, say so; releasing the claim lets another contributor participate.
6. If another contributor is already confirmed or has a PR in progress, do not start duplicate work. Ask the maintainer if you have a distinct approach that could be useful.
7. Keep the implementation scoped to the issue. Follow the capability-first layout and existing conventions rather than reorganizing unrelated code.
8. Open one focused pull request for the issue. Link it with a closing reference such as `Closes #123`, summarize what changed, list the verification you performed, and note any limitations.
9. Review your own diff before requesting review. Check for unrelated files, accidental generated artifacts, secrets, and changes outside the issue's acceptance criteria. Respond constructively to review feedback.

### Claim coordination and inactivity

- Claims are coordinated by maintainers so that opportunities are shared across contributors. Maintainers may ask for a progress update if a claim has been inactive for about 7 days.
- If there is no update after a reasonable follow-up window, the maintainer may release the claim and reopen the work to others. Please communicate if life or work gets in the way; asking for more time is welcome.
- Do not open a PR for work that is unrelated to the issue, and do not reserve issues through multiple comments or multiple accounts.
- First-time contributors are welcome. You do not need to ask permission to discuss an issue or suggest an improvement; confirmation is only needed to coordinate implementation work.

## Pull request expectations

- Prefer one issue, one focused PR, and one implementation commit when practical.
- Include the issue-closing reference, a concise summary, verification steps and results, and any known limitations.
- Keep changes small and reviewable. Do not bundle unrelated fixes or broad refactors.
- Self-review the complete diff before requesting maintainer review.
- Follow repository conventions: no unnecessary code comments, no GitHub Actions, and manual deployment/verification practices where applicable.

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
