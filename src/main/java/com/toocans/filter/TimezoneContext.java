package com.toocans.filter;

import java.time.ZoneId;

public class TimezoneContext {

    private static final ThreadLocal<ZoneId> timezoneThreadLocal = new ThreadLocal<>();

    public static void setTimezone(ZoneId timezone) {
        timezoneThreadLocal.set(timezone);
    }

    public static ZoneId getTimezone() {
        return timezoneThreadLocal.get();
    }

    public static void clear() {
        timezoneThreadLocal.remove();
    }
}

