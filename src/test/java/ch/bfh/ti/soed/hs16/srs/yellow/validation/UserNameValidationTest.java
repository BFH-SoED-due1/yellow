
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

public class UserNameValidationTest {

    private ValidationStrategy validationStrategy;

    @Before
    public void setUp() {
        this.validationStrategy = new UserNameValidationStrategy();
    }

    @Test
    public void testValidateInCorrectUserName() throws Exception {
        ValidationContext ctx = new ValidationContext();
        ctx.setStrategy(new UserNameValidationStrategy());
        String userName = "h+23/)0test";
        assertFalse(this.validationStrategy.validate(userName));
    }

    @Test
    public void testValidateCorrectUserName() throws Exception {
        ValidationContext ctx = new ValidationContext();
        ctx.setStrategy(new UserNameValidationStrategy());
        String userName = "hfjsd789";
        assertTrue(this.validationStrategy.validate(userName));
    }

    @Test
    public void testValidateCorrectUserName1() throws Exception {
        ValidationContext ctx = new ValidationContext();
        ctx.setStrategy(new UserNameValidationStrategy());
        String userName = "1234test";
        assertTrue(this.validationStrategy.validate(userName));
    }

}