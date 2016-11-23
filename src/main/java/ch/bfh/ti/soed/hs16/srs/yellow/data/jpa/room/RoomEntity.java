
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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 *
 */
public class RoomEntity
        implements Room {

    private final UUID ID;

    /**
     *
     */
    private Set<Equipment> equSet;

    public RoomEntity() {
        this.ID = UUID.randomUUID();
        equSet = new HashSet<>();
    }

    public UUID getID() {
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
