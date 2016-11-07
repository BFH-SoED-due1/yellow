
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations;


import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 */
public interface Payment {

    UUID getID();

    Boolean getIsSuccessful();

    /**
     * @param isSuccessful
     */
    public void setIsSuccessful(Boolean isSuccessful);

    public String getSumToPay();

    /**
     * @param sumToPay
     */
    public void setSumToPay(BigDecimal sumToPay);

}