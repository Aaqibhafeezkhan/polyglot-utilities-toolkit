use numbers_utils::{clamp, is_numeric, max_value, min_value};

#[test]
fn cross_language_matrix() {
    assert_eq!(clamp(-2.0, 0.0, 10.0), 0.0);
    assert_eq!(clamp(12.0, 0.0, 10.0), 10.0);
    assert_eq!(clamp(10.0, 0.0, 10.0), 10.0);
    assert!(is_numeric("12.5"));
    assert!(!is_numeric("12x"));
    assert_eq!(min_value(&[4.0, 2.0, 7.0]), Some(2.0));
    assert_eq!(max_value(&[4.0, 2.0, 7.0]), Some(7.0));
}
