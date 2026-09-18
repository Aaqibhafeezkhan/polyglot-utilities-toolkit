pub fn is_empty(value: &str) -> bool { value.is_empty() }

pub fn capitalize(value: &str) -> String {
    let mut chars = value.chars();
    match chars.next() {
        Some(first) => first.to_uppercase().collect::<String>() + chars.as_str(),
        None => String::new(),
    }
}

pub fn reverse_string(value: &str) -> String { value.chars().rev().collect() }

pub fn is_valid_email(value: &str) -> bool {
    let parts: Vec<&str> = value.trim().split('@').collect();
    parts.len() == 2 && !parts[0].is_empty() && parts[1].contains('.') && !parts[1].starts_with('.') && !parts[1].ends_with('.')
}

pub fn normalize_whitespace(value: &str) -> String {
    value.split_whitespace().collect::<Vec<_>>().join(" ")
}

pub fn to_title_case(value: &str) -> String {
    value.split_whitespace()
        .map(|word| capitalize(&word.to_lowercase()))
        .collect::<Vec<_>>()
        .join(" ")
}
