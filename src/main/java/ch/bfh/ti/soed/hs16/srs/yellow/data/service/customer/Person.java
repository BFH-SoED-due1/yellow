
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer;


import java.util.Date;

/**
 *
 */
public interface Person {

    /**
     * PersonEntity can change any info except from UUID
     */
    Long getID();

    String getLastName();

    void setLastName(String lastName);

    String getFirstName();

    void setFirstName(String firstName);

    Date getDateOfBirth();

    void setDateOfBirth(Date dateOfBirth);

}
