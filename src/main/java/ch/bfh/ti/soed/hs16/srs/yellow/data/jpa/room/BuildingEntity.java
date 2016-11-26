
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Building;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.GPSTag;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * BuildingEntity class which holds Rooms
 */
@Entity
@Table(name = "Building")
public class BuildingEntity
        implements Building {

    private String name;

    private GPSTag gpsTag;

    private Set<Room> roomsInBuilding;

    public BuildingEntity() {

        name = "";
        gpsTag = new GPSTagEntity("0", "0");
        roomsInBuilding = new HashSet<>();

    }

    public BuildingEntity(String name, GPSTag tag) {

        this.name = name;
        this.gpsTag = tag;
        roomsInBuilding = new HashSet<>();

    }

    public BuildingEntity(String name, String latitude, String longitude) {

        this.name = name;
        this.gpsTag = new GPSTagEntity(latitude, longitude);
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
