package com.gmail.at.rospopa.pavlo;

import java.time.Duration;
import java.time.LocalTime;

public enum ValidityPeriod {
    FROM9TO13 (Duration.ofHours(4)),
    FROM13TO17 (Duration.ofHours(4)),

    ONEDAY (Duration.ofDays(0)),
    TWODAYS (Duration.ofDays(1)),
    FIVEDAYS (Duration.ofDays(4));

    public static final LocalTime FIRSTHOUR = LocalTime.of(9,0,0);
    public static final LocalTime MIDDLEHOUR = LocalTime.of(13,0,0);
    public static final LocalTime LASTHOUR = LocalTime.of(17,0,0);

    private Duration duration;

    ValidityPeriod(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }
}
