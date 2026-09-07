export const currentTimeStamp = (): number => Math.floor(Date.now() / 1000);

export interface Age {
  years: number;
  months: number;
  days: number;
  hours: number;
  minutes: number;
  seconds: number;
}

const parseDateOfBirth = (dob: string): Date => {
  const match = /^(\d{4})-(\d{2})-(\d{2})$/.exec(dob);

  if (!match) {
    throw new Error('Date of birth must use YYYY-MM-DD format');
  }

  const year = Number(match[1]);
  const month = Number(match[2]);
  const day = Number(match[3]);
  const date = new Date(year, month - 1, day);

  if (
    date.getFullYear() !== year ||
    date.getMonth() !== month - 1 ||
    date.getDate() !== day
  ) {
    throw new Error('Date of birth is invalid');
  }

  return date;
};

export const calculateExactAge = (dob: string, now: Date = new Date()): Age => {
  const birthDate = parseDateOfBirth(dob);

  if (birthDate.getTime() > now.getTime()) {
    throw new Error('Date of birth cannot be in the future');
  }

  let years = now.getFullYear() - birthDate.getFullYear();
  let months = now.getMonth() - birthDate.getMonth();
  let days = now.getDate() - birthDate.getDate();
  let hours = now.getHours() - birthDate.getHours();
  let minutes = now.getMinutes() - birthDate.getMinutes();
  let seconds = now.getSeconds() - birthDate.getSeconds();

  if (seconds < 0) {
    seconds += 60;
    minutes--;
  }

  if (minutes < 0) {
    minutes += 60;
    hours--;
  }

  if (hours < 0) {
    hours += 24;
    days--;
  }

  if (days < 0) {
    const daysInPreviousMonth = new Date(
      now.getFullYear(),
      now.getMonth(),
      0
    ).getDate();
    days += daysInPreviousMonth;
    months--;
  }

  if (months < 0) {
    months += 12;
    years--;
  }

  return { years, months, days, hours, minutes, seconds };
};
