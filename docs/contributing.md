# Contributor Guide

Thanks for considering a contribution. You can help without knowing every language in the repository. The easiest contributions are focused on one file, one utility, one language, or one example.

## Choose a task

- [Good first issues](https://github.com/Aaqibhafeezkhan/polyglot-utilities-toolkit/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22)
- [Issues marked help wanted](https://github.com/Aaqibhafeezkhan/polyglot-utilities-toolkit/issues?q=is%3Aissue+is%3Aopen+label%3A%22help+wanted%22)
- [All open issues](https://github.com/Aaqibhafeezkhan/polyglot-utilities-toolkit/issues)

Before starting, read the issue and check its comments and linked PRs to avoid duplicating work.

### Do I need to claim an issue first?

- **Small, self-contained changes** such as a typo fix, a documentation clarification, or a missing example can be submitted directly as a PR.
- **Implementation work or a change that may take substantial effort:** comment with your intended approach first. Wait for confirmation if the issue asks for coordination or another contributor may already be working on it.
- Please do not reserve several issues at once. If you start work and cannot continue, leave a short update so someone else can pick it up.

A comment is welcome, but you do not need maintainer permission just to ask a question or propose a small documentation improvement.

## A quick first contribution

1. Fork the repository and clone your fork.
2. Pick one capability and one language, or a single documentation file.
3. Make the smallest change that meets the issue's goal.
4. Run the relevant verification command from the repository root or the language-specific project directory.
5. Review `git diff` and remove unrelated changes.
6. Open one focused PR. Link the issue when relevant, summarize the change, and include the verification command and result.

You do not need to install every language toolchain. Start with [Getting Started](getting-started.md) and run only the check relevant to your change. If a toolchain is unavailable, state that clearly in the PR instead of claiming a test passed.

## Repository structure

Utilities are organized by capability first and language second. For example:

```text
utilities/collections/javascript/
utilities/collections/python/
utilities/strings/javascript/
utilities/strings/python/
```

Add an implementation under the existing capability when possible. Add a new capability only when the utility does not fit the current taxonomy.

## Implementation guidelines

- Preserve the existing public behavior unless the issue explicitly requests a change.
- Follow the language's normal naming, formatting, build, and test conventions.
- Keep framework-specific dependencies out of general-purpose utility directories.
- Include meaningful empty, invalid, and boundary cases when the relevant test harness exists.
- Keep cross-language behavior aligned where that is the intended contract, and document meaningful language-specific differences.
- Keep code free of unnecessary comments, consistent with the repository convention.
- Do not add GitHub Actions; verification and deployment are currently manual.

## Pull request checklist

Before requesting review:

- [ ] The change addresses one issue or one clearly scoped improvement.
- [ ] The diff contains no unrelated files or generated artifacts.
- [ ] The relevant verification command and its result are included.
- [ ] Documentation or examples are updated if public behavior needs explanation.
- [ ] The PR description explains any known limitation or verification not performed.

Prefer one focused PR and one implementation commit when practical. Keep the change small enough that another person can understand it quickly.

## Need help?

If you are unsure which file to edit or which command to run, ask in the issue or PR. A short question is better than spending hours guessing.
