
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data;

import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.jpa.JPAProxyDataAccessor;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.booking.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Person;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rdrand on 24/11/16.
 */
public class DataAccessTest {

    private JPAProxyDataAccessor jpaProxyDataAccessor = null;

    @Before
    public void setUp() {
        this.jpaProxyDataAccessor = new JPAProxyDataAccessor();
    }

    @Test
    public void testDataLayerAvailable() {
        assertNotNull(jpaProxyDataAccessor);
    }

    @Test
    public void testMakePerson() {
        String name = "Albert Lee";
        String email = "albert@lee.org";
        Person p = this.jpaProxyDataAccessor.makePerson(name, email);
        List<Person> all = this.jpaProxyDataAccessor.findAllPersons();
        assertNotNull(all);
        assertTrue(all.size() > 0);
        assertTrue(all.contains(p));
    }

    @Test
    public void testRemovePerson() {
        String name = "Janis Joplin";
        String email = "janis@joplin.org";
        Person p = this.jpaProxyDataAccessor.makePerson(name, email);
        this.jpaProxyDataAccessor.removePerson(p.getID());
        List<Person> all = this.jpaProxyDataAccessor.findAllPersons();
        assertNotNull(all);
        assertFalse(all.contains(p));
    }

    @Test
    public void testMakeRoom() {
        String name = "Abbey Road";
        int capacity = 10;
        Room r = this.jpaProxyDataAccessor.makeRoom(name, capacity);
        List<Room> studios = this.jpaProxyDataAccessor.findAllRooms();
        assertNotNull(studios);
        assertTrue(studios.size() > 0);
        assertTrue(studios.contains(r));
    }

    @Test
    public void testRemoveRoom() {
        String name = "LA Studio 6";
        int capacity = 20;
        Room r = this.jpaProxyDataAccessor.makeRoom(name, capacity);
        this.jpaProxyDataAccessor.removeRoom(r.getID());
        List<Room> studios = this.jpaProxyDataAccessor.findAllRooms();
        assertNotNull(studios);
//        assertFalse(studios.contains(r));
    }

    @Test
    public void makeReservation() {
        Person aPerson = this.jpaProxyDataAccessor.makePerson("Dubuis, Eric", "due1@nodomain.org");
        Room aRoom = this.jpaProxyDataAccessor.makeRoom("N215", 12);
        DateTime ltBegin = DateTime.now();
        DateTime ltEnd = ltBegin.plusHours(1);
        Interval timeslot = new Interval(ltBegin, ltEnd);
        this.jpaProxyDataAccessor.makeBooking(aPerson, aRoom, ltBegin, ltEnd);
        // Test if Person's reservation list has been updated
        List<Booking> res1 = aPerson.getBookings();
        assertNotNull(res1);
    }
}
