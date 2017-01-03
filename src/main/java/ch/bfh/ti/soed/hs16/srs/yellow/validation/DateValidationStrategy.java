
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

public class DateValidationStrategy
        implements ValidationStrategy {

    public static final Pattern VALID_DATE_REGEX =
            Pattern.compile("^\\d{2}.\\d{2}.\\d{4}$");

    @Override
    public boolean validate(String input) {

        Matcher matcher = VALID_DATE_REGEX.matcher(input);
        return matcher.matches();

    }

}
