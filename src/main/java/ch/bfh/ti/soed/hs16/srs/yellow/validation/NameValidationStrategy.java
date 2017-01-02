
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidationStrategy
        implements ValidationStrategy {

    public static final String VALID_NAME_REGEX = "[A-Z][a-zA-Z]*";

    @Override
    public boolean validate(String input) {

        Pattern pattern = Pattern.compile(VALID_NAME_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();

    }

}
