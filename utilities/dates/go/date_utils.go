package dates

import "time"

func ParseDate(value string) (*time.Time, error) {
	if value == "" { return nil, nil }
	if parsed, err := time.Parse(time.RFC3339, value); err == nil { return &parsed, nil }
	parsed, err := time.ParseInLocation("2006-01-02 15:04:05", value, time.UTC)
	if err != nil { return nil, err }
	return &parsed, nil
}

func DaysBetween(start, end string) (*int64, error) {
	startDate, err := ParseDate(start)
	if err != nil { return nil, err }
	endDate, err := ParseDate(end)
	if err != nil { return nil, err }
	if startDate == nil || endDate == nil { return nil, nil }
	days := int64(endDate.Sub(*startDate) / (24 * time.Hour))
	return &days, nil
}
