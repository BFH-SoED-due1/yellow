
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
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Unit tests for Building implementation
 */
public class BuildingImplTest {

    @Test
    public void testBuildingName() {

        Building build1 = new BuildingImpl();

        assertNotNull(build1);

        String bName = "Lex Corp";

        build1.setName(bName);

        assertEquals(bName, build1.getName());
    }

    @Test
    public void testBuildingGPS() {

        Building build1 = new BuildingImpl();

        assertNotNull(build1);

        String lat = "N40° 44.9764";
        String lon = "W073° 59.9735";

        GPSTag gpsTag = new GPSTagImpl(lat, lon);

        build1.setGpsTag(gpsTag);

        GPSTag gpsTagBuild = build1.getGpsTag();

        assertNotNull(gpsTagBuild);

        assertEquals(gpsTag.getXCoor(), lat);
        assertEquals(gpsTag.getYCoor(), lon);

    }

    @Test
    public void testRoomsInitialized() {

        Building build1 = new BuildingImpl();

        Set<Room> roomSet = build1.getRoomsInBuilding();

        assertNotNull(roomSet);
    }

    @Test
    public void testAddRoomToBuilding() {

        Building build1 = new BuildingImpl();

        Room rm1 = new RoomImpl();

        build1.addRoomToBuilding(rm1);

        assertTrue(build1.getRoomsInBuilding().contains(rm1));
    }
}