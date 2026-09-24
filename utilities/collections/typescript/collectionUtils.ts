export const unique = <T>(items: T[]): T[] => [...new Set(items)];

export const groupBy = <T, K extends keyof T>(items: T[], key: K): Record<string, T[]> => items.reduce<Record<string, T[]>>((groups, item) => {
  const group = String(item[key]);
  groups[group] = groups[group] || [];
  groups[group].push(item);
  return groups;
}, {});

export const sum = (values: number[]): number => values.reduce((total, value) => total + value, 0);

export const average = (values: number[]): number => values.length === 0 ? 0 : sum(values) / values.length;
