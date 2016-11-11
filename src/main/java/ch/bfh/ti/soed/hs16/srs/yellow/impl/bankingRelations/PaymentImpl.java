
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations.Payment;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

/**
 *
 */
public class PaymentImpl implements Payment {

    private final UUID ID;

    private Boolean isSuccessful;

    private BigDecimal sumToPay;

    /**
     * Default constructor
     */
	public PaymentImpl() {
		this.ID = UUID.randomUUID();
        isSuccessful = false;
        sumToPay = new BigDecimal("0.000");
    }

    public UUID getID() {
		return ID;
	}

	public Boolean getIsSuccessful() {
		return isSuccessful;
	}

    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String getSumToPay() {
        NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
        usdCostFormat.setMinimumFractionDigits(1);
        usdCostFormat.setMaximumFractionDigits(2);
        return usdCostFormat.format(sumToPay.doubleValue());
    }

    public void setSumToPay(BigDecimal sumToPay) {
        this.sumToPay = sumToPay;
    }

}
