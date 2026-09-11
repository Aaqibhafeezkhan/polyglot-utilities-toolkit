# Core Utility Coverage

Phase 4 expands reusable coverage across the existing capability domains without introducing language-level silos.

## Collections

JavaScript, Python, and C++ provide collection helpers for common operations such as uniqueness, aggregation, and averages. Existing language-specific names remain idiomatic while equivalent behavior follows the cross-language contracts.

## Strings

JavaScript and Python provide reusable string helpers for empty-value detection, capitalization, reversal, email-shape validation, whitespace normalization, and title casing. C++ provides reusable case conversion helpers.

## Numbers

JavaScript and Python provide `clamp`, numeric detection, minimum, and maximum helpers. C++ now provides numeric detection plus minimum and maximum helpers under the same capability domain.

For empty collections, minimum and maximum return the language-appropriate absence representation: `undefined` in JavaScript, `None` in Python, and `0` in the current C++ integer utility. This intentional C++ difference follows the repository contract guidance rather than pretending the type systems are identical.

## Dates and validation

The existing TypeScript date and validation capabilities remain reusable and separate from framework-specific integrations. Phase 4 does not redesign those domains.

## Forms, models, runtime, and UI

These domains remain scoped to their existing responsibilities. Framework-specific UI code remains outside general-purpose utilities.

## Expansion rule

When adding a core utility:

1. Identify the capability first.
2. Reuse an existing capability domain when the behavior fits.
3. Add the implementation under the relevant language directory.
4. Follow an existing cross-language contract when an equivalent utility exists.
5. Preserve language-appropriate naming and idioms.
6. Add a new capability only when the behavior cannot be represented cleanly by an existing domain.

The goal is useful reusable coverage, not maximum function count.
