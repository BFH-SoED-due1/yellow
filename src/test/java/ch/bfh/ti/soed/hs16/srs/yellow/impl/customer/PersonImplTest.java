
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.customer;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for Person implementation
 */
public class PersonImplTest {

    @Test
    public void testGetPersonID() {
        PersonImpl personImpl1 = new PersonImpl();
        assertNotNull(personImpl1.getPersonID());
    }

    @Test
    public void testPersonName() {
        PersonImpl personImpl1 = new PersonImpl();

        String fName = "Barry";
        String lName = "Allen";

        personImpl1.setFirstName(fName);
        personImpl1.setLastName(lName);

        assertEquals(fName, personImpl1.getFirstName());
        assertEquals(lName, personImpl1.getLastName());
    }

    @Test
    public void testBirthDate() {
        PersonImpl person1 = new PersonImpl();


    }

}