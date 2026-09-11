export const clamp = (value, min, max) => Math.min(Math.max(value, min), max);

export const isNumeric = (value) => value !== '' && Number.isFinite(Number(value));

export const minValue = (values) => values.length === 0 ? undefined : Math.min(...values);

export const maxValue = (values) => values.length === 0 ? undefined : Math.max(...values);
