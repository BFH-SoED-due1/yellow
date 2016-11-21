
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations.BankingDetails;

import java.util.UUID;

/**
 * Banking details of a CustomerImpl
 */
public class BankingDetailsImpl
		implements BankingDetails {

    private final UUID ID;

	private final UUID boundPersonID;

    private String cardNumber;

    private String cardName;

    private BankCardProvider provider;

	/**
	 * Must bound a PersonImpl who created an entry by adding to account
	 */
	public BankingDetailsImpl(UUID boundPersonID) {
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
