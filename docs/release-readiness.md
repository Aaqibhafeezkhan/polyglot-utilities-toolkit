# Release Readiness

The repository is a multi-language utility toolkit rather than one package published through a single ecosystem.

## Repository release model

Use lightweight repository tags for coherent snapshots of the toolkit:

`vMAJOR.MINOR.PATCH`

The repository version should advance when the overall toolkit reaches a meaningful release boundary. Documentation-only changes that do not change the public utility surface do not require a new release tag unless the release notes intentionally include them.

Release tags are created manually. GitHub Actions and automatic release pipelines are not required.

## Ecosystem package versions

Language-specific package metadata remains independent.

- Java uses Maven artifact versions in each capability's `pom.xml`.
- Go uses the module path and normal Go module/version conventions.
- Rust uses the version in each `Cargo.toml`.
- C# uses the project/package metadata when packaging is introduced.
- Kotlin uses the Gradle project metadata when packaging is introduced.
- JavaScript/TypeScript uses the root `package.json` for the current private development package.

Do not turn the entire repository into one published package merely to make versions uniform.

## Release checklist

Before creating a repository release:

1. Confirm the root tree remains capability-first.
2. Confirm no generated build output or local IDE state is tracked.
3. Confirm language-specific configuration stays inside the relevant ecosystem or capability.
4. Run the documented compatibility matrix.
5. Run the language-specific checks relevant to changed capabilities.
6. Review public examples and documentation for stale paths or commands.
7. Check package metadata for accidental dependency or publication changes.
8. Review changed files for accidental personal or environment-specific information.
9. Update release notes or the release description with the affected capabilities.
10. Create the repository tag manually.

## Versioning principles

- Use semantic versioning for repository release tags.
- Keep ecosystem package versions independent where packaging is ecosystem-specific.
- Do not publish a package that has not reached a stable public API boundary.
- Do not introduce a monorepo package manager solely for version coordination.
- Preserve the capability-first layout as the repository grows.

## Manual verification

The canonical cross-language verification commands are documented in [cross-language-test-matrix.md](cross-language-test-matrix.md).

The repository intentionally has no GitHub Actions. Release verification and deployment remain manual.
