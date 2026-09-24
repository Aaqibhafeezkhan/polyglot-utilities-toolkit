export const clamp = (value: number, min: number, max: number): number => Math.min(Math.max(value, min), max);

export const isNumeric = (value: unknown): boolean => value !== "" && Number.isFinite(Number(value));

export const minValue = (values: number[]): number | undefined => values.length === 0 ? undefined : Math.min(...values);

export const maxValue = (values: number[]): number | undefined => values.length === 0 ? undefined : Math.max(...values);
