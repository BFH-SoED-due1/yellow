
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.room;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for Room implementation
 */
public class RoomImplTest {

    @Test
	public void testUUIDisInitialized() {

        RoomImpl rm1 = new RoomImpl();
        assertNotNull(rm1.getID());

    }

	@Test
	public void testSetIsInitialized() {

		RoomImpl rm1 = new RoomImpl();
		assertNotNull(rm1.getEquSet());

	}

	@Test
	public void testAddRoomEquipmentToSet() {

		RoomImpl rm1 = new RoomImpl();
		EquipmentImpl equip1 = new EquipmentImpl();

		rm1.addEquipment(equip1);

		assertNotNull(rm1.getEquSet());
		assertTrue(rm1.getEquSet().contains(equip1));
	}

	@Test
	public void testRemoveRoomEquipmentToSet() {

		RoomImpl rm1 = new RoomImpl();
		EquipmentImpl equip1 = new EquipmentImpl();

		rm1.addEquipment(equip1);

		assertNotNull(rm1.getEquSet());

		rm1.removeEquipment(equip1);
		assertFalse(rm1.getEquSet().contains(equip1));
	}
}