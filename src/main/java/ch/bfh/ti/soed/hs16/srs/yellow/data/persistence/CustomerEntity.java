
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.BankingDetails;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Credentials;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Payment;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @OneToMany(targetEntity = BankingDetailsEntity.class, cascade = CascadeType.PERSIST)
    private Set<BankingDetails> bankingDetails;

    @OneToMany(targetEntity = PaymentEntity.class, cascade = CascadeType.PERSIST)
    private Set<Payment> payments;

    @ManyToOne(targetEntity = CredentialsEntity.class, cascade = CascadeType.PERSIST)
    private Credentials cred;

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
