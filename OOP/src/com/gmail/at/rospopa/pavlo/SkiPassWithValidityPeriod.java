package com.gmail.at.rospopa.pavlo;

import java.time.LocalDateTime;

public class SkiPassWithValidityPeriod extends SkiPass{
    private final LocalDateTime activationDate;
    private final LocalDateTime expirationDate;

    public SkiPassWithValidityPeriod(String owner, SkiPassType type, LocalDateTime activationDate, LocalDateTime expirationDate) {
        super(owner, type);
        this.activationDate = activationDate;
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getActivationDate() {
        return activationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
