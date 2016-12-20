
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.GPSTag;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Tag in global positioning system
 */
@Entity(name = "GPSTag")
@Access(AccessType.FIELD)
@Table(name = "GPSTag")
public class GPSTagEntity
        implements GPSTag,
        Serializable {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "xcoor")
    private String XCoor = "";

    @Column(name = "ycoor")
    private String YCoor = "";

    /**
     * Default constructor. Must be used in order for O/R Mapper to function properly. Must be empty.
     */
    public GPSTagEntity() {
    }

    /**
     * Constructor which initializes a new GPSTag with initial coordinates
     *
     * @param XCoor x coordinate
     * @param YCoor y coordinate
     */
    public GPSTagEntity(String XCoor, String YCoor) {
        this.XCoor = XCoor;
        this.YCoor = YCoor;
    }

    /**
     * @return X coordinate
     */
    public String getXCoor() {
        return XCoor;
    }

    /**
     * @return Y coordinate
     */
    public String getYCoor() {
        return YCoor;
    }

}
