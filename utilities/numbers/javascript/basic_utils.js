export const clamp = (value, min, max) => Math.min(Math.max(value, min), max);

export const isNumeric = (value) => value !== '' && Number.isFinite(Number(value));
