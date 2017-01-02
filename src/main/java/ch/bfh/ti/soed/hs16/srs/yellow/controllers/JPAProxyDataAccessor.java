
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.controllers;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Building;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.DataAccessor;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Equipment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Person;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Room;
import org.joda.time.DateTime;

import java.util.List;

public class JPAProxyDataAccessor
        implements DataAccessor {

    private static final String DEFAULT_DATA_ACCESS_CLASS = "JPARealDataAccessor";
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

    public JPAProxyDataAccessor(String key) {
        if (realInstance == null) {
            try {
                realInstance = new JPARealDataAccessor(key);
            } catch (Exception ex) {
                ex.printStackTrace();
                System.err.println("Could not load class: " + DEFAULT_DATA_ACCESS_CLASS);
                throw new RuntimeException("Could not load class: " + DEFAULT_DATA_ACCESS_CLASS);
            }
        }
    }

    /**
     * Function to make a person
     *
     * @param name  Full-Qualified name of the person
     * @param email e-mail address of the person
     * @return Returns the created person
     */
    // Methods for persons
    //////////////////////
    @Override
    public Person makePerson(String name, String email) {
        return realInstance.makePerson(name, email);
    }

    /**
     * Function to find all persons in the database
     * @return List of all persons in the database
     */
    @Override
    public List<Person> findAllPersons() {
        return realInstance.findAllPersons();
    }


    @Override
    public void removePerson(Long id) {
        realInstance.removePerson(id);
    }

    // Methods for customers
    //////////////////////
    @Override
    public Customer makeCustomer(String name, String password) {
        return realInstance.makeCustomer(name, password);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return realInstance.findAllCustomers();
    }

    @Override
    public void removeCustomer(Long id) {
        realInstance.removeCustomer(id);
    }

    @Override
    public Long authentifyCustomer(String login, String password) {
        return realInstance.authentifyCustomer(login, password);
    }

    // Methods for rooms
    ////////////////////
    @Override
    public Room makeRoom(String name, int capacity) {
        return realInstance.makeRoom(name, capacity);
    }

    @Override
    public List<Room> findAllRooms() {
        return realInstance.findAllRooms();
    }

    @Override
    public void removeRoom(Long id) {
        realInstance.removeRoom(id);
    }

    // Methods for bookings
    ////////////////////
    @Override
    public Booking makeBooking(Person person, Room room, DateTime start, DateTime end) {
        return this.realInstance.makeBooking(person, room, start, end);
    }

    @Override
    public void removeBooking(Long id) {
        this.realInstance.removeBooking(id);
    }

    @Override
    public List<Booking> findAllBookings() {
        return this.realInstance.findAllBookings();
    }

    // Methods for equipments
    ////////////////////
    @Override
    public Equipment makeEquipment(String description) {
        return this.realInstance.makeEquipment(description);
    }

    @Override
    public void removeEquipment(Long id) {
        this.realInstance.removeEquipment(id);
    }

    @Override
    public List<Equipment> findAllEquipments() {
        return this.realInstance.findAllEquipments();
    }

    // Methods for buildings
    ////////////////////
    @Override
    public List<Building> findAllBuildings() {
        return realInstance.findAllBuildings();
    }
}
