
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations;


import java.math.BigDecimal;

/**
 *
 */
public interface Payment {

    Long getID();

    Boolean getIsSuccessful();

    /**
     * @param isSuccessful
     */
    void setIsSuccessful(Boolean isSuccessful);

    String getSumToPay();

    /**
     * @param sumToPay
     */
    void setSumToPay(BigDecimal sumToPay);

}
