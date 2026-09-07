def is_empty(value):
    return value is None or value == ""


def capitalize(value):
    return value[:1].upper() + value[1:] if value else value


def reverse_string(value):
    return value[::-1]


def is_valid_email(value):
    import re
    return bool(re.fullmatch(r"[^\s@]+@[^\s@]+\.[^\s@]+", value))


def normalize_whitespace(value):
    return " ".join(value.split())


def to_title_case(value):
    return value.strip().title()
