use dates_utils::{days_between, parse_date};

#[test]
fn cross_language_matrix() {
    assert_eq!(parse_date("2026-01-01T00:00:00Z"), Some((2026, 1, 1)));
    assert_eq!(parse_date("not-a-date"), None);
    assert_eq!(days_between("2026-01-01T00:00:00Z", "2026-01-03T00:00:00Z"), Some(2));
    assert_eq!(parse_date("2026-01-01T00:00:00"), Some((2026, 1, 1)));
}
