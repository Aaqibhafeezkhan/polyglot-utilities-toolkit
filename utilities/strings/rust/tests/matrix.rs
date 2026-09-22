use strings_utils::{capitalize, is_empty, is_valid_email, normalize_whitespace, reverse_string, to_title_case};

#[test]
fn cross_language_matrix() {
    assert!(is_empty(""));
    assert_eq!(capitalize("hello"), "Hello");
    assert_eq!(reverse_string("A🙂B"), "B🙂A");
    assert!(is_valid_email("user@example.com"));
    assert!(!is_valid_email("user@@example.com"));
    assert_eq!(normalize_whitespace("  hello \\t world  "), "hello world");
    assert_eq!(to_title_case("hello world"), "Hello World");
}
