

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

/**
 * Unit tests for BankingDetails implementation
 */
public class BankingDetailsImplTest {

    @Test
    public void testCreationOfIDs() {

        UUID boundPerson = UUID.randomUUID();
        BankingDetails bankingDetails = new BankingDetailsImpl(boundPerson);

        UUID return =bankingDetails.getID();
    }
}