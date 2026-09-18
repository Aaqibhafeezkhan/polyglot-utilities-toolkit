fn is_leap_year(year: i32) -> bool {
    year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}

fn days_in_month(year: i32, month: u32) -> u32 {
    match month {
        2 if is_leap_year(year) => 29,
        2 => 28,
        4 | 6 | 9 | 11 => 30,
        _ => 31,
    }
}

fn parse_components(value: &str) -> Option<(i32, u32, u32)> {
    let date = value.get(0..10)?;
    let mut parts = date.split('-');
    let year = parts.next()?.parse().ok()?;
    let month = parts.next()?.parse().ok()?;
    let day = parts.next()?.parse().ok()?;
    if parts.next().is_some() || !(1..=12).contains(&month) || day == 0 || day > days_in_month(year, month) {
        return None;
    }
    Some((year, month, day))
}

fn days_from_civil(year: i32, month: u32, day: u32) -> i64 {
    let y = year - if month <= 2 { 1 } else { 0 };
    let era = if y >= 0 { y } else { y - 399 } / 400;
    let yoe = y - era * 400;
    let month_index = month as i32 + if month > 2 { -3 } else { 9 };
    let doy = (153 * month_index + 2) / 5 + day as i32 - 1;
    let doe = yoe * 365 + yoe / 4 - yoe / 100 + doy;
    era as i64 * 146097 + doe as i64
}

pub fn parse_date(value: &str) -> Option<(i32, u32, u32)> { parse_components(value) }

pub fn days_between(start: &str, end: &str) -> Option<i64> {
    let start_date = parse_components(start)?;
    let end_date = parse_components(end)?;
    Some(days_from_civil(end_date.0, end_date.1, end_date.2) - days_from_civil(start_date.0, start_date.1, start_date.2))
}
