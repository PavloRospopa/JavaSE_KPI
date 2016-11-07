package com.gmail.at.rospopa.pavlo;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;



public class PersonTest {
    @Test
    public void ValidatePersonEqualsContract() throws Exception {
        EqualsVerifier.forClass(Person.class).suppress(Warning.STRICT_INHERITANCE).verify();
    }
}