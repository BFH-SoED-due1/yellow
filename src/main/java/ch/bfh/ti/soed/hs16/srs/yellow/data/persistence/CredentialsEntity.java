
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Credentials;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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

    @Column(name = "login")
    private String login;

    @Column(name = "pwd_hash")
    private String passwordHash;

    /**
     * Default constructor. Must be used in order for O/R Mapper to function properly. Must be empty.
     */
    public CredentialsEntity() {
    }

    /**
     * @return hash of a password to be checked for correctness
     */
    public String getPasswordHash() {
        return this.passwordHash;
    }

    /**
     * Sets hash of user password
     *
     * @param passwordHash hash of the user's password
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * @return login name of the customer
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Sets login of the user
     * @param login login of the user
     */
    public void setLogin(String login) {
        this.login = login;
    }
}
