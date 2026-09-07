export const clamp = (value, min, max) => Math.min(Math.max(value, min), max);

export const isEmpty = (value) => value == null || value === '';

export const capitalize = (value) => value.length === 0 ? value : value[0].toUpperCase() + value.slice(1);

export const reverseString = (value) => [...value].reverse().join('');

export const chunk = (items, size) => {
  if (size <= 0) throw new Error('Chunk size must be greater than zero');
  const result = [];
  for (let index = 0; index < items.length; index += size) {
    result.push(items.slice(index, index + size));
  }
  return result;
};
