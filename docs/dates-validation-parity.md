# Dates, Validation & Edge-Case Parity

Phase 5 strengthens date/time and validation coverage while keeping existing TypeScript behavior intact.

## Date contract

Date utilities accept ISO-like date/time strings. Empty, non-string, and malformed values return the language-appropriate absence representation rather than producing a partially valid result.

`daysBetween` uses elapsed time in 24-hour units and returns a signed integer. JavaScript relies on the runtime date parser. Python normalizes timezone-less parsed values to UTC so naive and explicit-UTC values have one documented interpretation.

Timezone-sensitive behavior must never be assumed from the machine locale. Callers should provide an explicit timezone or UTC representation when an instant matters.

## Validation categories

The current cross-language validation helpers cover:

- non-empty strings
- email-shaped strings
- inclusive numeric ranges

Invalid types return `false` rather than throwing. Range validation rejects non-numeric values and treats the lower and upper bounds as valid.

## Edge cases

| Case | Date parsing | Validation |
| --- | --- | --- |
| Empty string | absent result | false |
| Malformed input | absent result | false |
| Null/None | absent result | false |
| Boundary value | preserved | inclusive |
| Reversed dates | signed difference | not applicable |
| Locale-dependent input | not guaranteed | not applicable |

## Cross-language expectations

Equivalent utilities should agree on valid, invalid, empty, and boundary cases while retaining language-appropriate types and naming. JavaScript uses `undefined` for absent parsed dates; Python uses `None`. This is an intentional type-system difference with equivalent meaning.

Existing TypeScript date and validation utilities remain the source of their established public behavior. New implementations extend the capability domain rather than replacing those APIs.
