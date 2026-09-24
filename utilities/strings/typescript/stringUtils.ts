export const isEmpty = (value: string | null | undefined): boolean => value == null || value === "";

export const capitalize = (value: string): string => value.length === 0 ? value : value[0].toUpperCase() + value.slice(1);

export const reverseString = (value: string): string => [...value].reverse().join("");

export const isValidEmail = (value: string): boolean => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value);

export const toTitleCase = (value: string): string => value
  .trim()
  .toLowerCase()
  .replace(/\b\w/g, (character) => character.toUpperCase());

export const normalizeWhitespace = (value: string): string => value.trim().replace(/\s+/g, " ");
