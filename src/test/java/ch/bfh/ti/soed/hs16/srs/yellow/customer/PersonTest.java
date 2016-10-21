package ch.bfh.ti.soed.hs16.srs.yellow.customer;


import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/**
 * 
 */
public class PersonTest {

	@Test
	public void testGetPersonID() {
		Person person1 = new Person();
		assertNotNull(person1.getPersonID());
	}
	
	@Test
	public void testPersonName() {
		Person person1 = new Person();
		
		String fName = "Barry";
		String lName = "Allen";
		
		person1.setFirstName(fName);
		person1.setLastName(lName);
		
		assertEquals(fName, person1.getFirstName());
		assertEquals(lName, person1.getLastName());
	}
	
//	Date format?
//	@Test
//	public void testBirthDate() {
//		Person person1 = new Person();
//		
//		Date birthDate = 
//		assertEquals(birthDate, person1.getDateOfBirth());
//	}
	
}