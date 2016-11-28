
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa;

import ch.bfh.ti.soed.hs16.srs.yellow.data.DataAccess;
import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.customer.PersonEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room.RoomEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Person;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class JPADataAccess
        extends DataAccess {

    public static final String PERSISTENCE_UNIT = "srs-pu";
    private EntityManager entityManager;

    public JPADataAccess() {
        this.entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
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
}
