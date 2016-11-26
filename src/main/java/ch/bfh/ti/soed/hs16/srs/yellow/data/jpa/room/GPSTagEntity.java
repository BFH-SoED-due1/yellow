
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.GPSTag;

import javax.persistence.*;

/**
 * Tag in global positioning system
 */
@Entity
@Table(name = "GPSTag")
public class GPSTagEntity
        implements GPSTag {

    private final String XCoor;
    private final String YCoor;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    /**
     * Default constructor
     */
    public GPSTagEntity(String XCoor, String YCoor) {
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
