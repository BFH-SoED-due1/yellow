

/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */


package ch.bfh.ti.soed.hs16.srs.yellow.impl.bankingRelations;


/**
 * Unit tests for BankingDetails implementation
 */
public class BankingDetailsEntityTest {

    /*@Test
    public void testGetID() throws Exception {
        UUID boundPerson = UUID.randomUUID();
        BankingDetails bankingDetails = new BankingDetailsEntity(boundPerson);
        assertNotNull(bankingDetails.getID());
    }*/

/*    @Test
    public void testGetBoundPersonID() throws Exception {
        Long boundPerson = UUID.randomUUID();
        BankingDetails bankingDetails = new BankingDetailsEntity(boundPerson);
        assertEquals(boundPerson, bankingDetails.getBoundPersonID());
    }

    @Test
    public void testGetSetCardNumber() throws Exception {
        UUID boundPerson = UUID.randomUUID();
        BankingDetails bankingDetails = new BankingDetailsEntity(boundPerson);
        String cardNo = "1234567898765432";
        bankingDetails.setCardNumber(cardNo);
        assertEquals(cardNo, bankingDetails.getCardNumber());
    }

    @Test
    public void testGetSetCardName() throws Exception {
        UUID boundPerson = UUID.randomUUID();
        BankingDetails bankingDetails = new BankingDetailsEntity(boundPerson);
        String cardName = "1234567898765432";
        bankingDetails.setCardName(cardName);
        assertEquals(cardName, bankingDetails.getCardName());
    }
/*
    @Test
    public void testGetSetProvider() throws Exception {
        UUID boundPerson = UUID.randomUUID();
        BankingDetails bankingDetails = new BankingDetailsEntity(boundPerson);
        bankingDetails.setProvider(BankCardProvider.Maestro);
        assertEquals(BankCardProvider.Maestro, bankingDetails.getProvider());
    }*/
}
