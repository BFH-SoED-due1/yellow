
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.jpa;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Person;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.jpa.DataAccessor;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;
import java.util.List;
import org.joda.time.DateTime;

public class JPAProxyDataAccessor
        implements DataAccessor {

    public static final String DEFAULT_DATA_ACCESS_CLASS = "ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.jpa.JPARealDataAccessor";
    private static JPAProxyDataAccessor instance = null;
    private JPARealDataAccessor realInstance = null;

    public JPAProxyDataAccessor() {
        if (realInstance == null) {
            try {
                realInstance = new JPARealDataAccessor();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.err.println("Could not load class: " + DEFAULT_DATA_ACCESS_CLASS);
                throw new RuntimeException("Could not load class: " + DEFAULT_DATA_ACCESS_CLASS);
            }
        }
    }

    // Methods for persons
    //////////////////////
    public Person makePerson(String name, String email) {
        return realInstance.makePerson(name, email);
    }

    public List<Person> findAllPersons() {
        return realInstance.findAllPersons();
    }

    public void removePerson(Long id) {
        realInstance.removePerson(id);
    }

    // Methods for rooms
    ////////////////////
    public Room makeRoom(String name, int capacity) {
        return realInstance.makeRoom(name, capacity);
    }

    public List<Room> findAllRooms() {
        return realInstance.findAllRooms();
    }

    public void removeRoom(Long id) {
    }

    public void makeBooking(Person person, Room room, DateTime start, DateTime end) {
        this.realInstance.makeBooking(person, room, start, end);
    }
}
