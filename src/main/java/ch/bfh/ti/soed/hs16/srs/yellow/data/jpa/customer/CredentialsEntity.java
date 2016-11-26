
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.customer;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Credentials;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "Credentials")
public class CredentialsEntity
        implements Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    /**
     * Name under which the customer is known to system
     */
    private String login;

    /**
     * Hash from customer's password from the input field (not a plaintext password !)
     */
    private String passwordHash;

    public CredentialsEntity() {
    }

    public String getPasswordHash() {

        return this.passwordHash;
	}


	public void setPasswordHash(String passwordHash) {

        this.passwordHash = passwordHash;
	}

	public String getLogin() {

        return this.login;
	}

	public void setLogin(String login) {

        this.login = login;
	}
}
