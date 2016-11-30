
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.room;

import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.room.GPSTagEntity;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit tests for GPSTag implementation
 */
public class GPSTagTest {

    @Test
    public void testGetGPSXCoor() {

        String latitude = "N40° 44.9064";
        String longitude = "W073° 59.0735";
        GPSTagEntity gpsTag = new GPSTagEntity(latitude, longitude);
        assertEquals(gpsTag.getXCoor(), latitude);
    }

    @Test
    public void testGetGPSYCoor() {
        String latitude = "N40° 44.9064";
        String longitude = "W073° 59.0735";
        GPSTagEntity gpsTag = new GPSTagEntity(latitude, longitude);
        assertEquals(gpsTag.getYCoor(), longitude);
    }
}
