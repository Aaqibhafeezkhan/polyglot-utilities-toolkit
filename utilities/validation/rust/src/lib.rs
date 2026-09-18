pub fn is_non_empty(value: &str) -> bool { !value.trim().is_empty() }

pub fn is_email(value: &str) -> bool {
    let parts: Vec<&str> = value.trim().split('@').collect();
    parts.len() == 2 && !parts[0].is_empty() && parts[1].contains('.') && !parts[1].starts_with('.') && !parts[1].ends_with('.')
}

pub fn is_within_range(value: f64, minimum: f64, maximum: f64) -> bool {
    value.is_finite() && value >= minimum && value <= maximum
}
