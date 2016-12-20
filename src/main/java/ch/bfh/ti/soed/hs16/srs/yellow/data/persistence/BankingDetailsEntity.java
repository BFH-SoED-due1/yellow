
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence;


import ch.bfh.ti.soed.hs16.srs.yellow.data.service.BankingDetails;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

    /**
     * Default constructor
     */
    public BankingDetailsEntity() {
    }

    /**
     * Banking details normally do not exist without a person entity bound to them
     * @param boundPersonID ID of person who created banking details entry
     */
    public BankingDetailsEntity(Long boundPersonID) {
        this.boundPersonID = boundPersonID;
    }

    /**
     * Get ID of the banking details entry
     * @return ID of the banking details entry
     */
    public Long getID() {
        return ID;
    }

    /**
     * Get ID of the person to whom these BankingDetails belong
     * @return ID of the person to whom these BankingDetails belong
     */
    public Long getBoundPersonID() {
        return boundPersonID;
    }

    /**
     * Get number of banking card
     * @return number of banking card
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Set number of banking card
     * @param cardNumber number of banking card
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Get name written on the banking card
     * @return number of banking card
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Get name banking card
     * @param cardName name on banking card
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

}
