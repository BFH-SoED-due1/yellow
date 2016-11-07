
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.room;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Unit tests for Building implementation
 */
public class BuildingImplTest {

    @Test
    public void testBuildingName() {

        BuildingImpl build1 = new BuildingImpl();

        assertNotNull(build1);

        String bName = "Lex Corp";

        build1.setName(bName);

        assertEquals(bName, build1.getName());
    }

    @Test
    public void testBuildingGPS() {

        BuildingImpl build1 = new BuildingImpl();

        assertNotNull(build1);

        String lat = "N40° 44.9764";
        String lon = "W073° 59.9735";

        GPSTagImpl gpsTag = new GPSTagImpl(lat, lon);

        build1.setGpsTag(gpsTag);

        GPSTagImpl gpsTagBuild = build1.getGpsTag();

        assertNotNull(gpsTagBuild);

        assertEquals(gpsTag.getXCoor(), lat);
        assertEquals(gpsTag.getYCoor(), lon);

    }

    @Test
    public void testRoomsInitialized() {

        BuildingImpl build1 = new BuildingImpl();

        Set<RoomImpl> roomSet = build1.getRoomsInBuilding();

        assertNotNull(roomSet);
    }

    @Test
    public void testAddRoomToBuilding() {

        BuildingImpl build1 = new BuildingImpl();

        RoomImpl rm1 = new RoomImpl();

        build1.addRoomToBuilding(rm1);

        assertTrue(build1.getRoomsInBuilding().contains(rm1));
    }
}