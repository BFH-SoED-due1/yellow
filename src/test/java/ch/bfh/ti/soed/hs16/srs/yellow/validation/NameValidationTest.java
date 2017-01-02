
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

public class NameValidationTest {

    @Test
    public void testValidateCorrectName() throws Exception {
        String userName = "Thomas Cook";
        assertTrue(new NameValidationStrategy().validate(userName));
    }

    @Test
    public void testValidateInCorrectName() throws Exception {
        String userName = "Thomas8898 Coo1234kkk";
        assertTrue(new NameValidationStrategy().validate(userName));
    }

    @Test
    public void testValidateInCorrectNameWithCharacters() throws Exception {
        String userName = "/&/&/&/T565640200UIN";
        assertTrue(new NameValidationStrategy().validate(userName));
    }

}