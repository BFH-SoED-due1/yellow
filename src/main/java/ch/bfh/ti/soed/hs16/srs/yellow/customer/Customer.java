package ch.bfh.ti.soed.hs16.srs.yellow.customer;

import java.util.Set;

import ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations.BankingDetailsTest;
import ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations.PaymentTest;

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
    
    private BankingDetailsTest bankingDetails;
    
    private Set<PaymentTest> payments;

	public BankingDetailsTest getBankingDetails() {
		return bankingDetails;
	}

	public void setBankingDetails(BankingDetailsTest bankingDetails) {
		this.bankingDetails = bankingDetails;
	}

	public Set<PaymentTest> getPayments() {
		return payments;
	}

	public void setPayments(Set<PaymentTest> payments) {
		this.payments = payments;
	}

}