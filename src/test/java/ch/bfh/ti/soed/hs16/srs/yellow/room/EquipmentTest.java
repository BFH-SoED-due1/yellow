package ch.bfh.ti.soed.hs16.srs.yellow.room;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

/**
 * 
 */
public class EquipmentTest {

    /**
     * Default constructor
     */
	
	@Test
	public void testGetEquipmentID() {
		Equipment equip1 = new Equipment();
		assertNotNull(equip1.getID());
	}
	
	@Test
	public void testEqupmentDescription() {
		Equipment equip1 = new Equipment();
		
		String desc = "This equipment, has a description";
		equip1.setDescription(desc);
		
		assertEquals(desc, equip1.getDescription());
	}
	
//    public EquipmentTest() {
//    }
//
//    /**
//     * 
//     */
//    private UUID ID;
//    
//	/**
//     * 
//     */
//    private String Description;
//
//    public UUID getID() {
//		return ID;
//	}
//
//	public void setID(UUID iD) {
//		ID = iD;
//	}
//
//	public String getDescription() {
//		return Description;
//	}
//
//	public void setDescription(String description) {
//		Description = description;
//	}


}