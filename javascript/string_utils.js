export const isValidEmail = (value) => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value);

export const isNumeric = (value) => value !== '' && Number.isFinite(Number(value));

export const toTitleCase = (value) => value
  .trim()
  .toLowerCase()
  .replace(/\b\w/g, (character) => character.toUpperCase());

export const normalizeWhitespace = (value) => value.trim().replace(/\s+/g, ' ');
