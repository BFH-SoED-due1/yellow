
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.room;

import ch.bfh.ti.soed.hs16.srs.yellow.service.room.Room;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

/**
 *
 */
public class RoomImpl
        implements Room {

    private final UUID ID;

    private Set<EquipmentImpl> equSet;

    public RoomImpl() {
        this.ID = UUID.randomUUID();
    }

    public UUID getID() {
        return this.ID;
    }

    public Set<EquipmentImpl> getEquSet() {
        return Collections.unmodifiableSet(equSet);
    }

    public void addEquipment(EquipmentImpl newEquipmentImpl) {
        this.equSet.add(newEquipmentImpl);
    }

    public void removeEquipment(EquipmentImpl equipmentImplToRemove) {
        this.equSet.remove(equipmentImplToRemove);
    }

}