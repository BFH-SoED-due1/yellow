
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.BankingDetails;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Banking details of a CustomerEntity
 */
@Entity(name = "BankingDetailsEntity")
@Access(AccessType.FIELD)
@Table(name = "BankingDetails")
public class BankingDetailsEntity
		implements BankingDetails,
		Serializable {

	@Id
	@Column(name = "bankdetail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name = "cardno")
	private String cardNumber;

	@Column(name = "nameoncard")
	private String cardName;

	@Column(name = "person_id")
	private Long boundPersonID = 12345678910L;

	//@ManyToOne(targetEntity = BankCardProvider.class)
	//private BankCardProvider provider;

	public BankingDetailsEntity() {
	}

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

	//public BankCardProvider getProvider() {
	//	return provider;
	//}

	//public void setProvider(BankCardProvider provider) {
	//	this.provider = provider;
	//}

}
