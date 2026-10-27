# First Contribution: Quick Start

This guide is for contributors who want to make one useful change without learning the entire repository.

## 1. Pick a small task

Start with [good first issues](https://github.com/Aaqibhafeezkhan/polyglot-utilities-toolkit/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22). Favor issues that name one file, one language, and one observable outcome. Check comments and linked pull requests first.

A documentation correction or a small example can be sent directly as a PR. For larger implementation work, comment with your approach first if coordination is needed.

## 2. Work in one language

You do not need all language toolchains. Choose the language relevant to your change and follow the corresponding instructions in [Getting Started](getting-started.md).

For example, the JavaScript collection helper is at `utilities/collections/javascript/collection_utils.js`, and its compatibility runner is:

```bash
node --experimental-default-type=module tests/matrix/javascript/test_matrix.mjs
```

The Python collection helper is at `utilities/collections/python/collection_utils.py`, and its compatibility tests are:

```bash
python -m unittest discover -s tests/matrix/python -p "test_*.py"
```

## 3. Keep the change focused

- Change only what is needed for the task.
- Follow the capability-first layout.
- Add or update an example when it makes usage easier to understand.
- Do not add unrelated refactors or GitHub Actions.

## 4. Open a clear PR

Include what changed, why it helps, the verification command and result, and any checks you could not run. Link the issue when one exists. Review your diff before requesting review.

If you get stuck, ask a specific question in the issue or PR. First-time contributors are welcome.
