
package ch.bfh.ti.soed.hs16.srs.yellow.customer;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */
public class CredentialsTest {

	@Test
	public void testCredentialsPassword() {
		Credentials cred1 = new Credentials();
		
		String passw = "hallo123";
		cred1.setPasswordHash(passw);
		
		assertEquals(passw, cred1.getPasswordHash());
	}
	
	@Test
	public void testCredentialsLogin() {
		Credentials cred1 = new Credentials();
		
		String user = "admin";
		cred1.setLogin(user);
		
		assertEquals(user, cred1.getLogin());
	}
}