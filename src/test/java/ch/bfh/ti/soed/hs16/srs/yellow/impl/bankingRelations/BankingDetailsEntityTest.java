
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */


package ch.bfh.ti.soed.hs16.srs.yellow.impl.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.BankingDetailsEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.BankingDetails;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for BankingDetails implementation
 */
public class BankingDetailsEntityTest {

    @Test
    public void testGetID() throws Exception {
        BankingDetails bankingDetails = new BankingDetailsEntity();
        assertNotNull(bankingDetails);
    }

    @Test
    public void testGetSetCardNumber() throws Exception {
        BankingDetails bankingDetails = new BankingDetailsEntity();
        String cardNo = "1234567898765432";
        bankingDetails.setCardNumber(cardNo);
        assertEquals(cardNo, bankingDetails.getCardNumber());
    }

    @Test
    public void testGetSetCardName() throws Exception {
        BankingDetails bankingDetails = new BankingDetailsEntity();
        String cardName = "Bean Entity";
        bankingDetails.setCardName(cardName);
        assertEquals(cardName, bankingDetails.getCardName());
    }
}
