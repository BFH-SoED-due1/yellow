package ch.bfh.ti.soed.hs16.srs.yellow.room;


import java.util.*;

/**
 * Describes equipment which is available to the room
 */
public class Equipment {

    private final UUID ID;
    
    private String Description;
	
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