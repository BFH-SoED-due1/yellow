
package ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations;


import java.util.*;

/**
 * 
 */
public class Payment {

	/**
     * 
     */
    private final UUID ID;

    /**
     * 
     */
    private Boolean is_successful;
	
    /**
     * Default constructor
     */
    public Payment() {
    	this.ID = UUID.randomUUID();
    }

    public UUID getID() {
		return ID;
	}

	public Boolean getIs_successful() {
		return is_successful;
	}

	public void setIs_successful(Boolean is_successful) {
		this.is_successful = is_successful;
	}

}