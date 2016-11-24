
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.BankingDetails;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Banking details of a CustomerEntity
 */
public class BankingDetailsEntity
        implements BankingDetails {

	private final UUID boundPersonID;
    @Id
    @GeneratedValue
    private UUID ID;
    private String cardNumber;

    private String cardName;

    private BankCardProvider provider;

	/**
     * Must bound a PersonEntity who created an entry by adding to account
     */
    public BankingDetailsEntity(UUID boundPersonID) {
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
