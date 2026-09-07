import re


def is_valid_email(value):
    return bool(re.fullmatch(r"[^\s@]+@[^\s@]+\.[^\s@]+", value))


def is_numeric(value):
    try:
        float(value)
        return True
    except (TypeError, ValueError):
        return False


def normalize_whitespace(value):
    return " ".join(value.split())


def to_title_case(value):
    return value.strip().title()
