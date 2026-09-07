export const chunk = (items, size) => {
  if (size <= 0) throw new Error('Chunk size must be greater than zero');
  const result = [];
  for (let index = 0; index < items.length; index += size) {
    result.push(items.slice(index, index + size));
  }
  return result;
};
