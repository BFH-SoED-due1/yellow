
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.room;


import ch.bfh.ti.soed.hs16.srs.yellow.impl.room.EquipmentImpl;

import java.util.Set;
import java.util.UUID;

/**
 *
 */
public interface Room {

    UUID getID();

    Set<EquipmentImpl> getEquSet();

    void addEquipment(EquipmentImpl newEquipmentImpl);

    void removeEquipment(EquipmentImpl equipmentImplToRemove);

}