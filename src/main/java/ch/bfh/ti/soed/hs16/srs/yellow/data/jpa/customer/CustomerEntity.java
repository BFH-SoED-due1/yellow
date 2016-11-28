
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.customer;

import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.bankingRelations.BankingDetailsEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.bankingRelations.PaymentEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.BankingDetails;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.Payment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Credentials;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * CustomerEntity is a person which signed up for a login
 */
@Entity(name = "CustomerEntity")
@Access(AccessType.FIELD)
@Table(name = "Customer")
public class CustomerEntity
        extends PersonEntity
        implements Customer,
        Serializable {

    @OneToMany(targetEntity = BankingDetailsEntity.class)
    private Set<BankingDetails> bankingDetails;

    @OneToMany(targetEntity = PaymentEntity.class)
    private Set<Payment> payments;

    @ManyToOne(targetEntity = CredentialsEntity.class)
    private Credentials cred;

    /**
     * First generating a PersonEntity so that we could use his data and UUID database key
     */
    public CustomerEntity() {
        super();
        this.bankingDetails = new HashSet<>();
        this.payments = new HashSet<>();
        this.cred = new CredentialsEntity();
    }

    public Set<BankingDetails> getBankingDetails() {
        return Collections.unmodifiableSet(this.bankingDetails);
    }

    public void addBankingDetail(BankingDetails bankingDetailsImpl) {
        this.bankingDetails.add(bankingDetailsImpl);
    }

    public Set<Payment> getPayments() {
        return Collections.unmodifiableSet(payments);
    }

    public void addPayment(Payment paymentImpl) {
        this.payments.add(paymentImpl);
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
