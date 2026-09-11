# Utility Taxonomy

Polyglot Utilities Toolkit is organized by capability first and language second. This document defines the stable domains, placement rules, and boundaries used when adding utilities.

## Capability domains

| Domain | Purpose | Typical examples |
|---|---|---|
| `collections` | Operations over groups of values | filtering, grouping, deduplication, partitioning |
| `strings` | Text transformation and inspection | normalization, truncation, parsing, formatting |
| `numbers` | Numeric transformations and predicates | clamping, ranges, rounding, aggregation |
| `dates` | Date and time calculations | age, date differences, date normalization |
| `validation` | Reusable input and value validation | required checks, shape checks, domain predicates |
| `forms` | Reusable form-domain behavior | question models, input types, submissions |
| `models` | Domain-neutral reusable data representations | shared value objects, result models, transport-neutral structures |
| `runtime` | Runtime and execution concerns | environment helpers, platform-neutral runtime utilities |

Framework integrations belong under `ui/<language>/<framework>/` or another explicitly framework-scoped location. They do not become general-purpose utilities merely because they are reusable inside a framework.

## Placement rules

1. Identify the capability before choosing a language.
2. Put a general-purpose utility under the narrowest existing capability domain.
3. Put a language implementation under `utilities/<capability>/<language>/`.
4. Keep framework-specific implementations outside `utilities/`.
5. Do not create a new top-level language directory for a utility.
6. Create a new capability only when the behavior does not fit an existing domain and is likely to support multiple reusable utilities.
7. Keep one utility focused on one coherent responsibility.
8. Prefer deterministic behavior unless the capability inherently depends on runtime state.

## New capability test

Before introducing a new domain, confirm that the proposed behavior cannot reasonably live in `collections`, `strings`, `numbers`, `dates`, `validation`, `forms`, `models`, or `runtime`. Document the new domain and its boundary before adding language implementations.

## Generic versus framework-specific

A utility is generic when it can be understood and reused without a framework lifecycle, component model, rendering system, or framework-specific dependency. A utility that requires React, Angular, Vue, browser rendering, or another framework belongs in the framework-specific area.

Language idioms are allowed. The repository standardizes capability and behavior, not syntax.
