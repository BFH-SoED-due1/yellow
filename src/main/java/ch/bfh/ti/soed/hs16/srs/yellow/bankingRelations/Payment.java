package ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations;


import java.util.*;

/**
 * 
 */
public class Payment {

	/**
     * 
     */
    private UUID ID;

    /**
     * 
     */
    private Boolean is_successful;
	
    /**
     * Default constructor
     */
    public Payment() {
    }

    public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public Boolean getIs_successful() {
		return is_successful;
	}

	public void setIs_successful(Boolean is_successful) {
		this.is_successful = is_successful;
	}

}