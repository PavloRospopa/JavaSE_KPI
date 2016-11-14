package com.gmail.at.rospopa.pavlo;

import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class SkiPassTest {
    @Test
    public void validateSkiPassEquals() {
        EqualsVerifier.forClass(SkiPass.class).suppress(Warning.STRICT_INHERITANCE)
                .suppress(Warning.NONFINAL_FIELDS).verify();
    }
}