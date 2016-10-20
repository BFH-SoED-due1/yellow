
package ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations;


import java.util.*;

/**
 * 
 */
public class Payment {

    private final UUID ID;

    private Boolean isSuccessful;
    
    private int sumToPay;
	
    /**
     * Default constructor
     */
    public Payment() {
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