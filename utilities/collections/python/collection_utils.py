def unique(items):
    return list(dict.fromkeys(items))


def group_by(items, key):
    groups = {}
    for item in items:
        groups.setdefault(item[key], []).append(item)
    return groups


def sum_values(values):
    return sum(values)


def average(values):
    return sum(values) / len(values) if values else 0
