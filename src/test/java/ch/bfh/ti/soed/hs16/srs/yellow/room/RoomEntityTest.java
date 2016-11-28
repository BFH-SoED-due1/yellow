
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.room;


import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room.EquipmentEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room.RoomEntity;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for Room implementation
 */
public class RoomEntityTest {

    @Test
	public void testRoomEntityisInitialized() {

        RoomEntity rm1 = new RoomEntity();
		assertNotNull(rm1);

    }

	@Test
	public void testSetIsInitialized() {

        RoomEntity rm1 = new RoomEntity();
        assertNotNull(rm1.getEquSet());

	}

	@Test
	public void testAddRoomEquipmentToSet() {

        RoomEntity rm1 = new RoomEntity();
        EquipmentEntity equip1 = new EquipmentEntity();

		rm1.addEquipment(equip1);

		assertNotNull(rm1.getEquSet());
		assertTrue(rm1.getEquSet().contains(equip1));
	}

	@Test
	public void testRemoveRoomEquipmentToSet() {

        RoomEntity rm1 = new RoomEntity();
        EquipmentEntity equip1 = new EquipmentEntity();

		rm1.addEquipment(equip1);

		assertNotNull(rm1.getEquSet());

		rm1.removeEquipment(equip1);
		assertFalse(rm1.getEquSet().contains(equip1));
	}
}
