package com.gmail.at.rospopa.pavlo;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class TurnstileTest {

    @Test
    public void testProcessSkiPass(){
        Turnstile turnstile = new Turnstile(new SkiPassSystem());
        SkiPass skiPass1 = turnstile.getSkiPassSystem().createSeasonSkiPass("Steve Aoki", LocalDate.of(2016, Month.NOVEMBER, 1),
                LocalDate.of(2017, Month.JANUARY, 30));

        SkiPass skiPass2 = turnstile.getSkiPassSystem().createSkiPassWithLimitedLifts("Pavlo Rospopa",
                SkiPassType.WeekdayCard, NumberOfLifts.TEN);

        SkiPass skiPass3 = turnstile.getSkiPassSystem().createSkiPassWithValidityPeriod("Mike Rul", SkiPassType.WeekdayCard,
                ValidityPeriod.FROM9TO13, LocalDate.of(2016, Month.NOVEMBER, 25));

        Assert.assertEquals(true, turnstile.processSkiPass(skiPass2));
        Assert.assertEquals(9, ((SkiPassWithLimitedLifts) skiPass2).getNumberOfLifts());

        Assert.assertEquals(true, turnstile.processSkiPass(skiPass1));

        Assert.assertEquals(false, turnstile.processSkiPass(skiPass3));
    }
}