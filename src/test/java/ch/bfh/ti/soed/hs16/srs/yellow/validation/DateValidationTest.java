
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

public class DateValidationTest {

    private ValidationContext validationContext;

    @Before
    public void setUp() {
        this.validationContext = new ValidationContext(new DateValidationStrategy());
    }

    @Test
    public void validateWrongDate() throws Exception {
        String input = "1028-12-10";
        assertFalse(this.validationContext.executeStrategy(input));
    }

    @Test
    public void validateWrongDate1() throws Exception {
        String input = "1029.1210";
        assertFalse(this.validationContext.executeStrategy(input));
    }

    @Test
    public void validateRightDate() throws Exception {
        String input = "23.11.1027";
        assertTrue(this.validationContext.executeStrategy(input));
    }

}