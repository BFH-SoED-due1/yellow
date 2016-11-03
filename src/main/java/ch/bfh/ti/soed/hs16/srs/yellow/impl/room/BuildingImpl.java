
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.room;

import ch.bfh.ti.soed.hs16.srs.yellow.service.room.Building;

import java.util.Set;

/**
 * BuildingImpl class which holds Rooms
 */
public class BuildingImpl
        implements Building {

    /**
     *
     */
    private String Name;

    private GPSTagImpl gpsTag;

    private Set<RoomImpl> roomsInBuilding;

    /**
     * Default constructor
     */
    public BuildingImpl() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public GPSTagImpl getGpsTag() {
        return gpsTag;
    }

    public void setGpsTag(GPSTagImpl gpsTag) {
        this.gpsTag = gpsTag;
    }

    public Set<RoomImpl> getRoomsInBuilding() {
        return roomsInBuilding;
    }

    public void addRoomToBuilding(RoomImpl newRoomImpl) {
        this.roomsInBuilding.add(newRoomImpl);
    }
}