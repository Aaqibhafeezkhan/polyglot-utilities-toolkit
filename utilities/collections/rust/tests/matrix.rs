use collections_utils::{average, group_by, sum, unique};

#[test]
fn cross_language_matrix() {
    assert_eq!(unique(&[3, 1, 3, 2, 1]), vec![3, 1, 2]);
    assert_eq!(sum(&[1.0, 2.0, 3.0, 4.0]), 10.0);
    assert_eq!(average(&[1.0, 2.0, 3.0, 4.0]), 2.5);
    assert_eq!(average(&[]), 0.0);
    let groups = group_by(&[("a", 1), ("b", 2), ("a", 3)], |item| item.0);
    assert_eq!(groups.get("a").unwrap().len(), 2);
    assert_eq!(groups.get("a").unwrap()[1].1, 3);
}
