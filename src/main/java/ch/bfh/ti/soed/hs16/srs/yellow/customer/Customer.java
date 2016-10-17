package ch.bfh.ti.soed.hs16.srs.yellow.customer;

import java.util.Set;

import ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations.BankingDetails;
import ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations.Payment;

/**
 * 
 */
public class Customer extends Person {

    /**
     * Default constructor
     */
    public Customer() {
    	super();
    }
    
    private BankingDetails bankingDetails;
    
    private Set<Payment> payments;

	public BankingDetails getBankingDetails() {
		return bankingDetails;
	}

	public void setBankingDetails(BankingDetails bankingDetails) {
		this.bankingDetails = bankingDetails;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

}