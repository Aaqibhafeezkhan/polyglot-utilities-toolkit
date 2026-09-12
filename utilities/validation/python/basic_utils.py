def is_non_empty(value):
    return isinstance(value, str) and bool(value.strip())


def is_email(value):
    if not isinstance(value, str):
        return False
    parts = value.strip().split("@")
    return len(parts) == 2 and bool(parts[0]) and "." in parts[1] and not parts[1].startswith(".") and not parts[1].endswith(".")


def is_within_range(value, minimum, maximum):
    return isinstance(value, (int, float)) and not isinstance(value, bool) and minimum <= value <= maximum
