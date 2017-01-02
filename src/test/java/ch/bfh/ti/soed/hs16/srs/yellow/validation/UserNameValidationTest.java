
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.validation;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserNameValidationTest {

    @Test
    public void testValidateInCorrectUserName() throws Exception {
        ValidationContext ctx = new ValidationContext();
        ctx.setStrategy(new UserNameValidationStrategy());
        String userName = "hfjsdhf+23/)kkk";
        assertTrue(ctx.executeStrategy(userName));
    }

    @Test
    public void testValidateCorrectUserName() throws Exception {
        ValidationContext ctx = new ValidationContext();
        ctx.setStrategy(new UserNameValidationStrategy());
        String userName = "hfjsdhf1234kkk";
        assertTrue(ctx.executeStrategy(userName));
    }

}