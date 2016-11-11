
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.customer;


import ch.bfh.ti.soed.hs16.srs.yellow.service.customer.Person;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for Person implementation
 */
public class PersonImplTest {

    @Test
    public void testGetPersonID() {

        Person personImpl1 = new PersonImpl();

        assertNotNull(personImpl1.getPersonID());
    }

    @Test
    public void testPersonName() {

        Person personImpl1 = new PersonImpl();

        String fName = "Barry";

        String lName = "Allen";

        personImpl1.setFirstName(fName);

        personImpl1.setLastName(lName);

        assertEquals(fName, personImpl1.getFirstName());

        assertEquals(lName, personImpl1.getLastName());
    }

    @Test
    public void testBirthDate() {

        Random rand = new Random();

        Person person1 = new PersonImpl();

        Date bDate = new Date(rand.nextInt());

        person1.setDateOfBirth(bDate);

        assertEquals(bDate, person1.getDateOfBirth());
    }

}