
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.service;

import java.util.Set;

/**
 * CustomerEntity is a person which signed up for a login
 */
public interface Customer extends Person {

    Set<BankingDetails> getBankingDetails();

    void addBankingDetail(BankingDetails bankingDetails);

    Set<Payment> getPayments();

    void addPayment(Payment payment);

    String getLogin();

    String getpwdHash();

    void setCredentials(String login, String pwdHash);

    void updateLogin(String newLogin);

    void updatePwdHash(String newPwdHash);
}
