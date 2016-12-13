
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.service;

import java.math.BigDecimal;

public interface Payment {

    Long getID();

    Boolean getIsSuccessful();

    void setIsSuccessful(Boolean isSuccessful);

    String getSumToPay();

    void setSumToPay(BigDecimal sumToPay);

}
