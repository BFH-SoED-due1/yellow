
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordValidationTest {

    private ValidationStrategy validationStrategy;

    @Before
    public void setUp() {
        this.validationStrategy = new PasswordValidationStrategy();
    }

    @Test
    public void validateWrongPasswordWithLessThanEightLetters() throws Exception {
        String input = "12345";
        assertFalse(this.validationStrategy.validate(input));
    }

    @Test
    public void validateWrongPasswordWithWhitespace() throws Exception {
        String input = "535663465 4375734757";
        assertFalse(this.validationStrategy.validate(input));
    }

    @Test
    public void validateWrongPasswordWithNoDigit() throws Exception {
        String input = "testtesttest_ui";
        assertFalse(this.validationStrategy.validate(input));
    }

    @Test
    public void validateWrongPasswordWithNoSpecialChars() throws Exception {
        String input = "testtesttest123";
        assertFalse(this.validationStrategy.validate(input));
    }

    @Test
    public void validateRightPassword() throws Exception {
        String input = "test123&UI7/*";
        assertTrue(this.validationStrategy.validate(input));
    }

}