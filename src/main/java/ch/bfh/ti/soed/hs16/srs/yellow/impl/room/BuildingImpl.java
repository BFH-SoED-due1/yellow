
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.room;

import ch.bfh.ti.soed.hs16.srs.yellow.service.room.Building;

import java.util.HashSet;
import java.util.Set;

/**
 * BuildingImpl class which holds Rooms
 */
public class BuildingImpl
        implements Building {

    private String name;

    private GPSTagImpl gpsTag;

    private Set<RoomImpl> roomsInBuilding;

    public BuildingImpl() {

        name = "";
        gpsTag = new GPSTagImpl("0", "0");
        roomsInBuilding = new HashSet<>();

    }

    public BuildingImpl(String name, GPSTagImpl tag) {

        this.name = name;
        this.gpsTag = tag;
        roomsInBuilding = new HashSet<>();

    }

    public BuildingImpl(String name, String latitude, String longitude) {

        this.name = name;
        this.gpsTag = new GPSTagImpl(latitude, longitude);
        roomsInBuilding = new HashSet<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
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