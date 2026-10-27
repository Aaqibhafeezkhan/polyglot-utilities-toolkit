# Polyglot Utilities Toolkit

**One practical place to find small, reusable utilities across languages.** This project groups utilities by capability first and language second, so you can find the behavior you need without learning a separate repository for every language.

[Browse the examples](examples/README.md) · [Cross-language grouping tutorial](docs/tutorial-grouping-records.md) · [Find a starter task](https://github.com/Aaqibhafeezkhan/polyglot-utilities-toolkit/labels/good%20first%20issue) · [Contributing guide](docs/contributing.md)

## Try a utility in under a minute

The toolkit includes a `unique` collection helper that removes duplicate values while preserving their first occurrence.

**JavaScript**

```javascript
import { unique } from "./utilities/collections/javascript/collection_utils.js";

console.log(unique([3, 1, 3, 2, 1]));
// [3, 1, 2]
```

Run the JavaScript compatibility tests from the repository root:

```bash
node --experimental-default-type=module tests/matrix/javascript/test_matrix.mjs
```

**Python**

```python
from utilities.collections.python.collection_utils import unique

print(unique([3, 1, 3, 2, 1]))
# [3, 1, 2]
```

Run the Python compatibility tests from the repository root:

```bash
python -m unittest discover -s tests/matrix/python -p "test_*.py"
```

You only need the toolchain for the language you're working on. See [Getting Started](docs/getting-started.md) for more languages and commands.

## What you'll find

Utilities are grouped by capability, with language-specific implementations inside each capability.

| Capability | What it covers |
| --- | --- |
| Collections | Reusable operations on lists and collections |
| Strings | Common string transformations and helpers |
| Numbers | Numeric helpers and boundary behavior |
| Dates | Date-related helpers |
| Validation | Reusable validation rules |
| Forms, models, runtime | Focused helpers for applicable environments |

Current implementations include TypeScript, JavaScript, Python, C++, Java, Go, Rust, C#, and Kotlin. Coverage differs by capability and language; check the [cross-language test matrix](docs/cross-language-test-matrix.md) rather than assuming every utility exists everywhere.

## Make your first contribution

You do not need to understand every language or install every toolchain.

1. Browse [good first issues](https://github.com/Aaqibhafeezkhan/polyglot-utilities-toolkit/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22) or [all open issues](https://github.com/Aaqibhafeezkhan/polyglot-utilities-toolkit/issues).
2. Choose a task with a clear scope in one language or one documentation file.
3. For a typo, example, or other small, self-contained fix, you can open a PR directly. For a larger change, comment on the issue first so we can avoid duplicate work.
4. Follow [the contributor guide](docs/contributing.md), run the relevant check, and include the command and result in your PR.

First-time contributors are welcome. If an issue's scope is unclear, ask a question before investing time.

## Project guides

- [Getting started and verification commands](docs/getting-started.md)
- [Examples across languages](examples/README.md)
- [Contributor guide](docs/contributing.md)
- [First contribution quick start](docs/first-contribution.md)
- [Utility taxonomy](docs/utility-taxonomy.md)
- [Cross-language contracts](docs/cross-language-contracts.md)
- [Cross-language test matrix](docs/cross-language-test-matrix.md)
- [Core utility coverage](docs/core-utility-coverage.md)
- [Dates and validation parity](docs/dates-validation-parity.md)
- [Models and framework boundaries](docs/models-and-framework-boundaries.md)
- [Java language expansion](docs/java-language-expansion.md)
- [Go and Rust language expansion](docs/go-rust-language-expansion.md)
- [C# and Kotlin language expansion](docs/csharp-kotlin-language-expansion.md)

## Design principles

- Capability is the primary organizational boundary; language is the implementation boundary.
- Equivalent utilities should align in observable behavior without forcing identical APIs.
- Framework-specific code stays separate from general-purpose utilities.
- Existing behavior should be preserved when utilities are reorganized.
- Code remains free of comments; examples may include comments to explain their output.

## Development notes

TypeScript tooling is available for TypeScript utilities and React integrations. Other languages use their normal toolchains. Java capability implementations are independent Maven projects targeting Java 17; Go implementations are independent Go modules; Rust implementations are independent Cargo packages; C# projects target .NET 8; and Kotlin projects use Gradle Kotlin DSL.

Compatibility verification is currently manual. See the [test matrix guide](docs/cross-language-test-matrix.md) for canonical cases, runners, and language-specific verification.

## License

This project is licensed under the [MIT License](LICENSE). You may use, modify, and distribute the software subject to the license terms.
