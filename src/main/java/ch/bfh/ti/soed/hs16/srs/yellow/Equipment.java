package ch.bfh.ti.soed.hs16.srs.yellow;


import java.util.*;

/**
 * 
 */
public class Equipment {

    /**
     * Default constructor
     */
    public Equipment() {
    }

    /**
     * 
     */
    private UUID ID;
    
	/**
     * 
     */
    private String Description;

    public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}


}