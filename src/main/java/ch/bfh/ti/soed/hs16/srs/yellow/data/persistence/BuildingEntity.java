
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Building;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.GPSTag;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Room;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * BuildingEntity class which holds Rooms
 */
@Entity(name = "BuildingEntity")
@Access(AccessType.FIELD)
@Table(name = "Buildings")
public class BuildingEntity
        implements Building,
        Serializable {

    @Id
    @Column(name = "building_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "building_name")
    private String name;

    @ManyToOne(targetEntity = GPSTagEntity.class)
    private GPSTag gpsTag;

    @OneToMany(targetEntity = RoomEntity.class)
    private Set<Room> roomsInBuilding = new HashSet<>();

    public BuildingEntity() {
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
