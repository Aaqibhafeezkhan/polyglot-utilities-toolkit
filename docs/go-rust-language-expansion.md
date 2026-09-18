# Go and Rust Language Expansion

Go and Rust implementations live beneath the established capability domains.

## Covered capabilities

- Collections: uniqueness, grouping, sum, and average.
- Strings: empty checks, capitalization, Unicode-aware reversal, email-shape validation, whitespace normalization, and title casing.
- Numbers: clamping, numeric detection, minimum, and maximum.
- Dates: parsing and day differences with explicit UTC handling for local date-time values in Go, plus standard-library date parsing for ISO calendar dates in Rust.
- Validation: non-empty, email-shape, and inclusive numeric-range validation.

## Build and run

Each Go capability is an independent Go module. From a capability directory, run:

    go test ./...
    go build ./...

Each Rust capability is an independent Cargo package. From a capability directory, run:

    cargo test
    cargo build

No GitHub Actions are added.

## Cross-language behavior

The implementations follow the shared contracts while using language-appropriate APIs:

- Empty collection minimum and maximum use nil in Go and None in Rust.
- Collection ordering is preserved by Go uniqueness and Rust uniqueness.
- String reversal operates on Unicode code points.
- Invalid date input is represented as an error or nil in Go and None in Rust.
- Rust date parsing uses a standard-library civil-date implementation because calendar parsing is not provided by the Rust standard library.
- Validation does not coerce values.
