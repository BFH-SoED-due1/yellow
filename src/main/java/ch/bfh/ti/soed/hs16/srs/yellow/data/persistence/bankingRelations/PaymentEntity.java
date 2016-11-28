
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.bankingRelations;


import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.Payment;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 */
@Entity(name = "PaymentEntity")
@Access(AccessType.FIELD)
@Table(name = "Payments")
public class PaymentEntity
        implements Payment,
        Serializable {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "is_successful")
    private Boolean isSuccessful;

    @Column(name = "pay_sum")
    private BigDecimal sumToPay;

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
