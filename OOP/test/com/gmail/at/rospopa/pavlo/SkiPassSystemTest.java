package com.gmail.at.rospopa.pavlo;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class SkiPassSystemTest {
    @Test
    public void testValidateSkiPass() {
        SkiPassSystem skiPassSystem = new SkiPassSystem();
        SkiPass skiPass1 = skiPassSystem.createSkiPassWithLimitedLifts("Pavlo Rospopa",
                SkiPassType.WeekdayCard, NumberOfLifts.TEN);
        SkiPass skiPass2 = skiPassSystem.createSkiPassWithValidityPeriod("Mike Rul", SkiPassType.WeekdayCard,
                ValidityPeriod.FROM9TO13, LocalDate.of(2016, Month.NOVEMBER, 25));
        SkiPass skiPass3 = skiPassSystem.createSeasonSkiPass("Steve Aoki", LocalDate.of(2016, Month.NOVEMBER, 1),
                LocalDate.of(2017, Month.JANUARY, 30));

        skiPassSystem.banSkiPass(skiPass3);

        Assert.assertEquals(false, skiPassSystem.validateSkiPass(skiPass3));
        Assert.assertEquals(false, skiPassSystem.validateSkiPass(skiPass2));
        Assert.assertEquals(true, skiPassSystem.validateSkiPass(skiPass1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownInCreateSkiPassWithLimitedLifts() throws IllegalArgumentException{
        SkiPassSystem skiPassSystem = new SkiPassSystem();
        skiPassSystem.createSkiPassWithLimitedLifts("Pavlo Rospopa", SkiPassType.SeasonCard, NumberOfLifts.FIFTY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownInCreateSkiPassWithValidityPeriod() throws IllegalArgumentException{
        SkiPassSystem skiPassSystem = new SkiPassSystem();
        skiPassSystem.createSkiPassWithValidityPeriod("Pavlo Rospopa", SkiPassType.SeasonCard, ValidityPeriod.FROM13TO17,
                LocalDate.of(2016, Month.NOVEMBER, 14));
    }
}