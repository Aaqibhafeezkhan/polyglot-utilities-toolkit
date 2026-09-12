export const isNonEmpty = (value) => typeof value === 'string' && value.trim() !== '';

export const isEmail = (value) => typeof value === 'string' && /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value);

export const isWithinRange = (value, min, max) => Number.isFinite(value) && value >= min && value <= max;
