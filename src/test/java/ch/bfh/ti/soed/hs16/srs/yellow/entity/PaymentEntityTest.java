
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.entity;


import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.PaymentEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Payment;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for Payment implementation
 */
public class PaymentEntityTest {

    @Test
    public void testIfInitialized() {
        Payment pay = new PaymentEntity();
        assertNotNull(pay);
    }

    @Test
    public void testIsSuccessful() {
        Payment pay = new PaymentEntity();
        assertFalse(pay.getIsSuccessful());
        boolean payStat = true;
        pay.setIsSuccessful(payStat);
        assertTrue(pay.getIsSuccessful());
    }


    /* Pay attention, a VERY dangerous test! */
    @Test
    public void testGetSetSumToPay() {
        Payment pay = new PaymentEntity();
        BigDecimal bd = new BigDecimal("76.86");
        pay.setSumToPay(bd);
        String response = pay.getSumToPay();
        assertEquals(response, "$" + bd.toPlainString());
    }
}
