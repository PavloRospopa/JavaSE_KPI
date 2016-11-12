package com.gmail.at.rospopa.pavlo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class SkiPassSystem {
    private Set<SkiPass> skiPasses = new HashSet<>();
    private Set<SkiPass> bannedSkiPasses = new HashSet<>();

    private static long nextId = 0;

    private long getNextId() {
        return nextId++;
    }

    public SkiPass createSkiPassWithLimitedLifts(String owner, SkiPassType type, NumberOfLifts numberOfLifts){
        SkiPassWithLimitedLifts skiPassInstance = new SkiPassWithLimitedLifts(owner, type, numberOfLifts.getValue());
        skiPassInstance.setId(getNextId());
        skiPasses.add(skiPassInstance);

        return skiPassInstance;
    }

    public SkiPass createSkiPassWithValidityPeriod(String owner, SkiPassType type, ValidityPeriod validityPeriod,
                                                                     LocalDateTime activationDate){
        LocalDateTime expirationDate = activationDate.plus(validityPeriod.getDuration());
        //should to be implemented in upper layer
        if (validityPeriod != ValidityPeriod.FROM9TO13 && validityPeriod != ValidityPeriod.FROM13TO17){
            expirationDate = expirationDate.withHour(0).withMinute(1);
        }

        SkiPassWithValidityPeriod skiPassInstance = new SkiPassWithValidityPeriod(owner, type, activationDate, expirationDate);
        skiPassInstance.setId(getNextId());
        skiPasses.add(skiPassInstance);

        return skiPassInstance;
    }

    public SkiPass createSeasonSkiPass(String owner, LocalDateTime activationDate, LocalDateTime expirationDate){
        SkiPassWithValidityPeriod skiPassInstance = new SkiPassWithValidityPeriod(owner, SkiPassType.SeasonCard,
                activationDate, expirationDate);
        skiPassInstance.setId(getNextId());
        skiPasses.add(skiPassInstance);

        return skiPassInstance;
    }

    public SkiPass banSkiPass(SkiPass skiPass){
        bannedSkiPasses.add(skiPass);

        return skiPass;
    }

    public boolean validateSkiPass(SkiPass skiPass){
        if (bannedSkiPasses.contains(skiPass))
            return false;
        if (!skiPasses.contains(skiPass))
            return false;

        if (skiPass instanceof SkiPassWithValidityPeriod){
            return validateSkiPassWithValidityPeriod((SkiPassWithValidityPeriod)skiPass);
        }
        if (skiPass instanceof SkiPassWithLimitedLifts){
            return validateSkiPassWithLimitedLifts((SkiPassWithLimitedLifts) skiPass);
        }

        return false;
    }

    private boolean validateSkiPassWithValidityPeriod(SkiPassWithValidityPeriod skiPass){
        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(skiPass.getExpirationDate()) ||
                now.isBefore(skiPass.getActivationDate())) {
            return false;
        }
        return true;
    }

    private boolean validateSkiPassWithLimitedLifts(SkiPassWithLimitedLifts skiPass){
        if (skiPass.getNumberOfLifts() == 0)
            return false;
        return true;
    }
}
