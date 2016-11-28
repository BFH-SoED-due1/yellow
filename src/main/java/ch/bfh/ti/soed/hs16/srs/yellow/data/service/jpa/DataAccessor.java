package ch.bfh.ti.soed.hs16.srs.yellow.data.service.jpa;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Person;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;

import java.util.List;

/**
 * Created by rdrand on 28/11/16.
 */
public interface DataAccessor {
    // Methods for persons
    //////////////////////
    Person makePerson(String name, String email);

    List<Person> findAllPersons();

    void removePerson(Long id);

    // Methods for rooms
    ////////////////////
    Room makeRoom(String name, int capacity);

    List<Room> findAllRooms();

    void removeRoom(Long id);
}
