package com.gmail.at.rospopa.pavlo;

import java.time.DayOfWeek;
import java.time.LocalDate;
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

    public Set<SkiPass> getSkiPasses() {
        return skiPasses;
    }

    public Set<SkiPass> getBannedSkiPasses() {
        return bannedSkiPasses;
    }

    public SkiPass createSkiPassWithLimitedLifts(String owner, SkiPassType type, NumberOfLifts numberOfLifts)
            throws IllegalArgumentException {
        if (type == SkiPassType.SeasonCard) throw new IllegalArgumentException();

        SkiPassWithLimitedLifts skiPassInstance = new SkiPassWithLimitedLifts(owner, type, numberOfLifts.getValue());
        skiPassInstance.setId(getNextId());
        skiPasses.add(skiPassInstance);

        return skiPassInstance;
    }

    public SkiPass createSkiPassWithValidityPeriod(String owner, SkiPassType type, ValidityPeriod validityPeriod,
                                                   LocalDate activationDate)  throws IllegalArgumentException {
        if (type == SkiPassType.SeasonCard) throw new IllegalArgumentException();

        LocalDateTime activationDateTime;
        LocalDateTime expirationDateTime;
        switch (validityPeriod){
            case FROM9TO13:
                activationDateTime = LocalDateTime.of(activationDate, ValidityPeriod.FIRSTHOUR);
                expirationDateTime = activationDateTime.plus(validityPeriod.getDuration());
                break;
            case FROM13TO17:
                activationDateTime = LocalDateTime.of(activationDate, ValidityPeriod.MIDDLEHOUR);
                expirationDateTime = activationDateTime.plus(validityPeriod.getDuration());
                break;
            default:
                activationDateTime = LocalDateTime.of(activationDate, ValidityPeriod.FIRSTHOUR);
                expirationDateTime = activationDateTime.plus(validityPeriod.getDuration()).with(ValidityPeriod.LASTHOUR);
        }

        SkiPassWithValidityPeriod skiPassInstance = new SkiPassWithValidityPeriod(owner, type, activationDateTime, expirationDateTime);
        skiPassInstance.setId(getNextId());
        skiPasses.add(skiPassInstance);

        return skiPassInstance;
    }

    public SkiPass createSeasonSkiPass(String owner, LocalDate activationDate, LocalDate expirationDate){
        SkiPassWithValidityPeriod skiPassInstance = new SkiPassWithValidityPeriod(owner, SkiPassType.SeasonCard,
                LocalDateTime.of(activationDate, ValidityPeriod.FIRSTHOUR),
                LocalDateTime.of(expirationDate, ValidityPeriod.LASTHOUR));

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

        //bad practice. implement this method in SkiPass
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
        DayOfWeek today = LocalDateTime.now().getDayOfWeek();
        switch (today){
            case SATURDAY:
            case SUNDAY:
                if (skiPass.getType()!=SkiPassType.WeekendCard)
                    return false;
                break;
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                if (skiPass.getType()!=SkiPassType.WeekdayCard)
                    return false;
                break;
        }

        if (skiPass.getNumberOfLifts() == 0)
            return false;

        return true;
    }
}
