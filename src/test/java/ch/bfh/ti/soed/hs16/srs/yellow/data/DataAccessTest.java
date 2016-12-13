
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data;

import ch.bfh.ti.soed.hs16.srs.yellow.controllers.JPAProxyDataAccessor;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Equipment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Person;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Room;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
    public void testMakeEquipment() {

        String description = "Sofa";
        Equipment equ = this.jpaProxyDataAccessor.makeEquipment(description);
        assertNotNull(equ);
        List<Equipment> equList = this.jpaProxyDataAccessor.findAllEquipments();
        assertTrue(equList.size() > 0);
        assertTrue(equList.contains(equ));
        assertEquals(description, equ.getDescription());
    }

    @Test
    public void testRemoveEquipment() {

        String description = "Sofa1";
        Equipment equ = this.jpaProxyDataAccessor.makeEquipment(description);
        assertNotNull(equ);
        this.jpaProxyDataAccessor.removeEquipment(equ.getID());
        List<Equipment> equList = this.jpaProxyDataAccessor.findAllEquipments();
        assertFalse(equList.contains(equ));
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
        assertFalse(studios.contains(r));
    }

    @Test
    public void testmakeBooking() {
        Person aPerson = this.jpaProxyDataAccessor.makePerson("Bond, James", "noname@nodomain.org");
        Room aRoom = this.jpaProxyDataAccessor.makeRoom("N215", 12);
        DateTime ltBegin = DateTime.now();
        DateTime ltEnd = ltBegin.plusHours(1);
        Interval timeslot = new Interval(ltBegin, ltEnd);
        Booking bkng = this.jpaProxyDataAccessor.makeBooking(aPerson, aRoom, ltBegin, ltEnd);
        assertTrue(this.jpaProxyDataAccessor.findAllBookings().contains(bkng));
        // Test if Person's reservation list has been updated
        List<Booking> res1 = aPerson.getBookings();
        assertNotNull(res1);
    }

    @Test
    public void testRemoveBooking() {
        Person aPerson = this.jpaProxyDataAccessor.makePerson("Unknown, Anonymous", "noname@nodomain.org");
        Room aRoom = this.jpaProxyDataAccessor.makeRoom("N215", 12);
        DateTime ltBegin = DateTime.now();
        DateTime ltEnd = ltBegin.plusHours(1);
        Interval timeslot = new Interval(ltBegin, ltEnd);
        Booking bkng = this.jpaProxyDataAccessor.makeBooking(aPerson, aRoom, ltBegin, ltEnd);
        this.jpaProxyDataAccessor.removeBooking(bkng.getID());
        assertFalse(this.jpaProxyDataAccessor.findAllBookings().contains(bkng));
    }
}
