
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.room;

import java.util.Set;

/**
 * BuildingImpl class which holds Rooms
 */
public interface Building {

    String getName();

    void setName(String name);

    GPSTag getGpsTag();

    void setGpsTag(GPSTag gpsTag);

    Set<Room> getRoomsInBuilding();

    void addRoomToBuilding(Room newRoomImpl);
}
