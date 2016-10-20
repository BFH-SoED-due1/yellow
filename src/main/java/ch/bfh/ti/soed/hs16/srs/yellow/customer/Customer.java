package ch.bfh.ti.soed.hs16.srs.yellow.customer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations.BankingDetails;
import ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations.Payment;

/**
 * Customer is a person which signed up for a login
 */
public class Customer extends Person {
    
    private Set<BankingDetails> bankingDetails;
    
    private Set<Payment> payments;
    
    private Credentials cred;
    
    /**
     * First generating a Person so that we could use his data and UUID database key
     */
    public Customer() {
    	super();
    	this.bankingDetails = new HashSet<>();
    	this.payments = new HashSet<>();
    	this.cred = new Credentials();
    }

	public Set<BankingDetails> getBankingDetails() {
		return Collections.unmodifiableSet(this.bankingDetails);
	}

	public void addBankingDetail(BankingDetails bankingDetails) {
		this.bankingDetails.add(bankingDetails);
	}

	public Set<Payment> getPayments() {
		return Collections.unmodifiableSet(this.payments);
	}

	public void addPayment(Payment payment) {
		this.payments.add(payment);
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
	
	public void updateLogin(String newLogin){
		this.cred.setLogin(newLogin);
	}
	
	public void updatePwdHash(String newPwdHash){
		this.cred.setPasswordHash(newPwdHash);
	}
}