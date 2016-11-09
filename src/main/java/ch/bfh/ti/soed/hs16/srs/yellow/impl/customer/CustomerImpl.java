
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.customer;

import ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations.BankingDetails;
import ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations.Payment;
import ch.bfh.ti.soed.hs16.srs.yellow.service.customer.Credentials;
import ch.bfh.ti.soed.hs16.srs.yellow.service.customer.Customer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * CustomerImpl is a person which signed up for a login
 */
public class CustomerImpl
        extends PersonImpl
        implements Customer {

    private Set<BankingDetails> bankingDetailImpls;

    private Set<Payment> paymentImpls;

    private Credentials cred;

    /**
     * First generating a PersonImpl so that we could use his data and UUID database key
     */
    public CustomerImpl() {
        super();
        this.bankingDetailImpls = new HashSet<>();
        this.paymentImpls = new HashSet<>();
        this.cred = new CredentialsImpl();
    }

    public Set<BankingDetails> getBankingDetails() {
        return Collections.unmodifiableSet(this.bankingDetailImpls);
    }

    public void addBankingDetail(BankingDetails bankingDetailsImpl) {
        this.bankingDetailImpls.add(bankingDetailsImpl);
    }

    public Set<Payment> getPayments() {
        return Collections.unmodifiableSet(paymentImpls);
    }

    public void addPayment(Payment paymentImpl) {
        this.paymentImpls.add(paymentImpl);
    }

    public String getLogin() {
        return this.cred.getLogin();
    }

    public String getpwdHash() {
        return this.cred.getPasswordHash();
    }

    public void setCredentials(String login, String pwdHash) {
        this.cred.setLogin(login);
        this.cred.setPasswordHash(pwdHash);
    }

    public void updateLogin(String newLogin) {
        this.cred.setLogin(newLogin);
    }

    public void updatePwdHash(String newPwdHash) {
        this.cred.setPasswordHash(newPwdHash);
    }
}