
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.room;

import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room.EquipmentEntity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * Unit tests for Equipment implementation
 */
public class EquipmentEntityTest {

    @Test
    public void testGetEquipmentID() {

        EquipmentEntity equip1 = new EquipmentEntity();

        assertNotNull(equip1.getID());
    }

    @Test
    public void testEquipmentDescription() {

        EquipmentEntity equip1 = new EquipmentEntity();

        String desc = "This equipment has a description";

        equip1.setDescription(desc);

        assertEquals(desc, equip1.getDescription());
    }

}