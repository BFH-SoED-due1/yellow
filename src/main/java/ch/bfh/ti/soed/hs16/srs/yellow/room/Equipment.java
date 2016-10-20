package ch.bfh.ti.soed.hs16.srs.yellow.room;


import java.util.*;

/**
 * 
 */
public class Equipment {

    /**
     * 
     */
    private final UUID ID;
    
	/**
     * 
     */
    private String Description;
	
    /**
     * Default constructor
     */
    public Equipment() {
    	this.ID = UUID.randomUUID();
    }

    public UUID getID() {
		return ID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}


}