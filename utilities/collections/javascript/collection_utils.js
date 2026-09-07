export const unique = (items) => [...new Set(items)];

export const groupBy = (items, key) => items.reduce((groups, item) => {
  const group = item[key];
  groups[group] = groups[group] || [];
  groups[group].push(item);
  return groups;
}, {});

export const sum = (values) => values.reduce((total, value) => total + value, 0);

export const average = (values) => values.length === 0 ? 0 : sum(values) / values.length;
