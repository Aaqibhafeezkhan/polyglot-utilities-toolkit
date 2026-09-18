use std::collections::{HashMap, HashSet};
use std::hash::Hash;

pub fn unique<T: Eq + Hash + Clone>(items: &[T]) -> Vec<T> {
    let mut seen = HashSet::new();
    items.iter().filter(|item| seen.insert((*item).clone())).cloned().collect()
}

pub fn group_by<T: Clone, K: Eq + Hash>(items: &[T], key_extractor: impl Fn(&T) -> K) -> HashMap<K, Vec<T>> {
    let mut result = HashMap::new();
    for item in items {
        result.entry(key_extractor(item)).or_insert_with(Vec::new).push(item.clone());
    }
    result
}

pub fn sum(values: &[f64]) -> f64 { values.iter().sum() }

pub fn average(values: &[f64]) -> f64 {
    if values.is_empty() { 0.0 } else { sum(values) / values.len() as f64 }
}
