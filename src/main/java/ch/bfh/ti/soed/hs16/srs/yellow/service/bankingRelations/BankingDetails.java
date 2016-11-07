
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.impl.bankingRelations.BankCardProvider;

import java.util.UUID;

/**
 * Banking details of a CustomerImpl
 */
public interface BankingDetails {

    UUID getID();

    UUID getBoundPersonID();

    String getCardNumber();

    void setCardNumber(String cardNumber);

    String getCardName();

    void setCardName(String cardName);

    BankCardProvider getProvider();

    void setProvider(BankCardProvider provider);

}