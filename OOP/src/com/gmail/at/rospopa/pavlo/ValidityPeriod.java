package com.gmail.at.rospopa.pavlo;

import java.time.Duration;

public enum ValidityPeriod {
    FROM9TO13 (Duration.ofHours(4)),
    FROM13TO17 (Duration.ofHours(4)),
    ONEDAY (Duration.ofDays(1)),
    TWODAYS (Duration.ofDays(2)),
    FIVEDAYS (Duration.ofDays(5));

    private Duration duration;

    ValidityPeriod(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }
}
