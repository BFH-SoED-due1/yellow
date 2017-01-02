
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.entity;

import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.BankingDetailsEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.CustomerEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.PaymentEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.BankingDetails;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Payment;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for Customer implementation
 */
public class CustomerEntityTest extends PersonEntityTest {

    @Test
    public void testGetBankingDetailImpls() {

        Customer cust = new CustomerEntity();
        assertNotNull(cust.getBankingDetails());
    }

    @Test
    public void testAddBankingDetail() {

        BankingDetails bd = new BankingDetailsEntity();
        Customer cust = new CustomerEntity();
        cust.addBankingDetail(bd);
        assertTrue(cust.getBankingDetails().contains(bd));
    }

    @Test
    public void testGetPaymentImpls() {

        Payment pt = new PaymentEntity();
        BigDecimal bd = new BigDecimal("76.8598");
        pt.setSumToPay(bd);
        Customer cust = new CustomerEntity();
        cust.addPayment(pt);
        assertNotNull(cust.getPayments());
    }

    @Test
    public void testAddPayment() {

        Payment pt = new PaymentEntity();
        BigDecimal bd = new BigDecimal("78.8598");
        pt.setSumToPay(bd);
        Customer cust = new CustomerEntity();
        cust.addPayment(pt);
        assertTrue(cust.getPayments().contains(pt));
    }

    @Test
    public void testGetLogin() {

        String login1 = "Twilight123";
        String pwd1 = "47236494014jhfjdsh";
        Customer cust = new CustomerEntity();
        cust.setCredentials(login1, pwd1);
        assertEquals(login1, cust.getLogin());
    }

    @Test
    public void testGetpwdHash() {

        String login1 = "Twilight123";
        String pwd1 = "47236494014jhfjdsh";
        Customer cust = new CustomerEntity();
        cust.setCredentials(login1, pwd1);
        assertEquals(pwd1, cust.getpwdHash());
    }

    @Test
    public void testSetCredentials() {

        String login = "Twi78789";
        String pwd1 = "47236494014jhjfikdsjsh";
        Customer cust = new CustomerEntity();
        cust.setCredentials(login, pwd1);
        assertEquals(login, cust.getLogin());
        assertEquals(pwd1, cust.getpwdHash());
    }

    @Test
    public void testUpdateLogin() {

        String loginOld = "Twilight123";
        String pwd1 = "47236494014jhfjdsh";
        Customer cust = new CustomerEntity();
        cust.setCredentials(loginOld, pwd1);
        assertEquals(loginOld, cust.getLogin());

        String loginNew = "GTX980Ti";
        cust.updateLogin(loginNew);
        assertEquals(loginNew, cust.getLogin());
    }

    @Test
    public void testUpdatePwdHash() {

        String login1 = "Twilight123";
        String pwdOld = "47236494014jhfjdsh";
        String pwdNew = "47236494014jhfjiajfiuhfw";
        Customer cust = new CustomerEntity();
        cust.setCredentials(login1, pwdOld);
        assertEquals(pwdOld, cust.getpwdHash());

        cust.updatePwdHash(pwdNew);
        assertEquals(pwdNew, cust.getpwdHash());
    }
}
