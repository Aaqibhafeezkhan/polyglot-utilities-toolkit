from collections.abc import Iterable


def clamp(value, minimum, maximum):
    return min(max(value, minimum), maximum)


def is_empty(value):
    return value is None or value == ""


def capitalize(value):
    return value[:1].upper() + value[1:] if value else value


def reverse_string(value):
    return value[::-1]


def chunk(items: Iterable, size):
    if size <= 0:
        raise ValueError("Chunk size must be greater than zero")
    items = list(items)
    return [items[index:index + size] for index in range(0, len(items), size)]
