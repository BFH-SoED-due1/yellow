package ch.bfh.ti.soed.hs16.srs.yellow.room;


import java.util.*;

/**
 * 
 */
public class Room {

    /**
     * 
     */
    private final UUID ID;
    
    private Set<Equipment> equSet;
	
	/**
     * Default constructor
     */
    public Room() {
    	this.ID = UUID.randomUUID();
    }

	public UUID getID() {
		return ID;
	}

	public Set<Equipment> getEquSet() {
		return equSet;
	}

	public void setEquSet(Set<Equipment> equSet) {
		this.equSet = equSet;
	}

}