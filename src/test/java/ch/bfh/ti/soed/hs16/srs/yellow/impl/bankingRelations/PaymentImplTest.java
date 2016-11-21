
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations.Payment;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

/**
 * Unit tests for Payment implementation
 */
public class PaymentImplTest {

    @Test
    public void testGetID() {
        Payment pay = new PaymentImpl();
        UUID response = pay.getID();
        assertNotNull(response);
    }

    @Test
    public void testIsSuccessful() {
        Payment pay = new PaymentImpl();
        assertFalse(pay.getIsSuccessful());
        boolean payStat = true;
        pay.setIsSuccessful(payStat);
        assertTrue(pay.getIsSuccessful());
    }


    /* Pay attention, a VERY dangerous test! */
    @Test
    public void testGetSetSumToPay() {
        Payment pay = new PaymentImpl();
        BigDecimal bd = new BigDecimal("76.86");
        pay.setSumToPay(bd);
        String response = pay.getSumToPay();
        assertEquals(response, "$" + bd.toPlainString());
    }
}