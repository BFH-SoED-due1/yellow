
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.controllers;

import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.BookingEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.BuildingEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.CustomerEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.EquipmentEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.PersonEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.RoomEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Building;
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

    private static final String PERSISTENCE_UNIT_PRODUCTION = "srs-pu-production-derby-eclipselink";

    private static final String PERSISTENCE_UNIT_TEST = "srs-pu-test";

    private EntityManagerFactory entityManagerFactory = null;

    private EntityManager entityManager = null;

    private EntityTransaction entityTransaction = null;

    public JPARealDataAccessor() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_PRODUCTION);
            this.entityManager = entityManagerFactory.createEntityManager();
            this.generateFakeData();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public JPARealDataAccessor(String key) {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_TEST);
            this.entityManager = entityManagerFactory.createEntityManager();
            this.generateFakeData();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void generateFakeData() {
        Building building = this.makeBuilding("GEO1");
        Building building1 = this.makeBuilding("NAT2");
        Building building2 = this.makeBuilding("ROLEX3");
        Building building3 = this.makeBuilding("ID4");
        Building building4 = this.makeBuilding("TRN5");
        Equipment equipment = this.makeEquipment("TV");
        Equipment equipment1 = this.makeEquipment("Panoramic view");
        Equipment equipment2 = this.makeEquipment("Douche");
        Equipment equipment3 = this.makeEquipment("Projector");
        Equipment equipment4 = this.makeEquipment("Embedded PC");
        Customer customer = this.makeCustomer("nt4245", "rwutth9428*/&");
        Customer customer1 = this.makeCustomer("test", "twztuzrw85478&/(");
        Customer customer2 = this.makeCustomer("test1", "rwut428*/&");
        Customer customer3 = this.makeCustomer("test2", "fkdsnmfks428*/&");
        Customer customer4 = this.makeCustomer("test3", "rwutt(()7778*/&");
        Room room = this.makeRoom("N1", 15);
        Room room1 = this.makeRoom("N2", 10);
        Room room2 = this.makeRoom("N3", 12);
        Room room3 = this.makeRoom("N4", 13);
        Room room4 = this.makeRoom("N5", 16);
        Booking booking = this.makeBooking(customer, room, DateTime.now(), new DateTime(2017, 6, 2, 5, 17));
        Booking booking1 = this.makeBooking(customer1, room1, DateTime.now(), new DateTime(2017, 6, 2, 5, 13));
        Booking booking2 = this.makeBooking(customer, room, DateTime.now(), new DateTime(2017, 6, 2, 4, 17));
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
    public Customer makeCustomer(String name, String password) {
        this.entityManager.getTransaction().begin();
        CustomerEntity customer = new CustomerEntity();
        customer.setCredentials(name, password);
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

    @Override
    public Long authentifyCustomer(String login, String password) {
        EntityTransaction entr = this.entityManager.getTransaction();
        entr.begin();
        TypedQuery<Customer> query = this.entityManager.createQuery("SELECT c FROM CustomerEntity c " +
                "WHERE c.cred.login = :login " +
                "                                                           AND c.cred.passwordHash = :password", Customer.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        try {
            Customer c = query.getSingleResult();
            entr.commit();
            return c.getID();
        } catch (javax.persistence.NoResultException e) {
            entr.rollback();
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
    @SuppressWarnings("unchecked")
    public List<Booking> findAllBookings() {
        Query query = this.entityManager.createQuery("SELECT booking FROM BookingEntity booking");
        return query.getResultList();
    }

    @Override
    public void removeBooking(Long id) {
        this.entityManager.getTransaction().begin();
        BookingEntity booking = this.entityManager.find(BookingEntity.class, id);
        this.entityManager.remove(booking);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Building makeBuilding(String name) {
        this.entityManager.getTransaction().begin();
        Building building = new BuildingEntity();
        building.setName(name);
        this.entityManager.persist(building);
        this.entityManager.getTransaction().commit();
        return building;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Building> findAllBuildings() {
        Query query = this.entityManager.createQuery("select build from BuildingEntity build");
        return query.getResultList();
    }

}
