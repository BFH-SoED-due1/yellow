
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.customer;


import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Person;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@Table(name = "Person")
public class PersonEntity
        implements Person {

    /**
     * PersonEntity can change any info except from UUID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    public PersonEntity() {

    }

    public Long getID() {
        return this.ID;
    }

    public String getLastName() {

        return lastName;
    }

	public void setLastName(String lastName) {

        this.lastName = lastName;
    }

	public String getFirstName() {

        return firstName;
    }

	public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

	public Date getDateOfBirth() {

        return dateOfBirth;
    }

	public void setDateOfBirth(Date dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

}
