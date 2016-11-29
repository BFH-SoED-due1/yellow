
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.customer;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Credentials;
import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Entity(name = "CredentialsEntity")
@Access(AccessType.FIELD)
@Table(name = "Credentials")
public class CredentialsEntity
        implements Credentials,
        Serializable {

    @Id
    @Column(name = "cred_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    /**
     * Name under which the customer is known to system
     */
    @Column(name = "login")
    private String login;

    /**
     * Hash from customer's password from the input field (not a plaintext password !)
     */
    @Column(name = "pwd_hash")
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
