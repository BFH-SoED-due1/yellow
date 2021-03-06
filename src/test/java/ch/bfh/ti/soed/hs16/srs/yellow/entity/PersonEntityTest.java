
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.entity;

import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.BookingEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.PersonEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Person;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for Person implementation
 */
public class PersonEntityTest {

    @Test
    public void testPersonInitialized() {

        Person personImpl1 = new PersonEntity();
        assertNotNull(personImpl1);
    }

    @Test
    public void testPersonName() {

        Person personImpl1 = new PersonEntity();
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
        Person person1 = new PersonEntity();
        Date bDate = new Date(rand.nextInt());
        person1.setDateOfBirth(bDate);
        assertEquals(bDate, person1.getDateOfBirth());
    }

    @Test
    public void testAddBooking() {
        Booking booking = new BookingEntity();
        Person person1 = new PersonEntity();
        person1.addBooking(booking);
        assertTrue(person1.getBookings().contains(booking));
    }

}
