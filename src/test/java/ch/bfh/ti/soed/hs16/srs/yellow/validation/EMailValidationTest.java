
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.validation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EMailValidationTest {

    private ValidationStrategy validationStrategy;

    @Before
    public void setUp() {
        setStrategy(new EMailValidationStrategy());
    }

    public void setStrategy(ValidationStrategy strategy) {
        this.validationStrategy = strategy;
    }

    @Test
    public void validateCorrectEmail() throws Exception {
        String email = "test@test.com";
        assertTrue(this.validationStrategy.validate(email));
    }

    @Test
    public void validateCorrectEmail1() throws Exception {
        String email = "test@192.168.0.1";
        assertTrue(this.validationStrategy.validate(email));
    }

}