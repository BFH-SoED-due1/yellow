
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.customer;

import ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations.BankingDetails;
import ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations.Payment;

import java.util.Set;

/**
 * CustomerImpl is a person which signed up for a login
 */
public interface Customer extends Person {

    /**
     * First generating a PersonImpl so that we could use his data and UUID database key
     */
    Set<BankingDetails> getBankingDetails();

    void addBankingDetail(BankingDetails bankingDetailsImpl);

    Set<Payment> getPayments();

    void addPayment(Payment paymentImpl);

    String getLogin();

    String getpwdHash();

    void setCredentials(String login, String pwdHash);

    void updateLogin(String newLogin);

    void updatePwdHash(String newPwdHash);
}