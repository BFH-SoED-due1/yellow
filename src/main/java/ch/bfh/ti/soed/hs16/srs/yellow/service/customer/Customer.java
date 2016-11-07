
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.customer;

import ch.bfh.ti.soed.hs16.srs.yellow.impl.bankingRelations.BankingDetailsImpl;
import ch.bfh.ti.soed.hs16.srs.yellow.impl.bankingRelations.PaymentImpl;

import java.util.Set;

/**
 * CustomerImpl is a person which signed up for a login
 */
public interface Customer extends Person {

    /**
     * First generating a PersonImpl so that we could use his data and UUID database key
     */
    Set<BankingDetailsImpl> getBankingDetails();

    void addBankingDetail(BankingDetailsImpl bankingDetailsImpl);

    Set<PaymentImpl> getPayments();

    void addPayment(PaymentImpl paymentImpl);

    String getLogin();

    String getpwdHash();

    void setCredentials(String login, String pwdHash);

    void updateLogin(String newLogin);

    void updatePwdHash(String newPwdHash);
}