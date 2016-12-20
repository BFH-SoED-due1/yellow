
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

    /**
     * Default constructor. Must be used in order for O/R Mapper to function properly. Must be empty.
     */
    public BuildingEntity() {
    }

    /**
     * Constructor which initializes a building with initial data
     *
     * @param name Name of the building
     * @param tag  GPS Tag of the buildings coordinates
     */
    public BuildingEntity(String name, GPSTag tag) {

        this.name = name;
        this.gpsTag = tag;
        roomsInBuilding = new HashSet<>();

    }

    /**
     * Constructor which initializes a building without passing a GPS Tag
     * @param name Name of the building
     * @param latitude Latitude coordinates of the building
     * @param longitude Longitude coordinates of the building
     */
    public BuildingEntity(String name, String latitude, String longitude) {

        this.name = name;
        this.gpsTag = new GPSTagEntity(latitude, longitude);
        roomsInBuilding = new HashSet<>();

    }

    /**
     * @return Name of the building
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the building to new one
     * @param name Name of the building
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return Location of the building as GPS Tag
     */
    public GPSTag getGpsTag() {

        return gpsTag;
    }

    /**
     * Sets GPS Tag of the building to new one
     * @param gpsTag GPS Tag of the building
     */
    public void setGpsTag(GPSTag gpsTag) {

        this.gpsTag = gpsTag;
    }

    /**
     * @return set of all rooms in this building
     */
    public Set<Room> getRoomsInBuilding() {

        return roomsInBuilding;
    }

    /**
     * Adds room to building
     * @param newRoom Room to add to building
     */
    public void addRoomToBuilding(Room newRoom) {

        this.roomsInBuilding.add(newRoom);
    }
}
