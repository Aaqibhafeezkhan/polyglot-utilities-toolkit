use validation_utils::{is_email, is_non_empty, is_within_range};

#[test]
fn cross_language_matrix() {
    assert!(is_non_empty("ready"));
    assert!(!is_non_empty("   "));
    assert!(is_email("user@example.com"));
    assert!(!is_email("user@@example.com"));
    assert!(is_within_range(0.0, 0.0, 10.0));
    assert!(is_within_range(10.0, 0.0, 10.0));
    assert!(!is_within_range(11.0, 0.0, 10.0));
}
