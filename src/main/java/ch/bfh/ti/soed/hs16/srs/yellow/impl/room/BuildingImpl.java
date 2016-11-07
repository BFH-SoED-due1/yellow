
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.room;

import ch.bfh.ti.soed.hs16.srs.yellow.service.room.Building;
import ch.bfh.ti.soed.hs16.srs.yellow.service.room.GPSTag;
import ch.bfh.ti.soed.hs16.srs.yellow.service.room.Room;

import java.util.HashSet;
import java.util.Set;

/**
 * BuildingImpl class which holds Rooms
 */
public class BuildingImpl
        implements Building {

    private String name;

    private GPSTag gpsTag;

    private Set<Room> roomsInBuilding;

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

    public GPSTag getGpsTag() {

        return gpsTag;
    }

    public void setGpsTag(GPSTag gpsTag) {

        this.gpsTag = gpsTag;
    }

    public Set<Room> getRoomsInBuilding() {

        return roomsInBuilding;
    }

    public void addRoomToBuilding(Room newRoom) {

        this.roomsInBuilding.add(newRoom);
    }
}