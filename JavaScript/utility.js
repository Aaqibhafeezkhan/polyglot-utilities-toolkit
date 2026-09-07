export const clamp = (value, min, max) => Math.min(Math.max(value, min), max);

export const isEmpty = (value) => value == null || value === '';

export const capitalize = (value) => value.length === 0 ? value : value[0].toUpperCase() + value.slice(1);
