export const isEmpty = (value) => value == null || value === '';

export const capitalize = (value) => value.length === 0 ? value : value[0].toUpperCase() + value.slice(1);

export const reverseString = (value) => [...value].reverse().join('');

export const isValidEmail = (value) => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value);

export const toTitleCase = (value) => value
  .trim()
  .toLowerCase()
  .replace(/\b\w/g, (character) => character.toUpperCase());

export const normalizeWhitespace = (value) => value.trim().replace(/\s+/g, ' ');
