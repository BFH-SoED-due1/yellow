package ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations;


import java.util.*;

/**
 * 
 */
public class BankingDetails {

    /**
     * Default constructor
     */
    public BankingDetails() {
    }

    /**
     * 
     */
    private UUID ID;
    
	/**
     * 
     */
    private UUID boundPersonID;

    /**
     * 
     */
    private String CardNumber;

    /**
     * 
     */
    private String CardName;

    /**
     * 
     */
    private BankCardProviderTest provider;

    public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public UUID getBoundPersonID() {
		return boundPersonID;
	}

	public void setBoundPersonID(UUID boundPersonID) {
		this.boundPersonID = boundPersonID;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public String getCardName() {
		return CardName;
	}

	public void setCardName(String cardName) {
		CardName = cardName;
	}

	public BankCardProviderTest getProvider() {
		return provider;
	}

	public void setProvider(BankCardProviderTest provider) {
		this.provider = provider;
	}

}