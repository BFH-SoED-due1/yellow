
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.service.room;


/**
 * Describes equipment which is available to the room
 */
public interface Equipment {

    Long getID();

    String getDescription();

    void setDescription(String description);
}
