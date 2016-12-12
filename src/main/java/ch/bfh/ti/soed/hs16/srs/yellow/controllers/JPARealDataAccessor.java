
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.controllers;

import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.BookingEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.CustomerEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.EquipmentEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.PersonEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.RoomEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.DataAccessor;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Equipment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Person;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Room;
import org.joda.time.DateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPARealDataAccessor
        implements DataAccessor {

    public static final String PERSISTENCE_UNIT = "srs-pu";

    private EntityManagerFactory entityManagerFactory = null;

    private EntityManager entityManager = null;

    private EntityTransaction entityTransaction = null;

    public JPARealDataAccessor() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            this.entityManager = entityManagerFactory.createEntityManager();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Person makePerson(String name, String email) {
        this.entityManager.getTransaction().begin();
        PersonEntity person = new PersonEntity();
        this.entityManager.persist(person);
        this.entityManager.getTransaction().commit();
        return person;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> findAllPersons() {
        Query query = this.entityManager.createQuery("select p from PersonEntity p");
        return query.getResultList();
    }

    @Override
    public void removePerson(Long id) {
        this.entityManager.getTransaction().begin();
        PersonEntity person = this.entityManager.find(PersonEntity.class, id);
        this.entityManager.remove(person);
        this.entityManager.getTransaction().commit();

    }

    @Override
    public Customer makeCustomer(String name, String email) {
        this.entityManager.getTransaction().begin();
        CustomerEntity customer = new CustomerEntity();
        this.entityManager.persist(customer);
        this.entityManager.getTransaction().commit();
        return customer;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> findAllCustomers() {
        Query query = this.entityManager.createQuery("select c from CustomerEntity c");
        return query.getResultList();
    }

    @Override
    public void removeCustomer(Long id) {
        this.entityManager.getTransaction().begin();
        CustomerEntity customer = this.entityManager.find(CustomerEntity.class, id);
        this.entityManager.remove(customer);
        this.entityManager.getTransaction().commit();

    }

    public Long authentifyCustomer(String login, String password) {
        EntityTransaction entr = this.entityManager.getTransaction();
        entr.begin();
        TypedQuery<Customer> query = this.entityManager.createQuery("SELECT c FROM CustomerEntity c WHERE c.cred.login = :login AND c.cred.passwordHash = :password", Customer.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        try {
            Customer c = query.getSingleResult();
            return c.getID();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public Room makeRoom(String name, int capacity) {
        this.entityManager.getTransaction().begin();
        RoomEntity room = new RoomEntity();
        this.entityManager.persist(room);
        this.entityManager.getTransaction().commit();
        return room;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Room> findAllRooms() {
        Query query = this.entityManager.createQuery("select r from RoomEntity r");
        return query.getResultList();
    }

    @Override
    public void removeRoom(Long id) {
        this.entityManager.getTransaction().begin();
        RoomEntity room = this.entityManager.find(RoomEntity.class, id);
        this.entityManager.remove(room);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Booking makeBooking(Person person, Room room, DateTime start, DateTime end) {
        this.entityManager.getTransaction().begin();
        Booking booking = new BookingEntity();
        booking.setBookedRoom(room);
        booking.setInterval(start, end);
        this.entityManager.persist(booking);
        this.entityManager.getTransaction().commit();
        // person.addBooking(booking);
        return booking;
    }

    @Override
    public Equipment makeEquipment(String description) {
        this.entityManager.getTransaction().begin();
        Equipment equipment = new EquipmentEntity();
        equipment.setDescription(description);
        this.entityManager.persist(equipment);
        this.entityManager.getTransaction().commit();
        return equipment;
    }

    @Override
    public void removeEquipment(Long id) {
        this.entityManager.getTransaction().begin();
        EquipmentEntity equipment = this.entityManager.find(EquipmentEntity.class, id);
        this.entityManager.remove(equipment);
        this.entityManager.getTransaction().commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Equipment> findAllEquipments() {
        Query query = this.entityManager.createQuery("select equ from EquipmentEntity equ");
        return query.getResultList();
    }

    @Override
    public List<Booking> findAllBookings() {
        Query query = this.entityManager.createQuery("select booking from BookingEntity booking");
        return query.getResultList();
    }

    @Override
    public void removeBooking(Long id) {
        this.entityManager.getTransaction().begin();
        BookingEntity booking = this.entityManager.find(BookingEntity.class, id);
        this.entityManager.remove(booking);
        this.entityManager.getTransaction().commit();
    }

}
