
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations;


/**
 * Banking details of a CustomerEntity
 */
public interface BankingDetails {

    Long getID();

    Long getBoundPersonID();

    String getCardNumber();

    void setCardNumber(String cardNumber);

    String getCardName();

    void setCardName(String cardName);

    // BankCardProvider getProvider();

    // void setProvider(BankCardProvider provider);

}
