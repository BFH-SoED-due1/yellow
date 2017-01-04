
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

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class EMailValidationTest {

    private ValidationContext validationContext;

    @Before
    public void setUp() {
        this.validationContext = new ValidationContext(new EMailValidationStrategy());
    }

    @Test
    public void validateCorrectEmail() throws Exception {
        String email = "test@test.com";
        assertTrue(this.validationContext.executeStrategy(email));
    }

    @Test
    public void validateCorrectEmail1() throws Exception {
        String email = "test321@test.ch";
        assertTrue(this.validationContext.executeStrategy(email));
    }

    @Test
    public void validateInCorrectEmail1() throws Exception {
        String email = "test@test627.com%";
        assertFalse(this.validationContext.executeStrategy(email));
    }

    @Test
    public void validateInCorrectEmail2() throws Exception {
        String email = "test672@test627.company";
        assertFalse(this.validationContext.executeStrategy(email));
    }

}