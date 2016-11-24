
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.Payment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 */
@Entity
public class PaymentEntity implements Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private Boolean isSuccessful;

    private BigDecimal sumToPay;

    /**
     * Default constructor
     */
    public PaymentEntity() {
        isSuccessful = false;
        sumToPay = new BigDecimal("0.000");
    }

    public Long getID() {
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
