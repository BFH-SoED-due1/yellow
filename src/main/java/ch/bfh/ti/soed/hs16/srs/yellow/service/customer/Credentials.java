
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.customer;

/**
 *
 */
public interface Credentials {

    String getPasswordHash();

    void setPasswordHash(String passwordHash);

    String getLogin();

    void setLogin(String login);
}