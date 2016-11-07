
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.customer;


import ch.bfh.ti.soed.hs16.srs.yellow.service.customer.Person;

import java.util.Date;
import java.util.UUID;

/**
 * 
 */
public class PersonImpl
        implements Person {

    /**
     * PersonImpl can change any info except from UUID
     */
    private final UUID ID;
    
    private String firstName;
    
    private String lastName;
    
    private Date dateOfBirth;

    public PersonImpl() {
        this.ID = UUID.randomUUID();
    }
    
	public UUID getPersonID() {
		return ID;
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