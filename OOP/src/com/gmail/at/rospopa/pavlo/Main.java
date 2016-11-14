package com.gmail.at.rospopa.pavlo;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        SkiPassSystem skiPassSystem = new SkiPassSystem();

        SkiPass prskiPass = skiPassSystem.createSkiPassWithLimitedLifts("Pavlo Rospopa", SkiPassType.WeekendCard,
                NumberOfLifts.TWENTY);

        SkiPass anotherprskiPass = skiPassSystem.createSkiPassWithValidityPeriod("Pavlo Rospopa",
                SkiPassType.WeekdayCard, ValidityPeriod.TWODAYS, LocalDate.of(2016, Month.NOVEMBER, 14));

        SkiPass mrskiPass = skiPassSystem.createSkiPassWithValidityPeriod("Mike Rull", SkiPassType.WeekdayCard,
                ValidityPeriod.FROM9TO13, LocalDate.of(2016, Month.NOVEMBER, 14));

        SkiPass cbskiPass = skiPassSystem.createSeasonSkiPass("Conor Black", LocalDate.of(2016, Month.NOVEMBER, 1),
                LocalDate.of(2017, Month.FEBRUARY, 1));

        skiPassSystem.createSkiPassWithLimitedLifts("James Zabieli", SkiPassType.WeekdayCard, NumberOfLifts.FIFTY);
        skiPassSystem.createSkiPassWithLimitedLifts("Bain Sand", SkiPassType.WeekendCard, NumberOfLifts.TEN);

        Turnstile turnstile = new Turnstile(skiPassSystem);

        turnstile.getSkiPassSystem().banSkiPass(prskiPass);
        turnstile.getSkiPassSystem().banSkiPass(anotherprskiPass);
        turnstile.getSkiPassSystem().banSkiPass(mrskiPass);

        turnstile.processSkiPass(prskiPass);
        turnstile.processSkiPass(anotherprskiPass);
        turnstile.processSkiPass(mrskiPass);
        turnstile.processSkiPass(cbskiPass);

        System.out.println(turnstile.getAllReports());
        System.out.println(turnstile.getReportsBySkiPassType(SkiPassType.WeekdayCard));

       SkiPass testSkiPass = turnstile.getSkiPassSystem().createSkiPassWithValidityPeriod("Mamda Du", SkiPassType.WeekdayCard,
               ValidityPeriod.FIVEDAYS,
               LocalDate.of(2016, Month.NOVEMBER, 14));

        System.out.println(testSkiPass);
    }
}