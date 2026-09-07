def clamp(value, minimum, maximum):
    return min(max(value, minimum), maximum)


def is_numeric(value):
    if value == "":
        return False
    try:
        float(value)
        return True
    except (TypeError, ValueError):
        return False
