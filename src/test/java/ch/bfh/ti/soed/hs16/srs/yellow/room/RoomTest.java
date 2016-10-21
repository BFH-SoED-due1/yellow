package ch.bfh.ti.soed.hs16.srs.yellow.room;


import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/**
 * 
 */
public class RoomTest {

    /**
     * Default constructor
     */
	
	@Test
	public void testgetRoomID() {
		Room rm1 = new Room();
		assertNotNull(rm1.getID());
	}
	
	@Test
	public void testAddRoomEquipment() {
		Room rm1 = new Room();
		Equipment equip1 = new Equipment();
		
		rm1.addEquipment(equip1);	// Still red
		
		assertNotNull(rm1.getEquSet());
		assertEquals(equip1, rm1.getEquSet());
	}
	
	@Test
	public void testRemoveRoomEquipment() {
		Room rm1 = new Room();
		Equipment equip1 = new Equipment();
		
		rm1.addEquipment(equip1);
		
		assertNotNull(rm1.getEquSet());
		
		rm1.removeEquipment(equip1);
		assertNull(rm1.getEquSet());
	}
	
	
//    public RoomTest() {
//    }
//
//    /**
//     * 
//     */
//    private UUID ID;
//    
//    private Set<Equipment> equSet;
//
//	public UUID getID() {
//		return ID;
//	}
//
//	public void setID(UUID iD) {
//		ID = iD;
//	}
//
//	public Set<Equipment> getEquSet() {
//		return equSet;
//	}
//
//	public void setEquSet(Set<Equipment> equSet) {
//		this.equSet = equSet;
//	}

}