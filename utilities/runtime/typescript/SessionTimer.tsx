import * as React from 'react';

const DEFAULT_DURATION = 300;
const STORAGE_KEY = 'timer';

const SessionTimeoutCounter: React.FC = () => {
  const [timer, setTimer] = React.useState<number>(() => {
    if (typeof window === 'undefined') {
      return DEFAULT_DURATION;
    }

    const storedTimer = Number(window.sessionStorage.getItem(STORAGE_KEY));
    return Number.isFinite(storedTimer) && storedTimer >= 0
      ? Math.floor(storedTimer)
      : DEFAULT_DURATION;
  });

  React.useEffect(() => {
    if (timer <= 0) {
      window.sessionStorage.removeItem(STORAGE_KEY);
      return;
    }

    const timeoutId = window.setTimeout(() => {
      setTimer((currentTimer) => {
        const nextTimer = Math.max(currentTimer - 1, 0);

        if (nextTimer === 0) {
          window.sessionStorage.removeItem(STORAGE_KEY);
        } else {
          window.sessionStorage.setItem(STORAGE_KEY, String(nextTimer));
        }

        return nextTimer;
      });
    }, 1000);

    return () => window.clearTimeout(timeoutId);
  }, [timer]);

  return null;
};

export default SessionTimeoutCounter;
