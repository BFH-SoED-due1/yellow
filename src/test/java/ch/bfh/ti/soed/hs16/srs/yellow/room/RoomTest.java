package ch.bfh.ti.soed.hs16.srs.yellow.room;


import java.util.*;

/**
 * 
 */
public class RoomTest {

    /**
     * Default constructor
     */
    public RoomTest() {
    }

    /**
     * 
     */
    private UUID ID;
    
    private Set<Equipment> equSet;

	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public Set<Equipment> getEquSet() {
		return equSet;
	}

	public void setEquSet(Set<Equipment> equSet) {
		this.equSet = equSet;
	}

}