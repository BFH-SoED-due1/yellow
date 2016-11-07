
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.customer;


import java.util.Date;
import java.util.UUID;

/**
 *
 */
public interface Person {

    /**
     * PersonImpl can change any info except from UUID
     */
    UUID getPersonID();

    String getLastName();

    void setLastName(String lastName);

    String getFirstName();

    void setFirstName(String firstName);

    Date getDateOfBirth();

    void setDateOfBirth(Date dateOfBirth);

}