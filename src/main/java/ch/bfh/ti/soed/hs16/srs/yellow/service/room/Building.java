
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.room;

import ch.bfh.ti.soed.hs16.srs.yellow.impl.room.GPSTagImpl;
import ch.bfh.ti.soed.hs16.srs.yellow.impl.room.RoomImpl;

import java.util.Set;

/**
 * BuildingImpl class which holds Rooms
 */
public interface Building {

    String getName();

    void setName(String name);

    GPSTagImpl getGpsTag();

    void setGpsTag(GPSTagImpl gpsTag);

    Set<RoomImpl> getRoomsInBuilding();

    void addRoomToBuilding(RoomImpl newRoomImpl);
}