
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

    public GPSTagEntity() {
    }

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
