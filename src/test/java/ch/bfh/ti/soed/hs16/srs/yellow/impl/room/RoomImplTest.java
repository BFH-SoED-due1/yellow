package ch.bfh.ti.soed.hs16.srs.yellow.impl.room;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class RoomImplTest {

    /**
     * Default constructor
     */

    @Test
    public void testgetRoomID() {
        RoomImpl rm1 = new RoomImpl();
        assertNotNull(rm1.getID());
    }

//	@Test
//	public void testAddRoomEquipment() {
//		RoomImpl rm1 = new RoomImpl();
//		EquipmentImpl equip1 = new EquipmentImpl();
//		
//		rm1.addEquipment(equip1);	// Still red
//		
//		assertNotNull(rm1.getEquSet());
//		assertEquals(equip1, rm1.getEquSet());
//	}

//	@Test
//	public void testRemoveRoomEquipment() {
//		RoomImpl rm1 = new RoomImpl();
//		EquipmentImpl equip1 = new EquipmentImpl();
//		
//		rm1.addEquipment(equip1);	// Still red
//		
//		assertNotNull(rm1.getEquSet());
//		
//		rm1.removeEquipment(equip1);
//		assertNull(rm1.getEquSet());
//	}

}