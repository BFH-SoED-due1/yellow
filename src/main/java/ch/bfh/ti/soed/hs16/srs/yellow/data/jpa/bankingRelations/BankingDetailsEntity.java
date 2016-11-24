
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.BankCardProvider;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.BankingDetails;

import javax.persistence.*;

/**
 * Banking details of a CustomerEntity
 */
@Entity
@Table(name = "BankingDetails")
public class BankingDetailsEntity
        implements BankingDetails {

	private final Long boundPersonID;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String cardNumber;

    private String cardName;

    private BankCardProvider provider;

	/**
	 * Must bind a PersonEntity who created an entry by adding to account
	 */
	public BankingDetailsEntity(Long boundPersonID) {
		this.boundPersonID = boundPersonID;
    }

	public Long getID() {
		return ID;
	}

	public Long getBoundPersonID() {
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

	public ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.BankCardProvider getProvider() {
		return provider;
	}

	public void setProvider(BankCardProvider provider) {
		this.provider = provider;
	}

}
