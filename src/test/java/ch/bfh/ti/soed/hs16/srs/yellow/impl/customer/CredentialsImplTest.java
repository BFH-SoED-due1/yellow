
package ch.bfh.ti.soed.hs16.srs.yellow.impl.customer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 
 */
public class CredentialsImplTest {

	@Test
	public void testCredentialsPassword() {
        CredentialsImpl cred1 = new CredentialsImpl();

        String passw = "hallo123";
        cred1.setPasswordHash(passw);
		
		assertEquals(passw, cred1.getPasswordHash());
	}
	
	@Test
	public void testCredentialsLogin() {
        CredentialsImpl cred1 = new CredentialsImpl();

        String user = "admin";
        cred1.setLogin(user);
		
		assertEquals(user, cred1.getLogin());
	}
}