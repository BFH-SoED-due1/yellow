package ch.bfh.ti.soed.hs16.srs.yellow.room;


import java.util.*;

/**
 * 
 */
public class Room {

    private final UUID ID;
    
    private Set<Equipment> equSet;
	
    public Room() {
    	this.ID = UUID.randomUUID();
    }

	public UUID getID() {
		return this.ID;
	}

	public Set<Equipment> getEquSet() {
		return Collections.unmodifiableSet(equSet);
	}

	public void addEquipment(Equipment newEquipment) {
		this.equSet.add(newEquipment);
	}
	
	public void removeEquipment(Equipment equipmentToRemove){
		this.equSet.remove(equipmentToRemove);
	}

}