
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.room;

import ch.bfh.ti.soed.hs16.srs.yellow.service.room.GPSTag;

/**
 * Tag in global positioning system
 */
public class GPSTagImpl
        implements GPSTag {

    private final String XCoor;

    private final String YCoor;

    /**
     * Default constructor
     */
    public GPSTagImpl(String XCoor, String YCoor) {
        this.XCoor = XCoor;
        this.YCoor = YCoor;
    }

    public String getXCoor() {
        return XCoor;
    }

    public String getYCoor() {
        return YCoor;
    }

}
