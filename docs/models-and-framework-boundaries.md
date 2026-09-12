# Models and Framework Boundaries

## Model ownership

Reusable domain models live under `utilities/models/<language>/`. The TypeScript model catalog is the canonical home for shared enums, value objects, process models, and generated-origin model types.

Capability-specific models remain with their capability. Forms stay under `utilities/forms/typescript/`, validation models stay under `utilities/validation/typescript/`, and date models stay under `utilities/dates/typescript/`.

The shared TypeScript model index provides a stable aggregation point for consumers while individual capability boundaries remain explicit.

## Import boundaries

General-purpose utilities may depend on shared models but must not import React or another UI framework. Capability code may import models from the shared model boundary or from its own capability directory.

UI integrations belong under `ui/<language>/<framework>/`. React-specific imports, components, hooks, and framework lifecycle behavior must remain inside that boundary.

## Generated-origin cleanup

The previous generated model catalog used invalid relative paths and referenced a missing shared `AbstractMenuItem` definition. The canonical TypeScript model boundary now lives under `utilities/models/typescript/`, with explicit imports between model files and corrected capability-relative exports.

## Reusable patterns

Shared models should favor language-neutral concepts:

- identifiers and labels
- optional metadata
- validation/error results
- process state and process instances
- selectable options
- explicit enum-like states

Language implementations may use idiomatic types and APIs while preserving the same domain meaning. Framework concerns are not part of these contracts.

## Boundary rules

- `utilities/` contains reusable domain and utility behavior.
- `utilities/models/` owns shared domain models.
- Capability-specific models stay with their capability when they are not reusable domain concepts.
- `ui/` owns framework-dependent behavior.
- React imports must not appear in general-purpose utility or model modules.
- Generated-origin compatibility code should not become a second source of truth.
- Deployment remains manual and GitHub Actions are not part of the architecture.
