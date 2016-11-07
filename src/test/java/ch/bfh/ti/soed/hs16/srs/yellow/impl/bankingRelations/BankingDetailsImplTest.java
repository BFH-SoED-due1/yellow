

/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */


package ch.bfh.ti.soed.hs16.srs.yellow.impl.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations.BankingDetails;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for BankingDetails implementation
 */
public class BankingDetailsImplTest {
    @Test
    public void testGetID() throws Exception {
        UUID boundPerson = UUID.randomUUID();
        BankingDetails bankingDetails = new BankingDetailsImpl(boundPerson);
        assertNotNull(bankingDetails.getID());
    }

    @Test
    public void testGetBoundPersonID() throws Exception {
        UUID boundPerson = UUID.randomUUID();
        BankingDetails bankingDetails = new BankingDetailsImpl(boundPerson);
        assertEquals(boundPerson, bankingDetails.getBoundPersonID());
    }

    @Test
    public void testGetSetCardNumber() throws Exception {
        UUID boundPerson = UUID.randomUUID();
        BankingDetails bankingDetails = new BankingDetailsImpl(boundPerson);
        String cardNo = "1234567898765432";
        bankingDetails.setCardNumber(cardNo);
        assertEquals(cardNo, bankingDetails.getCardNumber());
    }

    @Test
    public void testGetSetCardName() throws Exception {
        UUID boundPerson = UUID.randomUUID();
        BankingDetails bankingDetails = new BankingDetailsImpl(boundPerson);
        String cardName = "1234567898765432";
        bankingDetails.setCardName(cardName);
        assertEquals(cardName, bankingDetails.getCardName());
    }

    @Test
    public void testGetSetProvider() throws Exception {
        UUID boundPerson = UUID.randomUUID();
        BankingDetails bankingDetails = new BankingDetailsImpl(boundPerson);
        bankingDetails.setProvider(BankCardProvider.Maestro);
        assertEquals(BankCardProvider.Maestro, bankingDetails.getProvider());
    }
}