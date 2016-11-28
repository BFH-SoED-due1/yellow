
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data;

import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.jpa.JPAProxyDataAccessor;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Person;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

     /*   @Test
        public void makeReservation() {
            Person aPerson = this.JPAProxyDataAccessor.makePerson("Dubuis, Eric", "due1@nodomain.org");
            Room aRoom = this.JPAProxyDataAccessor.makeRoom("N215", 12);
            DateRangeFactory dateRangeFactory = new ch.bfh.ti.daterange.impl.pojo.DateRangeFactory();
            LocalDateTime ltBegin = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
            Date startTime = Date.from(ltBegin.atZone(ZoneId.systemDefault()).toInstant());
            LocalDateTime ltEnd = ltBegin.plusHours(1);
            Date endTime = Date.from(ltEnd.atZone(ZoneId.systemDefault()).toInstant());
            DateRange timeslot = dateRangeFactory.createDateRange(startTime, endTime);
            this.JPAProxyDataAccessor.makeReservation(aPerson, aRoom, timeslot);
            // Test if due1's reservation list has been updated
            List<Reservation> res1 = aPerson.getReservations();
            assertNotNull(res1);
            // Test if n215's reservation list has been updated
            List<Reservation> res2 = aRoom.getReservations();
            assertNotNull(res2);
        }*/
}
