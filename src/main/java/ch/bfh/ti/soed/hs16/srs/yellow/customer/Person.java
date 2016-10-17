package ch.bfh.ti.soed.hs16.srs.yellow.customer;


import java.util.*;

/**
 * 
 */
public class Person {

    /**
     * 
     */
    private UUID ID;
    
    private String firstName;
    
    private String lastName;
    
    private Date dateOfBirth;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public UUID getPersonID() {
		return ID;
	}

	public void setPersonID(UUID personID) {
		this.ID = personID;
	}

}