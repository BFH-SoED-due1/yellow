
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.customer;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.BankingDetails;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.Payment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Credentials;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Customer;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * CustomerEntity is a person which signed up for a login
 */
@Entity
@Table(name = "Customer")
public class CustomerEntity
        extends PersonEntity
        implements Customer {

    private Set<BankingDetails> bankingDetailImpls;

    private Set<Payment> paymentImpls;

    private Credentials cred;

    /**
     * First generating a PersonEntity so that we could use his data and UUID database key
     */
    public CustomerEntity() {
        super();
        this.bankingDetailImpls = new HashSet<>();
        this.paymentImpls = new HashSet<>();
        this.cred = new CredentialsEntity();
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
