export const parseDate = (value) => {
    if (typeof value !== 'string' || value.trim() === '') return undefined;
    const date = new Date(value);
    return Number.isNaN(date.getTime()) ? undefined : date;
};

export const daysBetween = (start, end) => {
    const startDate = parseDate(start);
    const endDate = parseDate(end);
    if (!startDate || !endDate) return undefined;
    return Math.round((endDate.getTime() - startDate.getTime()) / 86400000);
};
