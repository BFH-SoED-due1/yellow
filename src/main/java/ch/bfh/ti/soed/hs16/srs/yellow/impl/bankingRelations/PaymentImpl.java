
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations.Payment;

import java.util.UUID;

/**
 * 
 */
public class PaymentImpl implements Payment {

    private final UUID ID;

    private Boolean isSuccessful;
    
    private int sumToPay;
	
    /**
     * Default constructor
     */
	public PaymentImpl() {
		this.ID = UUID.randomUUID();
	}

    public UUID getID() {
		return ID;
	}

	public Boolean getIsSuccessful() {
		return isSuccessful;
	}

	public void setIs_successful(Boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public int getSumToPay() {
		return sumToPay;
	}

	public void setSumToPay(int sumToPay) {
		this.sumToPay = sumToPay;
	}

}