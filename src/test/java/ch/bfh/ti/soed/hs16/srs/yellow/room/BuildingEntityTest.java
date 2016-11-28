
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.room;

import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room.BuildingEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room.GPSTagEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Building;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.GPSTag;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for Building implementation
 */
public class BuildingEntityTest {

    @Test
    public void testBuildingCreation() {

        String lat = "26356";
        String lon = "6363653";
        String buildingName = "Hauptgebäude";
        String buildingName1 = "Hauptgebäude123";
        GPSTag gpsCoors = new GPSTagEntity(lat, lon);
        Building building = new BuildingEntity(buildingName, gpsCoors);
        Building building1 = new BuildingEntity(buildingName1, lat, lon);
        assertNotNull(building);
        assertNotNull(building1);
        assertEquals(building.getName(), buildingName);
        assertEquals(building1.getName(), buildingName1);
        assertEquals(building.getGpsTag(), gpsCoors);
        assertEquals(building.getGpsTag().getXCoor(), lat);
        assertEquals(building.getGpsTag().getYCoor(), lon);
    }

    @Test
    public void testBuildingName() {

        Building build1 = new BuildingEntity();

        assertNotNull(build1);

        String bName = "Lex Corp";

        build1.setName(bName);

        assertEquals(bName, build1.getName());
    }

    @Test
    public void testBuildingGPS() {

        Building build1 = new BuildingEntity();

        assertNotNull(build1);

        String lat = "N40° 44.9764";
        String lon = "W073° 59.9735";

        GPSTag gpsTag = new GPSTagEntity(lat, lon);

        build1.setGpsTag(gpsTag);

        GPSTag gpsTagBuild = build1.getGpsTag();

        assertNotNull(gpsTagBuild);

        assertEquals(gpsTag.getXCoor(), lat);
        assertEquals(gpsTag.getYCoor(), lon);

    }
/*
    @Test
    public void testRoomsInitialized() {

        Building build1 = new BuildingEntity();

        Set<Room> roomSet = build1.getRoomsInBuilding();

        assertNotNull(roomSet);
    }

    @Test
    public void testAddRoomToBuilding() {

        Building build1 = new BuildingEntity();

        Room rm1 = new RoomEntity();

        build1.addRoomToBuilding(rm1);

        assertTrue(build1.getRoomsInBuilding().contains(rm1));
    }*/
}
