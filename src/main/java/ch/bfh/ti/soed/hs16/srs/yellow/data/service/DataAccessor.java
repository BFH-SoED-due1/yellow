
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.service;

import org.joda.time.DateTime;

import java.util.List;

public interface DataAccessor {
    // Methods for persons
    //////////////////////
    Person makePerson(String name, String email);

    List<Person> findAllPersons();

    void removePerson(Long id);

    // Methods for customers
    //////////////////////
    Customer makeCustomer(String name, String email);

    List<Customer> findAllCustomers();

    void removeCustomer(Long id);

    Long authentifyCustomer(String login, String password);

    // Methods for rooms
    ////////////////////
    Room makeRoom(String name, int capacity);

    List<Room> findAllRooms();

    void removeRoom(Long id);

    Booking makeBooking(Person person, Room room, DateTime start, DateTime end);

    Equipment makeEquipment(String description);

    void removeEquipment(Long id);

    @SuppressWarnings("unchecked")
    List<Equipment> findAllEquipments();

    @SuppressWarnings("unchecked")
    List<Booking> findAllBookings();

    void removeBooking(Long id);

    List<Building> findAllBuildings();
}
