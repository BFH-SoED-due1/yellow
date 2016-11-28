
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Person;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;

import java.util.List;

public abstract class DataAccess {

    // A more versatile approach could be introduced here:
    // - reading value via a Java property
    // - using Java's CDI
    public static final String DEFAULT_DATA_ACCESS_CLASS = "ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.JPADataAccess";

    private static DataAccess instance = null;

    public static DataAccess getInstance() {
        // The following is NOT thread safe:
        if (instance == null) {
            try {
                @SuppressWarnings("rawtypes")
                Class clazz = Class.forName(DEFAULT_DATA_ACCESS_CLASS);
                instance = (DataAccess) clazz.newInstance();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.err.println("Could not load class: " + DEFAULT_DATA_ACCESS_CLASS);
                throw new RuntimeException("Could not load class: " + DEFAULT_DATA_ACCESS_CLASS);
            }
        }
        return instance;
    }

    // Methods for persons
    //////////////////////
    public abstract Person makePerson(String name, String email);

    public abstract List<Person> findAllPersons();

    public abstract void removePerson(Long id);

    // Methods for rooms
    ////////////////////
    public abstract Room makeRoom(String name, int capacity);

    public abstract List<Room> findAllRooms();

    public abstract void removeRoom(Long id);
}
