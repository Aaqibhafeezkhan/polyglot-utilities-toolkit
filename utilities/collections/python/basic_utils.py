def chunk(items, size):
    if size <= 0:
        raise ValueError("Chunk size must be greater than zero")
    items = list(items)
    return [items[index:index + size] for index in range(0, len(items), size)]
