
package ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations;


import java.util.*;

/**
 * 
 */
public class BankingDetails {

    /**
     * 
     */
    private final UUID ID;
    
	/**
     * 
     */
    private final UUID boundPersonID;

    /**
     * 
     */
    private String cardNumber;

    /**
     * 
     */
    private String cardName;

    /**
     * 
     */
    private BankCardProvider provider;
	
    /**
     * Default constructor
     */
    public BankingDetails(UUID boundPersonID) {
    	this.ID = UUID.randomUUID();
    	this.boundPersonID = boundPersonID;
    }

    public UUID getID() {
		return ID;
	}

	public UUID getBoundPersonID() {
		return boundPersonID;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public BankCardProvider getProvider() {
		return provider;
	}

	public void setProvider(BankCardProvider provider) {
		this.provider = provider;
	}

}