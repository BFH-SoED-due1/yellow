
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations;


import java.util.UUID;

/**
 *
 */
public interface Payment {

    UUID getID();

    Boolean getIsSuccessful();

    void setIs_successful(Boolean isSuccessful);

    int getSumToPay();

    void setSumToPay(int sumToPay);

}