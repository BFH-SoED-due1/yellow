
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Equipment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "Room")
public class RoomEntity
        implements Room {

    @Id
    @GeneratedValue
    private Long ID;

    /**
     *
     */
    private Set<Equipment> equSet;

    public RoomEntity() {
        equSet = new HashSet<>();
    }

    public Long getID() {
        return this.ID;
    }

    public Set<Equipment> getEquSet() {
        return Collections.unmodifiableSet(equSet);
    }

    public void addEquipment(Equipment newEquipmentImpl) {
        this.equSet.add(newEquipmentImpl);
    }

    public void removeEquipment(Equipment equipmentImplToRemove) {
        this.equSet.remove(equipmentImplToRemove);
    }

}
