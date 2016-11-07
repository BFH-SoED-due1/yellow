
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.room;


import java.util.Set;
import java.util.UUID;

/**
 *
 */
public interface Room {

    UUID getID();

    Set<Equipment> getEquSet();

    void addEquipment(Equipment newEquipmentImpl);

    void removeEquipment(Equipment equipmentImplToRemove);

}