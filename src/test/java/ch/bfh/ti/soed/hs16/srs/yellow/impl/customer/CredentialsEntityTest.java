
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.customer;

import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.customer.CredentialsEntity;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit tests for Credentials implementation
 */
public class CredentialsEntityTest {

	@Test
	public void testCredentialsPassword() {

        CredentialsEntity cred1 = new CredentialsEntity();

        String passw = "hallo123";
        cred1.setPasswordHash(passw);
		
		assertEquals(passw, cred1.getPasswordHash());
	}
	
	@Test
	public void testCredentialsLogin() {
        CredentialsEntity cred1 = new CredentialsEntity();

        String user = "admin";
        cred1.setLogin(user);
		
		assertEquals(user, cred1.getLogin());
	}
}