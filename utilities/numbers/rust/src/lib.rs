pub fn clamp(value: f64, minimum: f64, maximum: f64) -> f64 { value.max(minimum).min(maximum) }
pub fn is_numeric(value: &str) -> bool { !value.is_empty() && value.parse::<f64>().is_ok() }
pub fn min_value(values: &[f64]) -> Option<f64> { values.iter().copied().reduce(f64::min) }
pub fn max_value(values: &[f64]) -> Option<f64> { values.iter().copied().reduce(f64::max) }
